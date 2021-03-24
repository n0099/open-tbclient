package com.baidu.spswitch.emotion.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/* loaded from: classes3.dex */
public class EmotionBaseFragment extends Fragment {
    public Bundle mArgs;

    public static <T extends Fragment> T newInstance(Class cls, Bundle bundle) {
        T t;
        try {
            t = (T) cls.newInstance();
        } catch (Exception e2) {
            e2.printStackTrace();
            t = null;
        }
        if (t != null) {
            t.setArguments(bundle);
        }
        return t;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mArgs = getArguments();
    }
}
