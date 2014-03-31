package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public final class b extends com.baidu.adp.a.f {
    private final Activity a;
    private final View c;
    private final LinearLayout d;
    private final TextView e;
    private final ImageView f;
    private final Button g;
    private final Button h;
    private int i;

    public b(Activity activity, String str, String str2, int i) {
        super(activity);
        this.i = -1;
        this.a = activity;
        this.c = LayoutInflater.from(activity).inflate(com.baidu.tbadk.k.enter_forum_login, (ViewGroup) null);
        this.d = (LinearLayout) this.c;
        this.e = (TextView) this.c.findViewById(com.baidu.tbadk.j.tip);
        this.f = (ImageView) this.c.findViewById(com.baidu.tbadk.j.img_bg);
        this.g = (Button) this.c.findViewById(com.baidu.tbadk.j.login_btn);
        if (str != null) {
            this.e.setText(str);
        }
        this.g.setOnClickListener(new c(this, activity, i, str2));
        this.h = (Button) this.c.findViewById(com.baidu.tbadk.j.reg_btn);
        this.h.setOnClickListener(new d(this, activity));
        int a = com.baidu.adp.lib.util.i.a((Context) activity, 7.0f);
        int a2 = com.baidu.adp.lib.util.i.a((Context) activity, 5.0f);
        this.d.setPadding(a, a2, a, a2);
    }

    public final View a() {
        TiebaStatic.a(this.a, "home_login_show", "loginshow", 1, new Object[0]);
        return this.c;
    }

    public final void a(int i) {
        boolean z;
        if (i == this.i) {
            z = false;
        } else {
            this.i = i;
            z = true;
        }
        if (z) {
            if (i == 1) {
                this.e.setTextColor(-11444363);
                this.f.setBackgroundResource(com.baidu.tbadk.i.pic_inset_login_1);
                this.g.setBackgroundResource(com.baidu.tbadk.i.btn_blue_square_1);
                this.h.setBackgroundResource(com.baidu.tbadk.i.btn_w_square_1);
                this.g.setTextColor(-5454368);
                this.h.setTextColor(-9207399);
                return;
            }
            this.e.setTextColor(-5065030);
            this.f.setBackgroundResource(com.baidu.tbadk.i.pic_inset_login);
            this.g.setBackgroundResource(com.baidu.tbadk.i.btn_blue_square);
            this.h.setBackgroundResource(com.baidu.tbadk.i.btn_w_square);
            this.g.setTextColor(-1);
            this.h.setTextColor(-14277082);
        }
    }
}
