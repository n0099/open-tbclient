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
    private TBLottieAnimationView bVn;
    private TextView bVo;
    private int bVp;
    private AgreeData bVq;
    private com.baidu.tieba.tbadkCore.data.e bVr;
    private String bVs;
    private CustomMessageListener bVt;
    private CustomMessageListener bVu;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeAloneView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bVt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVq != null && !TextUtils.isEmpty(AgreeAloneView.this.bVq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bVq.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bVr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.Jf();
                    }
                }
            }
        };
        this.bVu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVq != null && !TextUtils.isEmpty(AgreeAloneView.this.bVq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bVq.postId.equals(agreeData.postId) && AgreeAloneView.this.bVr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
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
        this.bVt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVq != null && !TextUtils.isEmpty(AgreeAloneView.this.bVq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bVq.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bVr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.Jf();
                    }
                }
            }
        };
        this.bVu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVq != null && !TextUtils.isEmpty(AgreeAloneView.this.bVq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bVq.postId.equals(agreeData.postId) && AgreeAloneView.this.bVr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
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
        this.bVt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVq != null && !TextUtils.isEmpty(AgreeAloneView.this.bVq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeAloneView.this.bVq.threadId.equals(agreeData.threadId) && AgreeAloneView.this.bVr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeAloneView.this.Jf();
                    }
                }
            }
        };
        this.bVu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeAloneView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeAloneView.this.bVq != null && !TextUtils.isEmpty(AgreeAloneView.this.bVq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeAloneView.this.bVq.postId.equals(agreeData.postId) && AgreeAloneView.this.bVr.uniqueId != eVar.uniqueId) {
                        AgreeAloneView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeAloneView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeAloneView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeAloneView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeAloneView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
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
        this.bVs = str;
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bVp = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds112);
        int g = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds19);
        this.bVo = new TextView(context);
        this.bVo.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -g;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bVo, layoutParams);
        this.bVn = new TBLottieAnimationView(context);
        this.bVn.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.bVp, this.bVp);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds_2);
        addView(this.bVn, layoutParams2);
        this.bVn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bVn.setOnClickListener(this.mOnClickListener);
        this.bVn.setAnimation(R.raw.agree);
        this.bVr = new com.baidu.tieba.tbadkCore.data.e();
        this.bVr.uniqueId = getPageId();
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bVq = agreeData;
            Jf();
        }
    }

    public void Jf() {
        if (this.bVq != null) {
            if (this.bVq.hasAgree) {
                this.bVo.setText(ap.aM(this.bVq.agreeNum));
                if (this.bVq.agreeType == 2) {
                    this.bVn.setMinAndMaxProgress(0.0f, 1.0f);
                    this.bVn.setProgress(1.0f);
                    this.bVo.setTextColor(al.getColor(R.color.cp_cont_h));
                    return;
                }
                this.bVn.setMinAndMaxProgress(0.0f, 0.0f);
                this.bVn.setProgress(0.0f);
                this.bVo.setTextColor(al.getColor(R.color.cp_cont_j));
                return;
            }
            if (this.bVq.agreeNum != 0) {
                this.bVo.setText(ap.aM(this.bVq.agreeNum));
            } else {
                this.bVo.setText(getResources().getString(R.string.zan));
            }
            this.bVn.setMinAndMaxProgress(0.0f, 0.0f);
            this.bVn.setProgress(0.0f);
            this.bVo.setTextColor(al.getColor(R.color.cp_cont_j));
        }
    }

    public void ed(boolean z) {
        if (z) {
            this.bVn.setMinAndMaxProgress(0.0f, 1.0f);
            this.bVn.bo();
            this.bVo.setText(ap.aM(this.bVq.agreeNum));
            this.bVo.setTextColor(al.getColor(R.color.cp_cont_h));
            return;
        }
        Jf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(View view) {
        int i;
        if (this.bVq != null && bc.cE(getContext())) {
            if (view instanceof TBLottieAnimationView) {
                ((TBLottieAnimationView) view).bo();
            }
            if (view.getId() == this.bVn.getId()) {
                if (this.bVq.hasAgree) {
                    if (this.bVq.agreeType == 2) {
                        this.bVq.agreeType = 2;
                        this.bVq.hasAgree = false;
                        this.bVq.diffAgreeNum--;
                        this.bVq.agreeNum--;
                        ed(false);
                        i = 1;
                    } else {
                        this.bVq.agreeType = 2;
                        this.bVq.hasAgree = true;
                        this.bVq.diffAgreeNum += 2;
                        this.bVq.agreeNum++;
                        this.bVq.disAgreeNum--;
                        ed(true);
                        com.baidu.tieba.n.a.ceu().x(getTbPageContext());
                        i = 0;
                    }
                } else {
                    this.bVq.agreeType = 2;
                    this.bVq.hasAgree = true;
                    this.bVq.diffAgreeNum++;
                    this.bVq.agreeNum++;
                    ed(true);
                    com.baidu.tieba.n.a.ceu().x(getTbPageContext());
                    if (!StringUtils.isNull(this.bVs)) {
                        TiebaStatic.log(new am("c13358").bT("tid", this.bVq.threadId).bT("topic_id", this.bVs));
                    }
                    i = 0;
                }
                iq(i);
            }
            this.bVr.agreeData = this.bVq;
            if (this.bVq.isInThread) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bVr));
                a(this.bVq, "isInThread");
            } else if (this.bVq.isInPost) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bVr));
                a(this.bVq, "isInPost");
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iq(int i) {
        if (this.bVq != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bVq.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bVq.objType == 0) {
                this.bVq.objType = 1;
            }
            httpMessage.addParam("obj_type", this.bVq.objType);
            httpMessage.addParam("agree_type", this.bVq.agreeType);
            httpMessage.addParam("forum_id", this.bVq.forumId);
            if (!TextUtils.isEmpty(this.bVq.postId)) {
                httpMessage.addParam("post_id", this.bVq.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bVq == null && this.mSkinType != i) {
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
        MessageManager.getInstance().registerListener(this.bVt);
        MessageManager.getInstance().registerListener(this.bVu);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bVt);
        MessageManager.getInstance().unRegisterListener(this.bVu);
    }
}
