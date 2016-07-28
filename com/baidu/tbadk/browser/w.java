package com.baidu.tbadk.browser;

import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class w implements com.baidu.tbadk.core.c.l {
    final /* synthetic */ TbWebViewActivity Kw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbWebViewActivity tbWebViewActivity) {
        this.Kw = tbWebViewActivity;
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
                    com.baidu.adp.lib.stats.d dG = com.baidu.tbadk.performanceLog.z.dG();
                    dG.c("frame_delta", sb.toString());
                    com.baidu.adp.lib.stats.a.dN().a("webview", dG);
                    return;
                }
            }
        }
    }
}
