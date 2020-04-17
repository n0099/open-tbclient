package com.baidu.swan.apps.o;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
/* loaded from: classes11.dex */
public final class c {
    @UiThread
    public static g a(@NonNull Activity activity, @NonNull e eVar, @Nullable String str, @Nullable String str2, @NonNull a aVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        View inflate = View.inflate(activity, a.g.swan_app_subscribe_msg_dialog, null);
        g.a ez = new g.a(activity).ey(true).ao(inflate).a(new com.baidu.swan.apps.view.c.a()).gi(a.e.aiapps_action_sheet_bg).eD(false).akv().ez(false);
        TextView textView = (TextView) inflate.findViewById(a.f.auth_negative_button);
        TextView textView2 = (TextView) inflate.findViewById(a.f.auth_positive_button);
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(a.f.swan_app_icon);
        Resources resources = activity.getResources();
        if (swanAppRoundedImageView != null) {
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, ai.a((com.baidu.swan.apps.x.b.b) eVar.akQ(), "SwanSubscribeMsgDialog", false)));
            swanAppRoundedImageView.setBorderColor(resources.getColor(a.c.swan_app_auth_icon_border));
        }
        ((TextView) inflate.findViewById(a.f.swan_app_name)).setText(eVar.getName());
        ((TextView) inflate.findViewById(a.f.template_title)).setText(str);
        ((TextView) inflate.findViewById(a.f.template_content)).setText(str2);
        aVar.a((CheckBox) inflate.findViewById(a.f.remember_checkbox));
        ez.a(textView, -2, aVar);
        ez.a(textView2, -1, aVar);
        g WU = ez.WU();
        WU.setEnableImmersion(false);
        WU.setOnCancelListener(onCancelListener);
        Window window = WU.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(af.cx(activity), -2);
            window.setWindowAnimations(a.i.action_sheet_animation);
        }
        return WU;
    }

    /* loaded from: classes11.dex */
    public static abstract class a implements DialogInterface.OnClickListener {
        @Nullable
        private CheckBox bTP;

        public abstract void a(DialogInterface dialogInterface, int i, boolean z);

        void a(@Nullable CheckBox checkBox) {
            this.bTP = checkBox;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            a(dialogInterface, i, this.bTP != null && this.bTP.isChecked());
        }
    }
}
