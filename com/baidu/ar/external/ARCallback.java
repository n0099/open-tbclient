package com.baidu.ar.external;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.Fragment;
import com.baidu.ar.ARFragment;
import com.baidu.ar.util.IoUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class ARCallback {
    public static final String AR_APP_NAME = "AR";
    private ARCallbackClient a;
    private a b;

    /* loaded from: classes3.dex */
    public enum ARAction {
        BACK,
        SWITCHTOBARCODE
    }

    private void a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeCommand(Context context, String str) {
        if (this.b != null) {
            this.b.a(context, str);
        } else {
            a(context, str);
        }
    }

    public void executeCommandWithO2O(Context context, String str) {
        try {
            String encode = URLEncoder.encode(str, IoUtils.UTF_8);
            StringBuilder sb = new StringBuilder("{\"mode\":\"0\",\"intent\":\"intent:#Intent;component=com.baidu.searchbox/.lightbrowser.LightBrowserActivity;S.bdsb_light_start_url=;B.bdsb_append_param=true;S.showtitlebar=0;S.showtoolbar=1;S.toolbaricons=%7b%22toolids%22%3a%5b%222%22%2c%223%22%5d%7d;S.extra_actionbar_color_str=%23f23d56;B.create_menu_key=0;end\",\"min_v\":\"16789248\"}");
            sb.insert("S.bdsb_light_start_url=".length() + "{\"mode\":\"0\",\"intent\":\"intent:#Intent;component=com.baidu.searchbox/.lightbrowser.LightBrowserActivity;S.bdsb_light_start_url=;B.bdsb_append_param=true;S.showtitlebar=0;S.showtoolbar=1;S.toolbaricons=%7b%22toolids%22%3a%5b%222%22%2c%223%22%5d%7d;S.extra_actionbar_color_str=%23f23d56;B.create_menu_key=0;end\",\"min_v\":\"16789248\"}".indexOf("S.bdsb_light_start_url="), encode);
            if (this.b != null) {
                this.b.a(context, str, sb);
                return;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        a(context, str);
    }

    public Bitmap getPreviewBitmap() {
        if (this.b != null) {
            return this.b.b();
        }
        return null;
    }

    public Boolean isNightMode() {
        if (this.b != null) {
            return Boolean.valueOf(this.b.a());
        }
        return false;
    }

    public void nonsupport(String str) {
        if (this.a != null) {
            this.a.nonsupport(str);
        }
    }

    public void openUrl(String str) {
        if (this.a != null) {
            this.a.openUrl(str);
        }
    }

    public void quitAR(Fragment fragment) {
        quitAR(fragment, null);
    }

    public void quitAR(Fragment fragment, ARAction aRAction) {
        if (fragment != null && (fragment instanceof ARFragment)) {
            ((ARFragment) fragment).setWillQuitAR();
        }
        if (this.b != null) {
            this.b.a(fragment, aRAction);
        }
        if (fragment != null) {
            fragment.getActivity().finish();
        }
    }

    public void release() {
        this.b = null;
    }

    public void rescan(Fragment fragment) {
        if (fragment != null && (fragment instanceof ARFragment)) {
            ((ARFragment) fragment).setWillQuitAR();
        }
        if (this.b != null) {
            this.b.a(fragment);
        } else if (fragment != null) {
            fragment.getActivity().finish();
        }
    }

    public void setARCallbackClient(ARCallbackClient aRCallbackClient) {
        this.a = aRCallbackClient;
    }

    public void setARPluginCallback(a aVar) {
        this.b = aVar;
    }

    public void setPreviewBitmap(Bitmap bitmap) {
        if (this.b != null) {
            this.b.a(bitmap);
        }
    }

    public void share(String str, String str2, String str3, String str4, int i) {
        if (this.a != null) {
            this.a.share(str, str2, str3, str4, i);
        }
    }

    public void shareSyncForPlugin(Context context, String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z, boolean z2, ShareResultListener shareResultListener) {
        if (this.b != null) {
            this.b.a(context, str, str2, str3, bitmap, str4, str5, z, z2, shareResultListener);
        }
    }
}
