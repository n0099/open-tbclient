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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    private ColorFilter IS;
    private TBLottieAnimationView cmB;
    private int cmC;
    private int cmD;
    private int cmE;
    private int cmF;
    private ScaleAnimation cmG;
    private String cmH;
    private boolean cmI;
    private boolean cmJ;
    private com.baidu.tbadk.core.data.d cmK;
    private int cmL;
    private TBLottieAnimationView cms;
    private TextView cmt;
    private int cmu;
    private AgreeData cmv;
    private com.baidu.tieba.tbadkCore.data.e cmw;
    private CustomMessageListener cmy;
    private CustomMessageListener cmz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private int mSkinType;

    public AgreeView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cmy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cmv != null && !TextUtils.isEmpty(AgreeView.this.cmv.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.cmv.threadId.equals(agreeData.threadId) && AgreeView.this.cmw.uniqueId != eVar.uniqueId) {
                        AgreeView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
                    }
                }
            }
        };
        this.cmz = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cmv != null && !TextUtils.isEmpty(AgreeView.this.cmv.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.cmv.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.cmI) {
                            if (AgreeView.this.cmv.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.cmw.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aN(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cmy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cmv != null && !TextUtils.isEmpty(AgreeView.this.cmv.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.cmv.threadId.equals(agreeData.threadId) && AgreeView.this.cmw.uniqueId != eVar.uniqueId) {
                        AgreeView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
                    }
                }
            }
        };
        this.cmz = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cmv != null && !TextUtils.isEmpty(AgreeView.this.cmv.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.cmv.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.cmI) {
                            if (AgreeView.this.cmv.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.cmw.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aN(view);
            }
        };
        init(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cmy = new CustomMessageListener(2016528) { // from class: com.baidu.tbadk.core.view.AgreeView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cmv != null && !TextUtils.isEmpty(AgreeView.this.cmv.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && AgreeView.this.cmv.threadId.equals(agreeData.threadId) && AgreeView.this.cmw.uniqueId != eVar.uniqueId) {
                        AgreeView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
                    }
                }
            }
        };
        this.cmz = new CustomMessageListener(2016530) { // from class: com.baidu.tbadk.core.view.AgreeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    com.baidu.tieba.tbadkCore.data.e eVar = (com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData();
                    AgreeData agreeData = eVar.agreeData;
                    if (AgreeView.this.cmv != null && !TextUtils.isEmpty(AgreeView.this.cmv.postId) && agreeData != null && !TextUtils.isEmpty(agreeData.postId) && AgreeView.this.cmv.postId.equals(agreeData.postId)) {
                        if (AgreeView.this.cmI) {
                            if (AgreeView.this.cmv.indexOfPic == agreeData.indexOfPic) {
                                return;
                            }
                        } else if (AgreeView.this.cmw.uniqueId == eVar.uniqueId) {
                            return;
                        }
                        AgreeView.this.cmv.agreeType = agreeData.agreeType;
                        AgreeView.this.cmv.hasAgree = agreeData.hasAgree;
                        AgreeView.this.cmv.diffAgreeNum = agreeData.diffAgreeNum;
                        AgreeView.this.cmv.agreeNum = agreeData.agreeNum;
                        AgreeView.this.cmv.disAgreeNum = agreeData.disAgreeNum;
                        AgreeView.this.updateUI();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.AgreeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeView.this.aN(view);
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
        setGravity(5);
        this.cmu = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136);
        this.cmC = -com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds17);
        this.cmD = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds7);
        this.cmE = -com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds3);
        this.cmF = -com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds13);
        this.cms = new TBLottieAnimationView(context);
        this.cms.setId(R.id.img_agree);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cmu, this.cmu);
        layoutParams.gravity = 16;
        addView(this.cms, layoutParams);
        this.cms.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cms.setOnClickListener(this.mOnClickListener);
        this.cmt = new TextView(context);
        this.cmt.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = this.cmC;
        layoutParams2.rightMargin = this.cmC;
        addView(this.cmt, layoutParams2);
        this.cmB = new TBLottieAnimationView(context);
        this.cmB.setId(R.id.img_disagree);
        this.cmB.addAnimatorListener(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.cmu, this.cmu);
        layoutParams3.gravity = 16;
        addView(this.cmB, layoutParams3);
        this.cmB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cms.addAnimatorListener(this);
        this.cmB.setOnClickListener(this.mOnClickListener);
        this.cmH = context.getString(R.string.agree_disagree);
        this.IS = new com.airbnb.lottie.k(am.getColor(R.color.cp_cont_j));
        this.cmw = new com.baidu.tieba.tbadkCore.data.e();
        this.cmw.uniqueId = getPageId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cmy);
        MessageManager.getInstance().registerListener(this.cmz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cmy);
        MessageManager.getInstance().unRegisterListener(this.cmz);
    }

    public void setIsFromBigpic(boolean z) {
        this.cmI = z;
        if (z) {
            this.IS = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        this.cmJ = z;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.cms;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.cmB;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData != null) {
            this.cmv = agreeData;
            updateUI();
        }
    }

    public AgreeData getData() {
        return this.cmv;
    }

    public void setAgreeAnimationResource(int i) {
        this.cms.setAnimation(i);
    }

    public void setDisagreeAnimationResource(int i) {
        this.cmB.setAnimation(i);
    }

    public void setLayoutParams(int i, int i2, int i3, int i4, int i5) {
        this.cmu = i;
        this.cmC = i2;
        this.cmD = i3;
        this.cmE = i4;
        this.cmF = i5;
        ViewGroup.LayoutParams layoutParams = this.cms.getLayoutParams();
        layoutParams.width = this.cmu;
        layoutParams.height = this.cmu;
        this.cms.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.cmB.getLayoutParams();
        layoutParams2.width = this.cmu;
        layoutParams2.height = this.cmu;
        this.cmB.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.cmt.getLayoutParams();
        layoutParams3.leftMargin = this.cmC;
        layoutParams3.rightMargin = this.cmC;
        this.cmt.setLayoutParams(layoutParams3);
    }

    private String a(AgreeData agreeData) {
        if (agreeData == null || (agreeData.agreeNum == 0 && agreeData.diffAgreeNum == 0)) {
            return getContext().getString(R.string.agree_disagree);
        }
        if (agreeData.diffAgreeNum >= 0) {
            return aq.numFormatOverWanNa(agreeData.diffAgreeNum);
        }
        return Constants.ACCEPT_TIME_SEPARATOR_SERVER + aq.numFormatOverWanNa(-agreeData.diffAgreeNum);
    }

    public void updateUI() {
        String a = a(this.cmv);
        ot(a);
        this.cmt.setText(a);
        if (this.cmv.hasAgree) {
            if (this.cmv.agreeType == 2) {
                this.cmB.setProgress(0.0f);
                this.cms.setProgress(1.0f);
                this.cmt.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            }
            this.cms.setProgress(0.0f);
            this.cmB.setProgress(1.0f);
            this.cmt.setTextColor(am.getColor(R.color.cp_link_tip_c));
            return;
        }
        this.cms.setMinAndMaxProgress(0.0f, 0.0f);
        this.cmB.setMinAndMaxProgress(0.0f, 0.0f);
        this.cms.setProgress(0.0f);
        this.cmB.setProgress(0.0f);
        if (this.cmJ) {
            this.cmt.setTextColor(am.getColor(R.color.cp_cont_d));
        } else if (this.cmI) {
            this.cmt.setTextColor(am.getColor(R.color.white_alpha83));
        } else {
            this.cmt.setTextColor(am.getColor(R.color.cp_cont_j));
        }
    }

    private void ot(String str) {
        if (str != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmt.getLayoutParams();
            if (str.equals(this.cmH)) {
                layoutParams.leftMargin = this.cmC;
                layoutParams.rightMargin = this.cmC;
            } else if (str.length() == 1) {
                layoutParams.leftMargin = this.cmD;
                layoutParams.rightMargin = this.cmD;
            } else if (str.length() == 2) {
                layoutParams.leftMargin = this.cmE;
                layoutParams.rightMargin = this.cmE;
            } else if (str.length() == 3) {
                layoutParams.leftMargin = this.cmF;
                layoutParams.rightMargin = this.cmF;
            } else {
                layoutParams.leftMargin = this.cmC;
                layoutParams.rightMargin = this.cmC;
            }
            this.cmt.setLayoutParams(layoutParams);
        }
    }

    public void ep(boolean z) {
        this.cms.setMinAndMaxProgress(0.0f, 1.0f);
        this.cmB.setMinAndMaxProgress(0.0f, 1.0f);
        String a = a(this.cmv);
        ot(a);
        this.cmt.setText(a);
        this.cms.clearColorFilter();
        this.cmB.clearColorFilter();
        if (z) {
            this.cms.playAnimation();
            this.cmB.cancelAnimation();
            this.cmB.setMinAndMaxProgress(0.0f, 0.0f);
        } else {
            this.cmB.playAnimation();
            this.cms.cancelAnimation();
            this.cms.setMinAndMaxProgress(0.0f, 0.0f);
        }
        this.cms.setFrame(0);
        this.cmB.setFrame(0);
        if (this.cmv.hasAgree) {
            if (this.cmv.agreeType == 2) {
                this.cmt.setTextColor(am.getColor(R.color.cp_cont_h));
                return;
            } else {
                this.cmt.setTextColor(am.getColor(R.color.cp_link_tip_c));
                return;
            }
        }
        this.cmt.setTextColor(am.getColor(R.color.cp_cont_c));
    }

    public void anu() {
        aN(this.cms);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(View view) {
        int i;
        int i2 = 0;
        if (this.cmv != null) {
            if (!this.cmI || com.baidu.tbadk.n.a.checkUpIsLogin(getContext())) {
                if (this.cmI || bc.checkUpIsLogin(getContext())) {
                    if (view instanceof TBLottieAnimationView) {
                        ((TBLottieAnimationView) view).playAnimation();
                    }
                    if (view.getId() == this.cms.getId()) {
                        if (this.cmK != null) {
                            this.cmK.type = 1;
                        }
                        if (this.cmv.hasAgree) {
                            if (this.cmv.agreeType == 2) {
                                this.cmv.agreeType = 2;
                                this.cmv.hasAgree = false;
                                this.cmv.diffAgreeNum--;
                                this.cmv.agreeNum--;
                                updateUI();
                                if (this.cmK != null) {
                                    this.cmK.bXT = 1;
                                    i = 1;
                                } else {
                                    i = 1;
                                }
                            } else {
                                this.cmv.agreeType = 2;
                                this.cmv.hasAgree = true;
                                this.cmv.diffAgreeNum += 2;
                                this.cmv.agreeNum++;
                                this.cmv.disAgreeNum--;
                                ep(true);
                                com.baidu.tieba.n.a.cfp().z(getTbPageContext());
                                if (this.cmK != null) {
                                    this.cmK.bXT = 0;
                                    i = 0;
                                }
                            }
                            iy(i);
                        } else {
                            this.cmv.agreeType = 2;
                            this.cmv.hasAgree = true;
                            this.cmv.diffAgreeNum++;
                            this.cmv.agreeNum++;
                            ep(true);
                            com.baidu.tieba.n.a.cfp().z(getTbPageContext());
                            if (this.cmK != null) {
                                this.cmK.bXT = 0;
                            }
                        }
                        i = 0;
                        iy(i);
                    } else if (view.getId() == this.cmB.getId()) {
                        if (this.cmK != null) {
                            this.cmK.type = 2;
                        }
                        if (this.cmv.hasAgree) {
                            if (this.cmv.agreeType == 5) {
                                this.cmv.agreeType = 5;
                                this.cmv.hasAgree = false;
                                this.cmv.diffAgreeNum++;
                                this.cmv.disAgreeNum--;
                                updateUI();
                                if (this.cmK != null) {
                                    this.cmK.bXW = 0;
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                            } else {
                                this.cmv.agreeType = 5;
                                this.cmv.hasAgree = true;
                                this.cmv.diffAgreeNum -= 2;
                                this.cmv.agreeNum--;
                                this.cmv.disAgreeNum++;
                                ep(false);
                                if (this.cmK != null) {
                                    this.cmK.bXW = 1;
                                }
                            }
                        } else {
                            this.cmv.agreeType = 5;
                            this.cmv.hasAgree = true;
                            this.cmv.diffAgreeNum--;
                            this.cmv.disAgreeNum++;
                            ep(false);
                            if (this.cmK != null) {
                                this.cmK.bXW = 1;
                            }
                        }
                        iy(i2);
                    }
                    this.cmw.agreeData = this.cmv;
                    if (this.cmv.isInThread) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, this.cmw));
                        a(this.cmv, "isInThread");
                    } else if (this.cmv.isInPost) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, this.cmw));
                        a(this.cmv, "isInPost");
                    }
                    anv();
                }
            }
        }
    }

    private void a(AgreeData agreeData, String str) {
    }

    public void iy(int i) {
        if (this.cmv != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", this.cmv.threadId);
            httpMessage.addParam("op_type", i);
            if (this.cmv.objType == 0) {
                this.cmv.objType = 3;
            }
            httpMessage.addParam("obj_type", this.cmv.objType);
            httpMessage.addParam("agree_type", this.cmv.agreeType);
            httpMessage.addParam("forum_id", this.cmv.forumId);
            if (!TextUtils.isEmpty(this.cmv.postId)) {
                httpMessage.addParam("post_id", this.cmv.postId);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (this.cmI) {
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getBduss())) {
                    httpMessage.addParam("BDUSS", com.baidu.tbadk.n.a.getBduss());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getTbs())) {
                    httpMessage.addParam("tbs", com.baidu.tbadk.n.a.getTbs());
                }
                if (!TextUtils.isEmpty(com.baidu.tbadk.n.a.getStoken())) {
                    httpMessage.addParam("stoken", com.baidu.tbadk.n.a.getStoken());
                }
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void anv() {
        if (this.cmK != null) {
            if (this.cmK.type == 1) {
                TiebaStatic.log(new an("c12003").O("obj_locate", this.cmK.bXQ).O("obj_param1", this.cmK.bXR).O("obj_source", this.cmK.bXS).O("resource_id", this.cmL).O("obj_id", this.cmK.bXT));
            } else if (this.cmK.type == 2) {
                TiebaStatic.log(new an("c13271").O("obj_type", this.cmK.bXU).O("obj_locate", this.cmK.bXV).O(TiebaInitialize.Params.OBJ_PARAM2, this.cmL).O("obj_id", this.cmK.bXW));
            }
        }
    }

    public Animation getScaleAnimation() {
        if (this.cmG == null) {
            this.cmG = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.cmG.setDuration(200L);
        }
        return this.cmG;
    }

    public void onChangeSkinType(int i) {
        if (this.cmv != null && this.mSkinType != i) {
            if (this.cmI) {
                this.IS = new PorterDuffColorFilter(am.getColor(R.color.white_alpha83), PorterDuff.Mode.SRC_IN);
            }
            am.a(this.cms, R.raw.agree);
            am.a(this.cmB, R.raw.disagree);
            updateUI();
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
        updateUI();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    public void setStatisticData(com.baidu.tbadk.core.data.d dVar) {
        this.cmK = dVar;
    }

    public void setGameId(int i) {
        this.cmL = i;
    }
}
