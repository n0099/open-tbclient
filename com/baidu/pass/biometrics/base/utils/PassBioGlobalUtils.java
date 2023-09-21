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
import com.baidu.sofire.ac.FH;
import com.baidu.tieba.R;
@SuppressLint({"InlinedApi", "NewApi"})
/* loaded from: classes3.dex */
public final class PassBioGlobalUtils {
    public static String getZid(Context context, String str, int i) {
        String gzfi = FH.gzfi(context, str, i);
        if (TextUtils.isEmpty(gzfi)) {
            return "NoZidYet";
        }
        return gzfi;
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
        if (TextUtils.isEmpty(charSequence) || (inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d077b, (ViewGroup) null)) == null || (textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f4a)) == null) {
            return;
        }
        textView.setText(charSequence);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091f49);
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
