package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements bs {
    private final /* synthetic */ int Ww;
    private final /* synthetic */ boolean Wx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(int i, boolean z) {
        this.Ww = i;
        this.Wx = z;
    }

    @Override // com.baidu.tbadk.core.util.bs
    public boolean m(View view) {
        int ap;
        int ap2;
        int ap3;
        int ap4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bq.c((TextView) view, this.Ww);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bq.c((TextView) view, this.Ww);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bq.k((TextView) view, this.Ww);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bq.a((CheckBox) view, this.Ww);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m411getInst().getApp(), this.Wx ? com.baidu.tieba.u.sidebar_content_1 : com.baidu.tieba.u.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    ap4 = bq.ap(this.Wx);
                    ((RadioButton) view).setTextColor(ap4);
                }
                ay.i(view, com.baidu.tieba.p.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    ap3 = bq.ap(this.Wx);
                    ((RadioButton) view).setTextColor(ap3);
                }
                ay.i(view, com.baidu.tieba.p.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    ap2 = bq.ap(this.Wx);
                    ((RadioButton) view).setTextColor(ap2);
                }
                ay.i(view, com.baidu.tieba.p.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    ap = bq.ap(this.Wx);
                    ((RadioButton) view).setTextColor(ap);
                }
                ay.i(view, com.baidu.tieba.p.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ay.c((ImageView) view, com.baidu.tieba.p.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bq.k(view, this.Ww);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
