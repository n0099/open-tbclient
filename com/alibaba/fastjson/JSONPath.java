package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class JSONPath implements JSONAware {
    public static final long SIZE = 5614464919154503228L;
    public static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    public ParserConfig parserConfig;
    public final String path;
    public Segement[] segments;
    public SerializeConfig serializeConfig;

    /* loaded from: classes.dex */
    public static class ArrayAccessSegement implements Segement {
        public final int index;

        public ArrayAccessSegement(int i) {
            this.index = i;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }
    }

    /* loaded from: classes.dex */
    public static class DoubleOpSegement implements Filter {
        public final Operator op;
        public final String propertyName;
        public final long propertyNameHash;
        public final double value;

        public DoubleOpSegement(String str, double d2, Operator operator) {
            this.propertyName = str;
            this.value = d2;
            this.op = operator;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue != null && (propertyValue instanceof Number)) {
                double doubleValue = ((Number) propertyValue).doubleValue();
                Operator operator = this.op;
                return operator == Operator.EQ ? doubleValue == this.value : operator == Operator.NE ? doubleValue != this.value : operator == Operator.GE ? doubleValue >= this.value : operator == Operator.GT ? doubleValue > this.value : operator == Operator.LE ? doubleValue <= this.value : operator == Operator.LT && doubleValue < this.value;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    /* loaded from: classes.dex */
    public static class FilterSegement implements Segement {
        public final Filter filter;

        public FilterSegement(Filter filter) {
            this.filter = filter;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (obj2 instanceof Iterable) {
                for (Object obj3 : (Iterable) obj2) {
                    if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                        jSONArray.add(obj3);
                    }
                }
                return jSONArray;
            } else if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                return obj2;
            } else {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class IntBetweenSegement implements Filter {
        public final long endValue;
        public final boolean not;
        public final String propertyName;
        public final long propertyNameHash;
        public final long startValue;

        public IntBetweenSegement(String str, long j, long j2, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.startValue = j;
            this.endValue = j2;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                if (longValue >= this.startValue && longValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    /* loaded from: classes.dex */
    public static class IntInSegement implements Filter {
        public final boolean not;
        public final String propertyName;
        public final long propertyNameHash;
        public final long[] values;

        public IntInSegement(String str, long[] jArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = jArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                for (long j : this.values) {
                    if (j == longValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    /* loaded from: classes.dex */
    public static class IntObjInSegement implements Filter {
        public final boolean not;
        public final String propertyName;
        public final long propertyNameHash;
        public final Long[] values;

        public IntObjInSegement(String str, Long[] lArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = lArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            int i = 0;
            if (propertyValue == null) {
                Long[] lArr = this.values;
                int length = lArr.length;
                while (i < length) {
                    if (lArr[i] == null) {
                        return !this.not;
                    }
                    i++;
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i < length2) {
                    Long l = lArr2[i];
                    if (l != null && l.longValue() == longValue) {
                        return !this.not;
                    }
                    i++;
                }
            }
            return this.not;
        }
    }

    /* loaded from: classes.dex */
    public static class IntOpSegement implements Filter {
        public final Operator op;
        public final String propertyName;
        public final long propertyNameHash;
        public final long value;

        public IntOpSegement(String str, long j, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = j;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue != null && (propertyValue instanceof Number)) {
                long longValue = ((Number) propertyValue).longValue();
                Operator operator = this.op;
                return operator == Operator.EQ ? longValue == this.value : operator == Operator.NE ? longValue != this.value : operator == Operator.GE ? longValue >= this.value : operator == Operator.GT ? longValue > this.value : operator == Operator.LE ? longValue <= this.value : operator == Operator.LT && longValue < this.value;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class JSONPathParser {
        public char ch;
        public int level;
        public final String path;
        public int pos;

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        public static boolean isDigitFirst(char c2) {
            return c2 == '-' || c2 == '+' || (c2 >= '0' && c2 <= '9');
        }

        public void accept(char c2) {
            if (this.ch == c2) {
                if (isEOF()) {
                    return;
                }
                next();
                return;
            }
            throw new JSONPathException("expect '" + c2 + ", but '" + this.ch + "'");
        }

        public Segement buildArraySegement(String str) {
            int length = str.length();
            int i = 0;
            char charAt = str.charAt(0);
            int i2 = length - 1;
            char charAt2 = str.charAt(i2);
            int indexOf = str.indexOf(44);
            if (str.length() > 2 && charAt == '\'' && charAt2 == '\'') {
                if (indexOf == -1) {
                    return new PropertySegement(str.substring(1, i2), false);
                }
                String[] split = str.split(",");
                String[] strArr = new String[split.length];
                while (i < split.length) {
                    String str2 = split[i];
                    strArr[i] = str2.substring(1, str2.length() - 1);
                    i++;
                }
                return new MultiPropertySegement(strArr);
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf == -1 && indexOf2 == -1) {
                if (TypeUtils.isNumber(str)) {
                    try {
                        return new ArrayAccessSegement(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new PropertySegement(str, false);
                    }
                }
                return new PropertySegement(str, false);
            } else if (indexOf != -1) {
                String[] split2 = str.split(",");
                int[] iArr = new int[split2.length];
                while (i < split2.length) {
                    iArr[i] = Integer.parseInt(split2[i]);
                    i++;
                }
                return new MultiIndexSegement(iArr);
            } else if (indexOf2 != -1) {
                String[] split3 = str.split(":");
                int length2 = split3.length;
                int[] iArr2 = new int[length2];
                for (int i3 = 0; i3 < split3.length; i3++) {
                    String str3 = split3[i3];
                    if (str3.length() != 0) {
                        iArr2[i3] = Integer.parseInt(str3);
                    } else if (i3 == 0) {
                        iArr2[i3] = 0;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
                int i4 = iArr2[0];
                int i5 = length2 > 1 ? iArr2[1] : -1;
                int i6 = length2 == 3 ? iArr2[2] : 1;
                if (i5 < 0 || i5 >= i4) {
                    if (i6 > 0) {
                        return new RangeSegement(i4, i5, i6);
                    }
                    throw new UnsupportedOperationException("step must greater than zero : " + i6);
                }
                throw new UnsupportedOperationException("end must greater than or equals start. start " + i4 + ",  end " + i5);
            } else {
                throw new UnsupportedOperationException();
            }
        }

        public Segement[] explain() {
            String str = this.path;
            if (str != null && str.length() != 0) {
                Segement[] segementArr = new Segement[8];
                while (true) {
                    Segement readSegement = readSegement();
                    if (readSegement == null) {
                        break;
                    }
                    int i = this.level;
                    if (i == segementArr.length) {
                        Segement[] segementArr2 = new Segement[(i * 3) / 2];
                        System.arraycopy(segementArr, 0, segementArr2, 0, i);
                        segementArr = segementArr2;
                    }
                    int i2 = this.level;
                    this.level = i2 + 1;
                    segementArr[i2] = readSegement;
                }
                int i3 = this.level;
                if (i3 == segementArr.length) {
                    return segementArr;
                }
                Segement[] segementArr3 = new Segement[i3];
                System.arraycopy(segementArr, 0, segementArr3, 0, i3);
                return segementArr3;
            }
            throw new IllegalArgumentException();
        }

        public boolean isEOF() {
            return this.pos >= this.path.length();
        }

        public void next() {
            String str = this.path;
            int i = this.pos;
            this.pos = i + 1;
            this.ch = str.charAt(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
            r0 = r14.pos;
         */
        /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Segement parseArrayAccess(boolean z) {
            boolean z2;
            String str;
            String str2;
            String str3;
            String str4;
            String[] strArr;
            int i;
            String substring;
            if (z) {
                accept('[');
            }
            int i2 = 0;
            if (this.ch == '?') {
                next();
                accept('(');
                if (this.ch == '@') {
                    next();
                    accept(IStringUtil.EXTENSION_SEPARATOR);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !IOUtils.firstIdentifier(this.ch)) {
                int i3 = this.pos - 1;
                while (true) {
                    char c2 = this.ch;
                    if (c2 == ']' || c2 == '/' || isEOF() || !(this.ch != '.' || z2 || z2)) {
                        break;
                    }
                    if (this.ch == '\\') {
                        next();
                    }
                    next();
                }
                char c3 = this.ch;
                if (c3 != '/' && c3 != '.') {
                    i = this.pos;
                    substring = this.path.substring(i3, i);
                    if (substring.indexOf(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) == -1) {
                    }
                } else {
                    int i4 = this.pos;
                    i = i4 - 1;
                    substring = this.path.substring(i3, i);
                    if (substring.indexOf(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) == -1) {
                        return new PropertySegement(substring.replaceAll("\\\\\\.", EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX), false);
                    }
                    Segement buildArraySegement = buildArraySegement(substring);
                    if (z && !isEOF()) {
                        accept(']');
                    }
                    return buildArraySegement;
                }
            } else {
                String readName = readName();
                skipWhitespace();
                if (z2 && this.ch == ')') {
                    next();
                    if (z) {
                        accept(']');
                    }
                    return new FilterSegement(new NotNullSegement(readName));
                } else if (z && this.ch == ']') {
                    next();
                    return new FilterSegement(new NotNullSegement(readName));
                } else {
                    Operator readOp = readOp();
                    skipWhitespace();
                    if (readOp != Operator.BETWEEN && readOp != Operator.NOT_BETWEEN) {
                        if (readOp != Operator.IN && readOp != Operator.NOT_IN) {
                            char c4 = this.ch;
                            if (c4 != '\'' && c4 != '\"') {
                                if (isDigitFirst(c4)) {
                                    long readLongValue = readLongValue();
                                    double readDoubleValue = this.ch == '.' ? readDoubleValue(readLongValue) : 0.0d;
                                    if (z2) {
                                        accept(')');
                                    }
                                    if (z) {
                                        accept(']');
                                    }
                                    if (readDoubleValue == 0.0d) {
                                        return new FilterSegement(new IntOpSegement(readName, readLongValue, readOp));
                                    }
                                    return new FilterSegement(new DoubleOpSegement(readName, readDoubleValue, readOp));
                                }
                                char c5 = this.ch;
                                if (c5 == 'n') {
                                    if (StringUtil.NULL_STRING.equals(readName())) {
                                        if (z2) {
                                            accept(')');
                                        }
                                        accept(']');
                                        if (readOp == Operator.EQ) {
                                            return new FilterSegement(new NullSegement(readName));
                                        }
                                        if (readOp == Operator.NE) {
                                            return new FilterSegement(new NotNullSegement(readName));
                                        }
                                        throw new UnsupportedOperationException();
                                    }
                                } else if (c5 == 't') {
                                    if ("true".equals(readName())) {
                                        if (z2) {
                                            accept(')');
                                        }
                                        accept(']');
                                        if (readOp == Operator.EQ) {
                                            return new FilterSegement(new ValueSegment(readName, Boolean.TRUE, true));
                                        }
                                        if (readOp == Operator.NE) {
                                            return new FilterSegement(new ValueSegment(readName, Boolean.TRUE, false));
                                        }
                                        throw new UnsupportedOperationException();
                                    }
                                } else if (c5 == 'f' && "false".equals(readName())) {
                                    if (z2) {
                                        accept(')');
                                    }
                                    accept(']');
                                    if (readOp == Operator.EQ) {
                                        return new FilterSegement(new ValueSegment(readName, Boolean.FALSE, true));
                                    }
                                    if (readOp == Operator.NE) {
                                        return new FilterSegement(new ValueSegment(readName, Boolean.FALSE, false));
                                    }
                                    throw new UnsupportedOperationException();
                                }
                                throw new UnsupportedOperationException();
                            }
                            String readString = readString();
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            if (readOp == Operator.RLIKE) {
                                return new FilterSegement(new RlikeSegement(readName, readString, false));
                            }
                            if (readOp == Operator.NOT_RLIKE) {
                                return new FilterSegement(new RlikeSegement(readName, readString, true));
                            }
                            if (readOp == Operator.LIKE || readOp == Operator.NOT_LIKE) {
                                while (readString.indexOf("%%") != -1) {
                                    readString = readString.replaceAll("%%", "%");
                                }
                                boolean z3 = readOp == Operator.NOT_LIKE;
                                int indexOf = readString.indexOf(37);
                                if (indexOf == -1) {
                                    if (readOp == Operator.LIKE) {
                                        readOp = Operator.EQ;
                                    } else {
                                        readOp = Operator.NE;
                                    }
                                } else {
                                    String[] split = readString.split("%");
                                    String[] strArr2 = null;
                                    if (indexOf == 0) {
                                        if (readString.charAt(readString.length() - 1) == '%') {
                                            int length = split.length - 1;
                                            String[] strArr3 = new String[length];
                                            System.arraycopy(split, 1, strArr3, 0, length);
                                            strArr = strArr3;
                                            str3 = null;
                                            str4 = null;
                                            return new FilterSegement(new MatchSegement(readName, str3, str4, strArr, z3));
                                        }
                                        String str5 = split[split.length - 1];
                                        if (split.length > 2) {
                                            int length2 = split.length - 2;
                                            String[] strArr4 = new String[length2];
                                            System.arraycopy(split, 1, strArr4, 0, length2);
                                            str4 = str5;
                                            strArr = strArr4;
                                            str3 = null;
                                        } else {
                                            str4 = str5;
                                            str3 = null;
                                            strArr = null;
                                        }
                                        return new FilterSegement(new MatchSegement(readName, str3, str4, strArr, z3));
                                    } else if (readString.charAt(readString.length() - 1) != '%') {
                                        if (split.length == 1) {
                                            str3 = split[0];
                                            str4 = null;
                                            strArr = null;
                                        } else {
                                            if (split.length == 2) {
                                                str = split[0];
                                                str2 = split[1];
                                            } else {
                                                str = split[0];
                                                str2 = split[split.length - 1];
                                                int length3 = split.length - 2;
                                                strArr2 = new String[length3];
                                                System.arraycopy(split, 1, strArr2, 0, length3);
                                            }
                                            str3 = str;
                                            str4 = str2;
                                            strArr = strArr2;
                                        }
                                        return new FilterSegement(new MatchSegement(readName, str3, str4, strArr, z3));
                                    } else {
                                        strArr = split;
                                        str3 = null;
                                        str4 = null;
                                        return new FilterSegement(new MatchSegement(readName, str3, str4, strArr, z3));
                                    }
                                }
                            }
                            return new FilterSegement(new StringOpSegement(readName, readString, readOp));
                        }
                        boolean z4 = readOp == Operator.NOT_IN;
                        accept('(');
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.add(readValue());
                        while (true) {
                            skipWhitespace();
                            if (this.ch != ',') {
                                break;
                            }
                            next();
                            jSONArray.add(readValue());
                        }
                        accept(')');
                        if (z2) {
                            accept(')');
                        }
                        if (z) {
                            accept(']');
                        }
                        boolean z5 = true;
                        boolean z6 = true;
                        boolean z7 = true;
                        for (Object obj : jSONArray) {
                            if (obj != null) {
                                Class<?> cls = obj.getClass();
                                if (z5 && cls != Byte.class && cls != Short.class && cls != Integer.class && cls != Long.class) {
                                    z5 = false;
                                    z7 = false;
                                }
                                if (z6 && cls != String.class) {
                                    z6 = false;
                                }
                            } else if (z5) {
                                z5 = false;
                            }
                        }
                        if (jSONArray.size() == 1 && jSONArray.get(0) == null) {
                            if (z4) {
                                return new FilterSegement(new NotNullSegement(readName));
                            }
                            return new FilterSegement(new NullSegement(readName));
                        } else if (z5) {
                            if (jSONArray.size() == 1) {
                                return new FilterSegement(new IntOpSegement(readName, ((Number) jSONArray.get(0)).longValue(), z4 ? Operator.NE : Operator.EQ));
                            }
                            int size = jSONArray.size();
                            long[] jArr = new long[size];
                            while (i2 < size) {
                                jArr[i2] = ((Number) jSONArray.get(i2)).longValue();
                                i2++;
                            }
                            return new FilterSegement(new IntInSegement(readName, jArr, z4));
                        } else if (z6) {
                            if (jSONArray.size() == 1) {
                                return new FilterSegement(new StringOpSegement(readName, (String) jSONArray.get(0), z4 ? Operator.NE : Operator.EQ));
                            }
                            String[] strArr5 = new String[jSONArray.size()];
                            jSONArray.toArray(strArr5);
                            return new FilterSegement(new StringInSegement(readName, strArr5, z4));
                        } else if (z7) {
                            int size2 = jSONArray.size();
                            Long[] lArr = new Long[size2];
                            while (i2 < size2) {
                                Number number = (Number) jSONArray.get(i2);
                                if (number != null) {
                                    lArr[i2] = Long.valueOf(number.longValue());
                                }
                                i2++;
                            }
                            return new FilterSegement(new IntObjInSegement(readName, lArr, z4));
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }
                    boolean z8 = readOp == Operator.NOT_BETWEEN;
                    Object readValue = readValue();
                    if ("and".equalsIgnoreCase(readName())) {
                        Object readValue2 = readValue();
                        if (readValue != null && readValue2 != null) {
                            if (JSONPath.isInt(readValue.getClass()) && JSONPath.isInt(readValue2.getClass())) {
                                return new FilterSegement(new IntBetweenSegement(readName, ((Number) readValue).longValue(), ((Number) readValue2).longValue(), z8));
                            }
                            throw new JSONPathException(this.path);
                        }
                        throw new JSONPathException(this.path);
                    }
                    throw new JSONPathException(this.path);
                }
            }
        }

        public double readDoubleValue(long j) {
            int i = this.pos - 1;
            next();
            while (true) {
                char c2 = this.ch;
                if (c2 < '0' || c2 > '9') {
                    break;
                }
                next();
            }
            return Double.parseDouble(this.path.substring(i, this.pos - 1)) + j;
        }

        public long readLongValue() {
            int i = this.pos - 1;
            char c2 = this.ch;
            if (c2 == '+' || c2 == '-') {
                next();
            }
            while (true) {
                char c3 = this.ch;
                if (c3 < '0' || c3 > '9') {
                    break;
                }
                next();
            }
            return Long.parseLong(this.path.substring(i, this.pos - 1));
        }

        public String readName() {
            skipWhitespace();
            char c2 = this.ch;
            if (c2 != '\\' && !IOUtils.firstIdentifier(c2)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            StringBuilder sb = new StringBuilder();
            while (!isEOF()) {
                char c3 = this.ch;
                if (c3 == '\\') {
                    next();
                    sb.append(this.ch);
                    if (isEOF()) {
                        break;
                    }
                    next();
                } else if (!IOUtils.isIdent(c3)) {
                    break;
                } else {
                    sb.append(this.ch);
                    next();
                }
            }
            if (isEOF() && IOUtils.isIdent(this.ch)) {
                sb.append(this.ch);
            }
            return sb.toString();
        }

        public Operator readOp() {
            Operator operator;
            char c2 = this.ch;
            if (c2 == '=') {
                next();
                operator = Operator.EQ;
            } else if (c2 == '!') {
                next();
                accept(a.f1897h);
                operator = Operator.NE;
            } else if (c2 == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c2 == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator == null) {
                String readName = readName();
                if ("not".equalsIgnoreCase(readName)) {
                    skipWhitespace();
                    String readName2 = readName();
                    if ("like".equalsIgnoreCase(readName2)) {
                        return Operator.NOT_LIKE;
                    }
                    if ("rlike".equalsIgnoreCase(readName2)) {
                        return Operator.NOT_RLIKE;
                    }
                    if ("in".equalsIgnoreCase(readName2)) {
                        return Operator.NOT_IN;
                    }
                    if ("between".equalsIgnoreCase(readName2)) {
                        return Operator.NOT_BETWEEN;
                    }
                    throw new UnsupportedOperationException();
                } else if ("like".equalsIgnoreCase(readName)) {
                    return Operator.LIKE;
                } else {
                    if ("rlike".equalsIgnoreCase(readName)) {
                        return Operator.RLIKE;
                    }
                    if ("in".equalsIgnoreCase(readName)) {
                        return Operator.IN;
                    }
                    if ("between".equalsIgnoreCase(readName)) {
                        return Operator.BETWEEN;
                    }
                    throw new UnsupportedOperationException();
                }
            }
            return operator;
        }

        public Segement readSegement() {
            char c2;
            boolean z = true;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new ArrayAccessSegement(this.ch - '0');
                }
                char c3 = this.ch;
                if ((c3 >= 'a' && c3 <= 'z') || ((c2 = this.ch) >= 'A' && c2 <= 'Z')) {
                    return new PropertySegement(Character.toString(this.ch), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c4 = this.ch;
                if (c4 != '$') {
                    if (c4 != '.' && c4 != '/') {
                        if (c4 == '[') {
                            return parseArrayAccess(true);
                        }
                        if (this.level == 0) {
                            return new PropertySegement(readName(), false);
                        }
                        throw new JSONPathException("not support jsonpath : " + this.path);
                    }
                    char c5 = this.ch;
                    next();
                    if (c5 == '.' && this.ch == '.') {
                        next();
                        int length = this.path.length();
                        int i = this.pos;
                        if (length > i + 3 && this.ch == '[' && this.path.charAt(i) == '*' && this.path.charAt(this.pos + 1) == ']' && this.path.charAt(this.pos + 2) == '.') {
                            next();
                            next();
                            next();
                            next();
                        }
                    } else {
                        z = false;
                    }
                    char c6 = this.ch;
                    if (c6 == '*') {
                        if (!isEOF()) {
                            next();
                        }
                        return WildCardSegement.instance;
                    } else if (isDigitFirst(c6)) {
                        return parseArrayAccess(false);
                    } else {
                        String readName = readName();
                        if (this.ch == '(') {
                            next();
                            if (this.ch == ')') {
                                if (!isEOF()) {
                                    next();
                                }
                                if ("size".equals(readName)) {
                                    return SizeSegement.instance;
                                }
                                throw new JSONPathException("not support jsonpath : " + this.path);
                            }
                            throw new JSONPathException("not support jsonpath : " + this.path);
                        }
                        return new PropertySegement(readName, z);
                    }
                }
                next();
            }
            return null;
        }

        public String readString() {
            char c2 = this.ch;
            next();
            int i = this.pos - 1;
            while (this.ch != c2 && !isEOF()) {
                next();
            }
            String substring = this.path.substring(i, isEOF() ? this.pos : this.pos - 1);
            accept(c2);
            return substring;
        }

        public Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            char c2 = this.ch;
            if (c2 == '\"' || c2 == '\'') {
                return readString();
            }
            if (c2 == 'n') {
                if (StringUtil.NULL_STRING.equals(readName())) {
                    return null;
                }
                throw new JSONPathException(this.path);
            }
            throw new UnsupportedOperationException();
        }

        public final void skipWhitespace() {
            while (true) {
                char c2 = this.ch;
                if (c2 > ' ') {
                    return;
                }
                if (c2 != ' ' && c2 != '\r' && c2 != '\n' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                    return;
                }
                next();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MatchSegement implements Filter {
        public final String[] containsValues;
        public final String endsWithValue;
        public final int minLength;
        public final boolean not;
        public final String propertyName;
        public final long propertyNameHash;
        public final String startsWithValue;

        public MatchSegement(String str, String str2, String str3, String[] strArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z;
            int length = str2 != null ? str2.length() + 0 : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.minLength = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            String obj4 = propertyValue.toString();
            if (obj4.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                i = 0;
            } else if (!obj4.startsWith(str)) {
                return this.not;
            } else {
                i = this.startsWithValue.length() + 0;
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i);
                    if (indexOf == -1) {
                        return this.not;
                    }
                    i = indexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            if (str3 != null && !obj4.endsWith(str3)) {
                return this.not;
            }
            return !this.not;
        }
    }

    /* loaded from: classes.dex */
    public static class MultiIndexSegement implements Segement {
        public final int[] indexes;

        public MultiIndexSegement(int[] iArr) {
            this.indexes = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.indexes.length);
            int i = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i >= iArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getArrayItem(obj2, iArr[i]));
                i++;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MultiPropertySegement implements Segement {
        public final String[] propertyNames;
        public final long[] propertyNamesHash;

        public MultiPropertySegement(String[] strArr) {
            this.propertyNames = strArr;
            this.propertyNamesHash = new long[strArr.length];
            int i = 0;
            while (true) {
                long[] jArr = this.propertyNamesHash;
                if (i >= jArr.length) {
                    return;
                }
                jArr[i] = TypeUtils.fnv1a_64(strArr[i]);
                i++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            int i = 0;
            while (true) {
                String[] strArr = this.propertyNames;
                if (i >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getPropertyValue(obj2, strArr[i], this.propertyNamesHash[i]));
                i++;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class NotNullSegement implements Filter {
        public final String propertyName;
        public final long propertyNameHash;

        public NotNullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) != null;
        }
    }

    /* loaded from: classes.dex */
    public static class NullSegement implements Filter {
        public final String propertyName;
        public final long propertyNameHash;

        public NullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) == null;
        }
    }

    /* loaded from: classes.dex */
    public enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN
    }

    /* loaded from: classes.dex */
    public static class PropertySegement implements Segement {
        public final boolean deep;
        public final String propertyName;
        public final long propertyNameHash;

        public PropertySegement(String str, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.deep = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                ArrayList arrayList = new ArrayList();
                jSONPath.deepScan(obj2, this.propertyName, arrayList);
                return arrayList;
            }
            return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName);
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, this.propertyNameHash, obj2);
            } else {
                jSONPath.setPropertyValue(obj, this.propertyName, this.propertyNameHash, obj2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class RangeSegement implements Segement {
        public final int end;
        public final int start;
        public final int step;

        public RangeSegement(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.step = i3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = SizeSegement.instance.eval(jSONPath, obj, obj2).intValue();
            int i = this.start;
            if (i < 0) {
                i += intValue;
            }
            int i2 = this.end;
            if (i2 < 0) {
                i2 += intValue;
            }
            int i3 = ((i2 - i) / this.step) + 1;
            if (i3 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i3);
            while (i <= i2 && i < intValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i));
                i += this.step;
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static class RlikeSegement implements Filter {
        public final boolean not;
        public final Pattern pattern;
        public final String propertyName;
        public final long propertyNameHash;

        public RlikeSegement(String str, String str2, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.pattern = Pattern.compile(str2);
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            boolean matches = this.pattern.matcher(propertyValue.toString()).matches();
            return this.not ? !matches : matches;
        }
    }

    /* loaded from: classes.dex */
    public interface Segement {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);
    }

    /* loaded from: classes.dex */
    public static class SizeSegement implements Segement {
        public static final SizeSegement instance = new SizeSegement();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }
    }

    /* loaded from: classes.dex */
    public static class StringInSegement implements Filter {
        public final boolean not;
        public final String propertyName;
        public final long propertyNameHash;
        public final String[] values;

        public StringInSegement(String str, String[] strArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = strArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            String[] strArr;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            for (String str : this.values) {
                if (str == propertyValue) {
                    return !this.not;
                }
                if (str != null && str.equals(propertyValue)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    /* loaded from: classes.dex */
    public static class StringOpSegement implements Filter {
        public final Operator op;
        public final String propertyName;
        public final long propertyNameHash;
        public final String value;

        public StringOpSegement(String str, String str2, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = str2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            Operator operator = this.op;
            if (operator == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (operator == Operator.NE) {
                return !this.value.equals(propertyValue);
            }
            if (propertyValue == null) {
                return false;
            }
            int compareTo = this.value.compareTo(propertyValue.toString());
            Operator operator2 = this.op;
            return operator2 == Operator.GE ? compareTo <= 0 : operator2 == Operator.GT ? compareTo < 0 : operator2 == Operator.LE ? compareTo >= 0 : operator2 == Operator.LT && compareTo > 0;
        }
    }

    /* loaded from: classes.dex */
    public static class ValueSegment implements Filter {
        public boolean eq;
        public final String propertyName;
        public final long propertyNameHash;
        public final Object value;

        public ValueSegment(String str, Object obj, boolean z) {
            this.eq = true;
            if (obj != null) {
                this.propertyName = str;
                this.propertyNameHash = TypeUtils.fnv1a_64(str);
                this.value = obj;
                this.eq = z;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.value.equals(jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash));
            return !this.eq ? !equals : equals;
        }
    }

    /* loaded from: classes.dex */
    public static class WildCardSegement implements Segement {
        public static WildCardSegement instance = new WildCardSegement();

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getPropertyValues(obj2);
        }
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public static JSONPath compile(String str) {
        if (str != null) {
            JSONPath jSONPath = pathCache.get(str);
            if (jSONPath == null) {
                JSONPath jSONPath2 = new JSONPath(str);
                if (pathCache.size() < 1024) {
                    pathCache.putIfAbsent(str, jSONPath2);
                    return pathCache.get(str);
                }
                return jSONPath2;
            }
            return jSONPath;
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    public static boolean eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return eqNotNull((Number) obj, (Number) obj2);
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean isInt = isInt(cls);
        Class<?> cls2 = number2.getClass();
        boolean isInt2 = isInt(cls2);
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (isInt2) {
                return bigDecimal.equals(BigDecimal.valueOf(number2.longValue()));
            }
        }
        if (isInt) {
            if (isInt2) {
                return number.longValue() == number2.longValue();
            } else if (number2 instanceof BigInteger) {
                return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
            }
        }
        if (isInt2 && (number instanceof BigInteger)) {
            return ((BigInteger) number).equals(BigInteger.valueOf(number2.longValue()));
        }
        boolean isDouble = isDouble(cls);
        boolean isDouble2 = isDouble(cls2);
        return ((isDouble && isDouble2) || ((isDouble && isInt2) || (isDouble2 && isInt))) && number.doubleValue() == number2.doubleValue();
    }

    public static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    public static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    public static Map<String, Object> paths(Object obj) {
        return paths(obj, SerializeConfig.globalInstance);
    }

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        init();
        Object obj2 = null;
        int i = 0;
        Object obj3 = obj;
        int i2 = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i2 >= segementArr.length) {
                break;
            }
            if (i2 == segementArr.length - 1) {
                obj2 = obj3;
            }
            obj3 = this.segments[i2].eval(this, obj, obj3);
            i2++;
        }
        if (obj3 != null) {
            if (obj3 instanceof Collection) {
                Collection collection = (Collection) obj3;
                int length = objArr.length;
                while (i < length) {
                    collection.add(objArr[i]);
                    i++;
                }
                return;
            }
            Class<?> cls = obj3.getClass();
            if (cls.isArray()) {
                int length2 = Array.getLength(obj3);
                Object newInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
                System.arraycopy(obj3, 0, newInstance, 0, length2);
                while (i < objArr.length) {
                    Array.set(newInstance, length2 + i, objArr[i]);
                    i++;
                }
                Segement[] segementArr2 = this.segments;
                Segement segement = segementArr2[segementArr2.length - 1];
                if (segement instanceof PropertySegement) {
                    ((PropertySegement) segement).setValue(this, obj2, newInstance);
                    return;
                } else if (segement instanceof ArrayAccessSegement) {
                    ((ArrayAccessSegement) segement).setValue(this, obj2, newInstance);
                    return;
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            throw new JSONException("unsupported array put operation. " + cls);
        }
        throw new JSONPathException("value not found in path " + this.path);
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i >= segementArr.length) {
                return true;
            }
            obj2 = segementArr[i].eval(this, obj, obj2);
            if (obj2 == null) {
                return false;
            }
            i++;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object eval = eval(obj);
        if (eval == obj2) {
            return true;
        }
        if (eval == null) {
            return false;
        }
        if (eval instanceof Iterable) {
            for (Object obj3 : (Iterable) eval) {
                if (eq(obj3, obj2)) {
                    return true;
                }
            }
            return false;
        }
        return eq(eval, obj2);
    }

    public void deepScan(Object obj, String str, List<Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                list.add(map.get(str));
                return;
            }
            for (Object obj2 : map.values()) {
                deepScan(obj2, str, list);
            }
            return;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
                if (fieldSerializer != null) {
                    try {
                        try {
                            list.add(fieldSerializer.getPropertyValueDirect(obj));
                            return;
                        } catch (InvocationTargetException e2) {
                            throw new JSONException("getFieldValue error." + str, e2);
                        }
                    } catch (IllegalAccessException e3) {
                        throw new JSONException("getFieldValue error." + str, e3);
                    }
                }
                for (Object obj3 : javaBeanSerializer.getFieldValues(obj)) {
                    deepScan(obj3, str, list);
                }
            } catch (Exception e4) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e4);
            }
        } else if (obj instanceof List) {
            List list2 = (List) obj;
            for (int i = 0; i < list2.size(); i++) {
                deepScan(list2.get(i), str, list);
            }
        }
    }

    public void deepSet(Object obj, String str, long j, Object obj2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                map.get(str);
                map.put(str, obj2);
                return;
            }
            for (Object obj3 : map.values()) {
                deepSet(obj3, str, j, obj2);
            }
            return;
        }
        Class<?> cls = obj.getClass();
        JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
        if (javaBeanDeserializer != null) {
            try {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                if (fieldDeserializer != null) {
                    fieldDeserializer.setValue(obj, obj2);
                    return;
                }
                for (Object obj4 : getJavaBeanSerializer(cls).getObjectFieldValues(obj)) {
                    deepSet(obj4, str, j, obj2);
                }
            } catch (Exception e2) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e2);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                deepSet(list.get(i), str, j, obj2);
            }
        }
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i >= segementArr.length) {
                return obj2;
            }
            obj2 = segementArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            int i = 0;
            for (Object obj2 : ((Map) obj).values()) {
                if (obj2 != null) {
                    i++;
                }
            }
            return i;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            return javaBeanSerializer.getSize(obj);
        } catch (Exception e2) {
            throw new JSONPathException("evalSize error : " + this.path, e2);
        }
    }

    public Object getArrayItem(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                if (i < list.size()) {
                    return list.get(i);
                }
                return null;
            } else if (Math.abs(i) <= list.size()) {
                return list.get(list.size() + i);
            } else {
                return null;
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    return Array.get(obj, i);
                }
                return null;
            } else if (Math.abs(i) <= length) {
                return Array.get(obj, length + i);
            } else {
                return null;
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i));
            return obj2 == null ? map.get(Integer.toString(i)) : obj2;
        } else if (obj instanceof Collection) {
            int i2 = 0;
            for (Object obj3 : (Collection) obj) {
                if (i2 == i) {
                    return obj3;
                }
                i2++;
            }
            return null;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(cls);
        if (deserializer instanceof JavaBeanDeserializer) {
            return (JavaBeanDeserializer) deserializer;
        }
        return null;
    }

    public JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        return null;
    }

    public String getPath() {
        return this.path;
    }

    public Object getPropertyValue(Object obj, String str, long j) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(str);
            return (obj2 == null && SIZE == j) ? Integer.valueOf(map.size()) : obj2;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj, str, j, false);
            } catch (Exception e2) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e2);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            if (SIZE == j) {
                return Integer.valueOf(list.size());
            }
            JSONArray jSONArray = new JSONArray(list.size());
            for (int i = 0; i < list.size(); i++) {
                Object propertyValue = getPropertyValue(list.get(i), str, j);
                if (propertyValue instanceof Collection) {
                    jSONArray.addAll((Collection) propertyValue);
                } else if (propertyValue != null) {
                    jSONArray.add(propertyValue);
                }
            }
            return jSONArray;
        } else {
            if (obj instanceof Enum) {
                Enum r12 = (Enum) obj;
                if (-4270347329889690746L == j) {
                    return r12.name();
                }
                if (-1014497654951707614L == j) {
                    return Integer.valueOf(r12.ordinal());
                }
            }
            if (obj instanceof Calendar) {
                Calendar calendar = (Calendar) obj;
                if (8963398325558730460L == j) {
                    return Integer.valueOf(calendar.get(1));
                }
                if (-811277319855450459L == j) {
                    return Integer.valueOf(calendar.get(2));
                }
                if (-3851359326990528739L == j) {
                    return Integer.valueOf(calendar.get(5));
                }
                if (4647432019745535567L == j) {
                    return Integer.valueOf(calendar.get(11));
                }
                if (6607618197526598121L == j) {
                    return Integer.valueOf(calendar.get(12));
                }
                if (-6586085717218287427L == j) {
                    return Integer.valueOf(calendar.get(13));
                }
            }
            return null;
        }
    }

    public Collection<Object> getPropertyValues(Object obj) {
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e2) {
                throw new JSONPathException("jsonpath error, path " + this.path, e2);
            }
        } else if (obj instanceof Map) {
            return ((Map) obj).values();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void init() {
        if (this.segments != null) {
            return;
        }
        if ("*".equals(this.path)) {
            this.segments = new Segement[]{WildCardSegement.instance};
        } else {
            this.segments = new JSONPathParser(this.path).explain();
        }
    }

    public boolean remove(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        init();
        Collection<Object> collection = null;
        Object obj2 = obj;
        int i = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i >= segementArr.length) {
                break;
            } else if (i == segementArr.length - 1) {
                collection = obj2;
                break;
            } else {
                obj2 = segementArr[i].eval(this, obj, obj2);
                if (obj2 == null) {
                    break;
                }
                i++;
            }
        }
        if (collection == null) {
            return false;
        }
        Segement[] segementArr2 = this.segments;
        Segement segement = segementArr2[segementArr2.length - 1];
        if (segement instanceof PropertySegement) {
            PropertySegement propertySegement = (PropertySegement) segement;
            if ((collection instanceof Collection) && segementArr2.length > 1) {
                Segement segement2 = segementArr2[segementArr2.length - 2];
                if ((segement2 instanceof RangeSegement) || (segement2 instanceof MultiIndexSegement)) {
                    for (Object obj3 : collection) {
                        if (propertySegement.remove(this, obj3)) {
                            z = true;
                        }
                    }
                    return z;
                }
            }
            return propertySegement.remove(this, collection);
        } else if (segement instanceof ArrayAccessSegement) {
            return ((ArrayAccessSegement) segement).remove(this, collection);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                if (i >= list.size()) {
                    return false;
                }
                list.remove(i);
                return true;
            }
            int size = list.size() + i;
            if (size < 0) {
                return false;
            }
            list.remove(size);
            return true;
        }
        Class<?> cls = obj.getClass();
        throw new JSONPathException("unsupported set operation." + cls);
    }

    public boolean removePropertyValue(Object obj, String str) {
        if (obj instanceof Map) {
            return ((Map) obj).remove(str) != null;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer != null) {
            FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
            if (fieldDeserializer == null) {
                return false;
            }
            fieldDeserializer.setValue(obj, (String) null);
            return true;
        }
        throw new UnsupportedOperationException();
    }

    public boolean set(Object obj, Object obj2) {
        return set(obj, obj2, true);
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                list.set(i, obj2);
            } else {
                list.set(list.size() + i, obj2);
            }
            return true;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    Array.set(obj, i, obj2);
                }
            } else if (Math.abs(i) <= length) {
                Array.set(obj, length + i, obj2);
            }
            return true;
        }
        throw new JSONPathException("unsupported set operation." + cls);
    }

    public boolean setPropertyValue(Object obj, String str, long j, Object obj2) {
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        } else if (obj instanceof List) {
            for (Object obj3 : (List) obj) {
                if (obj3 != null) {
                    setPropertyValue(obj3, str, j, obj2);
                }
            }
            return true;
        } else {
            ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
            JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
            if (javaBeanDeserializer != null) {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(j);
                if (fieldDeserializer == null) {
                    return false;
                }
                fieldDeserializer.setValue(obj, obj2);
                return true;
            }
            throw new UnsupportedOperationException();
        }
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i < segementArr.length) {
                obj2 = segementArr[i].eval(this, obj, obj2);
                i++;
            } else {
                return evalSize(obj2);
            }
        }
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        if (str != null && str.length() != 0) {
            this.path = str;
            this.serializeConfig = serializeConfig;
            this.parserConfig = parserConfig;
            return;
        }
        throw new JSONPathException("json-path can not be null or empty");
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        HashMap hashMap = new HashMap();
        paths(identityHashMap, hashMap, "/", obj, serializeConfig);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean set(Object obj, Object obj2, boolean z) {
        Class<?> cls;
        JavaBeanDeserializer javaBeanDeserializer;
        if (obj == null) {
            return false;
        }
        init();
        Object obj3 = obj;
        Object obj4 = null;
        int i = 0;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i >= segementArr.length) {
                obj3 = obj4;
                break;
            }
            Segement segement = segementArr[i];
            Object eval = segement.eval(this, obj, obj3);
            if (eval == null) {
                Segement[] segementArr2 = this.segments;
                Segement segement2 = i < segementArr2.length - 1 ? segementArr2[i + 1] : null;
                if (segement2 instanceof PropertySegement) {
                    if (segement instanceof PropertySegement) {
                        String str = ((PropertySegement) segement).propertyName;
                        JavaBeanDeserializer javaBeanDeserializer2 = getJavaBeanDeserializer(obj3.getClass());
                        if (javaBeanDeserializer2 != null) {
                            cls = javaBeanDeserializer2.getFieldDeserializer(str).fieldInfo.fieldClass;
                            javaBeanDeserializer = getJavaBeanDeserializer(cls);
                            if (javaBeanDeserializer == null) {
                                if (javaBeanDeserializer.beanInfo.defaultConstructor == null) {
                                    return false;
                                }
                                eval = javaBeanDeserializer.createInstance((DefaultJSONParser) null, cls);
                            } else {
                                eval = new JSONObject();
                            }
                        }
                    }
                    cls = null;
                    javaBeanDeserializer = null;
                    if (javaBeanDeserializer == null) {
                    }
                } else {
                    eval = segement2 instanceof ArrayAccessSegement ? new JSONArray() : null;
                }
                if (eval != null) {
                    if (segement instanceof PropertySegement) {
                        ((PropertySegement) segement).setValue(this, obj3, eval);
                    } else if (!(segement instanceof ArrayAccessSegement)) {
                        break;
                    } else {
                        ((ArrayAccessSegement) segement).setValue(this, obj3, eval);
                    }
                } else {
                    break;
                }
            }
            i++;
            obj4 = obj3;
            obj3 = eval;
        }
        if (obj3 == null) {
            return false;
        }
        Segement[] segementArr3 = this.segments;
        Segement segement3 = segementArr3[segementArr3.length - 1];
        if (segement3 instanceof PropertySegement) {
            ((PropertySegement) segement3).setValue(this, obj3, obj2);
            return true;
        } else if (segement3 instanceof ArrayAccessSegement) {
            return ((ArrayAccessSegement) segement3).setValue(this, obj3, obj2);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static void paths(Map<Object, String> map, Map<String, Object> map2, String str, Object obj, SerializeConfig serializeConfig) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (obj == null) {
            return;
        }
        int i = 0;
        if (map.put(obj, str) != null) {
            if (!((obj instanceof String) || (obj instanceof Number) || (obj instanceof Date) || (obj instanceof UUID))) {
                return;
            }
        }
        map2.put(str, obj);
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    if (str.equals("/")) {
                        sb4 = new StringBuilder();
                    } else {
                        sb4 = new StringBuilder();
                        sb4.append(str);
                    }
                    sb4.append("/");
                    sb4.append(key);
                    paths(map, map2, sb4.toString(), entry.getValue(), serializeConfig);
                }
            }
        } else if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (str.equals("/")) {
                    sb3 = new StringBuilder();
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                }
                sb3.append("/");
                sb3.append(i);
                paths(map, map2, sb3.toString(), obj2, serializeConfig);
                i++;
            }
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                while (i < length) {
                    Object obj3 = Array.get(obj, i);
                    if (str.equals("/")) {
                        sb2 = new StringBuilder();
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(str);
                    }
                    sb2.append("/");
                    sb2.append(i);
                    paths(map, map2, sb2.toString(), obj3, serializeConfig);
                    i++;
                }
            } else if (!ParserConfig.isPrimitive2(cls) && !cls.isEnum()) {
                ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls);
                if (objectWriter instanceof JavaBeanSerializer) {
                    try {
                        for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                            String key2 = entry2.getKey();
                            if (key2 instanceof String) {
                                if (str.equals("/")) {
                                    sb = new StringBuilder();
                                    sb.append("/");
                                    sb.append(key2);
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("/");
                                    sb.append(key2);
                                }
                                paths(map, map2, sb.toString(), entry2.getValue(), serializeConfig);
                            }
                        }
                    } catch (Exception e2) {
                        throw new JSONException("toJSON error", e2);
                    }
                }
            }
        }
    }

    public static int size(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalSize(compile.eval(obj));
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static boolean remove(Object obj, String str) {
        return compile(str).remove(obj);
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }

    public static void paths(Map<Object, String> map, String str, Object obj, SerializeConfig serializeConfig) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (obj == null || map.containsKey(obj)) {
            return;
        }
        map.put(obj, str);
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    if (str.equals("/")) {
                        sb4 = new StringBuilder();
                    } else {
                        sb4 = new StringBuilder();
                        sb4.append(str);
                    }
                    sb4.append("/");
                    sb4.append(key);
                    paths(map, sb4.toString(), entry.getValue(), serializeConfig);
                }
            }
            return;
        }
        int i = 0;
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (str.equals("/")) {
                    sb3 = new StringBuilder();
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                }
                sb3.append("/");
                sb3.append(i);
                paths(map, sb3.toString(), obj2, serializeConfig);
                i++;
            }
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            while (i < length) {
                Object obj3 = Array.get(obj, i);
                if (str.equals("/")) {
                    sb2 = new StringBuilder();
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str);
                }
                sb2.append("/");
                sb2.append(i);
                paths(map, sb2.toString(), obj3, serializeConfig);
                i++;
            }
        } else if (!ParserConfig.isPrimitive2(cls) && !cls.isEnum()) {
            ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls);
            if (objectWriter instanceof JavaBeanSerializer) {
                try {
                    for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                        String key2 = entry2.getKey();
                        if (key2 instanceof String) {
                            if (str.equals("/")) {
                                sb = new StringBuilder();
                                sb.append("/");
                                sb.append(key2);
                            } else {
                                sb = new StringBuilder();
                                sb.append(str);
                                sb.append("/");
                                sb.append(key2);
                            }
                            paths(map, sb.toString(), entry2.getValue(), serializeConfig);
                        }
                    }
                } catch (Exception e2) {
                    throw new JSONException("toJSON error", e2);
                }
            }
        }
    }
}
