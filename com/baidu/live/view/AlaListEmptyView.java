package com.baidu.live.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class AlaListEmptyView extends LinearLayout {
    private ImageView bsT;
    private TextView bsU;

    public AlaListEmptyView(@NonNull Context context) {
        super(context);
        initView();
    }

    public AlaListEmptyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AlaListEmptyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.sdk_list_empty_view_layout, this);
        this.bsT = (ImageView) findViewById(a.g.ala_empty_view_img);
        this.bsU = (TextView) findViewById(a.g.ala_empty_view_text);
    }

    public void setParams(int i, int i2) {
        if (i <= 0) {
            this.bsT.setVisibility(8);
        } else {
            this.bsT.setVisibility(0);
            this.bsT.setImageResource(i);
        }
        if (i2 <= 0) {
            this.bsU.setVisibility(8);
            return;
        }
        this.bsU.setVisibility(0);
        this.bsU.setText(i2);
    }

    public void setImageRes(int i) {
        if (i <= 0) {
            this.bsT.setVisibility(8);
            return;
        }
        this.bsT.setVisibility(0);
        this.bsT.setImageResource(i);
    }
}
