package com.baidu.searchbox.common.security;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsInterfaceLogger implements NoProGuard {
    public static final int MSG_UI_UBC = 0;
    public static Set<String> mWhiteHosts;
    public static UiHandler sUiHandler;
    public String mArgs;
    public HashMap<String, String> mArgsMap;
    public String mFun;
    public LogContext mLogContext;
    public JSONObject mUbcContent;

    /* loaded from: classes3.dex */
    public static abstract class LogContext implements NoProGuard {
        public abstract String getClazz();

        public abstract String getHost();

        public abstract String getUrl();
    }

    /* loaded from: classes3.dex */
    public static class FilterLogContext extends LogContext implements NoProGuard {
        public String mClazz;
        public ReusableLogContext mResuableContext;

        public FilterLogContext(ReusableLogContext reusableLogContext, String str) {
            this.mResuableContext = reusableLogContext;
            this.mClazz = str;
        }

        @Override // com.baidu.searchbox.common.security.JsInterfaceLogger.LogContext
        public String getClazz() {
            return this.mClazz;
        }

        @Override // com.baidu.searchbox.common.security.JsInterfaceLogger.LogContext
        public String getHost() {
            return this.mResuableContext.getHost();
        }

        @Override // com.baidu.searchbox.common.security.JsInterfaceLogger.LogContext
        public String getUrl() {
            return this.mResuableContext.getUrl();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ReusableLogContext extends LogContext implements NoProGuard {
        @Override // com.baidu.searchbox.common.security.JsInterfaceLogger.LogContext
        public final String getClazz() {
            if (!AppConfig.isDebug()) {
                return "";
            }
            throw new IllegalStateException("");
        }
    }

    /* loaded from: classes3.dex */
    public static class UiHandler extends Handler {
        public UiHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JsInterfaceLogger jsInterfaceLogger = (JsInterfaceLogger) message.obj;
                try {
                    String url = jsInterfaceLogger.mLogContext.getUrl();
                    UnitedSchemeMainDispatcher.doUBCForSpecifiedJsinterface(jsInterfaceLogger.mFun, url);
                    if (SecurityConfig.DEBUG && TextUtils.isEmpty(url)) {
                        throw new IllegalStateException("url is empty + " + jsInterfaceLogger.mLogContext);
                    }
                    if (!TextUtils.isEmpty(url) && url.startsWith("http://") && JsInterfaceLogger.isInWhiteHost(url)) {
                        new JsHttpSecureStatistic().setJsType("2").setApi(jsInterfaceLogger.mFun).setUrl(url).statistic();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public JsInterfaceLogger(LogContext logContext) {
        this.mLogContext = logContext;
    }

    public JsInterfaceLogger setArgs(String str) {
        this.mArgs = str;
        return this;
    }

    public JsInterfaceLogger setFun(String str) {
        this.mFun = str;
        return this;
    }

    public static UiHandler getUiHandler() {
        if (sUiHandler == null) {
            synchronized (JsInterfaceLogger.class) {
                if (sUiHandler == null) {
                    sUiHandler = new UiHandler(Looper.getMainLooper());
                }
            }
        }
        return sUiHandler;
    }

    public static void init() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        mWhiteHosts = linkedHashSet;
        linkedHashSet.add(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE);
        mWhiteHosts.add("nuomi.com");
        mWhiteHosts.add("hao123.com");
        mWhiteHosts.add("baifubao.com");
    }

    public void log() {
        if (AbTestManager.getInstance().getSwitch("security_js", SecurityPersistConfigConst.SEC_ABILITY_LOG_ENABLE_DEFAULT)) {
            return;
        }
        getUiHandler().obtainMessage(0, 0, 0, this).sendToTarget();
    }

    public static boolean isInWhiteHost(String str) {
        Uri parse;
        if (mWhiteHosts == null) {
            init();
        }
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return false;
        }
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        for (String str2 : mWhiteHosts) {
            if (host.equals(str2)) {
                return true;
            }
            if (host.endsWith("." + str2)) {
                return true;
            }
        }
        return false;
    }

    public JsInterfaceLogger addArg(String str, String str2) {
        synchronized (this) {
            if (this.mArgsMap == null) {
                this.mArgsMap = new HashMap<>();
            }
            this.mArgsMap.put(str, str2);
        }
        return this;
    }
}
