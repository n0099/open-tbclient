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
/* loaded from: classes15.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bw afL;
    private int aiY;
    protected TextView aib;
    protected ImageView czK;
    protected TextView dTJ;
    private int eoj;
    protected AgreeView etA;
    protected ImageView etB;
    protected View etC;
    protected TextView etD;
    protected ImageView etE;
    protected View etF;
    protected FrameLayout etG;
    protected ImageView etH;
    protected TextView etI;
    protected ImageView etJ;
    protected View etK;
    protected ab etL;
    protected TextView etM;
    protected LinearLayout etN;
    protected boolean etO;
    protected boolean etP;
    protected boolean etQ;
    protected boolean etR;
    protected boolean etS;
    protected boolean etT;
    protected boolean etU;
    protected boolean etV;
    protected boolean etW;
    protected boolean etX;
    protected boolean etY;
    private int etZ;
    protected int ety;
    private TextView etz;
    public int eua;
    public String eub;
    private String euc;
    private View.OnClickListener eud;
    protected int eue;
    protected int euf;
    private b eug;
    private a euh;
    private boolean eui;
    CustomMessageListener euj;
    CustomMessageListener euk;
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
        void iB(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.euc = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.etA != null) {
            this.etA.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.etZ = i;
    }

    public void setGameId(int i) {
        this.eoj = i;
        if (this.etA != null) {
            this.etA.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.etA != null) {
            this.etA.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.euj);
        MessageManager.getInstance().registerListener(this.euk);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.euj);
        MessageManager.getInstance().unRegisterListener(this.euk);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ety = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.aiY = 11;
        this.etO = false;
        this.etP = true;
        this.etQ = true;
        this.etR = true;
        this.etS = false;
        this.etT = false;
        this.etU = true;
        this.etV = false;
        this.etW = true;
        this.etX = false;
        this.etY = true;
        this.mFrom = 2;
        this.etZ = 1;
        this.mSkinType = 3;
        this.eug = null;
        this.eui = true;
        this.euj = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.afL != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.afL.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.afL.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.afL.ng(bwVar.bev());
                                ThreadCommentAndPraiseInfoLayout.this.z(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.afL.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.afL.ng(bwVar.bev());
                            ThreadCommentAndPraiseInfoLayout.this.z(bwVar);
                        }
                    }
                }
            }
        };
        this.euk = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.afL != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.afL.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.afL.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.afL.bfV() || ThreadCommentAndPraiseInfoLayout.this.afL.bfY()) && ThreadCommentAndPraiseInfoLayout.this.afL.beY() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.afL.beY() != null && ThreadCommentAndPraiseInfoLayout.this.afL.beY().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.afL.beY().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.afL.cD(ThreadCommentAndPraiseInfoLayout.this.afL.bgg() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.y(ThreadCommentAndPraiseInfoLayout.this.afL);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ety = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.aiY = 11;
        this.etO = false;
        this.etP = true;
        this.etQ = true;
        this.etR = true;
        this.etS = false;
        this.etT = false;
        this.etU = true;
        this.etV = false;
        this.etW = true;
        this.etX = false;
        this.etY = true;
        this.mFrom = 2;
        this.etZ = 1;
        this.mSkinType = 3;
        this.eug = null;
        this.eui = true;
        this.euj = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.afL != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.afL.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.afL.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.afL.ng(bwVar.bev());
                                ThreadCommentAndPraiseInfoLayout.this.z(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.afL.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.afL.ng(bwVar.bev());
                            ThreadCommentAndPraiseInfoLayout.this.z(bwVar);
                        }
                    }
                }
            }
        };
        this.euk = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.afL != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.afL.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.afL.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.afL.bfV() || ThreadCommentAndPraiseInfoLayout.this.afL.bfY()) && ThreadCommentAndPraiseInfoLayout.this.afL.beY() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.afL.beY() != null && ThreadCommentAndPraiseInfoLayout.this.afL.beY().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.afL.beY().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.afL.cD(ThreadCommentAndPraiseInfoLayout.this.afL.bgg() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.y(ThreadCommentAndPraiseInfoLayout.this.afL);
                    }
                }
            }
        };
        init(context);
    }

    protected View dZ(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.euf = R.drawable.icon_home_card_share;
        this.eue = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.ety = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aGz();
    }

    protected void aGz() {
        ak(dZ(this.mContext));
    }

    protected void ak(View view) {
        this.aib = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.etz = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.dTJ = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.etB = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.etC = view.findViewById(R.id.thread_info_commont_container);
        this.etD = (TextView) view.findViewById(R.id.share_num);
        this.etE = (ImageView) view.findViewById(R.id.share_num_img);
        this.etF = view.findViewById(R.id.share_num_container);
        this.etG = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.etH = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.etA = (AgreeView) findViewById;
            this.etA.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.eud != null) {
                        ThreadCommentAndPraiseInfoLayout.this.eud.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.afL);
                }
            });
        }
        this.etK = view.findViewById(R.id.manage_view_container);
        this.etI = (TextView) view.findViewById(R.id.thread_info_manage_text);
        this.etJ = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.czK = (ImageView) view.findViewById(R.id.manage_select_img);
        this.etM = (TextView) view.findViewById(R.id.manage_select_text);
        this.etN = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.etN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.czK.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.etM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.czK.performClick();
            }
        });
        this.etN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.czK.performClick();
            }
        });
        this.etC.setOnClickListener(this);
        this.etF.setOnClickListener(this);
        this.etK.setOnClickListener(this);
        this.czK.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.aiY = i;
        ue();
    }

    private void ue() {
        int i;
        this.etF.setVisibility(isShow(1) ? 0 : 8);
        this.etC.setVisibility(isShow(2) ? 0 : 8);
        View view = this.etK;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.etA.setVisibility(isShow(8) ? 0 : 8);
        this.etA.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.aiY & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aib) {
            bf(view);
        } else if (view == this.etC) {
            bc(view);
        } else if (view == this.etF) {
            bd(view);
        } else if (view == this.etH) {
            bh(view);
        } else if (view == this.etK) {
            bg(view);
        } else if (view == this.czK) {
            be(view);
        }
    }

    protected void be(View view) {
        if (this.czK != null && this.afL != null && this.etM != null && !this.afL.bgr()) {
            if (!this.afL.bgp() && com.baidu.tieba.frs.b.ckT().ckN()) {
                if (com.baidu.tieba.frs.b.ckT().ai(this.afL)) {
                    this.afL.ib(true);
                }
            } else if (!this.afL.bgq() && com.baidu.tieba.frs.a.ckM().ckN()) {
                if (com.baidu.tieba.frs.a.ckM().ai(this.afL)) {
                    this.afL.ic(true);
                }
            } else {
                com.baidu.tieba.frs.b.ckT().aj(this.afL);
                this.afL.ib(false);
                com.baidu.tieba.frs.a.ckM().aj(this.afL);
                this.afL.ic(false);
            }
            ap.setViewTextColor(this.etM, (this.afL.bgp() || this.afL.bgq()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.czK.setImageDrawable(ap.getDrawable((this.afL.bgp() || this.afL.bgq()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.eug != null) {
                this.eug.iB(this.afL.bgp() || this.afL.bgq());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.etC != null) {
            this.etC.setClickable(z);
            this.etB.setEnabled(z);
            this.dTJ.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.etF != null) {
            this.etF.setClickable(z);
            this.etE.setEnabled(z);
            this.etD.setEnabled(z);
        }
    }

    private void bf(View view) {
        if (this.afL != null && !StringUtils.isNull(this.afL.beI())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.euc)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.afL.beI(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.afL.beI(), this.mStType, this.euc)));
            }
            if (this.eud != null) {
                this.eud.onClick(view);
            }
        }
    }

    private boolean v(bw bwVar) {
        return (bwVar == null || !bwVar.bdk() || bwVar.beW() == null) ? false : true;
    }

    protected void bc(View view) {
        if (this.afL != null && this.mContext != null) {
            m.GZ(this.afL.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.afL, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.afL.getFid()));
            addLocateParam.setForumName(this.afL.beI());
            if (this.afL.bgt() && this.afL.bgs() != null) {
                addLocateParam.setForumId(this.afL.bgs().getForumId());
                addLocateParam.setForumName(this.afL.bgs().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.euh != null) {
                this.euh.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && v(this.afL)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.ak(this.afL);
            }
            if (this.afL.eeg) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.afL.bfL() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.eua);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            aq aqVar = new aq("c12291");
            aqVar.ai("obj_locate", this.mFrom);
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12942");
            aqVar2.ai("obj_locate", this.mFrom);
            aqVar2.ai("obj_type", getThreadType());
            aqVar2.dD("tid", this.afL.getTid());
            aqVar2.dD("nid", this.afL.getNid());
            if (this.mFrom == 18) {
                aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.u("fid", this.afL.getFid());
                aqVar2.ai("obj_locate", 18);
                aqVar2.dD("resource_id", this.mTabName);
            }
            TiebaStatic.log(aqVar2);
            bkS();
            a(view, this.afL);
            if (this.eud != null) {
                this.eud.onClick(view);
            }
        }
    }

    private void bkS() {
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
        if (this.afL == null) {
            return 0;
        }
        if (this.afL.bdm()) {
            return 1;
        }
        if (this.afL.bdn()) {
            return 2;
        }
        if (this.afL.bgz()) {
            return 3;
        }
        return this.afL.bgA() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.afL == null) {
            return 0;
        }
        if (this.afL.isShareThread) {
            return 4;
        }
        if (this.afL.getThreadType() == 49) {
            return 5;
        }
        if (this.afL.beW() != null) {
            return 1;
        }
        if (this.afL.getType() == bw.eaW || this.afL.getType() == bw.ebr) {
            if (y.getCount(this.afL.beR()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.afL != null || i >= 0) {
            aq oS = oS(i);
            oS.ai("thread_type", this.afL.getThreadType());
            TiebaStatic.log(oS);
        }
    }

    private aq oS(int i) {
        if (this.afL == null && i < 0) {
            return null;
        }
        aq aqVar = new aq("c12003");
        aqVar.dD("tid", this.afL.getTid());
        if (this.afL.getThreadType() == 40) {
            aqVar.dD("obj_param1", "2");
        } else if (this.afL.getThreadType() == 0) {
            aqVar.dD("obj_param1", "1");
        }
        aqVar.dD("obj_source", "1");
        aqVar.u("fid", this.afL.getFid());
        aqVar.ai("obj_locate", this.mFrom);
        aqVar.ai("obj_id", i);
        if (!at.isEmpty(this.eub)) {
            aqVar.dD("obj_floor", this.eub);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        aqVar.dD("nid", this.afL.getNid());
        aqVar.ai(IntentConfig.CARD_TYPE, this.afL.bgD());
        aqVar.dD(IntentConfig.RECOM_SOURCE, this.afL.mRecomSource);
        aqVar.dD("ab_tag", this.afL.mRecomAbTag);
        aqVar.dD("weight", this.afL.mRecomWeight);
        aqVar.dD("extra", this.afL.mRecomExtra);
        if (this.afL.getBaijiahaoData() != null && !at.isEmpty(this.afL.getBaijiahaoData().oriUgcVid)) {
            aqVar.dD("obj_param6", this.afL.getBaijiahaoData().oriUgcVid);
            return aqVar;
        }
        return aqVar;
    }

    protected void bd(View view) {
        if ((ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) && this.afL != null) {
            bkT();
            a(view, this.afL);
            if (!AntiHelper.d(getContext(), this.afL)) {
                bkV();
                if (this.eud != null) {
                    this.eud.onClick(view);
                }
            }
        }
    }

    private void bkT() {
        if (this.afL != null) {
            aq bkU = bkU();
            bkU.ai("thread_type", this.afL.getThreadType());
            TiebaStatic.log(bkU);
        }
    }

    private aq bkU() {
        if (this.afL == null) {
            return null;
        }
        int i = 0;
        if (this.etZ == 1) {
            i = 4;
        } else if (this.etZ == 2) {
            i = 5;
        } else if (this.etZ == 3) {
            i = 3;
        } else if (this.etZ == 4) {
            i = 2;
        } else if (this.etZ == 6) {
            i = 8;
        } else if (this.etZ == 7) {
            i = 9;
        } else if (this.etZ == 9) {
            i = 10;
        } else if (this.etZ == 10) {
            i = 17;
        } else if (this.etZ == 18) {
            i = 20;
        }
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.u("fid", this.afL.getFid());
        aqVar.dD("tid", this.afL.getTid());
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.ai("obj_locate", i);
        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, this.eoj);
        if (!at.isEmpty(this.eub)) {
            aqVar.dD("obj_floor", this.eub);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.afL.beY() != null && this.afL.beY().user_info != null && this.afL.beY().user_info.is_official == 2) {
            aqVar.ai("obj_isofficial", this.afL.beY().user_info.is_official);
        }
        aqVar.ai(IntentConfig.CARD_TYPE, this.afL.bgD()).dD("ab_tag", this.afL.mRecomAbTag).dD(IntentConfig.RECOM_SOURCE, this.afL.mRecomSource).dD("weight", this.afL.mRecomWeight).dD("extra", this.afL.mRecomExtra);
        if (this.afL.bdm()) {
            aqVar.ai("obj_type", 10);
        } else if (this.afL.bdn()) {
            aqVar.ai("obj_type", 9);
        } else if (this.afL.bgA()) {
            aqVar.ai("obj_type", 8);
        } else if (this.afL.bgz()) {
            aqVar.ai("obj_type", 7);
        } else if (this.afL.isShareThread) {
            aqVar.ai("obj_type", 6);
        } else if (this.afL.threadType == 0) {
            aqVar.ai("obj_type", 1);
        } else if (this.afL.threadType == 40) {
            aqVar.ai("obj_type", 2);
        } else if (this.afL.threadType == 49) {
            aqVar.ai("obj_type", 3);
        } else if (this.afL.threadType == 54) {
            aqVar.ai("obj_type", 4);
        } else {
            aqVar.ai("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            aqVar.dD("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            aqVar.dD("obj_tab", "a099");
            aqVar.dD("resource_id", this.mTabName);
        }
        if (this.afL.getBaijiahaoData() != null) {
            aqVar.dD("obj_param4", this.afL.getBaijiahaoData().oriUgcNid);
            if (this.afL.bdn() || this.afL.bgA()) {
                aqVar.dD("obj_param6", this.afL.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.afL.bgy()) {
            aqVar.ai("obj_param5", 2);
        } else if (this.afL.bdm() || this.afL.bdn()) {
            aqVar.ai("obj_param5", 3);
        } else if (this.afL.threadType == 0 || this.afL.threadType == 40) {
            aqVar.ai("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), aqVar);
        }
        aqVar.dD("nid", this.afL.getNid());
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

    private void bkV() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.afL != null && this.mContext != null) {
            String valueOf = String.valueOf(this.afL.getFid());
            String beI = this.afL.beI();
            if (this.afL.edT != null) {
                valueOf = this.afL.edT.id;
                beI = this.afL.edT.ori_fname;
            }
            String title = this.afL.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.afL.getAbstract();
            }
            if (this.afL.bdo()) {
                tid = this.afL.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.afL.getBaijiahaoData().oriUgcType + "&dvid=" + this.afL.getBaijiahaoData().oriUgcVid + "&nid=" + this.afL.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.afL.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.afL.beY() != null && this.afL.beY().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.afL.beY().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.afL.beY().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(this.afL);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = this.afL.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.afL.bdo() || this.afL.beE() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.afL.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.afL.beE().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = at.cutString(title, 100);
            String cutString2 = at.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(this.afL);
            if (this.afL.bdo()) {
                shareItem.readCount = -1L;
                shareItem.eEu = cutString2;
            } else {
                if (stateThreadType == 2 && this.afL.beW() != null) {
                    shareItem.readCount = this.afL.beW().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = this.afL.bew();
                }
                shareItem.eEu = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = beI;
            shareItem.tid = tid;
            shareItem.eEj = true;
            shareItem.eeF = this.etZ;
            shareItem.eEw = getShareObjSource();
            shareItem.eEB = stateThreadType;
            shareItem.eEx = 3;
            shareItem.eEy = getShareObjParam2(this.afL);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.afL.bdo()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.eEL = this.afL.getShareImageUrl();
            }
            bkW();
            shareItem.eEE = OriginalThreadInfo.ShareInfo.generateShareInfo(this.afL);
            if (this.mFrom == 13) {
                shareItem.eEF = ShareItem.ForwardInfo.generateForwardInfo(this.afL, 2);
            } else {
                shareItem.eEF = ShareItem.ForwardInfo.generateForwardInfo(this.afL);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEx);
            bundle.putInt("obj_type", shareItem.eEB);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeF);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.afL.getThreadType() == 49 || this.afL.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.f.cdc().b(shareDialogConfig);
        }
    }

    private void bkW() {
        ItemInfo cli;
        if ((this.mContext instanceof ao) && ((ao) this.mContext).clj() && this.afL != null && this.afL.bgH() == null && (cli = ((ao) this.mContext).cli()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cli.id.longValue());
            builder.item_name = cli.name;
            builder.icon_size = cli.icon_size;
            builder.icon_url = cli.icon_url;
            builder.tags = cli.tags;
            if (cli.score != null && cli.score.item_point != null) {
                Iterator<ItemPoint> it = cli.score.item_point.iterator();
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
            this.afL.a(itemData);
        }
    }

    private int getShareObjParam2(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bdm()) {
            return 10;
        }
        if (bwVar.bdn()) {
            return 9;
        }
        if (bwVar.bgA()) {
            return 8;
        }
        if (bwVar.bgz()) {
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
        if (this.etZ == 1) {
            return 5;
        }
        if (this.etZ != 3) {
            if (this.etZ == 4) {
                return 4;
            }
            if (this.etZ == 6) {
                return 8;
            }
            if (this.etZ != 10) {
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
        if (bwVar.beY() != null && !TextUtils.isEmpty(bwVar.beY().cover)) {
            return bwVar.beY().cover;
        }
        if (bwVar.beN() == null) {
            return null;
        }
        ArrayList<MediaData> beN = bwVar.beN();
        int size = beN.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = beN.get(i);
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
        if (str == null && bwVar.beW() != null && !TextUtils.isEmpty(bwVar.beW().thumbnail_url)) {
            return bwVar.beW().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.beG()) {
                return 4;
            }
            if (bwVar.beB() == 1) {
                return 3;
            }
            if (bwVar.bdm()) {
                return 5;
            }
            if (bwVar.bdn()) {
                return 6;
            }
            if (bwVar.bgz()) {
                return 7;
            }
            if (bwVar.bgA()) {
                return 8;
            }
            if (!bwVar.isShareThread || bwVar.edI == null) {
                return bwVar.bfW() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bg(View view) {
        if (this.etL == null) {
            this.etL = new ab(this.mPageContext, isShow(16));
        }
        this.etL.setData(this.afL);
        this.etL.Nv();
        if (this.afL != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).u("uid", TbadkCoreApplication.getCurrentAccountId()).u("fid", this.afL.getFid()).dD("tid", this.afL.getId()));
        }
    }

    private void bh(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.etR = z;
        if (this.aib != null) {
            this.aib.setClickable(this.etR);
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
        this.afL = bwVar;
        aag();
        A(bwVar);
        C(bwVar);
        z(bwVar);
        y(bwVar);
        updatePraiseNum(bwVar);
        B(bwVar);
        D(bwVar);
        setVisibility(this.etO ? 0 : 8);
        bkQ();
        return this.etO;
    }

    protected void bkQ() {
    }

    protected void aag() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bw bwVar) {
        this.aib.setVisibility(8);
    }

    protected void B(bw bwVar) {
        if (this.etN != null && this.czK != null && this.etM != null && bwVar != null) {
            if (!this.eui) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.etN.setVisibility(8);
            } else if (this.etY && (com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.czK.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.czK.performClick();
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
                ap.setViewTextColor(this.etM, (this.afL.bgp() || this.afL.bgq()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.czK.setImageDrawable(ap.getDrawable((bwVar.bgp() || this.afL.bgq()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.etN.setVisibility(4);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.etN.setVisibility(8);
            }
        }
    }

    private void C(bw bwVar) {
        String beh;
        if (this.etz != null && bwVar != null) {
            if (bwVar.bex() <= 0 || !this.etP) {
                this.etz.setVisibility(8);
                return;
            }
            this.etz.setVisibility(0);
            if (this.mFrom == 3) {
                beh = bwVar.bei();
            } else {
                beh = bwVar.beh();
            }
            this.etz.setText(beh);
            this.etO = true;
        }
    }

    public boolean isVisible() {
        return this.etO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(bw bwVar) {
        if (this.dTJ != null && bwVar != null) {
            if (this.etU) {
                this.etC.setVisibility(0);
                if (bwVar.bev() > 0) {
                    this.dTJ.setVisibility(0);
                    String numFormatOverWan = at.numFormatOverWan(bwVar.bev());
                    if (this.etS) {
                        updateReplyStateUI();
                        this.dTJ.setText(numFormatOverWan);
                    } else {
                        this.dTJ.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dTJ.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.etO = true;
                    return;
                } else if (this.etS) {
                    updateReplyStateUI();
                    this.dTJ.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dTJ.setVisibility(0);
                    this.etO = true;
                    return;
                } else {
                    this.dTJ.setVisibility(8);
                    return;
                }
            }
            this.etC.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.etS) {
            SvgManager.bjq().a(this.etB, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.dTJ, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bw bwVar) {
        setAgreeViewType(bwVar);
        if (bwVar.bgv() != null) {
            bwVar.bgv().isInThread = true;
            this.etA.setCardType(bwVar.bgD());
            this.etA.setThreadData(bwVar);
            this.etA.setData(bwVar.bgv());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(bw bwVar) {
        if (this.etF != null && this.etD != null && bwVar != null) {
            if (this.etW) {
                this.etF.setVisibility(0);
                long bgg = bwVar.bgg();
                if ((bwVar.bfV() || bwVar.bfY()) && bwVar.beY() != null && bwVar.beY().share_info != null) {
                    bgg = bwVar.beY().share_info.share_count;
                }
                this.etD.setText(bgg > 0 ? at.numFormatOverWan(bgg) : this.mContext.getString(R.string.share));
                this.etO = true;
                updateShareStateUI(bwVar);
                return;
            }
            this.etF.setVisibility(8);
        }
    }

    public void updateShareStateUI(bw bwVar) {
        if (AntiHelper.aY(bwVar)) {
            setShareClickable(true);
            SvgManager.bjq().a(this.etE, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.etD, R.color.cp_cont_e);
        } else if (bwVar != null && bwVar.edI != null && this.afL.edI.dYl) {
            setShareClickable(false);
            SvgManager.bjq().a(this.etE, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.etD, R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.bjq().a(this.etE, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.etD, R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void D(bw bwVar) {
        if (this.etK != null && bwVar != null) {
            this.etX = isShow(4);
            if (bwVar.edT != null) {
                this.etX = false;
            }
            if (this.etX && (this.etN == null || this.etN.getVisibility() == 8)) {
                this.etK.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.etI.setText(string);
                this.etI.setContentDescription(string);
                this.etO = true;
                return;
            }
            this.etK.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        if (this.etA != null) {
            this.etA.setStatisticData(cVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.aib, R.color.cp_cont_d);
            ap.setViewTextColor(this.etz, R.color.cp_cont_j);
            ap.setViewTextColor(this.etI, R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.afL);
            SvgManager.bjq().a(this.etH, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.etJ, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.etL != null) {
                this.etL.onChangeSkinType();
            }
            if (this.etA != null) {
                this.etA.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eud = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aib;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.etV = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.etP = z;
    }

    public View getCommentNumView() {
        return this.dTJ;
    }

    public View getCommentContainer() {
        return this.etC;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.etS = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.etT = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.etW = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etB.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.etB.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.etW = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etB.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.etB.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.etY = z;
    }

    public void setManageVisible(boolean z) {
        this.etX = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.eug = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.czK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.eui = z;
    }

    public boolean isInFrsAllThread() {
        return this.eui;
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
        if (this.etL != null) {
            this.etL.destory();
        }
    }

    public void setAgreeViewType(bw bwVar) {
        if (bwVar != null && bwVar.bdo()) {
            this.etA.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.etA.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.euh = aVar;
    }
}
