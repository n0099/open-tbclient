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
    private final TbPageContext<T> adr;
    private final View ads;
    private final LinearLayout adt;
    private final TbImageView adu;
    private final Button adv;
    private final Button adw;
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
        this.adr = tbPageContext;
        this.ads = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.enter_forum_login, (ViewGroup) null);
        this.adt = (LinearLayout) this.ads;
        this.mTip = (TextView) this.ads.findViewById(i.f.tip);
        this.adu = (TbImageView) this.ads.findViewById(i.f.img_bg);
        this.adv = (Button) this.ads.findViewById(i.f.login_btn);
        if (str != null) {
            this.mTip.setText(str);
        }
        this.adv.setOnClickListener(new g(this, tbPageContext, i, str2));
        this.adw = (Button) this.ads.findViewById(i.f.reg_btn);
        this.adw.setOnClickListener(new h(this, tbPageContext));
        int dip2px = com.baidu.adp.lib.util.k.dip2px(tbPageContext.getContext(), 7.0f);
        int dip2px2 = com.baidu.adp.lib.util.k.dip2px(tbPageContext.getContext(), 5.0f);
        this.adt.setPadding(dip2px, dip2px2, dip2px, dip2px2);
    }

    public View getView() {
        TiebaStatic.eventStat(this.adr.getContext(), "home_login_show", "loginshow", 1, new Object[0]);
        return this.ads;
    }

    private boolean cw(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void onStop() {
        this.mSkinType = -1;
        this.adu.setBackgroundDrawable(null);
        this.adv.setBackgroundDrawable(null);
        this.adw.setBackgroundDrawable(null);
    }

    public void cx(int i) {
        if (cw(i)) {
            if (i == 1) {
                this.mTip.setTextColor(-11444363);
                this.adu.d(com.baidu.tbadk.util.b.Ey().fv("pic_emotion01_1.png"), 10, false);
                this.adv.setTextColor(-5454368);
                this.adw.setTextColor(-9207399);
                return;
            }
            this.mTip.setTextColor(-5065030);
            this.adu.d(com.baidu.tbadk.util.b.Ey().fv("pic_emotion01.png"), 10, false);
            this.adv.setTextColor(-1);
            this.adw.setTextColor(-14277082);
        }
    }
}
