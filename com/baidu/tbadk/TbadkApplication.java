package com.baidu.tbadk;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.baidu.adp.base.a;
import com.baidu.adp.base.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.g.d;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InvokeOnCreateOnMainThreadMessageConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.e;
import com.baidu.tbadk.performanceLog.ad;
/* loaded from: classes.dex */
public class TbadkApplication extends TbadkCoreApplication implements b {
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
    private VersionData mVersionData = null;
    public long processCreateTime;
    private d resourcesWrapper;
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
        init(getContext());
        a.ah().a(this);
        MessageManager.getInstance().sendMessage(new CustomMessage(2005005, new InvokeOnCreateOnMainThreadMessageConfig(getInst().getContext())));
        setActivityStackMaxSize(20);
        if (isMainProcess(false)) {
            initLikeForum();
            initSignedForum();
        }
        MessageManager.getInstance().registerListener(this.mMemListener);
        if (isMainProcess(true)) {
            com.baidu.tbadk.distribute.a.uU().uX();
            UninstallInquirer.getInstance().startProcessBySwitch();
        }
        ad.zC().x(System.currentTimeMillis());
        if (this.isRemoteProcess) {
            ad.zC().D(System.currentTimeMillis() - this.processCreateTime);
        }
        LivePlayingStatusMgr.tP();
        if (isMainProcess(false)) {
            av.pv().pw();
        }
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

    @Override // com.baidu.adp.base.BdBaseApplication, android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        onAppMemoryLow();
        super.onLowMemory();
    }

    @Override // com.baidu.adp.base.BdBaseApplication
    public void onAppMemoryLow() {
        int wf = e.we().wf();
        int max = (int) Math.max(wf * 0.8d, TbConfig.getBigImageMaxUsedMemory());
        if (max < wf) {
            BdLog.isDebugMode();
            e.we().dw(max);
        }
        com.baidu.tbadk.core.util.d.eS();
        c.eR().eS();
    }

    public void clearMemOnActivityEmpty() {
        if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_IN_KUANG_SDK) {
            onLowMemory();
            l.fr();
            f.ct();
            BdCacheService.ct();
            com.baidu.tbadk.core.a.a.ct();
            com.baidu.adp.lib.asyncTask.f.ct();
            com.baidu.tbadk.core.sharedPref.b.ct();
            GifView.releaseBitmap();
            e.we().wg();
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
        com.baidu.tbadk.core.sharedPref.b.oj().remove("account_share");
    }

    public String loginShareRead() {
        return loadString("account_share", null);
    }

    public void loginShareSave(String str) {
        saveString("account_share", str);
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void onUserChanged() {
        if (!l.isNetOk()) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001253));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2005007));
    }

    public void setFrom(String str) {
        TbConfig.setFrom(str);
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

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void incLiveSdkCrashCount() {
        String str = "live_sdk_crash_count_" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void incBaobaoCrashCount() {
        String str = "baobao_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void incDQCrashCount() {
        String str = "dq_crash_count" + TbConfig.getVersion();
        TbadkSettings.getInst().saveInt(str, TbadkSettings.getInst().loadInt(str, 0) + 1);
    }

    public boolean isLiveRecordOpen() {
        return TbadkSettings.getInst().loadInt(new StringBuilder("live_sdk_crash_count_").append(TbConfig.getVersion()).toString(), 0) <= getFeatureCrashAutoCloseLimit() && com.baidu.adp.lib.b.f.da().Z("switch_live_record") == 0;
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

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void setBDLocON(boolean z) {
        com.baidu.adp.lib.d.a.dB().y(z);
        TbadkSettings.getInst().saveBoolean("bd_loc_switcher", z);
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public VersionData getVersionData() {
        return this.mVersionData;
    }

    @Override // com.baidu.tbadk.core.TbadkCoreApplication
    public void setVersionData(VersionData versionData) {
        this.mVersionData = versionData;
    }

    public void delPersonData() {
        delCachData(2);
    }

    public void delCachData(int i) {
        if (getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), getCurrentAccount()});
        }
    }

    public String getCachData(int i) {
        Cursor cursor;
        Throwable th;
        String str = null;
        if (getCurrentAccount() != null) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.rawQuery("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), getCurrentAccount()});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                str = cursor.getString(2);
                            }
                        } catch (Exception e) {
                            e = e;
                            mainDBDatabaseManager.a(e, "getCachData");
                            com.baidu.adp.lib.g.a.b(cursor);
                            return str;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.b(cursor);
                        throw th;
                    }
                }
                com.baidu.adp.lib.g.a.b(cursor);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                com.baidu.adp.lib.g.a.b(cursor);
                throw th;
            }
        }
        return str;
    }

    @Override // com.baidu.adp.base.b
    public void onActivityClosed() {
        clearMemOnActivityEmpty();
    }
}
