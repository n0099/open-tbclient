package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes11.dex */
public class f extends g.a {
    private Context mContext;

    public f(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.g.a
    public g WT() {
        this.mBtnHeight = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_action_sheet_list_item);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
        layoutParams.addRule(12);
        this.cnf.mBtnPanelLayout.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_action_sheet_bottom_divider));
        layoutParams2.addRule(2, this.cnf.mBtnPanelLayout.getId());
        this.cnf.mDivider2.setLayoutParams(layoutParams2);
        gj(a.c.aiapps_action_sheet_split_color);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, this.cnf.mDivider2.getId());
        this.cnf.mDialogContentPanel.setLayoutParams(layoutParams3);
        return super.WT();
    }
}
