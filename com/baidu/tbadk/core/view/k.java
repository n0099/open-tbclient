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
    protected boolean aEC;
    private CustomMessageListener aED;
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
                    k.this.dW(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.aED = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.aEm.setBackgroundColor(af.Cm().dg(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void ai(boolean z) {
        this.aEn.setBackgroundDrawable(null);
        super.ai(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void ah(boolean z) {
        super.ah(z);
        this.isDone = false;
        if (!this.aEC) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            dW(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.j
    public void dW(int i) {
        super.dW(i);
        if (this.aEm != null && this.aEn != null) {
            this.aEC = false;
            if (!Cu()) {
                this.aEr = af.Cm().de(i);
                if (this.aEr != null) {
                    this.aEC = true;
                } else {
                    this.aEr = new AnimationDrawable();
                }
                this.aEm.setBackgroundColor(af.Cm().dg(i));
                if (!this.aEC) {
                    this.aEr = af.Cm().df(i);
                }
                this.aEr.setOneShot(false);
                this.aEn.setBackgroundDrawable(this.aEr);
            }
        }
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.aED.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.aED);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.aED != null) {
            this.aED.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.aED);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.aED);
    }
}
