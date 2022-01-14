package c.i.b.a.d0.w.o;

import android.net.Uri;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.w.o.a;
import c.i.b.a.d0.w.o.b;
import c.i.b.a.h0.o;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public final class d implements o.a<c> {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f29340b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f29341c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f29342d;

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f29343e;

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f29344f;

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f29345g;

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f29346h;

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f29347i;

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f29348j;
    public static final Pattern k;
    public static final Pattern l;
    public static final Pattern m;
    public static final Pattern n;
    public static final Pattern o;
    public static final Pattern p;
    public static final Pattern q;
    public static final Pattern r;
    public static final Pattern s;
    public static final Pattern t;
    public static final Pattern u;
    public static final Pattern v;
    public static final Pattern w;
    public static final Pattern x;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BufferedReader a;

        /* renamed from: b  reason: collision with root package name */
        public final Queue<String> f29349b;

        /* renamed from: c  reason: collision with root package name */
        public String f29350c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {queue, bufferedReader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29349b = queue;
            this.a = bufferedReader;
        }

        public boolean a() throws IOException {
            InterceptResult invokeV;
            String trim;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f29350c != null) {
                    return true;
                }
                if (!this.f29349b.isEmpty()) {
                    this.f29350c = this.f29349b.poll();
                    return true;
                }
                do {
                    String readLine = this.a.readLine();
                    this.f29350c = readLine;
                    if (readLine == null) {
                        return false;
                    }
                    trim = readLine.trim();
                    this.f29350c = trim;
                } while (trim.isEmpty());
                return true;
            }
            return invokeV.booleanValue;
        }

        public String b() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (a()) {
                    String str = this.f29350c;
                    this.f29350c = null;
                    return str;
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(779781561, "Lc/i/b/a/d0/w/o/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(779781561, "Lc/i/b/a/d0/w/o/d;");
                return;
            }
        }
        a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
        f29340b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
        f29341c = Pattern.compile("CODECS=\"(.+?)\"");
        f29342d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
        f29343e = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
        f29344f = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
        f29345g = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
        f29346h = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
        f29347i = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
        f29348j = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
        k = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
        l = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
        m = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
        n = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES)");
        o = Pattern.compile("KEYFORMAT=\"(.+?)\"");
        p = Pattern.compile("URI=\"(.+?)\"");
        q = Pattern.compile("IV=([^,.*]+)");
        r = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
        s = Pattern.compile("LANGUAGE=\"(.+?)\"");
        t = Pattern.compile("NAME=\"(.+?)\"");
        u = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
        v = c("AUTOSELECT");
        w = c("DEFAULT");
        x = c("FORCED");
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean b(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bufferedReader)) == null) {
            int read = bufferedReader.read();
            if (read == 239) {
                if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                    return false;
                }
                read = bufferedReader.read();
            }
            int n2 = n(bufferedReader, true, read);
            for (int i2 = 0; i2 < 7; i2++) {
                if (n2 != "#EXTM3U".charAt(i2)) {
                    return false;
                }
                n2 = bufferedReader.read();
            }
            return v.z(n(bufferedReader, false, n2));
        }
        return invokeL.booleanValue;
    }

    public static Pattern c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return Pattern.compile(str + "=(NO|YES" + SmallTailInfo.EMOTION_SUFFIX);
        }
        return (Pattern) invokeL.objValue;
    }

    public static boolean e(String str, Pattern pattern, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, pattern, z)) == null) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(1).equals("YES") : z;
        }
        return invokeLLZ.booleanValue;
    }

    public static double f(String str, Pattern pattern) throws ParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, pattern)) == null) ? Double.parseDouble(l(str, pattern)) : invokeLL.doubleValue;
    }

    public static int g(String str, Pattern pattern) throws ParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, pattern)) == null) ? Integer.parseInt(l(str, pattern)) : invokeLL.intValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c.i.b.a.d0.w.o.a h(a aVar, String str) throws IOException {
        InterceptResult invokeLL;
        char c2;
        int parseInt;
        String str2;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, aVar, str)) == null) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = null;
            Format format = null;
            boolean z = false;
            while (aVar.a()) {
                String b2 = aVar.b();
                if (b2.startsWith("#EXT")) {
                    arrayList4.add(b2);
                }
                if (b2.startsWith("#EXT-X-MEDIA")) {
                    int k2 = k(b2);
                    String j2 = j(b2, p);
                    String l2 = l(b2, t);
                    String j3 = j(b2, s);
                    String l3 = l(b2, r);
                    int hashCode = l3.hashCode();
                    if (hashCode == -959297733) {
                        if (l3.equals("SUBTITLES")) {
                            c2 = 1;
                            if (c2 != 0) {
                            }
                        }
                        c2 = 65535;
                        if (c2 != 0) {
                        }
                    } else if (hashCode != -333210994) {
                        if (hashCode == 62628790 && l3.equals("AUDIO")) {
                            c2 = 0;
                            if (c2 != 0) {
                                Format createAudioContainerFormat = Format.createAudioContainerFormat(l2, "application/x-mpegURL", null, null, -1, -1, -1, null, k2, j3);
                                if (j2 == null) {
                                    format = createAudioContainerFormat;
                                } else {
                                    arrayList2.add(new a.C1659a(j2, createAudioContainerFormat));
                                }
                            } else if (c2 == 1) {
                                arrayList3.add(new a.C1659a(j2, Format.createTextContainerFormat(l2, "application/x-mpegURL", "text/vtt", null, -1, k2, j3)));
                            } else if (c2 == 2) {
                                String l4 = l(b2, u);
                                if (l4.startsWith("CC")) {
                                    parseInt = Integer.parseInt(l4.substring(2));
                                    str2 = "application/cea-608";
                                } else {
                                    parseInt = Integer.parseInt(l4.substring(7));
                                    str2 = "application/cea-708";
                                }
                                int i5 = parseInt;
                                String str3 = str2;
                                if (arrayList5 == null) {
                                    arrayList5 = new ArrayList();
                                }
                                arrayList5.add(Format.createTextContainerFormat(l2, null, str3, null, -1, k2, j3, i5));
                            }
                        }
                        c2 = 65535;
                        if (c2 != 0) {
                        }
                    } else {
                        if (l3.equals("CLOSED-CAPTIONS")) {
                            c2 = 2;
                            if (c2 != 0) {
                            }
                        }
                        c2 = 65535;
                        if (c2 != 0) {
                        }
                    }
                } else if (b2.startsWith("#EXT-X-STREAM-INF")) {
                    z |= b2.contains("CLOSED-CAPTIONS=NONE");
                    int g2 = g(b2, f29340b);
                    String j4 = j(b2, a);
                    if (j4 != null) {
                        g2 = Integer.parseInt(j4);
                    }
                    int i6 = g2;
                    String j5 = j(b2, f29341c);
                    String j6 = j(b2, f29342d);
                    if (j6 != null) {
                        String[] split = j6.split("x");
                        int parseInt2 = Integer.parseInt(split[0]);
                        int parseInt3 = Integer.parseInt(split[1]);
                        if (parseInt2 <= 0 || parseInt3 <= 0) {
                            parseInt2 = -1;
                            i4 = -1;
                        } else {
                            i4 = parseInt3;
                        }
                        i2 = parseInt2;
                        i3 = i4;
                    } else {
                        i2 = -1;
                        i3 = -1;
                    }
                    String j7 = j(b2, f29343e);
                    float parseFloat = j7 != null ? Float.parseFloat(j7) : -1.0f;
                    String b3 = aVar.b();
                    if (hashSet.add(b3)) {
                        arrayList.add(new a.C1659a(b3, Format.createVideoContainerFormat(Integer.toString(arrayList.size()), "application/x-mpegURL", null, j5, i6, i2, i3, parseFloat, null, 0)));
                    }
                }
            }
            return new c.i.b.a.d0.w.o.a(str, arrayList4, arrayList, arrayList2, arrayList3, format, z ? Collections.emptyList() : arrayList5);
        }
        return (c.i.b.a.d0.w.o.a) invokeLL.objValue;
    }

    public static b i(a aVar, String str) throws IOException {
        InterceptResult invokeLL;
        String hexString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, aVar, str)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            long j2 = -9223372036854775807L;
            long j3 = -9223372036854775807L;
            int i2 = 0;
            int i3 = 0;
            long j4 = 0;
            boolean z = false;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            boolean z2 = false;
            boolean z3 = false;
            DrmInitData drmInitData = null;
            b.a aVar2 = null;
            long j5 = 0;
            int i7 = 0;
            long j6 = -1;
            String str2 = null;
            long j7 = 0;
            String str3 = null;
            loop0: while (true) {
                long j8 = 0;
                while (aVar.a()) {
                    String b2 = aVar.b();
                    if (b2.startsWith("#EXT")) {
                        arrayList2.add(b2);
                    }
                    if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                        String l2 = l(b2, f29346h);
                        if ("VOD".equals(l2)) {
                            i3 = 1;
                        } else if ("EVENT".equals(l2)) {
                            i3 = 2;
                        }
                    } else if (b2.startsWith("#EXT-X-START")) {
                        j2 = (long) (f(b2, k) * 1000000.0d);
                    } else if (b2.startsWith("#EXT-X-MAP")) {
                        String l3 = l(b2, p);
                        String j9 = j(b2, m);
                        if (j9 != null) {
                            String[] split = j9.split("@");
                            j6 = Long.parseLong(split[0]);
                            if (split.length > 1) {
                                j5 = Long.parseLong(split[1]);
                            }
                        }
                        aVar2 = new b.a(l3, j5, j6);
                        j5 = 0;
                        j6 = -1;
                    } else if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                        j3 = 1000000 * g(b2, f29344f);
                    } else if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        i7 = g(b2, f29347i);
                        i5 = i7;
                    } else if (b2.startsWith("#EXT-X-VERSION")) {
                        i6 = g(b2, f29345g);
                    } else if (b2.startsWith("#EXTINF")) {
                        j8 = (long) (f(b2, f29348j) * 1000000.0d);
                    } else if (b2.startsWith("#EXT-X-KEY")) {
                        String l4 = l(b2, n);
                        String j10 = j(b2, o);
                        if (PolyActivity.NONE_PANEL_TYPE.equals(l4)) {
                            str2 = null;
                            str3 = null;
                        } else {
                            String j11 = j(b2, q);
                            if (!"identity".equals(j10) && j10 != null) {
                                DrmInitData.SchemeData m2 = m(b2, j10);
                                if (m2 != null) {
                                    drmInitData = new DrmInitData("SAMPLE-AES-CENC".equals(l4) ? "cenc" : "cbcs", m2);
                                }
                            } else if ("AES-128".equals(l4)) {
                                str2 = l(b2, p);
                                str3 = j11;
                            }
                            str3 = j11;
                            str2 = null;
                        }
                    } else if (b2.startsWith("#EXT-X-BYTERANGE")) {
                        String[] split2 = l(b2, l).split("@");
                        j6 = Long.parseLong(split2[0]);
                        if (split2.length > 1) {
                            j5 = Long.parseLong(split2[1]);
                        }
                    } else if (b2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                        i4 = Integer.parseInt(b2.substring(b2.indexOf(58) + 1));
                        z = true;
                    } else if (b2.equals("#EXT-X-DISCONTINUITY")) {
                        i2++;
                    } else if (b2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                        if (j4 == 0) {
                            j4 = c.i.b.a.b.a(v.D(b2.substring(b2.indexOf(58) + 1))) - j7;
                        }
                    } else if (!b2.startsWith("#")) {
                        if (str2 == null) {
                            hexString = null;
                        } else {
                            hexString = str3 != null ? str3 : Integer.toHexString(i7);
                        }
                        int i8 = i7 + 1;
                        int i9 = (j6 > (-1L) ? 1 : (j6 == (-1L) ? 0 : -1));
                        if (i9 == 0) {
                            j5 = 0;
                        }
                        arrayList.add(new b.a(b2, j8, i2, j7, str2, hexString, j5, j6));
                        j7 += j8;
                        if (i9 != 0) {
                            j5 += j6;
                        }
                        i7 = i8;
                        j6 = -1;
                    } else if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        z2 = true;
                    } else if (b2.equals("#EXT-X-ENDLIST")) {
                        z3 = true;
                    }
                }
                break loop0;
            }
            return new b(i3, str, arrayList2, j2, j4, z, i4, i5, i6, j3, z2, z3, j4 != 0, drmInitData, aVar2, arrayList);
        }
        return (b) invokeLL.objValue;
    }

    public static String j(String str, Pattern pattern) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, pattern)) == null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static int k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            return (e(str, w, false) ? 1 : 0) | (e(str, x, false) ? 2 : 0) | (e(str, v, false) ? 4 : 0);
        }
        return invokeL.intValue;
    }

    public static String l(String str, Pattern pattern) throws ParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, pattern)) == null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                return matcher.group(1);
            }
            throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
        }
        return (String) invokeLL.objValue;
    }

    public static DrmInitData.SchemeData m(String str, String str2) throws ParserException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
                String l2 = l(str, p);
                return new DrmInitData.SchemeData(c.i.b.a.b.f28994d, "video/mp4", Base64.decode(l2.substring(l2.indexOf(44)), 0));
            } else if ("com.widevine".equals(str2)) {
                try {
                    return new DrmInitData.SchemeData(c.i.b.a.b.f28994d, "hls", str.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    throw new ParserException(e2);
                }
            } else {
                return null;
            }
        }
        return (DrmInitData.SchemeData) invokeLL.objValue;
    }

    public static int n(BufferedReader bufferedReader, boolean z, int i2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{bufferedReader, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            while (i2 != -1 && Character.isWhitespace(i2) && (z || !v.z(i2))) {
                i2 = bufferedReader.read();
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.h0.o.a
    /* renamed from: d */
    public c a(Uri uri, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        String trim;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, inputStream)) == null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            ArrayDeque arrayDeque = new ArrayDeque();
            try {
                if (b(bufferedReader)) {
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            trim = readLine.trim();
                            if (!trim.isEmpty()) {
                                if (trim.startsWith("#EXT-X-STREAM-INF")) {
                                    arrayDeque.add(trim);
                                    return h(new a(arrayDeque, bufferedReader), uri.toString());
                                } else if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                } else {
                                    arrayDeque.add(trim);
                                }
                            }
                        } else {
                            v.i(bufferedReader);
                            throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                        }
                    }
                    arrayDeque.add(trim);
                    return i(new a(arrayDeque, bufferedReader), uri.toString());
                }
                throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
            } finally {
                v.i(bufferedReader);
            }
        }
        return (c) invokeLL.objValue;
    }
}
