package com.baidu.tbadk.core.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f<T> extends com.baidu.adp.base.f<T> {
    private final TbPageContext<T> adB;
    private final View adC;
    private final LinearLayout adD;
    private final TbImageView adE;
    private final Button adF;
    private final Button adG;
    private int mSkinType;
    private final TextView mTip;

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public int getSkinType() {
        return this.mSkinType;
    }

    public f(TbPageContext<T> tbPageContext, String str, String str2, int i) {
        super(tbPageContext);
        this.mSkinType = -1;
        this.adB = tbPageContext;
        this.adC = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.enter_forum_login, (ViewGroup) null);
        this.adD = (LinearLayout) this.adC;
        this.mTip = (TextView) this.adC.findViewById(i.f.tip);
        this.adE = (TbImageView) this.adC.findViewById(i.f.img_bg);
        this.adF = (Button) this.adC.findViewById(i.f.login_btn);
        if (str != null) {
            this.mTip.setText(str);
        }
        this.adF.setOnClickListener(new g(this, tbPageContext, i, str2));
        this.adG = (Button) this.adC.findViewById(i.f.reg_btn);
        this.adG.setOnClickListener(new h(this, tbPageContext));
        int dip2px = com.baidu.adp.lib.util.k.dip2px(tbPageContext.getContext(), 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.k.dip2px(tbPageContext.getContext(), 5.0f);
        this.adD.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.adB.getContext(), "home_login_show", "loginshow", 1, new Object[0]);
        return this.adC;
    }

    private boolean cC(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void onStop() {
        this.mSkinType = -1;
        this.adE.setBackgroundDrawable(null);
        this.adF.setBackgroundDrawable(null);
        this.adG.setBackgroundDrawable(null);
    }

    public void cD(int i) {
        if (cC(i)) {
            if (i == 1) {
                this.mTip.setTextColor(-11444363);
                this.adE.d(com.baidu.tbadk.util.b.EI().fD("pic_emotion01_1.png"), 10, false);
                this.adF.setTextColor(-5454368);
                this.adG.setTextColor(-9207399);
                return;
            }
            this.mTip.setTextColor(-5065030);
            this.adE.d(com.baidu.tbadk.util.b.EI().fD("pic_emotion01.png"), 10, false);
            this.adF.setTextColor(-1);
            this.adG.setTextColor(-14277082);
        }
    }
}
