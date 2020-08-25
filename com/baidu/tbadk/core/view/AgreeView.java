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
/* loaded from: classes15.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private View.OnClickListener aiA;
    private int cardType;
    private bw dUS;
    private TBLottieAnimationView enU;
    private TextView enV;
    private TBLottieAnimationView enW;
    private TextView enX;
    private AgreeData enY;
    private com.baidu.tieba.tbadkCore.data.e enZ;
    private ScaleAnimation eoa;
    private boolean eob;
    private boolean eoc;
    private com.baidu.tbadk.core.data.c eod;
    private int eoe;
    private int eog;
    private int eoh;
    private int eoi;
    private String eoj;
    public View.OnClickListener eok;
    private LinearLayout eol;
    private LinearLayout eom;
    private boolean eon;
    private boolean eoo;
    private a eop;
    private com.baidu.tbadk.core.message.a eoq;
    private CustomMessageListener eor;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes15.dex */
    public interface a {
        void e(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.enY != null) {
            this.enY.agreeType = agreeData.agreeType;
            this.enY.hasAgree = agreeData.hasAgree;
            this.enY.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eog = R.raw.lottie_agree;
        this.eoh = R.raw.lottie_disagree;
        this.eoi = R.color.cp_cont_j;
        this.cardType = 1;
        this.eon = false;
        this.eoo = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.enY != null && agreeData != null && AgreeView.this.enZ != null && !AgreeView.this.enY.isInPost && AgreeView.this.enZ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.enY.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.enY.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.enY.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eor = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.enY != null && !TextUtils.isEmpty(AgreeView.this.enY.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.enY.postId.equals(agreeData.postId) && !AgreeView.this.enY.isInThread) {
                        if (AgreeView.this.eob) {
                            if (AgreeView.this.enY.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.enZ.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bb(view);
                if (AgreeView.this.eok != null) {
                    AgreeView.this.eok.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eog = R.raw.lottie_agree;
        this.eoh = R.raw.lottie_disagree;
        this.eoi = R.color.cp_cont_j;
        this.cardType = 1;
        this.eon = false;
        this.eoo = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.enY != null && agreeData != null && AgreeView.this.enZ != null && !AgreeView.this.enY.isInPost && AgreeView.this.enZ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.enY.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.enY.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.enY.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eor = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.enY != null && !TextUtils.isEmpty(AgreeView.this.enY.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.enY.postId.equals(agreeData.postId) && !AgreeView.this.enY.isInThread) {
                        if (AgreeView.this.eob) {
                            if (AgreeView.this.enY.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.enZ.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bb(view);
                if (AgreeView.this.eok != null) {
                    AgreeView.this.eok.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eog = R.raw.lottie_agree;
        this.eoh = R.raw.lottie_disagree;
        this.eoi = R.color.cp_cont_j;
        this.cardType = 1;
        this.eon = false;
        this.eoo = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.enY != null && agreeData != null && AgreeView.this.enZ != null && !AgreeView.this.enY.isInPost && AgreeView.this.enZ.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.enY.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.enY.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.enY.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eor = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.enY != null && !TextUtils.isEmpty(AgreeView.this.enY.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.enY.postId.equals(agreeData.postId) && !AgreeView.this.enY.isInThread) {
                        if (AgreeView.this.eob) {
                            if (AgreeView.this.enY.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.enZ.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bb(view);
                if (AgreeView.this.eok != null) {
                    AgreeView.this.eok.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.enU = new TBLottieAnimationView(context);
        this.enU.setId(R.id.img_agree);
        this.enU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.enU.setOnClickListener(this.mOnClickListener);
        this.enU.addAnimatorListener(this);
        this.enV = new TextView(context);
        this.enV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.enV.setOnClickListener(this.mOnClickListener);
        this.enW = new TBLottieAnimationView(context);
        this.enW.setId(R.id.img_disagree);
        this.enW.addAnimatorListener(this);
        this.enW.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.enW.setOnClickListener(this.mOnClickListener);
        this.enX = new TextView(context);
        this.enX.setText(R.string.c_disagree);
        this.enX.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.enX.setOnClickListener(this.mOnClickListener);
        this.enZ = new com.baidu.tieba.tbadkCore.data.e();
        this.enZ.uniqueId = getPageId();
        this.eoq = new com.baidu.tbadk.core.message.a();
        bkd();
        setAgreeAnimationResource();
    }

    private void bkd() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eom = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.enU);
        linearLayout.addView(this.enV);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.eol = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.enW);
        linearLayout2.addView(this.enX);
        ip(false);
    }

    private void s(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.eom.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
        layoutParams.weight = i3;
        this.eom.setLayoutParams(layoutParams);
        this.enU.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.enV.setLayoutParams(layoutParams2);
        this.eol.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
        layoutParams3.weight = i3;
        this.eol.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.enW.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.enX.setLayoutParams(layoutParams5);
    }

    public void ip(boolean z) {
        if (z) {
            s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), 0, 1, 17);
            setAgreeAlone(this.eon);
            return;
        }
        s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), -2, 0, 16);
        setAgreeAlone(this.eon);
    }

    public void bke() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.enU.setLayoutParams(layoutParams);
        this.enV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.enV.setLayoutParams(layoutParams2);
        this.enW.setVisibility(8);
        this.enX.setVisibility(8);
    }

    public void iq(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.enU.setLayoutParams(layoutParams);
        this.enV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = i;
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.enV.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.eoo = true;
        }
        layoutParams2.gravity = 16;
        this.enV.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        this.enW.setLayoutParams(layoutParams3);
        this.enX.setVisibility(8);
    }

    public void bkf() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        ba(this.enU);
        ba(this.enW);
        ba(this.enV);
        ba(this.enX);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.enU, new LinearLayout.LayoutParams(dimens, dimens));
        this.enV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.enV, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.eol = linearLayout2;
        linearLayout2.addView(this.enW, new LinearLayout.LayoutParams(dimens, dimens));
        this.enX.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.enX, layoutParams4);
    }

    private void ba(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eor);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eor);
    }

    public void setTopicId(String str) {
        this.eoj = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.eob = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.eoc = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.enU;
    }

    public TextView getAgreeNumView() {
        return this.enV;
    }

    public TextView getDisagreeNumView() {
        return this.enX;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.enW;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.enY = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.enY;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.enU, this.eog);
        ap.a(this.enW, this.eoh);
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
        this.enV.setText(b(this.enY));
        if (this.enY.hasAgree) {
            if (this.enY.agreeType == 2) {
                this.enW.setProgress(0.0f);
                this.enU.setProgress(1.0f);
                this.enV.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.enX);
                return;
            }
            this.enU.setProgress(0.0f);
            this.enW.setProgress(1.0f);
            setTextNormalColor(this.enV);
            this.enX.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.enU.setProgress(0.0f);
        this.enW.setProgress(0.0f);
        setTextNormalColor(this.enV);
        setTextNormalColor(this.enX);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.eoc) {
            textView.setTextColor(ap.getColor(R.color.cp_cont_d));
        } else if (this.eob) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(ap.getColor(this.eoi));
        }
    }

    public void ir(boolean z) {
        this.enU.setMinAndMaxProgress(0.0f, 1.0f);
        this.enW.setMinAndMaxProgress(0.0f, 1.0f);
        this.enV.setText(b(this.enY));
        this.enU.clearColorFilter();
        this.enW.clearColorFilter();
        if (z) {
            this.enU.playAnimation();
            this.enW.cancelAnimation();
            this.enW.setFrame(0);
        } else {
            this.enW.playAnimation();
            this.enU.cancelAnimation();
            this.enU.setFrame(0);
        }
        if (this.enY.hasAgree) {
            if (this.enY.agreeType == 2) {
                this.enV.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.enX);
                return;
            }
            setTextNormalColor(this.enV);
            this.enX.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.enV);
        setTextNormalColor(this.enX);
    }

    public void bkg() {
        bb(this.enU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(View view) {
        int i = 0;
        int i2 = 1;
        if (this.enY != null) {
            if (!this.eob || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.eob || bg.checkUpIsLogin(getContext())) {
                    if (view != this.enV || this.eoo) {
                        if (view.getId() == this.enU.getId() || (this.eoo && view.getId() == this.enV.getId())) {
                            this.enU.cancelAnimation();
                            if (this.eod != null) {
                                this.eod.type = 1;
                            }
                            if (this.enY.hasAgree) {
                                if (this.enY.agreeType == 2) {
                                    this.enY.agreeType = 2;
                                    this.enY.hasAgree = false;
                                    this.enY.agreeNum--;
                                    updateUI();
                                    if (this.eod != null) {
                                        this.eod.dWN = 1;
                                    }
                                } else {
                                    this.enY.agreeType = 2;
                                    this.enY.hasAgree = true;
                                    this.enY.agreeNum++;
                                    ir(true);
                                    com.baidu.tieba.o.a.dmM().G(getTbPageContext());
                                    if (this.eod != null) {
                                        this.eod.dWN = 0;
                                        i2 = 0;
                                    }
                                }
                                this.eoq.a(this.enY, i2, getPageId(), this.eob);
                            } else {
                                this.enY.agreeType = 2;
                                this.enY.hasAgree = true;
                                this.enY.agreeNum++;
                                ir(true);
                                com.baidu.tieba.o.a.dmM().G(getTbPageContext());
                                if (this.eod != null) {
                                    this.eod.dWN = 0;
                                }
                            }
                            i2 = 0;
                            this.eoq.a(this.enY, i2, getPageId(), this.eob);
                        } else if (view.getId() == this.enW.getId()) {
                            this.enW.cancelAnimation();
                            if (this.eod != null) {
                                this.eod.type = 2;
                            }
                            if (this.enY.hasAgree) {
                                if (this.enY.agreeType == 5) {
                                    this.enY.agreeType = 5;
                                    this.enY.hasAgree = false;
                                    updateUI();
                                    if (this.eod != null) {
                                        this.eod.dWR = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.enY.agreeType = 5;
                                    this.enY.hasAgree = true;
                                    this.enY.agreeNum--;
                                    ir(false);
                                    if (this.eod != null) {
                                        this.eod.dWR = 1;
                                    }
                                }
                            } else {
                                this.enY.agreeType = 5;
                                this.enY.hasAgree = true;
                                ir(false);
                                if (this.eod != null) {
                                    this.eod.dWR = 1;
                                }
                            }
                            this.eoq.a(this.enY, i, getPageId(), this.eob);
                        }
                        this.eoq.a(this.enY, this.enZ);
                        if (this.aiA != null) {
                            this.aiA.onClick(view);
                        }
                        bkh();
                    }
                }
            }
        }
    }

    public void bkh() {
        if (this.eod != null && this.enY != null) {
            int i = 0;
            if (this.enY.baijiahaoData != null) {
                i = this.enY.baijiahaoData.oriUgcType;
            }
            if (this.eod.type == 1) {
                if (StringUtils.isNull(this.eoj)) {
                    aq dD = new aq("c12003").ai("obj_locate", this.eod.dWK).ai("obj_param1", this.eod.dWL).ai("obj_source", this.eod.dWM).ai("obj_id", this.eod.dWN).ai("obj_name", i).dD("post_id", this.enY.postId);
                    if (this.dUS != null) {
                        dD.dD("tid", this.dUS.getId()).dD("nid", this.dUS.getNid()).u("fid", this.dUS.getFid()).ai(IntentConfig.CARD_TYPE, this.cardType).dD("ab_tag", this.dUS.mRecomAbTag).dD(IntentConfig.RECOM_SOURCE, this.dUS.mRecomSource).dD("weight", this.dUS.mRecomWeight).dD("extra", this.dUS.mRecomExtra);
                        if (this.dUS.getBaijiahaoData() != null) {
                            dD.dD("obj_param4", this.dUS.getBaijiahaoData().oriUgcNid);
                            if (this.dUS.bdn() || this.dUS.bgA()) {
                                dD.dD("obj_param6", this.dUS.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.dUS.bgy()) {
                            dD.ai("obj_param5", 2);
                        } else if (this.dUS.bdm() || this.dUS.bdn()) {
                            dD.ai("obj_param5", 3);
                        } else if (this.dUS.threadType == 0 || this.dUS.threadType == 40) {
                            dD.ai("obj_param5", 1);
                        }
                    } else {
                        dD.dD("tid", this.enY.threadId);
                        dD.dD("nid", this.enY.nid);
                        dD.dD("fid", this.enY.forumId);
                        dD.ai(IntentConfig.CARD_TYPE, this.enY.cardType);
                        dD.dD("ab_tag", this.enY.recomAbTag);
                        dD.dD(IntentConfig.RECOM_SOURCE, this.enY.recomSource);
                        dD.dD("weight", this.enY.recomWeight);
                        dD.dD("extra", this.enY.recomExtra);
                        if (this.enY.baijiahaoData != null) {
                            dD.dD("obj_param6", this.enY.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (ov(this.eod.dWK) && ow(this.eod.dWO) != -1) {
                        dD.ai(TiebaInitialize.Params.OBJ_TO, ow(this.eod.dWO));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dD.dD("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dD.ai("resource_id", this.eoe);
                    } else if (this.mFrom == 18) {
                        dD.dD("obj_tab", "a099");
                        dD.dD("resource_id", this.mTabName);
                    } else {
                        dD.ai("resource_id", this.eoe);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dD);
                    }
                    if (this.enY.isFromImageViewer) {
                        dD.dD("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.enY.mImageViewerFromPage == "index") {
                            dD.dD(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.enY.keyFromHomePage)) {
                        dD.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dD.dD("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    TiebaStatic.log(dD);
                    return;
                }
                TiebaStatic.log(new aq("c13358").dD("tid", this.enY.threadId).dD("topic_id", this.eoj));
            } else if (this.eod.type == 2) {
                aq dD2 = new aq("c13271").ai("obj_type", this.eod.dWP).ai("obj_locate", this.eod.dWQ).ai(TiebaInitialize.Params.OBJ_PARAM2, this.eoe).ai("obj_id", this.eod.dWR).ai("obj_name", i).dD("post_id", this.enY.postId).dD("nid", this.enY.nid);
                if (this.dUS != null) {
                    dD2.dD("tid", this.dUS.getId()).dD("nid", this.dUS.getNid()).u("fid", this.dUS.getFid()).ai(IntentConfig.CARD_TYPE, this.cardType).dD("ab_tag", this.dUS.mRecomAbTag).dD(IntentConfig.RECOM_SOURCE, this.dUS.mRecomSource).dD("weight", this.dUS.mRecomWeight).dD("extra", this.dUS.mRecomExtra);
                    if (this.dUS.getBaijiahaoData() != null) {
                        dD2.dD("obj_param4", this.dUS.getBaijiahaoData().oriUgcNid);
                        if (this.dUS.bdn() || this.dUS.bgA()) {
                            dD2.dD("obj_param6", this.dUS.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.dUS.bgy()) {
                        dD2.ai("obj_param5", 2);
                    } else if (this.dUS.bdm() || this.dUS.bdn()) {
                        dD2.ai("obj_param5", 3);
                    } else if (this.dUS.threadType == 0 || this.dUS.threadType == 40) {
                        dD2.ai("obj_param5", 1);
                    }
                } else {
                    dD2.dD("tid", this.enY.threadId);
                    dD2.dD("nid", this.enY.nid);
                    dD2.dD("fid", this.enY.forumId);
                    dD2.ai(IntentConfig.CARD_TYPE, this.enY.cardType);
                    dD2.dD("ab_tag", this.enY.recomAbTag);
                    dD2.dD(IntentConfig.RECOM_SOURCE, this.enY.recomSource);
                    dD2.dD("weight", this.enY.recomWeight);
                    dD2.dD("extra", this.enY.recomExtra);
                    if (this.enY.baijiahaoData != null) {
                        dD2.dD("obj_param6", this.enY.baijiahaoData.oriUgcVid);
                    }
                }
                if (this.mFrom == 1 || this.mFrom == 2) {
                    dD2.dD("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                } else if (this.mFrom == 18) {
                    dD2.dD("obj_tab", "a099");
                    dD2.dD("resource_id", this.mTabName);
                }
                if (getTbPageContext() != null) {
                    com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dD2);
                }
                if (this.enY.isFromImageViewer) {
                    dD2.dD("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.enY.mImageViewerFromPage == "index") {
                        dD2.dD(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dD2);
            }
        }
    }

    public static boolean ov(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int ow(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.eoa == null) {
            this.eoa = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.eoa.setDuration(200L);
        }
        return this.eoa;
    }

    public void onChangeSkinType(int i) {
        if (this.enY != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.enU, this.eog);
            ap.a(this.enW, this.eoh);
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
        this.eod = cVar;
    }

    public void setGameId(int i) {
        this.eoe = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.enW.setVisibility(z ? 8 : 0);
        this.enX.setVisibility(z ? 8 : 0);
        if (z && this.eol != null) {
            this.eol.setVisibility(8);
        }
        if (this.eon != z && this.eop != null) {
            this.eop.e(this.enW, z);
        }
        this.eon = z;
    }

    public void setDisagreeShow(boolean z) {
        this.enW.setVisibility(z ? 8 : 0);
        this.enX.setVisibility(z ? 8 : 0);
        if (this.eol != null) {
            this.eol.setVisibility(z ? 8 : 0);
        }
        this.eon = z;
    }

    public boolean bki() {
        return this.eon;
    }

    public void setThreadData(bw bwVar) {
        this.dUS = bwVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.eog = i;
        this.eoh = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.eoi = i;
        setTextNormalColor(this.enV);
        setTextNormalColor(this.enX);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiA = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.eop = aVar;
    }
}
