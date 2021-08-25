package c.a.q0.a4.l.c.d;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
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
            if (pVar == null || fVar == null || pVar.f15850e == null) {
                return null;
            }
            long[] a2 = a(pVar.f15847b, pVar.f15846a);
            MultiMediaData multiMediaData = pVar.f15850e;
            n nVar = new n();
            nVar.f15839e = new ArrayList();
            nVar.f15835a = multiMediaData.path;
            nVar.f15837c = pVar.f15848c;
            nVar.f15838d = pVar.f15849d;
            nVar.f15836b = multiMediaData.rotation;
            for (int i2 = 0; i2 < pVar.f15847b; i2++) {
                long j2 = multiMediaData.start + a2[i2];
                h hVar = new h();
                hVar.f15816a = a.b(multiMediaData.path, j2, multiMediaData.type);
                hVar.f15817b = multiMediaData.path;
                hVar.f15821f = i2;
                hVar.f15822g = multiMediaData.type;
                hVar.f15823h = pVar.f15848c;
                hVar.f15824i = pVar.f15849d;
                hVar.f15825j = fVar;
                hVar.f15819d = j2;
                hVar.f15818c = multiMediaData.rotation;
                nVar.f15839e.add(hVar);
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
            if (oVar == null || fVar == null || oVar.f15841b <= 0 || c.a.w0.t.h.e(oVar.f15844e) || c.a.w0.t.h.e(oVar.f15845f)) {
                return null;
            }
            long[] a2 = a(oVar.f15841b, oVar.f15840a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i2 = 0; i2 < oVar.f15841b; i2++) {
                long j2 = ((float) a2[i2]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f15844e, j2);
                MultiMediaData multiMediaData2 = (MultiMediaData) c.a.w0.t.h.c(oVar.f15845f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f15839e = new ArrayList();
                        nVar.f15835a = multiMediaData2.path;
                        nVar.f15837c = oVar.f15842c;
                        nVar.f15838d = oVar.f15843d;
                        nVar.f15836b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) c.a.w0.t.h.c(oVar.f15844e, findInputIndexInSegments), j2) * 1000;
                    h hVar = new h();
                    hVar.f15816a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f15817b = multiMediaData2.path;
                    hVar.f15821f = i2;
                    hVar.f15822g = multiMediaData2.type;
                    hVar.f15823h = oVar.f15842c;
                    hVar.f15824i = oVar.f15843d;
                    hVar.f15819d = multiMediaDataSeekTime;
                    hVar.f15825j = fVar;
                    hVar.f15818c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f15839e) != null) {
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
