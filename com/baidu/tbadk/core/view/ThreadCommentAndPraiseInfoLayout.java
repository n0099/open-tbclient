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
import com.baidu.tbadk.core.data.by;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.n;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
/* loaded from: classes21.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected by ahA;
    protected TextView ajT;
    private int akO;
    protected ImageView dhw;
    private int eXm;
    protected int faG;
    private TextView fcE;
    protected AgreeView fcF;
    protected EMTextView fcG;
    protected ImageView fcH;
    protected View fcI;
    protected EMTextView fcJ;
    protected ImageView fcK;
    protected View fcL;
    protected FrameLayout fcM;
    protected ImageView fcN;
    protected EMTextView fcO;
    protected ImageView fcP;
    protected View fcQ;
    protected ac fcR;
    protected EMTextView fcS;
    protected LinearLayout fcT;
    protected boolean fcU;
    protected boolean fcV;
    protected boolean fcW;
    protected boolean fcX;
    protected boolean fcY;
    protected boolean fcZ;
    protected boolean fda;
    protected boolean fdb;
    protected boolean fdc;
    protected boolean fdd;
    protected boolean fde;
    private int fdf;
    public int fdg;
    public String fdh;
    private String fdi;
    private View.OnClickListener fdj;
    private b fdk;
    private a fdl;
    private boolean fdm;
    CustomMessageListener fdn;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;
    CustomMessageListener mUpdateShareNumListener;

    /* loaded from: classes21.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void jJ(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.fdi = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.fcF != null) {
            this.fcF.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.fdf = i;
    }

    public void setGameId(int i) {
        this.eXm = i;
        if (this.fcF != null) {
            this.fcF.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.fcF != null) {
            this.fcF.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fdn);
        MessageManager.getInstance().registerListener(this.mUpdateShareNumListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fdn);
        MessageManager.getInstance().unRegisterListener(this.mUpdateShareNumListener);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.faG = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.akO = 11;
        this.fcU = false;
        this.fcV = true;
        this.fcW = true;
        this.fcX = true;
        this.fcY = false;
        this.fcZ = false;
        this.fda = true;
        this.fdb = false;
        this.fdc = true;
        this.fdd = false;
        this.fde = true;
        this.mFrom = 2;
        this.fdf = 1;
        this.mSkinType = 3;
        this.fdk = null;
        this.fdm = true;
        this.fdn = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof by)) {
                    by byVar = (by) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.ahA != null && byVar != null) {
                        String str = byVar.getBaijiahaoData() != null ? byVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.ahA.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.ahA.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.ahA.oD(byVar.boG());
                                ThreadCommentAndPraiseInfoLayout.this.C(byVar);
                                return;
                            }
                            return;
                        }
                        String id = byVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.ahA.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.ahA.oD(byVar.boG());
                            ThreadCommentAndPraiseInfoLayout.this.C(byVar);
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
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.ahA != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.ahA.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.ahA.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.ahA.bqi() || ThreadCommentAndPraiseInfoLayout.this.ahA.bql()) && ThreadCommentAndPraiseInfoLayout.this.ahA.bpj() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.ahA.bpj() != null && ThreadCommentAndPraiseInfoLayout.this.ahA.bpj().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.ahA.bpj().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.ahA.dJ(ThreadCommentAndPraiseInfoLayout.this.ahA.bqt() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.ahA);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.faG = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.akO = 11;
        this.fcU = false;
        this.fcV = true;
        this.fcW = true;
        this.fcX = true;
        this.fcY = false;
        this.fcZ = false;
        this.fda = true;
        this.fdb = false;
        this.fdc = true;
        this.fdd = false;
        this.fde = true;
        this.mFrom = 2;
        this.fdf = 1;
        this.mSkinType = 3;
        this.fdk = null;
        this.fdm = true;
        this.fdn = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof by)) {
                    by byVar = (by) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.ahA != null && byVar != null) {
                        String str = byVar.getBaijiahaoData() != null ? byVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.ahA.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.ahA.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.ahA.oD(byVar.boG());
                                ThreadCommentAndPraiseInfoLayout.this.C(byVar);
                                return;
                            }
                            return;
                        }
                        String id = byVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.ahA.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.ahA.oD(byVar.boG());
                            ThreadCommentAndPraiseInfoLayout.this.C(byVar);
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
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.ahA != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.ahA.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.ahA.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.ahA.bqi() || ThreadCommentAndPraiseInfoLayout.this.ahA.bql()) && ThreadCommentAndPraiseInfoLayout.this.ahA.bpj() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.ahA.bpj() != null && ThreadCommentAndPraiseInfoLayout.this.ahA.bpj().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.ahA.bpj().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.ahA.dJ(ThreadCommentAndPraiseInfoLayout.this.ahA.bqt() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.ahA);
                    }
                }
            }
        };
        init(context);
    }

    protected View eK(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.faG = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aQK();
    }

    protected void aQK() {
        an(eK(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void an(View view) {
        this.ajT = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fcE = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.fcG = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.fcG).pu(R.string.F_X01);
        this.fcH = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fcI = view.findViewById(R.id.thread_info_commont_container);
        this.fcJ = (EMTextView) view.findViewById(R.id.share_num);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.fcJ).pu(R.string.F_X01);
        this.fcK = (ImageView) view.findViewById(R.id.share_num_img);
        this.fcL = view.findViewById(R.id.share_num_container);
        this.fcM = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.fcN = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.fcF = (AgreeView) findViewById;
            this.fcF.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.fdj != null) {
                        ThreadCommentAndPraiseInfoLayout.this.fdj.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.ahA);
                }
            });
        }
        this.fcQ = view.findViewById(R.id.manage_view_container);
        this.fcO = (EMTextView) view.findViewById(R.id.thread_info_manage_text);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.fcO).pu(R.string.F_X01);
        this.fcP = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.dhw = (ImageView) view.findViewById(R.id.manage_select_img);
        this.fcS = (EMTextView) view.findViewById(R.id.manage_select_text);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.fcS).pu(R.string.F_X01);
        this.fcT = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.fcT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.dhw.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.fcS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dhw.performClick();
            }
        });
        this.fcT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dhw.performClick();
            }
        });
        this.fcI.setOnClickListener(this);
        this.fcL.setOnClickListener(this);
        this.fcQ.setOnClickListener(this);
        this.dhw.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.akO = i;
        un();
    }

    private void un() {
        int i;
        this.fcL.setVisibility(isShow(1) ? 0 : 8);
        this.fcI.setVisibility(isShow(2) ? 0 : 8);
        View view = this.fcQ;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.fcF.setVisibility(isShow(8) ? 0 : 8);
        this.fcF.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.akO & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ajT) {
            bw(view);
        } else if (view == this.fcI) {
            bt(view);
        } else if (view == this.fcL) {
            bu(view);
        } else if (view == this.fcN) {
            by(view);
        } else if (view == this.fcQ) {
            bx(view);
        } else if (view == this.dhw) {
            bv(view);
        }
    }

    protected void bv(View view) {
        boolean z = false;
        if (this.dhw != null && this.ahA != null && this.fcS != null && !this.ahA.bqE()) {
            if (!this.ahA.bqC() && com.baidu.tieba.frs.b.cBe().cAY()) {
                if (com.baidu.tieba.frs.b.cBe().al(this.ahA)) {
                    this.ahA.jg(true);
                }
            } else if (!this.ahA.bqD() && com.baidu.tieba.frs.a.cAX().cAY()) {
                if (com.baidu.tieba.frs.a.cAX().al(this.ahA)) {
                    this.ahA.jh(true);
                }
            } else {
                com.baidu.tieba.frs.b.cBe().am(this.ahA);
                this.ahA.jg(false);
                com.baidu.tieba.frs.a.cAX().am(this.ahA);
                this.ahA.jh(false);
            }
            if (this.ahA.bqC() || this.ahA.bqD()) {
                ap.setViewTextColor(this.fcS, R.color.CAM_X0304);
                WebPManager.a(this.dhw, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            } else {
                com.baidu.tbadk.core.elementsMaven.c.bm(this.fcS).px(R.color.CAM_X0107);
                WebPManager.a(this.dhw, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            }
            if (this.fdk != null) {
                b bVar = this.fdk;
                if (this.ahA.bqC() || this.ahA.bqD()) {
                    z = true;
                }
                bVar.jJ(z);
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.fcI != null) {
            this.fcI.setClickable(z);
            this.fcH.setEnabled(z);
            this.fcG.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.fcL != null) {
            this.fcL.setClickable(z);
            this.fcK.setEnabled(z);
            this.fcJ.setEnabled(z);
        }
    }

    private void bw(View view) {
        if (this.ahA != null && !StringUtils.isNull(this.ahA.boT())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.fdi)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ahA.boT(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ahA.boT(), this.mStType, this.fdi)));
            }
            if (this.fdj != null) {
                this.fdj.onClick(view);
            }
        }
    }

    private boolean w(by byVar) {
        return (byVar == null || !byVar.bnv() || byVar.bph() == null) ? false : true;
    }

    protected void bt(View view) {
        if (this.ahA != null && this.mContext != null) {
            n.Jq(this.ahA.getTid());
            ar arVar = new ar("c12942");
            arVar.al("obj_locate", this.mFrom);
            arVar.al("obj_type", getThreadType());
            arVar.dY("tid", this.ahA.getTid());
            arVar.dY("nid", this.ahA.getNid());
            if (this.mFrom == 18) {
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.w("fid", this.ahA.getFid());
                arVar.al("obj_locate", 18);
                arVar.dY("resource_id", this.mTabName);
            }
            com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(this);
            if (bM != null) {
                arVar.dY("obj_cur_page", bM.getCurrentPageKey());
            }
            if (com.baidu.tbadk.pageExtra.d.bET() != null) {
                arVar.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
            }
            TiebaStatic.log(arVar);
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ahA, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ahA.getFid()));
            addLocateParam.setForumName(this.ahA.boT());
            if (this.ahA.bqG() && this.ahA.bqF() != null) {
                addLocateParam.setForumId(this.ahA.bqF().getForumId());
                addLocateParam.setForumName(this.ahA.bqF().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.fdl != null) {
                this.fdl.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.ahA)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.an(this.ahA);
            }
            if (this.ahA.eMf) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.ahA.bpY() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.fdg);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ar arVar2 = new ar("c12291");
            arVar2.al("obj_locate", this.mFrom);
            TiebaStatic.log(arVar2);
            bvG();
            a(view, this.ahA);
            if (this.fdj != null) {
                this.fdj.onClick(view);
            }
        }
    }

    private void bvG() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            ar arVar = new ar("c13568");
            arVar.al("obj_source", threadSourceForDynamicAndBjh);
            arVar.al("obj_type", threadTypeForDynamicAndBjh);
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
        if (this.ahA == null) {
            return 0;
        }
        if (this.ahA.bnx()) {
            return 1;
        }
        if (this.ahA.bny()) {
            return 2;
        }
        if (this.ahA.bqM()) {
            return 3;
        }
        return this.ahA.bqN() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.ahA == null) {
            return 0;
        }
        if (this.ahA.isShareThread) {
            return 4;
        }
        if (this.ahA.getThreadType() == 49) {
            return 5;
        }
        if (this.ahA.bph() != null) {
            return 1;
        }
        if (this.ahA.getType() == by.eIS || this.ahA.getType() == by.eJp) {
            if (y.getCount(this.ahA.bpc()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.ahA != null || i >= 0) {
            ar qX = qX(i);
            qX.al("thread_type", this.ahA.getThreadType());
            TiebaStatic.log(qX);
        }
    }

    private ar qX(int i) {
        if (this.ahA == null && i < 0) {
            return null;
        }
        ar arVar = new ar("c12003");
        arVar.dY("tid", this.ahA.getTid());
        if (this.ahA.getThreadType() == 40) {
            arVar.dY("obj_param1", "2");
        } else if (this.ahA.getThreadType() == 0) {
            arVar.dY("obj_param1", "1");
        }
        arVar.dY("obj_source", "1");
        arVar.w("fid", this.ahA.getFid());
        arVar.al("obj_locate", this.mFrom);
        arVar.al("obj_id", i);
        if (!au.isEmpty(this.fdh)) {
            arVar.dY("obj_floor", this.fdh);
        }
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        arVar.dY("nid", this.ahA.getNid());
        arVar.al(IntentConfig.CARD_TYPE, this.ahA.bqQ());
        arVar.dY(IntentConfig.RECOM_SOURCE, this.ahA.mRecomSource);
        arVar.dY("ab_tag", this.ahA.mRecomAbTag);
        arVar.dY("weight", this.ahA.mRecomWeight);
        arVar.dY("extra", this.ahA.mRecomExtra);
        if (this.ahA.getBaijiahaoData() != null && !au.isEmpty(this.ahA.getBaijiahaoData().oriUgcVid)) {
            arVar.dY("obj_param6", this.ahA.getBaijiahaoData().oriUgcVid);
        }
        com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(this);
        if (bM != null) {
            arVar.dY("obj_cur_page", bM.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bET() != null) {
            arVar.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
            return arVar;
        }
        return arVar;
    }

    protected void bu(View view) {
        if ((ShareSwitch.isOn() || bh.checkUpIsLogin(this.mContext)) && this.ahA != null) {
            bvH();
            a(view, this.ahA);
            if (!AntiHelper.d(getContext(), this.ahA)) {
                bvJ();
                if (this.fdj != null) {
                    this.fdj.onClick(view);
                }
            }
        }
    }

    private void bvH() {
        if (this.ahA != null) {
            ar bvI = bvI();
            bvI.al("thread_type", this.ahA.getThreadType());
            TiebaStatic.log(bvI);
        }
    }

    private ar bvI() {
        if (this.ahA == null) {
            return null;
        }
        int i = 0;
        if (this.fdf == 1) {
            i = 4;
        } else if (this.fdf == 2) {
            i = 5;
        } else if (this.fdf == 3) {
            i = 3;
        } else if (this.fdf == 4) {
            i = 2;
        } else if (this.fdf == 6) {
            i = 8;
        } else if (this.fdf == 7) {
            i = 9;
        } else if (this.fdf == 9) {
            i = 10;
        } else if (this.fdf == 10) {
            i = 17;
        } else if (this.fdf == 18) {
            i = 20;
        }
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        arVar.w("fid", this.ahA.getFid());
        arVar.dY("tid", this.ahA.getTid());
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.al("obj_locate", i);
        arVar.al(TiebaInitialize.Params.OBJ_PARAM2, this.eXm);
        if (!au.isEmpty(this.fdh)) {
            arVar.dY("obj_floor", this.fdh);
        }
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.ahA.bpj() != null && this.ahA.bpj().user_info != null && this.ahA.bpj().user_info.is_official == 2) {
            arVar.al("obj_isofficial", this.ahA.bpj().user_info.is_official);
        }
        arVar.al(IntentConfig.CARD_TYPE, this.ahA.bqQ()).dY("ab_tag", this.ahA.mRecomAbTag).dY(IntentConfig.RECOM_SOURCE, this.ahA.mRecomSource).dY("weight", this.ahA.mRecomWeight).dY("extra", this.ahA.mRecomExtra);
        if (this.ahA.bnx()) {
            arVar.al("obj_type", 10);
        } else if (this.ahA.bny()) {
            arVar.al("obj_type", 9);
        } else if (this.ahA.bqN()) {
            arVar.al("obj_type", 8);
        } else if (this.ahA.bqM()) {
            arVar.al("obj_type", 7);
        } else if (this.ahA.isShareThread) {
            arVar.al("obj_type", 6);
        } else if (this.ahA.threadType == 0) {
            arVar.al("obj_type", 1);
        } else if (this.ahA.threadType == 40) {
            arVar.al("obj_type", 2);
        } else if (this.ahA.threadType == 49) {
            arVar.al("obj_type", 3);
        } else if (this.ahA.threadType == 54) {
            arVar.al("obj_type", 4);
        } else {
            arVar.al("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            arVar.dY("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            arVar.dY("obj_tab", "a099");
            arVar.dY("resource_id", this.mTabName);
        }
        if (this.ahA.getBaijiahaoData() != null) {
            arVar.dY("obj_param4", this.ahA.getBaijiahaoData().oriUgcNid);
            if (this.ahA.bny() || this.ahA.bqN()) {
                arVar.dY("obj_param6", this.ahA.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.ahA.bqL()) {
            arVar.al("obj_param5", 2);
        } else if (this.ahA.bnx() || this.ahA.bny()) {
            arVar.al("obj_param5", 3);
        } else if (this.ahA.threadType == 0 || this.ahA.threadType == 40) {
            arVar.al("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), arVar);
        }
        arVar.dY("nid", this.ahA.getNid());
        return arVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, by byVar) {
        int i;
        int i2 = 1;
        if (byVar != null) {
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
                TiebaStatic.log(com.baidu.tieba.t.a.a("c13694", byVar, i2, i));
            }
        }
    }

    private void bvJ() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.ahA != null && this.mContext != null) {
            String valueOf = String.valueOf(this.ahA.getFid());
            String boT = this.ahA.boT();
            if (this.ahA.eLS != null) {
                valueOf = this.ahA.eLS.id;
                boT = this.ahA.eLS.ori_fname;
            }
            String title = this.ahA.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.ahA.getAbstract();
            }
            if (this.ahA.bnz()) {
                tid = this.ahA.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.ahA.getBaijiahaoData().oriUgcType + "&dvid=" + this.ahA.getBaijiahaoData().oriUgcVid + "&nid=" + this.ahA.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.ahA.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            boolean z = true;
            if (this.ahA.bpj() != null && this.ahA.bpj().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.ahA.bpj().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.ahA.bpj().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(this.ahA);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = this.ahA.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.ahA.bnz() || this.ahA.boP() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.ahA.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.ahA.boP().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = au.cutString(title, 100);
            String cutString2 = au.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(this.ahA);
            if (this.ahA.bnz()) {
                shareItem.readCount = -1L;
                shareItem.fnC = cutString2;
            } else {
                if (stateThreadType == 2 && this.ahA.bph() != null) {
                    shareItem.readCount = this.ahA.bph().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = this.ahA.boH();
                }
                shareItem.fnC = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = boT;
            shareItem.tid = tid;
            shareItem.fnr = true;
            shareItem.eMJ = this.fdf;
            shareItem.fnE = getShareObjSource();
            shareItem.fnJ = stateThreadType;
            shareItem.fnF = 3;
            shareItem.fnG = getShareObjParam2(this.ahA);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.ahA.bnz()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.fnT = this.ahA.getShareImageUrl();
            }
            bvK();
            shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahA);
            if (this.mFrom == 13) {
                shareItem.fnN = ShareItem.ForwardInfo.generateForwardInfo(this.ahA, 2);
            } else {
                shareItem.fnN = ShareItem.ForwardInfo.generateForwardInfo(this.ahA);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fnF);
            bundle.putInt("obj_type", shareItem.fnJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eMJ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.ahA.getThreadType() == 49 || this.ahA.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.d.f.ctl().b(shareDialogConfig);
        }
    }

    private void bvK() {
        ItemInfo cBu;
        if ((this.mContext instanceof an) && ((an) this.mContext).cBv() && this.ahA != null && this.ahA.bqV() == null && (cBu = ((an) this.mContext).cBu()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cBu.id.longValue());
            builder.item_name = cBu.name;
            builder.icon_size = cBu.icon_size;
            builder.icon_url = cBu.icon_url;
            builder.tags = cBu.tags;
            if (cBu.score != null && cBu.score.item_point != null) {
                Iterator<ItemPoint> it = cBu.score.item_point.iterator();
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
            this.ahA.a(itemData);
        }
    }

    private int getShareObjParam2(by byVar) {
        if (byVar == null) {
            return 0;
        }
        if (byVar.bnx()) {
            return 10;
        }
        if (byVar.bny()) {
            return 9;
        }
        if (byVar.bqN()) {
            return 8;
        }
        if (byVar.bqM()) {
            return 7;
        }
        if (byVar.isShareThread) {
            return 6;
        }
        if (byVar.threadType == 0) {
            return 1;
        }
        if (byVar.threadType == 40) {
            return 2;
        }
        if (byVar.threadType == 49) {
            return 3;
        }
        if (byVar.threadType == 54) {
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
        if (this.fdf == 1) {
            return 5;
        }
        if (this.fdf != 3) {
            if (this.fdf == 4) {
                return 4;
            }
            if (this.fdf == 6) {
                return 8;
            }
            if (this.fdf != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String getShareImageUrl(by byVar) {
        String str;
        if (byVar == null) {
            return null;
        }
        if (byVar.bpj() != null && !TextUtils.isEmpty(byVar.bpj().cover)) {
            return byVar.bpj().cover;
        }
        if (byVar.boY() == null) {
            return null;
        }
        ArrayList<MediaData> boY = byVar.boY();
        int size = boY.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = boY.get(i);
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
        if (str == null && byVar.bph() != null && !TextUtils.isEmpty(byVar.bph().thumbnail_url)) {
            return byVar.bph().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(by byVar) {
        if (byVar != null) {
            if (byVar.boR()) {
                return 4;
            }
            if (byVar.boM() == 1) {
                return 3;
            }
            if (byVar.bnx()) {
                return 5;
            }
            if (byVar.bny()) {
                return 6;
            }
            if (byVar.bqM()) {
                return 7;
            }
            if (byVar.bqN()) {
                return 8;
            }
            if (!byVar.isShareThread || byVar.eLH == null) {
                return byVar.bqj() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bx(View view) {
        if (this.fcR == null) {
            this.fcR = new ac(this.mPageContext, isShow(16));
        }
        this.fcR.setData(this.ahA);
        this.fcR.RU();
        if (this.ahA != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.ahA.getFid()).dY("tid", this.ahA.getId()));
        }
    }

    private void by(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.fcX = z;
        if (this.ajT != null) {
            this.ajT.setClickable(this.fcX);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(by byVar) {
        if (byVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahA = byVar;
        akv();
        D(byVar);
        F(byVar);
        C(byVar);
        B(byVar);
        updatePraiseNum(byVar);
        E(byVar);
        G(byVar);
        setVisibility(this.fcU ? 0 : 8);
        bvE();
        return this.fcU;
    }

    protected void bvE() {
    }

    protected void akv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(by byVar) {
        this.ajT.setVisibility(8);
    }

    protected void E(by byVar) {
        if (this.fcT != null && this.dhw != null && this.fcS != null && byVar != null) {
            if (!this.fdm) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.fcT.setVisibility(8);
            } else if (this.fde && (com.baidu.tieba.frs.b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.dhw.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.dhw.performClick();
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
                if (this.ahA.bqC() || this.ahA.bqD()) {
                    ap.setViewTextColor(this.fcS, R.color.CAM_X0304);
                    WebPManager.a(this.dhw, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
                } else {
                    com.baidu.tbadk.core.elementsMaven.c.bm(this.fcS).px(R.color.CAM_X0107);
                    WebPManager.a(this.dhw, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                }
                this.mMaskView.setVisibility(0);
                this.fcT.setVisibility(8);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.fcT.setVisibility(8);
            }
        }
    }

    private void F(by byVar) {
        String bos;
        if (this.fcE != null && byVar != null) {
            if (byVar.boI() <= 0 || !this.fcV) {
                this.fcE.setVisibility(8);
                return;
            }
            this.fcE.setVisibility(0);
            if (this.mFrom == 3) {
                bos = byVar.bot();
            } else {
                bos = byVar.bos();
            }
            this.fcE.setText(bos);
            this.fcU = true;
        }
    }

    public boolean isVisible() {
        return this.fcU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(by byVar) {
        if (this.fcG != null && byVar != null) {
            if (this.fda) {
                this.fcI.setVisibility(0);
                if (byVar.boG() > 0) {
                    this.fcG.setVisibility(0);
                    String numFormatOverWan = au.numFormatOverWan(byVar.boG());
                    if (this.fcY) {
                        updateReplyStateUI();
                        this.fcG.setText(numFormatOverWan);
                    } else {
                        this.fcG.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.fcG.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.fcU = true;
                    return;
                } else if (this.fcY) {
                    updateReplyStateUI();
                    this.fcG.setText(this.mContext.getString(R.string.action_comment_default));
                    this.fcG.setVisibility(0);
                    this.fcU = true;
                    return;
                } else {
                    this.fcG.setVisibility(8);
                    return;
                }
            }
            this.fcI.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.fcY) {
            WebPManager.a(this.fcH, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
        com.baidu.tbadk.core.elementsMaven.c.bm(this.fcG).px(R.color.CAM_X0107);
    }

    public void updatePraiseNum(by byVar) {
        setAgreeViewType(byVar);
        if (byVar.bqI() != null) {
            byVar.bqI().isInThread = true;
            this.fcF.setCardType(byVar.bqQ());
            this.fcF.setThreadData(byVar);
            this.fcF.setData(byVar.bqI());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(by byVar) {
        if (this.fcL != null && this.fcJ != null && byVar != null) {
            if (this.fdc) {
                this.fcL.setVisibility(0);
                long bqt = byVar.bqt();
                if ((byVar.bqi() || byVar.bql()) && byVar.bpj() != null && byVar.bpj().share_info != null) {
                    bqt = byVar.bpj().share_info.share_count;
                }
                this.fcJ.setText(bqt > 0 ? au.numFormatOverWan(bqt) : this.mContext.getString(R.string.share));
                this.fcU = true;
                updateShareStateUI(byVar);
                return;
            }
            this.fcL.setVisibility(8);
        }
    }

    public void updateShareStateUI(by byVar) {
        WebPManager.a(this.fcK, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        if (AntiHelper.bb(byVar)) {
            setShareClickable(true);
            this.fcJ.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0107), ap.eTL));
        } else if (byVar != null && byVar.eLH != null && this.ahA.eLH.eGg) {
            setShareClickable(false);
            this.fcJ.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0107), ap.eTL));
        } else {
            setShareClickable(true);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.fcJ).px(R.color.CAM_X0107);
        }
    }

    protected void G(by byVar) {
        if (this.fcQ != null && byVar != null) {
            this.fdd = isShow(4);
            if (byVar.eLS != null) {
                this.fdd = false;
            }
            if (this.fdd && (this.fcT == null || this.fcT.getVisibility() == 8)) {
                this.fcQ.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.fcO.setText(string);
                this.fcO.setContentDescription(string);
                this.fcU = true;
                return;
            }
            this.fcQ.setVisibility(isShow(64) ? 4 : 8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.fcF != null) {
            this.fcF.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            ap.setViewTextColor(this.ajT, R.color.CAM_X0109);
            ap.setViewTextColor(this.fcE, R.color.CAM_X0107);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.fcO).px(R.color.CAM_X0107);
            updateReplyStateUI();
            updateShareStateUI(this.ahA);
            WebPManager.a(this.fcP, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (this.fcR != null) {
                this.fcR.onChangeSkinType();
            }
            if (this.fcF != null) {
                this.fcF.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fdj = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.ajT;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.fdb = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.fcV = z;
    }

    public View getCommentNumView() {
        return this.fcG;
    }

    public View getCommentContainer() {
        return this.fcI;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.fcY = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.fcZ = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.fdc = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fcH.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.fcH.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.fdc = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fcH.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.fcH.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.fde = z;
    }

    public void setManageVisible(boolean z) {
        this.fdd = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.fdk = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.dhw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.fdm = z;
    }

    public boolean isInFrsAllThread() {
        return this.fdm;
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
        if (this.fcR != null) {
            this.fcR.destory();
        }
    }

    public void setAgreeViewType(by byVar) {
        if (byVar != null && byVar.bnz()) {
            this.fcF.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.fcF.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.fdl = aVar;
    }
}
