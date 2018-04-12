package com.baidu.adp.lib.Disk.ops;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
    private ArrayList<String> qs;

    public e(String str, String str2, DiskFileOperate.Action action, ArrayList<String> arrayList) {
        super(str, str2, action);
        this.qs = arrayList;
    }

    @Override // com.baidu.adp.lib.Disk.a
    public boolean d(File file) {
        if (this.qs == null) {
            return false;
        }
        if (file != null) {
            String name = file.getName();
            if (!TextUtils.isEmpty(name)) {
                Iterator<String> it = this.qs.iterator();
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
