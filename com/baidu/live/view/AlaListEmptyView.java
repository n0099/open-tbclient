package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaListEmptyView extends LinearLayout {
    private ImageView bTA;
    private TextView bTB;

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
        this.bTA = (ImageView) findViewById(a.f.ala_empty_view_img);
        this.bTB = (TextView) findViewById(a.f.ala_empty_view_text);
    }

    public void setParams(int i, int i2) {
        if (i <= 0) {
            this.bTA.setVisibility(8);
        } else {
            this.bTA.setVisibility(0);
            this.bTA.setImageResource(i);
        }
        if (i2 <= 0) {
            this.bTB.setVisibility(8);
            return;
        }
        this.bTB.setVisibility(0);
        this.bTB.setText(i2);
    }

    public void setImageRes(int i) {
        if (i <= 0) {
            this.bTA.setVisibility(8);
            return;
        }
        this.bTA.setVisibility(0);
        this.bTA.setImageResource(i);
    }
}
