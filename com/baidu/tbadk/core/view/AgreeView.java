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
    private bj cRf;
    private int cardType;
    private TBLottieAnimationView ddf;
    private TextView ddg;
    private TBLottieAnimationView ddh;
    private TextView ddi;
    private AgreeData ddj;
    private com.baidu.tieba.tbadkCore.data.e ddk;
    private ScaleAnimation ddl;
    private boolean ddm;
    private boolean ddn;
    private com.baidu.tbadk.core.data.d ddo;
    private int ddp;
    private int ddq;
    private int ddr;
    private String dds;
    private View ddt;
    private CustomMessageListener ddv;
    private CustomMessageListener ddw;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.ddj != null) {
            this.ddj.agreeType = agreeData.agreeType;
            this.ddj.hasAgree = agreeData.hasAgree;
            this.ddj.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ddq = R.raw.lottie_agree;
        this.ddr = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddv = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddj != null && agreeData != null && AgreeView.this.ddk != null && !AgreeView.this.ddj.isInPost && AgreeView.this.ddk.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddj.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddj.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddj.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddw = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddj != null && !TextUtils.isEmpty(AgreeView.this.ddj.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddj.postId.equals(agreeData.postId) && !AgreeView.this.ddj.isInThread) {
                        if (AgreeView.this.ddm) {
                            if (AgreeView.this.ddj.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddk.uniqueId == eVar.uniqueId) {
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
        this.ddq = R.raw.lottie_agree;
        this.ddr = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddv = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddj != null && agreeData != null && AgreeView.this.ddk != null && !AgreeView.this.ddj.isInPost && AgreeView.this.ddk.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddj.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddj.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddj.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddw = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddj != null && !TextUtils.isEmpty(AgreeView.this.ddj.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddj.postId.equals(agreeData.postId) && !AgreeView.this.ddj.isInThread) {
                        if (AgreeView.this.ddm) {
                            if (AgreeView.this.ddj.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddk.uniqueId == eVar.uniqueId) {
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
        this.ddq = R.raw.lottie_agree;
        this.ddr = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddv = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddj != null && agreeData != null && AgreeView.this.ddk != null && !AgreeView.this.ddj.isInPost && AgreeView.this.ddk.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddj.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddj.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddj.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddw = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddj != null && !TextUtils.isEmpty(AgreeView.this.ddj.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddj.postId.equals(agreeData.postId) && !AgreeView.this.ddj.isInThread) {
                        if (AgreeView.this.ddm) {
                            if (AgreeView.this.ddj.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddk.uniqueId == eVar.uniqueId) {
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
        this.ddf = new TBLottieAnimationView(context);
        this.ddf.setId(R.id.img_agree);
        this.ddf.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ddf.setOnClickListener(this.mOnClickListener);
        this.ddf.addAnimatorListener(this);
        this.ddg = new TextView(context);
        this.ddg.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ddg.setOnClickListener(this.mOnClickListener);
        this.ddh = new TBLottieAnimationView(context);
        this.ddh.setId(R.id.img_disagree);
        this.ddh.addAnimatorListener(this);
        this.ddh.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ddh.setOnClickListener(this.mOnClickListener);
        this.ddi = new TextView(context);
        this.ddi.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ddi.setOnClickListener(this.mOnClickListener);
        this.ddk = new com.baidu.tieba.tbadkCore.data.e();
        this.ddk.uniqueId = getPageId();
        aHo();
        setAgreeAnimationResource();
    }

    private void aHo() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        addView(this.ddf, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        addView(this.ddg, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        layoutParams3.gravity = 16;
        addView(this.ddh, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.ddi.setText(R.string.c_disagree);
        addView(this.ddi, layoutParams2);
    }

    public void aHp() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ddf.setLayoutParams(layoutParams);
        this.ddg.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ddg.setLayoutParams(layoutParams2);
        this.ddh.setVisibility(8);
        this.ddi.setVisibility(8);
    }

    public void aHq() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.ddf.setLayoutParams(layoutParams);
        this.ddg.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        this.ddg.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        layoutParams3.gravity = 16;
        this.ddh.setLayoutParams(layoutParams3);
        this.ddi.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.ddi.setLayoutParams(layoutParams4);
    }

    public void aHr() {
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
        linearLayout.addView(this.ddf, new LinearLayout.LayoutParams(dimens, dimens));
        this.ddg.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.ddg, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.ddt = linearLayout2;
        linearLayout2.addView(this.ddh, new LinearLayout.LayoutParams(dimens, dimens));
        this.ddi.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.ddi, layoutParams4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddv);
        MessageManager.getInstance().registerListener(this.ddw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ddv);
        MessageManager.getInstance().unRegisterListener(this.ddw);
    }

    public void setTopicId(String str) {
        this.dds = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.ddm = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.ddn = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.ddf;
    }

    public TextView getAgreeNumView() {
        return this.ddg;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.ddh;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.ddj = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.ddj;
    }

    public void setAgreeAnimationResource() {
        if (this.ddm) {
            am.b(this.ddf, this.ddq);
            am.b(this.ddh, this.ddr);
            return;
        }
        am.a(this.ddf, this.ddq);
        am.a(this.ddh, this.ddr);
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
        this.ddg.setText(b(this.ddj));
        if (this.ddj.hasAgree) {
            if (this.ddj.agreeType == 2) {
                this.ddh.setProgress(0.0f);
                this.ddf.setProgress(1.0f);
                this.ddg.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.ddi);
                return;
            }
            this.ddf.setProgress(0.0f);
            this.ddh.setProgress(1.0f);
            setTextNormalColor(this.ddg);
            this.ddi.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.ddf.setProgress(0.0f);
        this.ddh.setProgress(0.0f);
        setTextNormalColor(this.ddg);
        setTextNormalColor(this.ddi);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.ddn) {
            textView.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.ddm) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void fN(boolean z) {
        this.ddf.setMinAndMaxProgress(0.0f, 1.0f);
        this.ddh.setMinAndMaxProgress(0.0f, 1.0f);
        this.ddg.setText(b(this.ddj));
        this.ddf.clearColorFilter();
        this.ddh.clearColorFilter();
        if (z) {
            this.ddf.playAnimation();
            this.ddh.cancelAnimation();
            this.ddh.setFrame(0);
        } else {
            this.ddh.playAnimation();
            this.ddf.cancelAnimation();
            this.ddf.setFrame(0);
        }
        if (this.ddj.hasAgree) {
            if (this.ddj.agreeType == 2) {
                this.ddg.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.ddi);
                return;
            }
            setTextNormalColor(this.ddg);
            this.ddi.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.ddg);
        setTextNormalColor(this.ddi);
    }

    public void aHs() {
        aR(this.ddf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        int i = 0;
        int i2 = 1;
        if (this.ddj != null) {
            if (!this.ddm || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.ddm || bc.checkUpIsLogin(getContext())) && view != this.ddg) {
                    if (view.getId() == this.ddf.getId()) {
                        this.ddf.cancelAnimation();
                        if (this.ddo != null) {
                            this.ddo.type = 1;
                        }
                        if (this.ddj.hasAgree) {
                            if (this.ddj.agreeType == 2) {
                                this.ddj.agreeType = 2;
                                this.ddj.hasAgree = false;
                                this.ddj.agreeNum--;
                                updateUI();
                                if (this.ddo != null) {
                                    this.ddo.cNE = 1;
                                }
                            } else {
                                this.ddj.agreeType = 2;
                                this.ddj.hasAgree = true;
                                this.ddj.agreeNum++;
                                fN(true);
                                com.baidu.tieba.o.a.cCa().B(getTbPageContext());
                                if (this.ddo != null) {
                                    this.ddo.cNE = 0;
                                    i2 = 0;
                                }
                            }
                            kS(i2);
                        } else {
                            this.ddj.agreeType = 2;
                            this.ddj.hasAgree = true;
                            this.ddj.agreeNum++;
                            fN(true);
                            com.baidu.tieba.o.a.cCa().B(getTbPageContext());
                            if (this.ddo != null) {
                                this.ddo.cNE = 0;
                            }
                        }
                        i2 = 0;
                        kS(i2);
                    } else if (view.getId() == this.ddh.getId()) {
                        this.ddh.cancelAnimation();
                        if (this.ddo != null) {
                            this.ddo.type = 2;
                        }
                        if (this.ddj.hasAgree) {
                            if (this.ddj.agreeType == 5) {
                                this.ddj.agreeType = 5;
                                this.ddj.hasAgree = false;
                                updateUI();
                                if (this.ddo != null) {
                                    this.ddo.cNI = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.ddj.agreeType = 5;
                                this.ddj.hasAgree = true;
                                this.ddj.agreeNum--;
                                fN(false);
                                if (this.ddo != null) {
                                    this.ddo.cNI = 1;
                                }
                            }
                        } else {
                            this.ddj.agreeType = 5;
                            this.ddj.hasAgree = true;
                            fN(false);
                            if (this.ddo != null) {
                                this.ddo.cNI = 1;
                            }
                        }
                        kS(i);
                    }
                    this.ddk.agreeData = this.ddj;
                    if (this.ddj.isInThread) {
                        if (this.ddj.baijiahaoData != null) {
                            this.ddj.nid = this.ddj.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.ddk));
                        a(this.ddj, AgreeEvent.IS_THREAD);
                    } else if (this.ddj.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.ddk));
                        a(this.ddj, AgreeEvent.IS_POST);
                    }
                    if (this.Nh != null) {
                        this.Nh.onClick(view);
                    }
                    aHt();
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
        if (this.ddj != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.ddj.threadId);
            httpMessage.addParam("op_type", i);
            if (this.ddj.objType == 0) {
                this.ddj.objType = 3;
            }
            httpMessage.addParam("obj_type", this.ddj.objType);
            httpMessage.addParam("agree_type", this.ddj.agreeType);
            httpMessage.addParam("forum_id", this.ddj.forumId);
            if (!TextUtils.isEmpty(this.ddj.postId)) {
                httpMessage.addParam("post_id", this.ddj.postId);
            }
            if (this.ddj.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.ddj.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.ddj.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.ddj.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.ddj.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.ddm) {
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

    public void aHt() {
        if (this.ddo != null && this.ddj != null) {
            int i = 0;
            if (this.ddj.baijiahaoData != null) {
                i = this.ddj.baijiahaoData.oriUgcType;
            }
            if (this.ddo.type == 1) {
                if (StringUtils.isNull(this.dds)) {
                    an cy = new an("c12003").X("obj_locate", this.ddo.cNB).X("obj_param1", this.ddo.cNC).X("obj_source", this.ddo.cND).X("resource_id", this.ddp).X("obj_id", this.ddo.cNE).X("obj_name", i).cy("post_id", this.ddj.postId);
                    if (this.cRf != null) {
                        cy.cy("tid", this.cRf.getId()).s("fid", this.cRf.getFid()).X("card_type", this.cardType).cy(TiebaInitialize.Params.AB_TAG, this.cRf.mRecomAbTag).cy("recom_source", this.cRf.mRecomSource).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cRf.mRecomWeight).cy("extra", this.cRf.mRecomExtra);
                        if (this.cRf.getBaijiahaoData() != null) {
                            cy.cy("obj_param4", this.cRf.getBaijiahaoData().oriUgcNid);
                            if (this.cRf.aBe() || this.cRf.aEh()) {
                                cy.cy("obj_param6", this.cRf.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.cRf.aEf()) {
                            cy.X("obj_param5", 2);
                        } else if (this.cRf.aBd() || this.cRf.aBe()) {
                            cy.X("obj_param5", 3);
                        } else if (this.cRf.threadType == 0 || this.cRf.threadType == 40) {
                            cy.X("obj_param5", 1);
                        }
                    }
                    if (kT(this.ddo.cNB) && kU(this.ddo.cNF) != -1) {
                        cy.X(TiebaInitialize.Params.OBJ_TO, kU(this.ddo.cNF));
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
                TiebaStatic.log(new an("c13358").cy("tid", this.ddj.threadId).cy("topic_id", this.dds));
            } else if (this.ddo.type == 2) {
                an cy2 = new an("c13271").X("obj_type", this.ddo.cNG).X("obj_locate", this.ddo.cNH).X(TiebaInitialize.Params.OBJ_PARAM2, this.ddp).X("obj_id", this.ddo.cNI).X("obj_name", i).cy("post_id", this.ddj.postId);
                if (this.cRf != null) {
                    cy2.cy("tid", this.cRf.getId()).s("fid", this.cRf.getFid()).X("card_type", this.cardType).cy(TiebaInitialize.Params.AB_TAG, this.cRf.mRecomAbTag).cy("recom_source", this.cRf.mRecomSource).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cRf.mRecomWeight).cy("extra", this.cRf.mRecomExtra);
                    if (this.cRf.getBaijiahaoData() != null) {
                        cy2.cy("obj_param4", this.cRf.getBaijiahaoData().oriUgcNid);
                        if (this.cRf.aBe() || this.cRf.aEh()) {
                            cy2.cy("obj_param6", this.cRf.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.cRf.aEf()) {
                        cy2.X("obj_param5", 2);
                    } else if (this.cRf.aBd() || this.cRf.aBe()) {
                        cy2.X("obj_param5", 3);
                    } else if (this.cRf.threadType == 0 || this.cRf.threadType == 40) {
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
        if (this.ddl == null) {
            this.ddl = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.ddl.setDuration(200L);
        }
        return this.ddl;
    }

    public void onChangeSkinType(int i) {
        if (this.ddj != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.ddm) {
                am.b(this.ddf, this.ddq);
                am.b(this.ddh, this.ddr);
            } else {
                am.a(this.ddf, this.ddq);
                am.a(this.ddh, this.ddr);
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
        this.ddo = dVar;
    }

    public void setGameId(int i) {
        this.ddp = i;
    }

    public void setAgreeAlone(boolean z) {
        this.ddh.setVisibility(z ? 8 : 0);
        this.ddi.setVisibility(z ? 8 : 0);
        if (z && this.ddt != null) {
            this.ddt.setVisibility(8);
        }
    }

    public void setThreadData(bj bjVar) {
        this.cRf = bjVar;
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
