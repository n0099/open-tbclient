package c.a.e.e.n.n;

import android.text.TextUtils;
import c.a.e.e.n.j.e;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<c.a.e.e.n.j.d> a(c.a.e.e.n.j.a aVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, aVar, z)) == null) {
            ArrayList<c.a.e.e.n.j.d> arrayList = new ArrayList<>();
            File[] b2 = c.a.e.e.n.j.b.b(aVar.E(), z);
            if (b2 != null) {
                for (File file : b2) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(aVar.h()) && name.contains("Uploading")) {
                            long length = file.length();
                            if (z && file.getPath().contains("/notUpload")) {
                                name = "notUpload/" + file.getName();
                            }
                            arrayList.add(new c.a.e.e.n.j.d(name, length, file.lastModified()));
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<c.a.e.e.n.j.d> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (aVar.h() != "stat") {
                Iterator<c.a.e.e.n.j.d> it = arrayList.iterator();
                while (it.hasNext()) {
                    c.a.e.e.n.j.d next = it.next();
                    if (next != null) {
                        long j2 = next.f2413c;
                        if (j2 != 0 && j2 + 604800000 < currentTimeMillis) {
                            arrayList3.add(next.f2412b);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList3.size() > 0) {
                c.a.e.e.n.j.b.a(arrayList3, aVar.E());
            }
            return arrayList;
        }
        return (ArrayList) invokeLZ.objValue;
    }

    public static BdUploadingLogInfo b(c.a.e.e.n.j.a aVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, aVar, z)) == null) {
            ArrayList<c.a.e.e.n.j.d> a2 = a(aVar, z);
            BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getWriteDir(), aVar.E(), aVar.A());
            if (a2 != null && a2.size() > 0) {
                if (a2.size() > 1) {
                    Collections.sort(a2, new e());
                }
                ArrayList arrayList = new ArrayList();
                int size = a2.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    c.a.e.e.n.j.d dVar = a2.get(i2);
                    j2 += dVar.f2411a;
                    arrayList.add(dVar);
                    if (j2 >= ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
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
        return (BdUploadingLogInfo) invokeLZ.objValue;
    }
}
