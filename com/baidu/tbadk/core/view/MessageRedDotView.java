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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class MessageRedDotView extends FrameLayout {
    private ImageView amL;
    private TextView amM;
    private TextView amN;
    private TextView amO;
    private RelativeLayout amP;
    private ImageView amQ;
    private ImageView amR;
    private ImageView amS;
    private ImageView amT;
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
        this.amL = (ImageView) findViewById(d.g.red_dot);
        this.amM = (TextView) findViewById(d.g.one_num_red_dot);
        this.amN = (TextView) findViewById(d.g.two_num_red_dot);
        this.amO = (TextView) findViewById(d.g.three_num_red_dot);
        this.amP = (RelativeLayout) findViewById(d.g.more_num_red_dot);
        this.amQ = (ImageView) findViewById(d.g.more_num_red_dot_bg);
        this.amR = (ImageView) findViewById(d.g.more_num_white_dot_center);
        this.amS = (ImageView) findViewById(d.g.more_num_white_dot_left);
        this.amT = (ImageView) findViewById(d.g.more_num_white_dot_right);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.amL != null) {
            ak.c(this.amL, d.f.icon_news_red_dot);
        }
        if (this.amM != null) {
            ak.c(this.amM, d.C0126d.cp_cont_i, 1);
            ak.i(this.amM, d.f.icon_news_red_dot_one_number);
        }
        if (this.amN != null) {
            ak.c(this.amN, d.C0126d.cp_cont_i, 1);
            ak.i(this.amN, d.f.icon_news_red_dot_two_number);
        }
        if (this.amO != null) {
            ak.c(this.amO, d.C0126d.cp_cont_i, 1);
            ak.i(this.amO, d.f.icon_news_red_dot_three_number);
        }
        if (this.amQ != null && this.amR != null && this.amS != null && this.amT != null) {
            ak.c(this.amQ, d.f.icon_news_red_dot_two_number);
            ak.c(this.amR, d.f.icon_news_white_dot);
            ak.c(this.amS, d.f.icon_news_white_dot);
            ak.c(this.amT, d.f.icon_news_white_dot);
        }
    }

    public void refresh(int i) {
        if (i <= 0) {
            this.amL.setVisibility(0);
            this.amM.setVisibility(8);
            this.amN.setVisibility(8);
            this.amO.setVisibility(8);
            this.amP.setVisibility(8);
        } else if (i < 10) {
            this.amM.setText(String.valueOf(i));
            this.amL.setVisibility(8);
            this.amM.setVisibility(0);
            this.amN.setVisibility(8);
            this.amO.setVisibility(8);
            this.amP.setVisibility(8);
        } else if (i < 100) {
            this.amN.setText(String.valueOf(i));
            this.amL.setVisibility(8);
            this.amM.setVisibility(8);
            this.amN.setVisibility(0);
            this.amO.setVisibility(8);
            this.amP.setVisibility(8);
        } else {
            this.amL.setVisibility(8);
            this.amM.setVisibility(8);
            this.amN.setVisibility(8);
            if (this.mType == 1) {
                this.amP.setVisibility(0);
                this.amO.setVisibility(8);
            } else if (this.mType == 2) {
                this.amP.setVisibility(8);
                this.amO.setVisibility(0);
                this.amO.setText("99+");
            }
        }
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }
}
