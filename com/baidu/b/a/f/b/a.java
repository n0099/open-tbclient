package com.baidu.b.a.f.b;

import com.baidu.b.a.b.c.b;
import com.baidu.b.a.f.d.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static void w(List<b> list) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            List<com.baidu.b.a.c.a.a> downloadItems = bVar.getDownloadItems();
            if (downloadItems != null) {
                arrayList.addAll(downloadItems);
                new com.baidu.b.a.f.d.a(i.a(downloadItems, bVar), bVar).startDownload();
            }
        }
    }
}
