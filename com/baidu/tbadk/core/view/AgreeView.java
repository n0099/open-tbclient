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
/* loaded from: classes21.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener ajp;
    private int cardType;
    private TBLottieAnimationView eQM;
    private TextView eQN;
    private TBLottieAnimationView eQO;
    private TextView eQP;
    private AgreeData eQQ;
    private com.baidu.tieba.tbadkCore.data.e eQR;
    private ScaleAnimation eQS;
    private boolean eQT;
    private boolean eQU;
    private com.baidu.tbadk.core.data.c eQV;
    private int eQW;
    private int eQX;
    private int eQY;
    private int eQZ;
    private String eRa;
    public View.OnClickListener eRb;
    private LinearLayout eRc;
    private LinearLayout eRd;
    private boolean eRe;
    private boolean eRf;
    private a eRg;
    private com.baidu.tbadk.core.message.a eRh;
    private CustomMessageListener eRi;
    private bw exA;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes21.dex */
    public interface a {
        void f(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.eQQ != null) {
            this.eQQ.agreeType = agreeData.agreeType;
            this.eQQ.hasAgree = agreeData.hasAgree;
            this.eQQ.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eQX = R.raw.lottie_agree;
        this.eQY = R.raw.lottie_disagree;
        this.eQZ = R.color.cp_cont_j;
        this.cardType = 1;
        this.eRe = false;
        this.eRf = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eQQ != null && agreeData != null && AgreeView.this.eQR != null && !AgreeView.this.eQQ.isInPost && AgreeView.this.eQR.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eQQ.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eQQ.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eQQ.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eRi = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eQQ != null && !TextUtils.isEmpty(AgreeView.this.eQQ.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eQQ.postId.equals(agreeData.postId) && !AgreeView.this.eQQ.isInThread) {
                        if (AgreeView.this.eQT) {
                            if (AgreeView.this.eQQ.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eQR.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bm(view);
                if (AgreeView.this.eRb != null) {
                    AgreeView.this.eRb.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eQX = R.raw.lottie_agree;
        this.eQY = R.raw.lottie_disagree;
        this.eQZ = R.color.cp_cont_j;
        this.cardType = 1;
        this.eRe = false;
        this.eRf = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eQQ != null && agreeData != null && AgreeView.this.eQR != null && !AgreeView.this.eQQ.isInPost && AgreeView.this.eQR.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eQQ.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eQQ.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eQQ.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eRi = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eQQ != null && !TextUtils.isEmpty(AgreeView.this.eQQ.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eQQ.postId.equals(agreeData.postId) && !AgreeView.this.eQQ.isInThread) {
                        if (AgreeView.this.eQT) {
                            if (AgreeView.this.eQQ.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eQR.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bm(view);
                if (AgreeView.this.eRb != null) {
                    AgreeView.this.eRb.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eQX = R.raw.lottie_agree;
        this.eQY = R.raw.lottie_disagree;
        this.eQZ = R.color.cp_cont_j;
        this.cardType = 1;
        this.eRe = false;
        this.eRf = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eQQ != null && agreeData != null && AgreeView.this.eQR != null && !AgreeView.this.eQQ.isInPost && AgreeView.this.eQR.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eQQ.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eQQ.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eQQ.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eRi = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eQQ != null && !TextUtils.isEmpty(AgreeView.this.eQQ.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eQQ.postId.equals(agreeData.postId) && !AgreeView.this.eQQ.isInThread) {
                        if (AgreeView.this.eQT) {
                            if (AgreeView.this.eQQ.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eQR.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bm(view);
                if (AgreeView.this.eRb != null) {
                    AgreeView.this.eRb.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.eQM = new TBLottieAnimationView(context);
        this.eQM.setId(R.id.img_agree);
        this.eQM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eQM.setOnClickListener(this.mOnClickListener);
        this.eQM.addAnimatorListener(this);
        this.eQN = new TextView(context);
        this.eQN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eQN.setOnClickListener(this.mOnClickListener);
        this.eQO = new TBLottieAnimationView(context);
        this.eQO.setId(R.id.img_disagree);
        this.eQO.addAnimatorListener(this);
        this.eQO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eQO.setOnClickListener(this.mOnClickListener);
        this.eQP = new TextView(context);
        this.eQP.setText(R.string.c_disagree);
        this.eQP.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eQP.setOnClickListener(this.mOnClickListener);
        this.eQR = new com.baidu.tieba.tbadkCore.data.e();
        this.eQR.uniqueId = getPageId();
        this.eRh = new com.baidu.tbadk.core.message.a();
        bsb();
        setAgreeAnimationResource();
    }

    private void bsb() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eRd = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.eQM);
        linearLayout.addView(this.eQN);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.eRc = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.eQO);
        linearLayout2.addView(this.eQP);
        jh(false);
    }

    private void s(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.eRd.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
        layoutParams.weight = i3;
        this.eRd.setLayoutParams(layoutParams);
        this.eQM.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.eQN.setLayoutParams(layoutParams2);
        this.eRc.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
        layoutParams3.weight = i3;
        this.eRc.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.eQO.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.eQP.setLayoutParams(layoutParams5);
    }

    public void jh(boolean z) {
        if (z) {
            s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), 0, 1, 17);
            setAgreeAlone(this.eRe);
            return;
        }
        s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), -2, 0, 16);
        setAgreeAlone(this.eRe);
    }

    public void bsc() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eQM.setLayoutParams(layoutParams);
        this.eQN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eQN.setLayoutParams(layoutParams2);
        this.eQO.setVisibility(8);
        this.eQP.setVisibility(8);
    }

    public void ji(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.eQM.setLayoutParams(layoutParams);
        this.eQN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = i;
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.eQN.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.eRf = true;
        }
        layoutParams2.gravity = 16;
        this.eQN.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        this.eQO.setLayoutParams(layoutParams3);
        this.eQP.setVisibility(8);
    }

    public void bsd() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        bl(this.eQM);
        bl(this.eQO);
        bl(this.eQN);
        bl(this.eQP);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.eQM, new LinearLayout.LayoutParams(dimens, dimens));
        this.eQN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.eQN, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.eRc = linearLayout2;
        linearLayout2.addView(this.eQO, new LinearLayout.LayoutParams(dimens, dimens));
        this.eQP.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.eQP, layoutParams4);
    }

    private void bl(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eRi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eRi);
    }

    public void setTopicId(String str) {
        this.eRa = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.eQT = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.eQU = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.eQM;
    }

    public TextView getAgreeNumView() {
        return this.eQN;
    }

    public TextView getDisagreeNumView() {
        return this.eQP;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.eQO;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.eQQ = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.eQQ;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.eQM, this.eQX);
        ap.a(this.eQO, this.eQY);
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
        this.eQN.setText(b(this.eQQ));
        if (this.eQQ.hasAgree) {
            if (this.eQQ.agreeType == 2) {
                this.eQO.setProgress(0.0f);
                this.eQM.setProgress(1.0f);
                this.eQN.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eQP);
                return;
            }
            this.eQM.setProgress(0.0f);
            this.eQO.setProgress(1.0f);
            setTextNormalColor(this.eQN);
            this.eQP.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.eQM.setProgress(0.0f);
        this.eQO.setProgress(0.0f);
        setTextNormalColor(this.eQN);
        setTextNormalColor(this.eQP);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.eQU) {
            textView.setTextColor(ap.getColor(R.color.cp_cont_d));
        } else if (this.eQT) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(ap.getColor(this.eQZ));
        }
    }

    public void jj(boolean z) {
        this.eQM.setMinAndMaxProgress(0.0f, 1.0f);
        this.eQO.setMinAndMaxProgress(0.0f, 1.0f);
        this.eQN.setText(b(this.eQQ));
        this.eQM.clearColorFilter();
        this.eQO.clearColorFilter();
        if (z) {
            this.eQM.playAnimation();
            this.eQO.cancelAnimation();
            this.eQO.setFrame(0);
        } else {
            this.eQO.playAnimation();
            this.eQM.cancelAnimation();
            this.eQM.setFrame(0);
        }
        if (this.eQQ.hasAgree) {
            if (this.eQQ.agreeType == 2) {
                this.eQN.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eQP);
                return;
            }
            setTextNormalColor(this.eQN);
            this.eQP.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.eQN);
        setTextNormalColor(this.eQP);
    }

    public void bse() {
        bm(this.eQM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(View view) {
        int i = 0;
        int i2 = 1;
        if (this.eQQ != null) {
            if (!this.eQT || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.eQT || bg.checkUpIsLogin(getContext())) {
                    if (view != this.eQN || this.eRf) {
                        if (view.getId() == this.eQM.getId() || (this.eRf && view.getId() == this.eQN.getId())) {
                            this.eQM.cancelAnimation();
                            if (this.eQV != null) {
                                this.eQV.type = 1;
                            }
                            if (this.eQQ.hasAgree) {
                                if (this.eQQ.agreeType == 2) {
                                    this.eQQ.agreeType = 2;
                                    this.eQQ.hasAgree = false;
                                    this.eQQ.agreeNum--;
                                    updateUI();
                                    if (this.eQV != null) {
                                        this.eQV.ezw = 1;
                                    }
                                } else {
                                    this.eQQ.agreeType = 2;
                                    this.eQQ.hasAgree = true;
                                    this.eQQ.agreeNum++;
                                    jj(true);
                                    com.baidu.tieba.o.a.dzT().G(getTbPageContext());
                                    if (this.eQV != null) {
                                        this.eQV.ezw = 0;
                                        i2 = 0;
                                    }
                                }
                                this.eRh.a(this.eQQ, i2, getPageId(), this.eQT);
                            } else {
                                this.eQQ.agreeType = 2;
                                this.eQQ.hasAgree = true;
                                this.eQQ.agreeNum++;
                                jj(true);
                                com.baidu.tieba.o.a.dzT().G(getTbPageContext());
                                if (this.eQV != null) {
                                    this.eQV.ezw = 0;
                                }
                            }
                            i2 = 0;
                            this.eRh.a(this.eQQ, i2, getPageId(), this.eQT);
                        } else if (view.getId() == this.eQO.getId()) {
                            this.eQO.cancelAnimation();
                            if (this.eQV != null) {
                                this.eQV.type = 2;
                            }
                            if (this.eQQ.hasAgree) {
                                if (this.eQQ.agreeType == 5) {
                                    this.eQQ.agreeType = 5;
                                    this.eQQ.hasAgree = false;
                                    updateUI();
                                    if (this.eQV != null) {
                                        this.eQV.ezA = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.eQQ.agreeType = 5;
                                    this.eQQ.hasAgree = true;
                                    this.eQQ.agreeNum--;
                                    jj(false);
                                    if (this.eQV != null) {
                                        this.eQV.ezA = 1;
                                    }
                                }
                            } else {
                                this.eQQ.agreeType = 5;
                                this.eQQ.hasAgree = true;
                                jj(false);
                                if (this.eQV != null) {
                                    this.eQV.ezA = 1;
                                }
                            }
                            this.eRh.a(this.eQQ, i, getPageId(), this.eQT);
                        }
                        this.eRh.a(this.eQQ, this.eQR);
                        if (this.ajp != null) {
                            this.ajp.onClick(view);
                        }
                        bsf();
                    }
                }
            }
        }
    }

    public void bsf() {
        if (this.eQV != null && this.eQQ != null) {
            int i = 0;
            if (this.eQQ.baijiahaoData != null) {
                i = this.eQQ.baijiahaoData.oriUgcType;
            }
            if (this.eQV.type == 1) {
                if (StringUtils.isNull(this.eRa)) {
                    aq dR = new aq("c12003").al("obj_locate", this.eQV.ezt).al("obj_param1", this.eQV.ezu).al("obj_source", this.eQV.ezv).al("obj_id", this.eQV.ezw).al("obj_name", i).dR("post_id", this.eQQ.postId);
                    if (this.exA != null) {
                        dR.dR("tid", this.exA.getId()).dR("nid", this.exA.getNid()).w("fid", this.exA.getFid()).al(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.exA.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.exA.mRecomSource).dR("weight", this.exA.mRecomWeight).dR("extra", this.exA.mRecomExtra);
                        if (this.exA.getBaijiahaoData() != null) {
                            dR.dR("obj_param4", this.exA.getBaijiahaoData().oriUgcNid);
                            if (this.exA.blj() || this.exA.bow()) {
                                dR.dR("obj_param6", this.exA.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.exA.bou()) {
                            dR.al("obj_param5", 2);
                        } else if (this.exA.bli() || this.exA.blj()) {
                            dR.al("obj_param5", 3);
                        } else if (this.exA.threadType == 0 || this.exA.threadType == 40) {
                            dR.al("obj_param5", 1);
                        }
                    } else {
                        dR.dR("tid", this.eQQ.threadId);
                        dR.dR("nid", this.eQQ.nid);
                        dR.dR("fid", this.eQQ.forumId);
                        dR.al(IntentConfig.CARD_TYPE, this.eQQ.cardType);
                        dR.dR("ab_tag", this.eQQ.recomAbTag);
                        dR.dR(IntentConfig.RECOM_SOURCE, this.eQQ.recomSource);
                        dR.dR("weight", this.eQQ.recomWeight);
                        dR.dR("extra", this.eQQ.recomExtra);
                        if (this.eQQ.baijiahaoData != null) {
                            dR.dR("obj_param6", this.eQQ.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (pB(this.eQV.ezt) && pC(this.eQV.ezx) != -1) {
                        dR.al(TiebaInitialize.Params.OBJ_TO, pC(this.eQV.ezx));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.al("resource_id", this.eQW);
                    } else if (this.mFrom == 18) {
                        dR.dR("obj_tab", "a099");
                        dR.dR("resource_id", this.mTabName);
                    } else {
                        dR.al("resource_id", this.eQW);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dR);
                    }
                    if (this.eQQ.isFromImageViewer) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.eQQ.mImageViewerFromPage == "index") {
                            dR.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.eQQ.keyFromHomePage)) {
                        dR.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    TiebaStatic.log(dR);
                    return;
                }
                TiebaStatic.log(new aq("c13358").dR("tid", this.eQQ.threadId).dR("topic_id", this.eRa));
            } else if (this.eQV.type == 2) {
                aq dR2 = new aq("c13271").al("obj_type", this.eQV.ezy).al("obj_locate", this.eQV.ezz).al(TiebaInitialize.Params.OBJ_PARAM2, this.eQW).al("obj_id", this.eQV.ezA).al("obj_name", i).dR("post_id", this.eQQ.postId).dR("nid", this.eQQ.nid);
                if (this.exA != null) {
                    dR2.dR("tid", this.exA.getId()).dR("nid", this.exA.getNid()).w("fid", this.exA.getFid()).al(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.exA.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.exA.mRecomSource).dR("weight", this.exA.mRecomWeight).dR("extra", this.exA.mRecomExtra);
                    if (this.exA.getBaijiahaoData() != null) {
                        dR2.dR("obj_param4", this.exA.getBaijiahaoData().oriUgcNid);
                        if (this.exA.blj() || this.exA.bow()) {
                            dR2.dR("obj_param6", this.exA.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.exA.bou()) {
                        dR2.al("obj_param5", 2);
                    } else if (this.exA.bli() || this.exA.blj()) {
                        dR2.al("obj_param5", 3);
                    } else if (this.exA.threadType == 0 || this.exA.threadType == 40) {
                        dR2.al("obj_param5", 1);
                    }
                } else {
                    dR2.dR("tid", this.eQQ.threadId);
                    dR2.dR("nid", this.eQQ.nid);
                    dR2.dR("fid", this.eQQ.forumId);
                    dR2.al(IntentConfig.CARD_TYPE, this.eQQ.cardType);
                    dR2.dR("ab_tag", this.eQQ.recomAbTag);
                    dR2.dR(IntentConfig.RECOM_SOURCE, this.eQQ.recomSource);
                    dR2.dR("weight", this.eQQ.recomWeight);
                    dR2.dR("extra", this.eQQ.recomExtra);
                    if (this.eQQ.baijiahaoData != null) {
                        dR2.dR("obj_param6", this.eQQ.baijiahaoData.oriUgcVid);
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
                if (this.eQQ.isFromImageViewer) {
                    dR2.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.eQQ.mImageViewerFromPage == "index") {
                        dR2.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public static boolean pB(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int pC(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.eQS == null) {
            this.eQS = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.eQS.setDuration(200L);
        }
        return this.eQS;
    }

    public void onChangeSkinType(int i) {
        if (this.eQQ != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.eQM, this.eQX);
            ap.a(this.eQO, this.eQY);
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
        this.eQV = cVar;
    }

    public void setGameId(int i) {
        this.eQW = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.eQO.setVisibility(z ? 8 : 0);
        this.eQP.setVisibility(z ? 8 : 0);
        if (z && this.eRc != null) {
            this.eRc.setVisibility(8);
        }
        if (this.eRe != z && this.eRg != null) {
            this.eRg.f(this.eQO, z);
        }
        this.eRe = z;
    }

    public void setDisagreeShow(boolean z) {
        this.eQO.setVisibility(z ? 8 : 0);
        this.eQP.setVisibility(z ? 8 : 0);
        if (this.eRc != null) {
            this.eRc.setVisibility(z ? 8 : 0);
        }
        this.eRe = z;
    }

    public boolean bsg() {
        return this.eRe;
    }

    public void setThreadData(bw bwVar) {
        this.exA = bwVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.eQX = i;
        this.eQY = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.eQZ = i;
        setTextNormalColor(this.eQN);
        setTextNormalColor(this.eQP);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajp = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.eRg = aVar;
    }
}
