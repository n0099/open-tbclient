package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements bg.a {
    private final /* synthetic */ int ahc;
    private final /* synthetic */ boolean ahd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(int i, boolean z) {
        this.ahc = i;
        this.ahd = z;
    }

    @Override // com.baidu.tbadk.core.util.bg.a
    public boolean w(View view) {
        int aI;
        int aI2;
        int aI3;
        int aI4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bg.b((TextView) view, this.ahc);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bg.b((TextView) view, this.ahc);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bg.h((TextView) view, this.ahc);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bg.a((CheckBox) view, this.ahc);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m9getInst().getApp(), this.ahd ? w.m.sidebar_content_1 : w.m.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aI4 = bg.aI(this.ahd);
                    ((RadioButton) view).setTextColor(aI4);
                }
                aq.j(view, w.g.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aI3 = bg.aI(this.ahd);
                    ((RadioButton) view).setTextColor(aI3);
                }
                aq.j(view, w.g.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aI2 = bg.aI(this.ahd);
                    ((RadioButton) view).setTextColor(aI2);
                }
                aq.j(view, w.g.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aI = bg.aI(this.ahd);
                    ((RadioButton) view).setTextColor(aI);
                }
                aq.j(view, w.g.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                aq.c((ImageView) view, w.g.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bg.l(view, this.ahc);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
