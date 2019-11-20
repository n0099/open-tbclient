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
    private TBLottieAnimationView clA;
    private TextView clB;
    private int clC;
    private AgreeData clD;
    private com.baidu.tieba.tbadkCore.data.e clE;
    private String clF;
    private CustomMessageListener clG;
    private CustomMessageListener clH;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.clG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.clD != null && !TextUtils.isEmpty(AgreeAloneView.this.clD.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.clD.threadId.equals(agreeData.threadId) && AgreeAloneView.this.clE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.clD.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.clD.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.updateUI();
                    }
                }
            }
        };
        this.clH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.clD != null && !TextUtils.isEmpty(AgreeAloneView.this.clD.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.clD.postId.equals(agreeData.postId) && AgreeAloneView.this.clE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.clD.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.clD.disAgreeNum = agreeData.disAgreeNum;
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
        this.clG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.clD != null && !TextUtils.isEmpty(AgreeAloneView.this.clD.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.clD.threadId.equals(agreeData.threadId) && AgreeAloneView.this.clE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.clD.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.clD.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.updateUI();
                    }
                }
            }
        };
        this.clH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.clD != null && !TextUtils.isEmpty(AgreeAloneView.this.clD.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.clD.postId.equals(agreeData.postId) && AgreeAloneView.this.clE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.clD.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.clD.disAgreeNum = agreeData.disAgreeNum;
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
        this.clG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.clD != null && !TextUtils.isEmpty(AgreeAloneView.this.clD.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.clD.threadId.equals(agreeData.threadId) && AgreeAloneView.this.clE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.clD.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.clD.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.updateUI();
                    }
                }
            }
        };
        this.clH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.clD != null && !TextUtils.isEmpty(AgreeAloneView.this.clD.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.clD.postId.equals(agreeData.postId) && AgreeAloneView.this.clE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.clD.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.clD.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.clD.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.clD.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.clD.disAgreeNum = agreeData.disAgreeNum;
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
        this.clF = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(3);
        this.clC = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds112);
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds19);
        this.clA = new TBLottieAnimationView(context);
        this.clA.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.clC, this.clC);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds_2);
        addView(this.clA, layoutParams);
        this.clA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.clA.setOnClickListener(this.mOnClickListener);
        this.clA.setAnimation(R.raw.agree);
        this.clB = new TextView(context);
        this.clB.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds_2);
        addView(this.clB, layoutParams2);
        this.clE = new com.baidu.tieba.tbadkCore.data.e();
        this.clE.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.clD = agreeData;
            updateUI();
        }
    }

    public void updateUI() {
        if (this.clD != null) {
            if (this.clD.hasAgree) {
                this.clB.setText(aq.numFormatOverWanNa(this.clD.agreeNum));
                if (this.clD.agreeType == 2) {
                    this.clA.setMinAndMaxProgress(0.0f, 1.0f);
                    this.clA.setProgress(1.0f);
                    this.clB.setTextColor(am.getColor(R.color.cp_cont_h));
                    return;
                }
                this.clA.setMinAndMaxProgress(0.0f, 0.0f);
                this.clA.setProgress(0.0f);
                this.clB.setTextColor(am.getColor(R.color.cp_cont_j));
                return;
            }
            if (this.clD.agreeNum != 0) {
                this.clB.setText(aq.numFormatOverWanNa(this.clD.agreeNum));
            } else {
                this.clB.setText(getResources().getString(R.string.zan));
            }
            this.clA.setMinAndMaxProgress(0.0f, 0.0f);
            this.clA.setProgress(0.0f);
            this.clB.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void ep(boolean z) {
        if (z) {
            this.clA.setMinAndMaxProgress(0.0f, 1.0f);
            this.clA.playAnimation();
            this.clB.setText(aq.numFormatOverWanNa(this.clD.agreeNum));
            this.clB.setTextColor(am.getColor(R.color.cp_cont_h));
            return;
        }
        updateUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(View view) {
        int i;
        if (this.clD != null && bc.checkUpIsLogin(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).playAnimation();
            }
            if (view.getId() == this.clA.getId()) {
                if (this.clD.hasAgree) {
                    if (this.clD.agreeType == 2) {
                        this.clD.agreeType = 2;
                        this.clD.hasAgree = false;
                        this.clD.diffAgreeNum--;
                        this.clD.agreeNum--;
                        ep(false);
                        i = 1;
                    } else {
                        this.clD.agreeType = 2;
                        this.clD.hasAgree = true;
                        this.clD.diffAgreeNum += 2;
                        this.clD.agreeNum++;
                        this.clD.disAgreeNum--;
                        ep(true);
                        com.baidu.tieba.n.a.cfn().z(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.clD.agreeType = 2;
                    this.clD.hasAgree = true;
                    this.clD.diffAgreeNum++;
                    this.clD.agreeNum++;
                    ep(true);
                    com.baidu.tieba.n.a.cfn().z(getTbPageContext());
                    if (!StringUtils.isNull(this.clF)) {
                        TiebaStatic.log(new an("c13358").bS("tid", this.clD.threadId).bS("topic_id", this.clF));
                    }
                    i = 0;
                }
                ix(i);
            }
            this.clE.agreeData = this.clD;
            if (this.clD.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.clE));
                a(this.clD, "isInThread");
            } else if (this.clD.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.clE));
                a(this.clD, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void ix(int i) {
        if (this.clD != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.clD.threadId);
            httpMessage.addParam("op_type", i);
            if (this.clD.objType == 0) {
                this.clD.objType = 1;
            }
            httpMessage.addParam("obj_type", this.clD.objType);
            httpMessage.addParam("agree_type", this.clD.agreeType);
            httpMessage.addParam("forum_id", this.clD.forumId);
            if (!TextUtils.isEmpty(this.clD.postId)) {
                httpMessage.addParam("post_id", this.clD.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.clD == null && this.mSkinType != i) {
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
        MessageManager.getInstance().registerListener(this.clG);
        MessageManager.getInstance().registerListener(this.clH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.clG);
        MessageManager.getInstance().unRegisterListener(this.clH);
    }
}
