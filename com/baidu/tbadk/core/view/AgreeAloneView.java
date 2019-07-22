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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
/* loaded from: classes3.dex */
public class AgreeAloneView extends LinearLayout {
    private TBLottieAnimationView bWo;
    private TextView bWp;
    private int bWq;
    private AgreeData bWr;
    private com.baidu.tieba.tbadkCore.data.e bWs;
    private String bWt;
    private CustomMessageListener bWu;
    private CustomMessageListener bWv;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bWu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWr != null && !TextUtils.isEmpty(AgreeAloneView.this.bWr.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bWr.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bWs.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JS();
                    }
                }
            }
        };
        this.bWv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWr != null && !TextUtils.isEmpty(AgreeAloneView.this.bWr.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bWr.postId.equals(agreeData.postId) && AgreeAloneView.this.bWs.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JS();
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
        this.bWu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWr != null && !TextUtils.isEmpty(AgreeAloneView.this.bWr.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bWr.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bWs.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JS();
                    }
                }
            }
        };
        this.bWv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWr != null && !TextUtils.isEmpty(AgreeAloneView.this.bWr.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bWr.postId.equals(agreeData.postId) && AgreeAloneView.this.bWs.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JS();
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
        this.bWu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWr != null && !TextUtils.isEmpty(AgreeAloneView.this.bWr.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bWr.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bWs.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JS();
                    }
                }
            }
        };
        this.bWv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWr != null && !TextUtils.isEmpty(AgreeAloneView.this.bWr.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bWr.postId.equals(agreeData.postId) && AgreeAloneView.this.bWs.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWr.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWr.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWr.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWr.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWr.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JS();
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
        this.bWt = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bWq = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds112);
        int g = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds19);
        this.bWp = new TextView(context);
        this.bWp.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -g;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bWp, layoutParams);
        this.bWo = new TBLottieAnimationView(context);
        this.bWo.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.bWq, this.bWq);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bWo, layoutParams2);
        this.bWo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bWo.setOnClickListener(this.mOnClickListener);
        this.bWo.setAnimation(R.raw.agree);
        this.bWs = new com.baidu.tieba.tbadkCore.data.e();
        this.bWs.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bWr = agreeData;
            JS();
        }
    }

    public void JS() {
        if (this.bWr != null) {
            if (this.bWr.hasAgree) {
                this.bWp.setText(aq.aN(this.bWr.agreeNum));
                if (this.bWr.agreeType == 2) {
                    this.bWo.setMinAndMaxProgress(0.0f, 1.0f);
                    this.bWo.setProgress(1.0f);
                    this.bWp.setTextColor(am.getColor(R.color.cp_cont_h));
                    return;
                }
                this.bWo.setMinAndMaxProgress(0.0f, 0.0f);
                this.bWo.setProgress(0.0f);
                this.bWp.setTextColor(am.getColor(R.color.cp_cont_j));
                return;
            }
            if (this.bWr.agreeNum != 0) {
                this.bWp.setText(aq.aN(this.bWr.agreeNum));
            } else {
                this.bWp.setText(getResources().getString(R.string.zan));
            }
            this.bWo.setMinAndMaxProgress(0.0f, 0.0f);
            this.bWo.setProgress(0.0f);
            this.bWp.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void eh(boolean z) {
        if (z) {
            this.bWo.setMinAndMaxProgress(0.0f, 1.0f);
            this.bWo.br();
            this.bWp.setText(aq.aN(this.bWr.agreeNum));
            this.bWp.setTextColor(am.getColor(R.color.cp_cont_h));
            return;
        }
        JS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(View view) {
        int i;
        if (this.bWr != null && bd.cF(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).br();
            }
            if (view.getId() == this.bWo.getId()) {
                if (this.bWr.hasAgree) {
                    if (this.bWr.agreeType == 2) {
                        this.bWr.agreeType = 2;
                        this.bWr.hasAgree = false;
                        this.bWr.diffAgreeNum--;
                        this.bWr.agreeNum--;
                        eh(false);
                        i = 1;
                    } else {
                        this.bWr.agreeType = 2;
                        this.bWr.hasAgree = true;
                        this.bWr.diffAgreeNum += 2;
                        this.bWr.agreeNum++;
                        this.bWr.disAgreeNum--;
                        eh(true);
                        com.baidu.tieba.n.a.chl().z(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.bWr.agreeType = 2;
                    this.bWr.hasAgree = true;
                    this.bWr.diffAgreeNum++;
                    this.bWr.agreeNum++;
                    eh(true);
                    com.baidu.tieba.n.a.chl().z(getTbPageContext());
                    if (!StringUtils.isNull(this.bWt)) {
                        TiebaStatic.log(new an("c13358").bT("tid", this.bWr.threadId).bT("topic_id", this.bWt));
                    }
                    i = 0;
                }
                iw(i);
            }
            this.bWs.agreeData = this.bWr;
            if (this.bWr.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bWs));
                a(this.bWr, "isInThread");
            } else if (this.bWr.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bWs));
                a(this.bWr, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iw(int i) {
        if (this.bWr != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bWr.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bWr.objType == 0) {
                this.bWr.objType = 1;
            }
            httpMessage.addParam("obj_type", this.bWr.objType);
            httpMessage.addParam("agree_type", this.bWr.agreeType);
            httpMessage.addParam("forum_id", this.bWr.forumId);
            if (!TextUtils.isEmpty(this.bWr.postId)) {
                httpMessage.addParam("post_id", this.bWr.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWr == null && this.mSkinType != i) {
            JS();
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
        MessageManager.getInstance().registerListener(this.bWu);
        MessageManager.getInstance().registerListener(this.bWv);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bWu);
        MessageManager.getInstance().unRegisterListener(this.bWv);
    }
}
