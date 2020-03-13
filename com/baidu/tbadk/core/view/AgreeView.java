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
    private View.OnClickListener Nh;
    private bj cRg;
    private int cardType;
    private boolean ddA;
    private boolean ddB;
    private com.baidu.tbadk.core.data.d ddC;
    private int ddD;
    private int ddE;
    private int ddF;
    private String ddG;
    private View ddH;
    private CustomMessageListener ddI;
    private CustomMessageListener ddJ;
    private TBLottieAnimationView dds;
    private TextView ddt;
    private TBLottieAnimationView ddv;
    private TextView ddw;
    private AgreeData ddx;
    private com.baidu.tieba.tbadkCore.data.e ddy;
    private ScaleAnimation ddz;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.ddx != null) {
            this.ddx.agreeType = agreeData.agreeType;
            this.ddx.hasAgree = agreeData.hasAgree;
            this.ddx.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ddE = R.raw.lottie_agree;
        this.ddF = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddI = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddx != null && agreeData != null && AgreeView.this.ddy != null && !AgreeView.this.ddx.isInPost && AgreeView.this.ddy.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddx.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddx.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddx.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddJ = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddx != null && !TextUtils.isEmpty(AgreeView.this.ddx.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddx.postId.equals(agreeData.postId) && !AgreeView.this.ddx.isInThread) {
                        if (AgreeView.this.ddA) {
                            if (AgreeView.this.ddx.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddy.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aR(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ddE = R.raw.lottie_agree;
        this.ddF = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddI = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddx != null && agreeData != null && AgreeView.this.ddy != null && !AgreeView.this.ddx.isInPost && AgreeView.this.ddy.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddx.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddx.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddx.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddJ = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddx != null && !TextUtils.isEmpty(AgreeView.this.ddx.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddx.postId.equals(agreeData.postId) && !AgreeView.this.ddx.isInThread) {
                        if (AgreeView.this.ddA) {
                            if (AgreeView.this.ddx.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddy.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aR(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ddE = R.raw.lottie_agree;
        this.ddF = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddI = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddx != null && agreeData != null && AgreeView.this.ddy != null && !AgreeView.this.ddx.isInPost && AgreeView.this.ddy.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddx.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddx.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddx.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddJ = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddx != null && !TextUtils.isEmpty(AgreeView.this.ddx.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddx.postId.equals(agreeData.postId) && !AgreeView.this.ddx.isInThread) {
                        if (AgreeView.this.ddA) {
                            if (AgreeView.this.ddx.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddy.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.aR(view);
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.dds = new TBLottieAnimationView(context);
        this.dds.setId(R.id.img_agree);
        this.dds.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dds.setOnClickListener(this.mOnClickListener);
        this.dds.addAnimatorListener(this);
        this.ddt = new TextView(context);
        this.ddt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ddt.setOnClickListener(this.mOnClickListener);
        this.ddv = new TBLottieAnimationView(context);
        this.ddv.setId(R.id.img_disagree);
        this.ddv.addAnimatorListener(this);
        this.ddv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ddv.setOnClickListener(this.mOnClickListener);
        this.ddw = new TextView(context);
        this.ddw.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ddw.setOnClickListener(this.mOnClickListener);
        this.ddy = new com.baidu.tieba.tbadkCore.data.e();
        this.ddy.uniqueId = getPageId();
        aHp();
        setAgreeAnimationResource();
    }

    private void aHp() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        addView(this.dds, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        addView(this.ddt, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        layoutParams3.gravity = 16;
        addView(this.ddv, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.ddw.setText(R.string.c_disagree);
        addView(this.ddw, layoutParams2);
    }

    public void aHq() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dds.setLayoutParams(layoutParams);
        this.ddt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ddt.setLayoutParams(layoutParams2);
        this.ddv.setVisibility(8);
        this.ddw.setVisibility(8);
    }

    public void aHr() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.dds.setLayoutParams(layoutParams);
        this.ddt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        this.ddt.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        layoutParams3.gravity = 16;
        this.ddv.setLayoutParams(layoutParams3);
        this.ddw.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.ddw.setLayoutParams(layoutParams4);
    }

    public void aHs() {
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
        linearLayout.addView(this.dds, new LinearLayout.LayoutParams(dimens, dimens));
        this.ddt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.ddt, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.ddH = linearLayout2;
        linearLayout2.addView(this.ddv, new LinearLayout.LayoutParams(dimens, dimens));
        this.ddw.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.ddw, layoutParams4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddI);
        MessageManager.getInstance().registerListener(this.ddJ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ddI);
        MessageManager.getInstance().unRegisterListener(this.ddJ);
    }

    public void setTopicId(String str) {
        this.ddG = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.ddA = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.ddB = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.dds;
    }

    public TextView getAgreeNumView() {
        return this.ddt;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.ddv;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.ddx = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.ddx;
    }

    public void setAgreeAnimationResource() {
        if (this.ddA) {
            am.b(this.dds, this.ddE);
            am.b(this.ddv, this.ddF);
            return;
        }
        am.a(this.dds, this.ddE);
        am.a(this.ddv, this.ddF);
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
        this.ddt.setText(b(this.ddx));
        if (this.ddx.hasAgree) {
            if (this.ddx.agreeType == 2) {
                this.ddv.setProgress(0.0f);
                this.dds.setProgress(1.0f);
                this.ddt.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.ddw);
                return;
            }
            this.dds.setProgress(0.0f);
            this.ddv.setProgress(1.0f);
            setTextNormalColor(this.ddt);
            this.ddw.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.dds.setProgress(0.0f);
        this.ddv.setProgress(0.0f);
        setTextNormalColor(this.ddt);
        setTextNormalColor(this.ddw);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.ddB) {
            textView.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.ddA) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void fN(boolean z) {
        this.dds.setMinAndMaxProgress(0.0f, 1.0f);
        this.ddv.setMinAndMaxProgress(0.0f, 1.0f);
        this.ddt.setText(b(this.ddx));
        this.dds.clearColorFilter();
        this.ddv.clearColorFilter();
        if (z) {
            this.dds.playAnimation();
            this.ddv.cancelAnimation();
            this.ddv.setFrame(0);
        } else {
            this.ddv.playAnimation();
            this.dds.cancelAnimation();
            this.dds.setFrame(0);
        }
        if (this.ddx.hasAgree) {
            if (this.ddx.agreeType == 2) {
                this.ddt.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.ddw);
                return;
            }
            setTextNormalColor(this.ddt);
            this.ddw.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.ddt);
        setTextNormalColor(this.ddw);
    }

    public void aHt() {
        aR(this.dds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        int i = 0;
        int i2 = 1;
        if (this.ddx != null) {
            if (!this.ddA || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.ddA || bc.checkUpIsLogin(getContext())) && view != this.ddt) {
                    if (view.getId() == this.dds.getId()) {
                        this.dds.cancelAnimation();
                        if (this.ddC != null) {
                            this.ddC.type = 1;
                        }
                        if (this.ddx.hasAgree) {
                            if (this.ddx.agreeType == 2) {
                                this.ddx.agreeType = 2;
                                this.ddx.hasAgree = false;
                                this.ddx.agreeNum--;
                                updateUI();
                                if (this.ddC != null) {
                                    this.ddC.cNF = 1;
                                }
                            } else {
                                this.ddx.agreeType = 2;
                                this.ddx.hasAgree = true;
                                this.ddx.agreeNum++;
                                fN(true);
                                com.baidu.tieba.o.a.cCb().B(getTbPageContext());
                                if (this.ddC != null) {
                                    this.ddC.cNF = 0;
                                    i2 = 0;
                                }
                            }
                            kS(i2);
                        } else {
                            this.ddx.agreeType = 2;
                            this.ddx.hasAgree = true;
                            this.ddx.agreeNum++;
                            fN(true);
                            com.baidu.tieba.o.a.cCb().B(getTbPageContext());
                            if (this.ddC != null) {
                                this.ddC.cNF = 0;
                            }
                        }
                        i2 = 0;
                        kS(i2);
                    } else if (view.getId() == this.ddv.getId()) {
                        this.ddv.cancelAnimation();
                        if (this.ddC != null) {
                            this.ddC.type = 2;
                        }
                        if (this.ddx.hasAgree) {
                            if (this.ddx.agreeType == 5) {
                                this.ddx.agreeType = 5;
                                this.ddx.hasAgree = false;
                                updateUI();
                                if (this.ddC != null) {
                                    this.ddC.cNJ = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.ddx.agreeType = 5;
                                this.ddx.hasAgree = true;
                                this.ddx.agreeNum--;
                                fN(false);
                                if (this.ddC != null) {
                                    this.ddC.cNJ = 1;
                                }
                            }
                        } else {
                            this.ddx.agreeType = 5;
                            this.ddx.hasAgree = true;
                            fN(false);
                            if (this.ddC != null) {
                                this.ddC.cNJ = 1;
                            }
                        }
                        kS(i);
                    }
                    this.ddy.agreeData = this.ddx;
                    if (this.ddx.isInThread) {
                        if (this.ddx.baijiahaoData != null) {
                            this.ddx.nid = this.ddx.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.ddy));
                        a(this.ddx, AgreeEvent.IS_THREAD);
                    } else if (this.ddx.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.ddy));
                        a(this.ddx, AgreeEvent.IS_POST);
                    }
                    if (this.Nh != null) {
                        this.Nh.onClick(view);
                    }
                    aHu();
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

    public void kS(int i) {
        if (this.ddx != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.ddx.threadId);
            httpMessage.addParam("op_type", i);
            if (this.ddx.objType == 0) {
                this.ddx.objType = 3;
            }
            httpMessage.addParam("obj_type", this.ddx.objType);
            httpMessage.addParam("agree_type", this.ddx.agreeType);
            httpMessage.addParam("forum_id", this.ddx.forumId);
            if (!TextUtils.isEmpty(this.ddx.postId)) {
                httpMessage.addParam("post_id", this.ddx.postId);
            }
            if (this.ddx.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.ddx.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.ddx.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.ddx.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.ddx.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.ddA) {
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

    public void aHu() {
        if (this.ddC != null && this.ddx != null) {
            int i = 0;
            if (this.ddx.baijiahaoData != null) {
                i = this.ddx.baijiahaoData.oriUgcType;
            }
            if (this.ddC.type == 1) {
                if (StringUtils.isNull(this.ddG)) {
                    an cy = new an("c12003").X("obj_locate", this.ddC.cNC).X("obj_param1", this.ddC.cND).X("obj_source", this.ddC.cNE).X("resource_id", this.ddD).X("obj_id", this.ddC.cNF).X("obj_name", i).cy("post_id", this.ddx.postId);
                    if (this.cRg != null) {
                        cy.cy("tid", this.cRg.getId()).s("fid", this.cRg.getFid()).X("card_type", this.cardType).cy(TiebaInitialize.Params.AB_TAG, this.cRg.mRecomAbTag).cy("recom_source", this.cRg.mRecomSource).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cRg.mRecomWeight).cy("extra", this.cRg.mRecomExtra);
                        if (this.cRg.getBaijiahaoData() != null) {
                            cy.cy("obj_param4", this.cRg.getBaijiahaoData().oriUgcNid);
                            if (this.cRg.aBe() || this.cRg.aEh()) {
                                cy.cy("obj_param6", this.cRg.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.cRg.aEf()) {
                            cy.X("obj_param5", 2);
                        } else if (this.cRg.aBd() || this.cRg.aBe()) {
                            cy.X("obj_param5", 3);
                        } else if (this.cRg.threadType == 0 || this.cRg.threadType == 40) {
                            cy.X("obj_param5", 1);
                        }
                    }
                    if (kT(this.ddC.cNC) && kU(this.ddC.cNG) != -1) {
                        cy.X(TiebaInitialize.Params.OBJ_TO, kU(this.ddC.cNG));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        cy.cy("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cy);
                    }
                    TiebaStatic.log(cy);
                    return;
                }
                TiebaStatic.log(new an("c13358").cy("tid", this.ddx.threadId).cy("topic_id", this.ddG));
            } else if (this.ddC.type == 2) {
                an cy2 = new an("c13271").X("obj_type", this.ddC.cNH).X("obj_locate", this.ddC.cNI).X(TiebaInitialize.Params.OBJ_PARAM2, this.ddD).X("obj_id", this.ddC.cNJ).X("obj_name", i).cy("post_id", this.ddx.postId);
                if (this.cRg != null) {
                    cy2.cy("tid", this.cRg.getId()).s("fid", this.cRg.getFid()).X("card_type", this.cardType).cy(TiebaInitialize.Params.AB_TAG, this.cRg.mRecomAbTag).cy("recom_source", this.cRg.mRecomSource).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cRg.mRecomWeight).cy("extra", this.cRg.mRecomExtra);
                    if (this.cRg.getBaijiahaoData() != null) {
                        cy2.cy("obj_param4", this.cRg.getBaijiahaoData().oriUgcNid);
                        if (this.cRg.aBe() || this.cRg.aEh()) {
                            cy2.cy("obj_param6", this.cRg.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.cRg.aEf()) {
                        cy2.X("obj_param5", 2);
                    } else if (this.cRg.aBd() || this.cRg.aBe()) {
                        cy2.X("obj_param5", 3);
                    } else if (this.cRg.threadType == 0 || this.cRg.threadType == 40) {
                        cy2.X("obj_param5", 1);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    cy2.cy("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), cy2);
                }
                TiebaStatic.log(cy2);
            }
        }
    }

    public static boolean kT(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int kU(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.ddz == null) {
            this.ddz = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.ddz.setDuration(200L);
        }
        return this.ddz;
    }

    public void onChangeSkinType(int i) {
        if (this.ddx != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.ddA) {
                am.b(this.dds, this.ddE);
                am.b(this.ddv, this.ddF);
            } else {
                am.a(this.dds, this.ddE);
                am.a(this.ddv, this.ddF);
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
        this.ddC = dVar;
    }

    public void setGameId(int i) {
        this.ddD = i;
    }

    public void setAgreeAlone(boolean z) {
        this.ddv.setVisibility(z ? 8 : 0);
        this.ddw.setVisibility(z ? 8 : 0);
        if (z && this.ddH != null) {
            this.ddH.setVisibility(8);
        }
    }

    public void setThreadData(bj bjVar) {
        this.cRg = bjVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
