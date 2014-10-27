package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f {
    private final View Hj;
    private final LinearLayout Hk;
    private final TextView Hl;
    private final TbImageView Hm;
    private Bitmap Hn;
    private final Button Ho;
    private final Button Hp;
    private final Activity mActivity;
    private int mSkinType;

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    public d(Activity activity, String str, String str2, int i) {
        super(activity);
        this.Hn = null;
        this.mSkinType = -1;
        this.mActivity = activity;
        this.Hj = com.baidu.adp.lib.g.b.ek().inflate(activity, com.baidu.tieba.w.enter_forum_login, null);
        this.Hk = (LinearLayout) this.Hj;
        this.Hl = (TextView) this.Hj.findViewById(com.baidu.tieba.v.tip);
        this.Hm = (TbImageView) this.Hj.findViewById(com.baidu.tieba.v.img_bg);
        this.Ho = (Button) this.Hj.findViewById(com.baidu.tieba.v.login_btn);
        if (str != null) {
            this.Hl.setText(str);
        }
        this.Ho.setOnClickListener(new e(this, activity, i, str2));
        this.Hp = (Button) this.Hj.findViewById(com.baidu.tieba.v.reg_btn);
        this.Hp.setOnClickListener(new f(this, activity));
        int dip2px = com.baidu.adp.lib.util.m.dip2px(activity, 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.m.dip2px(activity, 5.0f);
        this.Hk.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.mActivity, "home_login_show", "loginshow", 1, new Object[0]);
        return this.Hj;
    }

    private boolean bF(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void onStop() {
        this.mSkinType = -1;
        this.Hm.setBackgroundDrawable(null);
        this.Ho.setBackgroundDrawable(null);
        this.Hp.setBackgroundDrawable(null);
        if (this.Hn != null) {
            if (!this.Hn.isRecycled()) {
                this.Hn.recycle();
            }
            this.Hn = null;
        }
    }

    public void bG(int i) {
        if (bF(i)) {
            if (i == 1) {
                this.Hl.setTextColor(-11444363);
                this.Hm.c(com.baidu.tbadk.util.b.uY().dO("pic_emotion01_1.png"), 10, false);
                this.Ho.setTextColor(-5454368);
                this.Hp.setTextColor(-9207399);
                return;
            }
            this.Hl.setTextColor(-5065030);
            this.Hm.c(com.baidu.tbadk.util.b.uY().dO("pic_emotion01.png"), 10, false);
            this.Ho.setTextColor(-1);
            this.Hp.setTextColor(-14277082);
        }
    }
}
