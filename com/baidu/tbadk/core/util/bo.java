package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements bn.a {
    private final /* synthetic */ int acj;
    private final /* synthetic */ boolean ack;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(int i, boolean z) {
        this.acj = i;
        this.ack = z;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean A(View view) {
        int aD;
        int aD2;
        int aD3;
        int aD4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bn.c((TextView) view, this.acj);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bn.c((TextView) view, this.acj);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bn.k((TextView) view, this.acj);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bn.a((CheckBox) view, this.acj);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m9getInst().getApp(), this.ack ? t.k.sidebar_content_1 : t.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aD4 = bn.aD(this.ack);
                    ((RadioButton) view).setTextColor(aD4);
                }
                av.k(view, t.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aD3 = bn.aD(this.ack);
                    ((RadioButton) view).setTextColor(aD3);
                }
                av.k(view, t.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aD2 = bn.aD(this.ack);
                    ((RadioButton) view).setTextColor(aD2);
                }
                av.k(view, t.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aD = bn.aD(this.ack);
                    ((RadioButton) view).setTextColor(aD);
                }
                av.k(view, t.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                av.c((ImageView) view, t.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bn.m(view, this.acj);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
