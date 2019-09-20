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
    private static volatile a aTB;
    private FloatButton aTC;
    private JSONObject aTD;
    private String aTE = "";
    private String anb;
    private Activity mActivity;

    public static a MX() {
        if (aTB == null) {
            synchronized (a.class) {
                if (aTB == null) {
                    aTB = new a();
                }
            }
        }
        return aTB;
    }

    private a() {
    }

    public void a(Activity activity, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (DEBUG) {
                Log.i("FloatButtonGuideManager", jSONObject.toString());
            }
            this.mActivity = activity;
            this.aTE = jSONObject.optString("name");
            this.anb = ac.isAppInstalled(activity, this.aTE) ? activity.getString(a.h.swan_app_hover_button_open) : activity.getString(a.h.swan_app_hover_button_download);
            this.aTD = jSONObject.optJSONObject(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
        }
    }

    public FloatButton MY() {
        if (!(this.mActivity instanceof SwanAppActivity)) {
            return null;
        }
        if (this.aTC == null) {
            this.aTC = e(this.mActivity, (ViewGroup) this.mActivity.findViewById(16908290));
        }
        this.aTC.setFloatButtonText(this.anb);
        this.aTC.setFloatButtonDrawable(this.mActivity.getResources().getDrawable(a.e.swan_app_hover_button_shape));
        this.aTC.setFloatButtonDefaultPosition();
        this.aTC.setFloatButtonStyle(this.aTD);
        this.aTC.setVisibility(0);
        return this.aTC;
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
        if (intent != null && this.aTC != null) {
            String dataString = intent.getDataString();
            if (!TextUtils.isEmpty(dataString)) {
                String substring = dataString.substring(8);
                if (!TextUtils.isEmpty(substring) && substring.equals(this.aTE)) {
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                        this.anb = this.mActivity.getResources().getString(a.h.swan_app_hover_button_open);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                        this.anb = this.mActivity.getResources().getString(a.h.swan_app_hover_button_download);
                    }
                    this.aTC.setFloatButtonText(this.anb);
                }
            }
        }
    }

    public FloatButton MZ() {
        return this.aTC;
    }

    public void a(FloatButton floatButton) {
        this.aTC = floatButton;
    }

    public void hh(String str) {
        this.aTE = str;
    }

    public static void release() {
        if (aTB != null) {
            aTB = null;
        }
    }
}
