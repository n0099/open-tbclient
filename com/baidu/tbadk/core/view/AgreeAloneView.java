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
    private CustomMessageListener bWA;
    private CustomMessageListener bWB;
    private TBLottieAnimationView bWu;
    private TextView bWv;
    private int bWw;
    private AgreeData bWx;
    private com.baidu.tieba.tbadkCore.data.e bWy;
    private String bWz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bWA = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWx != null && !TextUtils.isEmpty(AgreeAloneView.this.bWx.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bWx.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bWy.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JS();
                    }
                }
            }
        };
        this.bWB = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWx != null && !TextUtils.isEmpty(AgreeAloneView.this.bWx.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bWx.postId.equals(agreeData.postId) && AgreeAloneView.this.bWy.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
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
        this.bWA = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWx != null && !TextUtils.isEmpty(AgreeAloneView.this.bWx.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bWx.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bWy.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JS();
                    }
                }
            }
        };
        this.bWB = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWx != null && !TextUtils.isEmpty(AgreeAloneView.this.bWx.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bWx.postId.equals(agreeData.postId) && AgreeAloneView.this.bWy.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
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
        this.bWA = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWx != null && !TextUtils.isEmpty(AgreeAloneView.this.bWx.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bWx.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bWy.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.JS();
                    }
                }
            }
        };
        this.bWB = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bWx != null && !TextUtils.isEmpty(AgreeAloneView.this.bWx.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bWx.postId.equals(agreeData.postId) && AgreeAloneView.this.bWy.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bWx.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bWx.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bWx.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bWx.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bWx.disAgreeNum = agreeData.disAgreeNum;
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
        this.bWz = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bWw = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds112);
        int g = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds19);
        this.bWv = new TextView(context);
        this.bWv.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -g;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bWv, layoutParams);
        this.bWu = new TBLottieAnimationView(context);
        this.bWu.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.bWw, this.bWw);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bWu, layoutParams2);
        this.bWu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bWu.setOnClickListener(this.mOnClickListener);
        this.bWu.setAnimation(R.raw.agree);
        this.bWy = new com.baidu.tieba.tbadkCore.data.e();
        this.bWy.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bWx = agreeData;
            JS();
        }
    }

    public void JS() {
        if (this.bWx != null) {
            if (this.bWx.hasAgree) {
                this.bWv.setText(aq.aN(this.bWx.agreeNum));
                if (this.bWx.agreeType == 2) {
                    this.bWu.setMinAndMaxProgress(0.0f, 1.0f);
                    this.bWu.setProgress(1.0f);
                    this.bWv.setTextColor(am.getColor(R.color.cp_cont_h));
                    return;
                }
                this.bWu.setMinAndMaxProgress(0.0f, 0.0f);
                this.bWu.setProgress(0.0f);
                this.bWv.setTextColor(am.getColor(R.color.cp_cont_j));
                return;
            }
            if (this.bWx.agreeNum != 0) {
                this.bWv.setText(aq.aN(this.bWx.agreeNum));
            } else {
                this.bWv.setText(getResources().getString(R.string.zan));
            }
            this.bWu.setMinAndMaxProgress(0.0f, 0.0f);
            this.bWu.setProgress(0.0f);
            this.bWv.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void eh(boolean z) {
        if (z) {
            this.bWu.setMinAndMaxProgress(0.0f, 1.0f);
            this.bWu.br();
            this.bWv.setText(aq.aN(this.bWx.agreeNum));
            this.bWv.setTextColor(am.getColor(R.color.cp_cont_h));
            return;
        }
        JS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(View view) {
        int i;
        if (this.bWx != null && bd.cF(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).br();
            }
            if (view.getId() == this.bWu.getId()) {
                if (this.bWx.hasAgree) {
                    if (this.bWx.agreeType == 2) {
                        this.bWx.agreeType = 2;
                        this.bWx.hasAgree = false;
                        this.bWx.diffAgreeNum--;
                        this.bWx.agreeNum--;
                        eh(false);
                        i = 1;
                    } else {
                        this.bWx.agreeType = 2;
                        this.bWx.hasAgree = true;
                        this.bWx.diffAgreeNum += 2;
                        this.bWx.agreeNum++;
                        this.bWx.disAgreeNum--;
                        eh(true);
                        com.baidu.tieba.n.a.chD().z(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.bWx.agreeType = 2;
                    this.bWx.hasAgree = true;
                    this.bWx.diffAgreeNum++;
                    this.bWx.agreeNum++;
                    eh(true);
                    com.baidu.tieba.n.a.chD().z(getTbPageContext());
                    if (!StringUtils.isNull(this.bWz)) {
                        TiebaStatic.log(new an("c13358").bT("tid", this.bWx.threadId).bT("topic_id", this.bWz));
                    }
                    i = 0;
                }
                iw(i);
            }
            this.bWy.agreeData = this.bWx;
            if (this.bWx.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bWy));
                a(this.bWx, "isInThread");
            } else if (this.bWx.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bWy));
                a(this.bWx, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iw(int i) {
        if (this.bWx != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bWx.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bWx.objType == 0) {
                this.bWx.objType = 1;
            }
            httpMessage.addParam("obj_type", this.bWx.objType);
            httpMessage.addParam("agree_type", this.bWx.agreeType);
            httpMessage.addParam("forum_id", this.bWx.forumId);
            if (!TextUtils.isEmpty(this.bWx.postId)) {
                httpMessage.addParam("post_id", this.bWx.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bWx == null && this.mSkinType != i) {
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
        MessageManager.getInstance().registerListener(this.bWA);
        MessageManager.getInstance().registerListener(this.bWB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bWA);
        MessageManager.getInstance().unRegisterListener(this.bWB);
    }
}
