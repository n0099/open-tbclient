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
    private final /* synthetic */ int agN;
    private final /* synthetic */ boolean agO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(int i, boolean z) {
        this.agN = i;
        this.agO = z;
    }

    @Override // com.baidu.tbadk.core.util.bg.a
    public boolean w(View view) {
        int aG;
        int aG2;
        int aG3;
        int aG4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bg.b((TextView) view, this.agN);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bg.b((TextView) view, this.agN);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bg.j((TextView) view, this.agN);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bg.a((CheckBox) view, this.agN);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m9getInst().getApp(), this.agO ? w.m.sidebar_content_1 : w.m.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG4 = bg.aG(this.agO);
                    ((RadioButton) view).setTextColor(aG4);
                }
                aq.j(view, w.g.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG3 = bg.aG(this.agO);
                    ((RadioButton) view).setTextColor(aG3);
                }
                aq.j(view, w.g.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG2 = bg.aG(this.agO);
                    ((RadioButton) view).setTextColor(aG2);
                }
                aq.j(view, w.g.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG = bg.aG(this.agO);
                    ((RadioButton) view).setTextColor(aG);
                }
                aq.j(view, w.g.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                aq.c((ImageView) view, w.g.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bg.l(view, this.agN);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
