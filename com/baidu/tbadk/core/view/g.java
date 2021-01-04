package com.baidu.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ah;
/* loaded from: classes.dex */
public class g extends f {
    private boolean fmg;
    private CustomMessageListener fmh;
    private CustomMessageListener fmi;
    protected boolean isDone;
    protected boolean mApplyImage;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.fmg = false;
        this.fmh = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (g.this.isDone) {
                    g.this.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.fmi = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                g.this.mPullRoot.setBackgroundColor(ah.bwa().getPullViewBackgroundColor(TbadkCoreApplication.getInst().getSkinType()));
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
            if (!bwb()) {
                this.mAnimImage = ah.bwa().getAnimationDrawable(i);
                if (this.mAnimImage != null) {
                    this.mApplyImage = true;
                } else {
                    this.mAnimImage = new AnimationDrawable();
                }
                if (!this.mApplyImage) {
                    this.mAnimImage = ah.bwa().getDefaultAnimationDrawable(i);
                }
                this.mAnimImage.setOneShot(false);
                this.mPullImage.setBackgroundDrawable(this.mAnimImage);
            }
            if (this.fmg) {
                this.mPullRoot.setBackgroundColor(0);
            }
        }
    }

    private void h(TbPageContext<?> tbPageContext) {
        this.fmh.setTag(tbPageContext.getUniqueId());
        this.fmi.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.fmh);
        tbPageContext.registerListener(this.fmi);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.fmh != null) {
            this.fmh.setTag(bdUniqueId);
        }
        if (this.fmi != null) {
            this.fmi.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.fmh);
        MessageManager.getInstance().registerListener(this.fmi);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.fmh);
        MessageManager.getInstance().unRegisterListener(this.fmi);
    }

    public void ka(boolean z) {
        this.fmg = z;
    }
}
