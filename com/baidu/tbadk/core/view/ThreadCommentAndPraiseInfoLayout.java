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
    protected bj KJ;
    private int NC;
    private int ddo;
    protected boolean dhA;
    protected boolean dhB;
    protected boolean dhC;
    protected boolean dhD;
    private int dhE;
    public int dhF;
    public String dhG;
    private String dhH;
    private View.OnClickListener dhI;
    protected int dhJ;
    protected int dhK;
    private b dhL;
    private a dhM;
    private boolean dhN;
    CustomMessageListener dhO;
    CustomMessageListener dhP;
    protected int dhc;
    protected TextView dhd;
    private TextView dhe;
    protected AgreeView dhf;
    protected TextView dhg;
    protected ImageView dhh;
    protected View dhi;
    protected TextView dhj;
    protected ImageView dhk;
    protected View dhl;
    protected FrameLayout dhm;
    protected ImageView dhn;
    protected TextView dho;
    protected ImageView dhp;
    protected View dhq;
    protected aa dhr;
    protected TextView dhs;
    protected LinearLayout dht;
    protected boolean dhu;
    protected boolean dhv;
    protected boolean dhw;
    protected boolean dhx;
    protected boolean dhy;
    protected boolean dhz;
    protected boolean isVisible;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    protected ImageView mSelectImg;
    private int mSkinType;
    private String mStType;

    /* loaded from: classes8.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void fT(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.dhH = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.dhf != null) {
            this.dhf.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.dhE = i;
    }

    public void setGameId(int i) {
        this.ddo = i;
        if (this.dhf != null) {
            this.dhf.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dhO);
        MessageManager.getInstance().registerListener(this.dhP);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dhO);
        MessageManager.getInstance().unRegisterListener(this.dhP);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.dhc = 0;
        this.NC = 11;
        this.isVisible = false;
        this.dhu = true;
        this.dhv = true;
        this.dhw = true;
        this.dhx = false;
        this.dhy = false;
        this.dhz = true;
        this.dhA = false;
        this.dhB = true;
        this.dhC = false;
        this.dhD = true;
        this.mFrom = 2;
        this.dhE = 1;
        this.mSkinType = 3;
        this.dhL = null;
        this.dhN = false;
        this.dhO = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.KJ != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.KJ.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.KJ.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCd());
                                ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.KJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCd());
                            ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                        }
                    }
                }
            }
        };
        this.dhP = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.KJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.KJ.aDy() || ThreadCommentAndPraiseInfoLayout.this.KJ.aDB()) && ThreadCommentAndPraiseInfoLayout.this.KJ.aCF() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.KJ.aCF() != null && ThreadCommentAndPraiseInfoLayout.this.KJ.aCF().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.KJ.aCF().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.by(ThreadCommentAndPraiseInfoLayout.this.KJ.aDJ() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.v(ThreadCommentAndPraiseInfoLayout.this.KJ);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhc = 0;
        this.NC = 11;
        this.isVisible = false;
        this.dhu = true;
        this.dhv = true;
        this.dhw = true;
        this.dhx = false;
        this.dhy = false;
        this.dhz = true;
        this.dhA = false;
        this.dhB = true;
        this.dhC = false;
        this.dhD = true;
        this.mFrom = 2;
        this.dhE = 1;
        this.mSkinType = 3;
        this.dhL = null;
        this.dhN = false;
        this.dhO = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.KJ != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.KJ.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.KJ.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCd());
                                ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.KJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCd());
                            ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                        }
                    }
                }
            }
        };
        this.dhP = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.KJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.KJ.aDy() || ThreadCommentAndPraiseInfoLayout.this.KJ.aDB()) && ThreadCommentAndPraiseInfoLayout.this.KJ.aCF() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.KJ.aCF() != null && ThreadCommentAndPraiseInfoLayout.this.KJ.aCF().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.KJ.aCF().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.by(ThreadCommentAndPraiseInfoLayout.this.KJ.aDJ() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.v(ThreadCommentAndPraiseInfoLayout.this.KJ);
                    }
                }
            }
        };
        init(context);
    }

    protected View dR(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.dhc = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View dR = dR(context);
        this.dhd = (TextView) dR.findViewById(R.id.thread_info_bar_name);
        this.dhe = (TextView) dR.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) dR.findViewById(R.id.thread_comment_layout_root);
        this.dhg = (TextView) dR.findViewById(R.id.thread_info_commont_num);
        this.dhh = (ImageView) dR.findViewById(R.id.thread_info_commont_img);
        this.dhi = dR.findViewById(R.id.thread_info_commont_container);
        this.dhj = (TextView) dR.findViewById(R.id.share_num);
        this.dhk = (ImageView) dR.findViewById(R.id.share_num_img);
        this.dhl = dR.findViewById(R.id.share_num_container);
        this.dhm = (FrameLayout) dR.findViewById(R.id.btn_card_bottom_op_more_container);
        this.dhn = (ImageView) dR.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = dR.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.dhf = (AgreeView) findViewById;
            this.dhf.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadCommentAndPraiseInfoLayout.this.dhI != null) {
                        ThreadCommentAndPraiseInfoLayout.this.dhI.onClick(view);
                    }
                }
            });
        }
        this.dhq = dR.findViewById(R.id.manage_view_container);
        this.dho = (TextView) dR.findViewById(R.id.thread_info_manage_text);
        this.dhp = (ImageView) dR.findViewById(R.id.thread_info_manage_img);
        this.mSelectImg = (ImageView) dR.findViewById(R.id.manage_select_img);
        this.dhs = (TextView) dR.findViewById(R.id.manage_select_text);
        this.dht = (LinearLayout) dR.findViewById(R.id.manage_select_container);
        this.dht.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dhs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dht.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dhi.setOnClickListener(this);
        this.dhl.setOnClickListener(this);
        this.dhq.setOnClickListener(this);
        this.mSelectImg.setOnClickListener(this);
        this.dhK = R.drawable.icon_home_card_share;
        this.dhJ = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    public void setShowFlag(int i) {
        this.NC = i;
        nr();
    }

    private void nr() {
        int i;
        this.dhl.setVisibility(isShow(1) ? 0 : 8);
        this.dhi.setVisibility(isShow(2) ? 0 : 8);
        View view = this.dhq;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.dhf.setVisibility(isShow(8) ? 0 : 8);
        this.dhf.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.NC & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dhd) {
            aV(view);
        } else if (view == this.dhi) {
            aS(view);
        } else if (view == this.dhl) {
            aT(view);
        } else if (view == this.dhn) {
            aX(view);
        } else if (view == this.dhq) {
            aW(view);
        } else if (view == this.mSelectImg) {
            aU(view);
        }
    }

    protected void aU(View view) {
        if (this.mSelectImg != null && this.KJ != null && this.dhs != null && !this.KJ.aDU()) {
            if (!this.KJ.aDT()) {
                if (com.baidu.tieba.frs.a.bCT().ah(this.KJ)) {
                    this.KJ.fC(true);
                }
            } else {
                com.baidu.tieba.frs.a.bCT().ai(this.KJ);
                this.KJ.fC(false);
            }
            am.setViewTextColor(this.dhs, this.KJ.aDT() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.mSelectImg.setImageDrawable(am.getDrawable(this.KJ.aDT() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.dhL != null) {
                this.dhL.fT(this.KJ.aDT());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.dhi != null) {
            this.dhi.setClickable(z);
            this.dhh.setEnabled(z);
            this.dhg.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.dhl != null) {
            this.dhl.setClickable(z);
            this.dhk.setEnabled(z);
            this.dhj.setEnabled(z);
        }
    }

    private void aV(View view) {
        if (this.KJ != null && !StringUtils.isNull(this.KJ.aCr())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.dhH)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.KJ.aCr(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.KJ.aCr(), this.mStType, this.dhH)));
            }
            if (this.dhI != null) {
                this.dhI.onClick(view);
            }
        }
    }

    private boolean t(bj bjVar) {
        return (bjVar == null || !bjVar.aAZ() || bjVar.aCD() == null) ? false : true;
    }

    protected void aS(View view) {
        if (this.KJ != null && this.mContext != null) {
            com.baidu.tieba.card.l.zS(this.KJ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.KJ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.KJ.getFid()));
            addLocateParam.setForumName(this.KJ.aCr());
            if (this.KJ.aDW() && this.KJ.aDV() != null) {
                addLocateParam.setForumId(this.KJ.aDV().getForumId());
                addLocateParam.setForumName(this.KJ.aDV().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.dhM != null) {
                this.dhM.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(this.KJ)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.aj(this.KJ);
            }
            if (this.KJ.cUm) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.KJ.aDp() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.dhF);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.X("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.X("obj_locate", this.mFrom);
            anVar2.X("obj_type", getThreadType());
            anVar2.cy("tid", this.KJ.getTid());
            TiebaStatic.log(anVar2);
            aHX();
            if (this.dhI != null) {
                this.dhI.onClick(view);
            }
        }
    }

    private void aHX() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            an anVar = new an("c13568");
            anVar.X("obj_source", threadSourceForDynamicAndBjh);
            anVar.X("obj_type", threadTypeForDynamicAndBjh);
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
        if (this.KJ == null) {
            return 0;
        }
        if (this.KJ.aBb()) {
            return 1;
        }
        if (this.KJ.aBc()) {
            return 2;
        }
        if (this.KJ.aEe()) {
            return 3;
        }
        return this.KJ.aEf() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.KJ == null) {
            return 0;
        }
        if (this.KJ.isShareThread) {
            return 4;
        }
        if (this.KJ.getThreadType() == 49) {
            return 5;
        }
        if (this.KJ.aCD() != null) {
            return 1;
        }
        if (this.KJ.getType() == bj.cRi || this.KJ.getType() == bj.cRx) {
            if (v.getCount(this.KJ.aCA()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.KJ != null || i >= 0) {
            an ln = ln(i);
            ln.X("thread_type", this.KJ.getThreadType());
            TiebaStatic.log(ln);
        }
    }

    private an ln(int i) {
        if (this.KJ == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.cy("tid", this.KJ.getTid());
        if (this.KJ.getThreadType() == 40) {
            anVar.cy("obj_param1", "2");
        } else if (this.KJ.getThreadType() == 0) {
            anVar.cy("obj_param1", "1");
        }
        anVar.cy("obj_source", "1");
        anVar.s("fid", this.KJ.getFid());
        anVar.X("obj_locate", this.mFrom);
        anVar.X("obj_id", i);
        if (!aq.isEmpty(this.dhG)) {
            anVar.cy("obj_floor", this.dhG);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aT(View view) {
        if ((ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) && this.KJ != null) {
            aHY();
            if (!AntiHelper.d(getContext(), this.KJ)) {
                aIa();
                if (this.dhI != null) {
                    this.dhI.onClick(view);
                }
            }
        }
    }

    private void aHY() {
        if (this.KJ != null) {
            an aHZ = aHZ();
            aHZ.X("thread_type", this.KJ.getThreadType());
            TiebaStatic.log(aHZ);
        }
    }

    private an aHZ() {
        if (this.KJ == null) {
            return null;
        }
        int i = 0;
        if (this.dhE == 1) {
            i = 4;
        } else if (this.dhE == 2) {
            i = 5;
        } else if (this.dhE == 3) {
            i = 3;
        } else if (this.dhE == 4) {
            i = 2;
        } else if (this.dhE == 6) {
            i = 8;
        } else if (this.dhE == 7) {
            i = 9;
        } else if (this.dhE == 9) {
            i = 10;
        } else if (this.dhE == 10) {
            i = 17;
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("fid", this.KJ.getFid());
        anVar.cy("tid", this.KJ.getTid());
        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.X("obj_locate", i);
        anVar.X(TiebaInitialize.Params.OBJ_PARAM2, this.ddo);
        if (!aq.isEmpty(this.dhG)) {
            anVar.cy("obj_floor", this.dhG);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.KJ.aCF() != null && this.KJ.aCF().user_info != null && this.KJ.aCF().user_info.is_official == 2) {
            anVar.X("obj_isofficial", this.KJ.aCF().user_info.is_official);
        }
        anVar.X("card_type", this.KJ.aEj()).cy(TiebaInitialize.Params.AB_TAG, this.KJ.mRecomAbTag).cy("recom_source", this.KJ.mRecomSource).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, this.KJ.mRecomWeight).cy("extra", this.KJ.mRecomExtra);
        if (this.KJ.aBb()) {
            anVar.X("obj_type", 10);
        } else if (this.KJ.aBc()) {
            anVar.X("obj_type", 9);
        } else if (this.KJ.aEf()) {
            anVar.X("obj_type", 8);
        } else if (this.KJ.aEe()) {
            anVar.X("obj_type", 7);
        } else if (this.KJ.isShareThread) {
            anVar.X("obj_type", 6);
        } else if (this.KJ.threadType == 0) {
            anVar.X("obj_type", 1);
        } else if (this.KJ.threadType == 40) {
            anVar.X("obj_type", 2);
        } else if (this.KJ.threadType == 49) {
            anVar.X("obj_type", 3);
        } else if (this.KJ.threadType == 54) {
            anVar.X("obj_type", 4);
        } else {
            anVar.X("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            anVar.cy("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.KJ.getBaijiahaoData() != null) {
            anVar.cy("obj_param4", this.KJ.getBaijiahaoData().oriUgcNid);
            if (this.KJ.aBc() || this.KJ.aEf()) {
                anVar.cy("obj_param6", this.KJ.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.KJ.aEd()) {
            anVar.X("obj_param5", 2);
        } else if (this.KJ.aBb() || this.KJ.aBc()) {
            anVar.X("obj_param5", 3);
        } else if (this.KJ.threadType == 0 || this.KJ.threadType == 40) {
            anVar.X("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), anVar);
        }
        return anVar;
    }

    private void aIa() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.KJ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.KJ.getFid());
            String aCr = this.KJ.aCr();
            if (this.KJ.cTZ != null) {
                valueOf = this.KJ.cTZ.id;
                aCr = this.KJ.cTZ.ori_fname;
            }
            String title = this.KJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.KJ.getAbstract();
            }
            if (this.KJ.aEg()) {
                tid = this.KJ.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.KJ.getBaijiahaoData().oriUgcType + "&dvid=" + this.KJ.getBaijiahaoData().oriUgcVid + "&nid=" + this.KJ.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.KJ.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.KJ.aCF() != null && this.KJ.aCF().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.KJ.aCF().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.KJ.aCF().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String y = y(this.KJ);
            Uri parse = y == null ? null : Uri.parse(y);
            String str4 = this.KJ.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.KJ.aEg() || this.KJ.aCm() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.KJ.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.KJ.aCm().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = aq.cutString(title, 100);
            String cutString2 = aq.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int z2 = z(this.KJ);
            if (this.KJ.aEg()) {
                shareItem.readCount = -1L;
                shareItem.dqb = cutString2;
            } else {
                if (z2 == 2 && this.KJ.aCD() != null) {
                    shareItem.readCount = this.KJ.aCD().play_count.intValue();
                } else if (z2 == 1) {
                    shareItem.readCount = this.KJ.aCe();
                }
                shareItem.dqb = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aCr;
            shareItem.tid = tid;
            shareItem.dpR = true;
            shareItem.cUA = this.dhE;
            shareItem.dqd = getShareObjSource();
            shareItem.dqi = z2;
            shareItem.dqe = 3;
            shareItem.dqf = x(this.KJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.KJ.aEg()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.dqs = this.KJ.getShareImageUrl();
            }
            shareItem.dql = OriginalThreadInfo.ShareInfo.generateShareInfo(this.KJ);
            if (this.mFrom == 13) {
                shareItem.dqm = ShareItem.ForwardInfo.generateForwardInfo(this.KJ, 2);
            } else {
                shareItem.dqm = ShareItem.ForwardInfo.generateForwardInfo(this.KJ);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqe);
            bundle.putInt("obj_type", shareItem.dqi);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUA);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z3 = false;
            shareDialogConfig.setIsAlaLive((this.KJ.getThreadType() == 49 || this.KJ.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.e.bwk().b(shareDialogConfig);
        }
    }

    private int x(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBb()) {
            return 10;
        }
        if (bjVar.aBc()) {
            return 9;
        }
        if (bjVar.aEf()) {
            return 8;
        }
        if (bjVar.aEe()) {
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
        if (this.dhE == 1) {
            return 5;
        }
        if (this.dhE != 3) {
            if (this.dhE == 4) {
                return 4;
            }
            if (this.dhE == 6) {
                return 8;
            }
            if (this.dhE != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String y(bj bjVar) {
        String str;
        if (bjVar == null) {
            return null;
        }
        if (bjVar.aCF() != null && !TextUtils.isEmpty(bjVar.aCF().cover)) {
            return bjVar.aCF().cover;
        }
        if (bjVar.aCw() == null) {
            return null;
        }
        ArrayList<MediaData> aCw = bjVar.aCw();
        int size = aCw.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aCw.get(i);
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
        if (str == null && bjVar.aCD() != null && !TextUtils.isEmpty(bjVar.aCD().thumbnail_url)) {
            return bjVar.aCD().thumbnail_url;
        }
        return str;
    }

    private int z(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCo()) {
                return 4;
            }
            if (bjVar.aCj() == 1) {
                return 3;
            }
            if (bjVar.aBb()) {
                return 5;
            }
            if (bjVar.aBc()) {
                return 6;
            }
            if (bjVar.aEe()) {
                return 7;
            }
            if (bjVar.aEf()) {
                return 8;
            }
            if (!bjVar.isShareThread || bjVar.cTP == null) {
                return bjVar.aDz() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aW(View view) {
        if (this.dhr == null) {
            this.dhr = new aa(this.mPageContext, isShow(16));
        }
        this.dhr.setData(this.KJ);
        this.dhr.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aX(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.dhw = z;
        if (this.dhd != null) {
            this.dhd.setClickable(this.dhw);
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
        this.KJ = bjVar;
        aIb();
        A(bjVar);
        C(bjVar);
        w(bjVar);
        v(bjVar);
        updatePraiseNum(bjVar);
        B(bjVar);
        D(bjVar);
        setVisibility(this.isVisible ? 0 : 8);
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIb() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bj bjVar) {
        this.dhd.setVisibility(8);
    }

    protected void B(bj bjVar) {
        int equipmentWidth;
        if (this.dht != null && this.mSelectImg != null && this.dhs != null && bjVar != null) {
            if (!this.dhN) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dht.setVisibility(8);
            } else if (this.dhD && com.baidu.tieba.frs.a.bCT().bCU()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.mSelectImg.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
                        }
                    });
                }
                if (bjVar.aDU()) {
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
                am.setViewTextColor(this.dhs, this.KJ.aDT() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.mSelectImg.setImageDrawable(am.getDrawable(bjVar.aDT() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.dht.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dht.setVisibility(8);
            }
        }
    }

    private void C(bj bjVar) {
        String aBP;
        if (this.dhe != null && bjVar != null) {
            if (bjVar.aCf() <= 0 || !this.dhu) {
                this.dhe.setVisibility(8);
                return;
            }
            this.dhe.setVisibility(0);
            if (this.mFrom == 3) {
                aBP = bjVar.aBQ();
            } else {
                aBP = bjVar.aBP();
            }
            this.dhe.setText(aBP);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(bj bjVar) {
        if (this.dhg != null && bjVar != null) {
            if (this.dhz) {
                this.dhi.setVisibility(0);
                if (bjVar.aCd() > 0) {
                    this.dhg.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bjVar.aCd());
                    if (this.dhx) {
                        updateReplyStateUI();
                        this.dhg.setText(numFormatOverWan);
                    } else {
                        this.dhg.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dhg.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.dhx) {
                    updateReplyStateUI();
                    this.dhg.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dhg.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.dhg.setVisibility(8);
                    return;
                }
            }
            this.dhi.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.dhx) {
            SvgManager.aGA().a(this.dhh, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.dhg, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bj bjVar) {
        setAgreeViewType(bjVar);
        if (bjVar.aDY() != null) {
            bjVar.aDY().isInThread = true;
            this.dhf.setCardType(bjVar.aEj());
            this.dhf.setThreadData(bjVar);
            this.dhf.setData(bjVar.aDY());
        }
    }

    public void setAgreeViewType(bj bjVar) {
        if (bjVar != null && bjVar.aEg()) {
            this.dhf.setAgreeAlone(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(bj bjVar) {
        if (this.dhl != null && this.dhj != null && bjVar != null) {
            if (this.dhB) {
                this.dhl.setVisibility(0);
                long aDJ = bjVar.aDJ();
                if ((bjVar.aDy() || bjVar.aDB()) && bjVar.aCF() != null && bjVar.aCF().share_info != null) {
                    aDJ = bjVar.aCF().share_info.share_count;
                }
                this.dhj.setText(aDJ > 0 ? aq.numFormatOverWan(aDJ) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                updateShareStateUI(bjVar);
                return;
            }
            this.dhl.setVisibility(8);
        }
    }

    public void updateShareStateUI(bj bjVar) {
        if (AntiHelper.aY(bjVar)) {
            setShareClickable(true);
            SvgManager.aGA().a(this.dhk, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dhj, (int) R.color.cp_cont_e);
        } else if (bjVar != null && bjVar.cTP != null && this.KJ.cTP.cOJ) {
            setShareClickable(false);
            SvgManager.aGA().a(this.dhk, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dhj, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aGA().a(this.dhk, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dhj, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void D(bj bjVar) {
        if (this.dhq != null && bjVar != null) {
            this.dhC = isShow(4);
            if (bjVar.cTZ != null) {
                this.dhC = false;
            }
            if (this.dhC && (this.dht == null || this.dht.getVisibility() == 8)) {
                this.dhq.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.dho.setText(string);
                this.dho.setContentDescription(string);
                this.isVisible = true;
                return;
            }
            this.dhq.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.dhf != null) {
            this.dhf.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dhd, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dhe, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.dho, (int) R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.KJ);
            SvgManager.aGA().a(this.dhn, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGA().a(this.dhp, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.dhr != null) {
                this.dhr.onChangeSkinType();
            }
            if (this.dhf != null) {
                this.dhf.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dhI = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.dhd;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.dhA = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.dhu = z;
    }

    public View getCommentNumView() {
        return this.dhg;
    }

    public View getCommentContainer() {
        return this.dhi;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.dhx = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.dhy = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.dhB = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhh.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.dhh.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.dhB = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhh.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.dhh.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.dhD = z;
    }

    public void setManageVisible(boolean z) {
        this.dhC = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.dhL = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.mSelectImg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.dhN = z;
    }

    public boolean isInFrsAllThread() {
        return this.dhN;
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
        if (this.dhr != null) {
            this.dhr.destory();
        }
    }

    public void hideDisagree() {
        this.dhf.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.dhM = aVar;
    }
}
