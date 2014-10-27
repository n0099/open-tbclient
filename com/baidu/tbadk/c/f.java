package com.baidu.tbadk.c;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.q;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends a {
    private TextView Pd;
    private ImageView VB;
    private String[] VC;
    private TextView VD;
    private final int VE;
    private int currentIndex;
    private Runnable wb;

    /* JADX INFO: Access modifiers changed from: private */
    public int sy() {
        this.currentIndex++;
        if (this.currentIndex >= this.VE) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        super(com.baidu.adp.lib.g.b.ek().inflate(context, w.loading_view_layout, null));
        this.currentIndex = 0;
        this.wb = new g(this);
        this.VB = (ImageView) this.Vz.findViewById(v.loading_animate_view);
        this.Pd = (TextView) this.Vz.findViewById(v.loading_anim_ellipsis);
        this.VD = (TextView) this.Vz.findViewById(v.loading_text);
        this.VB.setBackgroundResource(u.loading_animation);
        this.VC = context.getResources().getStringArray(q.loading_anim_text_array);
        this.VE = this.VC.length;
    }

    private void sz() {
        if (this.VB != null && (this.VB.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.VB.getBackground()).start();
        }
    }

    private void sA() {
        if (this.VB != null && (this.VB.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.VB.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.c.a
    protected void sw() {
        sz();
        this.Pd.setText(this.VC[0]);
        this.Pd.postDelayed(this.wb, 200L);
    }

    @Override // com.baidu.tbadk.c.a
    protected void sx() {
        sA();
        this.Pd.removeCallbacks(this.wb);
    }

    public void sB() {
        aw.b(this.Pd, s.cp_cont_c, 1);
        aw.b(this.VD, s.cp_cont_c, 1);
        aw.i(this.Vz, s.cp_bg_line_d);
        sA();
        aw.h(this.VB, u.loading_animation);
        sz();
    }
}
