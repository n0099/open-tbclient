package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class MessageRedDotView extends FrameLayout {
    private ImageView bbA;
    private TextView bbB;
    private TextView bbC;
    private RelativeLayout bbD;
    private ImageView bbE;
    private ImageView bbF;
    private ImageView bbG;
    private ImageView bbH;

    public MessageRedDotView(Context context) {
        super(context);
        initView();
    }

    public MessageRedDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MessageRedDotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public MessageRedDotView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(d.h.message_red_dot_view, (ViewGroup) this, true);
        this.bbA = (ImageView) findViewById(d.g.red_dot);
        this.bbB = (TextView) findViewById(d.g.one_num_red_dot);
        this.bbC = (TextView) findViewById(d.g.two_num_red_dot);
        this.bbD = (RelativeLayout) findViewById(d.g.more_num_red_dot);
        this.bbE = (ImageView) findViewById(d.g.more_num_red_dot_bg);
        this.bbF = (ImageView) findViewById(d.g.more_num_white_dot_center);
        this.bbG = (ImageView) findViewById(d.g.more_num_white_dot_left);
        this.bbH = (ImageView) findViewById(d.g.more_num_white_dot_right);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.bbA != null) {
            aj.c(this.bbA, d.f.icon_news_red_dot);
        }
        if (this.bbB != null) {
            aj.e(this.bbB, d.C0140d.cp_cont_i, 1);
            aj.s(this.bbB, d.f.icon_news_red_dot_one_number);
        }
        if (this.bbC != null) {
            aj.e(this.bbC, d.C0140d.cp_cont_i, 1);
            aj.s(this.bbC, d.f.icon_news_red_dot_two_number);
        }
        if (this.bbE != null && this.bbF != null && this.bbG != null && this.bbH != null) {
            aj.c(this.bbE, d.f.icon_news_red_dot_two_number);
            aj.c(this.bbF, d.f.icon_news_white_dot);
            aj.c(this.bbG, d.f.icon_news_white_dot);
            aj.c(this.bbH, d.f.icon_news_white_dot);
        }
    }

    public void refresh(int i) {
        if (i <= 0) {
            this.bbA.setVisibility(0);
            this.bbB.setVisibility(8);
            this.bbC.setVisibility(8);
            this.bbD.setVisibility(8);
        } else if (i < 10) {
            this.bbB.setText(String.valueOf(i));
            this.bbA.setVisibility(8);
            this.bbB.setVisibility(0);
            this.bbC.setVisibility(8);
            this.bbD.setVisibility(8);
        } else if (i < 100) {
            this.bbC.setText(String.valueOf(i));
            this.bbA.setVisibility(8);
            this.bbB.setVisibility(8);
            this.bbC.setVisibility(0);
            this.bbD.setVisibility(8);
        } else {
            this.bbA.setVisibility(8);
            this.bbB.setVisibility(8);
            this.bbC.setVisibility(8);
            this.bbD.setVisibility(0);
        }
        onChangeSkinType();
    }
}
