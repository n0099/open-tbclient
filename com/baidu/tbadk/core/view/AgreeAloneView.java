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
    private int bNA;
    private AgreeData bNB;
    private com.baidu.tieba.tbadkCore.data.e bNC;
    private String bND;
    private CustomMessageListener bNE;
    private CustomMessageListener bNF;
    private TBLottieAnimationView bNy;
    private TextView bNz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bNE = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNB != null && !TextUtils.isEmpty(AgreeAloneView.this.bNB.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bNB.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNC.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GR();
                    }
                }
            }
        };
        this.bNF = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNB != null && !TextUtils.isEmpty(AgreeAloneView.this.bNB.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bNB.postId.equals(agreeData.postId) && AgreeAloneView.this.bNC.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GR();
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
        this.bNE = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNB != null && !TextUtils.isEmpty(AgreeAloneView.this.bNB.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bNB.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNC.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GR();
                    }
                }
            }
        };
        this.bNF = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNB != null && !TextUtils.isEmpty(AgreeAloneView.this.bNB.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bNB.postId.equals(agreeData.postId) && AgreeAloneView.this.bNC.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GR();
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
        this.bNE = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNB != null && !TextUtils.isEmpty(AgreeAloneView.this.bNB.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bNB.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNC.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GR();
                    }
                }
            }
        };
        this.bNF = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNB != null && !TextUtils.isEmpty(AgreeAloneView.this.bNB.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bNB.postId.equals(agreeData.postId) && AgreeAloneView.this.bNC.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNB.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNB.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNB.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNB.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNB.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GR();
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
        this.bND = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bNA = com.baidu.adp.lib.util.l.h(context, d.e.tbds112);
        int h = com.baidu.adp.lib.util.l.h(context, d.e.tbds19);
        this.bNz = new TextView(context);
        this.bNz.setTextSize(0, com.baidu.adp.lib.util.l.h(context, d.e.tbfontsize34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -h;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds_2);
        addView(this.bNz, layoutParams);
        this.bNy = new TBLottieAnimationView(context);
        this.bNy.setId(d.g.img_agree);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.bNA, this.bNA);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = -com.baidu.adp.lib.util.l.h(context, d.e.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds_2);
        addView(this.bNy, layoutParams2);
        this.bNy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNy.setOnClickListener(this.mOnClickListener);
        this.bNy.setAnimation(d.i.agree);
        if (getTbPageContext() != null) {
            getTbPageContext().registerListener(this.bNE);
            getTbPageContext().registerListener(this.bNF);
        }
        this.bNC = new com.baidu.tieba.tbadkCore.data.e();
        this.bNC.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bNB = agreeData;
            GR();
        }
    }

    public void GR() {
        if (this.bNB != null) {
            if (this.bNB.hasAgree) {
                this.bNz.setText(ap.ay(this.bNB.agreeNum));
                if (this.bNB.agreeType == 2) {
                    this.bNy.setMinAndMaxProgress(0.0f, 1.0f);
                    this.bNy.setProgress(1.0f);
                    this.bNz.setTextColor(al.getColor(d.C0277d.cp_cont_h));
                    return;
                }
                this.bNy.setMinAndMaxProgress(0.0f, 0.0f);
                this.bNy.setProgress(0.0f);
                this.bNz.setTextColor(al.getColor(d.C0277d.cp_cont_j));
                return;
            }
            if (this.bNB.agreeNum != 0) {
                this.bNz.setText(ap.ay(this.bNB.agreeNum));
            } else {
                this.bNz.setText(getResources().getString(d.j.zan));
            }
            this.bNy.setMinAndMaxProgress(0.0f, 0.0f);
            this.bNy.setProgress(0.0f);
            this.bNz.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        }
    }

    public void dH(boolean z) {
        if (z) {
            this.bNy.setMinAndMaxProgress(0.0f, 1.0f);
            this.bNy.cu();
            this.bNz.setText(ap.ay(this.bNB.agreeNum));
            this.bNz.setTextColor(al.getColor(d.C0277d.cp_cont_h));
            return;
        }
        GR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(View view) {
        int i;
        if (this.bNB != null && bc.cZ(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).cu();
            }
            if (view.getId() == this.bNy.getId()) {
                if (this.bNB.hasAgree) {
                    if (this.bNB.agreeType == 2) {
                        this.bNB.agreeType = 2;
                        this.bNB.hasAgree = false;
                        this.bNB.diffAgreeNum--;
                        this.bNB.agreeNum--;
                        dH(false);
                        i = 1;
                    } else {
                        this.bNB.agreeType = 2;
                        this.bNB.hasAgree = true;
                        this.bNB.diffAgreeNum += 2;
                        this.bNB.agreeNum++;
                        this.bNB.disAgreeNum--;
                        dH(true);
                        com.baidu.tieba.n.a.bWr().y(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.bNB.agreeType = 2;
                    this.bNB.hasAgree = true;
                    this.bNB.diffAgreeNum++;
                    this.bNB.agreeNum++;
                    dH(true);
                    com.baidu.tieba.n.a.bWr().y(getTbPageContext());
                    if (!StringUtils.isNull(this.bND)) {
                        TiebaStatic.log(new am("c13358").bJ("tid", this.bNB.threadId).bJ("topic_id", this.bND));
                    }
                    i = 0;
                }
                hD(i);
            }
            this.bNC.agreeData = this.bNB;
            if (this.bNB.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bNC));
                a(this.bNB, "isInThread");
            } else if (this.bNB.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bNC));
                a(this.bNB, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void hD(int i) {
        if (this.bNB != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bNB.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bNB.objType == 0) {
                this.bNB.objType = 1;
            }
            httpMessage.addParam("obj_type", this.bNB.objType);
            httpMessage.addParam("agree_type", this.bNB.agreeType);
            httpMessage.addParam("forum_id", this.bNB.forumId);
            if (!TextUtils.isEmpty(this.bNB.postId)) {
                httpMessage.addParam("post_id", this.bNB.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bNB == null && this.mSkinType != i) {
            GR();
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
