package com.baidu.platform.comapi.util;

import android.os.Build;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
import com.baidu.vi.VIContext;
/* loaded from: classes3.dex */
public class e {
    private static NACommonMemCache a = new NACommonMemCache();

    public static void a() {
        c();
    }

    public static NACommonMemCache b() {
        return a;
    }

    private static void c() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        String str = Build.MODEL;
        a.a(SyncSysInfo.initPhoneInfo());
        jsonBuilder.object();
        jsonBuilder.putStringValue(Config.EVENT_PAGE_MAPPING, "map");
        jsonBuilder.putStringValue("ov", "Android" + Build.VERSION.SDK_INT);
        jsonBuilder.putStringValue("ver", "2");
        jsonBuilder.key("sw").value(SysOSUtil.getInstance().getScreenWidth());
        jsonBuilder.key(IXAdRequestInfo.SCREEN_HEIGHT).value(SysOSUtil.getInstance().getScreenHeight());
        jsonBuilder.putStringValue("channel", "oem");
        jsonBuilder.putStringValue("mb", str);
        jsonBuilder.putStringValue("sv", SyncSysInfo.getSoftWareVer());
        jsonBuilder.putStringValue("os", "android");
        jsonBuilder.putStringValue("cuid", SyncSysInfo.getCid());
        jsonBuilder.putStringValue("path", SysOSUtil.getInstance().getOutputDirPath() + "/udc/");
        jsonBuilder.endObject();
        a.a("logstatistics", jsonBuilder.getJson());
        jsonBuilder.reset();
        jsonBuilder.object();
        jsonBuilder.putStringValue("cuid", SyncSysInfo.getCid());
        jsonBuilder.putStringValue("app", "1");
        jsonBuilder.putStringValue("path", VIContext.getContext().getCacheDir().getAbsolutePath() + "/");
        jsonBuilder.putStringValue("domain", "");
        jsonBuilder.endObject();
        a.a("longlink", jsonBuilder.getJson());
    }
}
