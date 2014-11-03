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
    private final View Hk;
    private final LinearLayout Hl;
    private final TextView Hm;
    private final TbImageView Hn;
    private Bitmap Ho;
    private final Button Hp;
    private final Button Hq;
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
        this.Ho = null;
        this.mSkinType = -1;
        this.mActivity = activity;
        this.Hk = com.baidu.adp.lib.g.b.ek().inflate(activity, com.baidu.tieba.w.enter_forum_login, null);
        this.Hl = (LinearLayout) this.Hk;
        this.Hm = (TextView) this.Hk.findViewById(com.baidu.tieba.v.tip);
        this.Hn = (TbImageView) this.Hk.findViewById(com.baidu.tieba.v.img_bg);
        this.Hp = (Button) this.Hk.findViewById(com.baidu.tieba.v.login_btn);
        if (str != null) {
            this.Hm.setText(str);
        }
        this.Hp.setOnClickListener(new e(this, activity, i, str2));
        this.Hq = (Button) this.Hk.findViewById(com.baidu.tieba.v.reg_btn);
        this.Hq.setOnClickListener(new f(this, activity));
        int dip2px = com.baidu.adp.lib.util.m.dip2px(activity, 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.m.dip2px(activity, 5.0f);
        this.Hl.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.mActivity, "home_login_show", "loginshow", 1, new Object[0]);
        return this.Hk;
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
        this.Hn.setBackgroundDrawable(null);
        this.Hp.setBackgroundDrawable(null);
        this.Hq.setBackgroundDrawable(null);
        if (this.Ho != null) {
            if (!this.Ho.isRecycled()) {
                this.Ho.recycle();
            }
            this.Ho = null;
        }
    }

    public void bG(int i) {
        if (bF(i)) {
            if (i == 1) {
                this.Hm.setTextColor(-11444363);
                this.Hn.c(com.baidu.tbadk.util.b.va().dO("pic_emotion01_1.png"), 10, false);
                this.Hp.setTextColor(-5454368);
                this.Hq.setTextColor(-9207399);
                return;
            }
            this.Hm.setTextColor(-5065030);
            this.Hn.c(com.baidu.tbadk.util.b.va().dO("pic_emotion01.png"), 10, false);
            this.Hp.setTextColor(-1);
            this.Hq.setTextColor(-14277082);
        }
    }
}
