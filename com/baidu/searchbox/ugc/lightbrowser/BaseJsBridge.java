package com.baidu.searchbox.ugc.lightbrowser;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class BaseJsBridge {
    private WeakReference<Activity> mActivityRef;
    CallbackHandler mCallbackHandler;
    protected Context mContext;
    UnitedSchemeMainDispatcher mMainDispatcher;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler) {
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

    Context getDispatchContext() {
        Activity activity = this.mActivityRef != null ? this.mActivityRef.get() : null;
        if (activity == null) {
            return this.mContext;
        }
        return activity;
    }
}
