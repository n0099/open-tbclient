package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ag;
/* loaded from: classes.dex */
public class h extends g {
    protected boolean awK;
    private CustomMessageListener awL;
    protected boolean isDone;
    private CustomMessageListener listener;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new CustomMessageListener(2016203) { // from class: com.baidu.tbadk.core.view.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (h.this.isDone) {
                    h.this.dC(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.awL = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.awu.setBackgroundColor(ag.zc().cN(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        this.awv.setBackgroundDrawable(null);
        super.Z(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void Y(boolean z) {
        super.Y(z);
        this.isDone = false;
        if (!this.awK) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            dC(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void nr() {
        super.nr();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.g
    public void dC(int i) {
        super.dC(i);
        if (this.awu != null && this.awv != null) {
            this.awK = false;
            if (!zk()) {
                this.awz = ag.zc().cL(i);
                if (this.awz != null) {
                    this.awK = true;
                } else {
                    this.awz = new AnimationDrawable();
                }
                this.awu.setBackgroundColor(ag.zc().cN(i));
                if (!this.awK) {
                    this.awz = ag.zc().cM(i);
                }
                this.awz.setOneShot(false);
                this.awv.setBackgroundDrawable(this.awz);
            }
        }
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.awL.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.awL);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.awL != null) {
            this.awL.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.awL);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.awL);
    }
}
