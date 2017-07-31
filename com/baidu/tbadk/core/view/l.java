package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class l extends k {
    protected boolean aoa;
    private CustomMessageListener aob;
    private CustomMessageListener aoc;
    protected boolean isDone;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.aob = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (l.this.isDone) {
                    l.this.dp(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.aoc = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l.this.anK.setBackgroundColor(ae.vz().cN(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        e(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        this.anL.setBackgroundDrawable(null);
        super.T(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void S(boolean z) {
        super.S(z);
        this.isDone = false;
        if (!this.aoa) {
            dp(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void lm() {
        super.lm();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.k
    public void dp(int i) {
        super.dp(i);
        if (this.anK != null && this.anL != null) {
            this.aoa = false;
            if (!vH()) {
                this.anP = ae.vz().cL(i);
                if (this.anP != null) {
                    this.aoa = true;
                } else {
                    this.anP = new AnimationDrawable();
                }
                this.anK.setBackgroundColor(ae.vz().cN(i));
                if (!this.aoa) {
                    this.anP = ae.vz().cM(i);
                }
                this.anP.setOneShot(false);
                this.anL.setBackgroundDrawable(this.anP);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        super.U(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(d.f.ds46), 0, 0);
    }

    private void e(TbPageContext<?> tbPageContext) {
        this.aob.setTag(tbPageContext.getUniqueId());
        this.aoc.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.aob);
        tbPageContext.registerListener(this.aoc);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.aob != null) {
            this.aob.setTag(bdUniqueId);
        }
        if (this.aoc != null) {
            this.aoc.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.aob);
        MessageManager.getInstance().registerListener(this.aoc);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.aob);
        MessageManager.getInstance().unRegisterListener(this.aoc);
    }
}
