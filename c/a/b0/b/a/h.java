package c.a.b0.b.a;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.b0.b.a.e
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            if (this.f1661e) {
                System.currentTimeMillis();
            }
            I();
            if (i2 != this.f1662f || i3 != this.f1663g) {
                this.f1662f = i2;
                this.f1663g = i3;
                t(" w * h : " + i2 + " * " + i3);
                s();
            }
            if (i2 == 0 || i3 == 0) {
                return;
            }
            q();
            b bVar = this.f1659c;
            if (bVar != null) {
                bVar.g();
            }
            b bVar2 = this.f1660d;
            if (bVar2 != null) {
                bVar2.g();
            }
        }
    }

    @Override // c.a.b0.b.a.e
    public int d(MediaTrack mediaTrack, int i2, Map<String, float[]> map) {
        a G;
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaTrack, i2, map)) == null) {
            try {
                if (this.f1659c != null && i2 != 0 && mediaTrack != null && this.m != null && this.l != null && (G = G(map, mediaTrack)) != null) {
                    return this.f1659c.e(i2, G);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                u(e2.toString(), e2);
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0099 */
    /* JADX DEBUG: Multi-variable search result rejected for r11v1, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: float[] */
    /* JADX DEBUG: Multi-variable search result rejected for r11v3, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.a.b0.b.a.e
    public int f(MediaTrack mediaTrack, int i2, int i3, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        int z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{mediaTrack, Integer.valueOf(i2), Integer.valueOf(i3), map})) != null) {
            return invokeCommon.intValue;
        }
        try {
            try {
                if (this.f1659c != null && mediaTrack != null && this.m != null && this.l != null) {
                    b bVar = this.f1659c;
                    float f2 = mediaTrack.glClearColor[0];
                    float f3 = mediaTrack.glClearColor[1];
                    float f4 = mediaTrack.glClearColor[2];
                    i4 = mediaTrack.glClearColor[3];
                    bVar.h(f2, f3, f4, i4);
                    ArrayList arrayList = new ArrayList();
                    try {
                        if (mediaTrack.mediaSegments == null || mediaTrack.mediaSegments.size() <= this.f1665i) {
                            i5 = i2;
                        } else {
                            MediaSegment mediaSegment = mediaTrack.mediaSegments.get(this.f1665i);
                            i5 = i2 == 0 ? mediaSegment.textureId : i2;
                            if (i3 == 1) {
                                z = z(mediaSegment, i5, map);
                            } else if (i3 == 2) {
                                z = y(mediaSegment, i5, map);
                            } else if (i3 == 3) {
                                z = A(mediaTrack, i5, map);
                            } else if (i3 == 4) {
                                C(map, arrayList, mediaTrack);
                            } else if (i3 != 5) {
                                z = B(mediaTrack, mediaSegment, i5, map, arrayList);
                            } else {
                                z = x(i5);
                            }
                            i5 = z;
                        }
                        if (i5 != 0 && arrayList.size() > 0) {
                            i5 = this.f1659c.f(i5, arrayList);
                        }
                        return i5;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        u(e.toString(), e);
                        b bVar2 = this.f1659c;
                        if (bVar2 != null) {
                            bVar2.h(0.0f, 0.0f, 0.0f, 0.0f);
                        }
                        return i4;
                    }
                }
                b bVar3 = this.f1659c;
                if (bVar3 != null) {
                    bVar3.h(0.0f, 0.0f, 0.0f, 0.0f);
                }
                return i2;
            } catch (Exception e3) {
                e = e3;
                i4 = i2;
            }
        } finally {
            b bVar4 = this.f1659c;
            if (bVar4 != null) {
                bVar4.h(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    @Override // c.a.b0.b.a.e
    public int h(MediaSegment mediaSegment, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, mediaSegment, i2, map)) == null) ? mediaSegment == null ? i2 : r(mediaSegment, i2, map) : invokeLIL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
        if (r8 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        r8.h(0.0f, 0.0f, 0.0f, 0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r8 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006e, code lost:
        return r9;
     */
    @Override // c.a.b0.b.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int i(MediaTrack mediaTrack, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(1048580, this, mediaTrack, i2, map)) != null) {
            return invokeLIL.intValue;
        }
        try {
            try {
                if (this.f1659c != null && mediaTrack != null && this.m != null && this.l != null) {
                    this.f1659c.h(mediaTrack.glClearColor[0], mediaTrack.glClearColor[1], mediaTrack.glClearColor[2], mediaTrack.glClearColor[3]);
                    ArrayList arrayList = new ArrayList();
                    i2 = D(map, arrayList, mediaTrack, i2);
                    if (i2 != 0 && arrayList.size() > 0) {
                        return this.f1659c.f(i2, arrayList);
                    }
                    bVar = this.f1659c;
                }
                b bVar2 = this.f1659c;
                if (bVar2 != null) {
                    bVar2.h(0.0f, 0.0f, 0.0f, 0.0f);
                }
                return i2;
            } catch (Exception e2) {
                e2.printStackTrace();
                u(e2.toString(), e2);
                bVar = this.f1659c;
            }
        } finally {
            b bVar3 = this.f1659c;
            if (bVar3 != null) {
                bVar3.h(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    @Override // c.a.b0.b.a.e
    public int k(int i2, float[] fArr, float[] fArr2, int i3, int i4, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), fArr, fArr2, Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)})) == null) {
            if (i2 == 0 || this.m == null) {
                return i2;
            }
            Map<String, ShaderConfig> map = this.l;
            if (map != null && !map.containsKey(c.a.b0.b.a.k.c.f1684g)) {
                this.l.put(c.a.b0.b.a.k.c.f1684g, ShaderConfig.getGaussianBlurHShaderConfig(f2));
                this.l.put(c.a.b0.b.a.k.c.f1685h, ShaderConfig.getGaussianBlurVShaderConfig(f2));
                Map<String, a> l = c.a.b0.b.a.k.a.l(this.a, this.l);
                for (Map.Entry<String, a> entry : l.entrySet()) {
                    a value = entry.getValue();
                    value.l();
                    value.v(i3, i4);
                }
                this.m.putAll(l);
            }
            if (this.f1660d == null) {
                this.f1660d = new b();
            }
            this.f1660d.g();
            this.f1660d.c(i3, i4);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.m.get(c.a.b0.b.a.k.c.f1684g));
            arrayList.add(this.m.get(c.a.b0.b.a.k.c.f1685h));
            float[] fArr3 = fArr;
            float[] fArr4 = fArr2;
            int i5 = 0;
            while (i5 < arrayList.size()) {
                a aVar = (a) arrayList.get(i5);
                aVar.v(i3, i4);
                if (i5 == 0) {
                    aVar.e(GLES20.glGetUniformLocation(aVar.j(), "wRatio"), "wRatio", new ShaderParams("wRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{f2}));
                } else {
                    aVar.e(GLES20.glGetUniformLocation(aVar.j(), "hRatio"), "hRatio", new ShaderParams("hRatio", ShaderParams.VALUE_TYPE_FLOAT, new float[]{f2}));
                }
                w(aVar, fArr3, fArr4, null);
                i5++;
                fArr3 = null;
                fArr4 = null;
            }
            return this.f1660d.f(i2, arrayList);
        }
        return invokeCommon.intValue;
    }
}
