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
    private TBLottieAnimationView bNA;
    private TextView bNB;
    private int bNC;
    private AgreeData bND;
    private com.baidu.tieba.tbadkCore.data.e bNE;
    private String bNF;
    private CustomMessageListener bNG;
    private CustomMessageListener bNH;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bNG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bND != null && !TextUtils.isEmpty(AgreeAloneView.this.bND.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bND.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bND.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bND.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GP();
                    }
                }
            }
        };
        this.bNH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bND != null && !TextUtils.isEmpty(AgreeAloneView.this.bND.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bND.postId.equals(agreeData.postId) && AgreeAloneView.this.bNE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bND.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bND.disAgreeNum = agreeData.disAgreeNum;
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
        this.bNG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bND != null && !TextUtils.isEmpty(AgreeAloneView.this.bND.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bND.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bND.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bND.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GP();
                    }
                }
            }
        };
        this.bNH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bND != null && !TextUtils.isEmpty(AgreeAloneView.this.bND.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bND.postId.equals(agreeData.postId) && AgreeAloneView.this.bNE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bND.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bND.disAgreeNum = agreeData.disAgreeNum;
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
        this.bNG = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bND != null && !TextUtils.isEmpty(AgreeAloneView.this.bND.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bND.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bND.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bND.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GP();
                    }
                }
            }
        };
        this.bNH = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bND != null && !TextUtils.isEmpty(AgreeAloneView.this.bND.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bND.postId.equals(agreeData.postId) && AgreeAloneView.this.bNE.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bND.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bND.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bND.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bND.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bND.disAgreeNum = agreeData.disAgreeNum;
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
        this.bNF = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bNC = com.baidu.adp.lib.util.l.h(context, d.e.tbds112);
        int h = com.baidu.adp.lib.util.l.h(context, d.e.tbds19);
        this.bNB = new TextView(context);
        this.bNB.setTextSize(0, com.baidu.adp.lib.util.l.h(context, d.e.tbfontsize34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -h;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds_2);
        addView(this.bNB, layoutParams);
        this.bNA = new TBLottieAnimationView(context);
        this.bNA.setId(d.g.img_agree);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.bNC, this.bNC);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = -com.baidu.adp.lib.util.l.h(context, d.e.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds_2);
        addView(this.bNA, layoutParams2);
        this.bNA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNA.setOnClickListener(this.mOnClickListener);
        this.bNA.setAnimation(d.i.agree);
        if (getTbPageContext() != null) {
            getTbPageContext().registerListener(this.bNG);
            getTbPageContext().registerListener(this.bNH);
        }
        this.bNE = new com.baidu.tieba.tbadkCore.data.e();
        this.bNE.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bND = agreeData;
            GP();
        }
    }

    public void GP() {
        if (this.bND != null) {
            if (this.bND.hasAgree) {
                this.bNB.setText(ap.ay(this.bND.agreeNum));
                if (this.bND.agreeType == 2) {
                    this.bNA.setMinAndMaxProgress(0.0f, 1.0f);
                    this.bNA.setProgress(1.0f);
                    this.bNB.setTextColor(al.getColor(d.C0277d.cp_cont_h));
                    return;
                }
                this.bNA.setMinAndMaxProgress(0.0f, 0.0f);
                this.bNA.setProgress(0.0f);
                this.bNB.setTextColor(al.getColor(d.C0277d.cp_cont_j));
                return;
            }
            if (this.bND.agreeNum != 0) {
                this.bNB.setText(ap.ay(this.bND.agreeNum));
            } else {
                this.bNB.setText(getResources().getString(d.j.zan));
            }
            this.bNA.setMinAndMaxProgress(0.0f, 0.0f);
            this.bNA.setProgress(0.0f);
            this.bNB.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        }
    }

    public void dH(boolean z) {
        if (z) {
            this.bNA.setMinAndMaxProgress(0.0f, 1.0f);
            this.bNA.cu();
            this.bNB.setText(ap.ay(this.bND.agreeNum));
            this.bNB.setTextColor(al.getColor(d.C0277d.cp_cont_h));
            return;
        }
        GP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(View view) {
        int i;
        if (this.bND != null && bc.cZ(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).cu();
            }
            if (view.getId() == this.bNA.getId()) {
                if (this.bND.hasAgree) {
                    if (this.bND.agreeType == 2) {
                        this.bND.agreeType = 2;
                        this.bND.hasAgree = false;
                        this.bND.diffAgreeNum--;
                        this.bND.agreeNum--;
                        dH(false);
                        i = 1;
                    } else {
                        this.bND.agreeType = 2;
                        this.bND.hasAgree = true;
                        this.bND.diffAgreeNum += 2;
                        this.bND.agreeNum++;
                        this.bND.disAgreeNum--;
                        dH(true);
                        com.baidu.tieba.n.a.bWn().x(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.bND.agreeType = 2;
                    this.bND.hasAgree = true;
                    this.bND.diffAgreeNum++;
                    this.bND.agreeNum++;
                    dH(true);
                    com.baidu.tieba.n.a.bWn().x(getTbPageContext());
                    if (!StringUtils.isNull(this.bNF)) {
                        TiebaStatic.log(new am("c13358").bJ("tid", this.bND.threadId).bJ("topic_id", this.bNF));
                    }
                    i = 0;
                }
                hC(i);
            }
            this.bNE.agreeData = this.bND;
            if (this.bND.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bNE));
                a(this.bND, "isInThread");
            } else if (this.bND.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bNE));
                a(this.bND, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void hC(int i) {
        if (this.bND != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bND.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bND.objType == 0) {
                this.bND.objType = 1;
            }
            httpMessage.addParam("obj_type", this.bND.objType);
            httpMessage.addParam("agree_type", this.bND.agreeType);
            httpMessage.addParam("forum_id", this.bND.forumId);
            if (!TextUtils.isEmpty(this.bND.postId)) {
                httpMessage.addParam("post_id", this.bND.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bND == null && this.mSkinType != i) {
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
