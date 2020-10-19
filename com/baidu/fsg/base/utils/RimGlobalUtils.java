package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.fsg.base.activity.BaseActivity;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes16.dex */
public final class RimGlobalUtils {

    /* renamed from: a  reason: collision with root package name */
    private static String f1525a;

    private RimGlobalUtils() {
    }

    public static String getMsg() {
        return f1525a;
    }

    public static void setMsg(String str) {
        f1525a = str;
    }

    public static void hideKeyboard(Activity activity) {
        View currentFocus;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null && (currentFocus = activity.getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public static boolean showInputMethod(final Context context, final View view) {
        if (context == null || view == null) {
            return false;
        }
        view.requestFocusFromTouch();
        view.postDelayed(new Runnable() { // from class: com.baidu.fsg.base.utils.RimGlobalUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
            }
        }, 100L);
        return true;
    }

    public static boolean hideInputMethod(Context context, View view) {
        if (context == null || view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            return inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return false;
    }

    public static void safeShowDialog(BaseActivity baseActivity, int i) {
        try {
            baseActivity.getActivity().showDialog(i);
        } catch (Exception e) {
            if (LogUtil.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void safeShowDialog(BaseActivity baseActivity, int i, String str) {
        f1525a = str;
        try {
            baseActivity.getActivity().showDialog(i);
        } catch (Exception e) {
            if (LogUtil.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void safeDismissDialog(BaseActivity baseActivity, int i) {
        try {
            Activity activity = baseActivity.getActivity();
            if (activity != null && !activity.isFinishing()) {
                baseActivity.getActivity().removeDialog(i);
            }
        } catch (Throwable th) {
            LogUtil.e("globalUtils", "dialog Exception", th);
        }
    }

    public static void toastWithTextId(Context context, int i) {
        toastWithTextId(context, i, 0);
    }

    public static void toastWithTextId(Context context, int i, int i2) {
        try {
            toastWithText(context, context.getResources().getString(i), i2);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void toastWithText(Context context, CharSequence charSequence) {
        toast(context, charSequence, -1, 0);
    }

    public static void toastWithText(Context context, CharSequence charSequence, int i) {
        toast(context, charSequence, -1, i);
    }

    public static void toast(Context context, CharSequence charSequence, int i, int i2) {
        View inflate;
        TextView textView;
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        if (!TextUtils.isEmpty(charSequence) && (inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "rim_base_toast_tips"), (ViewGroup) null)) != null && (textView = (TextView) inflate.findViewById(ResUtils.id(context, "rim_base_toast_message"))) != null) {
            textView.setText(charSequence);
            ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(context, "rim_base_toast_icon"));
            if (imageView != null && i > 0) {
                imageView.setImageResource(i);
                imageView.setVisibility(0);
            }
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(i2);
            toast.setView(inflate);
            toast.show();
        }
    }

    public static String getZid(Context context) {
        try {
            Object invoke = Class.forName("com.baidu.sofire.ac.FH").getDeclaredMethod("gz", Context.class).invoke(null, context);
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getZid2() {
        try {
            Class<?> cls = Class.forName("com.fsg.soter.Soter");
            Object invoke = cls.getDeclaredMethod("getLid", new Class[0]).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
