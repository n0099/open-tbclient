package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class InvokeRefreshInOnResumeConfig extends a {
    private Fragment mFragment;

    public InvokeRefreshInOnResumeConfig(Context context, Fragment fragment) {
        super(context);
        this.mFragment = fragment;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }
}
