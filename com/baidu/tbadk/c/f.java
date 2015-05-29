package com.baidu.tbadk.c;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.l;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable Iu;
    private String[] XP;
    private TextView agG;
    private ImageView amI;
    private TextView amJ;
    private final int amK;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ax() {
        this.currentIndex++;
        if (this.currentIndex >= this.amK) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(o.ds484));
    }

    public f(Context context, int i) {
        super(com.baidu.adp.lib.g.b.hr().inflate(context, r.loading_view_layout, null));
        this.currentIndex = 0;
        this.Iu = new g(this);
        this.amI = (ImageView) this.amG.findViewById(q.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.amI.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.amI.setLayoutParams(marginLayoutParams);
            }
        }
        this.agG = (TextView) this.amG.findViewById(q.loading_anim_ellipsis);
        this.amJ = (TextView) this.amG.findViewById(q.loading_text);
        this.amI.setBackgroundResource(p.loading_animation);
        this.XP = context.getResources().getStringArray(l.loading_anim_text_array);
        this.amK = this.XP.length;
    }

    private void Ay() {
        if (this.amI != null && (this.amI.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.amI.getBackground()).start();
        }
    }

    private void Az() {
        if (this.amI != null && (this.amI.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.amI.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.c.a
    protected void Av() {
        Ay();
        this.agG.setText(this.XP[0]);
        this.agG.postDelayed(this.Iu, 200L);
    }

    @Override // com.baidu.tbadk.c.a
    protected void Aw() {
        Az();
        this.agG.removeCallbacks(this.Iu);
    }

    public void rU() {
        ay.b(this.agG, n.cp_cont_c, 1);
        ay.b(this.amJ, n.cp_cont_c, 1);
        ay.j(this.amG, n.cp_bg_line_d);
        Az();
        ay.i(this.amI, p.loading_animation);
        Ay();
    }
}
