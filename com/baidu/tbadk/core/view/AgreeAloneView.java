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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
    private TBLottieAnimationView bXn;
    private TextView bXo;
    private int bXp;
    private AgreeData bXq;
    private com.baidu.tieba.tbadkCore.data.e bXr;
    private String bXs;
    private CustomMessageListener bXt;
    private CustomMessageListener bXu;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bXt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bXq != null && !TextUtils.isEmpty(AgreeAloneView.this.bXq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bXq.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bXr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JW();
                    }
                }
            }
        };
        this.bXu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bXq != null && !TextUtils.isEmpty(AgreeAloneView.this.bXq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bXq.postId.equals(agreeData.postId) && AgreeAloneView.this.bXr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JW();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aM(view);
            }
        };
        init(context);
    }

    public AgreeAloneView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bXt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bXq != null && !TextUtils.isEmpty(AgreeAloneView.this.bXq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bXq.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bXr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JW();
                    }
                }
            }
        };
        this.bXu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bXq != null && !TextUtils.isEmpty(AgreeAloneView.this.bXq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bXq.postId.equals(agreeData.postId) && AgreeAloneView.this.bXr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JW();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aM(view);
            }
        };
        init(context);
    }

    public AgreeAloneView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bXt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bXq != null && !TextUtils.isEmpty(AgreeAloneView.this.bXq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bXq.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bXr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JW();
                    }
                }
            }
        };
        this.bXu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bXq != null && !TextUtils.isEmpty(AgreeAloneView.this.bXq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bXq.postId.equals(agreeData.postId) && AgreeAloneView.this.bXr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bXq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bXq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bXq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bXq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bXq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JW();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aM(view);
            }
        };
        init(context);
    }

    public void setTopicId(String str) {
        this.bXs = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(3);
        this.bXp = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds112);
        int g = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds19);
        this.bXn = new TBLottieAnimationView(context);
        this.bXn.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bXp, this.bXp);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -g;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bXn, layoutParams);
        this.bXn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bXn.setOnClickListener(this.mOnClickListener);
        this.bXn.setAnimation(R.raw.agree);
        this.bXo = new TextView(context);
        this.bXo.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bXo, layoutParams2);
        this.bXr = new com.baidu.tieba.tbadkCore.data.e();
        this.bXr.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bXq = agreeData;
            JW();
        }
    }

    public void JW() {
        if (this.bXq != null) {
            if (this.bXq.hasAgree) {
                this.bXo.setText(aq.aN(this.bXq.agreeNum));
                if (this.bXq.agreeType == 2) {
                    this.bXn.setMinAndMaxProgress(0.0f, 1.0f);
                    this.bXn.setProgress(1.0f);
                    this.bXo.setTextColor(am.getColor(R.color.cp_cont_h));
                    return;
                }
                this.bXn.setMinAndMaxProgress(0.0f, 0.0f);
                this.bXn.setProgress(0.0f);
                this.bXo.setTextColor(am.getColor(R.color.cp_cont_j));
                return;
            }
            if (this.bXq.agreeNum != 0) {
                this.bXo.setText(aq.aN(this.bXq.agreeNum));
            } else {
                this.bXo.setText(getResources().getString(R.string.zan));
            }
            this.bXn.setMinAndMaxProgress(0.0f, 0.0f);
            this.bXn.setProgress(0.0f);
            this.bXo.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void ek(boolean z) {
        if (z) {
            this.bXn.setMinAndMaxProgress(0.0f, 1.0f);
            this.bXn.br();
            this.bXo.setText(aq.aN(this.bXq.agreeNum));
            this.bXo.setTextColor(am.getColor(R.color.cp_cont_h));
            return;
        }
        JW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(View view) {
        int i;
        if (this.bXq != null && bc.cF(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).br();
            }
            if (view.getId() == this.bXn.getId()) {
                if (this.bXq.hasAgree) {
                    if (this.bXq.agreeType == 2) {
                        this.bXq.agreeType = 2;
                        this.bXq.hasAgree = false;
                        this.bXq.diffAgreeNum--;
                        this.bXq.agreeNum--;
                        ek(false);
                        i = 1;
                    } else {
                        this.bXq.agreeType = 2;
                        this.bXq.hasAgree = true;
                        this.bXq.diffAgreeNum += 2;
                        this.bXq.agreeNum++;
                        this.bXq.disAgreeNum--;
                        ek(true);
                        com.baidu.tieba.n.a.cir().z(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.bXq.agreeType = 2;
                    this.bXq.hasAgree = true;
                    this.bXq.diffAgreeNum++;
                    this.bXq.agreeNum++;
                    ek(true);
                    com.baidu.tieba.n.a.cir().z(getTbPageContext());
                    if (!StringUtils.isNull(this.bXs)) {
                        TiebaStatic.log(new an("c13358").bT("tid", this.bXq.threadId).bT("topic_id", this.bXs));
                    }
                    i = 0;
                }
                iz(i);
            }
            this.bXr.agreeData = this.bXq;
            if (this.bXq.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bXr));
                a(this.bXq, "isInThread");
            } else if (this.bXq.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bXr));
                a(this.bXq, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iz(int i) {
        if (this.bXq != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bXq.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bXq.objType == 0) {
                this.bXq.objType = 1;
            }
            httpMessage.addParam("obj_type", this.bXq.objType);
            httpMessage.addParam("agree_type", this.bXq.agreeType);
            httpMessage.addParam("forum_id", this.bXq.forumId);
            if (!TextUtils.isEmpty(this.bXq.postId)) {
                httpMessage.addParam("post_id", this.bXq.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bXq == null && this.mSkinType != i) {
            JW();
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
        MessageManager.getInstance().registerListener(this.bXt);
        MessageManager.getInstance().registerListener(this.bXu);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bXt);
        MessageManager.getInstance().unRegisterListener(this.bXu);
    }
}
