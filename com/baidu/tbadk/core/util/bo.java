package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements bp {
    private final /* synthetic */ int FB;
    private final /* synthetic */ boolean FC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(int i, boolean z) {
        this.FB = i;
        this.FC = z;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public boolean k(View view) {
        int W;
        int W2;
        int W3;
        int W4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bn.b((TextView) view, this.FB);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bn.b((TextView) view, this.FB);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bn.l((TextView) view, this.FB);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bn.a((CheckBox) view, this.FB);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkApplication.m251getInst().getApp(), this.FC ? com.baidu.tieba.z.sidebar_content_1 : com.baidu.tieba.z.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    W4 = bn.W(this.FC);
                    ((RadioButton) view).setTextColor(W4);
                }
                aw.h(view, com.baidu.tieba.u.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    W3 = bn.W(this.FC);
                    ((RadioButton) view).setTextColor(W3);
                }
                aw.h(view, com.baidu.tieba.u.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    W2 = bn.W(this.FC);
                    ((RadioButton) view).setTextColor(W2);
                }
                aw.h(view, com.baidu.tieba.u.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    W = bn.W(this.FC);
                    ((RadioButton) view).setTextColor(W);
                }
                aw.h(view, com.baidu.tieba.u.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                aw.c((ImageView) view, com.baidu.tieba.u.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bn.j(view, this.FB);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
