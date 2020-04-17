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
    private static volatile a cqF;
    private FloatButton cqG;
    private JSONObject cqH;
    private Activity mActivity;
    private String mApkName = "";
    private String mText;

    public static a alV() {
        if (cqF == null) {
            synchronized (a.class) {
                if (cqF == null) {
                    cqF = new a();
                }
            }
        }
        return cqF;
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
            this.cqH = jSONObject.optJSONObject("style");
        }
    }

    public FloatButton alW() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.cqG == null) {
            this.cqG = d(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.cqG.setFloatButtonText(this.mText);
        this.cqG.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.cqG.setFloatButtonDefaultPosition();
        this.cqG.setFloatButtonStyle(this.cqH);
        this.cqG.setVisibility(0);
        return this.cqG;
    }

    private FloatButton d(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton cg = cg(context);
        viewGroup.addView(cg);
        return cg;
    }

    private FloatButton cg(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void J(Intent intent) {
        if (intent != null && this.cqG != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.mApkName)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.mText = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.cqG.setFloatButtonText(this.mText);
                }
            }
        }
    }

    public FloatButton alX() {
        return this.cqG;
    }

    public void a(FloatButton floatButton) {
        this.cqG = floatButton;
    }

    public void mE(String str) {
        this.mApkName = str;
    }

    public static void release() {
        if (cqF != null) {
            cqF = null;
        }
    }
}
