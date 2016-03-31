package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.h.i;
import com.baidu.adp.plugin.PluginCenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static volatile c Fj;
    private Messenger Fk;
    public f Fl;
    private PluginSettings Fc = new PluginSettings();
    private Messenger mReplyMessenger = new Messenger(new a(this, null));
    private ServiceConnection mServiceConnection = new b();
    private ArrayList<Message> Fm = new ArrayList<>();

    public static c lU() {
        if (Fj == null) {
            synchronized (c.class) {
                if (Fj == null) {
                    Fj = new c();
                }
            }
        }
        return Fj;
    }

    private c() {
    }

    public void m(String str, int i) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.installStatus != i) {
            findPluginSetting.installStatus = i;
            Bundle bundle = new Bundle();
            bundle.putInt(PluginSettingIOService.KEY_INSTALL_STATUS, i);
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            a(11, bundle);
        }
    }

    public PluginSettings lR() {
        return this.Fc;
    }

    public PluginSetting findPluginSetting(String str) {
        return this.Fc.findPluginSetting(str);
    }

    public void a(String str, PluginSetting pluginSetting) {
        if (this.Fc.insertOrUpdatePluginSetting(str, pluginSetting)) {
            save();
        }
    }

    public void a(String str, PluginSetting pluginSetting, boolean z) {
        if (this.Fc.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.b.lQ().save(this.Fc.m5clone(), null);
        }
    }

    public void bE(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(this.Fc.getContainerVersion()) || !this.Fc.getContainerVersion().equals(str)) {
            this.Fc.setContainerSetting(str);
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_VERSION, str);
            a(10, bundle);
        }
    }

    public void bF(String str) {
        if (this.Fc.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            a(7, bundle);
        }
    }

    public void bs(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && !findPluginSetting.forbidden) {
            findPluginSetting.forbidden = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, true);
            a(6, bundle);
        }
    }

    public void bt(String str) {
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

    public void bG(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null) {
            findPluginSetting.enable = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, true);
            a(9, bundle);
        }
    }

    public void b(String str, String str2, boolean z) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null) {
            findPluginSetting.setAbandon_apk_path(str2);
            if (z) {
                com.baidu.adp.plugin.packageManager.pluginSettings.b.lQ().save(this.Fc.m5clone(), null);
            }
        }
    }

    public String az(int i) {
        PluginSetting findPluginSettingByCmd = this.Fc.findPluginSettingByCmd(i);
        if (findPluginSettingByCmd != null) {
            return findPluginSettingByCmd.packageName;
        }
        return null;
    }

    public void setForbiddenFeatures(String str) {
        String forbiddenFeatures = this.Fc.getForbiddenFeatures();
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(forbiddenFeatures)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(forbiddenFeatures) || !str.equals(forbiddenFeatures)) {
                this.Fc.setForbiddenFeatures(str);
                Bundle bundle = new Bundle();
                bundle.putString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE, str);
                a(12, bundle);
            }
        }
    }

    public boolean bH(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public void J(boolean z) {
        if (this.Fc.setAllPluginEnable(z)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            a(8, bundle);
        }
    }

    public void bI(String str) {
        if (this.Fc.findPluginSetting(str) != null) {
            bF(str);
            bE("");
        }
    }

    public void bJ(String str) {
        if (this.Fc.findPluginSetting(str) != null) {
            bF(str);
            bE("");
        }
    }

    private void save() {
        Message obtain = Message.obtain((Handler) null, 4);
        Bundle bundle = new Bundle();
        bundle.putSerializable("plugin_settings", this.Fc.m5clone());
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.Fk == null || !lW()) {
                    this.Fm.add(obtain);
                    i.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.Fk.send(obtain);
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
                if (this.Fk == null || !lW()) {
                    this.Fm.add(obtain);
                    i.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.Fk.send(obtain);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends Handler {
        private a() {
        }

        /* synthetic */ a(c cVar, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Serializable serializable;
            try {
                switch (message.what) {
                    case 5:
                        Bundle data = message.getData();
                        if (data != null && (serializable = data.getSerializable("plugin_settings")) != null && (serializable instanceof PluginSettings)) {
                            c.this.Fc = (PluginSettings) data.getSerializable("plugin_settings");
                        }
                        if (c.this.Fl != null) {
                            c.this.Fl.a(c.this.Fc);
                            c.this.Fl = null;
                            return;
                        }
                        return;
                    case 6:
                        Bundle data2 = message.getData();
                        if (data2 != null) {
                            boolean z = data2.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                            String string = data2.getString(PluginSettingIOService.KEY_SETTING_NAME);
                            PluginSetting findPluginSetting = c.this.Fc.findPluginSetting(string);
                            if (findPluginSetting != null && findPluginSetting.forbidden != z) {
                                findPluginSetting.forbidden = z;
                            }
                            if (!z) {
                                PluginCenter.getInstance().launch(string);
                                return;
                            }
                            return;
                        }
                        return;
                    case 7:
                        Bundle data3 = message.getData();
                        if (data3 != null) {
                            c.this.Fc.removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                            return;
                        }
                        return;
                    case 8:
                        Bundle data4 = message.getData();
                        if (data4 != null) {
                            c.this.Fc.setAllPluginEnable(data4.getBoolean(PluginSettingIOService.KEY_ENABLE));
                            return;
                        }
                        return;
                    case 9:
                        Bundle data5 = message.getData();
                        if (data5 != null) {
                            boolean z2 = data5.getBoolean(PluginSettingIOService.KEY_ENABLE);
                            PluginSetting findPluginSetting2 = c.this.Fc.findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
                            if (findPluginSetting2 != null && findPluginSetting2.enable != z2) {
                                findPluginSetting2.enable = z2;
                            }
                            boolean z3 = false;
                            if (findPluginSetting2.isPatch && TextUtils.isEmpty(findPluginSetting2.replaceMethodClasses)) {
                                z3 = true;
                            }
                            if (findPluginSetting2 != null && findPluginSetting2.enable && !TextUtils.isEmpty(findPluginSetting2.requireLoad) && findPluginSetting2.requireLoad.equals("0") && !z3) {
                                PluginCenter.getInstance().launch(findPluginSetting2.packageName);
                                return;
                            }
                            return;
                        }
                        return;
                    case 10:
                        Bundle data6 = message.getData();
                        if (data6 != null) {
                            String string2 = data6.getString(PluginSettingIOService.KEY_VERSION);
                            if ((TextUtils.isEmpty(string2) && !TextUtils.isEmpty(c.this.Fc.getContainerVersion())) || ((!TextUtils.isEmpty(string2) && TextUtils.isEmpty(c.this.Fc.getContainerVersion())) || (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(c.this.Fc.getContainerVersion()) && !string2.equals(c.this.Fc.getContainerVersion())))) {
                                c.this.Fc.setContainerSetting(string2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 11:
                        Bundle data7 = message.getData();
                        if (data7 != null) {
                            int i = data7.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                            PluginSetting findPluginSetting3 = c.this.Fc.findPluginSetting(data7.getString(PluginSettingIOService.KEY_SETTING_NAME));
                            if (findPluginSetting3 != null && findPluginSetting3.installStatus != i) {
                                findPluginSetting3.installStatus = i;
                                return;
                            }
                            return;
                        }
                        return;
                    case 12:
                        Bundle data8 = message.getData();
                        if (data8 != null) {
                            c.this.Fc.setForbiddenFeatures(data8.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.this.Fk = new Messenger(iBinder);
            c.this.lV();
            if (c.this.Fm.size() > 0) {
                Iterator it = c.this.Fm.iterator();
                while (it.hasNext()) {
                    try {
                        c.this.Fk.send((Message) it.next());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                c.this.Fm.clear();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.Fk = null;
            c.this.Fm.clear();
        }
    }

    public void a(f fVar) {
        com.baidu.adp.plugin.packageManager.pluginSettings.b.lQ().a(new d(this, fVar));
        if (this.Fk == null || !lW()) {
            i.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV() {
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.Fk.send(obtain);
            } catch (RemoteException e) {
            } catch (Throwable th) {
                com.baidu.adp.lib.stats.d as = com.baidu.adp.lib.stats.a.hz().as("dbg");
                as.r("loc", String.valueOf(getClass().getName()) + "-sendMsgConnect");
                com.baidu.adp.lib.stats.a.hz().b("PARCEL_NULLPOINT", as);
            }
        }
    }

    private boolean lW() {
        List<ActivityManager.RunningServiceInfo> list;
        try {
            list = ((ActivityManager) BdBaseApplication.getInst().getSystemService("activity")).getRunningServices(100);
        } catch (Exception e) {
            com.baidu.adp.lib.stats.d as = com.baidu.adp.lib.stats.a.hz().as("dbg");
            as.r("loc", String.valueOf(getClass().getName()) + "-isPluginIOServiceStart-getRunningServices");
            com.baidu.adp.lib.stats.a.hz().b("PARCEL_NULLPOINT", as);
            list = null;
        }
        if (list != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : list) {
                if (runningServiceInfo != null && runningServiceInfo.service != null && PluginSettingIOService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
