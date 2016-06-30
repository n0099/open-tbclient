package com.baidu.tbadk.core.util;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements bn.a {
    private final /* synthetic */ int YL;
    private final /* synthetic */ boolean YM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(int i, boolean z) {
        this.YL = i;
        this.YM = z;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean z(View view) {
        int az;
        int az2;
        int az3;
        int az4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bn.c((TextView) view, this.YL);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bn.c((TextView) view, this.YL);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bn.k((TextView) view, this.YL);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bn.a((CheckBox) view, this.YL);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m9getInst().getApp(), this.YM ? u.k.sidebar_content_1 : u.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    az4 = bn.az(this.YM);
                    ((RadioButton) view).setTextColor(az4);
                }
                av.k(view, u.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    az3 = bn.az(this.YM);
                    ((RadioButton) view).setTextColor(az3);
                }
                av.k(view, u.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    az2 = bn.az(this.YM);
                    ((RadioButton) view).setTextColor(az2);
                }
                av.k(view, u.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    az = bn.az(this.YM);
                    ((RadioButton) view).setTextColor(az);
                }
                av.k(view, u.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                av.c((ImageView) view, u.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bn.m(view, this.YL);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
