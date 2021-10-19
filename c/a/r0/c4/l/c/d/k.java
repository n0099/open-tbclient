package c.a.r0.c4.l.c.d;

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
            if (pVar == null || fVar == null || pVar.f16555e == null) {
                return null;
            }
            long[] a2 = a(pVar.f16552b, pVar.f16551a);
            MultiMediaData multiMediaData = pVar.f16555e;
            n nVar = new n();
            nVar.f16544e = new ArrayList();
            nVar.f16540a = multiMediaData.path;
            nVar.f16542c = pVar.f16553c;
            nVar.f16543d = pVar.f16554d;
            nVar.f16541b = multiMediaData.rotation;
            for (int i2 = 0; i2 < pVar.f16552b; i2++) {
                long j2 = multiMediaData.start + a2[i2];
                h hVar = new h();
                hVar.f16521a = a.b(multiMediaData.path, j2, multiMediaData.type);
                hVar.f16522b = multiMediaData.path;
                hVar.f16526f = i2;
                hVar.f16527g = multiMediaData.type;
                hVar.f16528h = pVar.f16553c;
                hVar.f16529i = pVar.f16554d;
                hVar.f16530j = fVar;
                hVar.f16524d = j2;
                hVar.f16523c = multiMediaData.rotation;
                nVar.f16544e.add(hVar);
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
            if (oVar == null || fVar == null || oVar.f16546b <= 0 || c.a.x0.t.h.e(oVar.f16549e) || c.a.x0.t.h.e(oVar.f16550f)) {
                return null;
            }
            long[] a2 = a(oVar.f16546b, oVar.f16545a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i2 = 0; i2 < oVar.f16546b; i2++) {
                long j2 = ((float) a2[i2]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f16549e, j2);
                MultiMediaData multiMediaData2 = (MultiMediaData) c.a.x0.t.h.c(oVar.f16550f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f16544e = new ArrayList();
                        nVar.f16540a = multiMediaData2.path;
                        nVar.f16542c = oVar.f16547c;
                        nVar.f16543d = oVar.f16548d;
                        nVar.f16541b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) c.a.x0.t.h.c(oVar.f16549e, findInputIndexInSegments), j2) * 1000;
                    h hVar = new h();
                    hVar.f16521a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f16522b = multiMediaData2.path;
                    hVar.f16526f = i2;
                    hVar.f16527g = multiMediaData2.type;
                    hVar.f16528h = oVar.f16547c;
                    hVar.f16529i = oVar.f16548d;
                    hVar.f16524d = multiMediaDataSeekTime;
                    hVar.f16530j = fVar;
                    hVar.f16523c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f16544e) != null) {
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
