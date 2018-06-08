package com.baidu.ar.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.baidu.ar.ui.a.a;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.SystemInfoUtil;
/* loaded from: classes3.dex */
public class g {
    public static com.baidu.ar.ui.a.a a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        try {
            a.C0048a c0048a = new a.C0048a(context);
            c0048a.a((CharSequence) Res.getString("bdar_dialog_network_prompt_title"));
            c0048a.a(Res.getString("bdar_error_network_tips"));
            c0048a.a(Res.getString("bdar_error_network_wait"), onClickListener);
            c0048a.b(Res.getString("bdar_cancel"), onClickListener2);
            com.baidu.ar.ui.a.a a = c0048a.a();
            a(a, onClickListener2);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(Dialog dialog, final DialogInterface.OnClickListener onClickListener) {
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.ar.ui.g.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (onClickListener != null) {
                        onClickListener.onClick(dialogInterface, -2);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public static com.baidu.ar.ui.a.a b(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        try {
            a.C0048a c0048a = new a.C0048a(context);
            c0048a.a((CharSequence) Res.getString("bdar_dialog_prompt_title"));
            c0048a.a(Res.getString("bdar_download_timeout_error"));
            c0048a.a(Res.getString("bdar_ok"), onClickListener);
            c0048a.b(Res.getString("bdar_cancel"), onClickListener2);
            com.baidu.ar.ui.a.a a = c0048a.a();
            a(a, onClickListener2);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.baidu.ar.ui.a.a c(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        try {
            a.C0048a c0048a = new a.C0048a(context);
            c0048a.a((CharSequence) Res.getString("bdar_sdk_version_low_title_for_box"));
            c0048a.a(String.format(Res.getString("bdar_sdk_version_low_for_box"), SystemInfoUtil.getAppName(context)));
            c0048a.a(Res.getString("bdar_sdk_version_update_btn"), onClickListener);
            c0048a.b(Res.getString("bdar_cancel"), onClickListener2);
            com.baidu.ar.ui.a.a a = c0048a.a();
            a(a, onClickListener2);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.baidu.ar.ui.a.a d(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        try {
            a.C0048a c0048a = new a.C0048a(context);
            c0048a.a((CharSequence) Res.getString("bdar_dialog_network_prompt_title"));
            c0048a.a(Res.getString("bdar_error_network_retry_tips"));
            c0048a.a(Res.getString("bdar_error_network_retry"), onClickListener);
            c0048a.b(Res.getString("bdar_cancel"), onClickListener2);
            com.baidu.ar.ui.a.a a = c0048a.a();
            a(a, onClickListener2);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.baidu.ar.ui.a.a e(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        try {
            a.C0048a c0048a = new a.C0048a(context);
            c0048a.a((CharSequence) Res.getString("bdar_marketing_error_dialog_title"));
            c0048a.a(Res.getString("bdar_marketing_error_dialog_context"));
            c0048a.a(Res.getString("bdar_marketing_error_dialog_again"), onClickListener);
            c0048a.b(Res.getString("bdar_marketing_error_dialog_cancel"), onClickListener2);
            com.baidu.ar.ui.a.a a = c0048a.a();
            a(a, onClickListener2);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
