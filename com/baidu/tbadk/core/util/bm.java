package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements bl.a {
    private final /* synthetic */ int acV;
    private final /* synthetic */ boolean acW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(int i, boolean z) {
        this.acV = i;
        this.acW = z;
    }

    @Override // com.baidu.tbadk.core.util.bl.a
    public boolean A(View view) {
        int aw;
        int aw2;
        int aw3;
        int aw4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bl.c((TextView) view, this.acV);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bl.c((TextView) view, this.acV);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bl.k((TextView) view, this.acV);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bl.a((CheckBox) view, this.acV);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m411getInst().getApp(), this.acW ? t.k.sidebar_content_1 : t.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aw4 = bl.aw(this.acW);
                    ((RadioButton) view).setTextColor(aw4);
                }
                at.k(view, t.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aw3 = bl.aw(this.acW);
                    ((RadioButton) view).setTextColor(aw3);
                }
                at.k(view, t.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aw2 = bl.aw(this.acW);
                    ((RadioButton) view).setTextColor(aw2);
                }
                at.k(view, t.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aw = bl.aw(this.acW);
                    ((RadioButton) view).setTextColor(aw);
                }
                at.k(view, t.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                at.c((ImageView) view, t.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bl.m(view, this.acV);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
