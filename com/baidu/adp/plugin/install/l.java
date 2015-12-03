package com.baidu.adp.plugin.install;

import com.baidu.adp.plugin.install.d;
import java.util.Comparator;
import java.util.HashMap;
/* loaded from: classes.dex */
class l implements Comparator<String> {
    final /* synthetic */ d.a Db;
    private final /* synthetic */ HashMap Dc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d.a aVar, HashMap hashMap) {
        this.Db = aVar;
        this.Dc = hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        com.baidu.adp.plugin.packageManager.a.a aVar = (com.baidu.adp.plugin.packageManager.a.a) this.Dc.get(str);
        com.baidu.adp.plugin.packageManager.a.a aVar2 = (com.baidu.adp.plugin.packageManager.a.a) this.Dc.get(str2);
        if (aVar != null && aVar2 != null) {
            return aVar2.getPriority() - aVar.getPriority();
        }
        if (aVar != null && aVar2 == null) {
            return -1;
        }
        if (aVar == null && aVar2 != null) {
            return 1;
        }
        return 0;
    }
}
