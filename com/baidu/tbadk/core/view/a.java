package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    final /* synthetic */ AppDownloadView aaS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AppDownloadView appDownloadView, int i) {
        super(i);
        this.aaS = appDownloadView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
        if (r0.getId().equals(r1.getId()) != false) goto L17;
     */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DownloadData downloadData;
        DownloadData downloadData2;
        DownloadData downloadData3;
        DownloadData downloadData4;
        if (customResponsedMessage instanceof DownloadMessage) {
            downloadData = this.aaS.aaO;
            if (downloadData != null) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= data.size()) {
                        break;
                    }
                    downloadData2 = data.get(i2);
                    downloadData3 = this.aaS.aaO;
                    if (!TextUtils.isEmpty(downloadData3.getId())) {
                        downloadData4 = this.aaS.aaO;
                    } else {
                        i = i2 + 1;
                    }
                }
                if (downloadData2 != null) {
                    this.aaS.cG((int) ((downloadData2.getLength() * 100) / downloadData2.getSize()));
                    this.aaS.postInvalidate();
                }
            }
        }
    }
}
