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
/* loaded from: classes20.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener aiW;
    private int cardType;
    private bw dXg;
    private int eqA;
    private int eqB;
    private int eqC;
    private String eqD;
    public View.OnClickListener eqE;
    private LinearLayout eqF;
    private LinearLayout eqG;
    private boolean eqH;
    private boolean eqI;
    private a eqJ;
    private com.baidu.tbadk.core.message.a eqK;
    private CustomMessageListener eqL;
    private TBLottieAnimationView eqp;
    private TextView eqq;
    private TBLottieAnimationView eqr;
    private TextView eqs;
    private AgreeData eqt;
    private com.baidu.tieba.tbadkCore.data.e equ;
    private ScaleAnimation eqv;
    private boolean eqw;
    private boolean eqx;
    private com.baidu.tbadk.core.data.c eqy;
    private int eqz;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes20.dex */
    public interface a {
        void e(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.eqt != null) {
            this.eqt.agreeType = agreeData.agreeType;
            this.eqt.hasAgree = agreeData.hasAgree;
            this.eqt.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eqA = R.raw.lottie_agree;
        this.eqB = R.raw.lottie_disagree;
        this.eqC = R.color.cp_cont_j;
        this.cardType = 1;
        this.eqH = false;
        this.eqI = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eqt != null && agreeData != null && AgreeView.this.equ != null && !AgreeView.this.eqt.isInPost && AgreeView.this.equ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eqt.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eqt.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eqt.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eqL = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eqt != null && !TextUtils.isEmpty(AgreeView.this.eqt.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eqt.postId.equals(agreeData.postId) && !AgreeView.this.eqt.isInThread) {
                        if (AgreeView.this.eqw) {
                            if (AgreeView.this.eqt.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.equ.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bd(view);
                if (AgreeView.this.eqE != null) {
                    AgreeView.this.eqE.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eqA = R.raw.lottie_agree;
        this.eqB = R.raw.lottie_disagree;
        this.eqC = R.color.cp_cont_j;
        this.cardType = 1;
        this.eqH = false;
        this.eqI = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eqt != null && agreeData != null && AgreeView.this.equ != null && !AgreeView.this.eqt.isInPost && AgreeView.this.equ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eqt.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eqt.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eqt.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eqL = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eqt != null && !TextUtils.isEmpty(AgreeView.this.eqt.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eqt.postId.equals(agreeData.postId) && !AgreeView.this.eqt.isInThread) {
                        if (AgreeView.this.eqw) {
                            if (AgreeView.this.eqt.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.equ.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bd(view);
                if (AgreeView.this.eqE != null) {
                    AgreeView.this.eqE.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eqA = R.raw.lottie_agree;
        this.eqB = R.raw.lottie_disagree;
        this.eqC = R.color.cp_cont_j;
        this.cardType = 1;
        this.eqH = false;
        this.eqI = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eqt != null && agreeData != null && AgreeView.this.equ != null && !AgreeView.this.eqt.isInPost && AgreeView.this.equ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eqt.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eqt.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eqt.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eqL = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eqt != null && !TextUtils.isEmpty(AgreeView.this.eqt.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eqt.postId.equals(agreeData.postId) && !AgreeView.this.eqt.isInThread) {
                        if (AgreeView.this.eqw) {
                            if (AgreeView.this.eqt.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.equ.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bd(view);
                if (AgreeView.this.eqE != null) {
                    AgreeView.this.eqE.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.eqp = new TBLottieAnimationView(context);
        this.eqp.setId(R.id.img_agree);
        this.eqp.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eqp.setOnClickListener(this.mOnClickListener);
        this.eqp.addAnimatorListener(this);
        this.eqq = new TextView(context);
        this.eqq.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eqq.setOnClickListener(this.mOnClickListener);
        this.eqr = new TBLottieAnimationView(context);
        this.eqr.setId(R.id.img_disagree);
        this.eqr.addAnimatorListener(this);
        this.eqr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eqr.setOnClickListener(this.mOnClickListener);
        this.eqs = new TextView(context);
        this.eqs.setText(R.string.c_disagree);
        this.eqs.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eqs.setOnClickListener(this.mOnClickListener);
        this.equ = new com.baidu.tieba.tbadkCore.data.e();
        this.equ.uniqueId = getPageId();
        this.eqK = new com.baidu.tbadk.core.message.a();
        bkY();
        setAgreeAnimationResource();
    }

    private void bkY() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eqG = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.eqp);
        linearLayout.addView(this.eqq);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.eqF = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.eqr);
        linearLayout2.addView(this.eqs);
        in(false);
    }

    private void s(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.eqG.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
        layoutParams.weight = i3;
        this.eqG.setLayoutParams(layoutParams);
        this.eqp.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.eqq.setLayoutParams(layoutParams2);
        this.eqF.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
        layoutParams3.weight = i3;
        this.eqF.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.eqr.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.eqs.setLayoutParams(layoutParams5);
    }

    public void in(boolean z) {
        if (z) {
            s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), 0, 1, 17);
            setAgreeAlone(this.eqH);
            return;
        }
        s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), -2, 0, 16);
        setAgreeAlone(this.eqH);
    }

    public void bkZ() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eqp.setLayoutParams(layoutParams);
        this.eqq.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eqq.setLayoutParams(layoutParams2);
        this.eqr.setVisibility(8);
        this.eqs.setVisibility(8);
    }

    public void io(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.eqp.setLayoutParams(layoutParams);
        this.eqq.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = i;
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.eqq.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.eqI = true;
        }
        layoutParams2.gravity = 16;
        this.eqq.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        this.eqr.setLayoutParams(layoutParams3);
        this.eqs.setVisibility(8);
    }

    public void bla() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        bc(this.eqp);
        bc(this.eqr);
        bc(this.eqq);
        bc(this.eqs);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.eqp, new LinearLayout.LayoutParams(dimens, dimens));
        this.eqq.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.eqq, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.eqF = linearLayout2;
        linearLayout2.addView(this.eqr, new LinearLayout.LayoutParams(dimens, dimens));
        this.eqs.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.eqs, layoutParams4);
    }

    private void bc(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eqL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eqL);
    }

    public void setTopicId(String str) {
        this.eqD = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.eqw = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.eqx = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.eqp;
    }

    public TextView getAgreeNumView() {
        return this.eqq;
    }

    public TextView getDisagreeNumView() {
        return this.eqs;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.eqr;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.eqt = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.eqt;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.eqp, this.eqA);
        ap.a(this.eqr, this.eqB);
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
        this.eqq.setText(b(this.eqt));
        if (this.eqt.hasAgree) {
            if (this.eqt.agreeType == 2) {
                this.eqr.setProgress(0.0f);
                this.eqp.setProgress(1.0f);
                this.eqq.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eqs);
                return;
            }
            this.eqp.setProgress(0.0f);
            this.eqr.setProgress(1.0f);
            setTextNormalColor(this.eqq);
            this.eqs.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.eqp.setProgress(0.0f);
        this.eqr.setProgress(0.0f);
        setTextNormalColor(this.eqq);
        setTextNormalColor(this.eqs);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.eqx) {
            textView.setTextColor(ap.getColor(R.color.cp_cont_d));
        } else if (this.eqw) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(ap.getColor(this.eqC));
        }
    }

    public void ip(boolean z) {
        this.eqp.setMinAndMaxProgress(0.0f, 1.0f);
        this.eqr.setMinAndMaxProgress(0.0f, 1.0f);
        this.eqq.setText(b(this.eqt));
        this.eqp.clearColorFilter();
        this.eqr.clearColorFilter();
        if (z) {
            this.eqp.playAnimation();
            this.eqr.cancelAnimation();
            this.eqr.setFrame(0);
        } else {
            this.eqr.playAnimation();
            this.eqp.cancelAnimation();
            this.eqp.setFrame(0);
        }
        if (this.eqt.hasAgree) {
            if (this.eqt.agreeType == 2) {
                this.eqq.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eqs);
                return;
            }
            setTextNormalColor(this.eqq);
            this.eqs.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.eqq);
        setTextNormalColor(this.eqs);
    }

    public void blb() {
        bd(this.eqp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(View view) {
        int i = 0;
        int i2 = 1;
        if (this.eqt != null) {
            if (!this.eqw || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.eqw || bg.checkUpIsLogin(getContext())) {
                    if (view != this.eqq || this.eqI) {
                        if (view.getId() == this.eqp.getId() || (this.eqI && view.getId() == this.eqq.getId())) {
                            this.eqp.cancelAnimation();
                            if (this.eqy != null) {
                                this.eqy.type = 1;
                            }
                            if (this.eqt.hasAgree) {
                                if (this.eqt.agreeType == 2) {
                                    this.eqt.agreeType = 2;
                                    this.eqt.hasAgree = false;
                                    this.eqt.agreeNum--;
                                    updateUI();
                                    if (this.eqy != null) {
                                        this.eqy.dZb = 1;
                                    }
                                } else {
                                    this.eqt.agreeType = 2;
                                    this.eqt.hasAgree = true;
                                    this.eqt.agreeNum++;
                                    ip(true);
                                    com.baidu.tieba.o.a.dqz().G(getTbPageContext());
                                    if (this.eqy != null) {
                                        this.eqy.dZb = 0;
                                        i2 = 0;
                                    }
                                }
                                this.eqK.a(this.eqt, i2, getPageId(), this.eqw);
                            } else {
                                this.eqt.agreeType = 2;
                                this.eqt.hasAgree = true;
                                this.eqt.agreeNum++;
                                ip(true);
                                com.baidu.tieba.o.a.dqz().G(getTbPageContext());
                                if (this.eqy != null) {
                                    this.eqy.dZb = 0;
                                }
                            }
                            i2 = 0;
                            this.eqK.a(this.eqt, i2, getPageId(), this.eqw);
                        } else if (view.getId() == this.eqr.getId()) {
                            this.eqr.cancelAnimation();
                            if (this.eqy != null) {
                                this.eqy.type = 2;
                            }
                            if (this.eqt.hasAgree) {
                                if (this.eqt.agreeType == 5) {
                                    this.eqt.agreeType = 5;
                                    this.eqt.hasAgree = false;
                                    updateUI();
                                    if (this.eqy != null) {
                                        this.eqy.dZf = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.eqt.agreeType = 5;
                                    this.eqt.hasAgree = true;
                                    this.eqt.agreeNum--;
                                    ip(false);
                                    if (this.eqy != null) {
                                        this.eqy.dZf = 1;
                                    }
                                }
                            } else {
                                this.eqt.agreeType = 5;
                                this.eqt.hasAgree = true;
                                ip(false);
                                if (this.eqy != null) {
                                    this.eqy.dZf = 1;
                                }
                            }
                            this.eqK.a(this.eqt, i, getPageId(), this.eqw);
                        }
                        this.eqK.a(this.eqt, this.equ);
                        if (this.aiW != null) {
                            this.aiW.onClick(view);
                        }
                        blc();
                    }
                }
            }
        }
    }

    public void blc() {
        if (this.eqy != null && this.eqt != null) {
            int i = 0;
            if (this.eqt.baijiahaoData != null) {
                i = this.eqt.baijiahaoData.oriUgcType;
            }
            if (this.eqy.type == 1) {
                if (StringUtils.isNull(this.eqD)) {
                    aq dF = new aq("c12003").ai("obj_locate", this.eqy.dYY).ai("obj_param1", this.eqy.dYZ).ai("obj_source", this.eqy.dZa).ai("obj_id", this.eqy.dZb).ai("obj_name", i).dF("post_id", this.eqt.postId);
                    if (this.dXg != null) {
                        dF.dF("tid", this.dXg.getId()).dF("nid", this.dXg.getNid()).u("fid", this.dXg.getFid()).ai(IntentConfig.CARD_TYPE, this.cardType).dF("ab_tag", this.dXg.mRecomAbTag).dF(IntentConfig.RECOM_SOURCE, this.dXg.mRecomSource).dF("weight", this.dXg.mRecomWeight).dF("extra", this.dXg.mRecomExtra);
                        if (this.dXg.getBaijiahaoData() != null) {
                            dF.dF("obj_param4", this.dXg.getBaijiahaoData().oriUgcNid);
                            if (this.dXg.beh() || this.dXg.bhu()) {
                                dF.dF("obj_param6", this.dXg.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.dXg.bhs()) {
                            dF.ai("obj_param5", 2);
                        } else if (this.dXg.beg() || this.dXg.beh()) {
                            dF.ai("obj_param5", 3);
                        } else if (this.dXg.threadType == 0 || this.dXg.threadType == 40) {
                            dF.ai("obj_param5", 1);
                        }
                    } else {
                        dF.dF("tid", this.eqt.threadId);
                        dF.dF("nid", this.eqt.nid);
                        dF.dF("fid", this.eqt.forumId);
                        dF.ai(IntentConfig.CARD_TYPE, this.eqt.cardType);
                        dF.dF("ab_tag", this.eqt.recomAbTag);
                        dF.dF(IntentConfig.RECOM_SOURCE, this.eqt.recomSource);
                        dF.dF("weight", this.eqt.recomWeight);
                        dF.dF("extra", this.eqt.recomExtra);
                        if (this.eqt.baijiahaoData != null) {
                            dF.dF("obj_param6", this.eqt.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (oH(this.eqy.dYY) && oI(this.eqy.dZc) != -1) {
                        dF.ai(TiebaInitialize.Params.OBJ_TO, oI(this.eqy.dZc));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dF.dF("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dF.ai("resource_id", this.eqz);
                    } else if (this.mFrom == 18) {
                        dF.dF("obj_tab", "a099");
                        dF.dF("resource_id", this.mTabName);
                    } else {
                        dF.ai("resource_id", this.eqz);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dF);
                    }
                    if (this.eqt.isFromImageViewer) {
                        dF.dF("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.eqt.mImageViewerFromPage == "index") {
                            dF.dF(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.eqt.keyFromHomePage)) {
                        dF.dF("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dF.dF("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    TiebaStatic.log(dF);
                    return;
                }
                TiebaStatic.log(new aq("c13358").dF("tid", this.eqt.threadId).dF("topic_id", this.eqD));
            } else if (this.eqy.type == 2) {
                aq dF2 = new aq("c13271").ai("obj_type", this.eqy.dZd).ai("obj_locate", this.eqy.dZe).ai(TiebaInitialize.Params.OBJ_PARAM2, this.eqz).ai("obj_id", this.eqy.dZf).ai("obj_name", i).dF("post_id", this.eqt.postId).dF("nid", this.eqt.nid);
                if (this.dXg != null) {
                    dF2.dF("tid", this.dXg.getId()).dF("nid", this.dXg.getNid()).u("fid", this.dXg.getFid()).ai(IntentConfig.CARD_TYPE, this.cardType).dF("ab_tag", this.dXg.mRecomAbTag).dF(IntentConfig.RECOM_SOURCE, this.dXg.mRecomSource).dF("weight", this.dXg.mRecomWeight).dF("extra", this.dXg.mRecomExtra);
                    if (this.dXg.getBaijiahaoData() != null) {
                        dF2.dF("obj_param4", this.dXg.getBaijiahaoData().oriUgcNid);
                        if (this.dXg.beh() || this.dXg.bhu()) {
                            dF2.dF("obj_param6", this.dXg.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.dXg.bhs()) {
                        dF2.ai("obj_param5", 2);
                    } else if (this.dXg.beg() || this.dXg.beh()) {
                        dF2.ai("obj_param5", 3);
                    } else if (this.dXg.threadType == 0 || this.dXg.threadType == 40) {
                        dF2.ai("obj_param5", 1);
                    }
                } else {
                    dF2.dF("tid", this.eqt.threadId);
                    dF2.dF("nid", this.eqt.nid);
                    dF2.dF("fid", this.eqt.forumId);
                    dF2.ai(IntentConfig.CARD_TYPE, this.eqt.cardType);
                    dF2.dF("ab_tag", this.eqt.recomAbTag);
                    dF2.dF(IntentConfig.RECOM_SOURCE, this.eqt.recomSource);
                    dF2.dF("weight", this.eqt.recomWeight);
                    dF2.dF("extra", this.eqt.recomExtra);
                    if (this.eqt.baijiahaoData != null) {
                        dF2.dF("obj_param6", this.eqt.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dF2.dF("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dF2.dF("obj_tab", "a099");
                    dF2.dF("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dF2);
                }
                if (this.eqt.isFromImageViewer) {
                    dF2.dF("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.eqt.mImageViewerFromPage == "index") {
                        dF2.dF(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dF2);
            }
        }
    }

    public static boolean oH(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int oI(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.eqv == null) {
            this.eqv = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.eqv.setDuration(200L);
        }
        return this.eqv;
    }

    public void onChangeSkinType(int i) {
        if (this.eqt != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.eqp, this.eqA);
            ap.a(this.eqr, this.eqB);
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
        this.eqy = cVar;
    }

    public void setGameId(int i) {
        this.eqz = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.eqr.setVisibility(z ? 8 : 0);
        this.eqs.setVisibility(z ? 8 : 0);
        if (z && this.eqF != null) {
            this.eqF.setVisibility(8);
        }
        if (this.eqH != z && this.eqJ != null) {
            this.eqJ.e(this.eqr, z);
        }
        this.eqH = z;
    }

    public void setDisagreeShow(boolean z) {
        this.eqr.setVisibility(z ? 8 : 0);
        this.eqs.setVisibility(z ? 8 : 0);
        if (this.eqF != null) {
            this.eqF.setVisibility(z ? 8 : 0);
        }
        this.eqH = z;
    }

    public boolean bld() {
        return this.eqH;
    }

    public void setThreadData(bw bwVar) {
        this.dXg = bwVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.eqA = i;
        this.eqB = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.eqC = i;
        setTextNormalColor(this.eqq);
        setTextNormalColor(this.eqs);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.eqJ = aVar;
    }
}
