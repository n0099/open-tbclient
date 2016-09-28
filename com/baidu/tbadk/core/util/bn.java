package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements bm.a {
    private final /* synthetic */ int acu;
    private final /* synthetic */ boolean acv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(int i, boolean z) {
        this.acu = i;
        this.acv = z;
    }

    @Override // com.baidu.tbadk.core.util.bm.a
    public boolean A(View view) {
        int aD;
        int aD2;
        int aD3;
        int aD4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bm.c((TextView) view, this.acu);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bm.c((TextView) view, this.acu);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bm.k((TextView) view, this.acu);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bm.a((CheckBox) view, this.acu);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m9getInst().getApp(), this.acv ? r.k.sidebar_content_1 : r.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aD4 = bm.aD(this.acv);
                    ((RadioButton) view).setTextColor(aD4);
                }
                av.k(view, r.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aD3 = bm.aD(this.acv);
                    ((RadioButton) view).setTextColor(aD3);
                }
                av.k(view, r.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aD2 = bm.aD(this.acv);
                    ((RadioButton) view).setTextColor(aD2);
                }
                av.k(view, r.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aD = bm.aD(this.acv);
                    ((RadioButton) view).setTextColor(aD);
                }
                av.k(view, r.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                av.c((ImageView) view, r.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bm.m(view, this.acu);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
