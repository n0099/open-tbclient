package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f {
    private final Activity a;
    private final View b;
    private final LinearLayout c;
    private final TextView d;
    private final ImageView e;
    private Bitmap f;
    private final Button g;
    private final Button h;
    private int i;

    public void a(int i) {
        this.i = i;
    }

    public int a() {
        return this.i;
    }

    public d(Activity activity, String str, String str2, int i) {
        super(activity);
        this.f = null;
        this.i = -1;
        this.a = activity;
        this.b = com.baidu.adp.lib.e.b.a().a(activity, com.baidu.tieba.v.enter_forum_login, null);
        this.c = (LinearLayout) this.b;
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.u.tip);
        this.e = (ImageView) this.b.findViewById(com.baidu.tieba.u.img_bg);
        this.g = (Button) this.b.findViewById(com.baidu.tieba.u.login_btn);
        if (str != null) {
            this.d.setText(str);
        }
        this.g.setOnClickListener(new e(this, activity, i, str2));
        this.h = (Button) this.b.findViewById(com.baidu.tieba.u.reg_btn);
        this.h.setOnClickListener(new f(this, activity));
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
        this.i = -1;
        this.e.setBackgroundDrawable(null);
        this.g.setBackgroundDrawable(null);
        this.h.setBackgroundDrawable(null);
        if (this.f != null) {
            if (!this.f.isRecycled()) {
                this.f.recycle();
            }
            this.f = null;
        }
    }

    public void b(int i) {
        if (c(i)) {
            if (i == 1) {
                this.d.setTextColor(-11444363);
                this.f = com.baidu.tbadk.core.util.d.b(this.mContext, com.baidu.tieba.t.pic_emotion01_1);
                this.g.setBackgroundResource(com.baidu.tieba.t.btn_blue_square_1);
                this.h.setBackgroundResource(com.baidu.tieba.t.btn_w_square_1);
                this.g.setTextColor(-5454368);
                this.h.setTextColor(-9207399);
            } else {
                this.d.setTextColor(-5065030);
                this.f = com.baidu.tbadk.core.util.d.b(this.mContext, com.baidu.tieba.t.pic_emotion01);
                this.g.setBackgroundResource(com.baidu.tieba.t.btn_blue_square);
                this.h.setBackgroundResource(com.baidu.tieba.t.btn_w_square);
                this.g.setTextColor(-1);
                this.h.setTextColor(-14277082);
            }
            if (this.f != null) {
                this.e.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), this.f));
            }
        }
    }
}
