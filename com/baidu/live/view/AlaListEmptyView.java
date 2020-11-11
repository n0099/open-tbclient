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
/* loaded from: classes4.dex */
public class AlaListEmptyView extends LinearLayout {
    private ImageView bLo;
    private TextView bLp;

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
        LayoutInflater.from(getContext()).inflate(a.g.sdk_list_empty_view_layout, this);
        this.bLo = (ImageView) findViewById(a.f.ala_empty_view_img);
        this.bLp = (TextView) findViewById(a.f.ala_empty_view_text);
    }

    public void setParams(int i, int i2) {
        if (i <= 0) {
            this.bLo.setVisibility(8);
        } else {
            this.bLo.setVisibility(0);
            this.bLo.setImageResource(i);
        }
        if (i2 <= 0) {
            this.bLp.setVisibility(8);
            return;
        }
        this.bLp.setVisibility(0);
        this.bLp.setText(i2);
    }

    public void setImageRes(int i) {
        if (i <= 0) {
            this.bLo.setVisibility(8);
            return;
        }
        this.bLo.setVisibility(0);
        this.bLo.setImageResource(i);
    }
}
