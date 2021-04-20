package com.baidu.mobads.container.components.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.SendLogUtil;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class RemoteInstallApkTask implements IScheduleTask {
    public static final long TIME_OUT_MAX_TIME = 60000;
    public static final long WAIT_START_MAX_TIME = 5000;
    public long mApkInstallerStartTime;
    public Context mAppContext;
    public XAdRemoteAPKDownloadExtraInfo mExtraInfo;
    public boolean mIsApkInstallerStarted = false;
    public boolean mIsAppBackToForeground = false;
    public long mMonitorStartTime = System.currentTimeMillis();

    public RemoteInstallApkTask(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        this.mAppContext = context.getApplicationContext();
        this.mExtraInfo = xAdRemoteAPKDownloadExtraInfo;
    }

    private String getExtraValue(String str) {
        HashMap<String, String> hashMap;
        XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = this.mExtraInfo;
        return (xAdRemoteAPKDownloadExtraInfo == null || (hashMap = xAdRemoteAPKDownloadExtraInfo.mExtras) == null) ? "" : hashMap.get(str);
    }

    private String getShortString(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 64) ? str : str.substring(0, 64);
    }

    private void sendLog() {
        try {
            SendLogUtil.Builder append = SendLogUtil.Builder.create(this.mAppContext).appendType(530).append(XAdRemoteAPKDownloadExtraInfo.QK, this.mExtraInfo.queryKey).append(XAdRemoteAPKDownloadExtraInfo.ADID, this.mExtraInfo.mAdid).append(XAdRemoteAPKDownloadExtraInfo.BUYER, this.mExtraInfo.mBuyer).append("prod", this.mExtraInfo.mProd).appendAppSid(this.mExtraInfo.mAppsid).append("pk", this.mExtraInfo.packageName).append(XAdRemoteAPKDownloadExtraInfo.AUTO_OPEN, this.mExtraInfo.autoOpen).append(XAdRemoteAPKDownloadExtraInfo.APP_STORE_LINK, getShortString(this.mExtraInfo.asl)).append("apoOpen", this.mExtraInfo.mAPOOpen).append("mobileConfirmed", this.mExtraInfo.mobileConfirmed).append("dl_type", getExtraValue("dl_type")).append("cur_qk", getExtraValue("cur_qk")).append("cur_adid", getExtraValue("cur_adid")).append("cur_buyer", getExtraValue("cur_buyer")).append("cur_apid", getExtraValue("cur_apid")).append("act", getExtraValue("act")).append("isInstallStart", this.mIsApkInstallerStarted).append("isInstallFinish", this.mIsAppBackToForeground).append("isApkInstall", AdDownloadApkUtils.isInstalled(this.mAppContext, this.mExtraInfo.packageName));
            SendLogUtil.Builder append2 = append.append("mst", "" + this.mMonitorStartTime);
            append2.append("ist", "" + this.mApkInstallerStartTime).send();
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.container.components.monitor.IScheduleTask
    public boolean handle() {
        XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = this.mExtraInfo;
        if (xAdRemoteAPKDownloadExtraInfo == null || TextUtils.isEmpty(xAdRemoteAPKDownloadExtraInfo.packageName)) {
            return true;
        }
        Context context = this.mAppContext;
        boolean isForeground = AppUtils.isForeground(context, context.getPackageName());
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mIsApkInstallerStarted) {
            if (isForeground) {
                this.mIsAppBackToForeground = true;
                sendLog();
                return true;
            }
        } else if (currentTimeMillis - this.mMonitorStartTime > 5000) {
            sendLog();
            return true;
        } else if (!isForeground) {
            this.mIsApkInstallerStarted = true;
            this.mApkInstallerStartTime = System.currentTimeMillis();
        }
        if (currentTimeMillis - this.mMonitorStartTime > 60000) {
            sendLog();
            return true;
        }
        return false;
    }
}
