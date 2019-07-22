package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class BdUploadingLogInfo extends ArrayList<ArrayList<com.baidu.adp.lib.stats.base.c>> {
    private static final long serialVersionUID = -1737585838278753290L;
    private String mLogDir;
    private boolean mMustSuccess;
    private boolean mUseSdCard;

    public BdUploadingLogInfo(String str, boolean z, boolean z2) {
        this.mLogDir = null;
        this.mLogDir = str;
        this.mUseSdCard = z;
        this.mMustSuccess = z2;
    }

    public ArrayList<String> getLogStringByIndex(int i, ArrayList<String> arrayList) {
        String[] split;
        boolean z;
        int size = arrayList != null ? arrayList.size() : 0;
        ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2 = get(i);
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            String aQ = aQ(arrayList2.get(i2).mFileName);
            if (!TextUtils.isEmpty(aQ)) {
                for (String str : aQ.split("\r\n")) {
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

    private String aQ(String str) {
        d dVar = new d(this.mLogDir, str, DiskFileOperate.Action.READ);
        dVar.L(this.mUseSdCard);
        if (!this.mMustSuccess) {
            dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.Q(3);
        }
        com.baidu.adp.lib.Disk.d.gC().b(dVar);
        if (dVar.isSuccess()) {
            return dVar.getContent();
        }
        return null;
    }
}
