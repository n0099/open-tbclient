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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
/* loaded from: classes3.dex */
public class AgreeAloneView extends LinearLayout {
    private TBLottieAnimationView bVm;
    private TextView bVn;
    private int bVo;
    private AgreeData bVp;
    private com.baidu.tieba.tbadkCore.data.e bVq;
    private String bVr;
    private CustomMessageListener bVs;
    private CustomMessageListener bVt;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bVs = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVp != null && !TextUtils.isEmpty(AgreeAloneView.this.bVp.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bVp.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bVq.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.Jf();
                    }
                }
            }
        };
        this.bVt = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVp != null && !TextUtils.isEmpty(AgreeAloneView.this.bVp.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bVp.postId.equals(agreeData.postId) && AgreeAloneView.this.bVq.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.Jf();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aK(view);
            }
        };
        init(context);
    }

    public AgreeAloneView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bVs = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVp != null && !TextUtils.isEmpty(AgreeAloneView.this.bVp.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bVp.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bVq.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.Jf();
                    }
                }
            }
        };
        this.bVt = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVp != null && !TextUtils.isEmpty(AgreeAloneView.this.bVp.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bVp.postId.equals(agreeData.postId) && AgreeAloneView.this.bVq.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.Jf();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aK(view);
            }
        };
        init(context);
    }

    public AgreeAloneView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bVs = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVp != null && !TextUtils.isEmpty(AgreeAloneView.this.bVp.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bVp.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bVq.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.Jf();
                    }
                }
            }
        };
        this.bVt = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVp != null && !TextUtils.isEmpty(AgreeAloneView.this.bVp.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bVp.postId.equals(agreeData.postId) && AgreeAloneView.this.bVq.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.Jf();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeAloneView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeAloneView.this.aK(view);
            }
        };
        init(context);
    }

    public void setTopicId(String str) {
        this.bVr = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bVo = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds112);
        int g = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds19);
        this.bVn = new TextView(context);
        this.bVn.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -g;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bVn, layoutParams);
        this.bVm = new TBLottieAnimationView(context);
        this.bVm.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.bVo, this.bVo);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bVm, layoutParams2);
        this.bVm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bVm.setOnClickListener(this.mOnClickListener);
        this.bVm.setAnimation(R.raw.agree);
        this.bVq = new com.baidu.tieba.tbadkCore.data.e();
        this.bVq.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bVp = agreeData;
            Jf();
        }
    }

    public void Jf() {
        if (this.bVp != null) {
            if (this.bVp.hasAgree) {
                this.bVn.setText(ap.aM(this.bVp.agreeNum));
                if (this.bVp.agreeType == 2) {
                    this.bVm.setMinAndMaxProgress(0.0f, 1.0f);
                    this.bVm.setProgress(1.0f);
                    this.bVn.setTextColor(al.getColor(R.color.cp_cont_h));
                    return;
                }
                this.bVm.setMinAndMaxProgress(0.0f, 0.0f);
                this.bVm.setProgress(0.0f);
                this.bVn.setTextColor(al.getColor(R.color.cp_cont_j));
                return;
            }
            if (this.bVp.agreeNum != 0) {
                this.bVn.setText(ap.aM(this.bVp.agreeNum));
            } else {
                this.bVn.setText(getResources().getString(R.string.zan));
            }
            this.bVm.setMinAndMaxProgress(0.0f, 0.0f);
            this.bVm.setProgress(0.0f);
            this.bVn.setTextColor(al.getColor(R.color.cp_cont_j));
        }
    }

    public void ed(boolean z) {
        if (z) {
            this.bVm.setMinAndMaxProgress(0.0f, 1.0f);
            this.bVm.bo();
            this.bVn.setText(ap.aM(this.bVp.agreeNum));
            this.bVn.setTextColor(al.getColor(R.color.cp_cont_h));
            return;
        }
        Jf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(View view) {
        int i;
        if (this.bVp != null && bc.cE(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).bo();
            }
            if (view.getId() == this.bVm.getId()) {
                if (this.bVp.hasAgree) {
                    if (this.bVp.agreeType == 2) {
                        this.bVp.agreeType = 2;
                        this.bVp.hasAgree = false;
                        this.bVp.diffAgreeNum--;
                        this.bVp.agreeNum--;
                        ed(false);
                        i = 1;
                    } else {
                        this.bVp.agreeType = 2;
                        this.bVp.hasAgree = true;
                        this.bVp.diffAgreeNum += 2;
                        this.bVp.agreeNum++;
                        this.bVp.disAgreeNum--;
                        ed(true);
                        com.baidu.tieba.n.a.cer().x(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.bVp.agreeType = 2;
                    this.bVp.hasAgree = true;
                    this.bVp.diffAgreeNum++;
                    this.bVp.agreeNum++;
                    ed(true);
                    com.baidu.tieba.n.a.cer().x(getTbPageContext());
                    if (!StringUtils.isNull(this.bVr)) {
                        TiebaStatic.log(new am("c13358").bT("tid", this.bVp.threadId).bT("topic_id", this.bVr));
                    }
                    i = 0;
                }
                iq(i);
            }
            this.bVq.agreeData = this.bVp;
            if (this.bVp.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bVq));
                a(this.bVp, "isInThread");
            } else if (this.bVp.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bVq));
                a(this.bVp, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iq(int i) {
        if (this.bVp != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bVp.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bVp.objType == 0) {
                this.bVp.objType = 1;
            }
            httpMessage.addParam("obj_type", this.bVp.objType);
            httpMessage.addParam("agree_type", this.bVp.agreeType);
            httpMessage.addParam("forum_id", this.bVp.forumId);
            if (!TextUtils.isEmpty(this.bVp.postId)) {
                httpMessage.addParam("post_id", this.bVp.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bVp == null && this.mSkinType != i) {
            Jf();
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
        MessageManager.getInstance().registerListener(this.bVs);
        MessageManager.getInstance().registerListener(this.bVt);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bVs);
        MessageManager.getInstance().unRegisterListener(this.bVt);
    }
}
