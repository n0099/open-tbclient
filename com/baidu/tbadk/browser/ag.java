package com.baidu.tbadk.browser;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ XiubaTbJsBridge QI;
    private boolean QJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(XiubaTbJsBridge xiubaTbJsBridge, int i) {
        super(i);
        this.QI = xiubaTbJsBridge;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof DownloadMessage) {
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() != null && downloadMessage.getData().size() > 0) {
                for (DownloadData downloadData : downloadMessage.getData()) {
                    if (downloadData != null && "com.xiu8.baidu.activity".equals(downloadData.getId())) {
                        if (downloadData.getStatus() == 5) {
                            if (!this.QJ) {
                                this.QJ = true;
                                this.QI.callDownloadListener(1);
                            }
                        } else if (downloadData.getStatus() == 0 || downloadData.getStatus() == 3) {
                            this.QI.callDownloadListener(2);
                            this.QJ = false;
                        } else if (downloadData.getStatus() == 2 || downloadData.getStatus() == 4) {
                            this.QI.callDownloadListener(0);
                            this.QJ = false;
                        }
                    }
                }
            }
        }
    }
}
