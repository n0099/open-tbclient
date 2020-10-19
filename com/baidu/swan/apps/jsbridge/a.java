package com.baidu.swan.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.b;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class a {
    public static final boolean DEBUG = b.DEBUG;
    private WeakReference<Activity> mActivityRef;
    protected CallbackHandler mCallbackHandler;
    protected Context mContext;
    protected UnitedSchemeMainDispatcher mMainDispatcher;

    public a(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
        this.mContext = context;
        this.mMainDispatcher = unitedSchemeMainDispatcher;
        this.mCallbackHandler = callbackHandler;
        if (DEBUG) {
            if (this.mContext == null || this.mMainDispatcher == null) {
                throw new IllegalArgumentException("any of context, dispatcher objects can't be null.");
            }
        }
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
