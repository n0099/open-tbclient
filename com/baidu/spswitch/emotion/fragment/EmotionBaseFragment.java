package com.baidu.spswitch.emotion.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/* loaded from: classes3.dex */
public class EmotionBaseFragment extends Fragment {
    protected Bundle mArgs;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mArgs = getArguments();
    }
}
