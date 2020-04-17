package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
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
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
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
    private View.OnClickListener afS;
    private int cardType;
    private TBLottieAnimationView dDf;
    private TextView dDg;
    private TBLottieAnimationView dDh;
    private TextView dDi;
    private AgreeData dDj;
    private com.baidu.tieba.tbadkCore.data.e dDk;
    private ScaleAnimation dDl;
    private boolean dDm;
    private boolean dDn;
    private com.baidu.tbadk.core.data.d dDo;
    private int dDp;
    private int dDq;
    private int dDr;
    private String dDs;
    private View dDt;
    private CustomMessageListener dDu;
    private CustomMessageListener dDv;
    private bj dqA;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.dDj != null) {
            this.dDj.agreeType = agreeData.agreeType;
            this.dDj.hasAgree = agreeData.hasAgree;
            this.dDj.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dDq = R.raw.lottie_agree;
        this.dDr = R.raw.lottie_disagree;
        this.cardType = 1;
        this.dDu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDj != null && agreeData != null && AgreeView.this.dDk != null && !AgreeView.this.dDj.isInPost && AgreeView.this.dDk.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dDj.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dDj.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dDj.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dDv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDj != null && !TextUtils.isEmpty(AgreeView.this.dDj.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dDj.postId.equals(agreeData.postId) && !AgreeView.this.dDj.isInThread) {
                        if (AgreeView.this.dDm) {
                            if (AgreeView.this.dDj.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dDk.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aS(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dDq = R.raw.lottie_agree;
        this.dDr = R.raw.lottie_disagree;
        this.cardType = 1;
        this.dDu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDj != null && agreeData != null && AgreeView.this.dDk != null && !AgreeView.this.dDj.isInPost && AgreeView.this.dDk.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dDj.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dDj.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dDj.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dDv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDj != null && !TextUtils.isEmpty(AgreeView.this.dDj.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dDj.postId.equals(agreeData.postId) && !AgreeView.this.dDj.isInThread) {
                        if (AgreeView.this.dDm) {
                            if (AgreeView.this.dDj.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dDk.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aS(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dDq = R.raw.lottie_agree;
        this.dDr = R.raw.lottie_disagree;
        this.cardType = 1;
        this.dDu = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDj != null && agreeData != null && AgreeView.this.dDk != null && !AgreeView.this.dDj.isInPost && AgreeView.this.dDk.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dDj.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dDj.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dDj.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dDv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDj != null && !TextUtils.isEmpty(AgreeView.this.dDj.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dDj.postId.equals(agreeData.postId) && !AgreeView.this.dDj.isInThread) {
                        if (AgreeView.this.dDm) {
                            if (AgreeView.this.dDj.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dDk.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aS(view);
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.dDf = new TBLottieAnimationView(context);
        this.dDf.setId(R.id.img_agree);
        this.dDf.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dDf.setOnClickListener(this.mOnClickListener);
        this.dDf.addAnimatorListener(this);
        this.dDg = new TextView(context);
        this.dDg.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.dDg.setOnClickListener(this.mOnClickListener);
        this.dDh = new TBLottieAnimationView(context);
        this.dDh.setId(R.id.img_disagree);
        this.dDh.addAnimatorListener(this);
        this.dDh.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dDh.setOnClickListener(this.mOnClickListener);
        this.dDi = new TextView(context);
        this.dDi.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.dDi.setOnClickListener(this.mOnClickListener);
        this.dDk = new com.baidu.tieba.tbadkCore.data.e();
        this.dDk.uniqueId = getPageId();
        aPL();
        setAgreeAnimationResource();
    }

    private void aPL() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        addView(this.dDf, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        addView(this.dDg, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        layoutParams3.gravity = 16;
        addView(this.dDh, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.dDi.setText(R.string.c_disagree);
        addView(this.dDi, layoutParams2);
    }

    public void aPM() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dDf.setLayoutParams(layoutParams);
        this.dDg.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dDg.setLayoutParams(layoutParams2);
        this.dDh.setVisibility(8);
        this.dDi.setVisibility(8);
    }

    public void aPN() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.dDf.setLayoutParams(layoutParams);
        this.dDg.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        this.dDg.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        layoutParams3.gravity = 16;
        this.dDh.setLayoutParams(layoutParams3);
        this.dDi.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.dDi.setLayoutParams(layoutParams4);
    }

    public void aPO() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.dDf, new LinearLayout.LayoutParams(dimens, dimens));
        this.dDg.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.dDg, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.dDt = linearLayout2;
        linearLayout2.addView(this.dDh, new LinearLayout.LayoutParams(dimens, dimens));
        this.dDi.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.dDi, layoutParams4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dDu);
        MessageManager.getInstance().registerListener(this.dDv);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dDu);
        MessageManager.getInstance().unRegisterListener(this.dDv);
    }

    public void setTopicId(String str) {
        this.dDs = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.dDm = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.dDn = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.dDf;
    }

    public TextView getAgreeNumView() {
        return this.dDg;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.dDh;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.dDj = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.dDj;
    }

    public void setAgreeAnimationResource() {
        if (this.dDm) {
            am.b(this.dDf, this.dDq);
            am.b(this.dDh, this.dDr);
            return;
        }
        am.a(this.dDf, this.dDq);
        am.a(this.dDh, this.dDr);
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
        this.dDg.setText(b(this.dDj));
        if (this.dDj.hasAgree) {
            if (this.dDj.agreeType == 2) {
                this.dDh.setProgress(0.0f);
                this.dDf.setProgress(1.0f);
                this.dDg.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.dDi);
                return;
            }
            this.dDf.setProgress(0.0f);
            this.dDh.setProgress(1.0f);
            setTextNormalColor(this.dDg);
            this.dDi.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.dDf.setProgress(0.0f);
        this.dDh.setProgress(0.0f);
        setTextNormalColor(this.dDg);
        setTextNormalColor(this.dDi);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.dDn) {
            textView.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.dDm) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void gM(boolean z) {
        this.dDf.setMinAndMaxProgress(0.0f, 1.0f);
        this.dDh.setMinAndMaxProgress(0.0f, 1.0f);
        this.dDg.setText(b(this.dDj));
        this.dDf.clearColorFilter();
        this.dDh.clearColorFilter();
        if (z) {
            this.dDf.playAnimation();
            this.dDh.cancelAnimation();
            this.dDh.setFrame(0);
        } else {
            this.dDh.playAnimation();
            this.dDf.cancelAnimation();
            this.dDf.setFrame(0);
        }
        if (this.dDj.hasAgree) {
            if (this.dDj.agreeType == 2) {
                this.dDg.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.dDi);
                return;
            }
            setTextNormalColor(this.dDg);
            this.dDi.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.dDg);
        setTextNormalColor(this.dDi);
    }

    public void aPP() {
        aS(this.dDf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        int i = 0;
        int i2 = 1;
        if (this.dDj != null) {
            if (!this.dDm || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.dDm || bc.checkUpIsLogin(getContext())) && view != this.dDg) {
                    if (view.getId() == this.dDf.getId()) {
                        this.dDf.cancelAnimation();
                        if (this.dDo != null) {
                            this.dDo.type = 1;
                        }
                        if (this.dDj.hasAgree) {
                            if (this.dDj.agreeType == 2) {
                                this.dDj.agreeType = 2;
                                this.dDj.hasAgree = false;
                                this.dDj.agreeNum--;
                                updateUI();
                                if (this.dDo != null) {
                                    this.dDo.dmW = 1;
                                }
                            } else {
                                this.dDj.agreeType = 2;
                                this.dDj.hasAgree = true;
                                this.dDj.agreeNum++;
                                gM(true);
                                com.baidu.tieba.o.a.cMU().E(getTbPageContext());
                                if (this.dDo != null) {
                                    this.dDo.dmW = 0;
                                    i2 = 0;
                                }
                            }
                            lc(i2);
                        } else {
                            this.dDj.agreeType = 2;
                            this.dDj.hasAgree = true;
                            this.dDj.agreeNum++;
                            gM(true);
                            com.baidu.tieba.o.a.cMU().E(getTbPageContext());
                            if (this.dDo != null) {
                                this.dDo.dmW = 0;
                            }
                        }
                        i2 = 0;
                        lc(i2);
                    } else if (view.getId() == this.dDh.getId()) {
                        this.dDh.cancelAnimation();
                        if (this.dDo != null) {
                            this.dDo.type = 2;
                        }
                        if (this.dDj.hasAgree) {
                            if (this.dDj.agreeType == 5) {
                                this.dDj.agreeType = 5;
                                this.dDj.hasAgree = false;
                                updateUI();
                                if (this.dDo != null) {
                                    this.dDo.dna = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.dDj.agreeType = 5;
                                this.dDj.hasAgree = true;
                                this.dDj.agreeNum--;
                                gM(false);
                                if (this.dDo != null) {
                                    this.dDo.dna = 1;
                                }
                            }
                        } else {
                            this.dDj.agreeType = 5;
                            this.dDj.hasAgree = true;
                            gM(false);
                            if (this.dDo != null) {
                                this.dDo.dna = 1;
                            }
                        }
                        lc(i);
                    }
                    this.dDk.agreeData = this.dDj;
                    if (this.dDj.isInThread) {
                        if (this.dDj.baijiahaoData != null) {
                            this.dDj.nid = this.dDj.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.dDk));
                        a(this.dDj, AgreeEvent.IS_THREAD);
                    } else if (this.dDj.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.dDk));
                        a(this.dDj, AgreeEvent.IS_POST);
                    }
                    if (this.afS != null) {
                        this.afS.onClick(view);
                    }
                    aPQ();
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

    public void lc(int i) {
        if (this.dDj != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.dDj.threadId);
            httpMessage.addParam("op_type", i);
            if (this.dDj.objType == 0) {
                this.dDj.objType = 3;
            }
            httpMessage.addParam("obj_type", this.dDj.objType);
            httpMessage.addParam("agree_type", this.dDj.agreeType);
            httpMessage.addParam("forum_id", this.dDj.forumId);
            if (!TextUtils.isEmpty(this.dDj.postId)) {
                httpMessage.addParam("post_id", this.dDj.postId);
            }
            if (this.dDj.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.dDj.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.dDj.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.dDj.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.dDj.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.dDm) {
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

    public void aPQ() {
        if (this.dDo != null && this.dDj != null) {
            int i = 0;
            if (this.dDj.baijiahaoData != null) {
                i = this.dDj.baijiahaoData.oriUgcType;
            }
            if (this.dDo.type == 1) {
                if (StringUtils.isNull(this.dDs)) {
                    an cI = new an("c12003").af("obj_locate", this.dDo.dmT).af("obj_param1", this.dDo.dmU).af("obj_source", this.dDo.dmV).af("obj_id", this.dDo.dmW).af("obj_name", i).cI("post_id", this.dDj.postId);
                    if (this.dqA != null) {
                        cI.cI("tid", this.dqA.getId()).t("fid", this.dqA.getFid()).af("card_type", this.cardType).cI(TiebaInitialize.Params.AB_TAG, this.dqA.mRecomAbTag).cI("recom_source", this.dqA.mRecomSource).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, this.dqA.mRecomWeight).cI("extra", this.dqA.mRecomExtra);
                        if (this.dqA.getBaijiahaoData() != null) {
                            cI.cI("obj_param4", this.dqA.getBaijiahaoData().oriUgcNid);
                            if (this.dqA.aJu() || this.dqA.aMz()) {
                                cI.cI("obj_param6", this.dqA.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.dqA.aMx()) {
                            cI.af("obj_param5", 2);
                        } else if (this.dqA.aJt() || this.dqA.aJu()) {
                            cI.af("obj_param5", 3);
                        } else if (this.dqA.threadType == 0 || this.dqA.threadType == 40) {
                            cI.af("obj_param5", 1);
                        }
                    }
                    if (ld(this.dDo.dmT) && le(this.dDo.dmX) != -1) {
                        cI.af(TiebaInitialize.Params.OBJ_TO, le(this.dDo.dmX));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        cI.cI("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        cI.af("resource_id", this.dDp);
                    } else if (this.mFrom == 18) {
                        cI.cI("obj_tab", "a099");
                        cI.cI("resource_id", this.mTabName);
                    } else {
                        cI.af("resource_id", this.dDp);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cI);
                    }
                    TiebaStatic.log(cI);
                    return;
                }
                TiebaStatic.log(new an("c13358").cI("tid", this.dDj.threadId).cI("topic_id", this.dDs));
            } else if (this.dDo.type == 2) {
                an cI2 = new an("c13271").af("obj_type", this.dDo.dmY).af("obj_locate", this.dDo.dmZ).af(TiebaInitialize.Params.OBJ_PARAM2, this.dDp).af("obj_id", this.dDo.dna).af("obj_name", i).cI("post_id", this.dDj.postId);
                if (this.dqA != null) {
                    cI2.cI("tid", this.dqA.getId()).t("fid", this.dqA.getFid()).af("card_type", this.cardType).cI(TiebaInitialize.Params.AB_TAG, this.dqA.mRecomAbTag).cI("recom_source", this.dqA.mRecomSource).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, this.dqA.mRecomWeight).cI("extra", this.dqA.mRecomExtra);
                    if (this.dqA.getBaijiahaoData() != null) {
                        cI2.cI("obj_param4", this.dqA.getBaijiahaoData().oriUgcNid);
                        if (this.dqA.aJu() || this.dqA.aMz()) {
                            cI2.cI("obj_param6", this.dqA.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.dqA.aMx()) {
                        cI2.af("obj_param5", 2);
                    } else if (this.dqA.aJt() || this.dqA.aJu()) {
                        cI2.af("obj_param5", 3);
                    } else if (this.dqA.threadType == 0 || this.dqA.threadType == 40) {
                        cI2.af("obj_param5", 1);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    cI2.cI("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    cI2.cI("obj_tab", "a099");
                    cI2.cI("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cI2);
                }
                TiebaStatic.log(cI2);
            }
        }
    }

    public static boolean ld(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int le(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.dDl == null) {
            this.dDl = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dDl.setDuration(200L);
        }
        return this.dDl;
    }

    public void onChangeSkinType(int i) {
        if (this.dDj != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.dDm) {
                am.b(this.dDf, this.dDq);
                am.b(this.dDh, this.dDr);
            } else {
                am.a(this.dDf, this.dDq);
                am.a(this.dDh, this.dDr);
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

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.dDo = dVar;
    }

    public void setGameId(int i) {
        this.dDp = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.dDh.setVisibility(z ? 8 : 0);
        this.dDi.setVisibility(z ? 8 : 0);
        if (z && this.dDt != null) {
            this.dDt.setVisibility(8);
        }
    }

    public void setThreadData(bj bjVar) {
        this.dqA = bjVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afS = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
