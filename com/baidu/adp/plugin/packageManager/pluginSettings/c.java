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
    private static volatile c vB;
    private Messenger vC;
    public f vD;
    private PluginSettings vu = new PluginSettings();
    private Messenger mReplyMessenger = new Messenger(new a(this, null));
    private ServiceConnection mServiceConnection = new b();
    private ArrayList<Message> vE = new ArrayList<>();

    public static c ii() {
        if (vB == null) {
            synchronized (c.class) {
                if (vB == null) {
                    vB = new c();
                }
            }
        }
        return vB;
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
            a(11, bundle);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public PluginSettings m9if() {
        return this.vu;
    }

    public PluginSetting findPluginSetting(String str) {
        return this.vu.findPluginSetting(str);
    }

    public void a(String str, PluginSetting pluginSetting) {
        if (this.vu.insertOrUpdatePluginSetting(str, pluginSetting)) {
            save();
        }
    }

    public void a(String str, PluginSetting pluginSetting, boolean z) {
        if (this.vu.insertOrUpdatePluginSetting(str, pluginSetting) && z) {
            com.baidu.adp.plugin.packageManager.pluginSettings.b.ie().save(this.vu.m7clone(), null);
        }
    }

    public void bx(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(this.vu.getContainerVersion()) || !this.vu.getContainerVersion().equals(str)) {
            this.vu.setContainerSetting(str);
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_VERSION, str);
            a(10, bundle);
        }
    }

    public void by(String str) {
        if (this.vu.removePluginSetting(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            a(7, bundle);
        }
    }

    public void bl(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null && !findPluginSetting.forbidden) {
            findPluginSetting.forbidden = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_FORBIDDEN, true);
            a(6, bundle);
        }
    }

    public void bm(String str) {
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

    public void bz(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null) {
            findPluginSetting.enable = true;
            Bundle bundle = new Bundle();
            bundle.putString(PluginSettingIOService.KEY_SETTING_NAME, str);
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, true);
            a(9, bundle);
        }
    }

    public void a(String str, String str2, boolean z) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting != null) {
            findPluginSetting.setAbandon_apk_path(str2);
            if (z) {
                com.baidu.adp.plugin.packageManager.pluginSettings.b.ie().save(this.vu.m7clone(), null);
            }
        }
    }

    public String am(int i) {
        PluginSetting findPluginSettingByCmd = this.vu.findPluginSettingByCmd(i);
        if (findPluginSettingByCmd != null) {
            return findPluginSettingByCmd.packageName;
        }
        return null;
    }

    public void setForbiddenFeatures(String str) {
        String forbiddenFeatures = this.vu.getForbiddenFeatures();
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(forbiddenFeatures)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(forbiddenFeatures) || !str.equals(forbiddenFeatures)) {
                this.vu.setForbiddenFeatures(str);
                Bundle bundle = new Bundle();
                bundle.putString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE, str);
                a(12, bundle);
            }
        }
    }

    public boolean bA(String str) {
        PluginSetting findPluginSetting = findPluginSetting(str);
        if (findPluginSetting == null) {
            return true;
        }
        return findPluginSetting.forbidden;
    }

    public void J(boolean z) {
        if (this.vu.setAllPluginEnable(z)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(PluginSettingIOService.KEY_ENABLE, z);
            a(8, bundle);
        }
    }

    public void bB(String str) {
        if (this.vu.findPluginSetting(str) != null) {
            by(str);
            bx("");
        }
    }

    public void bC(String str) {
        if (this.vu.findPluginSetting(str) != null) {
            by(str);
            bx("");
        }
    }

    private void save() {
        Message obtain = Message.obtain((Handler) null, 4);
        Bundle bundle = new Bundle();
        bundle.putSerializable("plugin_settings", this.vu.m7clone());
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                if (this.vC == null || !ik()) {
                    this.vE.add(obtain);
                    i.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.vC.send(obtain);
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
                if (this.vC == null || !ik()) {
                    this.vE.add(obtain);
                    i.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
                } else {
                    this.vC.send(obtain);
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
                            c.this.vu = (PluginSettings) data.getSerializable("plugin_settings");
                        }
                        if (c.this.vD != null) {
                            c.this.vD.a(c.this.vu);
                            c.this.vD = null;
                            return;
                        }
                        return;
                    case 6:
                        Bundle data2 = message.getData();
                        if (data2 != null) {
                            boolean z = data2.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                            String string = data2.getString(PluginSettingIOService.KEY_SETTING_NAME);
                            PluginSetting findPluginSetting = c.this.vu.findPluginSetting(string);
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
                            c.this.vu.removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                            return;
                        }
                        return;
                    case 8:
                        Bundle data4 = message.getData();
                        if (data4 != null) {
                            c.this.vu.setAllPluginEnable(data4.getBoolean(PluginSettingIOService.KEY_ENABLE));
                            return;
                        }
                        return;
                    case 9:
                        Bundle data5 = message.getData();
                        if (data5 != null) {
                            boolean z2 = data5.getBoolean(PluginSettingIOService.KEY_ENABLE);
                            PluginSetting findPluginSetting2 = c.this.vu.findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
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
                            if ((TextUtils.isEmpty(string2) && !TextUtils.isEmpty(c.this.vu.getContainerVersion())) || ((!TextUtils.isEmpty(string2) && TextUtils.isEmpty(c.this.vu.getContainerVersion())) || (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(c.this.vu.getContainerVersion()) && !string2.equals(c.this.vu.getContainerVersion())))) {
                                c.this.vu.setContainerSetting(string2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 11:
                        Bundle data7 = message.getData();
                        if (data7 != null) {
                            int i = data7.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                            PluginSetting findPluginSetting3 = c.this.vu.findPluginSetting(data7.getString(PluginSettingIOService.KEY_SETTING_NAME));
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
                            c.this.vu.setForbiddenFeatures(data8.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
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
            c.this.vC = new Messenger(iBinder);
            c.this.ij();
            if (c.this.vE.size() > 0) {
                Iterator it = c.this.vE.iterator();
                while (it.hasNext()) {
                    try {
                        c.this.vC.send((Message) it.next());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                c.this.vE.clear();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.vC = null;
            c.this.vE.clear();
        }
    }

    public void a(f fVar) {
        com.baidu.adp.plugin.packageManager.pluginSettings.b.ie().a(new d(this, fVar));
        if (this.vC == null || !ik()) {
            i.bindService(BdBaseApplication.getInst(), new Intent(BdBaseApplication.getInst(), PluginSettingIOService.class), this.mServiceConnection, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij() {
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.vC.send(obtain);
            } catch (RemoteException e) {
            } catch (Throwable th) {
                com.baidu.adp.lib.stats.d al = com.baidu.adp.lib.stats.a.dN().al("dbg");
                al.q("loc", String.valueOf(getClass().getName()) + "-sendMsgConnect");
                com.baidu.adp.lib.stats.a.dN().b("PARCEL_NULLPOINT", al);
            }
        }
    }

    private boolean ik() {
        List<ActivityManager.RunningServiceInfo> list;
        try {
            list = ((ActivityManager) BdBaseApplication.getInst().getSystemService("activity")).getRunningServices(100);
        } catch (Exception e) {
            com.baidu.adp.lib.stats.d al = com.baidu.adp.lib.stats.a.dN().al("dbg");
            al.q("loc", String.valueOf(getClass().getName()) + "-isPluginIOServiceStart-getRunningServices");
            com.baidu.adp.lib.stats.a.dN().b("PARCEL_NULLPOINT", al);
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
