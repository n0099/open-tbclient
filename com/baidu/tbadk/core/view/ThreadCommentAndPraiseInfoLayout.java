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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bk aee;
    private int agM;
    protected ImageView ckX;
    private int dRA;
    protected int dVR;
    protected TextView dVS;
    private TextView dVT;
    protected AgreeView dVU;
    protected TextView dVV;
    protected ImageView dVW;
    protected View dVX;
    protected TextView dVY;
    protected ImageView dVZ;
    protected int dWA;
    private b dWB;
    private a dWC;
    private boolean dWD;
    CustomMessageListener dWE;
    CustomMessageListener dWF;
    protected View dWa;
    protected FrameLayout dWb;
    protected ImageView dWc;
    protected TextView dWd;
    protected ImageView dWe;
    protected View dWf;
    protected ab dWg;
    protected TextView dWh;
    protected LinearLayout dWi;
    protected boolean dWj;
    protected boolean dWk;
    protected boolean dWl;
    protected boolean dWm;
    protected boolean dWn;
    protected boolean dWo;
    protected boolean dWp;
    protected boolean dWq;
    protected boolean dWr;
    protected boolean dWs;
    protected boolean dWt;
    private int dWu;
    public int dWv;
    public String dWw;
    private String dWx;
    private View.OnClickListener dWy;
    protected int dWz;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;

    /* loaded from: classes8.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void hp(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.dWx = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.dVU != null) {
            this.dVU.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.dWu = i;
    }

    public void setGameId(int i) {
        this.dRA = i;
        if (this.dVU != null) {
            this.dVU.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.dVU != null) {
            this.dVU.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.dWE);
        MessageManager.getInstance().registerListener(this.dWF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.dWE);
        MessageManager.getInstance().unRegisterListener(this.dWF);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.dVR = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.agM = 11;
        this.dWj = false;
        this.dWk = true;
        this.dWl = true;
        this.dWm = true;
        this.dWn = false;
        this.dWo = false;
        this.dWp = true;
        this.dWq = false;
        this.dWr = true;
        this.dWs = false;
        this.dWt = true;
        this.mFrom = 2;
        this.dWu = 1;
        this.mSkinType = 3;
        this.dWB = null;
        this.dWD = true;
        this.dWE = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bk)) {
                    bk bkVar = (bk) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aee != null && bkVar != null) {
                        String str = bkVar.getBaijiahaoData() != null ? bkVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aee.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aee.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aee.ks(bkVar.aQo());
                                ThreadCommentAndPraiseInfoLayout.this.y(bkVar);
                                return;
                            }
                            return;
                        }
                        String id = bkVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aee.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aee.ks(bkVar.aQo());
                            ThreadCommentAndPraiseInfoLayout.this.y(bkVar);
                        }
                    }
                }
            }
        };
        this.dWF = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aee != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aee.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aee.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aee.aRP() || ThreadCommentAndPraiseInfoLayout.this.aee.aRS()) && ThreadCommentAndPraiseInfoLayout.this.aee.aQS() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aee.aQS() != null && ThreadCommentAndPraiseInfoLayout.this.aee.aQS().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aee.aQS().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aee.cd(ThreadCommentAndPraiseInfoLayout.this.aee.aSa() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.x(ThreadCommentAndPraiseInfoLayout.this.aee);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVR = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.agM = 11;
        this.dWj = false;
        this.dWk = true;
        this.dWl = true;
        this.dWm = true;
        this.dWn = false;
        this.dWo = false;
        this.dWp = true;
        this.dWq = false;
        this.dWr = true;
        this.dWs = false;
        this.dWt = true;
        this.mFrom = 2;
        this.dWu = 1;
        this.mSkinType = 3;
        this.dWB = null;
        this.dWD = true;
        this.dWE = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bk)) {
                    bk bkVar = (bk) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aee != null && bkVar != null) {
                        String str = bkVar.getBaijiahaoData() != null ? bkVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aee.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aee.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aee.ks(bkVar.aQo());
                                ThreadCommentAndPraiseInfoLayout.this.y(bkVar);
                                return;
                            }
                            return;
                        }
                        String id = bkVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aee.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aee.ks(bkVar.aQo());
                            ThreadCommentAndPraiseInfoLayout.this.y(bkVar);
                        }
                    }
                }
            }
        };
        this.dWF = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aee != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aee.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aee.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aee.aRP() || ThreadCommentAndPraiseInfoLayout.this.aee.aRS()) && ThreadCommentAndPraiseInfoLayout.this.aee.aQS() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aee.aQS() != null && ThreadCommentAndPraiseInfoLayout.this.aee.aQS().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aee.aQS().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aee.cd(ThreadCommentAndPraiseInfoLayout.this.aee.aSa() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.x(ThreadCommentAndPraiseInfoLayout.this.aee);
                    }
                }
            }
        };
        init(context);
    }

    protected View dK(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.dWA = R.drawable.icon_home_card_share;
        this.dWz = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.dVR = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aWF();
    }

    protected void aWF() {
        ag(dK(this.mContext));
    }

    protected void ag(View view) {
        this.dVS = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.dVT = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.dVV = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.dVW = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.dVX = view.findViewById(R.id.thread_info_commont_container);
        this.dVY = (TextView) view.findViewById(R.id.share_num);
        this.dVZ = (ImageView) view.findViewById(R.id.share_num_img);
        this.dWa = view.findViewById(R.id.share_num_container);
        this.dWb = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.dWc = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.dVU = (AgreeView) findViewById;
            this.dVU.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.dWy != null) {
                        ThreadCommentAndPraiseInfoLayout.this.dWy.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.aee);
                }
            });
        }
        this.dWf = view.findViewById(R.id.manage_view_container);
        this.dWd = (TextView) view.findViewById(R.id.thread_info_manage_text);
        this.dWe = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.ckX = (ImageView) view.findViewById(R.id.manage_select_img);
        this.dWh = (TextView) view.findViewById(R.id.manage_select_text);
        this.dWi = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.dWi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.ckX.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.dWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.ckX.performClick();
            }
        });
        this.dWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.ckX.performClick();
            }
        });
        this.dVX.setOnClickListener(this);
        this.dWa.setOnClickListener(this);
        this.dWf.setOnClickListener(this);
        this.ckX.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.agM = i;
        rU();
    }

    private void rU() {
        int i;
        this.dWa.setVisibility(isShow(1) ? 0 : 8);
        this.dVX.setVisibility(isShow(2) ? 0 : 8);
        View view = this.dWf;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.dVU.setVisibility(isShow(8) ? 0 : 8);
        this.dVU.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.agM & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dVS) {
            aX(view);
        } else if (view == this.dVX) {
            aU(view);
        } else if (view == this.dWa) {
            aV(view);
        } else if (view == this.dWc) {
            aZ(view);
        } else if (view == this.dWf) {
            aY(view);
        } else if (view == this.ckX) {
            aW(view);
        }
    }

    protected void aW(View view) {
        if (this.ckX != null && this.aee != null && this.dWh != null && !this.aee.aSl()) {
            if (!this.aee.aSk()) {
                if (com.baidu.tieba.frs.a.bTZ().al(this.aee)) {
                    this.aee.gS(true);
                }
            } else {
                com.baidu.tieba.frs.a.bTZ().am(this.aee);
                this.aee.gS(false);
            }
            am.setViewTextColor(this.dWh, this.aee.aSk() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.ckX.setImageDrawable(am.getDrawable(this.aee.aSk() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.dWB != null) {
                this.dWB.hp(this.aee.aSk());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.dVX != null) {
            this.dVX.setClickable(z);
            this.dVW.setEnabled(z);
            this.dVV.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.dWa != null) {
            this.dWa.setClickable(z);
            this.dVZ.setEnabled(z);
            this.dVY.setEnabled(z);
        }
    }

    private void aX(View view) {
        if (this.aee != null && !StringUtils.isNull(this.aee.aQC())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.dWx)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.aee.aQC(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aee.aQC(), this.mStType, this.dWx)));
            }
            if (this.dWy != null) {
                this.dWy.onClick(view);
            }
        }
    }

    private boolean u(bk bkVar) {
        return (bkVar == null || !bkVar.aPk() || bkVar.aQQ() == null) ? false : true;
    }

    protected void aU(View view) {
        if (this.aee != null && this.mContext != null) {
            m.Dn(this.aee.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aee, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aee.getFid()));
            addLocateParam.setForumName(this.aee.aQC());
            if (this.aee.aSn() && this.aee.aSm() != null) {
                addLocateParam.setForumId(this.aee.aSm().getForumId());
                addLocateParam.setForumName(this.aee.aSm().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.dWC != null) {
                this.dWC.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && u(this.aee)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.an(this.aee);
            }
            if (this.aee.dHJ) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.aee.aRF() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.dWv);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.ag("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.ag("obj_locate", this.mFrom);
            anVar2.ag("obj_type", getThreadType());
            anVar2.dh("tid", this.aee.getTid());
            anVar2.dh("nid", this.aee.getNid());
            if (this.mFrom == 18) {
                anVar2.s("uid", TbadkApplication.getCurrentAccountId());
                anVar2.s("fid", this.aee.getFid());
                anVar2.ag("obj_locate", 18);
                anVar2.dh("resource_id", this.mTabName);
            }
            TiebaStatic.log(anVar2);
            aWG();
            a(view, this.aee);
            if (this.dWy != null) {
                this.dWy.onClick(view);
            }
        }
    }

    private void aWG() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            an anVar = new an("c13568");
            anVar.ag("obj_source", threadSourceForDynamicAndBjh);
            anVar.ag("obj_type", threadTypeForDynamicAndBjh);
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
        if (this.aee == null) {
            return 0;
        }
        if (this.aee.aPm()) {
            return 1;
        }
        if (this.aee.aPn()) {
            return 2;
        }
        if (this.aee.aSv()) {
            return 3;
        }
        return this.aee.aSw() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.aee == null) {
            return 0;
        }
        if (this.aee.isShareThread) {
            return 4;
        }
        if (this.aee.getThreadType() == 49) {
            return 5;
        }
        if (this.aee.aQQ() != null) {
            return 1;
        }
        if (this.aee.getType() == bk.dEE || this.aee.getType() == bk.dEU) {
            if (v.getCount(this.aee.aQL()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aee != null || i >= 0) {
            an md = md(i);
            md.ag("thread_type", this.aee.getThreadType());
            TiebaStatic.log(md);
        }
    }

    private an md(int i) {
        if (this.aee == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.dh("tid", this.aee.getTid());
        if (this.aee.getThreadType() == 40) {
            anVar.dh("obj_param1", "2");
        } else if (this.aee.getThreadType() == 0) {
            anVar.dh("obj_param1", "1");
        }
        anVar.dh("obj_source", "1");
        anVar.s("fid", this.aee.getFid());
        anVar.ag("obj_locate", this.mFrom);
        anVar.ag("obj_id", i);
        if (!aq.isEmpty(this.dWw)) {
            anVar.dh("obj_floor", this.dWw);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        anVar.dh("nid", this.aee.getNid());
        anVar.ag(IntentConfig.CARD_TYPE, this.aee.aSA());
        anVar.dh(IntentConfig.RECOM_SOURCE, this.aee.mRecomSource);
        anVar.dh("ab_tag", this.aee.mRecomAbTag);
        anVar.dh("weight", this.aee.mRecomWeight);
        anVar.dh("extra", this.aee.mRecomExtra);
        if (this.aee.getBaijiahaoData() != null && !aq.isEmpty(this.aee.getBaijiahaoData().oriUgcVid)) {
            anVar.dh("obj_param6", this.aee.getBaijiahaoData().oriUgcVid);
            return anVar;
        }
        return anVar;
    }

    protected void aV(View view) {
        if ((ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) && this.aee != null) {
            aWH();
            a(view, this.aee);
            if (!AntiHelper.d(getContext(), this.aee)) {
                aWJ();
                if (this.dWy != null) {
                    this.dWy.onClick(view);
                }
            }
        }
    }

    private void aWH() {
        if (this.aee != null) {
            an aWI = aWI();
            aWI.ag("thread_type", this.aee.getThreadType());
            TiebaStatic.log(aWI);
        }
    }

    private an aWI() {
        if (this.aee == null) {
            return null;
        }
        int i = 0;
        if (this.dWu == 1) {
            i = 4;
        } else if (this.dWu == 2) {
            i = 5;
        } else if (this.dWu == 3) {
            i = 3;
        } else if (this.dWu == 4) {
            i = 2;
        } else if (this.dWu == 6) {
            i = 8;
        } else if (this.dWu == 7) {
            i = 9;
        } else if (this.dWu == 9) {
            i = 10;
        } else if (this.dWu == 10) {
            i = 17;
        } else if (this.dWu == 18) {
            i = 20;
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("fid", this.aee.getFid());
        anVar.dh("tid", this.aee.getTid());
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.ag("obj_locate", i);
        anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, this.dRA);
        if (!aq.isEmpty(this.dWw)) {
            anVar.dh("obj_floor", this.dWw);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.aee.aQS() != null && this.aee.aQS().user_info != null && this.aee.aQS().user_info.is_official == 2) {
            anVar.ag("obj_isofficial", this.aee.aQS().user_info.is_official);
        }
        anVar.ag(IntentConfig.CARD_TYPE, this.aee.aSA()).dh("ab_tag", this.aee.mRecomAbTag).dh(IntentConfig.RECOM_SOURCE, this.aee.mRecomSource).dh("weight", this.aee.mRecomWeight).dh("extra", this.aee.mRecomExtra);
        if (this.aee.aPm()) {
            anVar.ag("obj_type", 10);
        } else if (this.aee.aPn()) {
            anVar.ag("obj_type", 9);
        } else if (this.aee.aSw()) {
            anVar.ag("obj_type", 8);
        } else if (this.aee.aSv()) {
            anVar.ag("obj_type", 7);
        } else if (this.aee.isShareThread) {
            anVar.ag("obj_type", 6);
        } else if (this.aee.threadType == 0) {
            anVar.ag("obj_type", 1);
        } else if (this.aee.threadType == 40) {
            anVar.ag("obj_type", 2);
        } else if (this.aee.threadType == 49) {
            anVar.ag("obj_type", 3);
        } else if (this.aee.threadType == 54) {
            anVar.ag("obj_type", 4);
        } else {
            anVar.ag("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            anVar.dh("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            anVar.dh("obj_tab", "a099");
            anVar.dh("resource_id", this.mTabName);
        }
        if (this.aee.getBaijiahaoData() != null) {
            anVar.dh("obj_param4", this.aee.getBaijiahaoData().oriUgcNid);
            if (this.aee.aPn() || this.aee.aSw()) {
                anVar.dh("obj_param6", this.aee.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.aee.aSu()) {
            anVar.ag("obj_param5", 2);
        } else if (this.aee.aPm() || this.aee.aPn()) {
            anVar.ag("obj_param5", 3);
        } else if (this.aee.threadType == 0 || this.aee.threadType == 40) {
            anVar.ag("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), anVar);
        }
        anVar.dh("nid", this.aee.getNid());
        return anVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bk bkVar) {
        int i;
        int i2 = 1;
        if (bkVar != null) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a("c13694", bkVar, i2, i));
            }
        }
    }

    private void aWJ() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.aee != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aee.getFid());
            String aQC = this.aee.aQC();
            if (this.aee.dHw != null) {
                valueOf = this.aee.dHw.id;
                aQC = this.aee.dHw.ori_fname;
            }
            String title = this.aee.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aee.getAbstract();
            }
            if (this.aee.aSx()) {
                tid = this.aee.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.aee.getBaijiahaoData().oriUgcType + "&dvid=" + this.aee.getBaijiahaoData().oriUgcVid + "&nid=" + this.aee.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.aee.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.aee.aQS() != null && this.aee.aQS().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.aee.aQS().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.aee.aQS().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String A = A(this.aee);
            Uri parse = A == null ? null : Uri.parse(A);
            String str4 = this.aee.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.aee.aSx() || this.aee.aQx() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.aee.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.aee.aQx().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = aq.cutString(title, 100);
            String cutString2 = aq.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int B = B(this.aee);
            if (this.aee.aSx()) {
                shareItem.readCount = -1L;
                shareItem.eeT = cutString2;
            } else {
                if (B == 2 && this.aee.aQQ() != null) {
                    shareItem.readCount = this.aee.aQQ().play_count.intValue();
                } else if (B == 1) {
                    shareItem.readCount = this.aee.aQp();
                }
                shareItem.eeT = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aQC;
            shareItem.tid = tid;
            shareItem.eeK = true;
            shareItem.dHZ = this.dWu;
            shareItem.eeV = getShareObjSource();
            shareItem.efa = B;
            shareItem.eeW = 3;
            shareItem.eeX = z(this.aee);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.aee.aSx()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.efk = this.aee.getShareImageUrl();
            }
            shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aee);
            if (this.mFrom == 13) {
                shareItem.efe = ShareItem.ForwardInfo.generateForwardInfo(this.aee, 2);
            } else {
                shareItem.efe = ShareItem.ForwardInfo.generateForwardInfo(this.aee);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eeW);
            bundle.putInt("obj_type", shareItem.efa);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dHZ);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.aee.getThreadType() == 49 || this.aee.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.e.bMy().b(shareDialogConfig);
        }
    }

    private int z(bk bkVar) {
        if (bkVar == null) {
            return 0;
        }
        if (bkVar.aPm()) {
            return 10;
        }
        if (bkVar.aPn()) {
            return 9;
        }
        if (bkVar.aSw()) {
            return 8;
        }
        if (bkVar.aSv()) {
            return 7;
        }
        if (bkVar.isShareThread) {
            return 6;
        }
        if (bkVar.threadType == 0) {
            return 1;
        }
        if (bkVar.threadType == 40) {
            return 2;
        }
        if (bkVar.threadType == 49) {
            return 3;
        }
        if (bkVar.threadType == 54) {
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
        if (this.dWu == 1) {
            return 5;
        }
        if (this.dWu != 3) {
            if (this.dWu == 4) {
                return 4;
            }
            if (this.dWu == 6) {
                return 8;
            }
            if (this.dWu != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String A(bk bkVar) {
        String str;
        if (bkVar == null) {
            return null;
        }
        if (bkVar.aQS() != null && !TextUtils.isEmpty(bkVar.aQS().cover)) {
            return bkVar.aQS().cover;
        }
        if (bkVar.aQH() == null) {
            return null;
        }
        ArrayList<MediaData> aQH = bkVar.aQH();
        int size = aQH.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aQH.get(i);
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
        if (str == null && bkVar.aQQ() != null && !TextUtils.isEmpty(bkVar.aQQ().thumbnail_url)) {
            return bkVar.aQQ().thumbnail_url;
        }
        return str;
    }

    private int B(bk bkVar) {
        if (bkVar != null) {
            if (bkVar.aQz()) {
                return 4;
            }
            if (bkVar.aQu() == 1) {
                return 3;
            }
            if (bkVar.aPm()) {
                return 5;
            }
            if (bkVar.aPn()) {
                return 6;
            }
            if (bkVar.aSv()) {
                return 7;
            }
            if (bkVar.aSw()) {
                return 8;
            }
            if (!bkVar.isShareThread || bkVar.dHm == null) {
                return bkVar.aRQ() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aY(View view) {
        if (this.dWg == null) {
            this.dWg = new ab(this.mPageContext, isShow(16));
        }
        this.dWg.setData(this.aee);
        this.dWg.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aZ(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.dWm = z;
        if (this.dVS != null) {
            this.dVS.setClickable(this.dWm);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(bk bkVar) {
        if (bkVar == null) {
            setVisibility(8);
            return false;
        }
        this.aee = bkVar;
        aWC();
        C(bkVar);
        E(bkVar);
        y(bkVar);
        x(bkVar);
        updatePraiseNum(bkVar);
        D(bkVar);
        F(bkVar);
        setVisibility(this.dWj ? 0 : 8);
        aWD();
        return this.dWj;
    }

    protected void aWD() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aWC() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(bk bkVar) {
        this.dVS.setVisibility(8);
    }

    protected void D(bk bkVar) {
        if (this.dWi != null && this.ckX != null && this.dWh != null && bkVar != null) {
            if (!this.dWD) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dWi.setVisibility(8);
            } else if (this.dWt && com.baidu.tieba.frs.a.bTZ().bUa()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.ckX.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.ckX.performClick();
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
                am.setViewTextColor(this.dWh, this.aee.aSk() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.ckX.setImageDrawable(am.getDrawable(bkVar.aSk() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.dWi.setVisibility(4);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dWi.setVisibility(8);
            }
        }
    }

    private void E(bk bkVar) {
        String aQa;
        if (this.dVT != null && bkVar != null) {
            if (bkVar.aQq() <= 0 || !this.dWk) {
                this.dVT.setVisibility(8);
                return;
            }
            this.dVT.setVisibility(0);
            if (this.mFrom == 3) {
                aQa = bkVar.aQb();
            } else {
                aQa = bkVar.aQa();
            }
            this.dVT.setText(aQa);
            this.dWj = true;
        }
    }

    public boolean isVisible() {
        return this.dWj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(bk bkVar) {
        if (this.dVV != null && bkVar != null) {
            if (this.dWp) {
                this.dVX.setVisibility(0);
                if (bkVar.aQo() > 0) {
                    this.dVV.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bkVar.aQo());
                    if (this.dWn) {
                        updateReplyStateUI();
                        this.dVV.setText(numFormatOverWan);
                    } else {
                        this.dVV.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dVV.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.dWj = true;
                    return;
                } else if (this.dWn) {
                    updateReplyStateUI();
                    this.dVV.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dVV.setVisibility(0);
                    this.dWj = true;
                    return;
                } else {
                    this.dVV.setVisibility(8);
                    return;
                }
            }
            this.dVX.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.dWn) {
            SvgManager.aUW().a(this.dVW, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.dVV, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bk bkVar) {
        setAgreeViewType(bkVar);
        if (bkVar.aSp() != null) {
            bkVar.aSp().isInThread = true;
            this.dVU.setCardType(bkVar.aSA());
            this.dVU.setThreadData(bkVar);
            this.dVU.setData(bkVar.aSp());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(bk bkVar) {
        if (this.dWa != null && this.dVY != null && bkVar != null) {
            if (this.dWr) {
                this.dWa.setVisibility(0);
                long aSa = bkVar.aSa();
                if ((bkVar.aRP() || bkVar.aRS()) && bkVar.aQS() != null && bkVar.aQS().share_info != null) {
                    aSa = bkVar.aQS().share_info.share_count;
                }
                this.dVY.setText(aSa > 0 ? aq.numFormatOverWan(aSa) : this.mContext.getString(R.string.share));
                this.dWj = true;
                updateShareStateUI(bkVar);
                return;
            }
            this.dWa.setVisibility(8);
        }
    }

    public void updateShareStateUI(bk bkVar) {
        if (AntiHelper.aZ(bkVar)) {
            setShareClickable(true);
            SvgManager.aUW().a(this.dVZ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dVY, (int) R.color.cp_cont_e);
        } else if (bkVar != null && bkVar.dHm != null && this.aee.dHm.dCi) {
            setShareClickable(false);
            SvgManager.aUW().a(this.dVZ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dVY, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aUW().a(this.dVZ, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dVY, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void F(bk bkVar) {
        if (this.dWf != null && bkVar != null) {
            this.dWs = isShow(4);
            if (bkVar.dHw != null) {
                this.dWs = false;
            }
            if (this.dWs && (this.dWi == null || this.dWi.getVisibility() == 8)) {
                this.dWf.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.dWd.setText(string);
                this.dWd.setContentDescription(string);
                this.dWj = true;
                return;
            }
            this.dWf.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        if (this.dVU != null) {
            this.dVU.setStatisticData(cVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dVS, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dVT, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.dWd, (int) R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.aee);
            SvgManager.aUW().a(this.dWc, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aUW().a(this.dWe, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.dWg != null) {
                this.dWg.onChangeSkinType();
            }
            if (this.dVU != null) {
                this.dVU.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dWy = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.dVS;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.dWq = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.dWk = z;
    }

    public View getCommentNumView() {
        return this.dVV;
    }

    public View getCommentContainer() {
        return this.dVX;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.dWn = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.dWo = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.dWr = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dVW.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.dVW.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.dWr = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dVW.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.dVW.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.dWt = z;
    }

    public void setManageVisible(boolean z) {
        this.dWs = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.dWB = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.ckX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.dWD = z;
    }

    public boolean isInFrsAllThread() {
        return this.dWD;
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
        if (this.dWg != null) {
            this.dWg.destory();
        }
    }

    public void setAgreeViewType(bk bkVar) {
        if (bkVar != null && bkVar.aSx()) {
            this.dVU.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.dVU.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.dWC = aVar;
    }
}
