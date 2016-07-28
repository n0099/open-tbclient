package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class w extends t {
    protected boolean adD;
    private CustomMessageListener adE;
    private CustomMessageListener adF;
    protected boolean isDone;

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.adE = new x(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.adF = new y(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void Q(boolean z) {
        this.adn.setBackgroundDrawable(null);
        super.Q(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
        super.P(z);
        this.isDone = false;
        if (!this.adD) {
            cT(TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void jr() {
        super.jr();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void cT(int i) {
        super.cT(i);
        if (this.adm != null && this.adn != null) {
            this.adD = false;
            if (!tU()) {
                this.ads = com.baidu.tbadk.core.util.am.tM().ct(i);
                if (this.ads != null) {
                    this.adD = true;
                } else {
                    this.ads = new AnimationDrawable();
                }
                this.adm.setBackgroundColor(com.baidu.tbadk.core.util.am.tM().cv(i));
                if (!this.adD) {
                    this.ads = com.baidu.tbadk.core.util.am.tM().cu(i);
                }
                this.ads.setOneShot(false);
                this.adn.setBackgroundDrawable(this.ads);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
        super.R(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(u.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.adE.setTag(tbPageContext.getUniqueId());
        this.adF.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.adE);
        tbPageContext.registerListener(this.adF);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.adE != null) {
            this.adE.setTag(bdUniqueId);
        }
        if (this.adF != null) {
            this.adF.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.adE);
        MessageManager.getInstance().unRegisterListener(this.adF);
    }
}
