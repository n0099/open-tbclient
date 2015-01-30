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
    private final TbPageContext<T> MA;
    private final View MB;
    private final LinearLayout MC;
    private final TbImageView MD;
    private Bitmap ME;
    private final Button MF;
    private final Button MG;
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
        this.ME = null;
        this.mSkinType = -1;
        this.MA = tbPageContext;
        this.MB = com.baidu.adp.lib.g.b.ei().inflate(tbPageContext.getContext(), com.baidu.tieba.x.enter_forum_login, null);
        this.MC = (LinearLayout) this.MB;
        this.mTip = (TextView) this.MB.findViewById(com.baidu.tieba.w.tip);
        this.MD = (TbImageView) this.MB.findViewById(com.baidu.tieba.w.img_bg);
        this.MF = (Button) this.MB.findViewById(com.baidu.tieba.w.login_btn);
        if (str != null) {
            this.mTip.setText(str);
        }
        this.MF.setOnClickListener(new m(this, tbPageContext, i, str2));
        this.MG = (Button) this.MB.findViewById(com.baidu.tieba.w.reg_btn);
        this.MG.setOnClickListener(new n(this, tbPageContext));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(tbPageContext.getContext(), 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.l.dip2px(tbPageContext.getContext(), 5.0f);
        this.MC.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.MA.getContext(), "home_login_show", "loginshow", 1, new Object[0]);
        return this.MB;
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
        this.MD.setBackgroundDrawable(null);
        this.MF.setBackgroundDrawable(null);
        this.MG.setBackgroundDrawable(null);
        if (this.ME != null) {
            if (!this.ME.isRecycled()) {
                this.ME.recycle();
            }
            this.ME = null;
        }
    }

    public void ck(int i) {
        if (cj(i)) {
            if (i == 1) {
                this.mTip.setTextColor(-11444363);
                this.MD.d(com.baidu.tbadk.util.b.zO().eD("pic_emotion01_1.png"), 10, false);
                this.MF.setTextColor(-5454368);
                this.MG.setTextColor(-9207399);
                return;
            }
            this.mTip.setTextColor(-5065030);
            this.MD.d(com.baidu.tbadk.util.b.zO().eD("pic_emotion01.png"), 10, false);
            this.MF.setTextColor(-1);
            this.MG.setTextColor(-14277082);
        }
    }
}
