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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes21.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener akt;
    private int cardType;
    private by eCR;
    private TBLottieAnimationView eXc;
    private TextView eXd;
    private TBLottieAnimationView eXe;
    private TextView eXf;
    private AgreeData eXg;
    private com.baidu.tieba.tbadkCore.data.e eXh;
    private ScaleAnimation eXi;
    private boolean eXj;
    private boolean eXk;
    private com.baidu.tbadk.core.data.d eXl;
    private int eXm;
    private int eXn;
    private int eXo;
    private int eXp;
    private String eXq;
    public View.OnClickListener eXr;
    private LinearLayout eXs;
    private LinearLayout eXt;
    private boolean eXu;
    private boolean eXv;
    private a eXw;
    private com.baidu.tbadk.core.message.a eXx;
    private CustomMessageListener eXy;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes21.dex */
    public interface a {
        void g(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.eXg != null) {
            this.eXg.agreeType = agreeData.agreeType;
            this.eXg.hasAgree = agreeData.hasAgree;
            this.eXg.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eXn = R.raw.lottie_agree;
        this.eXo = R.raw.lottie_disagree;
        this.eXp = R.color.CAM_X0107;
        this.cardType = 1;
        this.eXu = false;
        this.eXv = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eXg != null && agreeData != null && AgreeView.this.eXh != null && !AgreeView.this.eXg.isInPost && AgreeView.this.eXh.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eXg.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eXg.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eXg.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eXy = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eXg != null && !TextUtils.isEmpty(AgreeView.this.eXg.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eXg.postId.equals(agreeData.postId) && !AgreeView.this.eXg.isInThread) {
                        if (AgreeView.this.eXj) {
                            if (AgreeView.this.eXg.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eXh.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bs(view);
                if (AgreeView.this.eXr != null) {
                    AgreeView.this.eXr.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eXn = R.raw.lottie_agree;
        this.eXo = R.raw.lottie_disagree;
        this.eXp = R.color.CAM_X0107;
        this.cardType = 1;
        this.eXu = false;
        this.eXv = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eXg != null && agreeData != null && AgreeView.this.eXh != null && !AgreeView.this.eXg.isInPost && AgreeView.this.eXh.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eXg.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eXg.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eXg.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eXy = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eXg != null && !TextUtils.isEmpty(AgreeView.this.eXg.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eXg.postId.equals(agreeData.postId) && !AgreeView.this.eXg.isInThread) {
                        if (AgreeView.this.eXj) {
                            if (AgreeView.this.eXg.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eXh.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bs(view);
                if (AgreeView.this.eXr != null) {
                    AgreeView.this.eXr.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eXn = R.raw.lottie_agree;
        this.eXo = R.raw.lottie_disagree;
        this.eXp = R.color.CAM_X0107;
        this.cardType = 1;
        this.eXu = false;
        this.eXv = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eXg != null && agreeData != null && AgreeView.this.eXh != null && !AgreeView.this.eXg.isInPost && AgreeView.this.eXh.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eXg.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eXg.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eXg.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eXy = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eXg != null && !TextUtils.isEmpty(AgreeView.this.eXg.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eXg.postId.equals(agreeData.postId) && !AgreeView.this.eXg.isInThread) {
                        if (AgreeView.this.eXj) {
                            if (AgreeView.this.eXg.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eXh.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bs(view);
                if (AgreeView.this.eXr != null) {
                    AgreeView.this.eXr.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.eXc = new TBLottieAnimationView(context);
        this.eXc.setId(R.id.img_agree);
        this.eXc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eXc.setOnClickListener(this.mOnClickListener);
        this.eXc.addAnimatorListener(this);
        this.eXd = new TextView(context);
        this.eXd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eXd.setOnClickListener(this.mOnClickListener);
        this.eXe = new TBLottieAnimationView(context);
        this.eXe.setId(R.id.img_disagree);
        this.eXe.addAnimatorListener(this);
        this.eXe.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eXe.setOnClickListener(this.mOnClickListener);
        this.eXf = new TextView(context);
        this.eXf.setText(R.string.c_disagree);
        this.eXf.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eXf.setOnClickListener(this.mOnClickListener);
        this.eXh = new com.baidu.tieba.tbadkCore.data.e();
        this.eXh.uniqueId = getPageId();
        this.eXx = new com.baidu.tbadk.core.message.a();
        buM();
        setAgreeAnimationResource();
    }

    private void buM() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eXt = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.eXc);
        linearLayout.addView(this.eXd);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.eXs = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.eXe);
        linearLayout2.addView(this.eXf);
        jx(false);
    }

    private void x(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.eXt.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.eXt.setLayoutParams(layoutParams);
        this.eXc.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.eXd.setLayoutParams(layoutParams2);
        this.eXs.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.eXs.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.eXe.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.eXf.setLayoutParams(layoutParams5);
    }

    public void jx(boolean z) {
        if (z) {
            x(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.eXu);
            return;
        }
        x(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.eXu);
    }

    public void buN() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eXc.setLayoutParams(layoutParams);
        this.eXd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eXd.setLayoutParams(layoutParams2);
        this.eXe.setVisibility(8);
        this.eXf.setVisibility(8);
    }

    public void jy(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.eXc.setLayoutParams(layoutParams);
        this.eXd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.eXd.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.eXv = true;
        } else {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22);
        }
        layoutParams2.gravity = 16;
        this.eXd.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        if (!z) {
            layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds28);
        }
        this.eXe.setLayoutParams(layoutParams3);
        this.eXf.setVisibility(8);
    }

    public void buO() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        removeAllViews();
        br(this.eXc);
        br(this.eXe);
        br(this.eXd);
        br(this.eXf);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.eXc, new LinearLayout.LayoutParams(dimens, dimens));
        this.eXd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        linearLayout.addView(this.eXd, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.eXs = linearLayout2;
        linearLayout2.addView(this.eXe, new LinearLayout.LayoutParams(dimens, dimens));
        this.eXf.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        linearLayout2.addView(this.eXf, layoutParams4);
    }

    private void br(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eXy);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eXy);
    }

    public void setTopicId(String str) {
        this.eXq = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.eXj = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.eXk = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.eXc;
    }

    public TextView getAgreeNumView() {
        return this.eXd;
    }

    public TextView getDisagreeNumView() {
        return this.eXf;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.eXe;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.eXg = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.eXg;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.eXc, this.eXn);
        ap.a(this.eXe, this.eXo);
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
            return au.numFormatOverWanNa(j);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + au.numFormatOverWanNa(-j);
    }

    public void updateUI() {
        this.eXd.setText(b(this.eXg));
        if (this.eXg.hasAgree) {
            if (this.eXg.agreeType == 2) {
                this.eXe.setProgress(0.0f);
                this.eXc.setProgress(1.0f);
                this.eXd.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.eXf);
                return;
            }
            this.eXc.setProgress(0.0f);
            this.eXe.setProgress(1.0f);
            setTextNormalColor(this.eXd);
            this.eXf.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        this.eXc.setProgress(0.0f);
        this.eXe.setProgress(0.0f);
        setTextNormalColor(this.eXd);
        setTextNormalColor(this.eXf);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.eXk) {
            textView.setTextColor(ap.getColor(R.color.CAM_X0107));
        } else if (this.eXj) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ap.getColor(this.eXp));
        }
    }

    public void jz(boolean z) {
        this.eXc.setMinAndMaxProgress(0.0f, 1.0f);
        this.eXe.setMinAndMaxProgress(0.0f, 1.0f);
        this.eXd.setText(b(this.eXg));
        this.eXc.clearColorFilter();
        this.eXe.clearColorFilter();
        if (z) {
            this.eXc.playAnimation();
            this.eXe.cancelAnimation();
            this.eXe.setFrame(0);
        } else {
            this.eXe.playAnimation();
            this.eXc.cancelAnimation();
            this.eXc.setFrame(0);
        }
        if (this.eXg.hasAgree) {
            if (this.eXg.agreeType == 2) {
                this.eXd.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.eXf);
                return;
            }
            setTextNormalColor(this.eXd);
            this.eXf.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.eXd);
        setTextNormalColor(this.eXf);
    }

    public void buP() {
        bs(this.eXc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bs(View view) {
        com.baidu.tbadk.pageExtra.c bM;
        int i = 0;
        int i2 = 1;
        if (this.eXg != null) {
            if (!this.eXj || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.eXj || bh.checkUpIsLogin(getContext())) {
                    if (view != this.eXd || this.eXv) {
                        if (view.getId() == this.eXc.getId() || (this.eXv && view.getId() == this.eXd.getId())) {
                            this.eXc.cancelAnimation();
                            if (this.eXl != null) {
                                this.eXl.type = 1;
                            }
                            if (this.eXg.hasAgree) {
                                if (this.eXg.agreeType == 2) {
                                    this.eXg.agreeType = 2;
                                    this.eXg.hasAgree = false;
                                    this.eXg.agreeNum--;
                                    updateUI();
                                    if (this.eXl != null) {
                                        this.eXl.eEM = 1;
                                    }
                                } else {
                                    this.eXg.agreeType = 2;
                                    this.eXg.hasAgree = true;
                                    this.eXg.agreeNum++;
                                    jz(true);
                                    com.baidu.tieba.p.a.dEK().G(getTbPageContext());
                                    if (this.eXl != null) {
                                        this.eXl.eEM = 0;
                                        i2 = 0;
                                    }
                                }
                                bM = com.baidu.tbadk.pageExtra.d.bM(this);
                                if (bM != null) {
                                    this.eXg.objSource = bM.getCurrentPageKey();
                                }
                                this.eXx.a(this.eXg, i2, getPageId(), this.eXj);
                            } else {
                                this.eXg.agreeType = 2;
                                this.eXg.hasAgree = true;
                                this.eXg.agreeNum++;
                                jz(true);
                                com.baidu.tieba.p.a.dEK().G(getTbPageContext());
                                if (this.eXl != null) {
                                    this.eXl.eEM = 0;
                                }
                            }
                            i2 = 0;
                            bM = com.baidu.tbadk.pageExtra.d.bM(this);
                            if (bM != null) {
                            }
                            this.eXx.a(this.eXg, i2, getPageId(), this.eXj);
                        } else if (view.getId() == this.eXe.getId()) {
                            this.eXe.cancelAnimation();
                            if (this.eXl != null) {
                                this.eXl.type = 2;
                            }
                            if (this.eXg.hasAgree) {
                                if (this.eXg.agreeType == 5) {
                                    this.eXg.agreeType = 5;
                                    this.eXg.hasAgree = false;
                                    updateUI();
                                    if (this.eXl != null) {
                                        this.eXl.eEQ = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.eXg.agreeType = 5;
                                    this.eXg.hasAgree = true;
                                    this.eXg.agreeNum--;
                                    jz(false);
                                    if (this.eXl != null) {
                                        this.eXl.eEQ = 1;
                                    }
                                }
                            } else {
                                this.eXg.agreeType = 5;
                                this.eXg.hasAgree = true;
                                jz(false);
                                if (this.eXl != null) {
                                    this.eXl.eEQ = 1;
                                }
                            }
                            com.baidu.tbadk.pageExtra.c bM2 = com.baidu.tbadk.pageExtra.d.bM(this);
                            if (bM2 != null) {
                                this.eXg.objSource = bM2.getCurrentPageKey();
                            }
                            this.eXx.a(this.eXg, i, getPageId(), this.eXj);
                        }
                        this.eXx.a(this.eXg, this.eXh);
                        if (this.akt != null) {
                            this.akt.onClick(view);
                        }
                        buQ();
                    }
                }
            }
        }
    }

    public void buQ() {
        if (this.eXl != null && this.eXg != null) {
            int i = 0;
            if (this.eXg.baijiahaoData != null) {
                i = this.eXg.baijiahaoData.oriUgcType;
            }
            if (this.eXl.type == 1) {
                if (StringUtils.isNull(this.eXq)) {
                    ar dY = new ar("c12003").al("obj_locate", this.eXl.eEJ).al("obj_param1", this.eXl.eEK).al("obj_source", this.eXl.eEL).al("obj_id", this.eXl.eEM).al("obj_name", i).dY("post_id", this.eXg.postId);
                    if (this.eCR != null) {
                        dY.dY("tid", this.eCR.getId()).dY("nid", this.eCR.getNid()).w("fid", this.eCR.getFid()).al(IntentConfig.CARD_TYPE, this.cardType).dY("ab_tag", this.eCR.mRecomAbTag).dY(IntentConfig.RECOM_SOURCE, this.eCR.mRecomSource).dY("weight", this.eCR.mRecomWeight).dY("extra", this.eCR.mRecomExtra);
                        if (this.eCR.getBaijiahaoData() != null) {
                            dY.dY("obj_param4", this.eCR.getBaijiahaoData().oriUgcNid);
                            if (this.eCR.bny() || this.eCR.bqN()) {
                                dY.dY("obj_param6", this.eCR.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.eCR.bqL()) {
                            dY.al("obj_param5", 2);
                        } else if (this.eCR.bnx() || this.eCR.bny()) {
                            dY.al("obj_param5", 3);
                        } else if (this.eCR.threadType == 0 || this.eCR.threadType == 40) {
                            dY.al("obj_param5", 1);
                        }
                    } else {
                        dY.dY("tid", this.eXg.threadId);
                        dY.dY("nid", this.eXg.nid);
                        dY.dY("fid", this.eXg.forumId);
                        dY.al(IntentConfig.CARD_TYPE, this.eXg.cardType);
                        dY.dY("ab_tag", this.eXg.recomAbTag);
                        dY.dY(IntentConfig.RECOM_SOURCE, this.eXg.recomSource);
                        dY.dY("weight", this.eXg.recomWeight);
                        dY.dY("extra", this.eXg.recomExtra);
                        if (this.eXg.baijiahaoData != null) {
                            dY.dY("obj_param6", this.eXg.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (qy(this.eXl.eEJ) && qz(this.eXl.eEN) != -1) {
                        dY.al(TiebaInitialize.Params.OBJ_TO, qz(this.eXl.eEN));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dY.dY("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dY.al("resource_id", this.eXm);
                    } else if (this.mFrom == 18) {
                        dY.dY("obj_tab", "a099");
                        dY.dY("resource_id", this.mTabName);
                    } else {
                        dY.al("resource_id", this.eXm);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dY);
                    }
                    if (this.eXg.isFromImageViewer) {
                        dY.dY("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.eXg.mImageViewerFromPage == "index") {
                            dY.dY(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.eXg.keyFromHomePage)) {
                        dY.dY("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dY.dY("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(this);
                    if (bM != null) {
                        dY.dY("obj_cur_page", bM.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                        dY.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
                    }
                    TiebaStatic.log(dY);
                    return;
                }
                TiebaStatic.log(new ar("c13358").dY("tid", this.eXg.threadId).dY("topic_id", this.eXq));
            } else if (this.eXl.type == 2) {
                ar dY2 = new ar("c13271").al("obj_type", this.eXl.eEO).al("obj_locate", this.eXl.eEP).al(TiebaInitialize.Params.OBJ_PARAM2, this.eXm).al("obj_id", this.eXl.eEQ).al("obj_name", i).dY("post_id", this.eXg.postId).dY("nid", this.eXg.nid);
                if (this.eCR != null) {
                    dY2.dY("tid", this.eCR.getId()).dY("nid", this.eCR.getNid()).w("fid", this.eCR.getFid()).al(IntentConfig.CARD_TYPE, this.cardType).dY("ab_tag", this.eCR.mRecomAbTag).dY(IntentConfig.RECOM_SOURCE, this.eCR.mRecomSource).dY("weight", this.eCR.mRecomWeight).dY("extra", this.eCR.mRecomExtra);
                    if (this.eCR.getBaijiahaoData() != null) {
                        dY2.dY("obj_param4", this.eCR.getBaijiahaoData().oriUgcNid);
                        if (this.eCR.bny() || this.eCR.bqN()) {
                            dY2.dY("obj_param6", this.eCR.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.eCR.bqL()) {
                        dY2.al("obj_param5", 2);
                    } else if (this.eCR.bnx() || this.eCR.bny()) {
                        dY2.al("obj_param5", 3);
                    } else if (this.eCR.threadType == 0 || this.eCR.threadType == 40) {
                        dY2.al("obj_param5", 1);
                    }
                } else {
                    dY2.dY("tid", this.eXg.threadId);
                    dY2.dY("nid", this.eXg.nid);
                    dY2.dY("fid", this.eXg.forumId);
                    dY2.al(IntentConfig.CARD_TYPE, this.eXg.cardType);
                    dY2.dY("ab_tag", this.eXg.recomAbTag);
                    dY2.dY(IntentConfig.RECOM_SOURCE, this.eXg.recomSource);
                    dY2.dY("weight", this.eXg.recomWeight);
                    dY2.dY("extra", this.eXg.recomExtra);
                    if (this.eXg.baijiahaoData != null) {
                        dY2.dY("obj_param6", this.eXg.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dY2.dY("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dY2.dY("obj_tab", "a099");
                    dY2.dY("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dY2);
                }
                if (this.eXg.isFromImageViewer) {
                    dY2.dY("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.eXg.mImageViewerFromPage == "index") {
                        dY2.dY(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dY2);
            }
        }
    }

    public static boolean qy(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int qz(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.eXi == null) {
            this.eXi = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.eXi.setDuration(200L);
        }
        return this.eXi;
    }

    public void onChangeSkinType(int i) {
        if (this.eXg != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.eXc, this.eXn);
            ap.a(this.eXe, this.eXo);
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
        this.eXl = dVar;
    }

    public void setGameId(int i) {
        this.eXm = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.eXe.setVisibility(z ? 8 : 0);
        this.eXf.setVisibility(z ? 8 : 0);
        if (z && this.eXs != null) {
            this.eXs.setVisibility(8);
        }
        if (this.eXu != z && this.eXw != null) {
            this.eXw.g(this.eXe, z);
        }
        this.eXu = z;
    }

    public void setDisagreeShow(boolean z) {
        this.eXe.setVisibility(z ? 8 : 0);
        this.eXf.setVisibility(z ? 8 : 0);
        if (this.eXs != null) {
            this.eXs.setVisibility(z ? 8 : 0);
        }
        this.eXu = z;
    }

    public boolean buR() {
        return this.eXu;
    }

    public void setThreadData(by byVar) {
        this.eCR = byVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.eXn = i;
        this.eXo = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.eXp = i;
        setTextNormalColor(this.eXd);
        setTextNormalColor(this.eXf);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.eXw = aVar;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.eXe;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.eXc;
    }
}
