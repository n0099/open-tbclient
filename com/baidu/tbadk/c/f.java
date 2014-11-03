package com.baidu.tbadk.c;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.q;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends a {
    private TextView Ph;
    private ImageView VF;
    private String[] VG;
    private TextView VH;
    private final int VI;
    private int currentIndex;
    private Runnable wb;

    /* JADX INFO: Access modifiers changed from: private */
    public int sA() {
        this.currentIndex++;
        if (this.currentIndex >= this.VI) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(t.ds484));
    }

    public f(Context context, int i) {
        super(com.baidu.adp.lib.g.b.ek().inflate(context, w.loading_view_layout, null));
        this.currentIndex = 0;
        this.wb = new g(this);
        this.VF = (ImageView) this.VD.findViewById(v.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.VF.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.VF.setLayoutParams(marginLayoutParams);
            }
        }
        this.Ph = (TextView) this.VD.findViewById(v.loading_anim_ellipsis);
        this.VH = (TextView) this.VD.findViewById(v.loading_text);
        this.VF.setBackgroundResource(u.loading_animation);
        this.VG = context.getResources().getStringArray(q.loading_anim_text_array);
        this.VI = this.VG.length;
    }

    private void sB() {
        if (this.VF != null && (this.VF.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.VF.getBackground()).start();
        }
    }

    private void sC() {
        if (this.VF != null && (this.VF.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.VF.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.c.a
    protected void sy() {
        sB();
        this.Ph.setText(this.VG[0]);
        this.Ph.postDelayed(this.wb, 200L);
    }

    @Override // com.baidu.tbadk.c.a
    protected void sz() {
        sC();
        this.Ph.removeCallbacks(this.wb);
    }

    public void sD() {
        aw.b(this.Ph, s.cp_cont_c, 1);
        aw.b(this.VH, s.cp_cont_c, 1);
        aw.i(this.VD, s.cp_bg_line_d);
        sC();
        aw.h(this.VF, u.loading_animation);
        sB();
    }
}
