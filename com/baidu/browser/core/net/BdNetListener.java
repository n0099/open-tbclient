package com.baidu.browser.core.net;

import com.baidu.browser.core.net.BdNet;
/* loaded from: classes.dex */
public interface BdNetListener {
    void onNetDownloadComplete(BdNet bdNet);

    void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i);

    void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i);

    void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask);

    boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i);

    void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i);

    void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i);

    void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask);

    void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask);

    void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask);

    void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2);
}
