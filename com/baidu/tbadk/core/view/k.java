package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.af;
/* loaded from: classes.dex */
public class k extends j {
    protected boolean bcV;
    private CustomMessageListener bcW;
    protected boolean isDone;
    private CustomMessageListener listener;

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new CustomMessageListener(2016203) { // from class: com.baidu.tbadk.core.view.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (k.this.isDone) {
                    k.this.gx(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.bcW = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.bcF.setBackgroundColor(af.CN().fJ(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void aE(boolean z) {
        this.bcG.setBackgroundDrawable(null);
        super.aE(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void aD(boolean z) {
        super.aD(z);
        this.isDone = false;
        if (!this.bcV) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            gx(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void sv() {
        super.sv();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.j
    public void gx(int i) {
        super.gx(i);
        if (this.bcF != null && this.bcG != null) {
            this.bcV = false;
            if (!CV()) {
                this.bcK = af.CN().fH(i);
                if (this.bcK != null) {
                    this.bcV = true;
                } else {
                    this.bcK = new AnimationDrawable();
                }
                this.bcF.setBackgroundColor(af.CN().fJ(i));
                if (!this.bcV) {
                    this.bcK = af.CN().fI(i);
                }
                this.bcK.setOneShot(false);
                this.bcG.setBackgroundDrawable(this.bcK);
            }
        }
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.bcW.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.bcW);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.bcW != null) {
            this.bcW.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.bcW);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.bcW);
    }
}
