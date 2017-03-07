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
public class ae extends ab {
    protected boolean alp;
    private CustomMessageListener alq;
    private CustomMessageListener alr;
    protected boolean isDone;

    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.alq = new af(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.alr = new ag(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.akZ.setBackgroundDrawable(null);
        super.T(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        super.S(z);
        this.isDone = false;
        if (!this.alp) {
            dh(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void lc() {
        super.lc();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.ab
    public void dh(int i) {
        super.dh(i);
        if (this.akY != null && this.akZ != null) {
            this.alp = false;
            if (!vu()) {
                this.ald = com.baidu.tbadk.core.util.ai.vm().cE(i);
                if (this.ald != null) {
                    this.alp = true;
                } else {
                    this.ald = new AnimationDrawable();
                }
                this.akY.setBackgroundColor(com.baidu.tbadk.core.util.ai.vm().cG(i));
                if (!this.alp) {
                    this.ald = com.baidu.tbadk.core.util.ai.vm().cF(i);
                }
                this.ald.setOneShot(false);
                this.akZ.setBackgroundDrawable(this.ald);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        super.U(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(w.f.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.alq.setTag(tbPageContext.getUniqueId());
        this.alr.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.alq);
        tbPageContext.registerListener(this.alr);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.alq != null) {
            this.alq.setTag(bdUniqueId);
        }
        if (this.alr != null) {
            this.alr.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.alq);
        MessageManager.getInstance().unRegisterListener(this.alr);
    }
}
