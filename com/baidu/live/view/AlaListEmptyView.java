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
    private ImageView bsQ;
    private TextView bsR;

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
        this.bsQ = (ImageView) findViewById(a.g.ala_empty_view_img);
        this.bsR = (TextView) findViewById(a.g.ala_empty_view_text);
    }

    public void setParams(int i, int i2) {
        if (i <= 0) {
            this.bsQ.setVisibility(8);
        } else {
            this.bsQ.setVisibility(0);
            this.bsQ.setImageResource(i);
        }
        if (i2 <= 0) {
            this.bsR.setVisibility(8);
            return;
        }
        this.bsR.setVisibility(0);
        this.bsR.setText(i2);
    }

    public void setImageRes(int i) {
        if (i <= 0) {
            this.bsQ.setVisibility(8);
            return;
        }
        this.bsQ.setVisibility(0);
        this.bsQ.setImageResource(i);
    }
}
