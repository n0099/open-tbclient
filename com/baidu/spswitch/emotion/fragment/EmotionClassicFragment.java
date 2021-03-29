package com.baidu.spswitch.emotion.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EmotionClassicFragment extends EmotionBaseFragment {
    public static final int EXPRESSION_LAYOUT_HEIGHT = 260;
    public List<String> mBagList = new ArrayList();
    public BDEmotionBagVerticalLayout mEmotionBagLayout;

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void initData() {
        this.mBagList = EmotionUtils.getInstance().getPanelEmotionList();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mEmotionBagLayout = new BDEmotionBagVerticalLayout(getContext());
        this.mEmotionBagLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, dip2px(getContext(), 260.0f)));
        initData();
        this.mEmotionBagLayout.setEmotionList(this.mBagList);
        return this.mEmotionBagLayout;
    }
}
