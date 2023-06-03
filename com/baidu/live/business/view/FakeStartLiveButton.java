package com.baidu.live.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FakeStartLiveButton extends FrameLayout {
    public FakeStartLiveButton(Context context) {
        this(context, null);
    }

    public FakeStartLiveButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FakeStartLiveButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05b2, this);
    }
}
