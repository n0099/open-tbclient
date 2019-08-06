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
    protected boolean cba;
    private boolean cbb;
    private CustomMessageListener cbc;
    protected boolean isDone;
    private CustomMessageListener listener;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.cbb = false;
        this.listener = new CustomMessageListener(2016203) { // from class: com.baidu.tbadk.core.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (i.this.isDone) {
                    i.this.iV(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.cbc = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.caH.setBackgroundColor(af.aiU().id(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void as(boolean z) {
        this.caI.setBackgroundDrawable(null);
        super.as(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void ar(boolean z) {
        super.ar(z);
        this.isDone = false;
        if (!this.cba) {
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
        if (this.caH != null && this.caI != null) {
            this.cba = false;
            if (!ajc()) {
                this.caN = af.aiU().ib(i);
                if (this.caN != null) {
                    this.cba = true;
                } else {
                    this.caN = new AnimationDrawable();
                }
                this.caH.setBackgroundColor(af.aiU().id(i));
                if (!this.cba) {
                    this.caN = af.aiU().ic(i);
                }
                this.caN.setOneShot(false);
                this.caI.setBackgroundDrawable(this.caN);
            }
            if (this.cbb) {
                this.caH.setBackgroundColor(0);
            }
        }
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.cbc.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.cbc);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.cbc != null) {
            this.cbc.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.cbc);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.cbc);
    }

    public void et(boolean z) {
        this.cbb = z;
    }
}
