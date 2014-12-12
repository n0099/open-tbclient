package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements br {
    private final /* synthetic */ int JL;
    private final /* synthetic */ boolean JM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(int i, boolean z) {
        this.JL = i;
        this.JM = z;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean k(View view) {
        int an;
        int an2;
        int an3;
        int an4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bp.c((TextView) view, this.JL);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bp.c((TextView) view, this.JL);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bp.k((TextView) view, this.JL);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bp.a((CheckBox) view, this.JL);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m255getInst().getApp(), this.JM ? com.baidu.tieba.aa.sidebar_content_1 : com.baidu.tieba.aa.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    an4 = bp.an(this.JM);
                    ((RadioButton) view).setTextColor(an4);
                }
                ax.i(view, com.baidu.tieba.v.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    an3 = bp.an(this.JM);
                    ((RadioButton) view).setTextColor(an3);
                }
                ax.i(view, com.baidu.tieba.v.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    an2 = bp.an(this.JM);
                    ((RadioButton) view).setTextColor(an2);
                }
                ax.i(view, com.baidu.tieba.v.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    an = bp.an(this.JM);
                    ((RadioButton) view).setTextColor(an);
                }
                ax.i(view, com.baidu.tieba.v.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ax.c((ImageView) view, com.baidu.tieba.v.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bp.k(view, this.JL);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
