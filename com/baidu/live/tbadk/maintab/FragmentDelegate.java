package com.baidu.live.tbadk.maintab;

import android.content.Context;
/* loaded from: classes7.dex */
public abstract class FragmentDelegate {
    protected FragmentTabStructure mFragement = createFragmentTabStructure();
    protected TbFragmentTabIndicator mIndicator;

    public abstract FragmentTabStructure createFragmentTabStructure();

    public abstract TbFragmentTabIndicator getTabIndicator(Context context);

    public abstract boolean isAvailable();

    public void onAdd() {
    }

    public void onRemove() {
    }

    public FragmentTabStructure getFragmentTabStructure() {
        return this.mFragement;
    }
}
