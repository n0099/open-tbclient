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
    private final TbPageContext<T> XG;
    private final View XH;
    private final LinearLayout XI;
    private final TbImageView XJ;
    private Bitmap XK;
    private final Button XL;
    private final Button XM;
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
        this.XK = null;
        this.mSkinType = -1;
        this.XG = tbPageContext;
        this.XH = com.baidu.adp.lib.g.b.hH().inflate(tbPageContext.getContext(), com.baidu.tieba.w.enter_forum_login, null);
        this.XI = (LinearLayout) this.XH;
        this.mTip = (TextView) this.XH.findViewById(com.baidu.tieba.v.tip);
        this.XJ = (TbImageView) this.XH.findViewById(com.baidu.tieba.v.img_bg);
        this.XL = (Button) this.XH.findViewById(com.baidu.tieba.v.login_btn);
        if (str != null) {
            this.mTip.setText(str);
        }
        this.XL.setOnClickListener(new i(this, tbPageContext, i, str2));
        this.XM = (Button) this.XH.findViewById(com.baidu.tieba.v.reg_btn);
        this.XM.setOnClickListener(new j(this, tbPageContext));
        int dip2px = com.baidu.adp.lib.util.n.dip2px(tbPageContext.getContext(), 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.n.dip2px(tbPageContext.getContext(), 5.0f);
        this.XI.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.XG.getContext(), "home_login_show", "loginshow", 1, new Object[0]);
        return this.XH;
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
        this.XJ.setBackgroundDrawable(null);
        this.XL.setBackgroundDrawable(null);
        this.XM.setBackgroundDrawable(null);
        if (this.XK != null) {
            if (!this.XK.isRecycled()) {
                this.XK.recycle();
            }
            this.XK = null;
        }
    }

    public void cl(int i) {
        if (ck(i)) {
            if (i == 1) {
                this.mTip.setTextColor(-11444363);
                this.XJ.c(com.baidu.tbadk.util.b.Di().eI("pic_emotion01_1.png"), 10, false);
                this.XL.setTextColor(-5454368);
                this.XM.setTextColor(-9207399);
                return;
            }
            this.mTip.setTextColor(-5065030);
            this.XJ.c(com.baidu.tbadk.util.b.Di().eI("pic_emotion01.png"), 10, false);
            this.XL.setTextColor(-1);
            this.XM.setTextColor(-14277082);
        }
    }
}
