package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener akV;
    private int cardType;
    private bz eMv;
    private TBLottieAnimationView fgD;
    private TextView fgE;
    private TBLottieAnimationView fgF;
    private TextView fgG;
    private AgreeData fgH;
    private com.baidu.tieba.tbadkCore.data.e fgI;
    private ScaleAnimation fgJ;
    private boolean fgK;
    private boolean fgL;
    private com.baidu.tbadk.core.data.d fgM;
    private int fgN;
    private int fgO;
    private int fgP;
    private int fgQ;
    private String fgR;
    public View.OnClickListener fgS;
    private LinearLayout fgT;
    private LinearLayout fgU;
    private boolean fgV;
    private boolean fgW;
    private a fgX;
    private com.baidu.tbadk.core.message.a fgY;
    private CustomMessageListener fgZ;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes.dex */
    public interface a {
        void f(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.fgH != null) {
            this.fgH.agreeType = agreeData.agreeType;
            this.fgH.hasAgree = agreeData.hasAgree;
            this.fgH.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fgO = R.raw.lottie_agree;
        this.fgP = R.raw.lottie_disagree;
        this.fgQ = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgV = false;
        this.fgW = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fgH != null && agreeData != null && AgreeView.this.fgI != null && !AgreeView.this.fgH.isInPost && AgreeView.this.fgI.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.fgH.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.fgH.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.fgH.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgZ = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fgH != null && !TextUtils.isEmpty(AgreeView.this.fgH.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.fgH.postId.equals(agreeData.postId) && !AgreeView.this.fgH.isInThread) {
                        if (AgreeView.this.fgK) {
                            if (AgreeView.this.fgH.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.fgI.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eMv == null || AgreeView.this.eMv.getType() != bz.eTC) {
                    AgreeView.this.bB(view);
                    if (AgreeView.this.fgS != null) {
                        AgreeView.this.fgS.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fgO = R.raw.lottie_agree;
        this.fgP = R.raw.lottie_disagree;
        this.fgQ = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgV = false;
        this.fgW = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fgH != null && agreeData != null && AgreeView.this.fgI != null && !AgreeView.this.fgH.isInPost && AgreeView.this.fgI.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.fgH.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.fgH.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.fgH.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgZ = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fgH != null && !TextUtils.isEmpty(AgreeView.this.fgH.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.fgH.postId.equals(agreeData.postId) && !AgreeView.this.fgH.isInThread) {
                        if (AgreeView.this.fgK) {
                            if (AgreeView.this.fgH.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.fgI.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eMv == null || AgreeView.this.eMv.getType() != bz.eTC) {
                    AgreeView.this.bB(view);
                    if (AgreeView.this.fgS != null) {
                        AgreeView.this.fgS.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fgO = R.raw.lottie_agree;
        this.fgP = R.raw.lottie_disagree;
        this.fgQ = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgV = false;
        this.fgW = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fgH != null && agreeData != null && AgreeView.this.fgI != null && !AgreeView.this.fgH.isInPost && AgreeView.this.fgI.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.fgH.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.fgH.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.fgH.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgZ = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fgH != null && !TextUtils.isEmpty(AgreeView.this.fgH.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.fgH.postId.equals(agreeData.postId) && !AgreeView.this.fgH.isInThread) {
                        if (AgreeView.this.fgK) {
                            if (AgreeView.this.fgH.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.fgI.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eMv == null || AgreeView.this.eMv.getType() != bz.eTC) {
                    AgreeView.this.bB(view);
                    if (AgreeView.this.fgS != null) {
                        AgreeView.this.fgS.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.fgD = new TBLottieAnimationView(context);
        this.fgD.setId(R.id.img_agree);
        this.fgD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fgD.setOnClickListener(this.mOnClickListener);
        this.fgD.addAnimatorListener(this);
        this.fgE = new TextView(context);
        this.fgE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.fgE.setOnClickListener(this.mOnClickListener);
        this.fgF = new TBLottieAnimationView(context);
        this.fgF.setId(R.id.img_disagree);
        this.fgF.addAnimatorListener(this);
        this.fgF.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fgF.setOnClickListener(this.mOnClickListener);
        this.fgG = new TextView(context);
        this.fgG.setText(R.string.c_disagree);
        this.fgG.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.fgG.setOnClickListener(this.mOnClickListener);
        this.fgI = new com.baidu.tieba.tbadkCore.data.e();
        this.fgI.uniqueId = getPageId();
        this.fgY = new com.baidu.tbadk.core.message.a();
        bxi();
        setAgreeAnimationResource();
    }

    private void bxi() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fgU = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.fgD);
        linearLayout.addView(this.fgE);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.fgT = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.fgF);
        linearLayout2.addView(this.fgG);
        jT(false);
    }

    private void y(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.fgU.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.fgU.setLayoutParams(layoutParams);
        this.fgD.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.fgE.setLayoutParams(layoutParams2);
        this.fgT.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.fgT.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.fgF.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.fgG.setLayoutParams(layoutParams5);
    }

    public void jT(boolean z) {
        if (z) {
            y(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.fgV);
            return;
        }
        y(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.fgV);
    }

    public void bxj() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.fgD.setLayoutParams(layoutParams);
        this.fgE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.fgE.setLayoutParams(layoutParams2);
        this.fgF.setVisibility(8);
        this.fgG.setVisibility(8);
    }

    public void jU(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.fgD.setLayoutParams(layoutParams);
        this.fgE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.fgE.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.fgW = true;
        } else {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22);
        }
        layoutParams2.gravity = 16;
        this.fgE.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        if (!z) {
            layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds28);
        }
        this.fgF.setLayoutParams(layoutParams3);
        this.fgG.setVisibility(8);
    }

    public void bxk() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        removeAllViews();
        bA(this.fgD);
        bA(this.fgF);
        bA(this.fgE);
        bA(this.fgG);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.fgD, new LinearLayout.LayoutParams(dimens, dimens));
        this.fgE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        linearLayout.addView(this.fgE, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.fgT = linearLayout2;
        linearLayout2.addView(this.fgF, new LinearLayout.LayoutParams(dimens, dimens));
        this.fgG.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        linearLayout2.addView(this.fgG, layoutParams4);
    }

    private void bA(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.fgZ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fgZ);
    }

    public void setTopicId(String str) {
        this.fgR = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.fgK = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.fgL = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.fgD;
    }

    public TextView getAgreeNumView() {
        return this.fgE;
    }

    public TextView getDisagreeNumView() {
        return this.fgG;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.fgF;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.fgH = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.fgH;
    }

    public void setAgreeAnimationResource() {
        ao.a(this.fgD, this.fgO);
        ao.a(this.fgF, this.fgP);
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
        this.fgE.setText(b(this.fgH));
        if (this.fgH.hasAgree) {
            if (this.fgH.agreeType == 2) {
                this.fgF.setProgress(0.0f);
                this.fgD.setProgress(1.0f);
                this.fgE.setTextColor(ao.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fgG);
                return;
            }
            this.fgD.setProgress(0.0f);
            this.fgF.setProgress(1.0f);
            setTextNormalColor(this.fgE);
            this.fgG.setTextColor(ao.getColor(R.color.CAM_X0107));
            return;
        }
        this.fgD.setProgress(0.0f);
        this.fgF.setProgress(0.0f);
        setTextNormalColor(this.fgE);
        setTextNormalColor(this.fgG);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.fgL) {
            textView.setTextColor(ao.getColor(R.color.CAM_X0107));
        } else if (this.fgK) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ao.getColor(this.fgQ));
        }
    }

    public void jV(boolean z) {
        this.fgD.setMinAndMaxProgress(0.0f, 1.0f);
        this.fgF.setMinAndMaxProgress(0.0f, 1.0f);
        this.fgE.setText(b(this.fgH));
        this.fgD.clearColorFilter();
        this.fgF.clearColorFilter();
        if (z) {
            this.fgD.playAnimation();
            this.fgF.cancelAnimation();
            this.fgF.setFrame(0);
        } else {
            this.fgF.playAnimation();
            this.fgD.cancelAnimation();
            this.fgD.setFrame(0);
        }
        if (this.fgH.hasAgree) {
            if (this.fgH.agreeType == 2) {
                this.fgE.setTextColor(ao.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fgG);
                return;
            }
            setTextNormalColor(this.fgE);
            this.fgG.setTextColor(ao.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.fgE);
        setTextNormalColor(this.fgG);
    }

    public void bxl() {
        bB(this.fgD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bB(View view) {
        com.baidu.tbadk.pageExtra.c bV;
        int i = 0;
        int i2 = 1;
        if (this.fgH != null) {
            if (!this.fgK || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.fgK || bg.checkUpIsLogin(getContext())) {
                    if (view != this.fgE || this.fgW) {
                        if (view.getId() == this.fgD.getId() || (this.fgW && view.getId() == this.fgE.getId())) {
                            this.fgD.cancelAnimation();
                            if (this.fgM != null) {
                                this.fgM.type = 1;
                            }
                            if (this.fgH.hasAgree) {
                                if (this.fgH.agreeType == 2) {
                                    this.fgH.agreeType = 2;
                                    this.fgH.hasAgree = false;
                                    this.fgH.agreeNum--;
                                    updateUI();
                                    if (this.fgM != null) {
                                        this.fgM.eOC = 1;
                                    }
                                } else {
                                    this.fgH.agreeType = 2;
                                    this.fgH.hasAgree = true;
                                    this.fgH.agreeNum++;
                                    jV(true);
                                    com.baidu.tieba.o.a.dEB().F(getTbPageContext());
                                    if (this.fgM != null) {
                                        this.fgM.eOC = 0;
                                        i2 = 0;
                                    }
                                }
                                bV = com.baidu.tbadk.pageExtra.d.bV(this);
                                if (bV != null) {
                                    this.fgH.objSource = bV.getCurrentPageKey();
                                }
                                this.fgY.a(this.fgH, i2, getPageId(), this.fgK);
                            } else {
                                this.fgH.agreeType = 2;
                                this.fgH.hasAgree = true;
                                this.fgH.agreeNum++;
                                jV(true);
                                com.baidu.tieba.o.a.dEB().F(getTbPageContext());
                                if (this.fgM != null) {
                                    this.fgM.eOC = 0;
                                }
                            }
                            i2 = 0;
                            bV = com.baidu.tbadk.pageExtra.d.bV(this);
                            if (bV != null) {
                            }
                            this.fgY.a(this.fgH, i2, getPageId(), this.fgK);
                        } else if (view.getId() == this.fgF.getId()) {
                            this.fgF.cancelAnimation();
                            if (this.fgM != null) {
                                this.fgM.type = 2;
                            }
                            if (this.fgH.hasAgree) {
                                if (this.fgH.agreeType == 5) {
                                    this.fgH.agreeType = 5;
                                    this.fgH.hasAgree = false;
                                    updateUI();
                                    if (this.fgM != null) {
                                        this.fgM.eOG = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.fgH.agreeType = 5;
                                    this.fgH.hasAgree = true;
                                    this.fgH.agreeNum--;
                                    jV(false);
                                    if (this.fgM != null) {
                                        this.fgM.eOG = 1;
                                    }
                                }
                            } else {
                                this.fgH.agreeType = 5;
                                this.fgH.hasAgree = true;
                                jV(false);
                                if (this.fgM != null) {
                                    this.fgM.eOG = 1;
                                }
                            }
                            com.baidu.tbadk.pageExtra.c bV2 = com.baidu.tbadk.pageExtra.d.bV(this);
                            if (bV2 != null) {
                                this.fgH.objSource = bV2.getCurrentPageKey();
                            }
                            this.fgY.a(this.fgH, i, getPageId(), this.fgK);
                        }
                        this.fgY.a(this.fgH, this.fgI);
                        if (this.akV != null) {
                            this.akV.onClick(view);
                        }
                        bxm();
                    }
                }
            }
        }
    }

    public void bxm() {
        if (this.fgM != null && this.fgH != null) {
            int i = 0;
            if (this.fgH.baijiahaoData != null) {
                i = this.fgH.baijiahaoData.oriUgcType;
            }
            if (this.fgM.type == 1) {
                if (StringUtils.isNull(this.fgR)) {
                    aq dX = new aq("c12003").an("obj_locate", this.fgM.eOz).an("obj_param1", this.fgM.eOA).an("obj_source", this.fgM.eOB).an("obj_id", this.fgM.eOC).an("obj_name", i).dX("post_id", this.fgH.postId);
                    if (this.eMv != null) {
                        dX.dX("tid", this.eMv.getId()).dX(IntentConfig.NID, this.eMv.bpP()).w("fid", this.eMv.getFid()).an(IntentConfig.CARD_TYPE, this.cardType).dX("ab_tag", this.eMv.mRecomAbTag).dX(IntentConfig.RECOM_SOURCE, this.eMv.mRecomSource).dX("weight", this.eMv.mRecomWeight).dX("extra", this.eMv.mRecomExtra);
                        if (this.eMv.getBaijiahaoData() != null) {
                            dX.dX("obj_param4", this.eMv.getBaijiahaoData().oriUgcNid);
                            if (this.eMv.bpZ() || this.eMv.btq()) {
                                dX.dX("obj_param6", this.eMv.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.eMv.bto()) {
                            dX.an("obj_param5", 2);
                        } else if (this.eMv.bpY() || this.eMv.bpZ()) {
                            dX.an("obj_param5", 3);
                        } else if (this.eMv.threadType == 0 || this.eMv.threadType == 40) {
                            dX.an("obj_param5", 1);
                        }
                    } else {
                        dX.dX("tid", this.fgH.threadId);
                        dX.dX(IntentConfig.NID, this.fgH.nid);
                        dX.dX("fid", this.fgH.forumId);
                        dX.an(IntentConfig.CARD_TYPE, this.fgH.cardType);
                        dX.dX("ab_tag", this.fgH.recomAbTag);
                        dX.dX(IntentConfig.RECOM_SOURCE, this.fgH.recomSource);
                        dX.dX("weight", this.fgH.recomWeight);
                        dX.dX("extra", this.fgH.recomExtra);
                        if (this.fgH.baijiahaoData != null) {
                            dX.dX("obj_param6", this.fgH.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (qJ(this.fgM.eOz) && qK(this.fgM.eOD) != -1) {
                        dX.an(TiebaInitialize.Params.OBJ_TO, qK(this.fgM.eOD));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dX.dX("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dX.an("resource_id", this.fgN);
                    } else if (this.mFrom == 18) {
                        dX.dX("obj_tab", "a099");
                        dX.dX("resource_id", this.mTabName);
                    } else {
                        dX.an("resource_id", this.fgN);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dX);
                    }
                    if (this.fgH.isFromImageViewer) {
                        dX.dX("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.fgH.mImageViewerFromPage == "index") {
                            dX.dX(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.fgH.keyFromHomePage)) {
                        dX.dX("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dX.dX("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
                    if (bV != null) {
                        dX.dX("obj_cur_page", bV.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bHn() != null) {
                        dX.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHn());
                    }
                    TiebaStatic.log(dX);
                    return;
                }
                TiebaStatic.log(new aq("c13358").dX("tid", this.fgH.threadId).dX("topic_id", this.fgR));
            } else if (this.fgM.type == 2) {
                aq dX2 = new aq("c13271").an("obj_type", this.fgM.eOE).an("obj_locate", this.fgM.eOF).an(TiebaInitialize.Params.OBJ_PARAM2, this.fgN).an("obj_id", this.fgM.eOG).an("obj_name", i).dX("post_id", this.fgH.postId).dX(IntentConfig.NID, this.fgH.nid);
                if (this.eMv != null) {
                    dX2.dX("tid", this.eMv.getId()).dX(IntentConfig.NID, this.eMv.bpP()).w("fid", this.eMv.getFid()).an(IntentConfig.CARD_TYPE, this.cardType).dX("ab_tag", this.eMv.mRecomAbTag).dX(IntentConfig.RECOM_SOURCE, this.eMv.mRecomSource).dX("weight", this.eMv.mRecomWeight).dX("extra", this.eMv.mRecomExtra);
                    if (this.eMv.getBaijiahaoData() != null) {
                        dX2.dX("obj_param4", this.eMv.getBaijiahaoData().oriUgcNid);
                        if (this.eMv.bpZ() || this.eMv.btq()) {
                            dX2.dX("obj_param6", this.eMv.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.eMv.bto()) {
                        dX2.an("obj_param5", 2);
                    } else if (this.eMv.bpY() || this.eMv.bpZ()) {
                        dX2.an("obj_param5", 3);
                    } else if (this.eMv.threadType == 0 || this.eMv.threadType == 40) {
                        dX2.an("obj_param5", 1);
                    }
                } else {
                    dX2.dX("tid", this.fgH.threadId);
                    dX2.dX(IntentConfig.NID, this.fgH.nid);
                    dX2.dX("fid", this.fgH.forumId);
                    dX2.an(IntentConfig.CARD_TYPE, this.fgH.cardType);
                    dX2.dX("ab_tag", this.fgH.recomAbTag);
                    dX2.dX(IntentConfig.RECOM_SOURCE, this.fgH.recomSource);
                    dX2.dX("weight", this.fgH.recomWeight);
                    dX2.dX("extra", this.fgH.recomExtra);
                    if (this.fgH.baijiahaoData != null) {
                        dX2.dX("obj_param6", this.fgH.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dX2.dX("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dX2.dX("obj_tab", "a099");
                    dX2.dX("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dX2);
                }
                if (this.fgH.isFromImageViewer) {
                    dX2.dX("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.fgH.mImageViewerFromPage == "index") {
                        dX2.dX(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dX2);
            }
        }
    }

    public static boolean qJ(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int qK(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.fgJ == null) {
            this.fgJ = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fgJ.setDuration(200L);
        }
        return this.fgJ;
    }

    public void onChangeSkinType(int i) {
        if (this.fgH != null && this.mSkinType != i) {
            this.mSkinType = i;
            ao.a(this.fgD, this.fgO);
            ao.a(this.fgF, this.fgP);
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

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.fgM = dVar;
    }

    public void setGameId(int i) {
        this.fgN = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.fgF.setVisibility(z ? 8 : 0);
        this.fgG.setVisibility(z ? 8 : 0);
        if (z && this.fgT != null) {
            this.fgT.setVisibility(8);
        }
        if (this.fgV != z && this.fgX != null) {
            this.fgX.f(this.fgF, z);
        }
        this.fgV = z;
    }

    public void setDisagreeShow(boolean z) {
        this.fgF.setVisibility(z ? 8 : 0);
        this.fgG.setVisibility(z ? 8 : 0);
        if (this.fgT != null) {
            this.fgT.setVisibility(z ? 8 : 0);
        }
        this.fgV = z;
    }

    public boolean bxn() {
        return this.fgV;
    }

    public void setThreadData(bz bzVar) {
        this.eMv = bzVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.fgO = i;
        this.fgP = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.fgQ = i;
        setTextNormalColor(this.fgE);
        setTextNormalColor(this.fgG);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akV = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.fgX = aVar;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.fgF;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.fgD;
    }
}
