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
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.FloatButton;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a dFi;
    private FloatButton dFj;
    private JSONObject dFk;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a aJG() {
        if (dFi == null) {
            synchronized (a.class) {
                if (dFi == null) {
                    dFi = new a();
                }
            }
        }
        return dFi;
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
            this.mText = ak.isAppInstalled(activity, this.mApkName) ? activity.getString(a.h.swan_app_hover_button_open) : activity.getString(a.h.swan_app_hover_button_download);
            this.dFk = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton aJH() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.dFj == null) {
            this.dFj = g(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.dFj.setFloatButtonText(this.mText);
        this.dFj.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.dFj.setFloatButtonDefaultPosition();
        this.dFj.setFloatButtonStyle(this.dFk);
        this.dFj.setVisibility(0);
        return this.dFj;
    }

    private FloatButton g(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton dp = dp(context);
        viewGroup.addView(dp);
        return dp;
    }

    private FloatButton dp(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void x(Intent intent) {
        if (intent != null && this.dFj != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.dFj.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton aJI() {
        return this.dFj;
    }

    public void a(FloatButton floatButton) {
        this.dFj = floatButton;
    }

    public void rS(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (dFi != null) {
            dFi = null;
        }
    }
}
