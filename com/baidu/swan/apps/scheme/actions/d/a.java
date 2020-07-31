package com.baidu.swan.apps.scheme.actions.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.FloatButton;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a cKq;
    private FloatButton cKr;
    private JSONObject cKs;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a asO() {
        if (cKq == null) {
            synchronized (a.class) {
                if (cKq == null) {
                    cKq = new a();
                }
            }
        }
        return cKq;
    }

    private a() {
    }

    public void a(Activity activity, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (DEBUG) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.mActivity = activity;
            this.mApkName = jSONObject.optString("name");
            this.mText = al.isAppInstalled(activity, this.mApkName) ? activity.getString(a.h.swan_app_hover_button_open) : activity.getString(a.h.swan_app_hover_button_download);
            this.cKs = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton asP() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.cKr == null) {
            this.cKr = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.cKr.setFloatButtonText(this.mText);
        this.cKr.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.cKr.setFloatButtonDefaultPosition();
        this.cKr.setFloatButtonStyle(this.cKs);
        this.cKr.setVisibility(0);
        return this.cKr;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton ck = ck(context);
        viewGroup.addView(ck);
        return ck;
    }

    private FloatButton ck(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void v(Intent intent) {
        if (intent != null && this.cKr != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.cKr.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton asQ() {
        return this.cKr;
    }

    public void a(FloatButton floatButton) {
        this.cKr = floatButton;
    }

    public void oU(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (cKq != null) {
            cKq = null;
        }
    }
}
