package com.baidu.sapi2.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ToastUtil implements NoProguard {
    public static final int a = -1;
    public static Toast b;

    public static View a(Context context, int i, String str) {
        View inflate;
        LayoutInflater from = LayoutInflater.from(context);
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && (confignation.isDarkMode || confignation.isNightMode)) {
            inflate = from.inflate(R.layout.layout_sapi_sdk_common_night_toast, (ViewGroup) null);
        } else {
            inflate = from.inflate(R.layout.layout_sapi_sdk_common_toast, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0920c4);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0920c5);
        if (-1 == i) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(i);
        }
        textView.setText(str);
        return inflate;
    }

    public static void a(Context context) {
        Toast toast = new Toast(context.getApplicationContext());
        b = toast;
        toast.setGravity(80, 0, ViewUtils.dp2px(context, 100.0f));
        b.setDuration(0);
    }

    public static void show(String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation == null) {
            return;
        }
        Toast toast = b;
        if (toast != null) {
            toast.cancel();
        }
        Context context = confignation.getContext();
        a(context);
        b.setView(a(context, -1, str));
        b.show();
    }

    public static void show(int i, String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation == null) {
            return;
        }
        Toast toast = b;
        if (toast != null) {
            toast.cancel();
        }
        Context context = confignation.getContext();
        a(context);
        b.setView(a(context, i, str));
        b.show();
    }
}
