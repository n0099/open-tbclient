package com.baidu.tbadk.core.util;

import android.app.Application;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements bh.a {
    private final /* synthetic */ int agl;
    private final /* synthetic */ boolean agm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(int i, boolean z) {
        this.agl = i;
        this.agm = z;
    }

    @Override // com.baidu.tbadk.core.util.bh.a
    public boolean w(View view) {
        int aF;
        int aF2;
        int aF3;
        int aF4;
        int i;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bh.b((TextView) view, this.agl);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bh.b((TextView) view, this.agl);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bh.h((TextView) view, this.agl);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bh.a((CheckBox) view, this.agl);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                TextView textView = (TextView) view;
                Application app = TbadkCoreApplication.m9getInst().getApp();
                if (this.agm) {
                    i = w.m.sidebar_content_1;
                } else {
                    i = w.m.sidebar_content;
                }
                textView.setTextAppearance(app, i);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aF4 = bh.aF(this.agm);
                    ((RadioButton) view).setTextColor(aF4);
                }
                aq.j(view, w.g.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aF3 = bh.aF(this.agm);
                    ((RadioButton) view).setTextColor(aF3);
                }
                aq.j(view, w.g.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aF2 = bh.aF(this.agm);
                    ((RadioButton) view).setTextColor(aF2);
                }
                aq.j(view, w.g.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aF = bh.aF(this.agm);
                    ((RadioButton) view).setTextColor(aF);
                }
                aq.j(view, w.g.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                aq.c((ImageView) view, w.g.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bh.l(view, this.agl);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
