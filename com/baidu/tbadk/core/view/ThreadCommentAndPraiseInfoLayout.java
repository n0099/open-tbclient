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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ac;
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
    protected cb aiB;
    protected TextView akL;
    private int alH;
    protected ImageView dlq;
    private int ffT;
    protected int fjr;
    protected ImageView flA;
    protected View flB;
    protected FrameLayout flC;
    protected ImageView flD;
    protected EMTextView flE;
    protected ImageView flF;
    protected View flG;
    protected ac flH;
    protected EMTextView flI;
    protected LinearLayout flJ;
    protected boolean flK;
    protected boolean flL;
    protected boolean flM;
    protected boolean flN;
    protected boolean flO;
    protected boolean flP;
    protected boolean flQ;
    protected boolean flR;
    protected boolean flS;
    protected boolean flT;
    private int flU;
    public int flV;
    public String flW;
    private String flX;
    private View.OnClickListener flY;
    private MaskView flZ;
    private TextView flu;
    protected AgreeView flv;
    protected EMTextView flw;
    protected ImageView flx;
    protected View fly;
    protected EMTextView flz;
    private b fma;
    private a fmb;
    private boolean fmc;
    CustomMessageListener fmd;
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
        void ke(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.flX = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.flv != null) {
            this.flv.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.flU = i;
    }

    public void setGameId(int i) {
        this.ffT = i;
        if (this.flv != null) {
            this.flv.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.flv != null) {
            this.flv.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fmd);
        MessageManager.getInstance().registerListener(this.mUpdateShareNumListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fmd);
        MessageManager.getInstance().unRegisterListener(this.mUpdateShareNumListener);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.fjr = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.alH = 11;
        this.isVisible = false;
        this.flK = true;
        this.flL = true;
        this.flM = true;
        this.flN = false;
        this.flO = false;
        this.flP = true;
        this.flQ = false;
        this.flR = true;
        this.flS = false;
        this.flT = true;
        this.mFrom = 2;
        this.flU = 1;
        this.mSkinType = 3;
        this.fma = null;
        this.fmc = true;
        this.fmd = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof cb)) {
                    cb cbVar = (cb) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aiB != null && cbVar != null) {
                        String str = cbVar.getBaijiahaoData() != null ? cbVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aiB.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aiB.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aiB.nl(cbVar.bnJ());
                                ThreadCommentAndPraiseInfoLayout.this.C(cbVar);
                                return;
                            }
                            return;
                        }
                        String id = cbVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aiB.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aiB.nl(cbVar.bnJ());
                            ThreadCommentAndPraiseInfoLayout.this.C(cbVar);
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
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aiB != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aiB.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aiB.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aiB.bpl() || ThreadCommentAndPraiseInfoLayout.this.aiB.bpo()) && ThreadCommentAndPraiseInfoLayout.this.aiB.bol() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aiB.bol() != null && ThreadCommentAndPraiseInfoLayout.this.aiB.bol().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aiB.bol().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aiB.dP(ThreadCommentAndPraiseInfoLayout.this.aiB.bpw() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.aiB);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjr = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.alH = 11;
        this.isVisible = false;
        this.flK = true;
        this.flL = true;
        this.flM = true;
        this.flN = false;
        this.flO = false;
        this.flP = true;
        this.flQ = false;
        this.flR = true;
        this.flS = false;
        this.flT = true;
        this.mFrom = 2;
        this.flU = 1;
        this.mSkinType = 3;
        this.fma = null;
        this.fmc = true;
        this.fmd = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof cb)) {
                    cb cbVar = (cb) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aiB != null && cbVar != null) {
                        String str = cbVar.getBaijiahaoData() != null ? cbVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aiB.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aiB.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aiB.nl(cbVar.bnJ());
                                ThreadCommentAndPraiseInfoLayout.this.C(cbVar);
                                return;
                            }
                            return;
                        }
                        String id = cbVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aiB.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aiB.nl(cbVar.bnJ());
                            ThreadCommentAndPraiseInfoLayout.this.C(cbVar);
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
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aiB != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aiB.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aiB.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aiB.bpl() || ThreadCommentAndPraiseInfoLayout.this.aiB.bpo()) && ThreadCommentAndPraiseInfoLayout.this.aiB.bol() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aiB.bol() != null && ThreadCommentAndPraiseInfoLayout.this.aiB.bol().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aiB.bol().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aiB.dP(ThreadCommentAndPraiseInfoLayout.this.aiB.bpw() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.aiB);
                    }
                }
            }
        };
        init(context);
    }

    protected View fc(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.fjr = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aPI();
    }

    protected void aPI() {
        am(fc(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am(View view) {
        this.akL = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.flu = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.flw = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
        com.baidu.tbadk.core.elementsMaven.c.br(this.flw).ob(R.string.F_X01);
        this.flx = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fly = view.findViewById(R.id.thread_info_commont_container);
        this.flz = (EMTextView) view.findViewById(R.id.share_num);
        com.baidu.tbadk.core.elementsMaven.c.br(this.flz).ob(R.string.F_X01);
        this.flA = (ImageView) view.findViewById(R.id.share_num_img);
        this.flB = view.findViewById(R.id.share_num_container);
        this.flC = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.flD = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.flv = (AgreeView) findViewById;
            this.flv.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.flY != null) {
                        ThreadCommentAndPraiseInfoLayout.this.flY.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.aiB);
                }
            });
        }
        this.flG = view.findViewById(R.id.manage_view_container);
        this.flE = (EMTextView) view.findViewById(R.id.thread_info_manage_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.flE).ob(R.string.F_X01);
        this.flF = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.dlq = (ImageView) view.findViewById(R.id.manage_select_img);
        this.flI = (EMTextView) view.findViewById(R.id.manage_select_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.flI).ob(R.string.F_X01);
        this.flJ = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.flJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.dlq.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.flI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dlq.performClick();
            }
        });
        this.flJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dlq.performClick();
            }
        });
        this.fly.setOnClickListener(this);
        this.flB.setOnClickListener(this);
        this.flG.setOnClickListener(this);
        this.dlq.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.alH = i;
        ty();
    }

    private void ty() {
        int i;
        this.flB.setVisibility(isShow(1) ? 0 : 8);
        this.fly.setVisibility(isShow(2) ? 0 : 8);
        View view = this.flG;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.flv.setVisibility(isShow(8) ? 0 : 8);
        this.flv.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.alH & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aiB == null || this.aiB.getType() != cb.eSE) {
            if (view == this.akL) {
                bB(view);
            } else if (view == this.fly) {
                by(view);
            } else if (view == this.flB) {
                bz(view);
            } else if (view == this.flD) {
                bD(view);
            } else if (view == this.flG) {
                bC(view);
            } else if (view == this.dlq) {
                bA(view);
            }
        }
    }

    protected void bA(View view) {
        boolean z = false;
        if (this.dlq != null && this.aiB != null && this.flI != null && !this.aiB.bpH()) {
            if (!this.aiB.bpF() && com.baidu.tieba.frs.b.cBE().cBy()) {
                if (com.baidu.tieba.frs.b.cBE().am(this.aiB)) {
                    this.aiB.jA(true);
                }
            } else if (!this.aiB.bpG() && com.baidu.tieba.frs.a.cBx().cBy()) {
                if (com.baidu.tieba.frs.a.cBx().am(this.aiB)) {
                    this.aiB.jB(true);
                }
            } else {
                com.baidu.tieba.frs.b.cBE().an(this.aiB);
                this.aiB.jA(false);
                com.baidu.tieba.frs.a.cBx().an(this.aiB);
                this.aiB.jB(false);
            }
            if (this.aiB.bpF() || this.aiB.bpG()) {
                ap.setViewTextColor(this.flI, R.color.CAM_X0304);
                WebPManager.a(this.dlq, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            } else {
                com.baidu.tbadk.core.elementsMaven.c.br(this.flI).oe(R.color.CAM_X0107);
                WebPManager.a(this.dlq, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            }
            if (this.fma != null) {
                b bVar = this.fma;
                if (this.aiB.bpF() || this.aiB.bpG()) {
                    z = true;
                }
                bVar.ke(z);
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.fly != null) {
            this.fly.setClickable(z);
            this.flx.setEnabled(z);
            this.flw.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.flB != null) {
            this.flB.setClickable(z);
            this.flA.setEnabled(z);
            this.flz.setEnabled(z);
        }
    }

    private void bB(View view) {
        if (this.aiB != null && !StringUtils.isNull(this.aiB.bnW())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.flX)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.aiB.bnW(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aiB.bnW(), this.mStType, this.flX)));
            }
            if (this.flY != null) {
                this.flY.onClick(view);
            }
        }
    }

    private boolean w(cb cbVar) {
        return (cbVar == null || !cbVar.bmx() || cbVar.boj() == null) ? false : true;
    }

    protected void by(View view) {
        if (this.aiB != null && this.mContext != null) {
            m.IW(this.aiB.getTid());
            ar arVar = new ar("c12942");
            arVar.aq("obj_locate", this.mFrom);
            arVar.aq("obj_type", getThreadType());
            arVar.dR("tid", this.aiB.getTid());
            arVar.dR(IntentConfig.NID, this.aiB.bmq());
            if (this.mFrom == 18) {
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.v("fid", this.aiB.getFid());
                arVar.aq("obj_locate", 18);
                arVar.dR("resource_id", this.mTabName);
            }
            com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(this);
            if (bR != null) {
                arVar.dR("obj_cur_page", bR.getCurrentPageKey());
            }
            if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
                arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
            }
            TiebaStatic.log(arVar);
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aiB, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aiB.getFid()));
            addLocateParam.setForumName(this.aiB.bnW());
            if (this.aiB.bpJ() && this.aiB.bpI() != null) {
                addLocateParam.setForumId(this.aiB.bpI().getForumId());
                addLocateParam.setForumName(this.aiB.bpI().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.fmb != null) {
                this.fmb.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.aiB)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.ao(this.aiB);
            }
            if (this.aiB.eVc) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.aiB.bpa() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.flV);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ar arVar2 = new ar("c12291");
            arVar2.aq("obj_locate", this.mFrom);
            TiebaStatic.log(arVar2);
            buF();
            a(view, this.aiB);
            if (this.flY != null) {
                this.flY.onClick(view);
            }
        }
    }

    private void buF() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            ar arVar = new ar("c13568");
            arVar.aq("obj_source", threadSourceForDynamicAndBjh);
            arVar.aq("obj_type", threadTypeForDynamicAndBjh);
            TiebaStatic.log(arVar);
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
        if (this.aiB == null) {
            return 0;
        }
        if (this.aiB.bmz()) {
            return 1;
        }
        if (this.aiB.bmA()) {
            return 2;
        }
        if (this.aiB.bpP()) {
            return 3;
        }
        return this.aiB.bpQ() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.aiB == null) {
            return 0;
        }
        if (this.aiB.isShareThread) {
            return 4;
        }
        if (this.aiB.getThreadType() == 49) {
            return 5;
        }
        if (this.aiB.boj() != null) {
            return 1;
        }
        if (this.aiB.getType() == cb.eRN || this.aiB.getType() == cb.eSk) {
            if (y.getCount(this.aiB.bof()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aiB != null || i >= 0) {
            ar pJ = pJ(i);
            pJ.aq("thread_type", this.aiB.getThreadType());
            TiebaStatic.log(pJ);
        }
    }

    private ar pJ(int i) {
        if (this.aiB == null && i < 0) {
            return null;
        }
        ar arVar = new ar("c12003");
        arVar.dR("tid", this.aiB.getTid());
        if (this.aiB.getThreadType() == 40) {
            arVar.dR("obj_param1", "2");
        } else if (this.aiB.getThreadType() == 0) {
            arVar.dR("obj_param1", "1");
        }
        arVar.dR("obj_source", "1");
        arVar.v("fid", this.aiB.getFid());
        arVar.aq("obj_locate", this.mFrom);
        arVar.aq("obj_id", i);
        if (!au.isEmpty(this.flW)) {
            arVar.dR("obj_floor", this.flW);
        }
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        arVar.dR(IntentConfig.NID, this.aiB.bmq());
        arVar.aq(IntentConfig.CARD_TYPE, this.aiB.bpT());
        arVar.dR(IntentConfig.RECOM_SOURCE, this.aiB.mRecomSource);
        arVar.dR("ab_tag", this.aiB.mRecomAbTag);
        arVar.dR("weight", this.aiB.mRecomWeight);
        arVar.dR("extra", this.aiB.mRecomExtra);
        if (this.aiB.getBaijiahaoData() != null && !au.isEmpty(this.aiB.getBaijiahaoData().oriUgcVid)) {
            arVar.dR("obj_param6", this.aiB.getBaijiahaoData().oriUgcVid);
        }
        com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(this);
        if (bR != null) {
            arVar.dR("obj_cur_page", bR.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
            arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
            return arVar;
        }
        return arVar;
    }

    protected void bz(View view) {
        if ((ShareSwitch.isOn() || bh.checkUpIsLogin(this.mContext)) && this.aiB != null) {
            buG();
            a(view, this.aiB);
            if (!AntiHelper.d(getContext(), this.aiB)) {
                buI();
                if (this.flY != null) {
                    this.flY.onClick(view);
                }
            }
        }
    }

    private void buG() {
        if (this.aiB != null) {
            ar buH = buH();
            buH.aq("thread_type", this.aiB.getThreadType());
            TiebaStatic.log(buH);
        }
    }

    private ar buH() {
        if (this.aiB == null) {
            return null;
        }
        int i = 0;
        if (this.flU == 1) {
            i = 4;
        } else if (this.flU == 2) {
            i = 5;
        } else if (this.flU == 3) {
            i = 3;
        } else if (this.flU == 4) {
            i = 2;
        } else if (this.flU == 6) {
            i = 8;
        } else if (this.flU == 7) {
            i = 9;
        } else if (this.flU == 9) {
            i = 10;
        } else if (this.flU == 10) {
            i = 17;
        } else if (this.flU == 18) {
            i = 20;
        }
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        arVar.v("fid", this.aiB.getFid());
        arVar.dR("tid", this.aiB.getTid());
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.aq("obj_locate", i);
        arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, this.ffT);
        if (!au.isEmpty(this.flW)) {
            arVar.dR("obj_floor", this.flW);
        }
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.aiB.bol() != null && this.aiB.bol().user_info != null && this.aiB.bol().user_info.is_official == 2) {
            arVar.aq("obj_isofficial", this.aiB.bol().user_info.is_official);
        }
        arVar.aq(IntentConfig.CARD_TYPE, this.aiB.bpT()).dR("ab_tag", this.aiB.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.aiB.mRecomSource).dR("weight", this.aiB.mRecomWeight).dR("extra", this.aiB.mRecomExtra);
        if (this.aiB.bmz()) {
            arVar.aq("obj_type", 10);
        } else if (this.aiB.bmA()) {
            arVar.aq("obj_type", 9);
        } else if (this.aiB.bpQ()) {
            arVar.aq("obj_type", 8);
        } else if (this.aiB.bpP()) {
            arVar.aq("obj_type", 7);
        } else if (this.aiB.isShareThread) {
            arVar.aq("obj_type", 6);
        } else if (this.aiB.threadType == 0) {
            arVar.aq("obj_type", 1);
        } else if (this.aiB.threadType == 40) {
            arVar.aq("obj_type", 2);
        } else if (this.aiB.threadType == 49) {
            arVar.aq("obj_type", 3);
        } else if (this.aiB.threadType == 54) {
            arVar.aq("obj_type", 4);
        } else {
            arVar.aq("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            arVar.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            arVar.dR("obj_tab", "a099");
            arVar.dR("resource_id", this.mTabName);
        }
        if (this.aiB.getBaijiahaoData() != null) {
            arVar.dR("obj_param4", this.aiB.getBaijiahaoData().oriUgcNid);
            if (this.aiB.bmA() || this.aiB.bpQ()) {
                arVar.dR("obj_param6", this.aiB.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.aiB.bpO()) {
            arVar.aq("obj_param5", 2);
        } else if (this.aiB.bmz() || this.aiB.bmA()) {
            arVar.aq("obj_param5", 3);
        } else if (this.aiB.threadType == 0 || this.aiB.threadType == 40) {
            arVar.aq("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), arVar);
        }
        arVar.dR(IntentConfig.NID, this.aiB.bmq());
        return arVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, cb cbVar) {
        int i;
        int i2 = 1;
        if (cbVar != null) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a("c13694", cbVar, i2, i));
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
    private void buI() {
        String tid;
        String str;
        boolean z;
        Uri parse;
        String str2;
        String format;
        String str3;
        if (this.aiB != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aiB.getFid());
            String bnW = this.aiB.bnW();
            if (this.aiB.eUO != null) {
                valueOf = this.aiB.eUO.id;
                bnW = this.aiB.eUO.ori_fname;
            }
            String title = this.aiB.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aiB.getAbstract();
            }
            if (this.aiB.bmB()) {
                tid = this.aiB.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.aiB.getBaijiahaoData().oriUgcType + "&dvid=" + this.aiB.getBaijiahaoData().oriUgcVid + "&nid=" + this.aiB.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.aiB.getTid();
                str = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            if (this.aiB.bol() != null && this.aiB.bol().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str3 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.aiB.bol().user_info.user_name, "utf-8");
                    } else {
                        str3 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.aiB.bol().user_info.user_name, "utf-8");
                    }
                    z = false;
                    str4 = str3;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String shareImageUrl = getShareImageUrl(this.aiB);
                parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
                str2 = this.aiB.getAbstract();
                String string = getResources().getString(R.string.share_content_tpl);
                String string2 = getResources().getString(R.string.default_share_content_tpl);
                if (this.aiB.bmB() || this.aiB.bnS() == null) {
                    format = MessageFormat.format(string, title, str2);
                } else {
                    format = (TextUtils.isEmpty(this.aiB.getTitle()) || TextUtils.isEmpty(str2)) ? MessageFormat.format(string2, this.aiB.bnS().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str2;
                }
                String cutString = au.cutString(title, 100);
                String cutString2 = au.cutString(format, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                int stateThreadType = getStateThreadType(this.aiB);
                if (!this.aiB.bmB()) {
                    shareItem.readCount = -1L;
                    shareItem.fwu = cutString2;
                } else {
                    if (stateThreadType == 2 && this.aiB.boj() != null) {
                        shareItem.readCount = this.aiB.boj().play_count.intValue();
                    } else if (stateThreadType == 1) {
                        shareItem.readCount = this.aiB.bnK();
                    }
                    shareItem.fwu = str2;
                }
                shareItem.linkUrl = str4;
                shareItem.extData = tid;
                shareItem.fid = valueOf;
                shareItem.fName = bnW;
                shareItem.tid = tid;
                shareItem.fwj = true;
                shareItem.eVJ = this.flU;
                shareItem.fww = getShareObjSource();
                shareItem.fwB = stateThreadType;
                shareItem.fwx = 3;
                shareItem.fwy = getShareObjParam2(this.aiB);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (this.aiB.bmB()) {
                    z = false;
                }
                shareItem.canShareBySmartApp = z;
                if (z) {
                    shareItem.fwL = this.aiB.getShareImageUrl();
                }
                buJ();
                shareItem.fwE = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aiB);
                if (this.mFrom != 13) {
                    shareItem.fwF = ShareItem.ForwardInfo.generateForwardInfo(this.aiB, 2);
                } else {
                    shareItem.fwF = ShareItem.ForwardInfo.generateForwardInfo(this.aiB);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fwx);
                bundle.putInt("obj_type", shareItem.fwB);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putInt("obj_source", shareItem.eVJ);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                boolean z2 = false;
                shareDialogConfig.setIsAlaLive((this.aiB.getThreadType() != 49 || this.aiB.getThreadType() == 60) ? true : true);
                a(shareDialogConfig);
                com.baidu.tieba.c.f.ctM().b(shareDialogConfig);
            }
            z = true;
            String shareImageUrl2 = getShareImageUrl(this.aiB);
            if (shareImageUrl2 != null) {
            }
            str2 = this.aiB.getAbstract();
            String string3 = getResources().getString(R.string.share_content_tpl);
            String string22 = getResources().getString(R.string.default_share_content_tpl);
            if (this.aiB.bmB()) {
            }
            format = MessageFormat.format(string3, title, str2);
            String cutString3 = au.cutString(title, 100);
            String cutString22 = au.cutString(format, 100);
            ShareItem shareItem2 = new ShareItem();
            shareItem2.title = cutString3;
            shareItem2.content = cutString22;
            int stateThreadType2 = getStateThreadType(this.aiB);
            if (!this.aiB.bmB()) {
            }
            shareItem2.linkUrl = str4;
            shareItem2.extData = tid;
            shareItem2.fid = valueOf;
            shareItem2.fName = bnW;
            shareItem2.tid = tid;
            shareItem2.fwj = true;
            shareItem2.eVJ = this.flU;
            shareItem2.fww = getShareObjSource();
            shareItem2.fwB = stateThreadType2;
            shareItem2.fwx = 3;
            shareItem2.fwy = getShareObjParam2(this.aiB);
            if (parse != null) {
            }
            if (this.aiB.bmB()) {
            }
            shareItem2.canShareBySmartApp = z;
            if (z) {
            }
            buJ();
            shareItem2.fwE = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aiB);
            if (this.mFrom != 13) {
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem2.fwx);
            bundle2.putInt("obj_type", shareItem2.fwB);
            bundle2.putString("fid", shareItem2.fid);
            bundle2.putString("tid", shareItem2.tid);
            bundle2.putInt("obj_source", shareItem2.eVJ);
            shareItem2.ae(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, shareItem2, true, true);
            boolean z22 = false;
            shareDialogConfig2.setIsAlaLive((this.aiB.getThreadType() != 49 || this.aiB.getThreadType() == 60) ? true : true);
            a(shareDialogConfig2);
            com.baidu.tieba.c.f.ctM().b(shareDialogConfig2);
        }
    }

    private void buJ() {
        ItemInfo cBU;
        if ((this.mContext instanceof ak) && ((ak) this.mContext).cBV() && this.aiB != null && this.aiB.bpY() == null && (cBU = ((ak) this.mContext).cBU()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cBU.id.longValue());
            builder.item_name = cBU.name;
            builder.icon_size = cBU.icon_size;
            builder.icon_url = cBU.icon_url;
            builder.tags = cBU.tags;
            if (cBU.score != null && cBU.score.item_point != null) {
                Iterator<ItemPoint> it = cBU.score.item_point.iterator();
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
            this.aiB.a(itemData);
        }
    }

    private int getShareObjParam2(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bmz()) {
            return 10;
        }
        if (cbVar.bmA()) {
            return 9;
        }
        if (cbVar.bpQ()) {
            return 8;
        }
        if (cbVar.bpP()) {
            return 7;
        }
        if (cbVar.isShareThread) {
            return 6;
        }
        if (cbVar.threadType == 0) {
            return 1;
        }
        if (cbVar.threadType == 40) {
            return 2;
        }
        if (cbVar.threadType == 49) {
            return 3;
        }
        if (cbVar.threadType == 54) {
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
        if (this.flU == 1) {
            return 5;
        }
        if (this.flU != 3) {
            if (this.flU == 4) {
                return 4;
            }
            if (this.flU == 6) {
                return 8;
            }
            if (this.flU != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String getShareImageUrl(cb cbVar) {
        String str;
        if (cbVar == null) {
            return null;
        }
        if (cbVar.bol() != null && !TextUtils.isEmpty(cbVar.bol().cover)) {
            return cbVar.bol().cover;
        }
        if (cbVar.bob() == null) {
            return null;
        }
        ArrayList<MediaData> bob = cbVar.bob();
        int size = bob.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bob.get(i);
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
        if (str == null && cbVar.boj() != null && !TextUtils.isEmpty(cbVar.boj().thumbnail_url)) {
            return cbVar.boj().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(cb cbVar) {
        if (cbVar != null) {
            if (cbVar.bnU()) {
                return 4;
            }
            if (cbVar.bnP() == 1) {
                return 3;
            }
            if (cbVar.bmz()) {
                return 5;
            }
            if (cbVar.bmA()) {
                return 6;
            }
            if (cbVar.bpP()) {
                return 7;
            }
            if (cbVar.bpQ()) {
                return 8;
            }
            if (!cbVar.isShareThread || cbVar.eUD == null) {
                return cbVar.bpm() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bC(View view) {
        if (this.flH == null) {
            this.flH = new ac(this.mPageContext, isShow(16));
        }
        this.flH.setData(this.aiB);
        this.flH.QH();
        if (this.aiB != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).v("uid", TbadkCoreApplication.getCurrentAccountId()).v("fid", this.aiB.getFid()).dR("tid", this.aiB.getId()));
        }
    }

    private void bD(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.flM = z;
        if (this.akL != null) {
            this.akL.setClickable(this.flM);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(cb cbVar) {
        if (cbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiB = cbVar;
        ain();
        D(cbVar);
        G(cbVar);
        C(cbVar);
        B(cbVar);
        updatePraiseNum(cbVar);
        F(cbVar);
        H(cbVar);
        setVisibility(this.isVisible ? 0 : 8);
        E(cbVar);
        buD();
        return this.isVisible;
    }

    protected void buD() {
    }

    protected void ain() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(cb cbVar) {
        this.akL.setVisibility(8);
    }

    protected void E(cb cbVar) {
        if (cbVar != null && this.mFrom == 13) {
            showOperationMaskView(cbVar.isAuthorView == 1);
        }
    }

    public void showOperationMaskView(boolean z) {
        if (z && this.flZ == null) {
            this.flZ = new MaskView(getContext());
            addView(this.flZ);
        }
        if (this.flZ != null) {
            this.flZ.setVisibility(z ? 0 : 8);
        }
    }

    protected void F(cb cbVar) {
        if (this.flJ != null && this.dlq != null && this.flI != null && cbVar != null) {
            if (!this.fmc) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.flJ.setVisibility(8);
            } else if (this.flT && !isShow(128) && (com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.dlq.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.dlq.performClick();
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
                if (this.aiB.bpF() || this.aiB.bpG()) {
                    ap.setViewTextColor(this.flI, R.color.CAM_X0304);
                    WebPManager.a(this.dlq, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
                } else {
                    com.baidu.tbadk.core.elementsMaven.c.br(this.flI).oe(R.color.CAM_X0107);
                    WebPManager.a(this.dlq, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                }
                this.mMaskView.setVisibility(0);
                this.flJ.setVisibility(8);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.flJ.setVisibility(8);
            }
        }
    }

    private void G(cb cbVar) {
        String bnv;
        if (this.flu != null && cbVar != null) {
            if (cbVar.bnL() <= 0 || !this.flK) {
                this.flu.setVisibility(8);
                return;
            }
            this.flu.setVisibility(0);
            if (this.mFrom == 3) {
                bnv = cbVar.bnw();
            } else {
                bnv = cbVar.bnv();
            }
            this.flu.setText(bnv);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(cb cbVar) {
        if (this.flw != null && cbVar != null) {
            if (this.flP) {
                this.fly.setVisibility(0);
                if (cbVar.bnJ() > 0) {
                    this.flw.setVisibility(0);
                    String numFormatOverWan = au.numFormatOverWan(cbVar.bnJ());
                    if (this.flN) {
                        updateReplyStateUI();
                        this.flw.setText(numFormatOverWan);
                    } else {
                        this.flw.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.flw.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.flN) {
                    updateReplyStateUI();
                    this.flw.setText(this.mContext.getString(R.string.action_comment_default));
                    this.flw.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.flw.setVisibility(8);
                    return;
                }
            }
            this.fly.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        int color;
        if (this.flN) {
            WebPManager.a(this.flx, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
        this.flx.setEnabled(this.aiB == null || this.aiB.getType() != cb.eSE);
        EMTextView eMTextView = this.flw;
        if (this.aiB != null && this.aiB.getType() == cb.eSE) {
            color = com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.fcn);
        } else {
            color = ap.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
    }

    public void updateManagerUI() {
        int color;
        WebPManager.a(this.flF, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        EMTextView eMTextView = this.flE;
        if (this.aiB != null && this.aiB.getType() == cb.eSE) {
            color = com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.fcn);
        } else {
            color = ap.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
        this.flF.setEnabled(this.aiB == null || this.aiB.getType() != cb.eSE);
    }

    public void updatePraiseNum(cb cbVar) {
        setAgreeViewType(cbVar);
        if (cbVar.bpL() != null) {
            cbVar.bpL().isInThread = true;
            this.flv.setCardType(cbVar.bpT());
            this.flv.setThreadData(cbVar);
            this.flv.setData(cbVar.bpL());
        }
        this.flv.setAlpha((this.aiB == null || this.aiB.getType() != cb.eSE) ? 1.0f : ap.fcn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(cb cbVar) {
        if (this.flB != null && this.flz != null && cbVar != null) {
            if (this.flR) {
                this.flB.setVisibility(0);
                long bpw = cbVar.bpw();
                if ((cbVar.bpl() || cbVar.bpo()) && cbVar.bol() != null && cbVar.bol().share_info != null) {
                    bpw = cbVar.bol().share_info.share_count;
                }
                this.flz.setText(bpw > 0 ? au.numFormatOverWan(bpw) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                updateShareStateUI(cbVar);
                return;
            }
            this.flB.setVisibility(8);
        }
    }

    public void updateShareStateUI(cb cbVar) {
        WebPManager.a(this.flA, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        if (AntiHelper.bd(cbVar)) {
            setShareClickable(true);
            this.flz.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.fcn));
        } else if (cbVar != null && cbVar.eUD != null && this.aiB.eUD.eOY) {
            setShareClickable(false);
            this.flz.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.fcn));
        } else {
            setShareClickable(true);
            com.baidu.tbadk.core.elementsMaven.c.br(this.flz).oe(R.color.CAM_X0107);
        }
        if (this.aiB != null && this.aiB.getType() == cb.eSE) {
            this.flA.setEnabled(false);
            this.flz.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.fcn));
        }
    }

    protected void H(cb cbVar) {
        if (this.flG != null && cbVar != null) {
            this.flS = isShow(4);
            if (cbVar.eUO != null) {
                this.flS = false;
            }
            if (this.flS && (this.flJ == null || this.flJ.getVisibility() == 8)) {
                this.flG.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.flE.setText(string);
                this.flE.setContentDescription(string);
                this.isVisible = true;
            } else {
                this.flG.setVisibility(isShow(64) ? 4 : 8);
            }
            updateManagerUI();
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.e eVar) {
        if (this.flv != null) {
            this.flv.setStatisticData(eVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            if (this.flZ != null) {
                this.flZ.bzq();
            }
            ap.setViewTextColor(this.akL, R.color.CAM_X0109);
            ap.setViewTextColor(this.flu, R.color.CAM_X0107);
            updateReplyStateUI();
            updateShareStateUI(this.aiB);
            updateManagerUI();
            if (this.flH != null) {
                this.flH.onChangeSkinType();
            }
            if (this.flv != null) {
                this.flv.onChangeSkinType(this.mSkinType);
                this.flv.setAlpha((this.aiB == null || this.aiB.getType() != cb.eSE) ? 1.0f : ap.fcn);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.flY = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.akL;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.flQ = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.flK = z;
    }

    public View getCommentNumView() {
        return this.flw;
    }

    public View getCommentContainer() {
        return this.fly;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.flN = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.flO = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.flR = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.flx.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.flx.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.flR = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.flx.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.flx.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.flT = z;
    }

    public void setManageVisible(boolean z) {
        this.flS = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.fma = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.dlq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.fmc = z;
    }

    public boolean isInFrsAllThread() {
        return this.fmc;
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
        if (this.flH != null) {
            this.flH.destory();
        }
    }

    public void setAgreeViewType(cb cbVar) {
        if (cbVar != null && cbVar.bmB()) {
            this.flv.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.flv.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.fmb = aVar;
    }
}
