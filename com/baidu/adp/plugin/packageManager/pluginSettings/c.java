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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static volatile c LM;
    private Messenger LN;
    public e LO;
    private PluginSettings LD = new PluginSettings();
    private Messenger mReplyMessenger = new Messenger(new a());
    private ServiceConnection mServiceConnection = new b();
    private ArrayList<Message> LP = new ArrayList<>();

    public static c nF() {
        if (LM == null) {
            synchronized (c.class) {
                if (LM == null) {
                    LM = new c();
                }
            }
        }
        return LM;
    }

    private c() {
    }

    public void s(String str, int i) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.installStatus != i) {
            findPluginSetting.installStatus = i;
            Bundle bundle = new Bundle();
            bundle.putInt(PluginSettingIOService.KEY_INSTALL_STATUS, i);
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            c(11, bundle);
        }
    }

    public PluginSettings nC() {
        return this.LD;
    }

    public PluginSetting findPluginSetting(String str) {
        return this.LD.findPluginSetting(str);
    }

    public void a(String str, PluginSetting pluginSetting) {
        if (this.LD.insertOrUpdatePluginSetting(str, pluginSetting)) {
            save();
        }
    }

    public void a(String str, PluginSetting pluginSetting, boolean z) {
        if (this.LD.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.b.nB().save(this.LD.m12clone(), null);
        }
    }

    public void ch(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(this.LD.getContainerVersion()) || !this.LD.getContainerVersion().equals(str)) {
            this.LD.setContainerSetting(str);
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_VERSION, str);
            c(10, bundle);
        }
    }

    public void ci(String str) {
        if (this.LD.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            c(7, bundle);
        }
    }

    public void bV(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && !findPluginSetting.forbidden) {
            findPluginSetting.forbidden = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, true);
            c(6, bundle);
        }
    }

    public void bW(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.forbidden) {
            findPluginSetting.forbidden = false;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, false);
            c(6, bundle);
        }
    }

    public void i(String str, boolean z) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && findPluginSetting.enable != z) {
            findPluginSetting.enable = z;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            c(9, bundle);
        }
    }

    public void cj(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null) {
            findPluginSetting.enable = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, true);
            c(9, bundle);
        }
    }

    public void b(String str, String str2, boolean z) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null) {
            findPluginSetting.setAbandon_apk_path(str2);
            if (z) {
                com.baidu.adp.plugin.packageManager.pluginSettings.b.nB().save(this.LD.m12clone(), null);
            }
        }
    }

    public String aJ(int i) {
        PluginSetting findPluginSettingByCmd = this.LD.findPluginSettingByCmd(i);
        if (findPluginSettingByCmd != null) {
            return findPluginSettingByCmd.packageName;
        }
        return null;
    }

    public void setForbiddenFeatures(String str) {
        String forbiddenFeatures = this.LD.getForbiddenFeatures();
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(forbiddenFeatures)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(forbiddenFeatures) || !str.equals(forbiddenFeatures)) {
                this.LD.setForbiddenFeatures(str);
                Bundle bundle = new Bundle();
                bundle.putString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE, str);
                c(12, bundle);
            }
        }
    }

    public boolean ck(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public void ac(boolean z) {
        if (this.LD.setAllPluginEnable(z)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            c(8, bundle);
        }
    }

    public void cl(String str) {
        if (this.LD.findPluginSetting(str) != null) {
            ci(str);
            ch("");
        }
    }

    public void cm(String str) {
        if (this.LD.findPluginSetting(str) != null) {
            ci(str);
            ch("");
        }
    }

    private void save() {
        Message obtain = Message.obtain((Handler) null, 4);
        Bundle bundle = new Bundle();
        bundle.putSerializable("plugin_settings", this.LD.m12clone());
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.LN == null || !nH()) {
                    this.LP.add(obtain);
                    f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.LN.send(obtain);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void c(int i, Bundle bundle) {
        Message obtain = Message.obtain((Handler) null, i);
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.LN == null || !nH()) {
                    this.LP.add(obtain);
                    f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.LN.send(obtain);
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
                            c.this.LD = (PluginSettings) data.getSerializable("plugin_settings");
                        }
                        if (c.this.LO != null) {
                            c.this.LO.a(c.this.LD);
                            c.this.LO = null;
                            return;
                        }
                        return;
                    case 6:
                        Bundle data2 = message.getData();
                        if (data2 != null) {
                            boolean z = data2.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                            String string = data2.getString(PluginSettingIOService.KEY_SETTING_NAME);
                            PluginSetting findPluginSetting = c.this.LD.findPluginSetting(string);
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
                            c.this.LD.removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                            return;
                        }
                        return;
                    case 8:
                        Bundle data4 = message.getData();
                        if (data4 != null) {
                            c.this.LD.setAllPluginEnable(data4.getBoolean(PluginSettingIOService.KEY_ENABLE));
                            return;
                        }
                        return;
                    case 9:
                        Bundle data5 = message.getData();
                        if (data5 != null) {
                            boolean z2 = data5.getBoolean(PluginSettingIOService.KEY_ENABLE);
                            PluginSetting findPluginSetting2 = c.this.LD.findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
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
                            if ((TextUtils.isEmpty(string2) && !TextUtils.isEmpty(c.this.LD.getContainerVersion())) || ((!TextUtils.isEmpty(string2) && TextUtils.isEmpty(c.this.LD.getContainerVersion())) || (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(c.this.LD.getContainerVersion()) && !string2.equals(c.this.LD.getContainerVersion())))) {
                                c.this.LD.setContainerSetting(string2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 11:
                        Bundle data7 = message.getData();
                        if (data7 != null) {
                            int i = data7.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                            PluginSetting findPluginSetting3 = c.this.LD.findPluginSetting(data7.getString(PluginSettingIOService.KEY_SETTING_NAME));
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
                            c.this.LD.setForbiddenFeatures(data8.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
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
            c.this.LN = new Messenger(iBinder);
            c.this.nG();
            if (c.this.LP.size() > 0) {
                Iterator it = c.this.LP.iterator();
                while (it.hasNext()) {
                    try {
                        c.this.LN.send((Message) it.next());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                c.this.LP.clear();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.LN = null;
            c.this.LP.clear();
        }
    }

    public void a(final e eVar) {
        com.baidu.adp.plugin.packageManager.pluginSettings.b.nB().a(new e() { // from class: com.baidu.adp.plugin.packageManager.pluginSettings.c.1
            @Override // com.baidu.adp.plugin.packageManager.pluginSettings.e
            public void a(PluginSettings pluginSettings) {
                if (pluginSettings != null) {
                    c.this.LD = pluginSettings;
                }
                if (eVar != null) {
                    eVar.a(pluginSettings);
                }
            }
        });
        if (this.LN == null || !nH()) {
            f.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nG() {
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.LN.send(obtain);
            } catch (RemoteException e) {
            } catch (Throwable th) {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("loc", getClass().getName() + "-sendMsgConnect");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
            }
        }
    }

    private boolean nH() {
        List<ActivityManager.RunningServiceInfo> list;
        try {
            list = ((ActivityManager) BdBaseApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningServices(100);
        } catch (Exception e) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("loc", getClass().getName() + "-isPluginIOServiceStart-getRunningServices");
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
