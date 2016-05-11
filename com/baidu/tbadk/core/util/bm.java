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
    private final /* synthetic */ int Yu;
    private final /* synthetic */ boolean Yv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(int i, boolean z) {
        this.Yu = i;
        this.Yv = z;
    }

    @Override // com.baidu.tbadk.core.util.bl.a
    public boolean A(View view) {
        int aB;
        int aB2;
        int aB3;
        int aB4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bl.c((TextView) view, this.Yu);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bl.c((TextView) view, this.Yu);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bl.k((TextView) view, this.Yu);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bl.a((CheckBox) view, this.Yu);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m11getInst().getApp(), this.Yv ? t.k.sidebar_content_1 : t.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aB4 = bl.aB(this.Yv);
                    ((RadioButton) view).setTextColor(aB4);
                }
                at.k(view, t.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aB3 = bl.aB(this.Yv);
                    ((RadioButton) view).setTextColor(aB3);
                }
                at.k(view, t.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aB2 = bl.aB(this.Yv);
                    ((RadioButton) view).setTextColor(aB2);
                }
                at.k(view, t.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aB = bl.aB(this.Yv);
                    ((RadioButton) view).setTextColor(aB);
                }
                at.k(view, t.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                at.c((ImageView) view, t.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bl.m(view, this.Yu);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
