package com.baidu.pass.biometrics.base.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.pass.biometrics.base.R;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes6.dex */
public final class PassBioGlobalUtils {
    private PassBioGlobalUtils() {
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
        if (!TextUtils.isEmpty(charSequence) && (inflate = LayoutInflater.from(context).inflate(R.layout.pass_bio_toast_tips, (ViewGroup) null)) != null && (textView = (TextView) inflate.findViewById(R.id.rim_base_toast_message)) != null) {
            textView.setText(charSequence);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.rim_base_toast_icon);
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
}
