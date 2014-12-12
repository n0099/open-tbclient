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
public class l<T> extends com.baidu.adp.base.g<T> {
    private final TbPageContext<T> Me;
    private final View Mf;
    private final LinearLayout Mg;
    private final TbImageView Mh;
    private Bitmap Mi;
    private final Button Mj;
    private final Button Mk;
    private int mSkinType;
    private final TextView mTip;

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    public l(TbPageContext<T> tbPageContext, String str, String str2, int i) {
        super(tbPageContext);
        this.Mi = null;
        this.mSkinType = -1;
        this.Me = tbPageContext;
        this.Mf = com.baidu.adp.lib.g.b.ek().inflate(tbPageContext.getContext(), com.baidu.tieba.x.enter_forum_login, null);
        this.Mg = (LinearLayout) this.Mf;
        this.mTip = (TextView) this.Mf.findViewById(com.baidu.tieba.w.tip);
        this.Mh = (TbImageView) this.Mf.findViewById(com.baidu.tieba.w.img_bg);
        this.Mj = (Button) this.Mf.findViewById(com.baidu.tieba.w.login_btn);
        if (str != null) {
            this.mTip.setText(str);
        }
        this.Mj.setOnClickListener(new m(this, tbPageContext, i, str2));
        this.Mk = (Button) this.Mf.findViewById(com.baidu.tieba.w.reg_btn);
        this.Mk.setOnClickListener(new n(this, tbPageContext));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(tbPageContext.getContext(), 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.l.dip2px(tbPageContext.getContext(), 5.0f);
        this.Mg.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.Me.getContext(), "home_login_show", "loginshow", 1, new Object[0]);
        return this.Mf;
    }

    private boolean cc(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void onStop() {
        this.mSkinType = -1;
        this.Mh.setBackgroundDrawable(null);
        this.Mj.setBackgroundDrawable(null);
        this.Mk.setBackgroundDrawable(null);
        if (this.Mi != null) {
            if (!this.Mi.isRecycled()) {
                this.Mi.recycle();
            }
            this.Mi = null;
        }
    }

    public void cd(int i) {
        if (cc(i)) {
            if (i == 1) {
                this.mTip.setTextColor(-11444363);
                this.Mh.d(com.baidu.tbadk.util.b.zx().eD("pic_emotion01_1.png"), 10, false);
                this.Mj.setTextColor(-5454368);
                this.Mk.setTextColor(-9207399);
                return;
            }
            this.mTip.setTextColor(-5065030);
            this.Mh.d(com.baidu.tbadk.util.b.zx().eD("pic_emotion01.png"), 10, false);
            this.Mj.setTextColor(-1);
            this.Mk.setTextColor(-14277082);
        }
    }
}
