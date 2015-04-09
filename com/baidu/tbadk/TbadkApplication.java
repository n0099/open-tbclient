package com.baidu.tbadk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import com.baidu.adp.base.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.g.d;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.d.a;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.e;
import com.baidu.tbadk.performanceLog.ai;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.util.Calendar;
/* loaded from: classes.dex */
public class TbadkApplication extends TbadkCoreApplication implements b {
    private static final String CUSTOM_THEME_URL = "file:///android_asset/sapi_theme/style.css";
    CustomMessageListener mMemListener = new CustomMessageListener(2001200) { // from class: com.baidu.tbadk.TbadkApplication.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
                if (num.intValue() != 0) {
                    TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.isMem + TbadkApplication.getCurrentAccount(), true);
                } else {
                    TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.isMem + TbadkApplication.getCurrentAccount(), false);
                }
            }
        }
    };
    public long processCreateTime;
    private d resourcesWrapper;
    private String tShopUrl;
    protected static TbadkApplication sApp = null;
    private static String mForumName = "armcv";

    public static TbadkApplication getInst() {
        return sApp;
    }

    private void initSapi() {
        String string;
        Resources resources = getResources();
        if (resources == null) {
            string = "";
        } else {
            string = resources.getString(y.register_tip);
        }
        SapiAccountManager.getInstance().init(new SapiConfiguration.Builder(getContext()).setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).setRuntimeEnvironment(com.baidu.tbadk.coreExtra.act.b.aan).registMode(RegistMode.FAST).initialShareStrategy(LoginShareStrategy.CHOICE).skin(CUSTOM_THEME_URL).fastRegConfirm(isNeedConfirm()).fastRegConfirmMsg(string).build());
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
        PluginPackageManager.ls().a(a.CZ(), new com.baidu.tbadk.d.d(), String.valueOf(TbConfig.getVersion()) + "." + TbConfig.BUILD_NUMBER, isMainProcess(false));
        ab.sy();
        initSettings();
        if (isMainProcess(true)) {
            UninstallInquirer.getInstance().startProcessBySwitch();
        }
        setActivityStackMaxSize(20);
        if (isMainProcess(false)) {
            updateSignAlarm();
            initLikeForum();
            initSignedForum();
        }
        MessageManager.getInstance().registerListener(this.mMemListener);
        ai.CW().x(System.currentTimeMillis());
        if (this.isRemoteProcess) {
            ai.CW().D(System.currentTimeMillis() - this.processCreateTime);
        }
    }

    private void initSettings() {
        getInst().mViewImageQuality = TbadkSettings.getInst().loadInt("view_image_quality", 0);
        getInst().setSkinTypeValue(TbadkSettings.getInst().loadInt("skin", 0));
        com.baidu.adp.lib.d.a.gZ().y(Build.VERSION.SDK_INT > 4 ? TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true) : false);
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
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(getInst().getContext(), 0, createIntentForSignAlarm, 268435456));
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

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.resourcesWrapper == null && super.getResources() != null) {
            this.resourcesWrapper = new d(super.getResources());
        }
        return this.resourcesWrapper;
    }

    public void init(Context context) {
    }

    public void clearMemOnActivityEmpty() {
        if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_IN_KUANG_SDK) {
            onLowMemory();
            n.iU();
            f.fR();
            BdCacheService.fR();
            com.baidu.tbadk.core.b.a.fR();
            com.baidu.adp.lib.asyncTask.f.fR();
            com.baidu.tbadk.core.sharedPref.b.fR();
            GifView.releaseBitmap();
            e.zy().zA();
            getApp().getResources().updateConfiguration(getApp().getResources().getConfiguration(), getApp().getResources().getDisplayMetrics());
        }
    }

    public boolean isDaemonProcess() {
        return this.isDaemonProcess;
    }

    public boolean isXiubaProcess() {
        return this.isXiubaProcess;
    }

    public boolean isTbCDNTachometerProcess() {
        if (this.isCdnTachometerProcess == null) {
            return false;
        }
        return this.isCdnTachometerProcess.booleanValue();
    }

    public void loginShareRemove() {
        com.baidu.tbadk.core.sharedPref.b.rB().remove("account_share");
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
        motuFilterImageMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, Integer.valueOf(u.motu_filter_normal));
        motuFilterImageMap.put("clvivid", Integer.valueOf(u.motu_filter_skin));
        motuFilterImageMap.put("cllomoscenery", Integer.valueOf(u.motu_filter_lomo));
        motuFilterImageMap.put("clcaisefupian", Integer.valueOf(u.motu_filter_classichdr));
        motuFilterImageMap.put("clm3", Integer.valueOf(u.motu_filter_nashiv));
        motuFilterImageMap.put("cqiuse", Integer.valueOf(u.motu_filter_fleeting));
        motuFilterImageMap.put("clzaoan", Integer.valueOf(u.motu_filter_bluetone));
        motuFilterImageMap.put("clfuguscenery", Integer.valueOf(u.motu_filter_elegant));
        motuFilterImageMap.put("clheibai", Integer.valueOf(u.motu_filter_gray));
    }

    public boolean isLiveRecordOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("live_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.gz().ag("switch_live_record") == 0;
    }

    public String gettShopUrl() {
        return this.tShopUrl;
    }

    public void settShopUrl(String str) {
        this.tShopUrl = str;
    }

    public void setAppUploadDate(long j) {
        TbadkSettings.getInst().saveLong("app_upload_time", j);
    }

    public long getAppUploadDate() {
        return TbadkSettings.getInst().loadLong("app_upload_time", 0L);
    }

    public void setAppUploadMd5(String str) {
        TbadkSettings.getInst().saveString("app_upload_md5", str);
    }

    public String getAppUploadMd5() {
        return TbadkSettings.getInst().loadString("app_upload_md5", null);
    }

    @Override // com.baidu.adp.base.b
    public void onActivityClosed() {
        clearMemOnActivityEmpty();
    }
}
