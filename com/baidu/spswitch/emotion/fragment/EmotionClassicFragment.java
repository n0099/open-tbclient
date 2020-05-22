package com.baidu.spswitch.emotion.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.spswitch.emotion.b;
import com.baidu.spswitch.emotion.view.BDEmotionBagLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class EmotionClassicFragment extends EmotionBaseFragment {
    private BDEmotionBagLayout bGc;
    private List<String> bGd = new ArrayList();

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.bGc = new BDEmotionBagLayout(getContext());
        this.bGc.setLayoutParams(new ViewGroup.LayoutParams(-1, dip2px(getContext(), 260.0f)));
        initData();
        this.bGc.setEmotionList(this.bGd);
        return this.bGc;
    }

    private void initData() {
        this.bGd = b.aR(getContext()).Qp();
    }

    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
