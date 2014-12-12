package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static volatile h tw;
    private Messenger mSendMessenger;
    public m tx;
    private PluginSettings tp = new PluginSettings();
    private Messenger mReplyMessenger = new Messenger(new j(this, null));
    private ServiceConnection mServiceConnection = new k(this);
    private ArrayList<Message> ty = new ArrayList<>();

    public static h iy() {
        if (tw == null) {
            synchronized (h.class) {
                if (tw == null) {
                    tw = new h();
                }
            }
        }
        return tw;
    }

    private h() {
    }

    public void k(String str, int i) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.installStatus != i) {
            findPluginSetting.installStatus = i;
            Bundle bundle = new Bundle();
            bundle.putInt(PluginSettingIOService.KEY_INSTALL_STATUS, i);
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            a(11, bundle);
        }
    }

    public PluginSettings iv() {
        return this.tp;
    }

    public PluginSetting findPluginSetting(String str) {
        return this.tp.findPluginSetting(str);
    }

    public void a(String str, PluginSetting pluginSetting) {
        if (this.tp.insertOrUpdatePluginSetting(str, pluginSetting)) {
            save();
        }
    }

    public void a(String str, PluginSetting pluginSetting, boolean z) {
        if (this.tp.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            e.iu().save(this.tp.m5clone(), null);
        }
    }

    public void br(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(this.tp.getContainerVersion()) || !this.tp.getContainerVersion().equals(str)) {
            this.tp.setContainerSetting(str);
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_VERSION, str);
            a(10, bundle);
        }
    }

    public void bs(String str) {
        if (this.tp.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            a(7, bundle);
        }
    }

    public void bg(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && !findPluginSetting.forbidden) {
            findPluginSetting.forbidden = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, true);
            a(6, bundle);
        }
    }

    public void bh(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.forbidden) {
            findPluginSetting.forbidden = false;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, false);
            a(6, bundle);
        }
    }

    public void f(String str, boolean z) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.enable != z) {
            findPluginSetting.enable = z;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            a(9, bundle);
        }
    }

    public void b(String str, String str2, boolean z) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null) {
            findPluginSetting.setAbandon_apk_path(str2);
            if (z) {
                e.iu().save(this.tp.m5clone(), null);
            }
        }
    }

    public String ar(int i) {
        PluginSetting findPluginSettingByCmd = this.tp.findPluginSettingByCmd(i);
        if (findPluginSettingByCmd != null) {
            return findPluginSettingByCmd.packageName;
        }
        return null;
    }

    public void setForbiddenFeatures(String str) {
        String forbiddenFeatures = this.tp.getForbiddenFeatures();
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(forbiddenFeatures)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(forbiddenFeatures) || !str.equals(forbiddenFeatures)) {
                this.tp.setForbiddenFeatures(str);
                Bundle bundle = new Bundle();
                bundle.putString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE, str);
                a(12, bundle);
            }
        }
    }

    public boolean bt(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public void K(boolean z) {
        if (this.tp.setAllPluginEnable(z)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            a(8, bundle);
        }
    }

    public void bu(String str) {
        if (this.tp.findPluginSetting(str) != null) {
            bs(str);
            br("");
        }
    }

    private void save() {
        Message obtain = Message.obtain((Handler) null, 4);
        Bundle bundle = new Bundle();
        bundle.putSerializable("plugin_settings", this.tp.m5clone());
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.mSendMessenger == null || !iA()) {
                    this.ty.add(obtain);
                    com.baidu.adp.lib.g.j.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.mSendMessenger.send(obtain);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(int i, Bundle bundle) {
        Message obtain = Message.obtain((Handler) null, i);
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.mSendMessenger == null || !iA()) {
                    this.ty.add(obtain);
                    com.baidu.adp.lib.g.j.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.mSendMessenger.send(obtain);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(m mVar) {
        e.iu().a(new i(this, mVar));
        if (this.mSendMessenger == null || !iA()) {
            com.baidu.adp.lib.g.j.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz() {
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.mSendMessenger.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    private boolean iA() {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) BdBaseApplication.getInst().getSystemService("activity")).getRunningServices(100);
        if (runningServices != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo != null && runningServiceInfo.service != null && PluginSettingIOService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
