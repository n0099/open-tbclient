package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.widget.ListView.e {
    public ak(Context context) {
        super(context);
    }

    public void cl(int i) {
        TextView jz = jz();
        TextView jy = jy();
        if (jz != null && jy != null && this.wr != null && this.ws != null) {
            if (i == 1) {
                int color = getContext().getResources().getColor(com.baidu.tieba.t.cp_cont_b_1);
                int color2 = getContext().getResources().getColor(com.baidu.tieba.t.cp_cont_c_1);
                this.wr.setBackgroundColor(getContext().getResources().getColor(com.baidu.tieba.t.cp_bg_line_c_1));
                jz.setTextColor(color);
                jy.setTextColor(color2);
                this.wA = new AnimationDrawable();
                Drawable drawable = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh02_1);
                if (drawable != null) {
                    this.wA.addFrame(drawable, 100);
                }
                Drawable drawable2 = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh01_1);
                if (drawable2 != null) {
                    this.wA.addFrame(drawable2, 100);
                }
                this.wA.setOneShot(false);
                this.ws.setBackgroundDrawable(this.wA);
                return;
            }
            int color3 = getContext().getResources().getColor(com.baidu.tieba.t.cp_cont_b);
            int color4 = getContext().getResources().getColor(com.baidu.tieba.t.cp_cont_c);
            this.wr.setBackgroundColor(getContext().getResources().getColor(com.baidu.tieba.t.cp_bg_line_c));
            jz.setTextColor(color3);
            jy.setTextColor(color4);
            this.wA = new AnimationDrawable();
            Drawable drawable3 = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh02);
            if (drawable3 != null) {
                this.wA.addFrame(drawable3, 100);
            }
            Drawable drawable4 = getContext().getResources().getDrawable(com.baidu.tieba.v.listview_pull_refresh01);
            if (drawable4 != null) {
                this.wA.addFrame(drawable4, 100);
            }
            this.wA.setOneShot(false);
            this.ws.setBackgroundDrawable(this.wA);
        }
    }
}
