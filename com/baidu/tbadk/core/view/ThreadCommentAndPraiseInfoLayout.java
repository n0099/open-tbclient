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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
/* loaded from: classes20.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bw agf;
    protected TextView aiw;
    private int ajs;
    protected ImageView cBL;
    protected TextView dVT;
    private int eqz;
    protected int evC;
    private TextView evD;
    protected AgreeView evE;
    protected ImageView evF;
    protected View evG;
    protected TextView evH;
    protected ImageView evI;
    protected View evJ;
    protected FrameLayout evK;
    protected ImageView evL;
    protected TextView evM;
    protected ImageView evN;
    protected View evO;
    protected ab evP;
    protected TextView evQ;
    protected LinearLayout evR;
    protected boolean evS;
    protected boolean evT;
    protected boolean evU;
    protected boolean evV;
    protected boolean evW;
    protected boolean evX;
    protected boolean evY;
    protected boolean evZ;
    protected boolean ewa;
    protected boolean ewb;
    protected boolean ewc;
    private int ewd;
    public int ewe;
    public String ewf;
    private String ewg;
    private View.OnClickListener ewh;
    protected int ewi;
    protected int ewj;
    private b ewk;
    private a ewl;
    private boolean ewm;
    CustomMessageListener ewn;
    CustomMessageListener ewo;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;

    /* loaded from: classes20.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void iy(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.ewg = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.evE != null) {
            this.evE.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.ewd = i;
    }

    public void setGameId(int i) {
        this.eqz = i;
        if (this.evE != null) {
            this.evE.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.evE != null) {
            this.evE.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ewn);
        MessageManager.getInstance().registerListener(this.ewo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ewn);
        MessageManager.getInstance().unRegisterListener(this.ewo);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.evC = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajs = 11;
        this.evS = false;
        this.evT = true;
        this.evU = true;
        this.evV = true;
        this.evW = false;
        this.evX = false;
        this.evY = true;
        this.evZ = false;
        this.ewa = true;
        this.ewb = false;
        this.ewc = true;
        this.mFrom = 2;
        this.ewd = 1;
        this.mSkinType = 3;
        this.ewk = null;
        this.ewm = true;
        this.ewn = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.agf != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.agf.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.agf.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.agf.nr(bwVar.bfp());
                                ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agf.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agf.nr(bwVar.bfp());
                            ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                        }
                    }
                }
            }
        };
        this.ewo = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agf != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agf.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agf.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agf.bgP() || ThreadCommentAndPraiseInfoLayout.this.agf.bgS()) && ThreadCommentAndPraiseInfoLayout.this.agf.bfS() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agf.bfS() != null && ThreadCommentAndPraiseInfoLayout.this.agf.bfS().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agf.bfS().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agf.cE(ThreadCommentAndPraiseInfoLayout.this.agf.bha() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.z(ThreadCommentAndPraiseInfoLayout.this.agf);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evC = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajs = 11;
        this.evS = false;
        this.evT = true;
        this.evU = true;
        this.evV = true;
        this.evW = false;
        this.evX = false;
        this.evY = true;
        this.evZ = false;
        this.ewa = true;
        this.ewb = false;
        this.ewc = true;
        this.mFrom = 2;
        this.ewd = 1;
        this.mSkinType = 3;
        this.ewk = null;
        this.ewm = true;
        this.ewn = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.agf != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.agf.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.agf.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.agf.nr(bwVar.bfp());
                                ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agf.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agf.nr(bwVar.bfp());
                            ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                        }
                    }
                }
            }
        };
        this.ewo = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agf != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agf.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agf.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agf.bgP() || ThreadCommentAndPraiseInfoLayout.this.agf.bgS()) && ThreadCommentAndPraiseInfoLayout.this.agf.bfS() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agf.bfS() != null && ThreadCommentAndPraiseInfoLayout.this.agf.bfS().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agf.bfS().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agf.cE(ThreadCommentAndPraiseInfoLayout.this.agf.bha() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.z(ThreadCommentAndPraiseInfoLayout.this.agf);
                    }
                }
            }
        };
        init(context);
    }

    protected View dY(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ewj = R.drawable.icon_home_card_share;
        this.ewi = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.evC = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aHj();
    }

    protected void aHj() {
        am(dY(this.mContext));
    }

    protected void am(View view) {
        this.aiw = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.evD = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.dVT = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.evF = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.evG = view.findViewById(R.id.thread_info_commont_container);
        this.evH = (TextView) view.findViewById(R.id.share_num);
        this.evI = (ImageView) view.findViewById(R.id.share_num_img);
        this.evJ = view.findViewById(R.id.share_num_container);
        this.evK = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.evL = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.evE = (AgreeView) findViewById;
            this.evE.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.ewh != null) {
                        ThreadCommentAndPraiseInfoLayout.this.ewh.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.agf);
                }
            });
        }
        this.evO = view.findViewById(R.id.manage_view_container);
        this.evM = (TextView) view.findViewById(R.id.thread_info_manage_text);
        this.evN = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.cBL = (ImageView) view.findViewById(R.id.manage_select_img);
        this.evQ = (TextView) view.findViewById(R.id.manage_select_text);
        this.evR = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.evR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cBL.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.evQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.cBL.performClick();
            }
        });
        this.evR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.cBL.performClick();
            }
        });
        this.evG.setOnClickListener(this);
        this.evJ.setOnClickListener(this);
        this.evO.setOnClickListener(this);
        this.cBL.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.ajs = i;
        uk();
    }

    private void uk() {
        int i;
        this.evJ.setVisibility(isShow(1) ? 0 : 8);
        this.evG.setVisibility(isShow(2) ? 0 : 8);
        View view = this.evO;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.evE.setVisibility(isShow(8) ? 0 : 8);
        this.evE.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.ajs & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aiw) {
            bh(view);
        } else if (view == this.evG) {
            be(view);
        } else if (view == this.evJ) {
            bf(view);
        } else if (view == this.evL) {
            bj(view);
        } else if (view == this.evO) {
            bi(view);
        } else if (view == this.cBL) {
            bg(view);
        }
    }

    protected void bg(View view) {
        if (this.cBL != null && this.agf != null && this.evQ != null && !this.agf.bhl()) {
            if (!this.agf.bhj() && com.baidu.tieba.frs.b.cog().coa()) {
                if (com.baidu.tieba.frs.b.cog().aj(this.agf)) {
                    this.agf.hY(true);
                }
            } else if (!this.agf.bhk() && com.baidu.tieba.frs.a.cnZ().coa()) {
                if (com.baidu.tieba.frs.a.cnZ().aj(this.agf)) {
                    this.agf.hZ(true);
                }
            } else {
                com.baidu.tieba.frs.b.cog().ak(this.agf);
                this.agf.hY(false);
                com.baidu.tieba.frs.a.cnZ().ak(this.agf);
                this.agf.hZ(false);
            }
            ap.setViewTextColor(this.evQ, (this.agf.bhj() || this.agf.bhk()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cBL.setImageDrawable(ap.getDrawable((this.agf.bhj() || this.agf.bhk()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.ewk != null) {
                this.ewk.iy(this.agf.bhj() || this.agf.bhk());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.evG != null) {
            this.evG.setClickable(z);
            this.evF.setEnabled(z);
            this.dVT.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.evJ != null) {
            this.evJ.setClickable(z);
            this.evI.setEnabled(z);
            this.evH.setEnabled(z);
        }
    }

    private void bh(View view) {
        if (this.agf != null && !StringUtils.isNull(this.agf.bfC())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.ewg)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.agf.bfC(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.agf.bfC(), this.mStType, this.ewg)));
            }
            if (this.ewh != null) {
                this.ewh.onClick(view);
            }
        }
    }

    private boolean w(bw bwVar) {
        return (bwVar == null || !bwVar.bee() || bwVar.bfQ() == null) ? false : true;
    }

    protected void be(View view) {
        if (this.agf != null && this.mContext != null) {
            m.Hw(this.agf.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.agf, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.agf.getFid()));
            addLocateParam.setForumName(this.agf.bfC());
            if (this.agf.bhn() && this.agf.bhm() != null) {
                addLocateParam.setForumId(this.agf.bhm().getForumId());
                addLocateParam.setForumName(this.agf.bhm().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.ewl != null) {
                this.ewl.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.agf)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.al(this.agf);
            }
            if (this.agf.egq) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.agf.bgF() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.ewe);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            aq aqVar = new aq("c12291");
            aqVar.ai("obj_locate", this.mFrom);
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12942");
            aqVar2.ai("obj_locate", this.mFrom);
            aqVar2.ai("obj_type", getThreadType());
            aqVar2.dF("tid", this.agf.getTid());
            aqVar2.dF("nid", this.agf.getNid());
            if (this.mFrom == 18) {
                aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.u("fid", this.agf.getFid());
                aqVar2.ai("obj_locate", 18);
                aqVar2.dF("resource_id", this.mTabName);
            }
            TiebaStatic.log(aqVar2);
            blN();
            a(view, this.agf);
            if (this.ewh != null) {
                this.ewh.onClick(view);
            }
        }
    }

    private void blN() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            aq aqVar = new aq("c13568");
            aqVar.ai("obj_source", threadSourceForDynamicAndBjh);
            aqVar.ai("obj_type", threadTypeForDynamicAndBjh);
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
        if (this.agf == null) {
            return 0;
        }
        if (this.agf.beg()) {
            return 1;
        }
        if (this.agf.beh()) {
            return 2;
        }
        if (this.agf.bht()) {
            return 3;
        }
        return this.agf.bhu() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.agf == null) {
            return 0;
        }
        if (this.agf.isShareThread) {
            return 4;
        }
        if (this.agf.getThreadType() == 49) {
            return 5;
        }
        if (this.agf.bfQ() != null) {
            return 1;
        }
        if (this.agf.getType() == bw.edg || this.agf.getType() == bw.edB) {
            if (y.getCount(this.agf.bfL()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.agf != null || i >= 0) {
            aq pe = pe(i);
            pe.ai("thread_type", this.agf.getThreadType());
            TiebaStatic.log(pe);
        }
    }

    private aq pe(int i) {
        if (this.agf == null && i < 0) {
            return null;
        }
        aq aqVar = new aq("c12003");
        aqVar.dF("tid", this.agf.getTid());
        if (this.agf.getThreadType() == 40) {
            aqVar.dF("obj_param1", "2");
        } else if (this.agf.getThreadType() == 0) {
            aqVar.dF("obj_param1", "1");
        }
        aqVar.dF("obj_source", "1");
        aqVar.u("fid", this.agf.getFid());
        aqVar.ai("obj_locate", this.mFrom);
        aqVar.ai("obj_id", i);
        if (!at.isEmpty(this.ewf)) {
            aqVar.dF("obj_floor", this.ewf);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dF(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        aqVar.dF("nid", this.agf.getNid());
        aqVar.ai(IntentConfig.CARD_TYPE, this.agf.bhx());
        aqVar.dF(IntentConfig.RECOM_SOURCE, this.agf.mRecomSource);
        aqVar.dF("ab_tag", this.agf.mRecomAbTag);
        aqVar.dF("weight", this.agf.mRecomWeight);
        aqVar.dF("extra", this.agf.mRecomExtra);
        if (this.agf.getBaijiahaoData() != null && !at.isEmpty(this.agf.getBaijiahaoData().oriUgcVid)) {
            aqVar.dF("obj_param6", this.agf.getBaijiahaoData().oriUgcVid);
            return aqVar;
        }
        return aqVar;
    }

    protected void bf(View view) {
        if ((ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) && this.agf != null) {
            blO();
            a(view, this.agf);
            if (!AntiHelper.d(getContext(), this.agf)) {
                blQ();
                if (this.ewh != null) {
                    this.ewh.onClick(view);
                }
            }
        }
    }

    private void blO() {
        if (this.agf != null) {
            aq blP = blP();
            blP.ai("thread_type", this.agf.getThreadType());
            TiebaStatic.log(blP);
        }
    }

    private aq blP() {
        if (this.agf == null) {
            return null;
        }
        int i = 0;
        if (this.ewd == 1) {
            i = 4;
        } else if (this.ewd == 2) {
            i = 5;
        } else if (this.ewd == 3) {
            i = 3;
        } else if (this.ewd == 4) {
            i = 2;
        } else if (this.ewd == 6) {
            i = 8;
        } else if (this.ewd == 7) {
            i = 9;
        } else if (this.ewd == 9) {
            i = 10;
        } else if (this.ewd == 10) {
            i = 17;
        } else if (this.ewd == 18) {
            i = 20;
        }
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.u("fid", this.agf.getFid());
        aqVar.dF("tid", this.agf.getTid());
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.ai("obj_locate", i);
        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, this.eqz);
        if (!at.isEmpty(this.ewf)) {
            aqVar.dF("obj_floor", this.ewf);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.agf.bfS() != null && this.agf.bfS().user_info != null && this.agf.bfS().user_info.is_official == 2) {
            aqVar.ai("obj_isofficial", this.agf.bfS().user_info.is_official);
        }
        aqVar.ai(IntentConfig.CARD_TYPE, this.agf.bhx()).dF("ab_tag", this.agf.mRecomAbTag).dF(IntentConfig.RECOM_SOURCE, this.agf.mRecomSource).dF("weight", this.agf.mRecomWeight).dF("extra", this.agf.mRecomExtra);
        if (this.agf.beg()) {
            aqVar.ai("obj_type", 10);
        } else if (this.agf.beh()) {
            aqVar.ai("obj_type", 9);
        } else if (this.agf.bhu()) {
            aqVar.ai("obj_type", 8);
        } else if (this.agf.bht()) {
            aqVar.ai("obj_type", 7);
        } else if (this.agf.isShareThread) {
            aqVar.ai("obj_type", 6);
        } else if (this.agf.threadType == 0) {
            aqVar.ai("obj_type", 1);
        } else if (this.agf.threadType == 40) {
            aqVar.ai("obj_type", 2);
        } else if (this.agf.threadType == 49) {
            aqVar.ai("obj_type", 3);
        } else if (this.agf.threadType == 54) {
            aqVar.ai("obj_type", 4);
        } else {
            aqVar.ai("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            aqVar.dF("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            aqVar.dF("obj_tab", "a099");
            aqVar.dF("resource_id", this.mTabName);
        }
        if (this.agf.getBaijiahaoData() != null) {
            aqVar.dF("obj_param4", this.agf.getBaijiahaoData().oriUgcNid);
            if (this.agf.beh() || this.agf.bhu()) {
                aqVar.dF("obj_param6", this.agf.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.agf.bhs()) {
            aqVar.ai("obj_param5", 2);
        } else if (this.agf.beg() || this.agf.beh()) {
            aqVar.ai("obj_param5", 3);
        } else if (this.agf.threadType == 0 || this.agf.threadType == 40) {
            aqVar.ai("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), aqVar);
        }
        aqVar.dF("nid", this.agf.getNid());
        return aqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bw bwVar) {
        int i;
        int i2 = 1;
        if (bwVar != null) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a("c13694", bwVar, i2, i));
            }
        }
    }

    private void blQ() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.agf != null && this.mContext != null) {
            String valueOf = String.valueOf(this.agf.getFid());
            String bfC = this.agf.bfC();
            if (this.agf.egd != null) {
                valueOf = this.agf.egd.id;
                bfC = this.agf.egd.ori_fname;
            }
            String title = this.agf.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.agf.getAbstract();
            }
            if (this.agf.bei()) {
                tid = this.agf.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.agf.getBaijiahaoData().oriUgcType + "&dvid=" + this.agf.getBaijiahaoData().oriUgcVid + "&nid=" + this.agf.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.agf.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            boolean z = true;
            if (this.agf.bfS() != null && this.agf.bfS().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.agf.bfS().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.agf.bfS().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(this.agf);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = this.agf.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.agf.bei() || this.agf.bfy() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.agf.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.agf.bfy().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = at.cutString(title, 100);
            String cutString2 = at.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(this.agf);
            if (this.agf.bei()) {
                shareItem.readCount = -1L;
                shareItem.eGA = cutString2;
            } else {
                if (stateThreadType == 2 && this.agf.bfQ() != null) {
                    shareItem.readCount = this.agf.bfQ().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = this.agf.bfq();
                }
                shareItem.eGA = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = bfC;
            shareItem.tid = tid;
            shareItem.eGp = true;
            shareItem.egT = this.ewd;
            shareItem.eGC = getShareObjSource();
            shareItem.eGH = stateThreadType;
            shareItem.eGD = 3;
            shareItem.eGE = getShareObjParam2(this.agf);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.agf.bei()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.eGR = this.agf.getShareImageUrl();
            }
            blR();
            shareItem.eGK = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agf);
            if (this.mFrom == 13) {
                shareItem.eGL = ShareItem.ForwardInfo.generateForwardInfo(this.agf, 2);
            } else {
                shareItem.eGL = ShareItem.ForwardInfo.generateForwardInfo(this.agf);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eGD);
            bundle.putInt("obj_type", shareItem.eGH);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.egT);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.agf.getThreadType() == 49 || this.agf.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.f.cgr().b(shareDialogConfig);
        }
    }

    private void blR() {
        ItemInfo cov;
        if ((this.mContext instanceof ao) && ((ao) this.mContext).cow() && this.agf != null && this.agf.bhB() == null && (cov = ((ao) this.mContext).cov()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cov.id.longValue());
            builder.item_name = cov.name;
            builder.icon_size = cov.icon_size;
            builder.icon_url = cov.icon_url;
            builder.tags = cov.tags;
            if (cov.score != null && cov.score.item_point != null) {
                Iterator<ItemPoint> it = cov.score.item_point.iterator();
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
            this.agf.a(itemData);
        }
    }

    private int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.beg()) {
            return 10;
        }
        if (bwVar.beh()) {
            return 9;
        }
        if (bwVar.bhu()) {
            return 8;
        }
        if (bwVar.bht()) {
            return 7;
        }
        if (bwVar.isShareThread) {
            return 6;
        }
        if (bwVar.threadType == 0) {
            return 1;
        }
        if (bwVar.threadType == 40) {
            return 2;
        }
        if (bwVar.threadType == 49) {
            return 3;
        }
        if (bwVar.threadType == 54) {
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
        if (this.ewd == 1) {
            return 5;
        }
        if (this.ewd != 3) {
            if (this.ewd == 4) {
                return 4;
            }
            if (this.ewd == 6) {
                return 8;
            }
            if (this.ewd != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String getShareImageUrl(bw bwVar) {
        String str;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.bfS() != null && !TextUtils.isEmpty(bwVar.bfS().cover)) {
            return bwVar.bfS().cover;
        }
        if (bwVar.bfH() == null) {
            return null;
        }
        ArrayList<MediaData> bfH = bwVar.bfH();
        int size = bfH.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bfH.get(i);
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
        if (str == null && bwVar.bfQ() != null && !TextUtils.isEmpty(bwVar.bfQ().thumbnail_url)) {
            return bwVar.bfQ().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.bfA()) {
                return 4;
            }
            if (bwVar.bfv() == 1) {
                return 3;
            }
            if (bwVar.beg()) {
                return 5;
            }
            if (bwVar.beh()) {
                return 6;
            }
            if (bwVar.bht()) {
                return 7;
            }
            if (bwVar.bhu()) {
                return 8;
            }
            if (!bwVar.isShareThread || bwVar.efS == null) {
                return bwVar.bgQ() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bi(View view) {
        if (this.evP == null) {
            this.evP = new ab(this.mPageContext, isShow(16));
        }
        this.evP.setData(this.agf);
        this.evP.NY();
        if (this.agf != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).u("uid", TbadkCoreApplication.getCurrentAccountId()).u("fid", this.agf.getFid()).dF("tid", this.agf.getId()));
        }
    }

    private void bj(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.evV = z;
        if (this.aiw != null) {
            this.aiw.setClickable(this.evV);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.agf = bwVar;
        aaP();
        B(bwVar);
        D(bwVar);
        A(bwVar);
        z(bwVar);
        updatePraiseNum(bwVar);
        C(bwVar);
        E(bwVar);
        setVisibility(this.evS ? 0 : 8);
        blL();
        return this.evS;
    }

    protected void blL() {
    }

    protected void aaP() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bw bwVar) {
        this.aiw.setVisibility(8);
    }

    protected void C(bw bwVar) {
        if (this.evR != null && this.cBL != null && this.evQ != null && bwVar != null) {
            if (!this.ewm) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.evR.setVisibility(8);
            } else if (this.ewc && (com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cBL.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cBL.performClick();
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
                ap.setViewTextColor(this.evQ, (this.agf.bhj() || this.agf.bhk()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cBL.setImageDrawable(ap.getDrawable((bwVar.bhj() || this.agf.bhk()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.evR.setVisibility(4);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.evR.setVisibility(8);
            }
        }
    }

    private void D(bw bwVar) {
        String bfb;
        if (this.evD != null && bwVar != null) {
            if (bwVar.bfr() <= 0 || !this.evT) {
                this.evD.setVisibility(8);
                return;
            }
            this.evD.setVisibility(0);
            if (this.mFrom == 3) {
                bfb = bwVar.bfc();
            } else {
                bfb = bwVar.bfb();
            }
            this.evD.setText(bfb);
            this.evS = true;
        }
    }

    public boolean isVisible() {
        return this.evS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bw bwVar) {
        if (this.dVT != null && bwVar != null) {
            if (this.evY) {
                this.evG.setVisibility(0);
                if (bwVar.bfp() > 0) {
                    this.dVT.setVisibility(0);
                    String numFormatOverWan = at.numFormatOverWan(bwVar.bfp());
                    if (this.evW) {
                        updateReplyStateUI();
                        this.dVT.setText(numFormatOverWan);
                    } else {
                        this.dVT.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dVT.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.evS = true;
                    return;
                } else if (this.evW) {
                    updateReplyStateUI();
                    this.dVT.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dVT.setVisibility(0);
                    this.evS = true;
                    return;
                } else {
                    this.dVT.setVisibility(8);
                    return;
                }
            }
            this.evG.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.evW) {
            SvgManager.bkl().a(this.evF, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.dVT, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bw bwVar) {
        setAgreeViewType(bwVar);
        if (bwVar.bhp() != null) {
            bwVar.bhp().isInThread = true;
            this.evE.setCardType(bwVar.bhx());
            this.evE.setThreadData(bwVar);
            this.evE.setData(bwVar.bhp());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(bw bwVar) {
        if (this.evJ != null && this.evH != null && bwVar != null) {
            if (this.ewa) {
                this.evJ.setVisibility(0);
                long bha = bwVar.bha();
                if ((bwVar.bgP() || bwVar.bgS()) && bwVar.bfS() != null && bwVar.bfS().share_info != null) {
                    bha = bwVar.bfS().share_info.share_count;
                }
                this.evH.setText(bha > 0 ? at.numFormatOverWan(bha) : this.mContext.getString(R.string.share));
                this.evS = true;
                updateShareStateUI(bwVar);
                return;
            }
            this.evJ.setVisibility(8);
        }
    }

    public void updateShareStateUI(bw bwVar) {
        if (AntiHelper.aZ(bwVar)) {
            setShareClickable(true);
            SvgManager.bkl().a(this.evI, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.evH, R.color.cp_cont_e);
        } else if (bwVar != null && bwVar.efS != null && this.agf.efS.eav) {
            setShareClickable(false);
            SvgManager.bkl().a(this.evI, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.evH, R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.bkl().a(this.evI, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.evH, R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void E(bw bwVar) {
        if (this.evO != null && bwVar != null) {
            this.ewb = isShow(4);
            if (bwVar.egd != null) {
                this.ewb = false;
            }
            if (this.ewb && (this.evR == null || this.evR.getVisibility() == 8)) {
                this.evO.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.evM.setText(string);
                this.evM.setContentDescription(string);
                this.evS = true;
                return;
            }
            this.evO.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        if (this.evE != null) {
            this.evE.setStatisticData(cVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.aiw, R.color.cp_cont_d);
            ap.setViewTextColor(this.evD, R.color.cp_cont_j);
            ap.setViewTextColor(this.evM, R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.agf);
            SvgManager.bkl().a(this.evL, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.evN, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.evP != null) {
                this.evP.onChangeSkinType();
            }
            if (this.evE != null) {
                this.evE.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ewh = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aiw;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.evZ = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.evT = z;
    }

    public View getCommentNumView() {
        return this.dVT;
    }

    public View getCommentContainer() {
        return this.evG;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.evW = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.evX = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.ewa = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evF.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.evF.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.ewa = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evF.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.evF.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.ewc = z;
    }

    public void setManageVisible(boolean z) {
        this.ewb = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.ewk = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.cBL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.ewm = z;
    }

    public boolean isInFrsAllThread() {
        return this.ewm;
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
        if (this.evP != null) {
            this.evP.destory();
        }
    }

    public void setAgreeViewType(bw bwVar) {
        if (bwVar != null && bwVar.bei()) {
            this.evE.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.evE.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.ewl = aVar;
    }
}
