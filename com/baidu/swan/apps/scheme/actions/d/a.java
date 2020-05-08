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
    private static volatile a cqL;
    private FloatButton cqM;
    private JSONObject cqN;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a alU() {
        if (cqL == null) {
            synchronized (a.class) {
                if (cqL == null) {
                    cqL = new a();
                }
            }
        }
        return cqL;
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
            this.cqN = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton alV() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.cqM == null) {
            this.cqM = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.cqM.setFloatButtonText(this.mText);
        this.cqM.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.cqM.setFloatButtonDefaultPosition();
        this.cqM.setFloatButtonStyle(this.cqN);
        this.cqM.setVisibility(0);
        return this.cqM;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton bU = bU(context);
        viewGroup.addView(bU);
        return bU;
    }

    private FloatButton bU(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void w(Intent intent) {
        if (intent != null && this.cqM != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.cqM.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton alW() {
        return this.cqM;
    }

    public void a(FloatButton floatButton) {
        this.cqM = floatButton;
    }

    public void mE(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (cqL != null) {
            cqL = null;
        }
    }
}
