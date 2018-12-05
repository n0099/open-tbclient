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
    protected boolean aIS;
    private CustomMessageListener aIT;
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
                    k.this.ey(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.aIT = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.aIC.setBackgroundColor(af.Dx().dI(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        this.aID.setBackgroundDrawable(null);
        super.aw(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        super.av(z);
        this.isDone = false;
        if (!this.aIS) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            ey(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.j
    public void ey(int i) {
        super.ey(i);
        if (this.aIC != null && this.aID != null) {
            this.aIS = false;
            if (!DF()) {
                this.aIH = af.Dx().dG(i);
                if (this.aIH != null) {
                    this.aIS = true;
                } else {
                    this.aIH = new AnimationDrawable();
                }
                this.aIC.setBackgroundColor(af.Dx().dI(i));
                if (!this.aIS) {
                    this.aIH = af.Dx().dH(i);
                }
                this.aIH.setOneShot(false);
                this.aID.setBackgroundDrawable(this.aIH);
            }
        }
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.aIT.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.aIT);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.aIT != null) {
            this.aIT.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.aIT);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.aIT);
    }
}
