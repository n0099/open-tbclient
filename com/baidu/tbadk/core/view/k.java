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
    protected boolean aIT;
    private CustomMessageListener aIU;
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
        this.aIU = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.aID.setBackgroundColor(af.Dx().dI(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        this.aIE.setBackgroundDrawable(null);
        super.aw(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        super.av(z);
        this.isDone = false;
        if (!this.aIT) {
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
        if (this.aID != null && this.aIE != null) {
            this.aIT = false;
            if (!DF()) {
                this.aII = af.Dx().dG(i);
                if (this.aII != null) {
                    this.aIT = true;
                } else {
                    this.aII = new AnimationDrawable();
                }
                this.aID.setBackgroundColor(af.Dx().dI(i));
                if (!this.aIT) {
                    this.aII = af.Dx().dH(i);
                }
                this.aII.setOneShot(false);
                this.aIE.setBackgroundDrawable(this.aII);
            }
        }
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.aIU.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.aIU);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.aIU != null) {
            this.aIU.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.aIU);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.aIU);
    }
}
