package com.baidu.tbadk.browser;

import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.core.c.k {
    final /* synthetic */ TbWebViewActivity PH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbWebViewActivity tbWebViewActivity) {
        this.PH = tbWebViewActivity;
    }

    @Override // com.baidu.tbadk.core.c.k
    public void k(List<Long> list) {
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
                    com.baidu.adp.lib.stats.d hs = com.baidu.tbadk.performanceLog.z.hs();
                    hs.b("frame_delta", sb.toString());
                    com.baidu.adp.lib.stats.a.hz().a("webview", hs);
                    return;
                }
            }
        }
    }
}
