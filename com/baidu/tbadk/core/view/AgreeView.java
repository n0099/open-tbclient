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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes15.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener ahn;
    private int cardType;
    private bv dLK;
    private ScaleAnimation eeA;
    private boolean eeB;
    private boolean eeC;
    private com.baidu.tbadk.core.data.c eeD;
    private int eeE;
    private int eeF;
    private int eeG;
    private int eeH;
    private String eeI;
    public View.OnClickListener eeJ;
    private LinearLayout eeK;
    private LinearLayout eeL;
    private boolean eeM;
    private boolean eeN;
    private a eeO;
    private com.baidu.tbadk.core.message.a eeP;
    private CustomMessageListener eeQ;
    private TBLottieAnimationView eeu;
    private TextView eev;
    private TBLottieAnimationView eew;
    private TextView eex;
    private AgreeData eey;
    private com.baidu.tieba.tbadkCore.data.e eez;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes15.dex */
    public interface a {
        void f(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.eey != null) {
            this.eey.agreeType = agreeData.agreeType;
            this.eey.hasAgree = agreeData.hasAgree;
            this.eey.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eeF = R.raw.lottie_agree;
        this.eeG = R.raw.lottie_disagree;
        this.eeH = R.color.cp_cont_j;
        this.cardType = 1;
        this.eeM = false;
        this.eeN = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eey != null && agreeData != null && AgreeView.this.eez != null && !AgreeView.this.eey.isInPost && AgreeView.this.eez.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eey.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eey.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eey.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eeQ = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eey != null && !TextUtils.isEmpty(AgreeView.this.eey.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eey.postId.equals(agreeData.postId) && !AgreeView.this.eey.isInThread) {
                        if (AgreeView.this.eeB) {
                            if (AgreeView.this.eey.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eez.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aZ(view);
                if (AgreeView.this.eeJ != null) {
                    AgreeView.this.eeJ.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eeF = R.raw.lottie_agree;
        this.eeG = R.raw.lottie_disagree;
        this.eeH = R.color.cp_cont_j;
        this.cardType = 1;
        this.eeM = false;
        this.eeN = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eey != null && agreeData != null && AgreeView.this.eez != null && !AgreeView.this.eey.isInPost && AgreeView.this.eez.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eey.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eey.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eey.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eeQ = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eey != null && !TextUtils.isEmpty(AgreeView.this.eey.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eey.postId.equals(agreeData.postId) && !AgreeView.this.eey.isInThread) {
                        if (AgreeView.this.eeB) {
                            if (AgreeView.this.eey.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eez.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aZ(view);
                if (AgreeView.this.eeJ != null) {
                    AgreeView.this.eeJ.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eeF = R.raw.lottie_agree;
        this.eeG = R.raw.lottie_disagree;
        this.eeH = R.color.cp_cont_j;
        this.cardType = 1;
        this.eeM = false;
        this.eeN = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eey != null && agreeData != null && AgreeView.this.eez != null && !AgreeView.this.eey.isInPost && AgreeView.this.eez.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eey.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eey.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eey.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eeQ = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eey != null && !TextUtils.isEmpty(AgreeView.this.eey.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eey.postId.equals(agreeData.postId) && !AgreeView.this.eey.isInThread) {
                        if (AgreeView.this.eeB) {
                            if (AgreeView.this.eey.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eez.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aZ(view);
                if (AgreeView.this.eeJ != null) {
                    AgreeView.this.eeJ.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.eeu = new TBLottieAnimationView(context);
        this.eeu.setId(R.id.img_agree);
        this.eeu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eeu.setOnClickListener(this.mOnClickListener);
        this.eeu.addAnimatorListener(this);
        this.eev = new TextView(context);
        this.eev.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eev.setOnClickListener(this.mOnClickListener);
        this.eew = new TBLottieAnimationView(context);
        this.eew.setId(R.id.img_disagree);
        this.eew.addAnimatorListener(this);
        this.eew.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eew.setOnClickListener(this.mOnClickListener);
        this.eex = new TextView(context);
        this.eex.setText(R.string.c_disagree);
        this.eex.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eex.setOnClickListener(this.mOnClickListener);
        this.eez = new com.baidu.tieba.tbadkCore.data.e();
        this.eez.uniqueId = getPageId();
        this.eeP = new com.baidu.tbadk.core.message.a();
        bbH();
        setAgreeAnimationResource();
    }

    private void bbH() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eeL = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.eeu);
        linearLayout.addView(this.eev);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.eeK = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.eew);
        linearLayout2.addView(this.eex);
        hS(false);
    }

    private void s(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.eeL.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
        layoutParams.weight = i3;
        this.eeL.setLayoutParams(layoutParams);
        this.eeu.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.eev.setLayoutParams(layoutParams2);
        this.eeK.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
        layoutParams3.weight = i3;
        this.eeK.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.eew.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.eex.setLayoutParams(layoutParams5);
    }

    public void hS(boolean z) {
        if (z) {
            s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), 0, 1, 17);
            setAgreeAlone(this.eeM);
            return;
        }
        s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), -2, 0, 16);
        setAgreeAlone(this.eeM);
    }

    public void bbI() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eeu.setLayoutParams(layoutParams);
        this.eev.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eev.setLayoutParams(layoutParams2);
        this.eew.setVisibility(8);
        this.eex.setVisibility(8);
    }

    public void hT(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.eeu.setLayoutParams(layoutParams);
        this.eev.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = i;
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.eev.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.eeN = true;
        }
        layoutParams2.gravity = 16;
        this.eev.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        this.eew.setLayoutParams(layoutParams3);
        this.eex.setVisibility(8);
    }

    public void bbJ() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        aY(this.eeu);
        aY(this.eew);
        aY(this.eev);
        aY(this.eex);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.eeu, new LinearLayout.LayoutParams(dimens, dimens));
        this.eev.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.eev, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.eeK = linearLayout2;
        linearLayout2.addView(this.eew, new LinearLayout.LayoutParams(dimens, dimens));
        this.eex.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.eex, layoutParams4);
    }

    private void aY(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eeQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eeQ);
    }

    public void setTopicId(String str) {
        this.eeI = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.eeB = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.eeC = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.eeu;
    }

    public TextView getAgreeNumView() {
        return this.eev;
    }

    public TextView getDisagreeNumView() {
        return this.eex;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.eew;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.eey = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.eey;
    }

    public void setAgreeAnimationResource() {
        ao.a(this.eeu, this.eeF);
        ao.a(this.eew, this.eeG);
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
            return as.numFormatOverWanNa(j);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + as.numFormatOverWanNa(-j);
    }

    public void updateUI() {
        this.eev.setText(b(this.eey));
        if (this.eey.hasAgree) {
            if (this.eey.agreeType == 2) {
                this.eew.setProgress(0.0f);
                this.eeu.setProgress(1.0f);
                this.eev.setTextColor(ao.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eex);
                return;
            }
            this.eeu.setProgress(0.0f);
            this.eew.setProgress(1.0f);
            setTextNormalColor(this.eev);
            this.eex.setTextColor(ao.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.eeu.setProgress(0.0f);
        this.eew.setProgress(0.0f);
        setTextNormalColor(this.eev);
        setTextNormalColor(this.eex);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.eeC) {
            textView.setTextColor(ao.getColor(R.color.cp_cont_d));
        } else if (this.eeB) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(ao.getColor(this.eeH));
        }
    }

    public void hU(boolean z) {
        this.eeu.setMinAndMaxProgress(0.0f, 1.0f);
        this.eew.setMinAndMaxProgress(0.0f, 1.0f);
        this.eev.setText(b(this.eey));
        this.eeu.clearColorFilter();
        this.eew.clearColorFilter();
        if (z) {
            this.eeu.playAnimation();
            this.eew.cancelAnimation();
            this.eew.setFrame(0);
        } else {
            this.eew.playAnimation();
            this.eeu.cancelAnimation();
            this.eeu.setFrame(0);
        }
        if (this.eey.hasAgree) {
            if (this.eey.agreeType == 2) {
                this.eev.setTextColor(ao.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eex);
                return;
            }
            setTextNormalColor(this.eev);
            this.eex.setTextColor(ao.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.eev);
        setTextNormalColor(this.eex);
    }

    public void bbK() {
        aZ(this.eeu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(View view) {
        int i = 0;
        int i2 = 1;
        if (this.eey != null) {
            if (!this.eeB || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.eeB || bf.checkUpIsLogin(getContext())) {
                    if (view != this.eev || this.eeN) {
                        if (view.getId() == this.eeu.getId() || (this.eeN && view.getId() == this.eev.getId())) {
                            this.eeu.cancelAnimation();
                            if (this.eeD != null) {
                                this.eeD.type = 1;
                            }
                            if (this.eey.hasAgree) {
                                if (this.eey.agreeType == 2) {
                                    this.eey.agreeType = 2;
                                    this.eey.hasAgree = false;
                                    this.eey.agreeNum--;
                                    updateUI();
                                    if (this.eeD != null) {
                                        this.eeD.dNE = 1;
                                    }
                                } else {
                                    this.eey.agreeType = 2;
                                    this.eey.hasAgree = true;
                                    this.eey.agreeNum++;
                                    hU(true);
                                    com.baidu.tieba.o.a.dbG().G(getTbPageContext());
                                    if (this.eeD != null) {
                                        this.eeD.dNE = 0;
                                        i2 = 0;
                                    }
                                }
                                this.eeP.a(this.eey, i2, getPageId(), this.eeB);
                            } else {
                                this.eey.agreeType = 2;
                                this.eey.hasAgree = true;
                                this.eey.agreeNum++;
                                hU(true);
                                com.baidu.tieba.o.a.dbG().G(getTbPageContext());
                                if (this.eeD != null) {
                                    this.eeD.dNE = 0;
                                }
                            }
                            i2 = 0;
                            this.eeP.a(this.eey, i2, getPageId(), this.eeB);
                        } else if (view.getId() == this.eew.getId()) {
                            this.eew.cancelAnimation();
                            if (this.eeD != null) {
                                this.eeD.type = 2;
                            }
                            if (this.eey.hasAgree) {
                                if (this.eey.agreeType == 5) {
                                    this.eey.agreeType = 5;
                                    this.eey.hasAgree = false;
                                    updateUI();
                                    if (this.eeD != null) {
                                        this.eeD.dNI = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.eey.agreeType = 5;
                                    this.eey.hasAgree = true;
                                    this.eey.agreeNum--;
                                    hU(false);
                                    if (this.eeD != null) {
                                        this.eeD.dNI = 1;
                                    }
                                }
                            } else {
                                this.eey.agreeType = 5;
                                this.eey.hasAgree = true;
                                hU(false);
                                if (this.eeD != null) {
                                    this.eeD.dNI = 1;
                                }
                            }
                            this.eeP.a(this.eey, i, getPageId(), this.eeB);
                        }
                        this.eeP.a(this.eey, this.eez);
                        if (this.ahn != null) {
                            this.ahn.onClick(view);
                        }
                        bbL();
                    }
                }
            }
        }
    }

    public void bbL() {
        if (this.eeD != null && this.eey != null) {
            int i = 0;
            if (this.eey.baijiahaoData != null) {
                i = this.eey.baijiahaoData.oriUgcType;
            }
            if (this.eeD.type == 1) {
                if (StringUtils.isNull(this.eeI)) {
                    ap dn = new ap("c12003").ah("obj_locate", this.eeD.dNB).ah("obj_param1", this.eeD.dNC).ah("obj_source", this.eeD.dND).ah("obj_id", this.eeD.dNE).ah("obj_name", i).dn("post_id", this.eey.postId);
                    if (this.dLK != null) {
                        dn.dn("tid", this.dLK.getId()).dn("nid", this.dLK.getNid()).t("fid", this.dLK.getFid()).ah(IntentConfig.CARD_TYPE, this.cardType).dn("ab_tag", this.dLK.mRecomAbTag).dn(IntentConfig.RECOM_SOURCE, this.dLK.mRecomSource).dn("weight", this.dLK.mRecomWeight).dn("extra", this.dLK.mRecomExtra);
                        if (this.dLK.getBaijiahaoData() != null) {
                            dn.dn("obj_param4", this.dLK.getBaijiahaoData().oriUgcNid);
                            if (this.dLK.aUU() || this.dLK.aYh()) {
                                dn.dn("obj_param6", this.dLK.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.dLK.aYf()) {
                            dn.ah("obj_param5", 2);
                        } else if (this.dLK.aUT() || this.dLK.aUU()) {
                            dn.ah("obj_param5", 3);
                        } else if (this.dLK.threadType == 0 || this.dLK.threadType == 40) {
                            dn.ah("obj_param5", 1);
                        }
                    } else {
                        dn.dn("tid", this.eey.threadId);
                        dn.dn("nid", this.eey.nid);
                        dn.dn("fid", this.eey.forumId);
                        dn.ah(IntentConfig.CARD_TYPE, this.eey.cardType);
                        dn.dn("ab_tag", this.eey.recomAbTag);
                        dn.dn(IntentConfig.RECOM_SOURCE, this.eey.recomSource);
                        dn.dn("weight", this.eey.recomWeight);
                        dn.dn("extra", this.eey.recomExtra);
                        if (this.eey.baijiahaoData != null) {
                            dn.dn("obj_param6", this.eey.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (mr(this.eeD.dNB) && ms(this.eeD.dNF) != -1) {
                        dn.ah(TiebaInitialize.Params.OBJ_TO, ms(this.eeD.dNF));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dn.dn("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dn.ah("resource_id", this.eeE);
                    } else if (this.mFrom == 18) {
                        dn.dn("obj_tab", "a099");
                        dn.dn("resource_id", this.mTabName);
                    } else {
                        dn.ah("resource_id", this.eeE);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dn);
                    }
                    if (this.eey.isFromImageViewer) {
                        dn.dn("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.eey.mImageViewerFromPage == "index") {
                            dn.dn(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.eey.keyFromHomePage)) {
                        dn.dn("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dn.dn("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    TiebaStatic.log(dn);
                    return;
                }
                TiebaStatic.log(new ap("c13358").dn("tid", this.eey.threadId).dn("topic_id", this.eeI));
            } else if (this.eeD.type == 2) {
                ap dn2 = new ap("c13271").ah("obj_type", this.eeD.dNG).ah("obj_locate", this.eeD.dNH).ah(TiebaInitialize.Params.OBJ_PARAM2, this.eeE).ah("obj_id", this.eeD.dNI).ah("obj_name", i).dn("post_id", this.eey.postId).dn("nid", this.eey.nid);
                if (this.dLK != null) {
                    dn2.dn("tid", this.dLK.getId()).dn("nid", this.dLK.getNid()).t("fid", this.dLK.getFid()).ah(IntentConfig.CARD_TYPE, this.cardType).dn("ab_tag", this.dLK.mRecomAbTag).dn(IntentConfig.RECOM_SOURCE, this.dLK.mRecomSource).dn("weight", this.dLK.mRecomWeight).dn("extra", this.dLK.mRecomExtra);
                    if (this.dLK.getBaijiahaoData() != null) {
                        dn2.dn("obj_param4", this.dLK.getBaijiahaoData().oriUgcNid);
                        if (this.dLK.aUU() || this.dLK.aYh()) {
                            dn2.dn("obj_param6", this.dLK.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.dLK.aYf()) {
                        dn2.ah("obj_param5", 2);
                    } else if (this.dLK.aUT() || this.dLK.aUU()) {
                        dn2.ah("obj_param5", 3);
                    } else if (this.dLK.threadType == 0 || this.dLK.threadType == 40) {
                        dn2.ah("obj_param5", 1);
                    }
                } else {
                    dn2.dn("tid", this.eey.threadId);
                    dn2.dn("nid", this.eey.nid);
                    dn2.dn("fid", this.eey.forumId);
                    dn2.ah(IntentConfig.CARD_TYPE, this.eey.cardType);
                    dn2.dn("ab_tag", this.eey.recomAbTag);
                    dn2.dn(IntentConfig.RECOM_SOURCE, this.eey.recomSource);
                    dn2.dn("weight", this.eey.recomWeight);
                    dn2.dn("extra", this.eey.recomExtra);
                    if (this.eey.baijiahaoData != null) {
                        dn2.dn("obj_param6", this.eey.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dn2.dn("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dn2.dn("obj_tab", "a099");
                    dn2.dn("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dn2);
                }
                if (this.eey.isFromImageViewer) {
                    dn2.dn("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.eey.mImageViewerFromPage == "index") {
                        dn2.dn(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dn2);
            }
        }
    }

    public static boolean mr(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int ms(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.eeA == null) {
            this.eeA = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.eeA.setDuration(200L);
        }
        return this.eeA;
    }

    public void onChangeSkinType(int i) {
        if (this.eey != null && this.mSkinType != i) {
            this.mSkinType = i;
            ao.a(this.eeu, this.eeF);
            ao.a(this.eew, this.eeG);
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
        this.eeD = cVar;
    }

    public void setGameId(int i) {
        this.eeE = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.eew.setVisibility(z ? 8 : 0);
        this.eex.setVisibility(z ? 8 : 0);
        if (z && this.eeK != null) {
            this.eeK.setVisibility(8);
        }
        if (this.eeM != z && this.eeO != null) {
            this.eeO.f(this.eew, z);
        }
        this.eeM = z;
    }

    public void setDisagreeShow(boolean z) {
        this.eew.setVisibility(z ? 8 : 0);
        this.eex.setVisibility(z ? 8 : 0);
        if (this.eeK != null) {
            this.eeK.setVisibility(z ? 8 : 0);
        }
        this.eeM = z;
    }

    public boolean bbM() {
        return this.eeM;
    }

    public void setThreadData(bv bvVar) {
        this.dLK = bvVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.eeF = i;
        this.eeG = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.eeH = i;
        setTextNormalColor(this.eev);
        setTextNormalColor(this.eex);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahn = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.eeO = aVar;
    }
}
