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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class UserLikeButton extends TextView {
    private View.OnClickListener OZ;
    private com.baidu.tbadk.core.data.as aeC;
    private View.OnClickListener aeD;
    private String ahV;
    private String ahW;
    private a ahX;
    private com.baidu.tbadk.coreExtra.d.a ahY;
    private CustomMessageListener ahZ;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void dp(int i);
    }

    public UserLikeButton(Context context) {
        super(context);
        this.ahV = TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed);
        this.ahW = TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv);
        this.OZ = new an(this);
        this.ahZ = new ao(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public UserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahV = TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed);
        this.ahW = TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv);
        this.OZ = new an(this);
        this.ahZ = new ao(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aeD = onClickListener;
    }

    public void setFanNumCallBack(a aVar) {
        this.ahX = aVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ahZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahZ);
        }
    }

    public void setData(com.baidu.tbadk.core.data.as asVar) {
        this.aeC = asVar;
        aD(false);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
            asVar.setAuthor(metaData);
            setData(asVar);
        }
    }

    public void aD(boolean z) {
        if (this.aeC != null && this.aeC.getAuthor() != null && this.aeC.getAuthor().getGodUserData() != null) {
            if (this.aeC.getAuthor().getGodUserData().getFollowed() == 1) {
                if (z || aE(false)) {
                    setClickable(false);
                    setText(this.ahV);
                    at.j((View) this, t.d.cp_cont_d);
                    setBackgroundDrawable(null);
                    setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    setPadding(0, 0, 0, 0);
                }
            } else if (z || aE(true)) {
                setClickable(true);
                setText(this.ahW);
                at.j((View) this, t.d.btn_forum_focus_color);
                at.k(this, t.f.btn_focus_border_bg);
                setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
                setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
            }
        }
    }

    private void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds28));
        setGravity(17);
        this.ahY = new com.baidu.tbadk.coreExtra.d.a(null);
        setOnClickListener(this.OZ);
    }

    private boolean aE(boolean z) {
        String a2 = com.baidu.adp.lib.util.j.a(getText(), "");
        if (StringUtils.isNull(a2)) {
            return true;
        }
        return z ? !this.ahW.equals(a2) : !this.ahV.equals(a2);
    }
}
