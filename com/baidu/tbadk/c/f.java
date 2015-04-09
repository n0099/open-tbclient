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
    private Runnable IF;
    private String[] Xe;
    private TextView afF;
    private ImageView alH;
    private TextView alI;
    private final int alJ;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int zL() {
        this.currentIndex++;
        if (this.currentIndex >= this.alJ) {
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
        this.IF = new g(this);
        this.alH = (ImageView) this.alF.findViewById(v.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.alH.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.alH.setLayoutParams(marginLayoutParams);
            }
        }
        this.afF = (TextView) this.alF.findViewById(v.loading_anim_ellipsis);
        this.alI = (TextView) this.alF.findViewById(v.loading_text);
        this.alH.setBackgroundResource(u.loading_animation);
        this.Xe = context.getResources().getStringArray(q.loading_anim_text_array);
        this.alJ = this.Xe.length;
    }

    private void zM() {
        if (this.alH != null && (this.alH.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.alH.getBackground()).start();
        }
    }

    private void zN() {
        if (this.alH != null && (this.alH.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.alH.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.c.a
    protected void zJ() {
        zM();
        this.afF.setText(this.Xe[0]);
        this.afF.postDelayed(this.IF, 200L);
    }

    @Override // com.baidu.tbadk.c.a
    protected void zK() {
        zN();
        this.afF.removeCallbacks(this.IF);
    }

    public void rk() {
        ba.b(this.afF, s.cp_cont_c, 1);
        ba.b(this.alI, s.cp_cont_c, 1);
        ba.j(this.alF, s.cp_bg_line_d);
        zN();
        ba.i(this.alH, u.loading_animation);
        zM();
    }
}
