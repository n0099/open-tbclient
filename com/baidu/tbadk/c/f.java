package com.baidu.tbadk.c;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f extends a {
    private Runnable Ix;
    private String[] acM;
    private TextView alM;
    private ImageView auu;
    private TextView auv;
    private final int auw;
    private int currentIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public int Ct() {
        this.currentIndex++;
        if (this.currentIndex >= this.auw) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public f(Context context) {
        this(context, context.getResources().getDimensionPixelSize(i.d.ds484));
    }

    public f(Context context, int i) {
        super(LayoutInflater.from(context).inflate(i.g.loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.Ix = new g(this);
        this.auu = (ImageView) this.aus.findViewById(i.f.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.auu.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.auu.setLayoutParams(marginLayoutParams);
            }
        }
        this.alM = (TextView) this.aus.findViewById(i.f.loading_anim_ellipsis);
        this.auv = (TextView) this.aus.findViewById(i.f.loading_text);
        this.acM = context.getResources().getStringArray(i.b.loading_anim_text_array);
        this.auw = this.acM.length;
    }

    private void Cu() {
        if (this.auu != null && (this.auu.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.auu.getBackground()).start();
        }
    }

    private void Cv() {
        if (this.auu != null && (this.auu.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.auu.getBackground()).stop();
        }
    }

    @Override // com.baidu.tbadk.c.a
    protected void Cr() {
        al.i(this.auu, i.e.loading_animation);
        Cu();
        this.alM.setText(this.acM[0]);
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Ix);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.Ix, 200L);
    }

    @Override // com.baidu.tbadk.c.a
    protected void Cs() {
        Cv();
        TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Ix);
        this.auu.setBackgroundResource(0);
    }

    public void ta() {
        al.i(this.auu, i.e.loading_animation);
        al.b(this.alM, i.c.cp_cont_c, 1);
        al.b(this.auv, i.c.cp_cont_c, 1);
        al.j(this.aus, i.c.cp_bg_line_d);
    }
}
