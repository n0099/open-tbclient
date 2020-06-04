package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener ags;
    private int cardType;
    private bk dEA;
    private int dRA;
    private int dRB;
    private int dRC;
    private int dRD;
    private String dRE;
    public View.OnClickListener dRF;
    private LinearLayout dRG;
    private LinearLayout dRH;
    private boolean dRI;
    private a dRJ;
    private CustomMessageListener dRK;
    private CustomMessageListener dRL;
    private TBLottieAnimationView dRq;
    private TextView dRr;
    private TBLottieAnimationView dRs;
    private TextView dRt;
    private AgreeData dRu;
    private com.baidu.tieba.tbadkCore.data.e dRv;
    private ScaleAnimation dRw;
    private boolean dRx;
    private boolean dRy;
    private com.baidu.tbadk.core.data.c dRz;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;

    /* loaded from: classes8.dex */
    public interface a {
        void f(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.dRu != null) {
            this.dRu.agreeType = agreeData.agreeType;
            this.dRu.hasAgree = agreeData.hasAgree;
            this.dRu.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dRB = R.raw.lottie_agree;
        this.dRC = R.raw.lottie_disagree;
        this.dRD = R.color.cp_cont_j;
        this.cardType = 1;
        this.dRI = false;
        this.dRK = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dRu != null && agreeData != null && AgreeView.this.dRv != null && !AgreeView.this.dRu.isInPost && AgreeView.this.dRv.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dRu.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dRu.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dRu.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dRL = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dRu != null && !TextUtils.isEmpty(AgreeView.this.dRu.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dRu.postId.equals(agreeData.postId) && !AgreeView.this.dRu.isInThread) {
                        if (AgreeView.this.dRx) {
                            if (AgreeView.this.dRu.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dRv.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aT(view);
                if (AgreeView.this.dRF != null) {
                    AgreeView.this.dRF.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dRB = R.raw.lottie_agree;
        this.dRC = R.raw.lottie_disagree;
        this.dRD = R.color.cp_cont_j;
        this.cardType = 1;
        this.dRI = false;
        this.dRK = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dRu != null && agreeData != null && AgreeView.this.dRv != null && !AgreeView.this.dRu.isInPost && AgreeView.this.dRv.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dRu.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dRu.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dRu.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dRL = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dRu != null && !TextUtils.isEmpty(AgreeView.this.dRu.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dRu.postId.equals(agreeData.postId) && !AgreeView.this.dRu.isInThread) {
                        if (AgreeView.this.dRx) {
                            if (AgreeView.this.dRu.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dRv.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aT(view);
                if (AgreeView.this.dRF != null) {
                    AgreeView.this.dRF.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dRB = R.raw.lottie_agree;
        this.dRC = R.raw.lottie_disagree;
        this.dRD = R.color.cp_cont_j;
        this.cardType = 1;
        this.dRI = false;
        this.dRK = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dRu != null && agreeData != null && AgreeView.this.dRv != null && !AgreeView.this.dRu.isInPost && AgreeView.this.dRv.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dRu.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dRu.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dRu.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dRL = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dRu != null && !TextUtils.isEmpty(AgreeView.this.dRu.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dRu.postId.equals(agreeData.postId) && !AgreeView.this.dRu.isInThread) {
                        if (AgreeView.this.dRx) {
                            if (AgreeView.this.dRu.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dRv.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.a(agreeData);
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aT(view);
                if (AgreeView.this.dRF != null) {
                    AgreeView.this.dRF.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.dRq = new TBLottieAnimationView(context);
        this.dRq.setId(R.id.img_agree);
        this.dRq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dRq.setOnClickListener(this.mOnClickListener);
        this.dRq.addAnimatorListener(this);
        this.dRr = new TextView(context);
        this.dRr.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.dRr.setOnClickListener(this.mOnClickListener);
        this.dRs = new TBLottieAnimationView(context);
        this.dRs.setId(R.id.img_disagree);
        this.dRs.addAnimatorListener(this);
        this.dRs.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dRs.setOnClickListener(this.mOnClickListener);
        this.dRt = new TextView(context);
        this.dRt.setText(R.string.c_disagree);
        this.dRt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.dRt.setOnClickListener(this.mOnClickListener);
        this.dRv = new com.baidu.tieba.tbadkCore.data.e();
        this.dRv.uniqueId = getPageId();
        aVN();
        setAgreeAnimationResource();
    }

    private void aVN() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.dRH = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.dRq);
        linearLayout.addView(this.dRr);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.dRG = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.dRs);
        linearLayout2.addView(this.dRt);
        he(false);
    }

    private void s(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.dRH.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
        layoutParams.weight = i3;
        this.dRH.setLayoutParams(layoutParams);
        this.dRq.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.dRr.setLayoutParams(layoutParams2);
        this.dRG.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
        layoutParams3.weight = i3;
        this.dRG.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.dRs.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.dRt.setLayoutParams(layoutParams5);
    }

    public void he(boolean z) {
        if (z) {
            s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), 0, 1, 17);
            setAgreeAlone(this.dRI);
            return;
        }
        s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), -2, 0, 16);
        setAgreeAlone(this.dRI);
    }

    public void aVO() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dRq.setLayoutParams(layoutParams);
        this.dRr.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dRr.setLayoutParams(layoutParams2);
        this.dRs.setVisibility(8);
        this.dRt.setVisibility(8);
    }

    public void hf(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.dRq.setLayoutParams(layoutParams);
        this.dRr.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        if (!z) {
            layoutParams2.leftMargin = i;
        }
        this.dRr.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        if (!z) {
            layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        }
        layoutParams3.gravity = 16;
        this.dRs.setLayoutParams(layoutParams3);
        if (z) {
            this.dRt.setVisibility(8);
            return;
        }
        this.dRt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.dRt.setLayoutParams(layoutParams4);
    }

    public void aVP() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        aS(this.dRq);
        aS(this.dRs);
        aS(this.dRr);
        aS(this.dRt);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.dRq, new LinearLayout.LayoutParams(dimens, dimens));
        this.dRr.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.dRr, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.dRG = linearLayout2;
        linearLayout2.addView(this.dRs, new LinearLayout.LayoutParams(dimens, dimens));
        this.dRt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.dRt, layoutParams4);
    }

    private void aS(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dRK);
        MessageManager.getInstance().registerListener(this.dRL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dRK);
        MessageManager.getInstance().unRegisterListener(this.dRL);
    }

    public void setTopicId(String str) {
        this.dRE = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.dRx = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.dRy = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.dRq;
    }

    public TextView getAgreeNumView() {
        return this.dRr;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.dRs;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.dRu = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.dRu;
    }

    public void setAgreeAnimationResource() {
        if (this.dRx) {
            am.b(this.dRq, this.dRB);
            am.b(this.dRs, this.dRC);
            return;
        }
        am.a(this.dRq, this.dRB);
        am.a(this.dRs, this.dRC);
    }

    private String b(AgreeData agreeData) {
        return c(agreeData);
    }

    private String c(AgreeData agreeData) {
        long j = agreeData != null ? agreeData.agreeNum : 0L;
        if (j == 0) {
            return getContext().getString(R.string.c_agree);
        }
        if (j > 0) {
            return aq.numFormatOverWanNa(j);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + aq.numFormatOverWanNa(-j);
    }

    public void updateUI() {
        this.dRr.setText(b(this.dRu));
        if (this.dRu.hasAgree) {
            if (this.dRu.agreeType == 2) {
                this.dRs.setProgress(0.0f);
                this.dRq.setProgress(1.0f);
                this.dRr.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.dRt);
                return;
            }
            this.dRq.setProgress(0.0f);
            this.dRs.setProgress(1.0f);
            setTextNormalColor(this.dRr);
            this.dRt.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.dRq.setProgress(0.0f);
        this.dRs.setProgress(0.0f);
        setTextNormalColor(this.dRr);
        setTextNormalColor(this.dRt);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.dRy) {
            textView.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.dRx) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(am.getColor(this.dRD));
        }
    }

    public void hg(boolean z) {
        this.dRq.setMinAndMaxProgress(0.0f, 1.0f);
        this.dRs.setMinAndMaxProgress(0.0f, 1.0f);
        this.dRr.setText(b(this.dRu));
        this.dRq.clearColorFilter();
        this.dRs.clearColorFilter();
        if (z) {
            this.dRq.playAnimation();
            this.dRs.cancelAnimation();
            this.dRs.setFrame(0);
        } else {
            this.dRs.playAnimation();
            this.dRq.cancelAnimation();
            this.dRq.setFrame(0);
        }
        if (this.dRu.hasAgree) {
            if (this.dRu.agreeType == 2) {
                this.dRr.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.dRt);
                return;
            }
            setTextNormalColor(this.dRr);
            this.dRt.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.dRr);
        setTextNormalColor(this.dRt);
    }

    public void aVQ() {
        aT(this.dRq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(View view) {
        int i = 0;
        int i2 = 1;
        if (this.dRu != null) {
            if (!this.dRx || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.dRx || bc.checkUpIsLogin(getContext())) && view != this.dRr) {
                    if (view.getId() == this.dRq.getId()) {
                        this.dRq.cancelAnimation();
                        if (this.dRz != null) {
                            this.dRz.type = 1;
                        }
                        if (this.dRu.hasAgree) {
                            if (this.dRu.agreeType == 2) {
                                this.dRu.agreeType = 2;
                                this.dRu.hasAgree = false;
                                this.dRu.agreeNum--;
                                updateUI();
                                if (this.dRz != null) {
                                    this.dRz.dBc = 1;
                                }
                            } else {
                                this.dRu.agreeType = 2;
                                this.dRu.hasAgree = true;
                                this.dRu.agreeNum++;
                                hg(true);
                                com.baidu.tieba.o.a.cUi().E(getTbPageContext());
                                if (this.dRz != null) {
                                    this.dRz.dBc = 0;
                                    i2 = 0;
                                }
                            }
                            lG(i2);
                        } else {
                            this.dRu.agreeType = 2;
                            this.dRu.hasAgree = true;
                            this.dRu.agreeNum++;
                            hg(true);
                            com.baidu.tieba.o.a.cUi().E(getTbPageContext());
                            if (this.dRz != null) {
                                this.dRz.dBc = 0;
                            }
                        }
                        i2 = 0;
                        lG(i2);
                    } else if (view.getId() == this.dRs.getId()) {
                        this.dRs.cancelAnimation();
                        if (this.dRz != null) {
                            this.dRz.type = 2;
                        }
                        if (this.dRu.hasAgree) {
                            if (this.dRu.agreeType == 5) {
                                this.dRu.agreeType = 5;
                                this.dRu.hasAgree = false;
                                updateUI();
                                if (this.dRz != null) {
                                    this.dRz.dBg = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.dRu.agreeType = 5;
                                this.dRu.hasAgree = true;
                                this.dRu.agreeNum--;
                                hg(false);
                                if (this.dRz != null) {
                                    this.dRz.dBg = 1;
                                }
                            }
                        } else {
                            this.dRu.agreeType = 5;
                            this.dRu.hasAgree = true;
                            hg(false);
                            if (this.dRz != null) {
                                this.dRz.dBg = 1;
                            }
                        }
                        lG(i);
                    }
                    this.dRv.agreeData = this.dRu;
                    if (this.dRu.isInThread) {
                        if (this.dRu.baijiahaoData != null) {
                            this.dRu.nid = this.dRu.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.dRv));
                        a(this.dRu, AgreeEvent.IS_THREAD);
                    } else if (this.dRu.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.dRv));
                        a(this.dRu, AgreeEvent.IS_POST);
                    }
                    if (this.ags != null) {
                        this.ags.onClick(view);
                    }
                    aVR();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        com.baidu.tbadk.mutiprocess.g.publishEvent(agreeEvent);
    }

    public void lG(int i) {
        if (this.dRu != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.dRu.threadId);
            httpMessage.addParam("op_type", i);
            if (this.dRu.objType == 0) {
                this.dRu.objType = 3;
            }
            httpMessage.addParam("obj_type", this.dRu.objType);
            httpMessage.addParam("agree_type", this.dRu.agreeType);
            httpMessage.addParam("forum_id", this.dRu.forumId);
            if (!TextUtils.isEmpty(this.dRu.postId)) {
                httpMessage.addParam("post_id", this.dRu.postId);
            }
            if (this.dRu.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.dRu.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.dRu.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.dRu.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.dRu.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.dRx) {
                if (!TextUtils.isEmpty(com.baidu.tbadk.mutiprocess.f.getBduss())) {
                    httpMessage.addParam("BDUSS", com.baidu.tbadk.mutiprocess.f.getBduss());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.mutiprocess.f.getTbs())) {
                    httpMessage.addParam("tbs", com.baidu.tbadk.mutiprocess.f.getTbs());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.mutiprocess.f.getStoken())) {
                    httpMessage.addParam("stoken", com.baidu.tbadk.mutiprocess.f.getStoken());
                }
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void aVR() {
        if (this.dRz != null && this.dRu != null) {
            int i = 0;
            if (this.dRu.baijiahaoData != null) {
                i = this.dRu.baijiahaoData.oriUgcType;
            }
            if (this.dRz.type == 1) {
                if (StringUtils.isNull(this.dRE)) {
                    an dh = new an("c12003").ag("obj_locate", this.dRz.dAZ).ag("obj_param1", this.dRz.dBa).ag("obj_source", this.dRz.dBb).ag("obj_id", this.dRz.dBc).ag("obj_name", i).dh("post_id", this.dRu.postId);
                    if (this.dEA != null) {
                        dh.dh("tid", this.dEA.getId()).dh("nid", this.dEA.getNid()).s("fid", this.dEA.getFid()).ag(IntentConfig.CARD_TYPE, this.cardType).dh("ab_tag", this.dEA.mRecomAbTag).dh(IntentConfig.RECOM_SOURCE, this.dEA.mRecomSource).dh("weight", this.dEA.mRecomWeight).dh("extra", this.dEA.mRecomExtra);
                        if (this.dEA.getBaijiahaoData() != null) {
                            dh.dh("obj_param4", this.dEA.getBaijiahaoData().oriUgcNid);
                            if (this.dEA.aPn() || this.dEA.aSw()) {
                                dh.dh("obj_param6", this.dEA.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.dEA.aSu()) {
                            dh.ag("obj_param5", 2);
                        } else if (this.dEA.aPm() || this.dEA.aPn()) {
                            dh.ag("obj_param5", 3);
                        } else if (this.dEA.threadType == 0 || this.dEA.threadType == 40) {
                            dh.ag("obj_param5", 1);
                        }
                    } else {
                        dh.dh("tid", this.dRu.threadId);
                        dh.dh("nid", this.dRu.nid);
                        dh.dh("fid", this.dRu.forumId);
                        dh.ag(IntentConfig.CARD_TYPE, this.dRu.cardType);
                        dh.dh("ab_tag", this.dRu.recomAbTag);
                        dh.dh(IntentConfig.RECOM_SOURCE, this.dRu.recomSource);
                        dh.dh("weight", this.dRu.recomWeight);
                        dh.dh("extra", this.dRu.recomExtra);
                        if (this.dRu.baijiahaoData != null) {
                            dh.dh("obj_param6", this.dRu.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (lH(this.dRz.dAZ) && lI(this.dRz.dBd) != -1) {
                        dh.ag(TiebaInitialize.Params.OBJ_TO, lI(this.dRz.dBd));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dh.dh("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dh.ag("resource_id", this.dRA);
                    } else if (this.mFrom == 18) {
                        dh.dh("obj_tab", "a099");
                        dh.dh("resource_id", this.mTabName);
                    } else {
                        dh.ag("resource_id", this.dRA);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dh);
                    }
                    if (this.dRu.isFromImageViewer) {
                        dh.dh("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.dRu.mImageViewerFromPage == "index") {
                            dh.dh(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    TiebaStatic.log(dh);
                    return;
                }
                TiebaStatic.log(new an("c13358").dh("tid", this.dRu.threadId).dh("topic_id", this.dRE));
            } else if (this.dRz.type == 2) {
                an dh2 = new an("c13271").ag("obj_type", this.dRz.dBe).ag("obj_locate", this.dRz.dBf).ag(TiebaInitialize.Params.OBJ_PARAM2, this.dRA).ag("obj_id", this.dRz.dBg).ag("obj_name", i).dh("post_id", this.dRu.postId).dh("nid", this.dRu.nid);
                if (this.dEA != null) {
                    dh2.dh("tid", this.dEA.getId()).dh("nid", this.dEA.getNid()).s("fid", this.dEA.getFid()).ag(IntentConfig.CARD_TYPE, this.cardType).dh("ab_tag", this.dEA.mRecomAbTag).dh(IntentConfig.RECOM_SOURCE, this.dEA.mRecomSource).dh("weight", this.dEA.mRecomWeight).dh("extra", this.dEA.mRecomExtra);
                    if (this.dEA.getBaijiahaoData() != null) {
                        dh2.dh("obj_param4", this.dEA.getBaijiahaoData().oriUgcNid);
                        if (this.dEA.aPn() || this.dEA.aSw()) {
                            dh2.dh("obj_param6", this.dEA.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.dEA.aSu()) {
                        dh2.ag("obj_param5", 2);
                    } else if (this.dEA.aPm() || this.dEA.aPn()) {
                        dh2.ag("obj_param5", 3);
                    } else if (this.dEA.threadType == 0 || this.dEA.threadType == 40) {
                        dh2.ag("obj_param5", 1);
                    }
                } else {
                    dh2.dh("tid", this.dRu.threadId);
                    dh2.dh("nid", this.dRu.nid);
                    dh2.dh("fid", this.dRu.forumId);
                    dh2.ag(IntentConfig.CARD_TYPE, this.dRu.cardType);
                    dh2.dh("ab_tag", this.dRu.recomAbTag);
                    dh2.dh(IntentConfig.RECOM_SOURCE, this.dRu.recomSource);
                    dh2.dh("weight", this.dRu.recomWeight);
                    dh2.dh("extra", this.dRu.recomExtra);
                    if (this.dRu.baijiahaoData != null) {
                        dh2.dh("obj_param6", this.dRu.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dh2.dh("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dh2.dh("obj_tab", "a099");
                    dh2.dh("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dh2);
                }
                if (this.dRu.isFromImageViewer) {
                    dh2.dh("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.dRu.mImageViewerFromPage == "index") {
                        dh2.dh(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dh2);
            }
        }
    }

    public static boolean lH(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int lI(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.dRw == null) {
            this.dRw = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dRw.setDuration(200L);
        }
        return this.dRw;
    }

    public void onChangeSkinType(int i) {
        if (this.dRu != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.dRx) {
                am.b(this.dRq, this.dRB);
                am.b(this.dRs, this.dRC);
            } else {
                am.a(this.dRq, this.dRB);
                am.a(this.dRs, this.dRC);
            }
            updateUI();
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

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.c cVar) {
        this.dRz = cVar;
    }

    public void setGameId(int i) {
        this.dRA = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.dRs.setVisibility(z ? 8 : 0);
        this.dRt.setVisibility(z ? 8 : 0);
        if (z && this.dRG != null) {
            this.dRG.setVisibility(8);
        }
        if (this.dRI != z && this.dRJ != null) {
            this.dRJ.f(this.dRs, z);
        }
        this.dRI = z;
    }

    public void setDisagreeShow(boolean z) {
        this.dRs.setVisibility(z ? 8 : 0);
        this.dRt.setVisibility(z ? 8 : 0);
        if (this.dRG != null) {
            this.dRG.setVisibility(z ? 8 : 0);
        }
        this.dRI = z;
    }

    public boolean aVS() {
        return this.dRI;
    }

    public void setThreadData(bk bkVar) {
        this.dEA = bkVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.dRB = i;
        this.dRC = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.dRD = i;
        setTextNormalColor(this.dRr);
        setTextNormalColor(this.dRt);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.dRJ = aVar;
    }
}
