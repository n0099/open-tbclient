package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements bi.a {
    private final /* synthetic */ int adG;
    private final /* synthetic */ boolean adH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(int i, boolean z) {
        this.adG = i;
        this.adH = z;
    }

    @Override // com.baidu.tbadk.core.util.bi.a
    public boolean A(View view) {
        int au;
        int au2;
        int au3;
        int au4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bi.c((TextView) view, this.adG);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bi.c((TextView) view, this.adG);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bi.k((TextView) view, this.adG);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bi.a((CheckBox) view, this.adG);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m411getInst().getApp(), this.adH ? t.k.sidebar_content_1 : t.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    au4 = bi.au(this.adH);
                    ((RadioButton) view).setTextColor(au4);
                }
                ar.k(view, t.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    au3 = bi.au(this.adH);
                    ((RadioButton) view).setTextColor(au3);
                }
                ar.k(view, t.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    au2 = bi.au(this.adH);
                    ((RadioButton) view).setTextColor(au2);
                }
                ar.k(view, t.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    au = bi.au(this.adH);
                    ((RadioButton) view).setTextColor(au);
                }
                ar.k(view, t.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ar.c((ImageView) view, t.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bi.m(view, this.adG);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
