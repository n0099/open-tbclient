package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ag;
/* loaded from: classes.dex */
public class g extends f {
    protected boolean awv;
    private CustomMessageListener aww;
    protected boolean isDone;
    private CustomMessageListener listener;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new CustomMessageListener(2016203) { // from class: com.baidu.tbadk.core.view.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (g.this.isDone) {
                    g.this.dy(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.aww = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.awf.setBackgroundColor(ag.yX().cK(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.f, com.baidu.adp.widget.ListView.c
    public void aa(boolean z) {
        this.awg.setBackgroundDrawable(null);
        super.aa(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.f, com.baidu.adp.widget.ListView.c
    public void Z(boolean z) {
        super.Z(z);
        this.isDone = false;
        if (!this.awv) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            dy(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.f, com.baidu.adp.widget.ListView.c
    public void np() {
        super.np();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void dy(int i) {
        super.dy(i);
        if (this.awf != null && this.awg != null) {
            this.awv = false;
            if (!zf()) {
                this.awk = ag.yX().cI(i);
                if (this.awk != null) {
                    this.awv = true;
                } else {
                    this.awk = new AnimationDrawable();
                }
                this.awf.setBackgroundColor(ag.yX().cK(i));
                if (!this.awv) {
                    this.awk = ag.yX().cJ(i);
                }
                this.awk.setOneShot(false);
                this.awg.setBackgroundDrawable(this.awk);
            }
        }
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.aww.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.aww);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.aww != null) {
            this.aww.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.aww);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.aww);
    }
}
