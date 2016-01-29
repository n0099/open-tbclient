package com.baidu.tbadk.core.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ AppDownloadView aeZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AppDownloadView appDownloadView, int i) {
        super(i);
        this.aeZ = appDownloadView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
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
            downloadData = this.aeZ.aeV;
            if (downloadData != null) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= data.size()) {
                        break;
                    }
                    downloadData2 = data.get(i2);
                    downloadData3 = this.aeZ.aeV;
                    if (!TextUtils.isEmpty(downloadData3.getId())) {
                        downloadData4 = this.aeZ.aeV;
                    } else {
                        i = i2 + 1;
                    }
                }
                downloadData2 = null;
                if (downloadData2 != null) {
                    this.aeZ.cT((int) ((downloadData2.getLength() * 100) / downloadData2.getSize()));
                }
            }
        }
    }
}
