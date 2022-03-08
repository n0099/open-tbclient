package c.a.d.f.n.n;

import android.text.TextUtils;
import c.a.d.f.n.j.e;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<c.a.d.f.n.j.d> a(c.a.d.f.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] b2 = c.a.d.f.n.j.c.b(aVar.C());
            if (b2 != null) {
                for (File file : b2) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(aVar.h()) && name.contains("Uploading")) {
                            arrayList.add(new c.a.d.f.n.j.d(name, file.length(), file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<c.a.d.f.n.j.d> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.f.n.j.d dVar = (c.a.d.f.n.j.d) it.next();
                if (dVar != null) {
                    long j2 = dVar.f2746c;
                    if (j2 != 0 && j2 + 604800000 < currentTimeMillis) {
                        arrayList3.add(dVar.f2745b);
                    } else {
                        arrayList2.add(dVar);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                c.a.d.f.n.j.c.a(arrayList3, aVar.C());
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static BdUploadingLogInfo b(c.a.d.f.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            ArrayList<c.a.d.f.n.j.d> a = a(aVar);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.C(), aVar.A());
            if (a != null && a.size() > 0) {
                if (a.size() > 1) {
                    Collections.sort(a, new e());
                }
                ArrayList arrayList = new ArrayList();
                int size = a.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    c.a.d.f.n.j.d dVar = a.get(i2);
                    j2 += dVar.a;
                    arrayList.add(dVar);
                    if (j2 >= 20480) {
                        bdUploadingLogInfo.add(arrayList);
                        arrayList = new ArrayList();
                        j2 = 0;
                    }
                }
                if (arrayList.size() > 0) {
                    bdUploadingLogInfo.add(arrayList);
                }
            }
            return bdUploadingLogInfo;
        }
        return (BdUploadingLogInfo) invokeL.objValue;
    }
}
