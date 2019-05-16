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
    protected boolean bZQ;
    private boolean bZR;
    private CustomMessageListener bZS;
    protected boolean isDone;
    private CustomMessageListener listener;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.bZR = false;
        this.listener = new CustomMessageListener(2016203) { // from class: com.baidu.tbadk.core.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (i.this.isDone) {
                    i.this.iP(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.bZS = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bZy.setBackgroundColor(af.ahQ().hX(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void ap(boolean z) {
        this.bZz.setBackgroundDrawable(null);
        super.ap(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void ao(boolean z) {
        super.ao(z);
        this.isDone = false;
        if (!this.bZQ) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            iP(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.h
    public void iP(int i) {
        super.iP(i);
        if (this.bZy != null && this.bZz != null) {
            this.bZQ = false;
            if (!ahY()) {
                this.bZE = af.ahQ().hV(i);
                if (this.bZE != null) {
                    this.bZQ = true;
                } else {
                    this.bZE = new AnimationDrawable();
                }
                this.bZy.setBackgroundColor(af.ahQ().hX(i));
                if (!this.bZQ) {
                    this.bZE = af.ahQ().hW(i);
                }
                this.bZE.setOneShot(false);
                this.bZz.setBackgroundDrawable(this.bZE);
            }
            if (this.bZR) {
                this.bZy.setBackgroundColor(0);
            }
        }
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.bZS.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.bZS);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.bZS != null) {
            this.bZS.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.bZS);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.bZS);
    }

    public void ep(boolean z) {
        this.bZR = z;
    }
}
