package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements bh.a {
    private final /* synthetic */ int acl;
    private final /* synthetic */ boolean acm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(int i, boolean z) {
        this.acl = i;
        this.acm = z;
    }

    @Override // com.baidu.tbadk.core.util.bh.a
    public boolean A(View view) {
        int aH;
        int aH2;
        int aH3;
        int aH4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bh.c((TextView) view, this.acl);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bh.c((TextView) view, this.acl);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bh.k((TextView) view, this.acl);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bh.a((CheckBox) view, this.acl);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m9getInst().getApp(), this.acm ? r.k.sidebar_content_1 : r.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aH4 = bh.aH(this.acm);
                    ((RadioButton) view).setTextColor(aH4);
                }
                ar.k(view, r.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aH3 = bh.aH(this.acm);
                    ((RadioButton) view).setTextColor(aH3);
                }
                ar.k(view, r.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aH2 = bh.aH(this.acm);
                    ((RadioButton) view).setTextColor(aH2);
                }
                ar.k(view, r.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aH = bh.aH(this.acm);
                    ((RadioButton) view).setTextColor(aH);
                }
                ar.k(view, r.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ar.c((ImageView) view, r.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bh.m(view, this.acl);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
