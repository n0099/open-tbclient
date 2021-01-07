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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a dJU;
    private FloatButton dJV;
    private JSONObject dJW;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a aNA() {
        if (dJU == null) {
            synchronized (a.class) {
                if (dJU == null) {
                    dJU = new a();
                }
            }
        }
        return dJU;
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
            this.dJW = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton aNB() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.dJV == null) {
            this.dJV = g(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.dJV.setFloatButtonText(this.mText);
        this.dJV.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.dJV.setFloatButtonDefaultPosition();
        this.dJV.setFloatButtonStyle(this.dJW);
        this.dJV.setVisibility(0);
        return this.dJV;
    }

    private FloatButton g(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton dq = dq(context);
        viewGroup.addView(dq);
        return dq;
    }

    private FloatButton dq(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void x(Intent intent) {
        if (intent != null && this.dJV != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.dJV.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton aNC() {
        return this.dJV;
    }

    public void a(FloatButton floatButton) {
        this.dJV = floatButton;
    }

    public void te(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (dJU != null) {
            dJU = null;
        }
    }
}
