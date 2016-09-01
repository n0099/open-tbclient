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
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class UserLikeButton extends TextView {
    private bg adL;
    private View.OnClickListener adM;
    private String ahY;
    private String ahZ;
    private a aia;
    private com.baidu.tbadk.coreExtra.d.a aib;
    private String aic;
    private BdUniqueId aid;
    private com.baidu.tbadk.c.a aie;
    private View.OnClickListener aif;
    private CustomMessageListener aig;
    private int es;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void dm(int i);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.aie = aVar;
    }

    public UserLikeButton(Context context) {
        super(context);
        this.ahY = TbadkCoreApplication.m9getInst().getString(t.j.relate_forum_is_followed);
        this.ahZ = TbadkCoreApplication.m9getInst().getString(t.j.forum_list_attention_tv);
        this.aic = "0";
        this.es = 1;
        this.aif = new aq(this);
        this.aig = new ar(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public UserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahY = TbadkCoreApplication.m9getInst().getString(t.j.relate_forum_is_followed);
        this.ahZ = TbadkCoreApplication.m9getInst().getString(t.j.forum_list_attention_tv);
        this.aic = "0";
        this.es = 1;
        this.aif = new aq(this);
        this.aig = new ar(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public void setAttentionFrom(String str) {
        this.aic = str;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.adM = onClickListener;
    }

    public void setFanNumCallBack(a aVar) {
        this.aia = aVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aid = bdUniqueId;
            this.aig.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aig);
        }
    }

    public void setData(bg bgVar) {
        this.adL = bgVar;
        aK(false);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bg bgVar = new bg();
            bgVar.setAuthor(metaData);
            setData(bgVar);
        }
    }

    public void setData(UserData userData) {
        if (userData != null) {
            bg bgVar = new bg();
            MetaData metaData = new MetaData();
            metaData.setUserName(userData.getUserName());
            metaData.setUserId(userData.getUserId());
            metaData.setPortrait(userData.getPortrait());
            metaData.setChecked(userData.isChecked());
            metaData.setHadConcerned(userData.hadConcerned());
            metaData.setConcern_num(userData.getConcern_num());
            metaData.setFansNickName(userData.getFansNickName());
            metaData.setFansNum(userData.getFansNum());
            metaData.setGender(userData.getGender());
            metaData.setIconInfo(userData.getIconInfo());
            metaData.setGodUserData(userData.getGodUserData());
            metaData.setIsLike(userData.getIsLike());
            bgVar.setAuthor(metaData);
            setData(bgVar);
        }
    }

    public void aK(boolean z) {
        if (this.adL != null && this.adL.getAuthor() != null) {
            if (this.es == 1) {
                if (this.adL.getAuthor().getGodUserData() != null) {
                    g(this.adL.getAuthor().getGodUserData().getFollowed() == 1, z);
                    return;
                }
                return;
            }
            g(this.adL.getAuthor().hadConcerned(), z);
        }
    }

    private void g(boolean z, boolean z2) {
        if (z) {
            if (z2 || aL(false)) {
                setClickable(false);
                setText(this.ahY);
                setColor(true);
                setPadding(0, 0, 0, 0);
            }
        } else if (z2 || aL(true)) {
            setClickable(true);
            setText(this.ahZ);
            setColor(false);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds10), 0);
        }
    }

    protected void setColor(boolean z) {
        if (z) {
            com.baidu.tbadk.core.util.av.j((View) this, t.d.cp_cont_d);
            setBackgroundDrawable(null);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        com.baidu.tbadk.core.util.av.j((View) this, t.d.btn_forum_focus_color);
        com.baidu.tbadk.core.util.av.k(this, t.f.btn_focus_border_bg);
        setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void ti() {
        if (this.adL != null && this.adL.getAuthor() != null) {
            if (this.es == 1) {
                if (this.adL.getAuthor().getGodUserData() != null) {
                    setColor(this.adL.getAuthor().getGodUserData().getFollowed() == 1);
                    return;
                }
                return;
            }
            setColor(this.adL.getAuthor().hadConcerned());
        }
    }

    private void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds28));
        setGravity(17);
        this.aib = new com.baidu.tbadk.coreExtra.d.a(null);
        setOnClickListener(this.aif);
    }

    private boolean aL(boolean z) {
        String a2 = com.baidu.adp.lib.util.j.a(getText(), "");
        if (StringUtils.isNull(a2)) {
            return true;
        }
        return z ? !this.ahZ.equals(a2) : !this.ahY.equals(a2);
    }

    public void setMode(int i) {
        if (this.es != i) {
            this.es = i;
            aK(false);
        }
    }
}
