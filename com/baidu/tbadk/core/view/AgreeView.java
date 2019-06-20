package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
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
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private ColorFilter Yy;
    private int bVA;
    private ScaleAnimation bVB;
    private String bVC;
    private boolean bVD;
    private boolean bVE;
    private com.baidu.tbadk.core.data.d bVF;
    private TBLottieAnimationView bVn;
    private TextView bVo;
    private int bVp;
    private AgreeData bVq;
    private com.baidu.tieba.tbadkCore.data.e bVr;
    private CustomMessageListener bVt;
    private CustomMessageListener bVu;
    private TBLottieAnimationView bVw;
    private int bVx;
    private int bVy;
    private int bVz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bVt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVq != null && !TextUtils.isEmpty(AgreeView.this.bVq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bVq.threadId.equals(agreeData.threadId) && AgreeView.this.bVr.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.Jf();
                    }
                }
            }
        };
        this.bVu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVq != null && !TextUtils.isEmpty(AgreeView.this.bVq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bVq.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bVD) {
                            if (AgreeView.this.bVq.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bVr.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.Jf();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aK(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bVt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVq != null && !TextUtils.isEmpty(AgreeView.this.bVq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bVq.threadId.equals(agreeData.threadId) && AgreeView.this.bVr.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.Jf();
                    }
                }
            }
        };
        this.bVu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVq != null && !TextUtils.isEmpty(AgreeView.this.bVq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bVq.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bVD) {
                            if (AgreeView.this.bVq.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bVr.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.Jf();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aK(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bVt = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVq != null && !TextUtils.isEmpty(AgreeView.this.bVq.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bVq.threadId.equals(agreeData.threadId) && AgreeView.this.bVr.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.Jf();
                    }
                }
            }
        };
        this.bVu = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVq != null && !TextUtils.isEmpty(AgreeView.this.bVq.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bVq.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bVD) {
                            if (AgreeView.this.bVq.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bVr.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bVq.agreeType = agreeData.agreeType;
                        AgreeView.this.bVq.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVq.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVq.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVq.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.Jf();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aK(view);
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.bVp = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds136);
        this.bVx = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds17);
        this.bVy = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds7);
        this.bVz = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds3);
        this.bVA = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds13);
        this.bVn = new TBLottieAnimationView(context);
        this.bVn.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bVp, this.bVp);
        layoutParams.gravity = 16;
        addView(this.bVn, layoutParams);
        this.bVn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bVn.setOnClickListener(this.mOnClickListener);
        this.bVo = new TextView(context);
        this.bVo.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.bVx;
        layoutParams2.rightMargin = this.bVx;
        addView(this.bVo, layoutParams2);
        this.bVw = new TBLottieAnimationView(context);
        this.bVw.setId(R.id.img_disagree);
        this.bVw.a(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.bVp, this.bVp);
        layoutParams3.gravity = 16;
        addView(this.bVw, layoutParams3);
        this.bVw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bVn.a(this);
        this.bVw.setOnClickListener(this.mOnClickListener);
        this.bVC = context.getString(R.string.agree_disagree);
        this.Yy = new com.airbnb.lottie.k(al.getColor(R.color.cp_cont_j));
        this.bVr = new com.baidu.tieba.tbadkCore.data.e();
        this.bVr.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bVt);
        MessageManager.getInstance().registerListener(this.bVu);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bVt);
        MessageManager.getInstance().unRegisterListener(this.bVu);
    }

    public void setIsFromBigpic(boolean z) {
        this.bVD = z;
        if (z) {
            this.Yy = new PorterDuffColorFilter(al.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.bVE = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.bVn;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.bVw;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bVq = agreeData;
            Jf();
        }
    }

    public AgreeData getData() {
        return this.bVq;
    }

    public void setAgreeAnimationResource(int i) {
        this.bVn.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.bVw.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.bVp = i;
        this.bVx = i2;
        this.bVy = i3;
        this.bVz = i4;
        this.bVA = i5;
        ViewGroup.LayoutParams layoutParams = this.bVn.getLayoutParams();
        layoutParams.width = this.bVp;
        layoutParams.height = this.bVp;
        this.bVn.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.bVw.getLayoutParams();
        layoutParams2.width = this.bVp;
        layoutParams2.height = this.bVp;
        this.bVw.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bVo.getLayoutParams();
        layoutParams3.leftMargin = this.bVx;
        layoutParams3.rightMargin = this.bVx;
        this.bVo.setLayoutParams(layoutParams3);
    }

    private String a(AgreeData agreeData) {
        if (agreeData == null || (agreeData.agreeNum == 0 && agreeData.diffAgreeNum == 0)) {
            return getContext().getString(R.string.agree_disagree);
        }
        if (agreeData.diffAgreeNum >= 0) {
            return ap.aM(agreeData.diffAgreeNum);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + ap.aM(-agreeData.diffAgreeNum);
    }

    public void Jf() {
        String a = a(this.bVq);
        ou(a);
        this.bVo.setText(a);
        if (this.bVq.hasAgree) {
            if (this.bVq.agreeType == 2) {
                this.bVw.setProgress(0.0f);
                this.bVn.setProgress(1.0f);
                this.bVo.setTextColor(al.getColor(R.color.cp_cont_h));
                return;
            }
            this.bVn.setProgress(0.0f);
            this.bVw.setProgress(1.0f);
            this.bVo.setTextColor(al.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.bVn.setMinAndMaxProgress(0.0f, 0.0f);
        this.bVw.setMinAndMaxProgress(0.0f, 0.0f);
        this.bVn.setProgress(0.0f);
        this.bVw.setProgress(0.0f);
        if (this.bVE) {
            this.bVo.setTextColor(al.getColor(R.color.cp_cont_d));
        } else if (this.bVD) {
            this.bVo.setTextColor(al.getColor(R.color.white_alpha83));
        } else {
            this.bVo.setTextColor(al.getColor(R.color.cp_cont_j));
        }
    }

    private void ou(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVo.getLayoutParams();
            if (str.equals(this.bVC)) {
                layoutParams.leftMargin = this.bVx;
                layoutParams.rightMargin = this.bVx;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.bVy;
                layoutParams.rightMargin = this.bVy;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.bVz;
                layoutParams.rightMargin = this.bVz;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.bVA;
                layoutParams.rightMargin = this.bVA;
            } else {
                layoutParams.leftMargin = this.bVx;
                layoutParams.rightMargin = this.bVx;
            }
            this.bVo.setLayoutParams(layoutParams);
        }
    }

    public void ed(boolean z) {
        this.bVn.setMinAndMaxProgress(0.0f, 1.0f);
        this.bVw.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.bVq);
        ou(a);
        this.bVo.setText(a);
        this.bVn.clearColorFilter();
        this.bVw.clearColorFilter();
        if (z) {
            this.bVn.bo();
            this.bVw.cancelAnimation();
            this.bVw.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.bVw.bo();
            this.bVn.cancelAnimation();
            this.bVn.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.bVn.setFrame(0);
        this.bVw.setFrame(0);
        if (this.bVq.hasAgree) {
            if (this.bVq.agreeType == 2) {
                this.bVo.setTextColor(al.getColor(R.color.cp_cont_h));
                return;
            } else {
                this.bVo.setTextColor(al.getColor(R.color.cp_link_tip_c));
                return;
            }
        }
        this.bVo.setTextColor(al.getColor(R.color.cp_cont_c));
    }

    public void aja() {
        aK(this.bVn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(View view) {
        int i;
        int i2 = 0;
        if (this.bVq != null) {
            if (!this.bVD || com.baidu.tbadk.n.a.cE(getContext())) {
                if (this.bVD || bc.cE(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).bo();
                    }
                    if (view.getId() == this.bVn.getId()) {
                        if (this.bVF != null) {
                            this.bVF.type = 1;
                        }
                        if (this.bVq.hasAgree) {
                            if (this.bVq.agreeType == 2) {
                                this.bVq.agreeType = 2;
                                this.bVq.hasAgree = false;
                                this.bVq.diffAgreeNum--;
                                this.bVq.agreeNum--;
                                Jf();
                                if (this.bVF != null) {
                                    this.bVF.bEC = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.bVq.agreeType = 2;
                                this.bVq.hasAgree = true;
                                this.bVq.diffAgreeNum += 2;
                                this.bVq.agreeNum++;
                                this.bVq.disAgreeNum--;
                                ed(true);
                                com.baidu.tieba.n.a.ceu().x(getTbPageContext());
                                if (this.bVF != null) {
                                    this.bVF.bEC = 0;
                                    i = 0;
                                }
                            }
                            iq(i);
                        } else {
                            this.bVq.agreeType = 2;
                            this.bVq.hasAgree = true;
                            this.bVq.diffAgreeNum++;
                            this.bVq.agreeNum++;
                            ed(true);
                            com.baidu.tieba.n.a.ceu().x(getTbPageContext());
                            if (this.bVF != null) {
                                this.bVF.bEC = 0;
                            }
                        }
                        i = 0;
                        iq(i);
                    } else if (view.getId() == this.bVw.getId()) {
                        if (this.bVF != null) {
                            this.bVF.type = 2;
                        }
                        if (this.bVq.hasAgree) {
                            if (this.bVq.agreeType == 5) {
                                this.bVq.agreeType = 5;
                                this.bVq.hasAgree = false;
                                this.bVq.diffAgreeNum++;
                                this.bVq.disAgreeNum--;
                                Jf();
                                if (this.bVF != null) {
                                    this.bVF.bEF = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.bVq.agreeType = 5;
                                this.bVq.hasAgree = true;
                                this.bVq.diffAgreeNum -= 2;
                                this.bVq.agreeNum--;
                                this.bVq.disAgreeNum++;
                                ed(false);
                                if (this.bVF != null) {
                                    this.bVF.bEF = 1;
                                }
                            }
                        } else {
                            this.bVq.agreeType = 5;
                            this.bVq.hasAgree = true;
                            this.bVq.diffAgreeNum--;
                            this.bVq.disAgreeNum++;
                            ed(false);
                            if (this.bVF != null) {
                                this.bVF.bEF = 1;
                            }
                        }
                        iq(i2);
                    }
                    this.bVr.agreeData = this.bVq;
                    if (this.bVq.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bVr));
                        a(this.bVq, "isInThread");
                    } else if (this.bVq.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bVr));
                        a(this.bVq, "isInPost");
                    }
                    ajb();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iq(int i) {
        if (this.bVq != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bVq.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bVq.objType == 0) {
                this.bVq.objType = 3;
            }
            httpMessage.addParam("obj_type", this.bVq.objType);
            httpMessage.addParam("agree_type", this.bVq.agreeType);
            httpMessage.addParam("forum_id", this.bVq.forumId);
            if (!TextUtils.isEmpty(this.bVq.postId)) {
                httpMessage.addParam("post_id", this.bVq.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.bVD) {
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getBduss())) {
                    httpMessage.addParam("BDUSS", com.baidu.tbadk.n.a.getBduss());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getTbs())) {
                    httpMessage.addParam("tbs", com.baidu.tbadk.n.a.getTbs());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getStoken())) {
                    httpMessage.addParam(ISapiAccount.SAPI_ACCOUNT_STOKEN, com.baidu.tbadk.n.a.getStoken());
                }
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void ajb() {
        if (this.bVF != null) {
            if (this.bVF.type == 1) {
                TiebaStatic.log(new am("c12003").P("obj_locate", this.bVF.bEz).P("obj_param1", this.bVF.bEA).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bVF.bEB).P(VideoPlayActivityConfig.OBJ_ID, this.bVF.bEC));
            } else if (this.bVF.type == 2) {
                TiebaStatic.log(new am("c13271").P("obj_type", this.bVF.bED).P("obj_locate", this.bVF.bEE).P(VideoPlayActivityConfig.OBJ_ID, this.bVF.bEF));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.bVB == null) {
            this.bVB = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bVB.setDuration(200L);
        }
        return this.bVB;
    }

    public void onChangeSkinType(int i) {
        if (this.bVq != null && this.mSkinType != i) {
            if (this.bVD) {
                this.Yy = new PorterDuffColorFilter(al.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            al.a(this.bVn, (int) R.raw.agree);
            al.a(this.bVw, (int) R.raw.disagree);
            Jf();
            this.mSkinType = i;
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
        Jf();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.bVF = dVar;
    }
}
