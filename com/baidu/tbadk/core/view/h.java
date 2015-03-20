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
public class h<T> extends com.baidu.adp.base.g<T> {
    private final TbPageContext<T> XE;
    private final View XF;
    private final LinearLayout XG;
    private final TbImageView XH;
    private Bitmap XI;
    private final Button XJ;
    private final Button XK;
    private int mSkinType;
    private final TextView mTip;

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    public h(TbPageContext<T> tbPageContext, String str, String str2, int i) {
        super(tbPageContext);
        this.XI = null;
        this.mSkinType = -1;
        this.XE = tbPageContext;
        this.XF = com.baidu.adp.lib.g.b.hH().inflate(tbPageContext.getContext(), com.baidu.tieba.w.enter_forum_login, null);
        this.XG = (LinearLayout) this.XF;
        this.mTip = (TextView) this.XF.findViewById(com.baidu.tieba.v.tip);
        this.XH = (TbImageView) this.XF.findViewById(com.baidu.tieba.v.img_bg);
        this.XJ = (Button) this.XF.findViewById(com.baidu.tieba.v.login_btn);
        if (str != null) {
            this.mTip.setText(str);
        }
        this.XJ.setOnClickListener(new i(this, tbPageContext, i, str2));
        this.XK = (Button) this.XF.findViewById(com.baidu.tieba.v.reg_btn);
        this.XK.setOnClickListener(new j(this, tbPageContext));
        int dip2px = com.baidu.adp.lib.util.n.dip2px(tbPageContext.getContext(), 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.n.dip2px(tbPageContext.getContext(), 5.0f);
        this.XG.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.XE.getContext(), "home_login_show", "loginshow", 1, new Object[0]);
        return this.XF;
    }

    private boolean ck(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void onStop() {
        this.mSkinType = -1;
        this.XH.setBackgroundDrawable(null);
        this.XJ.setBackgroundDrawable(null);
        this.XK.setBackgroundDrawable(null);
        if (this.XI != null) {
            if (!this.XI.isRecycled()) {
                this.XI.recycle();
            }
            this.XI = null;
        }
    }

    public void cl(int i) {
        if (ck(i)) {
            if (i == 1) {
                this.mTip.setTextColor(-11444363);
                this.XH.c(com.baidu.tbadk.util.b.Dc().eF("pic_emotion01_1.png"), 10, false);
                this.XJ.setTextColor(-5454368);
                this.XK.setTextColor(-9207399);
                return;
            }
            this.mTip.setTextColor(-5065030);
            this.XH.c(com.baidu.tbadk.util.b.Dc().eF("pic_emotion01.png"), 10, false);
            this.XJ.setTextColor(-1);
            this.XK.setTextColor(-14277082);
        }
    }
}
