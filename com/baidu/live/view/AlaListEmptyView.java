package com.baidu.live.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class AlaListEmptyView extends LinearLayout {
    private ImageView azW;
    private TextView azX;

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
        this.azW = (ImageView) findViewById(a.g.ala_empty_view_img);
        this.azX = (TextView) findViewById(a.g.ala_empty_view_text);
    }

    public void setParams(int i, int i2) {
        if (i <= 0) {
            this.azW.setVisibility(8);
        } else {
            this.azW.setVisibility(0);
            this.azW.setImageResource(i);
        }
        if (i2 <= 0) {
            this.azX.setVisibility(8);
            return;
        }
        this.azX.setVisibility(0);
        this.azX.setText(i2);
    }

    public void setImageRes(int i) {
        if (i <= 0) {
            this.azW.setVisibility(8);
            return;
        }
        this.azW.setVisibility(0);
        this.azW.setImageResource(i);
    }
}
