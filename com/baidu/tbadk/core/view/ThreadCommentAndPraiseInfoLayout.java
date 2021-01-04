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
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bz aim;
    protected TextView akv;
    private int alr;
    protected ImageView dmq;
    private int fgN;
    protected int fkk;
    protected View fmA;
    protected ab fmB;
    protected EMTextView fmC;
    protected LinearLayout fmD;
    protected boolean fmE;
    protected boolean fmF;
    protected boolean fmG;
    protected boolean fmH;
    protected boolean fmI;
    protected boolean fmJ;
    protected boolean fmK;
    protected boolean fmL;
    protected boolean fmM;
    protected boolean fmN;
    private int fmO;
    public int fmP;
    public String fmQ;
    private String fmR;
    private View.OnClickListener fmS;
    private b fmT;
    private a fmU;
    private boolean fmV;
    CustomMessageListener fmW;
    private TextView fmn;
    protected AgreeView fmo;
    protected EMTextView fmq;
    protected ImageView fmr;
    protected View fms;
    protected EMTextView fmt;
    protected ImageView fmu;
    protected View fmv;
    protected FrameLayout fmw;
    protected ImageView fmx;
    protected EMTextView fmy;
    protected ImageView fmz;
    protected boolean isVisible;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;
    CustomMessageListener mUpdateShareNumListener;

    /* loaded from: classes.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes.dex */
    public interface b {
        void kf(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.fmR = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.fmo != null) {
            this.fmo.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.fmO = i;
    }

    public void setGameId(int i) {
        this.fgN = i;
        if (this.fmo != null) {
            this.fmo.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.fmo != null) {
            this.fmo.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fmW);
        MessageManager.getInstance().registerListener(this.mUpdateShareNumListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fmW);
        MessageManager.getInstance().unRegisterListener(this.mUpdateShareNumListener);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.fkk = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.alr = 11;
        this.isVisible = false;
        this.fmE = true;
        this.fmF = true;
        this.fmG = true;
        this.fmH = false;
        this.fmI = false;
        this.fmJ = true;
        this.fmK = false;
        this.fmL = true;
        this.fmM = false;
        this.fmN = true;
        this.mFrom = 2;
        this.fmO = 1;
        this.mSkinType = 3;
        this.fmT = null;
        this.fmV = true;
        this.fmW = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bz)) {
                    bz bzVar = (bz) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aim != null && bzVar != null) {
                        String str = bzVar.getBaijiahaoData() != null ? bzVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aim.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aim.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aim.oN(bzVar.brh());
                                ThreadCommentAndPraiseInfoLayout.this.C(bzVar);
                                return;
                            }
                            return;
                        }
                        String id = bzVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aim.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aim.oN(bzVar.brh());
                            ThreadCommentAndPraiseInfoLayout.this.C(bzVar);
                        }
                    }
                }
            }
        };
        this.mUpdateShareNumListener = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aim != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aim.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aim.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aim.bsK() || ThreadCommentAndPraiseInfoLayout.this.aim.bsN()) && ThreadCommentAndPraiseInfoLayout.this.aim.brJ() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aim.brJ() != null && ThreadCommentAndPraiseInfoLayout.this.aim.brJ().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aim.brJ().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aim.dJ(ThreadCommentAndPraiseInfoLayout.this.aim.bsV() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.aim);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkk = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.alr = 11;
        this.isVisible = false;
        this.fmE = true;
        this.fmF = true;
        this.fmG = true;
        this.fmH = false;
        this.fmI = false;
        this.fmJ = true;
        this.fmK = false;
        this.fmL = true;
        this.fmM = false;
        this.fmN = true;
        this.mFrom = 2;
        this.fmO = 1;
        this.mSkinType = 3;
        this.fmT = null;
        this.fmV = true;
        this.fmW = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bz)) {
                    bz bzVar = (bz) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aim != null && bzVar != null) {
                        String str = bzVar.getBaijiahaoData() != null ? bzVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aim.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aim.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aim.oN(bzVar.brh());
                                ThreadCommentAndPraiseInfoLayout.this.C(bzVar);
                                return;
                            }
                            return;
                        }
                        String id = bzVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aim.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aim.oN(bzVar.brh());
                            ThreadCommentAndPraiseInfoLayout.this.C(bzVar);
                        }
                    }
                }
            }
        };
        this.mUpdateShareNumListener = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aim != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aim.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aim.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aim.bsK() || ThreadCommentAndPraiseInfoLayout.this.aim.bsN()) && ThreadCommentAndPraiseInfoLayout.this.aim.brJ() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aim.brJ() != null && ThreadCommentAndPraiseInfoLayout.this.aim.brJ().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aim.brJ().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aim.dJ(ThreadCommentAndPraiseInfoLayout.this.aim.bsV() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.aim);
                    }
                }
            }
        };
        init(context);
    }

    protected View fg(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.fkk = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aTf();
    }

    protected void aTf() {
        ap(fg(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap(View view) {
        this.akv = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fmn = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.fmq = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fmq).pE(R.string.F_X01);
        this.fmr = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fms = view.findViewById(R.id.thread_info_commont_container);
        this.fmt = (EMTextView) view.findViewById(R.id.share_num);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fmt).pE(R.string.F_X01);
        this.fmu = (ImageView) view.findViewById(R.id.share_num_img);
        this.fmv = view.findViewById(R.id.share_num_container);
        this.fmw = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.fmx = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.fmo = (AgreeView) findViewById;
            this.fmo.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.fmS != null) {
                        ThreadCommentAndPraiseInfoLayout.this.fmS.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.aim);
                }
            });
        }
        this.fmA = view.findViewById(R.id.manage_view_container);
        this.fmy = (EMTextView) view.findViewById(R.id.thread_info_manage_text);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fmy).pE(R.string.F_X01);
        this.fmz = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.dmq = (ImageView) view.findViewById(R.id.manage_select_img);
        this.fmC = (EMTextView) view.findViewById(R.id.manage_select_text);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fmC).pE(R.string.F_X01);
        this.fmD = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.fmD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.dmq.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.fmC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dmq.performClick();
            }
        });
        this.fmD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dmq.performClick();
            }
        });
        this.fms.setOnClickListener(this);
        this.fmv.setOnClickListener(this);
        this.fmA.setOnClickListener(this);
        this.dmq.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.alr = i;
        tM();
    }

    private void tM() {
        int i;
        this.fmv.setVisibility(isShow(1) ? 0 : 8);
        this.fms.setVisibility(isShow(2) ? 0 : 8);
        View view = this.fmA;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.fmo.setVisibility(isShow(8) ? 0 : 8);
        this.fmo.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.alr & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aim == null || this.aim.getType() != bz.eTC) {
            if (view == this.akv) {
                bF(view);
            } else if (view == this.fms) {
                bC(view);
            } else if (view == this.fmv) {
                bD(view);
            } else if (view == this.fmx) {
                bH(view);
            } else if (view == this.fmA) {
                bG(view);
            } else if (view == this.dmq) {
                bE(view);
            }
        }
    }

    protected void bE(View view) {
        boolean z = false;
        if (this.dmq != null && this.aim != null && this.fmC != null && !this.aim.btg()) {
            if (!this.aim.bte() && com.baidu.tieba.frs.b.cDX().cDR()) {
                if (com.baidu.tieba.frs.b.cDX().al(this.aim)) {
                    this.aim.jC(true);
                }
            } else if (!this.aim.btf() && com.baidu.tieba.frs.a.cDQ().cDR()) {
                if (com.baidu.tieba.frs.a.cDQ().al(this.aim)) {
                    this.aim.jD(true);
                }
            } else {
                com.baidu.tieba.frs.b.cDX().am(this.aim);
                this.aim.jC(false);
                com.baidu.tieba.frs.a.cDQ().am(this.aim);
                this.aim.jD(false);
            }
            if (this.aim.bte() || this.aim.btf()) {
                ao.setViewTextColor(this.fmC, R.color.CAM_X0304);
                WebPManager.a(this.dmq, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            } else {
                com.baidu.tbadk.core.elementsMaven.c.bv(this.fmC).pH(R.color.CAM_X0107);
                WebPManager.a(this.dmq, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            }
            if (this.fmT != null) {
                b bVar = this.fmT;
                if (this.aim.bte() || this.aim.btf()) {
                    z = true;
                }
                bVar.kf(z);
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.fms != null) {
            this.fms.setClickable(z);
            this.fmr.setEnabled(z);
            this.fmq.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.fmv != null) {
            this.fmv.setClickable(z);
            this.fmu.setEnabled(z);
            this.fmt.setEnabled(z);
        }
    }

    private void bF(View view) {
        if (this.aim != null && !StringUtils.isNull(this.aim.bru())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.fmR)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.aim.bru(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aim.bru(), this.mStType, this.fmR)));
            }
            if (this.fmS != null) {
                this.fmS.onClick(view);
            }
        }
    }

    private boolean w(bz bzVar) {
        return (bzVar == null || !bzVar.bpV() || bzVar.brH() == null) ? false : true;
    }

    protected void bC(View view) {
        if (this.aim != null && this.mContext != null) {
            m.Jo(this.aim.getTid());
            aq aqVar = new aq("c12942");
            aqVar.an("obj_locate", this.mFrom);
            aqVar.an("obj_type", getThreadType());
            aqVar.dX("tid", this.aim.getTid());
            aqVar.dX(IntentConfig.NID, this.aim.bpO());
            if (this.mFrom == 18) {
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", this.aim.getFid());
                aqVar.an("obj_locate", 18);
                aqVar.dX("resource_id", this.mTabName);
            }
            com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
            if (bV != null) {
                aqVar.dX("obj_cur_page", bV.getCurrentPageKey());
            }
            if (com.baidu.tbadk.pageExtra.d.bHm() != null) {
                aqVar.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHm());
            }
            TiebaStatic.log(aqVar);
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aim, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aim.getFid()));
            addLocateParam.setForumName(this.aim.bru());
            if (this.aim.bti() && this.aim.bth() != null) {
                addLocateParam.setForumId(this.aim.bth().getForumId());
                addLocateParam.setForumName(this.aim.bth().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.fmU != null) {
                this.fmU.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.aim)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.an(this.aim);
            }
            if (this.aim.eWa) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.aim.bsz() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.fmP);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            aq aqVar2 = new aq("c12291");
            aqVar2.an("obj_locate", this.mFrom);
            TiebaStatic.log(aqVar2);
            byb();
            a(view, this.aim);
            if (this.fmS != null) {
                this.fmS.onClick(view);
            }
        }
    }

    private void byb() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            aq aqVar = new aq("c13568");
            aqVar.an("obj_source", threadSourceForDynamicAndBjh);
            aqVar.an("obj_type", threadTypeForDynamicAndBjh);
            TiebaStatic.log(aqVar);
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
        if (this.aim == null) {
            return 0;
        }
        if (this.aim.bpX()) {
            return 1;
        }
        if (this.aim.bpY()) {
            return 2;
        }
        if (this.aim.bto()) {
            return 3;
        }
        return this.aim.btp() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.aim == null) {
            return 0;
        }
        if (this.aim.isShareThread) {
            return 4;
        }
        if (this.aim.getThreadType() == 49) {
            return 5;
        }
        if (this.aim.brH() != null) {
            return 1;
        }
        if (this.aim.getType() == bz.eSL || this.aim.getType() == bz.eTi) {
            if (x.getCount(this.aim.brD()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aim != null || i >= 0) {
            aq rj = rj(i);
            rj.an("thread_type", this.aim.getThreadType());
            TiebaStatic.log(rj);
        }
    }

    private aq rj(int i) {
        if (this.aim == null && i < 0) {
            return null;
        }
        aq aqVar = new aq("c12003");
        aqVar.dX("tid", this.aim.getTid());
        if (this.aim.getThreadType() == 40) {
            aqVar.dX("obj_param1", "2");
        } else if (this.aim.getThreadType() == 0) {
            aqVar.dX("obj_param1", "1");
        }
        aqVar.dX("obj_source", "1");
        aqVar.w("fid", this.aim.getFid());
        aqVar.an("obj_locate", this.mFrom);
        aqVar.an("obj_id", i);
        if (!at.isEmpty(this.fmQ)) {
            aqVar.dX("obj_floor", this.fmQ);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        aqVar.dX(IntentConfig.NID, this.aim.bpO());
        aqVar.an(IntentConfig.CARD_TYPE, this.aim.bts());
        aqVar.dX(IntentConfig.RECOM_SOURCE, this.aim.mRecomSource);
        aqVar.dX("ab_tag", this.aim.mRecomAbTag);
        aqVar.dX("weight", this.aim.mRecomWeight);
        aqVar.dX("extra", this.aim.mRecomExtra);
        if (this.aim.getBaijiahaoData() != null && !at.isEmpty(this.aim.getBaijiahaoData().oriUgcVid)) {
            aqVar.dX("obj_param6", this.aim.getBaijiahaoData().oriUgcVid);
        }
        com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
        if (bV != null) {
            aqVar.dX("obj_cur_page", bV.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bHm() != null) {
            aqVar.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHm());
            return aqVar;
        }
        return aqVar;
    }

    protected void bD(View view) {
        if ((ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) && this.aim != null) {
            byc();
            a(view, this.aim);
            if (!AntiHelper.d(getContext(), this.aim)) {
                bye();
                if (this.fmS != null) {
                    this.fmS.onClick(view);
                }
            }
        }
    }

    private void byc() {
        if (this.aim != null) {
            aq byd = byd();
            byd.an("thread_type", this.aim.getThreadType());
            TiebaStatic.log(byd);
        }
    }

    private aq byd() {
        if (this.aim == null) {
            return null;
        }
        int i = 0;
        if (this.fmO == 1) {
            i = 4;
        } else if (this.fmO == 2) {
            i = 5;
        } else if (this.fmO == 3) {
            i = 3;
        } else if (this.fmO == 4) {
            i = 2;
        } else if (this.fmO == 6) {
            i = 8;
        } else if (this.fmO == 7) {
            i = 9;
        } else if (this.fmO == 9) {
            i = 10;
        } else if (this.fmO == 10) {
            i = 17;
        } else if (this.fmO == 18) {
            i = 20;
        }
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.w("fid", this.aim.getFid());
        aqVar.dX("tid", this.aim.getTid());
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.an("obj_locate", i);
        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, this.fgN);
        if (!at.isEmpty(this.fmQ)) {
            aqVar.dX("obj_floor", this.fmQ);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.aim.brJ() != null && this.aim.brJ().user_info != null && this.aim.brJ().user_info.is_official == 2) {
            aqVar.an("obj_isofficial", this.aim.brJ().user_info.is_official);
        }
        aqVar.an(IntentConfig.CARD_TYPE, this.aim.bts()).dX("ab_tag", this.aim.mRecomAbTag).dX(IntentConfig.RECOM_SOURCE, this.aim.mRecomSource).dX("weight", this.aim.mRecomWeight).dX("extra", this.aim.mRecomExtra);
        if (this.aim.bpX()) {
            aqVar.an("obj_type", 10);
        } else if (this.aim.bpY()) {
            aqVar.an("obj_type", 9);
        } else if (this.aim.btp()) {
            aqVar.an("obj_type", 8);
        } else if (this.aim.bto()) {
            aqVar.an("obj_type", 7);
        } else if (this.aim.isShareThread) {
            aqVar.an("obj_type", 6);
        } else if (this.aim.threadType == 0) {
            aqVar.an("obj_type", 1);
        } else if (this.aim.threadType == 40) {
            aqVar.an("obj_type", 2);
        } else if (this.aim.threadType == 49) {
            aqVar.an("obj_type", 3);
        } else if (this.aim.threadType == 54) {
            aqVar.an("obj_type", 4);
        } else {
            aqVar.an("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            aqVar.dX("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            aqVar.dX("obj_tab", "a099");
            aqVar.dX("resource_id", this.mTabName);
        }
        if (this.aim.getBaijiahaoData() != null) {
            aqVar.dX("obj_param4", this.aim.getBaijiahaoData().oriUgcNid);
            if (this.aim.bpY() || this.aim.btp()) {
                aqVar.dX("obj_param6", this.aim.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.aim.btn()) {
            aqVar.an("obj_param5", 2);
        } else if (this.aim.bpX() || this.aim.bpY()) {
            aqVar.an("obj_param5", 3);
        } else if (this.aim.threadType == 0 || this.aim.threadType == 40) {
            aqVar.an("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), aqVar);
        }
        aqVar.dX(IntentConfig.NID, this.aim.bpO());
        return aqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bz bzVar) {
        int i;
        int i2 = 1;
        if (bzVar != null) {
            int id = view.getId();
            if (id == R.id.thread_info_commont_container) {
                i = 3;
            } else if (id == R.id.share_num_container) {
                i = 4;
            } else if (id == R.id.img_agree) {
                i = 1;
            } else {
                i = id == R.id.img_disagree ? 2 : 0;
            }
            switch (this.mFrom) {
                case 1:
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    i2 = 0;
                    break;
                case 4:
                case 9:
                    i2 = 3;
                    break;
                case 8:
                    i2 = 4;
                    break;
            }
            if (i > 0 && i2 > 0) {
                TiebaStatic.log(com.baidu.tieba.s.a.a("c13694", bzVar, i2, i));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bye() {
        String tid;
        String str;
        boolean z;
        Uri parse;
        String str2;
        String format;
        String str3;
        if (this.aim != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aim.getFid());
            String bru = this.aim.bru();
            if (this.aim.eVM != null) {
                valueOf = this.aim.eVM.id;
                bru = this.aim.eVM.ori_fname;
            }
            String title = this.aim.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aim.getAbstract();
            }
            if (this.aim.bpZ()) {
                tid = this.aim.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.aim.getBaijiahaoData().oriUgcType + "&dvid=" + this.aim.getBaijiahaoData().oriUgcVid + "&nid=" + this.aim.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.aim.getTid();
                str = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            if (this.aim.brJ() != null && this.aim.brJ().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str3 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.aim.brJ().user_info.user_name, "utf-8");
                    } else {
                        str3 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.aim.brJ().user_info.user_name, "utf-8");
                    }
                    z = false;
                    str4 = str3;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String shareImageUrl = getShareImageUrl(this.aim);
                parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
                str2 = this.aim.getAbstract();
                String string = getResources().getString(R.string.share_content_tpl);
                String string2 = getResources().getString(R.string.default_share_content_tpl);
                if (this.aim.bpZ() || this.aim.brq() == null) {
                    format = MessageFormat.format(string, title, str2);
                } else {
                    format = (TextUtils.isEmpty(this.aim.getTitle()) || TextUtils.isEmpty(str2)) ? MessageFormat.format(string2, this.aim.brq().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str2;
                }
                String cutString = at.cutString(title, 100);
                String cutString2 = at.cutString(format, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                int stateThreadType = getStateThreadType(this.aim);
                if (!this.aim.bpZ()) {
                    shareItem.readCount = -1L;
                    shareItem.fxm = cutString2;
                } else {
                    if (stateThreadType == 2 && this.aim.brH() != null) {
                        shareItem.readCount = this.aim.brH().play_count.intValue();
                    } else if (stateThreadType == 1) {
                        shareItem.readCount = this.aim.bri();
                    }
                    shareItem.fxm = str2;
                }
                shareItem.linkUrl = str4;
                shareItem.extData = tid;
                shareItem.fid = valueOf;
                shareItem.fName = bru;
                shareItem.tid = tid;
                shareItem.fxb = true;
                shareItem.eWH = this.fmO;
                shareItem.fxo = getShareObjSource();
                shareItem.fxt = stateThreadType;
                shareItem.fxp = 3;
                shareItem.fxq = getShareObjParam2(this.aim);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (this.aim.bpZ()) {
                    z = false;
                }
                shareItem.canShareBySmartApp = z;
                if (z) {
                    shareItem.fxD = this.aim.getShareImageUrl();
                }
                byf();
                shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aim);
                if (this.mFrom != 13) {
                    shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(this.aim, 2);
                } else {
                    shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(this.aim);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fxp);
                bundle.putInt("obj_type", shareItem.fxt);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putInt("obj_source", shareItem.eWH);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                boolean z2 = false;
                shareDialogConfig.setIsAlaLive((this.aim.getThreadType() != 49 || this.aim.getThreadType() == 60) ? true : true);
                a(shareDialogConfig);
                com.baidu.tieba.c.f.cwe().b(shareDialogConfig);
            }
            z = true;
            String shareImageUrl2 = getShareImageUrl(this.aim);
            if (shareImageUrl2 != null) {
            }
            str2 = this.aim.getAbstract();
            String string3 = getResources().getString(R.string.share_content_tpl);
            String string22 = getResources().getString(R.string.default_share_content_tpl);
            if (this.aim.bpZ()) {
            }
            format = MessageFormat.format(string3, title, str2);
            String cutString3 = at.cutString(title, 100);
            String cutString22 = at.cutString(format, 100);
            ShareItem shareItem2 = new ShareItem();
            shareItem2.title = cutString3;
            shareItem2.content = cutString22;
            int stateThreadType2 = getStateThreadType(this.aim);
            if (!this.aim.bpZ()) {
            }
            shareItem2.linkUrl = str4;
            shareItem2.extData = tid;
            shareItem2.fid = valueOf;
            shareItem2.fName = bru;
            shareItem2.tid = tid;
            shareItem2.fxb = true;
            shareItem2.eWH = this.fmO;
            shareItem2.fxo = getShareObjSource();
            shareItem2.fxt = stateThreadType2;
            shareItem2.fxp = 3;
            shareItem2.fxq = getShareObjParam2(this.aim);
            if (parse != null) {
            }
            if (this.aim.bpZ()) {
            }
            shareItem2.canShareBySmartApp = z;
            if (z) {
            }
            byf();
            shareItem2.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aim);
            if (this.mFrom != 13) {
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem2.fxp);
            bundle2.putInt("obj_type", shareItem2.fxt);
            bundle2.putString("fid", shareItem2.fid);
            bundle2.putString("tid", shareItem2.tid);
            bundle2.putInt("obj_source", shareItem2.eWH);
            shareItem2.ae(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, shareItem2, true, true);
            boolean z22 = false;
            shareDialogConfig2.setIsAlaLive((this.aim.getThreadType() != 49 || this.aim.getThreadType() == 60) ? true : true);
            a(shareDialogConfig2);
            com.baidu.tieba.c.f.cwe().b(shareDialogConfig2);
        }
    }

    private void byf() {
        ItemInfo cEn;
        if ((this.mContext instanceof ak) && ((ak) this.mContext).cEo() && this.aim != null && this.aim.btx() == null && (cEn = ((ak) this.mContext).cEn()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cEn.id.longValue());
            builder.item_name = cEn.name;
            builder.icon_size = cEn.icon_size;
            builder.icon_url = cEn.icon_url;
            builder.tags = cEn.tags;
            if (cEn.score != null && cEn.score.item_point != null) {
                Iterator<ItemPoint> it = cEn.score.item_point.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ItemPoint next = it.next();
                    if (next.time_intval.equals("all")) {
                        builder.score = next.point;
                        builder.star = Integer.valueOf((int) (next.point.doubleValue() / 2.0d));
                        break;
                    }
                }
            }
            Item build = builder.build(false);
            ItemData itemData = new ItemData();
            itemData.parseProto(build);
            this.aim.a(itemData);
        }
    }

    private int getShareObjParam2(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bpX()) {
            return 10;
        }
        if (bzVar.bpY()) {
            return 9;
        }
        if (bzVar.btp()) {
            return 8;
        }
        if (bzVar.bto()) {
            return 7;
        }
        if (bzVar.isShareThread) {
            return 6;
        }
        if (bzVar.threadType == 0) {
            return 1;
        }
        if (bzVar.threadType == 40) {
            return 2;
        }
        if (bzVar.threadType == 49) {
            return 3;
        }
        if (bzVar.threadType == 54) {
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
        if (this.fmO == 1) {
            return 5;
        }
        if (this.fmO != 3) {
            if (this.fmO == 4) {
                return 4;
            }
            if (this.fmO == 6) {
                return 8;
            }
            if (this.fmO != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String getShareImageUrl(bz bzVar) {
        String str;
        if (bzVar == null) {
            return null;
        }
        if (bzVar.brJ() != null && !TextUtils.isEmpty(bzVar.brJ().cover)) {
            return bzVar.brJ().cover;
        }
        if (bzVar.brz() == null) {
            return null;
        }
        ArrayList<MediaData> brz = bzVar.brz();
        int size = brz.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = brz.get(i);
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
        if (str == null && bzVar.brH() != null && !TextUtils.isEmpty(bzVar.brH().thumbnail_url)) {
            return bzVar.brH().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.brs()) {
                return 4;
            }
            if (bzVar.brn() == 1) {
                return 3;
            }
            if (bzVar.bpX()) {
                return 5;
            }
            if (bzVar.bpY()) {
                return 6;
            }
            if (bzVar.bto()) {
                return 7;
            }
            if (bzVar.btp()) {
                return 8;
            }
            if (!bzVar.isShareThread || bzVar.eVB == null) {
                return bzVar.bsL() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bG(View view) {
        if (this.fmB == null) {
            this.fmB = new ab(this.mPageContext, isShow(16));
        }
        this.fmB.setData(this.aim);
        this.fmB.SY();
        if (this.aim != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.aim.getFid()).dX("tid", this.aim.getId()));
        }
    }

    private void bH(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.fmG = z;
        if (this.akv != null) {
            this.akv.setClickable(this.fmG);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(bz bzVar) {
        if (bzVar == null) {
            setVisibility(8);
            return false;
        }
        this.aim = bzVar;
        alF();
        D(bzVar);
        F(bzVar);
        C(bzVar);
        B(bzVar);
        updatePraiseNum(bzVar);
        E(bzVar);
        G(bzVar);
        setVisibility(this.isVisible ? 0 : 8);
        bxZ();
        return this.isVisible;
    }

    protected void bxZ() {
    }

    protected void alF() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(bz bzVar) {
        this.akv.setVisibility(8);
    }

    protected void E(bz bzVar) {
        if (this.fmD != null && this.dmq != null && this.fmC != null && bzVar != null) {
            if (!this.fmV) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.fmD.setVisibility(8);
            } else if (this.fmN && !isShow(128) && (com.baidu.tieba.frs.b.cDX().cDR() || com.baidu.tieba.frs.a.cDQ().cDR())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.dmq.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.dmq.performClick();
                        }
                    });
                }
                int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mMaskView.getLayoutParams();
                if (layoutParams == null) {
                    this.mMaskView.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, -1));
                } else {
                    layoutParams.width = equipmentWidth;
                    requestLayout();
                }
                if (this.aim.bte() || this.aim.btf()) {
                    ao.setViewTextColor(this.fmC, R.color.CAM_X0304);
                    WebPManager.a(this.dmq, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
                } else {
                    com.baidu.tbadk.core.elementsMaven.c.bv(this.fmC).pH(R.color.CAM_X0107);
                    WebPManager.a(this.dmq, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                }
                this.mMaskView.setVisibility(0);
                this.fmD.setVisibility(8);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.fmD.setVisibility(8);
            }
        }
    }

    private void F(bz bzVar) {
        String bqT;
        if (this.fmn != null && bzVar != null) {
            if (bzVar.brj() <= 0 || !this.fmE) {
                this.fmn.setVisibility(8);
                return;
            }
            this.fmn.setVisibility(0);
            if (this.mFrom == 3) {
                bqT = bzVar.bqU();
            } else {
                bqT = bzVar.bqT();
            }
            this.fmn.setText(bqT);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(bz bzVar) {
        if (this.fmq != null && bzVar != null) {
            if (this.fmJ) {
                this.fms.setVisibility(0);
                if (bzVar.brh() > 0) {
                    this.fmq.setVisibility(0);
                    String numFormatOverWan = at.numFormatOverWan(bzVar.brh());
                    if (this.fmH) {
                        updateReplyStateUI();
                        this.fmq.setText(numFormatOverWan);
                    } else {
                        this.fmq.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.fmq.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.fmH) {
                    updateReplyStateUI();
                    this.fmq.setText(this.mContext.getString(R.string.action_comment_default));
                    this.fmq.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.fmq.setVisibility(8);
                    return;
                }
            }
            this.fms.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        int color;
        if (this.fmH) {
            WebPManager.a(this.fmr, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
        this.fmr.setEnabled(this.aim == null || this.aim.getType() != bz.eTC);
        EMTextView eMTextView = this.fmq;
        if (this.aim != null && this.aim.getType() == bz.eTC) {
            color = com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.fdi);
        } else {
            color = ao.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
    }

    public void updateManagerUI() {
        int color;
        WebPManager.a(this.fmz, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        EMTextView eMTextView = this.fmy;
        if (this.aim != null && this.aim.getType() == bz.eTC) {
            color = com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.fdi);
        } else {
            color = ao.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
        this.fmz.setEnabled(this.aim == null || this.aim.getType() != bz.eTC);
    }

    public void updatePraiseNum(bz bzVar) {
        setAgreeViewType(bzVar);
        if (bzVar.btk() != null) {
            bzVar.btk().isInThread = true;
            this.fmo.setCardType(bzVar.bts());
            this.fmo.setThreadData(bzVar);
            this.fmo.setData(bzVar.btk());
        }
        this.fmo.setAlpha((this.aim == null || this.aim.getType() != bz.eTC) ? 1.0f : ao.fdi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bz bzVar) {
        if (this.fmv != null && this.fmt != null && bzVar != null) {
            if (this.fmL) {
                this.fmv.setVisibility(0);
                long bsV = bzVar.bsV();
                if ((bzVar.bsK() || bzVar.bsN()) && bzVar.brJ() != null && bzVar.brJ().share_info != null) {
                    bsV = bzVar.brJ().share_info.share_count;
                }
                this.fmt.setText(bsV > 0 ? at.numFormatOverWan(bsV) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                updateShareStateUI(bzVar);
                return;
            }
            this.fmv.setVisibility(8);
        }
    }

    public void updateShareStateUI(bz bzVar) {
        WebPManager.a(this.fmu, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        if (AntiHelper.bc(bzVar)) {
            setShareClickable(true);
            this.fmt.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.fdi));
        } else if (bzVar != null && bzVar.eVB != null && this.aim.eVB.ePW) {
            setShareClickable(false);
            this.fmt.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.fdi));
        } else {
            setShareClickable(true);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.fmt).pH(R.color.CAM_X0107);
        }
        if (this.aim != null && this.aim.getType() == bz.eTC) {
            this.fmu.setEnabled(false);
            this.fmt.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.fdi));
        }
    }

    protected void G(bz bzVar) {
        if (this.fmA != null && bzVar != null) {
            this.fmM = isShow(4);
            if (bzVar.eVM != null) {
                this.fmM = false;
            }
            if (this.fmM && (this.fmD == null || this.fmD.getVisibility() == 8)) {
                this.fmA.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.fmy.setText(string);
                this.fmy.setContentDescription(string);
                this.isVisible = true;
            } else {
                this.fmA.setVisibility(isShow(64) ? 4 : 8);
            }
            updateManagerUI();
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.fmo != null) {
            this.fmo.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            ao.setViewTextColor(this.akv, R.color.CAM_X0109);
            ao.setViewTextColor(this.fmn, R.color.CAM_X0107);
            updateReplyStateUI();
            updateShareStateUI(this.aim);
            updateManagerUI();
            if (this.fmB != null) {
                this.fmB.onChangeSkinType();
            }
            if (this.fmo != null) {
                this.fmo.onChangeSkinType(this.mSkinType);
                this.fmo.setAlpha((this.aim == null || this.aim.getType() != bz.eTC) ? 1.0f : ao.fdi);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fmS = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.akv;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.fmK = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.fmE = z;
    }

    public View getCommentNumView() {
        return this.fmq;
    }

    public View getCommentContainer() {
        return this.fms;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.fmH = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.fmI = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.fmL = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmr.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.fmr.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.fmL = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmr.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.fmr.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.fmN = z;
    }

    public void setManageVisible(boolean z) {
        this.fmM = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.fmT = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.dmq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.fmV = z;
    }

    public boolean isInFrsAllThread() {
        return this.fmV;
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
        if (this.fmB != null) {
            this.fmB.destory();
        }
    }

    public void setAgreeViewType(bz bzVar) {
        if (bzVar != null && bzVar.bpZ()) {
            this.fmo.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.fmo.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.fmU = aVar;
    }
}
