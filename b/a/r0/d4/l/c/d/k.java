package b.a.r0.d4.l.c.d;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long[] a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
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
                jArr[i6] = fArr[i6] * ((float) j) * 1000.0f;
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static n b(p pVar, f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pVar, fVar)) == null) {
            if (pVar == null || fVar == null || pVar.f17197e == null) {
                return null;
            }
            long[] a2 = a(pVar.f17194b, pVar.f17193a);
            MultiMediaData multiMediaData = pVar.f17197e;
            n nVar = new n();
            nVar.f17186e = new ArrayList();
            nVar.f17182a = multiMediaData.path;
            nVar.f17184c = pVar.f17195c;
            nVar.f17185d = pVar.f17196d;
            nVar.f17183b = multiMediaData.rotation;
            for (int i2 = 0; i2 < pVar.f17194b; i2++) {
                long j = multiMediaData.start + a2[i2];
                h hVar = new h();
                hVar.f17164a = a.b(multiMediaData.path, j, multiMediaData.type);
                hVar.f17165b = multiMediaData.path;
                hVar.f17169f = i2;
                hVar.f17170g = multiMediaData.type;
                hVar.f17171h = pVar.f17195c;
                hVar.f17172i = pVar.f17196d;
                hVar.j = fVar;
                hVar.f17167d = j;
                hVar.f17166c = multiMediaData.rotation;
                nVar.f17186e.add(hVar);
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
            if (oVar == null || fVar == null || oVar.f17188b <= 0 || b.a.x0.t.h.e(oVar.f17191e) || b.a.x0.t.h.e(oVar.f17192f)) {
                return null;
            }
            long[] a2 = a(oVar.f17188b, oVar.f17187a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i2 = 0; i2 < oVar.f17188b; i2++) {
                long j = ((float) a2[i2]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f17191e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) b.a.x0.t.h.c(oVar.f17192f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f17186e = new ArrayList();
                        nVar.f17182a = multiMediaData2.path;
                        nVar.f17184c = oVar.f17189c;
                        nVar.f17185d = oVar.f17190d;
                        nVar.f17183b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) b.a.x0.t.h.c(oVar.f17191e, findInputIndexInSegments), j) * 1000;
                    h hVar = new h();
                    hVar.f17164a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f17165b = multiMediaData2.path;
                    hVar.f17169f = i2;
                    hVar.f17170g = multiMediaData2.type;
                    hVar.f17171h = oVar.f17189c;
                    hVar.f17172i = oVar.f17190d;
                    hVar.f17167d = multiMediaDataSeekTime;
                    hVar.j = fVar;
                    hVar.f17166c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f17186e) != null) {
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
