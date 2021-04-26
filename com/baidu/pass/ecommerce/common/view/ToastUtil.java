package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ecommerce.R;
/* loaded from: classes2.dex */
public class ToastUtil {
    public static final int NONE_IMG = -1;
    public static Toast mToast;

    public static void createToast(Context context) {
        Toast toast = new Toast(context);
        mToast = toast;
        toast.setGravity(17, 0, 0);
        mToast.setDuration(0);
    }

    public static View createView(Context context, int i2, String str) {
        View inflate;
        LayoutInflater from = LayoutInflater.from(context);
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && (confignation.isDarkMode || confignation.isNightMode)) {
            inflate = from.inflate(R.layout.layout_sapi_sdk_common_night_toast, (ViewGroup) null);
        } else {
            inflate = from.inflate(R.layout.layout_sapi_sdk_common_toast, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.sapi_sdk_toast_msg_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.sapi_sdk_toast_msg_tv);
        if (-1 == i2) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(i2);
        }
        textView.setText(str);
        return inflate;
    }

    public static void show(String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation == null) {
            return;
        }
        Toast toast = mToast;
        if (toast != null) {
            toast.cancel();
        }
        Context context = confignation.getContext();
        createToast(context);
        mToast.setView(createView(context, -1, str));
        mToast.show();
    }

    public static void show(int i2, String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation == null) {
            return;
        }
        Toast toast = mToast;
        if (toast != null) {
            toast.cancel();
        }
        Context context = confignation.getContext();
        createToast(context);
        mToast.setView(createView(context, i2, str));
        mToast.show();
    }
}
