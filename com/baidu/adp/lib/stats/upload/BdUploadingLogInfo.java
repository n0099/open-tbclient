package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import d.b.c.e.n.h.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class BdUploadingLogInfo extends ArrayList<ArrayList<d>> {
    public static final long serialVersionUID = -1737585838278753290L;
    public String mLogDir;
    public boolean mMustSuccess;
    public boolean mUseSdCard;

    public BdUploadingLogInfo(String str, boolean z, boolean z2) {
        this.mLogDir = null;
        this.mLogDir = str;
        this.mUseSdCard = z;
        this.mMustSuccess = z2;
    }

    public final String a(String str) {
        d.b.c.e.a.f.d dVar = new d.b.c.e.a.f.d(this.mLogDir, str, DiskFileOperate.Action.READ);
        dVar.setSdCard(this.mUseSdCard);
        if (!this.mMustSuccess) {
            dVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        d.b.c.e.a.d.g().d(dVar);
        if (dVar.isSuccess()) {
            return dVar.a();
        }
        return null;
    }

    public ArrayList<String> getLogStringByIndex(int i, ArrayList<String> arrayList) {
        String[] split;
        boolean z;
        int size = arrayList != null ? arrayList.size() : 0;
        ArrayList<d> arrayList2 = get(i);
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            String a2 = a(arrayList2.get(i2).f42664b);
            if (!TextUtils.isEmpty(a2)) {
                for (String str : a2.split(Part.CRLF)) {
                    if (size > 0) {
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (str.contains(it.next())) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                        arrayList3.add(str);
                    }
                }
            }
        }
        return arrayList3;
    }

    public ArrayList<String> getTrackLogStringByIndex(int i) {
        ArrayList<d> arrayList = get(i);
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String a2 = a(arrayList.get(i2).f42664b);
            if (!TextUtils.isEmpty(a2)) {
                for (String str : a2.split(Part.CRLF)) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }
}
