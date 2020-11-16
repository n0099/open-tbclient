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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes20.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener aju;
    private int cardType;
    private TBLottieAnimationView ePN;
    private TextView ePO;
    private TBLottieAnimationView ePP;
    private TextView ePQ;
    private AgreeData ePR;
    private com.baidu.tieba.tbadkCore.data.e ePS;
    private ScaleAnimation ePT;
    private boolean ePU;
    private boolean ePV;
    private com.baidu.tbadk.core.data.d ePW;
    private int ePX;
    private int ePY;
    private int ePZ;
    private int eQa;
    private String eQb;
    public View.OnClickListener eQc;
    private LinearLayout eQd;
    private LinearLayout eQe;
    private boolean eQf;
    private boolean eQg;
    private a eQh;
    private com.baidu.tbadk.core.message.a eQi;
    private CustomMessageListener eQj;
    private bx evQ;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes20.dex */
    public interface a {
        void g(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.ePR != null) {
            this.ePR.agreeType = agreeData.agreeType;
            this.ePR.hasAgree = agreeData.hasAgree;
            this.ePR.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ePY = R.raw.lottie_agree;
        this.ePZ = R.raw.lottie_disagree;
        this.eQa = R.color.CAM_X0107;
        this.cardType = 1;
        this.eQf = false;
        this.eQg = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ePR != null && agreeData != null && AgreeView.this.ePS != null && !AgreeView.this.ePR.isInPost && AgreeView.this.ePS.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ePR.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ePR.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ePR.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eQj = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ePR != null && !TextUtils.isEmpty(AgreeView.this.ePR.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ePR.postId.equals(agreeData.postId) && !AgreeView.this.ePR.isInThread) {
                        if (AgreeView.this.ePU) {
                            if (AgreeView.this.ePR.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ePS.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bp(view);
                if (AgreeView.this.eQc != null) {
                    AgreeView.this.eQc.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ePY = R.raw.lottie_agree;
        this.ePZ = R.raw.lottie_disagree;
        this.eQa = R.color.CAM_X0107;
        this.cardType = 1;
        this.eQf = false;
        this.eQg = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ePR != null && agreeData != null && AgreeView.this.ePS != null && !AgreeView.this.ePR.isInPost && AgreeView.this.ePS.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ePR.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ePR.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ePR.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eQj = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ePR != null && !TextUtils.isEmpty(AgreeView.this.ePR.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ePR.postId.equals(agreeData.postId) && !AgreeView.this.ePR.isInThread) {
                        if (AgreeView.this.ePU) {
                            if (AgreeView.this.ePR.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ePS.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bp(view);
                if (AgreeView.this.eQc != null) {
                    AgreeView.this.eQc.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ePY = R.raw.lottie_agree;
        this.ePZ = R.raw.lottie_disagree;
        this.eQa = R.color.CAM_X0107;
        this.cardType = 1;
        this.eQf = false;
        this.eQg = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ePR != null && agreeData != null && AgreeView.this.ePS != null && !AgreeView.this.ePR.isInPost && AgreeView.this.ePS.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.ePR.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.ePR.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.ePR.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eQj = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.ePR != null && !TextUtils.isEmpty(AgreeView.this.ePR.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.ePR.postId.equals(agreeData.postId) && !AgreeView.this.ePR.isInThread) {
                        if (AgreeView.this.ePU) {
                            if (AgreeView.this.ePR.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.ePS.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bp(view);
                if (AgreeView.this.eQc != null) {
                    AgreeView.this.eQc.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.ePN = new TBLottieAnimationView(context);
        this.ePN.setId(R.id.img_agree);
        this.ePN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ePN.setOnClickListener(this.mOnClickListener);
        this.ePN.addAnimatorListener(this);
        this.ePO = new TextView(context);
        this.ePO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ePO.setOnClickListener(this.mOnClickListener);
        this.ePP = new TBLottieAnimationView(context);
        this.ePP.setId(R.id.img_disagree);
        this.ePP.addAnimatorListener(this);
        this.ePP.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ePP.setOnClickListener(this.mOnClickListener);
        this.ePQ = new TextView(context);
        this.ePQ.setText(R.string.c_disagree);
        this.ePQ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.ePQ.setOnClickListener(this.mOnClickListener);
        this.ePS = new com.baidu.tieba.tbadkCore.data.e();
        this.ePS.uniqueId = getPageId();
        this.eQi = new com.baidu.tbadk.core.message.a();
        brp();
        setAgreeAnimationResource();
    }

    private void brp() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eQe = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.ePN);
        linearLayout.addView(this.ePO);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.eQd = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.ePP);
        linearLayout2.addView(this.ePQ);
        ji(false);
    }

    private void t(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.eQe.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        layoutParams.weight = i3;
        this.eQe.setLayoutParams(layoutParams);
        this.ePN.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.ePO.setLayoutParams(layoutParams2);
        this.eQd.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = i3;
        this.eQd.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.ePP.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.ePQ.setLayoutParams(layoutParams5);
    }

    public void ji(boolean z) {
        if (z) {
            t(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.eQf);
            return;
        }
        t(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.eQf);
    }

    public void brq() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ePN.setLayoutParams(layoutParams);
        this.ePO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.ePO.setLayoutParams(layoutParams2);
        this.ePP.setVisibility(8);
        this.ePQ.setVisibility(8);
    }

    public void jj(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.ePN.setLayoutParams(layoutParams);
        this.ePO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.ePO.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.eQg = true;
        } else {
            layoutParams2.leftMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds22);
        }
        layoutParams2.gravity = 16;
        this.ePO.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        if (!z) {
            layoutParams3.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds28);
        }
        this.ePP.setLayoutParams(layoutParams3);
        this.ePQ.setVisibility(8);
    }

    public void brr() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds120);
        removeAllViews();
        bo(this.ePN);
        bo(this.ePP);
        bo(this.ePO);
        bo(this.ePQ);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.ePN, new LinearLayout.LayoutParams(dimens, dimens));
        this.ePO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds16);
        linearLayout.addView(this.ePO, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.eQd = linearLayout2;
        linearLayout2.addView(this.ePP, new LinearLayout.LayoutParams(dimens, dimens));
        this.ePQ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        linearLayout2.addView(this.ePQ, layoutParams4);
    }

    private void bo(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eQj);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eQj);
    }

    public void setTopicId(String str) {
        this.eQb = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.ePU = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.ePV = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.ePN;
    }

    public TextView getAgreeNumView() {
        return this.ePO;
    }

    public TextView getDisagreeNumView() {
        return this.ePQ;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.ePP;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.ePR = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.ePR;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.ePN, this.ePY);
        ap.a(this.ePP, this.ePZ);
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
        this.ePO.setText(b(this.ePR));
        if (this.ePR.hasAgree) {
            if (this.ePR.agreeType == 2) {
                this.ePP.setProgress(0.0f);
                this.ePN.setProgress(1.0f);
                this.ePO.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.ePQ);
                return;
            }
            this.ePN.setProgress(0.0f);
            this.ePP.setProgress(1.0f);
            setTextNormalColor(this.ePO);
            this.ePQ.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        this.ePN.setProgress(0.0f);
        this.ePP.setProgress(0.0f);
        setTextNormalColor(this.ePO);
        setTextNormalColor(this.ePQ);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.ePV) {
            textView.setTextColor(ap.getColor(R.color.CAM_X0107));
        } else if (this.ePU) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(ap.getColor(this.eQa));
        }
    }

    public void jk(boolean z) {
        this.ePN.setMinAndMaxProgress(0.0f, 1.0f);
        this.ePP.setMinAndMaxProgress(0.0f, 1.0f);
        this.ePO.setText(b(this.ePR));
        this.ePN.clearColorFilter();
        this.ePP.clearColorFilter();
        if (z) {
            this.ePN.playAnimation();
            this.ePP.cancelAnimation();
            this.ePP.setFrame(0);
        } else {
            this.ePP.playAnimation();
            this.ePN.cancelAnimation();
            this.ePN.setFrame(0);
        }
        if (this.ePR.hasAgree) {
            if (this.ePR.agreeType == 2) {
                this.ePO.setTextColor(ap.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.ePQ);
                return;
            }
            setTextNormalColor(this.ePO);
            this.ePQ.setTextColor(ap.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.ePO);
        setTextNormalColor(this.ePQ);
    }

    public void brs() {
        bp(this.ePN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(View view) {
        int i = 0;
        int i2 = 1;
        if (this.ePR != null) {
            if (!this.ePU || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.ePU || bh.checkUpIsLogin(getContext())) {
                    if (view != this.ePO || this.eQg) {
                        if (view.getId() == this.ePN.getId() || (this.eQg && view.getId() == this.ePO.getId())) {
                            this.ePN.cancelAnimation();
                            if (this.ePW != null) {
                                this.ePW.type = 1;
                            }
                            if (this.ePR.hasAgree) {
                                if (this.ePR.agreeType == 2) {
                                    this.ePR.agreeType = 2;
                                    this.ePR.hasAgree = false;
                                    this.ePR.agreeNum--;
                                    updateUI();
                                    if (this.ePW != null) {
                                        this.ePW.exL = 1;
                                    }
                                } else {
                                    this.ePR.agreeType = 2;
                                    this.ePR.hasAgree = true;
                                    this.ePR.agreeNum++;
                                    jk(true);
                                    com.baidu.tieba.p.a.dzt().G(getTbPageContext());
                                    if (this.ePW != null) {
                                        this.ePW.exL = 0;
                                        i2 = 0;
                                    }
                                }
                                this.eQi.a(this.ePR, i2, getPageId(), this.ePU);
                            } else {
                                this.ePR.agreeType = 2;
                                this.ePR.hasAgree = true;
                                this.ePR.agreeNum++;
                                jk(true);
                                com.baidu.tieba.p.a.dzt().G(getTbPageContext());
                                if (this.ePW != null) {
                                    this.ePW.exL = 0;
                                }
                            }
                            i2 = 0;
                            this.eQi.a(this.ePR, i2, getPageId(), this.ePU);
                        } else if (view.getId() == this.ePP.getId()) {
                            this.ePP.cancelAnimation();
                            if (this.ePW != null) {
                                this.ePW.type = 2;
                            }
                            if (this.ePR.hasAgree) {
                                if (this.ePR.agreeType == 5) {
                                    this.ePR.agreeType = 5;
                                    this.ePR.hasAgree = false;
                                    updateUI();
                                    if (this.ePW != null) {
                                        this.ePW.exP = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.ePR.agreeType = 5;
                                    this.ePR.hasAgree = true;
                                    this.ePR.agreeNum--;
                                    jk(false);
                                    if (this.ePW != null) {
                                        this.ePW.exP = 1;
                                    }
                                }
                            } else {
                                this.ePR.agreeType = 5;
                                this.ePR.hasAgree = true;
                                jk(false);
                                if (this.ePW != null) {
                                    this.ePW.exP = 1;
                                }
                            }
                            this.eQi.a(this.ePR, i, getPageId(), this.ePU);
                        }
                        this.eQi.a(this.ePR, this.ePS);
                        if (this.aju != null) {
                            this.aju.onClick(view);
                        }
                        brt();
                    }
                }
            }
        }
    }

    public void brt() {
        if (this.ePW != null && this.ePR != null) {
            int i = 0;
            if (this.ePR.baijiahaoData != null) {
                i = this.ePR.baijiahaoData.oriUgcType;
            }
            if (this.ePW.type == 1) {
                if (StringUtils.isNull(this.eQb)) {
                    ar dR = new ar("c12003").ak("obj_locate", this.ePW.exI).ak("obj_param1", this.ePW.exJ).ak("obj_source", this.ePW.exK).ak("obj_id", this.ePW.exL).ak("obj_name", i).dR("post_id", this.ePR.postId);
                    if (this.evQ != null) {
                        dR.dR("tid", this.evQ.getId()).dR("nid", this.evQ.getNid()).w("fid", this.evQ.getFid()).ak(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.evQ.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.evQ.mRecomSource).dR("weight", this.evQ.mRecomWeight).dR("extra", this.evQ.mRecomExtra);
                        if (this.evQ.getBaijiahaoData() != null) {
                            dR.dR("obj_param4", this.evQ.getBaijiahaoData().oriUgcNid);
                            if (this.evQ.bkl() || this.evQ.bnA()) {
                                dR.dR("obj_param6", this.evQ.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.evQ.bny()) {
                            dR.ak("obj_param5", 2);
                        } else if (this.evQ.bkk() || this.evQ.bkl()) {
                            dR.ak("obj_param5", 3);
                        } else if (this.evQ.threadType == 0 || this.evQ.threadType == 40) {
                            dR.ak("obj_param5", 1);
                        }
                    } else {
                        dR.dR("tid", this.ePR.threadId);
                        dR.dR("nid", this.ePR.nid);
                        dR.dR("fid", this.ePR.forumId);
                        dR.ak(IntentConfig.CARD_TYPE, this.ePR.cardType);
                        dR.dR("ab_tag", this.ePR.recomAbTag);
                        dR.dR(IntentConfig.RECOM_SOURCE, this.ePR.recomSource);
                        dR.dR("weight", this.ePR.recomWeight);
                        dR.dR("extra", this.ePR.recomExtra);
                        if (this.ePR.baijiahaoData != null) {
                            dR.dR("obj_param6", this.ePR.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (pY(this.ePW.exI) && pZ(this.ePW.exM) != -1) {
                        dR.ak(TiebaInitialize.Params.OBJ_TO, pZ(this.ePW.exM));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.ak("resource_id", this.ePX);
                    } else if (this.mFrom == 18) {
                        dR.dR("obj_tab", "a099");
                        dR.dR("resource_id", this.mTabName);
                    } else {
                        dR.ak("resource_id", this.ePX);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dR);
                    }
                    if (this.ePR.isFromImageViewer) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.ePR.mImageViewerFromPage == "index") {
                            dR.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.ePR.keyFromHomePage)) {
                        dR.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    TiebaStatic.log(dR);
                    return;
                }
                TiebaStatic.log(new ar("c13358").dR("tid", this.ePR.threadId).dR("topic_id", this.eQb));
            } else if (this.ePW.type == 2) {
                ar dR2 = new ar("c13271").ak("obj_type", this.ePW.exN).ak("obj_locate", this.ePW.exO).ak(TiebaInitialize.Params.OBJ_PARAM2, this.ePX).ak("obj_id", this.ePW.exP).ak("obj_name", i).dR("post_id", this.ePR.postId).dR("nid", this.ePR.nid);
                if (this.evQ != null) {
                    dR2.dR("tid", this.evQ.getId()).dR("nid", this.evQ.getNid()).w("fid", this.evQ.getFid()).ak(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.evQ.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.evQ.mRecomSource).dR("weight", this.evQ.mRecomWeight).dR("extra", this.evQ.mRecomExtra);
                    if (this.evQ.getBaijiahaoData() != null) {
                        dR2.dR("obj_param4", this.evQ.getBaijiahaoData().oriUgcNid);
                        if (this.evQ.bkl() || this.evQ.bnA()) {
                            dR2.dR("obj_param6", this.evQ.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.evQ.bny()) {
                        dR2.ak("obj_param5", 2);
                    } else if (this.evQ.bkk() || this.evQ.bkl()) {
                        dR2.ak("obj_param5", 3);
                    } else if (this.evQ.threadType == 0 || this.evQ.threadType == 40) {
                        dR2.ak("obj_param5", 1);
                    }
                } else {
                    dR2.dR("tid", this.ePR.threadId);
                    dR2.dR("nid", this.ePR.nid);
                    dR2.dR("fid", this.ePR.forumId);
                    dR2.ak(IntentConfig.CARD_TYPE, this.ePR.cardType);
                    dR2.dR("ab_tag", this.ePR.recomAbTag);
                    dR2.dR(IntentConfig.RECOM_SOURCE, this.ePR.recomSource);
                    dR2.dR("weight", this.ePR.recomWeight);
                    dR2.dR("extra", this.ePR.recomExtra);
                    if (this.ePR.baijiahaoData != null) {
                        dR2.dR("obj_param6", this.ePR.baijiahaoData.oriUgcVid);
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
                if (this.ePR.isFromImageViewer) {
                    dR2.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.ePR.mImageViewerFromPage == "index") {
                        dR2.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public static boolean pY(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int pZ(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.ePT == null) {
            this.ePT = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.ePT.setDuration(200L);
        }
        return this.ePT;
    }

    public void onChangeSkinType(int i) {
        if (this.ePR != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.ePN, this.ePY);
            ap.a(this.ePP, this.ePZ);
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
        this.ePW = dVar;
    }

    public void setGameId(int i) {
        this.ePX = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.ePP.setVisibility(z ? 8 : 0);
        this.ePQ.setVisibility(z ? 8 : 0);
        if (z && this.eQd != null) {
            this.eQd.setVisibility(8);
        }
        if (this.eQf != z && this.eQh != null) {
            this.eQh.g(this.ePP, z);
        }
        this.eQf = z;
    }

    public void setDisagreeShow(boolean z) {
        this.ePP.setVisibility(z ? 8 : 0);
        this.ePQ.setVisibility(z ? 8 : 0);
        if (this.eQd != null) {
            this.eQd.setVisibility(z ? 8 : 0);
        }
        this.eQf = z;
    }

    public boolean bru() {
        return this.eQf;
    }

    public void setThreadData(bx bxVar) {
        this.evQ = bxVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.ePY = i;
        this.ePZ = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.eQa = i;
        setTextNormalColor(this.ePO);
        setTextNormalColor(this.ePQ);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aju = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.eQh = aVar;
    }
}
