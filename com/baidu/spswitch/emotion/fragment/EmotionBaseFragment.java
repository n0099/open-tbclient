package com.baidu.spswitch.emotion.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
/* loaded from: classes3.dex */
public class EmotionBaseFragment extends Fragment {
    protected Bundle mArgs;

    @Override // android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mArgs = getArguments();
    }
}
