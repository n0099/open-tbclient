package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements bb.a {
    private final /* synthetic */ int abG;
    private final /* synthetic */ boolean abH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(int i, boolean z) {
        this.abG = i;
        this.abH = z;
    }

    @Override // com.baidu.tbadk.core.util.bb.a
    public boolean n(View view) {
        int at;
        int at2;
        int at3;
        int at4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bb.c((TextView) view, this.abG);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bb.c((TextView) view, this.abG);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bb.k((TextView) view, this.abG);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bb.a((CheckBox) view, this.abG);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m411getInst().getApp(), this.abH ? i.C0057i.sidebar_content_1 : i.C0057i.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    at4 = bb.at(this.abH);
                    ((RadioButton) view).setTextColor(at4);
                }
                al.h(view, i.e.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    at3 = bb.at(this.abH);
                    ((RadioButton) view).setTextColor(at3);
                }
                al.h(view, i.e.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    at2 = bb.at(this.abH);
                    ((RadioButton) view).setTextColor(at2);
                }
                al.h(view, i.e.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    at = bb.at(this.abH);
                    ((RadioButton) view).setTextColor(at);
                }
                al.h(view, i.e.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                al.c((ImageView) view, i.e.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bb.j(view, this.abG);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
