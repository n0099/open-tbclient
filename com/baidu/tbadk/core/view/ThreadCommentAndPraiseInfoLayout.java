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
    private int ddp;
    protected boolean dhA;
    protected boolean dhB;
    protected boolean dhC;
    protected boolean dhD;
    protected boolean dhE;
    private int dhF;
    public int dhG;
    public String dhH;
    private String dhI;
    private View.OnClickListener dhJ;
    protected int dhK;
    protected int dhL;
    private b dhM;
    private a dhN;
    private boolean dhO;
    CustomMessageListener dhP;
    CustomMessageListener dhQ;
    protected int dhd;
    protected TextView dhe;
    private TextView dhf;
    protected AgreeView dhg;
    protected TextView dhh;
    protected ImageView dhi;
    protected View dhj;
    protected TextView dhk;
    protected ImageView dhl;
    protected View dhm;
    protected FrameLayout dhn;
    protected ImageView dho;
    protected TextView dhp;
    protected ImageView dhq;
    protected View dhr;
    protected aa dhs;
    protected TextView dht;
    protected LinearLayout dhu;
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
        this.dhI = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.dhg != null) {
            this.dhg.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.dhF = i;
    }

    public void setGameId(int i) {
        this.ddp = i;
        if (this.dhg != null) {
            this.dhg.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dhP);
        MessageManager.getInstance().registerListener(this.dhQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dhP);
        MessageManager.getInstance().unRegisterListener(this.dhQ);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.dhd = 0;
        this.NC = 11;
        this.isVisible = false;
        this.dhv = true;
        this.dhw = true;
        this.dhx = true;
        this.dhy = false;
        this.dhz = false;
        this.dhA = true;
        this.dhB = false;
        this.dhC = true;
        this.dhD = false;
        this.dhE = true;
        this.mFrom = 2;
        this.dhF = 1;
        this.mSkinType = 3;
        this.dhM = null;
        this.dhO = false;
        this.dhP = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
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
                                ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCf());
                                ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.KJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCf());
                            ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                        }
                    }
                }
            }
        };
        this.dhQ = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.KJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.KJ.aDA() || ThreadCommentAndPraiseInfoLayout.this.KJ.aDD()) && ThreadCommentAndPraiseInfoLayout.this.KJ.aCH() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.KJ.aCH() != null && ThreadCommentAndPraiseInfoLayout.this.KJ.aCH().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.KJ.aCH().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.by(ThreadCommentAndPraiseInfoLayout.this.KJ.aDL() + 1);
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
        this.dhd = 0;
        this.NC = 11;
        this.isVisible = false;
        this.dhv = true;
        this.dhw = true;
        this.dhx = true;
        this.dhy = false;
        this.dhz = false;
        this.dhA = true;
        this.dhB = false;
        this.dhC = true;
        this.dhD = false;
        this.dhE = true;
        this.mFrom = 2;
        this.dhF = 1;
        this.mSkinType = 3;
        this.dhM = null;
        this.dhO = false;
        this.dhP = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
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
                                ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCf());
                                ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.KJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCf());
                            ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                        }
                    }
                }
            }
        };
        this.dhQ = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.KJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.KJ.aDA() || ThreadCommentAndPraiseInfoLayout.this.KJ.aDD()) && ThreadCommentAndPraiseInfoLayout.this.KJ.aCH() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.KJ.aCH() != null && ThreadCommentAndPraiseInfoLayout.this.KJ.aCH().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.KJ.aCH().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.by(ThreadCommentAndPraiseInfoLayout.this.KJ.aDL() + 1);
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
        this.dhd = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View dR = dR(context);
        this.dhe = (TextView) dR.findViewById(R.id.thread_info_bar_name);
        this.dhf = (TextView) dR.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) dR.findViewById(R.id.thread_comment_layout_root);
        this.dhh = (TextView) dR.findViewById(R.id.thread_info_commont_num);
        this.dhi = (ImageView) dR.findViewById(R.id.thread_info_commont_img);
        this.dhj = dR.findViewById(R.id.thread_info_commont_container);
        this.dhk = (TextView) dR.findViewById(R.id.share_num);
        this.dhl = (ImageView) dR.findViewById(R.id.share_num_img);
        this.dhm = dR.findViewById(R.id.share_num_container);
        this.dhn = (FrameLayout) dR.findViewById(R.id.btn_card_bottom_op_more_container);
        this.dho = (ImageView) dR.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = dR.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.dhg = (AgreeView) findViewById;
            this.dhg.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadCommentAndPraiseInfoLayout.this.dhJ != null) {
                        ThreadCommentAndPraiseInfoLayout.this.dhJ.onClick(view);
                    }
                }
            });
        }
        this.dhr = dR.findViewById(R.id.manage_view_container);
        this.dhp = (TextView) dR.findViewById(R.id.thread_info_manage_text);
        this.dhq = (ImageView) dR.findViewById(R.id.thread_info_manage_img);
        this.mSelectImg = (ImageView) dR.findViewById(R.id.manage_select_img);
        this.dht = (TextView) dR.findViewById(R.id.manage_select_text);
        this.dhu = (LinearLayout) dR.findViewById(R.id.manage_select_container);
        this.dhu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dht.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dhu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dhj.setOnClickListener(this);
        this.dhm.setOnClickListener(this);
        this.dhr.setOnClickListener(this);
        this.mSelectImg.setOnClickListener(this);
        this.dhL = R.drawable.icon_home_card_share;
        this.dhK = R.drawable.icon_home_card_comment;
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
        this.dhm.setVisibility(isShow(1) ? 0 : 8);
        this.dhj.setVisibility(isShow(2) ? 0 : 8);
        View view = this.dhr;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.dhg.setVisibility(isShow(8) ? 0 : 8);
        this.dhg.setAgreeAlone(isShow(32));
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
        if (view == this.dhe) {
            aV(view);
        } else if (view == this.dhj) {
            aS(view);
        } else if (view == this.dhm) {
            aT(view);
        } else if (view == this.dho) {
            aX(view);
        } else if (view == this.dhr) {
            aW(view);
        } else if (view == this.mSelectImg) {
            aU(view);
        }
    }

    protected void aU(View view) {
        if (this.mSelectImg != null && this.KJ != null && this.dht != null && !this.KJ.aDW()) {
            if (!this.KJ.aDV()) {
                if (com.baidu.tieba.frs.a.bCV().ah(this.KJ)) {
                    this.KJ.fC(true);
                }
            } else {
                com.baidu.tieba.frs.a.bCV().ai(this.KJ);
                this.KJ.fC(false);
            }
            am.setViewTextColor(this.dht, this.KJ.aDV() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.mSelectImg.setImageDrawable(am.getDrawable(this.KJ.aDV() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.dhM != null) {
                this.dhM.fT(this.KJ.aDV());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.dhj != null) {
            this.dhj.setClickable(z);
            this.dhi.setEnabled(z);
            this.dhh.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.dhm != null) {
            this.dhm.setClickable(z);
            this.dhl.setEnabled(z);
            this.dhk.setEnabled(z);
        }
    }

    private void aV(View view) {
        if (this.KJ != null && !StringUtils.isNull(this.KJ.aCt())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.dhI)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.KJ.aCt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.KJ.aCt(), this.mStType, this.dhI)));
            }
            if (this.dhJ != null) {
                this.dhJ.onClick(view);
            }
        }
    }

    private boolean t(bj bjVar) {
        return (bjVar == null || !bjVar.aBb() || bjVar.aCF() == null) ? false : true;
    }

    protected void aS(View view) {
        if (this.KJ != null && this.mContext != null) {
            com.baidu.tieba.card.l.zS(this.KJ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.KJ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.KJ.getFid()));
            addLocateParam.setForumName(this.KJ.aCt());
            if (this.KJ.aDY() && this.KJ.aDX() != null) {
                addLocateParam.setForumId(this.KJ.aDX().getForumId());
                addLocateParam.setForumName(this.KJ.aDX().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.dhN != null) {
                this.dhN.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(this.KJ)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.aj(this.KJ);
            }
            if (this.KJ.cUn) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.KJ.aDr() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.dhG);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.X("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.X("obj_locate", this.mFrom);
            anVar2.X("obj_type", getThreadType());
            anVar2.cy("tid", this.KJ.getTid());
            TiebaStatic.log(anVar2);
            aHZ();
            if (this.dhJ != null) {
                this.dhJ.onClick(view);
            }
        }
    }

    private void aHZ() {
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
        if (this.KJ.aBd()) {
            return 1;
        }
        if (this.KJ.aBe()) {
            return 2;
        }
        if (this.KJ.aEg()) {
            return 3;
        }
        return this.KJ.aEh() ? 4 : 0;
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
        if (this.KJ.aCF() != null) {
            return 1;
        }
        if (this.KJ.getType() == bj.cRj || this.KJ.getType() == bj.cRy) {
            if (v.getCount(this.KJ.aCC()) > 0) {
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
        if (!aq.isEmpty(this.dhH)) {
            anVar.cy("obj_floor", this.dhH);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aT(View view) {
        if ((ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) && this.KJ != null) {
            aIa();
            if (!AntiHelper.d(getContext(), this.KJ)) {
                aIc();
                if (this.dhJ != null) {
                    this.dhJ.onClick(view);
                }
            }
        }
    }

    private void aIa() {
        if (this.KJ != null) {
            an aIb = aIb();
            aIb.X("thread_type", this.KJ.getThreadType());
            TiebaStatic.log(aIb);
        }
    }

    private an aIb() {
        if (this.KJ == null) {
            return null;
        }
        int i = 0;
        if (this.dhF == 1) {
            i = 4;
        } else if (this.dhF == 2) {
            i = 5;
        } else if (this.dhF == 3) {
            i = 3;
        } else if (this.dhF == 4) {
            i = 2;
        } else if (this.dhF == 6) {
            i = 8;
        } else if (this.dhF == 7) {
            i = 9;
        } else if (this.dhF == 9) {
            i = 10;
        } else if (this.dhF == 10) {
            i = 17;
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("fid", this.KJ.getFid());
        anVar.cy("tid", this.KJ.getTid());
        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.X("obj_locate", i);
        anVar.X(TiebaInitialize.Params.OBJ_PARAM2, this.ddp);
        if (!aq.isEmpty(this.dhH)) {
            anVar.cy("obj_floor", this.dhH);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.KJ.aCH() != null && this.KJ.aCH().user_info != null && this.KJ.aCH().user_info.is_official == 2) {
            anVar.X("obj_isofficial", this.KJ.aCH().user_info.is_official);
        }
        anVar.X("card_type", this.KJ.aEl()).cy(TiebaInitialize.Params.AB_TAG, this.KJ.mRecomAbTag).cy("recom_source", this.KJ.mRecomSource).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, this.KJ.mRecomWeight).cy("extra", this.KJ.mRecomExtra);
        if (this.KJ.aBd()) {
            anVar.X("obj_type", 10);
        } else if (this.KJ.aBe()) {
            anVar.X("obj_type", 9);
        } else if (this.KJ.aEh()) {
            anVar.X("obj_type", 8);
        } else if (this.KJ.aEg()) {
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
            if (this.KJ.aBe() || this.KJ.aEh()) {
                anVar.cy("obj_param6", this.KJ.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.KJ.aEf()) {
            anVar.X("obj_param5", 2);
        } else if (this.KJ.aBd() || this.KJ.aBe()) {
            anVar.X("obj_param5", 3);
        } else if (this.KJ.threadType == 0 || this.KJ.threadType == 40) {
            anVar.X("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), anVar);
        }
        return anVar;
    }

    private void aIc() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.KJ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.KJ.getFid());
            String aCt = this.KJ.aCt();
            if (this.KJ.cUa != null) {
                valueOf = this.KJ.cUa.id;
                aCt = this.KJ.cUa.ori_fname;
            }
            String title = this.KJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.KJ.getAbstract();
            }
            if (this.KJ.aEi()) {
                tid = this.KJ.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.KJ.getBaijiahaoData().oriUgcType + "&dvid=" + this.KJ.getBaijiahaoData().oriUgcVid + "&nid=" + this.KJ.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.KJ.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.KJ.aCH() != null && this.KJ.aCH().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.KJ.aCH().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.KJ.aCH().user_info.user_name, "utf-8");
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
            if (!this.KJ.aEi() || this.KJ.aCo() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.KJ.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.KJ.aCo().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = aq.cutString(title, 100);
            String cutString2 = aq.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int z2 = z(this.KJ);
            if (this.KJ.aEi()) {
                shareItem.readCount = -1L;
                shareItem.dqc = cutString2;
            } else {
                if (z2 == 2 && this.KJ.aCF() != null) {
                    shareItem.readCount = this.KJ.aCF().play_count.intValue();
                } else if (z2 == 1) {
                    shareItem.readCount = this.KJ.aCg();
                }
                shareItem.dqc = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aCt;
            shareItem.tid = tid;
            shareItem.dpS = true;
            shareItem.cUB = this.dhF;
            shareItem.dqe = getShareObjSource();
            shareItem.dqj = z2;
            shareItem.dqf = 3;
            shareItem.dqg = x(this.KJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.KJ.aEi()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.dqt = this.KJ.getShareImageUrl();
            }
            shareItem.dqm = OriginalThreadInfo.ShareInfo.generateShareInfo(this.KJ);
            if (this.mFrom == 13) {
                shareItem.dqn = ShareItem.ForwardInfo.generateForwardInfo(this.KJ, 2);
            } else {
                shareItem.dqn = ShareItem.ForwardInfo.generateForwardInfo(this.KJ);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqf);
            bundle.putInt("obj_type", shareItem.dqj);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUB);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z3 = false;
            shareDialogConfig.setIsAlaLive((this.KJ.getThreadType() == 49 || this.KJ.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.e.bwm().b(shareDialogConfig);
        }
    }

    private int x(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBd()) {
            return 10;
        }
        if (bjVar.aBe()) {
            return 9;
        }
        if (bjVar.aEh()) {
            return 8;
        }
        if (bjVar.aEg()) {
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
        if (this.dhF == 1) {
            return 5;
        }
        if (this.dhF != 3) {
            if (this.dhF == 4) {
                return 4;
            }
            if (this.dhF == 6) {
                return 8;
            }
            if (this.dhF != 10) {
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
        if (bjVar.aCH() != null && !TextUtils.isEmpty(bjVar.aCH().cover)) {
            return bjVar.aCH().cover;
        }
        if (bjVar.aCy() == null) {
            return null;
        }
        ArrayList<MediaData> aCy = bjVar.aCy();
        int size = aCy.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aCy.get(i);
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
        if (str == null && bjVar.aCF() != null && !TextUtils.isEmpty(bjVar.aCF().thumbnail_url)) {
            return bjVar.aCF().thumbnail_url;
        }
        return str;
    }

    private int z(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCq()) {
                return 4;
            }
            if (bjVar.aCl() == 1) {
                return 3;
            }
            if (bjVar.aBd()) {
                return 5;
            }
            if (bjVar.aBe()) {
                return 6;
            }
            if (bjVar.aEg()) {
                return 7;
            }
            if (bjVar.aEh()) {
                return 8;
            }
            if (!bjVar.isShareThread || bjVar.cTQ == null) {
                return bjVar.aDB() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aW(View view) {
        if (this.dhs == null) {
            this.dhs = new aa(this.mPageContext, isShow(16));
        }
        this.dhs.setData(this.KJ);
        this.dhs.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aX(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.dhx = z;
        if (this.dhe != null) {
            this.dhe.setClickable(this.dhx);
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
        aId();
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
    public void aId() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bj bjVar) {
        this.dhe.setVisibility(8);
    }

    protected void B(bj bjVar) {
        int equipmentWidth;
        if (this.dhu != null && this.mSelectImg != null && this.dht != null && bjVar != null) {
            if (!this.dhO) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dhu.setVisibility(8);
            } else if (this.dhE && com.baidu.tieba.frs.a.bCV().bCW()) {
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
                if (bjVar.aDW()) {
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
                am.setViewTextColor(this.dht, this.KJ.aDV() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.mSelectImg.setImageDrawable(am.getDrawable(bjVar.aDV() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.dhu.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dhu.setVisibility(8);
            }
        }
    }

    private void C(bj bjVar) {
        String aBR;
        if (this.dhf != null && bjVar != null) {
            if (bjVar.aCh() <= 0 || !this.dhv) {
                this.dhf.setVisibility(8);
                return;
            }
            this.dhf.setVisibility(0);
            if (this.mFrom == 3) {
                aBR = bjVar.aBS();
            } else {
                aBR = bjVar.aBR();
            }
            this.dhf.setText(aBR);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(bj bjVar) {
        if (this.dhh != null && bjVar != null) {
            if (this.dhA) {
                this.dhj.setVisibility(0);
                if (bjVar.aCf() > 0) {
                    this.dhh.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bjVar.aCf());
                    if (this.dhy) {
                        updateReplyStateUI();
                        this.dhh.setText(numFormatOverWan);
                    } else {
                        this.dhh.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dhh.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.dhy) {
                    updateReplyStateUI();
                    this.dhh.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dhh.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.dhh.setVisibility(8);
                    return;
                }
            }
            this.dhj.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.dhy) {
            SvgManager.aGC().a(this.dhi, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.dhh, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bj bjVar) {
        setAgreeViewType(bjVar);
        if (bjVar.aEa() != null) {
            bjVar.aEa().isInThread = true;
            this.dhg.setCardType(bjVar.aEl());
            this.dhg.setThreadData(bjVar);
            this.dhg.setData(bjVar.aEa());
        }
    }

    public void setAgreeViewType(bj bjVar) {
        if (bjVar != null && bjVar.aEi()) {
            this.dhg.setAgreeAlone(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(bj bjVar) {
        if (this.dhm != null && this.dhk != null && bjVar != null) {
            if (this.dhC) {
                this.dhm.setVisibility(0);
                long aDL = bjVar.aDL();
                if ((bjVar.aDA() || bjVar.aDD()) && bjVar.aCH() != null && bjVar.aCH().share_info != null) {
                    aDL = bjVar.aCH().share_info.share_count;
                }
                this.dhk.setText(aDL > 0 ? aq.numFormatOverWan(aDL) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                updateShareStateUI(bjVar);
                return;
            }
            this.dhm.setVisibility(8);
        }
    }

    public void updateShareStateUI(bj bjVar) {
        if (AntiHelper.aY(bjVar)) {
            setShareClickable(true);
            SvgManager.aGC().a(this.dhl, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dhk, (int) R.color.cp_cont_e);
        } else if (bjVar != null && bjVar.cTQ != null && this.KJ.cTQ.cOK) {
            setShareClickable(false);
            SvgManager.aGC().a(this.dhl, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dhk, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aGC().a(this.dhl, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dhk, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void D(bj bjVar) {
        if (this.dhr != null && bjVar != null) {
            this.dhD = isShow(4);
            if (bjVar.cUa != null) {
                this.dhD = false;
            }
            if (this.dhD && (this.dhu == null || this.dhu.getVisibility() == 8)) {
                this.dhr.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.dhp.setText(string);
                this.dhp.setContentDescription(string);
                this.isVisible = true;
                return;
            }
            this.dhr.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.dhg != null) {
            this.dhg.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dhe, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dhf, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.dhp, (int) R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.KJ);
            SvgManager.aGC().a(this.dho, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGC().a(this.dhq, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.dhs != null) {
                this.dhs.onChangeSkinType();
            }
            if (this.dhg != null) {
                this.dhg.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dhJ = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.dhe;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.dhB = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.dhv = z;
    }

    public View getCommentNumView() {
        return this.dhh;
    }

    public View getCommentContainer() {
        return this.dhj;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.dhy = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.dhz = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.dhC = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhi.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.dhi.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.dhC = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhi.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.dhi.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.dhE = z;
    }

    public void setManageVisible(boolean z) {
        this.dhD = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.dhM = bVar;
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
        this.dhO = z;
    }

    public boolean isInFrsAllThread() {
        return this.dhO;
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
        if (this.dhs != null) {
            this.dhs.destory();
        }
    }

    public void hideDisagree() {
        this.dhg.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.dhN = aVar;
    }
}
