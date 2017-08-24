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
    protected boolean aob;
    private CustomMessageListener aoc;
    private CustomMessageListener aod;
    protected boolean isDone;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.aoc = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (l.this.isDone) {
                    l.this.dp(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.aod = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l.this.anL.setBackgroundColor(ae.vA().cN(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        e(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        this.anM.setBackgroundDrawable(null);
        super.T(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void S(boolean z) {
        super.S(z);
        this.isDone = false;
        if (!this.aob) {
            dp(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void ll() {
        super.ll();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.k
    public void dp(int i) {
        super.dp(i);
        if (this.anL != null && this.anM != null) {
            this.aob = false;
            if (!vI()) {
                this.anQ = ae.vA().cL(i);
                if (this.anQ != null) {
                    this.aob = true;
                } else {
                    this.anQ = new AnimationDrawable();
                }
                this.anL.setBackgroundColor(ae.vA().cN(i));
                if (!this.aob) {
                    this.anQ = ae.vA().cM(i);
                }
                this.anQ.setOneShot(false);
                this.anM.setBackgroundDrawable(this.anQ);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        super.U(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(d.f.ds46), 0, 0);
    }

    private void e(TbPageContext<?> tbPageContext) {
        this.aoc.setTag(tbPageContext.getUniqueId());
        this.aod.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.aoc);
        tbPageContext.registerListener(this.aod);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.aoc != null) {
            this.aoc.setTag(bdUniqueId);
        }
        if (this.aod != null) {
            this.aod.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.aoc);
        MessageManager.getInstance().registerListener(this.aod);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.aoc);
        MessageManager.getInstance().unRegisterListener(this.aod);
    }
}
