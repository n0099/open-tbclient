package com.baidu.tbadk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.appsearchlib.NASLib;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.switchs.PluginClassChangeSwitch;
import com.baidu.tieba.service.SignAlertReceiver;
import d.a.c.e.m.c;
import d.a.c.h.h.b;
import d.a.c.h.j.g.d;
import d.a.i0.m0.l;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TbadkApplication extends TbadkCoreApplication {
    public static String mForumName = "armcv";
    public static TbadkApplication sApp;
    public CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.tbadk.TbadkApplication.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null) {
                return;
            }
            TbadkCoreApplication.setCurrentMemberType(num.intValue());
            if (num.intValue() != 0) {
                TbadkSettings inst = TbadkSettings.getInst();
                inst.saveBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), true);
                return;
            }
            TbadkSettings inst2 = TbadkSettings.getInst();
            inst2.saveBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
        }
    };
    public String[] mPatchWhiteList = {"HUAWEI:H60-L01", "HUAWEI:H60-L02", "HUAWEI:H60-L03"};
    public c resourcesWrapper;
    public String tShopUrl;

    private boolean checkSyncPatchBlacklist() {
        StringBuffer stringBuffer;
        Map<String, PluginSetting> plugins;
        try {
            plugins = d.k().l().getPlugins();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        if (d.k().l().hasPatch() && plugins != null && !plugins.isEmpty()) {
            Iterator<PluginSetting> it = plugins.values().iterator();
            PluginSetting pluginSetting = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PluginSetting next = it.next();
                if (next.isPatch && next.enable && !next.forbidden && TextUtils.isEmpty(next.replaceMethodClasses)) {
                    pluginSetting = next;
                    break;
                }
            }
            if (pluginSetting == null) {
                return false;
            }
            if (!TextUtils.isEmpty(pluginSetting.ext)) {
                String string = new JSONObject(pluginSetting.ext).getString("patch_blacklist_models");
                if (!TextUtils.isEmpty(string)) {
                    this.mPatchWhiteList = string.split(",");
                }
            }
            String[] strArr = this.mPatchWhiteList;
            if (strArr != null && strArr.length != 0) {
                String str = Build.MANUFACTURER;
                if (str == null) {
                    stringBuffer = new StringBuffer("");
                } else {
                    stringBuffer = new StringBuffer(str);
                }
                stringBuffer.append(':');
                String str2 = Build.MODEL;
                if (str2 != null) {
                    stringBuffer.append(str2);
                }
                String stringBuffer2 = stringBuffer.toString();
                for (String str3 : this.mPatchWhiteList) {
                    if (stringBuffer2.equals(str3)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static TbadkApplication getInst() {
        return sApp;
    }

    private void prepareForDefaultAlertTime() {
        Calendar calendar = Calendar.getInstance();
        setSignAlertTime(calendar.get(11), calendar.get(12));
    }

    public Intent createIntentForSignAlarm() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(getInst().getContext(), SignAlertReceiver.class);
        return intent;
    }

    public String getForumName() {
        return mForumName;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst() != null && !BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            if (this.resourcesWrapper == null && super.getResources() != null) {
                this.resourcesWrapper = new c(super.getResources());
            }
            return this.resourcesWrapper;
        }
        return super.getResources();
    }

    public int getSignAlertHours() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
    }

    public int getSignAlertMins() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
        }
        return loadInt;
    }

    public String gettShopUrl() {
        return this.tShopUrl;
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication
    public void handleInitMessage(Message message) {
        if (message == null) {
            return;
        }
        super.handleInitMessage(message);
        boolean z = true;
        switch (message.what) {
            case 6:
                boolean isXiaomiPushSdkShouldOpen = isXiaomiPushSdkShouldOpen();
                boolean z2 = this.mIsToLogo && isXiaomiPushSdkShouldOpen;
                b.e("TbadkApplication_onCreate", z2 ? "plugin_load_delay" : "plugin_load_now");
                long currentTimeMillis = System.currentTimeMillis();
                b.e("TbadkApplication_onCreate", "load_all_plugins");
                String str = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER;
                if (!((isMainProcess(false) && PluginClassChangeSwitch.isOn()) ? false : false)) {
                    isXiaomiPushSdkShouldOpen = z2;
                }
                boolean z3 = Build.VERSION.SDK_INT < 28 ? isXiaomiPushSdkShouldOpen : false;
                if (!this.isKeepLiveProcess) {
                    if (!this.mPluginIsInited) {
                        PluginPackageManager.O().i0(d.a.i0.o0.c.n(), new d.a.i0.o0.d(), z3, null);
                    }
                    PluginSettings l = d.k().l();
                    if (l != null) {
                        String containerVersion = l.getContainerVersion();
                        if (!TextUtils.isEmpty(containerVersion) && Util.c(containerVersion, str) == Util.VersionCompare.EQUAL) {
                            l.b().D(z3);
                            l.b().C(System.currentTimeMillis() - currentTimeMillis);
                        }
                    }
                }
                this.mAppInitHandler.sendEmptyMessage(7);
                return;
            case 7:
                setActivityStackMaxSize(20);
                if (isMainProcess(false)) {
                    updateSignAlarm();
                    initLikeForum();
                    initSignedForum();
                }
                this.mAppInitHandler.sendEmptyMessage(8);
                return;
            case 8:
                MessageManager.getInstance().registerListener(this.mMemListener);
                if (isMainProcess(true)) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    NASLib.setCallBack(new NASLib.NASCallBack() { // from class: com.baidu.tbadk.TbadkApplication.2
                        @Override // com.baidu.appsearchlib.NASLib.NASCallBack
                        public void callback(String str2, String str3) {
                            UrlManager.getInstance().dealOneLink(null, new String[]{str3});
                        }
                    });
                    l.b().q(System.currentTimeMillis() - currentTimeMillis2);
                }
                this.mAppInitHandler.sendEmptyMessage(9);
                return;
            case 9:
                EmotionUtil.statisticsEmotionGroupNums();
                if (this.isRemoteProcess) {
                    l.b().g(System.currentTimeMillis() - this.processCreateTime);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void initSetting() {
        super.initSetting();
        upgradeAbstractOnInMemory(TbadkSettings.getInst().loadInt("new_abstract_state", 0));
    }

    public boolean isDaemonProcess() {
        return this.isDaemonProcess;
    }

    public boolean isSignAlertOn() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    public boolean isTbCDNTachometerProcess() {
        Boolean bool = this.isCdnTachometerProcess;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void loadPatchs() {
        if (this.isKeepLiveProcess) {
            return;
        }
        super.loadPatchs();
        int k = d.a.i0.r.d0.b.j().k("plugin_patch_hook_failed_count", 0);
        PluginPackageManager.O().v0(k);
        if (checkSyncPatchBlacklist() && d.a.c.h.g.d.l() && k == 0 && PluginPackageManager.O().n0()) {
            long currentTimeMillis = System.currentTimeMillis();
            PluginPackageManager.O().k0();
            l.b().B(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public String loginShareRead() {
        return loadString("account_share", null);
    }

    public void loginShareRemove() {
        d.a.i0.r.d0.b.j().C("account_share");
    }

    public void loginShareSave(String str) {
        saveString("account_share", str);
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication, android.app.Application
    public void onCreate() {
        sApp = this;
        super.onCreate();
    }

    public void setForumName(String str) {
        mForumName = str;
    }

    public void setSignAlertOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
        updateSignAlarm();
    }

    public void setSignAlertTime(int i2, int i3) {
        TbadkSettings.getInst().saveInt("alert_sign_hours", i2);
        TbadkSettings.getInst().saveInt("alert_sign_mins", i3);
        updateSignAlarm();
    }

    public void settShopUrl(String str) {
        this.tShopUrl = str;
    }

    public void updateSignAlarm() {
        AlarmManager alarmManager = (AlarmManager) getInst().getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent createIntentForSignAlarm = createIntentForSignAlarm();
        if (isSignAlertOn()) {
            Calendar calendar = Calendar.getInstance();
            int signAlertHours = getSignAlertHours();
            int i2 = calendar.get(11);
            int signAlertMins = getSignAlertMins();
            int i3 = calendar.get(12);
            calendar.set(11, signAlertHours);
            calendar.set(12, signAlertMins);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i2 >= signAlertHours && (i2 != signAlertHours || i3 >= signAlertMins)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, 134217728));
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }
}
