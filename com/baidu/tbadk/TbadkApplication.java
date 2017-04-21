package com.baidu.tbadk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.install.l;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.message.UninstallInquirerBySwitchMessage;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.j.ab;
import com.baidu.tbadk.k.a;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
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
    private String[] mPatchWhiteList = {"HUAWEI:H60-L01", "HUAWEI:H60-L02", "HUAWEI:H60-L03"};
    private c resourcesWrapper;
    private String tShopUrl;
    protected static TbadkApplication sApp = null;
    private static String mForumName = "armcv";

    public static TbadkApplication getInst() {
        return sApp;
    }

    private void initSapi() {
        String str;
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
            str = "";
        } else {
            try {
                str = resources.getString(w.l.register_tip);
            } catch (Exception e) {
                str = "";
            }
        }
        if (b.uL().getBoolean("is_domain_qa", false)) {
            build = new SapiConfiguration.Builder(getContext()).setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).setRuntimeEnvironment(Domain.DOMAIN_QA).registMode(RegistMode.FAST).customActionBar(true).initialShareStrategy(LoginShareStrategy.SILENT).skin(CUSTOM_THEME_URL).fastRegConfirm(isNeedConfirm()).fastRegConfirmMsg(str).fastLoginSupport(generateFastLoginFeatures()).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).build();
        } else {
            build = new SapiConfiguration.Builder(getContext()).setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).setRuntimeEnvironment(com.baidu.tbadk.coreExtra.a.b.aop).registMode(RegistMode.FAST).customActionBar(true).initialShareStrategy(LoginShareStrategy.SILENT).skin(CUSTOM_THEME_URL).fastRegConfirm(isNeedConfirm()).fastRegConfirmMsg(str).fastLoginSupport(generateFastLoginFeatures()).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).build();
        }
        try {
            SapiAccountManager.getInstance().init(build);
        } catch (Exception e2) {
        }
        ab.GM().T(System.currentTimeMillis() - currentTimeMillis);
    }

    private FastLoginFeature[] generateFastLoginFeatures() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 10) {
            arrayList.add(FastLoginFeature.TX_QQ_WEBVIEW);
            arrayList.add(FastLoginFeature.TX_WEIXIN_SSO);
            arrayList.add(FastLoginFeature.SINA_WEIBO_WEBVIEW);
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
        if ((this.isCdnTachometerProcess == null || !this.isCdnTachometerProcess.booleanValue()) && !this.isPluginInstallProcess) {
            boolean Hl = i.Hl();
            boolean isXiaomiPushSdkShouldOpen = isXiaomiPushSdkShouldOpen();
            boolean z = Hl && isXiaomiPushSdkShouldOpen;
            long currentTimeMillis = System.currentTimeMillis();
            String str = String.valueOf(TbConfig.getVersion()) + "." + TbConfig.BUILD_NUMBER;
            PluginPackageManager.jy().a(a.GR(), new com.baidu.tbadk.k.c(), Hl && isXiaomiPushSdkShouldOpen);
            PluginSettings jY = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY();
            if (jY != null) {
                String containerVersion = jY.getContainerVersion();
                if (!TextUtils.isEmpty(containerVersion) && Util.I(containerVersion, str) == Util.VersionCompare.EQUAL) {
                    ab.GM().bZ(z);
                    ab.GM().V(System.currentTimeMillis() - currentTimeMillis);
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
            ab.GM().am(System.currentTimeMillis() - this.processCreateTime);
        }
        if (isMainProcess(true)) {
            long currentTimeMillis2 = System.currentTimeMillis();
            NASLib.setCallBack(new NASLib.NASCallBack() { // from class: com.baidu.tbadk.TbadkApplication.3
                @Override // com.baidu.appsearchlib.NASLib.NASCallBack
                public void callback(String str2, String str3) {
                    bb.wn().c(null, new String[]{str3});
                }
            });
            ab.GM().ae(System.currentTimeMillis() - currentTimeMillis2);
        }
        ab.GM().R(System.currentTimeMillis());
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
        Intent intent = new Intent(d.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(getInst().getContext(), SignAlertReceiver.class);
        return intent;
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
        b.uL().remove("account_share");
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
        motuFilterImageMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, Integer.valueOf(w.g.motu_filter_normal));
        motuFilterImageMap.put("clvivid", Integer.valueOf(w.g.motu_filter_skin));
        motuFilterImageMap.put("cllomoscenery", Integer.valueOf(w.g.motu_filter_lomo));
        motuFilterImageMap.put("clcaisefupian", Integer.valueOf(w.g.motu_filter_classichdr));
        motuFilterImageMap.put("clm3", Integer.valueOf(w.g.motu_filter_nashiv));
        motuFilterImageMap.put("cqiuse", Integer.valueOf(w.g.motu_filter_fleeting));
        motuFilterImageMap.put("clzaoan", Integer.valueOf(w.g.motu_filter_bluetone));
        motuFilterImageMap.put("clfuguscenery", Integer.valueOf(w.g.motu_filter_elegant));
        motuFilterImageMap.put("clheibai", Integer.valueOf(w.g.motu_filter_gray));
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
        PluginPackageManager.jy().d(String.valueOf(TbConfig.getVersion()) + "." + TbConfig.BUILD_NUMBER, isMainProcess(false), this.isThirdProcess);
        int i = b.uL().getInt("plugin_patch_hook_failed_count", 0);
        PluginPackageManager.jy().aC(i);
        if (checkSyncPatchBlacklist() && l.jj() && i == 0 && PluginPackageManager.jy().jC()) {
            long currentTimeMillis = System.currentTimeMillis();
            PluginPackageManager.jy().jD();
            ab.GM().U(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private boolean checkSyncPatchBlacklist() {
        StringBuffer stringBuffer;
        Map<String, PluginSetting> plugins;
        PluginSetting pluginSetting;
        try {
            plugins = com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY().getPlugins();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        if (!com.baidu.adp.plugin.packageManager.pluginSettings.c.kb().jY().hasPatch() || plugins == null || plugins.isEmpty()) {
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
                this.mPatchWhiteList = string.split(",");
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
