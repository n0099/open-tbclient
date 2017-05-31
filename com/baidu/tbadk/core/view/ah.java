package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ah extends ae {
    protected boolean alq;
    private CustomMessageListener alr;
    protected boolean isDone;
    private CustomMessageListener listener;

    public ah(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new ai(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.alr = new aj(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.ala.setBackgroundDrawable(null);
        super.T(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        super.S(z);
        this.isDone = false;
        if (!this.alq) {
            dj(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void lg() {
        super.lg();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void dj(int i) {
        super.dj(i);
        if (this.akZ != null && this.ala != null) {
            this.alq = false;
            if (!vb()) {
                this.ale = com.baidu.tbadk.core.util.ai.uT().cF(i);
                if (this.ale != null) {
                    this.alq = true;
                } else {
                    this.ale = new AnimationDrawable();
                }
                this.akZ.setBackgroundColor(com.baidu.tbadk.core.util.ai.uT().cH(i));
                if (!this.alq) {
                    this.ale = com.baidu.tbadk.core.util.ai.uT().cG(i);
                }
                this.ale.setOneShot(false);
                this.ala.setBackgroundDrawable(this.ale);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        super.U(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(w.f.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.alr.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.alr);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.alr != null) {
            this.alr.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.alr);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.alr);
    }
}
