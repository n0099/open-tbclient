package c.i.b.a.a0.q;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.ProtectionSchemeInformationBox;
import com.coremedia.iso.boxes.SampleAuxiliaryInformationOffsetsBox;
import com.coremedia.iso.boxes.SampleAuxiliaryInformationSizesBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SchemeInformationBox;
import com.coremedia.iso.boxes.SchemeTypeBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.UserDataBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.apple.AppleItemListBox;
import com.coremedia.iso.boxes.apple.AppleWaveBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.h264.AvcConfigurationBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.SubtitleSampleEntry;
import com.coremedia.iso.boxes.sampleentry.TextSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.DTSSpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom;
import com.googlecode.mp4parser.boxes.basemediaformat.TrackEncryptionBox;
import com.googlecode.mp4parser.boxes.cenc.ProtectionSystemSpecificHeaderBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox;
import com.googlecode.mp4parser.boxes.ultraviolet.SampleEncryptionBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int A0;
    public static final int B;
    public static final int B0;
    public static final int C;
    public static final int C0;
    public static final int D;
    public static final int D0;
    public static final int E;
    public static final int E0;
    public static final int F;
    public static final int F0;
    public static final int G;
    public static final int G0;
    public static final int H;
    public static final int H0;
    public static final int I;
    public static final int I0;
    public static final int J;
    public static final int J0;
    public static final int K;
    public static final int K0;
    public static final int L;
    public static final int L0;
    public static final int M;
    public static final int M0;
    public static final int N;
    public static final int N0;
    public static final int O;
    public static final int O0;
    public static final int P;
    public static final int Q;
    public static final int R;
    public static final int S;
    public static final int T;
    public static final int U;
    public static final int V;
    public static final int W;
    public static final int X;
    public static final int Y;
    public static final int Z;
    public static final int a0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f28642b;
    public static final int b0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f28643c;
    public static final int c0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f28644d;
    public static final int d0;

    /* renamed from: e  reason: collision with root package name */
    public static final int f28645e;
    public static final int e0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f28646f;
    public static final int f0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f28647g;
    public static final int g0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f28648h;
    public static final int h0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f28649i;
    public static final int i0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f28650j;
    public static final int j0;
    public static final int k;
    public static final int k0;
    public static final int l;
    public static final int l0;
    public static final int m;
    public static final int m0;
    public static final int n;
    public static final int n0;
    public static final int o;
    public static final int o0;
    public static final int p;
    public static final int p0;
    public static final int q;
    public static final int q0;
    public static final int r;
    public static final int r0;
    public static final int s;
    public static final int s0;
    public static final int t;
    public static final int t0;
    public static final int u;
    public static final int u0;
    public static final int v;
    public static final int v0;
    public static final int w;
    public static final int w0;
    public static final int x;
    public static final int x0;
    public static final int y;
    public static final int y0;
    public static final int z;
    public static final int z0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: c.i.b.a.a0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1651a extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long P0;
        public final List<b> Q0;
        public final List<C1651a> R0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1651a(int i2, long j2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.P0 = j2;
            this.Q0 = new ArrayList();
            this.R0 = new ArrayList();
        }

        public void d(C1651a c1651a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c1651a) == null) {
                this.R0.add(c1651a);
            }
        }

        public void e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.Q0.add(bVar);
            }
        }

        public C1651a f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int size = this.R0.size();
                for (int i3 = 0; i3 < size; i3++) {
                    C1651a c1651a = this.R0.get(i3);
                    if (c1651a.a == i2) {
                        return c1651a;
                    }
                }
                return null;
            }
            return (C1651a) invokeI.objValue;
        }

        public b g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int size = this.Q0.size();
                for (int i3 = 0; i3 < size; i3++) {
                    b bVar = this.Q0.get(i3);
                    if (bVar.a == i2) {
                        return bVar;
                    }
                }
                return null;
            }
            return (b) invokeI.objValue;
        }

        @Override // c.i.b.a.a0.q.a
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return a.a(this.a) + " leaves: " + Arrays.toString(this.Q0.toArray()) + " containers: " + Arrays.toString(this.R0.toArray());
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b extends a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.i.b.a.i0.l P0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2, c.i.b.a.i0.l lVar) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.P0 = lVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445121473, "Lc/i/b/a/a0/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445121473, "Lc/i/b/a/a0/q/a;");
                return;
            }
        }
        f28642b = v.q("ftyp");
        f28643c = v.q(VisualSampleEntry.TYPE3);
        f28644d = v.q(VisualSampleEntry.TYPE4);
        f28645e = v.q("hvc1");
        f28646f = v.q("hev1");
        f28647g = v.q(VisualSampleEntry.TYPE2);
        f28648h = v.q("d263");
        f28649i = v.q(MediaDataBox.TYPE);
        f28650j = v.q(AudioSampleEntry.TYPE3);
        k = v.q(EmotionResourceProvider.EMOTION_SOUND_SUFFIX);
        l = v.q(AppleWaveBox.TYPE);
        m = v.q("lpcm");
        n = v.q("sowt");
        o = v.q(AudioSampleEntry.TYPE8);
        p = v.q(AC3SpecificBox.TYPE);
        q = v.q(AudioSampleEntry.TYPE9);
        r = v.q(EC3SpecificBox.TYPE);
        s = v.q("dtsc");
        t = v.q(AudioSampleEntry.TYPE12);
        u = v.q(AudioSampleEntry.TYPE11);
        v = v.q(AudioSampleEntry.TYPE13);
        w = v.q(DTSSpecificBox.TYPE);
        x = v.q(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
        y = v.q(TrackFragmentHeaderBox.TYPE);
        z = v.q(TrackExtendsBox.TYPE);
        A = v.q(TrackRunBox.TYPE);
        B = v.q(SegmentIndexBox.TYPE);
        C = v.q(MovieBox.TYPE);
        D = v.q(MovieHeaderBox.TYPE);
        E = v.q(TrackBox.TYPE);
        F = v.q(MediaBox.TYPE);
        G = v.q(MediaInformationBox.TYPE);
        H = v.q(SampleTableBox.TYPE);
        I = v.q(AvcConfigurationBox.TYPE);
        J = v.q("hvcC");
        K = v.q(ESDescriptorBox.TYPE);
        L = v.q(MovieFragmentBox.TYPE);
        M = v.q(TrackFragmentBox.TYPE);
        N = v.q(MovieExtendsBox.TYPE);
        O = v.q(MovieExtendsHeaderBox.TYPE);
        P = v.q(TrackHeaderBox.TYPE);
        Q = v.q(EditBox.TYPE);
        R = v.q(EditListBox.TYPE);
        S = v.q(MediaHeaderBox.TYPE);
        T = v.q(HandlerBox.TYPE);
        U = v.q(SampleDescriptionBox.TYPE);
        V = v.q(ProtectionSystemSpecificHeaderBox.TYPE);
        W = v.q(ProtectionSchemeInformationBox.TYPE);
        X = v.q(SchemeTypeBox.TYPE);
        Y = v.q(SchemeInformationBox.TYPE);
        Z = v.q(TrackEncryptionBox.TYPE);
        a0 = v.q(VisualSampleEntry.TYPE_ENCRYPTED);
        b0 = v.q(AudioSampleEntry.TYPE_ENCRYPTED);
        c0 = v.q(OriginalFormatBox.TYPE);
        d0 = v.q(SampleAuxiliaryInformationSizesBox.TYPE);
        e0 = v.q(SampleAuxiliaryInformationOffsetsBox.TYPE);
        f0 = v.q(SampleToGroupBox.TYPE);
        g0 = v.q(SampleGroupDescriptionBox.TYPE);
        h0 = v.q("uuid");
        i0 = v.q(SampleEncryptionBox.TYPE);
        j0 = v.q(PixelAspectRationAtom.TYPE);
        k0 = v.q("TTML");
        v.q(VideoMediaHeaderBox.TYPE);
        l0 = v.q(VisualSampleEntry.TYPE1);
        m0 = v.q(TimeToSampleBox.TYPE);
        n0 = v.q(SyncSampleBox.TYPE);
        o0 = v.q(CompositionTimeToSample.TYPE);
        p0 = v.q(SampleToChunkBox.TYPE);
        q0 = v.q(SampleSizeBox.TYPE);
        r0 = v.q("stz2");
        s0 = v.q(StaticChunkOffsetBox.TYPE);
        t0 = v.q(ChunkOffset64BitBox.TYPE);
        u0 = v.q(TextSampleEntry.TYPE1);
        v0 = v.q("wvtt");
        w0 = v.q(SubtitleSampleEntry.TYPE1);
        x0 = v.q("c608");
        y0 = v.q(AudioSampleEntry.TYPE1);
        z0 = v.q(AudioSampleEntry.TYPE2);
        A0 = v.q(UserDataBox.TYPE);
        B0 = v.q("meta");
        C0 = v.q(AppleItemListBox.TYPE);
        D0 = v.q("mean");
        E0 = v.q("name");
        F0 = v.q("data");
        G0 = v.q("emsg");
        H0 = v.q("st3d");
        I0 = v.q("sv3d");
        J0 = v.q("proj");
        K0 = v.q("vp08");
        L0 = v.q("vp09");
        M0 = v.q("vpcC");
        N0 = v.q("camm");
        O0 = v.q("alac");
    }

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
        }
        return (String) invokeI.objValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 & 16777215 : invokeI.intValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? (i2 >> 24) & 255 : invokeI.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a(this.a) : (String) invokeV.objValue;
    }
}
