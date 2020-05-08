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
    private View.OnClickListener afV;
    private int cardType;
    private TBLottieAnimationView dDj;
    private TextView dDk;
    private TBLottieAnimationView dDl;
    private TextView dDm;
    private AgreeData dDn;
    private com.baidu.tieba.tbadkCore.data.e dDo;
    private ScaleAnimation dDp;
    private boolean dDq;
    private boolean dDr;
    private com.baidu.tbadk.core.data.d dDs;
    private int dDt;
    private int dDu;
    private int dDv;
    private String dDw;
    private View dDx;
    private CustomMessageListener dDy;
    private CustomMessageListener dDz;
    private bj dqE;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.dDn != null) {
            this.dDn.agreeType = agreeData.agreeType;
            this.dDn.hasAgree = agreeData.hasAgree;
            this.dDn.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dDu = R.raw.lottie_agree;
        this.dDv = R.raw.lottie_disagree;
        this.cardType = 1;
        this.dDy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDn != null && agreeData != null && AgreeView.this.dDo != null && !AgreeView.this.dDn.isInPost && AgreeView.this.dDo.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dDn.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dDn.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dDn.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dDz = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDn != null && !TextUtils.isEmpty(AgreeView.this.dDn.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dDn.postId.equals(agreeData.postId) && !AgreeView.this.dDn.isInThread) {
                        if (AgreeView.this.dDq) {
                            if (AgreeView.this.dDn.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dDo.uniqueId == eVar.uniqueId) {
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
        this.dDu = R.raw.lottie_agree;
        this.dDv = R.raw.lottie_disagree;
        this.cardType = 1;
        this.dDy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDn != null && agreeData != null && AgreeView.this.dDo != null && !AgreeView.this.dDn.isInPost && AgreeView.this.dDo.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dDn.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dDn.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dDn.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dDz = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDn != null && !TextUtils.isEmpty(AgreeView.this.dDn.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dDn.postId.equals(agreeData.postId) && !AgreeView.this.dDn.isInThread) {
                        if (AgreeView.this.dDq) {
                            if (AgreeView.this.dDn.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dDo.uniqueId == eVar.uniqueId) {
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
        this.dDu = R.raw.lottie_agree;
        this.dDv = R.raw.lottie_disagree;
        this.cardType = 1;
        this.dDy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDn != null && agreeData != null && AgreeView.this.dDo != null && !AgreeView.this.dDn.isInPost && AgreeView.this.dDo.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.dDn.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.dDn.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.dDn.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.dDz = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.dDn != null && !TextUtils.isEmpty(AgreeView.this.dDn.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.dDn.postId.equals(agreeData.postId) && !AgreeView.this.dDn.isInThread) {
                        if (AgreeView.this.dDq) {
                            if (AgreeView.this.dDn.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.dDo.uniqueId == eVar.uniqueId) {
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
        this.dDj = new TBLottieAnimationView(context);
        this.dDj.setId(R.id.img_agree);
        this.dDj.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dDj.setOnClickListener(this.mOnClickListener);
        this.dDj.addAnimatorListener(this);
        this.dDk = new TextView(context);
        this.dDk.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.dDk.setOnClickListener(this.mOnClickListener);
        this.dDl = new TBLottieAnimationView(context);
        this.dDl.setId(R.id.img_disagree);
        this.dDl.addAnimatorListener(this);
        this.dDl.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dDl.setOnClickListener(this.mOnClickListener);
        this.dDm = new TextView(context);
        this.dDm.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.dDm.setOnClickListener(this.mOnClickListener);
        this.dDo = new com.baidu.tieba.tbadkCore.data.e();
        this.dDo.uniqueId = getPageId();
        aPI();
        setAgreeAnimationResource();
    }

    private void aPI() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        addView(this.dDj, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        addView(this.dDk, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        layoutParams3.gravity = 16;
        addView(this.dDl, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.dDm.setText(R.string.c_disagree);
        addView(this.dDm, layoutParams2);
    }

    public void aPJ() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dDj.setLayoutParams(layoutParams);
        this.dDk.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dDk.setLayoutParams(layoutParams2);
        this.dDl.setVisibility(8);
        this.dDm.setVisibility(8);
    }

    public void aPK() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.dDj.setLayoutParams(layoutParams);
        this.dDk.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        this.dDk.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        layoutParams3.gravity = 16;
        this.dDl.setLayoutParams(layoutParams3);
        this.dDm.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.dDm.setLayoutParams(layoutParams4);
    }

    public void aPL() {
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
        linearLayout.addView(this.dDj, new LinearLayout.LayoutParams(dimens, dimens));
        this.dDk.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.dDk, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.dDx = linearLayout2;
        linearLayout2.addView(this.dDl, new LinearLayout.LayoutParams(dimens, dimens));
        this.dDm.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.dDm, layoutParams4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dDy);
        MessageManager.getInstance().registerListener(this.dDz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dDy);
        MessageManager.getInstance().unRegisterListener(this.dDz);
    }

    public void setTopicId(String str) {
        this.dDw = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.dDq = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.dDr = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.dDj;
    }

    public TextView getAgreeNumView() {
        return this.dDk;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.dDl;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.dDn = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.dDn;
    }

    public void setAgreeAnimationResource() {
        if (this.dDq) {
            am.b(this.dDj, this.dDu);
            am.b(this.dDl, this.dDv);
            return;
        }
        am.a(this.dDj, this.dDu);
        am.a(this.dDl, this.dDv);
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
        this.dDk.setText(b(this.dDn));
        if (this.dDn.hasAgree) {
            if (this.dDn.agreeType == 2) {
                this.dDl.setProgress(0.0f);
                this.dDj.setProgress(1.0f);
                this.dDk.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.dDm);
                return;
            }
            this.dDj.setProgress(0.0f);
            this.dDl.setProgress(1.0f);
            setTextNormalColor(this.dDk);
            this.dDm.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.dDj.setProgress(0.0f);
        this.dDl.setProgress(0.0f);
        setTextNormalColor(this.dDk);
        setTextNormalColor(this.dDm);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.dDr) {
            textView.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.dDq) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void gM(boolean z) {
        this.dDj.setMinAndMaxProgress(0.0f, 1.0f);
        this.dDl.setMinAndMaxProgress(0.0f, 1.0f);
        this.dDk.setText(b(this.dDn));
        this.dDj.clearColorFilter();
        this.dDl.clearColorFilter();
        if (z) {
            this.dDj.playAnimation();
            this.dDl.cancelAnimation();
            this.dDl.setFrame(0);
        } else {
            this.dDl.playAnimation();
            this.dDj.cancelAnimation();
            this.dDj.setFrame(0);
        }
        if (this.dDn.hasAgree) {
            if (this.dDn.agreeType == 2) {
                this.dDk.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.dDm);
                return;
            }
            setTextNormalColor(this.dDk);
            this.dDm.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.dDk);
        setTextNormalColor(this.dDm);
    }

    public void aPM() {
        aS(this.dDj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        int i = 0;
        int i2 = 1;
        if (this.dDn != null) {
            if (!this.dDq || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.dDq || bc.checkUpIsLogin(getContext())) && view != this.dDk) {
                    if (view.getId() == this.dDj.getId()) {
                        this.dDj.cancelAnimation();
                        if (this.dDs != null) {
                            this.dDs.type = 1;
                        }
                        if (this.dDn.hasAgree) {
                            if (this.dDn.agreeType == 2) {
                                this.dDn.agreeType = 2;
                                this.dDn.hasAgree = false;
                                this.dDn.agreeNum--;
                                updateUI();
                                if (this.dDs != null) {
                                    this.dDs.dna = 1;
                                }
                            } else {
                                this.dDn.agreeType = 2;
                                this.dDn.hasAgree = true;
                                this.dDn.agreeNum++;
                                gM(true);
                                com.baidu.tieba.o.a.cMR().E(getTbPageContext());
                                if (this.dDs != null) {
                                    this.dDs.dna = 0;
                                    i2 = 0;
                                }
                            }
                            lc(i2);
                        } else {
                            this.dDn.agreeType = 2;
                            this.dDn.hasAgree = true;
                            this.dDn.agreeNum++;
                            gM(true);
                            com.baidu.tieba.o.a.cMR().E(getTbPageContext());
                            if (this.dDs != null) {
                                this.dDs.dna = 0;
                            }
                        }
                        i2 = 0;
                        lc(i2);
                    } else if (view.getId() == this.dDl.getId()) {
                        this.dDl.cancelAnimation();
                        if (this.dDs != null) {
                            this.dDs.type = 2;
                        }
                        if (this.dDn.hasAgree) {
                            if (this.dDn.agreeType == 5) {
                                this.dDn.agreeType = 5;
                                this.dDn.hasAgree = false;
                                updateUI();
                                if (this.dDs != null) {
                                    this.dDs.dne = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.dDn.agreeType = 5;
                                this.dDn.hasAgree = true;
                                this.dDn.agreeNum--;
                                gM(false);
                                if (this.dDs != null) {
                                    this.dDs.dne = 1;
                                }
                            }
                        } else {
                            this.dDn.agreeType = 5;
                            this.dDn.hasAgree = true;
                            gM(false);
                            if (this.dDs != null) {
                                this.dDs.dne = 1;
                            }
                        }
                        lc(i);
                    }
                    this.dDo.agreeData = this.dDn;
                    if (this.dDn.isInThread) {
                        if (this.dDn.baijiahaoData != null) {
                            this.dDn.nid = this.dDn.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.dDo));
                        a(this.dDn, AgreeEvent.IS_THREAD);
                    } else if (this.dDn.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.dDo));
                        a(this.dDn, AgreeEvent.IS_POST);
                    }
                    if (this.afV != null) {
                        this.afV.onClick(view);
                    }
                    aPN();
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
        if (this.dDn != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.dDn.threadId);
            httpMessage.addParam("op_type", i);
            if (this.dDn.objType == 0) {
                this.dDn.objType = 3;
            }
            httpMessage.addParam("obj_type", this.dDn.objType);
            httpMessage.addParam("agree_type", this.dDn.agreeType);
            httpMessage.addParam("forum_id", this.dDn.forumId);
            if (!TextUtils.isEmpty(this.dDn.postId)) {
                httpMessage.addParam("post_id", this.dDn.postId);
            }
            if (this.dDn.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.dDn.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.dDn.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.dDn.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.dDn.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.dDq) {
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

    public void aPN() {
        if (this.dDs != null && this.dDn != null) {
            int i = 0;
            if (this.dDn.baijiahaoData != null) {
                i = this.dDn.baijiahaoData.oriUgcType;
            }
            if (this.dDs.type == 1) {
                if (StringUtils.isNull(this.dDw)) {
                    an cI = new an("c12003").af("obj_locate", this.dDs.dmX).af("obj_param1", this.dDs.dmY).af("obj_source", this.dDs.dmZ).af("obj_id", this.dDs.dna).af("obj_name", i).cI("post_id", this.dDn.postId);
                    if (this.dqE != null) {
                        cI.cI("tid", this.dqE.getId()).t("fid", this.dqE.getFid()).af("card_type", this.cardType).cI(TiebaInitialize.Params.AB_TAG, this.dqE.mRecomAbTag).cI("recom_source", this.dqE.mRecomSource).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, this.dqE.mRecomWeight).cI("extra", this.dqE.mRecomExtra);
                        if (this.dqE.getBaijiahaoData() != null) {
                            cI.cI("obj_param4", this.dqE.getBaijiahaoData().oriUgcNid);
                            if (this.dqE.aJs() || this.dqE.aMx()) {
                                cI.cI("obj_param6", this.dqE.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.dqE.aMv()) {
                            cI.af("obj_param5", 2);
                        } else if (this.dqE.aJr() || this.dqE.aJs()) {
                            cI.af("obj_param5", 3);
                        } else if (this.dqE.threadType == 0 || this.dqE.threadType == 40) {
                            cI.af("obj_param5", 1);
                        }
                    }
                    if (ld(this.dDs.dmX) && le(this.dDs.dnb) != -1) {
                        cI.af(TiebaInitialize.Params.OBJ_TO, le(this.dDs.dnb));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        cI.cI("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        cI.af("resource_id", this.dDt);
                    } else if (this.mFrom == 18) {
                        cI.cI("obj_tab", "a099");
                        cI.cI("resource_id", this.mTabName);
                    } else {
                        cI.af("resource_id", this.dDt);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cI);
                    }
                    TiebaStatic.log(cI);
                    return;
                }
                TiebaStatic.log(new an("c13358").cI("tid", this.dDn.threadId).cI("topic_id", this.dDw));
            } else if (this.dDs.type == 2) {
                an cI2 = new an("c13271").af("obj_type", this.dDs.dnc).af("obj_locate", this.dDs.dnd).af(TiebaInitialize.Params.OBJ_PARAM2, this.dDt).af("obj_id", this.dDs.dne).af("obj_name", i).cI("post_id", this.dDn.postId);
                if (this.dqE != null) {
                    cI2.cI("tid", this.dqE.getId()).t("fid", this.dqE.getFid()).af("card_type", this.cardType).cI(TiebaInitialize.Params.AB_TAG, this.dqE.mRecomAbTag).cI("recom_source", this.dqE.mRecomSource).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, this.dqE.mRecomWeight).cI("extra", this.dqE.mRecomExtra);
                    if (this.dqE.getBaijiahaoData() != null) {
                        cI2.cI("obj_param4", this.dqE.getBaijiahaoData().oriUgcNid);
                        if (this.dqE.aJs() || this.dqE.aMx()) {
                            cI2.cI("obj_param6", this.dqE.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.dqE.aMv()) {
                        cI2.af("obj_param5", 2);
                    } else if (this.dqE.aJr() || this.dqE.aJs()) {
                        cI2.af("obj_param5", 3);
                    } else if (this.dqE.threadType == 0 || this.dqE.threadType == 40) {
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
        if (this.dDp == null) {
            this.dDp = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.dDp.setDuration(200L);
        }
        return this.dDp;
    }

    public void onChangeSkinType(int i) {
        if (this.dDn != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.dDq) {
                am.b(this.dDj, this.dDu);
                am.b(this.dDl, this.dDv);
            } else {
                am.a(this.dDj, this.dDu);
                am.a(this.dDl, this.dDv);
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
        this.dDs = dVar;
    }

    public void setGameId(int i) {
        this.dDt = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.dDl.setVisibility(z ? 8 : 0);
        this.dDm.setVisibility(z ? 8 : 0);
        if (z && this.dDx != null) {
            this.dDx.setVisibility(8);
        }
    }

    public void setThreadData(bj bjVar) {
        this.dqE = bjVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afV = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
