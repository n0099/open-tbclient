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
    private bj cRe;
    private int cardType;
    private TBLottieAnimationView dde;
    private TextView ddf;
    private TBLottieAnimationView ddg;
    private TextView ddh;
    private AgreeData ddi;
    private com.baidu.tieba.tbadkCore.data.e ddj;
    private ScaleAnimation ddk;
    private boolean ddl;
    private boolean ddm;
    private com.baidu.tbadk.core.data.d ddn;
    private int ddo;
    private int ddp;
    private int ddq;
    private String ddr;
    private View dds;
    private CustomMessageListener ddt;
    private CustomMessageListener ddv;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.ddi != null) {
            this.ddi.agreeType = agreeData.agreeType;
            this.ddi.hasAgree = agreeData.hasAgree;
            this.ddi.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ddp = R.raw.lottie_agree;
        this.ddq = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddi != null && agreeData != null && AgreeView.this.ddj != null && !AgreeView.this.ddi.isInPost && AgreeView.this.ddj.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddi.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddi.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddi.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddi != null && !TextUtils.isEmpty(AgreeView.this.ddi.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddi.postId.equals(agreeData.postId) && !AgreeView.this.ddi.isInThread) {
                        if (AgreeView.this.ddl) {
                            if (AgreeView.this.ddi.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddj.uniqueId == eVar.uniqueId) {
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
        this.ddp = R.raw.lottie_agree;
        this.ddq = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddi != null && agreeData != null && AgreeView.this.ddj != null && !AgreeView.this.ddi.isInPost && AgreeView.this.ddj.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddi.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddi.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddi.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddi != null && !TextUtils.isEmpty(AgreeView.this.ddi.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddi.postId.equals(agreeData.postId) && !AgreeView.this.ddi.isInThread) {
                        if (AgreeView.this.ddl) {
                            if (AgreeView.this.ddi.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddj.uniqueId == eVar.uniqueId) {
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
        this.ddp = R.raw.lottie_agree;
        this.ddq = R.raw.lottie_disagree;
        this.cardType = 1;
        this.ddt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddi != null && agreeData != null && AgreeView.this.ddj != null && !AgreeView.this.ddi.isInPost && AgreeView.this.ddj.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ddi.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ddi.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ddi.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.ddv = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ddi != null && !TextUtils.isEmpty(AgreeView.this.ddi.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ddi.postId.equals(agreeData.postId) && !AgreeView.this.ddi.isInThread) {
                        if (AgreeView.this.ddl) {
                            if (AgreeView.this.ddi.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ddj.uniqueId == eVar.uniqueId) {
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
        this.dde = new TBLottieAnimationView(context);
        this.dde.setId(R.id.img_agree);
        this.dde.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dde.setOnClickListener(this.mOnClickListener);
        this.dde.addAnimatorListener(this);
        this.ddf = new TextView(context);
        this.ddf.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ddf.setOnClickListener(this.mOnClickListener);
        this.ddg = new TBLottieAnimationView(context);
        this.ddg.setId(R.id.img_disagree);
        this.ddg.addAnimatorListener(this);
        this.ddg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ddg.setOnClickListener(this.mOnClickListener);
        this.ddh = new TextView(context);
        this.ddh.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ddh.setOnClickListener(this.mOnClickListener);
        this.ddj = new com.baidu.tieba.tbadkCore.data.e();
        this.ddj.uniqueId = getPageId();
        aHm();
        setAgreeAnimationResource();
    }

    private void aHm() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        addView(this.dde, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        addView(this.ddf, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        layoutParams3.gravity = 16;
        addView(this.ddg, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.ddh.setText(R.string.c_disagree);
        addView(this.ddh, layoutParams2);
    }

    public void aHn() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.dde.setLayoutParams(layoutParams);
        this.ddf.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ddf.setLayoutParams(layoutParams2);
        this.ddg.setVisibility(8);
        this.ddh.setVisibility(8);
    }

    public void aHo() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.dde.setLayoutParams(layoutParams);
        this.ddf.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i;
        this.ddf.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        layoutParams3.gravity = 16;
        this.ddg.setLayoutParams(layoutParams3);
        this.ddh.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = i;
        this.ddh.setLayoutParams(layoutParams4);
    }

    public void aHp() {
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
        linearLayout.addView(this.dde, new LinearLayout.LayoutParams(dimens, dimens));
        this.ddf.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.ddf, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.dds = linearLayout2;
        linearLayout2.addView(this.ddg, new LinearLayout.LayoutParams(dimens, dimens));
        this.ddh.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.ddh, layoutParams4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddt);
        MessageManager.getInstance().registerListener(this.ddv);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ddt);
        MessageManager.getInstance().unRegisterListener(this.ddv);
    }

    public void setTopicId(String str) {
        this.ddr = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.ddl = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.ddm = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.dde;
    }

    public TextView getAgreeNumView() {
        return this.ddf;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.ddg;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.ddi = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.ddi;
    }

    public void setAgreeAnimationResource() {
        if (this.ddl) {
            am.b(this.dde, this.ddp);
            am.b(this.ddg, this.ddq);
            return;
        }
        am.a(this.dde, this.ddp);
        am.a(this.ddg, this.ddq);
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
        this.ddf.setText(b(this.ddi));
        if (this.ddi.hasAgree) {
            if (this.ddi.agreeType == 2) {
                this.ddg.setProgress(0.0f);
                this.dde.setProgress(1.0f);
                this.ddf.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.ddh);
                return;
            }
            this.dde.setProgress(0.0f);
            this.ddg.setProgress(1.0f);
            setTextNormalColor(this.ddf);
            this.ddh.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.dde.setProgress(0.0f);
        this.ddg.setProgress(0.0f);
        setTextNormalColor(this.ddf);
        setTextNormalColor(this.ddh);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.ddm) {
            textView.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.ddl) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    public void fN(boolean z) {
        this.dde.setMinAndMaxProgress(0.0f, 1.0f);
        this.ddg.setMinAndMaxProgress(0.0f, 1.0f);
        this.ddf.setText(b(this.ddi));
        this.dde.clearColorFilter();
        this.ddg.clearColorFilter();
        if (z) {
            this.dde.playAnimation();
            this.ddg.cancelAnimation();
            this.ddg.setFrame(0);
        } else {
            this.ddg.playAnimation();
            this.dde.cancelAnimation();
            this.dde.setFrame(0);
        }
        if (this.ddi.hasAgree) {
            if (this.ddi.agreeType == 2) {
                this.ddf.setTextColor(am.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.ddh);
                return;
            }
            setTextNormalColor(this.ddf);
            this.ddh.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.ddf);
        setTextNormalColor(this.ddh);
    }

    public void aHq() {
        aR(this.dde);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(View view) {
        int i = 0;
        int i2 = 1;
        if (this.ddi != null) {
            if (!this.ddl || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if ((this.ddl || bc.checkUpIsLogin(getContext())) && view != this.ddf) {
                    if (view.getId() == this.dde.getId()) {
                        this.dde.cancelAnimation();
                        if (this.ddn != null) {
                            this.ddn.type = 1;
                        }
                        if (this.ddi.hasAgree) {
                            if (this.ddi.agreeType == 2) {
                                this.ddi.agreeType = 2;
                                this.ddi.hasAgree = false;
                                this.ddi.agreeNum--;
                                updateUI();
                                if (this.ddn != null) {
                                    this.ddn.cND = 1;
                                }
                            } else {
                                this.ddi.agreeType = 2;
                                this.ddi.hasAgree = true;
                                this.ddi.agreeNum++;
                                fN(true);
                                com.baidu.tieba.o.a.cBY().B(getTbPageContext());
                                if (this.ddn != null) {
                                    this.ddn.cND = 0;
                                    i2 = 0;
                                }
                            }
                            kS(i2);
                        } else {
                            this.ddi.agreeType = 2;
                            this.ddi.hasAgree = true;
                            this.ddi.agreeNum++;
                            fN(true);
                            com.baidu.tieba.o.a.cBY().B(getTbPageContext());
                            if (this.ddn != null) {
                                this.ddn.cND = 0;
                            }
                        }
                        i2 = 0;
                        kS(i2);
                    } else if (view.getId() == this.ddg.getId()) {
                        this.ddg.cancelAnimation();
                        if (this.ddn != null) {
                            this.ddn.type = 2;
                        }
                        if (this.ddi.hasAgree) {
                            if (this.ddi.agreeType == 5) {
                                this.ddi.agreeType = 5;
                                this.ddi.hasAgree = false;
                                updateUI();
                                if (this.ddn != null) {
                                    this.ddn.cNH = 0;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.ddi.agreeType = 5;
                                this.ddi.hasAgree = true;
                                this.ddi.agreeNum--;
                                fN(false);
                                if (this.ddn != null) {
                                    this.ddn.cNH = 1;
                                }
                            }
                        } else {
                            this.ddi.agreeType = 5;
                            this.ddi.hasAgree = true;
                            fN(false);
                            if (this.ddn != null) {
                                this.ddn.cNH = 1;
                            }
                        }
                        kS(i);
                    }
                    this.ddj.agreeData = this.ddi;
                    if (this.ddi.isInThread) {
                        if (this.ddi.baijiahaoData != null) {
                            this.ddi.nid = this.ddi.baijiahaoData.oriUgcNid;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.ddj));
                        a(this.ddi, AgreeEvent.IS_THREAD);
                    } else if (this.ddi.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.ddj));
                        a(this.ddi, AgreeEvent.IS_POST);
                    }
                    if (this.Nh != null) {
                        this.Nh.onClick(view);
                    }
                    aHr();
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
        if (this.ddi != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.ddi.threadId);
            httpMessage.addParam("op_type", i);
            if (this.ddi.objType == 0) {
                this.ddi.objType = 3;
            }
            httpMessage.addParam("obj_type", this.ddi.objType);
            httpMessage.addParam("agree_type", this.ddi.agreeType);
            httpMessage.addParam("forum_id", this.ddi.forumId);
            if (!TextUtils.isEmpty(this.ddi.postId)) {
                httpMessage.addParam("post_id", this.ddi.postId);
            }
            if (this.ddi.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", this.ddi.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.ddi.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.ddi.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", this.ddi.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.ddl) {
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

    public void aHr() {
        if (this.ddn != null && this.ddi != null) {
            int i = 0;
            if (this.ddi.baijiahaoData != null) {
                i = this.ddi.baijiahaoData.oriUgcType;
            }
            if (this.ddn.type == 1) {
                if (StringUtils.isNull(this.ddr)) {
                    an cy = new an("c12003").X("obj_locate", this.ddn.cNA).X("obj_param1", this.ddn.cNB).X("obj_source", this.ddn.cNC).X("resource_id", this.ddo).X("obj_id", this.ddn.cND).X("obj_name", i).cy("post_id", this.ddi.postId);
                    if (this.cRe != null) {
                        cy.cy("tid", this.cRe.getId()).s("fid", this.cRe.getFid()).X("card_type", this.cardType).cy(TiebaInitialize.Params.AB_TAG, this.cRe.mRecomAbTag).cy("recom_source", this.cRe.mRecomSource).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cRe.mRecomWeight).cy("extra", this.cRe.mRecomExtra);
                        if (this.cRe.getBaijiahaoData() != null) {
                            cy.cy("obj_param4", this.cRe.getBaijiahaoData().oriUgcNid);
                            if (this.cRe.aBc() || this.cRe.aEf()) {
                                cy.cy("obj_param6", this.cRe.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.cRe.aEd()) {
                            cy.X("obj_param5", 2);
                        } else if (this.cRe.aBb() || this.cRe.aBc()) {
                            cy.X("obj_param5", 3);
                        } else if (this.cRe.threadType == 0 || this.cRe.threadType == 40) {
                            cy.X("obj_param5", 1);
                        }
                    }
                    if (kT(this.ddn.cNA) && kU(this.ddn.cNE) != -1) {
                        cy.X(TiebaInitialize.Params.OBJ_TO, kU(this.ddn.cNE));
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
                TiebaStatic.log(new an("c13358").cy("tid", this.ddi.threadId).cy("topic_id", this.ddr));
            } else if (this.ddn.type == 2) {
                an cy2 = new an("c13271").X("obj_type", this.ddn.cNF).X("obj_locate", this.ddn.cNG).X(TiebaInitialize.Params.OBJ_PARAM2, this.ddo).X("obj_id", this.ddn.cNH).X("obj_name", i).cy("post_id", this.ddi.postId);
                if (this.cRe != null) {
                    cy2.cy("tid", this.cRe.getId()).s("fid", this.cRe.getFid()).X("card_type", this.cardType).cy(TiebaInitialize.Params.AB_TAG, this.cRe.mRecomAbTag).cy("recom_source", this.cRe.mRecomSource).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, this.cRe.mRecomWeight).cy("extra", this.cRe.mRecomExtra);
                    if (this.cRe.getBaijiahaoData() != null) {
                        cy2.cy("obj_param4", this.cRe.getBaijiahaoData().oriUgcNid);
                        if (this.cRe.aBc() || this.cRe.aEf()) {
                            cy2.cy("obj_param6", this.cRe.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.cRe.aEd()) {
                        cy2.X("obj_param5", 2);
                    } else if (this.cRe.aBb() || this.cRe.aBc()) {
                        cy2.X("obj_param5", 3);
                    } else if (this.cRe.threadType == 0 || this.cRe.threadType == 40) {
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
        if (this.ddk == null) {
            this.ddk = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.ddk.setDuration(200L);
        }
        return this.ddk;
    }

    public void onChangeSkinType(int i) {
        if (this.ddi != null && this.mSkinType != i) {
            this.mSkinType = i;
            if (this.ddl) {
                am.b(this.dde, this.ddp);
                am.b(this.ddg, this.ddq);
            } else {
                am.a(this.dde, this.ddp);
                am.a(this.ddg, this.ddq);
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
        this.ddn = dVar;
    }

    public void setGameId(int i) {
        this.ddo = i;
    }

    public void setAgreeAlone(boolean z) {
        this.ddg.setVisibility(z ? 8 : 0);
        this.ddh.setVisibility(z ? 8 : 0);
        if (z && this.dds != null) {
            this.dds.setVisibility(8);
        }
    }

    public void setThreadData(bj bjVar) {
        this.cRe = bjVar;
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
