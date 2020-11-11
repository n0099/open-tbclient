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
    protected ImageView dcg;
    private int eQW;
    protected int eVX;
    private TextView eVY;
    protected AgreeView eVZ;
    public String eWA;
    private String eWB;
    private View.OnClickListener eWC;
    protected int eWD;
    protected int eWE;
    private b eWF;
    private a eWG;
    private boolean eWH;
    CustomMessageListener eWI;
    CustomMessageListener eWJ;
    protected ImageView eWa;
    protected View eWb;
    protected TextView eWc;
    protected ImageView eWd;
    protected View eWe;
    protected FrameLayout eWf;
    protected ImageView eWg;
    protected TextView eWh;
    protected ImageView eWi;
    protected View eWj;
    protected ac eWk;
    protected TextView eWl;
    protected LinearLayout eWm;
    protected boolean eWn;
    protected boolean eWo;
    protected boolean eWp;
    protected boolean eWq;
    protected boolean eWr;
    protected boolean eWs;
    protected boolean eWt;
    protected boolean eWu;
    protected boolean eWv;
    protected boolean eWw;
    protected boolean eWx;
    private int eWy;
    public int eWz;
    protected TextView ewm;
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
        void js(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.eWB = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.eVZ != null) {
            this.eVZ.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.eWy = i;
    }

    public void setGameId(int i) {
        this.eQW = i;
        if (this.eVZ != null) {
            this.eVZ.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.eVZ != null) {
            this.eVZ.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eWI);
        MessageManager.getInstance().registerListener(this.eWJ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eWI);
        MessageManager.getInstance().unRegisterListener(this.eWJ);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.eVX = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajL = 11;
        this.eWn = false;
        this.eWo = true;
        this.eWp = true;
        this.eWq = true;
        this.eWr = false;
        this.eWs = false;
        this.eWt = true;
        this.eWu = false;
        this.eWv = true;
        this.eWw = false;
        this.eWx = true;
        this.mFrom = 2;
        this.eWy = 1;
        this.mSkinType = 3;
        this.eWF = null;
        this.eWH = true;
        this.eWI = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
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
                                ThreadCommentAndPraiseInfoLayout.this.agx.oj(bwVar.bmr());
                                ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agx.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agx.oj(bwVar.bmr());
                            ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                        }
                    }
                }
            }
        };
        this.eWJ = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agx != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agx.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agx.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agx.bnR() || ThreadCommentAndPraiseInfoLayout.this.agx.bnU()) && ThreadCommentAndPraiseInfoLayout.this.agx.bmU() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agx.bmU() != null && ThreadCommentAndPraiseInfoLayout.this.agx.bmU().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agx.bmU().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agx.dk(ThreadCommentAndPraiseInfoLayout.this.agx.boc() + 1);
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
        this.eVX = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajL = 11;
        this.eWn = false;
        this.eWo = true;
        this.eWp = true;
        this.eWq = true;
        this.eWr = false;
        this.eWs = false;
        this.eWt = true;
        this.eWu = false;
        this.eWv = true;
        this.eWw = false;
        this.eWx = true;
        this.mFrom = 2;
        this.eWy = 1;
        this.mSkinType = 3;
        this.eWF = null;
        this.eWH = true;
        this.eWI = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
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
                                ThreadCommentAndPraiseInfoLayout.this.agx.oj(bwVar.bmr());
                                ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agx.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agx.oj(bwVar.bmr());
                            ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                        }
                    }
                }
            }
        };
        this.eWJ = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agx != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agx.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agx.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agx.bnR() || ThreadCommentAndPraiseInfoLayout.this.agx.bnU()) && ThreadCommentAndPraiseInfoLayout.this.agx.bmU() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agx.bmU() != null && ThreadCommentAndPraiseInfoLayout.this.agx.bmU().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agx.bmU().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agx.dk(ThreadCommentAndPraiseInfoLayout.this.agx.boc() + 1);
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
        this.eWE = R.drawable.icon_home_card_share;
        this.eWD = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.eVX = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aOm();
    }

    protected void aOm() {
        al(ef(this.mContext));
    }

    protected void al(View view) {
        this.aiP = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.eVY = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.ewm = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.eWa = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.eWb = view.findViewById(R.id.thread_info_commont_container);
        this.eWc = (TextView) view.findViewById(R.id.share_num);
        this.eWd = (ImageView) view.findViewById(R.id.share_num_img);
        this.eWe = view.findViewById(R.id.share_num_container);
        this.eWf = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.eWg = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.eVZ = (AgreeView) findViewById;
            this.eVZ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.eWC != null) {
                        ThreadCommentAndPraiseInfoLayout.this.eWC.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.agx);
                }
            });
        }
        this.eWj = view.findViewById(R.id.manage_view_container);
        this.eWh = (TextView) view.findViewById(R.id.thread_info_manage_text);
        this.eWi = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.dcg = (ImageView) view.findViewById(R.id.manage_select_img);
        this.eWl = (TextView) view.findViewById(R.id.manage_select_text);
        this.eWm = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.eWm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.dcg.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.eWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dcg.performClick();
            }
        });
        this.eWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dcg.performClick();
            }
        });
        this.eWb.setOnClickListener(this);
        this.eWe.setOnClickListener(this);
        this.eWj.setOnClickListener(this);
        this.dcg.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.ajL = i;
        uk();
    }

    private void uk() {
        int i;
        this.eWe.setVisibility(isShow(1) ? 0 : 8);
        this.eWb.setVisibility(isShow(2) ? 0 : 8);
        View view = this.eWj;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.eVZ.setVisibility(isShow(8) ? 0 : 8);
        this.eVZ.setAgreeAlone(isShow(32));
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
            bq(view);
        } else if (view == this.eWb) {
            bn(view);
        } else if (view == this.eWe) {
            bo(view);
        } else if (view == this.eWg) {
            bs(view);
        } else if (view == this.eWj) {
            br(view);
        } else if (view == this.dcg) {
            bp(view);
        }
    }

    protected void bp(View view) {
        if (this.dcg != null && this.agx != null && this.eWl != null && !this.agx.bon()) {
            if (!this.agx.bol() && com.baidu.tieba.frs.b.cxm().cxg()) {
                if (com.baidu.tieba.frs.b.cxm().aj(this.agx)) {
                    this.agx.iQ(true);
                }
            } else if (!this.agx.bom() && com.baidu.tieba.frs.a.cxf().cxg()) {
                if (com.baidu.tieba.frs.a.cxf().aj(this.agx)) {
                    this.agx.iR(true);
                }
            } else {
                com.baidu.tieba.frs.b.cxm().ak(this.agx);
                this.agx.iQ(false);
                com.baidu.tieba.frs.a.cxf().ak(this.agx);
                this.agx.iR(false);
            }
            ap.setViewTextColor(this.eWl, (this.agx.bol() || this.agx.bom()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.dcg.setImageDrawable(ap.getDrawable((this.agx.bol() || this.agx.bom()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.eWF != null) {
                this.eWF.js(this.agx.bol() || this.agx.bom());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.eWb != null) {
            this.eWb.setClickable(z);
            this.eWa.setEnabled(z);
            this.ewm.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.eWe != null) {
            this.eWe.setClickable(z);
            this.eWd.setEnabled(z);
            this.eWc.setEnabled(z);
        }
    }

    private void bq(View view) {
        if (this.agx != null && !StringUtils.isNull(this.agx.bmE())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.eWB)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.agx.bmE(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.agx.bmE(), this.mStType, this.eWB)));
            }
            if (this.eWC != null) {
                this.eWC.onClick(view);
            }
        }
    }

    private boolean w(bw bwVar) {
        return (bwVar == null || !bwVar.blg() || bwVar.bmS() == null) ? false : true;
    }

    protected void bn(View view) {
        if (this.agx != null && this.mContext != null) {
            n.IZ(this.agx.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.agx, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.agx.getFid()));
            addLocateParam.setForumName(this.agx.bmE());
            if (this.agx.bop() && this.agx.boo() != null) {
                addLocateParam.setForumId(this.agx.boo().getForumId());
                addLocateParam.setForumName(this.agx.boo().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.eWG != null) {
                this.eWG.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.agx)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.al(this.agx);
            }
            if (this.agx.eGL) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.agx.bnH() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.eWz);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            aq aqVar = new aq("c12291");
            aqVar.al("obj_locate", this.mFrom);
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12942");
            aqVar2.al("obj_locate", this.mFrom);
            aqVar2.al("obj_type", getThreadType());
            aqVar2.dR("tid", this.agx.getTid());
            aqVar2.dR("nid", this.agx.getNid());
            if (this.mFrom == 18) {
                aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.w("fid", this.agx.getFid());
                aqVar2.al("obj_locate", 18);
                aqVar2.dR("resource_id", this.mTabName);
            }
            TiebaStatic.log(aqVar2);
            bsQ();
            a(view, this.agx);
            if (this.eWC != null) {
                this.eWC.onClick(view);
            }
        }
    }

    private void bsQ() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            aq aqVar = new aq("c13568");
            aqVar.al("obj_source", threadSourceForDynamicAndBjh);
            aqVar.al("obj_type", threadTypeForDynamicAndBjh);
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
        if (this.agx.bli()) {
            return 1;
        }
        if (this.agx.blj()) {
            return 2;
        }
        if (this.agx.bov()) {
            return 3;
        }
        return this.agx.bow() ? 4 : 0;
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
        if (this.agx.bmS() != null) {
            return 1;
        }
        if (this.agx.getType() == bw.eDA || this.agx.getType() == bw.eDV) {
            if (y.getCount(this.agx.bmN()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.agx != null || i >= 0) {
            aq pY = pY(i);
            pY.al("thread_type", this.agx.getThreadType());
            TiebaStatic.log(pY);
        }
    }

    private aq pY(int i) {
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
        aqVar.al("obj_locate", this.mFrom);
        aqVar.al("obj_id", i);
        if (!at.isEmpty(this.eWA)) {
            aqVar.dR("obj_floor", this.eWA);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        aqVar.dR("nid", this.agx.getNid());
        aqVar.al(IntentConfig.CARD_TYPE, this.agx.boz());
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

    protected void bo(View view) {
        if ((ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) && this.agx != null) {
            bsR();
            a(view, this.agx);
            if (!AntiHelper.d(getContext(), this.agx)) {
                bsT();
                if (this.eWC != null) {
                    this.eWC.onClick(view);
                }
            }
        }
    }

    private void bsR() {
        if (this.agx != null) {
            aq bsS = bsS();
            bsS.al("thread_type", this.agx.getThreadType());
            TiebaStatic.log(bsS);
        }
    }

    private aq bsS() {
        if (this.agx == null) {
            return null;
        }
        int i = 0;
        if (this.eWy == 1) {
            i = 4;
        } else if (this.eWy == 2) {
            i = 5;
        } else if (this.eWy == 3) {
            i = 3;
        } else if (this.eWy == 4) {
            i = 2;
        } else if (this.eWy == 6) {
            i = 8;
        } else if (this.eWy == 7) {
            i = 9;
        } else if (this.eWy == 9) {
            i = 10;
        } else if (this.eWy == 10) {
            i = 17;
        } else if (this.eWy == 18) {
            i = 20;
        }
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.w("fid", this.agx.getFid());
        aqVar.dR("tid", this.agx.getTid());
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.al("obj_locate", i);
        aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, this.eQW);
        if (!at.isEmpty(this.eWA)) {
            aqVar.dR("obj_floor", this.eWA);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.agx.bmU() != null && this.agx.bmU().user_info != null && this.agx.bmU().user_info.is_official == 2) {
            aqVar.al("obj_isofficial", this.agx.bmU().user_info.is_official);
        }
        aqVar.al(IntentConfig.CARD_TYPE, this.agx.boz()).dR("ab_tag", this.agx.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.agx.mRecomSource).dR("weight", this.agx.mRecomWeight).dR("extra", this.agx.mRecomExtra);
        if (this.agx.bli()) {
            aqVar.al("obj_type", 10);
        } else if (this.agx.blj()) {
            aqVar.al("obj_type", 9);
        } else if (this.agx.bow()) {
            aqVar.al("obj_type", 8);
        } else if (this.agx.bov()) {
            aqVar.al("obj_type", 7);
        } else if (this.agx.isShareThread) {
            aqVar.al("obj_type", 6);
        } else if (this.agx.threadType == 0) {
            aqVar.al("obj_type", 1);
        } else if (this.agx.threadType == 40) {
            aqVar.al("obj_type", 2);
        } else if (this.agx.threadType == 49) {
            aqVar.al("obj_type", 3);
        } else if (this.agx.threadType == 54) {
            aqVar.al("obj_type", 4);
        } else {
            aqVar.al("obj_type", 5);
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
            if (this.agx.blj() || this.agx.bow()) {
                aqVar.dR("obj_param6", this.agx.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.agx.bou()) {
            aqVar.al("obj_param5", 2);
        } else if (this.agx.bli() || this.agx.blj()) {
            aqVar.al("obj_param5", 3);
        } else if (this.agx.threadType == 0 || this.agx.threadType == 40) {
            aqVar.al("obj_param5", 1);
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

    private void bsT() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.agx != null && this.mContext != null) {
            String valueOf = String.valueOf(this.agx.getFid());
            String bmE = this.agx.bmE();
            if (this.agx.eGy != null) {
                valueOf = this.agx.eGy.id;
                bmE = this.agx.eGy.ori_fname;
            }
            String title = this.agx.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.agx.getAbstract();
            }
            if (this.agx.blk()) {
                tid = this.agx.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.agx.getBaijiahaoData().oriUgcType + "&dvid=" + this.agx.getBaijiahaoData().oriUgcVid + "&nid=" + this.agx.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.agx.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            boolean z = true;
            if (this.agx.bmU() != null && this.agx.bmU().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.agx.bmU().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.agx.bmU().user_info.user_name, "utf-8");
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
            if (!this.agx.blk() || this.agx.bmA() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.agx.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.agx.bmA().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = at.cutString(title, 100);
            String cutString2 = at.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(this.agx);
            if (this.agx.blk()) {
                shareItem.readCount = -1L;
                shareItem.fgU = cutString2;
            } else {
                if (stateThreadType == 2 && this.agx.bmS() != null) {
                    shareItem.readCount = this.agx.bmS().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = this.agx.bms();
                }
                shareItem.fgU = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = bmE;
            shareItem.tid = tid;
            shareItem.fgJ = true;
            shareItem.eHo = this.eWy;
            shareItem.fgW = getShareObjSource();
            shareItem.fhb = stateThreadType;
            shareItem.fgX = 3;
            shareItem.fgY = getShareObjParam2(this.agx);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.agx.blk()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.fhl = this.agx.getShareImageUrl();
            }
            bsU();
            shareItem.fhe = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agx);
            if (this.mFrom == 13) {
                shareItem.fhf = ShareItem.ForwardInfo.generateForwardInfo(this.agx, 2);
            } else {
                shareItem.fhf = ShareItem.ForwardInfo.generateForwardInfo(this.agx);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fgX);
            bundle.putInt("obj_type", shareItem.fhb);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eHo);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.agx.getThreadType() == 49 || this.agx.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.f.cpv().b(shareDialogConfig);
        }
    }

    private void bsU() {
        ItemInfo cxB;
        if ((this.mContext instanceof ao) && ((ao) this.mContext).cxC() && this.agx != null && this.agx.boD() == null && (cxB = ((ao) this.mContext).cxB()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cxB.id.longValue());
            builder.item_name = cxB.name;
            builder.icon_size = cxB.icon_size;
            builder.icon_url = cxB.icon_url;
            builder.tags = cxB.tags;
            if (cxB.score != null && cxB.score.item_point != null) {
                Iterator<ItemPoint> it = cxB.score.item_point.iterator();
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
        if (bwVar.bli()) {
            return 10;
        }
        if (bwVar.blj()) {
            return 9;
        }
        if (bwVar.bow()) {
            return 8;
        }
        if (bwVar.bov()) {
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
        if (this.eWy == 1) {
            return 5;
        }
        if (this.eWy != 3) {
            if (this.eWy == 4) {
                return 4;
            }
            if (this.eWy == 6) {
                return 8;
            }
            if (this.eWy != 10) {
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
        if (bwVar.bmU() != null && !TextUtils.isEmpty(bwVar.bmU().cover)) {
            return bwVar.bmU().cover;
        }
        if (bwVar.bmJ() == null) {
            return null;
        }
        ArrayList<MediaData> bmJ = bwVar.bmJ();
        int size = bmJ.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bmJ.get(i);
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
        if (str == null && bwVar.bmS() != null && !TextUtils.isEmpty(bwVar.bmS().thumbnail_url)) {
            return bwVar.bmS().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.bmC()) {
                return 4;
            }
            if (bwVar.bmx() == 1) {
                return 3;
            }
            if (bwVar.bli()) {
                return 5;
            }
            if (bwVar.blj()) {
                return 6;
            }
            if (bwVar.bov()) {
                return 7;
            }
            if (bwVar.bow()) {
                return 8;
            }
            if (!bwVar.isShareThread || bwVar.eGn == null) {
                return bwVar.bnS() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void br(View view) {
        if (this.eWk == null) {
            this.eWk = new ac(this.mPageContext, isShow(16));
        }
        this.eWk.setData(this.agx);
        this.eWk.Qj();
        if (this.agx != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.agx.getFid()).dR("tid", this.agx.getId()));
        }
    }

    private void bs(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.eWq = z;
        if (this.aiP != null) {
            this.aiP.setClickable(this.eWq);
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
        ahV();
        B(bwVar);
        D(bwVar);
        A(bwVar);
        z(bwVar);
        updatePraiseNum(bwVar);
        C(bwVar);
        E(bwVar);
        setVisibility(this.eWn ? 0 : 8);
        bsO();
        return this.eWn;
    }

    protected void bsO() {
    }

    protected void ahV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bw bwVar) {
        this.aiP.setVisibility(8);
    }

    protected void C(bw bwVar) {
        if (this.eWm != null && this.dcg != null && this.eWl != null && bwVar != null) {
            if (!this.eWH) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.eWm.setVisibility(8);
            } else if (this.eWx && (com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.dcg.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.dcg.performClick();
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
                ap.setViewTextColor(this.eWl, (this.agx.bol() || this.agx.bom()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.dcg.setImageDrawable(ap.getDrawable((bwVar.bol() || this.agx.bom()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.eWm.setVisibility(4);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.eWm.setVisibility(8);
            }
        }
    }

    private void D(bw bwVar) {
        String bmd;
        if (this.eVY != null && bwVar != null) {
            if (bwVar.bmt() <= 0 || !this.eWo) {
                this.eVY.setVisibility(8);
                return;
            }
            this.eVY.setVisibility(0);
            if (this.mFrom == 3) {
                bmd = bwVar.bme();
            } else {
                bmd = bwVar.bmd();
            }
            this.eVY.setText(bmd);
            this.eWn = true;
        }
    }

    public boolean isVisible() {
        return this.eWn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bw bwVar) {
        if (this.ewm != null && bwVar != null) {
            if (this.eWt) {
                this.eWb.setVisibility(0);
                if (bwVar.bmr() > 0) {
                    this.ewm.setVisibility(0);
                    String numFormatOverWan = at.numFormatOverWan(bwVar.bmr());
                    if (this.eWr) {
                        updateReplyStateUI();
                        this.ewm.setText(numFormatOverWan);
                    } else {
                        this.ewm.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.ewm.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.eWn = true;
                    return;
                } else if (this.eWr) {
                    updateReplyStateUI();
                    this.ewm.setText(this.mContext.getString(R.string.action_comment_default));
                    this.ewm.setVisibility(0);
                    this.eWn = true;
                    return;
                } else {
                    this.ewm.setVisibility(8);
                    return;
                }
            }
            this.eWb.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.eWr) {
            SvgManager.brn().a(this.eWa, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.ewm, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bw bwVar) {
        setAgreeViewType(bwVar);
        if (bwVar.bor() != null) {
            bwVar.bor().isInThread = true;
            this.eVZ.setCardType(bwVar.boz());
            this.eVZ.setThreadData(bwVar);
            this.eVZ.setData(bwVar.bor());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(bw bwVar) {
        if (this.eWe != null && this.eWc != null && bwVar != null) {
            if (this.eWv) {
                this.eWe.setVisibility(0);
                long boc = bwVar.boc();
                if ((bwVar.bnR() || bwVar.bnU()) && bwVar.bmU() != null && bwVar.bmU().share_info != null) {
                    boc = bwVar.bmU().share_info.share_count;
                }
                this.eWc.setText(boc > 0 ? at.numFormatOverWan(boc) : this.mContext.getString(R.string.share));
                this.eWn = true;
                updateShareStateUI(bwVar);
                return;
            }
            this.eWe.setVisibility(8);
        }
    }

    public void updateShareStateUI(bw bwVar) {
        if (AntiHelper.aZ(bwVar)) {
            setShareClickable(true);
            SvgManager.brn().a(this.eWd, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.eWc, R.color.cp_cont_e);
        } else if (bwVar != null && bwVar.eGn != null && this.agx.eGn.eAQ) {
            setShareClickable(false);
            SvgManager.brn().a(this.eWd, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.eWc, R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.brn().a(this.eWd, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.eWc, R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void E(bw bwVar) {
        if (this.eWj != null && bwVar != null) {
            this.eWw = isShow(4);
            if (bwVar.eGy != null) {
                this.eWw = false;
            }
            if (this.eWw && (this.eWm == null || this.eWm.getVisibility() == 8)) {
                this.eWj.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.eWh.setText(string);
                this.eWh.setContentDescription(string);
                this.eWn = true;
                return;
            }
            this.eWj.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        if (this.eVZ != null) {
            this.eVZ.setStatisticData(cVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.aiP, R.color.cp_cont_d);
            ap.setViewTextColor(this.eVY, R.color.cp_cont_j);
            ap.setViewTextColor(this.eWh, R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.agx);
            SvgManager.brn().a(this.eWg, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.brn().a(this.eWi, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.eWk != null) {
                this.eWk.onChangeSkinType();
            }
            if (this.eVZ != null) {
                this.eVZ.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eWC = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aiP;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.eWu = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.eWo = z;
    }

    public View getCommentNumView() {
        return this.ewm;
    }

    public View getCommentContainer() {
        return this.eWb;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.eWr = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.eWs = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.eWv = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWa.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.eWa.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.eWv = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWa.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.eWa.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.eWx = z;
    }

    public void setManageVisible(boolean z) {
        this.eWw = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.eWF = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.dcg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.eWH = z;
    }

    public boolean isInFrsAllThread() {
        return this.eWH;
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
        if (this.eWk != null) {
            this.eWk.destory();
        }
    }

    public void setAgreeViewType(bw bwVar) {
        if (bwVar != null && bwVar.blk()) {
            this.eVZ.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.eVZ.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.eWG = aVar;
    }
}
