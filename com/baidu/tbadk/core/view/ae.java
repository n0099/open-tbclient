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
    protected boolean alE;
    private CustomMessageListener alF;
    protected boolean isDone;
    private CustomMessageListener listener;

    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new af(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.alF = new ag(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.alp.setBackgroundDrawable(null);
        super.T(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        super.S(z);
        this.isDone = false;
        if (!this.alE) {
            dk(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void lh() {
        super.lh();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.ab
    public void dk(int i) {
        super.dk(i);
        if (this.alo != null && this.alp != null) {
            this.alE = false;
            if (!vR()) {
                this.alt = com.baidu.tbadk.core.util.ai.vJ().cH(i);
                if (this.alt != null) {
                    this.alE = true;
                } else {
                    this.alt = new AnimationDrawable();
                }
                this.alo.setBackgroundColor(com.baidu.tbadk.core.util.ai.vJ().cJ(i));
                if (!this.alE) {
                    this.alt = com.baidu.tbadk.core.util.ai.vJ().cI(i);
                }
                this.alt.setOneShot(false);
                this.alp.setBackgroundDrawable(this.alt);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        super.U(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(w.f.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.alF.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.alF);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.alF != null) {
            this.alF.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.alF);
    }
}
