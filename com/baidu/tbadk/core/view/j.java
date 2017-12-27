package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.af;
/* loaded from: classes.dex */
public class j extends i {
    protected boolean bbg;
    private CustomMessageListener bbh;
    protected boolean isDone;
    private CustomMessageListener listener;

    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.this.isDone) {
                    j.this.gy(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.bbh = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                j.this.baQ.setBackgroundColor(af.CB().fL(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.i, com.baidu.adp.widget.ListView.c
    public void aA(boolean z) {
        this.baR.setBackgroundDrawable(null);
        super.aA(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.i, com.baidu.adp.widget.ListView.c
    public void az(boolean z) {
        super.az(z);
        this.isDone = false;
        if (!this.bbg) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            gy(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.i, com.baidu.adp.widget.ListView.c
    public void sw() {
        super.sw();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.i
    public void gy(int i) {
        super.gy(i);
        if (this.baQ != null && this.baR != null) {
            this.bbg = false;
            if (!CJ()) {
                this.baV = af.CB().fJ(i);
                if (this.baV != null) {
                    this.bbg = true;
                } else {
                    this.baV = new AnimationDrawable();
                }
                this.baQ.setBackgroundColor(af.CB().fL(i));
                if (!this.bbg) {
                    this.baV = af.CB().fK(i);
                }
                this.baV.setOneShot(false);
                this.baR.setBackgroundDrawable(this.baV);
            }
        }
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.bbh.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.bbh);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.bbh != null) {
            this.bbh.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.bbh);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.bbh);
    }
}
