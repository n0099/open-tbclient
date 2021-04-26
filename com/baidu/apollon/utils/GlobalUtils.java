package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes.dex */
public final class GlobalUtils {

    /* renamed from: a  reason: collision with root package name */
    public static LayoutInflater f4039a = null;

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<Toast> f4040b = null;
    public static String showStr = "";

    public static String getProperties(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e2) {
            Log.e("getProperties", "Exception while getting system property: ", e2);
            return str2;
        }
    }

    public static boolean hideInputMethod(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return false;
        }
        return inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideKeyboard(Activity activity) {
        View currentFocus;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager == null || (currentFocus = activity.getCurrentFocus()) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
    }

    public static boolean showInputMethod(final Context context, final View view) {
        if (context == null || view == null) {
            return false;
        }
        view.requestFocusFromTouch();
        view.postDelayed(new Runnable() { // from class: com.baidu.apollon.utils.GlobalUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
            }
        }, 100L);
        return true;
    }

    public static void toast(Context context, CharSequence charSequence) {
        toast(context, charSequence, 0);
    }

    public static void toast(Context context, CharSequence charSequence, int i2) {
        try {
            toast(context, charSequence, -1, i2);
        } catch (Exception unused) {
            LogUtil.errord("Exception in Toast!");
        }
    }

    public static void toast(Context context, CharSequence charSequence, int i2, int i3) {
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        WeakReference<Toast> weakReference = f4040b;
        if (weakReference != null && weakReference.get() != null) {
            f4040b.get().cancel();
        }
        if (f4039a == null) {
            f4039a = LayoutInflater.from(applicationContext);
        }
        View inflate = f4039a.inflate(ResUtils.layout(applicationContext, "wallet_base_toast"), (ViewGroup) null);
        if (inflate == null || (textView = (TextView) inflate.findViewById(ResUtils.id(applicationContext, "wallet_base_toast_message"))) == null) {
            return;
        }
        textView.setText(charSequence);
        ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(applicationContext, "wallet_base_toast_icon"));
        if (imageView != null && i2 > 0) {
            imageView.setImageResource(i2);
            imageView.setVisibility(0);
        }
        Toast toast = new Toast(applicationContext);
        toast.setDuration(i3);
        toast.setGravity(17, 0, 0);
        toast.setView(inflate);
        f4040b = new WeakReference<>(toast);
        toast.show();
    }
}
