package com.baidu.platform.comapi.bikenavi.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class g extends com.baidu.platform.comapi.walknavi.g.b.b {
    private Activity a;
    private com.baidu.platform.comapi.bikenavi.c.b b;
    private ImageView c;
    private TextView d;
    private View e;

    public g(Context context, com.baidu.platform.comapi.bikenavi.c.b bVar, View view) {
        this.a = (Activity) context;
        this.b = bVar;
        a(view);
    }

    private void a(View view) {
        this.c = (ImageView) view.findViewById(R.raw.lottie_disagree_2);
        this.d = (TextView) view.findViewById(R.raw.lottie_full_screen_refresh);
        this.e = view.findViewById(R.raw.lottie_disagree_1);
        this.e.setVisibility(8);
    }

    public void c() {
        if (this.e.getVisibility() == 8) {
            this.e.setVisibility(0);
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.a, R.anim.abc_fade_in);
            this.e.setAnimation(c);
            c.setAnimationListener(new h(this));
            c.start();
        }
    }

    public void d() {
        if (this.e.getVisibility() == 0) {
            Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.a, R.anim.abc_grow_fade_in_from_bottom);
            c.setAnimationListener(new i(this));
            this.e.startAnimation(c);
        }
    }

    public void a(int i, String str) {
        if (i == R.drawable.abc_btn_radio_material || i == R.drawable.abc_action_bar_item_background_material) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        if (com.baidu.platform.comapi.bikenavi.a.a.a) {
            this.c.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.b().getDrawable(i));
        } else {
            this.c.setImageResource(i);
        }
        this.d.setText(str);
    }
}
