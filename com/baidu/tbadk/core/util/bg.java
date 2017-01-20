package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements bf.a {
    private final /* synthetic */ int abx;
    private final /* synthetic */ boolean aby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(int i, boolean z) {
        this.abx = i;
        this.aby = z;
    }

    @Override // com.baidu.tbadk.core.util.bf.a
    public boolean y(View view) {
        int aH;
        int aH2;
        int aH3;
        int aH4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bf.c((TextView) view, this.abx);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bf.c((TextView) view, this.abx);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bf.k((TextView) view, this.abx);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bf.a((CheckBox) view, this.abx);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m9getInst().getApp(), this.aby ? r.m.sidebar_content_1 : r.m.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aH4 = bf.aH(this.aby);
                    ((RadioButton) view).setTextColor(aH4);
                }
                ap.j(view, r.g.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aH3 = bf.aH(this.aby);
                    ((RadioButton) view).setTextColor(aH3);
                }
                ap.j(view, r.g.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aH2 = bf.aH(this.aby);
                    ((RadioButton) view).setTextColor(aH2);
                }
                ap.j(view, r.g.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aH = bf.aH(this.aby);
                    ((RadioButton) view).setTextColor(aH);
                }
                ap.j(view, r.g.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                ap.c((ImageView) view, r.g.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bf.l(view, this.abx);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
