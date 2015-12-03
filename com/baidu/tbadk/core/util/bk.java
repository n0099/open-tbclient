package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements bj.a {
    private final /* synthetic */ int acF;
    private final /* synthetic */ boolean acG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(int i, boolean z) {
        this.acF = i;
        this.acG = z;
    }

    @Override // com.baidu.tbadk.core.util.bj.a
    public boolean n(View view) {
        int aw;
        int aw2;
        int aw3;
        int aw4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bj.c((TextView) view, this.acF);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bj.c((TextView) view, this.acF);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bj.k((TextView) view, this.acF);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bj.a((CheckBox) view, this.acF);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m411getInst().getApp(), this.acG ? n.j.sidebar_content_1 : n.j.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aw4 = bj.aw(this.acG);
                    ((RadioButton) view).setTextColor(aw4);
                }
                as.i(view, n.e.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aw3 = bj.aw(this.acG);
                    ((RadioButton) view).setTextColor(aw3);
                }
                as.i(view, n.e.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aw2 = bj.aw(this.acG);
                    ((RadioButton) view).setTextColor(aw2);
                }
                as.i(view, n.e.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aw = bj.aw(this.acG);
                    ((RadioButton) view).setTextColor(aw);
                }
                as.i(view, n.e.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                as.c((ImageView) view, n.e.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bj.k(view, this.acF);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
