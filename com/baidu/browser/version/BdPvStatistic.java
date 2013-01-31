package com.baidu.browser.version;

import android.content.Context;
import com.baidu.browser.core.BdPath;
import com.baidu.browser.core.net.BdNet;
import com.baidu.browser.core.net.BdNetListener;
import com.baidu.browser.core.net.BdNetTask;
import com.baidu.browser.core.util.BdFileUtil;
import com.baidu.browser.core.util.BdLog;
/* loaded from: classes.dex */
public class BdPvStatistic implements BdNetListener {
    private static final String LAUHCH_FILENAME = "pv_launch";
    private static BdPvStatistic sInstance;
    private Context mContext;
    private int mLauchCount;
    private long mLauchTime;
    private BdNet mNet;
    private String mSubmitUrl = "http://shahe.baidu.com/reportinfo.php";

    private BdPvStatistic(Context context) {
        this.mContext = context;
    }

    public static BdPvStatistic getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new BdPvStatistic(context);
        }
        return sInstance;
    }

    public void addLauchCount() {
        this.mLauchCount = BdFileUtil.readPrivateFileToInt(BdPath.getInstance(this.mContext).getDirPv(), LAUHCH_FILENAME);
        this.mLauchCount++;
    }

    public void saveLauchCount() {
        BdFileUtil.writePrivateFile(String.valueOf(this.mLauchCount).getBytes(), BdPath.getInstance(this.mContext).getDirPv(), LAUHCH_FILENAME);
    }

    public void saveLauchTime() {
        this.mLauchTime = System.currentTimeMillis();
    }

    public void submitPv(boolean z) {
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= this.mLauchTime + 86400000) {
                submitPv();
                this.mLauchTime = currentTimeMillis;
                return;
            }
            return;
        }
        submitPv();
    }

    private void submitPv() {
        if (this.mLauchCount > 0) {
            BdLog.i("");
            String ccCnt = ccCnt(BdUpdateUtil.ccSeid(BdUpdateUtil.processUrl(this.mContext, this.mSubmitUrl)));
            BdLog.v("url=" + ccCnt);
            if (this.mNet == null) {
                this.mNet = new BdNet();
                this.mNet.setEventListener(this);
            }
            this.mNet.obtainTask(ccCnt).start();
            BdLog.i(ccCnt);
            resetPv();
        }
    }

    private void resetPv() {
        this.mLauchCount = 0;
        BdFileUtil.writePrivateFile(String.valueOf(this.mLauchCount).getBytes(), BdPath.getInstance(this.mContext).getDirPv(), LAUHCH_FILENAME);
    }

    private String ccCnt(String str) {
        return String.valueOf(str) + "&cnt=" + this.mLauchCount;
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
        BdLog.i(new StringBuilder(String.valueOf(i)).toString());
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
        BdLog.i(new StringBuilder(String.valueOf(i)).toString());
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
        BdLog.i("");
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
    }

    @Override // com.baidu.browser.core.net.BdNetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }
}
