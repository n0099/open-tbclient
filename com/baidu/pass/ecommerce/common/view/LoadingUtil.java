package com.baidu.pass.ecommerce.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class LoadingUtil {
    public static Toast mToast;

    public static void cancel() {
        Toast toast = mToast;
        if (toast != null) {
            toast.cancel();
        }
    }

    public static View createView(Context context, String str) {
        View inflate;
        LayoutInflater from = LayoutInflater.from(context);
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && (confignation.isDarkMode || confignation.isNightMode)) {
            inflate = from.inflate(R.layout.obfuscated_res_0x7f0d055a, (ViewGroup) null);
        } else {
            inflate = from.inflate(R.layout.obfuscated_res_0x7f0d0559, (ViewGroup) null);
        }
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092047)).setText(str);
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
        Toast toast2 = new Toast(context);
        mToast = toast2;
        toast2.setGravity(17, 0, 0);
        mToast.setDuration(1);
        mToast.setView(createView(context, str));
        mToast.show();
    }
}
