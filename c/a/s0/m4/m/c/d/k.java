package c.a.s0.m4.m.c.d;

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
            if (pVar == null || fVar == null || pVar.f19833e == null) {
                return null;
            }
            long[] a = a(pVar.f19830b, pVar.a);
            MultiMediaData multiMediaData = pVar.f19833e;
            n nVar = new n();
            nVar.f19824e = new ArrayList();
            nVar.a = multiMediaData.path;
            nVar.f19822c = pVar.f19831c;
            nVar.f19823d = pVar.f19832d;
            nVar.f19821b = multiMediaData.rotation;
            for (int i2 = 0; i2 < pVar.f19830b; i2++) {
                long j2 = multiMediaData.start + a[i2];
                h hVar = new h();
                hVar.a = a.b(multiMediaData.path, j2, multiMediaData.type);
                hVar.f19806b = multiMediaData.path;
                hVar.f19810f = i2;
                hVar.f19811g = multiMediaData.type;
                hVar.f19812h = pVar.f19831c;
                hVar.f19813i = pVar.f19832d;
                hVar.f19814j = fVar;
                hVar.f19808d = j2;
                hVar.f19807c = multiMediaData.rotation;
                nVar.f19824e.add(hVar);
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
            if (oVar == null || fVar == null || oVar.f19825b <= 0 || c.a.y0.t.h.e(oVar.f19828e) || c.a.y0.t.h.e(oVar.f19829f)) {
                return null;
            }
            long[] a = a(oVar.f19825b, oVar.a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i2 = 0; i2 < oVar.f19825b; i2++) {
                long j2 = ((float) a[i2]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f19828e, j2);
                MultiMediaData multiMediaData2 = (MultiMediaData) c.a.y0.t.h.c(oVar.f19829f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f19824e = new ArrayList();
                        nVar.a = multiMediaData2.path;
                        nVar.f19822c = oVar.f19826c;
                        nVar.f19823d = oVar.f19827d;
                        nVar.f19821b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) c.a.y0.t.h.c(oVar.f19828e, findInputIndexInSegments), j2) * 1000;
                    h hVar = new h();
                    hVar.a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f19806b = multiMediaData2.path;
                    hVar.f19810f = i2;
                    hVar.f19811g = multiMediaData2.type;
                    hVar.f19812h = oVar.f19826c;
                    hVar.f19813i = oVar.f19827d;
                    hVar.f19808d = multiMediaDataSeekTime;
                    hVar.f19814j = fVar;
                    hVar.f19807c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f19824e) != null) {
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
