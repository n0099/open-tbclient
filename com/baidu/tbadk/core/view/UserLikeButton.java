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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class UserLikeButton extends TextView {
    private be abb;
    private View.OnClickListener abc;
    private String afd;
    private String afe;
    private a aff;
    private com.baidu.tbadk.coreExtra.d.a afg;
    private String afh;
    private BdUniqueId afi;
    private int afj;
    private View.OnClickListener afk;
    private CustomMessageListener afl;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void cY(int i);
    }

    public UserLikeButton(Context context) {
        super(context);
        this.afd = TbadkCoreApplication.m10getInst().getString(u.j.relate_forum_is_followed);
        this.afe = TbadkCoreApplication.m10getInst().getString(u.j.forum_list_attention_tv);
        this.afh = "0";
        this.afj = 1;
        this.afk = new ap(this);
        this.afl = new aq(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public UserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afd = TbadkCoreApplication.m10getInst().getString(u.j.relate_forum_is_followed);
        this.afe = TbadkCoreApplication.m10getInst().getString(u.j.forum_list_attention_tv);
        this.afh = "0";
        this.afj = 1;
        this.afk = new ap(this);
        this.afl = new aq(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
        this.mContext = context;
        init();
    }

    public void setAttentionFrom(String str) {
        this.afh = str;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.abc = onClickListener;
    }

    public void setFanNumCallBack(a aVar) {
        this.aff = aVar;
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.afi = bdUniqueId;
            this.afl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.afl);
        }
    }

    public void setData(be beVar) {
        this.abb = beVar;
        aJ(false);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            be beVar = new be();
            beVar.setAuthor(metaData);
            setData(beVar);
        }
    }

    public void aJ(boolean z) {
        if (this.abb != null && this.abb.getAuthor() != null) {
            if (this.afj == 1) {
                if (this.abb.getAuthor().getGodUserData() != null) {
                    e(this.abb.getAuthor().getGodUserData().getFollowed() == 1, z);
                    return;
                }
                return;
            }
            e(this.abb.getAuthor().hadConcerned(), z);
        }
    }

    private void e(boolean z, boolean z2) {
        if (z) {
            if (z2 || aK(false)) {
                setClickable(false);
                setText(this.afd);
                setColor(true);
                setPadding(0, 0, 0, 0);
            }
        } else if (z2 || aK(true)) {
            setClickable(true);
            setText(this.afe);
            setColor(false);
            setPadding(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds18), 0, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds10), 0);
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

    public void sd() {
        if (this.abb != null && this.abb.getAuthor() != null) {
            if (this.afj == 1) {
                if (this.abb.getAuthor().getGodUserData() != null) {
                    setColor(this.abb.getAuthor().getGodUserData().getFollowed() == 1);
                    return;
                }
                return;
            }
            setColor(this.abb.getAuthor().hadConcerned());
        }
    }

    private void init() {
        setSingleLine();
        setIncludeFontPadding(false);
        setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds28));
        setGravity(17);
        this.afg = new com.baidu.tbadk.coreExtra.d.a(null);
        setOnClickListener(this.afk);
    }

    private boolean aK(boolean z) {
        String a2 = com.baidu.adp.lib.util.j.a(getText(), "");
        if (StringUtils.isNull(a2)) {
            return true;
        }
        return z ? !this.afe.equals(a2) : !this.afd.equals(a2);
    }

    public void setMode(int i) {
        if (this.afj != i) {
            this.afj = i;
            aJ(false);
        }
    }
}
