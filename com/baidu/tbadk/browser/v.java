package com.baidu.tbadk.browser;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.core.d.l {
    final /* synthetic */ TbWebViewActivity QU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TbWebViewActivity tbWebViewActivity) {
        this.QU = tbWebViewActivity;
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
                    com.baidu.adp.lib.stats.c fH = com.baidu.tbadk.performanceLog.z.fH();
                    fH.c("frame_delta", sb.toString());
                    BdStatisticsManager.getInstance().performance("webview", fH);
                    return;
                }
            }
        }
    }
}
