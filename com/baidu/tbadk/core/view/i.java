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
    protected boolean bRZ;
    private CustomMessageListener bSa;
    protected boolean isDone;
    private CustomMessageListener listener;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new CustomMessageListener(2016203) { // from class: com.baidu.tbadk.core.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (i.this.isDone) {
                    i.this.ib(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.bSa = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bRH.setBackgroundColor(af.acS().hj(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void ax(boolean z) {
        this.bRI.setBackgroundDrawable(null);
        super.ax(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        super.aw(z);
        this.isDone = false;
        if (!this.bRZ) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            ib(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.h
    public void ib(int i) {
        super.ib(i);
        if (this.bRH != null && this.bRI != null) {
            this.bRZ = false;
            if (!ada()) {
                this.bRN = af.acS().hh(i);
                if (this.bRN != null) {
                    this.bRZ = true;
                } else {
                    this.bRN = new AnimationDrawable();
                }
                this.bRH.setBackgroundColor(af.acS().hj(i));
                if (!this.bRZ) {
                    this.bRN = af.acS().hi(i);
                }
                this.bRN.setOneShot(false);
                this.bRI.setBackgroundDrawable(this.bRN);
            }
        }
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.bSa.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.bSa);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.bSa != null) {
            this.bSa.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.bSa);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.bSa);
    }
}
