package c.i.b.a.a0.q;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.coremedia.iso.boxes.GenreBox;
import com.coremedia.iso.boxes.RatingBox;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public static final int C;
    public static final String[] D;

    /* renamed from: a  reason: collision with root package name */
    public static final int f32406a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f32407b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f32408c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f32409d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f32410e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f32411f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f32412g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f32413h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f32414i;

    /* renamed from: j  reason: collision with root package name */
    public static final int f32415j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445121318, "Lc/i/b/a/a0/q/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445121318, "Lc/i/b/a/a0/q/f;");
                return;
            }
        }
        f32406a = v.q("nam");
        f32407b = v.q("trk");
        f32408c = v.q("cmt");
        f32409d = v.q("day");
        f32410e = v.q("ART");
        f32411f = v.q("too");
        f32412g = v.q("alb");
        f32413h = v.q("com");
        f32414i = v.q("wrt");
        f32415j = v.q("lyr");
        k = v.q("gen");
        l = v.q("covr");
        m = v.q(GenreBox.TYPE);
        n = v.q("grp");
        o = v.q("disk");
        p = v.q("trkn");
        q = v.q("tmpo");
        r = v.q("cpil");
        s = v.q("aART");
        t = v.q("sonm");
        u = v.q("soal");
        v = v.q("soar");
        w = v.q("soaa");
        x = v.q("soco");
        y = v.q(RatingBox.TYPE);
        z = v.q("pgap");
        A = v.q("sosn");
        B = v.q("tvsh");
        C = v.q("----");
        D = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    }

    public static CommentFrame a(int i2, c.i.b.a.i0.l lVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, lVar)) == null) {
            int i3 = lVar.i();
            if (lVar.i() == a.F0) {
                lVar.K(8);
                String s2 = lVar.s(i3 - 16);
                return new CommentFrame("und", s2, s2);
            }
            String str = "Failed to parse comment attribute: " + a.a(i2);
            return null;
        }
        return (CommentFrame) invokeIL.objValue;
    }

    public static ApicFrame b(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) {
            int i2 = lVar.i();
            if (lVar.i() == a.F0) {
                int b2 = a.b(lVar.i());
                String str = b2 == 13 ? "image/jpeg" : b2 == 14 ? "image/png" : null;
                if (str == null) {
                    String str2 = "Unrecognized cover art flags: " + b2;
                    return null;
                }
                lVar.K(4);
                int i3 = i2 - 16;
                byte[] bArr = new byte[i3];
                lVar.g(bArr, 0, i3);
                return new ApicFrame(str, null, 3, bArr);
            }
            return null;
        }
        return (ApicFrame) invokeL.objValue;
    }

    public static Metadata.Entry c(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lVar)) == null) {
            int c2 = lVar.c() + lVar.i();
            int i2 = lVar.i();
            int i3 = (i2 >> 24) & 255;
            try {
                if (i3 != 169 && i3 != 65533) {
                    if (i2 == m) {
                        return f(lVar);
                    }
                    if (i2 == o) {
                        return d(i2, "TPOS", lVar);
                    }
                    if (i2 == p) {
                        return d(i2, "TRCK", lVar);
                    }
                    if (i2 == q) {
                        return h(i2, "TBPM", lVar, true, false);
                    }
                    if (i2 == r) {
                        return h(i2, "TCMP", lVar, true, true);
                    }
                    if (i2 == l) {
                        return b(lVar);
                    }
                    if (i2 == s) {
                        return g(i2, "TPE2", lVar);
                    }
                    if (i2 == t) {
                        return g(i2, "TSOT", lVar);
                    }
                    if (i2 == u) {
                        return g(i2, "TSO2", lVar);
                    }
                    if (i2 == v) {
                        return g(i2, "TSOA", lVar);
                    }
                    if (i2 == w) {
                        return g(i2, "TSOP", lVar);
                    }
                    if (i2 == x) {
                        return g(i2, "TSOC", lVar);
                    }
                    if (i2 == y) {
                        return h(i2, "ITUNESADVISORY", lVar, false, false);
                    }
                    if (i2 == z) {
                        return h(i2, "ITUNESGAPLESS", lVar, false, true);
                    }
                    if (i2 == A) {
                        return g(i2, "TVSHOWSORT", lVar);
                    }
                    if (i2 == B) {
                        return g(i2, "TVSHOW", lVar);
                    }
                    if (i2 == C) {
                        return e(lVar, c2);
                    }
                } else {
                    int i4 = 16777215 & i2;
                    if (i4 == f32408c) {
                        return a(i2, lVar);
                    }
                    if (i4 != f32406a && i4 != f32407b) {
                        if (i4 != f32413h && i4 != f32414i) {
                            if (i4 == f32409d) {
                                return g(i2, "TDRC", lVar);
                            }
                            if (i4 == f32410e) {
                                return g(i2, "TPE1", lVar);
                            }
                            if (i4 == f32411f) {
                                return g(i2, "TSSE", lVar);
                            }
                            if (i4 == f32412g) {
                                return g(i2, "TALB", lVar);
                            }
                            if (i4 == f32415j) {
                                return g(i2, "USLT", lVar);
                            }
                            if (i4 == k) {
                                return g(i2, "TCON", lVar);
                            }
                            if (i4 == n) {
                                return g(i2, "TIT1", lVar);
                            }
                        }
                        return g(i2, "TCOM", lVar);
                    }
                    return g(i2, "TIT2", lVar);
                }
                String str = "Skipped unknown metadata entry: " + a.a(i2);
                return null;
            } finally {
                lVar.J(c2);
            }
        }
        return (Metadata.Entry) invokeL.objValue;
    }

    public static TextInformationFrame d(int i2, String str, c.i.b.a.i0.l lVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, str, lVar)) == null) {
            int i3 = lVar.i();
            if (lVar.i() == a.F0 && i3 >= 22) {
                lVar.K(10);
                int D2 = lVar.D();
                if (D2 > 0) {
                    String str2 = "" + D2;
                    int D3 = lVar.D();
                    if (D3 > 0) {
                        str2 = str2 + "/" + D3;
                    }
                    return new TextInformationFrame(str, null, str2);
                }
            }
            String str3 = "Failed to parse index/count attribute: " + a.a(i2);
            return null;
        }
        return (TextInformationFrame) invokeILL.objValue;
    }

    public static Id3Frame e(c.i.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, lVar, i2)) == null) {
            String str = null;
            String str2 = null;
            int i3 = -1;
            int i4 = -1;
            while (lVar.c() < i2) {
                int c2 = lVar.c();
                int i5 = lVar.i();
                int i6 = lVar.i();
                lVar.K(4);
                if (i6 == a.D0) {
                    str = lVar.s(i5 - 12);
                } else if (i6 == a.E0) {
                    str2 = lVar.s(i5 - 12);
                } else {
                    if (i6 == a.F0) {
                        i3 = c2;
                        i4 = i5;
                    }
                    lVar.K(i5 - 12);
                }
            }
            if ("com.apple.iTunes".equals(str) && "iTunSMPB".equals(str2) && i3 != -1) {
                lVar.J(i3);
                lVar.K(16);
                return new CommentFrame("und", str2, lVar.s(i4 - 16));
            }
            return null;
        }
        return (Id3Frame) invokeLI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0020 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TextInformationFrame f(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, lVar)) != null) {
            return (TextInformationFrame) invokeL.objValue;
        }
        int i2 = i(lVar);
        if (i2 > 0) {
            String[] strArr = D;
            if (i2 <= strArr.length) {
                str = strArr[i2 - 1];
                if (str == null) {
                    return new TextInformationFrame("TCON", null, str);
                }
                return null;
            }
        }
        str = null;
        if (str == null) {
        }
    }

    public static TextInformationFrame g(int i2, String str, c.i.b.a.i0.l lVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65543, null, i2, str, lVar)) == null) {
            int i3 = lVar.i();
            if (lVar.i() == a.F0) {
                lVar.K(8);
                return new TextInformationFrame(str, null, lVar.s(i3 - 16));
            }
            String str2 = "Failed to parse text attribute: " + a.a(i2);
            return null;
        }
        return (TextInformationFrame) invokeILL.objValue;
    }

    public static Id3Frame h(int i2, String str, c.i.b.a.i0.l lVar, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), str, lVar, Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            int i3 = i(lVar);
            if (z3) {
                i3 = Math.min(1, i3);
            }
            if (i3 >= 0) {
                if (z2) {
                    return new TextInformationFrame(str, null, Integer.toString(i3));
                }
                return new CommentFrame("und", str, Integer.toString(i3));
            }
            String str2 = "Failed to parse uint8 attribute: " + a.a(i2);
            return null;
        }
        return (Id3Frame) invokeCommon.objValue;
    }

    public static int i(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, lVar)) == null) {
            lVar.K(4);
            if (lVar.i() == a.F0) {
                lVar.K(8);
                return lVar.x();
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
