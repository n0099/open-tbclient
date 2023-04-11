package com.baidu.searchbox.live.interfaces.context;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/context/PluginContextUtil;", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "getActivity", "(Landroid/content/Context;)Landroid/app/Activity;", "getRealContext", "(Landroid/content/Context;)Landroid/content/Context;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PluginContextUtil {
    public static final PluginContextUtil INSTANCE = new PluginContextUtil();

    public final Activity getActivity(Context context) {
        Context context2;
        if (!(context instanceof Activity)) {
            context2 = null;
        } else {
            context2 = context;
        }
        Activity activity = (Activity) context2;
        if (activity != null) {
            return activity;
        }
        if (!(context instanceof LivePluginActivityContextWrapper)) {
            context = null;
        }
        LivePluginActivityContextWrapper livePluginActivityContextWrapper = (LivePluginActivityContextWrapper) context;
        if (livePluginActivityContextWrapper == null) {
            return null;
        }
        return livePluginActivityContextWrapper.getActivity();
    }

    public final Context getRealContext(Context context) {
        if (context instanceof LivePluginActivityContextWrapper) {
            return ((LivePluginActivityContextWrapper) context).getBaseContext();
        }
        return context;
    }
}
