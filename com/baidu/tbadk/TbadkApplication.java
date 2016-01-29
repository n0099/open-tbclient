package com.baidu.tbadk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.e;
import com.baidu.adp.lib.h.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.install.m;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.appsearchlib.NASLib;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.message.UninstallInquirerBySwitchMessage;
import com.baidu.tbadk.g.a;
import com.baidu.tbadk.performanceLog.ab;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes.dex */
public class TbadkApplication extends TbadkCoreApplication {
    private static final String CUSTOM_THEME_URL = "file:///android_asset/sapi_theme/style.css";
    CustomMessageListener mMemListener = new CustomMessageListener(CmdConfigCustom.CMD_RESPONSE_MEM) { // from class: com.baidu.tbadk.TbadkApplication.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
                TbadkApplication.setCurrentMemberType(num.intValue());
                if (num.intValue() != 0) {
                    TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.isMem + TbadkApplication.getCurrentAccount(), true);
                } else {
                    TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.isMem + TbadkApplication.getCurrentAccount(), false);
                }
            }
        }
    };
    private c resourcesWrapper;
    private String tShopUrl;
    protected static TbadkApplication sApp = null;
    private static String mForumName = "armcv";

    public static TbadkApplication getInst() {
        return sApp;
    }

    private void initSapi() {
        String string;
        SapiConfiguration build;
        long currentTimeMillis = System.currentTimeMillis();
        SapiAccountManager.registerSilentShareListener(new SapiAccountManager.SilentShareListener() { // from class: com.baidu.tbadk.TbadkApplication.2
            @Override // com.baidu.sapi2.SapiAccountManager.SilentShareListener
            public void onSilentShare() {
                SapiAccountManager.unregisterSilentShareListener();
            }
        });
        Resources resources = getResources();
        if (resources == null) {
            string = "";
        } else {
            string = resources.getString(t.j.register_tip);
        }
        boolean z = b.uO().getBoolean("is_domain_qa", false);
        boolean isVoiceLoginCanUse = TbadkCoreApplication.m411getInst().isVoiceLoginCanUse();
        if (z) {
            build = new SapiConfiguration.Builder(getContext()).setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).setRuntimeEnvironment(Domain.DOMAIN_QA).registMode(RegistMode.FAST).customActionBar(true).initialShareStrategy(LoginShareStrategy.SILENT).skin(CUSTOM_THEME_URL).fastRegConfirm(isNeedConfirm()).fastRegConfirmMsg(string).fastLoginSupport(generateFastLoginFeatures(isVoiceLoginCanUse)).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).build();
        } else {
            build = new SapiConfiguration.Builder(getContext()).setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).setRuntimeEnvironment(com.baidu.tbadk.coreExtra.a.b.ajp).registMode(RegistMode.FAST).customActionBar(true).initialShareStrategy(LoginShareStrategy.SILENT).skin(CUSTOM_THEME_URL).fastRegConfirm(isNeedConfirm()).fastRegConfirmMsg(string).fastLoginSupport(generateFastLoginFeatures(isVoiceLoginCanUse)).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).build();
        }
        try {
            SapiAccountManager.getInstance().init(build);
        } catch (Exception e) {
        }
        ab.Ge().Q(System.currentTimeMillis() - currentTimeMillis);
    }

    private FastLoginFeature[] generateFastLoginFeatures(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 10) {
            arrayList.add(FastLoginFeature.TX_QQ_WEBVIEW);
            arrayList.add(FastLoginFeature.TX_WEIXIN_SSO);
        }
        if (z) {
            arrayList.add(FastLoginFeature.VOICE_LOGIN);
        }
        FastLoginFeature[] fastLoginFeatureArr = new FastLoginFeature[arrayList.size()];
        arrayList.toArray(fastLoginFeatureArr);
        return fastLoginFeatureArr;
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication, android.app.Application
    public void onCreate() {
        sApp = this;
        super.onCreate();
        initMotuFilterImageMap();
        if (isMainProcess(true)) {
            initSapi();
        }
        init(getContext());
        if ((this.isCdnTachometerProcess == null || !this.isCdnTachometerProcess.booleanValue()) && !this.isPluginInstallProcess) {
            boolean Gy = g.Gy();
            boolean isXiaomiPushSdkShouldOpen = isXiaomiPushSdkShouldOpen();
            long currentTimeMillis = System.currentTimeMillis();
            String str = String.valueOf(TbConfig.getVersion()) + "." + TbConfig.BUILD_NUMBER;
            PluginPackageManager.lD().a(a.Gj(), new com.baidu.tbadk.g.c(), Gy && isXiaomiPushSdkShouldOpen);
            PluginSettings lZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ();
            if (lZ != null) {
                String containerVersion = lZ.getContainerVersion();
                if (!TextUtils.isEmpty(containerVersion) && Util.M(containerVersion, str) == Util.VersionCompare.EQUAL) {
                    ab.Ge().R(System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
        initSettings();
        if (isMainProcess(true)) {
            MessageManager.getInstance().dispatchResponsedMessage(new UninstallInquirerBySwitchMessage());
        }
        setActivityStackMaxSize(20);
        if (isMainProcess(false)) {
            updateSignAlarm();
            initLikeForum();
            initSignedForum();
        }
        MessageManager.getInstance().registerListener(this.mMemListener);
        if (this.isRemoteProcess) {
            ab.Ge().ai(System.currentTimeMillis() - this.processCreateTime);
        }
        if (isMainProcess(true)) {
            long currentTimeMillis2 = System.currentTimeMillis();
            NASLib.setCallBack(new NASLib.NASCallBack() { // from class: com.baidu.tbadk.TbadkApplication.3
                @Override // com.baidu.appsearchlib.NASLib.NASCallBack
                public void callback(String str2, String str3) {
                    be.wt().c(null, new String[]{str3});
                }
            });
            ab.Ge().aa(System.currentTimeMillis() - currentTimeMillis2);
        }
        ab.Ge().O(System.currentTimeMillis());
    }

    private void initSettings() {
        getInst().mViewImageQuality = TbadkSettings.getInst().loadInt("view_image_quality", 0);
        getInst().setSkinTypeValue(TbadkSettings.getInst().loadInt("skin_" + TbadkCoreApplication.getCurrentAccount(), 0));
    }

    public boolean isSignAlertOn() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    public void setSignAlertOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
        updateSignAlarm();
    }

    public int getSignAlertHours() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
    }

    private void prepareForDefaultAlertTime() {
        Calendar calendar = Calendar.getInstance();
        setSignAlertTime(calendar.get(11), calendar.get(12));
    }

    public int getSignAlertMins() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
        }
        return loadInt;
    }

    public void setSignAlertTime(int i, int i2) {
        TbadkSettings.getInst().saveInt("alert_sign_hours", i);
        TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        updateSignAlarm();
    }

    public void updateSignAlarm() {
        AlarmManager alarmManager = (AlarmManager) getInst().getContext().getSystemService("alarm");
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
            BdLog.isDebugMode();
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            BdLog.isDebugMode();
        }
    }

    protected Intent createIntentForSignAlarm() {
        Intent intent = new Intent(com.baidu.tbadk.data.b.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(getInst().getContext(), SignAlertReceiver.class);
        return intent;
    }

    public void init(Context context) {
    }

    @Override // com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (BdBaseApplication.getInst().getIsPluginResourcOpen()) {
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
        b.uO().remove("account_share");
    }

    public String loginShareRead() {
        return loadString("account_share", null);
    }

    public void loginShareSave(String str) {
        saveString("account_share", str);
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
        upgradeAbstractOnInMemory(TbadkSettings.getInst().loadInt("new_abstract_state", 0));
    }

    private static void initMotuFilterImageMap() {
        motuFilterImageMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, Integer.valueOf(t.f.motu_filter_normal));
        motuFilterImageMap.put("clvivid", Integer.valueOf(t.f.motu_filter_skin));
        motuFilterImageMap.put("cllomoscenery", Integer.valueOf(t.f.motu_filter_lomo));
        motuFilterImageMap.put("clcaisefupian", Integer.valueOf(t.f.motu_filter_classichdr));
        motuFilterImageMap.put("clm3", Integer.valueOf(t.f.motu_filter_nashiv));
        motuFilterImageMap.put("cqiuse", Integer.valueOf(t.f.motu_filter_fleeting));
        motuFilterImageMap.put("clzaoan", Integer.valueOf(t.f.motu_filter_bluetone));
        motuFilterImageMap.put("clfuguscenery", Integer.valueOf(t.f.motu_filter_elegant));
        motuFilterImageMap.put("clheibai", Integer.valueOf(t.f.motu_filter_gray));
    }

    public boolean isLiveRecordOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("live_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && e.gE().ai("switch_live_record") == 0;
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
        super.loadPatchs();
        PluginPackageManager.lD().d(String.valueOf(TbConfig.getVersion()) + "." + TbConfig.BUILD_NUMBER, isMainProcess(false), this.isThirdProcess);
        if (m.lo()) {
            PluginPackageManager.lD().lH();
        } else if (b.uO().getBoolean("is_cpu_arch_saved", false)) {
            b.uO().putBoolean("is_cpu_arch_saved", true);
            com.baidu.adp.plugin.b.a.lq().bo("loadPatchs_cancel : not arm arch");
        }
    }
}
