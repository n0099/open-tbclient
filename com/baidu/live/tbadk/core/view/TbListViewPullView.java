package com.baidu.live.tbadk.core.view;

import android.graphics.drawable.AnimationDrawable;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.PullViewHelper;
/* loaded from: classes11.dex */
public class TbListViewPullView extends TbListCommonPullView {
    private CustomMessageListener bgColorChangeListener;
    protected boolean isDone;
    private CustomMessageListener listener;
    protected boolean mApplyImage;

    public TbListViewPullView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.isDone = true;
        this.listener = new CustomMessageListener(CmdConfigCustom.CMD_PULL_IMAGE_CHANGE) { // from class: com.baidu.live.tbadk.core.view.TbListViewPullView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbListViewPullView.this.isDone) {
                    TbListViewPullView.this.changeSkin(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        };
        this.bgColorChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_PULL_BGCOLOR_CHANGE) { // from class: com.baidu.live.tbadk.core.view.TbListViewPullView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                TbListViewPullView.this.mPullRoot.setBackgroundColor(PullViewHelper.getInstance().getPullViewBackgroundColor(TbadkCoreApplication.getInst().getSkinType()));
            }
        };
        registerImageChange(tbPageContext);
    }

    @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView, com.baidu.live.adp.widget.listview.BdIListPullView
    public void done(boolean z) {
        this.mPullImage.setBackgroundDrawable(null);
        super.done(z);
        this.isDone = true;
    }

    @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView, com.baidu.live.adp.widget.listview.BdIListPullView
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

    @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView, com.baidu.live.adp.widget.listview.BdIListPullView
    public void refreshing() {
        super.refreshing();
        this.isDone = false;
    }

    @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView
    public void changeSkin(int i) {
        super.changeSkin(i);
        if (this.mPullRoot != null && this.mPullImage != null) {
            this.mApplyImage = false;
            this.mAnimImage = PullViewHelper.getInstance().getAnimationDrawable(i);
            if (this.mAnimImage != null) {
                this.mApplyImage = true;
            } else {
                this.mAnimImage = new AnimationDrawable();
            }
            this.mPullRoot.setBackgroundColor(PullViewHelper.getInstance().getPullViewBackgroundColor(i));
            if (!this.mApplyImage) {
                this.mAnimImage = PullViewHelper.getInstance().getDefaultAnimationDrawable(i);
            }
            this.mAnimImage.setOneShot(false);
            this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        }
    }

    private void registerImageChange(TbPageContext<?> tbPageContext) {
        this.listener.setTag(tbPageContext.getUniqueId());
        this.bgColorChangeListener.setTag(tbPageContext.getUniqueId());
        tbPageContext.registerListener(this.listener);
        tbPageContext.registerListener(this.bgColorChangeListener);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (this.listener != null) {
            this.listener.setTag(bdUniqueId);
        }
        if (this.bgColorChangeListener != null) {
            this.bgColorChangeListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.listener);
        MessageManager.getInstance().registerListener(this.bgColorChangeListener);
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.listener);
        MessageManager.getInstance().unRegisterListener(this.bgColorChangeListener);
    }
}
