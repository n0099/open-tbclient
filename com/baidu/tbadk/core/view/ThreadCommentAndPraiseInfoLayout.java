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
    protected bj adJ;
    private int agq;
    protected ImageView cau;
    private int dDt;
    protected int dHC;
    protected TextView dHD;
    private TextView dHE;
    protected AgreeView dHF;
    protected TextView dHG;
    protected ImageView dHH;
    protected View dHI;
    protected TextView dHJ;
    protected ImageView dHK;
    protected View dHL;
    protected FrameLayout dHM;
    protected ImageView dHN;
    protected TextView dHO;
    protected ImageView dHP;
    protected View dHQ;
    protected aa dHR;
    protected TextView dHS;
    protected LinearLayout dHT;
    protected boolean dHU;
    protected boolean dHV;
    protected boolean dHW;
    protected boolean dHX;
    protected boolean dHY;
    protected boolean dHZ;
    protected boolean dIa;
    protected boolean dIb;
    protected boolean dIc;
    protected boolean dId;
    protected boolean dIe;
    private int dIf;
    public int dIg;
    public String dIh;
    private String dIi;
    private View.OnClickListener dIj;
    protected int dIk;
    protected int dIl;
    private b dIm;
    private a dIn;
    private boolean dIo;
    CustomMessageListener dIp;
    CustomMessageListener dIq;
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
        this.dIi = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.dHF != null) {
            this.dHF.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.dIf = i;
    }

    public void setGameId(int i) {
        this.dDt = i;
        if (this.dHF != null) {
            this.dHF.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.dHF != null) {
            this.dHF.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dIp);
        MessageManager.getInstance().registerListener(this.dIq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dIp);
        MessageManager.getInstance().unRegisterListener(this.dIq);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.dHC = 0;
        this.agq = 11;
        this.dHU = false;
        this.dHV = true;
        this.dHW = true;
        this.dHX = true;
        this.dHY = false;
        this.dHZ = false;
        this.dIa = true;
        this.dIb = false;
        this.dIc = true;
        this.dId = false;
        this.dIe = true;
        this.mFrom = 2;
        this.dIf = 1;
        this.mSkinType = 3;
        this.dIm = null;
        this.dIo = false;
        this.dIp = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.adJ != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.adJ.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.adJ.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.adJ.jQ(bjVar.aKt());
                                ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.adJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.adJ.jQ(bjVar.aKt());
                            ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                        }
                    }
                }
            }
        };
        this.dIq = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.adJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.adJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.adJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.adJ.aLQ() || ThreadCommentAndPraiseInfoLayout.this.adJ.aLT()) && ThreadCommentAndPraiseInfoLayout.this.adJ.aKV() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.adJ.aKV() != null && ThreadCommentAndPraiseInfoLayout.this.adJ.aKV().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.adJ.aKV().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.adJ.cd(ThreadCommentAndPraiseInfoLayout.this.adJ.aMb() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.w(ThreadCommentAndPraiseInfoLayout.this.adJ);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dHC = 0;
        this.agq = 11;
        this.dHU = false;
        this.dHV = true;
        this.dHW = true;
        this.dHX = true;
        this.dHY = false;
        this.dHZ = false;
        this.dIa = true;
        this.dIb = false;
        this.dIc = true;
        this.dId = false;
        this.dIe = true;
        this.mFrom = 2;
        this.dIf = 1;
        this.mSkinType = 3;
        this.dIm = null;
        this.dIo = false;
        this.dIp = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.adJ != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.adJ.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.adJ.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.adJ.jQ(bjVar.aKt());
                                ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.adJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.adJ.jQ(bjVar.aKt());
                            ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                        }
                    }
                }
            }
        };
        this.dIq = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.adJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.adJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.adJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.adJ.aLQ() || ThreadCommentAndPraiseInfoLayout.this.adJ.aLT()) && ThreadCommentAndPraiseInfoLayout.this.adJ.aKV() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.adJ.aKV() != null && ThreadCommentAndPraiseInfoLayout.this.adJ.aKV().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.adJ.aKV().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.adJ.cd(ThreadCommentAndPraiseInfoLayout.this.adJ.aMb() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.w(ThreadCommentAndPraiseInfoLayout.this.adJ);
                    }
                }
            }
        };
        init(context);
    }

    protected View ds(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.dHC = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View ds = ds(context);
        this.dHD = (TextView) ds.findViewById(R.id.thread_info_bar_name);
        this.dHE = (TextView) ds.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) ds.findViewById(R.id.thread_comment_layout_root);
        this.dHG = (TextView) ds.findViewById(R.id.thread_info_commont_num);
        this.dHH = (ImageView) ds.findViewById(R.id.thread_info_commont_img);
        this.dHI = ds.findViewById(R.id.thread_info_commont_container);
        this.dHJ = (TextView) ds.findViewById(R.id.share_num);
        this.dHK = (ImageView) ds.findViewById(R.id.share_num_img);
        this.dHL = ds.findViewById(R.id.share_num_container);
        this.dHM = (FrameLayout) ds.findViewById(R.id.btn_card_bottom_op_more_container);
        this.dHN = (ImageView) ds.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = ds.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.dHF = (AgreeView) findViewById;
            this.dHF.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadCommentAndPraiseInfoLayout.this.dIj != null) {
                        ThreadCommentAndPraiseInfoLayout.this.dIj.onClick(view);
                    }
                }
            });
        }
        this.dHQ = ds.findViewById(R.id.manage_view_container);
        this.dHO = (TextView) ds.findViewById(R.id.thread_info_manage_text);
        this.dHP = (ImageView) ds.findViewById(R.id.thread_info_manage_img);
        this.cau = (ImageView) ds.findViewById(R.id.manage_select_img);
        this.dHS = (TextView) ds.findViewById(R.id.manage_select_text);
        this.dHT = (LinearLayout) ds.findViewById(R.id.manage_select_container);
        this.dHT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cau.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dHS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cau.performClick();
            }
        });
        this.dHT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cau.performClick();
            }
        });
        this.dHI.setOnClickListener(this);
        this.dHL.setOnClickListener(this);
        this.dHQ.setOnClickListener(this);
        this.cau.setOnClickListener(this);
        this.dIl = R.drawable.icon_home_card_share;
        this.dIk = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    public void setShowFlag(int i) {
        this.agq = i;
        rK();
    }

    private void rK() {
        int i;
        this.dHL.setVisibility(isShow(1) ? 0 : 8);
        this.dHI.setVisibility(isShow(2) ? 0 : 8);
        View view = this.dHQ;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.dHF.setVisibility(isShow(8) ? 0 : 8);
        this.dHF.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.agq & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dHD) {
            aW(view);
        } else if (view == this.dHI) {
            aT(view);
        } else if (view == this.dHL) {
            aU(view);
        } else if (view == this.dHN) {
            aY(view);
        } else if (view == this.dHQ) {
            aX(view);
        } else if (view == this.cau) {
            aV(view);
        }
    }

    protected void aV(View view) {
        if (this.cau != null && this.adJ != null && this.dHS != null && !this.adJ.aMm()) {
            if (!this.adJ.aMl()) {
                if (com.baidu.tieba.frs.a.bNB().ak(this.adJ)) {
                    this.adJ.gA(true);
                }
            } else {
                com.baidu.tieba.frs.a.bNB().al(this.adJ);
                this.adJ.gA(false);
            }
            am.setViewTextColor(this.dHS, this.adJ.aMl() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cau.setImageDrawable(am.getDrawable(this.adJ.aMl() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.dIm != null) {
                this.dIm.gS(this.adJ.aMl());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.dHI != null) {
            this.dHI.setClickable(z);
            this.dHH.setEnabled(z);
            this.dHG.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.dHL != null) {
            this.dHL.setClickable(z);
            this.dHK.setEnabled(z);
            this.dHJ.setEnabled(z);
        }
    }

    private void aW(View view) {
        if (this.adJ != null && !StringUtils.isNull(this.adJ.aKH())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.dIi)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.adJ.aKH(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.adJ.aKH(), this.mStType, this.dIi)));
            }
            if (this.dIj != null) {
                this.dIj.onClick(view);
            }
        }
    }

    private boolean t(bj bjVar) {
        return (bjVar == null || !bjVar.aJp() || bjVar.aKT() == null) ? false : true;
    }

    protected void aT(View view) {
        if (this.adJ != null && this.mContext != null) {
            com.baidu.tieba.card.l.BE(this.adJ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.adJ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.adJ.getFid()));
            addLocateParam.setForumName(this.adJ.aKH());
            if (this.adJ.aMo() && this.adJ.aMn() != null) {
                addLocateParam.setForumId(this.adJ.aMn().getForumId());
                addLocateParam.setForumName(this.adJ.aMn().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.dIn != null) {
                this.dIn.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(this.adJ)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.am(this.adJ);
            }
            if (this.adJ.dtQ) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.adJ.aLG() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.dIg);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.af("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.af("obj_locate", this.mFrom);
            anVar2.af("obj_type", getThreadType());
            anVar2.cI("tid", this.adJ.getTid());
            if (this.mFrom == 18) {
                anVar2.t("uid", TbadkApplication.getCurrentAccountId());
                anVar2.t("fid", this.adJ.getFid());
                anVar2.af("obj_locate", 18);
                anVar2.cI("resource_id", this.mTabName);
            }
            TiebaStatic.log(anVar2);
            aQx();
            if (this.dIj != null) {
                this.dIj.onClick(view);
            }
        }
    }

    private void aQx() {
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
        if (this.adJ == null) {
            return 0;
        }
        if (this.adJ.aJr()) {
            return 1;
        }
        if (this.adJ.aJs()) {
            return 2;
        }
        if (this.adJ.aMw()) {
            return 3;
        }
        return this.adJ.aMx() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.adJ == null) {
            return 0;
        }
        if (this.adJ.isShareThread) {
            return 4;
        }
        if (this.adJ.getThreadType() == 49) {
            return 5;
        }
        if (this.adJ.aKT() != null) {
            return 1;
        }
        if (this.adJ.getType() == bj.dqI || this.adJ.getType() == bj.dqY) {
            if (v.getCount(this.adJ.aKQ()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.adJ != null || i >= 0) {
            an lz = lz(i);
            lz.af("thread_type", this.adJ.getThreadType());
            TiebaStatic.log(lz);
        }
    }

    private an lz(int i) {
        if (this.adJ == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.cI("tid", this.adJ.getTid());
        if (this.adJ.getThreadType() == 40) {
            anVar.cI("obj_param1", "2");
        } else if (this.adJ.getThreadType() == 0) {
            anVar.cI("obj_param1", "1");
        }
        anVar.cI("obj_source", "1");
        anVar.t("fid", this.adJ.getFid());
        anVar.af("obj_locate", this.mFrom);
        anVar.af("obj_id", i);
        if (!aq.isEmpty(this.dIh)) {
            anVar.cI("obj_floor", this.dIh);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aU(View view) {
        if ((ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) && this.adJ != null) {
            aQy();
            if (!AntiHelper.d(getContext(), this.adJ)) {
                aQA();
                if (this.dIj != null) {
                    this.dIj.onClick(view);
                }
            }
        }
    }

    private void aQy() {
        if (this.adJ != null) {
            an aQz = aQz();
            aQz.af("thread_type", this.adJ.getThreadType());
            TiebaStatic.log(aQz);
        }
    }

    private an aQz() {
        if (this.adJ == null) {
            return null;
        }
        int i = 0;
        if (this.dIf == 1) {
            i = 4;
        } else if (this.dIf == 2) {
            i = 5;
        } else if (this.dIf == 3) {
            i = 3;
        } else if (this.dIf == 4) {
            i = 2;
        } else if (this.dIf == 6) {
            i = 8;
        } else if (this.dIf == 7) {
            i = 9;
        } else if (this.dIf == 9) {
            i = 10;
        } else if (this.dIf == 10) {
            i = 17;
        } else if (this.dIf == 18) {
            i = 20;
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.t("fid", this.adJ.getFid());
        anVar.cI("tid", this.adJ.getTid());
        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.af("obj_locate", i);
        anVar.af(TiebaInitialize.Params.OBJ_PARAM2, this.dDt);
        if (!aq.isEmpty(this.dIh)) {
            anVar.cI("obj_floor", this.dIh);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.adJ.aKV() != null && this.adJ.aKV().user_info != null && this.adJ.aKV().user_info.is_official == 2) {
            anVar.af("obj_isofficial", this.adJ.aKV().user_info.is_official);
        }
        anVar.af("card_type", this.adJ.aMB()).cI(TiebaInitialize.Params.AB_TAG, this.adJ.mRecomAbTag).cI("recom_source", this.adJ.mRecomSource).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, this.adJ.mRecomWeight).cI("extra", this.adJ.mRecomExtra);
        if (this.adJ.aJr()) {
            anVar.af("obj_type", 10);
        } else if (this.adJ.aJs()) {
            anVar.af("obj_type", 9);
        } else if (this.adJ.aMx()) {
            anVar.af("obj_type", 8);
        } else if (this.adJ.aMw()) {
            anVar.af("obj_type", 7);
        } else if (this.adJ.isShareThread) {
            anVar.af("obj_type", 6);
        } else if (this.adJ.threadType == 0) {
            anVar.af("obj_type", 1);
        } else if (this.adJ.threadType == 40) {
            anVar.af("obj_type", 2);
        } else if (this.adJ.threadType == 49) {
            anVar.af("obj_type", 3);
        } else if (this.adJ.threadType == 54) {
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
        if (this.adJ.getBaijiahaoData() != null) {
            anVar.cI("obj_param4", this.adJ.getBaijiahaoData().oriUgcNid);
            if (this.adJ.aJs() || this.adJ.aMx()) {
                anVar.cI("obj_param6", this.adJ.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.adJ.aMv()) {
            anVar.af("obj_param5", 2);
        } else if (this.adJ.aJr() || this.adJ.aJs()) {
            anVar.af("obj_param5", 3);
        } else if (this.adJ.threadType == 0 || this.adJ.threadType == 40) {
            anVar.af("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), anVar);
        }
        return anVar;
    }

    private void aQA() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.adJ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.adJ.getFid());
            String aKH = this.adJ.aKH();
            if (this.adJ.dtD != null) {
                valueOf = this.adJ.dtD.id;
                aKH = this.adJ.dtD.ori_fname;
            }
            String title = this.adJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.adJ.getAbstract();
            }
            if (this.adJ.aMy()) {
                tid = this.adJ.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.adJ.getBaijiahaoData().oriUgcType + "&dvid=" + this.adJ.getBaijiahaoData().oriUgcVid + "&nid=" + this.adJ.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.adJ.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.adJ.aKV() != null && this.adJ.aKV().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.adJ.aKV().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.adJ.aKV().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String z2 = z(this.adJ);
            Uri parse = z2 == null ? null : Uri.parse(z2);
            String str4 = this.adJ.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.adJ.aMy() || this.adJ.aKC() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.adJ.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.adJ.aKC().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = aq.cutString(title, 100);
            String cutString2 = aq.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int A = A(this.adJ);
            if (this.adJ.aMy()) {
                shareItem.readCount = -1L;
                shareItem.dQA = cutString2;
            } else {
                if (A == 2 && this.adJ.aKT() != null) {
                    shareItem.readCount = this.adJ.aKT().play_count.intValue();
                } else if (A == 1) {
                    shareItem.readCount = this.adJ.aKu();
                }
                shareItem.dQA = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aKH;
            shareItem.tid = tid;
            shareItem.dQq = true;
            shareItem.due = this.dIf;
            shareItem.dQC = getShareObjSource();
            shareItem.dQH = A;
            shareItem.dQD = 3;
            shareItem.dQE = y(this.adJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.adJ.aMy()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.dQR = this.adJ.getShareImageUrl();
            }
            shareItem.dQK = OriginalThreadInfo.ShareInfo.generateShareInfo(this.adJ);
            if (this.mFrom == 13) {
                shareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(this.adJ, 2);
            } else {
                shareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(this.adJ);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dQD);
            bundle.putInt("obj_type", shareItem.dQH);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.due);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z3 = false;
            shareDialogConfig.setIsAlaLive((this.adJ.getThreadType() == 49 || this.adJ.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.e.bGc().b(shareDialogConfig);
        }
    }

    private int y(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aJr()) {
            return 10;
        }
        if (bjVar.aJs()) {
            return 9;
        }
        if (bjVar.aMx()) {
            return 8;
        }
        if (bjVar.aMw()) {
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
        if (this.dIf == 1) {
            return 5;
        }
        if (this.dIf != 3) {
            if (this.dIf == 4) {
                return 4;
            }
            if (this.dIf == 6) {
                return 8;
            }
            if (this.dIf != 10) {
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
        if (bjVar.aKV() != null && !TextUtils.isEmpty(bjVar.aKV().cover)) {
            return bjVar.aKV().cover;
        }
        if (bjVar.aKM() == null) {
            return null;
        }
        ArrayList<MediaData> aKM = bjVar.aKM();
        int size = aKM.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aKM.get(i);
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
        if (str == null && bjVar.aKT() != null && !TextUtils.isEmpty(bjVar.aKT().thumbnail_url)) {
            return bjVar.aKT().thumbnail_url;
        }
        return str;
    }

    private int A(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aKE()) {
                return 4;
            }
            if (bjVar.aKz() == 1) {
                return 3;
            }
            if (bjVar.aJr()) {
                return 5;
            }
            if (bjVar.aJs()) {
                return 6;
            }
            if (bjVar.aMw()) {
                return 7;
            }
            if (bjVar.aMx()) {
                return 8;
            }
            if (!bjVar.isShareThread || bjVar.dtt == null) {
                return bjVar.aLR() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aX(View view) {
        if (this.dHR == null) {
            this.dHR = new aa(this.mPageContext, isShow(16));
        }
        this.dHR.setData(this.adJ);
        this.dHR.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aY(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.dHX = z;
        if (this.dHD != null) {
            this.dHD.setClickable(this.dHX);
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
        this.adJ = bjVar;
        aQB();
        B(bjVar);
        D(bjVar);
        x(bjVar);
        w(bjVar);
        updatePraiseNum(bjVar);
        C(bjVar);
        E(bjVar);
        setVisibility(this.dHU ? 0 : 8);
        return this.dHU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQB() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bj bjVar) {
        this.dHD.setVisibility(8);
    }

    protected void C(bj bjVar) {
        int equipmentWidth;
        if (this.dHT != null && this.cau != null && this.dHS != null && bjVar != null) {
            if (!this.dIo) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dHT.setVisibility(8);
            } else if (this.dIe && com.baidu.tieba.frs.a.bNB().bNC()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cau.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cau.performClick();
                        }
                    });
                }
                if (bjVar.aMm()) {
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
                am.setViewTextColor(this.dHS, this.adJ.aMl() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cau.setImageDrawable(am.getDrawable(bjVar.aMl() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.dHT.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dHT.setVisibility(8);
            }
        }
    }

    private void D(bj bjVar) {
        String aKf;
        if (this.dHE != null && bjVar != null) {
            if (bjVar.aKv() <= 0 || !this.dHV) {
                this.dHE.setVisibility(8);
                return;
            }
            this.dHE.setVisibility(0);
            if (this.mFrom == 3) {
                aKf = bjVar.aKg();
            } else {
                aKf = bjVar.aKf();
            }
            this.dHE.setText(aKf);
            this.dHU = true;
        }
    }

    public boolean isVisible() {
        return this.dHU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(bj bjVar) {
        if (this.dHG != null && bjVar != null) {
            if (this.dIa) {
                this.dHI.setVisibility(0);
                if (bjVar.aKt() > 0) {
                    this.dHG.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bjVar.aKt());
                    if (this.dHY) {
                        updateReplyStateUI();
                        this.dHG.setText(numFormatOverWan);
                    } else {
                        this.dHG.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dHG.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.dHU = true;
                    return;
                } else if (this.dHY) {
                    updateReplyStateUI();
                    this.dHG.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dHG.setVisibility(0);
                    this.dHU = true;
                    return;
                } else {
                    this.dHG.setVisibility(8);
                    return;
                }
            }
            this.dHI.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.dHY) {
            SvgManager.aOR().a(this.dHH, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.dHG, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bj bjVar) {
        setAgreeViewType(bjVar);
        if (bjVar.aMq() != null) {
            bjVar.aMq().isInThread = true;
            this.dHF.setCardType(bjVar.aMB());
            this.dHF.setThreadData(bjVar);
            this.dHF.setData(bjVar.aMq());
        }
    }

    public void setAgreeViewType(bj bjVar) {
        if (bjVar != null && bjVar.aMy()) {
            this.dHF.setAgreeAlone(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(bj bjVar) {
        if (this.dHL != null && this.dHJ != null && bjVar != null) {
            if (this.dIc) {
                this.dHL.setVisibility(0);
                long aMb = bjVar.aMb();
                if ((bjVar.aLQ() || bjVar.aLT()) && bjVar.aKV() != null && bjVar.aKV().share_info != null) {
                    aMb = bjVar.aKV().share_info.share_count;
                }
                this.dHJ.setText(aMb > 0 ? aq.numFormatOverWan(aMb) : this.mContext.getString(R.string.share));
                this.dHU = true;
                updateShareStateUI(bjVar);
                return;
            }
            this.dHL.setVisibility(8);
        }
    }

    public void updateShareStateUI(bj bjVar) {
        if (AntiHelper.ba(bjVar)) {
            setShareClickable(true);
            SvgManager.aOR().a(this.dHK, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dHJ, (int) R.color.cp_cont_e);
        } else if (bjVar != null && bjVar.dtt != null && this.adJ.dtt.doi) {
            setShareClickable(false);
            SvgManager.aOR().a(this.dHK, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dHJ, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aOR().a(this.dHK, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dHJ, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void E(bj bjVar) {
        if (this.dHQ != null && bjVar != null) {
            this.dId = isShow(4);
            if (bjVar.dtD != null) {
                this.dId = false;
            }
            if (this.dId && (this.dHT == null || this.dHT.getVisibility() == 8)) {
                this.dHQ.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.dHO.setText(string);
                this.dHO.setContentDescription(string);
                this.dHU = true;
                return;
            }
            this.dHQ.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.dHF != null) {
            this.dHF.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dHD, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dHE, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.dHO, (int) R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.adJ);
            SvgManager.aOR().a(this.dHN, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aOR().a(this.dHP, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.dHR != null) {
                this.dHR.onChangeSkinType();
            }
            if (this.dHF != null) {
                this.dHF.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dIj = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.dHD;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.dIb = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.dHV = z;
    }

    public View getCommentNumView() {
        return this.dHG;
    }

    public View getCommentContainer() {
        return this.dHI;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.dHY = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.dHZ = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.dIc = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHH.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.dHH.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.dIc = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHH.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.dHH.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.dIe = z;
    }

    public void setManageVisible(boolean z) {
        this.dId = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.dIm = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.cau);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.dIo = z;
    }

    public boolean isInFrsAllThread() {
        return this.dIo;
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
        if (this.dHR != null) {
            this.dHR.destory();
        }
    }

    public void hideDisagree() {
        this.dHF.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.dIn = aVar;
    }
}
