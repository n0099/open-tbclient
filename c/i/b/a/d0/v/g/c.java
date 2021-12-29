package c.i.b.a.d0.v.g;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.v.g.h;
import c.i.b.a.h0.o;
import c.i.b.a.i0.u;
import c.i.b.a.i0.v;
import c.i.b.a.i0.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.alipay.Result;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
import com.coremedia.iso.boxes.sampleentry.SubtitleSampleEntry;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.aspectj.lang.JoinPoint;
import org.webrtc.MediaStreamTrack;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes9.dex */
public class c extends DefaultHandler implements o.a<b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f30175c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f30176d;

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f30177e;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final XmlPullParserFactory f30178b;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Format a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30179b;

        /* renamed from: c  reason: collision with root package name */
        public final h f30180c;

        /* renamed from: d  reason: collision with root package name */
        public final String f30181d;

        /* renamed from: e  reason: collision with root package name */
        public final ArrayList<DrmInitData.SchemeData> f30182e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayList<d> f30183f;

        public a(Format format, String str, h hVar, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<d> arrayList2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {format, str, hVar, str2, arrayList, arrayList2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = format;
            this.f30179b = str;
            this.f30180c = hVar;
            this.f30181d = str2;
            this.f30182e = arrayList;
            this.f30183f = arrayList2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(750914051, "Lc/i/b/a/d0/v/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(750914051, "Lc/i/b/a/d0/v/g/c;");
                return;
            }
        }
        f30175c = Pattern.compile("(\\d+)(?:/(\\d+))?");
        f30176d = Pattern.compile("CC([1-4])=.*");
        f30177e = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static long B(XmlPullParser xmlPullParser, String str, long j2) throws ParserException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{xmlPullParser, str, Long.valueOf(j2)})) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? j2 : v.D(attributeValue);
        }
        return invokeCommon.longValue;
    }

    public static d C(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xmlPullParser, str)) == null) {
            String T = T(xmlPullParser, "schemeIdUri", "");
            String T2 = T(xmlPullParser, "value", null);
            String T3 = T(xmlPullParser, "id", null);
            do {
                xmlPullParser.next();
            } while (!w.c(xmlPullParser, str));
            return new d(T, T2, T3);
        }
        return (d) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int D(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, xmlPullParser)) == null) {
            String J = v.J(xmlPullParser.getAttributeValue(null, "value"));
            if (J == null) {
                return -1;
            }
            switch (J.hashCode()) {
                case 1596796:
                    if (J.equals(Result.RESULT_FAILED)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2937391:
                    if (J.equals("a000")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3094035:
                    if (J.equals("f801")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3133436:
                    if (J.equals("fa01")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return c2 != 3 ? -1 : 8;
                    }
                    return 6;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static long E(XmlPullParser xmlPullParser, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{xmlPullParser, str, Long.valueOf(j2)})) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? j2 : v.E(attributeValue);
        }
        return invokeCommon.longValue;
    }

    public static float F(XmlPullParser xmlPullParser, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65543, null, xmlPullParser, f2)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
            if (attributeValue != null) {
                Matcher matcher = f30175c.matcher(attributeValue);
                if (matcher.matches()) {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    String group = matcher.group(2);
                    return !TextUtils.isEmpty(group) ? parseInt / Integer.parseInt(group) : parseInt;
                }
                return f2;
            }
            return f2;
        }
        return invokeLF.floatValue;
    }

    public static int H(XmlPullParser xmlPullParser, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, xmlPullParser, str, i2)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? i2 : Integer.parseInt(attributeValue);
        }
        return invokeLLI.intValue;
    }

    public static long I(XmlPullParser xmlPullParser, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{xmlPullParser, str, Long.valueOf(j2)})) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? j2 : Long.parseLong(attributeValue);
        }
        return invokeCommon.longValue;
    }

    public static String T(XmlPullParser xmlPullParser, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, xmlPullParser, str, str2)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue == null ? str2 : attributeValue;
        }
        return (String) invokeLLL.objValue;
    }

    public static int m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i2, i3)) == null) {
            if (i2 == -1) {
                return i3;
            }
            if (i3 == -1) {
                return i2;
            }
            c.i.b.a.i0.a.f(i2 == i3);
            return i2;
        }
        return invokeII.intValue;
    }

    public static String n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if (str == null) {
                return str2;
            }
            if (str2 == null) {
                return str;
            }
            c.i.b.a.i0.a.f(str.equals(str2));
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void o(ArrayList<DrmInitData.SchemeData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, arrayList) == null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                DrmInitData.SchemeData schemeData = arrayList.get(size);
                if (!schemeData.hasData()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        } else if (arrayList.get(i2).canReplace(schemeData)) {
                            arrayList.remove(size);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
    }

    public static String q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            if (c.i.b.a.i0.i.g(str)) {
                return c.i.b.a.i0.i.a(str2);
            }
            if (c.i.b.a.i0.i.i(str)) {
                return c.i.b.a.i0.i.f(str2);
            }
            if (r(str)) {
                return str;
            }
            if ("application/mp4".equals(str)) {
                if (SubtitleSampleEntry.TYPE1.equals(str2)) {
                    return "application/ttml+xml";
                }
                if ("wvtt".equals(str2)) {
                    return "application/x-mp4-vtt";
                }
            } else if ("application/x-rawcc".equals(str) && str2 != null) {
                if (str2.contains("cea708")) {
                    return "application/cea-708";
                }
                if (str2.contains("eia608") || str2.contains("cea608")) {
                    return "application/cea-608";
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) ? c.i.b.a.i0.i.h(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str) : invokeL.booleanValue;
    }

    public static String w(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, xmlPullParser, str)) == null) {
            xmlPullParser.next();
            return u.c(str, xmlPullParser.getText());
        }
        return (String) invokeLL.objValue;
    }

    public static int x(List<d> list) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                d dVar = list.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.a) && (str = dVar.f30184b) != null) {
                    Matcher matcher = f30176d.matcher(str);
                    if (matcher.matches()) {
                        return Integer.parseInt(matcher.group(1));
                    }
                    String str2 = "Unable to parse CEA-608 channel number from: " + dVar.f30184b;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int y(List<d> list) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                d dVar = list.get(i2);
                if ("urn:scte:dash:cc:cea-708:2015".equals(dVar.a) && (str = dVar.f30184b) != null) {
                    Matcher matcher = f30177e.matcher(str);
                    if (matcher.matches()) {
                        return Integer.parseInt(matcher.group(1));
                    }
                    String str2 = "Unable to parse CEA-708 service block number from: " + dVar.f30184b;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int A(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xmlPullParser)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
            if (TextUtils.isEmpty(attributeValue)) {
                return -1;
            }
            if (MediaStreamTrack.AUDIO_TRACK_KIND.equals(attributeValue)) {
                return 1;
            }
            if ("video".equals(attributeValue)) {
                return 2;
            }
            return "text".equals(attributeValue) ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public f G(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xmlPullParser)) == null) ? L(xmlPullParser, "sourceURL", "range") : (f) invokeL.objValue;
    }

    public b J(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, xmlPullParser, str)) != null) {
            return (b) invokeLL.objValue;
        }
        long B = B(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long E = E(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long E2 = E(xmlPullParser, "minBufferTime", -9223372036854775807L);
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        boolean z = attributeValue != null && attributeValue.equals("dynamic");
        long E3 = z ? E(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long E4 = z ? E(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long E5 = z ? E(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        long j2 = z ? -9223372036854775807L : 0L;
        boolean z2 = false;
        boolean z3 = false;
        Uri uri = null;
        String str2 = str;
        k kVar2 = null;
        while (true) {
            xmlPullParser.next();
            if (w.e(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    str2 = w(xmlPullParser, str2);
                    kVar = kVar2;
                    z2 = true;
                }
                kVar = kVar2;
                str2 = str2;
                j2 = j2;
            } else if (w.e(xmlPullParser, "UTCTiming")) {
                kVar = V(xmlPullParser);
            } else {
                if (w.e(xmlPullParser, "Location")) {
                    uri = Uri.parse(xmlPullParser.nextText());
                } else {
                    if (w.e(xmlPullParser, "Period") && !z3) {
                        Pair<e, Long> K = K(xmlPullParser, str2, j2);
                        String str3 = str2;
                        e eVar = (e) K.first;
                        long j3 = j2;
                        if (eVar.f30186b != -9223372036854775807L) {
                            long longValue = ((Long) K.second).longValue();
                            long j4 = longValue == -9223372036854775807L ? -9223372036854775807L : eVar.f30186b + longValue;
                            arrayList.add(eVar);
                            j2 = j4;
                            str2 = str3;
                        } else if (!z) {
                            throw new ParserException("Unable to determine start of period " + arrayList.size());
                        } else {
                            kVar = kVar2;
                            str2 = str3;
                            j2 = j3;
                            z3 = true;
                        }
                    }
                    kVar = kVar2;
                    str2 = str2;
                    j2 = j2;
                }
                kVar = kVar2;
            }
            if (w.c(xmlPullParser, "MPD")) {
                if (E == -9223372036854775807L) {
                    if (j2 != -9223372036854775807L) {
                        E = j2;
                    } else if (!z) {
                        throw new ParserException("Unable to determine duration of static manifest.");
                    }
                }
                if (!arrayList.isEmpty()) {
                    return d(B, E, E2, z, E3, E4, E5, kVar, uri, arrayList);
                }
                throw new ParserException("No periods found.");
            }
            kVar2 = kVar;
        }
    }

    public Pair<e, Long> K(XmlPullParser xmlPullParser, String str, long j2) throws XmlPullParserException, IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{xmlPullParser, str, Long.valueOf(j2)})) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "id");
            long E = E(xmlPullParser, "start", j2);
            long E2 = E(xmlPullParser, "duration", -9223372036854775807L);
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            h hVar = null;
            do {
                xmlPullParser.next();
                if (w.e(xmlPullParser, "BaseURL")) {
                    if (!z) {
                        str = w(xmlPullParser, str);
                        z = true;
                    }
                } else if (w.e(xmlPullParser, "AdaptationSet")) {
                    arrayList.add(t(xmlPullParser, str, hVar));
                } else if (w.e(xmlPullParser, "SegmentBase")) {
                    hVar = O(xmlPullParser, null);
                } else if (w.e(xmlPullParser, "SegmentList")) {
                    hVar = P(xmlPullParser, null);
                } else if (w.e(xmlPullParser, "SegmentTemplate")) {
                    hVar = Q(xmlPullParser, null);
                }
            } while (!w.c(xmlPullParser, "Period"));
            return Pair.create(e(attributeValue, E, arrayList), Long.valueOf(E2));
        }
        return (Pair) invokeCommon.objValue;
    }

    public f L(XmlPullParser xmlPullParser, String str, String str2) {
        InterceptResult invokeLLL;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, xmlPullParser, str, str2)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
            if (attributeValue2 != null) {
                String[] split = attributeValue2.split("-");
                j2 = Long.parseLong(split[0]);
                if (split.length == 2) {
                    j3 = (Long.parseLong(split[1]) - j2) + 1;
                    return f(attributeValue, j2, j3);
                }
            } else {
                j2 = 0;
            }
            j3 = -1;
            return f(attributeValue, j2, j3);
        }
        return (f) invokeLLL.objValue;
    }

    public a M(XmlPullParser xmlPullParser, String str, String str2, String str3, int i2, int i3, float f2, int i4, int i5, String str4, int i6, List<d> list, h hVar) throws XmlPullParserException, IOException {
        InterceptResult invokeCommon;
        String str5;
        h Q;
        h hVar2;
        String str6;
        String str7;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{xmlPullParser, str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), str4, Integer.valueOf(i6), list, hVar})) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "id");
            int H = H(xmlPullParser, "bandwidth", -1);
            String T = T(xmlPullParser, "mimeType", str2);
            String T2 = T(xmlPullParser, "codecs", str3);
            int H2 = H(xmlPullParser, "width", i2);
            int H3 = H(xmlPullParser, "height", i3);
            float F = F(xmlPullParser, f2);
            int H4 = H(xmlPullParser, "audioSamplingRate", i5);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i7 = i4;
            h hVar3 = hVar;
            String str8 = null;
            boolean z2 = false;
            String str9 = str;
            while (true) {
                xmlPullParser.next();
                int i8 = i7;
                if (!w.e(xmlPullParser, "BaseURL")) {
                    if (w.e(xmlPullParser, "AudioChannelConfiguration")) {
                        i7 = v(xmlPullParser);
                        hVar2 = hVar3;
                        str6 = str8;
                    } else {
                        if (w.e(xmlPullParser, "SegmentBase")) {
                            Q = O(xmlPullParser, (h.e) hVar3);
                        } else if (w.e(xmlPullParser, "SegmentList")) {
                            Q = P(xmlPullParser, (h.b) hVar3);
                        } else if (w.e(xmlPullParser, "SegmentTemplate")) {
                            Q = Q(xmlPullParser, (h.c) hVar3);
                        } else {
                            if (w.e(xmlPullParser, "ContentProtection")) {
                                Pair<String, DrmInitData.SchemeData> z3 = z(xmlPullParser);
                                str5 = str9;
                                Object obj = z3.first;
                                if (obj != null) {
                                    str8 = (String) obj;
                                }
                                Object obj2 = z3.second;
                                if (obj2 != null) {
                                    arrayList.add(obj2);
                                }
                            } else {
                                str5 = str9;
                                if (w.e(xmlPullParser, "InbandEventStream")) {
                                    arrayList2.add(C(xmlPullParser, "InbandEventStream"));
                                }
                            }
                            i7 = i8;
                            hVar2 = hVar3;
                            str6 = str8;
                            z = z2;
                            str7 = str5;
                        }
                        hVar2 = Q;
                        str6 = str8;
                        i7 = i8;
                    }
                    boolean z4 = z2;
                    str7 = str9;
                    z = z4;
                } else if (z2) {
                    str5 = str9;
                    i7 = i8;
                    hVar2 = hVar3;
                    str6 = str8;
                    z = z2;
                    str7 = str5;
                } else {
                    i7 = i8;
                    str7 = w(xmlPullParser, str9);
                    hVar2 = hVar3;
                    str6 = str8;
                    z = true;
                }
                if (w.c(xmlPullParser, "Representation")) {
                    break;
                }
                hVar3 = hVar2;
                str8 = str6;
                String str10 = str7;
                z2 = z;
                str9 = str10;
            }
            return new a(c(attributeValue, T, H2, H3, F, i7, H4, H, str4, i6, list, T2), str7, hVar2 != null ? hVar2 : new h.e(), str6, arrayList, arrayList2);
        }
        return (a) invokeCommon.objValue;
    }

    public int N(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xmlPullParser)) == null) {
            String T = T(xmlPullParser, "schemeIdUri", null);
            String T2 = T(xmlPullParser, "value", null);
            do {
                xmlPullParser.next();
            } while (!w.c(xmlPullParser, "Role"));
            return ("urn:mpeg:dash:role:2011".equals(T) && "main".equals(T2)) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    public h.e O(XmlPullParser xmlPullParser, h.e eVar) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, xmlPullParser, eVar)) == null) {
            long I = I(xmlPullParser, "timescale", eVar != null ? eVar.f30199b : 1L);
            long I2 = I(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f30200c : 0L);
            long j4 = eVar != null ? eVar.f30208d : 0L;
            long j5 = eVar != null ? eVar.f30209e : 0L;
            String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
            if (attributeValue != null) {
                String[] split = attributeValue.split("-");
                long parseLong = Long.parseLong(split[0]);
                j2 = (Long.parseLong(split[1]) - parseLong) + 1;
                j3 = parseLong;
            } else {
                j2 = j5;
                j3 = j4;
            }
            f fVar = eVar != null ? eVar.a : null;
            do {
                xmlPullParser.next();
                if (w.e(xmlPullParser, "Initialization")) {
                    fVar = G(xmlPullParser);
                }
            } while (!w.c(xmlPullParser, "SegmentBase"));
            return k(fVar, I, I2, j3, j2);
        }
        return (h.e) invokeLL.objValue;
    }

    public h.b P(XmlPullParser xmlPullParser, h.b bVar) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xmlPullParser, bVar)) == null) {
            long I = I(xmlPullParser, "timescale", bVar != null ? bVar.f30199b : 1L);
            long I2 = I(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f30200c : 0L);
            long I3 = I(xmlPullParser, "duration", bVar != null ? bVar.f30202e : -9223372036854775807L);
            int H = H(xmlPullParser, "startNumber", bVar != null ? bVar.f30201d : 1);
            List<f> list = null;
            f fVar = null;
            List<h.d> list2 = null;
            do {
                xmlPullParser.next();
                if (w.e(xmlPullParser, "Initialization")) {
                    fVar = G(xmlPullParser);
                } else if (w.e(xmlPullParser, "SegmentTimeline")) {
                    list2 = R(xmlPullParser);
                } else if (w.e(xmlPullParser, "SegmentURL")) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(S(xmlPullParser));
                }
            } while (!w.c(xmlPullParser, "SegmentList"));
            if (bVar != null) {
                if (fVar == null) {
                    fVar = bVar.a;
                }
                if (list2 == null) {
                    list2 = bVar.f30203f;
                }
                if (list == null) {
                    list = bVar.f30204g;
                }
            }
            return h(fVar, I, I2, H, I3, list2, list);
        }
        return (h.b) invokeLL.objValue;
    }

    public h.c Q(XmlPullParser xmlPullParser, h.c cVar) throws XmlPullParserException, IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, xmlPullParser, cVar)) == null) {
            long I = I(xmlPullParser, "timescale", cVar != null ? cVar.f30199b : 1L);
            long I2 = I(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f30200c : 0L);
            long I3 = I(xmlPullParser, "duration", cVar != null ? cVar.f30202e : -9223372036854775807L);
            int H = H(xmlPullParser, "startNumber", cVar != null ? cVar.f30201d : 1);
            f fVar = null;
            j U = U(xmlPullParser, VodClient.PATH_MEDIA, cVar != null ? cVar.f30206h : null);
            j U2 = U(xmlPullParser, JoinPoint.INITIALIZATION, cVar != null ? cVar.f30205g : null);
            List<h.d> list = null;
            do {
                xmlPullParser.next();
                if (w.e(xmlPullParser, "Initialization")) {
                    fVar = G(xmlPullParser);
                } else if (w.e(xmlPullParser, "SegmentTimeline")) {
                    list = R(xmlPullParser);
                }
            } while (!w.c(xmlPullParser, "SegmentTemplate"));
            if (cVar != null) {
                if (fVar == null) {
                    fVar = cVar.a;
                }
                if (list == null) {
                    list = cVar.f30203f;
                }
            }
            return i(fVar, I, I2, H, I3, list, U2, U);
        }
        return (h.c) invokeLL.objValue;
    }

    public List<h.d> R(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, xmlPullParser)) == null) {
            ArrayList arrayList = new ArrayList();
            long j2 = 0;
            do {
                xmlPullParser.next();
                if (w.e(xmlPullParser, "S")) {
                    j2 = I(xmlPullParser, "t", j2);
                    long I = I(xmlPullParser, "d", -9223372036854775807L);
                    int H = H(xmlPullParser, "r", 0) + 1;
                    for (int i2 = 0; i2 < H; i2++) {
                        arrayList.add(j(j2, I));
                        j2 += I;
                    }
                }
            } while (!w.c(xmlPullParser, "SegmentTimeline"));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public f S(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, xmlPullParser)) == null) ? L(xmlPullParser, VodClient.PATH_MEDIA, "mediaRange") : (f) invokeL.objValue;
    }

    public j U(XmlPullParser xmlPullParser, String str, j jVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, xmlPullParser, str, jVar)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? j.b(attributeValue) : jVar;
        }
        return (j) invokeLLL.objValue;
    }

    public k V(XmlPullParser xmlPullParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, xmlPullParser)) == null) ? l(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value")) : (k) invokeL.objValue;
    }

    public c.i.b.a.d0.v.g.a b(int i2, int i3, List<g> list, List<d> list2, List<d> list3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), list, list2, list3})) == null) ? new c.i.b.a.d0.v.g.a(i2, i3, list, list2, list3) : (c.i.b.a.d0.v.g.a) invokeCommon.objValue;
    }

    public Format c(String str, String str2, int i2, int i3, float f2, int i4, int i5, int i6, String str3, int i7, List<d> list, String str4) {
        InterceptResult invokeCommon;
        int i8;
        int y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str3, Integer.valueOf(i7), list, str4})) == null) {
            String q = q(str2, str4);
            if (q != null) {
                if (c.i.b.a.i0.i.i(q)) {
                    return Format.createVideoContainerFormat(str, str2, q, str4, i6, i2, i3, f2, null, i7);
                }
                if (c.i.b.a.i0.i.g(q)) {
                    return Format.createAudioContainerFormat(str, str2, q, str4, i6, i4, i5, null, i7, str3);
                }
                if (r(q)) {
                    if ("application/cea-608".equals(q)) {
                        y = x(list);
                    } else if ("application/cea-708".equals(q)) {
                        y = y(list);
                    } else {
                        i8 = -1;
                        return Format.createTextContainerFormat(str, str2, q, str4, i6, i7, str3, i8);
                    }
                    i8 = y;
                    return Format.createTextContainerFormat(str, str2, q, str4, i6, i7, str3, i8);
                }
            }
            return Format.createContainerFormat(str, str2, q, str4, i6, i7, str3);
        }
        return (Format) invokeCommon.objValue;
    }

    public b d(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, k kVar, Uri uri, List<e> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), kVar, uri, list})) == null) ? new b(j2, j3, j4, z, j5, j6, j7, kVar, uri, list) : (b) invokeCommon.objValue;
    }

    public e e(String str, long j2, List<c.i.b.a.d0.v.g.a> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{str, Long.valueOf(j2), list})) == null) ? new e(str, j2, list) : (e) invokeCommon.objValue;
    }

    public f f(String str, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? new f(str, j2, j3) : (f) invokeCommon.objValue;
    }

    public g g(a aVar, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<d> arrayList2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048596, this, aVar, str, str2, arrayList, arrayList2)) == null) {
            Format format = aVar.a;
            String str3 = aVar.f30181d;
            if (str3 != null) {
                str2 = str3;
            }
            ArrayList<DrmInitData.SchemeData> arrayList3 = aVar.f30182e;
            arrayList3.addAll(arrayList);
            if (!arrayList3.isEmpty()) {
                o(arrayList3);
                format = format.copyWithDrmInitData(new DrmInitData(str2, arrayList3));
            }
            ArrayList<d> arrayList4 = aVar.f30183f;
            arrayList4.addAll(arrayList2);
            return g.l(str, -1L, format, aVar.f30179b, aVar.f30180c, arrayList4);
        }
        return (g) invokeLLLLL.objValue;
    }

    public h.b h(f fVar, long j2, long j3, int i2, long j4, List<h.d> list, List<f> list2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{fVar, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), list, list2})) == null) ? new h.b(fVar, j2, j3, i2, j4, list, list2) : (h.b) invokeCommon.objValue;
    }

    public h.c i(f fVar, long j2, long j3, int i2, long j4, List<h.d> list, j jVar, j jVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{fVar, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), list, jVar, jVar2})) == null) ? new h.c(fVar, j2, j3, i2, j4, list, jVar, jVar2) : (h.c) invokeCommon.objValue;
    }

    public h.d j(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? new h.d(j2, j3) : (h.d) invokeCommon.objValue;
    }

    public h.e k(f fVar, long j2, long j3, long j4, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{fVar, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)})) == null) ? new h.e(fVar, j2, j3, j4, j5) : (h.e) invokeCommon.objValue;
    }

    public k l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) ? new k(str, str2) : (k) invokeLL.objValue;
    }

    public int p(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, format)) == null) {
            String str = format.sampleMimeType;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (c.i.b.a.i0.i.i(str)) {
                return 2;
            }
            if (c.i.b.a.i0.i.g(str)) {
                return 1;
            }
            return r(str) ? 3 : -1;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.h0.o.a
    /* renamed from: s */
    public b a(Uri uri, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, uri, inputStream)) == null) {
            try {
                XmlPullParser newPullParser = this.f30178b.newPullParser();
                newPullParser.setInput(inputStream, null);
                if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                    return J(newPullParser, uri.toString());
                }
                throw new ParserException("inputStream does not contain a valid media presentation description");
            } catch (XmlPullParserException e2) {
                throw new ParserException(e2);
            }
        }
        return (b) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v46, types: [java.lang.Object] */
    public c.i.b.a.d0.v.g.a t(XmlPullParser xmlPullParser, String str, h hVar) throws XmlPullParserException, IOException {
        InterceptResult invokeLLL;
        String str2;
        String str3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList<DrmInitData.SchemeData> arrayList4;
        String str4;
        String str5;
        XmlPullParser xmlPullParser2;
        int i2;
        ArrayList<d> arrayList5;
        h Q;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, xmlPullParser, str, hVar)) == null) {
            XmlPullParser xmlPullParser3 = xmlPullParser;
            int H = H(xmlPullParser3, "id", -1);
            int A = A(xmlPullParser);
            String str6 = null;
            String attributeValue = xmlPullParser3.getAttributeValue(null, "mimeType");
            String attributeValue2 = xmlPullParser3.getAttributeValue(null, "codecs");
            int H2 = H(xmlPullParser3, "width", -1);
            int H3 = H(xmlPullParser3, "height", -1);
            float F = F(xmlPullParser3, -1.0f);
            int H4 = H(xmlPullParser3, "audioSamplingRate", -1);
            String str7 = "lang";
            String attributeValue3 = xmlPullParser3.getAttributeValue(null, "lang");
            ArrayList<DrmInitData.SchemeData> arrayList6 = new ArrayList<>();
            ArrayList<d> arrayList7 = new ArrayList<>();
            ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            ArrayList arrayList10 = new ArrayList();
            String str8 = str;
            h hVar2 = hVar;
            int i4 = A;
            String str9 = attributeValue3;
            String str10 = null;
            int i5 = -1;
            boolean z = false;
            int i6 = 0;
            while (true) {
                xmlPullParser.next();
                if (w.e(xmlPullParser3, "BaseURL")) {
                    if (!z) {
                        z = true;
                        str3 = w(xmlPullParser3, str8);
                        arrayList = arrayList10;
                        arrayList2 = arrayList9;
                        arrayList3 = arrayList8;
                        arrayList5 = arrayList7;
                        arrayList4 = arrayList6;
                        str4 = str7;
                        str5 = str6;
                        xmlPullParser2 = xmlPullParser3;
                        i3 = i4;
                    }
                    str2 = str9;
                    i2 = i4;
                    str3 = str8;
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList6;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    i3 = i2;
                    str9 = str2;
                } else {
                    if (w.e(xmlPullParser3, "ContentProtection")) {
                        Pair<String, DrmInitData.SchemeData> z2 = z(xmlPullParser);
                        Object obj = z2.first;
                        if (obj != null) {
                            str10 = (String) obj;
                        }
                        ?? r0 = z2.second;
                        if (r0 != 0) {
                            arrayList6.add(r0);
                        }
                    } else if (w.e(xmlPullParser3, "ContentComponent")) {
                        str9 = n(str9, xmlPullParser3.getAttributeValue(str6, str7));
                        str3 = str8;
                        arrayList = arrayList10;
                        arrayList2 = arrayList9;
                        arrayList3 = arrayList8;
                        arrayList5 = arrayList7;
                        arrayList4 = arrayList6;
                        str4 = str7;
                        str5 = str6;
                        i3 = m(i4, A(xmlPullParser));
                        xmlPullParser2 = xmlPullParser3;
                    } else if (w.e(xmlPullParser3, "Role")) {
                        i6 |= N(xmlPullParser);
                    } else if (w.e(xmlPullParser3, "AudioChannelConfiguration")) {
                        i5 = v(xmlPullParser);
                    } else {
                        if (w.e(xmlPullParser3, "Accessibility")) {
                            arrayList8.add(C(xmlPullParser3, "Accessibility"));
                        } else if (w.e(xmlPullParser3, "SupplementalProperty")) {
                            arrayList9.add(C(xmlPullParser3, "SupplementalProperty"));
                        } else if (w.e(xmlPullParser3, "Representation")) {
                            String str11 = str9;
                            str3 = str8;
                            arrayList2 = arrayList9;
                            arrayList3 = arrayList8;
                            arrayList4 = arrayList6;
                            str4 = str7;
                            str5 = str6;
                            a M = M(xmlPullParser, str8, attributeValue, attributeValue2, H2, H3, F, i5, H4, str11, i6, arrayList3, hVar2);
                            int m = m(i4, p(M.a));
                            arrayList = arrayList10;
                            arrayList.add(M);
                            i3 = m;
                            str9 = str11;
                            arrayList5 = arrayList7;
                            xmlPullParser2 = xmlPullParser;
                        } else {
                            str2 = str9;
                            str3 = str8;
                            arrayList = arrayList10;
                            arrayList2 = arrayList9;
                            arrayList3 = arrayList8;
                            ArrayList<d> arrayList11 = arrayList7;
                            arrayList4 = arrayList6;
                            str4 = str7;
                            str5 = str6;
                            xmlPullParser2 = xmlPullParser;
                            i2 = i4;
                            if (w.e(xmlPullParser2, "SegmentBase")) {
                                Q = O(xmlPullParser2, (h.e) hVar2);
                            } else if (w.e(xmlPullParser2, "SegmentList")) {
                                Q = P(xmlPullParser2, (h.b) hVar2);
                            } else if (w.e(xmlPullParser2, "SegmentTemplate")) {
                                Q = Q(xmlPullParser2, (h.c) hVar2);
                            } else {
                                if (w.e(xmlPullParser2, "InbandEventStream")) {
                                    arrayList5 = arrayList11;
                                    arrayList5.add(C(xmlPullParser2, "InbandEventStream"));
                                } else {
                                    arrayList5 = arrayList11;
                                    if (w.d(xmlPullParser)) {
                                        u(xmlPullParser);
                                    }
                                }
                                i3 = i2;
                                str9 = str2;
                            }
                            hVar2 = Q;
                            i3 = i2;
                            str9 = str2;
                            arrayList5 = arrayList11;
                        }
                        str2 = str9;
                        i2 = i4;
                        str3 = str8;
                        arrayList = arrayList10;
                        arrayList2 = arrayList9;
                        arrayList3 = arrayList8;
                        arrayList5 = arrayList7;
                        arrayList4 = arrayList6;
                        str4 = str7;
                        str5 = str6;
                        xmlPullParser2 = xmlPullParser3;
                        i3 = i2;
                        str9 = str2;
                    }
                    str3 = str8;
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList6;
                    str4 = str7;
                    str5 = str6;
                    xmlPullParser2 = xmlPullParser3;
                    i3 = i4;
                }
                if (w.c(xmlPullParser2, "AdaptationSet")) {
                    break;
                }
                xmlPullParser3 = xmlPullParser2;
                arrayList7 = arrayList5;
                i4 = i3;
                arrayList9 = arrayList2;
                arrayList8 = arrayList3;
                arrayList6 = arrayList4;
                str7 = str4;
                str6 = str5;
                arrayList10 = arrayList;
                str8 = str3;
            }
            ArrayList arrayList12 = new ArrayList(arrayList.size());
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                arrayList12.add(g((a) arrayList.get(i7), this.a, str10, arrayList4, arrayList5));
            }
            return b(H, i3, arrayList12, arrayList3, arrayList2);
        }
        return (c.i.b.a.d0.v.g.a) invokeLLL.objValue;
    }

    public void u(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, xmlPullParser) == null) {
        }
    }

    public int v(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, xmlPullParser)) == null) {
            String T = T(xmlPullParser, "schemeIdUri", null);
            int i2 = -1;
            if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(T)) {
                i2 = H(xmlPullParser, "value", -1);
            } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(T)) {
                i2 = D(xmlPullParser);
            }
            do {
                xmlPullParser.next();
            } while (!w.c(xmlPullParser, "AudioChannelConfiguration"));
            return i2;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<String, DrmInitData.SchemeData> z(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        InterceptResult invokeL;
        UUID uuid;
        byte[] bArr;
        boolean z;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, xmlPullParser)) == null) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
            if (attributeValue != null) {
                String J = v.J(attributeValue);
                char c2 = 65535;
                int hashCode = J.hashCode();
                if (hashCode != 489446379) {
                    if (hashCode != 755418770) {
                        if (hashCode == 1812765994 && J.equals("urn:mpeg:dash:mp4protection:2011")) {
                            c2 = 0;
                        }
                    } else if (J.equals("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed")) {
                        c2 = 2;
                    }
                } else if (J.equals("urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
                    String attributeValue3 = xmlPullParser.getAttributeValue(null, "cenc:default_KID");
                    if (attributeValue3 == null || "00000000-0000-0000-0000-000000000000".equals(attributeValue3)) {
                        bArr2 = null;
                        bArr = attributeValue2;
                        z = false;
                        uuid = null;
                    } else {
                        byte[] b2 = c.i.b.a.a0.q.h.b(c.i.b.a.b.f29915c, new UUID[]{UUID.fromString(attributeValue3)}, null);
                        z = false;
                        bArr = attributeValue2;
                        uuid = c.i.b.a.b.f29915c;
                        bArr2 = b2;
                    }
                    do {
                        xmlPullParser.next();
                        if (w.e(xmlPullParser, "widevine:license")) {
                        }
                    } while (!w.c(xmlPullParser, "ContentProtection"));
                    return Pair.create(bArr, uuid != null ? new DrmInitData.SchemeData(uuid, "video/mp4", bArr2, z) : null);
                }
                if (c2 == 1) {
                    uuid = c.i.b.a.b.f29917e;
                } else if (c2 == 2) {
                    uuid = c.i.b.a.b.f29916d;
                }
                bArr = null;
                bArr2 = bArr;
                z = false;
                do {
                    xmlPullParser.next();
                    if (w.e(xmlPullParser, "widevine:license")) {
                        String attributeValue4 = xmlPullParser.getAttributeValue(null, "robustness_level");
                        z = attributeValue4 != null && attributeValue4.startsWith("HW");
                    } else if (bArr2 == null) {
                        if (w.e(xmlPullParser, "cenc:pssh") && xmlPullParser.next() == 4) {
                            byte[] decode = Base64.decode(xmlPullParser.getText(), 0);
                            UUID d2 = c.i.b.a.a0.q.h.d(decode);
                            if (d2 == null) {
                                uuid = d2;
                                bArr2 = null;
                            } else {
                                bArr2 = decode;
                                uuid = d2;
                            }
                        } else if (uuid == c.i.b.a.b.f29917e && w.e(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                            bArr2 = c.i.b.a.a0.q.h.a(c.i.b.a.b.f29917e, Base64.decode(xmlPullParser.getText(), 0));
                        }
                    }
                } while (!w.c(xmlPullParser, "ContentProtection"));
                return Pair.create(bArr, uuid != null ? new DrmInitData.SchemeData(uuid, "video/mp4", bArr2, z) : null);
            }
            uuid = null;
            bArr = null;
            bArr2 = bArr;
            z = false;
            do {
                xmlPullParser.next();
                if (w.e(xmlPullParser, "widevine:license")) {
                }
            } while (!w.c(xmlPullParser, "ContentProtection"));
            return Pair.create(bArr, uuid != null ? new DrmInitData.SchemeData(uuid, "video/mp4", bArr2, z) : null);
        }
        return (Pair) invokeL.objValue;
    }

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = str;
        try {
            this.f30178b = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }
}
