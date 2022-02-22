package c.a.u0.q4.m.c.d;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long[] a(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            float[] fArr = new float[i2];
            if (i2 > 1) {
                float f2 = 1.0f / i2;
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = i3 + 1;
                    if (i4 == i2) {
                        int i5 = i3 - 1;
                        fArr[i3] = fArr[i5] + ((1.0f - fArr[i5]) / 2.0f);
                    } else {
                        fArr[i3] = i4 * f2;
                    }
                    i3 = i4;
                }
            } else if (i2 == 1) {
                fArr[0] = 0.5f;
            }
            long[] jArr = new long[i2];
            for (int i6 = 0; i6 < i2; i6++) {
                jArr[i6] = fArr[i6] * ((float) j2) * 1000.0f;
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static n b(p pVar, f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pVar, fVar)) == null) {
            if (pVar == null || fVar == null || pVar.f21690e == null) {
                return null;
            }
            long[] a = a(pVar.f21687b, pVar.a);
            MultiMediaData multiMediaData = pVar.f21690e;
            n nVar = new n();
            nVar.f21681e = new ArrayList();
            nVar.a = multiMediaData.path;
            nVar.f21679c = pVar.f21688c;
            nVar.f21680d = pVar.f21689d;
            nVar.f21678b = multiMediaData.rotation;
            for (int i2 = 0; i2 < pVar.f21687b; i2++) {
                long j2 = multiMediaData.start + a[i2];
                h hVar = new h();
                hVar.a = a.b(multiMediaData.path, j2, multiMediaData.type);
                hVar.f21663b = multiMediaData.path;
                hVar.f21667f = i2;
                hVar.f21668g = multiMediaData.type;
                hVar.f21669h = pVar.f21688c;
                hVar.f21670i = pVar.f21689d;
                hVar.f21671j = fVar;
                hVar.f21665d = j2;
                hVar.f21664c = multiMediaData.rotation;
                nVar.f21681e.add(hVar);
            }
            return nVar;
        }
        return (n) invokeLL.objValue;
    }

    public static List<n> c(o oVar, f fVar) {
        InterceptResult invokeLL;
        List<h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, oVar, fVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (oVar == null || fVar == null || oVar.f21682b <= 0 || c.a.b1.t.h.e(oVar.f21685e) || c.a.b1.t.h.e(oVar.f21686f)) {
                return null;
            }
            long[] a = a(oVar.f21682b, oVar.a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i2 = 0; i2 < oVar.f21682b; i2++) {
                long j2 = ((float) a[i2]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f21685e, j2);
                MultiMediaData multiMediaData2 = (MultiMediaData) c.a.b1.t.h.c(oVar.f21686f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f21681e = new ArrayList();
                        nVar.a = multiMediaData2.path;
                        nVar.f21679c = oVar.f21683c;
                        nVar.f21680d = oVar.f21684d;
                        nVar.f21678b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) c.a.b1.t.h.c(oVar.f21685e, findInputIndexInSegments), j2) * 1000;
                    h hVar = new h();
                    hVar.a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f21663b = multiMediaData2.path;
                    hVar.f21667f = i2;
                    hVar.f21668g = multiMediaData2.type;
                    hVar.f21669h = oVar.f21683c;
                    hVar.f21670i = oVar.f21684d;
                    hVar.f21665d = multiMediaDataSeekTime;
                    hVar.f21671j = fVar;
                    hVar.f21664c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f21681e) != null) {
                        list.add(hVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
