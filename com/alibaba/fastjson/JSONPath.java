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
/* loaded from: classes15.dex */
public class JSONPath implements JSONAware {
    static final long SIZE = 5614464919154503228L;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private ParserConfig parserConfig;
    private final String path;
    private Segement[] segments;
    private SerializeConfig serializeConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public interface Segement {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        if (str == null || str.length() == 0) {
            throw new JSONPathException("json-path can not be null or empty");
        }
        this.path = str;
        this.serializeConfig = serializeConfig;
        this.parserConfig = parserConfig;
    }

    protected void init() {
        if (this.segments == null) {
            if (!"*".equals(this.path)) {
                this.segments = new JSONPathParser(this.path).explain();
            } else {
                this.segments = new Segement[]{WildCardSegement.instance};
            }
        }
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        Object obj2 = obj;
        for (int i = 0; i < this.segments.length; i++) {
            obj2 = this.segments[i].eval(this, obj, obj2);
        }
        return obj2;
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        for (int i = 0; i < this.segments.length; i++) {
            obj2 = this.segments[i].eval(this, obj, obj2);
            if (obj2 == null) {
                return false;
            }
        }
        return true;
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

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        Object obj2 = obj;
        for (int i = 0; i < this.segments.length; i++) {
            obj2 = this.segments[i].eval(this, obj, obj2);
        }
        return evalSize(obj2);
    }

    public void arrayAdd(Object obj, Object... objArr) {
        int i = 0;
        if (objArr != null && objArr.length != 0 && obj != null) {
            init();
            Object obj2 = null;
            int i2 = 0;
            Object obj3 = obj;
            while (i2 < this.segments.length) {
                if (i2 == this.segments.length - 1) {
                    obj2 = obj3;
                }
                Object eval = this.segments[i2].eval(this, obj, obj3);
                i2++;
                obj3 = eval;
            }
            if (obj3 == null) {
                throw new JSONPathException("value not found in path " + this.path);
            }
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
                Segement segement = this.segments[this.segments.length - 1];
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
    }

    public boolean remove(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        init();
        int i = 0;
        Collection<Object> collection = obj;
        while (true) {
            if (i >= this.segments.length) {
                collection = null;
                break;
            } else if (i == this.segments.length - 1) {
                break;
            } else {
                collection = this.segments[i].eval(this, obj, collection);
                if (collection == null) {
                    collection = null;
                    break;
                }
                i++;
            }
        }
        if (collection != null) {
            Segement segement = this.segments[this.segments.length - 1];
            if (segement instanceof PropertySegement) {
                PropertySegement propertySegement = (PropertySegement) segement;
                if ((collection instanceof Collection) && this.segments.length > 1) {
                    Segement segement2 = this.segments[this.segments.length - 2];
                    if ((segement2 instanceof RangeSegement) || (segement2 instanceof MultiIndexSegement)) {
                        for (Object obj2 : collection) {
                            if (propertySegement.remove(this, obj2)) {
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
        return false;
    }

    public boolean set(Object obj, Object obj2) {
        return set(obj, obj2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
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
        int i = 0;
        Object obj3 = null;
        Object obj4 = obj;
        while (true) {
            if (i >= this.segments.length) {
                obj4 = obj3;
                break;
            }
            Segement segement = this.segments[i];
            Object eval = segement.eval(this, obj, obj4);
            if (eval == null) {
                Segement segement2 = i < this.segments.length + (-1) ? this.segments[i + 1] : null;
                if (segement2 instanceof PropertySegement) {
                    if (segement instanceof PropertySegement) {
                        String str = ((PropertySegement) segement).propertyName;
                        JavaBeanDeserializer javaBeanDeserializer2 = getJavaBeanDeserializer(obj4.getClass());
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
                        ((PropertySegement) segement).setValue(this, obj4, eval);
                    } else if (!(segement instanceof ArrayAccessSegement)) {
                        break;
                    } else {
                        ((ArrayAccessSegement) segement).setValue(this, obj4, eval);
                    }
                } else {
                    break;
                }
            }
            i++;
            Object obj5 = obj4;
            obj4 = eval;
            obj3 = obj5;
        }
        if (obj4 != null) {
            Segement segement3 = this.segments[this.segments.length - 1];
            if (segement3 instanceof PropertySegement) {
                ((PropertySegement) segement3).setValue(this, obj4, obj2);
                return true;
            } else if (segement3 instanceof ArrayAccessSegement) {
                return ((ArrayAccessSegement) segement3).setValue(this, obj4, obj2);
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return false;
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static int size(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalSize(compile.eval(obj));
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }

    public static boolean remove(Object obj, String str) {
        return compile(str).remove(obj);
    }

    public static JSONPath compile(String str) {
        if (str == null) {
            throw new JSONPathException("jsonpath can not be null");
        }
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

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    public static Map<String, Object> paths(Object obj) {
        return paths(obj, SerializeConfig.globalInstance);
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        HashMap hashMap = new HashMap();
        paths(identityHashMap, hashMap, "/", obj, serializeConfig);
        return hashMap;
    }

    private static void paths(Map<Object, String> map, Map<String, Object> map2, String str, Object obj, SerializeConfig serializeConfig) {
        if (obj != null) {
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
                        paths(map, map2, str.equals("/") ? "/" + key : str + "/" + key, entry.getValue(), serializeConfig);
                    }
                }
            } else if (obj instanceof Collection) {
                int i = 0;
                for (Object obj2 : (Collection) obj) {
                    paths(map, map2, str.equals("/") ? "/" + i : str + "/" + i, obj2, serializeConfig);
                    i++;
                }
            } else {
                Class<?> cls = obj.getClass();
                if (cls.isArray()) {
                    int length = Array.getLength(obj);
                    for (int i2 = 0; i2 < length; i2++) {
                        paths(map, map2, str.equals("/") ? "/" + i2 : str + "/" + i2, Array.get(obj, i2), serializeConfig);
                    }
                } else if (!ParserConfig.isPrimitive2(cls) && !cls.isEnum()) {
                    ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls);
                    if (objectWriter instanceof JavaBeanSerializer) {
                        try {
                            for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                                String key2 = entry2.getKey();
                                if (key2 instanceof String) {
                                    paths(map, map2, str.equals("/") ? "/" + key2 : str + "/" + key2, entry2.getValue(), serializeConfig);
                                }
                            }
                        } catch (Exception e) {
                            throw new JSONException("toJSON error", e);
                        }
                    }
                }
            }
        }
    }

    private static void paths(Map<Object, String> map, String str, Object obj, SerializeConfig serializeConfig) {
        int i = 0;
        if (obj != null && !map.containsKey(obj)) {
            map.put(obj, str);
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        paths(map, str.equals("/") ? "/" + key : str + "/" + key, entry.getValue(), serializeConfig);
                    }
                }
            } else if (obj instanceof Collection) {
                for (Object obj2 : (Collection) obj) {
                    paths(map, str.equals("/") ? "/" + i : str + "/" + i, obj2, serializeConfig);
                    i++;
                }
            } else {
                Class<?> cls = obj.getClass();
                if (cls.isArray()) {
                    int length = Array.getLength(obj);
                    for (int i2 = 0; i2 < length; i2++) {
                        paths(map, str.equals("/") ? "/" + i2 : str + "/" + i2, Array.get(obj, i2), serializeConfig);
                    }
                } else if (!ParserConfig.isPrimitive2(cls) && !cls.isEnum()) {
                    ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls);
                    if (objectWriter instanceof JavaBeanSerializer) {
                        try {
                            for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                                String key2 = entry2.getKey();
                                if (key2 instanceof String) {
                                    paths(map, str.equals("/") ? "/" + key2 : str + "/" + key2, entry2.getValue(), serializeConfig);
                                }
                            }
                        } catch (Exception e) {
                            throw new JSONException("toJSON error", e);
                        }
                    }
                }
            }
        }
    }

    public String getPath() {
        return this.path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class JSONPathParser {
        private char ch;
        private int level;
        private final String path;
        private int pos;

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        void next() {
            String str = this.path;
            int i = this.pos;
            this.pos = i + 1;
            this.ch = str.charAt(i);
        }

        boolean isEOF() {
            return this.pos >= this.path.length();
        }

        Segement readSegement() {
            boolean z = true;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new ArrayAccessSegement(this.ch - '0');
                }
                if ((this.ch >= 'a' && this.ch <= 'z') || (this.ch >= 'A' && this.ch <= 'Z')) {
                    return new PropertySegement(Character.toString(this.ch), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                if (this.ch == '$') {
                    next();
                } else if (this.ch == '.' || this.ch == '/') {
                    char c = this.ch;
                    next();
                    if (c == '.' && this.ch == '.') {
                        next();
                        if (this.path.length() > this.pos + 3 && this.ch == '[' && this.path.charAt(this.pos) == '*' && this.path.charAt(this.pos + 1) == ']' && this.path.charAt(this.pos + 2) == '.') {
                            next();
                            next();
                            next();
                            next();
                        }
                    } else {
                        z = false;
                    }
                    if (this.ch == '*') {
                        if (!isEOF()) {
                            next();
                        }
                        return WildCardSegement.instance;
                    } else if (isDigitFirst(this.ch)) {
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
                } else if (this.ch == '[') {
                    return parseArrayAccess(true);
                } else {
                    if (this.level == 0) {
                        return new PropertySegement(readName(), false);
                    }
                    throw new JSONPathException("not support jsonpath : " + this.path);
                }
            }
            return null;
        }

        public final void skipWhitespace() {
            while (this.ch <= ' ') {
                if (this.ch == ' ' || this.ch == '\r' || this.ch == '\n' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b') {
                    next();
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:250:0x0458, code lost:
            r1 = r13.pos - 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Segement parseArrayAccess(boolean z) {
            boolean z2;
            String str;
            String str2;
            Operator operator;
            int i = 0;
            if (z) {
                accept('[');
            }
            if (this.ch == '?') {
                next();
                accept('(');
                if (this.ch == '@') {
                    next();
                    accept('.');
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || IOUtils.firstIdentifier(this.ch)) {
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
                    if (readOp == Operator.BETWEEN || readOp == Operator.NOT_BETWEEN) {
                        boolean z3 = readOp == Operator.NOT_BETWEEN;
                        Object readValue = readValue();
                        if (!"and".equalsIgnoreCase(readName())) {
                            throw new JSONPathException(this.path);
                        }
                        Object readValue2 = readValue();
                        if (readValue == null || readValue2 == null) {
                            throw new JSONPathException(this.path);
                        }
                        if (JSONPath.isInt(readValue.getClass()) && JSONPath.isInt(readValue2.getClass())) {
                            return new FilterSegement(new IntBetweenSegement(readName, ((Number) readValue).longValue(), ((Number) readValue2).longValue(), z3));
                        }
                        throw new JSONPathException(this.path);
                    } else if (readOp == Operator.IN || readOp == Operator.NOT_IN) {
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
                            if (obj == null) {
                                if (z7) {
                                    z7 = false;
                                }
                            } else {
                                Class<?> cls = obj.getClass();
                                if (z7 && cls != Byte.class && cls != Short.class && cls != Integer.class && cls != Long.class) {
                                    z6 = false;
                                    z7 = false;
                                }
                                if (z5 && cls != String.class) {
                                    z5 = false;
                                }
                            }
                        }
                        if (jSONArray.size() == 1 && jSONArray.get(0) == null) {
                            if (z4) {
                                return new FilterSegement(new NotNullSegement(readName));
                            }
                            return new FilterSegement(new NullSegement(readName));
                        } else if (z7) {
                            if (jSONArray.size() == 1) {
                                return new FilterSegement(new IntOpSegement(readName, ((Number) jSONArray.get(0)).longValue(), z4 ? Operator.NE : Operator.EQ));
                            }
                            long[] jArr = new long[jSONArray.size()];
                            while (true) {
                                int i2 = i;
                                if (i2 < jArr.length) {
                                    jArr[i2] = ((Number) jSONArray.get(i2)).longValue();
                                    i = i2 + 1;
                                } else {
                                    return new FilterSegement(new IntInSegement(readName, jArr, z4));
                                }
                            }
                        } else if (z5) {
                            if (jSONArray.size() == 1) {
                                return new FilterSegement(new StringOpSegement(readName, (String) jSONArray.get(0), z4 ? Operator.NE : Operator.EQ));
                            }
                            String[] strArr = new String[jSONArray.size()];
                            jSONArray.toArray(strArr);
                            return new FilterSegement(new StringInSegement(readName, strArr, z4));
                        } else if (z6) {
                            Long[] lArr = new Long[jSONArray.size()];
                            while (true) {
                                int i3 = i;
                                if (i3 < lArr.length) {
                                    Number number = (Number) jSONArray.get(i3);
                                    if (number != null) {
                                        lArr[i3] = Long.valueOf(number.longValue());
                                    }
                                    i = i3 + 1;
                                } else {
                                    return new FilterSegement(new IntObjInSegement(readName, lArr, z4));
                                }
                            }
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    } else if (this.ch == '\'' || this.ch == '\"') {
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
                            boolean z8 = readOp == Operator.NOT_LIKE;
                            int indexOf = readString.indexOf(37);
                            if (indexOf == -1) {
                                if (readOp == Operator.LIKE) {
                                    operator = Operator.EQ;
                                } else {
                                    operator = Operator.NE;
                                }
                            } else {
                                String[] split = readString.split("%");
                                String[] strArr2 = null;
                                if (indexOf == 0) {
                                    if (readString.charAt(readString.length() - 1) == '%') {
                                        strArr2 = new String[split.length - 1];
                                        System.arraycopy(split, 1, strArr2, 0, strArr2.length);
                                        str = null;
                                        str2 = null;
                                    } else {
                                        String str3 = split[split.length - 1];
                                        if (split.length <= 2) {
                                            str = str3;
                                            str2 = null;
                                        } else {
                                            strArr2 = new String[split.length - 2];
                                            System.arraycopy(split, 1, strArr2, 0, strArr2.length);
                                            str = str3;
                                            str2 = null;
                                        }
                                    }
                                } else if (readString.charAt(readString.length() - 1) == '%') {
                                    strArr2 = split;
                                    str2 = null;
                                    str = null;
                                } else if (split.length == 1) {
                                    str2 = split[0];
                                    str = null;
                                } else if (split.length == 2) {
                                    str2 = split[0];
                                    str = split[1];
                                } else {
                                    String str4 = split[0];
                                    String str5 = split[split.length - 1];
                                    strArr2 = new String[split.length - 2];
                                    System.arraycopy(split, 1, strArr2, 0, strArr2.length);
                                    str = str5;
                                    str2 = str4;
                                }
                                return new FilterSegement(new MatchSegement(readName, str2, str, strArr2, z8));
                            }
                        } else {
                            operator = readOp;
                        }
                        return new FilterSegement(new StringOpSegement(readName, readString, operator));
                    } else if (isDigitFirst(this.ch)) {
                        long readLongValue = readLongValue();
                        double d = 0.0d;
                        if (this.ch == '.') {
                            d = readDoubleValue(readLongValue);
                        }
                        if (z2) {
                            accept(')');
                        }
                        if (z) {
                            accept(']');
                        }
                        if (d == 0.0d) {
                            return new FilterSegement(new IntOpSegement(readName, readLongValue, readOp));
                        }
                        return new FilterSegement(new DoubleOpSegement(readName, d, readOp));
                    } else {
                        if (this.ch == 'n') {
                            if ("null".equals(readName())) {
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
                        } else if (this.ch == 't') {
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
                        } else if (this.ch == 'f' && "false".equals(readName())) {
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
                }
            } else {
                int i4 = this.pos - 1;
                while (this.ch != ']' && this.ch != '/' && !isEOF() && (this.ch != '.' || z2 || z2)) {
                    if (this.ch == '\\') {
                        next();
                    }
                    next();
                }
                int i5 = (this.ch == '/' || this.ch == '.') ? this.pos - 1 : this.pos;
                String substring = this.path.substring(i4, i5);
                if (substring.indexOf("\\.") != -1) {
                    return new PropertySegement(substring.replaceAll("\\\\\\.", "\\."), false);
                }
                Segement buildArraySegement = buildArraySegement(substring);
                if (z && !isEOF()) {
                    accept(']');
                    return buildArraySegement;
                }
                return buildArraySegement;
            }
        }

        protected long readLongValue() {
            int i = this.pos - 1;
            if (this.ch == '+' || this.ch == '-') {
                next();
            }
            while (this.ch >= '0' && this.ch <= '9') {
                next();
            }
            return Long.parseLong(this.path.substring(i, this.pos - 1));
        }

        protected double readDoubleValue(long j) {
            int i = this.pos - 1;
            next();
            while (this.ch >= '0' && this.ch <= '9') {
                next();
            }
            return Double.parseDouble(this.path.substring(i, this.pos - 1)) + j;
        }

        protected Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            if (this.ch == '\"' || this.ch == '\'') {
                return readString();
            }
            if (this.ch == 'n') {
                if ("null".equals(readName())) {
                    return null;
                }
                throw new JSONPathException(this.path);
            }
            throw new UnsupportedOperationException();
        }

        static boolean isDigitFirst(char c) {
            return c == '-' || c == '+' || (c >= '0' && c <= '9');
        }

        protected Operator readOp() {
            Operator operator = null;
            if (this.ch == '=') {
                next();
                operator = Operator.EQ;
            } else if (this.ch == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (this.ch == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (this.ch == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
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

        String readName() {
            skipWhitespace();
            if (this.ch != '\\' && !IOUtils.firstIdentifier(this.ch)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            StringBuilder sb = new StringBuilder();
            while (!isEOF()) {
                if (this.ch == '\\') {
                    next();
                    sb.append(this.ch);
                    if (isEOF()) {
                        break;
                    }
                    next();
                } else if (!IOUtils.isIdent(this.ch)) {
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

        String readString() {
            char c = this.ch;
            next();
            int i = this.pos - 1;
            while (this.ch != c && !isEOF()) {
                next();
            }
            String substring = this.path.substring(i, isEOF() ? this.pos : this.pos - 1);
            accept(c);
            return substring;
        }

        void accept(char c) {
            if (this.ch != c) {
                throw new JSONPathException("expect '" + c + ", but '" + this.ch + "'");
            }
            if (!isEOF()) {
                next();
            }
        }

        public Segement[] explain() {
            if (this.path == null || this.path.length() == 0) {
                throw new IllegalArgumentException();
            }
            Segement[] segementArr = new Segement[8];
            while (true) {
                Segement readSegement = readSegement();
                if (readSegement == null) {
                    break;
                }
                if (this.level == segementArr.length) {
                    Segement[] segementArr2 = new Segement[(this.level * 3) / 2];
                    System.arraycopy(segementArr, 0, segementArr2, 0, this.level);
                    segementArr = segementArr2;
                }
                int i = this.level;
                this.level = i + 1;
                segementArr[i] = readSegement;
            }
            if (this.level != segementArr.length) {
                Segement[] segementArr3 = new Segement[this.level];
                System.arraycopy(segementArr, 0, segementArr3, 0, this.level);
                return segementArr3;
            }
            return segementArr;
        }

        Segement buildArraySegement(String str) {
            String str2;
            int i = 0;
            int length = str.length();
            char charAt = str.charAt(0);
            char charAt2 = str.charAt(length - 1);
            int indexOf = str.indexOf(44);
            if (str.length() > 2 && charAt == '\'' && charAt2 == '\'') {
                if (indexOf == -1) {
                    return new PropertySegement(str.substring(1, length - 1), false);
                }
                String[] split = str.split(",");
                String[] strArr = new String[split.length];
                while (i < split.length) {
                    strArr[i] = split[i].substring(1, str2.length() - 1);
                    i++;
                }
                return new MultiPropertySegement(strArr);
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf == -1 && indexOf2 == -1) {
                if (TypeUtils.isNumber(str)) {
                    try {
                        return new ArrayAccessSegement(Integer.parseInt(str));
                    } catch (NumberFormatException e) {
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
                int[] iArr2 = new int[split3.length];
                for (int i2 = 0; i2 < split3.length; i2++) {
                    String str3 = split3[i2];
                    if (str3.length() == 0) {
                        if (i2 == 0) {
                            iArr2[i2] = 0;
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        iArr2[i2] = Integer.parseInt(str3);
                    }
                }
                int i3 = iArr2[0];
                int i4 = iArr2.length > 1 ? iArr2[1] : -1;
                int i5 = iArr2.length == 3 ? iArr2[2] : 1;
                if (i4 >= 0 && i4 < i3) {
                    throw new UnsupportedOperationException("end must greater than or equals start. start " + i3 + ",  end " + i4);
                }
                if (i5 <= 0) {
                    throw new UnsupportedOperationException("step must greater than zero : " + i5);
                }
                return new RangeSegement(i3, i4, i5);
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class SizeSegement implements Segement {
        public static final SizeSegement instance = new SizeSegement();

        SizeSegement() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class PropertySegement implements Segement {
        private final boolean deep;
        private final String propertyName;
        private final long propertyNameHash;

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

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, this.propertyNameHash, obj2);
            } else {
                jSONPath.setPropertyValue(obj, this.propertyName, this.propertyNameHash, obj2);
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class MultiPropertySegement implements Segement {
        private final String[] propertyNames;
        private final long[] propertyNamesHash;

        public MultiPropertySegement(String[] strArr) {
            this.propertyNames = strArr;
            this.propertyNamesHash = new long[strArr.length];
            for (int i = 0; i < this.propertyNamesHash.length; i++) {
                this.propertyNamesHash[i] = TypeUtils.fnv1a_64(strArr[i]);
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            for (int i = 0; i < this.propertyNames.length; i++) {
                arrayList.add(jSONPath.getPropertyValue(obj2, this.propertyNames[i], this.propertyNamesHash[i]));
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class WildCardSegement implements Segement {
        public static WildCardSegement instance = new WildCardSegement();

        WildCardSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getPropertyValues(obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class ArrayAccessSegement implements Segement {
        private final int index;

        public ArrayAccessSegement(int i) {
            this.index = i;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class MultiIndexSegement implements Segement {
        private final int[] indexes;

        public MultiIndexSegement(int[] iArr) {
            this.indexes = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.indexes.length);
            for (int i = 0; i < this.indexes.length; i++) {
                arrayList.add(jSONPath.getArrayItem(obj2, this.indexes[i]));
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class RangeSegement implements Segement {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegement(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.step = i3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = SizeSegement.instance.eval(jSONPath, obj, obj2).intValue();
            int i = this.start >= 0 ? this.start : this.start + intValue;
            int i2 = this.end >= 0 ? this.end : this.end + intValue;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class NotNullSegement implements Filter {
        private final String propertyName;
        private final long propertyNameHash;

        public NotNullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class NullSegement implements Filter {
        private final String propertyName;
        private final long propertyNameHash;

        public NullSegement(String str) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) == null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class ValueSegment implements Filter {
        private boolean eq;
        private final String propertyName;
        private final long propertyNameHash;
        private final Object value;

        public ValueSegment(String str, Object obj, boolean z) {
            this.eq = true;
            if (obj == null) {
                throw new IllegalArgumentException("value is null");
            }
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = obj;
            this.eq = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.value.equals(jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash));
            if (this.eq) {
                return equals;
            }
            return !equals;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class IntInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final long[] values;

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
                long[] jArr = this.values;
                int length = jArr.length;
                for (int i = 0; i < length; i++) {
                    if (jArr[i] == longValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class IntBetweenSegement implements Filter {
        private final long endValue;
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final long startValue;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class IntObjInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final Long[] values;

        public IntObjInSegement(String str, Long[] lArr, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.values = lArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Long[] lArr;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                for (Long l : this.values) {
                    if (l == null) {
                        return !this.not;
                    }
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                for (Long l2 : this.values) {
                    if (l2 != null && l2.longValue() == longValue) {
                        return this.not ? false : true;
                    }
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class StringInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final String[] values;

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
                } else if (str != null && str.equals(propertyValue)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class IntOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final long value;

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
                if (this.op == Operator.EQ) {
                    return longValue == this.value;
                }
                return this.op == Operator.NE ? longValue != this.value : this.op == Operator.GE ? longValue >= this.value : this.op == Operator.GT ? longValue > this.value : this.op == Operator.LE ? longValue <= this.value : this.op == Operator.LT && longValue < this.value;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class DoubleOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final double value;

        public DoubleOpSegement(String str, double d, Operator operator) {
            this.propertyName = str;
            this.value = d;
            this.op = operator;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue != null && (propertyValue instanceof Number)) {
                double doubleValue = ((Number) propertyValue).doubleValue();
                if (this.op == Operator.EQ) {
                    return doubleValue == this.value;
                }
                return this.op == Operator.NE ? doubleValue != this.value : this.op == Operator.GE ? doubleValue >= this.value : this.op == Operator.GT ? doubleValue > this.value : this.op == Operator.LE ? doubleValue <= this.value : this.op == Operator.LT && doubleValue < this.value;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class MatchSegement implements Filter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String propertyName;
        private final long propertyNameHash;
        private final String startsWithValue;

        public MatchSegement(String str, String str2, String str3, String[] strArr, boolean z) {
            int i = 0;
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z;
            int length = str2 != null ? str2.length() + 0 : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                int length2 = strArr.length;
                while (i < length2) {
                    int length3 = strArr[i].length() + length;
                    i++;
                    length = length3;
                }
            }
            this.minLength = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i;
            String[] strArr;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (propertyValue == null) {
                return false;
            }
            String obj4 = propertyValue.toString();
            if (obj4.length() < this.minLength) {
                return this.not;
            }
            if (this.startsWithValue == null) {
                i = 0;
            } else if (!obj4.startsWith(this.startsWithValue)) {
                return this.not;
            } else {
                i = this.startsWithValue.length() + 0;
            }
            if (this.containsValues != null) {
                int i2 = i;
                for (String str : this.containsValues) {
                    int indexOf = obj4.indexOf(str, i2);
                    if (indexOf == -1) {
                        return this.not;
                    }
                    i2 = indexOf + str.length();
                }
            }
            if (this.endsWithValue == null || obj4.endsWith(this.endsWithValue)) {
                return !this.not;
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class RlikeSegement implements Filter {
        private final boolean not;
        private final Pattern pattern;
        private final String propertyName;
        private final long propertyNameHash;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class StringOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long propertyNameHash;
        private final String value;

        public StringOpSegement(String str, String str2, Operator operator) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.value = str2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash);
            if (this.op == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (this.op == Operator.NE) {
                return !this.value.equals(propertyValue);
            } else if (propertyValue == null) {
                return false;
            } else {
                int compareTo = this.value.compareTo(propertyValue.toString());
                return this.op == Operator.GE ? compareTo <= 0 : this.op == Operator.GT ? compareTo < 0 : this.op == Operator.LE ? compareTo >= 0 : this.op == Operator.LT && compareTo > 0;
            }
        }
    }

    /* loaded from: classes15.dex */
    public static class FilterSegement implements Segement {
        private final Filter filter;

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

    protected Object getArrayItem(Object obj, int i) {
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
            if (obj2 == null) {
                return map.get(Integer.toString(i));
            }
            return obj2;
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

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                list.set(i, obj2);
            } else {
                list.set(list.size() + i, obj2);
            }
        } else {
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
            } else {
                throw new JSONPathException("unsupported set operation." + cls);
            }
        }
        return true;
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                if (i >= list.size()) {
                    return false;
                }
                list.remove(i);
            } else {
                int size = list.size() + i;
                if (size < 0) {
                    return false;
                }
                list.remove(size);
            }
            return true;
        }
        throw new JSONPathException("unsupported set operation." + obj.getClass());
    }

    protected Collection<Object> getPropertyValues(Object obj) {
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof Map) {
            return ((Map) obj).values();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    static boolean eq(Object obj, Object obj2) {
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

    static boolean eqNotNull(Number number, Number number2) {
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
        if ((isDouble && isDouble2) || ((isDouble && isInt2) || (isDouble2 && isInt))) {
            return number.doubleValue() == number2.doubleValue();
        }
        return false;
    }

    protected static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    protected static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    protected Object getPropertyValue(Object obj, String str, long j) {
        int i = 0;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(str);
            if (obj2 == null && SIZE == j) {
                return Integer.valueOf(map.size());
            }
            return obj2;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj, str, j, false);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            if (SIZE == j) {
                return Integer.valueOf(list.size());
            }
            JSONArray jSONArray = new JSONArray(list.size());
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    return jSONArray;
                }
                Object propertyValue = getPropertyValue(list.get(i2), str, j);
                if (propertyValue instanceof Collection) {
                    jSONArray.addAll((Collection) propertyValue);
                } else if (propertyValue != null) {
                    jSONArray.add(propertyValue);
                }
                i = i2 + 1;
            }
        } else {
            if (obj instanceof Enum) {
                Enum r0 = (Enum) obj;
                if (-4270347329889690746L == j) {
                    return r0.name();
                }
                if (-1014497654951707614L == j) {
                    return Integer.valueOf(r0.ordinal());
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

    protected void deepScan(Object obj, String str, List<Object> list) {
        if (obj != null) {
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
                            } catch (InvocationTargetException e) {
                                throw new JSONException("getFieldValue error." + str, e);
                            }
                        } catch (IllegalAccessException e2) {
                            throw new JSONException("getFieldValue error." + str, e2);
                        }
                    }
                    for (Object obj3 : javaBeanSerializer.getFieldValues(obj)) {
                        deepScan(obj3, str, list);
                    }
                } catch (Exception e3) {
                    throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e3);
                }
            } else if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i = 0; i < list2.size(); i++) {
                    deepScan(list2.get(i), str, list);
                }
            }
        }
    }

    protected void deepSet(Object obj, String str, long j, Object obj2) {
        if (obj != null) {
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
                } catch (Exception e) {
                    throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                for (int i = 0; i < list.size(); i++) {
                    deepSet(list.get(i), str, j, obj2);
                }
            }
        }
    }

    protected boolean setPropertyValue(Object obj, String str, long j, Object obj2) {
        JavaBeanDeserializer javaBeanDeserializer;
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
            if (!(deserializer instanceof JavaBeanDeserializer)) {
                javaBeanDeserializer = null;
            } else {
                javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
            }
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

    protected boolean removePropertyValue(Object obj, String str) {
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

    protected JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (!(objectWriter instanceof JavaBeanSerializer)) {
            return null;
        }
        return (JavaBeanSerializer) objectWriter;
    }

    protected JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(cls);
        if (!(deserializer instanceof JavaBeanDeserializer)) {
            return null;
        }
        return (JavaBeanDeserializer) deserializer;
    }

    int evalSize(Object obj) {
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
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getSize(obj);
            } catch (Exception e) {
                throw new JSONPathException("evalSize error : " + this.path, e);
            }
        }
        return -1;
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }
}
