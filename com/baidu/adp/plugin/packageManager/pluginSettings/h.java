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
    private static volatile h Ew;
    private Messenger Ex;
    public m Ez;
    private PluginSettings Ep = new PluginSettings();
    private Messenger Ey = new Messenger(new j(this, null));
    private ServiceConnection mServiceConnection = new k(this);
    private ArrayList<Message> EA = new ArrayList<>();

    public static h lP() {
        if (Ew == null) {
            synchronized (h.class) {
                if (Ew == null) {
                    Ew = new h();
                }
            }
        }
        return Ew;
    }

    private h() {
    }

    public void j(String str, int i) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.installStatus != i) {
            findPluginSetting.installStatus = i;
            Bundle bundle = new Bundle();
            bundle.putInt(PluginSettingIOService.KEY_INSTALL_STATUS, i);
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            a(11, bundle);
        }
    }

    public PluginSettings lM() {
        return this.Ep;
    }

    public PluginSetting findPluginSetting(String str) {
        return this.Ep.findPluginSetting(str);
    }

    public void a(String str, PluginSetting pluginSetting) {
        if (this.Ep.insertOrUpdatePluginSetting(str, pluginSetting)) {
            save();
        }
    }

    public void a(String str, PluginSetting pluginSetting, boolean z) {
        if (this.Ep.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            e.lL().save(this.Ep.m5clone(), null);
        }
    }

    public void bw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(this.Ep.getContainerVersion()) || !this.Ep.getContainerVersion().equals(str)) {
            this.Ep.setContainerSetting(str);
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_VERSION, str);
            a(10, bundle);
        }
    }

    public void bx(String str) {
        if (this.Ep.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            a(7, bundle);
        }
    }

    public void bk(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && !findPluginSetting.forbidden) {
            findPluginSetting.forbidden = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, true);
            a(6, bundle);
        }
    }

    public void bl(String str) {
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
                e.lL().save(this.Ep.m5clone(), null);
            }
        }
    }

    public String au(int i) {
        PluginSetting findPluginSettingByCmd = this.Ep.findPluginSettingByCmd(i);
        if (findPluginSettingByCmd != null) {
            return findPluginSettingByCmd.packageName;
        }
        return null;
    }

    public void setForbiddenFeatures(String str) {
        String forbiddenFeatures = this.Ep.getForbiddenFeatures();
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(forbiddenFeatures)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(forbiddenFeatures) || !str.equals(forbiddenFeatures)) {
                this.Ep.setForbiddenFeatures(str);
                Bundle bundle = new Bundle();
                bundle.putString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE, str);
                a(12, bundle);
            }
        }
    }

    public boolean by(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public void K(boolean z) {
        if (this.Ep.setAllPluginEnable(z)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            a(8, bundle);
        }
    }

    public void bz(String str) {
        if (this.Ep.findPluginSetting(str) != null) {
            bx(str);
            bw("");
        }
    }

    private void save() {
        Message obtain = Message.obtain((Handler) null, 4);
        Bundle bundle = new Bundle();
        bundle.putSerializable("plugin_settings", this.Ep.m5clone());
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.Ex == null || !lR()) {
                    this.EA.add(obtain);
                    com.baidu.adp.lib.g.j.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.Ex.send(obtain);
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
                if (this.Ex == null || !lR()) {
                    this.EA.add(obtain);
                    com.baidu.adp.lib.g.j.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.Ex.send(obtain);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(m mVar) {
        e.lL().a(new i(this, mVar));
        if (this.Ex == null || !lR()) {
            com.baidu.adp.lib.g.j.a(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ() {
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = this.Ey;
                this.Ex.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    private boolean lR() {
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
