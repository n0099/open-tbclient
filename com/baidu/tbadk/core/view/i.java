package com.baidu.tbadk.core.view;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class i<T> extends com.baidu.adp.base.g<T> {
    private final TbPageContext<T> Yt;
    private final View Yu;
    private final LinearLayout Yv;
    private final TbImageView Yw;
    private Bitmap Yx;
    private final Button Yy;
    private final Button Yz;
    private int mSkinType;
    private final TextView mTip;

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    public i(TbPageContext<T> tbPageContext, String str, String str2, int i) {
        super(tbPageContext);
        this.Yx = null;
        this.mSkinType = -1;
        this.Yt = tbPageContext;
        this.Yu = com.baidu.adp.lib.g.b.hr().inflate(tbPageContext.getContext(), com.baidu.tieba.r.enter_forum_login, null);
        this.Yv = (LinearLayout) this.Yu;
        this.mTip = (TextView) this.Yu.findViewById(com.baidu.tieba.q.tip);
        this.Yw = (TbImageView) this.Yu.findViewById(com.baidu.tieba.q.img_bg);
        this.Yy = (Button) this.Yu.findViewById(com.baidu.tieba.q.login_btn);
        if (str != null) {
            this.mTip.setText(str);
        }
        this.Yy.setOnClickListener(new j(this, tbPageContext, i, str2));
        this.Yz = (Button) this.Yu.findViewById(com.baidu.tieba.q.reg_btn);
        this.Yz.setOnClickListener(new k(this, tbPageContext));
        int dip2px = com.baidu.adp.lib.util.n.dip2px(tbPageContext.getContext(), 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.n.dip2px(tbPageContext.getContext(), 5.0f);
        this.Yv.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.Yt.getContext(), "home_login_show", "loginshow", 1, new Object[0]);
        return this.Yu;
    }

    private boolean co(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void onStop() {
        this.mSkinType = -1;
        this.Yw.setBackgroundDrawable(null);
        this.Yy.setBackgroundDrawable(null);
        this.Yz.setBackgroundDrawable(null);
        if (this.Yx != null) {
            if (!this.Yx.isRecycled()) {
                this.Yx.recycle();
            }
            this.Yx = null;
        }
    }

    public void cp(int i) {
        if (co(i)) {
            if (i == 1) {
                this.mTip.setTextColor(-11444363);
                this.Yw.c(com.baidu.tbadk.util.b.DT().fd("pic_emotion01_1.png"), 10, false);
                this.Yy.setTextColor(-5454368);
                this.Yz.setTextColor(-9207399);
                return;
            }
            this.mTip.setTextColor(-5065030);
            this.Yw.c(com.baidu.tbadk.util.b.DT().fd("pic_emotion01.png"), 10, false);
            this.Yy.setTextColor(-1);
            this.Yz.setTextColor(-14277082);
        }
    }
}
