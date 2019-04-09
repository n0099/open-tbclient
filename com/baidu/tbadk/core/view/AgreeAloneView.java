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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.AgreeData;
/* loaded from: classes3.dex */
public class AgreeAloneView extends LinearLayout {
    private TBLottieAnimationView bNB;
    private TextView bNC;
    private int bND;
    private AgreeData bNE;
    private com.baidu.tieba.tbadkCore.data.e bNF;
    private String bNG;
    private CustomMessageListener bNH;
    private CustomMessageListener bNI;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bNH = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNE != null && !TextUtils.isEmpty(AgreeAloneView.this.bNE.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bNE.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNF.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GP();
                    }
                }
            }
        };
        this.bNI = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNE != null && !TextUtils.isEmpty(AgreeAloneView.this.bNE.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bNE.postId.equals(agreeData.postId) && AgreeAloneView.this.bNF.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GP();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aE(view);
            }
        };
        init(context);
    }

    public AgreeAloneView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bNH = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNE != null && !TextUtils.isEmpty(AgreeAloneView.this.bNE.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bNE.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNF.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GP();
                    }
                }
            }
        };
        this.bNI = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNE != null && !TextUtils.isEmpty(AgreeAloneView.this.bNE.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bNE.postId.equals(agreeData.postId) && AgreeAloneView.this.bNF.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GP();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aE(view);
            }
        };
        init(context);
    }

    public AgreeAloneView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bNH = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNE != null && !TextUtils.isEmpty(AgreeAloneView.this.bNE.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bNE.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNF.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GP();
                    }
                }
            }
        };
        this.bNI = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNE != null && !TextUtils.isEmpty(AgreeAloneView.this.bNE.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bNE.postId.equals(agreeData.postId) && AgreeAloneView.this.bNF.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNE.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNE.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNE.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNE.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNE.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GP();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aE(view);
            }
        };
        init(context);
    }

    public void setTopicId(String str) {
        this.bNG = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bND = com.baidu.adp.lib.util.l.h(context, d.e.tbds112);
        int h = com.baidu.adp.lib.util.l.h(context, d.e.tbds19);
        this.bNC = new TextView(context);
        this.bNC.setTextSize(0, com.baidu.adp.lib.util.l.h(context, d.e.tbfontsize34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -h;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds_2);
        addView(this.bNC, layoutParams);
        this.bNB = new TBLottieAnimationView(context);
        this.bNB.setId(d.g.img_agree);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.bND, this.bND);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = -com.baidu.adp.lib.util.l.h(context, d.e.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds_2);
        addView(this.bNB, layoutParams2);
        this.bNB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNB.setOnClickListener(this.mOnClickListener);
        this.bNB.setAnimation(d.i.agree);
        if (getTbPageContext() != null) {
            getTbPageContext().registerListener(this.bNH);
            getTbPageContext().registerListener(this.bNI);
        }
        this.bNF = new com.baidu.tieba.tbadkCore.data.e();
        this.bNF.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bNE = agreeData;
            GP();
        }
    }

    public void GP() {
        if (this.bNE != null) {
            if (this.bNE.hasAgree) {
                this.bNC.setText(ap.ay(this.bNE.agreeNum));
                if (this.bNE.agreeType == 2) {
                    this.bNB.setMinAndMaxProgress(0.0f, 1.0f);
                    this.bNB.setProgress(1.0f);
                    this.bNC.setTextColor(al.getColor(d.C0277d.cp_cont_h));
                    return;
                }
                this.bNB.setMinAndMaxProgress(0.0f, 0.0f);
                this.bNB.setProgress(0.0f);
                this.bNC.setTextColor(al.getColor(d.C0277d.cp_cont_j));
                return;
            }
            if (this.bNE.agreeNum != 0) {
                this.bNC.setText(ap.ay(this.bNE.agreeNum));
            } else {
                this.bNC.setText(getResources().getString(d.j.zan));
            }
            this.bNB.setMinAndMaxProgress(0.0f, 0.0f);
            this.bNB.setProgress(0.0f);
            this.bNC.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        }
    }

    public void dH(boolean z) {
        if (z) {
            this.bNB.setMinAndMaxProgress(0.0f, 1.0f);
            this.bNB.cu();
            this.bNC.setText(ap.ay(this.bNE.agreeNum));
            this.bNC.setTextColor(al.getColor(d.C0277d.cp_cont_h));
            return;
        }
        GP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(View view) {
        int i;
        if (this.bNE != null && bc.cZ(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).cu();
            }
            if (view.getId() == this.bNB.getId()) {
                if (this.bNE.hasAgree) {
                    if (this.bNE.agreeType == 2) {
                        this.bNE.agreeType = 2;
                        this.bNE.hasAgree = false;
                        this.bNE.diffAgreeNum--;
                        this.bNE.agreeNum--;
                        dH(false);
                        i = 1;
                    } else {
                        this.bNE.agreeType = 2;
                        this.bNE.hasAgree = true;
                        this.bNE.diffAgreeNum += 2;
                        this.bNE.agreeNum++;
                        this.bNE.disAgreeNum--;
                        dH(true);
                        com.baidu.tieba.n.a.bWn().x(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.bNE.agreeType = 2;
                    this.bNE.hasAgree = true;
                    this.bNE.diffAgreeNum++;
                    this.bNE.agreeNum++;
                    dH(true);
                    com.baidu.tieba.n.a.bWn().x(getTbPageContext());
                    if (!StringUtils.isNull(this.bNG)) {
                        TiebaStatic.log(new am("c13358").bJ("tid", this.bNE.threadId).bJ("topic_id", this.bNG));
                    }
                    i = 0;
                }
                hC(i);
            }
            this.bNF.agreeData = this.bNE;
            if (this.bNE.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bNF));
                a(this.bNE, "isInThread");
            } else if (this.bNE.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bNF));
                a(this.bNE, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void hC(int i) {
        if (this.bNE != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bNE.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bNE.objType == 0) {
                this.bNE.objType = 1;
            }
            httpMessage.addParam("obj_type", this.bNE.objType);
            httpMessage.addParam("agree_type", this.bNE.agreeType);
            httpMessage.addParam("forum_id", this.bNE.forumId);
            if (!TextUtils.isEmpty(this.bNE.postId)) {
                httpMessage.addParam("post_id", this.bNE.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bNE == null && this.mSkinType != i) {
            GP();
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
}
