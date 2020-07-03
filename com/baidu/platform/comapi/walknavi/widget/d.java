package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends com.baidu.platform.comapi.walknavi.g.b.b {
    private Activity a;
    private com.baidu.platform.comapi.walknavi.g.a b;
    private ImageView c;
    private TextView d;
    private View e;
    private View f;

    public d(Context context, com.baidu.platform.comapi.walknavi.g.a aVar, View view) {
        this.a = (Activity) context;
        this.b = aVar;
        a(view);
    }

    private void a(View view) {
        this.f = view.findViewById(R.raw.lottie_use_refresh_n_2);
        this.c = (ImageView) view.findViewById(R.raw.lottie_full_screen_refresh_1);
        this.d = (TextView) view.findViewById(R.raw.lottie_full_screen_refresh_2);
        this.e = view.findViewById(R.raw.lottie_full_screen_refresh);
        this.e.setVisibility(8);
    }

    public void c() {
        if (this.e.getVisibility() == 8) {
            this.e.setVisibility(0);
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.a, R.anim.abc_fade_in);
            this.e.setAnimation(c);
            c.setAnimationListener(new e(this));
            c.start();
        }
    }

    public void d() {
        if (this.e.getVisibility() == 0) {
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.a, R.anim.abc_grow_fade_in_from_bottom);
            c.setAnimationListener(new f(this));
            this.e.startAnimation(c);
        }
    }

    public void a(int i, String str) {
        if (i == R.drawable.abc_text_select_handle_left_mtrl_dark) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.a) {
            this.c.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.a, i));
        } else {
            this.c.setImageResource(i);
        }
        if (i == R.drawable.action_bar_editor_pressed || i == R.drawable.action_bar_eidtor_background) {
            this.d.setText("步行导航开始");
        } else {
            this.d.setText(str);
        }
    }

    public void a(int i) {
        this.f.setBackgroundColor(i);
    }

    public void b(int i) {
        this.d.setTextColor(i);
    }
}
