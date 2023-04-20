package com.baidu.searchbox.task.async.privacy;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.eg9;
/* loaded from: classes2.dex */
public class LaunchWithPrivacyTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "LaunchWithPrivacy";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    /* loaded from: classes2.dex */
    public class MyPhoneStateListener extends PhoneStateListener {
        public MyPhoneStateListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            if (i != 0) {
                if (i == 1 || i == 2) {
                    TbadkCoreApplication.getInst().isPhoneCalling = true;
                }
            } else {
                TbadkCoreApplication.getInst().isPhoneCalling = false;
            }
            super.onCallStateChanged(i, str);
        }
    }

    private void registerPhoneListener() {
        if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadPhoneState(TbadkCoreApplication.getInst().getContext())) {
            try {
                ((TelephonyManager) TbadkCoreApplication.getInst().getApp().getSystemService("phone")).listen(new MyPhoneStateListener(), 32);
            } catch (SecurityException | Exception unused) {
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        registerPhoneListener();
        HttpRuntime.getHttpContext().prefetchDnsResult("tbprefetch");
        HttpManager.getDefault(eg9.a()).setHttpDnsEnable(true);
    }
}
