package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.annotation.SuppressLint;
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
import com.baidu.adp.lib.g.f;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.plugin.PluginCenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static volatile c Gy;
    public e GA;
    private Messenger Gz;
    private PluginSettings Gr = new PluginSettings();
    private Messenger mReplyMessenger = new Messenger(new a());
    private ServiceConnection mServiceConnection = new b();
    private ArrayList<Message> GB = new ArrayList<>();

    public static c kh() {
        if (Gy == null) {
            synchronized (c.class) {
                if (Gy == null) {
                    Gy = new c();
                }
            }
        }
        return Gy;
    }

    private c() {
    }

    public void n(String str, int i) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.installStatus != i) {
            findPluginSetting.installStatus = i;
            Bundle bundle = new Bundle();
            bundle.putInt(PluginSettingIOService.KEY_INSTALL_STATUS, i);
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            b(11, bundle);
        }
    }

    public PluginSettings ke() {
        return this.Gr;
    }

    public PluginSetting findPluginSetting(String str) {
        return this.Gr.findPluginSetting(str);
    }

    public void a(String str, PluginSetting pluginSetting) {
        if (this.Gr.insertOrUpdatePluginSetting(str, pluginSetting)) {
            save();
        }
    }

    public void a(String str, PluginSetting pluginSetting, boolean z) {
        if (this.Gr.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.b.kd().save(this.Gr.m7clone(), null);
        }
    }

    public void bA(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(this.Gr.getContainerVersion()) || !this.Gr.getContainerVersion().equals(str)) {
            this.Gr.setContainerSetting(str);
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_VERSION, str);
            b(10, bundle);
        }
    }

    public void bB(String str) {
        if (this.Gr.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            b(7, bundle);
        }
    }

    public void bo(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && !findPluginSetting.forbidden) {
            findPluginSetting.forbidden = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, true);
            b(6, bundle);
        }
    }

    public void bp(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.forbidden) {
            findPluginSetting.forbidden = false;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, false);
            b(6, bundle);
        }
    }

    public void f(String str, boolean z) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.enable != z) {
            findPluginSetting.enable = z;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            b(9, bundle);
        }
    }

    public void bC(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null) {
            findPluginSetting.enable = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, true);
            b(9, bundle);
        }
    }

    public void b(String str, String str2, boolean z) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null) {
            findPluginSetting.setAbandon_apk_path(str2);
            if (z) {
                com.baidu.adp.plugin.packageManager.pluginSettings.b.kd().save(this.Gr.m7clone(), null);
            }
        }
    }

    public String aF(int i) {
        PluginSetting findPluginSettingByCmd = this.Gr.findPluginSettingByCmd(i);
        if (findPluginSettingByCmd != null) {
            return findPluginSettingByCmd.packageName;
        }
        return null;
    }

    public void setForbiddenFeatures(String str) {
        String forbiddenFeatures = this.Gr.getForbiddenFeatures();
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(forbiddenFeatures)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(forbiddenFeatures) || !str.equals(forbiddenFeatures)) {
                this.Gr.setForbiddenFeatures(str);
                Bundle bundle = new Bundle();
                bundle.putString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE, str);
                b(12, bundle);
            }
        }
    }

    public boolean bD(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public void O(boolean z) {
        if (this.Gr.setAllPluginEnable(z)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            b(8, bundle);
        }
    }

    public void bE(String str) {
        if (this.Gr.findPluginSetting(str) != null) {
            bB(str);
            bA("");
        }
    }

    public void bF(String str) {
        if (this.Gr.findPluginSetting(str) != null) {
            bB(str);
            bA("");
        }
    }

    private void save() {
        Message obtain = Message.obtain((Handler) null, 4);
        Bundle bundle = new Bundle();
        bundle.putSerializable("plugin_settings", this.Gr.m7clone());
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.Gz == null || !kj()) {
                    this.GB.add(obtain);
                    f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.Gz.send(obtain);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void b(int i, Bundle bundle) {
        Message obtain = Message.obtain((Handler) null, i);
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.Gz == null || !kj()) {
                    this.GB.add(obtain);
                    f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.Gz.send(obtain);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    private class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Serializable serializable;
            try {
                switch (message.what) {
                    case 5:
                        Bundle data = message.getData();
                        if (data != null && (serializable = data.getSerializable("plugin_settings")) != null && (serializable instanceof PluginSettings)) {
                            c.this.Gr = (PluginSettings) data.getSerializable("plugin_settings");
                        }
                        if (c.this.GA != null) {
                            c.this.GA.a(c.this.Gr);
                            c.this.GA = null;
                            return;
                        }
                        return;
                    case 6:
                        Bundle data2 = message.getData();
                        if (data2 != null) {
                            boolean z = data2.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                            String string = data2.getString(PluginSettingIOService.KEY_SETTING_NAME);
                            PluginSetting findPluginSetting = c.this.Gr.findPluginSetting(string);
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
                            c.this.Gr.removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                            return;
                        }
                        return;
                    case 8:
                        Bundle data4 = message.getData();
                        if (data4 != null) {
                            c.this.Gr.setAllPluginEnable(data4.getBoolean(PluginSettingIOService.KEY_ENABLE));
                            return;
                        }
                        return;
                    case 9:
                        Bundle data5 = message.getData();
                        if (data5 != null) {
                            boolean z2 = data5.getBoolean(PluginSettingIOService.KEY_ENABLE);
                            PluginSetting findPluginSetting2 = c.this.Gr.findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
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
                            if ((TextUtils.isEmpty(string2) && !TextUtils.isEmpty(c.this.Gr.getContainerVersion())) || ((!TextUtils.isEmpty(string2) && TextUtils.isEmpty(c.this.Gr.getContainerVersion())) || (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(c.this.Gr.getContainerVersion()) && !string2.equals(c.this.Gr.getContainerVersion())))) {
                                c.this.Gr.setContainerSetting(string2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 11:
                        Bundle data7 = message.getData();
                        if (data7 != null) {
                            int i = data7.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                            PluginSetting findPluginSetting3 = c.this.Gr.findPluginSetting(data7.getString(PluginSettingIOService.KEY_SETTING_NAME));
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
                            c.this.Gr.setForbiddenFeatures(data8.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
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
            c.this.Gz = new Messenger(iBinder);
            c.this.ki();
            if (c.this.GB.size() > 0) {
                Iterator it = c.this.GB.iterator();
                while (it.hasNext()) {
                    try {
                        c.this.Gz.send((Message) it.next());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                c.this.GB.clear();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.Gz = null;
            c.this.GB.clear();
        }
    }

    public void a(final e eVar) {
        com.baidu.adp.plugin.packageManager.pluginSettings.b.kd().a(new e() { // from class: com.baidu.adp.plugin.packageManager.pluginSettings.c.1
            @Override // com.baidu.adp.plugin.packageManager.pluginSettings.e
            public void a(PluginSettings pluginSettings) {
                if (pluginSettings != null) {
                    c.this.Gr = pluginSettings;
                }
                if (eVar != null) {
                    eVar.a(pluginSettings);
                }
            }
        });
        if (this.Gz == null || !kj()) {
            f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki() {
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.Gz.send(obtain);
            } catch (RemoteException e) {
            } catch (Throwable th) {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.p("loc", getClass().getName() + "-sendMsgConnect");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
            }
        }
    }

    private boolean kj() {
        List<ActivityManager.RunningServiceInfo> list;
        try {
            list = ((ActivityManager) BdBaseApplication.getInst().getSystemService("activity")).getRunningServices(100);
        } catch (Exception e) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.p("loc", getClass().getName() + "-isPluginIOServiceStart-getRunningServices");
            BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
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
