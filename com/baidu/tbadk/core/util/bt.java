package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements bu {
    private final /* synthetic */ int VP;
    private final /* synthetic */ boolean VQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(int i, boolean z) {
        this.VP = i;
        this.VQ = z;
    }

    @Override // com.baidu.tbadk.core.util.bu
    public boolean k(View view) {
        int aj;
        int aj2;
        int aj3;
        int aj4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bs.c((TextView) view, this.VP);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bs.c((TextView) view, this.VP);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bs.k((TextView) view, this.VP);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bs.a((CheckBox) view, this.VP);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m411getInst().getApp(), this.VQ ? com.baidu.tieba.z.sidebar_content_1 : com.baidu.tieba.z.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aj4 = bs.aj(this.VQ);
                    ((RadioButton) view).setTextColor(aj4);
                }
                ba.i(view, com.baidu.tieba.u.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aj3 = bs.aj(this.VQ);
                    ((RadioButton) view).setTextColor(aj3);
                }
                ba.i(view, com.baidu.tieba.u.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aj2 = bs.aj(this.VQ);
                    ((RadioButton) view).setTextColor(aj2);
                }
                ba.i(view, com.baidu.tieba.u.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aj = bs.aj(this.VQ);
                    ((RadioButton) view).setTextColor(aj);
                }
                ba.i(view, com.baidu.tieba.u.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ba.c((ImageView) view, com.baidu.tieba.u.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bs.k(view, this.VP);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
