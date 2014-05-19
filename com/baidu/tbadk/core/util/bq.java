package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements br {
    private final /* synthetic */ int a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // com.baidu.tbadk.core.util.br
    public boolean a(View view) {
        int b;
        int b2;
        int b3;
        int b4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bp.b((TextView) view, this.a);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bp.b((TextView) view, this.a);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bp.a((TextView) view, this.a);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bp.a((CheckBox) view, this.a);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkApplication.m252getInst().getApp(), this.b ? com.baidu.tieba.v.sidebar_content_1 : com.baidu.tieba.v.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    b4 = bp.b(this.b);
                    ((RadioButton) view).setTextColor(b4);
                }
                bc.e(view, this.b ? com.baidu.tieba.q.more_up_1 : com.baidu.tieba.q.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    b3 = bp.b(this.b);
                    ((RadioButton) view).setTextColor(b3);
                }
                bc.e(view, this.b ? com.baidu.tieba.q.more_middle_1 : com.baidu.tieba.q.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    b2 = bp.b(this.b);
                    ((RadioButton) view).setTextColor(b2);
                }
                bc.e(view, this.b ? com.baidu.tieba.q.more_down_1 : com.baidu.tieba.q.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    b = bp.b(this.b);
                    ((RadioButton) view).setTextColor(b);
                }
                bc.e(view, this.b ? com.baidu.tieba.q.more_all_1 : com.baidu.tieba.q.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ((ImageView) view).setImageResource(this.b ? com.baidu.tieba.q.icon_ba_top_arrow_big_1 : com.baidu.tieba.q.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bp.a(view, this.a);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
