package c.a.p0.a4.l.c.d;

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
            if (pVar == null || fVar == null || pVar.f15564e == null) {
                return null;
            }
            long[] a2 = a(pVar.f15561b, pVar.f15560a);
            MultiMediaData multiMediaData = pVar.f15564e;
            n nVar = new n();
            nVar.f15553e = new ArrayList();
            nVar.f15549a = multiMediaData.path;
            nVar.f15551c = pVar.f15562c;
            nVar.f15552d = pVar.f15563d;
            nVar.f15550b = multiMediaData.rotation;
            for (int i2 = 0; i2 < pVar.f15561b; i2++) {
                long j2 = multiMediaData.start + a2[i2];
                h hVar = new h();
                hVar.f15530a = a.b(multiMediaData.path, j2, multiMediaData.type);
                hVar.f15531b = multiMediaData.path;
                hVar.f15535f = i2;
                hVar.f15536g = multiMediaData.type;
                hVar.f15537h = pVar.f15562c;
                hVar.f15538i = pVar.f15563d;
                hVar.f15539j = fVar;
                hVar.f15533d = j2;
                hVar.f15532c = multiMediaData.rotation;
                nVar.f15553e.add(hVar);
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
            if (oVar == null || fVar == null || oVar.f15555b <= 0 || c.a.v0.t.h.e(oVar.f15558e) || c.a.v0.t.h.e(oVar.f15559f)) {
                return null;
            }
            long[] a2 = a(oVar.f15555b, oVar.f15554a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i2 = 0; i2 < oVar.f15555b; i2++) {
                long j2 = ((float) a2[i2]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f15558e, j2);
                MultiMediaData multiMediaData2 = (MultiMediaData) c.a.v0.t.h.c(oVar.f15559f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f15553e = new ArrayList();
                        nVar.f15549a = multiMediaData2.path;
                        nVar.f15551c = oVar.f15556c;
                        nVar.f15552d = oVar.f15557d;
                        nVar.f15550b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) c.a.v0.t.h.c(oVar.f15558e, findInputIndexInSegments), j2) * 1000;
                    h hVar = new h();
                    hVar.f15530a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f15531b = multiMediaData2.path;
                    hVar.f15535f = i2;
                    hVar.f15536g = multiMediaData2.type;
                    hVar.f15537h = oVar.f15556c;
                    hVar.f15538i = oVar.f15557d;
                    hVar.f15533d = multiMediaDataSeekTime;
                    hVar.f15539j = fVar;
                    hVar.f15532c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f15553e) != null) {
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
