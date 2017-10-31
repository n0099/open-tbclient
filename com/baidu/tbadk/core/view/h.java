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
    protected boolean amN;
    private CustomMessageListener amO;
    protected boolean isDone;
    private CustomMessageListener listener;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (h.this.isDone) {
                    h.this.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.amO = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.amx.setBackgroundColor(af.vb().cM(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.amy.setBackgroundDrawable(null);
        super.U(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        super.T(z);
        this.isDone = false;
        if (!this.amN) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            dz(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void kZ() {
        super.kZ();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.g
    public void dz(int i) {
        super.dz(i);
        if (this.amx != null && this.amy != null) {
            this.amN = false;
            if (!vj()) {
                this.amC = af.vb().cK(i);
                if (this.amC != null) {
                    this.amN = true;
                } else {
                    this.amC = new AnimationDrawable();
                }
                this.amx.setBackgroundColor(af.vb().cM(i));
                if (!this.amN) {
                    this.amC = af.vb().cL(i);
                }
                this.amC.setOneShot(false);
                this.amy.setBackgroundDrawable(this.amC);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        super.V(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(d.e.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.amO.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.amO);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.amO != null) {
            this.amO.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.amO);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.amO);
    }
}
