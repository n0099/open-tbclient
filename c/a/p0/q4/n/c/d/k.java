package c.a.p0.q4.n.c.d;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long[] a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (i < 0) {
                i = 0;
            }
            float[] fArr = new float[i];
            if (i > 1) {
                float f2 = 1.0f / i;
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2 + 1;
                    if (i3 == i) {
                        int i4 = i2 - 1;
                        fArr[i2] = fArr[i4] + ((1.0f - fArr[i4]) / 2.0f);
                    } else {
                        fArr[i2] = i3 * f2;
                    }
                    i2 = i3;
                }
            } else if (i == 1) {
                fArr[0] = 0.5f;
            }
            long[] jArr = new long[i];
            for (int i5 = 0; i5 < i; i5++) {
                jArr[i5] = fArr[i5] * ((float) j) * 1000.0f;
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static n b(p pVar, f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pVar, fVar)) == null) {
            if (pVar == null || fVar == null || pVar.f17873e == null) {
                return null;
            }
            long[] a = a(pVar.f17870b, pVar.a);
            MultiMediaData multiMediaData = pVar.f17873e;
            n nVar = new n();
            nVar.f17864e = new ArrayList();
            nVar.a = multiMediaData.path;
            nVar.f17862c = pVar.f17871c;
            nVar.f17863d = pVar.f17872d;
            nVar.f17861b = multiMediaData.rotation;
            for (int i = 0; i < pVar.f17870b; i++) {
                long j = multiMediaData.start + a[i];
                h hVar = new h();
                hVar.a = a.b(multiMediaData.path, j, multiMediaData.type);
                hVar.f17850b = multiMediaData.path;
                hVar.f17854f = i;
                hVar.f17855g = multiMediaData.type;
                hVar.f17856h = pVar.f17871c;
                hVar.i = pVar.f17872d;
                hVar.j = fVar;
                hVar.f17852d = j;
                hVar.f17851c = multiMediaData.rotation;
                nVar.f17864e.add(hVar);
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
            if (oVar == null || fVar == null || oVar.f17865b <= 0 || c.a.v0.r.h.e(oVar.f17868e) || c.a.v0.r.h.e(oVar.f17869f)) {
                return null;
            }
            long[] a = a(oVar.f17865b, oVar.a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i = 0; i < oVar.f17865b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f17868e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) c.a.v0.r.h.c(oVar.f17869f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f17864e = new ArrayList();
                        nVar.a = multiMediaData2.path;
                        nVar.f17862c = oVar.f17866c;
                        nVar.f17863d = oVar.f17867d;
                        nVar.f17861b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) c.a.v0.r.h.c(oVar.f17868e, findInputIndexInSegments), j) * 1000;
                    h hVar = new h();
                    hVar.a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f17850b = multiMediaData2.path;
                    hVar.f17854f = i;
                    hVar.f17855g = multiMediaData2.type;
                    hVar.f17856h = oVar.f17866c;
                    hVar.i = oVar.f17867d;
                    hVar.f17852d = multiMediaDataSeekTime;
                    hVar.j = fVar;
                    hVar.f17851c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f17864e) != null) {
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
