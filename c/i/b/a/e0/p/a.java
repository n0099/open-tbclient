package c.i.b.a.e0.p;

import android.text.Layout;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import c.i.b.a.i0.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tachikoma.core.component.input.TextAlign;
import com.tachikoma.core.component.text.SpanItem;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes9.dex */
public final class a extends c.i.b.a.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern o;
    public static final Pattern p;
    public static final Pattern q;
    public static final Pattern r;
    public static final C1649a s;
    public transient /* synthetic */ FieldHolder $fh;
    public final XmlPullParserFactory n;

    /* renamed from: c.i.b.a.e0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1649a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float a;

        /* renamed from: b  reason: collision with root package name */
        public final int f30445b;

        /* renamed from: c  reason: collision with root package name */
        public final int f30446c;

        public C1649a(float f2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f2;
            this.f30445b = i2;
            this.f30446c = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1190103836, "Lc/i/b/a/e0/p/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1190103836, "Lc/i/b/a/e0/p/a;");
                return;
            }
        }
        o = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
        p = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
        q = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
        r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
        s = new C1649a(30.0f, 1, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("TtmlDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.n = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    public static boolean B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.equals(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP) || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information") : invokeL.booleanValue;
    }

    public static void C(String str, e eVar) throws SubtitleDecoderException {
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, eVar) == null) {
            String[] split = str.split("\\s+");
            if (split.length == 1) {
                matcher = q.matcher(str);
            } else if (split.length == 2) {
                matcher = q.matcher(split[1]);
            } else {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
            }
            if (matcher.matches()) {
                String group = matcher.group(3);
                char c2 = 65535;
                int hashCode = group.hashCode();
                if (hashCode != 37) {
                    if (hashCode != 3240) {
                        if (hashCode == 3592 && group.equals("px")) {
                            c2 = 0;
                        }
                    } else if (group.equals("em")) {
                        c2 = 1;
                    }
                } else if (group.equals("%")) {
                    c2 = 2;
                }
                if (c2 == 0) {
                    eVar.t(1);
                } else if (c2 == 1) {
                    eVar.t(2);
                } else if (c2 == 2) {
                    eVar.t(3);
                } else {
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
                }
                eVar.s(Float.valueOf(matcher.group(1)).floatValue());
                return;
            }
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c0, code lost:
        if (r14.equals("s") != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long J(String str, C1649a c1649a) throws SubtitleDecoderException {
        InterceptResult invokeLL;
        double d2;
        double d3;
        String group;
        String group2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, c1649a)) == null) {
            Matcher matcher = o.matcher(str);
            char c2 = 2;
            if (matcher.matches()) {
                double parseLong = (Long.parseLong(matcher.group(1)) * 3600) + (Long.parseLong(matcher.group(2)) * 60) + Long.parseLong(matcher.group(3));
                String group3 = matcher.group(4);
                return (long) ((parseLong + (group3 != null ? Double.parseDouble(group3) : 0.0d) + (matcher.group(5) != null ? ((float) Long.parseLong(group)) / c1649a.a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(group2) / c1649a.f30445b) / c1649a.a : 0.0d)) * 1000000.0d);
            }
            Matcher matcher2 = p.matcher(str);
            if (matcher2.matches()) {
                double parseDouble = Double.parseDouble(matcher2.group(1));
                String group4 = matcher2.group(2);
                int hashCode = group4.hashCode();
                if (hashCode == 102) {
                    if (group4.equals("f")) {
                        c2 = 4;
                    }
                    c2 = 65535;
                } else if (hashCode == 104) {
                    if (group4.equals("h")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else if (hashCode == 109) {
                    if (group4.equals("m")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode == 3494) {
                    if (group4.equals("ms")) {
                        c2 = 3;
                    }
                    c2 = 65535;
                } else if (hashCode != 115) {
                    if (hashCode == 116 && group4.equals("t")) {
                        c2 = 5;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    d2 = 3600.0d;
                } else if (c2 != 1) {
                    if (c2 == 3) {
                        d3 = 1000.0d;
                    } else if (c2 != 4) {
                        if (c2 == 5) {
                            d3 = c1649a.f30446c;
                        }
                        return (long) (parseDouble * 1000000.0d);
                    } else {
                        d3 = c1649a.a;
                    }
                    parseDouble /= d3;
                    return (long) (parseDouble * 1000000.0d);
                } else {
                    d2 = 60.0d;
                }
                parseDouble *= d2;
                return (long) (parseDouble * 1000000.0d);
            }
            throw new SubtitleDecoderException("Malformed time expression: " + str);
        }
        return invokeLL.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.e0.c
    /* renamed from: A */
    public f w(byte[] bArr, int i2, boolean z) throws SubtitleDecoderException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            try {
                XmlPullParser newPullParser = this.n.newPullParser();
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                f fVar = null;
                hashMap2.put("", new c(null));
                int i3 = 0;
                newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i2), null);
                LinkedList linkedList = new LinkedList();
                C1649a c1649a = s;
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                    b bVar = (b) linkedList.peekLast();
                    if (i3 == 0) {
                        String name = newPullParser.getName();
                        if (eventType == 2) {
                            if (PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP.equals(name)) {
                                c1649a = D(newPullParser);
                            }
                            if (!B(name)) {
                                String str = "Ignoring unsupported tag: " + newPullParser.getName();
                            } else if ("head".equals(name)) {
                                E(newPullParser, hashMap, hashMap2);
                            } else {
                                try {
                                    b F = F(newPullParser, bVar, hashMap2, c1649a);
                                    linkedList.addLast(F);
                                    if (bVar != null) {
                                        bVar.a(F);
                                    }
                                } catch (SubtitleDecoderException unused) {
                                }
                            }
                            i3++;
                        } else if (eventType == 4) {
                            bVar.a(b.d(newPullParser.getText()));
                        } else if (eventType == 3) {
                            if (newPullParser.getName().equals(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)) {
                                fVar = new f((b) linkedList.getLast(), hashMap, hashMap2);
                            }
                            linkedList.removeLast();
                        }
                    } else {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                i3--;
                            }
                        }
                        i3++;
                    }
                    newPullParser.next();
                }
                return fVar;
            } catch (IOException e2) {
                throw new IllegalStateException("Unexpected error when reading input.", e2);
            } catch (XmlPullParserException e3) {
                throw new SubtitleDecoderException("Unable to decode source", e3);
            }
        }
        return (f) invokeCommon.objValue;
    }

    public final C1649a D(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xmlPullParser)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
            int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
            float f2 = 1.0f;
            String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
            if (attributeValue2 != null) {
                String[] split = attributeValue2.split(" ");
                if (split.length == 2) {
                    f2 = Integer.parseInt(split[0]) / Integer.parseInt(split[1]);
                } else {
                    throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
                }
            }
            int i2 = s.f30445b;
            String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
            if (attributeValue3 != null) {
                i2 = Integer.parseInt(attributeValue3);
            }
            int i3 = s.f30446c;
            String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
            if (attributeValue4 != null) {
                i3 = Integer.parseInt(attributeValue4);
            }
            return new C1649a(parseInt * f2, i2, i3);
        }
        return (C1649a) invokeL.objValue;
    }

    public final Map<String, e> E(XmlPullParser xmlPullParser, Map<String, e> map, Map<String, c> map2) throws IOException, XmlPullParserException {
        c G;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, xmlPullParser, map, map2)) == null) {
            do {
                xmlPullParser.next();
                if (w.e(xmlPullParser, "style")) {
                    String a = w.a(xmlPullParser, "style");
                    e H = H(xmlPullParser, new e());
                    if (a != null) {
                        for (String str : I(a)) {
                            H.a(map.get(str));
                        }
                    }
                    if (H.g() != null) {
                        map.put(H.g(), H);
                    }
                } else if (w.e(xmlPullParser, "region") && (G = G(xmlPullParser)) != null) {
                    map2.put(G.a, G);
                }
            } while (!w.c(xmlPullParser, "head"));
            return map;
        }
        return (Map) invokeLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final b F(XmlPullParser xmlPullParser, b bVar, Map<String, c> map, C1649a c1649a) throws SubtitleDecoderException {
        InterceptResult invokeLLLL;
        long j2;
        long j3;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, xmlPullParser, bVar, map, c1649a)) == null) {
            int attributeCount = xmlPullParser.getAttributeCount();
            e H = H(xmlPullParser, null);
            String[] strArr = null;
            String str = "";
            long j4 = -9223372036854775807L;
            long j5 = -9223372036854775807L;
            long j6 = -9223372036854775807L;
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = xmlPullParser.getAttributeName(i2);
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                switch (attributeName.hashCode()) {
                    case -934795532:
                        if (attributeName.equals("region")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 99841:
                        if (attributeName.equals("dur")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 100571:
                        if (attributeName.equals("end")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 93616297:
                        if (attributeName.equals(ProgressInfo.JSON_KEY_BEGIN)) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 109780401:
                        if (attributeName.equals("style")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    j4 = J(attributeValue, c1649a);
                } else if (c2 == 1) {
                    j5 = J(attributeValue, c1649a);
                } else if (c2 == 2) {
                    j6 = J(attributeValue, c1649a);
                } else if (c2 != 3) {
                    if (c2 == 4 && map.containsKey(attributeValue)) {
                        str = attributeValue;
                    }
                } else {
                    String[] I = I(attributeValue);
                    if (I.length > 0) {
                        strArr = I;
                    }
                }
            }
            if (bVar != null) {
                long j7 = bVar.f30449d;
                j2 = -9223372036854775807L;
                if (j7 != -9223372036854775807L) {
                    if (j4 != -9223372036854775807L) {
                        j4 += j7;
                    }
                    if (j5 != -9223372036854775807L) {
                        j5 += bVar.f30449d;
                    }
                }
            } else {
                j2 = -9223372036854775807L;
            }
            long j8 = j4;
            if (j5 == j2) {
                if (j6 != j2) {
                    j3 = j8 + j6;
                } else if (bVar != null) {
                    long j9 = bVar.f30450e;
                    if (j9 != j2) {
                        j3 = j9;
                    }
                }
                return b.c(xmlPullParser.getName(), j8, j3, H, strArr, str);
            }
            j3 = j5;
            return b.c(xmlPullParser.getName(), j8, j3, H, strArr, str);
        }
        return (b) invokeLLLL.objValue;
    }

    public final c G(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        String a;
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xmlPullParser)) == null) {
            String a2 = w.a(xmlPullParser, "id");
            if (a2 != null && (a = w.a(xmlPullParser, FilterValue.DEFAULT_FILTER_VALUE)) != null) {
                Matcher matcher = r.matcher(a);
                if (matcher.matches()) {
                    try {
                        float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                        float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                        String a3 = w.a(xmlPullParser, "extent");
                        if (a3 != null) {
                            Matcher matcher2 = r.matcher(a3);
                            if (matcher2.matches()) {
                                try {
                                    float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                    float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                    String a4 = w.a(xmlPullParser, "displayAlign");
                                    if (a4 != null) {
                                        String J = v.J(a4);
                                        char c2 = 65535;
                                        int hashCode = J.hashCode();
                                        if (hashCode != -1364013995) {
                                            if (hashCode == 92734940 && J.equals("after")) {
                                                c2 = 1;
                                            }
                                        } else if (J.equals(TextAlign.CENTER)) {
                                            c2 = 0;
                                        }
                                        if (c2 == 0) {
                                            f2 = parseFloat2 + (parseFloat4 / 2.0f);
                                            i2 = 1;
                                        } else if (c2 == 1) {
                                            f2 = parseFloat2 + parseFloat4;
                                            i2 = 2;
                                        }
                                        return new c(a2, parseFloat, f2, 0, i2, parseFloat3);
                                    }
                                    f2 = parseFloat2;
                                    i2 = 0;
                                    return new c(a2, parseFloat, f2, 0, i2, parseFloat3);
                                } catch (NumberFormatException unused) {
                                    String str = "Ignoring region with malformed extent: " + a;
                                    return null;
                                }
                            }
                            String str2 = "Ignoring region with unsupported extent: " + a;
                        }
                        return null;
                    } catch (NumberFormatException unused2) {
                        String str3 = "Ignoring region with malformed origin: " + a;
                        return null;
                    }
                }
                String str4 = "Ignoring region with unsupported origin: " + a;
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final e H(XmlPullParser xmlPullParser, e eVar) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, xmlPullParser, eVar)) == null) {
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                String attributeName = xmlPullParser.getAttributeName(i2);
                char c3 = 65535;
                switch (attributeName.hashCode()) {
                    case -1550943582:
                        if (attributeName.equals("fontStyle")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1224696685:
                        if (attributeName.equals(SpanItem.TYPE_FONT_FAMILY)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1065511464:
                        if (attributeName.equals("textAlign")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -879295043:
                        if (attributeName.equals("textDecoration")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -734428249:
                        if (attributeName.equals("fontWeight")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3355:
                        if (attributeName.equals("id")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 94842723:
                        if (attributeName.equals("color")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 365601008:
                        if (attributeName.equals("fontSize")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1287124693:
                        if (attributeName.equals("backgroundColor")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        if ("style".equals(xmlPullParser.getName())) {
                            eVar = z(eVar);
                            eVar.u(attributeValue);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        eVar = z(eVar);
                        try {
                            eVar.o(c.i.b.a.i0.d.d(attributeValue));
                            break;
                        } catch (IllegalArgumentException unused) {
                            String str = "Failed parsing background value: " + attributeValue;
                            break;
                        }
                    case 2:
                        eVar = z(eVar);
                        try {
                            eVar.q(c.i.b.a.i0.d.d(attributeValue));
                            break;
                        } catch (IllegalArgumentException unused2) {
                            String str2 = "Failed parsing color value: " + attributeValue;
                            break;
                        }
                    case 3:
                        eVar = z(eVar);
                        eVar.r(attributeValue);
                        break;
                    case 4:
                        try {
                            eVar = z(eVar);
                            C(attributeValue, eVar);
                            break;
                        } catch (SubtitleDecoderException unused3) {
                            String str3 = "Failed parsing fontSize value: " + attributeValue;
                            break;
                        }
                    case 5:
                        eVar = z(eVar);
                        eVar.p(SpanItem.STYLE_BOLD.equalsIgnoreCase(attributeValue));
                        break;
                    case 6:
                        eVar = z(eVar);
                        eVar.v(SpanItem.STYLE_ITALIC.equalsIgnoreCase(attributeValue));
                        break;
                    case 7:
                        String J = v.J(attributeValue);
                        switch (J.hashCode()) {
                            case -1364013995:
                                if (J.equals(TextAlign.CENTER)) {
                                    c3 = 4;
                                    break;
                                }
                                break;
                            case 100571:
                                if (J.equals("end")) {
                                    c3 = 3;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (J.equals("left")) {
                                    c3 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (J.equals("right")) {
                                    c3 = 2;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (J.equals("start")) {
                                    c3 = 1;
                                    break;
                                }
                                break;
                        }
                        if (c3 != 0) {
                            if (c3 != 1) {
                                if (c3 != 2) {
                                    if (c3 != 3) {
                                        if (c3 != 4) {
                                            break;
                                        } else {
                                            eVar = z(eVar);
                                            eVar.x(Layout.Alignment.ALIGN_CENTER);
                                            break;
                                        }
                                    } else {
                                        eVar = z(eVar);
                                        eVar.x(Layout.Alignment.ALIGN_OPPOSITE);
                                        break;
                                    }
                                } else {
                                    eVar = z(eVar);
                                    eVar.x(Layout.Alignment.ALIGN_OPPOSITE);
                                    break;
                                }
                            } else {
                                eVar = z(eVar);
                                eVar.x(Layout.Alignment.ALIGN_NORMAL);
                                break;
                            }
                        } else {
                            eVar = z(eVar);
                            eVar.x(Layout.Alignment.ALIGN_NORMAL);
                            break;
                        }
                    case '\b':
                        String J2 = v.J(attributeValue);
                        switch (J2.hashCode()) {
                            case -1461280213:
                                if (J2.equals("nounderline")) {
                                    c3 = 3;
                                    break;
                                }
                                break;
                            case -1026963764:
                                if (J2.equals("underline")) {
                                    c3 = 2;
                                    break;
                                }
                                break;
                            case 913457136:
                                if (J2.equals("nolinethrough")) {
                                    c3 = 1;
                                    break;
                                }
                                break;
                            case 1679736913:
                                if (J2.equals("linethrough")) {
                                    c3 = 0;
                                    break;
                                }
                                break;
                        }
                        if (c3 != 0) {
                            if (c3 != 1) {
                                if (c3 != 2) {
                                    if (c3 != 3) {
                                        break;
                                    } else {
                                        eVar = z(eVar);
                                        eVar.y(false);
                                        break;
                                    }
                                } else {
                                    eVar = z(eVar);
                                    eVar.y(true);
                                    break;
                                }
                            } else {
                                eVar = z(eVar);
                                eVar.w(false);
                                break;
                            }
                        } else {
                            eVar = z(eVar);
                            eVar.w(true);
                            break;
                        }
                }
            }
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public final String[] I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? str.split("\\s+") : (String[]) invokeL.objValue;
    }

    public final e z(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar)) == null) ? eVar == null ? new e() : eVar : (e) invokeL.objValue;
    }
}
