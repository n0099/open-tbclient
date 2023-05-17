package com.baidu.searchbox.common.security;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.JsInterfaceLogger;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class JsInterfaceChecker {
    public static final int CHECK_POLICY_BAIDU_INTERAL_ALLOW = 0;
    public static final int CHECK_RES_ALLOW = 0;
    public static final int CHECK_RES_REFUSE = 1;
    public static final boolean DEBUG;
    public static final int MSG_APS_SEC_CHECK = 0;
    public static final int MSG_CHECK_URL = 0;
    public static final int MSG_GET_URL = 1;
    public static final String TAG;
    public static HandlerThread sHandlerThread;
    public static UiHandler sUiHandler;
    public static WorkHandler sWorkHandler;
    public String mAnyThreadUrl;
    public String mArgs;
    public HashMap<String, String> mArgsMap;
    public int mCheckPolicy;
    public String mFun;
    public JsInterfaceLogger.LogContext mLogContext;
    public String mScheme;

    public boolean checkHost(String str) {
        return true;
    }

    public void onCheckPermissionFinished(int i) {
    }

    /* loaded from: classes3.dex */
    public static class MsgObj {
        public JsInterfaceChecker mJsInterfaceChecker;
        public String mUrl;

        public MsgObj() {
        }

        public MsgObj(String str, JsInterfaceChecker jsInterfaceChecker) {
            this.mUrl = str;
            this.mJsInterfaceChecker = jsInterfaceChecker;
        }
    }

    /* loaded from: classes3.dex */
    public static class UiHandler extends Handler {
        public UiHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            int i2 = 0;
            if (i != 0) {
                if (i == 1) {
                    JsInterfaceChecker jsInterfaceChecker = (JsInterfaceChecker) message.obj;
                    try {
                        String url = jsInterfaceChecker.mLogContext.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            if (!SecurityConfig.DEBUG) {
                                jsInterfaceChecker.onCheckPermissionFinished(1);
                                return;
                            }
                            throw new IllegalStateException("url is empty + " + jsInterfaceChecker.mLogContext);
                        }
                        JsInterfaceChecker.access$500().obtainMessage(0, 0, 0, new MsgObj(url, jsInterfaceChecker)).sendToTarget();
                        return;
                    } catch (Exception e) {
                        if (!JsInterfaceChecker.DEBUG) {
                            jsInterfaceChecker.onCheckPermissionFinished(1);
                            return;
                        }
                        throw new IllegalStateException(e);
                    }
                }
                return;
            }
            JsInterfaceChecker jsInterfaceChecker2 = (JsInterfaceChecker) message.obj;
            try {
                String url2 = jsInterfaceChecker2.mLogContext.getUrl();
                if (TextUtils.isEmpty(url2)) {
                    if (SecurityConfig.DEBUG) {
                        String str = JsInterfaceChecker.TAG;
                        Log.e(str, "url is empty + " + jsInterfaceChecker2.mLogContext);
                    }
                    jsInterfaceChecker2.onCheckPermissionFinished(1);
                } else if (!url2.equals(jsInterfaceChecker2.mAnyThreadUrl) && !jsInterfaceChecker2.checkUrlInAnyThread()) {
                    jsInterfaceChecker2.onCheckPermissionFinished(1);
                } else {
                    if (SchemeCheckerHelperImpl.getInstance().preCheckUrl(url2, jsInterfaceChecker2.mScheme) != 0) {
                        i2 = 1;
                    }
                    jsInterfaceChecker2.onCheckPermissionFinished(i2);
                }
            } catch (Exception e2) {
                if (!JsInterfaceChecker.DEBUG) {
                    jsInterfaceChecker2.onCheckPermissionFinished(1);
                    return;
                }
                throw new IllegalStateException(e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class WorkHandler extends Handler {
        public WorkHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                MsgObj msgObj = (MsgObj) message.obj;
                String str = msgObj.mUrl;
                JsInterfaceChecker jsInterfaceChecker = msgObj.mJsInterfaceChecker;
                int i = 0;
                if (JsInterfaceChecker.isWebUrl(str)) {
                    String host = Uri.parse(str).getHost();
                    if (TextUtils.isEmpty(host)) {
                        if (!SecurityConfig.DEBUG) {
                            jsInterfaceChecker.onCheckPermissionFinished(1);
                            return;
                        }
                        throw new IllegalStateException("host is empty + " + jsInterfaceChecker.mLogContext);
                    }
                    try {
                        if (!jsInterfaceChecker.checkHost(host)) {
                            i = 1;
                        }
                        jsInterfaceChecker.onCheckPermissionFinished(i);
                    } catch (Exception e) {
                        if (!JsInterfaceChecker.DEBUG) {
                            jsInterfaceChecker.onCheckPermissionFinished(1);
                            return;
                        }
                        throw new IllegalStateException(e);
                    }
                } else if (JsInterfaceChecker.isBaiduLocalDomain(str)) {
                    jsInterfaceChecker.onCheckPermissionFinished(0);
                } else {
                    jsInterfaceChecker.onCheckPermissionFinished(1);
                }
            }
        }
    }

    static {
        String simpleName;
        boolean z = SecurityConfig.DEBUG;
        DEBUG = z;
        if (z) {
            simpleName = "JsInterfaceChecker";
        } else {
            simpleName = JsInterfaceChecker.class.getSimpleName();
        }
        TAG = simpleName;
    }

    public static /* synthetic */ WorkHandler access$500() {
        return getWorkHandler();
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

    public static WorkHandler getWorkHandler() {
        if (sWorkHandler == null) {
            synchronized (JsInterfaceLogger.class) {
                if (sWorkHandler == null) {
                    HandlerThread handlerThread = new HandlerThread("Js_Interface_Checker");
                    sHandlerThread = handlerThread;
                    handlerThread.start();
                    sWorkHandler = new WorkHandler(sHandlerThread.getLooper());
                }
            }
        }
        return sWorkHandler;
    }

    public boolean check() {
        JsInterfaceLogger.LogContext logContext = this.mLogContext;
        if (logContext == null) {
            return true;
        }
        String host = logContext.getHost();
        String clazz = this.mLogContext.getClazz();
        if (SecurityConfig.DEBUG && !TextUtils.isEmpty(host)) {
            TextUtils.isEmpty(clazz);
        }
        getUiHandler().obtainMessage(0, 0, 0, this).sendToTarget();
        return false;
    }

    public boolean checkUrlInAnyThread() {
        if (TextUtils.isEmpty(this.mAnyThreadUrl) || SchemeCheckerHelperImpl.getInstance().preCheckUrl(this.mAnyThreadUrl, this.mScheme) == 0) {
            return true;
        }
        return false;
    }

    public JsInterfaceChecker(JsInterfaceLogger.LogContext logContext) {
        this(logContext, null, null);
    }

    public static boolean isWebUrl(String str) {
        String scheme = Uri.parse(str).getScheme();
        if (!TextUtils.equals(scheme, "http") && !TextUtils.equals(scheme, "https")) {
            return false;
        }
        return true;
    }

    public JsInterfaceChecker setArgs(String str) {
        this.mArgs = str;
        return this;
    }

    public JsInterfaceChecker setCheckPolicy(int i) {
        this.mCheckPolicy = i;
        return this;
    }

    public JsInterfaceChecker setFun(String str) {
        this.mFun = str;
        return this;
    }

    public JsInterfaceChecker(JsInterfaceLogger.LogContext logContext, String str) {
        this(logContext, str, null);
    }

    public JsInterfaceChecker addArg(String str, String str2) {
        synchronized (this) {
            if (this.mArgsMap == null) {
                this.mArgsMap = new HashMap<>();
            }
            this.mArgsMap.put(str, str2);
        }
        return this;
    }

    public JsInterfaceChecker(JsInterfaceLogger.LogContext logContext, String str, String str2) {
        this.mCheckPolicy = 0;
        this.mLogContext = logContext;
        this.mScheme = str;
        this.mAnyThreadUrl = str2;
    }

    public static boolean isBaiduLocalDomain(String str) {
        Uri parse;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && TextUtils.equals("file", parse.getScheme())) {
            String absolutePath = new File(AppRuntime.getAppContext().getFilesDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE).getAbsolutePath();
            if (!TextUtils.isEmpty(parse.getPath()) && parse.getPath().startsWith(absolutePath)) {
                return true;
            }
        }
        return false;
    }

    public boolean apsJsCheck() {
        JsInterfaceLogger.LogContext logContext;
        if (!SecurityPersistConfig.getInstance().getBoolean(SecurityPersistConfigConst.KEY_APS_JS_SEC_ABILITY_CHECK_ENABLE, true) || (logContext = this.mLogContext) == null) {
            return true;
        }
        String host = logContext.getHost();
        String clazz = this.mLogContext.getClazz();
        if (SecurityConfig.DEBUG && (TextUtils.isEmpty(host) || TextUtils.isEmpty(clazz))) {
            throw new IllegalStateException("host or cls is empty");
        }
        getUiHandler().obtainMessage(1, 0, 0, this).sendToTarget();
        return false;
    }
}
