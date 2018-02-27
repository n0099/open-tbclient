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
    private ImageView bbo;
    private TextView bbp;
    private TextView bbq;
    private RelativeLayout bbr;
    private ImageView bbs;
    private ImageView bbt;
    private ImageView bbu;
    private ImageView bbv;

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
        this.bbo = (ImageView) findViewById(d.g.red_dot);
        this.bbp = (TextView) findViewById(d.g.one_num_red_dot);
        this.bbq = (TextView) findViewById(d.g.two_num_red_dot);
        this.bbr = (RelativeLayout) findViewById(d.g.more_num_red_dot);
        this.bbs = (ImageView) findViewById(d.g.more_num_red_dot_bg);
        this.bbt = (ImageView) findViewById(d.g.more_num_white_dot_center);
        this.bbu = (ImageView) findViewById(d.g.more_num_white_dot_left);
        this.bbv = (ImageView) findViewById(d.g.more_num_white_dot_right);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.bbo != null) {
            aj.c(this.bbo, d.f.icon_news_red_dot);
        }
        if (this.bbp != null) {
            aj.e(this.bbp, d.C0141d.cp_cont_i, 1);
            aj.s(this.bbp, d.f.icon_news_red_dot_one_number);
        }
        if (this.bbq != null) {
            aj.e(this.bbq, d.C0141d.cp_cont_i, 1);
            aj.s(this.bbq, d.f.icon_news_red_dot_two_number);
        }
        if (this.bbs != null && this.bbt != null && this.bbu != null && this.bbv != null) {
            aj.c(this.bbs, d.f.icon_news_red_dot_two_number);
            aj.c(this.bbt, d.f.icon_news_white_dot);
            aj.c(this.bbu, d.f.icon_news_white_dot);
            aj.c(this.bbv, d.f.icon_news_white_dot);
        }
    }

    public void refresh(int i) {
        if (i <= 0) {
            this.bbo.setVisibility(0);
            this.bbp.setVisibility(8);
            this.bbq.setVisibility(8);
            this.bbr.setVisibility(8);
        } else if (i < 10) {
            this.bbp.setText(String.valueOf(i));
            this.bbo.setVisibility(8);
            this.bbp.setVisibility(0);
            this.bbq.setVisibility(8);
            this.bbr.setVisibility(8);
        } else if (i < 100) {
            this.bbq.setText(String.valueOf(i));
            this.bbo.setVisibility(8);
            this.bbp.setVisibility(8);
            this.bbq.setVisibility(0);
            this.bbr.setVisibility(8);
        } else {
            this.bbo.setVisibility(8);
            this.bbp.setVisibility(8);
            this.bbq.setVisibility(8);
            this.bbr.setVisibility(0);
        }
        onChangeSkinType();
    }
}
