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
/* loaded from: classes5.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bj Ki;
    private int MY;
    private int cZa;
    protected int dcN;
    protected TextView dcO;
    private TextView dcP;
    protected AgreeView dcQ;
    protected TextView dcR;
    protected ImageView dcS;
    protected View dcT;
    protected TextView dcU;
    protected ImageView dcV;
    protected View dcW;
    protected FrameLayout dcX;
    protected ImageView dcY;
    protected TextView dcZ;
    CustomMessageListener ddA;
    CustomMessageListener ddB;
    protected ImageView dda;
    protected View ddb;
    protected aa ddc;
    protected TextView ddd;
    protected LinearLayout dde;
    protected boolean ddf;
    protected boolean ddg;
    protected boolean ddh;
    protected boolean ddi;
    protected boolean ddj;
    protected boolean ddk;
    protected boolean ddl;
    protected boolean ddm;
    protected boolean ddn;
    protected boolean ddo;
    private int ddp;
    public int ddq;
    public String ddr;
    private String dds;
    private View.OnClickListener ddt;
    protected int ddv;
    protected int ddw;
    private b ddx;
    private a ddy;
    private boolean ddz;
    protected boolean isVisible;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    protected ImageView mSelectImg;
    private int mSkinType;
    private String mStType;

    /* loaded from: classes5.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void fH(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.dds = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.ddp = i;
    }

    public void setGameId(int i) {
        this.cZa = i;
        if (this.dcQ != null) {
            this.dcQ.setGameId(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.ddA);
        MessageManager.getInstance().registerListener(this.ddB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ddA);
        MessageManager.getInstance().unRegisterListener(this.ddB);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.dcN = 0;
        this.MY = 11;
        this.isVisible = false;
        this.ddf = true;
        this.ddg = true;
        this.ddh = true;
        this.ddi = false;
        this.ddj = false;
        this.ddk = true;
        this.ddl = false;
        this.ddm = true;
        this.ddn = false;
        this.ddo = true;
        this.mFrom = 2;
        this.ddp = 1;
        this.mSkinType = 3;
        this.ddx = null;
        this.ddz = false;
        this.ddA = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.Ki != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.Ki.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.Ki.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.Ki.js(bjVar.azv());
                                ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.Ki.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.Ki.js(bjVar.azv());
                            ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                        }
                    }
                }
            }
        };
        this.ddB = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.Ki != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.Ki.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.Ki.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.Ki.aAS() || ThreadCommentAndPraiseInfoLayout.this.Ki.aAV()) && ThreadCommentAndPraiseInfoLayout.this.Ki.azX() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.Ki.azX() != null && ThreadCommentAndPraiseInfoLayout.this.Ki.azX().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.Ki.azX().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.Ki.br(ThreadCommentAndPraiseInfoLayout.this.Ki.aBd() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.v(ThreadCommentAndPraiseInfoLayout.this.Ki);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dcN = 0;
        this.MY = 11;
        this.isVisible = false;
        this.ddf = true;
        this.ddg = true;
        this.ddh = true;
        this.ddi = false;
        this.ddj = false;
        this.ddk = true;
        this.ddl = false;
        this.ddm = true;
        this.ddn = false;
        this.ddo = true;
        this.mFrom = 2;
        this.ddp = 1;
        this.mSkinType = 3;
        this.ddx = null;
        this.ddz = false;
        this.ddA = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bj)) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.Ki != null && bjVar != null) {
                        String str = bjVar.getBaijiahaoData() != null ? bjVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.Ki.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.Ki.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.Ki.js(bjVar.azv());
                                ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                                return;
                            }
                            return;
                        }
                        String id = bjVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.Ki.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.Ki.js(bjVar.azv());
                            ThreadCommentAndPraiseInfoLayout.this.w(bjVar);
                        }
                    }
                }
            }
        };
        this.ddB = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.Ki != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.Ki.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.Ki.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.Ki.aAS() || ThreadCommentAndPraiseInfoLayout.this.Ki.aAV()) && ThreadCommentAndPraiseInfoLayout.this.Ki.azX() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.Ki.azX() != null && ThreadCommentAndPraiseInfoLayout.this.Ki.azX().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.Ki.azX().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.Ki.br(ThreadCommentAndPraiseInfoLayout.this.Ki.aBd() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.v(ThreadCommentAndPraiseInfoLayout.this.Ki);
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
        this.dcN = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View dN = dN(context);
        this.dcO = (TextView) dN.findViewById(R.id.thread_info_bar_name);
        this.dcP = (TextView) dN.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) dN.findViewById(R.id.thread_comment_layout_root);
        this.dcR = (TextView) dN.findViewById(R.id.thread_info_commont_num);
        this.dcS = (ImageView) dN.findViewById(R.id.thread_info_commont_img);
        this.dcT = dN.findViewById(R.id.thread_info_commont_container);
        this.dcU = (TextView) dN.findViewById(R.id.share_num);
        this.dcV = (ImageView) dN.findViewById(R.id.share_num_img);
        this.dcW = dN.findViewById(R.id.share_num_container);
        this.dcX = (FrameLayout) dN.findViewById(R.id.btn_card_bottom_op_more_container);
        this.dcY = (ImageView) dN.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = dN.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.dcQ = (AgreeView) findViewById;
            this.dcQ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadCommentAndPraiseInfoLayout.this.ddt != null) {
                        ThreadCommentAndPraiseInfoLayout.this.ddt.onClick(view);
                    }
                }
            });
        }
        this.ddb = dN.findViewById(R.id.manage_view_container);
        this.dcZ = (TextView) dN.findViewById(R.id.thread_info_manage_text);
        this.dda = (ImageView) dN.findViewById(R.id.thread_info_manage_img);
        this.mSelectImg = (ImageView) dN.findViewById(R.id.manage_select_img);
        this.ddd = (TextView) dN.findViewById(R.id.manage_select_text);
        this.dde = (LinearLayout) dN.findViewById(R.id.manage_select_container);
        this.dde.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ddd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dde.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.mSelectImg.performClick();
            }
        });
        this.dcT.setOnClickListener(this);
        this.dcW.setOnClickListener(this);
        this.ddb.setOnClickListener(this);
        this.mSelectImg.setOnClickListener(this);
        this.ddw = R.drawable.icon_home_card_share;
        this.ddv = R.drawable.icon_home_card_comment;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    public void setShowFlag(int i) {
        this.MY = i;
        mZ();
    }

    private void mZ() {
        int i;
        this.dcW.setVisibility(isShow(1) ? 0 : 8);
        this.dcT.setVisibility(isShow(2) ? 0 : 8);
        View view = this.ddb;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.dcQ.setVisibility(isShow(8) ? 0 : 8);
        this.dcQ.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.MY & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dcO) {
            aR(view);
        } else if (view == this.dcT) {
            aO(view);
        } else if (view == this.dcW) {
            aP(view);
        } else if (view == this.dcY) {
            aT(view);
        } else if (view == this.ddb) {
            aS(view);
        } else if (view == this.mSelectImg) {
            aQ(view);
        }
    }

    protected void aQ(View view) {
        if (this.mSelectImg != null && this.Ki != null && this.ddd != null && !this.Ki.aBo()) {
            if (!this.Ki.aBn()) {
                if (com.baidu.tieba.frs.a.bAp().af(this.Ki)) {
                    this.Ki.fq(true);
                }
            } else {
                com.baidu.tieba.frs.a.bAp().ag(this.Ki);
                this.Ki.fq(false);
            }
            am.setViewTextColor(this.ddd, this.Ki.aBn() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.mSelectImg.setImageDrawable(am.getDrawable(this.Ki.aBn() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.ddx != null) {
                this.ddx.fH(this.Ki.aBn());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.dcT != null) {
            this.dcT.setClickable(z);
            this.dcS.setEnabled(z);
            this.dcR.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.dcW != null) {
            this.dcW.setClickable(z);
            this.dcV.setEnabled(z);
            this.dcU.setEnabled(z);
        }
    }

    private void aR(View view) {
        if (this.Ki != null && !StringUtils.isNull(this.Ki.azJ())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.dds)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.Ki.azJ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.Ki.azJ(), this.mStType, this.dds)));
            }
            if (this.ddt != null) {
                this.ddt.onClick(view);
            }
        }
    }

    private boolean t(bj bjVar) {
        return (bjVar == null || !bjVar.aAE() || bjVar.azV() == null) ? false : true;
    }

    protected void aO(View view) {
        if (this.Ki != null && this.mContext != null) {
            com.baidu.tieba.card.l.zs(this.Ki.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.Ki, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.Ki.getFid()));
            addLocateParam.setForumName(this.Ki.azJ());
            if (this.Ki.aBr() && this.Ki.aBq() != null) {
                addLocateParam.setForumId(this.Ki.aBq().getForumId());
                addLocateParam.setForumName(this.Ki.aBq().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.ddy != null) {
                this.ddy.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && t(this.Ki)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.i.ah(this.Ki);
            }
            if (this.Ki.cQa) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.Ki.aAJ() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.ddq);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.Z("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.Z("obj_locate", this.mFrom);
            anVar2.Z("obj_type", getThreadType());
            anVar2.cp("tid", this.Ki.getTid());
            TiebaStatic.log(anVar2);
            aFp();
            if (this.ddt != null) {
                this.ddt.onClick(view);
            }
        }
    }

    private void aFp() {
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
        if (this.Ki == null) {
            return 0;
        }
        if (this.Ki.ays()) {
            return 1;
        }
        if (this.Ki.aBz()) {
            return 2;
        }
        if (this.Ki.aBA()) {
            return 3;
        }
        return this.Ki.aBB() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.Ki == null) {
            return 0;
        }
        if (this.Ki.isShareThread) {
            return 4;
        }
        if (this.Ki.getThreadType() == 49) {
            return 5;
        }
        if (this.Ki.azV() != null) {
            return 1;
        }
        if (this.Ki.getType() == bj.cMV || this.Ki.getType() == bj.cNk) {
            if (v.getCount(this.Ki.azS()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.Ki != null || i >= 0) {
            an kW = kW(i);
            kW.Z("thread_type", this.Ki.getThreadType());
            TiebaStatic.log(kW);
        }
    }

    private an kW(int i) {
        if (this.Ki == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.cp("tid", this.Ki.getTid());
        if (this.Ki.getThreadType() == 40) {
            anVar.cp("obj_param1", "2");
        } else if (this.Ki.getThreadType() == 0) {
            anVar.cp("obj_param1", "1");
        }
        anVar.cp("obj_source", "1");
        anVar.s("fid", this.Ki.getFid());
        anVar.Z("obj_locate", this.mFrom);
        anVar.Z("obj_id", i);
        if (!aq.isEmpty(this.ddr)) {
            anVar.cp("obj_floor", this.ddr);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aP(View view) {
        if ((ShareSwitch.isOn() || bc.checkUpIsLogin(this.mContext)) && this.Ki != null) {
            aFq();
            aFs();
            if (this.ddt != null) {
                this.ddt.onClick(view);
            }
        }
    }

    private void aFq() {
        if (this.Ki != null) {
            an aFr = aFr();
            aFr.Z("thread_type", this.Ki.getThreadType());
            TiebaStatic.log(aFr);
        }
    }

    private an aFr() {
        if (this.Ki == null) {
            return null;
        }
        int i = 0;
        if (this.ddp == 1) {
            i = 4;
        } else if (this.ddp == 2) {
            i = 5;
        } else if (this.ddp == 3) {
            i = 3;
        } else if (this.ddp == 4) {
            i = 2;
        } else if (this.ddp == 6) {
            i = 8;
        } else if (this.ddp == 7) {
            i = 9;
        } else if (this.ddp == 9) {
            i = 10;
        } else if (this.ddp == 10) {
            i = 17;
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("fid", this.Ki.getFid());
        anVar.cp("tid", this.Ki.getTid());
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.Z("obj_locate", i);
        anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, this.cZa);
        if (!aq.isEmpty(this.ddr)) {
            anVar.cp("obj_floor", this.ddr);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.Ki.azX() != null && this.Ki.azX().user_info != null && this.Ki.azX().user_info.is_official == 2) {
            anVar.Z("obj_isofficial", this.Ki.azX().user_info.is_official);
        }
        anVar.Z("card_type", this.Ki.aBF()).cp(TiebaInitialize.Params.AB_TAG, this.Ki.mRecomAbTag).cp("source", this.Ki.mRecomSource).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, this.Ki.mRecomWeight).cp("extra", this.Ki.mRecomExtra);
        if (this.Ki.isShareThread) {
            anVar.Z("obj_type", 6);
        } else if (this.Ki.threadType == 0) {
            anVar.Z("obj_type", 1);
        } else if (this.Ki.threadType == 40) {
            anVar.Z("obj_type", 2);
        } else if (this.Ki.threadType == 49) {
            anVar.Z("obj_type", 3);
        } else if (this.Ki.threadType == 54) {
            anVar.Z("obj_type", 4);
        } else {
            anVar.Z("obj_type", 5);
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
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aFs() {
        String str;
        boolean z;
        Uri parse;
        ShareItem shareItem;
        String str2;
        boolean z2 = false;
        if (this.Ki != null && this.mContext != null) {
            if (this.Ki.aBC() && !TbadkCoreApplication.isLogin()) {
                bc.skipToLoginActivity(this.mContext);
                return;
            }
            String valueOf = String.valueOf(this.Ki.getFid());
            String azJ = this.Ki.azJ();
            if (this.Ki.cPN != null) {
                valueOf = this.Ki.cPN.id;
                azJ = this.Ki.cPN.ori_fname;
            }
            String title = this.Ki.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.Ki.getAbstract();
            }
            String tid = this.Ki.getTid();
            String str3 = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            if (this.Ki.azX() != null && this.Ki.azX().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.Ki.azX().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.Ki.azX().user_info.user_name, "utf-8");
                    }
                    str = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String x = x(this.Ki);
                parse = x != null ? null : Uri.parse(x);
                String str4 = this.Ki.getAbstract();
                String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str4);
                shareItem = new ShareItem();
                shareItem.title = title;
                shareItem.content = format;
                shareItem.dlC = str4;
                shareItem.linkUrl = str;
                shareItem.extData = tid;
                shareItem.fid = valueOf;
                shareItem.fName = azJ;
                shareItem.tid = tid;
                shareItem.dlt = true;
                shareItem.cQo = this.ddp;
                shareItem.dlE = getShareObjSource();
                shareItem.dlJ = y(this.Ki);
                shareItem.dlF = 3;
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (!this.Ki.isBjh() || this.Ki.aBC()) {
                    shareItem.dlP = false;
                    z = false;
                }
                shareItem.canShareBySmartApp = z;
                if (z) {
                    shareItem.dlT = this.Ki.getShareImageUrl();
                }
                shareItem.dlM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.Ki);
                if (this.mFrom != 13) {
                    shareItem.dlN = ShareItem.ForwardInfo.generateForwardInfo(this.Ki, 2);
                } else {
                    shareItem.dlN = ShareItem.ForwardInfo.generateForwardInfo(this.Ki);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.dlF);
                bundle.putInt("obj_type", shareItem.dlJ);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putInt("obj_source", shareItem.cQo);
                shareItem.Y(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                if (this.Ki.getThreadType() != 49 || this.Ki.getThreadType() == 60) {
                    z2 = true;
                }
                shareDialogConfig.setIsAlaLive(z2);
                com.baidu.tieba.c.e.btE().a(shareDialogConfig);
            }
            str = str3;
            z = true;
            String x2 = x(this.Ki);
            if (x2 != null) {
            }
            String str42 = this.Ki.getAbstract();
            String format2 = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str42);
            shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format2;
            shareItem.dlC = str42;
            shareItem.linkUrl = str;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = azJ;
            shareItem.tid = tid;
            shareItem.dlt = true;
            shareItem.cQo = this.ddp;
            shareItem.dlE = getShareObjSource();
            shareItem.dlJ = y(this.Ki);
            shareItem.dlF = 3;
            if (parse != null) {
            }
            if (!this.Ki.isBjh()) {
            }
            shareItem.dlP = false;
            z = false;
            shareItem.canShareBySmartApp = z;
            if (z) {
            }
            shareItem.dlM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.Ki);
            if (this.mFrom != 13) {
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem.dlF);
            bundle2.putInt("obj_type", shareItem.dlJ);
            bundle2.putString("fid", shareItem.fid);
            bundle2.putString("tid", shareItem.tid);
            bundle2.putInt("obj_source", shareItem.cQo);
            shareItem.Y(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, shareItem, true, true);
            if (this.Ki.getThreadType() != 49) {
            }
            z2 = true;
            shareDialogConfig2.setIsAlaLive(z2);
            com.baidu.tieba.c.e.btE().a(shareDialogConfig2);
        }
    }

    private int getShareObjSource() {
        if (this.ddp == 1) {
            return 5;
        }
        if (this.ddp != 3) {
            if (this.ddp == 4) {
                return 4;
            }
            if (this.ddp != 6) {
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
        if (bjVar.azX() != null && !TextUtils.isEmpty(bjVar.azX().cover)) {
            return bjVar.azX().cover;
        }
        if (bjVar.azO() == null) {
            return null;
        }
        ArrayList<MediaData> azO = bjVar.azO();
        int size = azO.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = azO.get(i);
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
        if (str == null && bjVar.azV() != null && !TextUtils.isEmpty(bjVar.azV().thumbnail_url)) {
            return bjVar.azV().thumbnail_url;
        }
        return str;
    }

    private int y(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.azG()) {
                return 4;
            }
            if (bjVar.azB() == 1) {
                return 3;
            }
            if (bjVar.ays()) {
                return 5;
            }
            if (bjVar.aBz()) {
                return 6;
            }
            if (bjVar.aBA()) {
                return 7;
            }
            if (bjVar.aBB()) {
                return 8;
            }
            if (!bjVar.isShareThread || bjVar.cPD == null) {
                return bjVar.aAT() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void aS(View view) {
        if (this.ddc == null) {
            this.ddc = new aa(this.mPageContext, isShow(16));
        }
        this.ddc.setData(this.Ki);
        this.ddc.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aT(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ddh = z;
        if (this.dcO != null) {
            this.dcO.setClickable(this.ddh);
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
        this.Ki = bjVar;
        aFt();
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
    public void aFt() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(bj bjVar) {
        this.dcO.setVisibility(8);
    }

    protected void A(bj bjVar) {
        int equipmentWidth;
        if (this.dde != null && this.mSelectImg != null && this.ddd != null && bjVar != null) {
            if (!this.ddz) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dde.setVisibility(8);
            } else if (this.ddo && com.baidu.tieba.frs.a.bAp().bAq()) {
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
                if (bjVar.aBo()) {
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
                am.setViewTextColor(this.ddd, this.Ki.aBn() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.mSelectImg.setImageDrawable(am.getDrawable(bjVar.aBn() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.dde.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.dde.setVisibility(8);
            }
        }
    }

    private void B(bj bjVar) {
        String azg;
        if (this.dcP != null && bjVar != null) {
            if (bjVar.azx() <= 0 || !this.ddf) {
                this.dcP.setVisibility(8);
                return;
            }
            this.dcP.setVisibility(0);
            if (this.mFrom == 3) {
                azg = bjVar.azh();
            } else {
                azg = bjVar.azg();
            }
            this.dcP.setText(azg);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(bj bjVar) {
        if (this.dcR != null && bjVar != null) {
            if (this.ddk) {
                this.dcT.setVisibility(0);
                if (bjVar.azv() > 0) {
                    this.dcR.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bjVar.azv());
                    if (this.ddi) {
                        SvgManager.aDW().a(this.dcS, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        this.dcR.setText(numFormatOverWan);
                    } else {
                        this.dcR.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.dcR.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.ddi) {
                    am.getDrawable(this.ddv);
                    SvgManager.aDW().a(this.dcS, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.dcR.setText(this.mContext.getString(R.string.action_comment_default));
                    this.dcR.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.dcR.setVisibility(8);
                    return;
                }
            }
            this.dcT.setVisibility(8);
        }
    }

    public void updatePraiseNum(bj bjVar) {
        setAgreeViewType(bjVar);
        if (bjVar.aBt() != null) {
            bjVar.aBt().isInThread = true;
            this.dcQ.setCardType(bjVar.aBF());
            this.dcQ.setThreadData(bjVar);
            this.dcQ.setData(bjVar.aBt());
        }
    }

    public void setAgreeViewType(bj bjVar) {
        if (bjVar != null && bjVar.aBC()) {
            this.dcQ.setAgreeAlone(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(bj bjVar) {
        if (this.dcW != null && this.dcU != null && bjVar != null) {
            if (this.ddm) {
                this.dcW.setVisibility(0);
                long aBd = bjVar.aBd();
                if ((bjVar.aAS() || bjVar.aAV()) && bjVar.azX() != null && bjVar.azX().share_info != null) {
                    aBd = bjVar.azX().share_info.share_count;
                }
                this.dcU.setText(aBd > 0 ? aq.numFormatOverWan(aBd) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                if (bjVar.cPD != null && bjVar.cPD.cKv) {
                    setShareClickable(false);
                    SvgManager.aDW().a(this.dcV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setViewTextColor(this.dcU, (int) R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                SvgManager.aDW().a(this.dcV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.dcU, (int) R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.dcW.setVisibility(8);
        }
    }

    protected void C(bj bjVar) {
        if (this.ddb != null && bjVar != null) {
            this.ddn = isShow(4);
            if (bjVar.cPN != null) {
                this.ddn = false;
            }
            if (this.ddn && (this.dde == null || this.dde.getVisibility() == 8)) {
                this.ddb.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.dcZ.setText(string);
                this.dcZ.setContentDescription(string);
                this.isVisible = true;
                return;
            }
            this.ddb.setVisibility(8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.dcQ != null) {
            this.dcQ.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.dcO, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.dcP, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.dcR, (int) R.drawable.selector_comment_and_prise_item_text_color);
            am.setViewTextColor(this.dcZ, (int) R.drawable.selector_comment_and_prise_item_text_color);
            if (this.dcR != null && this.ddi && this.ddv > 0) {
                SvgManager.aDW().a(this.dcS, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.Ki != null && this.Ki.cPD != null && this.Ki.cPD.cKv) {
                setShareClickable(false);
                SvgManager.aDW().a(this.dcV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.dcU, (int) R.color.cp_cont_e);
            } else {
                setShareClickable(true);
                SvgManager.aDW().a(this.dcV, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.dcU, (int) R.drawable.selector_comment_and_prise_item_text_color);
            }
            SvgManager.aDW().a(this.dcY, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.dda != null) {
                SvgManager.aDW().a(this.dda, R.drawable.icon_pure_card_administration24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.ddc != null) {
                this.ddc.onChangeSkinType();
            }
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            if (this.dcQ != null) {
                this.dcQ.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ddt = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.dcO;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.ddl = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.ddf = z;
    }

    public View getCommentNumView() {
        return this.dcR;
    }

    public View getCommentContainer() {
        return this.dcT;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.ddi = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.ddj = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.ddo = z;
    }

    public void setManageVisible(boolean z) {
        this.ddn = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.ddx = bVar;
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
        this.ddz = z;
    }

    public boolean isInFrsAllThread() {
        return this.ddz;
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
        if (this.ddc != null) {
            this.ddc.destory();
        }
    }

    public void hideDisagree() {
        this.dcQ.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.ddy = aVar;
    }
}
