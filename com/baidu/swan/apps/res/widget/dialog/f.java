package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes8.dex */
public class f extends g.a {
    private Context mContext;

    public f(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.g.a
    public g aqn() {
        this.dDa = this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_action_sheet_list_item);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dDa);
        layoutParams.addRule(12);
        this.dDJ.dCZ.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.aiapps_action_sheet_bottom_divider));
        layoutParams2.addRule(2, this.dDJ.dCZ.getId());
        this.dDJ.dCT.setLayoutParams(layoutParams2);
        jc(a.c.aiapps_action_sheet_split_color);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, this.dDJ.dCT.getId());
        this.dDJ.dDQ.setLayoutParams(layoutParams3);
        return super.aqn();
    }
}
