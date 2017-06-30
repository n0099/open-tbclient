package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ah extends ae {
    protected boolean amd;
    private CustomMessageListener ame;
    private CustomMessageListener amf;
    protected boolean isDone;

    public ah(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.ame = new ai(this, CmdConfigCustom.CMD_PULL_IMAGE_CHANGE);
        this.amf = new aj(this, CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE);
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
        this.alO.setBackgroundDrawable(null);
        super.T(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
        super.S(z);
        this.isDone = false;
        if (!this.amd) {
            dl(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void le() {
        super.le();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void dl(int i) {
        super.dl(i);
        if (this.alN != null && this.alO != null) {
            this.amd = false;
            if (!vr()) {
                this.alS = com.baidu.tbadk.core.util.ak.vj().cH(i);
                if (this.alS != null) {
                    this.amd = true;
                } else {
                    this.alS = new AnimationDrawable();
                }
                this.alN.setBackgroundColor(com.baidu.tbadk.core.util.ak.vj().cJ(i));
                if (!this.amd) {
                    this.alS = com.baidu.tbadk.core.util.ak.vj().cI(i);
                }
                this.alS.setOneShot(false);
                this.alO.setBackgroundDrawable(this.alS);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void U(boolean z) {
        super.U(z);
        setPadding(0, -getContext().getResources().getDimensionPixelSize(w.f.ds46), 0, 0);
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.ame.setTag(tbPageContext.getUniqueId());
        this.amf.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.ame);
        tbPageContext.registerListener(this.amf);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.ame != null) {
            this.ame.setTag(bdUniqueId);
        }
        if (this.amf != null) {
            this.amf.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.ame);
        MessageManager.getInstance().registerListener(this.amf);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ame);
        MessageManager.getInstance().unRegisterListener(this.amf);
    }
}
