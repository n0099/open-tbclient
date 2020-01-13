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
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bj Kn;
    private int Nc;
    private int cZk;
    protected int dcX;
    protected TextView dcY;
    private TextView dcZ;
    private int ddA;
    public int ddB;
    public String ddC;
    private String ddD;
    private View.OnClickListener ddE;
    protected int ddF;
    protected int ddG;
    private b ddH;
    private a ddI;
    private boolean ddJ;
    CustomMessageListener ddK;
    CustomMessageListener ddL;
    protected AgreeView dda;
    protected TextView ddb;
    protected ImageView ddc;
    protected View ddd;
    protected TextView dde;
    protected ImageView ddf;
    protected View ddg;
    protected FrameLayout ddh;
    protected ImageView ddi;
    protected TextView ddj;
    protected ImageView ddk;
    protected View ddl;
    protected aa ddm;
    protected TextView ddn;
    protected LinearLayout ddo;
    protected boolean ddp;
    protected boolean ddq;
    protected boolean ddr;
    protected boolean dds;
    protected boolean ddt;
    protected boolean ddv;
    protected boolean ddw;
    protected boolean ddx;
    protected boolean ddy;
    protected boolean ddz;
    protected boolean isVisible;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    protected ImageView mSelectImg;
    private int mSkinType;
    private String mStType;

    /* loaded from: classes6.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void fM(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.ddD = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.dda != null) {
            this.dda.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.ddA = i;
    }

    public void setGameId(int i) {
        this.cZk = i;
        if (this.dda != null) {
            this.dda.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddK);
        MessageManager.getInstance().registerListener(this.ddL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ddK);
        MessageManager.getInstance().unRegisterListener(this.ddL);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.dcX = 0;
        this.Nc = 11;
        this.isVisible = false;
        this.ddp = true;
        this.ddq = true;
        this.ddr = true;
        this.dds = false;
        this.ddt = false;
        this.ddv = true;
        this.ddw = false;
        this.ddx = true;
        this.ddy = false;
        this.ddz = true;
        this.mFrom = 2;
        this.ddA = 1;
        this.mSkinType = 3;
        this.ddH = null;
        this.ddJ = false;
        this.ddK = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.Kn != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.Kn.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.Kn.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.Kn.js(bjVar.azO());
                                ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.Kn.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.Kn.js(bjVar.azO());
                            ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                        }
                    }
                }
            }
        };
        this.ddL = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.Kn != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.Kn.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.Kn.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.Kn.aBl() || ThreadCommentAndPraiseInfoLayout.this.Kn.aBo()) && ThreadCommentAndPraiseInfoLayout.this.Kn.aAq() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.Kn.aAq() != null && ThreadCommentAndPraiseInfoLayout.this.Kn.aAq().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.Kn.aAq().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.Kn.bu(ThreadCommentAndPraiseInfoLayout.this.Kn.aBw() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.v(ThreadCommentAndPraiseInfoLayout.this.Kn);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dcX = 0;
        this.Nc = 11;
        this.isVisible = false;
        this.ddp = true;
        this.ddq = true;
        this.ddr = true;
        this.dds = false;
        this.ddt = false;
        this.ddv = true;
        this.ddw = false;
        this.ddx = true;
        this.ddy = false;
        this.ddz = true;
        this.mFrom = 2;
        this.ddA = 1;
        this.mSkinType = 3;
        this.ddH = null;
        this.ddJ = false;
        this.ddK = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.Kn != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.Kn.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.Kn.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.Kn.js(bjVar.azO());
                                ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.Kn.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.Kn.js(bjVar.azO());
                            ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                        }
                    }
                }
            }
        };
        this.ddL = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.Kn != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.Kn.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.Kn.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.Kn.aBl() || ThreadCommentAndPraiseInfoLayout.this.Kn.aBo()) && ThreadCommentAndPraiseInfoLayout.this.Kn.aAq() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.Kn.aAq() != null && ThreadCommentAndPraiseInfoLayout.this.Kn.aAq().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.Kn.aAq().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.Kn.bu(ThreadCommentAndPraiseInfoLayout.this.Kn.aBw() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.v(ThreadCommentAndPraiseInfoLayout.this.Kn);
                    }
                }
            }
        };
        init(context);
    }

    protected View dN(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.dcX = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View dN = dN(context);
        this.dcY = (TextView) dN.findViewById(R.id.thread_info_bar_name);
        this.dcZ = (TextView) dN.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) dN.findViewById(R.id.thread_comment_layout_root);
        this.ddb = (TextView) dN.findViewById(R.id.thread_info_commont_num);
        this.ddc = (ImageView) dN.findViewById(R.id.thread_info_commont_img);
        this.ddd = dN.findViewById(R.id.thread_info_commont_container);
        this.dde = (TextView) dN.findViewById(R.id.share_num);
        this.ddf = (ImageView) dN.findViewById(R.id.share_num_img);
        this.ddg = dN.findViewById(R.id.share_num_container);
        this.ddh = (FrameLayout) dN.findViewById(R.id.btn_card_bottom_op_more_container);
        this.ddi = (ImageView) dN.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = dN.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.dda = (AgreeView) findViewById;
            this.dda.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadCommentAndPraiseInfoLayout.this.ddE != null) {
                        ThreadCommentAndPraiseInfoLayout.this.ddE.onClick(view);
                    }
                }
            });
        }
        this.ddl = dN.findViewById(R.id.manage_view_container);
        this.ddj = (TextView) dN.findViewById(R.id.thread_info_manage_text);
        this.ddk = (ImageView) dN.findViewById(R.id.thread_info_manage_img);
        this.mSelectImg = (ImageView) dN.findViewById(R.id.manage_select_img);
        this.ddn = (TextView) dN.findViewById(R.id.manage_select_text);
        this.ddo = (LinearLayout) dN.findViewById(R.id.manage_select_container);
        this.ddo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ddn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.ddo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.ddd.setOnClickListener(this);
        this.ddg.setOnClickListener(this);
        this.ddl.setOnClickListener(this);
        this.mSelectImg.setOnClickListener(this);
        this.ddG = R.drawable.icon_home_card_share;
        this.ddF = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    public void setShowFlag(int i) {
        this.Nc = i;
        na();
    }

    private void na() {
        int i;
        this.ddg.setVisibility(isShow(1) ? 0 : 8);
        this.ddd.setVisibility(isShow(2) ? 0 : 8);
        View view = this.ddl;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.dda.setVisibility(isShow(8) ? 0 : 8);
        this.dda.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.Nc & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dcY) {
            aV(view);
        } else if (view == this.ddd) {
            aS(view);
        } else if (view == this.ddg) {
            aT(view);
        } else if (view == this.ddi) {
            aX(view);
        } else if (view == this.ddl) {
            aW(view);
        } else if (view == this.mSelectImg) {
            aU(view);
        }
    }

    protected void aU(View view) {
        if (this.mSelectImg != null && this.Kn != null && this.ddn != null && !this.Kn.aBH()) {
            if (!this.Kn.aBG()) {
                if (com.baidu.tieba.frs.a.bBr().ag(this.Kn)) {
                    this.Kn.fv(true);
                }
            } else {
                com.baidu.tieba.frs.a.bBr().ah(this.Kn);
                this.Kn.fv(false);
            }
            am.setViewTextColor(this.ddn, this.Kn.aBG() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.mSelectImg.setImageDrawable(am.getDrawable(this.Kn.aBG() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.ddH != null) {
                this.ddH.fM(this.Kn.aBG());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.ddd != null) {
            this.ddd.setClickable(z);
            this.ddc.setEnabled(z);
            this.ddb.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.ddg != null) {
            this.ddg.setClickable(z);
            this.ddf.setEnabled(z);
            this.dde.setEnabled(z);
        }
    }

    private void aV(View view) {
        if (this.Kn != null && !StringUtils.isNull(this.Kn.aAc())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.ddD)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.Kn.aAc(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.Kn.aAc(), this.mStType, this.ddD)));
            }
            if (this.ddE != null) {
                this.ddE.onClick(view);
            }
        }
    }

    private boolean t(bj bjVar) {
        return (bjVar == null || !bjVar.aAX() || bjVar.aAo() == null) ? false : true;
    }

    protected void aS(View view) {
        if (this.Kn != null && this.mContext != null) {
            com.baidu.tieba.card.l.zC(this.Kn.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.Kn, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.Kn.getFid()));
            addLocateParam.setForumName(this.Kn.aAc());
            if (this.Kn.aBK() && this.Kn.aBJ() != null) {
                addLocateParam.setForumId(this.Kn.aBJ().getForumId());
                addLocateParam.setForumName(this.Kn.aBJ().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.ddI != null) {
                this.ddI.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(this.Kn)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.ai(this.Kn);
            }
            if (this.Kn.cQk) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.Kn.aBc() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.ddB);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.Z("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.Z("obj_locate", this.mFrom);
            anVar2.Z("obj_type", getThreadType());
            anVar2.cp("tid", this.Kn.getTid());
            TiebaStatic.log(anVar2);
            aFI();
            if (this.ddE != null) {
                this.ddE.onClick(view);
            }
        }
    }

    private void aFI() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            an anVar = new an("c13568");
            anVar.Z("obj_source", threadSourceForDynamicAndBjh);
            anVar.Z("obj_type", threadTypeForDynamicAndBjh);
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
        if (this.Kn == null) {
            return 0;
        }
        if (this.Kn.ayL()) {
            return 1;
        }
        if (this.Kn.aBS()) {
            return 2;
        }
        if (this.Kn.aBT()) {
            return 3;
        }
        return this.Kn.aBU() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.Kn == null) {
            return 0;
        }
        if (this.Kn.isShareThread) {
            return 4;
        }
        if (this.Kn.getThreadType() == 49) {
            return 5;
        }
        if (this.Kn.aAo() != null) {
            return 1;
        }
        if (this.Kn.getType() == bj.cNf || this.Kn.getType() == bj.cNu) {
            if (v.getCount(this.Kn.aAl()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.Kn != null || i >= 0) {
            an kW = kW(i);
            kW.Z("thread_type", this.Kn.getThreadType());
            TiebaStatic.log(kW);
        }
    }

    private an kW(int i) {
        if (this.Kn == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.cp("tid", this.Kn.getTid());
        if (this.Kn.getThreadType() == 40) {
            anVar.cp("obj_param1", "2");
        } else if (this.Kn.getThreadType() == 0) {
            anVar.cp("obj_param1", "1");
        }
        anVar.cp("obj_source", "1");
        anVar.s("fid", this.Kn.getFid());
        anVar.Z("obj_locate", this.mFrom);
        anVar.Z("obj_id", i);
        if (!aq.isEmpty(this.ddC)) {
            anVar.cp("obj_floor", this.ddC);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aT(View view) {
        if ((ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) && this.Kn != null) {
            aFJ();
            aFL();
            if (this.ddE != null) {
                this.ddE.onClick(view);
            }
        }
    }

    private void aFJ() {
        if (this.Kn != null) {
            an aFK = aFK();
            aFK.Z("thread_type", this.Kn.getThreadType());
            TiebaStatic.log(aFK);
        }
    }

    private an aFK() {
        if (this.Kn == null) {
            return null;
        }
        int i = 0;
        if (this.ddA == 1) {
            i = 4;
        } else if (this.ddA == 2) {
            i = 5;
        } else if (this.ddA == 3) {
            i = 3;
        } else if (this.ddA == 4) {
            i = 2;
        } else if (this.ddA == 6) {
            i = 8;
        } else if (this.ddA == 7) {
            i = 9;
        } else if (this.ddA == 9) {
            i = 10;
        } else if (this.ddA == 10) {
            i = 17;
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("fid", this.Kn.getFid());
        anVar.cp("tid", this.Kn.getTid());
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.Z("obj_locate", i);
        anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, this.cZk);
        if (!aq.isEmpty(this.ddC)) {
            anVar.cp("obj_floor", this.ddC);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.Kn.aAq() != null && this.Kn.aAq().user_info != null && this.Kn.aAq().user_info.is_official == 2) {
            anVar.Z("obj_isofficial", this.Kn.aAq().user_info.is_official);
        }
        anVar.Z("card_type", this.Kn.aBY()).cp(TiebaInitialize.Params.AB_TAG, this.Kn.mRecomAbTag).cp("recom_source", this.Kn.mRecomSource).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, this.Kn.mRecomWeight).cp("extra", this.Kn.mRecomExtra);
        if (this.Kn.isShareThread) {
            anVar.Z("obj_type", 6);
        } else if (this.Kn.threadType == 0) {
            anVar.Z("obj_type", 1);
        } else if (this.Kn.threadType == 40) {
            anVar.Z("obj_type", 2);
        } else if (this.Kn.threadType == 49) {
            anVar.Z("obj_type", 3);
        } else if (this.Kn.threadType == 54) {
            anVar.Z("obj_type", 4);
        } else {
            anVar.Z("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            anVar.cp("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.Kn.getBaijiahaoData() != null) {
            anVar.cp("obj_param4", this.Kn.getBaijiahaoData().oriUgcNid);
            if (this.Kn.aBS() || this.Kn.aBU()) {
                anVar.cp("obj_param6", this.Kn.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.Kn.aBR()) {
            anVar.Z("obj_param5", 2);
        } else if (this.Kn.ayL() || this.Kn.aBS()) {
            anVar.Z("obj_param5", 3);
        } else if (this.Kn.threadType == 0 || this.Kn.threadType == 40) {
            anVar.Z("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), anVar);
        }
        return anVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aFL() {
        String str;
        boolean z;
        Uri parse;
        ShareItem shareItem;
        String str2;
        boolean z2 = false;
        if (this.Kn != null && this.mContext != null) {
            if (this.Kn.aBV() && !TbadkCoreApplication.isLogin()) {
                bc.skipToLoginActivity(this.mContext);
                return;
            }
            String valueOf = String.valueOf(this.Kn.getFid());
            String aAc = this.Kn.aAc();
            if (this.Kn.cPX != null) {
                valueOf = this.Kn.cPX.id;
                aAc = this.Kn.cPX.ori_fname;
            }
            String title = this.Kn.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.Kn.getAbstract();
            }
            String tid = this.Kn.getTid();
            String str3 = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            if (this.Kn.aAq() != null && this.Kn.aAq().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.Kn.aAq().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.Kn.aAq().user_info.user_name, "utf-8");
                    }
                    str = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String x = x(this.Kn);
                parse = x != null ? null : Uri.parse(x);
                String str4 = this.Kn.getAbstract();
                String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str4);
                shareItem = new ShareItem();
                shareItem.title = title;
                shareItem.content = format;
                shareItem.dlS = str4;
                shareItem.linkUrl = str;
                shareItem.extData = tid;
                shareItem.fid = valueOf;
                shareItem.fName = aAc;
                shareItem.tid = tid;
                shareItem.dlJ = true;
                shareItem.cQy = this.ddA;
                shareItem.dlU = getShareObjSource();
                shareItem.dlZ = y(this.Kn);
                shareItem.dlV = 3;
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (!this.Kn.isBjh() || this.Kn.aBV()) {
                    shareItem.dmf = false;
                    z = false;
                }
                shareItem.canShareBySmartApp = z;
                if (z) {
                    shareItem.dmj = this.Kn.getShareImageUrl();
                }
                shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo(this.Kn);
                if (this.mFrom != 13) {
                    shareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(this.Kn, 2);
                } else {
                    shareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(this.Kn);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dlV);
                bundle.putInt("obj_type", shareItem.dlZ);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putInt("obj_source", shareItem.cQy);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                if (this.Kn.getThreadType() != 49 || this.Kn.getThreadType() == 60) {
                    z2 = true;
                }
                shareDialogConfig.setIsAlaLive(z2);
                a(shareDialogConfig);
                com.baidu.tieba.c.e.buG().b(shareDialogConfig);
            }
            str = str3;
            z = true;
            String x2 = x(this.Kn);
            if (x2 != null) {
            }
            String str42 = this.Kn.getAbstract();
            String format2 = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str42);
            shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format2;
            shareItem.dlS = str42;
            shareItem.linkUrl = str;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = aAc;
            shareItem.tid = tid;
            shareItem.dlJ = true;
            shareItem.cQy = this.ddA;
            shareItem.dlU = getShareObjSource();
            shareItem.dlZ = y(this.Kn);
            shareItem.dlV = 3;
            if (parse != null) {
            }
            if (!this.Kn.isBjh()) {
            }
            shareItem.dmf = false;
            z = false;
            shareItem.canShareBySmartApp = z;
            if (z) {
            }
            shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo(this.Kn);
            if (this.mFrom != 13) {
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem.dlV);
            bundle2.putInt("obj_type", shareItem.dlZ);
            bundle2.putString("fid", shareItem.fid);
            bundle2.putString("tid", shareItem.tid);
            bundle2.putInt("obj_source", shareItem.cQy);
            shareItem.Y(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, shareItem, true, true);
            if (this.Kn.getThreadType() != 49) {
            }
            z2 = true;
            shareDialogConfig2.setIsAlaLive(z2);
            a(shareDialogConfig2);
            com.baidu.tieba.c.e.buG().b(shareDialogConfig2);
        }
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
            case 10:
                shareDialogConfig.setFrom(ShareDialogConfig.From.FRS);
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
        if (this.ddA == 1) {
            return 5;
        }
        if (this.ddA != 3) {
            if (this.ddA == 4) {
                return 4;
            }
            if (this.ddA != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String x(bj bjVar) {
        String str;
        if (bjVar == null) {
            return null;
        }
        if (bjVar.aAq() != null && !TextUtils.isEmpty(bjVar.aAq().cover)) {
            return bjVar.aAq().cover;
        }
        if (bjVar.aAh() == null) {
            return null;
        }
        ArrayList<MediaData> aAh = bjVar.aAh();
        int size = aAh.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aAh.get(i);
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
        if (str == null && bjVar.aAo() != null && !TextUtils.isEmpty(bjVar.aAo().thumbnail_url)) {
            return bjVar.aAo().thumbnail_url;
        }
        return str;
    }

    private int y(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.azZ()) {
                return 4;
            }
            if (bjVar.azU() == 1) {
                return 3;
            }
            if (bjVar.ayL()) {
                return 5;
            }
            if (bjVar.aBS()) {
                return 6;
            }
            if (bjVar.aBT()) {
                return 7;
            }
            if (bjVar.aBU()) {
                return 8;
            }
            if (!bjVar.isShareThread || bjVar.cPN == null) {
                return bjVar.aBm() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aW(View view) {
        if (this.ddm == null) {
            this.ddm = new aa(this.mPageContext, isShow(16));
        }
        this.ddm.setData(this.Kn);
        this.ddm.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aX(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ddr = z;
        if (this.dcY != null) {
            this.dcY.setClickable(this.ddr);
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
        this.Kn = bjVar;
        aFM();
        z(bjVar);
        B(bjVar);
        w(bjVar);
        v(bjVar);
        updatePraiseNum(bjVar);
        A(bjVar);
        C(bjVar);
        setVisibility(this.isVisible ? 0 : 8);
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(bj bjVar) {
        this.dcY.setVisibility(8);
    }

    protected void A(bj bjVar) {
        int equipmentWidth;
        if (this.ddo != null && this.mSelectImg != null && this.ddn != null && bjVar != null) {
            if (!this.ddJ) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.ddo.setVisibility(8);
            } else if (this.ddz && com.baidu.tieba.frs.a.bBr().bBs()) {
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
                if (bjVar.aBH()) {
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
                am.setViewTextColor(this.ddn, this.Kn.aBG() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.mSelectImg.setImageDrawable(am.getDrawable(bjVar.aBG() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.ddo.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.ddo.setVisibility(8);
            }
        }
    }

    private void B(bj bjVar) {
        String azz;
        if (this.dcZ != null && bjVar != null) {
            if (bjVar.azQ() <= 0 || !this.ddp) {
                this.dcZ.setVisibility(8);
                return;
            }
            this.dcZ.setVisibility(0);
            if (this.mFrom == 3) {
                azz = bjVar.azA();
            } else {
                azz = bjVar.azz();
            }
            this.dcZ.setText(azz);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(bj bjVar) {
        if (this.ddb != null && bjVar != null) {
            if (this.ddv) {
                this.ddd.setVisibility(0);
                if (bjVar.azO() > 0) {
                    this.ddb.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bjVar.azO());
                    if (this.dds) {
                        SvgManager.aEp().a(this.ddc, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        this.ddb.setText(numFormatOverWan);
                    } else {
                        this.ddb.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.ddb.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.dds) {
                    am.getDrawable(this.ddF);
                    SvgManager.aEp().a(this.ddc, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.ddb.setText(this.mContext.getString(R.string.action_comment_default));
                    this.ddb.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.ddb.setVisibility(8);
                    return;
                }
            }
            this.ddd.setVisibility(8);
        }
    }

    public void updatePraiseNum(bj bjVar) {
        setAgreeViewType(bjVar);
        if (bjVar.aBM() != null) {
            bjVar.aBM().isInThread = true;
            this.dda.setCardType(bjVar.aBY());
            this.dda.setThreadData(bjVar);
            this.dda.setData(bjVar.aBM());
        }
    }

    public void setAgreeViewType(bj bjVar) {
        if (bjVar != null && bjVar.aBV()) {
            this.dda.setAgreeAlone(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(bj bjVar) {
        if (this.ddg != null && this.dde != null && bjVar != null) {
            if (this.ddx) {
                this.ddg.setVisibility(0);
                long aBw = bjVar.aBw();
                if ((bjVar.aBl() || bjVar.aBo()) && bjVar.aAq() != null && bjVar.aAq().share_info != null) {
                    aBw = bjVar.aAq().share_info.share_count;
                }
                this.dde.setText(aBw > 0 ? aq.numFormatOverWan(aBw) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                if (bjVar.cPN != null && bjVar.cPN.cKG) {
                    setShareClickable(false);
                    SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setViewTextColor(this.dde, (int) R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.dde, (int) R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.ddg.setVisibility(8);
        }
    }

    protected void C(bj bjVar) {
        if (this.ddl != null && bjVar != null) {
            this.ddy = isShow(4);
            if (bjVar.cPX != null) {
                this.ddy = false;
            }
            if (this.ddy && (this.ddo == null || this.ddo.getVisibility() == 8)) {
                this.ddl.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.ddj.setText(string);
                this.ddj.setContentDescription(string);
                this.isVisible = true;
                return;
            }
            this.ddl.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.dda != null) {
            this.dda.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.dcY, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dcZ, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.ddb, (int) R.drawable.selector_comment_and_prise_item_text_color);
            am.setViewTextColor(this.ddj, (int) R.drawable.selector_comment_and_prise_item_text_color);
            if (this.ddb != null && this.dds && this.ddF > 0) {
                SvgManager.aEp().a(this.ddc, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.Kn != null && this.Kn.cPN != null && this.Kn.cPN.cKG) {
                setShareClickable(false);
                SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.dde, (int) R.color.cp_cont_e);
            } else {
                setShareClickable(true);
                SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.dde, (int) R.drawable.selector_comment_and_prise_item_text_color);
            }
            SvgManager.aEp().a(this.ddi, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.ddk != null) {
                SvgManager.aEp().a(this.ddk, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.ddm != null) {
                this.ddm.onChangeSkinType();
            }
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            if (this.dda != null) {
                this.dda.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ddE = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.dcY;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.ddw = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.ddp = z;
    }

    public View getCommentNumView() {
        return this.ddb;
    }

    public View getCommentContainer() {
        return this.ddd;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.dds = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.ddt = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.ddz = z;
    }

    public void setManageVisible(boolean z) {
        this.ddy = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.ddH = bVar;
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
        this.ddJ = z;
    }

    public boolean isInFrsAllThread() {
        return this.ddJ;
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
        if (this.ddm != null) {
            this.ddm.destory();
        }
    }

    public void hideDisagree() {
        this.dda.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.ddI = aVar;
    }
}
