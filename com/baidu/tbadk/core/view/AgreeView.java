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
    private View.OnClickListener aiC;
    private int cardType;
    private bw dUW;
    private TBLottieAnimationView enY;
    private TextView enZ;
    private TBLottieAnimationView eoa;
    private TextView eob;
    private AgreeData eoc;
    private com.baidu.tieba.tbadkCore.data.e eod;
    private ScaleAnimation eoe;
    private boolean eog;
    private boolean eoh;
    private com.baidu.tbadk.core.data.c eoi;
    private int eoj;
    private int eok;
    private int eol;
    private int eom;
    private String eon;
    public View.OnClickListener eoo;
    private LinearLayout eop;
    private LinearLayout eoq;
    private boolean eor;
    private boolean eos;
    private a eot;
    private com.baidu.tbadk.core.message.a eou;
    private CustomMessageListener eov;
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
        if (agreeData != null && this.eoc != null) {
            this.eoc.agreeType = agreeData.agreeType;
            this.eoc.hasAgree = agreeData.hasAgree;
            this.eoc.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eok = R.raw.lottie_agree;
        this.eol = R.raw.lottie_disagree;
        this.eom = R.color.cp_cont_j;
        this.cardType = 1;
        this.eor = false;
        this.eos = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eoc != null && agreeData != null && AgreeView.this.eod != null && !AgreeView.this.eoc.isInPost && AgreeView.this.eod.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eoc.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eoc.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eoc.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eov = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eoc != null && !TextUtils.isEmpty(AgreeView.this.eoc.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eoc.postId.equals(agreeData.postId) && !AgreeView.this.eoc.isInThread) {
                        if (AgreeView.this.eog) {
                            if (AgreeView.this.eoc.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eod.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eoo != null) {
                    AgreeView.this.eoo.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eok = R.raw.lottie_agree;
        this.eol = R.raw.lottie_disagree;
        this.eom = R.color.cp_cont_j;
        this.cardType = 1;
        this.eor = false;
        this.eos = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eoc != null && agreeData != null && AgreeView.this.eod != null && !AgreeView.this.eoc.isInPost && AgreeView.this.eod.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eoc.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eoc.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eoc.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eov = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eoc != null && !TextUtils.isEmpty(AgreeView.this.eoc.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eoc.postId.equals(agreeData.postId) && !AgreeView.this.eoc.isInThread) {
                        if (AgreeView.this.eog) {
                            if (AgreeView.this.eoc.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eod.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eoo != null) {
                    AgreeView.this.eoo.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eok = R.raw.lottie_agree;
        this.eol = R.raw.lottie_disagree;
        this.eom = R.color.cp_cont_j;
        this.cardType = 1;
        this.eor = false;
        this.eos = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eoc != null && agreeData != null && AgreeView.this.eod != null && !AgreeView.this.eoc.isInPost && AgreeView.this.eod.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eoc.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eoc.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eoc.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eov = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eoc != null && !TextUtils.isEmpty(AgreeView.this.eoc.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eoc.postId.equals(agreeData.postId) && !AgreeView.this.eoc.isInThread) {
                        if (AgreeView.this.eog) {
                            if (AgreeView.this.eoc.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eod.uniqueId == eVar.uniqueId) {
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
                if (AgreeView.this.eoo != null) {
                    AgreeView.this.eoo.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.enY = new TBLottieAnimationView(context);
        this.enY.setId(R.id.img_agree);
        this.enY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.enY.setOnClickListener(this.mOnClickListener);
        this.enY.addAnimatorListener(this);
        this.enZ = new TextView(context);
        this.enZ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.enZ.setOnClickListener(this.mOnClickListener);
        this.eoa = new TBLottieAnimationView(context);
        this.eoa.setId(R.id.img_disagree);
        this.eoa.addAnimatorListener(this);
        this.eoa.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eoa.setOnClickListener(this.mOnClickListener);
        this.eob = new TextView(context);
        this.eob.setText(R.string.c_disagree);
        this.eob.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eob.setOnClickListener(this.mOnClickListener);
        this.eod = new com.baidu.tieba.tbadkCore.data.e();
        this.eod.uniqueId = getPageId();
        this.eou = new com.baidu.tbadk.core.message.a();
        bkd();
        setAgreeAnimationResource();
    }

    private void bkd() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eoq = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.enY);
        linearLayout.addView(this.enZ);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.eop = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.eoa);
        linearLayout2.addView(this.eob);
        iq(false);
    }

    private void s(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.eoq.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
        layoutParams.weight = i3;
        this.eoq.setLayoutParams(layoutParams);
        this.enY.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.enZ.setLayoutParams(layoutParams2);
        this.eop.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
        layoutParams3.weight = i3;
        this.eop.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.eoa.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.eob.setLayoutParams(layoutParams5);
    }

    public void iq(boolean z) {
        if (z) {
            s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), 0, 1, 17);
            setAgreeAlone(this.eor);
            return;
        }
        s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), -2, 0, 16);
        setAgreeAlone(this.eor);
    }

    public void bke() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.enY.setLayoutParams(layoutParams);
        this.enZ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.enZ.setLayoutParams(layoutParams2);
        this.eoa.setVisibility(8);
        this.eob.setVisibility(8);
    }

    public void ir(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.enY.setLayoutParams(layoutParams);
        this.enZ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = i;
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.enZ.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.eos = true;
        }
        layoutParams2.gravity = 16;
        this.enZ.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        this.eoa.setLayoutParams(layoutParams3);
        this.eob.setVisibility(8);
    }

    public void bkf() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        ba(this.enY);
        ba(this.eoa);
        ba(this.enZ);
        ba(this.eob);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.enY, new LinearLayout.LayoutParams(dimens, dimens));
        this.enZ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.enZ, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.eop = linearLayout2;
        linearLayout2.addView(this.eoa, new LinearLayout.LayoutParams(dimens, dimens));
        this.eob.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.eob, layoutParams4);
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
        MessageManager.getInstance().registerListener(this.eov);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eov);
    }

    public void setTopicId(String str) {
        this.eon = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.eog = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.eoh = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.enY;
    }

    public TextView getAgreeNumView() {
        return this.enZ;
    }

    public TextView getDisagreeNumView() {
        return this.eob;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.eoa;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.eoc = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.eoc;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.enY, this.eok);
        ap.a(this.eoa, this.eol);
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
        this.enZ.setText(b(this.eoc));
        if (this.eoc.hasAgree) {
            if (this.eoc.agreeType == 2) {
                this.eoa.setProgress(0.0f);
                this.enY.setProgress(1.0f);
                this.enZ.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eob);
                return;
            }
            this.enY.setProgress(0.0f);
            this.eoa.setProgress(1.0f);
            setTextNormalColor(this.enZ);
            this.eob.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.enY.setProgress(0.0f);
        this.eoa.setProgress(0.0f);
        setTextNormalColor(this.enZ);
        setTextNormalColor(this.eob);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.eoh) {
            textView.setTextColor(ap.getColor(R.color.cp_cont_d));
        } else if (this.eog) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(ap.getColor(this.eom));
        }
    }

    public void is(boolean z) {
        this.enY.setMinAndMaxProgress(0.0f, 1.0f);
        this.eoa.setMinAndMaxProgress(0.0f, 1.0f);
        this.enZ.setText(b(this.eoc));
        this.enY.clearColorFilter();
        this.eoa.clearColorFilter();
        if (z) {
            this.enY.playAnimation();
            this.eoa.cancelAnimation();
            this.eoa.setFrame(0);
        } else {
            this.eoa.playAnimation();
            this.enY.cancelAnimation();
            this.enY.setFrame(0);
        }
        if (this.eoc.hasAgree) {
            if (this.eoc.agreeType == 2) {
                this.enZ.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eob);
                return;
            }
            setTextNormalColor(this.enZ);
            this.eob.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.enZ);
        setTextNormalColor(this.eob);
    }

    public void bkg() {
        bb(this.enY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(View view) {
        int i = 0;
        int i2 = 1;
        if (this.eoc != null) {
            if (!this.eog || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.eog || bg.checkUpIsLogin(getContext())) {
                    if (view != this.enZ || this.eos) {
                        if (view.getId() == this.enY.getId() || (this.eos && view.getId() == this.enZ.getId())) {
                            this.enY.cancelAnimation();
                            if (this.eoi != null) {
                                this.eoi.type = 1;
                            }
                            if (this.eoc.hasAgree) {
                                if (this.eoc.agreeType == 2) {
                                    this.eoc.agreeType = 2;
                                    this.eoc.hasAgree = false;
                                    this.eoc.agreeNum--;
                                    updateUI();
                                    if (this.eoi != null) {
                                        this.eoi.dWR = 1;
                                    }
                                } else {
                                    this.eoc.agreeType = 2;
                                    this.eoc.hasAgree = true;
                                    this.eoc.agreeNum++;
                                    is(true);
                                    com.baidu.tieba.o.a.dmP().G(getTbPageContext());
                                    if (this.eoi != null) {
                                        this.eoi.dWR = 0;
                                        i2 = 0;
                                    }
                                }
                                this.eou.a(this.eoc, i2, getPageId(), this.eog);
                            } else {
                                this.eoc.agreeType = 2;
                                this.eoc.hasAgree = true;
                                this.eoc.agreeNum++;
                                is(true);
                                com.baidu.tieba.o.a.dmP().G(getTbPageContext());
                                if (this.eoi != null) {
                                    this.eoi.dWR = 0;
                                }
                            }
                            i2 = 0;
                            this.eou.a(this.eoc, i2, getPageId(), this.eog);
                        } else if (view.getId() == this.eoa.getId()) {
                            this.eoa.cancelAnimation();
                            if (this.eoi != null) {
                                this.eoi.type = 2;
                            }
                            if (this.eoc.hasAgree) {
                                if (this.eoc.agreeType == 5) {
                                    this.eoc.agreeType = 5;
                                    this.eoc.hasAgree = false;
                                    updateUI();
                                    if (this.eoi != null) {
                                        this.eoi.dWV = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.eoc.agreeType = 5;
                                    this.eoc.hasAgree = true;
                                    this.eoc.agreeNum--;
                                    is(false);
                                    if (this.eoi != null) {
                                        this.eoi.dWV = 1;
                                    }
                                }
                            } else {
                                this.eoc.agreeType = 5;
                                this.eoc.hasAgree = true;
                                is(false);
                                if (this.eoi != null) {
                                    this.eoi.dWV = 1;
                                }
                            }
                            this.eou.a(this.eoc, i, getPageId(), this.eog);
                        }
                        this.eou.a(this.eoc, this.eod);
                        if (this.aiC != null) {
                            this.aiC.onClick(view);
                        }
                        bkh();
                    }
                }
            }
        }
    }

    public void bkh() {
        if (this.eoi != null && this.eoc != null) {
            int i = 0;
            if (this.eoc.baijiahaoData != null) {
                i = this.eoc.baijiahaoData.oriUgcType;
            }
            if (this.eoi.type == 1) {
                if (StringUtils.isNull(this.eon)) {
                    aq dD = new aq("c12003").ai("obj_locate", this.eoi.dWO).ai("obj_param1", this.eoi.dWP).ai("obj_source", this.eoi.dWQ).ai("obj_id", this.eoi.dWR).ai("obj_name", i).dD("post_id", this.eoc.postId);
                    if (this.dUW != null) {
                        dD.dD("tid", this.dUW.getId()).dD("nid", this.dUW.getNid()).u("fid", this.dUW.getFid()).ai(IntentConfig.CARD_TYPE, this.cardType).dD("ab_tag", this.dUW.mRecomAbTag).dD(IntentConfig.RECOM_SOURCE, this.dUW.mRecomSource).dD("weight", this.dUW.mRecomWeight).dD("extra", this.dUW.mRecomExtra);
                        if (this.dUW.getBaijiahaoData() != null) {
                            dD.dD("obj_param4", this.dUW.getBaijiahaoData().oriUgcNid);
                            if (this.dUW.bdn() || this.dUW.bgA()) {
                                dD.dD("obj_param6", this.dUW.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.dUW.bgy()) {
                            dD.ai("obj_param5", 2);
                        } else if (this.dUW.bdm() || this.dUW.bdn()) {
                            dD.ai("obj_param5", 3);
                        } else if (this.dUW.threadType == 0 || this.dUW.threadType == 40) {
                            dD.ai("obj_param5", 1);
                        }
                    } else {
                        dD.dD("tid", this.eoc.threadId);
                        dD.dD("nid", this.eoc.nid);
                        dD.dD("fid", this.eoc.forumId);
                        dD.ai(IntentConfig.CARD_TYPE, this.eoc.cardType);
                        dD.dD("ab_tag", this.eoc.recomAbTag);
                        dD.dD(IntentConfig.RECOM_SOURCE, this.eoc.recomSource);
                        dD.dD("weight", this.eoc.recomWeight);
                        dD.dD("extra", this.eoc.recomExtra);
                        if (this.eoc.baijiahaoData != null) {
                            dD.dD("obj_param6", this.eoc.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (ov(this.eoi.dWO) && ow(this.eoi.dWS) != -1) {
                        dD.ai(TiebaInitialize.Params.OBJ_TO, ow(this.eoi.dWS));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dD.dD("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dD.ai("resource_id", this.eoj);
                    } else if (this.mFrom == 18) {
                        dD.dD("obj_tab", "a099");
                        dD.dD("resource_id", this.mTabName);
                    } else {
                        dD.ai("resource_id", this.eoj);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dD);
                    }
                    if (this.eoc.isFromImageViewer) {
                        dD.dD("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.eoc.mImageViewerFromPage == "index") {
                            dD.dD(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.eoc.keyFromHomePage)) {
                        dD.dD("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dD.dD("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    TiebaStatic.log(dD);
                    return;
                }
                TiebaStatic.log(new aq("c13358").dD("tid", this.eoc.threadId).dD("topic_id", this.eon));
            } else if (this.eoi.type == 2) {
                aq dD2 = new aq("c13271").ai("obj_type", this.eoi.dWT).ai("obj_locate", this.eoi.dWU).ai(TiebaInitialize.Params.OBJ_PARAM2, this.eoj).ai("obj_id", this.eoi.dWV).ai("obj_name", i).dD("post_id", this.eoc.postId).dD("nid", this.eoc.nid);
                if (this.dUW != null) {
                    dD2.dD("tid", this.dUW.getId()).dD("nid", this.dUW.getNid()).u("fid", this.dUW.getFid()).ai(IntentConfig.CARD_TYPE, this.cardType).dD("ab_tag", this.dUW.mRecomAbTag).dD(IntentConfig.RECOM_SOURCE, this.dUW.mRecomSource).dD("weight", this.dUW.mRecomWeight).dD("extra", this.dUW.mRecomExtra);
                    if (this.dUW.getBaijiahaoData() != null) {
                        dD2.dD("obj_param4", this.dUW.getBaijiahaoData().oriUgcNid);
                        if (this.dUW.bdn() || this.dUW.bgA()) {
                            dD2.dD("obj_param6", this.dUW.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.dUW.bgy()) {
                        dD2.ai("obj_param5", 2);
                    } else if (this.dUW.bdm() || this.dUW.bdn()) {
                        dD2.ai("obj_param5", 3);
                    } else if (this.dUW.threadType == 0 || this.dUW.threadType == 40) {
                        dD2.ai("obj_param5", 1);
                    }
                } else {
                    dD2.dD("tid", this.eoc.threadId);
                    dD2.dD("nid", this.eoc.nid);
                    dD2.dD("fid", this.eoc.forumId);
                    dD2.ai(IntentConfig.CARD_TYPE, this.eoc.cardType);
                    dD2.dD("ab_tag", this.eoc.recomAbTag);
                    dD2.dD(IntentConfig.RECOM_SOURCE, this.eoc.recomSource);
                    dD2.dD("weight", this.eoc.recomWeight);
                    dD2.dD("extra", this.eoc.recomExtra);
                    if (this.eoc.baijiahaoData != null) {
                        dD2.dD("obj_param6", this.eoc.baijiahaoData.oriUgcVid);
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
                if (this.eoc.isFromImageViewer) {
                    dD2.dD("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.eoc.mImageViewerFromPage == "index") {
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
        if (this.eoe == null) {
            this.eoe = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.eoe.setDuration(200L);
        }
        return this.eoe;
    }

    public void onChangeSkinType(int i) {
        if (this.eoc != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.enY, this.eok);
            ap.a(this.eoa, this.eol);
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
        this.eoi = cVar;
    }

    public void setGameId(int i) {
        this.eoj = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.eoa.setVisibility(z ? 8 : 0);
        this.eob.setVisibility(z ? 8 : 0);
        if (z && this.eop != null) {
            this.eop.setVisibility(8);
        }
        if (this.eor != z && this.eot != null) {
            this.eot.e(this.eoa, z);
        }
        this.eor = z;
    }

    public void setDisagreeShow(boolean z) {
        this.eoa.setVisibility(z ? 8 : 0);
        this.eob.setVisibility(z ? 8 : 0);
        if (this.eop != null) {
            this.eop.setVisibility(z ? 8 : 0);
        }
        this.eor = z;
    }

    public boolean bki() {
        return this.eor;
    }

    public void setThreadData(bw bwVar) {
        this.dUW = bwVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.eok = i;
        this.eol = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.eom = i;
        setTextNormalColor(this.enZ);
        setTextNormalColor(this.eob);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.eot = aVar;
    }
}
