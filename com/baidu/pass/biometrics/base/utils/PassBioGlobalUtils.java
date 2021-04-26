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
import com.baidu.pass.biometrics.R;
import com.baidu.sofire.ac.FH;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes2.dex */
public final class PassBioGlobalUtils {
    public static String getZid(Context context, String str, int i2) {
        String gzfi = FH.gzfi(context, str, i2);
        return TextUtils.isEmpty(gzfi) ? "NoZidYet" : gzfi;
    }

    public static void toast(Context context, CharSequence charSequence, int i2, int i3) {
        View inflate;
        TextView textView;
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        if (TextUtils.isEmpty(charSequence) || (inflate = LayoutInflater.from(context).inflate(R.layout.pass_bio_toast_tips, (ViewGroup) null)) == null || (textView = (TextView) inflate.findViewById(R.id.rim_base_toast_message)) == null) {
            return;
        }
        textView.setText(charSequence);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.rim_base_toast_icon);
        if (imageView != null && i2 > 0) {
            imageView.setImageResource(i2);
            imageView.setVisibility(0);
        }
        Toast toast = new Toast(context);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i3);
        toast.setView(inflate);
        toast.show();
    }

    public static void toastWithText(Context context, CharSequence charSequence, int i2) {
        toast(context, charSequence, -1, i2);
    }
}
