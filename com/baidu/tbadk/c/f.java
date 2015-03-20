package com.baidu.tbadk.c;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.q;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable IC;
    private String[] Xc;
    private TextView afx;
    private TextView alA;
    private final int alB;
    private ImageView alz;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int zF() {
        this.currentIndex++;
        if (this.currentIndex >= this.alB) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(t.ds484));
    }

    public f(Context context, int i) {
        super(com.baidu.adp.lib.g.b.hH().inflate(context, w.loading_view_layout, null));
        this.currentIndex = 0;
        this.IC = new g(this);
        this.alz = (ImageView) this.alx.findViewById(v.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.alz.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.alz.setLayoutParams(marginLayoutParams);
            }
        }
        this.afx = (TextView) this.alx.findViewById(v.loading_anim_ellipsis);
        this.alA = (TextView) this.alx.findViewById(v.loading_text);
        this.alz.setBackgroundResource(u.loading_animation);
        this.Xc = context.getResources().getStringArray(q.loading_anim_text_array);
        this.alB = this.Xc.length;
    }

    private void zG() {
        if (this.alz != null && (this.alz.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.alz.getBackground()).start();
        }
    }

    private void zH() {
        if (this.alz != null && (this.alz.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.alz.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.c.a
    protected void zD() {
        zG();
        this.afx.setText(this.Xc[0]);
        this.afx.postDelayed(this.IC, 200L);
    }

    @Override // com.baidu.tbadk.c.a
    protected void zE() {
        zH();
        this.afx.removeCallbacks(this.IC);
    }

    public void rk() {
        ba.b(this.afx, s.cp_cont_c, 1);
        ba.b(this.alA, s.cp_cont_c, 1);
        ba.j(this.alx, s.cp_bg_line_d);
        zH();
        ba.i(this.alz, u.loading_animation);
        zG();
    }
}
