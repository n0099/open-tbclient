package b.a.e.e.n.n;

import android.text.TextUtils;
import b.a.e.e.n.j.e;
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

    public static ArrayList<b.a.e.e.n.j.d> a(b.a.e.e.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] b2 = b.a.e.e.n.j.c.b(aVar.C());
            if (b2 != null) {
                for (File file : b2) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(aVar.h()) && name.contains("Uploading")) {
                            arrayList.add(new b.a.e.e.n.j.d(name, file.length(), file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<b.a.e.e.n.j.d> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b.a.e.e.n.j.d dVar = (b.a.e.e.n.j.d) it.next();
                if (dVar != null) {
                    long j = dVar.f1945c;
                    if (j != 0 && j + 604800000 < currentTimeMillis) {
                        arrayList3.add(dVar.f1944b);
                    } else {
                        arrayList2.add(dVar);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                b.a.e.e.n.j.c.a(arrayList3, aVar.C());
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static BdUploadingLogInfo b(b.a.e.e.n.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            ArrayList<b.a.e.e.n.j.d> a2 = a(aVar);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.C(), aVar.A());
            if (a2 != null && a2.size() > 0) {
                if (a2.size() > 1) {
                    Collections.sort(a2, new e());
                }
                ArrayList arrayList = new ArrayList();
                int size = a2.size();
                long j = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    b.a.e.e.n.j.d dVar = a2.get(i2);
                    j += dVar.f1943a;
                    arrayList.add(dVar);
                    if (j >= 20480) {
                        bdUploadingLogInfo.add(arrayList);
                        arrayList = new ArrayList();
                        j = 0;
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
