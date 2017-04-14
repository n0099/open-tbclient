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
    protected boolean alD;
    private CustomMessageListener alE;
    private CustomMessageListener alF;
    protected boolean isDone;

    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.alE = new af(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.alF = new ag(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.alo.setBackgroundDrawable(null);
        super.T(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        super.S(z);
        this.isDone = false;
        if (!this.alD) {
            dk(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void lg() {
        super.lg();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.ab
    public void dk(int i) {
        super.dk(i);
        if (this.aln != null && this.alo != null) {
            this.alD = false;
            if (!vR()) {
                this.als = com.baidu.tbadk.core.util.ai.vJ().cH(i);
                if (this.als != null) {
                    this.alD = true;
                } else {
                    this.als = new AnimationDrawable();
                }
                this.aln.setBackgroundColor(com.baidu.tbadk.core.util.ai.vJ().cJ(i));
                if (!this.alD) {
                    this.als = com.baidu.tbadk.core.util.ai.vJ().cI(i);
                }
                this.als.setOneShot(false);
                this.alo.setBackgroundDrawable(this.als);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        super.U(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(w.f.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.alE.setTag(tbPageContext.getUniqueId());
        this.alF.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.alE);
        tbPageContext.registerListener(this.alF);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.alE != null) {
            this.alE.setTag(bdUniqueId);
        }
        if (this.alF != null) {
            this.alF.setTag(bdUniqueId);
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.alE);
        MessageManager.getInstance().unRegisterListener(this.alF);
    }
}
