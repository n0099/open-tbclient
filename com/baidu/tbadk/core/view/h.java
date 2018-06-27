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
    protected boolean axe;
    private CustomMessageListener axf;
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
                    h.this.dz(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.axf = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.awO.setBackgroundColor(ag.zl().cL(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void aa(boolean z) {
        this.awP.setBackgroundDrawable(null);
        super.aa(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        super.Z(z);
        this.isDone = false;
        if (!this.axe) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            dz(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void np() {
        super.np();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.g
    public void dz(int i) {
        super.dz(i);
        if (this.awO != null && this.awP != null) {
            this.axe = false;
            if (!zt()) {
                this.awT = ag.zl().cJ(i);
                if (this.awT != null) {
                    this.axe = true;
                } else {
                    this.awT = new AnimationDrawable();
                }
                this.awO.setBackgroundColor(ag.zl().cL(i));
                if (!this.axe) {
                    this.awT = ag.zl().cK(i);
                }
                this.awT.setOneShot(false);
                this.awP.setBackgroundDrawable(this.awT);
            }
        }
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.axf.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.axf);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.axf != null) {
            this.axf.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.axf);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.axf);
    }
}
