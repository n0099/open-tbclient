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
    protected bw afJ;
    protected TextView ahZ;
    private int aiW;
    protected ImageView czG;
    protected TextView dTF;
    private int eoe;
    protected ImageView etA;
    protected View etB;
    protected FrameLayout etC;
    protected ImageView etD;
    protected TextView etE;
    protected ImageView etF;
    protected View etG;
    protected ab etH;
    protected TextView etI;
    protected LinearLayout etJ;
    protected boolean etK;
    protected boolean etL;
    protected boolean etM;
    protected boolean etN;
    protected boolean etO;
    protected boolean etP;
    protected boolean etQ;
    protected boolean etR;
    protected boolean etS;
    protected boolean etT;
    protected boolean etU;
    private int etV;
    public int etW;
    public String etX;
    private String etY;
    private View.OnClickListener etZ;
    protected int etu;
    private TextView etv;
    protected AgreeView etw;
    protected ImageView etx;
    protected View ety;
    protected TextView etz;
    protected int eua;
    protected int eub;
    private b euc;
    private a eud;
    private boolean eue;
    CustomMessageListener euf;
    CustomMessageListener eug;
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
        void iA(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.etY = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.etw != null) {
            this.etw.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.etV = i;
    }

    public void setGameId(int i) {
        this.eoe = i;
        if (this.etw != null) {
            this.etw.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.etw != null) {
            this.etw.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.euf);
        MessageManager.getInstance().registerListener(this.eug);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.euf);
        MessageManager.getInstance().unRegisterListener(this.eug);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.etu = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.aiW = 11;
        this.etK = false;
        this.etL = true;
        this.etM = true;
        this.etN = true;
        this.etO = false;
        this.etP = false;
        this.etQ = true;
        this.etR = false;
        this.etS = true;
        this.etT = false;
        this.etU = true;
        this.mFrom = 2;
        this.etV = 1;
        this.mSkinType = 3;
        this.euc = null;
        this.eue = true;
        this.euf = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.afJ != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.afJ.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.afJ.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.afJ.ng(bwVar.bev());
                                ThreadCommentAndPraiseInfoLayout.this.z(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.afJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.afJ.ng(bwVar.bev());
                            ThreadCommentAndPraiseInfoLayout.this.z(bwVar);
                        }
                    }
                }
            }
        };
        this.eug = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.afJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.afJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.afJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.afJ.bfV() || ThreadCommentAndPraiseInfoLayout.this.afJ.bfY()) && ThreadCommentAndPraiseInfoLayout.this.afJ.beY() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.afJ.beY() != null && ThreadCommentAndPraiseInfoLayout.this.afJ.beY().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.afJ.beY().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.afJ.cD(ThreadCommentAndPraiseInfoLayout.this.afJ.bgg() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.y(ThreadCommentAndPraiseInfoLayout.this.afJ);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etu = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.aiW = 11;
        this.etK = false;
        this.etL = true;
        this.etM = true;
        this.etN = true;
        this.etO = false;
        this.etP = false;
        this.etQ = true;
        this.etR = false;
        this.etS = true;
        this.etT = false;
        this.etU = true;
        this.mFrom = 2;
        this.etV = 1;
        this.mSkinType = 3;
        this.euc = null;
        this.eue = true;
        this.euf = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bw)) {
                    bw bwVar = (bw) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.afJ != null && bwVar != null) {
                        String str = bwVar.getBaijiahaoData() != null ? bwVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.afJ.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.afJ.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.afJ.ng(bwVar.bev());
                                ThreadCommentAndPraiseInfoLayout.this.z(bwVar);
                                return;
                            }
                            return;
                        }
                        String id = bwVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.afJ.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.afJ.ng(bwVar.bev());
                            ThreadCommentAndPraiseInfoLayout.this.z(bwVar);
                        }
                    }
                }
            }
        };
        this.eug = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.afJ != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.afJ.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.afJ.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.afJ.bfV() || ThreadCommentAndPraiseInfoLayout.this.afJ.bfY()) && ThreadCommentAndPraiseInfoLayout.this.afJ.beY() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.afJ.beY() != null && ThreadCommentAndPraiseInfoLayout.this.afJ.beY().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.afJ.beY().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.afJ.cD(ThreadCommentAndPraiseInfoLayout.this.afJ.bgg() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.y(ThreadCommentAndPraiseInfoLayout.this.afJ);
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
        this.eub = R.drawable.icon_home_card_share;
        this.eua = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.etu = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aGz();
    }

    protected void aGz() {
        ak(dZ(this.mContext));
    }

    protected void ak(View view) {
        this.ahZ = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.etv = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.dTF = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.etx = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.ety = view.findViewById(R.id.thread_info_commont_container);
        this.etz = (TextView) view.findViewById(R.id.share_num);
        this.etA = (ImageView) view.findViewById(R.id.share_num_img);
        this.etB = view.findViewById(R.id.share_num_container);
        this.etC = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.etD = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.etw = (AgreeView) findViewById;
            this.etw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.etZ != null) {
                        ThreadCommentAndPraiseInfoLayout.this.etZ.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.afJ);
                }
            });
        }
        this.etG = view.findViewById(R.id.manage_view_container);
        this.etE = (TextView) view.findViewById(R.id.thread_info_manage_text);
        this.etF = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.czG = (ImageView) view.findViewById(R.id.manage_select_img);
        this.etI = (TextView) view.findViewById(R.id.manage_select_text);
        this.etJ = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.etJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.czG.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.etI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.czG.performClick();
            }
        });
        this.etJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.czG.performClick();
            }
        });
        this.ety.setOnClickListener(this);
        this.etB.setOnClickListener(this);
        this.etG.setOnClickListener(this);
        this.czG.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.aiW = i;
        ue();
    }

    private void ue() {
        int i;
        this.etB.setVisibility(isShow(1) ? 0 : 8);
        this.ety.setVisibility(isShow(2) ? 0 : 8);
        View view = this.etG;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.etw.setVisibility(isShow(8) ? 0 : 8);
        this.etw.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.aiW & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ahZ) {
            bf(view);
        } else if (view == this.ety) {
            bc(view);
        } else if (view == this.etB) {
            bd(view);
        } else if (view == this.etD) {
            bh(view);
        } else if (view == this.etG) {
            bg(view);
        } else if (view == this.czG) {
            be(view);
        }
    }

    protected void be(View view) {
        if (this.czG != null && this.afJ != null && this.etI != null && !this.afJ.bgr()) {
            if (!this.afJ.bgp() && com.baidu.tieba.frs.b.ckS().ckM()) {
                if (com.baidu.tieba.frs.b.ckS().ai(this.afJ)) {
                    this.afJ.ia(true);
                }
            } else if (!this.afJ.bgq() && com.baidu.tieba.frs.a.ckL().ckM()) {
                if (com.baidu.tieba.frs.a.ckL().ai(this.afJ)) {
                    this.afJ.ib(true);
                }
            } else {
                com.baidu.tieba.frs.b.ckS().aj(this.afJ);
                this.afJ.ia(false);
                com.baidu.tieba.frs.a.ckL().aj(this.afJ);
                this.afJ.ib(false);
            }
            ap.setViewTextColor(this.etI, (this.afJ.bgp() || this.afJ.bgq()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.czG.setImageDrawable(ap.getDrawable((this.afJ.bgp() || this.afJ.bgq()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.euc != null) {
                this.euc.iA(this.afJ.bgp() || this.afJ.bgq());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.ety != null) {
            this.ety.setClickable(z);
            this.etx.setEnabled(z);
            this.dTF.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.etB != null) {
            this.etB.setClickable(z);
            this.etA.setEnabled(z);
            this.etz.setEnabled(z);
        }
    }

    private void bf(View view) {
        if (this.afJ != null && !StringUtils.isNull(this.afJ.beI())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.etY)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.afJ.beI(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.afJ.beI(), this.mStType, this.etY)));
            }
            if (this.etZ != null) {
                this.etZ.onClick(view);
            }
        }
    }

    private boolean v(bw bwVar) {
        return (bwVar == null || !bwVar.bdk() || bwVar.beW() == null) ? false : true;
    }

    protected void bc(View view) {
        if (this.afJ != null && this.mContext != null) {
            m.GY(this.afJ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.afJ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.afJ.getFid()));
            addLocateParam.setForumName(this.afJ.beI());
            if (this.afJ.bgt() && this.afJ.bgs() != null) {
                addLocateParam.setForumId(this.afJ.bgs().getForumId());
                addLocateParam.setForumName(this.afJ.bgs().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.eud != null) {
                this.eud.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && v(this.afJ)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.ak(this.afJ);
            }
            if (this.afJ.eec) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.afJ.bfL() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.etW);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            aq aqVar = new aq("c12291");
            aqVar.ai("obj_locate", this.mFrom);
            TiebaStatic.log(aqVar);
            aq aqVar2 = new aq("c12942");
            aqVar2.ai("obj_locate", this.mFrom);
            aqVar2.ai("obj_type", getThreadType());
            aqVar2.dD("tid", this.afJ.getTid());
            aqVar2.dD("nid", this.afJ.getNid());
            if (this.mFrom == 18) {
                aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.u("fid", this.afJ.getFid());
                aqVar2.ai("obj_locate", 18);
                aqVar2.dD("resource_id", this.mTabName);
            }
            TiebaStatic.log(aqVar2);
            bkS();
            a(view, this.afJ);
            if (this.etZ != null) {
                this.etZ.onClick(view);
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
        if (this.afJ == null) {
            return 0;
        }
        if (this.afJ.bdm()) {
            return 1;
        }
        if (this.afJ.bdn()) {
            return 2;
        }
        if (this.afJ.bgz()) {
            return 3;
        }
        return this.afJ.bgA() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.afJ == null) {
            return 0;
        }
        if (this.afJ.isShareThread) {
            return 4;
        }
        if (this.afJ.getThreadType() == 49) {
            return 5;
        }
        if (this.afJ.beW() != null) {
            return 1;
        }
        if (this.afJ.getType() == bw.eaS || this.afJ.getType() == bw.ebn) {
            if (y.getCount(this.afJ.beR()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.afJ != null || i >= 0) {
            aq oS = oS(i);
            oS.ai("thread_type", this.afJ.getThreadType());
            TiebaStatic.log(oS);
        }
    }

    private aq oS(int i) {
        if (this.afJ == null && i < 0) {
            return null;
        }
        aq aqVar = new aq("c12003");
        aqVar.dD("tid", this.afJ.getTid());
        if (this.afJ.getThreadType() == 40) {
            aqVar.dD("obj_param1", "2");
        } else if (this.afJ.getThreadType() == 0) {
            aqVar.dD("obj_param1", "1");
        }
        aqVar.dD("obj_source", "1");
        aqVar.u("fid", this.afJ.getFid());
        aqVar.ai("obj_locate", this.mFrom);
        aqVar.ai("obj_id", i);
        if (!at.isEmpty(this.etX)) {
            aqVar.dD("obj_floor", this.etX);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        aqVar.dD("nid", this.afJ.getNid());
        aqVar.ai(IntentConfig.CARD_TYPE, this.afJ.bgD());
        aqVar.dD(IntentConfig.RECOM_SOURCE, this.afJ.mRecomSource);
        aqVar.dD("ab_tag", this.afJ.mRecomAbTag);
        aqVar.dD("weight", this.afJ.mRecomWeight);
        aqVar.dD("extra", this.afJ.mRecomExtra);
        if (this.afJ.getBaijiahaoData() != null && !at.isEmpty(this.afJ.getBaijiahaoData().oriUgcVid)) {
            aqVar.dD("obj_param6", this.afJ.getBaijiahaoData().oriUgcVid);
            return aqVar;
        }
        return aqVar;
    }

    protected void bd(View view) {
        if ((ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) && this.afJ != null) {
            bkT();
            a(view, this.afJ);
            if (!AntiHelper.d(getContext(), this.afJ)) {
                bkV();
                if (this.etZ != null) {
                    this.etZ.onClick(view);
                }
            }
        }
    }

    private void bkT() {
        if (this.afJ != null) {
            aq bkU = bkU();
            bkU.ai("thread_type", this.afJ.getThreadType());
            TiebaStatic.log(bkU);
        }
    }

    private aq bkU() {
        if (this.afJ == null) {
            return null;
        }
        int i = 0;
        if (this.etV == 1) {
            i = 4;
        } else if (this.etV == 2) {
            i = 5;
        } else if (this.etV == 3) {
            i = 3;
        } else if (this.etV == 4) {
            i = 2;
        } else if (this.etV == 6) {
            i = 8;
        } else if (this.etV == 7) {
            i = 9;
        } else if (this.etV == 9) {
            i = 10;
        } else if (this.etV == 10) {
            i = 17;
        } else if (this.etV == 18) {
            i = 20;
        }
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.u("fid", this.afJ.getFid());
        aqVar.dD("tid", this.afJ.getTid());
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.ai("obj_locate", i);
        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, this.eoe);
        if (!at.isEmpty(this.etX)) {
            aqVar.dD("obj_floor", this.etX);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.afJ.beY() != null && this.afJ.beY().user_info != null && this.afJ.beY().user_info.is_official == 2) {
            aqVar.ai("obj_isofficial", this.afJ.beY().user_info.is_official);
        }
        aqVar.ai(IntentConfig.CARD_TYPE, this.afJ.bgD()).dD("ab_tag", this.afJ.mRecomAbTag).dD(IntentConfig.RECOM_SOURCE, this.afJ.mRecomSource).dD("weight", this.afJ.mRecomWeight).dD("extra", this.afJ.mRecomExtra);
        if (this.afJ.bdm()) {
            aqVar.ai("obj_type", 10);
        } else if (this.afJ.bdn()) {
            aqVar.ai("obj_type", 9);
        } else if (this.afJ.bgA()) {
            aqVar.ai("obj_type", 8);
        } else if (this.afJ.bgz()) {
            aqVar.ai("obj_type", 7);
        } else if (this.afJ.isShareThread) {
            aqVar.ai("obj_type", 6);
        } else if (this.afJ.threadType == 0) {
            aqVar.ai("obj_type", 1);
        } else if (this.afJ.threadType == 40) {
            aqVar.ai("obj_type", 2);
        } else if (this.afJ.threadType == 49) {
            aqVar.ai("obj_type", 3);
        } else if (this.afJ.threadType == 54) {
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
        if (this.afJ.getBaijiahaoData() != null) {
            aqVar.dD("obj_param4", this.afJ.getBaijiahaoData().oriUgcNid);
            if (this.afJ.bdn() || this.afJ.bgA()) {
                aqVar.dD("obj_param6", this.afJ.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.afJ.bgy()) {
            aqVar.ai("obj_param5", 2);
        } else if (this.afJ.bdm() || this.afJ.bdn()) {
            aqVar.ai("obj_param5", 3);
        } else if (this.afJ.threadType == 0 || this.afJ.threadType == 40) {
            aqVar.ai("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), aqVar);
        }
        aqVar.dD("nid", this.afJ.getNid());
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
        if (this.afJ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.afJ.getFid());
            String beI = this.afJ.beI();
            if (this.afJ.edP != null) {
                valueOf = this.afJ.edP.id;
                beI = this.afJ.edP.ori_fname;
            }
            String title = this.afJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.afJ.getAbstract();
            }
            if (this.afJ.bdo()) {
                tid = this.afJ.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.afJ.getBaijiahaoData().oriUgcType + "&dvid=" + this.afJ.getBaijiahaoData().oriUgcVid + "&nid=" + this.afJ.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.afJ.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + str;
            boolean z = true;
            if (this.afJ.beY() != null && this.afJ.beY().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.afJ.beY().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.afJ.beY().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(this.afJ);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = this.afJ.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.afJ.bdo() || this.afJ.beE() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.afJ.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.afJ.beE().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = at.cutString(title, 100);
            String cutString2 = at.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(this.afJ);
            if (this.afJ.bdo()) {
                shareItem.readCount = -1L;
                shareItem.eEq = cutString2;
            } else {
                if (stateThreadType == 2 && this.afJ.beW() != null) {
                    shareItem.readCount = this.afJ.beW().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = this.afJ.bew();
                }
                shareItem.eEq = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = beI;
            shareItem.tid = tid;
            shareItem.eEf = true;
            shareItem.eeB = this.etV;
            shareItem.eEs = getShareObjSource();
            shareItem.eEx = stateThreadType;
            shareItem.eEt = 3;
            shareItem.eEu = getShareObjParam2(this.afJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.afJ.bdo()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.eEH = this.afJ.getShareImageUrl();
            }
            bkW();
            shareItem.eEA = OriginalThreadInfo.ShareInfo.generateShareInfo(this.afJ);
            if (this.mFrom == 13) {
                shareItem.eEB = ShareItem.ForwardInfo.generateForwardInfo(this.afJ, 2);
            } else {
                shareItem.eEB = ShareItem.ForwardInfo.generateForwardInfo(this.afJ);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEt);
            bundle.putInt("obj_type", shareItem.eEx);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeB);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.afJ.getThreadType() == 49 || this.afJ.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.c.f.cdb().b(shareDialogConfig);
        }
    }

    private void bkW() {
        ItemInfo clh;
        if ((this.mContext instanceof ao) && ((ao) this.mContext).cli() && this.afJ != null && this.afJ.bgH() == null && (clh = ((ao) this.mContext).clh()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(clh.id.longValue());
            builder.item_name = clh.name;
            builder.icon_size = clh.icon_size;
            builder.icon_url = clh.icon_url;
            builder.tags = clh.tags;
            if (clh.score != null && clh.score.item_point != null) {
                Iterator<ItemPoint> it = clh.score.item_point.iterator();
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
            this.afJ.a(itemData);
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
        if (this.etV == 1) {
            return 5;
        }
        if (this.etV != 3) {
            if (this.etV == 4) {
                return 4;
            }
            if (this.etV == 6) {
                return 8;
            }
            if (this.etV != 10) {
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
            if (!bwVar.isShareThread || bwVar.edE == null) {
                return bwVar.bfW() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bg(View view) {
        if (this.etH == null) {
            this.etH = new ab(this.mPageContext, isShow(16));
        }
        this.etH.setData(this.afJ);
        this.etH.Nv();
        if (this.afJ != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).u("uid", TbadkCoreApplication.getCurrentAccountId()).u("fid", this.afJ.getFid()).dD("tid", this.afJ.getId()));
        }
    }

    private void bh(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.etN = z;
        if (this.ahZ != null) {
            this.ahZ.setClickable(this.etN);
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
        this.afJ = bwVar;
        aag();
        A(bwVar);
        C(bwVar);
        z(bwVar);
        y(bwVar);
        updatePraiseNum(bwVar);
        B(bwVar);
        D(bwVar);
        setVisibility(this.etK ? 0 : 8);
        bkQ();
        return this.etK;
    }

    protected void bkQ() {
    }

    protected void aag() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(bw bwVar) {
        this.ahZ.setVisibility(8);
    }

    protected void B(bw bwVar) {
        if (this.etJ != null && this.czG != null && this.etI != null && bwVar != null) {
            if (!this.eue) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.etJ.setVisibility(8);
            } else if (this.etU && (com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.czG.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.czG.performClick();
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
                ap.setViewTextColor(this.etI, (this.afJ.bgp() || this.afJ.bgq()) ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.czG.setImageDrawable(ap.getDrawable((bwVar.bgp() || this.afJ.bgq()) ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.etJ.setVisibility(4);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.etJ.setVisibility(8);
            }
        }
    }

    private void C(bw bwVar) {
        String beh;
        if (this.etv != null && bwVar != null) {
            if (bwVar.bex() <= 0 || !this.etL) {
                this.etv.setVisibility(8);
                return;
            }
            this.etv.setVisibility(0);
            if (this.mFrom == 3) {
                beh = bwVar.bei();
            } else {
                beh = bwVar.beh();
            }
            this.etv.setText(beh);
            this.etK = true;
        }
    }

    public boolean isVisible() {
        return this.etK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(bw bwVar) {
        if (this.dTF != null && bwVar != null) {
            if (this.etQ) {
                this.ety.setVisibility(0);
                if (bwVar.bev() > 0) {
                    this.dTF.setVisibility(0);
                    String numFormatOverWan = at.numFormatOverWan(bwVar.bev());
                    if (this.etO) {
                        updateReplyStateUI();
                        this.dTF.setText(numFormatOverWan);
                    } else {
                        this.dTF.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dTF.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.etK = true;
                    return;
                } else if (this.etO) {
                    updateReplyStateUI();
                    this.dTF.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dTF.setVisibility(0);
                    this.etK = true;
                    return;
                } else {
                    this.dTF.setVisibility(8);
                    return;
                }
            }
            this.ety.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.etO) {
            SvgManager.bjq().a(this.etx, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.dTF, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public void updatePraiseNum(bw bwVar) {
        setAgreeViewType(bwVar);
        if (bwVar.bgv() != null) {
            bwVar.bgv().isInThread = true;
            this.etw.setCardType(bwVar.bgD());
            this.etw.setThreadData(bwVar);
            this.etw.setData(bwVar.bgv());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(bw bwVar) {
        if (this.etB != null && this.etz != null && bwVar != null) {
            if (this.etS) {
                this.etB.setVisibility(0);
                long bgg = bwVar.bgg();
                if ((bwVar.bfV() || bwVar.bfY()) && bwVar.beY() != null && bwVar.beY().share_info != null) {
                    bgg = bwVar.beY().share_info.share_count;
                }
                this.etz.setText(bgg > 0 ? at.numFormatOverWan(bgg) : this.mContext.getString(R.string.share));
                this.etK = true;
                updateShareStateUI(bwVar);
                return;
            }
            this.etB.setVisibility(8);
        }
    }

    public void updateShareStateUI(bw bwVar) {
        if (AntiHelper.aY(bwVar)) {
            setShareClickable(true);
            SvgManager.bjq().a(this.etA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.etz, R.color.cp_cont_e);
        } else if (bwVar != null && bwVar.edE != null && this.afJ.edE.dYh) {
            setShareClickable(false);
            SvgManager.bjq().a(this.etA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.etz, R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.bjq().a(this.etA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ap.setViewTextColor(this.etz, R.drawable.selector_comment_and_prise_item_text_color);
        }
    }

    protected void D(bw bwVar) {
        if (this.etG != null && bwVar != null) {
            this.etT = isShow(4);
            if (bwVar.edP != null) {
                this.etT = false;
            }
            if (this.etT && (this.etJ == null || this.etJ.getVisibility() == 8)) {
                this.etG.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.etE.setText(string);
                this.etE.setContentDescription(string);
                this.etK = true;
                return;
            }
            this.etG.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.c cVar) {
        if (this.etw != null) {
            this.etw.setStatisticData(cVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.ahZ, R.color.cp_cont_d);
            ap.setViewTextColor(this.etv, R.color.cp_cont_j);
            ap.setViewTextColor(this.etE, R.drawable.selector_comment_and_prise_item_text_color);
            updateReplyStateUI();
            updateShareStateUI(this.afJ);
            SvgManager.bjq().a(this.etD, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.etF, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.etH != null) {
                this.etH.onChangeSkinType();
            }
            if (this.etw != null) {
                this.etw.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.etZ = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.ahZ;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.etR = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.etL = z;
    }

    public View getCommentNumView() {
        return this.dTF;
    }

    public View getCommentContainer() {
        return this.ety;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.etO = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.etP = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.etS = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etx.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.etx.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.etS = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etx.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.etx.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.etU = z;
    }

    public void setManageVisible(boolean z) {
        this.etT = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.euc = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.czG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.eue = z;
    }

    public boolean isInFrsAllThread() {
        return this.eue;
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
        if (this.etH != null) {
            this.etH.destory();
        }
    }

    public void setAgreeViewType(bw bwVar) {
        if (bwVar != null && bwVar.bdo()) {
            this.etw.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.etw.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.eud = aVar;
    }
}
