package c.b.b.n.k;

import androidx.core.view.InputDeviceCompat;
import c.b.b.n.k.h;
import c.b.b.q.i0;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final C1636a f27246e;

    /* renamed from: f  reason: collision with root package name */
    public c.b.b.q.a<i> f27247f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27248g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27249h;

    /* renamed from: c.b.b.n.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1636a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f27250b;

        /* renamed from: c  reason: collision with root package name */
        public c.b.b.m.a f27251c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f27252d;

        /* renamed from: e  reason: collision with root package name */
        public float f27253e;

        /* renamed from: f  reason: collision with root package name */
        public float f27254f;

        /* renamed from: g  reason: collision with root package name */
        public float f27255g;

        /* renamed from: h  reason: collision with root package name */
        public float f27256h;

        /* renamed from: i  reason: collision with root package name */
        public float f27257i;

        /* renamed from: j  reason: collision with root package name */
        public float f27258j;
        public float k;
        public float l;
        public float m;
        public float n;
        public float o;
        public boolean p;
        public final b[][] q;
        public b r;
        public float s;
        public float t;
        public char[] u;
        public char[] v;

        public C1636a(c.b.b.m.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27258j = 1.0f;
            this.n = 1.0f;
            this.o = 1.0f;
            this.q = new b[128];
            this.t = 1.0f;
            this.u = new char[]{'x', 'e', 'a', 'o', 'n', 's', 'r', 'c', 'u', 'm', 'v', 'w', 'z'};
            this.v = new char[]{'M', 'N', 'B', 'D', 'C', 'E', 'F', 'K', 'A', 'G', 'H', 'I', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            this.f27251c = aVar;
            this.f27252d = z;
            e(aVar, z);
        }

        public b a() {
            InterceptResult invokeV;
            b[][] bVarArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                for (b[] bVarArr2 : this.q) {
                    if (bVarArr2 != null) {
                        for (b bVar : bVarArr2) {
                            if (bVar != null && bVar.f27262e != 0 && bVar.f27261d != 0) {
                                return bVar;
                            }
                        }
                        continue;
                    }
                }
                throw new GdxRuntimeException("No glyphs found.");
            }
            return (b) invokeV.objValue;
        }

        public b b(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Character.valueOf(c2)})) == null) {
                b[] bVarArr = this.q[c2 / 512];
                if (bVarArr != null) {
                    return bVarArr[c2 & 511];
                }
                return null;
            }
            return (b) invokeCommon.objValue;
        }

        public String c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f27250b[i2] : (String) invokeI.objValue;
        }

        public String[] d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27250b : (String[]) invokeV.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:118:0x02d5 A[Catch: Exception -> 0x0452, all -> 0x0476, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:121:0x02eb A[Catch: Exception -> 0x0452, all -> 0x0476, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:123:0x02f3 A[Catch: Exception -> 0x0452, all -> 0x0476, TRY_LEAVE, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:135:0x0340 A[Catch: Exception -> 0x0452, all -> 0x0476, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0357 A[Catch: Exception -> 0x0452, all -> 0x0476, TryCatch #1 {all -> 0x0476, blocks: (B:137:0x0348, B:140:0x0357, B:142:0x0371, B:145:0x0379, B:147:0x03c1, B:149:0x03da, B:151:0x03ed, B:152:0x03f0, B:154:0x03f6, B:155:0x0400, B:157:0x0404, B:159:0x0408, B:148:0x03cc, B:144:0x0376, B:116:0x02c9, B:106:0x02a5, B:108:0x02a9, B:110:0x02af, B:113:0x02b4, B:115:0x02c2, B:180:0x045d, B:181:0x0475, B:119:0x02dc, B:121:0x02eb, B:123:0x02f3, B:118:0x02d5, B:127:0x0307, B:133:0x032e, B:135:0x0340, B:160:0x0416, B:161:0x041f, B:162:0x0420, B:163:0x0429, B:164:0x042a, B:165:0x0433, B:166:0x0434, B:167:0x043d, B:168:0x043e, B:169:0x0447, B:170:0x0448, B:171:0x0451), top: B:193:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:208:0x0352 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:220:0x0343 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00dc A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0213 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0231 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0250 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0262 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0276 A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x028a A[Catch: all -> 0x0454, Exception -> 0x0459, TryCatch #7 {Exception -> 0x0459, all -> 0x0454, blocks: (B:7:0x0020, B:9:0x0026, B:11:0x0047, B:13:0x0079, B:15:0x0084, B:17:0x008e, B:19:0x00a7, B:21:0x00b7, B:23:0x00bb, B:25:0x00c5, B:28:0x00d5, B:30:0x00dc, B:32:0x00e2, B:34:0x00f2, B:35:0x00f6, B:38:0x00fd, B:39:0x0113, B:42:0x0116, B:43:0x012c, B:44:0x012d, B:46:0x013d, B:47:0x015d, B:48:0x0164, B:49:0x0165, B:50:0x016c, B:51:0x016d, B:52:0x0170, B:56:0x017e, B:59:0x0187, B:61:0x018d, B:62:0x0194, B:68:0x01a5, B:70:0x01ab, B:72:0x020d, B:74:0x0213, B:76:0x0222, B:77:0x0226, B:78:0x022d, B:80:0x0231, B:81:0x0243, B:83:0x0250, B:86:0x025b, B:88:0x0262, B:89:0x0266, B:91:0x0276, B:94:0x0281, B:97:0x028a, B:99:0x0290, B:102:0x029b, B:65:0x019b), top: B:193:0x0020, inners: #2 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void e(c.b.b.m.a aVar, boolean z) {
            String[] split;
            int i2;
            int i3;
            String readLine;
            String readLine2;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            b b2;
            int length;
            int i4;
            b bVar;
            int length2;
            int i5;
            b bVar2;
            b bVar3;
            BufferedReader bufferedReader;
            b[][] bVarArr;
            BufferedReader bufferedReader2;
            b[] bVarArr2;
            StringTokenizer stringTokenizer;
            int parseInt;
            b b3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048580, this, aVar, z) == null) {
                if (this.f27250b == null) {
                    this.a = aVar.h();
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(aVar.m()), 512);
                    try {
                        try {
                            String readLine3 = bufferedReader3.readLine();
                            try {
                                if (readLine3 != null) {
                                    String substring = readLine3.substring(readLine3.indexOf("padding=") + 8);
                                    if (substring.substring(0, substring.indexOf(32)).split(",", 4).length == 4) {
                                        this.f27253e = Integer.parseInt(split[0]);
                                        boolean z2 = true;
                                        this.f27254f = Integer.parseInt(split[1]);
                                        this.f27255g = Integer.parseInt(split[2]);
                                        this.f27256h = Integer.parseInt(split[3]);
                                        float f8 = this.f27253e + this.f27255g;
                                        String readLine4 = bufferedReader3.readLine();
                                        if (readLine4 != null) {
                                            String[] split2 = readLine4.split(" ", 9);
                                            if (split2.length >= 3) {
                                                if (split2[1].startsWith("lineHeight=")) {
                                                    this.f27257i = Integer.parseInt(split2[1].substring(11));
                                                    if (split2[2].startsWith("base=")) {
                                                        float parseInt2 = Integer.parseInt(split2[2].substring(5));
                                                        if (split2.length >= 6 && split2[5] != null && split2[5].startsWith("pages=")) {
                                                            try {
                                                                i2 = Math.max(1, Integer.parseInt(split2[5].substring(6)));
                                                            } catch (NumberFormatException unused) {
                                                            }
                                                            this.f27250b = new String[i2];
                                                            for (i3 = 0; i3 < i2; i3++) {
                                                                String readLine5 = bufferedReader3.readLine();
                                                                if (readLine5 != null) {
                                                                    Matcher matcher = Pattern.compile(".*id=(\\d+)").matcher(readLine5);
                                                                    if (matcher.find()) {
                                                                        String group = matcher.group(1);
                                                                        try {
                                                                            if (Integer.parseInt(group) != i3) {
                                                                                throw new GdxRuntimeException("Page IDs must be indices starting at 0: " + group);
                                                                            }
                                                                        } catch (NumberFormatException e2) {
                                                                            throw new GdxRuntimeException("Invalid page id: " + group, e2);
                                                                        }
                                                                    }
                                                                    Matcher matcher2 = Pattern.compile(".*file=\"?([^\"]+)\"?").matcher(readLine5);
                                                                    if (matcher2.find()) {
                                                                        this.f27250b[i3] = aVar.i().a(matcher2.group(1)).j().replaceAll("\\\\", "/");
                                                                    } else {
                                                                        throw new GdxRuntimeException("Missing: file");
                                                                    }
                                                                } else {
                                                                    throw new GdxRuntimeException("Missing additional page definitions.");
                                                                }
                                                            }
                                                            float f9 = 0.0f;
                                                            this.l = 0.0f;
                                                            while (true) {
                                                                readLine = bufferedReader3.readLine();
                                                                if (readLine != null || readLine.startsWith("kernings ") || readLine.startsWith("metrics ")) {
                                                                    break;
                                                                }
                                                                BufferedReader bufferedReader4 = bufferedReader3;
                                                                if (!readLine.startsWith("char ")) {
                                                                    b bVar4 = new b();
                                                                    StringTokenizer stringTokenizer2 = new StringTokenizer(readLine, " =");
                                                                    stringTokenizer2.nextToken();
                                                                    stringTokenizer2.nextToken();
                                                                    int parseInt3 = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    if (parseInt3 <= 0) {
                                                                        this.r = bVar4;
                                                                    } else if (parseInt3 <= 65535) {
                                                                        f(parseInt3, bVar4);
                                                                    }
                                                                    bVar4.a = parseInt3;
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.f27259b = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.f27260c = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.f27261d = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.f27262e = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.f27267j = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    stringTokenizer2.nextToken();
                                                                    if (z) {
                                                                        bVar4.k = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    } else {
                                                                        bVar4.k = -(bVar4.f27262e + Integer.parseInt(stringTokenizer2.nextToken()));
                                                                    }
                                                                    stringTokenizer2.nextToken();
                                                                    bVar4.l = Integer.parseInt(stringTokenizer2.nextToken());
                                                                    if (stringTokenizer2.hasMoreTokens()) {
                                                                        stringTokenizer2.nextToken();
                                                                    }
                                                                    if (stringTokenizer2.hasMoreTokens()) {
                                                                        try {
                                                                            bVar4.n = Integer.parseInt(stringTokenizer2.nextToken());
                                                                        } catch (NumberFormatException unused2) {
                                                                        }
                                                                    }
                                                                    if (bVar4.f27261d > 0 && bVar4.f27262e > 0) {
                                                                        this.l = Math.min(bVar4.k + parseInt2, this.l);
                                                                    }
                                                                }
                                                                bufferedReader3 = bufferedReader4;
                                                            }
                                                            this.l += this.f27255g;
                                                            while (true) {
                                                                readLine2 = bufferedReader3.readLine();
                                                                if (readLine2 != null || !readLine2.startsWith("kerning ")) {
                                                                    break;
                                                                }
                                                                BufferedReader bufferedReader5 = bufferedReader3;
                                                                stringTokenizer = new StringTokenizer(readLine2, " =");
                                                                stringTokenizer.nextToken();
                                                                stringTokenizer.nextToken();
                                                                parseInt = Integer.parseInt(stringTokenizer.nextToken());
                                                                stringTokenizer.nextToken();
                                                                int parseInt4 = Integer.parseInt(stringTokenizer.nextToken());
                                                                if (parseInt >= 0 && parseInt <= 65535 && parseInt4 >= 0 && parseInt4 <= 65535) {
                                                                    b3 = b((char) parseInt);
                                                                    stringTokenizer.nextToken();
                                                                    int parseInt5 = Integer.parseInt(stringTokenizer.nextToken());
                                                                    if (b3 == null) {
                                                                        b3.a(parseInt4, parseInt5);
                                                                    }
                                                                }
                                                                bufferedReader3 = bufferedReader5;
                                                            }
                                                            if (readLine2 == null && readLine2.startsWith("metrics ")) {
                                                                StringTokenizer stringTokenizer3 = new StringTokenizer(readLine2, " =");
                                                                stringTokenizer3.nextToken();
                                                                stringTokenizer3.nextToken();
                                                                float parseFloat = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f3 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f4 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f5 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f6 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f7 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                stringTokenizer3.nextToken();
                                                                f2 = Float.parseFloat(stringTokenizer3.nextToken());
                                                                f9 = parseFloat;
                                                            } else {
                                                                z2 = false;
                                                                f2 = 0.0f;
                                                                f3 = 0.0f;
                                                                f4 = 0.0f;
                                                                f5 = 0.0f;
                                                                f6 = 0.0f;
                                                                f7 = 0.0f;
                                                            }
                                                            b2 = b(WebvttCueParser.CHAR_SPACE);
                                                            if (b2 == null) {
                                                                b2 = new b();
                                                                b2.a = 32;
                                                                b b4 = b('l');
                                                                if (b4 == null) {
                                                                    b4 = a();
                                                                }
                                                                b2.l = b4.l;
                                                                f(32, b2);
                                                            }
                                                            if (b2.f27261d == 0) {
                                                                b2.f27261d = (int) (this.f27256h + b2.l + this.f27254f);
                                                                b2.f27267j = (int) (-this.f27256h);
                                                            }
                                                            this.s = b2.l;
                                                            char[] cArr = this.u;
                                                            length = cArr.length;
                                                            i4 = 0;
                                                            bVar = null;
                                                            while (i4 < length) {
                                                                int i6 = length;
                                                                bVar = b(cArr[i4]);
                                                                if (bVar != null) {
                                                                    break;
                                                                }
                                                                i4++;
                                                                length = i6;
                                                            }
                                                            if (bVar == null) {
                                                                bVar = a();
                                                            }
                                                            this.t = bVar.f27262e - f8;
                                                            char[] cArr2 = this.v;
                                                            length2 = cArr2.length;
                                                            i5 = 0;
                                                            bVar2 = null;
                                                            while (i5 < length2) {
                                                                int i7 = length2;
                                                                bVar2 = b(cArr2[i5]);
                                                                if (bVar2 != null) {
                                                                    break;
                                                                }
                                                                i5++;
                                                                length2 = i7;
                                                            }
                                                            if (bVar2 != null) {
                                                                b[][] bVarArr3 = this.q;
                                                                int length3 = bVarArr3.length;
                                                                int i8 = 0;
                                                                while (i8 < length3) {
                                                                    int i9 = length3;
                                                                    b[] bVarArr4 = bVarArr3[i8];
                                                                    if (bVarArr4 == null) {
                                                                        bufferedReader2 = bufferedReader3;
                                                                        bVarArr = bVarArr3;
                                                                    } else {
                                                                        bVarArr = bVarArr3;
                                                                        int length4 = bVarArr4.length;
                                                                        bufferedReader2 = bufferedReader3;
                                                                        int i10 = 0;
                                                                        while (i10 < length4) {
                                                                            int i11 = length4;
                                                                            b bVar5 = bVarArr4[i10];
                                                                            if (bVar5 != null) {
                                                                                bVarArr2 = bVarArr4;
                                                                                if (bVar5.f27262e != 0 && bVar5.f27261d != 0) {
                                                                                    this.f27258j = Math.max(this.f27258j, bVar5.f27262e);
                                                                                }
                                                                            } else {
                                                                                bVarArr2 = bVarArr4;
                                                                            }
                                                                            i10++;
                                                                            length4 = i11;
                                                                            bVarArr4 = bVarArr2;
                                                                        }
                                                                    }
                                                                    i8++;
                                                                    length3 = i9;
                                                                    bVarArr3 = bVarArr;
                                                                    bufferedReader3 = bufferedReader2;
                                                                }
                                                                bufferedReader = bufferedReader3;
                                                            } else {
                                                                bufferedReader = bufferedReader3;
                                                                this.f27258j = bVar3.f27262e;
                                                            }
                                                            float f10 = this.f27258j - f8;
                                                            this.f27258j = f10;
                                                            float f11 = parseInt2 - f10;
                                                            this.k = f11;
                                                            float f12 = -this.f27257i;
                                                            this.m = f12;
                                                            if (z) {
                                                                this.k = -f11;
                                                                this.m = -f12;
                                                            }
                                                            if (z2) {
                                                                this.k = f9;
                                                                this.l = f3;
                                                                this.m = f4;
                                                                this.f27258j = f5;
                                                                this.f27257i = f6;
                                                                this.s = f7;
                                                                this.t = f2;
                                                            }
                                                            i0.a(bufferedReader);
                                                            return;
                                                        }
                                                        i2 = 1;
                                                        this.f27250b = new String[i2];
                                                        while (i3 < i2) {
                                                        }
                                                        float f92 = 0.0f;
                                                        this.l = 0.0f;
                                                        while (true) {
                                                            readLine = bufferedReader3.readLine();
                                                            if (readLine != null) {
                                                                break;
                                                                break;
                                                            }
                                                            BufferedReader bufferedReader42 = bufferedReader3;
                                                            if (!readLine.startsWith("char ")) {
                                                            }
                                                            bufferedReader3 = bufferedReader42;
                                                        }
                                                        this.l += this.f27255g;
                                                        while (true) {
                                                            readLine2 = bufferedReader3.readLine();
                                                            if (readLine2 != null) {
                                                                break;
                                                            }
                                                            BufferedReader bufferedReader52 = bufferedReader3;
                                                            stringTokenizer = new StringTokenizer(readLine2, " =");
                                                            stringTokenizer.nextToken();
                                                            stringTokenizer.nextToken();
                                                            parseInt = Integer.parseInt(stringTokenizer.nextToken());
                                                            stringTokenizer.nextToken();
                                                            int parseInt42 = Integer.parseInt(stringTokenizer.nextToken());
                                                            if (parseInt >= 0) {
                                                                b3 = b((char) parseInt);
                                                                stringTokenizer.nextToken();
                                                                int parseInt52 = Integer.parseInt(stringTokenizer.nextToken());
                                                                if (b3 == null) {
                                                                }
                                                            }
                                                            bufferedReader3 = bufferedReader52;
                                                        }
                                                        if (readLine2 == null) {
                                                        }
                                                        z2 = false;
                                                        f2 = 0.0f;
                                                        f3 = 0.0f;
                                                        f4 = 0.0f;
                                                        f5 = 0.0f;
                                                        f6 = 0.0f;
                                                        f7 = 0.0f;
                                                        b2 = b(WebvttCueParser.CHAR_SPACE);
                                                        if (b2 == null) {
                                                        }
                                                        if (b2.f27261d == 0) {
                                                        }
                                                        this.s = b2.l;
                                                        char[] cArr3 = this.u;
                                                        length = cArr3.length;
                                                        i4 = 0;
                                                        bVar = null;
                                                        while (i4 < length) {
                                                        }
                                                        if (bVar == null) {
                                                        }
                                                        this.t = bVar.f27262e - f8;
                                                        char[] cArr22 = this.v;
                                                        length2 = cArr22.length;
                                                        i5 = 0;
                                                        bVar2 = null;
                                                        while (i5 < length2) {
                                                        }
                                                        if (bVar2 != null) {
                                                        }
                                                        float f102 = this.f27258j - f8;
                                                        this.f27258j = f102;
                                                        float f112 = parseInt2 - f102;
                                                        this.k = f112;
                                                        float f122 = -this.f27257i;
                                                        this.m = f122;
                                                        if (z) {
                                                        }
                                                        if (z2) {
                                                        }
                                                        i0.a(bufferedReader);
                                                        return;
                                                    }
                                                    throw new GdxRuntimeException("Missing: base");
                                                }
                                                throw new GdxRuntimeException("Missing: lineHeight");
                                            }
                                            throw new GdxRuntimeException("Invalid common header.");
                                        }
                                        throw new GdxRuntimeException("Missing common header.");
                                    }
                                    throw new GdxRuntimeException("Invalid padding.");
                                }
                                throw new GdxRuntimeException("File is empty.");
                            } catch (Exception e3) {
                                e = e3;
                                throw new GdxRuntimeException("Error loading font file: " + aVar, e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            i0.a(bufferedReader3);
                            throw th2;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        throw new GdxRuntimeException("Error loading font file: " + aVar, e);
                    } catch (Throwable th3) {
                        th = th3;
                        Throwable th22 = th;
                        i0.a(bufferedReader3);
                        throw th22;
                    }
                }
                throw new IllegalStateException("Already loaded.");
            }
        }

        public void f(int i2, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i2, bVar) == null) {
                b[][] bVarArr = this.q;
                int i3 = i2 / 512;
                b[] bVarArr2 = bVarArr[i3];
                if (bVarArr2 == null) {
                    bVarArr2 = new b[512];
                    bVarArr[i3] = bVarArr2;
                }
                bVarArr2[i2 & 511] = bVar;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void g(b bVar, i iVar) {
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048582, this, bVar, iVar) != null) {
                return;
            }
            Texture f4 = iVar.f();
            float x = 1.0f / f4.x();
            float u = 1.0f / f4.u();
            float f5 = iVar.f27312b;
            float f6 = iVar.f27313c;
            float c2 = iVar.c();
            float b2 = iVar.b();
            float f7 = 0.0f;
            if (iVar instanceof h.a) {
                h.a aVar = (h.a) iVar;
                f2 = aVar.f27291j;
                f3 = (aVar.o - aVar.m) - aVar.k;
            } else {
                f2 = 0.0f;
                f3 = 0.0f;
            }
            int i2 = bVar.f27259b;
            float f8 = i2;
            int i3 = bVar.f27261d;
            float f9 = i2 + i3;
            int i4 = bVar.f27260c;
            float f10 = i4;
            float f11 = i4 + bVar.f27262e;
            if (f2 > 0.0f) {
                f8 -= f2;
                if (f8 < 0.0f) {
                    bVar.f27261d = (int) (i3 + f8);
                    bVar.f27267j = (int) (bVar.f27267j - f8);
                    f8 = 0.0f;
                }
                f9 -= f2;
                if (f9 > c2) {
                    bVar.f27261d = (int) (bVar.f27261d - (f9 - c2));
                    if (f3 > 0.0f) {
                        float f12 = f10 - f3;
                        if (f12 < 0.0f) {
                            int i5 = (int) (bVar.f27262e + f12);
                            bVar.f27262e = i5;
                            if (i5 < 0) {
                                bVar.f27262e = 0;
                            }
                        } else {
                            f7 = f12;
                        }
                        f11 -= f3;
                        if (f11 > b2) {
                            float f13 = f11 - b2;
                            bVar.f27262e = (int) (bVar.f27262e - f13);
                            bVar.k = (int) (bVar.k + f13);
                            f10 = f7;
                            bVar.f27263f = (f8 * x) + f5;
                            bVar.f27265h = f5 + (c2 * x);
                            if (this.f27252d) {
                                bVar.f27264g = (f10 * u) + f6;
                                bVar.f27266i = f6 + (b2 * u);
                                return;
                            }
                            bVar.f27266i = (f10 * u) + f6;
                            bVar.f27264g = f6 + (b2 * u);
                            return;
                        }
                        f10 = f7;
                    }
                    b2 = f11;
                    bVar.f27263f = (f8 * x) + f5;
                    bVar.f27265h = f5 + (c2 * x);
                    if (this.f27252d) {
                    }
                }
            }
            c2 = f9;
            if (f3 > 0.0f) {
            }
            b2 = f11;
            bVar.f27263f = (f8 * x) + f5;
            bVar.f27265h = f5 + (c2 * x);
            if (this.f27252d) {
            }
        }

        public void h(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
                i(f2, f2);
            }
        }

        public void i(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                if (f2 == 0.0f) {
                    throw new IllegalArgumentException("scaleX cannot be 0.");
                }
                if (f3 != 0.0f) {
                    float f4 = f2 / this.n;
                    float f5 = f3 / this.o;
                    this.f27257i *= f5;
                    this.s *= f4;
                    this.t *= f5;
                    this.f27258j *= f5;
                    this.k *= f5;
                    this.l *= f5;
                    this.m *= f5;
                    this.f27256h *= f4;
                    this.f27254f *= f4;
                    this.f27253e *= f5;
                    this.f27255g *= f5;
                    this.n = f2;
                    this.o = f3;
                    return;
                }
                throw new IllegalArgumentException("scaleY cannot be 0.");
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String str = this.a;
                return str != null ? str : super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f27259b;

        /* renamed from: c  reason: collision with root package name */
        public int f27260c;

        /* renamed from: d  reason: collision with root package name */
        public int f27261d;

        /* renamed from: e  reason: collision with root package name */
        public int f27262e;

        /* renamed from: f  reason: collision with root package name */
        public float f27263f;

        /* renamed from: g  reason: collision with root package name */
        public float f27264g;

        /* renamed from: h  reason: collision with root package name */
        public float f27265h;

        /* renamed from: i  reason: collision with root package name */
        public float f27266i;

        /* renamed from: j  reason: collision with root package name */
        public int f27267j;
        public int k;
        public int l;
        public byte[][] m;
        public int n;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = 0;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.m == null) {
                    this.m = new byte[128];
                }
                byte[][] bArr = this.m;
                int i4 = i2 >>> 9;
                byte[] bArr2 = bArr[i4];
                if (bArr2 == null) {
                    bArr2 = new byte[512];
                    bArr[i4] = bArr2;
                }
                bArr2[i2 & 511] = (byte) i3;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Character.toString((char) this.a) : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(c.b.b.f.f27076d.f("com/badlogic/gdx/utils/arial-15.fnt"), c.b.b.f.f27076d.f("com/badlogic/gdx/utils/arial-15.png"), false, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((c.b.b.m.a) objArr[0], (c.b.b.m.a) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27246e.f27258j : invokeV.floatValue;
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.f27249h) {
            return;
        }
        int i2 = 0;
        while (true) {
            c.b.b.q.a<i> aVar = this.f27247f;
            if (i2 >= aVar.f27499f) {
                return;
            }
            aVar.get(i2).f().dispose();
            i2++;
        }
    }

    public C1636a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27246e : (C1636a) invokeV.objValue;
    }

    public void g(C1636a c1636a) {
        b[][] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c1636a) == null) {
            for (b[] bVarArr2 : c1636a.q) {
                if (bVarArr2 != null) {
                    for (b bVar : bVarArr2) {
                        if (bVar != null) {
                            c1636a.g(bVar, this.f27247f.get(bVar.n));
                        }
                    }
                }
            }
            b bVar2 = c1636a.r;
            if (bVar2 != null) {
                c1636a.g(bVar2, this.f27247f.get(bVar2.n));
            }
        }
    }

    public c.b.b.n.k.b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new c.b.b.n.k.b(this, this.f27248g) : (c.b.b.n.k.b) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = this.f27246e.a;
            return str != null ? str : super.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c.b.b.m.a aVar, i iVar) {
        this(aVar, iVar, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, iVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.b.b.m.a) objArr2[0], (i) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c.b.b.m.a aVar, i iVar, boolean z) {
        this(new C1636a(aVar, z), iVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, iVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((C1636a) objArr2[0], (i) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c.b.b.m.a aVar, boolean z) {
        this(new C1636a(aVar, z), (i) null, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((C1636a) objArr2[0], (i) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c.b.b.m.a aVar, c.b.b.m.a aVar2, boolean z) {
        this(aVar, aVar2, z, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.b.b.m.a) objArr2[0], (c.b.b.m.a) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c.b.b.m.a aVar, c.b.b.m.a aVar2, boolean z, boolean z2) {
        this(new C1636a(aVar, z), new i(new Texture(aVar2, false)), z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((C1636a) objArr2[0], (i) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27249h = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(C1636a c1636a, i iVar, boolean z) {
        this(c1636a, iVar != null ? c.b.b.q.a.n(iVar) : null, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c1636a, iVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((C1636a) objArr2[0], (c.b.b.q.a) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    public a(C1636a c1636a, c.b.b.q.a<i> aVar, boolean z) {
        c.b.b.m.a d2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c1636a, aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        boolean z2 = c1636a.f27252d;
        this.f27246e = c1636a;
        this.f27248g = z;
        if (aVar != null && aVar.f27499f != 0) {
            this.f27247f = aVar;
            this.f27249h = false;
        } else {
            String[] strArr = c1636a.f27250b;
            if (strArr != null) {
                int length = strArr.length;
                this.f27247f = new c.b.b.q.a<>(length);
                for (int i4 = 0; i4 < length; i4++) {
                    c.b.b.m.a aVar2 = c1636a.f27251c;
                    if (aVar2 == null) {
                        d2 = c.b.b.f.f27076d.a(c1636a.f27250b[i4]);
                    } else {
                        d2 = c.b.b.f.f27076d.d(c1636a.f27250b[i4], aVar2.t());
                    }
                    this.f27247f.a(new i(new Texture(d2, false)));
                }
                this.f27249h = true;
            } else {
                throw new IllegalArgumentException("If no regions are specified, the font data must have an images path.");
            }
        }
        h();
        g(c1636a);
    }
}
