package com.baidu.browser.sailor.feature.b;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends com.baidu.browser.sailor.feature.a {
    protected Map<Activity, b> VS;

    public a(Context context) {
        super(context);
        this.VS = new HashMap();
    }

    public boolean a(Activity activity, ValueCallback<Uri> valueCallback) {
        boolean a = activity != null ? v(activity).a(valueCallback, "") : false;
        if (!a) {
            valueCallback.onReceiveValue(null);
        }
        return a;
    }

    public boolean a(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        boolean z = false;
        if (activity != null) {
            b v = v(activity);
            if (fileChooserParams != null) {
                z = v.a(valueCallback, fileChooserParams);
            }
        }
        if (!z) {
            valueCallback.onReceiveValue(null);
        }
        return z;
    }

    public boolean a(Activity activity, ValueCallback<Uri> valueCallback, String str) {
        boolean a = activity != null ? v(activity).a(valueCallback, str) : false;
        if (!a) {
            valueCallback.onReceiveValue(null);
        }
        return a;
    }

    public boolean a(Activity activity, ValueCallback<Uri> valueCallback, String str, String str2) {
        boolean a = activity != null ? v(activity).a(valueCallback, str, str2) : false;
        if (!a) {
            valueCallback.onReceiveValue(null);
        }
        return a;
    }

    @Override // com.baidu.browser.sailor.feature.a
    public String getName() {
        return "UPLOAD";
    }

    public b u(Activity activity) {
        if (this.VS == null || this.VS.size() <= 0) {
            return null;
        }
        return this.VS.get(activity);
    }

    protected b v(Activity activity) {
        b u = u(activity);
        if (u == null) {
            b bVar = new b(activity);
            this.VS.put(activity, bVar);
            return bVar;
        }
        return u;
    }
}
