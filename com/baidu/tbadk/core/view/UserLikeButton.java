package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class UserLikeButton extends TextView {
    private View.OnClickListener Fn;
    private ax aab;
    private View.OnClickListener aac;
    private String adR;
    private String adS;
    private a adT;
    private com.baidu.tbadk.coreExtra.d.a adU;
    private String adV;
    private CustomMessageListener adW;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void cW(int i);
    }

    public UserLikeButton(Context context) {
        super(context);
        this.adR = TbadkCoreApplication.m11getInst().getString(t.j.relate_forum_is_followed);
        this.adS = TbadkCoreApplication.m11getInst().getString(t.j.forum_list_attention_tv);
        this.adV = "0";
        this.Fn = new ap(this);
        this.adW = new aq(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public UserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adR = TbadkCoreApplication.m11getInst().getString(t.j.relate_forum_is_followed);
        this.adS = TbadkCoreApplication.m11getInst().getString(t.j.forum_list_attention_tv);
        this.adV = "0";
        this.Fn = new ap(this);
        this.adW = new aq(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public void setAttentionFrom(String str) {
        this.adV = str;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aac = onClickListener;
    }

    public void setFanNumCallBack(a aVar) {
        this.adT = aVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.adW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.adW);
        }
    }

    public void setData(ax axVar) {
        this.aab = axVar;
        aI(false);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            ax axVar = new ax();
            axVar.setAuthor(metaData);
            setData(axVar);
        }
    }

    public void aI(boolean z) {
        if (this.aab != null && this.aab.getAuthor() != null && this.aab.getAuthor().getGodUserData() != null) {
            if (this.aab.getAuthor().getGodUserData().getFollowed() == 1) {
                if (z || aJ(false)) {
                    setClickable(false);
                    setText(this.adR);
                    com.baidu.tbadk.core.util.at.j((View) this, t.d.cp_cont_d);
                    setBackgroundDrawable(null);
                    setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    setPadding(0, 0, 0, 0);
                }
            } else if (z || aJ(true)) {
                setClickable(true);
                setText(this.adS);
                com.baidu.tbadk.core.util.at.j((View) this, t.d.btn_forum_focus_color);
                com.baidu.tbadk.core.util.at.k(this, t.f.btn_focus_border_bg);
                setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
                setPadding(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
            }
        }
    }

    private void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds28));
        setGravity(17);
        this.adU = new com.baidu.tbadk.coreExtra.d.a(null);
        setOnClickListener(this.Fn);
    }

    private boolean aJ(boolean z) {
        String a2 = com.baidu.adp.lib.util.j.a(getText(), "");
        if (StringUtils.isNull(a2)) {
            return true;
        }
        return z ? !this.adS.equals(a2) : !this.adR.equals(a2);
    }
}
