package com.baidu.tbadk.core.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
/* loaded from: classes3.dex */
public class AgreeAloneView extends LinearLayout {
    private TBLottieAnimationView cms;
    private TextView cmt;
    private int cmu;
    private AgreeData cmv;
    private com.baidu.tieba.tbadkCore.data.e cmw;
    private String cmx;
    private CustomMessageListener cmy;
    private CustomMessageListener cmz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cmy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.cmv != null && !TextUtils.isEmpty(AgreeAloneView.this.cmv.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.cmv.threadId.equals(agreeData.threadId) && AgreeAloneView.this.cmw.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.updateUI();
                    }
                }
            }
        };
        this.cmz = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.cmv != null && !TextUtils.isEmpty(AgreeAloneView.this.cmv.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.cmv.postId.equals(agreeData.postId) && AgreeAloneView.this.cmw.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.updateUI();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aN(view);
            }
        };
        init(context);
    }

    public AgreeAloneView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cmy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.cmv != null && !TextUtils.isEmpty(AgreeAloneView.this.cmv.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.cmv.threadId.equals(agreeData.threadId) && AgreeAloneView.this.cmw.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.updateUI();
                    }
                }
            }
        };
        this.cmz = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.cmv != null && !TextUtils.isEmpty(AgreeAloneView.this.cmv.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.cmv.postId.equals(agreeData.postId) && AgreeAloneView.this.cmw.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.updateUI();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aN(view);
            }
        };
        init(context);
    }

    public AgreeAloneView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cmy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.cmv != null && !TextUtils.isEmpty(AgreeAloneView.this.cmv.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.cmv.threadId.equals(agreeData.threadId) && AgreeAloneView.this.cmw.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.updateUI();
                    }
                }
            }
        };
        this.cmz = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.cmv != null && !TextUtils.isEmpty(AgreeAloneView.this.cmv.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.cmv.postId.equals(agreeData.postId) && AgreeAloneView.this.cmw.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.updateUI();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aN(view);
            }
        };
        init(context);
    }

    public void setTopicId(String str) {
        this.cmx = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(3);
        this.cmu = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds112);
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds19);
        this.cms = new TBLottieAnimationView(context);
        this.cms.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cmu, this.cmu);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds_2);
        addView(this.cms, layoutParams);
        this.cms.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cms.setOnClickListener(this.mOnClickListener);
        this.cms.setAnimation(R.raw.agree);
        this.cmt = new TextView(context);
        this.cmt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds_2);
        addView(this.cmt, layoutParams2);
        this.cmw = new com.baidu.tieba.tbadkCore.data.e();
        this.cmw.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.cmv = agreeData;
            updateUI();
        }
    }

    public void updateUI() {
        if (this.cmv != null) {
            if (this.cmv.hasAgree) {
                this.cmt.setText(aq.numFormatOverWanNa(this.cmv.agreeNum));
                if (this.cmv.agreeType == 2) {
                    this.cms.setMinAndMaxProgress(0.0f, 1.0f);
                    this.cms.setProgress(1.0f);
                    this.cmt.setTextColor(am.getColor(R.color.cp_cont_h));
                    return;
                }
                this.cms.setMinAndMaxProgress(0.0f, 0.0f);
                this.cms.setProgress(0.0f);
                this.cmt.setTextColor(am.getColor(R.color.cp_cont_j));
                return;
            }
            if (this.cmv.agreeNum != 0) {
                this.cmt.setText(aq.numFormatOverWanNa(this.cmv.agreeNum));
            } else {
                this.cmt.setText(getResources().getString(R.string.zan));
            }
            this.cms.setMinAndMaxProgress(0.0f, 0.0f);
            this.cms.setProgress(0.0f);
            this.cmt.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void ep(boolean z) {
        if (z) {
            this.cms.setMinAndMaxProgress(0.0f, 1.0f);
            this.cms.playAnimation();
            this.cmt.setText(aq.numFormatOverWanNa(this.cmv.agreeNum));
            this.cmt.setTextColor(am.getColor(R.color.cp_cont_h));
            return;
        }
        updateUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(View view) {
        int i;
        if (this.cmv != null && bc.checkUpIsLogin(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).playAnimation();
            }
            if (view.getId() == this.cms.getId()) {
                if (this.cmv.hasAgree) {
                    if (this.cmv.agreeType == 2) {
                        this.cmv.agreeType = 2;
                        this.cmv.hasAgree = false;
                        this.cmv.diffAgreeNum--;
                        this.cmv.agreeNum--;
                        ep(false);
                        i = 1;
                    } else {
                        this.cmv.agreeType = 2;
                        this.cmv.hasAgree = true;
                        this.cmv.diffAgreeNum += 2;
                        this.cmv.agreeNum++;
                        this.cmv.disAgreeNum--;
                        ep(true);
                        com.baidu.tieba.n.a.cfp().z(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.cmv.agreeType = 2;
                    this.cmv.hasAgree = true;
                    this.cmv.diffAgreeNum++;
                    this.cmv.agreeNum++;
                    ep(true);
                    com.baidu.tieba.n.a.cfp().z(getTbPageContext());
                    if (!StringUtils.isNull(this.cmx)) {
                        TiebaStatic.log(new an("c13358").bS("tid", this.cmv.threadId).bS("topic_id", this.cmx));
                    }
                    i = 0;
                }
                iy(i);
            }
            this.cmw.agreeData = this.cmv;
            if (this.cmv.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.cmw));
                a(this.cmv, "isInThread");
            } else if (this.cmv.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.cmw));
                a(this.cmv, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iy(int i) {
        if (this.cmv != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.cmv.threadId);
            httpMessage.addParam("op_type", i);
            if (this.cmv.objType == 0) {
                this.cmv.objType = 1;
            }
            httpMessage.addParam("obj_type", this.cmv.objType);
            httpMessage.addParam("agree_type", this.cmv.agreeType);
            httpMessage.addParam("forum_id", this.cmv.forumId);
            if (!TextUtils.isEmpty(this.cmv.postId)) {
                httpMessage.addParam("post_id", this.cmv.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cmv == null && this.mSkinType != i) {
            updateUI();
            this.mSkinType = i;
        }
    }

    public BdUniqueId getPageId() {
        TbPageContext tbPageContext = getTbPageContext();
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public TbPageContext getTbPageContext() {
        if (this.mPageContext == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.mPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
        }
        return this.mPageContext;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cmy);
        MessageManager.getInstance().registerListener(this.cmz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cmy);
        MessageManager.getInstance().unRegisterListener(this.cmz);
    }
}
