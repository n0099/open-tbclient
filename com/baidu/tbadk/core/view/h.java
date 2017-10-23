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
public class h extends g {
    protected boolean amr;
    private CustomMessageListener ams;
    private CustomMessageListener amt;
    protected boolean isDone;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.ams = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (h.this.isDone) {
                    h.this.dy(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.amt = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.amb.setBackgroundColor(af.uU().cL(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
        this.amc.setBackgroundDrawable(null);
        super.V(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
        super.U(z);
        this.isDone = false;
        if (!this.amr) {
            dy(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void lf() {
        super.lf();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.g
    public void dy(int i) {
        super.dy(i);
        if (this.amb != null && this.amc != null) {
            this.amr = false;
            if (!vc()) {
                this.amg = af.uU().cJ(i);
                if (this.amg != null) {
                    this.amr = true;
                } else {
                    this.amg = new AnimationDrawable();
                }
                this.amb.setBackgroundColor(af.uU().cL(i));
                if (!this.amr) {
                    this.amg = af.uU().cK(i);
                }
                this.amg.setOneShot(false);
                this.amc.setBackgroundDrawable(this.amg);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void W(boolean z) {
        super.W(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(d.f.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.ams.setTag(tbPageContext.getUniqueId());
        this.amt.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.ams);
        tbPageContext.registerListener(this.amt);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ams != null) {
            this.ams.setTag(bdUniqueId);
        }
        if (this.amt != null) {
            this.amt.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.ams);
        MessageManager.getInstance().registerListener(this.amt);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ams);
        MessageManager.getInstance().unRegisterListener(this.amt);
    }
}
