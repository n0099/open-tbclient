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
public class i extends h {
    private boolean cqh;
    private CustomMessageListener cqi;
    private CustomMessageListener cqj;
    protected boolean isDone;
    protected boolean mApplyImage;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.cqh = false;
        this.cqi = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.tbadk.core.view.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (i.this.isDone) {
                    i.this.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.cqj = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.tbadk.core.view.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.mPullRoot.setBackgroundColor(af.amz().getPullViewBackgroundColor(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        d(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void done(boolean z) {
        this.mPullImage.setBackgroundDrawable(null);
        super.done(z);
        this.isDone = true;
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
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

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.tbadk.core.view.h
    public void changeSkin(int i) {
        super.changeSkin(i);
        if (this.mPullRoot != null && this.mPullImage != null) {
            this.mApplyImage = false;
            if (!amA()) {
                this.mAnimImage = af.amz().getAnimationDrawable(i);
                if (this.mAnimImage != null) {
                    this.mApplyImage = true;
                } else {
                    this.mAnimImage = new AnimationDrawable();
                }
                this.mPullRoot.setBackgroundColor(af.amz().getPullViewBackgroundColor(i));
                if (!this.mApplyImage) {
                    this.mAnimImage = af.amz().getDefaultAnimationDrawable(i);
                }
                this.mAnimImage.setOneShot(false);
                this.mPullImage.setBackgroundDrawable(this.mAnimImage);
            }
            if (this.cqh) {
                this.mPullRoot.setBackgroundColor(0);
            }
        }
    }

    private void d(TbPageContext<?> tbPageContext) {
        this.cqi.setTag(tbPageContext.getUniqueId());
        this.cqj.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.cqi);
        tbPageContext.registerListener(this.cqj);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.cqi != null) {
            this.cqi.setTag(bdUniqueId);
        }
        if (this.cqj != null) {
            this.cqj.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.cqi);
        MessageManager.getInstance().registerListener(this.cqj);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.cqi);
        MessageManager.getInstance().unRegisterListener(this.cqj);
    }

    public void eu(boolean z) {
        this.cqh = z;
    }
}
