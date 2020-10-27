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
    private TBLottieAnimationView eKX;
    private TextView eKY;
    private TBLottieAnimationView eKZ;
    private TextView eLa;
    private AgreeData eLb;
    private com.baidu.tieba.tbadkCore.data.e eLc;
    private ScaleAnimation eLd;
    private boolean eLe;
    private boolean eLf;
    private com.baidu.tbadk.core.data.c eLg;
    private int eLh;
    private int eLi;
    private int eLj;
    private int eLk;
    private String eLl;
    public View.OnClickListener eLm;
    private LinearLayout eLn;
    private LinearLayout eLo;
    private boolean eLp;
    private boolean eLq;
    private a eLr;
    private com.baidu.tbadk.core.message.a eLs;
    private CustomMessageListener eLt;
    private bw erH;
    private int mFrom;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;
    private String mTabName;
    private CustomMessageListener mThreadAgreeChangedListener;

    /* loaded from: classes21.dex */
    public interface a {
        void e(View view, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AgreeData agreeData) {
        if (agreeData != null && this.eLb != null) {
            this.eLb.agreeType = agreeData.agreeType;
            this.eLb.hasAgree = agreeData.hasAgree;
            this.eLb.agreeNum = agreeData.agreeNum;
            updateUI();
        }
    }

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eLi = R.raw.lottie_agree;
        this.eLj = R.raw.lottie_disagree;
        this.eLk = R.color.cp_cont_j;
        this.cardType = 1;
        this.eLp = false;
        this.eLq = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eLb != null && agreeData != null && AgreeView.this.eLc != null && !AgreeView.this.eLb.isInPost && AgreeView.this.eLc.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eLb.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eLb.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eLb.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eLt = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eLb != null && !TextUtils.isEmpty(AgreeView.this.eLb.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eLb.postId.equals(agreeData.postId) && !AgreeView.this.eLb.isInThread) {
                        if (AgreeView.this.eLe) {
                            if (AgreeView.this.eLb.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eLc.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bi(view);
                if (AgreeView.this.eLm != null) {
                    AgreeView.this.eLm.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eLi = R.raw.lottie_agree;
        this.eLj = R.raw.lottie_disagree;
        this.eLk = R.color.cp_cont_j;
        this.cardType = 1;
        this.eLp = false;
        this.eLq = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eLb != null && agreeData != null && AgreeView.this.eLc != null && !AgreeView.this.eLb.isInPost && AgreeView.this.eLc.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eLb.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eLb.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eLb.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eLt = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eLb != null && !TextUtils.isEmpty(AgreeView.this.eLb.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eLb.postId.equals(agreeData.postId) && !AgreeView.this.eLb.isInThread) {
                        if (AgreeView.this.eLe) {
                            if (AgreeView.this.eLb.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eLc.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bi(view);
                if (AgreeView.this.eLm != null) {
                    AgreeView.this.eLm.onClick(view);
                }
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eLi = R.raw.lottie_agree;
        this.eLj = R.raw.lottie_disagree;
        this.eLk = R.color.cp_cont_j;
        this.cardType = 1;
        this.eLp = false;
        this.eLq = false;
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eLb != null && agreeData != null && AgreeView.this.eLc != null && !AgreeView.this.eLb.isInPost && AgreeView.this.eLc.uniqueId != eVar.uniqueId) {
                        String str = agreeData.nid;
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (AgreeView.this.eLb.baijiahaoData != null && TextUtils.equals(str, AgreeView.this.eLb.baijiahaoData.oriUgcNid)) {
                                AgreeView.this.a(agreeData);
                                return;
                            }
                            return;
                        }
                        String str2 = agreeData.threadId;
                        String str3 = AgreeView.this.eLb.threadId;
                        if (!"0".equals(str2) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, str3)) {
                            AgreeView.this.a(agreeData);
                        }
                    }
                }
            }
        };
        this.eLt = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.eLb != null && !TextUtils.isEmpty(AgreeView.this.eLb.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.eLb.postId.equals(agreeData.postId) && !AgreeView.this.eLb.isInThread) {
                        if (AgreeView.this.eLe) {
                            if (AgreeView.this.eLb.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.eLc.uniqueId == eVar.uniqueId) {
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
                AgreeView.this.bi(view);
                if (AgreeView.this.eLm != null) {
                    AgreeView.this.eLm.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        this.eKX = new TBLottieAnimationView(context);
        this.eKX.setId(R.id.img_agree);
        this.eKX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eKX.setOnClickListener(this.mOnClickListener);
        this.eKX.addAnimatorListener(this);
        this.eKY = new TextView(context);
        this.eKY.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eKY.setOnClickListener(this.mOnClickListener);
        this.eKZ = new TBLottieAnimationView(context);
        this.eKZ.setId(R.id.img_disagree);
        this.eKZ.addAnimatorListener(this);
        this.eKZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eKZ.setOnClickListener(this.mOnClickListener);
        this.eLa = new TextView(context);
        this.eLa.setText(R.string.c_disagree);
        this.eLa.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        this.eLa.setOnClickListener(this.mOnClickListener);
        this.eLc = new com.baidu.tieba.tbadkCore.data.e();
        this.eLc.uniqueId = getPageId();
        this.eLs = new com.baidu.tbadk.core.message.a();
        bpB();
        setAgreeAnimationResource();
    }

    private void bpB() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eLo = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.eKX);
        linearLayout.addView(this.eKY);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.eLn = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.eKZ);
        linearLayout2.addView(this.eLa);
        iY(false);
    }

    private void s(int i, int i2, int i3, int i4) {
        int i5 = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds34);
        this.eLo.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -2);
        layoutParams.weight = i3;
        this.eLo.setLayoutParams(layoutParams);
        this.eKX.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.eKY.setLayoutParams(layoutParams2);
        this.eLn.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
        layoutParams3.weight = i3;
        this.eLn.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = dimens;
        this.eKZ.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.eLa.setLayoutParams(layoutParams5);
    }

    public void iY(boolean z) {
        if (z) {
            s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), 0, 1, 17);
            setAgreeAlone(this.eLp);
            return;
        }
        s(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds118), -2, 0, 16);
        setAgreeAlone(this.eLp);
    }

    public void bpC() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds112);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -dimens2;
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eKX.setLayoutParams(layoutParams);
        this.eKY.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds_2);
        this.eKY.setLayoutParams(layoutParams2);
        this.eKZ.setVisibility(8);
        this.eLa.setVisibility(8);
    }

    public void iZ(boolean z) {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds104);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 16;
        this.eKX.setLayoutParams(layoutParams);
        this.eKY.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = i;
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.eKY.setPadding(0, dimens2, dimens2 * 3, dimens2);
            this.eLq = true;
        }
        layoutParams2.gravity = 16;
        this.eKY.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.gravity = 16;
        this.eKZ.setLayoutParams(layoutParams3);
        this.eLa.setVisibility(8);
    }

    public void bpD() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds152);
        int i = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds38);
        removeAllViews();
        bh(this.eKX);
        bh(this.eKZ);
        bh(this.eKY);
        bh(this.eLa);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.eKX, new LinearLayout.LayoutParams(dimens, dimens));
        this.eKY.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = i;
        linearLayout.addView(this.eKY, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.eLn = linearLayout2;
        linearLayout2.addView(this.eKZ, new LinearLayout.LayoutParams(dimens, dimens));
        this.eLa.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = i;
        linearLayout2.addView(this.eLa, layoutParams4);
    }

    private void bh(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().registerListener(this.eLt);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.mThreadAgreeChangedListener);
        MessageManager.getInstance().unRegisterListener(this.eLt);
    }

    public void setTopicId(String str) {
        this.eLl = str;
    }

    public void setIsFromBigpic(boolean z) {
        this.eLe = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.eLf = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.eKX;
    }

    public TextView getAgreeNumView() {
        return this.eKY;
    }

    public TextView getDisagreeNumView() {
        return this.eLa;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.eKZ;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.eLb = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.eLb;
    }

    public void setAgreeAnimationResource() {
        ap.a(this.eKX, this.eLi);
        ap.a(this.eKZ, this.eLj);
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
        this.eKY.setText(b(this.eLb));
        if (this.eLb.hasAgree) {
            if (this.eLb.agreeType == 2) {
                this.eKZ.setProgress(0.0f);
                this.eKX.setProgress(1.0f);
                this.eKY.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eLa);
                return;
            }
            this.eKX.setProgress(0.0f);
            this.eKZ.setProgress(1.0f);
            setTextNormalColor(this.eKY);
            this.eLa.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.eKX.setProgress(0.0f);
        this.eKZ.setProgress(0.0f);
        setTextNormalColor(this.eKY);
        setTextNormalColor(this.eLa);
    }

    private void setTextNormalColor(TextView textView) {
        if (this.eLf) {
            textView.setTextColor(ap.getColor(R.color.cp_cont_d));
        } else if (this.eLe) {
            textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            textView.setTextColor(ap.getColor(this.eLk));
        }
    }

    public void ja(boolean z) {
        this.eKX.setMinAndMaxProgress(0.0f, 1.0f);
        this.eKZ.setMinAndMaxProgress(0.0f, 1.0f);
        this.eKY.setText(b(this.eLb));
        this.eKX.clearColorFilter();
        this.eKZ.clearColorFilter();
        if (z) {
            this.eKX.playAnimation();
            this.eKZ.cancelAnimation();
            this.eKZ.setFrame(0);
        } else {
            this.eKZ.playAnimation();
            this.eKX.cancelAnimation();
            this.eKX.setFrame(0);
        }
        if (this.eLb.hasAgree) {
            if (this.eLb.agreeType == 2) {
                this.eKY.setTextColor(ap.getColor(R.color.cp_cont_h));
                setTextNormalColor(this.eLa);
                return;
            }
            setTextNormalColor(this.eKY);
            this.eLa.setTextColor(ap.getColor(R.color.cp_link_tip_c));
            return;
        }
        setTextNormalColor(this.eKY);
        setTextNormalColor(this.eLa);
    }

    public void bpE() {
        bi(this.eKX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(View view) {
        int i = 0;
        int i2 = 1;
        if (this.eLb != null) {
            if (!this.eLe || com.baidu.tbadk.mutiprocess.f.checkUpIsLogin(getContext())) {
                if (this.eLe || bg.checkUpIsLogin(getContext())) {
                    if (view != this.eKY || this.eLq) {
                        if (view.getId() == this.eKX.getId() || (this.eLq && view.getId() == this.eKY.getId())) {
                            this.eKX.cancelAnimation();
                            if (this.eLg != null) {
                                this.eLg.type = 1;
                            }
                            if (this.eLb.hasAgree) {
                                if (this.eLb.agreeType == 2) {
                                    this.eLb.agreeType = 2;
                                    this.eLb.hasAgree = false;
                                    this.eLb.agreeNum--;
                                    updateUI();
                                    if (this.eLg != null) {
                                        this.eLg.etD = 1;
                                    }
                                } else {
                                    this.eLb.agreeType = 2;
                                    this.eLb.hasAgree = true;
                                    this.eLb.agreeNum++;
                                    ja(true);
                                    com.baidu.tieba.o.a.dxr().G(getTbPageContext());
                                    if (this.eLg != null) {
                                        this.eLg.etD = 0;
                                        i2 = 0;
                                    }
                                }
                                this.eLs.a(this.eLb, i2, getPageId(), this.eLe);
                            } else {
                                this.eLb.agreeType = 2;
                                this.eLb.hasAgree = true;
                                this.eLb.agreeNum++;
                                ja(true);
                                com.baidu.tieba.o.a.dxr().G(getTbPageContext());
                                if (this.eLg != null) {
                                    this.eLg.etD = 0;
                                }
                            }
                            i2 = 0;
                            this.eLs.a(this.eLb, i2, getPageId(), this.eLe);
                        } else if (view.getId() == this.eKZ.getId()) {
                            this.eKZ.cancelAnimation();
                            if (this.eLg != null) {
                                this.eLg.type = 2;
                            }
                            if (this.eLb.hasAgree) {
                                if (this.eLb.agreeType == 5) {
                                    this.eLb.agreeType = 5;
                                    this.eLb.hasAgree = false;
                                    updateUI();
                                    if (this.eLg != null) {
                                        this.eLg.etH = 0;
                                        i = 1;
                                    } else {
                                        i = 1;
                                    }
                                } else {
                                    this.eLb.agreeType = 5;
                                    this.eLb.hasAgree = true;
                                    this.eLb.agreeNum--;
                                    ja(false);
                                    if (this.eLg != null) {
                                        this.eLg.etH = 1;
                                    }
                                }
                            } else {
                                this.eLb.agreeType = 5;
                                this.eLb.hasAgree = true;
                                ja(false);
                                if (this.eLg != null) {
                                    this.eLg.etH = 1;
                                }
                            }
                            this.eLs.a(this.eLb, i, getPageId(), this.eLe);
                        }
                        this.eLs.a(this.eLb, this.eLc);
                        if (this.ajp != null) {
                            this.ajp.onClick(view);
                        }
                        bpF();
                    }
                }
            }
        }
    }

    public void bpF() {
        if (this.eLg != null && this.eLb != null) {
            int i = 0;
            if (this.eLb.baijiahaoData != null) {
                i = this.eLb.baijiahaoData.oriUgcType;
            }
            if (this.eLg.type == 1) {
                if (StringUtils.isNull(this.eLl)) {
                    aq dR = new aq("c12003").aj("obj_locate", this.eLg.etA).aj("obj_param1", this.eLg.etB).aj("obj_source", this.eLg.etC).aj("obj_id", this.eLg.etD).aj("obj_name", i).dR("post_id", this.eLb.postId);
                    if (this.erH != null) {
                        dR.dR("tid", this.erH.getId()).dR("nid", this.erH.getNid()).w("fid", this.erH.getFid()).aj(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.erH.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.erH.mRecomSource).dR("weight", this.erH.mRecomWeight).dR("extra", this.erH.mRecomExtra);
                        if (this.erH.getBaijiahaoData() != null) {
                            dR.dR("obj_param4", this.erH.getBaijiahaoData().oriUgcNid);
                            if (this.erH.biJ() || this.erH.blW()) {
                                dR.dR("obj_param6", this.erH.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.erH.blU()) {
                            dR.aj("obj_param5", 2);
                        } else if (this.erH.biI() || this.erH.biJ()) {
                            dR.aj("obj_param5", 3);
                        } else if (this.erH.threadType == 0 || this.erH.threadType == 40) {
                            dR.aj("obj_param5", 1);
                        }
                    } else {
                        dR.dR("tid", this.eLb.threadId);
                        dR.dR("nid", this.eLb.nid);
                        dR.dR("fid", this.eLb.forumId);
                        dR.aj(IntentConfig.CARD_TYPE, this.eLb.cardType);
                        dR.dR("ab_tag", this.eLb.recomAbTag);
                        dR.dR(IntentConfig.RECOM_SOURCE, this.eLb.recomSource);
                        dR.dR("weight", this.eLb.recomWeight);
                        dR.dR("extra", this.eLb.recomExtra);
                        if (this.eLb.baijiahaoData != null) {
                            dR.dR("obj_param6", this.eLb.baijiahaoData.oriUgcVid);
                        }
                    }
                    if (pr(this.eLg.etA) && ps(this.eLg.etE) != -1) {
                        dR.aj(TiebaInitialize.Params.OBJ_TO, ps(this.eLg.etE));
                    }
                    if (this.mFrom == 1 || this.mFrom == 2) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.aj("resource_id", this.eLh);
                    } else if (this.mFrom == 18) {
                        dR.dR("obj_tab", "a099");
                        dR.dR("resource_id", this.mTabName);
                    } else {
                        dR.aj("resource_id", this.eLh);
                    }
                    if (getTbPageContext() != null) {
                        com.baidu.tbadk.pageInfo.c.a(getTbPageContext().getPageActivity(), dR);
                    }
                    if (this.eLb.isFromImageViewer) {
                        dR.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                        if (this.eLb.mImageViewerFromPage == "index") {
                            dR.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        }
                    }
                    if ("index".equals(this.eLb.keyFromHomePage)) {
                        dR.dR("obj_pre_page", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                        dR.dR("obj_cur_page", PageStayDurationConstants.PageName.VIDEO_LIST);
                    }
                    TiebaStatic.log(dR);
                    return;
                }
                TiebaStatic.log(new aq("c13358").dR("tid", this.eLb.threadId).dR("topic_id", this.eLl));
            } else if (this.eLg.type == 2) {
                aq dR2 = new aq("c13271").aj("obj_type", this.eLg.etF).aj("obj_locate", this.eLg.etG).aj(TiebaInitialize.Params.OBJ_PARAM2, this.eLh).aj("obj_id", this.eLg.etH).aj("obj_name", i).dR("post_id", this.eLb.postId).dR("nid", this.eLb.nid);
                if (this.erH != null) {
                    dR2.dR("tid", this.erH.getId()).dR("nid", this.erH.getNid()).w("fid", this.erH.getFid()).aj(IntentConfig.CARD_TYPE, this.cardType).dR("ab_tag", this.erH.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.erH.mRecomSource).dR("weight", this.erH.mRecomWeight).dR("extra", this.erH.mRecomExtra);
                    if (this.erH.getBaijiahaoData() != null) {
                        dR2.dR("obj_param4", this.erH.getBaijiahaoData().oriUgcNid);
                        if (this.erH.biJ() || this.erH.blW()) {
                            dR2.dR("obj_param6", this.erH.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.erH.blU()) {
                        dR2.aj("obj_param5", 2);
                    } else if (this.erH.biI() || this.erH.biJ()) {
                        dR2.aj("obj_param5", 3);
                    } else if (this.erH.threadType == 0 || this.erH.threadType == 40) {
                        dR2.aj("obj_param5", 1);
                    }
                } else {
                    dR2.dR("tid", this.eLb.threadId);
                    dR2.dR("nid", this.eLb.nid);
                    dR2.dR("fid", this.eLb.forumId);
                    dR2.aj(IntentConfig.CARD_TYPE, this.eLb.cardType);
                    dR2.dR("ab_tag", this.eLb.recomAbTag);
                    dR2.dR(IntentConfig.RECOM_SOURCE, this.eLb.recomSource);
                    dR2.dR("weight", this.eLb.recomWeight);
                    dR2.dR("extra", this.eLb.recomExtra);
                    if (this.eLb.baijiahaoData != null) {
                        dR2.dR("obj_param6", this.eLb.baijiahaoData.oriUgcVid);
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
                if (this.eLb.isFromImageViewer) {
                    dR2.dR("obj_tab", PageStayDurationConstants.PageName.BIGIMAGE);
                    if (this.eLb.mImageViewerFromPage == "index") {
                        dR2.dR(GuildActivityConfig.FROM_PAGE, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                    }
                }
                TiebaStatic.log(dR2);
            }
        }
    }

    public static boolean pr(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    public static int ps(int i) {
        if (i == 2) {
            return 1;
        }
        return i != 3 ? -1 : 2;
    }

    public Animation getScaleAnimation() {
        if (this.eLd == null) {
            this.eLd = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.eLd.setDuration(200L);
        }
        return this.eLd;
    }

    public void onChangeSkinType(int i) {
        if (this.eLb != null && this.mSkinType != i) {
            this.mSkinType = i;
            ap.a(this.eKX, this.eLi);
            ap.a(this.eKZ, this.eLj);
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
        this.eLg = cVar;
    }

    public void setGameId(int i) {
        this.eLh = i;
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }

    public void setAgreeAlone(boolean z) {
        this.eKZ.setVisibility(z ? 8 : 0);
        this.eLa.setVisibility(z ? 8 : 0);
        if (z && this.eLn != null) {
            this.eLn.setVisibility(8);
        }
        if (this.eLp != z && this.eLr != null) {
            this.eLr.e(this.eKZ, z);
        }
        this.eLp = z;
    }

    public void setDisagreeShow(boolean z) {
        this.eKZ.setVisibility(z ? 8 : 0);
        this.eLa.setVisibility(z ? 8 : 0);
        if (this.eLn != null) {
            this.eLn.setVisibility(z ? 8 : 0);
        }
        this.eLp = z;
    }

    public boolean bpG() {
        return this.eLp;
    }

    public void setThreadData(bw bwVar) {
        this.erH = bwVar;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setResourceId(int i, int i2) {
        this.eLi = i;
        this.eLj = i2;
        setAgreeAnimationResource();
    }

    public void setNormalColorResourceId(int i) {
        this.eLk = i;
        setTextNormalColor(this.eKY);
        setTextNormalColor(this.eLa);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajp = onClickListener;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setVisibilityListener(a aVar) {
        this.eLr = aVar;
    }
}
