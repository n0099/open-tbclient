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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener ake;
    private int cardType;
    private bz eHK;
    private TBLottieAnimationView fbU;
    private TextView fbV;
    private TBLottieAnimationView fbW;
    private TextView fbX;
    private AgreeData fbY;
    private com.baidu.tieba.tbadkCore.data.e fbZ;
    private ScaleAnimation fca;
    private boolean fcb;
    private boolean fcc;
    private com.baidu.tbadk.core.data.d fcd;
    private int fce;
    private int fcf;
    private int fcg;
    private int fch;
    private String fci;
    public View.OnClickListener fcj;
    private LinearLayout fck;
    private LinearLayout fcl;
    private boolean fcm;
    private boolean fcn;
    private a fco;
    private com.baidu.tbadk.core.message.a fcq;
    private CustomMessageListener fcr;
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
        if (agreeData != null && this.fbY != null) {
            this.fbY.agreeType = agreeData.agreeType;
            this.fbY.hasAgree = agreeData.hasAgree;
            this.fbY.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fcf = R.raw.lottie_agree;
        this.fcg = R.raw.lottie_disagree;
        this.fch = R.color.CAM_X0107;
        this.cardType = 1;
        this.fcm = false;
        this.fcn = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fbY != null && agreeData != null && AgreeView.this.fbZ != null && !AgreeView.this.fbY.isInPost && AgreeView.this.fbZ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.fbY.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.fbY.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.fbY.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fcr = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fbY != null && !TextUtils.isEmpty(AgreeView.this.fbY.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.fbY.postId.equals(agreeData.postId) && !AgreeView.this.fbY.isInThread) {
                        if (AgreeView.this.fcb) {
                            if (AgreeView.this.fbY.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.fbZ.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eHK == null || AgreeView.this.eHK.getType() != bz.eOR) {
                    AgreeView.this.bB(view);
                    if (AgreeView.this.fcj != null) {
                        AgreeView.this.fcj.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fcf = R.raw.lottie_agree;
        this.fcg = R.raw.lottie_disagree;
        this.fch = R.color.CAM_X0107;
        this.cardType = 1;
        this.fcm = false;
        this.fcn = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fbY != null && agreeData != null && AgreeView.this.fbZ != null && !AgreeView.this.fbY.isInPost && AgreeView.this.fbZ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.fbY.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.fbY.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.fbY.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fcr = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fbY != null && !TextUtils.isEmpty(AgreeView.this.fbY.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.fbY.postId.equals(agreeData.postId) && !AgreeView.this.fbY.isInThread) {
                        if (AgreeView.this.fcb) {
                            if (AgreeView.this.fbY.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.fbZ.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eHK == null || AgreeView.this.eHK.getType() != bz.eOR) {
                    AgreeView.this.bB(view);
                    if (AgreeView.this.fcj != null) {
                        AgreeView.this.fcj.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fcf = R.raw.lottie_agree;
        this.fcg = R.raw.lottie_disagree;
        this.fch = R.color.CAM_X0107;
        this.cardType = 1;
        this.fcm = false;
        this.fcn = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fbY != null && agreeData != null && AgreeView.this.fbZ != null && !AgreeView.this.fbY.isInPost && AgreeView.this.fbZ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.fbY.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.fbY.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.fbY.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.fcr = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.fbY != null && !TextUtils.isEmpty(AgreeView.this.fbY.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.fbY.postId.equals(agreeData.postId) && !AgreeView.this.fbY.isInThread) {
                        if (AgreeView.this.fcb) {
                            if (AgreeView.this.fbY.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.fbZ.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eHK == null || AgreeView.this.eHK.getType() != bz.eOR) {
                    AgreeView.this.bB(view);
                    if (AgreeView.this.fcj != null) {
                        AgreeView.this.fcj.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.fbU = new TBLottieAnimationView(context);
        this.fbU.setId(R.id.img_agree);
        this.fbU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fbU.setOnClickListener(this.mOnClickListener);
        this.fbU.addAnimatorListener(this);
        this.fbV = new TextView(context);
        this.fbV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.fbV.setOnClickListener(this.mOnClickListener);
        this.fbW = new TBLottieAnimationView(context);
        this.fbW.setId(R.id.img_disagree);
        this.fbW.addAnimatorListener(this);
        this.fbW.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fbW.setOnClickListener(this.mOnClickListener);
        this.fbX = new TextView(context);
        this.fbX.setText(R.string.c_disagree);
        this.fbX.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.fbX.setOnClickListener(this.mOnClickListener);
        this.fbZ = new com.baidu.tieba.tbadkCore.data.e();
        this.fbZ.uniqueId = getPageId();
        this.fcq = new com.baidu.tbadk.core.message.a();
        bto();
        setAgreeAnimationResource();
    }

    private void bto() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.fcl = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.fbU);
        linearLayout.addView(this.fbV);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.fck = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.fbW);
        linearLayout2.addView(this.fbX);
        jP(false);
    }

    private void y(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.fcl.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.fcl.setLayoutParams(layoutParams);
        this.fbU.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.fbV.setLayoutParams(layoutParams2);
        this.fck.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.fck.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.fbW.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.fbX.setLayoutParams(layoutParams5);
    }

    public void jP(boolean z) {
        if (z) {
            y(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.fcm);
            return;
        }
        y(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.fcm);
    }

    public void btp() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.fbU.setLayoutParams(layoutParams);
        this.fbV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.fbV.setLayoutParams(layoutParams2);
        this.fbW.setVisibility(8);
        this.fbX.setVisibility(8);
    }

    public void jQ(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.fbU.setLayoutParams(layoutParams);
        this.fbV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.fbV.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.fcn = true;
        } else {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22);
        }
        layoutParams2.gravity = 16;
        this.fbV.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        if (!z) {
            layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds28);
        }
        this.fbW.setLayoutParams(layoutParams3);
        this.fbX.setVisibility(8);
    }

    public void btq() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        removeAllViews();
        bA(this.fbU);
        bA(this.fbW);
        bA(this.fbV);
        bA(this.fbX);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.fbU, new LinearLayout.LayoutParams(dimens, dimens));
        this.fbV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        linearLayout.addView(this.fbV, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.fck = linearLayout2;
        linearLayout2.addView(this.fbW, new LinearLayout.LayoutParams(dimens, dimens));
        this.fbX.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        linearLayout2.addView(this.fbX, layoutParams4);
    }

    private void bA(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.fcr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.fcr);
    }

    public void setTopicId(String str) {
        this.fci = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.fcb = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.fcc = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.fbU;
    }

    public TextView getAgreeNumView() {
        return this.fbV;
    }

    public TextView getDisagreeNumView() {
        return this.fbX;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.fbW;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.fbY = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.fbY;
    }

    public void setAgreeAnimationResource() {
        ao.a(this.fbU, this.fcf);
        ao.a(this.fbW, this.fcg);
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
        this.fbV.setText(b(this.fbY));
        if (this.fbY.hasAgree) {
            if (this.fbY.agreeType == 2) {
                this.fbW.setProgress(0.0f);
                this.fbU.setProgress(1.0f);
                this.fbV.setTextColor(ao.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fbX);
                return;
            }
            this.fbU.setProgress(0.0f);
            this.fbW.setProgress(1.0f);
            setTextNormalColor(this.fbV);
            this.fbX.setTextColor(ao.getColor(R.color.CAM_X0107));
            return;
        }
        this.fbU.setProgress(0.0f);
        this.fbW.setProgress(0.0f);
        setTextNormalColor(this.fbV);
        setTextNormalColor(this.fbX);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.fcc) {
            textView.setTextColor(ao.getColor(R.color.CAM_X0107));
        } else if (this.fcb) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ao.getColor(this.fch));
        }
    }

    public void jR(boolean z) {
        this.fbU.setMinAndMaxProgress(0.0f, 1.0f);
        this.fbW.setMinAndMaxProgress(0.0f, 1.0f);
        this.fbV.setText(b(this.fbY));
        this.fbU.clearColorFilter();
        this.fbW.clearColorFilter();
        if (z) {
            this.fbU.playAnimation();
            this.fbW.cancelAnimation();
            this.fbW.setFrame(0);
        } else {
            this.fbW.playAnimation();
            this.fbU.cancelAnimation();
            this.fbU.setFrame(0);
        }
        if (this.fbY.hasAgree) {
            if (this.fbY.agreeType == 2) {
                this.fbV.setTextColor(ao.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.fbX);
                return;
            }
            setTextNormalColor(this.fbV);
            this.fbX.setTextColor(ao.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.fbV);
        setTextNormalColor(this.fbX);
    }

    public void btr() {
        bB(this.fbU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bB(View view) {
        com.baidu.tbadk.pageExtra.c bV;
        int i = 0;
        int i2 = 1;
        if (this.fbY != null) {
            if (!this.fcb || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.fcb || bg.checkUpIsLogin(getContext())) {
                    if (view != this.fbV || this.fcn) {
                        if (view.getId() == this.fbU.getId() || (this.fcn && view.getId() == this.fbV.getId())) {
                            this.fbU.cancelAnimation();
                            if (this.fcd != null) {
                                this.fcd.type = 1;
                            }
                            if (this.fbY.hasAgree) {
                                if (this.fbY.agreeType == 2) {
                                    this.fbY.agreeType = 2;
                                    this.fbY.hasAgree = false;
                                    this.fbY.agreeNum--;
                                    updateUI();
                                    if (this.fcd != null) {
                                        this.fcd.eJR = 1;
                                    }
                                } else {
                                    this.fbY.agreeType = 2;
                                    this.fbY.hasAgree = true;
                                    this.fbY.agreeNum++;
                                    jR(true);
                                    com.baidu.tieba.o.a.dAJ().F(getTbPageContext());
                                    if (this.fcd != null) {
                                        this.fcd.eJR = 0;
                                        i2 = 0;
                                    }
                                }
                                bV = com.baidu.tbadk.pageExtra.d.bV(this);
                                if (bV != null) {
                                    this.fbY.objSource = bV.getCurrentPageKey();
                                }
                                this.fcq.a(this.fbY, i2, getPageId(), this.fcb);
                            } else {
                                this.fbY.agreeType = 2;
                                this.fbY.hasAgree = true;
                                this.fbY.agreeNum++;
                                jR(true);
                                com.baidu.tieba.o.a.dAJ().F(getTbPageContext());
                                if (this.fcd != null) {
                                    this.fcd.eJR = 0;
                                }
                            }
                            i2 = 0;
                            bV = com.baidu.tbadk.pageExtra.d.bV(this);
                            if (bV != null) {
                            }
                            this.fcq.a(this.fbY, i2, getPageId(), this.fcb);
                        } else if (view.getId() == this.fbW.getId()) {
                            this.fbW.cancelAnimation();
                            if (this.fcd != null) {
                                this.fcd.type = 2;
                            }
                            if (this.fbY.hasAgree) {
                                if (this.fbY.agreeType == 5) {
                                    this.fbY.agreeType = 5;
                                    this.fbY.hasAgree = false;
                                    updateUI();
                                    if (this.fcd != null) {
                                        this.fcd.eJV = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.fbY.agreeType = 5;
                                    this.fbY.hasAgree = true;
                                    this.fbY.agreeNum--;
                                    jR(false);
                                    if (this.fcd != null) {
                                        this.fcd.eJV = 1;
                                    }
                                }
                            } else {
                                this.fbY.agreeType = 5;
                                this.fbY.hasAgree = true;
                                jR(false);
                                if (this.fcd != null) {
                                    this.fcd.eJV = 1;
                                }
                            }
                            com.baidu.tbadk.pageExtra.c bV2 = com.baidu.tbadk.pageExtra.d.bV(this);
                            if (bV2 != null) {
                                this.fbY.objSource = bV2.getCurrentPageKey();
                            }
                            this.fcq.a(this.fbY, i, getPageId(), this.fcb);
                        }
                        this.fcq.a(this.fbY, this.fbZ);
                        if (this.ake != null) {
                            this.ake.onClick(view);
                        }
                        bts();
                    }
                }
            }
        }
    }

    public void bts() {
        if (this.fcd != null && this.fbY != null) {
            int i = 0;
            if (this.fbY.baijiahaoData != null) {
                i = this.fbY.baijiahaoData.oriUgcType;
            }
            if (this.fcd.type == 1) {
                if (StringUtils.isNull(this.fci)) {
                    aq dW = new aq("c12003").an("obj_locate", this.fcd.eJO).an("obj_param1", this.fcd.eJP).an("obj_source", this.fcd.eJQ).an("obj_id", this.fcd.eJR).an("obj_name", i).dW("post_id", this.fbY.postId);
                    if (this.eHK != null) {
                        dW.dW("tid", this.eHK.getId()).dW(IntentConfig.NID, this.eHK.blV()).w("fid", this.eHK.getFid()).an(IntentConfig.CARD_TYPE, this.cardType).dW("ab_tag", this.eHK.mRecomAbTag).dW(IntentConfig.RECOM_SOURCE, this.eHK.mRecomSource).dW("weight", this.eHK.mRecomWeight).dW("extra", this.eHK.mRecomExtra);
                        if (this.eHK.getBaijiahaoData() != null) {
                            dW.dW("obj_param4", this.eHK.getBaijiahaoData().oriUgcNid);
                            if (this.eHK.bmf() || this.eHK.bpw()) {
                                dW.dW("obj_param6", this.eHK.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.eHK.bpu()) {
                            dW.an("obj_param5", 2);
                        } else if (this.eHK.bme() || this.eHK.bmf()) {
                            dW.an("obj_param5", 3);
                        } else if (this.eHK.threadType == 0 || this.eHK.threadType == 40) {
                            dW.an("obj_param5", 1);
                        }
                    } else {
                        dW.dW("tid", this.fbY.threadId);
                        dW.dW(IntentConfig.NID, this.fbY.nid);
                        dW.dW("fid", this.fbY.forumId);
                        dW.an(IntentConfig.CARD_TYPE, this.fbY.cardType);
                        dW.dW("ab_tag", this.fbY.recomAbTag);
                        dW.dW(IntentConfig.RECOM_SOURCE, this.fbY.recomSource);
                        dW.dW("weight", this.fbY.recomWeight);
                        dW.dW("extra", this.fbY.recomExtra);
                        if (this.fbY.baijiahaoData != null) {
                            dW.dW("obj_param6", this.fbY.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (pc(this.fcd.eJO) && pd(this.fcd.eJS) != -1) {
                        dW.an(TiebaInitialize.Params.OBJ_TO, pd(this.fcd.eJS));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dW.dW("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dW.an("resource_id", this.fce);
                    } else if (this.mFrom == 18) {
                        dW.dW("obj_tab", "a099");
                        dW.dW("resource_id", this.mTabName);
                    } else {
                        dW.an("resource_id", this.fce);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dW);
                    }
                    if (this.fbY.isFromImageViewer) {
                        dW.dW("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.fbY.mImageViewerFromPage == "index") {
                            dW.dW(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.fbY.keyFromHomePage)) {
                        dW.dW("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dW.dW("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
                    if (bV != null) {
                        dW.dW("obj_cur_page", bV.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                        dW.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
                    }
                    TiebaStatic.log(dW);
                    return;
                }
                TiebaStatic.log(new aq("c13358").dW("tid", this.fbY.threadId).dW("topic_id", this.fci));
            } else if (this.fcd.type == 2) {
                aq dW2 = new aq("c13271").an("obj_type", this.fcd.eJT).an("obj_locate", this.fcd.eJU).an(TiebaInitialize.Params.OBJ_PARAM2, this.fce).an("obj_id", this.fcd.eJV).an("obj_name", i).dW("post_id", this.fbY.postId).dW(IntentConfig.NID, this.fbY.nid);
                if (this.eHK != null) {
                    dW2.dW("tid", this.eHK.getId()).dW(IntentConfig.NID, this.eHK.blV()).w("fid", this.eHK.getFid()).an(IntentConfig.CARD_TYPE, this.cardType).dW("ab_tag", this.eHK.mRecomAbTag).dW(IntentConfig.RECOM_SOURCE, this.eHK.mRecomSource).dW("weight", this.eHK.mRecomWeight).dW("extra", this.eHK.mRecomExtra);
                    if (this.eHK.getBaijiahaoData() != null) {
                        dW2.dW("obj_param4", this.eHK.getBaijiahaoData().oriUgcNid);
                        if (this.eHK.bmf() || this.eHK.bpw()) {
                            dW2.dW("obj_param6", this.eHK.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.eHK.bpu()) {
                        dW2.an("obj_param5", 2);
                    } else if (this.eHK.bme() || this.eHK.bmf()) {
                        dW2.an("obj_param5", 3);
                    } else if (this.eHK.threadType == 0 || this.eHK.threadType == 40) {
                        dW2.an("obj_param5", 1);
                    }
                } else {
                    dW2.dW("tid", this.fbY.threadId);
                    dW2.dW(IntentConfig.NID, this.fbY.nid);
                    dW2.dW("fid", this.fbY.forumId);
                    dW2.an(IntentConfig.CARD_TYPE, this.fbY.cardType);
                    dW2.dW("ab_tag", this.fbY.recomAbTag);
                    dW2.dW(IntentConfig.RECOM_SOURCE, this.fbY.recomSource);
                    dW2.dW("weight", this.fbY.recomWeight);
                    dW2.dW("extra", this.fbY.recomExtra);
                    if (this.fbY.baijiahaoData != null) {
                        dW2.dW("obj_param6", this.fbY.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dW2.dW("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dW2.dW("obj_tab", "a099");
                    dW2.dW("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dW2);
                }
                if (this.fbY.isFromImageViewer) {
                    dW2.dW("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.fbY.mImageViewerFromPage == "index") {
                        dW2.dW(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dW2);
            }
        }
    }

    public static boolean pc(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int pd(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.fca == null) {
            this.fca = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fca.setDuration(200L);
        }
        return this.fca;
    }

    public void onChangeSkinType(int i) {
        if (this.fbY != null && this.mSkinType != i) {
            this.mSkinType = i;
            ao.a(this.fbU, this.fcf);
            ao.a(this.fbW, this.fcg);
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
        this.fcd = dVar;
    }

    public void setGameId(int i) {
        this.fce = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.fbW.setVisibility(z ? 8 : 0);
        this.fbX.setVisibility(z ? 8 : 0);
        if (z && this.fck != null) {
            this.fck.setVisibility(8);
        }
        if (this.fcm != z && this.fco != null) {
            this.fco.f(this.fbW, z);
        }
        this.fcm = z;
    }

    public void setDisagreeShow(boolean z) {
        this.fbW.setVisibility(z ? 8 : 0);
        this.fbX.setVisibility(z ? 8 : 0);
        if (this.fck != null) {
            this.fck.setVisibility(z ? 8 : 0);
        }
        this.fcm = z;
    }

    public boolean btt() {
        return this.fcm;
    }

    public void setThreadData(bz bzVar) {
        this.eHK = bzVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.fcf = i;
        this.fcg = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.fch = i;
        setTextNormalColor(this.fbV);
        setTextNormalColor(this.fbX);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ake = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.fco = aVar;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.fbW;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.fbU;
    }
}
