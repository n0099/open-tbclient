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
public class f extends e {
    protected boolean aon;
    private CustomMessageListener aoo;
    protected boolean isDone;
    private CustomMessageListener listener;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new CustomMessageListener(2016203) { // from class: com.baidu.tbadk.core.view.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.isDone) {
                    f.this.dw(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.aoo = new CustomMessageListener(2016204) { // from class: com.baidu.tbadk.core.view.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                f.this.anX.setBackgroundColor(af.vx().cI(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        c(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.e, com.baidu.adp.widget.ListView.c
    public void Y(boolean z) {
        this.anY.setBackgroundDrawable(null);
        super.Y(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.e, com.baidu.adp.widget.ListView.c
    public void X(boolean z) {
        super.X(z);
        this.isDone = false;
        if (!this.aon) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            dw(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.e, com.baidu.adp.widget.ListView.c
    public void kC() {
        super.kC();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.e
    public void dw(int i) {
        super.dw(i);
        if (this.anX != null && this.anY != null) {
            this.aon = false;
            if (!vF()) {
                this.aoc = af.vx().cG(i);
                if (this.aoc != null) {
                    this.aon = true;
                } else {
                    this.aoc = new AnimationDrawable();
                }
                this.anX.setBackgroundColor(af.vx().cI(i));
                if (!this.aon) {
                    this.aoc = af.vx().cH(i);
                }
                this.aoc.setOneShot(false);
                this.anY.setBackgroundDrawable(this.aoc);
            }
        }
    }

    private void c(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.aoo.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.aoo);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.aoo != null) {
            this.aoo.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.aoo);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.aoo);
    }
}
