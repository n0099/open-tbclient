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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes21.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener ajo;
    private int cardType;
    private TBLottieAnimationView eCB;
    private TextView eCC;
    private TBLottieAnimationView eCD;
    private TextView eCE;
    private AgreeData eCF;
    private com.baidu.tieba.tbadkCore.data.e eCG;
    private ScaleAnimation eCH;
    private boolean eCI;
    private boolean eCJ;
    private com.baidu.tbadk.core.data.c eCK;
    private int eCL;
    private int eCM;
    private int eCN;
    private int eCO;
    private String eCP;
    public View.OnClickListener eCQ;
    private LinearLayout eCR;
    private LinearLayout eCS;
    private boolean eCT;
    private boolean eCU;
    private a eCV;
    private com.baidu.tbadk.core.message.a eCW;
    private CustomMessageListener eCX;
    private bw eji;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes21.dex */
    public interface a {
        void e(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.eCF != null) {
            this.eCF.agreeType = agreeData.agreeType;
            this.eCF.hasAgree = agreeData.hasAgree;
            this.eCF.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eCM = R.raw.lottie_agree;
        this.eCN = R.raw.lottie_disagree;
        this.eCO = R.color.cp_cont_j;
        this.cardType = 1;
        this.eCT = false;
        this.eCU = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eCF != null && agreeData != null && AgreeView.this.eCG != null && !AgreeView.this.eCF.isInPost && AgreeView.this.eCG.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eCF.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eCF.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eCF.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eCX = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eCF != null && !TextUtils.isEmpty(AgreeView.this.eCF.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eCF.postId.equals(agreeData.postId) && !AgreeView.this.eCF.isInThread) {
                        if (AgreeView.this.eCI) {
                            if (AgreeView.this.eCF.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eCG.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bh(view);
                if (AgreeView.this.eCQ != null) {
                    AgreeView.this.eCQ.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eCM = R.raw.lottie_agree;
        this.eCN = R.raw.lottie_disagree;
        this.eCO = R.color.cp_cont_j;
        this.cardType = 1;
        this.eCT = false;
        this.eCU = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eCF != null && agreeData != null && AgreeView.this.eCG != null && !AgreeView.this.eCF.isInPost && AgreeView.this.eCG.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eCF.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eCF.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eCF.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eCX = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eCF != null && !TextUtils.isEmpty(AgreeView.this.eCF.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eCF.postId.equals(agreeData.postId) && !AgreeView.this.eCF.isInThread) {
                        if (AgreeView.this.eCI) {
                            if (AgreeView.this.eCF.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eCG.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bh(view);
                if (AgreeView.this.eCQ != null) {
                    AgreeView.this.eCQ.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eCM = R.raw.lottie_agree;
        this.eCN = R.raw.lottie_disagree;
        this.eCO = R.color.cp_cont_j;
        this.cardType = 1;
        this.eCT = false;
        this.eCU = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eCF != null && agreeData != null && AgreeView.this.eCG != null && !AgreeView.this.eCF.isInPost && AgreeView.this.eCG.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eCF.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eCF.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eCF.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eCX = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eCF != null && !TextUtils.isEmpty(AgreeView.this.eCF.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eCF.postId.equals(agreeData.postId) && !AgreeView.this.eCF.isInThread) {
                        if (AgreeView.this.eCI) {
                            if (AgreeView.this.eCF.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eCG.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bh(view);
                if (AgreeView.this.eCQ != null) {
                    AgreeView.this.eCQ.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.eCB = new TBLottieAnimationView(context);
        this.eCB.setId(R.id.img_agree);
        this.eCB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eCB.setOnClickListener(this.mOnClickListener);
        this.eCB.addAnimatorListener(this);
        this.eCC = new TextView(context);
        this.eCC.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eCC.setOnClickListener(this.mOnClickListener);
        this.eCD = new TBLottieAnimationView(context);
        this.eCD.setId(R.id.img_disagree);
        this.eCD.addAnimatorListener(this);
        this.eCD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eCD.setOnClickListener(this.mOnClickListener);
        this.eCE = new TextView(context);
        this.eCE.setText(R.string.c_disagree);
        this.eCE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eCE.setOnClickListener(this.mOnClickListener);
        this.eCG = new com.baidu.tieba.tbadkCore.data.e();
        this.eCG.uniqueId = getPageId();
        this.eCW = new com.baidu.tbadk.core.message.a();
        bnI();
        setAgreeAnimationResource();
    }

    private void bnI() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eCS = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.eCB);
        linearLayout.addView(this.eCC);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.eCR = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.eCD);
        linearLayout2.addView(this.eCE);
        iL(false);
    }

    private void s(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.eCS.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
        layoutParams.weight = i3;
        this.eCS.setLayoutParams(layoutParams);
        this.eCB.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.eCC.setLayoutParams(layoutParams2);
        this.eCR.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
        layoutParams3.weight = i3;
        this.eCR.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.eCD.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.eCE.setLayoutParams(layoutParams5);
    }

    public void iL(boolean z) {
        if (z) {
            s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), 0, 1, 17);
            setAgreeAlone(this.eCT);
            return;
        }
        s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), -2, 0, 16);
        setAgreeAlone(this.eCT);
    }

    public void bnJ() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eCB.setLayoutParams(layoutParams);
        this.eCC.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eCC.setLayoutParams(layoutParams2);
        this.eCD.setVisibility(8);
        this.eCE.setVisibility(8);
    }

    public void iM(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.eCB.setLayoutParams(layoutParams);
        this.eCC.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = i;
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.eCC.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.eCU = true;
        }
        layoutParams2.gravity = 16;
        this.eCC.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        this.eCD.setLayoutParams(layoutParams3);
        this.eCE.setVisibility(8);
    }

    public void bnK() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        bg(this.eCB);
        bg(this.eCD);
        bg(this.eCC);
        bg(this.eCE);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.eCB, new LinearLayout.LayoutParams(dimens, dimens));
        this.eCC.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.eCC, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.eCR = linearLayout2;
        linearLayout2.addView(this.eCD, new LinearLayout.LayoutParams(dimens, dimens));
        this.eCE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.eCE, layoutParams4);
    }

    private void bg(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eCX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eCX);
    }

    public void setTopicId(String str) {
        this.eCP = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.eCI = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.eCJ = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.eCB;
    }

    public TextView getAgreeNumView() {
        return this.eCC;
    }

    public TextView getDisagreeNumView() {
        return this.eCE;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.eCD;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.eCF = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.eCF;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.eCB, this.eCM);
        ap.a(this.eCD, this.eCN);
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
            return at.numFormatOverWanNa(j);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + at.numFormatOverWanNa(-j);
    }

    public void updateUI() {
        this.eCC.setText(b(this.eCF));
        if (this.eCF.hasAgree) {
            if (this.eCF.agreeType == 2) {
                this.eCD.setProgress(0.0f);
                this.eCB.setProgress(1.0f);
                this.eCC.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eCE);
                return;
            }
            this.eCB.setProgress(0.0f);
            this.eCD.setProgress(1.0f);
            setTextNormalColor(this.eCC);
            this.eCE.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.eCB.setProgress(0.0f);
        this.eCD.setProgress(0.0f);
        setTextNormalColor(this.eCC);
        setTextNormalColor(this.eCE);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.eCJ) {
            textView.setTextColor(ap.getColor(R.color.cp_cont_d));
        } else if (this.eCI) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(ap.getColor(this.eCO));
        }
    }

    public void iN(boolean z) {
        this.eCB.setMinAndMaxProgress(0.0f, 1.0f);
        this.eCD.setMinAndMaxProgress(0.0f, 1.0f);
        this.eCC.setText(b(this.eCF));
        this.eCB.clearColorFilter();
        this.eCD.clearColorFilter();
        if (z) {
            this.eCB.playAnimation();
            this.eCD.cancelAnimation();
            this.eCD.setFrame(0);
        } else {
            this.eCD.playAnimation();
            this.eCB.cancelAnimation();
            this.eCB.setFrame(0);
        }
        if (this.eCF.hasAgree) {
            if (this.eCF.agreeType == 2) {
                this.eCC.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eCE);
                return;
            }
            setTextNormalColor(this.eCC);
            this.eCE.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.eCC);
        setTextNormalColor(this.eCE);
    }

    public void bnL() {
        bh(this.eCB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(View view) {
        int i = 0;
        int i2 = 1;
        if (this.eCF != null) {
            if (!this.eCI || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.eCI || bg.checkUpIsLogin(getContext())) {
                    if (view != this.eCC || this.eCU) {
                        if (view.getId() == this.eCB.getId() || (this.eCU && view.getId() == this.eCC.getId())) {
                            this.eCB.cancelAnimation();
                            if (this.eCK != null) {
                                this.eCK.type = 1;
                            }
                            if (this.eCF.hasAgree) {
                                if (this.eCF.agreeType == 2) {
                                    this.eCF.agreeType = 2;
                                    this.eCF.hasAgree = false;
                                    this.eCF.agreeNum--;
                                    updateUI();
                                    if (this.eCK != null) {
                                        this.eCK.eld = 1;
                                    }
                                } else {
                                    this.eCF.agreeType = 2;
                                    this.eCF.hasAgree = true;
                                    this.eCF.agreeNum++;
                                    iN(true);
                                    com.baidu.tieba.o.a.duk().G(getTbPageContext());
                                    if (this.eCK != null) {
                                        this.eCK.eld = 0;
                                        i2 = 0;
                                    }
                                }
                                this.eCW.a(this.eCF, i2, getPageId(), this.eCI);
                            } else {
                                this.eCF.agreeType = 2;
                                this.eCF.hasAgree = true;
                                this.eCF.agreeNum++;
                                iN(true);
                                com.baidu.tieba.o.a.duk().G(getTbPageContext());
                                if (this.eCK != null) {
                                    this.eCK.eld = 0;
                                }
                            }
                            i2 = 0;
                            this.eCW.a(this.eCF, i2, getPageId(), this.eCI);
                        } else if (view.getId() == this.eCD.getId()) {
                            this.eCD.cancelAnimation();
                            if (this.eCK != null) {
                                this.eCK.type = 2;
                            }
                            if (this.eCF.hasAgree) {
                                if (this.eCF.agreeType == 5) {
                                    this.eCF.agreeType = 5;
                                    this.eCF.hasAgree = false;
                                    updateUI();
                                    if (this.eCK != null) {
                                        this.eCK.elh = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.eCF.agreeType = 5;
                                    this.eCF.hasAgree = true;
                                    this.eCF.agreeNum--;
                                    iN(false);
                                    if (this.eCK != null) {
                                        this.eCK.elh = 1;
                                    }
                                }
                            } else {
                                this.eCF.agreeType = 5;
                                this.eCF.hasAgree = true;
                                iN(false);
                                if (this.eCK != null) {
                                    this.eCK.elh = 1;
                                }
                            }
                            this.eCW.a(this.eCF, i, getPageId(), this.eCI);
                        }
                        this.eCW.a(this.eCF, this.eCG);
                        if (this.ajo != null) {
                            this.ajo.onClick(view);
                        }
                        bnM();
                    }
                }
            }
        }
    }

    public void bnM() {
        if (this.eCK != null && this.eCF != null) {
            int i = 0;
            if (this.eCF.baijiahaoData != null) {
                i = this.eCF.baijiahaoData.oriUgcType;
            }
            if (this.eCK.type == 1) {
                if (StringUtils.isNull(this.eCP)) {
                    aq dK = new aq("c12003").aj("obj_locate", this.eCK.ela).aj("obj_param1", this.eCK.elb).aj("obj_source", this.eCK.elc).aj("obj_id", this.eCK.eld).aj("obj_name", i).dK("post_id", this.eCF.postId);
                    if (this.eji != null) {
                        dK.dK("tid", this.eji.getId()).dK("nid", this.eji.getNid()).u("fid", this.eji.getFid()).aj(IntentConfig.CARD_TYPE, this.cardType).dK("ab_tag", this.eji.mRecomAbTag).dK(IntentConfig.RECOM_SOURCE, this.eji.mRecomSource).dK("weight", this.eji.mRecomWeight).dK("extra", this.eji.mRecomExtra);
                        if (this.eji.getBaijiahaoData() != null) {
                            dK.dK("obj_param4", this.eji.getBaijiahaoData().oriUgcNid);
                            if (this.eji.bgQ() || this.eji.bkd()) {
                                dK.dK("obj_param6", this.eji.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.eji.bkb()) {
                            dK.aj("obj_param5", 2);
                        } else if (this.eji.bgP() || this.eji.bgQ()) {
                            dK.aj("obj_param5", 3);
                        } else if (this.eji.threadType == 0 || this.eji.threadType == 40) {
                            dK.aj("obj_param5", 1);
                        }
                    } else {
                        dK.dK("tid", this.eCF.threadId);
                        dK.dK("nid", this.eCF.nid);
                        dK.dK("fid", this.eCF.forumId);
                        dK.aj(IntentConfig.CARD_TYPE, this.eCF.cardType);
                        dK.dK("ab_tag", this.eCF.recomAbTag);
                        dK.dK(IntentConfig.RECOM_SOURCE, this.eCF.recomSource);
                        dK.dK("weight", this.eCF.recomWeight);
                        dK.dK("extra", this.eCF.recomExtra);
                        if (this.eCF.baijiahaoData != null) {
                            dK.dK("obj_param6", this.eCF.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (pf(this.eCK.ela) && pg(this.eCK.ele) != -1) {
                        dK.aj(TiebaInitialize.Params.OBJ_TO, pg(this.eCK.ele));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dK.dK("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dK.aj("resource_id", this.eCL);
                    } else if (this.mFrom == 18) {
                        dK.dK("obj_tab", "a099");
                        dK.dK("resource_id", this.mTabName);
                    } else {
                        dK.aj("resource_id", this.eCL);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dK);
                    }
                    if (this.eCF.isFromImageViewer) {
                        dK.dK("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.eCF.mImageViewerFromPage == "index") {
                            dK.dK(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.eCF.keyFromHomePage)) {
                        dK.dK("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dK.dK("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    TiebaStatic.log(dK);
                    return;
                }
                TiebaStatic.log(new aq("c13358").dK("tid", this.eCF.threadId).dK("topic_id", this.eCP));
            } else if (this.eCK.type == 2) {
                aq dK2 = new aq("c13271").aj("obj_type", this.eCK.elf).aj("obj_locate", this.eCK.elg).aj(TiebaInitialize.Params.OBJ_PARAM2, this.eCL).aj("obj_id", this.eCK.elh).aj("obj_name", i).dK("post_id", this.eCF.postId).dK("nid", this.eCF.nid);
                if (this.eji != null) {
                    dK2.dK("tid", this.eji.getId()).dK("nid", this.eji.getNid()).u("fid", this.eji.getFid()).aj(IntentConfig.CARD_TYPE, this.cardType).dK("ab_tag", this.eji.mRecomAbTag).dK(IntentConfig.RECOM_SOURCE, this.eji.mRecomSource).dK("weight", this.eji.mRecomWeight).dK("extra", this.eji.mRecomExtra);
                    if (this.eji.getBaijiahaoData() != null) {
                        dK2.dK("obj_param4", this.eji.getBaijiahaoData().oriUgcNid);
                        if (this.eji.bgQ() || this.eji.bkd()) {
                            dK2.dK("obj_param6", this.eji.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.eji.bkb()) {
                        dK2.aj("obj_param5", 2);
                    } else if (this.eji.bgP() || this.eji.bgQ()) {
                        dK2.aj("obj_param5", 3);
                    } else if (this.eji.threadType == 0 || this.eji.threadType == 40) {
                        dK2.aj("obj_param5", 1);
                    }
                } else {
                    dK2.dK("tid", this.eCF.threadId);
                    dK2.dK("nid", this.eCF.nid);
                    dK2.dK("fid", this.eCF.forumId);
                    dK2.aj(IntentConfig.CARD_TYPE, this.eCF.cardType);
                    dK2.dK("ab_tag", this.eCF.recomAbTag);
                    dK2.dK(IntentConfig.RECOM_SOURCE, this.eCF.recomSource);
                    dK2.dK("weight", this.eCF.recomWeight);
                    dK2.dK("extra", this.eCF.recomExtra);
                    if (this.eCF.baijiahaoData != null) {
                        dK2.dK("obj_param6", this.eCF.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dK2.dK("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dK2.dK("obj_tab", "a099");
                    dK2.dK("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dK2);
                }
                if (this.eCF.isFromImageViewer) {
                    dK2.dK("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.eCF.mImageViewerFromPage == "index") {
                        dK2.dK(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dK2);
            }
        }
    }

    public static boolean pf(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int pg(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.eCH == null) {
            this.eCH = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.eCH.setDuration(200L);
        }
        return this.eCH;
    }

    public void onChangeSkinType(int i) {
        if (this.eCF != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.eCB, this.eCM);
            ap.a(this.eCD, this.eCN);
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
        this.eCK = cVar;
    }

    public void setGameId(int i) {
        this.eCL = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.eCD.setVisibility(z ? 8 : 0);
        this.eCE.setVisibility(z ? 8 : 0);
        if (z && this.eCR != null) {
            this.eCR.setVisibility(8);
        }
        if (this.eCT != z && this.eCV != null) {
            this.eCV.e(this.eCD, z);
        }
        this.eCT = z;
    }

    public void setDisagreeShow(boolean z) {
        this.eCD.setVisibility(z ? 8 : 0);
        this.eCE.setVisibility(z ? 8 : 0);
        if (this.eCR != null) {
            this.eCR.setVisibility(z ? 8 : 0);
        }
        this.eCT = z;
    }

    public boolean bnN() {
        return this.eCT;
    }

    public void setThreadData(bw bwVar) {
        this.eji = bwVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.eCM = i;
        this.eCN = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.eCO = i;
        setTextNormalColor(this.eCC);
        setTextNormalColor(this.eCE);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajo = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.eCV = aVar;
    }
}
