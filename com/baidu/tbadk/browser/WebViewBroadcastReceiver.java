package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class WebViewBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_CLOSE_WEBVIEW = "action_close_webview";
    public static final String BROADCAST_PERMISSION_CLOSE_WEBVIEW = "com.baidu.live.sdk.permission.DETAIL_BROADCAST";
    public static final String INTENT_LOCALE_RECEV_CLOSE = "recClose";
    private boolean mReceiverTag;
    private WeakReference<Activity> reference;

    public void register(Activity activity) {
        if (activity != null) {
            this.reference = new WeakReference<>(activity);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ACTION_CLOSE_WEBVIEW);
            try {
                activity.registerReceiver(this, intentFilter, BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mReceiverTag = true;
        }
    }

    public void unregister() {
        Activity ref = getRef();
        if (ref != null && this.mReceiverTag) {
            try {
                ref.unregisterReceiver(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mReceiverTag = false;
    }

    private Activity getRef() {
        if (this.reference != null) {
            return this.reference.get();
        }
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Activity ref = getRef();
        if (intent != null && ref != null && TextUtils.equals(ACTION_CLOSE_WEBVIEW, intent.getAction()) && ref != null) {
            try {
                ref.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
