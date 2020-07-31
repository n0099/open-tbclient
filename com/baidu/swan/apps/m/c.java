package com.baidu.swan.apps.m;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c {

    /* loaded from: classes7.dex */
    public interface a {
        boolean a(DialogInterface dialogInterface, int i, List<d> list);
    }

    @UiThread
    public static g a(@NonNull Activity activity, @NonNull e eVar, @Nullable String str, @NonNull List<d> list, @NonNull final a aVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        View inflate = View.inflate(activity, a.g.swan_app_subscribe_msg_dialog, null);
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(a.f.swan_app_icon);
        final Resources resources = activity.getResources();
        if (swanAppRoundedImageView != null) {
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, al.a((com.baidu.swan.apps.u.c.b) eVar.arz(), "SwanSubscribeMsgDialog", false)));
            swanAppRoundedImageView.setBorderColor(resources.getColor(a.c.swan_app_auth_icon_border));
        }
        TextView textView = (TextView) inflate.findViewById(a.f.auth_negative_button);
        final TextView textView2 = (TextView) inflate.findViewById(a.f.auth_positive_button);
        ((TextView) inflate.findViewById(a.f.swan_app_name)).setText(eVar.getName());
        ((TextView) inflate.findViewById(a.f.tips)).setText(str);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(a.f.template_title_layout);
        final ArrayList arrayList = new ArrayList(list);
        if (list.size() > 0) {
            for (d dVar : list) {
                linearLayout.addView(a(activity, dVar, arrayList, new View.OnClickListener() { // from class: com.baidu.swan.apps.m.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (arrayList.size() > 0) {
                            textView2.setBackground(resources.getDrawable(a.e.swan_app_auth_positive_bg_selector));
                        } else {
                            textView2.setBackground(resources.getDrawable(a.e.swan_app_auth_pos_button_unable));
                        }
                    }
                }));
            }
        }
        final g abN = new g.a(activity).ff(true).ar(inflate).a(new com.baidu.swan.apps.view.c.a()).gW(a.e.aiapps_action_sheet_bg).fk(false).arb().fg(false).abN();
        final DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.m.c.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.a(dialogInterface, i, arrayList)) {
                    abN.dismiss();
                }
            }
        };
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.m.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.onButtonClick(-1);
                onClickListener.onClick(g.this, -1);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.m.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.onButtonClick(-2);
                onClickListener.onClick(g.this, -2);
            }
        });
        abN.setEnableImmersion(false);
        abN.setOnCancelListener(onCancelListener);
        Window window = abN.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(ai.cC(activity), -2);
            window.setWindowAnimations(a.i.action_sheet_animation);
        }
        return abN;
    }

    private static View a(@NonNull Activity activity, @NonNull final d dVar, final List<d> list, final View.OnClickListener onClickListener) {
        Resources resources = activity.getResources();
        final int dimension = (int) resources.getDimension(a.d.swan_app_template_title_padding);
        final TextView textView = new TextView(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 16, 0, 16);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(com.baidu.swan.support.v4.a.a.getColor(activity, a.c.swan_app_msg_dialog_title));
        textView.setText(dVar.ckU);
        final Drawable drawable = resources.getDrawable(a.e.aiapps_subscribe_msg_unselected);
        final Drawable drawable2 = resources.getDrawable(a.e.aiapps_subscribe_msg_selected);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablePadding(dimension);
        textView.setTextSize(18.0f);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.m.c.5
            boolean selected = true;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.selected = !this.selected;
                textView.setCompoundDrawablesWithIntrinsicBounds(this.selected ? drawable2 : drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setCompoundDrawablePadding(dimension);
                if (this.selected) {
                    list.add(dVar);
                } else {
                    list.remove(dVar);
                }
                onClickListener.onClick(view);
            }
        });
        return textView;
    }
}
