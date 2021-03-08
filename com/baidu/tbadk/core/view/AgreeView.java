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
    private View.OnClickListener alm;
    private int cardType;
    private cb eLr;
    private TBLottieAnimationView ffJ;
    private TextView ffK;
    private TBLottieAnimationView ffL;
    private TextView ffM;
    private AgreeData ffN;
    private com.baidu.tieba.tbadkCore.data.e ffO;
    private ScaleAnimation ffP;
    private boolean ffQ;
    private boolean ffR;
    private com.baidu.tbadk.core.data.e ffS;
    private int ffT;
    private int ffU;
    private int ffV;
    private int ffW;
    private String ffX;
    public View.OnClickListener ffY;
    private LinearLayout ffZ;
    private LinearLayout fga;
    private boolean fgb;
    private boolean fgc;
    private a fgd;
    private com.baidu.tbadk.core.message.a fge;
    private CustomMessageListener fgf;
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
        if (agreeData != null && this.ffN != null) {
            this.ffN.agreeType = agreeData.agreeType;
            this.ffN.hasAgree = agreeData.hasAgree;
            this.ffN.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ffU = R.raw.lottie_agree;
        this.ffV = R.raw.lottie_disagree;
        this.ffW = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgb = false;
        this.fgc = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ffN != null && agreeData != null && AgreeView.this.ffO != null && !AgreeView.this.ffN.isInPost && AgreeView.this.ffO.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ffN.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ffN.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ffN.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgf = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ffN != null && !TextUtils.isEmpty(AgreeView.this.ffN.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ffN.postId.equals(agreeData.postId) && !AgreeView.this.ffN.isInThread) {
                        if (AgreeView.this.ffQ) {
                            if (AgreeView.this.ffN.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ffO.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eLr == null || AgreeView.this.eLr.getType() != cb.eSE) {
                    AgreeView.this.bx(view);
                    if (AgreeView.this.ffY != null) {
                        AgreeView.this.ffY.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ffU = R.raw.lottie_agree;
        this.ffV = R.raw.lottie_disagree;
        this.ffW = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgb = false;
        this.fgc = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ffN != null && agreeData != null && AgreeView.this.ffO != null && !AgreeView.this.ffN.isInPost && AgreeView.this.ffO.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ffN.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ffN.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ffN.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgf = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ffN != null && !TextUtils.isEmpty(AgreeView.this.ffN.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ffN.postId.equals(agreeData.postId) && !AgreeView.this.ffN.isInThread) {
                        if (AgreeView.this.ffQ) {
                            if (AgreeView.this.ffN.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ffO.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eLr == null || AgreeView.this.eLr.getType() != cb.eSE) {
                    AgreeView.this.bx(view);
                    if (AgreeView.this.ffY != null) {
                        AgreeView.this.ffY.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ffU = R.raw.lottie_agree;
        this.ffV = R.raw.lottie_disagree;
        this.ffW = R.color.CAM_X0107;
        this.cardType = 1;
        this.fgb = false;
        this.fgc = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ffN != null && agreeData != null && AgreeView.this.ffO != null && !AgreeView.this.ffN.isInPost && AgreeView.this.ffO.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ffN.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ffN.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ffN.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fgf = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ffN != null && !TextUtils.isEmpty(AgreeView.this.ffN.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ffN.postId.equals(agreeData.postId) && !AgreeView.this.ffN.isInThread) {
                        if (AgreeView.this.ffQ) {
                            if (AgreeView.this.ffN.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ffO.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eLr == null || AgreeView.this.eLr.getType() != cb.eSE) {
                    AgreeView.this.bx(view);
                    if (AgreeView.this.ffY != null) {
                        AgreeView.this.ffY.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.ffJ = new TBLottieAnimationView(context);
        this.ffJ.setId(R.id.img_agree);
        this.ffJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ffJ.setOnClickListener(this.mOnClickListener);
        this.ffJ.addAnimatorListener(this);
        this.ffK = new TextView(context);
        this.ffK.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ffK.setOnClickListener(this.mOnClickListener);
        this.ffL = new TBLottieAnimationView(context);
        this.ffL.setId(R.id.img_disagree);
        this.ffL.addAnimatorListener(this);
        this.ffL.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ffL.setOnClickListener(this.mOnClickListener);
        this.ffM = new TextView(context);
        this.ffM.setText(R.string.c_disagree);
        this.ffM.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ffM.setOnClickListener(this.mOnClickListener);
        this.ffO = new com.baidu.tieba.tbadkCore.data.e();
        this.ffO.uniqueId = getPageId();
        this.fge = new com.baidu.tbadk.core.message.a();
        btL();
        setAgreeAnimationResource();
    }

    private void btL() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fga = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.ffJ);
        linearLayout.addView(this.ffK);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.ffZ = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.ffL);
        linearLayout2.addView(this.ffM);
        jS(false);
    }

    private void y(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.fga.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.fga.setLayoutParams(layoutParams);
        this.ffJ.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.ffK.setLayoutParams(layoutParams2);
        this.ffZ.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.ffZ.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.ffL.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.ffM.setLayoutParams(layoutParams5);
    }

    public void jS(boolean z) {
        if (z) {
            y(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.fgb);
            return;
        }
        y(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.fgb);
    }

    public void btM() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ffJ.setLayoutParams(layoutParams);
        this.ffK.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ffK.setLayoutParams(layoutParams2);
        this.ffL.setVisibility(8);
        this.ffM.setVisibility(8);
    }

    public void jT(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.ffJ.setLayoutParams(layoutParams);
        this.ffK.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.ffK.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.fgc = true;
        } else {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22);
        }
        layoutParams2.gravity = 16;
        this.ffK.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        if (!z) {
            layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds28);
        }
        this.ffL.setLayoutParams(layoutParams3);
        this.ffM.setVisibility(8);
    }

    public void btN() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        removeAllViews();
        bw(this.ffJ);
        bw(this.ffL);
        bw(this.ffK);
        bw(this.ffM);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.ffJ, new LinearLayout.LayoutParams(dimens, dimens));
        this.ffK.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        linearLayout.addView(this.ffK, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.ffZ = linearLayout2;
        linearLayout2.addView(this.ffL, new LinearLayout.LayoutParams(dimens, dimens));
        this.ffM.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        linearLayout2.addView(this.ffM, layoutParams4);
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
        MessageManager.getInstance().registerListener(this.fgf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fgf);
    }

    public void setTopicId(String str) {
        this.ffX = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.ffQ = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.ffR = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.ffJ;
    }

    public TextView getAgreeNumView() {
        return this.ffK;
    }

    public TextView getDisagreeNumView() {
        return this.ffM;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.ffL;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.ffN = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.ffN;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.ffJ, this.ffU);
        ap.a(this.ffL, this.ffV);
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
        this.ffK.setText(b(this.ffN));
        if (this.ffN.hasAgree) {
            if (this.ffN.agreeType == 2) {
                this.ffL.setProgress(0.0f);
                this.ffJ.setProgress(1.0f);
                this.ffK.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.ffM);
                return;
            }
            this.ffJ.setProgress(0.0f);
            this.ffL.setProgress(1.0f);
            setTextNormalColor(this.ffK);
            this.ffM.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        this.ffJ.setProgress(0.0f);
        this.ffL.setProgress(0.0f);
        setTextNormalColor(this.ffK);
        setTextNormalColor(this.ffM);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.ffR) {
            textView.setTextColor(ap.getColor(R.color.CAM_X0107));
        } else if (this.ffQ) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ap.getColor(this.ffW));
        }
    }

    public void jU(boolean z) {
        this.ffJ.setMinAndMaxProgress(0.0f, 1.0f);
        this.ffL.setMinAndMaxProgress(0.0f, 1.0f);
        this.ffK.setText(b(this.ffN));
        this.ffJ.clearColorFilter();
        this.ffL.clearColorFilter();
        if (z) {
            this.ffJ.playAnimation();
            this.ffL.cancelAnimation();
            this.ffL.setFrame(0);
        } else {
            this.ffL.playAnimation();
            this.ffJ.cancelAnimation();
            this.ffJ.setFrame(0);
        }
        if (this.ffN.hasAgree) {
            if (this.ffN.agreeType == 2) {
                this.ffK.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.ffM);
                return;
            }
            setTextNormalColor(this.ffK);
            this.ffM.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.ffK);
        setTextNormalColor(this.ffM);
    }

    public void btO() {
        bx(this.ffJ);
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
        if (this.ffN != null) {
            if (!this.ffQ || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.ffQ || bh.checkUpIsLogin(getContext())) {
                    if (view != this.ffK || this.fgc) {
                        if (view.getId() == this.ffJ.getId() || (this.fgc && view.getId() == this.ffK.getId())) {
                            this.ffJ.cancelAnimation();
                            if (this.ffS != null) {
                                this.ffS.type = 1;
                            }
                            if (this.ffN.hasAgree) {
                                if (this.ffN.agreeType == 2) {
                                    this.ffN.agreeType = 2;
                                    this.ffN.hasAgree = false;
                                    this.ffN.agreeNum--;
                                    updateUI();
                                    if (this.ffS != null) {
                                        this.ffS.eNE = 1;
                                    }
                                } else {
                                    this.ffN.agreeType = 2;
                                    this.ffN.hasAgree = true;
                                    this.ffN.agreeNum++;
                                    jU(true);
                                    com.baidu.tieba.o.a.dDg().J(getTbPageContext());
                                    if (this.ffS != null) {
                                        this.ffS.eNE = 0;
                                        i2 = 0;
                                    }
                                }
                                bR = com.baidu.tbadk.pageExtra.d.bR(this);
                                if (bR != null) {
                                    this.ffN.objSource = bR.getCurrentPageKey();
                                }
                                this.fge.a(this.ffN, i2, getPageId(), this.ffQ);
                            } else {
                                this.ffN.agreeType = 2;
                                this.ffN.hasAgree = true;
                                this.ffN.agreeNum++;
                                jU(true);
                                com.baidu.tieba.o.a.dDg().J(getTbPageContext());
                                if (this.ffS != null) {
                                    this.ffS.eNE = 0;
                                }
                            }
                            i2 = 0;
                            bR = com.baidu.tbadk.pageExtra.d.bR(this);
                            if (bR != null) {
                            }
                            this.fge.a(this.ffN, i2, getPageId(), this.ffQ);
                        } else if (view.getId() == this.ffL.getId()) {
                            this.ffL.cancelAnimation();
                            if (this.ffS != null) {
                                this.ffS.type = 2;
                            }
                            if (this.ffN.hasAgree) {
                                if (this.ffN.agreeType == 5) {
                                    this.ffN.agreeType = 5;
                                    this.ffN.hasAgree = false;
                                    updateUI();
                                    if (this.ffS != null) {
                                        this.ffS.eNI = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.ffN.agreeType = 5;
                                    this.ffN.hasAgree = true;
                                    this.ffN.agreeNum--;
                                    jU(false);
                                    if (this.ffS != null) {
                                        this.ffS.eNI = 1;
                                    }
                                }
                            } else {
                                this.ffN.agreeType = 5;
                                this.ffN.hasAgree = true;
                                jU(false);
                                if (this.ffS != null) {
                                    this.ffS.eNI = 1;
                                }
                            }
                            com.baidu.tbadk.pageExtra.c bR2 = com.baidu.tbadk.pageExtra.d.bR(this);
                            if (bR2 != null) {
                                this.ffN.objSource = bR2.getCurrentPageKey();
                            }
                            this.fge.a(this.ffN, i, getPageId(), this.ffQ);
                        }
                        this.fge.a(this.ffN, this.ffO);
                        if (this.alm != null) {
                            this.alm.onClick(view);
                        }
                        btP();
                    }
                }
            }
        }
    }

    public void btP() {
        if (this.ffS != null && this.ffN != null) {
            int i = 0;
            if (this.ffN.baijiahaoData != null) {
                i = this.ffN.baijiahaoData.oriUgcType;
            }
            if (this.ffS.type == 1) {
                if (StringUtils.isNull(this.ffX)) {
                    ar dR = new ar("c12003").aq("obj_locate", this.ffS.eNB).aq("obj_param1", this.ffS.eNC).aq("obj_source", this.ffS.eND).aq("obj_id", this.ffS.eNE).aq("obj_name", i).dR("post_id", this.ffN.postId);
                    if (this.eLr != null) {
                        dR.dR("tid", this.eLr.getId()).dR(IntentConfig.NID, this.eLr.bmq()).v("fid", this.eLr.getFid()).aq(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.eLr.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.eLr.mRecomSource).dR("weight", this.eLr.mRecomWeight).dR("extra", this.eLr.mRecomExtra);
                        if (this.eLr.getBaijiahaoData() != null) {
                            dR.dR("obj_param4", this.eLr.getBaijiahaoData().oriUgcNid);
                            if (this.eLr.bmA() || this.eLr.bpQ()) {
                                dR.dR("obj_param6", this.eLr.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.eLr.bpO()) {
                            dR.aq("obj_param5", 2);
                        } else if (this.eLr.bmz() || this.eLr.bmA()) {
                            dR.aq("obj_param5", 3);
                        } else if (this.eLr.threadType == 0 || this.eLr.threadType == 40) {
                            dR.aq("obj_param5", 1);
                        }
                    } else {
                        dR.dR("tid", this.ffN.threadId);
                        dR.dR(IntentConfig.NID, this.ffN.nid);
                        dR.dR("fid", this.ffN.forumId);
                        dR.aq(IntentConfig.CARD_TYPE, this.ffN.cardType);
                        dR.dR("ab_tag", this.ffN.recomAbTag);
                        dR.dR(IntentConfig.RECOM_SOURCE, this.ffN.recomSource);
                        dR.dR("weight", this.ffN.recomWeight);
                        dR.dR("extra", this.ffN.recomExtra);
                        if (this.ffN.baijiahaoData != null) {
                            dR.dR("obj_param6", this.ffN.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (pi(this.ffS.eNB) && pj(this.ffS.eNF) != -1) {
                        dR.aq(TiebaInitialize.Params.OBJ_TO, pj(this.ffS.eNF));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.aq("resource_id", this.ffT);
                    } else if (this.mFrom == 18) {
                        dR.dR("obj_tab", "a099");
                        dR.dR("resource_id", this.mTabName);
                    } else {
                        dR.aq("resource_id", this.ffT);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dR);
                    }
                    if (this.ffN.isFromImageViewer) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.ffN.mImageViewerFromPage == "index") {
                            dR.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.ffN.keyFromHomePage)) {
                        dR.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(this);
                    if (bR != null) {
                        dR.dR("obj_cur_page", bR.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
                        dR.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
                    }
                    TiebaStatic.log(dR);
                    return;
                }
                TiebaStatic.log(new ar("c13358").dR("tid", this.ffN.threadId).dR("topic_id", this.ffX));
            } else if (this.ffS.type == 2) {
                ar dR2 = new ar("c13271").aq("obj_type", this.ffS.eNG).aq("obj_locate", this.ffS.eNH).aq(TiebaInitialize.Params.OBJ_PARAM2, this.ffT).aq("obj_id", this.ffS.eNI).aq("obj_name", i).dR("post_id", this.ffN.postId).dR(IntentConfig.NID, this.ffN.nid);
                if (this.eLr != null) {
                    dR2.dR("tid", this.eLr.getId()).dR(IntentConfig.NID, this.eLr.bmq()).v("fid", this.eLr.getFid()).aq(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.eLr.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.eLr.mRecomSource).dR("weight", this.eLr.mRecomWeight).dR("extra", this.eLr.mRecomExtra);
                    if (this.eLr.getBaijiahaoData() != null) {
                        dR2.dR("obj_param4", this.eLr.getBaijiahaoData().oriUgcNid);
                        if (this.eLr.bmA() || this.eLr.bpQ()) {
                            dR2.dR("obj_param6", this.eLr.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.eLr.bpO()) {
                        dR2.aq("obj_param5", 2);
                    } else if (this.eLr.bmz() || this.eLr.bmA()) {
                        dR2.aq("obj_param5", 3);
                    } else if (this.eLr.threadType == 0 || this.eLr.threadType == 40) {
                        dR2.aq("obj_param5", 1);
                    }
                } else {
                    dR2.dR("tid", this.ffN.threadId);
                    dR2.dR(IntentConfig.NID, this.ffN.nid);
                    dR2.dR("fid", this.ffN.forumId);
                    dR2.aq(IntentConfig.CARD_TYPE, this.ffN.cardType);
                    dR2.dR("ab_tag", this.ffN.recomAbTag);
                    dR2.dR(IntentConfig.RECOM_SOURCE, this.ffN.recomSource);
                    dR2.dR("weight", this.ffN.recomWeight);
                    dR2.dR("extra", this.ffN.recomExtra);
                    if (this.ffN.baijiahaoData != null) {
                        dR2.dR("obj_param6", this.ffN.baijiahaoData.oriUgcVid);
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
                if (this.ffN.isFromImageViewer) {
                    dR2.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.ffN.mImageViewerFromPage == "index") {
                        dR2.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public static boolean pi(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int pj(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.ffP == null) {
            this.ffP = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.ffP.setDuration(200L);
        }
        return this.ffP;
    }

    public void onChangeSkinType(int i) {
        if (this.ffN != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.ffJ, this.ffU);
            ap.a(this.ffL, this.ffV);
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
        this.ffS = eVar;
    }

    public void setGameId(int i) {
        this.ffT = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.ffL.setVisibility(z ? 8 : 0);
        this.ffM.setVisibility(z ? 8 : 0);
        if (z && this.ffZ != null) {
            this.ffZ.setVisibility(8);
        }
        if (this.fgb != z && this.fgd != null) {
            this.fgd.f(this.ffL, z);
        }
        this.fgb = z;
    }

    public void setDisagreeShow(boolean z) {
        this.ffL.setVisibility(z ? 8 : 0);
        this.ffM.setVisibility(z ? 8 : 0);
        if (this.ffZ != null) {
            this.ffZ.setVisibility(z ? 8 : 0);
        }
        this.fgb = z;
    }

    public boolean btQ() {
        return this.fgb;
    }

    public void setThreadData(cb cbVar) {
        this.eLr = cbVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.ffU = i;
        this.ffV = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.ffW = i;
        setTextNormalColor(this.ffK);
        setTextNormalColor(this.ffM);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.fgd = aVar;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.ffL;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.ffJ;
    }
}
