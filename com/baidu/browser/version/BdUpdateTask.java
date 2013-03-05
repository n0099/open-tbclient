package com.baidu.browser.version;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.browser.core.net.BdNet;
import com.baidu.browser.core.net.BdNetListener;
import com.baidu.browser.core.net.BdNetTask;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes.dex */
public class BdUpdateTask extends AsyncTask implements BdNetListener {
    public static final String UPDATE_URL = "http://shahe.baidu.com/update.php";
    private Context mContext;
    private BdNet mNet;

    public BdUpdateTask(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public String doInBackground(String... strArr) {
        checkUpdate();
        return null;
    }

    private void checkUpdate() {
        String ccSeid = BdUpdateUtil.ccSeid(BdUpdateUtil.processUrl(this.mContext, UPDATE_URL));
        BdLog.v("url=" + ccSeid);
        if (this.mNet == null) {
            this.mNet = new BdNet();
            this.mNet.setEventListener(this);
        }
        this.mNet.obtainTask(ccSeid).start();
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        return false;
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        BdLog.i(bdNetTask.getUrl());
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }
}
