package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements bj.a {
    private final /* synthetic */ int adk;
    private final /* synthetic */ boolean adl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(int i, boolean z) {
        this.adk = i;
        this.adl = z;
    }

    @Override // com.baidu.tbadk.core.util.bj.a
    public boolean n(View view) {
        int at;
        int at2;
        int at3;
        int at4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bj.c((TextView) view, this.adk);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bj.c((TextView) view, this.adk);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bj.k((TextView) view, this.adk);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bj.a((CheckBox) view, this.adk);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m411getInst().getApp(), this.adl ? n.k.sidebar_content_1 : n.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    at4 = bj.at(this.adl);
                    ((RadioButton) view).setTextColor(at4);
                }
                as.i(view, n.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    at3 = bj.at(this.adl);
                    ((RadioButton) view).setTextColor(at3);
                }
                as.i(view, n.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    at2 = bj.at(this.adl);
                    ((RadioButton) view).setTextColor(at2);
                }
                as.i(view, n.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    at = bj.at(this.adl);
                    ((RadioButton) view).setTextColor(at);
                }
                as.i(view, n.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                as.c((ImageView) view, n.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bj.k(view, this.adk);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
