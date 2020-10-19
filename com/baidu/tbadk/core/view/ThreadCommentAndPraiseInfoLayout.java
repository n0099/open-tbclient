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
/* loaded from: classes21.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bw agw;
    protected TextView aiO;
    private int ajK;
    protected ImageView cNQ;
    private int eCL;
    protected int eHM;
    private TextView eHN;
    protected AgreeView eHO;
    protected ImageView eHP;
    protected View eHQ;
    protected TextView eHR;
    protected ImageView eHS;
    protected View eHT;
    protected FrameLayout eHU;
    protected ImageView eHV;
    protected TextView eHW;
    protected ImageView eHX;
    protected View eHY;
    protected ab eHZ;
    protected TextView eIa;
    protected LinearLayout eIb;
    protected boolean eIc;
    protected boolean eId;
    protected boolean eIe;
    protected boolean eIf;
    protected boolean eIg;
    protected boolean eIh;
    protected boolean eIi;
    protected boolean eIj;
    protected boolean eIk;
    protected boolean eIl;
    protected boolean eIm;
    private int eIn;
    public int eIo;
    public String eIp;
    private String eIq;
    private View.OnClickListener eIr;
    protected int eIs;
    protected int eIt;
    private b eIu;
    private a eIv;
    private boolean eIw;
    CustomMessageListener eIx;
    CustomMessageListener eIy;
    protected TextView ehV;
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
        void iW(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.eIq = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.eHO != null) {
            this.eHO.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.eIn = i;
    }

    public void setGameId(int i) {
        this.eCL = i;
        if (this.eHO != null) {
            this.eHO.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.eHO != null) {
            this.eHO.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eIx);
        MessageManager.getInstance().registerListener(this.eIy);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eIx);
        MessageManager.getInstance().unRegisterListener(this.eIy);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.eHM = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajK = 11;
        this.eIc = false;
        this.eId = true;
        this.eIe = true;
        this.eIf = true;
        this.eIg = false;
        this.eIh = false;
        this.eIi = true;
        this.eIj = false;
        this.eIk = true;
        this.eIl = false;
        this.eIm = true;
        this.mFrom = 2;
        this.eIn = 1;
        this.mSkinType = 3;
        this.eIu = null;
        this.eIw = true;
        this.eIx = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.agw != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.agw.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.agw.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.agw.nO(bwVar.bhY());
                                ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agw.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agw.nO(bwVar.bhY());
                            ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                        }
                    }
                }
            }
        };
        this.eIy = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agw != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agw.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agw.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agw.bjy() || ThreadCommentAndPraiseInfoLayout.this.agw.bjB()) && ThreadCommentAndPraiseInfoLayout.this.agw.biB() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agw.biB() != null && ThreadCommentAndPraiseInfoLayout.this.agw.biB().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agw.biB().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agw.cM(ThreadCommentAndPraiseInfoLayout.this.agw.bjJ() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.z(ThreadCommentAndPraiseInfoLayout.this.agw);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHM = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajK = 11;
        this.eIc = false;
        this.eId = true;
        this.eIe = true;
        this.eIf = true;
        this.eIg = false;
        this.eIh = false;
        this.eIi = true;
        this.eIj = false;
        this.eIk = true;
        this.eIl = false;
        this.eIm = true;
        this.mFrom = 2;
        this.eIn = 1;
        this.mSkinType = 3;
        this.eIu = null;
        this.eIw = true;
        this.eIx = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.agw != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.agw.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.agw.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.agw.nO(bwVar.bhY());
                                ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agw.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agw.nO(bwVar.bhY());
                            ThreadCommentAndPraiseInfoLayout.this.A(bwVar);
                        }
                    }
                }
            }
        };
        this.eIy = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agw != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agw.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agw.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agw.bjy() || ThreadCommentAndPraiseInfoLayout.this.agw.bjB()) && ThreadCommentAndPraiseInfoLayout.this.agw.biB() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agw.biB() != null && ThreadCommentAndPraiseInfoLayout.this.agw.biB().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agw.biB().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agw.cM(ThreadCommentAndPraiseInfoLayout.this.agw.bjJ() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.z(ThreadCommentAndPraiseInfoLayout.this.agw);
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
        this.eIt = R.drawable.icon_home_card_share;
        this.eIs = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.eHM = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aJS();
    }

    protected void aJS() {
        an(ef(this.mContext));
    }

    protected void an(View view) {
        this.aiO = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.eHN = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.ehV = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.eHP = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.eHQ = view.findViewById(R.id.thread_info_commont_container);
        this.eHR = (TextView) view.findViewById(R.id.share_num);
        this.eHS = (ImageView) view.findViewById(R.id.share_num_img);
        this.eHT = view.findViewById(R.id.share_num_container);
        this.eHU = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.eHV = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.eHO = (AgreeView) findViewById;
            this.eHO.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.eIr != null) {
                        ThreadCommentAndPraiseInfoLayout.this.eIr.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.agw);
                }
            });
        }
        this.eHY = view.findViewById(R.id.manage_view_container);
        this.eHW = (TextView) view.findViewById(R.id.thread_info_manage_text);
        this.eHX = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.cNQ = (ImageView) view.findViewById(R.id.manage_select_img);
        this.eIa = (TextView) view.findViewById(R.id.manage_select_text);
        this.eIb = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.eIb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cNQ.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.eIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.cNQ.performClick();
            }
        });
        this.eIb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.cNQ.performClick();
            }
        });
        this.eHQ.setOnClickListener(this);
        this.eHT.setOnClickListener(this);
        this.eHY.setOnClickListener(this);
        this.cNQ.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.ajK = i;
        uk();
    }

    private void uk() {
        int i;
        this.eHT.setVisibility(isShow(1) ? 0 : 8);
        this.eHQ.setVisibility(isShow(2) ? 0 : 8);
        View view = this.eHY;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.eHO.setVisibility(isShow(8) ? 0 : 8);
        this.eHO.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.ajK & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aiO) {
            bl(view);
        } else if (view == this.eHQ) {
            bi(view);
        } else if (view == this.eHT) {
            bj(view);
        } else if (view == this.eHV) {
            bn(view);
        } else if (view == this.eHY) {
            bm(view);
        } else if (view == this.cNQ) {
            bk(view);
        }
    }

    protected void bk(View view) {
        if (this.cNQ != null && this.agw != null && this.eIa != null && !this.agw.bjU()) {
            if (!this.agw.bjS() && com.baidu.tieba.frs.b.crE().cry()) {
                if (com.baidu.tieba.frs.b.crE().aj(this.agw)) {
                    this.agw.iu(true);
                }
            } else if (!this.agw.bjT() && com.baidu.tieba.frs.a.crx().cry()) {
                if (com.baidu.tieba.frs.a.crx().aj(this.agw)) {
                    this.agw.iv(true);
                }
            } else {
                com.baidu.tieba.frs.b.crE().ak(this.agw);
                this.agw.iu(false);
                com.baidu.tieba.frs.a.crx().ak(this.agw);
                this.agw.iv(false);
            }
            ap.setViewTextColor(this.eIa, (this.agw.bjS() || this.agw.bjT()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cNQ.setImageDrawable(ap.getDrawable((this.agw.bjS() || this.agw.bjT()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.eIu != null) {
                this.eIu.iW(this.agw.bjS() || this.agw.bjT());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.eHQ != null) {
            this.eHQ.setClickable(z);
            this.eHP.setEnabled(z);
            this.ehV.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.eHT != null) {
            this.eHT.setClickable(z);
            this.eHS.setEnabled(z);
            this.eHR.setEnabled(z);
        }
    }

    private void bl(View view) {
        if (this.agw != null && !StringUtils.isNull(this.agw.bil())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.eIq)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.agw.bil(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.agw.bil(), this.mStType, this.eIq)));
            }
            if (this.eIr != null) {
                this.eIr.onClick(view);
            }
        }
    }

    private boolean w(bw bwVar) {
        return (bwVar == null || !bwVar.bgN() || bwVar.biz() == null) ? false : true;
    }

    protected void bi(View view) {
        if (this.agw != null && this.mContext != null) {
            m.Ij(this.agw.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.agw, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.agw.getFid()));
            addLocateParam.setForumName(this.agw.bil());
            if (this.agw.bjW() && this.agw.bjV() != null) {
                addLocateParam.setForumId(this.agw.bjV().getForumId());
                addLocateParam.setForumName(this.agw.bjV().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.eIv != null) {
                this.eIv.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.agw)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.al(this.agw);
            }
            if (this.agw.esw) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.agw.bjo() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.eIo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            aq aqVar = new aq("c12291");
            aqVar.aj("obj_locate", this.mFrom);
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12942");
            aqVar2.aj("obj_locate", this.mFrom);
            aqVar2.aj("obj_type", getThreadType());
            aqVar2.dK("tid", this.agw.getTid());
            aqVar2.dK("nid", this.agw.getNid());
            if (this.mFrom == 18) {
                aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.u("fid", this.agw.getFid());
                aqVar2.aj("obj_locate", 18);
                aqVar2.dK("resource_id", this.mTabName);
            }
            TiebaStatic.log(aqVar2);
            box();
            a(view, this.agw);
            if (this.eIr != null) {
                this.eIr.onClick(view);
            }
        }
    }

    private void box() {
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
        if (this.agw == null) {
            return 0;
        }
        if (this.agw.bgP()) {
            return 1;
        }
        if (this.agw.bgQ()) {
            return 2;
        }
        if (this.agw.bkc()) {
            return 3;
        }
        return this.agw.bkd() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.agw == null) {
            return 0;
        }
        if (this.agw.isShareThread) {
            return 4;
        }
        if (this.agw.getThreadType() == 49) {
            return 5;
        }
        if (this.agw.biz() != null) {
            return 1;
        }
        if (this.agw.getType() == bw.epl || this.agw.getType() == bw.epG) {
            if (y.getCount(this.agw.biu()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.agw != null || i >= 0) {
            aq pD = pD(i);
            pD.aj("thread_type", this.agw.getThreadType());
            TiebaStatic.log(pD);
        }
    }

    private aq pD(int i) {
        if (this.agw == null && i < 0) {
            return null;
        }
        aq aqVar = new aq("c12003");
        aqVar.dK("tid", this.agw.getTid());
        if (this.agw.getThreadType() == 40) {
            aqVar.dK("obj_param1", "2");
        } else if (this.agw.getThreadType() == 0) {
            aqVar.dK("obj_param1", "1");
        }
        aqVar.dK("obj_source", "1");
        aqVar.u("fid", this.agw.getFid());
        aqVar.aj("obj_locate", this.mFrom);
        aqVar.aj("obj_id", i);
        if (!at.isEmpty(this.eIp)) {
            aqVar.dK("obj_floor", this.eIp);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dK(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        aqVar.dK("nid", this.agw.getNid());
        aqVar.aj(IntentConfig.CARD_TYPE, this.agw.bkg());
        aqVar.dK(IntentConfig.RECOM_SOURCE, this.agw.mRecomSource);
        aqVar.dK("ab_tag", this.agw.mRecomAbTag);
        aqVar.dK("weight", this.agw.mRecomWeight);
        aqVar.dK("extra", this.agw.mRecomExtra);
        if (this.agw.getBaijiahaoData() != null && !at.isEmpty(this.agw.getBaijiahaoData().oriUgcVid)) {
            aqVar.dK("obj_param6", this.agw.getBaijiahaoData().oriUgcVid);
            return aqVar;
        }
        return aqVar;
    }

    protected void bj(View view) {
        if ((ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) && this.agw != null) {
            boy();
            a(view, this.agw);
            if (!AntiHelper.d(getContext(), this.agw)) {
                boA();
                if (this.eIr != null) {
                    this.eIr.onClick(view);
                }
            }
        }
    }

    private void boy() {
        if (this.agw != null) {
            aq boz = boz();
            boz.aj("thread_type", this.agw.getThreadType());
            TiebaStatic.log(boz);
        }
    }

    private aq boz() {
        if (this.agw == null) {
            return null;
        }
        int i = 0;
        if (this.eIn == 1) {
            i = 4;
        } else if (this.eIn == 2) {
            i = 5;
        } else if (this.eIn == 3) {
            i = 3;
        } else if (this.eIn == 4) {
            i = 2;
        } else if (this.eIn == 6) {
            i = 8;
        } else if (this.eIn == 7) {
            i = 9;
        } else if (this.eIn == 9) {
            i = 10;
        } else if (this.eIn == 10) {
            i = 17;
        } else if (this.eIn == 18) {
            i = 20;
        }
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.u("fid", this.agw.getFid());
        aqVar.dK("tid", this.agw.getTid());
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.aj("obj_locate", i);
        aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, this.eCL);
        if (!at.isEmpty(this.eIp)) {
            aqVar.dK("obj_floor", this.eIp);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.agw.biB() != null && this.agw.biB().user_info != null && this.agw.biB().user_info.is_official == 2) {
            aqVar.aj("obj_isofficial", this.agw.biB().user_info.is_official);
        }
        aqVar.aj(IntentConfig.CARD_TYPE, this.agw.bkg()).dK("ab_tag", this.agw.mRecomAbTag).dK(IntentConfig.RECOM_SOURCE, this.agw.mRecomSource).dK("weight", this.agw.mRecomWeight).dK("extra", this.agw.mRecomExtra);
        if (this.agw.bgP()) {
            aqVar.aj("obj_type", 10);
        } else if (this.agw.bgQ()) {
            aqVar.aj("obj_type", 9);
        } else if (this.agw.bkd()) {
            aqVar.aj("obj_type", 8);
        } else if (this.agw.bkc()) {
            aqVar.aj("obj_type", 7);
        } else if (this.agw.isShareThread) {
            aqVar.aj("obj_type", 6);
        } else if (this.agw.threadType == 0) {
            aqVar.aj("obj_type", 1);
        } else if (this.agw.threadType == 40) {
            aqVar.aj("obj_type", 2);
        } else if (this.agw.threadType == 49) {
            aqVar.aj("obj_type", 3);
        } else if (this.agw.threadType == 54) {
            aqVar.aj("obj_type", 4);
        } else {
            aqVar.aj("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            aqVar.dK("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            aqVar.dK("obj_tab", "a099");
            aqVar.dK("resource_id", this.mTabName);
        }
        if (this.agw.getBaijiahaoData() != null) {
            aqVar.dK("obj_param4", this.agw.getBaijiahaoData().oriUgcNid);
            if (this.agw.bgQ() || this.agw.bkd()) {
                aqVar.dK("obj_param6", this.agw.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.agw.bkb()) {
            aqVar.aj("obj_param5", 2);
        } else if (this.agw.bgP() || this.agw.bgQ()) {
            aqVar.aj("obj_param5", 3);
        } else if (this.agw.threadType == 0 || this.agw.threadType == 40) {
            aqVar.aj("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), aqVar);
        }
        aqVar.dK("nid", this.agw.getNid());
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

    private void boA() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.agw != null && this.mContext != null) {
            String valueOf = String.valueOf(this.agw.getFid());
            String bil = this.agw.bil();
            if (this.agw.esj != null) {
                valueOf = this.agw.esj.id;
                bil = this.agw.esj.ori_fname;
            }
            String title = this.agw.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.agw.getAbstract();
            }
            if (this.agw.bgR()) {
                tid = this.agw.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.agw.getBaijiahaoData().oriUgcType + "&dvid=" + this.agw.getBaijiahaoData().oriUgcVid + "&nid=" + this.agw.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.agw.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            boolean z = true;
            if (this.agw.biB() != null && this.agw.biB().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.agw.biB().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.agw.biB().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(this.agw);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = this.agw.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.agw.bgR() || this.agw.bih() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.agw.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.agw.bih().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = at.cutString(title, 100);
            String cutString2 = at.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(this.agw);
            if (this.agw.bgR()) {
                shareItem.readCount = -1L;
                shareItem.eSH = cutString2;
            } else {
                if (stateThreadType == 2 && this.agw.biz() != null) {
                    shareItem.readCount = this.agw.biz().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = this.agw.bhZ();
                }
                shareItem.eSH = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = bil;
            shareItem.tid = tid;
            shareItem.eSw = true;
            shareItem.esZ = this.eIn;
            shareItem.eSJ = getShareObjSource();
            shareItem.eSO = stateThreadType;
            shareItem.eSK = 3;
            shareItem.eSL = getShareObjParam2(this.agw);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.agw.bgR()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.eSY = this.agw.getShareImageUrl();
            }
            boB();
            shareItem.eSR = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agw);
            if (this.mFrom == 13) {
                shareItem.eSS = ShareItem.ForwardInfo.generateForwardInfo(this.agw, 2);
            } else {
                shareItem.eSS = ShareItem.ForwardInfo.generateForwardInfo(this.agw);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eSK);
            bundle.putInt("obj_type", shareItem.eSO);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.esZ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.agw.getThreadType() == 49 || this.agw.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.f.cjN().b(shareDialogConfig);
        }
    }

    private void boB() {
        ItemInfo crT;
        if ((this.mContext instanceof ao) && ((ao) this.mContext).crU() && this.agw != null && this.agw.bkk() == null && (crT = ((ao) this.mContext).crT()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(crT.id.longValue());
            builder.item_name = crT.name;
            builder.icon_size = crT.icon_size;
            builder.icon_url = crT.icon_url;
            builder.tags = crT.tags;
            if (crT.score != null && crT.score.item_point != null) {
                Iterator<ItemPoint> it = crT.score.item_point.iterator();
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
            this.agw.a(itemData);
        }
    }

    private int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bgP()) {
            return 10;
        }
        if (bwVar.bgQ()) {
            return 9;
        }
        if (bwVar.bkd()) {
            return 8;
        }
        if (bwVar.bkc()) {
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
        if (this.eIn == 1) {
            return 5;
        }
        if (this.eIn != 3) {
            if (this.eIn == 4) {
                return 4;
            }
            if (this.eIn == 6) {
                return 8;
            }
            if (this.eIn != 10) {
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
        if (bwVar.biB() != null && !TextUtils.isEmpty(bwVar.biB().cover)) {
            return bwVar.biB().cover;
        }
        if (bwVar.biq() == null) {
            return null;
        }
        ArrayList<MediaData> biq = bwVar.biq();
        int size = biq.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = biq.get(i);
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
        if (str == null && bwVar.biz() != null && !TextUtils.isEmpty(bwVar.biz().thumbnail_url)) {
            return bwVar.biz().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.bij()) {
                return 4;
            }
            if (bwVar.bie() == 1) {
                return 3;
            }
            if (bwVar.bgP()) {
                return 5;
            }
            if (bwVar.bgQ()) {
                return 6;
            }
            if (bwVar.bkc()) {
                return 7;
            }
            if (bwVar.bkd()) {
                return 8;
            }
            if (!bwVar.isShareThread || bwVar.erY == null) {
                return bwVar.bjz() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bm(View view) {
        if (this.eHZ == null) {
            this.eHZ = new ab(this.mPageContext, isShow(16));
        }
        this.eHZ.setData(this.agw);
        this.eHZ.Pd();
        if (this.agw != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).u("uid", TbadkCoreApplication.getCurrentAccountId()).u("fid", this.agw.getFid()).dK("tid", this.agw.getId()));
        }
    }

    private void bn(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.eIf = z;
        if (this.aiO != null) {
            this.aiO.setClickable(this.eIf);
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
        this.agw = bwVar;
        adB();
        B(bwVar);
        D(bwVar);
        A(bwVar);
        z(bwVar);
        updatePraiseNum(bwVar);
        C(bwVar);
        E(bwVar);
        setVisibility(this.eIc ? 0 : 8);
        bov();
        return this.eIc;
    }

    protected void bov() {
    }

    protected void adB() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bw bwVar) {
        this.aiO.setVisibility(8);
    }

    protected void C(bw bwVar) {
        if (this.eIb != null && this.cNQ != null && this.eIa != null && bwVar != null) {
            if (!this.eIw) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.eIb.setVisibility(8);
            } else if (this.eIm && (com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cNQ.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cNQ.performClick();
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
                ap.setViewTextColor(this.eIa, (this.agw.bjS() || this.agw.bjT()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cNQ.setImageDrawable(ap.getDrawable((bwVar.bjS() || this.agw.bjT()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.eIb.setVisibility(4);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.eIb.setVisibility(8);
            }
        }
    }

    private void D(bw bwVar) {
        String bhK;
        if (this.eHN != null && bwVar != null) {
            if (bwVar.bia() <= 0 || !this.eId) {
                this.eHN.setVisibility(8);
                return;
            }
            this.eHN.setVisibility(0);
            if (this.mFrom == 3) {
                bhK = bwVar.bhL();
            } else {
                bhK = bwVar.bhK();
            }
            this.eHN.setText(bhK);
            this.eIc = true;
        }
    }

    public boolean isVisible() {
        return this.eIc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bw bwVar) {
        if (this.ehV != null && bwVar != null) {
            if (this.eIi) {
                this.eHQ.setVisibility(0);
                if (bwVar.bhY() > 0) {
                    this.ehV.setVisibility(0);
                    String numFormatOverWan = at.numFormatOverWan(bwVar.bhY());
                    if (this.eIg) {
                        updateReplyStateUI();
                        this.ehV.setText(numFormatOverWan);
                    } else {
                        this.ehV.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.ehV.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.eIc = true;
                    return;
                } else if (this.eIg) {
                    updateReplyStateUI();
                    this.ehV.setText(this.mContext.getString(R.string.action_comment_default));
                    this.ehV.setVisibility(0);
                    this.eIc = true;
                    return;
                } else {
                    this.ehV.setVisibility(8);
                    return;
                }
            }
            this.eHQ.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.eIg) {
            SvgManager.bmU().a(this.eHP, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.ehV, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bw bwVar) {
        setAgreeViewType(bwVar);
        if (bwVar.bjY() != null) {
            bwVar.bjY().isInThread = true;
            this.eHO.setCardType(bwVar.bkg());
            this.eHO.setThreadData(bwVar);
            this.eHO.setData(bwVar.bjY());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(bw bwVar) {
        if (this.eHT != null && this.eHR != null && bwVar != null) {
            if (this.eIk) {
                this.eHT.setVisibility(0);
                long bjJ = bwVar.bjJ();
                if ((bwVar.bjy() || bwVar.bjB()) && bwVar.biB() != null && bwVar.biB().share_info != null) {
                    bjJ = bwVar.biB().share_info.share_count;
                }
                this.eHR.setText(bjJ > 0 ? at.numFormatOverWan(bjJ) : this.mContext.getString(R.string.share));
                this.eIc = true;
                updateShareStateUI(bwVar);
                return;
            }
            this.eHT.setVisibility(8);
        }
    }

    public void updateShareStateUI(bw bwVar) {
        if (AntiHelper.aZ(bwVar)) {
            setShareClickable(true);
            SvgManager.bmU().a(this.eHS, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.eHR, R.color.cp_cont_e);
        } else if (bwVar != null && bwVar.erY != null && this.agw.erY.emx) {
            setShareClickable(false);
            SvgManager.bmU().a(this.eHS, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.eHR, R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.bmU().a(this.eHS, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.eHR, R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void E(bw bwVar) {
        if (this.eHY != null && bwVar != null) {
            this.eIl = isShow(4);
            if (bwVar.esj != null) {
                this.eIl = false;
            }
            if (this.eIl && (this.eIb == null || this.eIb.getVisibility() == 8)) {
                this.eHY.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.eHW.setText(string);
                this.eHW.setContentDescription(string);
                this.eIc = true;
                return;
            }
            this.eHY.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        if (this.eHO != null) {
            this.eHO.setStatisticData(cVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.aiO, R.color.cp_cont_d);
            ap.setViewTextColor(this.eHN, R.color.cp_cont_j);
            ap.setViewTextColor(this.eHW, R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.agw);
            SvgManager.bmU().a(this.eHV, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.eHX, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.eHZ != null) {
                this.eHZ.onChangeSkinType();
            }
            if (this.eHO != null) {
                this.eHO.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eIr = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aiO;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.eIj = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.eId = z;
    }

    public View getCommentNumView() {
        return this.ehV;
    }

    public View getCommentContainer() {
        return this.eHQ;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.eIg = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.eIh = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.eIk = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eHP.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.eHP.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.eIk = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eHP.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.eHP.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.eIm = z;
    }

    public void setManageVisible(boolean z) {
        this.eIl = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.eIu = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.cNQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.eIw = z;
    }

    public boolean isInFrsAllThread() {
        return this.eIw;
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
        if (this.eHZ != null) {
            this.eHZ.destory();
        }
    }

    public void setAgreeViewType(bw bwVar) {
        if (bwVar != null && bwVar.bgR()) {
            this.eHO.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.eHO.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.eIv = aVar;
    }
}
