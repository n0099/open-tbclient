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
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.n;
import com.baidu.tieba.frs.ao;
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
    protected bw agx;
    protected TextView aiP;
    private int ajL;
    protected ImageView cWm;
    private int eLh;
    protected boolean eQA;
    protected boolean eQB;
    protected boolean eQC;
    protected boolean eQD;
    protected boolean eQE;
    protected boolean eQF;
    protected boolean eQG;
    protected boolean eQH;
    protected boolean eQI;
    private int eQJ;
    public int eQK;
    public String eQL;
    private String eQM;
    private View.OnClickListener eQN;
    protected int eQO;
    protected int eQP;
    private b eQQ;
    private a eQR;
    private boolean eQS;
    CustomMessageListener eQT;
    CustomMessageListener eQU;
    protected int eQi;
    private TextView eQj;
    protected AgreeView eQk;
    protected ImageView eQl;
    protected View eQm;
    protected TextView eQn;
    protected ImageView eQo;
    protected View eQp;
    protected FrameLayout eQq;
    protected ImageView eQr;
    protected TextView eQs;
    protected ImageView eQt;
    protected View eQu;
    protected ac eQv;
    protected TextView eQw;
    protected LinearLayout eQx;
    protected boolean eQy;
    protected boolean eQz;
    protected TextView eqt;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;

    /* loaded from: classes21.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void jj(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.eQM = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.eQk != null) {
            this.eQk.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.eQJ = i;
    }

    public void setGameId(int i) {
        this.eLh = i;
        if (this.eQk != null) {
            this.eQk.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.eQk != null) {
            this.eQk.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eQT);
        MessageManager.getInstance().registerListener(this.eQU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eQT);
        MessageManager.getInstance().unRegisterListener(this.eQU);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.eQi = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajL = 11;
        this.eQy = false;
        this.eQz = true;
        this.eQA = true;
        this.eQB = true;
        this.eQC = false;
        this.eQD = false;
        this.eQE = true;
        this.eQF = false;
        this.eQG = true;
        this.eQH = false;
        this.eQI = true;
        this.mFrom = 2;
        this.eQJ = 1;
        this.mSkinType = 3;
        this.eQQ = null;
        this.eQS = true;
        this.eQT = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.agx != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.agx.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.agx.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.agx.nZ(bwVar.bjR());
                                ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agx.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agx.nZ(bwVar.bjR());
                            ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                        }
                    }
                }
            }
        };
        this.eQU = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agx != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agx.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agx.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agx.blr() || ThreadCommentAndPraiseInfoLayout.this.agx.blu()) && ThreadCommentAndPraiseInfoLayout.this.agx.bku() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agx.bku() != null && ThreadCommentAndPraiseInfoLayout.this.agx.bku().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agx.bku().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agx.cO(ThreadCommentAndPraiseInfoLayout.this.agx.blC() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.z(ThreadCommentAndPraiseInfoLayout.this.agx);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eQi = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajL = 11;
        this.eQy = false;
        this.eQz = true;
        this.eQA = true;
        this.eQB = true;
        this.eQC = false;
        this.eQD = false;
        this.eQE = true;
        this.eQF = false;
        this.eQG = true;
        this.eQH = false;
        this.eQI = true;
        this.mFrom = 2;
        this.eQJ = 1;
        this.mSkinType = 3;
        this.eQQ = null;
        this.eQS = true;
        this.eQT = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.agx != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.agx.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.agx.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.agx.nZ(bwVar.bjR());
                                ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agx.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agx.nZ(bwVar.bjR());
                            ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                        }
                    }
                }
            }
        };
        this.eQU = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agx != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agx.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agx.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agx.blr() || ThreadCommentAndPraiseInfoLayout.this.agx.blu()) && ThreadCommentAndPraiseInfoLayout.this.agx.bku() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agx.bku() != null && ThreadCommentAndPraiseInfoLayout.this.agx.bku().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agx.bku().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agx.cO(ThreadCommentAndPraiseInfoLayout.this.agx.blC() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.z(ThreadCommentAndPraiseInfoLayout.this.agx);
                    }
                }
            }
        };
        init(context);
    }

    protected View ef(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.eQP = R.drawable.icon_home_card_share;
        this.eQO = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.eQi = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aLM();
    }

    protected void aLM() {
        ah(ef(this.mContext));
    }

    protected void ah(View view) {
        this.aiP = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.eQj = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.eqt = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.eQl = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.eQm = view.findViewById(R.id.thread_info_commont_container);
        this.eQn = (TextView) view.findViewById(R.id.share_num);
        this.eQo = (ImageView) view.findViewById(R.id.share_num_img);
        this.eQp = view.findViewById(R.id.share_num_container);
        this.eQq = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.eQr = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.eQk = (AgreeView) findViewById;
            this.eQk.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.eQN != null) {
                        ThreadCommentAndPraiseInfoLayout.this.eQN.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.agx);
                }
            });
        }
        this.eQu = view.findViewById(R.id.manage_view_container);
        this.eQs = (TextView) view.findViewById(R.id.thread_info_manage_text);
        this.eQt = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.cWm = (ImageView) view.findViewById(R.id.manage_select_img);
        this.eQw = (TextView) view.findViewById(R.id.manage_select_text);
        this.eQx = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.eQx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cWm.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.eQw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.cWm.performClick();
            }
        });
        this.eQx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.cWm.performClick();
            }
        });
        this.eQm.setOnClickListener(this);
        this.eQp.setOnClickListener(this);
        this.eQu.setOnClickListener(this);
        this.cWm.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.ajL = i;
        uk();
    }

    private void uk() {
        int i;
        this.eQp.setVisibility(isShow(1) ? 0 : 8);
        this.eQm.setVisibility(isShow(2) ? 0 : 8);
        View view = this.eQu;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.eQk.setVisibility(isShow(8) ? 0 : 8);
        this.eQk.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.ajL & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aiP) {
            bm(view);
        } else if (view == this.eQm) {
            bj(view);
        } else if (view == this.eQp) {
            bk(view);
        } else if (view == this.eQr) {
            bo(view);
        } else if (view == this.eQu) {
            bn(view);
        } else if (view == this.cWm) {
            bl(view);
        }
    }

    protected void bl(View view) {
        if (this.cWm != null && this.agx != null && this.eQw != null && !this.agx.blN()) {
            if (!this.agx.blL() && com.baidu.tieba.frs.b.cuL().cuF()) {
                if (com.baidu.tieba.frs.b.cuL().aj(this.agx)) {
                    this.agx.iH(true);
                }
            } else if (!this.agx.blM() && com.baidu.tieba.frs.a.cuE().cuF()) {
                if (com.baidu.tieba.frs.a.cuE().aj(this.agx)) {
                    this.agx.iI(true);
                }
            } else {
                com.baidu.tieba.frs.b.cuL().ak(this.agx);
                this.agx.iH(false);
                com.baidu.tieba.frs.a.cuE().ak(this.agx);
                this.agx.iI(false);
            }
            ap.setViewTextColor(this.eQw, (this.agx.blL() || this.agx.blM()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cWm.setImageDrawable(ap.getDrawable((this.agx.blL() || this.agx.blM()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.eQQ != null) {
                this.eQQ.jj(this.agx.blL() || this.agx.blM());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.eQm != null) {
            this.eQm.setClickable(z);
            this.eQl.setEnabled(z);
            this.eqt.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.eQp != null) {
            this.eQp.setClickable(z);
            this.eQo.setEnabled(z);
            this.eQn.setEnabled(z);
        }
    }

    private void bm(View view) {
        if (this.agx != null && !StringUtils.isNull(this.agx.bke())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.eQM)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.agx.bke(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.agx.bke(), this.mStType, this.eQM)));
            }
            if (this.eQN != null) {
                this.eQN.onClick(view);
            }
        }
    }

    private boolean w(bw bwVar) {
        return (bwVar == null || !bwVar.biG() || bwVar.bks() == null) ? false : true;
    }

    protected void bj(View view) {
        if (this.agx != null && this.mContext != null) {
            n.II(this.agx.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.agx, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.agx.getFid()));
            addLocateParam.setForumName(this.agx.bke());
            if (this.agx.blP() && this.agx.blO() != null) {
                addLocateParam.setForumId(this.agx.blO().getForumId());
                addLocateParam.setForumName(this.agx.blO().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.eQR != null) {
                this.eQR.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.agx)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.al(this.agx);
            }
            if (this.agx.eAW) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.agx.blh() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.eQK);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            aq aqVar = new aq("c12291");
            aqVar.aj("obj_locate", this.mFrom);
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12942");
            aqVar2.aj("obj_locate", this.mFrom);
            aqVar2.aj("obj_type", getThreadType());
            aqVar2.dR("tid", this.agx.getTid());
            aqVar2.dR("nid", this.agx.getNid());
            if (this.mFrom == 18) {
                aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.w("fid", this.agx.getFid());
                aqVar2.aj("obj_locate", 18);
                aqVar2.dR("resource_id", this.mTabName);
            }
            TiebaStatic.log(aqVar2);
            bqq();
            a(view, this.agx);
            if (this.eQN != null) {
                this.eQN.onClick(view);
            }
        }
    }

    private void bqq() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            aq aqVar = new aq("c13568");
            aqVar.aj("obj_source", threadSourceForDynamicAndBjh);
            aqVar.aj("obj_type", threadTypeForDynamicAndBjh);
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
        if (this.agx == null) {
            return 0;
        }
        if (this.agx.biI()) {
            return 1;
        }
        if (this.agx.biJ()) {
            return 2;
        }
        if (this.agx.blV()) {
            return 3;
        }
        return this.agx.blW() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.agx == null) {
            return 0;
        }
        if (this.agx.isShareThread) {
            return 4;
        }
        if (this.agx.getThreadType() == 49) {
            return 5;
        }
        if (this.agx.bks() != null) {
            return 1;
        }
        if (this.agx.getType() == bw.exJ || this.agx.getType() == bw.eyf) {
            if (y.getCount(this.agx.bkn()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.agx != null || i >= 0) {
            aq pO = pO(i);
            pO.aj("thread_type", this.agx.getThreadType());
            TiebaStatic.log(pO);
        }
    }

    private aq pO(int i) {
        if (this.agx == null && i < 0) {
            return null;
        }
        aq aqVar = new aq("c12003");
        aqVar.dR("tid", this.agx.getTid());
        if (this.agx.getThreadType() == 40) {
            aqVar.dR("obj_param1", "2");
        } else if (this.agx.getThreadType() == 0) {
            aqVar.dR("obj_param1", "1");
        }
        aqVar.dR("obj_source", "1");
        aqVar.w("fid", this.agx.getFid());
        aqVar.aj("obj_locate", this.mFrom);
        aqVar.aj("obj_id", i);
        if (!at.isEmpty(this.eQL)) {
            aqVar.dR("obj_floor", this.eQL);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        aqVar.dR("nid", this.agx.getNid());
        aqVar.aj(IntentConfig.CARD_TYPE, this.agx.blZ());
        aqVar.dR(IntentConfig.RECOM_SOURCE, this.agx.mRecomSource);
        aqVar.dR("ab_tag", this.agx.mRecomAbTag);
        aqVar.dR("weight", this.agx.mRecomWeight);
        aqVar.dR("extra", this.agx.mRecomExtra);
        if (this.agx.getBaijiahaoData() != null && !at.isEmpty(this.agx.getBaijiahaoData().oriUgcVid)) {
            aqVar.dR("obj_param6", this.agx.getBaijiahaoData().oriUgcVid);
            return aqVar;
        }
        return aqVar;
    }

    protected void bk(View view) {
        if ((ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) && this.agx != null) {
            bqr();
            a(view, this.agx);
            if (!AntiHelper.d(getContext(), this.agx)) {
                bqt();
                if (this.eQN != null) {
                    this.eQN.onClick(view);
                }
            }
        }
    }

    private void bqr() {
        if (this.agx != null) {
            aq bqs = bqs();
            bqs.aj("thread_type", this.agx.getThreadType());
            TiebaStatic.log(bqs);
        }
    }

    private aq bqs() {
        if (this.agx == null) {
            return null;
        }
        int i = 0;
        if (this.eQJ == 1) {
            i = 4;
        } else if (this.eQJ == 2) {
            i = 5;
        } else if (this.eQJ == 3) {
            i = 3;
        } else if (this.eQJ == 4) {
            i = 2;
        } else if (this.eQJ == 6) {
            i = 8;
        } else if (this.eQJ == 7) {
            i = 9;
        } else if (this.eQJ == 9) {
            i = 10;
        } else if (this.eQJ == 10) {
            i = 17;
        } else if (this.eQJ == 18) {
            i = 20;
        }
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.w("fid", this.agx.getFid());
        aqVar.dR("tid", this.agx.getTid());
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.aj("obj_locate", i);
        aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, this.eLh);
        if (!at.isEmpty(this.eQL)) {
            aqVar.dR("obj_floor", this.eQL);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.agx.bku() != null && this.agx.bku().user_info != null && this.agx.bku().user_info.is_official == 2) {
            aqVar.aj("obj_isofficial", this.agx.bku().user_info.is_official);
        }
        aqVar.aj(IntentConfig.CARD_TYPE, this.agx.blZ()).dR("ab_tag", this.agx.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.agx.mRecomSource).dR("weight", this.agx.mRecomWeight).dR("extra", this.agx.mRecomExtra);
        if (this.agx.biI()) {
            aqVar.aj("obj_type", 10);
        } else if (this.agx.biJ()) {
            aqVar.aj("obj_type", 9);
        } else if (this.agx.blW()) {
            aqVar.aj("obj_type", 8);
        } else if (this.agx.blV()) {
            aqVar.aj("obj_type", 7);
        } else if (this.agx.isShareThread) {
            aqVar.aj("obj_type", 6);
        } else if (this.agx.threadType == 0) {
            aqVar.aj("obj_type", 1);
        } else if (this.agx.threadType == 40) {
            aqVar.aj("obj_type", 2);
        } else if (this.agx.threadType == 49) {
            aqVar.aj("obj_type", 3);
        } else if (this.agx.threadType == 54) {
            aqVar.aj("obj_type", 4);
        } else {
            aqVar.aj("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            aqVar.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            aqVar.dR("obj_tab", "a099");
            aqVar.dR("resource_id", this.mTabName);
        }
        if (this.agx.getBaijiahaoData() != null) {
            aqVar.dR("obj_param4", this.agx.getBaijiahaoData().oriUgcNid);
            if (this.agx.biJ() || this.agx.blW()) {
                aqVar.dR("obj_param6", this.agx.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.agx.blU()) {
            aqVar.aj("obj_param5", 2);
        } else if (this.agx.biI() || this.agx.biJ()) {
            aqVar.aj("obj_param5", 3);
        } else if (this.agx.threadType == 0 || this.agx.threadType == 40) {
            aqVar.aj("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), aqVar);
        }
        aqVar.dR("nid", this.agx.getNid());
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

    private void bqt() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.agx != null && this.mContext != null) {
            String valueOf = String.valueOf(this.agx.getFid());
            String bke = this.agx.bke();
            if (this.agx.eAJ != null) {
                valueOf = this.agx.eAJ.id;
                bke = this.agx.eAJ.ori_fname;
            }
            String title = this.agx.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.agx.getAbstract();
            }
            if (this.agx.biK()) {
                tid = this.agx.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.agx.getBaijiahaoData().oriUgcType + "&dvid=" + this.agx.getBaijiahaoData().oriUgcVid + "&nid=" + this.agx.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.agx.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            boolean z = true;
            if (this.agx.bku() != null && this.agx.bku().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.agx.bku().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.agx.bku().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(this.agx);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = this.agx.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.agx.biK() || this.agx.bka() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.agx.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.agx.bka().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = at.cutString(title, 100);
            String cutString2 = at.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(this.agx);
            if (this.agx.biK()) {
                shareItem.readCount = -1L;
                shareItem.fbd = cutString2;
            } else {
                if (stateThreadType == 2 && this.agx.bks() != null) {
                    shareItem.readCount = this.agx.bks().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = this.agx.bjS();
                }
                shareItem.fbd = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = bke;
            shareItem.tid = tid;
            shareItem.faS = true;
            shareItem.eBz = this.eQJ;
            shareItem.fbf = getShareObjSource();
            shareItem.fbk = stateThreadType;
            shareItem.fbg = 3;
            shareItem.fbh = getShareObjParam2(this.agx);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.agx.biK()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.fbu = this.agx.getShareImageUrl();
            }
            bqu();
            shareItem.fbn = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agx);
            if (this.mFrom == 13) {
                shareItem.fbo = ShareItem.ForwardInfo.generateForwardInfo(this.agx, 2);
            } else {
                shareItem.fbo = ShareItem.ForwardInfo.generateForwardInfo(this.agx);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fbg);
            bundle.putInt("obj_type", shareItem.fbk);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eBz);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.agx.getThreadType() == 49 || this.agx.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.f.cmU().b(shareDialogConfig);
        }
    }

    private void bqu() {
        ItemInfo cva;
        if ((this.mContext instanceof ao) && ((ao) this.mContext).cvb() && this.agx != null && this.agx.bmd() == null && (cva = ((ao) this.mContext).cva()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cva.id.longValue());
            builder.item_name = cva.name;
            builder.icon_size = cva.icon_size;
            builder.icon_url = cva.icon_url;
            builder.tags = cva.tags;
            if (cva.score != null && cva.score.item_point != null) {
                Iterator<ItemPoint> it = cva.score.item_point.iterator();
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
            this.agx.a(itemData);
        }
    }

    private int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.biI()) {
            return 10;
        }
        if (bwVar.biJ()) {
            return 9;
        }
        if (bwVar.blW()) {
            return 8;
        }
        if (bwVar.blV()) {
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
        if (this.eQJ == 1) {
            return 5;
        }
        if (this.eQJ != 3) {
            if (this.eQJ == 4) {
                return 4;
            }
            if (this.eQJ == 6) {
                return 8;
            }
            if (this.eQJ != 10) {
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
        if (bwVar.bku() != null && !TextUtils.isEmpty(bwVar.bku().cover)) {
            return bwVar.bku().cover;
        }
        if (bwVar.bkj() == null) {
            return null;
        }
        ArrayList<MediaData> bkj = bwVar.bkj();
        int size = bkj.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bkj.get(i);
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
        if (str == null && bwVar.bks() != null && !TextUtils.isEmpty(bwVar.bks().thumbnail_url)) {
            return bwVar.bks().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.bkc()) {
                return 4;
            }
            if (bwVar.bjX() == 1) {
                return 3;
            }
            if (bwVar.biI()) {
                return 5;
            }
            if (bwVar.biJ()) {
                return 6;
            }
            if (bwVar.blV()) {
                return 7;
            }
            if (bwVar.blW()) {
                return 8;
            }
            if (!bwVar.isShareThread || bwVar.eAy == null) {
                return bwVar.bls() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bn(View view) {
        if (this.eQv == null) {
            this.eQv = new ac(this.mPageContext, isShow(16));
        }
        this.eQv.setData(this.agx);
        this.eQv.PJ();
        if (this.agx != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.agx.getFid()).dR("tid", this.agx.getId()));
        }
    }

    private void bo(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.eQB = z;
        if (this.aiP != null) {
            this.aiP.setClickable(this.eQB);
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
        this.agx = bwVar;
        afv();
        B(bwVar);
        D(bwVar);
        A(bwVar);
        z(bwVar);
        updatePraiseNum(bwVar);
        C(bwVar);
        E(bwVar);
        setVisibility(this.eQy ? 0 : 8);
        bqo();
        return this.eQy;
    }

    protected void bqo() {
    }

    protected void afv() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bw bwVar) {
        this.aiP.setVisibility(8);
    }

    protected void C(bw bwVar) {
        if (this.eQx != null && this.cWm != null && this.eQw != null && bwVar != null) {
            if (!this.eQS) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.eQx.setVisibility(8);
            } else if (this.eQI && (com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cWm.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cWm.performClick();
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
                ap.setViewTextColor(this.eQw, (this.agx.blL() || this.agx.blM()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cWm.setImageDrawable(ap.getDrawable((bwVar.blL() || this.agx.blM()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.eQx.setVisibility(4);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.eQx.setVisibility(8);
            }
        }
    }

    private void D(bw bwVar) {
        String bjD;
        if (this.eQj != null && bwVar != null) {
            if (bwVar.bjT() <= 0 || !this.eQz) {
                this.eQj.setVisibility(8);
                return;
            }
            this.eQj.setVisibility(0);
            if (this.mFrom == 3) {
                bjD = bwVar.bjE();
            } else {
                bjD = bwVar.bjD();
            }
            this.eQj.setText(bjD);
            this.eQy = true;
        }
    }

    public boolean isVisible() {
        return this.eQy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bw bwVar) {
        if (this.eqt != null && bwVar != null) {
            if (this.eQE) {
                this.eQm.setVisibility(0);
                if (bwVar.bjR() > 0) {
                    this.eqt.setVisibility(0);
                    String numFormatOverWan = at.numFormatOverWan(bwVar.bjR());
                    if (this.eQC) {
                        updateReplyStateUI();
                        this.eqt.setText(numFormatOverWan);
                    } else {
                        this.eqt.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.eqt.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.eQy = true;
                    return;
                } else if (this.eQC) {
                    updateReplyStateUI();
                    this.eqt.setText(this.mContext.getString(R.string.action_comment_default));
                    this.eqt.setVisibility(0);
                    this.eQy = true;
                    return;
                } else {
                    this.eqt.setVisibility(8);
                    return;
                }
            }
            this.eQm.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.eQC) {
            SvgManager.boN().a(this.eQl, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.eqt, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bw bwVar) {
        setAgreeViewType(bwVar);
        if (bwVar.blR() != null) {
            bwVar.blR().isInThread = true;
            this.eQk.setCardType(bwVar.blZ());
            this.eQk.setThreadData(bwVar);
            this.eQk.setData(bwVar.blR());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(bw bwVar) {
        if (this.eQp != null && this.eQn != null && bwVar != null) {
            if (this.eQG) {
                this.eQp.setVisibility(0);
                long blC = bwVar.blC();
                if ((bwVar.blr() || bwVar.blu()) && bwVar.bku() != null && bwVar.bku().share_info != null) {
                    blC = bwVar.bku().share_info.share_count;
                }
                this.eQn.setText(blC > 0 ? at.numFormatOverWan(blC) : this.mContext.getString(R.string.share));
                this.eQy = true;
                updateShareStateUI(bwVar);
                return;
            }
            this.eQp.setVisibility(8);
        }
    }

    public void updateShareStateUI(bw bwVar) {
        if (AntiHelper.aZ(bwVar)) {
            setShareClickable(true);
            SvgManager.boN().a(this.eQo, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.eQn, R.color.cp_cont_e);
        } else if (bwVar != null && bwVar.eAy != null && this.agx.eAy.euX) {
            setShareClickable(false);
            SvgManager.boN().a(this.eQo, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.eQn, R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.boN().a(this.eQo, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.eQn, R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void E(bw bwVar) {
        if (this.eQu != null && bwVar != null) {
            this.eQH = isShow(4);
            if (bwVar.eAJ != null) {
                this.eQH = false;
            }
            if (this.eQH && (this.eQx == null || this.eQx.getVisibility() == 8)) {
                this.eQu.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.eQs.setText(string);
                this.eQs.setContentDescription(string);
                this.eQy = true;
                return;
            }
            this.eQu.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        if (this.eQk != null) {
            this.eQk.setStatisticData(cVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.aiP, R.color.cp_cont_d);
            ap.setViewTextColor(this.eQj, R.color.cp_cont_j);
            ap.setViewTextColor(this.eQs, R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.agx);
            SvgManager.boN().a(this.eQr, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.eQt, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.eQv != null) {
                this.eQv.onChangeSkinType();
            }
            if (this.eQk != null) {
                this.eQk.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eQN = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aiP;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.eQF = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.eQz = z;
    }

    public View getCommentNumView() {
        return this.eqt;
    }

    public View getCommentContainer() {
        return this.eQm;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.eQC = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.eQD = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.eQG = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQl.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.eQl.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.eQG = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQl.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.eQl.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.eQI = z;
    }

    public void setManageVisible(boolean z) {
        this.eQH = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.eQQ = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.cWm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.eQS = z;
    }

    public boolean isInFrsAllThread() {
        return this.eQS;
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
        if (this.eQv != null) {
            this.eQv.destory();
        }
    }

    public void setAgreeViewType(bw bwVar) {
        if (bwVar != null && bwVar.biK()) {
            this.eQk.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.eQk.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.eQR = aVar;
    }
}
