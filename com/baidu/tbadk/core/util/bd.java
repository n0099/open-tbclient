package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements bc.a {
    private final /* synthetic */ int abF;
    private final /* synthetic */ boolean abG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(int i, boolean z) {
        this.abF = i;
        this.abG = z;
    }

    @Override // com.baidu.tbadk.core.util.bc.a
    public boolean n(View view) {
        int at;
        int at2;
        int at3;
        int at4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bc.c((TextView) view, this.abF);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bc.c((TextView) view, this.abF);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bc.k((TextView) view, this.abF);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bc.a((CheckBox) view, this.abF);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m411getInst().getApp(), this.abG ? i.C0057i.sidebar_content_1 : i.C0057i.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    at4 = bc.at(this.abG);
                    ((RadioButton) view).setTextColor(at4);
                }
                am.i(view, i.e.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    at3 = bc.at(this.abG);
                    ((RadioButton) view).setTextColor(at3);
                }
                am.i(view, i.e.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    at2 = bc.at(this.abG);
                    ((RadioButton) view).setTextColor(at2);
                }
                am.i(view, i.e.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    at = bc.at(this.abG);
                    ((RadioButton) view).setTextColor(at);
                }
                am.i(view, i.e.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                am.c((ImageView) view, i.e.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bc.k(view, this.abF);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
