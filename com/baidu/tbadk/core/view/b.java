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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f {
    private final Activity a;
    private final View b;
    private final LinearLayout c;
    private final TextView d;
    private final ImageView e;
    private final Button f;
    private final Button g;
    private int h;

    public void a(int i) {
        this.h = i;
    }

    public int a() {
        return this.h;
    }

    public b(Activity activity, String str, String str2, int i) {
        super(activity);
        this.h = -1;
        this.a = activity;
        this.b = LayoutInflater.from(activity).inflate(com.baidu.tieba.w.enter_forum_login, (ViewGroup) null);
        this.c = (LinearLayout) this.b;
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.v.tip);
        this.e = (ImageView) this.b.findViewById(com.baidu.tieba.v.img_bg);
        this.f = (Button) this.b.findViewById(com.baidu.tieba.v.login_btn);
        if (str != null) {
            this.d.setText(str);
        }
        this.f.setOnClickListener(new c(this, activity, i, str2));
        this.g = (Button) this.b.findViewById(com.baidu.tieba.v.reg_btn);
        this.g.setOnClickListener(new d(this, activity));
        int a = com.baidu.adp.lib.util.j.a((Context) activity, 7.0f);
        int a2 = com.baidu.adp.lib.util.j.a((Context) activity, 5.0f);
        this.c.setPadding(a, a2, a, a2);
    }

    public View b() {
        TiebaStatic.eventStat(this.a, "home_login_show", "loginshow", 1, new Object[0]);
        return this.b;
    }

    private boolean c(int i) {
        if (i == a()) {
            return false;
        }
        a(i);
        return true;
    }

    public void c() {
        b(TbadkApplication.m252getInst().getSkinType());
    }

    public void d() {
        this.h = -1;
        this.e.setBackgroundDrawable(null);
        this.f.setBackgroundDrawable(null);
        this.g.setBackgroundDrawable(null);
    }

    public void b(int i) {
        if (c(i)) {
            if (i == 1) {
                this.d.setTextColor(-11444363);
                this.e.setBackgroundResource(com.baidu.tieba.u.pic_inset_login_1);
                this.f.setBackgroundResource(com.baidu.tieba.u.btn_blue_square_1);
                this.g.setBackgroundResource(com.baidu.tieba.u.btn_w_square_1);
                this.f.setTextColor(-5454368);
                this.g.setTextColor(-9207399);
                return;
            }
            this.d.setTextColor(-5065030);
            this.e.setBackgroundResource(com.baidu.tieba.u.pic_inset_login);
            this.f.setBackgroundResource(com.baidu.tieba.u.btn_blue_square);
            this.g.setBackgroundResource(com.baidu.tieba.u.btn_w_square);
            this.f.setTextColor(-1);
            this.g.setTextColor(-14277082);
        }
    }
}
