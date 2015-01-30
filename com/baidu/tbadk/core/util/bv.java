package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements bw {
    private final /* synthetic */ int Ke;
    private final /* synthetic */ boolean Kf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(int i, boolean z) {
        this.Ke = i;
        this.Kf = z;
    }

    @Override // com.baidu.tbadk.core.util.bw
    public boolean k(View view) {
        int ap;
        int ap2;
        int ap3;
        int ap4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bu.c((TextView) view, this.Ke);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bu.c((TextView) view, this.Ke);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bu.k((TextView) view, this.Ke);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bu.a((CheckBox) view, this.Ke);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m255getInst().getApp(), this.Kf ? com.baidu.tieba.aa.sidebar_content_1 : com.baidu.tieba.aa.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    ap4 = bu.ap(this.Kf);
                    ((RadioButton) view).setTextColor(ap4);
                }
                bc.i(view, com.baidu.tieba.v.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    ap3 = bu.ap(this.Kf);
                    ((RadioButton) view).setTextColor(ap3);
                }
                bc.i(view, com.baidu.tieba.v.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    ap2 = bu.ap(this.Kf);
                    ((RadioButton) view).setTextColor(ap2);
                }
                bc.i(view, com.baidu.tieba.v.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    ap = bu.ap(this.Kf);
                    ((RadioButton) view).setTextColor(ap);
                }
                bc.i(view, com.baidu.tieba.v.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                bc.c((ImageView) view, com.baidu.tieba.v.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bu.k(view, this.Ke);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
