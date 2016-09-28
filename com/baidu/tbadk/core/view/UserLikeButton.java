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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class UserLikeButton extends TextView {
    private bi adW;
    private View.OnClickListener adX;
    private String ahG;
    private String ahH;
    private a ahI;
    private com.baidu.tbadk.coreExtra.d.a ahJ;
    private String ahK;
    private BdUniqueId ahL;
    private com.baidu.tbadk.c.a ahM;
    private View.OnClickListener ahN;
    private CustomMessageListener ahO;
    private int es;
    private Context mContext;
    private String mForumId;

    /* loaded from: classes.dex */
    public interface a {
        void dm(int i);
    }

    public void setOnInterceptClickEventListener(com.baidu.tbadk.c.a aVar) {
        this.ahM = aVar;
    }

    public UserLikeButton(Context context) {
        super(context);
        this.ahG = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
        this.ahH = TbadkCoreApplication.m9getInst().getString(r.j.forum_list_attention_tv);
        this.ahK = "0";
        this.es = 1;
        this.ahN = new ao(this);
        this.ahO = new ap(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public UserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahG = TbadkCoreApplication.m9getInst().getString(r.j.relate_forum_is_followed);
        this.ahH = TbadkCoreApplication.m9getInst().getString(r.j.forum_list_attention_tv);
        this.ahK = "0";
        this.es = 1;
        this.ahN = new ao(this);
        this.ahO = new ap(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public void setAttentionFrom(String str) {
        this.ahK = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.adX = onClickListener;
    }

    public void setFanNumCallBack(a aVar) {
        this.ahI = aVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ahL = bdUniqueId;
            this.ahO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahO);
        }
    }

    public void setData(bi biVar) {
        a(biVar, false);
    }

    public void a(bi biVar, boolean z) {
        this.adW = biVar;
        if (z) {
            this.mForumId = new StringBuilder(String.valueOf(this.adW.getFid())).toString();
        }
        aK(false);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bi biVar = new bi();
            biVar.setAuthor(metaData);
            setData(biVar);
        }
    }

    public void setData(UserData userData) {
        if (userData != null) {
            bi biVar = new bi();
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
            biVar.setAuthor(metaData);
            setData(biVar);
        }
    }

    public void aK(boolean z) {
        if (this.adW != null && this.adW.getAuthor() != null) {
            if (this.es == 1) {
                if (this.adW.getAuthor().getGodUserData() != null) {
                    g(this.adW.getAuthor().getGodUserData().getFollowed() == 1, z);
                    return;
                }
                return;
            }
            g(this.adW.getAuthor().hadConcerned(), z);
        }
    }

    private void g(boolean z, boolean z2) {
        if (z) {
            if (z2 || aL(false)) {
                setClickable(false);
                setText(this.ahG);
                setColor(true);
                setPadding(0, 0, 0, 0);
            }
        } else if (z2 || aL(true)) {
            setClickable(true);
            setText(this.ahH);
            setColor(false);
            setPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds18), 0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10), 0);
        }
    }

    protected void setColor(boolean z) {
        if (z) {
            av.j((View) this, r.d.cp_cont_d);
            setBackgroundDrawable(null);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        av.j((View) this, r.d.btn_forum_focus_color);
        av.k(this, r.f.btn_focus_border_bg);
        setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void tx() {
        if (this.adW != null && this.adW.getAuthor() != null) {
            if (this.es == 1) {
                if (this.adW.getAuthor().getGodUserData() != null) {
                    setColor(this.adW.getAuthor().getGodUserData().getFollowed() == 1);
                    return;
                }
                return;
            }
            setColor(this.adW.getAuthor().hadConcerned());
        }
    }

    private void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds28));
        setGravity(17);
        this.ahJ = new com.baidu.tbadk.coreExtra.d.a(null);
        setOnClickListener(this.ahN);
    }

    private boolean aL(boolean z) {
        String a2 = com.baidu.adp.lib.util.j.a(getText(), "");
        if (StringUtils.isNull(a2)) {
            return true;
        }
        return z ? !this.ahH.equals(a2) : !this.ahG.equals(a2);
    }

    public void setMode(int i) {
        if (this.es != i) {
            this.es = i;
            aK(false);
        }
    }
}
