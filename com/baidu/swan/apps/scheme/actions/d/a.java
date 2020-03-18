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
    private static volatile a bRS;
    private FloatButton bRT;
    private JSONObject bRU;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a adQ() {
        if (bRS == null) {
            synchronized (a.class) {
                if (bRS == null) {
                    bRS = new a();
                }
            }
        }
        return bRS;
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
            this.bRU = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton adR() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.bRT == null) {
            this.bRT = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.bRT.setFloatButtonText(this.mText);
        this.bRT.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.bRT.setFloatButtonDefaultPosition();
        this.bRT.setFloatButtonStyle(this.bRU);
        this.bRT.setVisibility(0);
        return this.bRT;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton cs = cs(context);
        viewGroup.addView(cs);
        return cs;
    }

    private FloatButton cs(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void K(Intent intent) {
        if (intent != null && this.bRT != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.bRT.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton adS() {
        return this.bRT;
    }

    public void a(FloatButton floatButton) {
        this.bRT = floatButton;
    }

    public void lr(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (bRS != null) {
            bRS = null;
        }
    }
}
