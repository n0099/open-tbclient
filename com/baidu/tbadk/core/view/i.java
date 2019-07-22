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
public class i extends h {
    protected boolean caT;
    private boolean caU;
    private CustomMessageListener caV;
    protected boolean isDone;
    private CustomMessageListener listener;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.caU = false;
        this.listener = new CustomMessageListener(2016203) { // from class: com.baidu.tbadk.core.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (i.this.isDone) {
                    i.this.iV(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.caV = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.caB.setBackgroundColor(af.aiS().id(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void as(boolean z) {
        this.caC.setBackgroundDrawable(null);
        super.as(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void ar(boolean z) {
        super.ar(z);
        this.isDone = false;
        if (!this.caT) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            iV(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.h
    public void iV(int i) {
        super.iV(i);
        if (this.caB != null && this.caC != null) {
            this.caT = false;
            if (!aja()) {
                this.caH = af.aiS().ib(i);
                if (this.caH != null) {
                    this.caT = true;
                } else {
                    this.caH = new AnimationDrawable();
                }
                this.caB.setBackgroundColor(af.aiS().id(i));
                if (!this.caT) {
                    this.caH = af.aiS().ic(i);
                }
                this.caH.setOneShot(false);
                this.caC.setBackgroundDrawable(this.caH);
            }
            if (this.caU) {
                this.caB.setBackgroundColor(0);
            }
        }
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.caV.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.caV);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.caV != null) {
            this.caV.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.caV);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.caV);
    }

    public void et(boolean z) {
        this.caU = z;
    }
}
