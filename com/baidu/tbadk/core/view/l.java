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
    protected boolean amH;
    private CustomMessageListener amI;
    private CustomMessageListener amJ;
    protected boolean isDone;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.amI = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (l.this.isDone) {
                    l.this.dn(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.amJ = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l.this.amr.setBackgroundColor(ae.vp().cL(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        e(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
        this.ams.setBackgroundDrawable(null);
        super.T(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void S(boolean z) {
        super.S(z);
        this.isDone = false;
        if (!this.amH) {
            dn(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void lc() {
        super.lc();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.k
    public void dn(int i) {
        super.dn(i);
        if (this.amr != null && this.ams != null) {
            this.amH = false;
            if (!vx()) {
                this.amw = ae.vp().cJ(i);
                if (this.amw != null) {
                    this.amH = true;
                } else {
                    this.amw = new AnimationDrawable();
                }
                this.amr.setBackgroundColor(ae.vp().cL(i));
                if (!this.amH) {
                    this.amw = ae.vp().cK(i);
                }
                this.amw.setOneShot(false);
                this.ams.setBackgroundDrawable(this.amw);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        super.U(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(d.f.ds46), 0, 0);
    }

    private void e(TbPageContext<?> tbPageContext) {
        this.amI.setTag(tbPageContext.getUniqueId());
        this.amJ.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.amI);
        tbPageContext.registerListener(this.amJ);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.amI != null) {
            this.amI.setTag(bdUniqueId);
        }
        if (this.amJ != null) {
            this.amJ.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.amI);
        MessageManager.getInstance().registerListener(this.amJ);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.amI);
        MessageManager.getInstance().unRegisterListener(this.amJ);
    }
}
