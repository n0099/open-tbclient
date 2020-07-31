package com.baidu.live.adp.lib.disk.ops;

import android.text.TextUtils;
import com.baidu.live.adp.lib.disk.DiskFileComparator;
import com.baidu.live.adp.lib.disk.ops.DiskFileOperate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class LogDiskFileOperate extends DiskFileOperate implements DiskFileComparator {
    private ArrayList<String> list;

    public LogDiskFileOperate(String str, String str2, DiskFileOperate.Action action, ArrayList<String> arrayList) {
        super(str, str2, action);
        this.list = arrayList;
    }

    @Override // com.baidu.live.adp.lib.disk.DiskFileComparator
    public boolean compare(File file) {
        if (this.list == null) {
            return false;
        }
        if (file != null) {
            String name = file.getName();
            if (!TextUtils.isEmpty(name)) {
                Iterator<String> it = this.list.iterator();
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
