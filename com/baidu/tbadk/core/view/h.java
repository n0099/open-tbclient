package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.af;
/* loaded from: classes.dex */
public class h extends g {
    private boolean dHu;
    private CustomMessageListener dHv;
    private CustomMessageListener dHw;
    protected boolean isDone;
    protected boolean mApplyImage;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.dHu = false;
        this.dHv = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (h.this.isDone) {
                    h.this.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.dHw = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h.this.mPullRoot.setBackgroundColor(af.aOG().getPullViewBackgroundColor(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        f(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.mPullImage.setBackgroundDrawable(null);
        super.done(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void pullToRefresh(boolean z) {
        super.pullToRefresh(z);
        this.isDone = false;
        if (!this.mApplyImage) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.mSkinType != Integer.MIN_VALUE) {
                skinType = this.mSkinType;
            }
            changeSkin(skinType);
        }
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.g
    public void changeSkin(int i) {
        super.changeSkin(i);
        if (this.mPullRoot != null && this.mPullImage != null) {
            this.mApplyImage = false;
            if (!aOH()) {
                this.mAnimImage = af.aOG().getAnimationDrawable(i);
                if (this.mAnimImage != null) {
                    this.mApplyImage = true;
                } else {
                    this.mAnimImage = new AnimationDrawable();
                }
                this.mPullRoot.setBackgroundColor(af.aOG().getPullViewBackgroundColor(i));
                if (!this.mApplyImage) {
                    this.mAnimImage = af.aOG().getDefaultAnimationDrawable(i);
                }
                this.mAnimImage.setOneShot(false);
                this.mPullImage.setBackgroundDrawable(this.mAnimImage);
            }
            if (this.dHu) {
                this.mPullRoot.setBackgroundColor(0);
            }
        }
    }

    private void f(TbPageContext<?> tbPageContext) {
        this.dHv.setTag(tbPageContext.getUniqueId());
        this.dHw.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.dHv);
        tbPageContext.registerListener(this.dHw);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.dHv != null) {
            this.dHv.setTag(bdUniqueId);
        }
        if (this.dHw != null) {
            this.dHw.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.dHv);
        MessageManager.getInstance().registerListener(this.dHw);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.dHv);
        MessageManager.getInstance().unRegisterListener(this.dHw);
    }

    public void gR(boolean z) {
        this.dHu = z;
    }
}
