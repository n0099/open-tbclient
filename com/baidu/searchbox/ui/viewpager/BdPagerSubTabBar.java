package com.baidu.searchbox.ui.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.ui.viewpager.BdPagerTabBar;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BdPagerSubTabBar extends BdPagerTabBar {
    public BdPagerSubTabBar(Context context) {
        super(context);
        init(context);
    }

    public BdPagerSubTabBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public BdPagerSubTabBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setAdapter(new BdPagerTabBar.TabAdapter(context, true, false));
        setDividerDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08151e));
        setBackgroundResource(R.drawable.obfuscated_res_0x7f081165);
        setTabTextSize((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07076b));
        setTabTextColor(getResources().getColorStateList(R.color.obfuscated_res_0x7f060b50));
        setTabBackground(R.drawable.obfuscated_res_0x7f081521);
    }
}
