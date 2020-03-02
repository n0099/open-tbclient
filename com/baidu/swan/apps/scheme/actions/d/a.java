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
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.FloatButton;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bRG;
    private FloatButton bRH;
    private JSONObject bRI;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a adN() {
        if (bRG == null) {
            synchronized (a.class) {
                if (bRG == null) {
                    bRG = new a();
                }
            }
        }
        return bRG;
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
            this.mText = ai.isAppInstalled(activity, this.mApkName) ? activity.getString(a.h.swan_app_hover_button_open) : activity.getString(a.h.swan_app_hover_button_download);
            this.bRI = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton adO() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.bRH == null) {
            this.bRH = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.bRH.setFloatButtonText(this.mText);
        this.bRH.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.bRH.setFloatButtonDefaultPosition();
        this.bRH.setFloatButtonStyle(this.bRI);
        this.bRH.setVisibility(0);
        return this.bRH;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton ct = ct(context);
        viewGroup.addView(ct);
        return ct;
    }

    private FloatButton ct(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void K(Intent intent) {
        if (intent != null && this.bRH != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.bRH.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton adP() {
        return this.bRH;
    }

    public void a(FloatButton floatButton) {
        this.bRH = floatButton;
    }

    public void ls(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (bRG != null) {
            bRG = null;
        }
    }
}
