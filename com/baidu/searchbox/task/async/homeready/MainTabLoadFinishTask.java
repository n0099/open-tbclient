package com.baidu.searchbox.task.async.homeready;

import android.app.Activity;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.logsystem.basic.Loki;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.aj;
import com.baidu.tieba.b06;
import com.baidu.tieba.da5;
import com.baidu.tieba.h29;
import com.baidu.tieba.l65;
import com.baidu.tieba.m65;
import com.baidu.tieba.x50;
import com.baidu.tieba.yk;
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
        if (StringUtils.isNull(str2) || (b = new x50("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(str2)) == null) {
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
                String str;
                try {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        m65.p(currentActivity, l65.q);
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        da5.p().J("key_default_useragent", WebSettings.getDefaultUserAgent(TbadkCoreApplication.getInst()));
                    }
                    String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst().getContext());
                    String w = da5.p().w("key_last_cached_oid", "");
                    if (StringUtils.isNull(w) || !w.equals(lastCachedOid)) {
                        da5.p().J("key_last_cached_oid", lastCachedOid);
                        da5.p().J("key_last_cached_real_oid", MainTabLoadFinishTask.this.getRealOaid(lastCachedOid));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                boolean l = da5.p().l("key_splash_shake_ad_open", true);
                StatisticItem statisticItem = new StatisticItem("c15178");
                if (l) {
                    str = "0";
                } else {
                    str = "1";
                }
                TiebaStatic.log(statisticItem.param("obj_param1", str));
                h29 a = yk.a();
                a.c(Config.DEVICE_PART, "Device Info: cuid: " + TbadkCoreApplication.getInst().getCuid() + " from: " + TbadkCoreApplication.getFrom() + " client_version: " + TbConfig.getVersion() + " os_version: " + aj.k());
                return false;
            }
        });
        try {
            String w = da5.p().w("key_cache_url_list", null);
            if (!TextUtils.isEmpty(w)) {
                JSONArray jSONArray = new JSONArray(w);
                h29 defaultLog = DefaultLog.getInstance();
                defaultLog.c("WebPreheat", "冷启动预热H5:" + jSONArray);
                b06.e(jSONArray);
            }
        } catch (Throwable th) {
            h29 defaultLog2 = DefaultLog.getInstance();
            defaultLog2.b("WebPreheat", "exception:" + th);
        }
    }
}
