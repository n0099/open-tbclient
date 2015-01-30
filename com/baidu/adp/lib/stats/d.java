package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class d extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
    final /* synthetic */ BdNormalStatBase lJ;
    private ArrayList<String> lM;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BdNormalStatBase bdNormalStatBase, String str, String str2, DiskFileOperate.Action action, ArrayList<String> arrayList) {
        super(str, str2, action);
        this.lJ = bdNormalStatBase;
        this.lM = arrayList;
    }

    @Override // com.baidu.adp.lib.Disk.a
    public boolean c(File file) {
        if (this.lM == null) {
            return false;
        }
        if (file != null) {
            String name = file.getName();
            if (!TextUtils.isEmpty(name)) {
                Iterator<String> it = this.lM.iterator();
                while (it.hasNext()) {
                    if (name.equals(it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
