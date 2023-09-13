package com.baidu.cyberplayer.sdk.remote;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class RemotePlayerService extends Service {
    public static final String TAG = "RemotePlayer";
    public String mClientID;
    public Map<String, String> mInstallOpts;
    public int mInstallType;
    public int mPcdnType;

    public long getKernelNetHandle() {
        return 0L;
    }

    public long getPCDNNetHandle() {
        return 0L;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Context applicationContext = getApplicationContext();
        String stringExtra = intent.getStringExtra("clientID");
        int intExtra = intent.getIntExtra("installType", 1);
        int intExtra2 = intent.getIntExtra("pcdnType", 0);
        try {
            Map map = (Map) intent.getSerializableExtra("installOpts");
            if (!map.containsKey(CyberPlayerManager.INSTALL_OPT_CRASHPAD_MEDIA_PROCESS_WORK_DIR)) {
                String stringExtra2 = intent.getStringExtra(CyberPlayerManager.INSTALL_OPT_CRASHPAD_MEDIA_PROCESS_WORK_DIR);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    map.put(CyberPlayerManager.INSTALL_OPT_CRASHPAD_MEDIA_PROCESS_WORK_DIR, stringExtra2);
                    CyberLog.d("RemotePlayer", "crashpadWorkDir" + stringExtra2);
                }
            }
            if (!map.containsKey("zeusVersion")) {
                String stringExtra3 = intent.getStringExtra("zeusVersion");
                if (!TextUtils.isEmpty(stringExtra3)) {
                    map.put("zeusVersion", stringExtra3);
                    CyberLog.d("RemotePlayer", "zeusVersion:" + stringExtra3);
                }
            }
            CyberPlayerManager.install(applicationContext, stringExtra, (String) null, intExtra, (Class<?>) null, map, new CyberPlayerManager.InstallListener() { // from class: com.baidu.cyberplayer.sdk.remote.RemotePlayerService.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallError(int i, int i2, String str) {
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallProgress(int i, int i2) {
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
                public void onInstallSuccess(int i, String str) {
                    if (CyberCfgManager.getInstance().getCfgBoolValue("remote_set_nethandle_listener_enable", true)) {
                        CyberPlayerManager.setNetHandleListener(new CyberPlayerManager.GetNetHandleListener() { // from class: com.baidu.cyberplayer.sdk.remote.RemotePlayerService.1.1
                            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.GetNetHandleListener
                            public Long getKerNetHandle() {
                                return Long.valueOf(RemotePlayerService.this.getKernelNetHandle());
                            }

                            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.GetNetHandleListener
                            public Long getPcdnNetHandle() {
                                return Long.valueOf(RemotePlayerService.this.getPCDNNetHandle());
                            }
                        });
                    }
                }
            }, intExtra2);
            this.mClientID = stringExtra;
            this.mPcdnType = intExtra2;
            this.mInstallType = intExtra;
            this.mInstallOpts = (Map) intent.getSerializableExtra("installOpts");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RemotePlayerFactory.RemoteImpl(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (!Utils.isMainProcessAlive()) {
            Process.killProcess(Process.myPid());
        }
        return super.onUnbind(intent);
    }

    public void remoteInstallNewType(int i) {
        try {
            if (!CyberPlayerManager.isCoreLoaded(i) && this.mInstallType != i) {
                CyberLog.e("RemotePlayer", "service remoteInstallNewType: " + this.mInstallType + " => " + i);
                CyberPlayerManager.install(getApplicationContext(), this.mClientID, (String) null, i, (Class<?>) null, this.mInstallOpts, (CyberPlayerManager.InstallListener2) null, this.mPcdnType);
                return;
            }
            CyberLog.e("RemotePlayer", "remoteInstallNewType do nothing: " + this.mInstallType + " => " + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
