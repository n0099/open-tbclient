package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements bd.a {
    private final /* synthetic */ int abN;
    private final /* synthetic */ boolean abO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(int i, boolean z) {
        this.abN = i;
        this.abO = z;
    }

    @Override // com.baidu.tbadk.core.util.bd.a
    public boolean n(View view) {
        int at;
        int at2;
        int at3;
        int at4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bd.c((TextView) view, this.abN);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bd.c((TextView) view, this.abN);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bd.k((TextView) view, this.abN);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bd.a((CheckBox) view, this.abN);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m411getInst().getApp(), this.abO ? i.C0057i.sidebar_content_1 : i.C0057i.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    at4 = bd.at(this.abO);
                    ((RadioButton) view).setTextColor(at4);
                }
                an.i(view, i.e.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    at3 = bd.at(this.abO);
                    ((RadioButton) view).setTextColor(at3);
                }
                an.i(view, i.e.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    at2 = bd.at(this.abO);
                    ((RadioButton) view).setTextColor(at2);
                }
                an.i(view, i.e.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    at = bd.at(this.abO);
                    ((RadioButton) view).setTextColor(at);
                }
                an.i(view, i.e.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                an.c((ImageView) view, i.e.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bd.k(view, this.abN);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
