package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bo implements bp {
    private final /* synthetic */ int a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public final boolean a(View view) {
        int b;
        int b2;
        int b3;
        int b4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bn.b((TextView) view, this.a);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bn.b((TextView) view, this.a);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bn.a((TextView) view, this.a);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bn.a((CheckBox) view, this.a);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkApplication.j().b(), this.b ? com.baidu.tbadk.m.sidebar_content_1 : com.baidu.tbadk.m.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    b4 = bn.b(this.b);
                    ((RadioButton) view).setTextColor(b4);
                }
                ba.e(view, this.b ? com.baidu.tbadk.i.more_up_1 : com.baidu.tbadk.i.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    b3 = bn.b(this.b);
                    ((RadioButton) view).setTextColor(b3);
                }
                ba.e(view, this.b ? com.baidu.tbadk.i.more_middle_1 : com.baidu.tbadk.i.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    b2 = bn.b(this.b);
                    ((RadioButton) view).setTextColor(b2);
                }
                ba.e(view, this.b ? com.baidu.tbadk.i.more_down_1 : com.baidu.tbadk.i.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    b = bn.b(this.b);
                    ((RadioButton) view).setTextColor(b);
                }
                ba.e(view, this.b ? com.baidu.tbadk.i.more_all_1 : com.baidu.tbadk.i.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ((ImageView) view).setImageResource(this.b ? com.baidu.tbadk.i.icon_ba_top_arrow_big_1 : com.baidu.tbadk.i.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bn.a(view, this.a);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
