package com.baidu.tbadk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.b.b;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.appsearchlib.NASLib;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.o.d;
import com.baidu.tbadk.switchs.PluginClassChangeSwitch;
import com.baidu.tbadk.switchs.XiaomiWebViewInitSwitch;
import com.baidu.tieba.service.SignAlertReceiver;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbadkApplication extends TbadkCoreApplication {
    CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tbadk.TbadkApplication.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
                TbadkCoreApplication.setCurrentMemberType(num.intValue());
                if (num.intValue() != 0) {
                    TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.isMem + TbadkApplication.getCurrentAccount(), true);
                } else {
                    TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.isMem + TbadkApplication.getCurrentAccount(), false);
                }
            }
        }
    };
    private String[] mPatchWhiteList = {"HUAWEI:H60-L01", "HUAWEI:H60-L02", "HUAWEI:H60-L03"};
    private c resourcesWrapper;
    private String tShopUrl;
    protected static TbadkApplication sApp = null;
    private static String mForumName = "armcv";

    public static TbadkApplication getInst() {
        return sApp;
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication, android.app.Application
    public void onCreate() {
        sApp = this;
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication
    public void handleInitMessage(Message message) {
        boolean z = true;
        if (message != null) {
            super.handleInitMessage(message);
            switch (message.what) {
                case 6:
                    boolean isXiaomiPushSdkShouldOpen = isXiaomiPushSdkShouldOpen();
                    boolean z2 = this.mIsToLogo && isXiaomiPushSdkShouldOpen;
                    b.E("TbadkApplication_onCreate", z2 ? "plugin_load_delay" : "plugin_load_now");
                    if (Build.VERSION.SDK_INT >= 24 && (!this.isRemoteProcess || XiaomiWebViewInitSwitch.isOn())) {
                        try {
                            new WebView(this);
                        } catch (Throwable th) {
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    b.E("TbadkApplication_onCreate", "load_all_plugins");
                    String str = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER;
                    if (!isMainProcess(false) || !PluginClassChangeSwitch.isOn()) {
                        z = false;
                    }
                    if (z) {
                        z2 = isXiaomiPushSdkShouldOpen;
                    }
                    boolean z3 = Build.VERSION.SDK_INT < 28 ? z2 : false;
                    if (!this.isKeepLiveProcess) {
                        if (!this.mPluginIsInited) {
                            PluginPackageManager.nX().a(com.baidu.tbadk.o.c.bfW(), new d(), z3, (Object) null);
                        }
                        PluginSettings ox = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox();
                        if (ox != null) {
                            String containerVersion = ox.getContainerVersion();
                            if (!TextUtils.isEmpty(containerVersion) && Util.K(containerVersion, str) == Util.VersionCompare.EQUAL) {
                                n.bfN().ir(z3);
                                n.bfN().cz(System.currentTimeMillis() - currentTimeMillis);
                            }
                        }
                    }
                    this.mAppInitHandler.sendEmptyMessage(7);
                    return;
                case 7:
                    initSettings();
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
                                ba.aUZ().b(null, new String[]{str3});
                            }
                        });
                        n.bfN().cJ(System.currentTimeMillis() - currentTimeMillis2);
                    }
                    this.mAppInitHandler.sendEmptyMessage(9);
                    return;
                case 9:
                    j.aUj();
                    if (this.isRemoteProcess) {
                        n.bfN().cR(System.currentTimeMillis() - this.processCreateTime);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void initSettings() {
        getInst().mViewImageQuality = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_VIEW_IMAGE_QUALITY, 0);
    }

    public boolean isSignAlertOn() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.ALERT_SIGN_ON, false);
    }

    public void setSignAlertOn(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.ALERT_SIGN_ON, z);
        updateSignAlarm();
    }

    public int getSignAlertHours() {
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.ALERT_SIGN_HOURS, -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt(SharedPrefConfig.ALERT_SIGN_HOURS, 12);
        }
        return loadInt;
    }

    private void prepareForDefaultAlertTime() {
        Calendar calendar = Calendar.getInstance();
        setSignAlertTime(calendar.get(11), calendar.get(12));
    }

    public int getSignAlertMins() {
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.ALERT_SIGN_MINS, -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt(SharedPrefConfig.ALERT_SIGN_MINS, 30);
        }
        return loadInt;
    }

    public void setSignAlertTime(int i, int i2) {
        TbadkSettings.getInst().saveInt(SharedPrefConfig.ALERT_SIGN_HOURS, i);
        TbadkSettings.getInst().saveInt(SharedPrefConfig.ALERT_SIGN_MINS, i2);
        updateSignAlarm();
    }

    public void updateSignAlarm() {
        AlarmManager alarmManager = (AlarmManager) getInst().getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent createIntentForSignAlarm = createIntentForSignAlarm();
        if (isSignAlertOn()) {
            Calendar calendar = Calendar.getInstance();
            int signAlertHours = getSignAlertHours();
            int i = calendar.get(11);
            int signAlertMins = getSignAlertMins();
            int i2 = calendar.get(12);
            calendar.set(11, signAlertHours);
            calendar.set(12, signAlertMins);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= signAlertHours && (i != signAlertHours || i2 >= signAlertMins)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, 134217728));
            if (BdLog.isDebugMode()) {
            }
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            if (BdLog.isDebugMode()) {
            }
        }
    }

    protected Intent createIntentForSignAlarm() {
        Intent intent = new Intent(com.baidu.tbadk.data.d.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(getInst().getContext(), SignAlertReceiver.class);
        return intent;
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst() == null || BdBaseApplication.getInst().getIsPluginResourcOpen()) {
            return super.getResources();
        }
        if (this.resourcesWrapper == null && super.getResources() != null) {
            this.resourcesWrapper = new c(super.getResources());
        }
        return this.resourcesWrapper;
    }

    public boolean isDaemonProcess() {
        return this.isDaemonProcess;
    }

    public boolean isTbCDNTachometerProcess() {
        if (this.isCdnTachometerProcess == null) {
            return false;
        }
        return this.isCdnTachometerProcess.booleanValue();
    }

    public void loginShareRemove() {
        com.baidu.tbadk.core.sharedPref.b.aTX().remove(SharedPrefConfig.ACCOUNT_SHARE);
    }

    public String loginShareRead() {
        return loadString(SharedPrefConfig.ACCOUNT_SHARE, null);
    }

    public void loginShareSave(String str) {
        saveString(SharedPrefConfig.ACCOUNT_SHARE, str);
    }

    public void setForumName(String str) {
        mForumName = str;
    }

    public String getForumName() {
        return mForumName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void initSetting() {
        super.initSetting();
        upgradeAbstractOnInMemory(TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_ABSTRACT_STATE, 0));
    }

    public String gettShopUrl() {
        return this.tShopUrl;
    }

    public void settShopUrl(String str) {
        this.tShopUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void loadPatchs() {
        if (!this.isKeepLiveProcess) {
            super.loadPatchs();
            int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.PATCH_FATAL_ERROR_COUNT, 0);
            PluginPackageManager.nX().ar(i);
            if (checkSyncPatchBlacklist() && com.baidu.adp.plugin.install.d.nF() && i == 0 && PluginPackageManager.nX().ob()) {
                long currentTimeMillis = System.currentTimeMillis();
                PluginPackageManager.nX().oc();
                n.bfN().cy(System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    private boolean checkSyncPatchBlacklist() {
        StringBuffer stringBuffer;
        Map<String, PluginSetting> plugins;
        PluginSetting pluginSetting;
        try {
            plugins = com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox().getPlugins();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        if (!com.baidu.adp.plugin.packageManager.pluginSettings.c.oA().ox().hasPatch() || plugins == null || plugins.isEmpty()) {
            return false;
        }
        Iterator<PluginSetting> it = plugins.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                pluginSetting = null;
                break;
            }
            pluginSetting = it.next();
            if (pluginSetting.isPatch && pluginSetting.enable && !pluginSetting.forbidden && TextUtils.isEmpty(pluginSetting.replaceMethodClasses)) {
                break;
            }
        }
        if (pluginSetting == null) {
            return false;
        }
        if (!TextUtils.isEmpty(pluginSetting.ext)) {
            String string = new JSONObject(pluginSetting.ext).getString("patch_blacklist_models");
            if (!TextUtils.isEmpty(string)) {
                this.mPatchWhiteList = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        if (this.mPatchWhiteList == null || this.mPatchWhiteList.length == 0) {
            return true;
        }
        if (Build.MANUFACTURER == null) {
            stringBuffer = new StringBuffer("");
        } else {
            stringBuffer = new StringBuffer(Build.MANUFACTURER);
        }
        stringBuffer.append(':');
        if (Build.MODEL != null) {
            stringBuffer.append(Build.MODEL);
        }
        String stringBuffer2 = stringBuffer.toString();
        for (String str : this.mPatchWhiteList) {
            if (stringBuffer2.equals(str)) {
                return false;
            }
        }
        return true;
    }
}
