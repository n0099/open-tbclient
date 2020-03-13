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
    private int ddD;
    protected FrameLayout dhA;
    protected ImageView dhB;
    protected TextView dhC;
    protected ImageView dhD;
    protected View dhE;
    protected aa dhF;
    protected TextView dhG;
    protected LinearLayout dhH;
    protected boolean dhI;
    protected boolean dhJ;
    protected boolean dhK;
    protected boolean dhL;
    protected boolean dhM;
    protected boolean dhN;
    protected boolean dhO;
    protected boolean dhP;
    protected boolean dhQ;
    protected boolean dhR;
    private int dhS;
    public int dhT;
    public String dhU;
    private String dhV;
    private View.OnClickListener dhW;
    protected int dhX;
    protected int dhY;
    private b dhZ;
    protected int dhq;
    protected TextView dhr;
    private TextView dhs;
    protected AgreeView dht;
    protected TextView dhu;
    protected ImageView dhv;
    protected View dhw;
    protected TextView dhx;
    protected ImageView dhy;
    protected View dhz;
    private a dia;
    private boolean dib;
    CustomMessageListener dic;
    CustomMessageListener die;
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
        this.dhV = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.dht != null) {
            this.dht.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.dhS = i;
    }

    public void setGameId(int i) {
        this.ddD = i;
        if (this.dht != null) {
            this.dht.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dic);
        MessageManager.getInstance().registerListener(this.die);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dic);
        MessageManager.getInstance().unRegisterListener(this.die);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.dhq = 0;
        this.NC = 11;
        this.isVisible = false;
        this.dhI = true;
        this.dhJ = true;
        this.dhK = true;
        this.dhL = false;
        this.dhM = false;
        this.dhN = true;
        this.dhO = false;
        this.dhP = true;
        this.dhQ = false;
        this.dhR = true;
        this.mFrom = 2;
        this.dhS = 1;
        this.mSkinType = 3;
        this.dhZ = null;
        this.dib = false;
        this.dic = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
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
        this.die = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
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
        this.dhq = 0;
        this.NC = 11;
        this.isVisible = false;
        this.dhI = true;
        this.dhJ = true;
        this.dhK = true;
        this.dhL = false;
        this.dhM = false;
        this.dhN = true;
        this.dhO = false;
        this.dhP = true;
        this.dhQ = false;
        this.dhR = true;
        this.mFrom = 2;
        this.dhS = 1;
        this.mSkinType = 3;
        this.dhZ = null;
        this.dib = false;
        this.dic = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
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
        this.die = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
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
        this.dhq = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View dR = dR(context);
        this.dhr = (TextView) dR.findViewById(R.id.thread_info_bar_name);
        this.dhs = (TextView) dR.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) dR.findViewById(R.id.thread_comment_layout_root);
        this.dhu = (TextView) dR.findViewById(R.id.thread_info_commont_num);
        this.dhv = (ImageView) dR.findViewById(R.id.thread_info_commont_img);
        this.dhw = dR.findViewById(R.id.thread_info_commont_container);
        this.dhx = (TextView) dR.findViewById(R.id.share_num);
        this.dhy = (ImageView) dR.findViewById(R.id.share_num_img);
        this.dhz = dR.findViewById(R.id.share_num_container);
        this.dhA = (FrameLayout) dR.findViewById(R.id.btn_card_bottom_op_more_container);
        this.dhB = (ImageView) dR.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = dR.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.dht = (AgreeView) findViewById;
            this.dht.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadCommentAndPraiseInfoLayout.this.dhW != null) {
                        ThreadCommentAndPraiseInfoLayout.this.dhW.onClick(view);
                    }
                }
            });
        }
        this.dhE = dR.findViewById(R.id.manage_view_container);
        this.dhC = (TextView) dR.findViewById(R.id.thread_info_manage_text);
        this.dhD = (ImageView) dR.findViewById(R.id.thread_info_manage_img);
        this.mSelectImg = (ImageView) dR.findViewById(R.id.manage_select_img);
        this.dhG = (TextView) dR.findViewById(R.id.manage_select_text);
        this.dhH = (LinearLayout) dR.findViewById(R.id.manage_select_container);
        this.dhH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dhG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dhH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dhw.setOnClickListener(this);
        this.dhz.setOnClickListener(this);
        this.dhE.setOnClickListener(this);
        this.mSelectImg.setOnClickListener(this);
        this.dhY = R.drawable.icon_home_card_share;
        this.dhX = R.drawable.icon_home_card_comment;
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
        this.dhz.setVisibility(isShow(1) ? 0 : 8);
        this.dhw.setVisibility(isShow(2) ? 0 : 8);
        View view = this.dhE;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.dht.setVisibility(isShow(8) ? 0 : 8);
        this.dht.setAgreeAlone(isShow(32));
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
        if (view == this.dhr) {
            aV(view);
        } else if (view == this.dhw) {
            aS(view);
        } else if (view == this.dhz) {
            aT(view);
        } else if (view == this.dhB) {
            aX(view);
        } else if (view == this.dhE) {
            aW(view);
        } else if (view == this.mSelectImg) {
            aU(view);
        }
    }

    protected void aU(View view) {
        if (this.mSelectImg != null && this.KJ != null && this.dhG != null && !this.KJ.aDW()) {
            if (!this.KJ.aDV()) {
                if (com.baidu.tieba.frs.a.bCW().ah(this.KJ)) {
                    this.KJ.fC(true);
                }
            } else {
                com.baidu.tieba.frs.a.bCW().ai(this.KJ);
                this.KJ.fC(false);
            }
            am.setViewTextColor(this.dhG, this.KJ.aDV() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.mSelectImg.setImageDrawable(am.getDrawable(this.KJ.aDV() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.dhZ != null) {
                this.dhZ.fT(this.KJ.aDV());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.dhw != null) {
            this.dhw.setClickable(z);
            this.dhv.setEnabled(z);
            this.dhu.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.dhz != null) {
            this.dhz.setClickable(z);
            this.dhy.setEnabled(z);
            this.dhx.setEnabled(z);
        }
    }

    private void aV(View view) {
        if (this.KJ != null && !StringUtils.isNull(this.KJ.aCt())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.dhV)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.KJ.aCt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.KJ.aCt(), this.mStType, this.dhV)));
            }
            if (this.dhW != null) {
                this.dhW.onClick(view);
            }
        }
    }

    private boolean t(bj bjVar) {
        return (bjVar == null || !bjVar.aBb() || bjVar.aCF() == null) ? false : true;
    }

    protected void aS(View view) {
        if (this.KJ != null && this.mContext != null) {
            com.baidu.tieba.card.l.zT(this.KJ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.KJ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.KJ.getFid()));
            addLocateParam.setForumName(this.KJ.aCt());
            if (this.KJ.aDY() && this.KJ.aDX() != null) {
                addLocateParam.setForumId(this.KJ.aDX().getForumId());
                addLocateParam.setForumName(this.KJ.aDX().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.dia != null) {
                this.dia.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(this.KJ)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.aj(this.KJ);
            }
            if (this.KJ.cUo) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.KJ.aDr() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.dhT);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.X("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.X("obj_locate", this.mFrom);
            anVar2.X("obj_type", getThreadType());
            anVar2.cy("tid", this.KJ.getTid());
            TiebaStatic.log(anVar2);
            aIa();
            if (this.dhW != null) {
                this.dhW.onClick(view);
            }
        }
    }

    private void aIa() {
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
        if (this.KJ.getType() == bj.cRk || this.KJ.getType() == bj.cRz) {
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
        if (!aq.isEmpty(this.dhU)) {
            anVar.cy("obj_floor", this.dhU);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aT(View view) {
        if ((ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) && this.KJ != null) {
            aIb();
            if (!AntiHelper.d(getContext(), this.KJ)) {
                aId();
                if (this.dhW != null) {
                    this.dhW.onClick(view);
                }
            }
        }
    }

    private void aIb() {
        if (this.KJ != null) {
            an aIc = aIc();
            aIc.X("thread_type", this.KJ.getThreadType());
            TiebaStatic.log(aIc);
        }
    }

    private an aIc() {
        if (this.KJ == null) {
            return null;
        }
        int i = 0;
        if (this.dhS == 1) {
            i = 4;
        } else if (this.dhS == 2) {
            i = 5;
        } else if (this.dhS == 3) {
            i = 3;
        } else if (this.dhS == 4) {
            i = 2;
        } else if (this.dhS == 6) {
            i = 8;
        } else if (this.dhS == 7) {
            i = 9;
        } else if (this.dhS == 9) {
            i = 10;
        } else if (this.dhS == 10) {
            i = 17;
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("fid", this.KJ.getFid());
        anVar.cy("tid", this.KJ.getTid());
        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.X("obj_locate", i);
        anVar.X(TiebaInitialize.Params.OBJ_PARAM2, this.ddD);
        if (!aq.isEmpty(this.dhU)) {
            anVar.cy("obj_floor", this.dhU);
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

    private void aId() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.KJ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.KJ.getFid());
            String aCt = this.KJ.aCt();
            if (this.KJ.cUb != null) {
                valueOf = this.KJ.cUb.id;
                aCt = this.KJ.cUb.ori_fname;
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
                shareItem.dqp = cutString2;
            } else {
                if (z2 == 2 && this.KJ.aCF() != null) {
                    shareItem.readCount = this.KJ.aCF().play_count.intValue();
                } else if (z2 == 1) {
                    shareItem.readCount = this.KJ.aCg();
                }
                shareItem.dqp = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aCt;
            shareItem.tid = tid;
            shareItem.dqf = true;
            shareItem.cUC = this.dhS;
            shareItem.dqr = getShareObjSource();
            shareItem.dqw = z2;
            shareItem.dqs = 3;
            shareItem.dqt = x(this.KJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.KJ.aEi()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.dqG = this.KJ.getShareImageUrl();
            }
            shareItem.dqz = OriginalThreadInfo.ShareInfo.generateShareInfo(this.KJ);
            if (this.mFrom == 13) {
                shareItem.dqA = ShareItem.ForwardInfo.generateForwardInfo(this.KJ, 2);
            } else {
                shareItem.dqA = ShareItem.ForwardInfo.generateForwardInfo(this.KJ);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqs);
            bundle.putInt("obj_type", shareItem.dqw);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUC);
            shareItem.Y(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z3 = false;
            shareDialogConfig.setIsAlaLive((this.KJ.getThreadType() == 49 || this.KJ.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.e.bwn().b(shareDialogConfig);
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
        if (this.dhS == 1) {
            return 5;
        }
        if (this.dhS != 3) {
            if (this.dhS == 4) {
                return 4;
            }
            if (this.dhS == 6) {
                return 8;
            }
            if (this.dhS != 10) {
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
            if (!bjVar.isShareThread || bjVar.cTR == null) {
                return bjVar.aDB() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aW(View view) {
        if (this.dhF == null) {
            this.dhF = new aa(this.mPageContext, isShow(16));
        }
        this.dhF.setData(this.KJ);
        this.dhF.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aX(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.dhK = z;
        if (this.dhr != null) {
            this.dhr.setClickable(this.dhK);
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
        aIe();
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
    public void aIe() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bj bjVar) {
        this.dhr.setVisibility(8);
    }

    protected void B(bj bjVar) {
        int equipmentWidth;
        if (this.dhH != null && this.mSelectImg != null && this.dhG != null && bjVar != null) {
            if (!this.dib) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dhH.setVisibility(8);
            } else if (this.dhR && com.baidu.tieba.frs.a.bCW().bCX()) {
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
                am.setViewTextColor(this.dhG, this.KJ.aDV() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.mSelectImg.setImageDrawable(am.getDrawable(bjVar.aDV() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.dhH.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dhH.setVisibility(8);
            }
        }
    }

    private void C(bj bjVar) {
        String aBR;
        if (this.dhs != null && bjVar != null) {
            if (bjVar.aCh() <= 0 || !this.dhI) {
                this.dhs.setVisibility(8);
                return;
            }
            this.dhs.setVisibility(0);
            if (this.mFrom == 3) {
                aBR = bjVar.aBS();
            } else {
                aBR = bjVar.aBR();
            }
            this.dhs.setText(aBR);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(bj bjVar) {
        if (this.dhu != null && bjVar != null) {
            if (this.dhN) {
                this.dhw.setVisibility(0);
                if (bjVar.aCf() > 0) {
                    this.dhu.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bjVar.aCf());
                    if (this.dhL) {
                        updateReplyStateUI();
                        this.dhu.setText(numFormatOverWan);
                    } else {
                        this.dhu.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dhu.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.dhL) {
                    updateReplyStateUI();
                    this.dhu.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dhu.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.dhu.setVisibility(8);
                    return;
                }
            }
            this.dhw.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.dhL) {
            SvgManager.aGC().a(this.dhv, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.dhu, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bj bjVar) {
        setAgreeViewType(bjVar);
        if (bjVar.aEa() != null) {
            bjVar.aEa().isInThread = true;
            this.dht.setCardType(bjVar.aEl());
            this.dht.setThreadData(bjVar);
            this.dht.setData(bjVar.aEa());
        }
    }

    public void setAgreeViewType(bj bjVar) {
        if (bjVar != null && bjVar.aEi()) {
            this.dht.setAgreeAlone(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(bj bjVar) {
        if (this.dhz != null && this.dhx != null && bjVar != null) {
            if (this.dhP) {
                this.dhz.setVisibility(0);
                long aDL = bjVar.aDL();
                if ((bjVar.aDA() || bjVar.aDD()) && bjVar.aCH() != null && bjVar.aCH().share_info != null) {
                    aDL = bjVar.aCH().share_info.share_count;
                }
                this.dhx.setText(aDL > 0 ? aq.numFormatOverWan(aDL) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                updateShareStateUI(bjVar);
                return;
            }
            this.dhz.setVisibility(8);
        }
    }

    public void updateShareStateUI(bj bjVar) {
        if (AntiHelper.aY(bjVar)) {
            setShareClickable(true);
            SvgManager.aGC().a(this.dhy, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dhx, (int) R.color.cp_cont_e);
        } else if (bjVar != null && bjVar.cTR != null && this.KJ.cTR.cOL) {
            setShareClickable(false);
            SvgManager.aGC().a(this.dhy, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dhx, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aGC().a(this.dhy, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dhx, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void D(bj bjVar) {
        if (this.dhE != null && bjVar != null) {
            this.dhQ = isShow(4);
            if (bjVar.cUb != null) {
                this.dhQ = false;
            }
            if (this.dhQ && (this.dhH == null || this.dhH.getVisibility() == 8)) {
                this.dhE.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.dhC.setText(string);
                this.dhC.setContentDescription(string);
                this.isVisible = true;
                return;
            }
            this.dhE.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.dht != null) {
            this.dht.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dhr, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dhs, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.dhC, (int) R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.KJ);
            SvgManager.aGC().a(this.dhB, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aGC().a(this.dhD, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.dhF != null) {
                this.dhF.onChangeSkinType();
            }
            if (this.dht != null) {
                this.dht.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dhW = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.dhr;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.dhO = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.dhI = z;
    }

    public View getCommentNumView() {
        return this.dhu;
    }

    public View getCommentContainer() {
        return this.dhw;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.dhL = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.dhM = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.dhP = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhv.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.dhv.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.dhP = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dhv.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.dhv.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.dhR = z;
    }

    public void setManageVisible(boolean z) {
        this.dhQ = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.dhZ = bVar;
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
        this.dib = z;
    }

    public boolean isInFrsAllThread() {
        return this.dib;
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
        if (this.dhF != null) {
            this.dhF.destory();
        }
    }

    public void hideDisagree() {
        this.dht.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.dia = aVar;
    }
}
