package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.af;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends g {
    protected boolean amD;
    private CustomMessageListener amE;
    private CustomMessageListener amF;
    protected boolean isDone;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.amE = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (h.this.isDone) {
                    h.this.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.amF = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.amn.setBackgroundColor(af.vb().cM(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        this.amo.setBackgroundDrawable(null);
        super.V(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        super.U(z);
        this.isDone = false;
        if (!this.amD) {
            dz(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void lf() {
        super.lf();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.g
    public void dz(int i) {
        super.dz(i);
        if (this.amn != null && this.amo != null) {
            this.amD = false;
            if (!vj()) {
                this.ams = af.vb().cK(i);
                if (this.ams != null) {
                    this.amD = true;
                } else {
                    this.ams = new AnimationDrawable();
                }
                this.amn.setBackgroundColor(af.vb().cM(i));
                if (!this.amD) {
                    this.ams = af.vb().cL(i);
                }
                this.ams.setOneShot(false);
                this.amo.setBackgroundDrawable(this.ams);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void W(boolean z) {
        super.W(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(d.f.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.amE.setTag(tbPageContext.getUniqueId());
        this.amF.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.amE);
        tbPageContext.registerListener(this.amF);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.amE != null) {
            this.amE.setTag(bdUniqueId);
        }
        if (this.amF != null) {
            this.amF.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.amE);
        MessageManager.getInstance().registerListener(this.amF);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.amE);
        MessageManager.getInstance().unRegisterListener(this.amF);
    }
}
