package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
/* loaded from: classes.dex */
public class g extends f {
    private boolean fjO;
    private CustomMessageListener fjP;
    private CustomMessageListener fjQ;
    protected boolean isDone;
    protected boolean mApplyImage;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.fjO = false;
        this.fjP = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (g.this.isDone) {
                    g.this.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.fjQ = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.mPullRoot.setBackgroundColor(ai.bsB().getPullViewBackgroundColor(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        h(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.f, com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.mPullImage.setBackgroundDrawable(null);
        super.done(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.f, com.baidu.adp.widget.ListView.c
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

    @Override // com.baidu.tbadk.core.view.f, com.baidu.adp.widget.ListView.c
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.f
    public void changeSkin(int i) {
        super.changeSkin(i);
        if (this.mPullRoot != null && this.mPullImage != null) {
            this.mApplyImage = false;
            if (!bsC()) {
                this.mAnimImage = ai.bsB().getAnimationDrawable(i);
                if (this.mAnimImage != null) {
                    this.mApplyImage = true;
                } else {
                    this.mAnimImage = new AnimationDrawable();
                }
                if (!this.mApplyImage) {
                    this.mAnimImage = ai.bsB().getDefaultAnimationDrawable(i);
                }
                this.mAnimImage.setOneShot(false);
                this.mPullImage.setBackgroundDrawable(this.mAnimImage);
            }
            if (this.fjO) {
                this.mPullRoot.setBackgroundColor(0);
            }
        }
    }

    private void h(TbPageContext<?> tbPageContext) {
        this.fjP.setTag(tbPageContext.getUniqueId());
        this.fjQ.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.fjP);
        tbPageContext.registerListener(this.fjQ);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fjP != null) {
            this.fjP.setTag(bdUniqueId);
        }
        if (this.fjQ != null) {
            this.fjQ.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.fjP);
        MessageManager.getInstance().registerListener(this.fjQ);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.fjP);
        MessageManager.getInstance().unRegisterListener(this.fjQ);
    }

    public void jZ(boolean z) {
        this.fjO = z;
    }
}
