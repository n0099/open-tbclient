package com.baidu.searchbox.ng.ai.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class AiAppBaseJsBridge {
    public static final boolean DEBUG = false;
    private WeakReference<Activity> mActivityRef;
    protected CallbackHandler mCallbackHandler;
    protected Context mContext;
    protected UnitedSchemeMainDispatcher mMainDispatcher;

    public AiAppBaseJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        this.mContext = context;
        this.mMainDispatcher = unitedSchemeMainDispatcher;
        this.mCallbackHandler = callbackHandler;
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        this.mCallbackHandler = callbackHandler;
    }

    public void setActivityRef(Activity activity) {
        if (activity != null) {
            this.mActivityRef = new WeakReference<>(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getDispatchContext() {
        Activity activity = this.mActivityRef != null ? this.mActivityRef.get() : null;
        if (activity == null) {
            return this.mContext;
        }
        return activity;
    }
}
