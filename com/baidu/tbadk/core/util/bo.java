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
    private final /* synthetic */ int Zu;
    private final /* synthetic */ boolean Zv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(int i, boolean z) {
        this.Zu = i;
        this.Zv = z;
    }

    @Override // com.baidu.tbadk.core.util.bn.a
    public boolean z(View view) {
        int aC;
        int aC2;
        int aC3;
        int aC4;
        Object tag = view.getTag();
        if (tag != null) {
            if ("skin_text_group".equals(tag)) {
                bn.c((TextView) view, this.Zu);
                return false;
            } else if ("skin_text_content".equals(tag)) {
                bn.c((TextView) view, this.Zu);
                return false;
            } else if ("skin_text_num".equals(tag)) {
                bn.k((TextView) view, this.Zu);
                return false;
            } else if ("skin_check_box".equals(tag)) {
                bn.a((CheckBox) view, this.Zu);
                return false;
            } else if ("skin_sidebar_content".equals(tag)) {
                ((TextView) view).setTextAppearance(TbadkCoreApplication.m10getInst().getApp(), this.Zv ? u.k.sidebar_content_1 : u.k.sidebar_content);
                return false;
            } else if ("skin_more_up".equals(tag)) {
                if (view instanceof RadioButton) {
                    aC4 = bn.aC(this.Zv);
                    ((RadioButton) view).setTextColor(aC4);
                }
                av.k(view, u.f.more_up);
                return false;
            } else if ("skin_more_middle".equals(tag)) {
                if (view instanceof RadioButton) {
                    aC3 = bn.aC(this.Zv);
                    ((RadioButton) view).setTextColor(aC3);
                }
                av.k(view, u.f.more_middle);
                return false;
            } else if ("skin_more_down".equals(tag)) {
                if (view instanceof RadioButton) {
                    aC2 = bn.aC(this.Zv);
                    ((RadioButton) view).setTextColor(aC2);
                }
                av.k(view, u.f.more_down);
                return false;
            } else if ("skin_more_all".equals(tag)) {
                if (view instanceof RadioButton) {
                    aC = bn.aC(this.Zv);
                    ((RadioButton) view).setTextColor(aC);
                }
                av.k(view, u.f.more_all);
                return false;
            } else if ("skin_arrow".equals(tag)) {
                av.c((ImageView) view, u.f.icon_ba_top_arrow_big);
                return false;
            } else if ("skin_list_line".equals(tag)) {
                bn.m(view, this.Zu);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
