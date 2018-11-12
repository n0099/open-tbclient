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
    protected boolean aFs;
    private CustomMessageListener aFt;
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
                    k.this.ek(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.aFt = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k.this.aFc.setBackgroundColor(af.Ct().du(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void aw(boolean z) {
        this.aFd.setBackgroundDrawable(null);
        super.aw(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void av(boolean z) {
        super.av(z);
        this.isDone = false;
        if (!this.aFs) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            ek(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.j
    public void ek(int i) {
        super.ek(i);
        if (this.aFc != null && this.aFd != null) {
            this.aFs = false;
            if (!CB()) {
                this.aFh = af.Ct().ds(i);
                if (this.aFh != null) {
                    this.aFs = true;
                } else {
                    this.aFh = new AnimationDrawable();
                }
                this.aFc.setBackgroundColor(af.Ct().du(i));
                if (!this.aFs) {
                    this.aFh = af.Ct().dt(i);
                }
                this.aFh.setOneShot(false);
                this.aFd.setBackgroundDrawable(this.aFh);
            }
        }
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.aFt.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.aFt);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.aFt != null) {
            this.aFt.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.aFt);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.aFt);
    }
}
