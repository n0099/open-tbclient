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
public class i extends h {
    protected boolean anf;
    private CustomMessageListener ang;
    protected boolean isDone;
    private CustomMessageListener listener;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (i.this.isDone) {
                    i.this.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.ang = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.amP.setBackgroundColor(af.vb().cM(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.amQ.setBackgroundDrawable(null);
        super.U(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        super.T(z);
        this.isDone = false;
        if (!this.anf) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            dz(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void kZ() {
        super.kZ();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.h
    public void dz(int i) {
        super.dz(i);
        if (this.amP != null && this.amQ != null) {
            this.anf = false;
            if (!vj()) {
                this.amU = af.vb().cK(i);
                if (this.amU != null) {
                    this.anf = true;
                } else {
                    this.amU = new AnimationDrawable();
                }
                this.amP.setBackgroundColor(af.vb().cM(i));
                if (!this.anf) {
                    this.amU = af.vb().cL(i);
                }
                this.amU.setOneShot(false);
                this.amQ.setBackgroundDrawable(this.amU);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        super.V(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(d.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.ang.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.ang);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.ang != null) {
            this.ang.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.ang);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.ang);
    }
}
