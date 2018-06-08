package com.baidu.tbadk.core.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class MessageRedDotView extends FrameLayout {
    private ImageView auT;
    private TextView auU;
    private TextView auV;
    private TextView auW;
    private RelativeLayout auX;
    private ImageView auY;
    private ImageView auZ;
    private ImageView ava;
    private ImageView avb;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(d.i.message_red_dot_view, (ViewGroup) this, true);
        this.auT = (ImageView) findViewById(d.g.red_dot);
        this.auU = (TextView) findViewById(d.g.one_num_red_dot);
        this.auV = (TextView) findViewById(d.g.two_num_red_dot);
        this.auW = (TextView) findViewById(d.g.three_num_red_dot);
        this.auX = (RelativeLayout) findViewById(d.g.more_num_red_dot);
        this.auY = (ImageView) findViewById(d.g.more_num_red_dot_bg);
        this.auZ = (ImageView) findViewById(d.g.more_num_white_dot_center);
        this.ava = (ImageView) findViewById(d.g.more_num_white_dot_left);
        this.avb = (ImageView) findViewById(d.g.more_num_white_dot_right);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.auT != null) {
            al.c(this.auT, d.f.icon_news_red_dot);
        }
        if (this.auU != null) {
            al.c(this.auU, d.C0141d.cp_cont_i, 1);
            al.i(this.auU, d.f.icon_news_red_dot_one_number);
        }
        if (this.auV != null) {
            al.c(this.auV, d.C0141d.cp_cont_i, 1);
            al.i(this.auV, d.f.icon_news_red_dot_two_number);
        }
        if (this.auW != null) {
            al.c(this.auW, d.C0141d.cp_cont_i, 1);
            al.i(this.auW, d.f.icon_news_red_dot_three_number);
        }
        if (this.auY != null && this.auZ != null && this.ava != null && this.avb != null) {
            al.c(this.auY, d.f.icon_news_red_dot_two_number);
            al.c(this.auZ, d.f.icon_news_white_dot);
            al.c(this.ava, d.f.icon_news_white_dot);
            al.c(this.avb, d.f.icon_news_white_dot);
        }
    }

    public void refresh(int i) {
        if (i <= 0) {
            this.auT.setVisibility(0);
            this.auU.setVisibility(8);
            this.auV.setVisibility(8);
            this.auW.setVisibility(8);
            this.auX.setVisibility(8);
        } else if (i < 10) {
            this.auU.setText(String.valueOf(i));
            this.auT.setVisibility(8);
            this.auU.setVisibility(0);
            this.auV.setVisibility(8);
            this.auW.setVisibility(8);
            this.auX.setVisibility(8);
        } else if (i < 100) {
            this.auV.setText(String.valueOf(i));
            this.auT.setVisibility(8);
            this.auU.setVisibility(8);
            this.auV.setVisibility(0);
            this.auW.setVisibility(8);
            this.auX.setVisibility(8);
        } else {
            this.auT.setVisibility(8);
            this.auU.setVisibility(8);
            this.auV.setVisibility(8);
            if (this.mType == 1) {
                this.auX.setVisibility(0);
                this.auW.setVisibility(8);
            } else if (this.mType == 2) {
                this.auX.setVisibility(8);
                this.auW.setVisibility(0);
                this.auW.setText("99+");
            }
        }
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }
}
