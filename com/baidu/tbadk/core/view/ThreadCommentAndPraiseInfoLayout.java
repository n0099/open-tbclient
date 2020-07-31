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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
/* loaded from: classes15.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bv aeA;
    protected TextView agQ;
    private int ahI;
    protected ImageView crR;
    protected TextView dKx;
    private int eeE;
    private TextView ejA;
    protected AgreeView ejB;
    protected ImageView ejC;
    protected View ejD;
    protected TextView ejE;
    protected ImageView ejF;
    protected View ejG;
    protected FrameLayout ejH;
    protected ImageView ejI;
    protected TextView ejJ;
    protected ImageView ejK;
    protected View ejL;
    protected ab ejM;
    protected TextView ejN;
    protected LinearLayout ejO;
    protected boolean ejP;
    protected boolean ejQ;
    protected boolean ejR;
    protected boolean ejS;
    protected boolean ejT;
    protected boolean ejU;
    protected boolean ejV;
    protected boolean ejW;
    protected boolean ejX;
    protected boolean ejY;
    protected boolean ejZ;
    protected int ejz;
    private int eka;
    public int ekb;
    public String ekc;
    private String ekd;
    private View.OnClickListener eke;
    protected int ekf;
    protected int ekg;
    private b ekh;
    private a eki;
    private boolean ekj;
    CustomMessageListener ekk;
    CustomMessageListener ekl;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;

    /* loaded from: classes15.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes15.dex */
    public interface b {
        void id(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.ekd = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.ejB != null) {
            this.ejB.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.eka = i;
    }

    public void setGameId(int i) {
        this.eeE = i;
        if (this.ejB != null) {
            this.ejB.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.ejB != null) {
            this.ejB.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ekk);
        MessageManager.getInstance().registerListener(this.ekl);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ekk);
        MessageManager.getInstance().unRegisterListener(this.ekl);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ejz = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ahI = 11;
        this.ejP = false;
        this.ejQ = true;
        this.ejR = true;
        this.ejS = true;
        this.ejT = false;
        this.ejU = false;
        this.ejV = true;
        this.ejW = false;
        this.ejX = true;
        this.ejY = false;
        this.ejZ = true;
        this.mFrom = 2;
        this.eka = 1;
        this.mSkinType = 3;
        this.ekh = null;
        this.ekj = true;
        this.ekk = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bv)) {
                    bv bvVar = (bv) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aeA != null && bvVar != null) {
                        String str = bvVar.getBaijiahaoData() != null ? bvVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aeA.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aeA.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aeA.la(bvVar.aWc());
                                ThreadCommentAndPraiseInfoLayout.this.z(bvVar);
                                return;
                            }
                            return;
                        }
                        String id = bvVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aeA.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aeA.la(bvVar.aWc());
                            ThreadCommentAndPraiseInfoLayout.this.z(bvVar);
                        }
                    }
                }
            }
        };
        this.ekl = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aeA != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aeA.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aeA.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aeA.aXC() || ThreadCommentAndPraiseInfoLayout.this.aeA.aXF()) && ThreadCommentAndPraiseInfoLayout.this.aeA.aWF() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aeA.aWF() != null && ThreadCommentAndPraiseInfoLayout.this.aeA.aWF().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aeA.aWF().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aeA.ct(ThreadCommentAndPraiseInfoLayout.this.aeA.aXN() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.y(ThreadCommentAndPraiseInfoLayout.this.aeA);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ejz = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ahI = 11;
        this.ejP = false;
        this.ejQ = true;
        this.ejR = true;
        this.ejS = true;
        this.ejT = false;
        this.ejU = false;
        this.ejV = true;
        this.ejW = false;
        this.ejX = true;
        this.ejY = false;
        this.ejZ = true;
        this.mFrom = 2;
        this.eka = 1;
        this.mSkinType = 3;
        this.ekh = null;
        this.ekj = true;
        this.ekk = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bv)) {
                    bv bvVar = (bv) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.aeA != null && bvVar != null) {
                        String str = bvVar.getBaijiahaoData() != null ? bvVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.aeA.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.aeA.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.aeA.la(bvVar.aWc());
                                ThreadCommentAndPraiseInfoLayout.this.z(bvVar);
                                return;
                            }
                            return;
                        }
                        String id = bvVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.aeA.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.aeA.la(bvVar.aWc());
                            ThreadCommentAndPraiseInfoLayout.this.z(bvVar);
                        }
                    }
                }
            }
        };
        this.ekl = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.aeA != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.aeA.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.aeA.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.aeA.aXC() || ThreadCommentAndPraiseInfoLayout.this.aeA.aXF()) && ThreadCommentAndPraiseInfoLayout.this.aeA.aWF() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.aeA.aWF() != null && ThreadCommentAndPraiseInfoLayout.this.aeA.aWF().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.aeA.aWF().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.aeA.ct(ThreadCommentAndPraiseInfoLayout.this.aeA.aXN() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.y(ThreadCommentAndPraiseInfoLayout.this.aeA);
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
        this.ekg = R.drawable.icon_home_card_share;
        this.ekf = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.ejz = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        ayq();
    }

    protected void ayq() {
        aj(dQ(this.mContext));
    }

    protected void aj(View view) {
        this.agQ = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.ejA = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.dKx = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.ejC = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.ejD = view.findViewById(R.id.thread_info_commont_container);
        this.ejE = (TextView) view.findViewById(R.id.share_num);
        this.ejF = (ImageView) view.findViewById(R.id.share_num_img);
        this.ejG = view.findViewById(R.id.share_num_container);
        this.ejH = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.ejI = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.ejB = (AgreeView) findViewById;
            this.ejB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.eke != null) {
                        ThreadCommentAndPraiseInfoLayout.this.eke.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.aeA);
                }
            });
        }
        this.ejL = view.findViewById(R.id.manage_view_container);
        this.ejJ = (TextView) view.findViewById(R.id.thread_info_manage_text);
        this.ejK = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.crR = (ImageView) view.findViewById(R.id.manage_select_img);
        this.ejN = (TextView) view.findViewById(R.id.manage_select_text);
        this.ejO = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.ejO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.crR.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ejN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.crR.performClick();
            }
        });
        this.ejO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.crR.performClick();
            }
        });
        this.ejD.setOnClickListener(this);
        this.ejG.setOnClickListener(this);
        this.ejL.setOnClickListener(this);
        this.crR.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.ahI = i;
        sr();
    }

    private void sr() {
        int i;
        this.ejG.setVisibility(isShow(1) ? 0 : 8);
        this.ejD.setVisibility(isShow(2) ? 0 : 8);
        View view = this.ejL;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.ejB.setVisibility(isShow(8) ? 0 : 8);
        this.ejB.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.ahI & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.agQ) {
            bd(view);
        } else if (view == this.ejD) {
            ba(view);
        } else if (view == this.ejG) {
            bb(view);
        } else if (view == this.ejI) {
            bf(view);
        } else if (view == this.ejL) {
            be(view);
        } else if (view == this.crR) {
            bc(view);
        }
    }

    protected void bc(View view) {
        if (this.crR != null && this.aeA != null && this.ejN != null && !this.aeA.aXY()) {
            if (!this.aeA.aXW() && com.baidu.tieba.frs.b.caw().caq()) {
                if (com.baidu.tieba.frs.b.caw().ai(this.aeA)) {
                    this.aeA.hE(true);
                }
            } else if (!this.aeA.aXX() && com.baidu.tieba.frs.a.cap().caq()) {
                if (com.baidu.tieba.frs.a.cap().ai(this.aeA)) {
                    this.aeA.hF(true);
                }
            } else {
                com.baidu.tieba.frs.b.caw().aj(this.aeA);
                this.aeA.hE(false);
                com.baidu.tieba.frs.a.cap().aj(this.aeA);
                this.aeA.hF(false);
            }
            ao.setViewTextColor(this.ejN, (this.aeA.aXW() || this.aeA.aXX()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.crR.setImageDrawable(ao.getDrawable((this.aeA.aXW() || this.aeA.aXX()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.ekh != null) {
                this.ekh.id(this.aeA.aXW() || this.aeA.aXX());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.ejD != null) {
            this.ejD.setClickable(z);
            this.ejC.setEnabled(z);
            this.dKx.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.ejG != null) {
            this.ejG.setClickable(z);
            this.ejF.setEnabled(z);
            this.ejE.setEnabled(z);
        }
    }

    private void bd(View view) {
        if (this.aeA != null && !StringUtils.isNull(this.aeA.aWp())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.ekd)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.aeA.aWp(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aeA.aWp(), this.mStType, this.ekd)));
            }
            if (this.eke != null) {
                this.eke.onClick(view);
            }
        }
    }

    private boolean v(bv bvVar) {
        return (bvVar == null || !bvVar.aUR() || bvVar.aWD() == null) ? false : true;
    }

    protected void ba(View view) {
        if (this.aeA != null && this.mContext != null) {
            m.Ez(this.aeA.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aeA, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aeA.getFid()));
            addLocateParam.setForumName(this.aeA.aWp());
            if (this.aeA.aYa() && this.aeA.aXZ() != null) {
                addLocateParam.setForumId(this.aeA.aXZ().getForumId());
                addLocateParam.setForumName(this.aeA.aXZ().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.eki != null) {
                this.eki.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && v(this.aeA)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.k.ak(this.aeA);
            }
            if (this.aeA.dUG) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.aeA.aXs() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.ekb);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ap apVar = new ap("c12291");
            apVar.ah("obj_locate", this.mFrom);
            TiebaStatic.log(apVar);
            ap apVar2 = new ap("c12942");
            apVar2.ah("obj_locate", this.mFrom);
            apVar2.ah("obj_type", getThreadType());
            apVar2.dn("tid", this.aeA.getTid());
            apVar2.dn("nid", this.aeA.getNid());
            if (this.mFrom == 18) {
                apVar2.t("uid", TbadkApplication.getCurrentAccountId());
                apVar2.t("fid", this.aeA.getFid());
                apVar2.ah("obj_locate", 18);
                apVar2.dn("resource_id", this.mTabName);
            }
            TiebaStatic.log(apVar2);
            bcv();
            a(view, this.aeA);
            if (this.eke != null) {
                this.eke.onClick(view);
            }
        }
    }

    private void bcv() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            ap apVar = new ap("c13568");
            apVar.ah("obj_source", threadSourceForDynamicAndBjh);
            apVar.ah("obj_type", threadTypeForDynamicAndBjh);
            TiebaStatic.log(apVar);
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
        if (this.aeA == null) {
            return 0;
        }
        if (this.aeA.aUT()) {
            return 1;
        }
        if (this.aeA.aUU()) {
            return 2;
        }
        if (this.aeA.aYg()) {
            return 3;
        }
        return this.aeA.aYh() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.aeA == null) {
            return 0;
        }
        if (this.aeA.isShareThread) {
            return 4;
        }
        if (this.aeA.getThreadType() == 49) {
            return 5;
        }
        if (this.aeA.aWD() != null) {
            return 1;
        }
        if (this.aeA.getType() == bv.dRx || this.aeA.getType() == bv.dRR) {
            if (x.getCount(this.aeA.aWy()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aeA != null || i >= 0) {
            ap mN = mN(i);
            mN.ah("thread_type", this.aeA.getThreadType());
            TiebaStatic.log(mN);
        }
    }

    private ap mN(int i) {
        if (this.aeA == null && i < 0) {
            return null;
        }
        ap apVar = new ap("c12003");
        apVar.dn("tid", this.aeA.getTid());
        if (this.aeA.getThreadType() == 40) {
            apVar.dn("obj_param1", "2");
        } else if (this.aeA.getThreadType() == 0) {
            apVar.dn("obj_param1", "1");
        }
        apVar.dn("obj_source", "1");
        apVar.t("fid", this.aeA.getFid());
        apVar.ah("obj_locate", this.mFrom);
        apVar.ah("obj_id", i);
        if (!as.isEmpty(this.ekc)) {
            apVar.dn("obj_floor", this.ekc);
        }
        if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        apVar.dn("nid", this.aeA.getNid());
        apVar.ah(IntentConfig.CARD_TYPE, this.aeA.aYk());
        apVar.dn(IntentConfig.RECOM_SOURCE, this.aeA.mRecomSource);
        apVar.dn("ab_tag", this.aeA.mRecomAbTag);
        apVar.dn("weight", this.aeA.mRecomWeight);
        apVar.dn("extra", this.aeA.mRecomExtra);
        if (this.aeA.getBaijiahaoData() != null && !as.isEmpty(this.aeA.getBaijiahaoData().oriUgcVid)) {
            apVar.dn("obj_param6", this.aeA.getBaijiahaoData().oriUgcVid);
            return apVar;
        }
        return apVar;
    }

    protected void bb(View view) {
        if ((ShareSwitch.isOn() || bf.checkUpIsLogin(this.mContext)) && this.aeA != null) {
            bcw();
            a(view, this.aeA);
            if (!AntiHelper.d(getContext(), this.aeA)) {
                bcy();
                if (this.eke != null) {
                    this.eke.onClick(view);
                }
            }
        }
    }

    private void bcw() {
        if (this.aeA != null) {
            ap bcx = bcx();
            bcx.ah("thread_type", this.aeA.getThreadType());
            TiebaStatic.log(bcx);
        }
    }

    private ap bcx() {
        if (this.aeA == null) {
            return null;
        }
        int i = 0;
        if (this.eka == 1) {
            i = 4;
        } else if (this.eka == 2) {
            i = 5;
        } else if (this.eka == 3) {
            i = 3;
        } else if (this.eka == 4) {
            i = 2;
        } else if (this.eka == 6) {
            i = 8;
        } else if (this.eka == 7) {
            i = 9;
        } else if (this.eka == 9) {
            i = 10;
        } else if (this.eka == 10) {
            i = 17;
        } else if (this.eka == 18) {
            i = 20;
        }
        ap apVar = new ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        apVar.t("fid", this.aeA.getFid());
        apVar.dn("tid", this.aeA.getTid());
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        apVar.ah("obj_locate", i);
        apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, this.eeE);
        if (!as.isEmpty(this.ekc)) {
            apVar.dn("obj_floor", this.ekc);
        }
        if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.aeA.aWF() != null && this.aeA.aWF().user_info != null && this.aeA.aWF().user_info.is_official == 2) {
            apVar.ah("obj_isofficial", this.aeA.aWF().user_info.is_official);
        }
        apVar.ah(IntentConfig.CARD_TYPE, this.aeA.aYk()).dn("ab_tag", this.aeA.mRecomAbTag).dn(IntentConfig.RECOM_SOURCE, this.aeA.mRecomSource).dn("weight", this.aeA.mRecomWeight).dn("extra", this.aeA.mRecomExtra);
        if (this.aeA.aUT()) {
            apVar.ah("obj_type", 10);
        } else if (this.aeA.aUU()) {
            apVar.ah("obj_type", 9);
        } else if (this.aeA.aYh()) {
            apVar.ah("obj_type", 8);
        } else if (this.aeA.aYg()) {
            apVar.ah("obj_type", 7);
        } else if (this.aeA.isShareThread) {
            apVar.ah("obj_type", 6);
        } else if (this.aeA.threadType == 0) {
            apVar.ah("obj_type", 1);
        } else if (this.aeA.threadType == 40) {
            apVar.ah("obj_type", 2);
        } else if (this.aeA.threadType == 49) {
            apVar.ah("obj_type", 3);
        } else if (this.aeA.threadType == 54) {
            apVar.ah("obj_type", 4);
        } else {
            apVar.ah("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            apVar.dn("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            apVar.dn("obj_tab", "a099");
            apVar.dn("resource_id", this.mTabName);
        }
        if (this.aeA.getBaijiahaoData() != null) {
            apVar.dn("obj_param4", this.aeA.getBaijiahaoData().oriUgcNid);
            if (this.aeA.aUU() || this.aeA.aYh()) {
                apVar.dn("obj_param6", this.aeA.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.aeA.aYf()) {
            apVar.ah("obj_param5", 2);
        } else if (this.aeA.aUT() || this.aeA.aUU()) {
            apVar.ah("obj_param5", 3);
        } else if (this.aeA.threadType == 0 || this.aeA.threadType == 40) {
            apVar.ah("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), apVar);
        }
        apVar.dn("nid", this.aeA.getNid());
        return apVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bv bvVar) {
        int i;
        int i2 = 1;
        if (bvVar != null) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a("c13694", bvVar, i2, i));
            }
        }
    }

    private void bcy() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.aeA != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aeA.getFid());
            String aWp = this.aeA.aWp();
            if (this.aeA.dUt != null) {
                valueOf = this.aeA.dUt.id;
                aWp = this.aeA.dUt.ori_fname;
            }
            String title = this.aeA.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aeA.getAbstract();
            }
            if (this.aeA.aUV()) {
                tid = this.aeA.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.aeA.getBaijiahaoData().oriUgcType + "&dvid=" + this.aeA.getBaijiahaoData().oriUgcVid + "&nid=" + this.aeA.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.aeA.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.aeA.aWF() != null && this.aeA.aWF().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.aeA.aWF().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.aeA.aWF().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(this.aeA);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = this.aeA.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.aeA.aUV() || this.aeA.aWl() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.aeA.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.aeA.aWl().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = as.cutString(title, 100);
            String cutString2 = as.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(this.aeA);
            if (this.aeA.aUV()) {
                shareItem.readCount = -1L;
                shareItem.etQ = cutString2;
            } else {
                if (stateThreadType == 2 && this.aeA.aWD() != null) {
                    shareItem.readCount = this.aeA.aWD().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = this.aeA.aWd();
                }
                shareItem.etQ = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aWp;
            shareItem.tid = tid;
            shareItem.etH = true;
            shareItem.dVb = this.eka;
            shareItem.etS = getShareObjSource();
            shareItem.etX = stateThreadType;
            shareItem.etT = 3;
            shareItem.etU = getShareObjParam2(this.aeA);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.aeA.aUV()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.euh = this.aeA.getShareImageUrl();
            }
            bcz();
            shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aeA);
            if (this.mFrom == 13) {
                shareItem.eub = ShareItem.ForwardInfo.generateForwardInfo(this.aeA, 2);
            } else {
                shareItem.eub = ShareItem.ForwardInfo.generateForwardInfo(this.aeA);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.etT);
            bundle.putInt("obj_type", shareItem.etX);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dVb);
            shareItem.af(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.aeA.getThreadType() == 49 || this.aeA.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.f.bSP().b(shareDialogConfig);
        }
    }

    private void bcz() {
        ItemInfo caL;
        if ((this.mContext instanceof am) && ((am) this.mContext).caM() && this.aeA != null && this.aeA.aYo() == null && (caL = ((am) this.mContext).caL()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(caL.id.longValue());
            builder.item_name = caL.name;
            builder.icon_size = caL.icon_size;
            builder.icon_url = caL.icon_url;
            builder.tags = caL.tags;
            if (caL.score != null && caL.score.item_point != null) {
                Iterator<ItemPoint> it = caL.score.item_point.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ItemPoint next = it.next();
                    if (next.time_intval.equals(SchemeCollecter.CLASSIFY_ALL)) {
                        builder.score = next.point;
                        builder.star = Integer.valueOf((int) (next.point.doubleValue() / 2.0d));
                        break;
                    }
                }
            }
            Item build = builder.build(false);
            ItemData itemData = new ItemData();
            itemData.parseProto(build);
            this.aeA.a(itemData);
        }
    }

    private int getShareObjParam2(bv bvVar) {
        if (bvVar == null) {
            return 0;
        }
        if (bvVar.aUT()) {
            return 10;
        }
        if (bvVar.aUU()) {
            return 9;
        }
        if (bvVar.aYh()) {
            return 8;
        }
        if (bvVar.aYg()) {
            return 7;
        }
        if (bvVar.isShareThread) {
            return 6;
        }
        if (bvVar.threadType == 0) {
            return 1;
        }
        if (bvVar.threadType == 40) {
            return 2;
        }
        if (bvVar.threadType == 49) {
            return 3;
        }
        if (bvVar.threadType == 54) {
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
        if (this.eka == 1) {
            return 5;
        }
        if (this.eka != 3) {
            if (this.eka == 4) {
                return 4;
            }
            if (this.eka == 6) {
                return 8;
            }
            if (this.eka != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String getShareImageUrl(bv bvVar) {
        String str;
        if (bvVar == null) {
            return null;
        }
        if (bvVar.aWF() != null && !TextUtils.isEmpty(bvVar.aWF().cover)) {
            return bvVar.aWF().cover;
        }
        if (bvVar.aWu() == null) {
            return null;
        }
        ArrayList<MediaData> aWu = bvVar.aWu();
        int size = aWu.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aWu.get(i);
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
        if (str == null && bvVar.aWD() != null && !TextUtils.isEmpty(bvVar.aWD().thumbnail_url)) {
            return bvVar.aWD().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(bv bvVar) {
        if (bvVar != null) {
            if (bvVar.aWn()) {
                return 4;
            }
            if (bvVar.aWi() == 1) {
                return 3;
            }
            if (bvVar.aUT()) {
                return 5;
            }
            if (bvVar.aUU()) {
                return 6;
            }
            if (bvVar.aYg()) {
                return 7;
            }
            if (bvVar.aYh()) {
                return 8;
            }
            if (!bvVar.isShareThread || bvVar.dUi == null) {
                return bvVar.aXD() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void be(View view) {
        if (this.ejM == null) {
            this.ejM = new ab(this.mPageContext, isShow(16));
        }
        this.ejM.setData(this.aeA);
        this.ejM.showDialog();
        if (this.aeA != null) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).t("uid", TbadkCoreApplication.getCurrentAccountId()).t("fid", this.aeA.getFid()).dn("tid", this.aeA.getId()));
        }
    }

    private void bf(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ejS = z;
        if (this.agQ != null) {
            this.agQ.setClickable(this.ejS);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(bv bvVar) {
        if (bvVar == null) {
            setVisibility(8);
            return false;
        }
        this.aeA = bvVar;
        Tk();
        A(bvVar);
        C(bvVar);
        z(bvVar);
        y(bvVar);
        updatePraiseNum(bvVar);
        B(bvVar);
        D(bvVar);
        setVisibility(this.ejP ? 0 : 8);
        bct();
        return this.ejP;
    }

    protected void bct() {
    }

    protected void Tk() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bv bvVar) {
        this.agQ.setVisibility(8);
    }

    protected void B(bv bvVar) {
        if (this.ejO != null && this.crR != null && this.ejN != null && bvVar != null) {
            if (!this.ekj) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.ejO.setVisibility(8);
            } else if (this.ejZ && (com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ao.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.crR.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.crR.performClick();
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
                ao.setViewTextColor(this.ejN, (this.aeA.aXW() || this.aeA.aXX()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.crR.setImageDrawable(ao.getDrawable((bvVar.aXW() || this.aeA.aXX()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.ejO.setVisibility(4);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.ejO.setVisibility(8);
            }
        }
    }

    private void C(bv bvVar) {
        String aVO;
        if (this.ejA != null && bvVar != null) {
            if (bvVar.aWe() <= 0 || !this.ejQ) {
                this.ejA.setVisibility(8);
                return;
            }
            this.ejA.setVisibility(0);
            if (this.mFrom == 3) {
                aVO = bvVar.aVP();
            } else {
                aVO = bvVar.aVO();
            }
            this.ejA.setText(aVO);
            this.ejP = true;
        }
    }

    public boolean isVisible() {
        return this.ejP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(bv bvVar) {
        if (this.dKx != null && bvVar != null) {
            if (this.ejV) {
                this.ejD.setVisibility(0);
                if (bvVar.aWc() > 0) {
                    this.dKx.setVisibility(0);
                    String numFormatOverWan = as.numFormatOverWan(bvVar.aWc());
                    if (this.ejT) {
                        updateReplyStateUI();
                        this.dKx.setText(numFormatOverWan);
                    } else {
                        this.dKx.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dKx.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.ejP = true;
                    return;
                } else if (this.ejT) {
                    updateReplyStateUI();
                    this.dKx.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dKx.setVisibility(0);
                    this.ejP = true;
                    return;
                } else {
                    this.dKx.setVisibility(8);
                    return;
                }
            }
            this.ejD.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.ejT) {
            SvgManager.baR().a(this.ejC, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ao.setViewTextColor(this.dKx, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bv bvVar) {
        setAgreeViewType(bvVar);
        if (bvVar.aYc() != null) {
            bvVar.aYc().isInThread = true;
            this.ejB.setCardType(bvVar.aYk());
            this.ejB.setThreadData(bvVar);
            this.ejB.setData(bvVar.aYc());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(bv bvVar) {
        if (this.ejG != null && this.ejE != null && bvVar != null) {
            if (this.ejX) {
                this.ejG.setVisibility(0);
                long aXN = bvVar.aXN();
                if ((bvVar.aXC() || bvVar.aXF()) && bvVar.aWF() != null && bvVar.aWF().share_info != null) {
                    aXN = bvVar.aWF().share_info.share_count;
                }
                this.ejE.setText(aXN > 0 ? as.numFormatOverWan(aXN) : this.mContext.getString(R.string.share));
                this.ejP = true;
                updateShareStateUI(bvVar);
                return;
            }
            this.ejG.setVisibility(8);
        }
    }

    public void updateShareStateUI(bv bvVar) {
        if (AntiHelper.aX(bvVar)) {
            setShareClickable(true);
            SvgManager.baR().a(this.ejF, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.ejE, R.color.cp_cont_e);
        } else if (bvVar != null && bvVar.dUi != null && this.aeA.dUi.dOO) {
            setShareClickable(false);
            SvgManager.baR().a(this.ejF, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setViewTextColor(this.ejE, R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.baR().a(this.ejF, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ao.setViewTextColor(this.ejE, R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void D(bv bvVar) {
        if (this.ejL != null && bvVar != null) {
            this.ejY = isShow(4);
            if (bvVar.dUt != null) {
                this.ejY = false;
            }
            if (this.ejY && (this.ejO == null || this.ejO.getVisibility() == 8)) {
                this.ejL.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.ejJ.setText(string);
                this.ejJ.setContentDescription(string);
                this.ejP = true;
                return;
            }
            this.ejL.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        if (this.ejB != null) {
            this.ejB.setStatisticData(cVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.agQ, R.color.cp_cont_d);
            ao.setViewTextColor(this.ejA, R.color.cp_cont_j);
            ao.setViewTextColor(this.ejJ, R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.aeA);
            SvgManager.baR().a(this.ejI, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.ejK, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.ejM != null) {
                this.ejM.onChangeSkinType();
            }
            if (this.ejB != null) {
                this.ejB.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eke = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.agQ;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.ejW = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.ejQ = z;
    }

    public View getCommentNumView() {
        return this.dKx;
    }

    public View getCommentContainer() {
        return this.ejD;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.ejT = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.ejU = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.ejX = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejC.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.ejC.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.ejX = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejC.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.ejC.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.ejZ = z;
    }

    public void setManageVisible(boolean z) {
        this.ejY = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.ekh = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.crR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.ekj = z;
    }

    public boolean isInFrsAllThread() {
        return this.ekj;
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
        if (this.ejM != null) {
            this.ejM.destory();
        }
    }

    public void setAgreeViewType(bv bvVar) {
        if (bvVar != null && bvVar.aUV()) {
            this.ejB.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.ejB.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.eki = aVar;
    }
}
