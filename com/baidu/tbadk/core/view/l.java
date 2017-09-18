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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class l extends k {
    protected boolean ant;
    private CustomMessageListener anu;
    private CustomMessageListener anv;
    protected boolean isDone;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.anu = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (l.this.isDone) {
                    l.this.dq(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.anv = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l.this.and.setBackgroundColor(af.vx().cO(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        e(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.ane.setBackgroundDrawable(null);
        super.U(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        super.T(z);
        this.isDone = false;
        if (!this.ant) {
            dq(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void ld() {
        super.ld();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.k
    public void dq(int i) {
        super.dq(i);
        if (this.and != null && this.ane != null) {
            this.ant = false;
            if (!vF()) {
                this.ani = af.vx().cM(i);
                if (this.ani != null) {
                    this.ant = true;
                } else {
                    this.ani = new AnimationDrawable();
                }
                this.and.setBackgroundColor(af.vx().cO(i));
                if (!this.ant) {
                    this.ani = af.vx().cN(i);
                }
                this.ani.setOneShot(false);
                this.ane.setBackgroundDrawable(this.ani);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        super.V(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(d.f.ds46), 0, 0);
    }

    private void e(TbPageContext<?> tbPageContext) {
        this.anu.setTag(tbPageContext.getUniqueId());
        this.anv.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.anu);
        tbPageContext.registerListener(this.anv);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.anu != null) {
            this.anu.setTag(bdUniqueId);
        }
        if (this.anv != null) {
            this.anv.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.anu);
        MessageManager.getInstance().registerListener(this.anv);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.anu);
        MessageManager.getInstance().unRegisterListener(this.anv);
    }
}
