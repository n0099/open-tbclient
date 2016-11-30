package com.baidu.tbadk.browser;

import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.core.c.l {
    final /* synthetic */ TbWebViewActivity MG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.MG = tbWebViewActivity;
    }

    @Override // com.baidu.tbadk.core.c.l
    public void m(List<Long> list) {
        if (list != null && list.size() != 0) {
            String str = "";
            StringBuilder sb = new StringBuilder();
            Iterator<Long> it = list.iterator();
            while (true) {
                String str2 = str;
                if (it.hasNext()) {
                    sb.append(str2);
                    sb.append(it.next());
                    str = "_";
                } else {
                    com.baidu.adp.lib.stats.d eB = com.baidu.tbadk.performanceLog.z.eB();
                    eB.c("frame_delta", sb.toString());
                    com.baidu.adp.lib.stats.a.eI().a("webview", eB);
                    return;
                }
            }
        }
    }
}
