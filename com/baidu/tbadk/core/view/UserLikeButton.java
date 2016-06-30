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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class UserLikeButton extends TextView {
    private az aas;
    private View.OnClickListener aat;
    private String aep;
    private String aeq;
    private a aer;
    private com.baidu.tbadk.coreExtra.d.a aes;
    private String aet;
    private BdUniqueId aeu;
    private int aev;
    private View.OnClickListener aew;
    private CustomMessageListener aex;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void cY(int i);
    }

    public UserLikeButton(Context context) {
        super(context);
        this.aep = TbadkCoreApplication.m9getInst().getString(u.j.relate_forum_is_followed);
        this.aeq = TbadkCoreApplication.m9getInst().getString(u.j.forum_list_attention_tv);
        this.aet = "0";
        this.aev = 1;
        this.aew = new ap(this);
        this.aex = new aq(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public UserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aep = TbadkCoreApplication.m9getInst().getString(u.j.relate_forum_is_followed);
        this.aeq = TbadkCoreApplication.m9getInst().getString(u.j.forum_list_attention_tv);
        this.aet = "0";
        this.aev = 1;
        this.aew = new ap(this);
        this.aex = new aq(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public void setAttentionFrom(String str) {
        this.aet = str;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aat = onClickListener;
    }

    public void setFanNumCallBack(a aVar) {
        this.aer = aVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aeu = bdUniqueId;
            this.aex.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aex);
        }
    }

    public void setData(az azVar) {
        this.aas = azVar;
        aG(false);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            az azVar = new az();
            azVar.setAuthor(metaData);
            setData(azVar);
        }
    }

    public void aG(boolean z) {
        if (this.aas != null && this.aas.getAuthor() != null) {
            if (this.aev == 1) {
                if (this.aas.getAuthor().getGodUserData() != null) {
                    e(this.aas.getAuthor().getGodUserData().getFollowed() == 1, z);
                    return;
                }
                return;
            }
            e(this.aas.getAuthor().hadConcerned(), z);
        }
    }

    private void e(boolean z, boolean z2) {
        if (z) {
            if (z2 || aH(false)) {
                setClickable(false);
                setText(this.aep);
                setColor(true);
                setPadding(0, 0, 0, 0);
            }
        } else if (z2 || aH(true)) {
            setClickable(true);
            setText(this.aeq);
            setColor(false);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds10), 0);
        }
    }

    protected void setColor(boolean z) {
        if (z) {
            av.j((View) this, u.d.cp_cont_d);
            setBackgroundDrawable(null);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        av.j((View) this, u.d.btn_forum_focus_color);
        av.k(this, u.f.btn_focus_border_bg);
        setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds28));
        setGravity(17);
        this.aes = new com.baidu.tbadk.coreExtra.d.a(null);
        setOnClickListener(this.aew);
    }

    private boolean aH(boolean z) {
        String a2 = com.baidu.adp.lib.util.j.a(getText(), "");
        if (StringUtils.isNull(a2)) {
            return true;
        }
        return z ? !this.aeq.equals(a2) : !this.aep.equals(a2);
    }

    public void setMode(int i) {
        if (this.aev != i) {
            this.aev = i;
            aG(false);
        }
    }
}
