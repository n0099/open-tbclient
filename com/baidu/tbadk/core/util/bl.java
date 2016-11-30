package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements bk.a {
    private final /* synthetic */ int acS;
    private final /* synthetic */ boolean acT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(int i, boolean z) {
        this.acS = i;
        this.acT = z;
    }

    @Override // com.baidu.tbadk.core.util.bk.a
    public boolean A(View view) {
        int aG;
        int aG2;
        int aG3;
        int aG4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bk.c((TextView) view, this.acS);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bk.c((TextView) view, this.acS);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bk.k((TextView) view, this.acS);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bk.a((CheckBox) view, this.acS);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m9getInst().getApp(), this.acT ? r.k.sidebar_content_1 : r.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG4 = bk.aG(this.acT);
                    ((RadioButton) view).setTextColor(aG4);
                }
                at.k(view, r.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG3 = bk.aG(this.acT);
                    ((RadioButton) view).setTextColor(aG3);
                }
                at.k(view, r.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG2 = bk.aG(this.acT);
                    ((RadioButton) view).setTextColor(aG2);
                }
                at.k(view, r.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aG = bk.aG(this.acT);
                    ((RadioButton) view).setTextColor(aG);
                }
                at.k(view, r.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                at.c((ImageView) view, r.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bk.m(view, this.acS);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
