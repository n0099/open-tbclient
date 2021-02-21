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
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener ajT;
    private int cardType;
    private cb eJQ;
    private LinearLayout feA;
    private LinearLayout feB;
    private boolean feC;
    private boolean feD;
    private a feE;
    private com.baidu.tbadk.core.message.a feF;
    private CustomMessageListener feG;
    private TBLottieAnimationView fek;
    private TextView fel;
    private TBLottieAnimationView fem;
    private TextView fen;
    private AgreeData feo;
    private com.baidu.tieba.tbadkCore.data.e fep;
    private ScaleAnimation feq;
    private boolean fer;
    private boolean fes;
    private com.baidu.tbadk.core.data.e fet;
    private int feu;
    private int fev;
    private int few;
    private int fex;
    private String fey;
    public View.OnClickListener fez;
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
        if (agreeData != null && this.feo != null) {
            this.feo.agreeType = agreeData.agreeType;
            this.feo.hasAgree = agreeData.hasAgree;
            this.feo.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fev = R.raw.lottie_agree;
        this.few = R.raw.lottie_disagree;
        this.fex = R.color.CAM_X0107;
        this.cardType = 1;
        this.feC = false;
        this.feD = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.feo != null && agreeData != null && AgreeView.this.fep != null && !AgreeView.this.feo.isInPost && AgreeView.this.fep.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.feo.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.feo.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.feo.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.feG = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.feo != null && !TextUtils.isEmpty(AgreeView.this.feo.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.feo.postId.equals(agreeData.postId) && !AgreeView.this.feo.isInThread) {
                        if (AgreeView.this.fer) {
                            if (AgreeView.this.feo.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.fep.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eJQ == null || AgreeView.this.eJQ.getType() != cb.eRd) {
                    AgreeView.this.bx(view);
                    if (AgreeView.this.fez != null) {
                        AgreeView.this.fez.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fev = R.raw.lottie_agree;
        this.few = R.raw.lottie_disagree;
        this.fex = R.color.CAM_X0107;
        this.cardType = 1;
        this.feC = false;
        this.feD = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.feo != null && agreeData != null && AgreeView.this.fep != null && !AgreeView.this.feo.isInPost && AgreeView.this.fep.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.feo.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.feo.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.feo.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.feG = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.feo != null && !TextUtils.isEmpty(AgreeView.this.feo.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.feo.postId.equals(agreeData.postId) && !AgreeView.this.feo.isInThread) {
                        if (AgreeView.this.fer) {
                            if (AgreeView.this.feo.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.fep.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eJQ == null || AgreeView.this.eJQ.getType() != cb.eRd) {
                    AgreeView.this.bx(view);
                    if (AgreeView.this.fez != null) {
                        AgreeView.this.fez.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fev = R.raw.lottie_agree;
        this.few = R.raw.lottie_disagree;
        this.fex = R.color.CAM_X0107;
        this.cardType = 1;
        this.feC = false;
        this.feD = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.feo != null && agreeData != null && AgreeView.this.fep != null && !AgreeView.this.feo.isInPost && AgreeView.this.fep.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.feo.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.feo.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.feo.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.feG = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.feo != null && !TextUtils.isEmpty(AgreeView.this.feo.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.feo.postId.equals(agreeData.postId) && !AgreeView.this.feo.isInThread) {
                        if (AgreeView.this.fer) {
                            if (AgreeView.this.feo.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.fep.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eJQ == null || AgreeView.this.eJQ.getType() != cb.eRd) {
                    AgreeView.this.bx(view);
                    if (AgreeView.this.fez != null) {
                        AgreeView.this.fez.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.fek = new TBLottieAnimationView(context);
        this.fek.setId(R.id.img_agree);
        this.fek.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fek.setOnClickListener(this.mOnClickListener);
        this.fek.addAnimatorListener(this);
        this.fel = new TextView(context);
        this.fel.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.fel.setOnClickListener(this.mOnClickListener);
        this.fem = new TBLottieAnimationView(context);
        this.fem.setId(R.id.img_disagree);
        this.fem.addAnimatorListener(this);
        this.fem.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fem.setOnClickListener(this.mOnClickListener);
        this.fen = new TextView(context);
        this.fen.setText(R.string.c_disagree);
        this.fen.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.fen.setOnClickListener(this.mOnClickListener);
        this.fep = new com.baidu.tieba.tbadkCore.data.e();
        this.fep.uniqueId = getPageId();
        this.feF = new com.baidu.tbadk.core.message.a();
        btI();
        setAgreeAnimationResource();
    }

    private void btI() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.feB = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.fek);
        linearLayout.addView(this.fel);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.feA = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.fem);
        linearLayout2.addView(this.fen);
        jS(false);
    }

    private void y(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.feB.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.feB.setLayoutParams(layoutParams);
        this.fek.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.fel.setLayoutParams(layoutParams2);
        this.feA.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.feA.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.fem.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.fen.setLayoutParams(layoutParams5);
    }

    public void jS(boolean z) {
        if (z) {
            y(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.feC);
            return;
        }
        y(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.feC);
    }

    public void btJ() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.fek.setLayoutParams(layoutParams);
        this.fel.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.fel.setLayoutParams(layoutParams2);
        this.fem.setVisibility(8);
        this.fen.setVisibility(8);
    }

    public void jT(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.fek.setLayoutParams(layoutParams);
        this.fel.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.fel.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.feD = true;
        } else {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22);
        }
        layoutParams2.gravity = 16;
        this.fel.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        if (!z) {
            layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds28);
        }
        this.fem.setLayoutParams(layoutParams3);
        this.fen.setVisibility(8);
    }

    public void btK() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        removeAllViews();
        bw(this.fek);
        bw(this.fem);
        bw(this.fel);
        bw(this.fen);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.fek, new LinearLayout.LayoutParams(dimens, dimens));
        this.fel.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        linearLayout.addView(this.fel, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.feA = linearLayout2;
        linearLayout2.addView(this.fem, new LinearLayout.LayoutParams(dimens, dimens));
        this.fen.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        linearLayout2.addView(this.fen, layoutParams4);
    }

    private void bw(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.feG);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.feG);
    }

    public void setTopicId(String str) {
        this.fey = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.fer = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.fes = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.fek;
    }

    public TextView getAgreeNumView() {
        return this.fel;
    }

    public TextView getDisagreeNumView() {
        return this.fen;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.fem;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.feo = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.feo;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.fek, this.fev);
        ap.a(this.fem, this.few);
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
        this.fel.setText(b(this.feo));
        if (this.feo.hasAgree) {
            if (this.feo.agreeType == 2) {
                this.fem.setProgress(0.0f);
                this.fek.setProgress(1.0f);
                this.fel.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fen);
                return;
            }
            this.fek.setProgress(0.0f);
            this.fem.setProgress(1.0f);
            setTextNormalColor(this.fel);
            this.fen.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        this.fek.setProgress(0.0f);
        this.fem.setProgress(0.0f);
        setTextNormalColor(this.fel);
        setTextNormalColor(this.fen);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.fes) {
            textView.setTextColor(ap.getColor(R.color.CAM_X0107));
        } else if (this.fer) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ap.getColor(this.fex));
        }
    }

    public void jU(boolean z) {
        this.fek.setMinAndMaxProgress(0.0f, 1.0f);
        this.fem.setMinAndMaxProgress(0.0f, 1.0f);
        this.fel.setText(b(this.feo));
        this.fek.clearColorFilter();
        this.fem.clearColorFilter();
        if (z) {
            this.fek.playAnimation();
            this.fem.cancelAnimation();
            this.fem.setFrame(0);
        } else {
            this.fem.playAnimation();
            this.fek.cancelAnimation();
            this.fek.setFrame(0);
        }
        if (this.feo.hasAgree) {
            if (this.feo.agreeType == 2) {
                this.fel.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fen);
                return;
            }
            setTextNormalColor(this.fel);
            this.fen.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.fel);
        setTextNormalColor(this.fen);
    }

    public void btL() {
        bx(this.fek);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bx(View view) {
        com.baidu.tbadk.pageExtra.c bR;
        int i = 0;
        int i2 = 1;
        if (this.feo != null) {
            if (!this.fer || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.fer || bh.checkUpIsLogin(getContext())) {
                    if (view != this.fel || this.feD) {
                        if (view.getId() == this.fek.getId() || (this.feD && view.getId() == this.fel.getId())) {
                            this.fek.cancelAnimation();
                            if (this.fet != null) {
                                this.fet.type = 1;
                            }
                            if (this.feo.hasAgree) {
                                if (this.feo.agreeType == 2) {
                                    this.feo.agreeType = 2;
                                    this.feo.hasAgree = false;
                                    this.feo.agreeNum--;
                                    updateUI();
                                    if (this.fet != null) {
                                        this.fet.eMd = 1;
                                    }
                                } else {
                                    this.feo.agreeType = 2;
                                    this.feo.hasAgree = true;
                                    this.feo.agreeNum++;
                                    jU(true);
                                    com.baidu.tieba.o.a.dCY().J(getTbPageContext());
                                    if (this.fet != null) {
                                        this.fet.eMd = 0;
                                        i2 = 0;
                                    }
                                }
                                bR = com.baidu.tbadk.pageExtra.d.bR(this);
                                if (bR != null) {
                                    this.feo.objSource = bR.getCurrentPageKey();
                                }
                                this.feF.a(this.feo, i2, getPageId(), this.fer);
                            } else {
                                this.feo.agreeType = 2;
                                this.feo.hasAgree = true;
                                this.feo.agreeNum++;
                                jU(true);
                                com.baidu.tieba.o.a.dCY().J(getTbPageContext());
                                if (this.fet != null) {
                                    this.fet.eMd = 0;
                                }
                            }
                            i2 = 0;
                            bR = com.baidu.tbadk.pageExtra.d.bR(this);
                            if (bR != null) {
                            }
                            this.feF.a(this.feo, i2, getPageId(), this.fer);
                        } else if (view.getId() == this.fem.getId()) {
                            this.fem.cancelAnimation();
                            if (this.fet != null) {
                                this.fet.type = 2;
                            }
                            if (this.feo.hasAgree) {
                                if (this.feo.agreeType == 5) {
                                    this.feo.agreeType = 5;
                                    this.feo.hasAgree = false;
                                    updateUI();
                                    if (this.fet != null) {
                                        this.fet.eMh = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.feo.agreeType = 5;
                                    this.feo.hasAgree = true;
                                    this.feo.agreeNum--;
                                    jU(false);
                                    if (this.fet != null) {
                                        this.fet.eMh = 1;
                                    }
                                }
                            } else {
                                this.feo.agreeType = 5;
                                this.feo.hasAgree = true;
                                jU(false);
                                if (this.fet != null) {
                                    this.fet.eMh = 1;
                                }
                            }
                            com.baidu.tbadk.pageExtra.c bR2 = com.baidu.tbadk.pageExtra.d.bR(this);
                            if (bR2 != null) {
                                this.feo.objSource = bR2.getCurrentPageKey();
                            }
                            this.feF.a(this.feo, i, getPageId(), this.fer);
                        }
                        this.feF.a(this.feo, this.fep);
                        if (this.ajT != null) {
                            this.ajT.onClick(view);
                        }
                        btM();
                    }
                }
            }
        }
    }

    public void btM() {
        if (this.fet != null && this.feo != null) {
            int i = 0;
            if (this.feo.baijiahaoData != null) {
                i = this.feo.baijiahaoData.oriUgcType;
            }
            if (this.fet.type == 1) {
                if (StringUtils.isNull(this.fey)) {
                    ar dR = new ar("c12003").ap("obj_locate", this.fet.eMa).ap("obj_param1", this.fet.eMb).ap("obj_source", this.fet.eMc).ap("obj_id", this.fet.eMd).ap("obj_name", i).dR("post_id", this.feo.postId);
                    if (this.eJQ != null) {
                        dR.dR("tid", this.eJQ.getId()).dR(IntentConfig.NID, this.eJQ.bmo()).v("fid", this.eJQ.getFid()).ap(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.eJQ.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.eJQ.mRecomSource).dR("weight", this.eJQ.mRecomWeight).dR("extra", this.eJQ.mRecomExtra);
                        if (this.eJQ.getBaijiahaoData() != null) {
                            dR.dR("obj_param4", this.eJQ.getBaijiahaoData().oriUgcNid);
                            if (this.eJQ.bmy() || this.eJQ.bpO()) {
                                dR.dR("obj_param6", this.eJQ.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.eJQ.bpM()) {
                            dR.ap("obj_param5", 2);
                        } else if (this.eJQ.bmx() || this.eJQ.bmy()) {
                            dR.ap("obj_param5", 3);
                        } else if (this.eJQ.threadType == 0 || this.eJQ.threadType == 40) {
                            dR.ap("obj_param5", 1);
                        }
                    } else {
                        dR.dR("tid", this.feo.threadId);
                        dR.dR(IntentConfig.NID, this.feo.nid);
                        dR.dR("fid", this.feo.forumId);
                        dR.ap(IntentConfig.CARD_TYPE, this.feo.cardType);
                        dR.dR("ab_tag", this.feo.recomAbTag);
                        dR.dR(IntentConfig.RECOM_SOURCE, this.feo.recomSource);
                        dR.dR("weight", this.feo.recomWeight);
                        dR.dR("extra", this.feo.recomExtra);
                        if (this.feo.baijiahaoData != null) {
                            dR.dR("obj_param6", this.feo.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (ph(this.fet.eMa) && pi(this.fet.eMe) != -1) {
                        dR.ap(TiebaInitialize.Params.OBJ_TO, pi(this.fet.eMe));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.ap("resource_id", this.feu);
                    } else if (this.mFrom == 18) {
                        dR.dR("obj_tab", "a099");
                        dR.dR("resource_id", this.mTabName);
                    } else {
                        dR.ap("resource_id", this.feu);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dR);
                    }
                    if (this.feo.isFromImageViewer) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.feo.mImageViewerFromPage == "index") {
                            dR.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.feo.keyFromHomePage)) {
                        dR.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(this);
                    if (bR != null) {
                        dR.dR("obj_cur_page", bR.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                        dR.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
                    }
                    TiebaStatic.log(dR);
                    return;
                }
                TiebaStatic.log(new ar("c13358").dR("tid", this.feo.threadId).dR("topic_id", this.fey));
            } else if (this.fet.type == 2) {
                ar dR2 = new ar("c13271").ap("obj_type", this.fet.eMf).ap("obj_locate", this.fet.eMg).ap(TiebaInitialize.Params.OBJ_PARAM2, this.feu).ap("obj_id", this.fet.eMh).ap("obj_name", i).dR("post_id", this.feo.postId).dR(IntentConfig.NID, this.feo.nid);
                if (this.eJQ != null) {
                    dR2.dR("tid", this.eJQ.getId()).dR(IntentConfig.NID, this.eJQ.bmo()).v("fid", this.eJQ.getFid()).ap(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.eJQ.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.eJQ.mRecomSource).dR("weight", this.eJQ.mRecomWeight).dR("extra", this.eJQ.mRecomExtra);
                    if (this.eJQ.getBaijiahaoData() != null) {
                        dR2.dR("obj_param4", this.eJQ.getBaijiahaoData().oriUgcNid);
                        if (this.eJQ.bmy() || this.eJQ.bpO()) {
                            dR2.dR("obj_param6", this.eJQ.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.eJQ.bpM()) {
                        dR2.ap("obj_param5", 2);
                    } else if (this.eJQ.bmx() || this.eJQ.bmy()) {
                        dR2.ap("obj_param5", 3);
                    } else if (this.eJQ.threadType == 0 || this.eJQ.threadType == 40) {
                        dR2.ap("obj_param5", 1);
                    }
                } else {
                    dR2.dR("tid", this.feo.threadId);
                    dR2.dR(IntentConfig.NID, this.feo.nid);
                    dR2.dR("fid", this.feo.forumId);
                    dR2.ap(IntentConfig.CARD_TYPE, this.feo.cardType);
                    dR2.dR("ab_tag", this.feo.recomAbTag);
                    dR2.dR(IntentConfig.RECOM_SOURCE, this.feo.recomSource);
                    dR2.dR("weight", this.feo.recomWeight);
                    dR2.dR("extra", this.feo.recomExtra);
                    if (this.feo.baijiahaoData != null) {
                        dR2.dR("obj_param6", this.feo.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dR2.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dR2.dR("obj_tab", "a099");
                    dR2.dR("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dR2);
                }
                if (this.feo.isFromImageViewer) {
                    dR2.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.feo.mImageViewerFromPage == "index") {
                        dR2.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public static boolean ph(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int pi(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.feq == null) {
            this.feq = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.feq.setDuration(200L);
        }
        return this.feq;
    }

    public void onChangeSkinType(int i) {
        if (this.feo != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.fek, this.fev);
            ap.a(this.fem, this.few);
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

    public void setStatisticData(com.baidu.tbadk.core.data.e eVar) {
        this.fet = eVar;
    }

    public void setGameId(int i) {
        this.feu = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.fem.setVisibility(z ? 8 : 0);
        this.fen.setVisibility(z ? 8 : 0);
        if (z && this.feA != null) {
            this.feA.setVisibility(8);
        }
        if (this.feC != z && this.feE != null) {
            this.feE.f(this.fem, z);
        }
        this.feC = z;
    }

    public void setDisagreeShow(boolean z) {
        this.fem.setVisibility(z ? 8 : 0);
        this.fen.setVisibility(z ? 8 : 0);
        if (this.feA != null) {
            this.feA.setVisibility(z ? 8 : 0);
        }
        this.feC = z;
    }

    public boolean btN() {
        return this.feC;
    }

    public void setThreadData(cb cbVar) {
        this.eJQ = cbVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.fev = i;
        this.few = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.fex = i;
        setTextNormalColor(this.fel);
        setTextNormalColor(this.fen);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.feE = aVar;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.fem;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.fek;
    }
}
