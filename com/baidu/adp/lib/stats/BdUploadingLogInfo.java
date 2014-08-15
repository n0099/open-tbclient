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
            String a = a(arrayList.get(i2).b);
            if (!TextUtils.isEmpty(a)) {
                String[] split = a.split("\r\n");
                for (String str : split) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    private String a(String str) {
        com.baidu.adp.lib.Disk.ops.e eVar = new com.baidu.adp.lib.Disk.ops.e(this.mLogDir, str, DiskFileOperate.Action.READ);
        eVar.e(this.mUseSdCard);
        if (this.mCanTrySuccess) {
            eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            eVar.a(3);
        }
        com.baidu.adp.lib.Disk.d.a().a(eVar);
        if (eVar.g()) {
            return eVar.v();
        }
        return null;
    }
}
