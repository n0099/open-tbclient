package com.baidu.swan.apps.scheme.actions.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.ui.FloatButton;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a aTd;
    private FloatButton aTe;
    private JSONObject aTf;
    private String aTg = "";
    private String amD;
    private Activity mActivity;

    public static a MT() {
        if (aTd == null) {
            synchronized (a.class) {
                if (aTd == null) {
                    aTd = new a();
                }
            }
        }
        return aTd;
    }

    private a() {
    }

    public void a(Activity activity, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (DEBUG) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.mActivity = activity;
            this.aTg = jSONObject.optString("name");
            this.amD = ac.isAppInstalled(activity, this.aTg) ? activity.getString(a.h.swan_app_hover_button_open) : activity.getString(a.h.swan_app_hover_button_download);
            this.aTf = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        }
    }

    public FloatButton MU() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.aTe == null) {
            this.aTe = e(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.aTe.setFloatButtonText(this.amD);
        this.aTe.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.aTe.setFloatButtonDefaultPosition();
        this.aTe.setFloatButtonStyle(this.aTf);
        this.aTe.setVisibility(0);
        return this.aTe;
    }

    private FloatButton e(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return null;
        }
        FloatButton bA = bA(context);
        viewGroup.addView(bA);
        return bA;
    }

    private FloatButton bA(Context context) {
        if (context == null) {
            return null;
        }
        return (FloatButton) LayoutInflater.from(context.getApplicationContext()).inflate(a.g.swan_app_float_button, (ViewGroup) null);
    }

    public void L(Intent intent) {
        if (intent != null && this.aTe != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.aTg)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.amD = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.amD = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.aTe.setFloatButtonText(this.amD);
                }
            }
        }
    }

    public FloatButton MV() {
        return this.aTe;
    }

    public void a(FloatButton floatButton) {
        this.aTe = floatButton;
    }

    public void hf(String str) {
        this.aTg = str;
    }

    public static void release() {
        if (aTd != null) {
            aTd = null;
        }
    }
}
