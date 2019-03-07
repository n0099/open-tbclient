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
    private AgreeData bNA;
    private com.baidu.tieba.tbadkCore.data.e bNB;
    private String bNC;
    private CustomMessageListener bND;
    private CustomMessageListener bNE;
    private TBLottieAnimationView bNx;
    private TextView bNy;
    private int bNz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bND = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNA != null && !TextUtils.isEmpty(AgreeAloneView.this.bNA.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bNA.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNB.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GR();
                    }
                }
            }
        };
        this.bNE = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNA != null && !TextUtils.isEmpty(AgreeAloneView.this.bNA.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bNA.postId.equals(agreeData.postId) && AgreeAloneView.this.bNB.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
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
        this.bND = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNA != null && !TextUtils.isEmpty(AgreeAloneView.this.bNA.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bNA.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNB.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GR();
                    }
                }
            }
        };
        this.bNE = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNA != null && !TextUtils.isEmpty(AgreeAloneView.this.bNA.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bNA.postId.equals(agreeData.postId) && AgreeAloneView.this.bNB.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
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
        this.bND = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNA != null && !TextUtils.isEmpty(AgreeAloneView.this.bNA.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bNA.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bNB.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.GR();
                    }
                }
            }
        };
        this.bNE = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bNA != null && !TextUtils.isEmpty(AgreeAloneView.this.bNA.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bNA.postId.equals(agreeData.postId) && AgreeAloneView.this.bNB.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bNA.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bNA.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bNA.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bNA.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bNA.disAgreeNum = agreeData.disAgreeNum;
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
        this.bNC = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bNz = com.baidu.adp.lib.util.l.h(context, d.e.tbds112);
        int h = com.baidu.adp.lib.util.l.h(context, d.e.tbds19);
        this.bNy = new TextView(context);
        this.bNy.setTextSize(0, com.baidu.adp.lib.util.l.h(context, d.e.tbfontsize34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -h;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds_2);
        addView(this.bNy, layoutParams);
        this.bNx = new TBLottieAnimationView(context);
        this.bNx.setId(d.g.img_agree);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.bNz, this.bNz);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = -com.baidu.adp.lib.util.l.h(context, d.e.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds_2);
        addView(this.bNx, layoutParams2);
        this.bNx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bNx.setOnClickListener(this.mOnClickListener);
        this.bNx.setAnimation(d.i.agree);
        if (getTbPageContext() != null) {
            getTbPageContext().registerListener(this.bND);
            getTbPageContext().registerListener(this.bNE);
        }
        this.bNB = new com.baidu.tieba.tbadkCore.data.e();
        this.bNB.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bNA = agreeData;
            GR();
        }
    }

    public void GR() {
        if (this.bNA != null) {
            if (this.bNA.hasAgree) {
                this.bNy.setText(ap.ay(this.bNA.agreeNum));
                if (this.bNA.agreeType == 2) {
                    this.bNx.setMinAndMaxProgress(0.0f, 1.0f);
                    this.bNx.setProgress(1.0f);
                    this.bNy.setTextColor(al.getColor(d.C0236d.cp_cont_h));
                    return;
                }
                this.bNx.setMinAndMaxProgress(0.0f, 0.0f);
                this.bNx.setProgress(0.0f);
                this.bNy.setTextColor(al.getColor(d.C0236d.cp_cont_j));
                return;
            }
            if (this.bNA.agreeNum != 0) {
                this.bNy.setText(ap.ay(this.bNA.agreeNum));
            } else {
                this.bNy.setText(getResources().getString(d.j.zan));
            }
            this.bNx.setMinAndMaxProgress(0.0f, 0.0f);
            this.bNx.setProgress(0.0f);
            this.bNy.setTextColor(al.getColor(d.C0236d.cp_cont_j));
        }
    }

    public void dH(boolean z) {
        if (z) {
            this.bNx.setMinAndMaxProgress(0.0f, 1.0f);
            this.bNx.cu();
            this.bNy.setText(ap.ay(this.bNA.agreeNum));
            this.bNy.setTextColor(al.getColor(d.C0236d.cp_cont_h));
            return;
        }
        GR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(View view) {
        int i;
        if (this.bNA != null && bc.cZ(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).cu();
            }
            if (view.getId() == this.bNx.getId()) {
                if (this.bNA.hasAgree) {
                    if (this.bNA.agreeType == 2) {
                        this.bNA.agreeType = 2;
                        this.bNA.hasAgree = false;
                        this.bNA.diffAgreeNum--;
                        this.bNA.agreeNum--;
                        dH(false);
                        i = 1;
                    } else {
                        this.bNA.agreeType = 2;
                        this.bNA.hasAgree = true;
                        this.bNA.diffAgreeNum += 2;
                        this.bNA.agreeNum++;
                        this.bNA.disAgreeNum--;
                        dH(true);
                        com.baidu.tieba.n.a.bWo().y(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.bNA.agreeType = 2;
                    this.bNA.hasAgree = true;
                    this.bNA.diffAgreeNum++;
                    this.bNA.agreeNum++;
                    dH(true);
                    com.baidu.tieba.n.a.bWo().y(getTbPageContext());
                    if (!StringUtils.isNull(this.bNC)) {
                        TiebaStatic.log(new am("c13358").bJ("tid", this.bNA.threadId).bJ("topic_id", this.bNC));
                    }
                    i = 0;
                }
                hD(i);
            }
            this.bNB.agreeData = this.bNA;
            if (this.bNA.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bNB));
                a(this.bNA, "isInThread");
            } else if (this.bNA.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bNB));
                a(this.bNA, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void hD(int i) {
        if (this.bNA != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bNA.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bNA.objType == 0) {
                this.bNA.objType = 1;
            }
            httpMessage.addParam("obj_type", this.bNA.objType);
            httpMessage.addParam("agree_type", this.bNA.agreeType);
            httpMessage.addParam("forum_id", this.bNA.forumId);
            if (!TextUtils.isEmpty(this.bNA.postId)) {
                httpMessage.addParam("post_id", this.bNA.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bNA == null && this.mSkinType != i) {
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
