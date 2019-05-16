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
    private ColorFilter Yz;
    private ScaleAnimation bVA;
    private String bVB;
    private boolean bVC;
    private boolean bVD;
    private com.baidu.tbadk.core.data.d bVE;
    private TBLottieAnimationView bVm;
    private TextView bVn;
    private int bVo;
    private AgreeData bVp;
    private com.baidu.tieba.tbadkCore.data.e bVq;
    private CustomMessageListener bVs;
    private CustomMessageListener bVt;
    private TBLottieAnimationView bVv;
    private int bVw;
    private int bVx;
    private int bVy;
    private int bVz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bVs = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVp != null && !TextUtils.isEmpty(AgreeView.this.bVp.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bVp.threadId.equals(agreeData.threadId) && AgreeView.this.bVq.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.Jf();
                    }
                }
            }
        };
        this.bVt = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVp != null && !TextUtils.isEmpty(AgreeView.this.bVp.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bVp.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bVC) {
                            if (AgreeView.this.bVp.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bVq.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
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
        this.bVs = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVp != null && !TextUtils.isEmpty(AgreeView.this.bVp.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bVp.threadId.equals(agreeData.threadId) && AgreeView.this.bVq.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.Jf();
                    }
                }
            }
        };
        this.bVt = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVp != null && !TextUtils.isEmpty(AgreeView.this.bVp.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bVp.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bVC) {
                            if (AgreeView.this.bVp.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bVq.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
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
        this.bVs = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVp != null && !TextUtils.isEmpty(AgreeView.this.bVp.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.bVp.threadId.equals(agreeData.threadId) && AgreeView.this.bVq.uniqueId != eVar.uniqueId) {
                        AgreeView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.Jf();
                    }
                }
            }
        };
        this.bVt = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.bVp != null && !TextUtils.isEmpty(AgreeView.this.bVp.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.bVp.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.bVC) {
                            if (AgreeView.this.bVp.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.bVq.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.bVp.agreeType = agreeData.agreeType;
                        AgreeView.this.bVp.hasAgree = agreeData.hasAgree;
                        AgreeView.this.bVp.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.bVp.agreeNum = agreeData.agreeNum;
                        AgreeView.this.bVp.disAgreeNum = agreeData.disAgreeNum;
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
        this.bVo = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds136);
        this.bVw = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds17);
        this.bVx = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds7);
        this.bVy = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds3);
        this.bVz = -com.baidu.adp.lib.util.l.g(context, R.dimen.tbds13);
        this.bVm = new TBLottieAnimationView(context);
        this.bVm.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bVo, this.bVo);
        layoutParams.gravity = 16;
        addView(this.bVm, layoutParams);
        this.bVm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bVm.setOnClickListener(this.mOnClickListener);
        this.bVn = new TextView(context);
        this.bVn.setTextSize(0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.bVw;
        layoutParams2.rightMargin = this.bVw;
        addView(this.bVn, layoutParams2);
        this.bVv = new TBLottieAnimationView(context);
        this.bVv.setId(R.id.img_disagree);
        this.bVv.a(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.bVo, this.bVo);
        layoutParams3.gravity = 16;
        addView(this.bVv, layoutParams3);
        this.bVv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bVm.a(this);
        this.bVv.setOnClickListener(this.mOnClickListener);
        this.bVB = context.getString(R.string.agree_disagree);
        this.Yz = new com.airbnb.lottie.k(al.getColor(R.color.cp_cont_j));
        this.bVq = new com.baidu.tieba.tbadkCore.data.e();
        this.bVq.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.bVs);
        MessageManager.getInstance().registerListener(this.bVt);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.bVs);
        MessageManager.getInstance().unRegisterListener(this.bVt);
    }

    public void setIsFromBigpic(boolean z) {
        this.bVC = z;
        if (z) {
            this.Yz = new PorterDuffColorFilter(al.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.bVD = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.bVm;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.bVv;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.bVp = agreeData;
            Jf();
        }
    }

    public AgreeData getData() {
        return this.bVp;
    }

    public void setAgreeAnimationResource(int i) {
        this.bVm.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.bVv.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.bVo = i;
        this.bVw = i2;
        this.bVx = i3;
        this.bVy = i4;
        this.bVz = i5;
        ViewGroup.LayoutParams layoutParams = this.bVm.getLayoutParams();
        layoutParams.width = this.bVo;
        layoutParams.height = this.bVo;
        this.bVm.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.bVv.getLayoutParams();
        layoutParams2.width = this.bVo;
        layoutParams2.height = this.bVo;
        this.bVv.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bVn.getLayoutParams();
        layoutParams3.leftMargin = this.bVw;
        layoutParams3.rightMargin = this.bVw;
        this.bVn.setLayoutParams(layoutParams3);
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
        String a = a(this.bVp);
        ov(a);
        this.bVn.setText(a);
        if (this.bVp.hasAgree) {
            if (this.bVp.agreeType == 2) {
                this.bVv.setProgress(0.0f);
                this.bVm.setProgress(1.0f);
                this.bVn.setTextColor(al.getColor(R.color.cp_cont_h));
                return;
            }
            this.bVm.setProgress(0.0f);
            this.bVv.setProgress(1.0f);
            this.bVn.setTextColor(al.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.bVm.setMinAndMaxProgress(0.0f, 0.0f);
        this.bVv.setMinAndMaxProgress(0.0f, 0.0f);
        this.bVm.setProgress(0.0f);
        this.bVv.setProgress(0.0f);
        if (this.bVD) {
            this.bVn.setTextColor(al.getColor(R.color.cp_cont_d));
        } else if (this.bVC) {
            this.bVn.setTextColor(al.getColor(R.color.white_alpha83));
        } else {
            this.bVn.setTextColor(al.getColor(R.color.cp_cont_j));
        }
    }

    private void ov(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVn.getLayoutParams();
            if (str.equals(this.bVB)) {
                layoutParams.leftMargin = this.bVw;
                layoutParams.rightMargin = this.bVw;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.bVx;
                layoutParams.rightMargin = this.bVx;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.bVy;
                layoutParams.rightMargin = this.bVy;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.bVz;
                layoutParams.rightMargin = this.bVz;
            } else {
                layoutParams.leftMargin = this.bVw;
                layoutParams.rightMargin = this.bVw;
            }
            this.bVn.setLayoutParams(layoutParams);
        }
    }

    public void ed(boolean z) {
        this.bVm.setMinAndMaxProgress(0.0f, 1.0f);
        this.bVv.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.bVp);
        ov(a);
        this.bVn.setText(a);
        this.bVm.clearColorFilter();
        this.bVv.clearColorFilter();
        if (z) {
            this.bVm.bo();
            this.bVv.cancelAnimation();
            this.bVv.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.bVv.bo();
            this.bVm.cancelAnimation();
            this.bVm.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.bVm.setFrame(0);
        this.bVv.setFrame(0);
        if (this.bVp.hasAgree) {
            if (this.bVp.agreeType == 2) {
                this.bVn.setTextColor(al.getColor(R.color.cp_cont_h));
                return;
            } else {
                this.bVn.setTextColor(al.getColor(R.color.cp_link_tip_c));
                return;
            }
        }
        this.bVn.setTextColor(al.getColor(R.color.cp_cont_c));
    }

    public void aja() {
        aK(this.bVm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(View view) {
        int i;
        int i2 = 0;
        if (this.bVp != null) {
            if (!this.bVC || com.baidu.tbadk.n.a.cE(getContext())) {
                if (this.bVC || bc.cE(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).bo();
                    }
                    if (view.getId() == this.bVm.getId()) {
                        if (this.bVE != null) {
                            this.bVE.type = 1;
                        }
                        if (this.bVp.hasAgree) {
                            if (this.bVp.agreeType == 2) {
                                this.bVp.agreeType = 2;
                                this.bVp.hasAgree = false;
                                this.bVp.diffAgreeNum--;
                                this.bVp.agreeNum--;
                                Jf();
                                if (this.bVE != null) {
                                    this.bVE.bEB = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.bVp.agreeType = 2;
                                this.bVp.hasAgree = true;
                                this.bVp.diffAgreeNum += 2;
                                this.bVp.agreeNum++;
                                this.bVp.disAgreeNum--;
                                ed(true);
                                com.baidu.tieba.n.a.cer().x(getTbPageContext());
                                if (this.bVE != null) {
                                    this.bVE.bEB = 0;
                                    i = 0;
                                }
                            }
                            iq(i);
                        } else {
                            this.bVp.agreeType = 2;
                            this.bVp.hasAgree = true;
                            this.bVp.diffAgreeNum++;
                            this.bVp.agreeNum++;
                            ed(true);
                            com.baidu.tieba.n.a.cer().x(getTbPageContext());
                            if (this.bVE != null) {
                                this.bVE.bEB = 0;
                            }
                        }
                        i = 0;
                        iq(i);
                    } else if (view.getId() == this.bVv.getId()) {
                        if (this.bVE != null) {
                            this.bVE.type = 2;
                        }
                        if (this.bVp.hasAgree) {
                            if (this.bVp.agreeType == 5) {
                                this.bVp.agreeType = 5;
                                this.bVp.hasAgree = false;
                                this.bVp.diffAgreeNum++;
                                this.bVp.disAgreeNum--;
                                Jf();
                                if (this.bVE != null) {
                                    this.bVE.bEE = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.bVp.agreeType = 5;
                                this.bVp.hasAgree = true;
                                this.bVp.diffAgreeNum -= 2;
                                this.bVp.agreeNum--;
                                this.bVp.disAgreeNum++;
                                ed(false);
                                if (this.bVE != null) {
                                    this.bVE.bEE = 1;
                                }
                            }
                        } else {
                            this.bVp.agreeType = 5;
                            this.bVp.hasAgree = true;
                            this.bVp.diffAgreeNum--;
                            this.bVp.disAgreeNum++;
                            ed(false);
                            if (this.bVE != null) {
                                this.bVE.bEE = 1;
                            }
                        }
                        iq(i2);
                    }
                    this.bVq.agreeData = this.bVp;
                    if (this.bVp.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.bVq));
                        a(this.bVp, "isInThread");
                    } else if (this.bVp.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.bVq));
                        a(this.bVp, "isInPost");
                    }
                    ajb();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iq(int i) {
        if (this.bVp != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.bVp.threadId);
            httpMessage.addParam("op_type", i);
            if (this.bVp.objType == 0) {
                this.bVp.objType = 3;
            }
            httpMessage.addParam("obj_type", this.bVp.objType);
            httpMessage.addParam("agree_type", this.bVp.agreeType);
            httpMessage.addParam("forum_id", this.bVp.forumId);
            if (!TextUtils.isEmpty(this.bVp.postId)) {
                httpMessage.addParam("post_id", this.bVp.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.bVC) {
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
        if (this.bVE != null) {
            if (this.bVE.type == 1) {
                TiebaStatic.log(new am("c12003").P("obj_locate", this.bVE.bEy).P("obj_param1", this.bVE.bEz).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.bVE.bEA).P(VideoPlayActivityConfig.OBJ_ID, this.bVE.bEB));
            } else if (this.bVE.type == 2) {
                TiebaStatic.log(new am("c13271").P("obj_type", this.bVE.bEC).P("obj_locate", this.bVE.bED).P(VideoPlayActivityConfig.OBJ_ID, this.bVE.bEE));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.bVA == null) {
            this.bVA = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bVA.setDuration(200L);
        }
        return this.bVA;
    }

    public void onChangeSkinType(int i) {
        if (this.bVp != null && this.mSkinType != i) {
            if (this.bVC) {
                this.Yz = new PorterDuffColorFilter(al.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            al.a(this.bVm, (int) R.raw.agree);
            al.a(this.bVv, (int) R.raw.disagree);
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
        this.bVE = dVar;
    }
}
