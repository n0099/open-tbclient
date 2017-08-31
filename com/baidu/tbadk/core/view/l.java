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
    protected boolean anv;
    private CustomMessageListener anw;
    private CustomMessageListener anx;
    protected boolean isDone;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.anw = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (l.this.isDone) {
                    l.this.dq(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.anx = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l.this.anf.setBackgroundColor(af.vx().cO(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        e(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        this.ang.setBackgroundDrawable(null);
        super.U(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        super.T(z);
        this.isDone = false;
        if (!this.anv) {
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
        if (this.anf != null && this.ang != null) {
            this.anv = false;
            if (!vF()) {
                this.ank = af.vx().cM(i);
                if (this.ank != null) {
                    this.anv = true;
                } else {
                    this.ank = new AnimationDrawable();
                }
                this.anf.setBackgroundColor(af.vx().cO(i));
                if (!this.anv) {
                    this.ank = af.vx().cN(i);
                }
                this.ank.setOneShot(false);
                this.ang.setBackgroundDrawable(this.ank);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        super.V(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(d.f.ds46), 0, 0);
    }

    private void e(TbPageContext<?> tbPageContext) {
        this.anw.setTag(tbPageContext.getUniqueId());
        this.anx.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.anw);
        tbPageContext.registerListener(this.anx);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.anw != null) {
            this.anw.setTag(bdUniqueId);
        }
        if (this.anx != null) {
            this.anx.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.anw);
        MessageManager.getInstance().registerListener(this.anx);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.anw);
        MessageManager.getInstance().unRegisterListener(this.anx);
    }
}
