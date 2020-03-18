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
    private int ND;
    private int ddQ;
    protected int dhD;
    protected TextView dhE;
    private TextView dhF;
    protected AgreeView dhG;
    protected TextView dhH;
    protected ImageView dhI;
    protected View dhJ;
    protected TextView dhK;
    protected ImageView dhL;
    protected View dhM;
    protected FrameLayout dhN;
    protected ImageView dhO;
    protected TextView dhP;
    protected ImageView dhQ;
    protected View dhR;
    protected aa dhS;
    protected TextView dhT;
    protected LinearLayout dhU;
    protected boolean dhV;
    protected boolean dhW;
    protected boolean dhX;
    protected boolean dhY;
    protected boolean dhZ;
    protected boolean dia;
    protected boolean dib;
    protected boolean dic;
    protected boolean die;
    protected boolean dif;
    private int dig;
    public int dih;
    public String dii;
    private String dij;
    private View.OnClickListener dik;
    protected int dil;
    protected int dim;
    private b din;
    private a dio;
    private boolean dip;
    CustomMessageListener diq;
    CustomMessageListener dit;
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
        void fU(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.dij = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.dhG != null) {
            this.dhG.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.dig = i;
    }

    public void setGameId(int i) {
        this.ddQ = i;
        if (this.dhG != null) {
            this.dhG.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.diq);
        MessageManager.getInstance().registerListener(this.dit);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.diq);
        MessageManager.getInstance().unRegisterListener(this.dit);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.dhD = 0;
        this.ND = 11;
        this.isVisible = false;
        this.dhV = true;
        this.dhW = true;
        this.dhX = true;
        this.dhY = false;
        this.dhZ = false;
        this.dia = true;
        this.dib = false;
        this.dic = true;
        this.die = false;
        this.dif = true;
        this.mFrom = 2;
        this.dig = 1;
        this.mSkinType = 3;
        this.din = null;
        this.dip = false;
        this.diq = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
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
                                ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCi());
                                ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.KJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCi());
                            ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                        }
                    }
                }
            }
        };
        this.dit = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.KJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.KJ.aDE() || ThreadCommentAndPraiseInfoLayout.this.KJ.aDH()) && ThreadCommentAndPraiseInfoLayout.this.KJ.aCK() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.KJ.aCK() != null && ThreadCommentAndPraiseInfoLayout.this.KJ.aCK().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.KJ.aCK().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.by(ThreadCommentAndPraiseInfoLayout.this.KJ.aDP() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.w(ThreadCommentAndPraiseInfoLayout.this.KJ);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhD = 0;
        this.ND = 11;
        this.isVisible = false;
        this.dhV = true;
        this.dhW = true;
        this.dhX = true;
        this.dhY = false;
        this.dhZ = false;
        this.dia = true;
        this.dib = false;
        this.dic = true;
        this.die = false;
        this.dif = true;
        this.mFrom = 2;
        this.dig = 1;
        this.mSkinType = 3;
        this.din = null;
        this.dip = false;
        this.diq = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
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
                                ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCi());
                                ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.KJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.jJ(bjVar.aCi());
                            ThreadCommentAndPraiseInfoLayout.this.x(bjVar);
                        }
                    }
                }
            }
        };
        this.dit = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.KJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.KJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.KJ.aDE() || ThreadCommentAndPraiseInfoLayout.this.KJ.aDH()) && ThreadCommentAndPraiseInfoLayout.this.KJ.aCK() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.KJ.aCK() != null && ThreadCommentAndPraiseInfoLayout.this.KJ.aCK().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.KJ.aCK().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.KJ.by(ThreadCommentAndPraiseInfoLayout.this.KJ.aDP() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.w(ThreadCommentAndPraiseInfoLayout.this.KJ);
                    }
                }
            }
        };
        init(context);
    }

    protected View dQ(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.dhD = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View dQ = dQ(context);
        this.dhE = (TextView) dQ.findViewById(R.id.thread_info_bar_name);
        this.dhF = (TextView) dQ.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) dQ.findViewById(R.id.thread_comment_layout_root);
        this.dhH = (TextView) dQ.findViewById(R.id.thread_info_commont_num);
        this.dhI = (ImageView) dQ.findViewById(R.id.thread_info_commont_img);
        this.dhJ = dQ.findViewById(R.id.thread_info_commont_container);
        this.dhK = (TextView) dQ.findViewById(R.id.share_num);
        this.dhL = (ImageView) dQ.findViewById(R.id.share_num_img);
        this.dhM = dQ.findViewById(R.id.share_num_container);
        this.dhN = (FrameLayout) dQ.findViewById(R.id.btn_card_bottom_op_more_container);
        this.dhO = (ImageView) dQ.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = dQ.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.dhG = (AgreeView) findViewById;
            this.dhG.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadCommentAndPraiseInfoLayout.this.dik != null) {
                        ThreadCommentAndPraiseInfoLayout.this.dik.onClick(view);
                    }
                }
            });
        }
        this.dhR = dQ.findViewById(R.id.manage_view_container);
        this.dhP = (TextView) dQ.findViewById(R.id.thread_info_manage_text);
        this.dhQ = (ImageView) dQ.findViewById(R.id.thread_info_manage_img);
        this.mSelectImg = (ImageView) dQ.findViewById(R.id.manage_select_img);
        this.dhT = (TextView) dQ.findViewById(R.id.manage_select_text);
        this.dhU = (LinearLayout) dQ.findViewById(R.id.manage_select_container);
        this.dhU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dhT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dhU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dhJ.setOnClickListener(this);
        this.dhM.setOnClickListener(this);
        this.dhR.setOnClickListener(this);
        this.mSelectImg.setOnClickListener(this);
        this.dim = R.drawable.icon_home_card_share;
        this.dil = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    public void setShowFlag(int i) {
        this.ND = i;
        nr();
    }

    private void nr() {
        int i;
        this.dhM.setVisibility(isShow(1) ? 0 : 8);
        this.dhJ.setVisibility(isShow(2) ? 0 : 8);
        View view = this.dhR;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.dhG.setVisibility(isShow(8) ? 0 : 8);
        this.dhG.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.ND & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dhE) {
            aV(view);
        } else if (view == this.dhJ) {
            aS(view);
        } else if (view == this.dhM) {
            aT(view);
        } else if (view == this.dhO) {
            aX(view);
        } else if (view == this.dhR) {
            aW(view);
        } else if (view == this.mSelectImg) {
            aU(view);
        }
    }

    protected void aU(View view) {
        if (this.mSelectImg != null && this.KJ != null && this.dhT != null && !this.KJ.aEa()) {
            if (!this.KJ.aDZ()) {
                if (com.baidu.tieba.frs.a.bDd().ai(this.KJ)) {
                    this.KJ.fD(true);
                }
            } else {
                com.baidu.tieba.frs.a.bDd().aj(this.KJ);
                this.KJ.fD(false);
            }
            am.setViewTextColor(this.dhT, this.KJ.aDZ() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.mSelectImg.setImageDrawable(am.getDrawable(this.KJ.aDZ() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.din != null) {
                this.din.fU(this.KJ.aDZ());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.dhJ != null) {
            this.dhJ.setClickable(z);
            this.dhI.setEnabled(z);
            this.dhH.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.dhM != null) {
            this.dhM.setClickable(z);
            this.dhL.setEnabled(z);
            this.dhK.setEnabled(z);
        }
    }

    private void aV(View view) {
        if (this.KJ != null && !StringUtils.isNull(this.KJ.aCw())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.dij)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.KJ.aCw(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.KJ.aCw(), this.mStType, this.dij)));
            }
            if (this.dik != null) {
                this.dik.onClick(view);
            }
        }
    }

    private boolean t(bj bjVar) {
        return (bjVar == null || !bjVar.aBe() || bjVar.aCI() == null) ? false : true;
    }

    protected void aS(View view) {
        if (this.KJ != null && this.mContext != null) {
            com.baidu.tieba.card.l.zU(this.KJ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.KJ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.KJ.getFid()));
            addLocateParam.setForumName(this.KJ.aCw());
            if (this.KJ.aEc() && this.KJ.aEb() != null) {
                addLocateParam.setForumId(this.KJ.aEb().getForumId());
                addLocateParam.setForumName(this.KJ.aEb().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.dio != null) {
                this.dio.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(this.KJ)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.ak(this.KJ);
            }
            if (this.KJ.cUB) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.KJ.aDv() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.dih);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.X("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.X("obj_locate", this.mFrom);
            anVar2.X("obj_type", getThreadType());
            anVar2.cx("tid", this.KJ.getTid());
            TiebaStatic.log(anVar2);
            aIe();
            if (this.dik != null) {
                this.dik.onClick(view);
            }
        }
    }

    private void aIe() {
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
        if (this.KJ.aBg()) {
            return 1;
        }
        if (this.KJ.aBh()) {
            return 2;
        }
        if (this.KJ.aEk()) {
            return 3;
        }
        return this.KJ.aEl() ? 4 : 0;
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
        if (this.KJ.aCI() != null) {
            return 1;
        }
        if (this.KJ.getType() == bj.cRx || this.KJ.getType() == bj.cRM) {
            if (v.getCount(this.KJ.aCF()) > 0) {
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
        anVar.cx("tid", this.KJ.getTid());
        if (this.KJ.getThreadType() == 40) {
            anVar.cx("obj_param1", "2");
        } else if (this.KJ.getThreadType() == 0) {
            anVar.cx("obj_param1", "1");
        }
        anVar.cx("obj_source", "1");
        anVar.s("fid", this.KJ.getFid());
        anVar.X("obj_locate", this.mFrom);
        anVar.X("obj_id", i);
        if (!aq.isEmpty(this.dii)) {
            anVar.cx("obj_floor", this.dii);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aT(View view) {
        if ((ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) && this.KJ != null) {
            aIf();
            if (!AntiHelper.d(getContext(), this.KJ)) {
                aIh();
                if (this.dik != null) {
                    this.dik.onClick(view);
                }
            }
        }
    }

    private void aIf() {
        if (this.KJ != null) {
            an aIg = aIg();
            aIg.X("thread_type", this.KJ.getThreadType());
            TiebaStatic.log(aIg);
        }
    }

    private an aIg() {
        if (this.KJ == null) {
            return null;
        }
        int i = 0;
        if (this.dig == 1) {
            i = 4;
        } else if (this.dig == 2) {
            i = 5;
        } else if (this.dig == 3) {
            i = 3;
        } else if (this.dig == 4) {
            i = 2;
        } else if (this.dig == 6) {
            i = 8;
        } else if (this.dig == 7) {
            i = 9;
        } else if (this.dig == 9) {
            i = 10;
        } else if (this.dig == 10) {
            i = 17;
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("fid", this.KJ.getFid());
        anVar.cx("tid", this.KJ.getTid());
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.X("obj_locate", i);
        anVar.X(TiebaInitialize.Params.OBJ_PARAM2, this.ddQ);
        if (!aq.isEmpty(this.dii)) {
            anVar.cx("obj_floor", this.dii);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.KJ.aCK() != null && this.KJ.aCK().user_info != null && this.KJ.aCK().user_info.is_official == 2) {
            anVar.X("obj_isofficial", this.KJ.aCK().user_info.is_official);
        }
        anVar.X("card_type", this.KJ.aEp()).cx(TiebaInitialize.Params.AB_TAG, this.KJ.mRecomAbTag).cx("recom_source", this.KJ.mRecomSource).cx(TableDefine.SessionColumns.COLUMN_WEIGHT, this.KJ.mRecomWeight).cx("extra", this.KJ.mRecomExtra);
        if (this.KJ.aBg()) {
            anVar.X("obj_type", 10);
        } else if (this.KJ.aBh()) {
            anVar.X("obj_type", 9);
        } else if (this.KJ.aEl()) {
            anVar.X("obj_type", 8);
        } else if (this.KJ.aEk()) {
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
            anVar.cx("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.KJ.getBaijiahaoData() != null) {
            anVar.cx("obj_param4", this.KJ.getBaijiahaoData().oriUgcNid);
            if (this.KJ.aBh() || this.KJ.aEl()) {
                anVar.cx("obj_param6", this.KJ.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.KJ.aEj()) {
            anVar.X("obj_param5", 2);
        } else if (this.KJ.aBg() || this.KJ.aBh()) {
            anVar.X("obj_param5", 3);
        } else if (this.KJ.threadType == 0 || this.KJ.threadType == 40) {
            anVar.X("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), anVar);
        }
        return anVar;
    }

    private void aIh() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.KJ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.KJ.getFid());
            String aCw = this.KJ.aCw();
            if (this.KJ.cUo != null) {
                valueOf = this.KJ.cUo.id;
                aCw = this.KJ.cUo.ori_fname;
            }
            String title = this.KJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.KJ.getAbstract();
            }
            if (this.KJ.aEm()) {
                tid = this.KJ.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.KJ.getBaijiahaoData().oriUgcType + "&dvid=" + this.KJ.getBaijiahaoData().oriUgcVid + "&nid=" + this.KJ.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.KJ.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.KJ.aCK() != null && this.KJ.aCK().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.KJ.aCK().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.KJ.aCK().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String z2 = z(this.KJ);
            Uri parse = z2 == null ? null : Uri.parse(z2);
            String str4 = this.KJ.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.KJ.aEm() || this.KJ.aCr() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.KJ.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.KJ.aCr().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = aq.cutString(title, 100);
            String cutString2 = aq.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int A = A(this.KJ);
            if (this.KJ.aEm()) {
                shareItem.readCount = -1L;
                shareItem.dqC = cutString2;
            } else {
                if (A == 2 && this.KJ.aCI() != null) {
                    shareItem.readCount = this.KJ.aCI().play_count.intValue();
                } else if (A == 1) {
                    shareItem.readCount = this.KJ.aCj();
                }
                shareItem.dqC = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aCw;
            shareItem.tid = tid;
            shareItem.dqs = true;
            shareItem.cUP = this.dig;
            shareItem.dqE = getShareObjSource();
            shareItem.dqJ = A;
            shareItem.dqF = 3;
            shareItem.dqG = y(this.KJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.KJ.aEm()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.dqT = this.KJ.getShareImageUrl();
            }
            shareItem.dqM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.KJ);
            if (this.mFrom == 13) {
                shareItem.dqN = ShareItem.ForwardInfo.generateForwardInfo(this.KJ, 2);
            } else {
                shareItem.dqN = ShareItem.ForwardInfo.generateForwardInfo(this.KJ);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqF);
            bundle.putInt("obj_type", shareItem.dqJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUP);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z3 = false;
            shareDialogConfig.setIsAlaLive((this.KJ.getThreadType() == 49 || this.KJ.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.e.bws().b(shareDialogConfig);
        }
    }

    private int y(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBg()) {
            return 10;
        }
        if (bjVar.aBh()) {
            return 9;
        }
        if (bjVar.aEl()) {
            return 8;
        }
        if (bjVar.aEk()) {
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
        if (this.dig == 1) {
            return 5;
        }
        if (this.dig != 3) {
            if (this.dig == 4) {
                return 4;
            }
            if (this.dig == 6) {
                return 8;
            }
            if (this.dig != 10) {
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
        if (bjVar.aCK() != null && !TextUtils.isEmpty(bjVar.aCK().cover)) {
            return bjVar.aCK().cover;
        }
        if (bjVar.aCB() == null) {
            return null;
        }
        ArrayList<MediaData> aCB = bjVar.aCB();
        int size = aCB.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aCB.get(i);
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
        if (str == null && bjVar.aCI() != null && !TextUtils.isEmpty(bjVar.aCI().thumbnail_url)) {
            return bjVar.aCI().thumbnail_url;
        }
        return str;
    }

    private int A(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCt()) {
                return 4;
            }
            if (bjVar.aCo() == 1) {
                return 3;
            }
            if (bjVar.aBg()) {
                return 5;
            }
            if (bjVar.aBh()) {
                return 6;
            }
            if (bjVar.aEk()) {
                return 7;
            }
            if (bjVar.aEl()) {
                return 8;
            }
            if (!bjVar.isShareThread || bjVar.cUe == null) {
                return bjVar.aDF() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aW(View view) {
        if (this.dhS == null) {
            this.dhS = new aa(this.mPageContext, isShow(16));
        }
        this.dhS.setData(this.KJ);
        this.dhS.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aX(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.dhX = z;
        if (this.dhE != null) {
            this.dhE.setClickable(this.dhX);
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
        aIi();
        B(bjVar);
        D(bjVar);
        x(bjVar);
        w(bjVar);
        updatePraiseNum(bjVar);
        C(bjVar);
        E(bjVar);
        setVisibility(this.isVisible ? 0 : 8);
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIi() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bj bjVar) {
        this.dhE.setVisibility(8);
    }

    protected void C(bj bjVar) {
        int equipmentWidth;
        if (this.dhU != null && this.mSelectImg != null && this.dhT != null && bjVar != null) {
            if (!this.dip) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dhU.setVisibility(8);
            } else if (this.dif && com.baidu.tieba.frs.a.bDd().bDe()) {
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
                if (bjVar.aEa()) {
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
                am.setViewTextColor(this.dhT, this.KJ.aDZ() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.mSelectImg.setImageDrawable(am.getDrawable(bjVar.aDZ() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.dhU.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dhU.setVisibility(8);
            }
        }
    }

    private void D(bj bjVar) {
        String aBU;
        if (this.dhF != null && bjVar != null) {
            if (bjVar.aCk() <= 0 || !this.dhV) {
                this.dhF.setVisibility(8);
                return;
            }
            this.dhF.setVisibility(0);
            if (this.mFrom == 3) {
                aBU = bjVar.aBV();
            } else {
                aBU = bjVar.aBU();
            }
            this.dhF.setText(aBU);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(bj bjVar) {
        if (this.dhH != null && bjVar != null) {
            if (this.dia) {
                this.dhJ.setVisibility(0);
                if (bjVar.aCi() > 0) {
                    this.dhH.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bjVar.aCi());
                    if (this.dhY) {
                        updateReplyStateUI();
                        this.dhH.setText(numFormatOverWan);
                    } else {
                        this.dhH.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dhH.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.dhY) {
                    updateReplyStateUI();
                    this.dhH.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dhH.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.dhH.setVisibility(8);
                    return;
                }
            }
            this.dhJ.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.dhY) {
            SvgManager.aGG().a(this.dhI, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.dhH, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bj bjVar) {
        setAgreeViewType(bjVar);
        if (bjVar.aEe() != null) {
            bjVar.aEe().isInThread = true;
            this.dhG.setCardType(bjVar.aEp());
            this.dhG.setThreadData(bjVar);
            this.dhG.setData(bjVar.aEe());
        }
    }

    public void setAgreeViewType(bj bjVar) {
        if (bjVar != null && bjVar.aEm()) {
            this.dhG.setAgreeAlone(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(bj bjVar) {
        if (this.dhM != null && this.dhK != null && bjVar != null) {
            if (this.dic) {
                this.dhM.setVisibility(0);
                long aDP = bjVar.aDP();
                if ((bjVar.aDE() || bjVar.aDH()) && bjVar.aCK() != null && bjVar.aCK().share_info != null) {
                    aDP = bjVar.aCK().share_info.share_count;
                }
                this.dhK.setText(aDP > 0 ? aq.numFormatOverWan(aDP) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                updateShareStateUI(bjVar);
                return;
            }
            this.dhM.setVisibility(8);
        }
    }

    public void updateShareStateUI(bj bjVar) {
        if (AntiHelper.aZ(bjVar)) {
            setShareClickable(true);
            SvgManager.aGG().a(this.dhL, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dhK, (int) R.color.cp_cont_e);
        } else if (bjVar != null && bjVar.cUe != null && this.KJ.cUe.cOY) {
            setShareClickable(false);
            SvgManager.aGG().a(this.dhL, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dhK, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aGG().a(this.dhL, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dhK, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void E(bj bjVar) {
        if (this.dhR != null && bjVar != null) {
            this.die = isShow(4);
            if (bjVar.cUo != null) {
                this.die = false;
            }
            if (this.die && (this.dhU == null || this.dhU.getVisibility() == 8)) {
                this.dhR.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.dhP.setText(string);
                this.dhP.setContentDescription(string);
                this.isVisible = true;
                return;
            }
            this.dhR.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.dhG != null) {
            this.dhG.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dhE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dhF, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.dhP, (int) R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.KJ);
            SvgManager.aGG().a(this.dhO, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGG().a(this.dhQ, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.dhS != null) {
                this.dhS.onChangeSkinType();
            }
            if (this.dhG != null) {
                this.dhG.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dik = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.dhE;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.dib = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.dhV = z;
    }

    public View getCommentNumView() {
        return this.dhH;
    }

    public View getCommentContainer() {
        return this.dhJ;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.dhY = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.dhZ = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.dic = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhI.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.dhI.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.dic = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhI.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.dhI.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.dif = z;
    }

    public void setManageVisible(boolean z) {
        this.die = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.din = bVar;
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
        this.dip = z;
    }

    public boolean isInFrsAllThread() {
        return this.dip;
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
        if (this.dhS != null) {
            this.dhS.destory();
        }
    }

    public void hideDisagree() {
        this.dhG.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.dio = aVar;
    }
}
