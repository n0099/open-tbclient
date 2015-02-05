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
    private final TbImageView MA;
    private Bitmap MB;
    private final Button MC;
    private final Button MD;
    private final TbPageContext<T> Mx;
    private final View My;
    private final LinearLayout Mz;
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
        this.MB = null;
        this.mSkinType = -1;
        this.Mx = tbPageContext;
        this.My = com.baidu.adp.lib.g.b.ei().inflate(tbPageContext.getContext(), com.baidu.tieba.x.enter_forum_login, null);
        this.Mz = (LinearLayout) this.My;
        this.mTip = (TextView) this.My.findViewById(com.baidu.tieba.w.tip);
        this.MA = (TbImageView) this.My.findViewById(com.baidu.tieba.w.img_bg);
        this.MC = (Button) this.My.findViewById(com.baidu.tieba.w.login_btn);
        if (str != null) {
            this.mTip.setText(str);
        }
        this.MC.setOnClickListener(new m(this, tbPageContext, i, str2));
        this.MD = (Button) this.My.findViewById(com.baidu.tieba.w.reg_btn);
        this.MD.setOnClickListener(new n(this, tbPageContext));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(tbPageContext.getContext(), 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.l.dip2px(tbPageContext.getContext(), 5.0f);
        this.Mz.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.Mx.getContext(), "home_login_show", "loginshow", 1, new Object[0]);
        return this.My;
    }

    private boolean cj(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void onStop() {
        this.mSkinType = -1;
        this.MA.setBackgroundDrawable(null);
        this.MC.setBackgroundDrawable(null);
        this.MD.setBackgroundDrawable(null);
        if (this.MB != null) {
            if (!this.MB.isRecycled()) {
                this.MB.recycle();
            }
            this.MB = null;
        }
    }

    public void ck(int i) {
        if (cj(i)) {
            if (i == 1) {
                this.mTip.setTextColor(-11444363);
                this.MA.d(com.baidu.tbadk.util.b.zI().eA("pic_emotion01_1.png"), 10, false);
                this.MC.setTextColor(-5454368);
                this.MD.setTextColor(-9207399);
                return;
            }
            this.mTip.setTextColor(-5065030);
            this.MA.d(com.baidu.tbadk.util.b.zI().eA("pic_emotion01.png"), 10, false);
            this.MC.setTextColor(-1);
            this.MD.setTextColor(-14277082);
        }
    }
}
