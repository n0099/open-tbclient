package com.baidu.tbadk.core.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bj adG;
    private int agn;
    protected ImageView cao;
    private int dDp;
    private TextView dHA;
    protected AgreeView dHB;
    protected TextView dHC;
    protected ImageView dHD;
    protected View dHE;
    protected TextView dHF;
    protected ImageView dHG;
    protected View dHH;
    protected FrameLayout dHI;
    protected ImageView dHJ;
    protected TextView dHK;
    protected ImageView dHL;
    protected View dHM;
    protected aa dHN;
    protected TextView dHO;
    protected LinearLayout dHP;
    protected boolean dHQ;
    protected boolean dHR;
    protected boolean dHS;
    protected boolean dHT;
    protected boolean dHU;
    protected boolean dHV;
    protected boolean dHW;
    protected boolean dHX;
    protected boolean dHY;
    protected boolean dHZ;
    protected int dHy;
    protected TextView dHz;
    protected boolean dIa;
    private int dIb;
    public int dIc;
    public String dId;
    private String dIe;
    private View.OnClickListener dIf;
    protected int dIg;
    protected int dIh;
    private b dIi;
    private a dIj;
    private boolean dIk;
    CustomMessageListener dIl;
    CustomMessageListener dIm;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;

    /* loaded from: classes8.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void gS(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.dIe = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.dHB != null) {
            this.dHB.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.dIb = i;
    }

    public void setGameId(int i) {
        this.dDp = i;
        if (this.dHB != null) {
            this.dHB.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.dHB != null) {
            this.dHB.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dIl);
        MessageManager.getInstance().registerListener(this.dIm);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dIl);
        MessageManager.getInstance().unRegisterListener(this.dIm);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.dHy = 0;
        this.agn = 11;
        this.dHQ = false;
        this.dHR = true;
        this.dHS = true;
        this.dHT = true;
        this.dHU = false;
        this.dHV = false;
        this.dHW = true;
        this.dHX = false;
        this.dHY = true;
        this.dHZ = false;
        this.dIa = true;
        this.mFrom = 2;
        this.dIb = 1;
        this.mSkinType = 3;
        this.dIi = null;
        this.dIk = false;
        this.dIl = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.adG != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.adG.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.adG.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.adG.jQ(bjVar.aKv());
                                ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.adG.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.adG.jQ(bjVar.aKv());
                            ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                        }
                    }
                }
            }
        };
        this.dIm = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.adG != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.adG.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.adG.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.adG.aLS() || ThreadCommentAndPraiseInfoLayout.this.adG.aLV()) && ThreadCommentAndPraiseInfoLayout.this.adG.aKX() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.adG.aKX() != null && ThreadCommentAndPraiseInfoLayout.this.adG.aKX().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.adG.aKX().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.adG.cd(ThreadCommentAndPraiseInfoLayout.this.adG.aMd() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.w(ThreadCommentAndPraiseInfoLayout.this.adG);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dHy = 0;
        this.agn = 11;
        this.dHQ = false;
        this.dHR = true;
        this.dHS = true;
        this.dHT = true;
        this.dHU = false;
        this.dHV = false;
        this.dHW = true;
        this.dHX = false;
        this.dHY = true;
        this.dHZ = false;
        this.dIa = true;
        this.mFrom = 2;
        this.dIb = 1;
        this.mSkinType = 3;
        this.dIi = null;
        this.dIk = false;
        this.dIl = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.adG != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.adG.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.adG.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.adG.jQ(bjVar.aKv());
                                ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.adG.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.adG.jQ(bjVar.aKv());
                            ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                        }
                    }
                }
            }
        };
        this.dIm = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.adG != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.adG.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.adG.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.adG.aLS() || ThreadCommentAndPraiseInfoLayout.this.adG.aLV()) && ThreadCommentAndPraiseInfoLayout.this.adG.aKX() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.adG.aKX() != null && ThreadCommentAndPraiseInfoLayout.this.adG.aKX().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.adG.aKX().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.adG.cd(ThreadCommentAndPraiseInfoLayout.this.adG.aMd() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.w(ThreadCommentAndPraiseInfoLayout.this.adG);
                    }
                }
            }
        };
        init(context);
    }

    protected View dE(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.dHy = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View dE = dE(context);
        this.dHz = (TextView) dE.findViewById(R.id.thread_info_bar_name);
        this.dHA = (TextView) dE.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) dE.findViewById(R.id.thread_comment_layout_root);
        this.dHC = (TextView) dE.findViewById(R.id.thread_info_commont_num);
        this.dHD = (ImageView) dE.findViewById(R.id.thread_info_commont_img);
        this.dHE = dE.findViewById(R.id.thread_info_commont_container);
        this.dHF = (TextView) dE.findViewById(R.id.share_num);
        this.dHG = (ImageView) dE.findViewById(R.id.share_num_img);
        this.dHH = dE.findViewById(R.id.share_num_container);
        this.dHI = (FrameLayout) dE.findViewById(R.id.btn_card_bottom_op_more_container);
        this.dHJ = (ImageView) dE.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = dE.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.dHB = (AgreeView) findViewById;
            this.dHB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadCommentAndPraiseInfoLayout.this.dIf != null) {
                        ThreadCommentAndPraiseInfoLayout.this.dIf.onClick(view);
                    }
                }
            });
        }
        this.dHM = dE.findViewById(R.id.manage_view_container);
        this.dHK = (TextView) dE.findViewById(R.id.thread_info_manage_text);
        this.dHL = (ImageView) dE.findViewById(R.id.thread_info_manage_img);
        this.cao = (ImageView) dE.findViewById(R.id.manage_select_img);
        this.dHO = (TextView) dE.findViewById(R.id.manage_select_text);
        this.dHP = (LinearLayout) dE.findViewById(R.id.manage_select_container);
        this.dHP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cao.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cao.performClick();
            }
        });
        this.dHP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cao.performClick();
            }
        });
        this.dHE.setOnClickListener(this);
        this.dHH.setOnClickListener(this);
        this.dHM.setOnClickListener(this);
        this.cao.setOnClickListener(this);
        this.dIh = R.drawable.icon_home_card_share;
        this.dIg = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    public void setShowFlag(int i) {
        this.agn = i;
        rK();
    }

    private void rK() {
        int i;
        this.dHH.setVisibility(isShow(1) ? 0 : 8);
        this.dHE.setVisibility(isShow(2) ? 0 : 8);
        View view = this.dHM;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.dHB.setVisibility(isShow(8) ? 0 : 8);
        this.dHB.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.agn & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dHz) {
            aW(view);
        } else if (view == this.dHE) {
            aT(view);
        } else if (view == this.dHH) {
            aU(view);
        } else if (view == this.dHJ) {
            aY(view);
        } else if (view == this.dHM) {
            aX(view);
        } else if (view == this.cao) {
            aV(view);
        }
    }

    protected void aV(View view) {
        if (this.cao != null && this.adG != null && this.dHO != null && !this.adG.aMo()) {
            if (!this.adG.aMn()) {
                if (com.baidu.tieba.frs.a.bND().ak(this.adG)) {
                    this.adG.gA(true);
                }
            } else {
                com.baidu.tieba.frs.a.bND().al(this.adG);
                this.adG.gA(false);
            }
            am.setViewTextColor(this.dHO, this.adG.aMn() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cao.setImageDrawable(am.getDrawable(this.adG.aMn() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.dIi != null) {
                this.dIi.gS(this.adG.aMn());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.dHE != null) {
            this.dHE.setClickable(z);
            this.dHD.setEnabled(z);
            this.dHC.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.dHH != null) {
            this.dHH.setClickable(z);
            this.dHG.setEnabled(z);
            this.dHF.setEnabled(z);
        }
    }

    private void aW(View view) {
        if (this.adG != null && !StringUtils.isNull(this.adG.aKJ())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.dIe)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.adG.aKJ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.adG.aKJ(), this.mStType, this.dIe)));
            }
            if (this.dIf != null) {
                this.dIf.onClick(view);
            }
        }
    }

    private boolean t(bj bjVar) {
        return (bjVar == null || !bjVar.aJr() || bjVar.aKV() == null) ? false : true;
    }

    protected void aT(View view) {
        if (this.adG != null && this.mContext != null) {
            com.baidu.tieba.card.l.BB(this.adG.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.adG, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.adG.getFid()));
            addLocateParam.setForumName(this.adG.aKJ());
            if (this.adG.aMq() && this.adG.aMp() != null) {
                addLocateParam.setForumId(this.adG.aMp().getForumId());
                addLocateParam.setForumName(this.adG.aMp().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.dIj != null) {
                this.dIj.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(this.adG)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.am(this.adG);
            }
            if (this.adG.dtM) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.adG.aLI() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.dIc);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.af("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.af("obj_locate", this.mFrom);
            anVar2.af("obj_type", getThreadType());
            anVar2.cI("tid", this.adG.getTid());
            if (this.mFrom == 18) {
                anVar2.t("uid", TbadkApplication.getCurrentAccountId());
                anVar2.t("fid", this.adG.getFid());
                anVar2.af("obj_locate", 18);
                anVar2.cI("resource_id", this.mTabName);
            }
            TiebaStatic.log(anVar2);
            aQA();
            if (this.dIf != null) {
                this.dIf.onClick(view);
            }
        }
    }

    private void aQA() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            an anVar = new an("c13568");
            anVar.af("obj_source", threadSourceForDynamicAndBjh);
            anVar.af("obj_type", threadTypeForDynamicAndBjh);
            TiebaStatic.log(anVar);
        }
    }

    private int getThreadSourceForDynamicAndBjh() {
        if (this.mFrom == 4 || this.mFrom == 9) {
            return 1;
        }
        if (this.mFrom == 1) {
            return 2;
        }
        if (this.mFrom == 8 || this.mFrom == 13) {
            return 3;
        }
        return 0;
    }

    private int getThreadTypeForDynamicAndBjh() {
        if (this.adG == null) {
            return 0;
        }
        if (this.adG.aJt()) {
            return 1;
        }
        if (this.adG.aJu()) {
            return 2;
        }
        if (this.adG.aMy()) {
            return 3;
        }
        return this.adG.aMz() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.adG == null) {
            return 0;
        }
        if (this.adG.isShareThread) {
            return 4;
        }
        if (this.adG.getThreadType() == 49) {
            return 5;
        }
        if (this.adG.aKV() != null) {
            return 1;
        }
        if (this.adG.getType() == bj.dqE || this.adG.getType() == bj.dqU) {
            if (v.getCount(this.adG.aKS()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.adG != null || i >= 0) {
            an lz = lz(i);
            lz.af("thread_type", this.adG.getThreadType());
            TiebaStatic.log(lz);
        }
    }

    private an lz(int i) {
        if (this.adG == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.cI("tid", this.adG.getTid());
        if (this.adG.getThreadType() == 40) {
            anVar.cI("obj_param1", "2");
        } else if (this.adG.getThreadType() == 0) {
            anVar.cI("obj_param1", "1");
        }
        anVar.cI("obj_source", "1");
        anVar.t("fid", this.adG.getFid());
        anVar.af("obj_locate", this.mFrom);
        anVar.af("obj_id", i);
        if (!aq.isEmpty(this.dId)) {
            anVar.cI("obj_floor", this.dId);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aU(View view) {
        if ((ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) && this.adG != null) {
            aQB();
            if (!AntiHelper.d(getContext(), this.adG)) {
                aQD();
                if (this.dIf != null) {
                    this.dIf.onClick(view);
                }
            }
        }
    }

    private void aQB() {
        if (this.adG != null) {
            an aQC = aQC();
            aQC.af("thread_type", this.adG.getThreadType());
            TiebaStatic.log(aQC);
        }
    }

    private an aQC() {
        if (this.adG == null) {
            return null;
        }
        int i = 0;
        if (this.dIb == 1) {
            i = 4;
        } else if (this.dIb == 2) {
            i = 5;
        } else if (this.dIb == 3) {
            i = 3;
        } else if (this.dIb == 4) {
            i = 2;
        } else if (this.dIb == 6) {
            i = 8;
        } else if (this.dIb == 7) {
            i = 9;
        } else if (this.dIb == 9) {
            i = 10;
        } else if (this.dIb == 10) {
            i = 17;
        } else if (this.dIb == 18) {
            i = 20;
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.t("fid", this.adG.getFid());
        anVar.cI("tid", this.adG.getTid());
        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.af("obj_locate", i);
        anVar.af(TiebaInitialize.Params.OBJ_PARAM2, this.dDp);
        if (!aq.isEmpty(this.dId)) {
            anVar.cI("obj_floor", this.dId);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.adG.aKX() != null && this.adG.aKX().user_info != null && this.adG.aKX().user_info.is_official == 2) {
            anVar.af("obj_isofficial", this.adG.aKX().user_info.is_official);
        }
        anVar.af("card_type", this.adG.aMD()).cI(TiebaInitialize.Params.AB_TAG, this.adG.mRecomAbTag).cI("recom_source", this.adG.mRecomSource).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, this.adG.mRecomWeight).cI("extra", this.adG.mRecomExtra);
        if (this.adG.aJt()) {
            anVar.af("obj_type", 10);
        } else if (this.adG.aJu()) {
            anVar.af("obj_type", 9);
        } else if (this.adG.aMz()) {
            anVar.af("obj_type", 8);
        } else if (this.adG.aMy()) {
            anVar.af("obj_type", 7);
        } else if (this.adG.isShareThread) {
            anVar.af("obj_type", 6);
        } else if (this.adG.threadType == 0) {
            anVar.af("obj_type", 1);
        } else if (this.adG.threadType == 40) {
            anVar.af("obj_type", 2);
        } else if (this.adG.threadType == 49) {
            anVar.af("obj_type", 3);
        } else if (this.adG.threadType == 54) {
            anVar.af("obj_type", 4);
        } else {
            anVar.af("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            anVar.cI("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            anVar.cI("obj_tab", "a099");
            anVar.cI("resource_id", this.mTabName);
        }
        if (this.adG.getBaijiahaoData() != null) {
            anVar.cI("obj_param4", this.adG.getBaijiahaoData().oriUgcNid);
            if (this.adG.aJu() || this.adG.aMz()) {
                anVar.cI("obj_param6", this.adG.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.adG.aMx()) {
            anVar.af("obj_param5", 2);
        } else if (this.adG.aJt() || this.adG.aJu()) {
            anVar.af("obj_param5", 3);
        } else if (this.adG.threadType == 0 || this.adG.threadType == 40) {
            anVar.af("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), anVar);
        }
        return anVar;
    }

    private void aQD() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.adG != null && this.mContext != null) {
            String valueOf = String.valueOf(this.adG.getFid());
            String aKJ = this.adG.aKJ();
            if (this.adG.dtz != null) {
                valueOf = this.adG.dtz.id;
                aKJ = this.adG.dtz.ori_fname;
            }
            String title = this.adG.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.adG.getAbstract();
            }
            if (this.adG.aMA()) {
                tid = this.adG.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.adG.getBaijiahaoData().oriUgcType + "&dvid=" + this.adG.getBaijiahaoData().oriUgcVid + "&nid=" + this.adG.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.adG.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.adG.aKX() != null && this.adG.aKX().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.adG.aKX().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.adG.aKX().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String z2 = z(this.adG);
            Uri parse = z2 == null ? null : Uri.parse(z2);
            String str4 = this.adG.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.adG.aMA() || this.adG.aKE() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.adG.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.adG.aKE().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = aq.cutString(title, 100);
            String cutString2 = aq.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int A = A(this.adG);
            if (this.adG.aMA()) {
                shareItem.readCount = -1L;
                shareItem.dQv = cutString2;
            } else {
                if (A == 2 && this.adG.aKV() != null) {
                    shareItem.readCount = this.adG.aKV().play_count.intValue();
                } else if (A == 1) {
                    shareItem.readCount = this.adG.aKw();
                }
                shareItem.dQv = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aKJ;
            shareItem.tid = tid;
            shareItem.dQl = true;
            shareItem.dua = this.dIb;
            shareItem.dQx = getShareObjSource();
            shareItem.dQC = A;
            shareItem.dQy = 3;
            shareItem.dQz = y(this.adG);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.adG.aMA()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.dQM = this.adG.getShareImageUrl();
            }
            shareItem.dQF = OriginalThreadInfo.ShareInfo.generateShareInfo(this.adG);
            if (this.mFrom == 13) {
                shareItem.dQG = ShareItem.ForwardInfo.generateForwardInfo(this.adG, 2);
            } else {
                shareItem.dQG = ShareItem.ForwardInfo.generateForwardInfo(this.adG);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dQy);
            bundle.putInt("obj_type", shareItem.dQC);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dua);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z3 = false;
            shareDialogConfig.setIsAlaLive((this.adG.getThreadType() == 49 || this.adG.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.e.bGe().b(shareDialogConfig);
        }
    }

    private int y(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aJt()) {
            return 10;
        }
        if (bjVar.aJu()) {
            return 9;
        }
        if (bjVar.aMz()) {
            return 8;
        }
        if (bjVar.aMy()) {
            return 7;
        }
        if (bjVar.isShareThread) {
            return 6;
        }
        if (bjVar.threadType == 0) {
            return 1;
        }
        if (bjVar.threadType == 40) {
            return 2;
        }
        if (bjVar.threadType == 49) {
            return 3;
        }
        if (bjVar.threadType == 54) {
            return 4;
        }
        return 5;
    }

    private void a(ShareDialogConfig shareDialogConfig) {
        switch (this.mFrom) {
            case 1:
                shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
                return;
            case 2:
                shareDialogConfig.setFrom(ShareDialogConfig.From.FRS);
                return;
            case 3:
            case 5:
            case 6:
            case 10:
            case 11:
            case 14:
            case 15:
            default:
                shareDialogConfig.setFrom(ShareDialogConfig.From.Default);
                return;
            case 4:
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                return;
            case 7:
                shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
                return;
            case 8:
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                return;
            case 9:
                shareDialogConfig.setFrom(ShareDialogConfig.From.Concern);
                return;
            case 12:
                shareDialogConfig.setFrom(ShareDialogConfig.From.HomeGameTab);
                return;
            case 13:
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                return;
            case 16:
                shareDialogConfig.setFrom(ShareDialogConfig.From.HomeVideoTab);
                return;
        }
    }

    private int getShareObjSource() {
        if (this.dIb == 1) {
            return 5;
        }
        if (this.dIb != 3) {
            if (this.dIb == 4) {
                return 4;
            }
            if (this.dIb == 6) {
                return 8;
            }
            if (this.dIb != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String z(bj bjVar) {
        String str;
        if (bjVar == null) {
            return null;
        }
        if (bjVar.aKX() != null && !TextUtils.isEmpty(bjVar.aKX().cover)) {
            return bjVar.aKX().cover;
        }
        if (bjVar.aKO() == null) {
            return null;
        }
        ArrayList<MediaData> aKO = bjVar.aKO();
        int size = aKO.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aKO.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    str = mediaData.getThumbnails_url();
                    break;
                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    str = mediaData.getPicUrl();
                    break;
                }
            }
            i++;
        }
        if (str == null && bjVar.aKV() != null && !TextUtils.isEmpty(bjVar.aKV().thumbnail_url)) {
            return bjVar.aKV().thumbnail_url;
        }
        return str;
    }

    private int A(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aKG()) {
                return 4;
            }
            if (bjVar.aKB() == 1) {
                return 3;
            }
            if (bjVar.aJt()) {
                return 5;
            }
            if (bjVar.aJu()) {
                return 6;
            }
            if (bjVar.aMy()) {
                return 7;
            }
            if (bjVar.aMz()) {
                return 8;
            }
            if (!bjVar.isShareThread || bjVar.dto == null) {
                return bjVar.aLT() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aX(View view) {
        if (this.dHN == null) {
            this.dHN = new aa(this.mPageContext, isShow(16));
        }
        this.dHN.setData(this.adG);
        this.dHN.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aY(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.dHT = z;
        if (this.dHz != null) {
            this.dHz.setClickable(this.dHT);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.adG = bjVar;
        aQE();
        B(bjVar);
        D(bjVar);
        x(bjVar);
        w(bjVar);
        updatePraiseNum(bjVar);
        C(bjVar);
        E(bjVar);
        setVisibility(this.dHQ ? 0 : 8);
        return this.dHQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bj bjVar) {
        this.dHz.setVisibility(8);
    }

    protected void C(bj bjVar) {
        int equipmentWidth;
        if (this.dHP != null && this.cao != null && this.dHO != null && bjVar != null) {
            if (!this.dIk) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dHP.setVisibility(8);
            } else if (this.dIa && com.baidu.tieba.frs.a.bND().bNE()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cao.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cao.performClick();
                        }
                    });
                }
                if (bjVar.aMo()) {
                    equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
                } else {
                    equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) / 4) * 3;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mMaskView.getLayoutParams();
                if (layoutParams == null) {
                    this.mMaskView.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, -1));
                } else {
                    layoutParams.width = equipmentWidth;
                    requestLayout();
                }
                am.setViewTextColor(this.dHO, this.adG.aMn() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cao.setImageDrawable(am.getDrawable(bjVar.aMn() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.dHP.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dHP.setVisibility(8);
            }
        }
    }

    private void D(bj bjVar) {
        String aKh;
        if (this.dHA != null && bjVar != null) {
            if (bjVar.aKx() <= 0 || !this.dHR) {
                this.dHA.setVisibility(8);
                return;
            }
            this.dHA.setVisibility(0);
            if (this.mFrom == 3) {
                aKh = bjVar.aKi();
            } else {
                aKh = bjVar.aKh();
            }
            this.dHA.setText(aKh);
            this.dHQ = true;
        }
    }

    public boolean isVisible() {
        return this.dHQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(bj bjVar) {
        if (this.dHC != null && bjVar != null) {
            if (this.dHW) {
                this.dHE.setVisibility(0);
                if (bjVar.aKv() > 0) {
                    this.dHC.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bjVar.aKv());
                    if (this.dHU) {
                        updateReplyStateUI();
                        this.dHC.setText(numFormatOverWan);
                    } else {
                        this.dHC.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dHC.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.dHQ = true;
                    return;
                } else if (this.dHU) {
                    updateReplyStateUI();
                    this.dHC.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dHC.setVisibility(0);
                    this.dHQ = true;
                    return;
                } else {
                    this.dHC.setVisibility(8);
                    return;
                }
            }
            this.dHE.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.dHU) {
            SvgManager.aOU().a(this.dHD, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.dHC, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bj bjVar) {
        setAgreeViewType(bjVar);
        if (bjVar.aMs() != null) {
            bjVar.aMs().isInThread = true;
            this.dHB.setCardType(bjVar.aMD());
            this.dHB.setThreadData(bjVar);
            this.dHB.setData(bjVar.aMs());
        }
    }

    public void setAgreeViewType(bj bjVar) {
        if (bjVar != null && bjVar.aMA()) {
            this.dHB.setAgreeAlone(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(bj bjVar) {
        if (this.dHH != null && this.dHF != null && bjVar != null) {
            if (this.dHY) {
                this.dHH.setVisibility(0);
                long aMd = bjVar.aMd();
                if ((bjVar.aLS() || bjVar.aLV()) && bjVar.aKX() != null && bjVar.aKX().share_info != null) {
                    aMd = bjVar.aKX().share_info.share_count;
                }
                this.dHF.setText(aMd > 0 ? aq.numFormatOverWan(aMd) : this.mContext.getString(R.string.share));
                this.dHQ = true;
                updateShareStateUI(bjVar);
                return;
            }
            this.dHH.setVisibility(8);
        }
    }

    public void updateShareStateUI(bj bjVar) {
        if (AntiHelper.ba(bjVar)) {
            setShareClickable(true);
            SvgManager.aOU().a(this.dHG, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dHF, (int) R.color.cp_cont_e);
        } else if (bjVar != null && bjVar.dto != null && this.adG.dto.doe) {
            setShareClickable(false);
            SvgManager.aOU().a(this.dHG, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dHF, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aOU().a(this.dHG, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dHF, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void E(bj bjVar) {
        if (this.dHM != null && bjVar != null) {
            this.dHZ = isShow(4);
            if (bjVar.dtz != null) {
                this.dHZ = false;
            }
            if (this.dHZ && (this.dHP == null || this.dHP.getVisibility() == 8)) {
                this.dHM.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.dHK.setText(string);
                this.dHK.setContentDescription(string);
                this.dHQ = true;
                return;
            }
            this.dHM.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.dHB != null) {
            this.dHB.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dHz, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dHA, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.dHK, (int) R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.adG);
            SvgManager.aOU().a(this.dHJ, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aOU().a(this.dHL, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.dHN != null) {
                this.dHN.onChangeSkinType();
            }
            if (this.dHB != null) {
                this.dHB.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dIf = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.dHz;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.dHX = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.dHR = z;
    }

    public View getCommentNumView() {
        return this.dHC;
    }

    public View getCommentContainer() {
        return this.dHE;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.dHU = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.dHV = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.dHY = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHD.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.dHD.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.dHY = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHD.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.dHD.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.dIa = z;
    }

    public void setManageVisible(boolean z) {
        this.dHZ = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.dIi = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.cao);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.dIk = z;
    }

    public boolean isInFrsAllThread() {
        return this.dIk;
    }

    public void setShowCommonView() {
        setReplyTimeVisible(false);
        setIsBarViewVisible(false);
        setShowPraiseNum(true);
        setNeedAddPraiseIcon(true);
        setNeedAddReplyIcon(true);
        setShareVisible(true);
    }

    public void onDestroy() {
        if (this.dHN != null) {
            this.dHN.destory();
        }
    }

    public void hideDisagree() {
        this.dHB.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.dIj = aVar;
    }
}
