package c.a.t0.n4.m.c.d;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
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
            if (pVar == null || fVar == null || pVar.f20571e == null) {
                return null;
            }
            long[] a = a(pVar.f20568b, pVar.a);
            MultiMediaData multiMediaData = pVar.f20571e;
            n nVar = new n();
            nVar.f20562e = new ArrayList();
            nVar.a = multiMediaData.path;
            nVar.f20560c = pVar.f20569c;
            nVar.f20561d = pVar.f20570d;
            nVar.f20559b = multiMediaData.rotation;
            for (int i2 = 0; i2 < pVar.f20568b; i2++) {
                long j2 = multiMediaData.start + a[i2];
                h hVar = new h();
                hVar.a = a.b(multiMediaData.path, j2, multiMediaData.type);
                hVar.f20544b = multiMediaData.path;
                hVar.f20548f = i2;
                hVar.f20549g = multiMediaData.type;
                hVar.f20550h = pVar.f20569c;
                hVar.f20551i = pVar.f20570d;
                hVar.f20552j = fVar;
                hVar.f20546d = j2;
                hVar.f20545c = multiMediaData.rotation;
                nVar.f20562e.add(hVar);
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
            if (oVar == null || fVar == null || oVar.f20563b <= 0 || c.a.a1.t.h.e(oVar.f20566e) || c.a.a1.t.h.e(oVar.f20567f)) {
                return null;
            }
            long[] a = a(oVar.f20563b, oVar.a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i2 = 0; i2 < oVar.f20563b; i2++) {
                long j2 = ((float) a[i2]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f20566e, j2);
                MultiMediaData multiMediaData2 = (MultiMediaData) c.a.a1.t.h.c(oVar.f20567f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f20562e = new ArrayList();
                        nVar.a = multiMediaData2.path;
                        nVar.f20560c = oVar.f20564c;
                        nVar.f20561d = oVar.f20565d;
                        nVar.f20559b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) c.a.a1.t.h.c(oVar.f20566e, findInputIndexInSegments), j2) * 1000;
                    h hVar = new h();
                    hVar.a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f20544b = multiMediaData2.path;
                    hVar.f20548f = i2;
                    hVar.f20549g = multiMediaData2.type;
                    hVar.f20550h = oVar.f20564c;
                    hVar.f20551i = oVar.f20565d;
                    hVar.f20546d = multiMediaDataSeekTime;
                    hVar.f20552j = fVar;
                    hVar.f20545c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f20562e) != null) {
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
