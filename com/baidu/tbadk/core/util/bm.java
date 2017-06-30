package com.baidu.tbadk.core.util;

import android.app.Application;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements bl.a {
    private final /* synthetic */ int agT;
    private final /* synthetic */ boolean agU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(int i, boolean z) {
        this.agT = i;
        this.agU = z;
    }

    @Override // com.baidu.tbadk.core.util.bl.a
    public boolean w(View view) {
        int aG;
        int aG2;
        int aG3;
        int aG4;
        int i;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bl.b((TextView) view, this.agT);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bl.b((TextView) view, this.agT);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bl.h((TextView) view, this.agT);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bl.a((CheckBox) view, this.agT);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                TextView textView = (TextView) view;
                Application app = TbadkCoreApplication.m9getInst().getApp();
                if (this.agU) {
                    i = w.m.sidebar_content_1;
                } else {
                    i = w.m.sidebar_content;
                }
                textView.setTextAppearance(app, i);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG4 = bl.aG(this.agU);
                    ((RadioButton) view).setTextColor(aG4);
                }
                as.j(view, w.g.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG3 = bl.aG(this.agU);
                    ((RadioButton) view).setTextColor(aG3);
                }
                as.j(view, w.g.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG2 = bl.aG(this.agU);
                    ((RadioButton) view).setTextColor(aG2);
                }
                as.j(view, w.g.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG = bl.aG(this.agU);
                    ((RadioButton) view).setTextColor(aG);
                }
                as.j(view, w.g.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                as.c((ImageView) view, w.g.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bl.l(view, this.agT);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
