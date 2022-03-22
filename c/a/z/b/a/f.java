package c.a.z.b.a;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.Rotation;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class f implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f22260b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.z.b.a.b f22261c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.z.b.a.b f22262d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22263e;

    /* renamed from: f  reason: collision with root package name */
    public int f22264f;

    /* renamed from: g  reason: collision with root package name */
    public int f22265g;

    /* renamed from: h  reason: collision with root package name */
    public final LinkedList<Runnable> f22266h;
    public int i;
    public long j;
    public List<MediaTrack> k;
    public Map<String, ShaderConfig> l;
    public Map<String, c.a.z.b.a.a> m;
    public boolean n;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f22267b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f22268c;

        public a(f fVar, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22268c = fVar;
            this.a = i;
            this.f22267b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f22268c;
                fVar.i = this.a;
                fVar.j = this.f22267b;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f22269b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f22270c;

        public b(f fVar, List list, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22270c = fVar;
            this.a = list;
            this.f22269b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f22270c.f22260b) {
                    this.f22270c.s();
                }
                f fVar = this.f22270c;
                fVar.k = this.a;
                fVar.l = this.f22269b;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f22271b;

        public c(f fVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22271b = fVar;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22271b.k = this.a;
            }
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22263e = false;
        this.f22266h = new LinkedList<>();
    }

    public int A(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        MediaSegment mediaSegment;
        c.a.z.b.a.a F;
        int e2;
        MediaSegment mediaSegment2;
        c.a.z.b.a.a F2;
        int e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, mediaTrack, i, map)) == null) {
            if (this.i == 0 && (mediaSegment2 = mediaTrack.superpositionHeader) != null && ((TextUtils.equals(mediaSegment2.superpositionType, "all") || TextUtils.equals(mediaTrack.superpositionHeader.superpositionType, "without_trans")) && (F2 = F(mediaTrack.superpositionHeader, map)) != null && (e3 = this.f22261c.e(i, F2)) != i)) {
                i = e3;
            }
            return (this.i != mediaTrack.mediaSegments.size() + (-1) || (mediaSegment = mediaTrack.superpositionFooter) == null) ? i : ((!TextUtils.equals(mediaSegment.superpositionType, "all") && !TextUtils.equals(mediaTrack.superpositionFooter.superpositionType, "without_trans")) || (F = F(mediaTrack.superpositionFooter, map)) == null || (e2 = this.f22261c.e(i, F)) == i) ? i : e2;
        }
        return invokeLIL.intValue;
    }

    public int B(MediaTrack mediaTrack, MediaSegment mediaSegment, int i, Map<String, float[]> map, List<c.a.z.b.a.a> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{mediaTrack, mediaSegment, Integer.valueOf(i), map, list})) == null) {
            int A = A(mediaTrack, y(mediaSegment, z(mediaSegment, i, map), map), map);
            C(map, list, mediaTrack);
            return A;
        }
        return invokeCommon.intValue;
    }

    public void C(Map<String, float[]> map, List<c.a.z.b.a.a> list, MediaTrack mediaTrack) {
        List<MediaTransition> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, map, list, mediaTrack) == null) || (list2 = mediaTrack.mediaTransitions) == null) {
            return;
        }
        int size = list2.size();
        int i = this.i;
        if (size > i) {
            MediaTransition mediaTransition = mediaTrack.mediaTransitions.get(i);
            long j = mediaTransition.end;
            long j2 = mediaTransition.start;
            if (j - j2 > 0) {
                long j3 = this.j;
                if (j3 < j2 || j3 > j) {
                    return;
                }
                String str = mediaTransition.shaderConfigKey;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                H(this.i, mediaTrack, mediaTransition, map);
                c.a.z.b.a.a aVar = this.m.get(str);
                if (aVar != null) {
                    v(aVar, map);
                    K(str, aVar, mediaTransition);
                    list.add(aVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r5 <= r14) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int D(Map<String, float[]> map, List<c.a.z.b.a.a> list, MediaTrack mediaTrack, int i) {
        InterceptResult invokeLLLI;
        c.a.z.b.a.a aVar;
        c.a.z.b.a.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048579, this, map, list, mediaTrack, i)) == null) {
            boolean m = c.a.z.b.a.k.c.m(mediaTrack, "effect");
            int size = m ? mediaTrack.mediaSegments.size() - 1 : 0;
            boolean z = !m ? size >= mediaTrack.mediaSegments.size() : size < 0;
            int i2 = size;
            int i3 = i;
            while (z) {
                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i2);
                if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                    long j = mediaSegment.start;
                    long j2 = mediaSegment.end;
                    if (j != j2) {
                        long j3 = this.j;
                        if (j3 >= j) {
                        }
                    }
                    i2 = !m ? i2 - 1 : i2 + 1;
                    z = m ? i2 < mediaTrack.mediaSegments.size() : i2 >= 0;
                }
                if (!m && !c.a.z.b.a.k.c.m(mediaTrack, "template_effect") && mediaSegment.mediaAEffect != null) {
                    int e2 = this.f22261c.e(i3, E(mediaSegment, mediaSegment.textureId, map));
                    if (e2 != i3) {
                        i3 = e2;
                    }
                } else {
                    String str = mediaSegment.shaderConfigKey;
                    if (!TextUtils.isEmpty(str) && (aVar2 = this.m.get(str)) != null) {
                        v(aVar2, map);
                        J(str, aVar2);
                        p(aVar2);
                        list.add(aVar2);
                    }
                    MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
                    if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                        MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                        if (mediaAEffect2.duration > 0) {
                            String str2 = mediaAEffect2.shaderConfigKey;
                            long j4 = mediaSegment.effectStart;
                            if (j4 <= 0) {
                                j4 = mediaSegment.start;
                            }
                            long j5 = j4;
                            long j6 = mediaSegment.effectEnd;
                            long j7 = j6 > 0 ? j6 : mediaSegment.end;
                            if (!TextUtils.isEmpty(str2)) {
                                long j8 = this.j;
                                if (j8 >= j5 && j8 <= j7 && (aVar = this.m.get(str2)) != null) {
                                    v(aVar, map);
                                    J(str2, aVar);
                                    p(aVar);
                                    aVar.F(mediaAEffect2.effectType, j5, j7, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                                    list.add(aVar);
                                }
                            }
                        }
                    }
                }
                if (m) {
                    break;
                }
                if (!m) {
                }
                if (m) {
                }
            }
            return i3;
        }
        return invokeLLLI.intValue;
    }

    public c.a.z.b.a.a E(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, mediaSegment, i, map)) == null) {
            if (i == 0) {
                i = mediaSegment.textureId;
            }
            c.a.z.b.a.a aVar = null;
            if (i == 0) {
                return null;
            }
            int r = r(mediaSegment, i, map);
            String str = mediaSegment.shaderConfigKey;
            if (!TextUtils.isEmpty(str)) {
                List<MediaTextureData> list = this.l.get(str).textures;
                if (list != null) {
                    for (MediaTextureData mediaTextureData : list) {
                        mediaTextureData.textureId = r;
                    }
                }
                aVar = this.m.get(str);
                if (aVar != null) {
                    v(aVar, map);
                    J(str, aVar);
                    p(aVar);
                }
            }
            return aVar;
        }
        return (c.a.z.b.a.a) invokeLIL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r5 <= r3) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.z.b.a.a F(MediaSegment mediaSegment, Map<String, float[]> map) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048581, this, mediaSegment, map)) != null) {
            return (c.a.z.b.a.a) invokeLL.objValue;
        }
        if (mediaSegment == null) {
            return null;
        }
        if (mediaSegment.start != 0 || mediaSegment.end != 0) {
            long j = mediaSegment.start;
            long j2 = mediaSegment.end;
            if (j != j2) {
                long j3 = this.j;
                if (j3 >= j) {
                }
            }
            z = false;
            if (z) {
                return null;
            }
            return E(mediaSegment, mediaSegment.textureId, map);
        }
        z = true;
        if (z) {
        }
    }

    public c.a.z.b.a.a G(Map<String, float[]> map, MediaTrack mediaTrack) {
        InterceptResult invokeLL;
        c.a.z.b.a.a F;
        c.a.z.b.a.a F2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, map, mediaTrack)) == null) {
            if (mediaTrack != null) {
                MediaSegment mediaSegment = mediaTrack.superpositionHeader;
                if (mediaSegment == null || !TextUtils.equals(mediaSegment.superpositionType, "self") || (F2 = F(mediaTrack.superpositionHeader, map)) == null) {
                    MediaSegment mediaSegment2 = mediaTrack.superpositionFooter;
                    if (mediaSegment2 == null || !TextUtils.equals(mediaSegment2.superpositionType, "self") || (F = F(mediaTrack.superpositionFooter, map)) == null) {
                        return null;
                    }
                    return F;
                }
                return F2;
            }
            return null;
        }
        return (c.a.z.b.a.a) invokeLL.objValue;
    }

    public void H(int i, MediaTrack mediaTrack, MediaTransition mediaTransition, Map<String, float[]> map) {
        int i2;
        List<MediaTextureData> list;
        c.a.z.b.a.a F;
        int e2;
        List<MediaTextureData> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), mediaTrack, mediaTransition, map}) == null) {
            ShaderConfig shaderConfig = this.l.get(mediaTransition.shaderConfigKey);
            if (shaderConfig != null && (list2 = shaderConfig.textures) != null) {
                for (MediaTextureData mediaTextureData : list2) {
                    if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData.type)) {
                        i2 = mediaTextureData.textureId;
                        break;
                    }
                }
            }
            i2 = 0;
            if (i2 == 0) {
                return;
            }
            int i3 = i + 1;
            if (mediaTrack.mediaSegments.size() > i3) {
                MediaSegment mediaSegment = mediaTrack.mediaSegments.get(i3);
                i2 = y(mediaSegment, x(z(mediaSegment, i2, map)), map);
                MediaSegment mediaSegment2 = mediaTrack.superpositionFooter;
                if (mediaSegment2 != null && TextUtils.equals(mediaSegment2.superpositionType, "all") && (F = F(mediaTrack.superpositionFooter, map)) != null && (e2 = this.f22261c.e(i2, F)) != i2) {
                    i2 = e2;
                }
            }
            if (shaderConfig == null || (list = shaderConfig.textures) == null) {
                return;
            }
            for (MediaTextureData mediaTextureData2 : list) {
                if (TextUtils.equals(MediaTextureData.TEXTURE_INPUT, mediaTextureData2.type)) {
                    mediaTextureData2.textureId = i2;
                    return;
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            while (!this.f22266h.isEmpty()) {
                this.f22266h.removeFirst().run();
            }
        }
    }

    public void J(String str, c.a.z.b.a.a aVar) {
        ShaderConfig shaderConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, aVar) == null) || !(aVar instanceof d) || TextUtils.isEmpty(str) || (shaderConfig = this.l.get(str)) == null || shaderConfig.textures == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaTextureData mediaTextureData : shaderConfig.textures) {
            int i = mediaTextureData.textureId;
            if (i != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        ((d) aVar).Y(arrayList);
    }

    public void K(String str, c.a.z.b.a.a aVar, MediaTransition mediaTransition) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, str, aVar, mediaTransition) == null) && (aVar instanceof d)) {
            ArrayList arrayList = new ArrayList();
            for (MediaTextureData mediaTextureData : this.l.get(str).textures) {
                int i = mediaTextureData.textureId;
                if (i != 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            ((d) aVar).Y(arrayList);
            p(aVar);
            aVar.Q(mediaTransition.start, mediaTransition.end, mediaTransition.tParams);
        }
    }

    @Override // c.a.z.b.a.e
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // c.a.z.b.a.e
    @Deprecated
    public int c(int i, int i2, Map<String, float[]> map) {
        InterceptResult invokeIIL;
        c.a.z.b.a.a G;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048588, this, i, i2, map)) == null) {
            try {
                b(i, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                u(e2.toString(), e2);
            }
            if (this.f22261c != null && this.k != null && this.m != null && this.l != null) {
                ArrayList arrayList = new ArrayList();
                MediaTrack mediaTrack = null;
                int size = c.a.z.b.a.k.a.x(this.k, "edit_sticker") ? this.k.size() - 2 : this.k.size() - 1;
                int i4 = 0;
                for (int i5 = 0; i5 < this.k.size(); i5++) {
                    MediaTrack mediaTrack2 = this.k.get(i5);
                    if (i5 == 0) {
                        if (mediaTrack2.mediaSegments != null && mediaTrack2.mediaSegments.size() > this.i) {
                            MediaSegment mediaSegment = mediaTrack2.mediaSegments.get(this.i);
                            int i6 = mediaSegment.textureId;
                            if (TextUtils.equals(mediaSegment.type, "camera")) {
                                this.n = true;
                                if (mediaSegment.vertexMtx != null || mediaSegment.textureMtx != null) {
                                    c.a.z.b.a.c cVar = (c.a.z.b.a.c) this.m.get(c.a.z.b.a.k.c.f22276b);
                                    if (mediaSegment.vertexMtx != null) {
                                        cVar.U(mediaSegment.vertexMtx);
                                    }
                                    if (mediaSegment.textureMtx != null) {
                                        cVar.V(mediaSegment.textureMtx);
                                    }
                                    cVar.D(1.0f);
                                    int e3 = this.f22261c.e(i6, cVar);
                                    if (e3 != i6) {
                                        i3 = e3;
                                        i4 = B(mediaTrack2, mediaSegment, i3, map, arrayList);
                                    }
                                }
                            }
                            i3 = i6;
                            i4 = B(mediaTrack2, mediaSegment, i3, map, arrayList);
                        }
                        mediaTrack = mediaTrack2;
                    } else {
                        D(map, arrayList, mediaTrack2, i4);
                    }
                    if (i5 == size && (G = G(map, mediaTrack)) != null) {
                        arrayList.add(G);
                    }
                }
                if (i4 != 0) {
                    return this.f22261c.f(i4, arrayList);
                }
                return 0;
            }
            return 0;
        }
        return invokeIIL.intValue;
    }

    @Override // c.a.z.b.a.e
    public void e(List<MediaTrack> list, Map<String, ShaderConfig> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, map) == null) {
            this.f22266h.add(new b(this, list, map));
        }
    }

    @Override // c.a.z.b.a.e
    public void g(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.f22266h.add(new a(this, i, j));
        }
    }

    @Override // c.a.z.b.a.e
    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.a = context;
        }
    }

    @Override // c.a.z.b.a.e
    public List<MediaTrack> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    @Override // c.a.z.b.a.e
    @Deprecated
    public int m(int i, float[] fArr, float[] fArr2, int i2, int i3, int i4, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) {
            I();
            List<MediaTrack> list = this.k;
            if (list != null && list.size() != 0 && this.k.get(0).mediaSegments != null && this.k.get(0).mediaSegments.size() == 1 && i3 != 0 && i4 != 0) {
                if (i3 != this.f22264f || i4 != this.f22265g) {
                    this.f22264f = i3;
                    this.f22265g = i4;
                    t(" w * h : " + i3 + " * " + i4);
                    s();
                }
                try {
                    MediaSegment mediaSegment = this.k.get(0).mediaSegments.get(0);
                    mediaSegment.textureId = i;
                    mediaSegment.vertexMtx = fArr;
                    mediaSegment.textureMtx = fArr2;
                    int c2 = c(i3, i4, map);
                    if (c2 != 0) {
                        if (fArr2 != null) {
                            Matrix.setIdentityM(fArr2, 0);
                        }
                        if (fArr != null) {
                            Matrix.setIdentityM(fArr, 0);
                        }
                    }
                    return c2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    u(e2.toString(), e2);
                }
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    @Override // c.a.z.b.a.e
    public void n(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.f22266h.add(new c(this, list));
        }
    }

    public void p(c.a.z.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) && !this.n && (aVar instanceof d)) {
            ((d) aVar).X(Rotation.NORMAL, false, true);
        }
    }

    public void q() {
        Map<String, ShaderConfig> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.f22260b || this.k == null || (map = this.l) == null) {
            return;
        }
        if (!map.containsKey(c.a.z.b.a.k.c.f22276b)) {
            this.l.put(c.a.z.b.a.k.c.f22276b, ShaderConfig.getDefaultShaderConfig());
        }
        if (!this.l.containsKey(c.a.z.b.a.k.c.f22280f)) {
            this.l.put(c.a.z.b.a.k.c.f22280f, ShaderConfig.getStickerShaderConfig());
        }
        Map<String, c.a.z.b.a.a> l = c.a.z.b.a.k.a.l(this.a, this.l);
        this.m = l;
        for (Map.Entry<String, c.a.z.b.a.a> entry : l.entrySet()) {
            c.a.z.b.a.a value = entry.getValue();
            value.l();
            value.v(this.f22264f, this.f22265g);
        }
        if (this.f22261c == null) {
            this.f22261c = new c.a.z.b.a.b();
        }
        this.f22261c.c(this.f22264f, this.f22265g);
        this.f22260b = true;
    }

    public int r(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048597, this, mediaSegment, i, map)) == null) {
            MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
            if (mediaAEffect != null && !TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
                if (mediaAEffect2.duration > 0) {
                    String str = mediaAEffect2.shaderConfigKey;
                    if (!TextUtils.isEmpty(str)) {
                        List<MediaTextureData> list = this.l.get(str).textures;
                        if (list != null) {
                            for (MediaTextureData mediaTextureData : list) {
                                mediaTextureData.textureId = i;
                            }
                        }
                        c.a.z.b.a.a aVar = this.m.get(str);
                        long j = mediaSegment.effectStart;
                        if (j <= 0) {
                            j = mediaSegment.start;
                        }
                        long j2 = j;
                        long j3 = mediaSegment.effectEnd;
                        long j4 = j3 > 0 ? j3 : mediaSegment.end;
                        if (aVar != null) {
                            long j5 = this.j;
                            if (j5 >= j2 && j5 <= j4) {
                                v(aVar, map);
                                J(str, aVar);
                                aVar.F(mediaAEffect2.effectType, j2, j4, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                                int e2 = this.f22261c.e(i, aVar);
                                if (e2 != i) {
                                    return e2;
                                }
                            }
                        }
                    }
                }
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    @Override // c.a.z.b.a.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                if (this.f22261c != null) {
                    this.f22261c.b();
                    this.f22261c = null;
                }
                if (this.f22262d != null) {
                    this.f22262d.b();
                    this.f22262d = null;
                }
                if (this.l != null) {
                    for (Map.Entry<String, ShaderConfig> entry : this.l.entrySet()) {
                        entry.getValue().destroy();
                    }
                    this.l = null;
                }
                s();
            } catch (Exception e2) {
                t(e2.getMessage());
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            try {
                if (this.f22260b) {
                    if (this.m != null) {
                        for (Map.Entry<String, c.a.z.b.a.a> entry : this.m.entrySet()) {
                            entry.getValue().h();
                        }
                        this.m = null;
                    }
                    this.j = 0L;
                    this.f22260b = false;
                }
            } catch (Exception e2) {
                t(e2.getMessage());
            }
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && this.f22263e) {
            Log.d("zmy", "---> " + str);
        }
    }

    public void u(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, str, exc) == null) && this.f22263e) {
            Log.d("zmy", "---> " + str, exc);
        }
    }

    public void v(c.a.z.b.a.a aVar, Map<String, float[]> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, aVar, map) == null) {
            float[] fArr = g.f22272b;
            w(aVar, fArr, fArr, map);
        }
    }

    public void w(c.a.z.b.a.a aVar, float[] fArr, float[] fArr2, Map<String, float[]> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048603, this, aVar, fArr, fArr2, map) == null) || aVar == null) {
            return;
        }
        if (aVar instanceof c.a.z.b.a.c) {
            if (fArr == null) {
                fArr = g.f22272b;
            }
            if (fArr2 == null) {
                fArr2 = g.f22272b;
            }
            c.a.z.b.a.c cVar = (c.a.z.b.a.c) aVar;
            cVar.U(fArr);
            cVar.V(fArr2);
        }
        aVar.J();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, float[]> entry : map.entrySet()) {
                aVar.I(GLES20.glGetUniformLocation(aVar.j(), entry.getKey()), entry.getValue(), true);
            }
        }
        aVar.E(this.j);
    }

    public int x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            List<MediaTrack> list = this.k;
            if (list == null) {
                return i;
            }
            String str = NotificationCompat.WearableExtender.KEY_BACKGROUND;
            if (!c.a.z.b.a.k.c.k(list, NotificationCompat.WearableExtender.KEY_BACKGROUND)) {
                str = "user_background";
            }
            int i2 = 1;
            while (true) {
                if (i2 >= this.k.size()) {
                    break;
                }
                MediaTrack mediaTrack = this.k.get(i2);
                if (mediaTrack != null && c.a.z.b.a.k.c.m(mediaTrack, str)) {
                    c.a.z.b.a.b bVar = this.f22261c;
                    float[] fArr = mediaTrack.glClearColor;
                    bVar.h(fArr[0], fArr[1], fArr[2], fArr[3]);
                    List<MediaSegment> list2 = mediaTrack.mediaSegments;
                    if (list2 != null) {
                        for (MediaSegment mediaSegment : list2) {
                            if (mediaSegment.start != 0 || mediaSegment.end != 0) {
                                long j = mediaSegment.start;
                                long j2 = mediaSegment.end;
                                if (j != j2) {
                                    long j3 = this.j;
                                    if (j3 >= j && j3 <= j2) {
                                    }
                                } else {
                                    continue;
                                }
                            }
                            if (mediaSegment.textureId == 0) {
                                continue;
                            } else if (TextUtils.equals(mediaSegment.type, "input")) {
                                return i;
                            } else {
                                c.a.z.b.a.a aVar = this.m.get(c.a.z.b.a.k.c.f22280f);
                                if (aVar != null) {
                                    v(aVar, null);
                                    if (aVar instanceof d) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(Integer.valueOf(i));
                                        ((d) aVar).Y(arrayList);
                                    }
                                    p(aVar);
                                    int e2 = this.f22261c.e(mediaSegment.textureId, aVar);
                                    if (e2 != mediaSegment.textureId) {
                                        i = e2;
                                    }
                                }
                            }
                        }
                    } else {
                        c.a.z.b.a.a aVar2 = this.m.get(c.a.z.b.a.k.c.f22276b);
                        if (aVar2 != null) {
                            v(aVar2, null);
                            GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                            GLES20.glBlendFunc(770, 771);
                            int e3 = this.f22261c.e(i, aVar2);
                            GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                            if (e3 != i) {
                                i = e3;
                            }
                        }
                    }
                    this.f22261c.h(0.0f, 0.0f, 0.0f, 0.0f);
                } else {
                    i2++;
                }
            }
            return i;
        }
        return invokeI.intValue;
    }

    public int y(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        c.a.z.b.a.a aVar;
        c.a.z.b.a.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048605, this, mediaSegment, i, map)) == null) {
            int i2 = i;
            String str = mediaSegment.shaderConfigKey;
            if (!TextUtils.isEmpty(str) && (aVar2 = this.m.get(str)) != null) {
                v(aVar2, map);
                J(str, aVar2);
                int e2 = this.f22261c.e(i2, aVar2);
                if (e2 != i2) {
                    i2 = e2;
                }
            }
            MediaAEffect mediaAEffect = mediaSegment.mediaAEffect;
            if (mediaAEffect == null || TextUtils.isEmpty(mediaAEffect.shaderConfigKey)) {
                return i2;
            }
            MediaAEffect mediaAEffect2 = mediaSegment.mediaAEffect;
            if (mediaAEffect2.duration > 0) {
                String str2 = mediaAEffect2.shaderConfigKey;
                long j = mediaSegment.effectStart;
                if (j <= 0) {
                    j = mediaSegment.start;
                }
                long j2 = j;
                long j3 = mediaSegment.effectEnd;
                long j4 = j3 > 0 ? j3 : mediaSegment.end;
                if (TextUtils.isEmpty(str2)) {
                    return i2;
                }
                long j5 = this.j;
                if (j5 < j2 || j5 > j4 || (aVar = this.m.get(str2)) == null) {
                    return i2;
                }
                v(aVar, map);
                J(str2, aVar);
                aVar.F(mediaAEffect2.effectType, j2, j4, mediaAEffect2.duration, mediaAEffect2.repeatMode, mediaAEffect2.mediaOneAEffects);
                int e3 = this.f22261c.e(i2, aVar);
                return e3 != i2 ? e3 : i2;
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int z(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        c.a.z.b.a.a aVar;
        List<MediaTextureData> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048606, this, mediaSegment, i, map)) == null) {
            String str = mediaSegment.lutConfigKey;
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            ShaderConfig shaderConfig = this.l.get(str);
            String str2 = null;
            if (shaderConfig != null && (list = shaderConfig.textures) != null) {
                for (MediaTextureData mediaTextureData : list) {
                    if (mediaTextureData.textureId == 0 || !TextUtils.equals(mediaTextureData.type, MediaTextureData.TEXTURE_LUT)) {
                        str = null;
                        break;
                    }
                    while (r0.hasNext()) {
                    }
                }
                str2 = str;
            }
            if (TextUtils.isEmpty(str2) || (aVar = this.m.get(str2)) == null) {
                return i;
            }
            v(aVar, map);
            J(str2, aVar);
            int e2 = this.f22261c.e(i, aVar);
            return e2 != i ? e2 : i;
        }
        return invokeLIL.intValue;
    }
}
