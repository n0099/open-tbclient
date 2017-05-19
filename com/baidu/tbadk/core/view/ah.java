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
    protected boolean alA;
    private CustomMessageListener alB;
    protected boolean isDone;
    private CustomMessageListener listener;

    public ah(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new ai(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.alB = new aj(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.alk.setBackgroundDrawable(null);
        super.T(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        super.S(z);
        this.isDone = false;
        if (!this.alA) {
            di(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void lg() {
        super.lg();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void di(int i) {
        super.di(i);
        if (this.alj != null && this.alk != null) {
            this.alA = false;
            if (!ve()) {
                this.alp = com.baidu.tbadk.core.util.ai.uW().cE(i);
                if (this.alp != null) {
                    this.alA = true;
                } else {
                    this.alp = new AnimationDrawable();
                }
                this.alj.setBackgroundColor(com.baidu.tbadk.core.util.ai.uW().cG(i));
                if (!this.alA) {
                    this.alp = com.baidu.tbadk.core.util.ai.uW().cF(i);
                }
                this.alp.setOneShot(false);
                this.alk.setBackgroundDrawable(this.alp);
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
        this.alB.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.alB);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.alB != null) {
            this.alB.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.alB);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.alB);
    }
}
