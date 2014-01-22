package com.baidu.adp.lib.stats;

import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String a = h.a(this.a, false);
            com.baidu.adp.lib.network.f a2 = com.baidu.adp.lib.network.e.a().a(h.a(this.a), TextUtils.isEmpty(a) ? null : a.getBytes(), 3, null, null, null);
            if (a2 != null) {
                String str = new String(a2.d, "utf-8");
                if (!TextUtils.isEmpty(str)) {
                    BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
                    bdStatSwitchData.parserJson(str);
                    if (bdStatSwitchData.getError_code() == 0) {
                        n.a().a(a2.d, h.b(this.a));
                        h.a(this.a, bdStatSwitchData);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(getClass(), "syncSwitch", e);
        }
    }
}
