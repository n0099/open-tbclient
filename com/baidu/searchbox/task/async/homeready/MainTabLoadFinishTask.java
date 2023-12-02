package com.baidu.searchbox.task.async.homeready;

import android.app.Activity;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.KVStorageRuntime;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.Loki;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.searchbox.util.KVStorageWrapper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.InitWriteWebDelaySwitch;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.n00;
import com.baidu.tieba.pv5;
import com.baidu.tieba.qf;
import com.baidu.tieba.r5b;
import com.baidu.tieba.write.WriteWebViewCacheManager;
import com.baidu.tieba.y05;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class MainTabLoadFinishTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "initMainTab";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initMainTab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRealOaid(String str) {
        String[] split;
        byte[] b;
        if (StringUtils.isNull(str) || (split = str.split("-")) == null || split.length <= 1) {
            return "";
        }
        String str2 = split[1];
        if (StringUtils.isNull(str2) || (b = new n00("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(str2)) == null) {
            return "";
        }
        try {
            return new String(b, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void initMainTab() {
        Loki.startTrack();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.searchbox.task.async.homeready.MainTabLoadFinishTask.1
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                try {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        YunDialogManager.onShow(currentActivity, y05.r);
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        SharedPrefHelper.getInstance().putString("key_default_useragent", WebSettings.getDefaultUserAgent(TbadkCoreApplication.getInst()));
                    }
                    String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst().getContext());
                    String string = SharedPrefHelper.getInstance().getString("key_last_cached_oid", "");
                    if (StringUtils.isNull(string) || !string.equals(lastCachedOid)) {
                        SharedPrefHelper.getInstance().putString("key_last_cached_oid", lastCachedOid);
                        SharedPrefHelper.getInstance().putString("key_last_cached_real_oid", MainTabLoadFinishTask.this.getRealOaid(lastCachedOid));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                MainTabLoadFinishTask.this.statSplashShakeSwitch();
                TbLog a = qf.a();
                a.i(Config.DEVICE_PART, "Device Info: cuid: " + TbadkCoreApplication.getInst().getCuid() + " from: " + TbadkCoreApplication.getFrom() + " client_version: " + TbConfig.getVersion() + " os_version: " + DeviceInfoHelper.getOsVersion());
                if (InitWriteWebDelaySwitch.isOn()) {
                    WriteWebViewCacheManager.g().j();
                    return false;
                }
                return false;
            }
        });
        try {
            String string = SharedPrefHelper.getInstance().getString("key_cache_url_list", null);
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("WebPreheat", "冷启动预热H5:" + jSONArray);
                pv5.e(jSONArray);
            }
        } catch (Throwable th) {
            TbLog defaultLog2 = DefaultLog.getInstance();
            defaultLog2.e("WebPreheat", "exception:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statSplashShakeSwitch() {
        String str;
        boolean z;
        boolean z2 = SharedPrefHelper.getInstance().getBoolean("key_splash_shake_ad_open", true);
        DefaultLog.getInstance().i(LaunchTask.TAG, "冷启动，开屏广告摇一摇开关状态" + z2);
        StatisticItem statisticItem = new StatisticItem("c15178");
        if (z2) {
            str = "0";
        } else {
            str = "1";
        }
        TiebaStatic.log(statisticItem.param("obj_param1", str));
        boolean contains = TbadkCoreApplication.getInst().getSharedPreferences("settings2", 0).contains("key_splash_shake_ad_open");
        boolean z3 = TbadkCoreApplication.getInst().getSharedPreferences("settings2", 0).getBoolean("key_splash_shake_ad_open", true);
        boolean isKVStorageInitSuccess = KVStorageFactory.isKVStorageInitSuccess();
        String absolutePath = AppRuntime.getAppContext().getDir(r5b.c, 0).getAbsolutePath();
        boolean exists = new File(absolutePath).exists();
        String kVStoragePath = KVStorageRuntime.getKVStorageControl().getKVStoragePath();
        if (kVStoragePath != null && new File(kVStoragePath).exists()) {
            z = true;
        } else {
            z = false;
        }
        String str2 = "hasSp: " + contains + " isOnSp: " + z3 + " isKVStorageInitSuccess: " + isKVStorageInitSuccess + " spPath: " + absolutePath + " isSpFileExist: " + exists + " kvPath: " + kVStoragePath + " isKvFileExist: " + z + " kvMeta: " + new KVStorageWrapper("settings2").getCustomMeta() + " hasKV: " + KVStorageFactory.getSharedPreferences("settings2", 0).contains("key_splash_shake_ad_open") + " isOnKV: " + TbadkCoreApplication.getInst().getSharedPreferences("settings2", 0).getBoolean("key_splash_shake_ad_open", true);
        qf.a().i(LaunchTask.TAG, "冷启动，开屏广告摇一摇开关状态(详细) " + str2);
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_type", "shake_switch_check").param("obj_source", "launch check: " + z2).param("obj_param1", str2));
    }
}
