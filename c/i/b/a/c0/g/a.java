package c.i.b.a.c0.g;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.c0.c;
import c.i.b.a.i0.l;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes9.dex */
public final class a implements c.i.b.a.c0.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final int f29002b;
    public transient /* synthetic */ FieldHolder $fh;
    public final InterfaceC1654a a;

    /* renamed from: c.i.b.a.c0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1654a {
        boolean a(int i2, int i3, int i4, int i5, int i6);
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f29003b;

        /* renamed from: c  reason: collision with root package name */
        public final int f29004c;

        public b(int i2, boolean z, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f29003b = z;
            this.f29004c = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1329587979, "Lc/i/b/a/c0/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1329587979, "Lc/i/b/a/c0/g/a;");
                return;
            }
        }
        f29002b = v.q("ID3");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((InterfaceC1654a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static byte[] b(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) ? i3 <= i2 ? new byte[0] : Arrays.copyOfRange(bArr, i2, i3) : (byte[]) invokeLII.objValue;
    }

    public static ApicFrame d(l lVar, int i2, int i3) throws UnsupportedEncodingException {
        InterceptResult invokeLII;
        int u;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, lVar, i2, i3)) == null) {
            int x = lVar.x();
            String r = r(x);
            int i4 = i2 - 1;
            byte[] bArr = new byte[i4];
            lVar.g(bArr, 0, i4);
            if (i3 == 2) {
                str = FileUtils.IMAGE_FILE_START + v.J(new String(bArr, 0, 3, "ISO-8859-1"));
                if (str.equals("image/jpg")) {
                    str = "image/jpeg";
                }
                u = 2;
            } else {
                u = u(bArr, 0);
                String J = v.J(new String(bArr, 0, u, "ISO-8859-1"));
                if (J.indexOf(47) == -1) {
                    str = FileUtils.IMAGE_FILE_START + J;
                } else {
                    str = J;
                }
            }
            int i5 = u + 2;
            int t = t(bArr, i5, x);
            return new ApicFrame(str, new String(bArr, i5, t - i5, r), bArr[u + 1] & 255, b(bArr, t + q(x), i4));
        }
        return (ApicFrame) invokeLII.objValue;
    }

    public static BinaryFrame e(l lVar, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, lVar, i2, str)) == null) {
            byte[] bArr = new byte[i2];
            lVar.g(bArr, 0, i2);
            return new BinaryFrame(str, bArr);
        }
        return (BinaryFrame) invokeLIL.objValue;
    }

    public static ChapterFrame f(l lVar, int i2, int i3, boolean z, int i4, InterfaceC1654a interfaceC1654a) throws UnsupportedEncodingException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), interfaceC1654a})) == null) {
            int c2 = lVar.c();
            int u = u(lVar.a, c2);
            String str = new String(lVar.a, c2, u - c2, "ISO-8859-1");
            lVar.J(u + 1);
            int i5 = lVar.i();
            int i6 = lVar.i();
            long z2 = lVar.z();
            long j2 = z2 == 4294967295L ? -1L : z2;
            long z3 = lVar.z();
            long j3 = z3 == 4294967295L ? -1L : z3;
            ArrayList arrayList = new ArrayList();
            int i7 = c2 + i2;
            while (lVar.c() < i7) {
                Id3Frame i8 = i(i3, lVar, z, i4, interfaceC1654a);
                if (i8 != null) {
                    arrayList.add(i8);
                }
            }
            Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
            arrayList.toArray(id3FrameArr);
            return new ChapterFrame(str, i5, i6, j2, j3, id3FrameArr);
        }
        return (ChapterFrame) invokeCommon.objValue;
    }

    public static ChapterTocFrame g(l lVar, int i2, int i3, boolean z, int i4, InterfaceC1654a interfaceC1654a) throws UnsupportedEncodingException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), interfaceC1654a})) == null) {
            int c2 = lVar.c();
            int u = u(lVar.a, c2);
            String str = new String(lVar.a, c2, u - c2, "ISO-8859-1");
            lVar.J(u + 1);
            int x = lVar.x();
            boolean z2 = (x & 2) != 0;
            boolean z3 = (x & 1) != 0;
            int x2 = lVar.x();
            String[] strArr = new String[x2];
            for (int i5 = 0; i5 < x2; i5++) {
                int c3 = lVar.c();
                int u2 = u(lVar.a, c3);
                strArr[i5] = new String(lVar.a, c3, u2 - c3, "ISO-8859-1");
                lVar.J(u2 + 1);
            }
            ArrayList arrayList = new ArrayList();
            int i6 = c2 + i2;
            while (lVar.c() < i6) {
                Id3Frame i7 = i(i3, lVar, z, i4, interfaceC1654a);
                if (i7 != null) {
                    arrayList.add(i7);
                }
            }
            Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
            arrayList.toArray(id3FrameArr);
            return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
        }
        return (ChapterTocFrame) invokeCommon.objValue;
    }

    public static CommentFrame h(l lVar, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, lVar, i2)) == null) {
            if (i2 < 4) {
                return null;
            }
            int x = lVar.x();
            String r = r(x);
            byte[] bArr = new byte[3];
            lVar.g(bArr, 0, 3);
            String str = new String(bArr, 0, 3);
            int i3 = i2 - 4;
            byte[] bArr2 = new byte[i3];
            lVar.g(bArr2, 0, i3);
            int t = t(bArr2, 0, x);
            String str2 = new String(bArr2, 0, t, r);
            int q = t + q(x);
            return new CommentFrame(str, str2, q < i3 ? new String(bArr2, q, t(bArr2, q, x) - q, r) : "");
        }
        return (CommentFrame) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x018a, code lost:
        if (r13 == 67) goto L100;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Id3Frame i(int i2, l lVar, boolean z, int i3, InterfaceC1654a interfaceC1654a) {
        InterceptResult invokeCommon;
        int A;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Id3Frame e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i2), lVar, Boolean.valueOf(z), Integer.valueOf(i3), interfaceC1654a})) == null) {
            int x = lVar.x();
            int x2 = lVar.x();
            int x3 = lVar.x();
            int x4 = i2 >= 3 ? lVar.x() : 0;
            if (i2 == 4) {
                A = lVar.B();
                if (!z) {
                    A = (((A >> 24) & 255) << 21) | (A & 255) | (((A >> 8) & 255) << 7) | (((A >> 16) & 255) << 14);
                }
            } else if (i2 == 3) {
                A = lVar.B();
            } else {
                A = lVar.A();
            }
            int i6 = A;
            int D = i2 >= 3 ? lVar.D() : 0;
            if (x == 0 && x2 == 0 && x3 == 0 && x4 == 0 && i6 == 0 && D == 0) {
                lVar.J(lVar.d());
                return null;
            }
            int c2 = lVar.c() + i6;
            if (c2 > lVar.d()) {
                lVar.J(lVar.d());
                return null;
            }
            if (interfaceC1654a != null) {
                i4 = c2;
                i5 = D;
                if (!interfaceC1654a.a(i2, x, x2, x3, x4)) {
                    lVar.J(i4);
                    return null;
                }
            } else {
                i4 = c2;
                i5 = D;
            }
            if (i2 == 3) {
                boolean z7 = (i5 & 128) != 0;
                z3 = (i5 & 64) != 0;
                z6 = z7;
                z5 = false;
                z2 = (i5 & 32) != 0;
                z4 = z6;
            } else if (i2 == 4) {
                z2 = (i5 & 64) != 0;
                boolean z8 = (i5 & 8) != 0;
                boolean z9 = (i5 & 4) != 0;
                z5 = (i5 & 2) != 0;
                z6 = z8;
                z3 = z9;
                z4 = (i5 & 1) != 0;
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
            if (!z6 && !z3) {
                if (z2) {
                    i6--;
                    lVar.K(1);
                }
                if (z4) {
                    i6 -= 4;
                    lVar.K(4);
                }
                if (z5) {
                    i6 = v(lVar, i6);
                }
                try {
                    if (x == 84 && x2 == 88 && x3 == 88 && (i2 == 2 || x4 == 88)) {
                        e2 = n(lVar, i6);
                    } else if (x == 84) {
                        e2 = m(lVar, i6, s(i2, x, x2, x3, x4));
                    } else if (x == 87 && x2 == 88 && x3 == 88 && (i2 == 2 || x4 == 88)) {
                        e2 = p(lVar, i6);
                    } else if (x == 87) {
                        e2 = o(lVar, i6, s(i2, x, x2, x3, x4));
                    } else if (x == 80 && x2 == 82 && x3 == 73 && x4 == 86) {
                        e2 = l(lVar, i6);
                    } else if (x == 71 && x2 == 69 && x3 == 79 && (x4 == 66 || i2 == 2)) {
                        e2 = j(lVar, i6);
                    } else if (i2 == 2) {
                        if (x == 80 && x2 == 73 && x3 == 67) {
                            e2 = d(lVar, i6, i2);
                        }
                        if (x != 67 && x2 == 79 && x3 == 77 && (x4 == 77 || i2 == 2)) {
                            e2 = h(lVar, i6);
                        } else if (x != 67 && x2 == 72 && x3 == 65 && x4 == 80) {
                            e2 = f(lVar, i6, i2, z, i3, interfaceC1654a);
                        } else if (x != 67 && x2 == 84 && x3 == 79 && x4 == 67) {
                            e2 = g(lVar, i6, i2, z, i3, interfaceC1654a);
                        } else {
                            e2 = e(lVar, i6, s(i2, x, x2, x3, x4));
                        }
                    } else {
                        if (x == 65) {
                            if (x2 == 80) {
                                if (x3 == 73) {
                                }
                            }
                        }
                        if (x != 67) {
                        }
                        if (x != 67) {
                        }
                        if (x != 67) {
                        }
                        e2 = e(lVar, i6, s(i2, x, x2, x3, x4));
                    }
                    if (e2 == null) {
                        String str = "Failed to decode frame: id=" + s(i2, x, x2, x3, x4) + ", frameSize=" + i6;
                    }
                    lVar.J(i4);
                    return e2;
                } catch (UnsupportedEncodingException unused) {
                    lVar.J(i4);
                    return null;
                } catch (Throwable th) {
                    lVar.J(i4);
                    throw th;
                }
            }
            lVar.J(i4);
            return null;
        }
        return (Id3Frame) invokeCommon.objValue;
    }

    public static GeobFrame j(l lVar, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, lVar, i2)) == null) {
            int x = lVar.x();
            String r = r(x);
            int i3 = i2 - 1;
            byte[] bArr = new byte[i3];
            lVar.g(bArr, 0, i3);
            int u = u(bArr, 0);
            String str = new String(bArr, 0, u, "ISO-8859-1");
            int i4 = u + 1;
            int t = t(bArr, i4, x);
            String str2 = new String(bArr, i4, t - i4, r);
            int q = t + q(x);
            int t2 = t(bArr, q, x);
            return new GeobFrame(str, str2, new String(bArr, q, t2 - q, r), b(bArr, t2 + q(x), i3));
        }
        return (GeobFrame) invokeLI.objValue;
    }

    public static b k(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, lVar)) == null) {
            if (lVar.a() < 10) {
                return null;
            }
            int A = lVar.A();
            if (A != f29002b) {
                String str = "Unexpected first three bytes of ID3 tag header: " + A;
                return null;
            }
            int x = lVar.x();
            boolean z = true;
            lVar.K(1);
            int x2 = lVar.x();
            int w = lVar.w();
            if (x == 2) {
                if ((x2 & 64) != 0) {
                    return null;
                }
            } else if (x == 3) {
                if ((x2 & 64) != 0) {
                    int i2 = lVar.i();
                    lVar.K(i2);
                    w -= i2 + 4;
                }
            } else if (x != 4) {
                String str2 = "Skipped ID3 tag with unsupported majorVersion=" + x;
                return null;
            } else {
                if ((x2 & 64) != 0) {
                    int w2 = lVar.w();
                    lVar.K(w2 - 4);
                    w -= w2;
                }
                if ((x2 & 16) != 0) {
                    w -= 10;
                }
            }
            return new b(x, (x >= 4 || (x2 & 128) == 0) ? false : false, w);
        }
        return (b) invokeL.objValue;
    }

    public static PrivFrame l(l lVar, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, lVar, i2)) == null) {
            byte[] bArr = new byte[i2];
            lVar.g(bArr, 0, i2);
            int u = u(bArr, 0);
            return new PrivFrame(new String(bArr, 0, u, "ISO-8859-1"), b(bArr, u + 1, i2));
        }
        return (PrivFrame) invokeLI.objValue;
    }

    public static TextInformationFrame m(l lVar, int i2, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, lVar, i2, str)) == null) {
            if (i2 < 1) {
                return null;
            }
            int x = lVar.x();
            String r = r(x);
            int i3 = i2 - 1;
            byte[] bArr = new byte[i3];
            lVar.g(bArr, 0, i3);
            return new TextInformationFrame(str, null, new String(bArr, 0, t(bArr, 0, x), r));
        }
        return (TextInformationFrame) invokeLIL.objValue;
    }

    public static TextInformationFrame n(l lVar, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, lVar, i2)) == null) {
            if (i2 < 1) {
                return null;
            }
            int x = lVar.x();
            String r = r(x);
            int i3 = i2 - 1;
            byte[] bArr = new byte[i3];
            lVar.g(bArr, 0, i3);
            int t = t(bArr, 0, x);
            String str = new String(bArr, 0, t, r);
            int q = t + q(x);
            return new TextInformationFrame("TXXX", str, q < i3 ? new String(bArr, q, t(bArr, q, x) - q, r) : "");
        }
        return (TextInformationFrame) invokeLI.objValue;
    }

    public static UrlLinkFrame o(l lVar, int i2, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, lVar, i2, str)) == null) {
            byte[] bArr = new byte[i2];
            lVar.g(bArr, 0, i2);
            return new UrlLinkFrame(str, null, new String(bArr, 0, u(bArr, 0), "ISO-8859-1"));
        }
        return (UrlLinkFrame) invokeLIL.objValue;
    }

    public static UrlLinkFrame p(l lVar, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, lVar, i2)) == null) {
            if (i2 < 1) {
                return null;
            }
            int x = lVar.x();
            String r = r(x);
            int i3 = i2 - 1;
            byte[] bArr = new byte[i3];
            lVar.g(bArr, 0, i3);
            int t = t(bArr, 0, x);
            String str = new String(bArr, 0, t, r);
            int q = t + q(x);
            return new UrlLinkFrame("WXXX", str, q < i3 ? new String(bArr, q, u(bArr, q) - q, "ISO-8859-1") : "");
        }
        return (UrlLinkFrame) invokeLI.objValue;
    }

    public static int q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) ? (i2 == 0 || i2 == 3) ? 1 : 2 : invokeI.intValue;
    }

    public static String r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16" : (String) invokeI.objValue;
    }

    public static String s(int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) ? i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)) : (String) invokeCommon.objValue;
    }

    public static int t(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65556, null, bArr, i2, i3)) == null) {
            int u = u(bArr, i2);
            if (i3 == 0 || i3 == 3) {
                return u;
            }
            while (u < bArr.length - 1) {
                if (u % 2 == 0 && bArr[u + 1] == 0) {
                    return u;
                }
                u = u(bArr, u + 1);
            }
            return bArr.length;
        }
        return invokeLII.intValue;
    }

    public static int u(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, bArr, i2)) == null) {
            while (i2 < bArr.length) {
                if (bArr[i2] == 0) {
                    return i2;
                }
                i2++;
            }
            return bArr.length;
        }
        return invokeLI.intValue;
    }

    public static int v(l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65558, null, lVar, i2)) != null) {
            return invokeLI.intValue;
        }
        byte[] bArr = lVar.a;
        int c2 = lVar.c();
        while (true) {
            int i3 = c2 + 1;
            if (i3 >= i2) {
                return i2;
            }
            if ((bArr[c2] & 255) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, c2 + 2, bArr, i3, (i2 - c2) - 2);
                i2--;
            }
            c2 = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
        if ((r10 & 1) != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
        if ((r10 & 128) != 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean w(l lVar, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        int A;
        long A2;
        int i4;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        int c2 = lVar.c();
        while (true) {
            try {
                if (lVar.a() < i3) {
                    return true;
                }
                if (i2 >= 3) {
                    A = lVar.i();
                    A2 = lVar.z();
                    i4 = lVar.D();
                } else {
                    A = lVar.A();
                    A2 = lVar.A();
                    i4 = 0;
                }
                if (A == 0 && A2 == 0 && i4 == 0) {
                    return true;
                }
                if (i2 == 4 && !z) {
                    if ((8421504 & A2) != 0) {
                        return false;
                    }
                    A2 = (((A2 >> 24) & 255) << 21) | (A2 & 255) | (((A2 >> 8) & 255) << 7) | (((A2 >> 16) & 255) << 14);
                }
                if (i2 == 4) {
                    z2 = (i4 & 64) != 0;
                } else {
                    if (i2 == 3) {
                        z2 = (i4 & 32) != 0;
                    } else {
                        z2 = false;
                    }
                    z3 = false;
                }
                int i5 = z2 ? 1 : 0;
                if (z3) {
                    i5 += 4;
                }
                if (A2 < i5) {
                    return false;
                }
                if (lVar.a() < A2) {
                    return false;
                }
                lVar.K((int) A2);
            } finally {
                lVar.J(c2);
            }
        }
    }

    @Override // c.i.b.a.c0.a
    public Metadata a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            ByteBuffer byteBuffer = cVar.f29956g;
            return c(byteBuffer.array(), byteBuffer.limit());
        }
        return (Metadata) invokeL.objValue;
    }

    public Metadata c(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            l lVar = new l(bArr, i2);
            b k = k(lVar);
            if (k == null) {
                return null;
            }
            int c2 = lVar.c();
            int i3 = k.a == 2 ? 6 : 10;
            int i4 = k.f29004c;
            if (k.f29003b) {
                i4 = v(lVar, k.f29004c);
            }
            lVar.I(c2 + i4);
            boolean z = false;
            if (!w(lVar, k.a, i3, false)) {
                if (k.a != 4 || !w(lVar, 4, i3, true)) {
                    String str = "Failed to validate ID3 tag with majorVersion=" + k.a;
                    return null;
                }
                z = true;
            }
            while (lVar.a() >= i3) {
                Id3Frame i5 = i(k.a, lVar, z, i3, this.a);
                if (i5 != null) {
                    arrayList.add(i5);
                }
            }
            return new Metadata(arrayList);
        }
        return (Metadata) invokeLI.objValue;
    }

    public a(InterfaceC1654a interfaceC1654a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC1654a};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = interfaceC1654a;
    }
}
