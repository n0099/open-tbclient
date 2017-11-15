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
    protected boolean amM;
    private CustomMessageListener amN;
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
                    h.this.dy(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.amN = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.amw.setBackgroundColor(af.vb().cL(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.amx.setBackgroundDrawable(null);
        super.U(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        super.T(z);
        this.isDone = false;
        if (!this.amM) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            dy(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void kZ() {
        super.kZ();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.g
    public void dy(int i) {
        super.dy(i);
        if (this.amw != null && this.amx != null) {
            this.amM = false;
            if (!vj()) {
                this.amB = af.vb().cJ(i);
                if (this.amB != null) {
                    this.amM = true;
                } else {
                    this.amB = new AnimationDrawable();
                }
                this.amw.setBackgroundColor(af.vb().cL(i));
                if (!this.amM) {
                    this.amB = af.vb().cK(i);
                }
                this.amB.setOneShot(false);
                this.amx.setBackgroundDrawable(this.amB);
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
        this.amN.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.amN);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.amN != null) {
            this.amN.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.amN);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.amN);
    }
}
