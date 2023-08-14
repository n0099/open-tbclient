package com.baidu.live;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.live.feedpage.interfaces.IHKLiveFeedPageInvoke;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.bsb;
import com.baidu.tieba.fd0;
import com.baidu.tieba.jc0;
import com.baidu.tieba.vb0;
/* loaded from: classes3.dex */
public class LiveFeedPageSdk {
    public static final String FOLLOW_VIDEO = "follow_video";
    public static final String HK_START_LIVE = "baiduhaokan://video/yylive/router?url=yymobile%3a%2f%2fMobileLive%2fPreViewPage%3fneedLogin%3d1";
    public static final String HOST_BAIDU = "baidu";
    public static final String HOST_HAOKAN = "haokan";
    public static final String HOST_LIVE_TAB = "live_tab";
    public static final String HOST_QUANMIN = "quanmin";
    public static final String HOST_TIEBA = "tieba";
    public static final String IMMERSION = "immersion";
    public static final String LIVE_SDK_VERSION = "6.4.5";
    public static final long REFRESH_TIME = 180000;
    public static final String UI_MODE_DARK = "dark";
    public static final String UI_MODE_DAY = "day";
    public static final String UI_MODE_NIGHT = "night";
    public static final String VIDEO_BAR = "video_bar";
    public static boolean liveFeedDebug;
    public static LiveFeedPageSdk sInstance;
    public IHKLiveFeedPageInvoke hkLiveFeedPageInvoke;
    public boolean isInit;
    public ILiveFeedPageInvoke liveFeedPageInvoke;
    public Context mAppContext;
    public String mHost;

    /* loaded from: classes3.dex */
    public static class Holder {
        public static final LiveFeedPageSdk INSTANCE = new LiveFeedPageSdk();
    }

    public static LiveFeedPageSdk getInstance() {
        if (sInstance == null) {
            sInstance = Holder.INSTANCE;
        }
        return sInstance;
    }

    public Context getApplication() {
        return this.mAppContext;
    }

    public String getBdId() {
        if (getInvoker() != null) {
            String uk = getInvoker().getUK();
            if (!TextUtils.isEmpty(uk) && !"0".equals(uk)) {
                return uk;
            }
            return getInvoker().getCuid();
        }
        return "";
    }

    public String getDefaultStartLiveScheme() {
        if (HOST_HAOKAN.equals(getHost())) {
            return HK_START_LIVE;
        }
        return null;
    }

    public IHKLiveFeedPageInvoke getHKInvoker() {
        return this.hkLiveFeedPageInvoke;
    }

    public String getHost() {
        return this.mHost;
    }

    @Nullable
    public ILiveFeedPageInvoke getInvoker() {
        return this.liveFeedPageInvoke;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void setInit() {
        this.isInit = true;
    }

    public static void liveLog(String str) {
        liveLog("LiveFeedPageSdk", str);
    }

    public String getYYHDID(Context context) {
        return bsb.a(context);
    }

    public void initInvoke(ILiveFeedPageInvoke iLiveFeedPageInvoke) {
        this.liveFeedPageInvoke = iLiveFeedPageInvoke;
    }

    public void initNetWork(INetWork iNetWork) {
        jc0.b(iNetWork);
    }

    public void setContext(Context context) {
        if (context != null && this.mAppContext == null) {
            this.mAppContext = context.getApplicationContext();
        }
    }

    public void setHKInvoker(IHKLiveFeedPageInvoke iHKLiveFeedPageInvoke) {
        this.hkLiveFeedPageInvoke = iHKLiveFeedPageInvoke;
    }

    public void startLiveSearchActivity(Context context) {
        if (vb0.a() != null) {
            vb0.a().a(context, "");
        }
    }

    public void updateUiMode(String str) {
        fd0.f().u(str);
    }

    public static void liveLog(String str, String str2) {
        if (liveFeedDebug) {
            Log.i(str, str2);
        }
    }

    public void initHostInfo(String str, String str2) {
        this.mHost = str;
        fd0.f().s(str, str2);
    }

    public void starLivePageActivity(Context context, String str, String str2, String str3, String str4, boolean z) {
        if (context != null) {
            Intent intent = new Intent(context, LiveFeedPageActivity.class);
            intent.putExtra("source", str);
            intent.putExtra("scheme_next", str2);
            intent.putExtra("tab_extend_subtype", str3);
            intent.putExtra("tab_extend_thirdtype", str4);
            intent.putExtra("tab_extend_scroll_to_tab", z);
            if (!(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }
}
