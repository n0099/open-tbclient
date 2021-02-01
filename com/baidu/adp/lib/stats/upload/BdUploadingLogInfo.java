package com.baidu.adp.lib.stats.upload;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class BdUploadingLogInfo extends ArrayList<ArrayList<com.baidu.adp.lib.stats.base.d>> {
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
        ArrayList<com.baidu.adp.lib.stats.base.d> arrayList2 = get(i);
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            String cc = cc(arrayList2.get(i2).mFileName);
            if (!TextUtils.isEmpty(cc)) {
                for (String str : cc.split("\r\n")) {
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
        ArrayList<com.baidu.adp.lib.stats.base.d> arrayList = get(i);
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String cc = cc(arrayList.get(i2).mFileName);
            if (!TextUtils.isEmpty(cc)) {
                String[] split = cc.split("\r\n");
                for (String str : split) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    private String cc(String str) {
        com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(this.mLogDir, str, DiskFileOperate.Action.READ);
        dVar.setSdCard(this.mUseSdCard);
        if (!this.mMustSuccess) {
            dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            dVar.setTrySuccessWeight(3);
        }
        com.baidu.adp.lib.Disk.d.lg().b(dVar);
        if (dVar.isSuccess()) {
            return dVar.getContent();
        }
        return null;
    }
}
