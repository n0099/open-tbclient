package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BdUploadingLogInfo extends ArrayList<ArrayList<s>> {
    private boolean mCanTrySuccess;
    private String mLogDir;
    private boolean mUseSdCard;

    public BdUploadingLogInfo(String str, boolean z, boolean z2) {
        this.mLogDir = null;
        this.mLogDir = str;
        this.mUseSdCard = z;
        this.mCanTrySuccess = z2;
    }

    public ArrayList<String> getLogStringByIndex(int i) {
        ArrayList<s> arrayList = get(i);
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String ap = ap(arrayList.get(i2).mFileName);
            if (!TextUtils.isEmpty(ap)) {
                String[] split = ap.split("\r\n");
                for (String str : split) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    private String ap(String str) {
        com.baidu.adp.lib.Disk.ops.e eVar = new com.baidu.adp.lib.Disk.ops.e(this.mLogDir, str, DiskFileOperate.Action.READ);
        eVar.q(this.mUseSdCard);
        if (this.mCanTrySuccess) {
            eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            eVar.G(3);
        }
        com.baidu.adp.lib.Disk.d.fp().b(eVar);
        if (eVar.isSuccess()) {
            return eVar.getContent();
        }
        return null;
    }
}
