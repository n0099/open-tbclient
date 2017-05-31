package com.baidu.tbadk.browser;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class w implements com.baidu.tbadk.core.d.l {
    final /* synthetic */ TbWebViewActivity Qs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbWebViewActivity tbWebViewActivity) {
        this.Qs = tbWebViewActivity;
    }

    @Override // com.baidu.tbadk.core.d.l
    public void j(List<Long> list) {
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
                    com.baidu.adp.lib.stats.c fN = com.baidu.tbadk.j.z.fN();
                    fN.c("frame_delta", sb.toString());
                    BdStatisticsManager.getInstance().performance("webview", fN);
                    return;
                }
            }
        }
    }
}
