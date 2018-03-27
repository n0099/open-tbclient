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
    private ImageView bbq;
    private TextView bbr;
    private TextView bbs;
    private RelativeLayout bbt;
    private ImageView bbu;
    private ImageView bbv;
    private ImageView bbw;
    private ImageView bbx;

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
        this.bbq = (ImageView) findViewById(d.g.red_dot);
        this.bbr = (TextView) findViewById(d.g.one_num_red_dot);
        this.bbs = (TextView) findViewById(d.g.two_num_red_dot);
        this.bbt = (RelativeLayout) findViewById(d.g.more_num_red_dot);
        this.bbu = (ImageView) findViewById(d.g.more_num_red_dot_bg);
        this.bbv = (ImageView) findViewById(d.g.more_num_white_dot_center);
        this.bbw = (ImageView) findViewById(d.g.more_num_white_dot_left);
        this.bbx = (ImageView) findViewById(d.g.more_num_white_dot_right);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.bbq != null) {
            aj.c(this.bbq, d.f.icon_news_red_dot);
        }
        if (this.bbr != null) {
            aj.e(this.bbr, d.C0141d.cp_cont_i, 1);
            aj.s(this.bbr, d.f.icon_news_red_dot_one_number);
        }
        if (this.bbs != null) {
            aj.e(this.bbs, d.C0141d.cp_cont_i, 1);
            aj.s(this.bbs, d.f.icon_news_red_dot_two_number);
        }
        if (this.bbu != null && this.bbv != null && this.bbw != null && this.bbx != null) {
            aj.c(this.bbu, d.f.icon_news_red_dot_two_number);
            aj.c(this.bbv, d.f.icon_news_white_dot);
            aj.c(this.bbw, d.f.icon_news_white_dot);
            aj.c(this.bbx, d.f.icon_news_white_dot);
        }
    }

    public void refresh(int i) {
        if (i <= 0) {
            this.bbq.setVisibility(0);
            this.bbr.setVisibility(8);
            this.bbs.setVisibility(8);
            this.bbt.setVisibility(8);
        } else if (i < 10) {
            this.bbr.setText(String.valueOf(i));
            this.bbq.setVisibility(8);
            this.bbr.setVisibility(0);
            this.bbs.setVisibility(8);
            this.bbt.setVisibility(8);
        } else if (i < 100) {
            this.bbs.setText(String.valueOf(i));
            this.bbq.setVisibility(8);
            this.bbr.setVisibility(8);
            this.bbs.setVisibility(0);
            this.bbt.setVisibility(8);
        } else {
            this.bbq.setVisibility(8);
            this.bbr.setVisibility(8);
            this.bbs.setVisibility(8);
            this.bbt.setVisibility(0);
        }
        onChangeSkinType();
    }
}
