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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes20.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bx agB;
    protected TextView aiU;
    private int ajO;
    protected ImageView dax;
    private int ePX;
    protected int eTl;
    protected boolean eVA;
    protected boolean eVB;
    protected boolean eVC;
    protected boolean eVD;
    protected boolean eVE;
    protected boolean eVF;
    protected boolean eVG;
    protected boolean eVH;
    private int eVI;
    public int eVJ;
    public String eVK;
    private String eVL;
    private View.OnClickListener eVM;
    private b eVN;
    private a eVO;
    private boolean eVP;
    CustomMessageListener eVQ;
    private TextView eVh;
    protected AgreeView eVi;
    protected EMTextView eVj;
    protected ImageView eVk;
    protected View eVl;
    protected EMTextView eVm;
    protected ImageView eVn;
    protected View eVo;
    protected FrameLayout eVp;
    protected ImageView eVq;
    protected EMTextView eVr;
    protected ImageView eVs;
    protected View eVt;
    protected ac eVu;
    protected EMTextView eVv;
    protected LinearLayout eVw;
    protected boolean eVx;
    protected boolean eVy;
    protected boolean eVz;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;
    CustomMessageListener mUpdateShareNumListener;

    /* loaded from: classes20.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void jt(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.eVL = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.eVi != null) {
            this.eVi.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.eVI = i;
    }

    public void setGameId(int i) {
        this.ePX = i;
        if (this.eVi != null) {
            this.eVi.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.eVi != null) {
            this.eVi.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eVQ);
        MessageManager.getInstance().registerListener(this.mUpdateShareNumListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eVQ);
        MessageManager.getInstance().unRegisterListener(this.mUpdateShareNumListener);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.eTl = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajO = 11;
        this.eVx = false;
        this.eVy = true;
        this.eVz = true;
        this.eVA = true;
        this.eVB = false;
        this.eVC = false;
        this.eVD = true;
        this.eVE = false;
        this.eVF = true;
        this.eVG = false;
        this.eVH = true;
        this.mFrom = 2;
        this.eVI = 1;
        this.mSkinType = 3;
        this.eVN = null;
        this.eVP = true;
        this.eVQ = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bx)) {
                    bx bxVar = (bx) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.agB != null && bxVar != null) {
                        String str = bxVar.getBaijiahaoData() != null ? bxVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.agB.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.agB.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.agB.of(bxVar.blt());
                                ThreadCommentAndPraiseInfoLayout.this.C(bxVar);
                                return;
                            }
                            return;
                        }
                        String id = bxVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agB.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agB.of(bxVar.blt());
                            ThreadCommentAndPraiseInfoLayout.this.C(bxVar);
                        }
                    }
                }
            }
        };
        this.mUpdateShareNumListener = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agB != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agB.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agB.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agB.bmV() || ThreadCommentAndPraiseInfoLayout.this.agB.bmY()) && ThreadCommentAndPraiseInfoLayout.this.agB.blW() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agB.blW() != null && ThreadCommentAndPraiseInfoLayout.this.agB.blW().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agB.blW().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agB.dk(ThreadCommentAndPraiseInfoLayout.this.agB.bng() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.agB);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eTl = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ajO = 11;
        this.eVx = false;
        this.eVy = true;
        this.eVz = true;
        this.eVA = true;
        this.eVB = false;
        this.eVC = false;
        this.eVD = true;
        this.eVE = false;
        this.eVF = true;
        this.eVG = false;
        this.eVH = true;
        this.mFrom = 2;
        this.eVI = 1;
        this.mSkinType = 3;
        this.eVN = null;
        this.eVP = true;
        this.eVQ = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bx)) {
                    bx bxVar = (bx) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.agB != null && bxVar != null) {
                        String str = bxVar.getBaijiahaoData() != null ? bxVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.agB.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.agB.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.agB.of(bxVar.blt());
                                ThreadCommentAndPraiseInfoLayout.this.C(bxVar);
                                return;
                            }
                            return;
                        }
                        String id = bxVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.agB.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.agB.of(bxVar.blt());
                            ThreadCommentAndPraiseInfoLayout.this.C(bxVar);
                        }
                    }
                }
            }
        };
        this.mUpdateShareNumListener = new CustomMessageListener(2921417) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.agB != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.agB.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.agB.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.agB.bmV() || ThreadCommentAndPraiseInfoLayout.this.agB.bmY()) && ThreadCommentAndPraiseInfoLayout.this.agB.blW() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.agB.blW() != null && ThreadCommentAndPraiseInfoLayout.this.agB.blW().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.agB.blW().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.agB.dk(ThreadCommentAndPraiseInfoLayout.this.agB.bng() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.agB);
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
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.eTl = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aNE();
    }

    protected void aNE() {
        al(ef(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void al(View view) {
        this.aiU = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.eVh = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.eVj = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.eVj).oV(R.string.F_X01);
        this.eVk = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.eVl = view.findViewById(R.id.thread_info_commont_container);
        this.eVm = (EMTextView) view.findViewById(R.id.share_num);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.eVm).oV(R.string.F_X01);
        this.eVn = (ImageView) view.findViewById(R.id.share_num_img);
        this.eVo = view.findViewById(R.id.share_num_container);
        this.eVp = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.eVq = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.eVi = (AgreeView) findViewById;
            this.eVi.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.eVM != null) {
                        ThreadCommentAndPraiseInfoLayout.this.eVM.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.agB);
                }
            });
        }
        this.eVt = view.findViewById(R.id.manage_view_container);
        this.eVr = (EMTextView) view.findViewById(R.id.thread_info_manage_text);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.eVr).oV(R.string.F_X01);
        this.eVs = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.dax = (ImageView) view.findViewById(R.id.manage_select_img);
        this.eVv = (EMTextView) view.findViewById(R.id.manage_select_text);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.eVv).oV(R.string.F_X01);
        this.eVw = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.eVw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.dax.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.eVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dax.performClick();
            }
        });
        this.eVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dax.performClick();
            }
        });
        this.eVl.setOnClickListener(this);
        this.eVo.setOnClickListener(this);
        this.eVt.setOnClickListener(this);
        this.dax.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.ajO = i;
        uk();
    }

    private void uk() {
        int i;
        this.eVo.setVisibility(isShow(1) ? 0 : 8);
        this.eVl.setVisibility(isShow(2) ? 0 : 8);
        View view = this.eVt;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.eVi.setVisibility(isShow(8) ? 0 : 8);
        this.eVi.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.ajO & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aiU) {
            bt(view);
        } else if (view == this.eVl) {
            bq(view);
        } else if (view == this.eVo) {
            br(view);
        } else if (view == this.eVq) {
            bv(view);
        } else if (view == this.eVt) {
            bu(view);
        } else if (view == this.dax) {
            bs(view);
        }
    }

    protected void bs(View view) {
        boolean z = false;
        if (this.dax != null && this.agB != null && this.eVv != null && !this.agB.bnr()) {
            if (!this.agB.bnp() && com.baidu.tieba.frs.b.cwO().cwI()) {
                if (com.baidu.tieba.frs.b.cwO().al(this.agB)) {
                    this.agB.iR(true);
                }
            } else if (!this.agB.bnq() && com.baidu.tieba.frs.a.cwH().cwI()) {
                if (com.baidu.tieba.frs.a.cwH().al(this.agB)) {
                    this.agB.iS(true);
                }
            } else {
                com.baidu.tieba.frs.b.cwO().am(this.agB);
                this.agB.iR(false);
                com.baidu.tieba.frs.a.cwH().am(this.agB);
                this.agB.iS(false);
            }
            if (this.agB.bnp() || this.agB.bnq()) {
                ap.setViewTextColor(this.eVv, R.color.CAM_X0304);
                WebPManager.a(this.dax, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            } else {
                com.baidu.tbadk.core.elementsMaven.c.bj(this.eVv).oY(R.color.CAM_X0107);
                WebPManager.a(this.dax, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            }
            if (this.eVN != null) {
                b bVar = this.eVN;
                if (this.agB.bnp() || this.agB.bnq()) {
                    z = true;
                }
                bVar.jt(z);
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.eVl != null) {
            this.eVl.setClickable(z);
            this.eVk.setEnabled(z);
            this.eVj.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.eVo != null) {
            this.eVo.setClickable(z);
            this.eVn.setEnabled(z);
            this.eVm.setEnabled(z);
        }
    }

    private void bt(View view) {
        if (this.agB != null && !StringUtils.isNull(this.agB.blG())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.eVL)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.agB.blG(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.agB.blG(), this.mStType, this.eVL)));
            }
            if (this.eVM != null) {
                this.eVM.onClick(view);
            }
        }
    }

    private boolean w(bx bxVar) {
        return (bxVar == null || !bxVar.bki() || bxVar.blU() == null) ? false : true;
    }

    protected void bq(View view) {
        if (this.agB != null && this.mContext != null) {
            n.IA(this.agB.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.agB, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.agB.getFid()));
            addLocateParam.setForumName(this.agB.blG());
            if (this.agB.bnt() && this.agB.bns() != null) {
                addLocateParam.setForumId(this.agB.bns().getForumId());
                addLocateParam.setForumName(this.agB.bns().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.eVO != null) {
                this.eVO.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.agB)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.an(this.agB);
            }
            if (this.agB.eFd) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.agB.bmL() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.eVJ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ar arVar = new ar("c12291");
            arVar.ak("obj_locate", this.mFrom);
            TiebaStatic.log(arVar);
            ar arVar2 = new ar("c12942");
            arVar2.ak("obj_locate", this.mFrom);
            arVar2.ak("obj_type", getThreadType());
            arVar2.dR("tid", this.agB.getTid());
            arVar2.dR("nid", this.agB.getNid());
            if (this.mFrom == 18) {
                arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                arVar2.w("fid", this.agB.getFid());
                arVar2.ak("obj_locate", 18);
                arVar2.dR("resource_id", this.mTabName);
            }
            TiebaStatic.log(arVar2);
            bsg();
            a(view, this.agB);
            if (this.eVM != null) {
                this.eVM.onClick(view);
            }
        }
    }

    private void bsg() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            ar arVar = new ar("c13568");
            arVar.ak("obj_source", threadSourceForDynamicAndBjh);
            arVar.ak("obj_type", threadTypeForDynamicAndBjh);
            TiebaStatic.log(arVar);
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
        if (this.agB == null) {
            return 0;
        }
        if (this.agB.bkk()) {
            return 1;
        }
        if (this.agB.bkl()) {
            return 2;
        }
        if (this.agB.bnz()) {
            return 3;
        }
        return this.agB.bnA() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.agB == null) {
            return 0;
        }
        if (this.agB.isShareThread) {
            return 4;
        }
        if (this.agB.getThreadType() == 49) {
            return 5;
        }
        if (this.agB.blU() != null) {
            return 1;
        }
        if (this.agB.getType() == bx.eBR || this.agB.getType() == bx.eCn) {
            if (y.getCount(this.agB.blP()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.agB != null || i >= 0) {
            ar qw = qw(i);
            qw.ak("thread_type", this.agB.getThreadType());
            TiebaStatic.log(qw);
        }
    }

    private ar qw(int i) {
        if (this.agB == null && i < 0) {
            return null;
        }
        ar arVar = new ar("c12003");
        arVar.dR("tid", this.agB.getTid());
        if (this.agB.getThreadType() == 40) {
            arVar.dR("obj_param1", "2");
        } else if (this.agB.getThreadType() == 0) {
            arVar.dR("obj_param1", "1");
        }
        arVar.dR("obj_source", "1");
        arVar.w("fid", this.agB.getFid());
        arVar.ak("obj_locate", this.mFrom);
        arVar.ak("obj_id", i);
        if (!au.isEmpty(this.eVK)) {
            arVar.dR("obj_floor", this.eVK);
        }
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        arVar.dR("nid", this.agB.getNid());
        arVar.ak(IntentConfig.CARD_TYPE, this.agB.bnD());
        arVar.dR(IntentConfig.RECOM_SOURCE, this.agB.mRecomSource);
        arVar.dR("ab_tag", this.agB.mRecomAbTag);
        arVar.dR("weight", this.agB.mRecomWeight);
        arVar.dR("extra", this.agB.mRecomExtra);
        if (this.agB.getBaijiahaoData() != null && !au.isEmpty(this.agB.getBaijiahaoData().oriUgcVid)) {
            arVar.dR("obj_param6", this.agB.getBaijiahaoData().oriUgcVid);
            return arVar;
        }
        return arVar;
    }

    protected void br(View view) {
        if ((ShareSwitch.isOn() || bh.checkUpIsLogin(this.mContext)) && this.agB != null) {
            bsh();
            a(view, this.agB);
            if (!AntiHelper.d(getContext(), this.agB)) {
                bsj();
                if (this.eVM != null) {
                    this.eVM.onClick(view);
                }
            }
        }
    }

    private void bsh() {
        if (this.agB != null) {
            ar bsi = bsi();
            bsi.ak("thread_type", this.agB.getThreadType());
            TiebaStatic.log(bsi);
        }
    }

    private ar bsi() {
        if (this.agB == null) {
            return null;
        }
        int i = 0;
        if (this.eVI == 1) {
            i = 4;
        } else if (this.eVI == 2) {
            i = 5;
        } else if (this.eVI == 3) {
            i = 3;
        } else if (this.eVI == 4) {
            i = 2;
        } else if (this.eVI == 6) {
            i = 8;
        } else if (this.eVI == 7) {
            i = 9;
        } else if (this.eVI == 9) {
            i = 10;
        } else if (this.eVI == 10) {
            i = 17;
        } else if (this.eVI == 18) {
            i = 20;
        }
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        arVar.w("fid", this.agB.getFid());
        arVar.dR("tid", this.agB.getTid());
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.ak("obj_locate", i);
        arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, this.ePX);
        if (!au.isEmpty(this.eVK)) {
            arVar.dR("obj_floor", this.eVK);
        }
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.agB.blW() != null && this.agB.blW().user_info != null && this.agB.blW().user_info.is_official == 2) {
            arVar.ak("obj_isofficial", this.agB.blW().user_info.is_official);
        }
        arVar.ak(IntentConfig.CARD_TYPE, this.agB.bnD()).dR("ab_tag", this.agB.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.agB.mRecomSource).dR("weight", this.agB.mRecomWeight).dR("extra", this.agB.mRecomExtra);
        if (this.agB.bkk()) {
            arVar.ak("obj_type", 10);
        } else if (this.agB.bkl()) {
            arVar.ak("obj_type", 9);
        } else if (this.agB.bnA()) {
            arVar.ak("obj_type", 8);
        } else if (this.agB.bnz()) {
            arVar.ak("obj_type", 7);
        } else if (this.agB.isShareThread) {
            arVar.ak("obj_type", 6);
        } else if (this.agB.threadType == 0) {
            arVar.ak("obj_type", 1);
        } else if (this.agB.threadType == 40) {
            arVar.ak("obj_type", 2);
        } else if (this.agB.threadType == 49) {
            arVar.ak("obj_type", 3);
        } else if (this.agB.threadType == 54) {
            arVar.ak("obj_type", 4);
        } else {
            arVar.ak("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            arVar.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            arVar.dR("obj_tab", "a099");
            arVar.dR("resource_id", this.mTabName);
        }
        if (this.agB.getBaijiahaoData() != null) {
            arVar.dR("obj_param4", this.agB.getBaijiahaoData().oriUgcNid);
            if (this.agB.bkl() || this.agB.bnA()) {
                arVar.dR("obj_param6", this.agB.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.agB.bny()) {
            arVar.ak("obj_param5", 2);
        } else if (this.agB.bkk() || this.agB.bkl()) {
            arVar.ak("obj_param5", 3);
        } else if (this.agB.threadType == 0 || this.agB.threadType == 40) {
            arVar.ak("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), arVar);
        }
        arVar.dR("nid", this.agB.getNid());
        return arVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bx bxVar) {
        int i;
        int i2 = 1;
        if (bxVar != null) {
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
                TiebaStatic.log(com.baidu.tieba.t.a.a("c13694", bxVar, i2, i));
            }
        }
    }

    private void bsj() {
        String tid;
        String str;
        String format;
        String str2;
        if (this.agB != null && this.mContext != null) {
            String valueOf = String.valueOf(this.agB.getFid());
            String blG = this.agB.blG();
            if (this.agB.eEQ != null) {
                valueOf = this.agB.eEQ.id;
                blG = this.agB.eEQ.ori_fname;
            }
            String title = this.agB.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.agB.getAbstract();
            }
            if (this.agB.bkm()) {
                tid = this.agB.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.agB.getBaijiahaoData().oriUgcType + "&dvid=" + this.agB.getBaijiahaoData().oriUgcVid + "&nid=" + this.agB.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.agB.getTid();
                str = "?share=9105&fr=share";
            }
            String str3 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            boolean z = true;
            if (this.agB.blW() != null && this.agB.blW().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.agB.blW().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.agB.blW().user_info.user_name, "utf-8");
                    }
                    str3 = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            String shareImageUrl = getShareImageUrl(this.agB);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str4 = this.agB.getAbstract();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.agB.bkm() || this.agB.blC() == null) {
                format = MessageFormat.format(string, title, str4);
            } else {
                format = (TextUtils.isEmpty(this.agB.getTitle()) || TextUtils.isEmpty(str4)) ? MessageFormat.format(string2, this.agB.blC().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str4;
            }
            String cutString = au.cutString(title, 100);
            String cutString2 = au.cutString(format, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.title = cutString;
            shareItem.content = cutString2;
            int stateThreadType = getStateThreadType(this.agB);
            if (this.agB.bkm()) {
                shareItem.readCount = -1L;
                shareItem.fgc = cutString2;
            } else {
                if (stateThreadType == 2 && this.agB.blU() != null) {
                    shareItem.readCount = this.agB.blU().play_count.intValue();
                } else if (stateThreadType == 1) {
                    shareItem.readCount = this.agB.blu();
                }
                shareItem.fgc = str4;
            }
            shareItem.linkUrl = str3;
            shareItem.extData = tid;
            shareItem.fid = valueOf;
            shareItem.fName = blG;
            shareItem.tid = tid;
            shareItem.ffR = true;
            shareItem.eFG = this.eVI;
            shareItem.fge = getShareObjSource();
            shareItem.fgj = stateThreadType;
            shareItem.fgf = 3;
            shareItem.fgg = getShareObjParam2(this.agB);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            if (this.agB.bkm()) {
                z = false;
            }
            shareItem.canShareBySmartApp = z;
            if (z) {
                shareItem.fgt = this.agB.getShareImageUrl();
            }
            bsk();
            shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agB);
            if (this.mFrom == 13) {
                shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(this.agB, 2);
            } else {
                shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(this.agB);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fgf);
            bundle.putInt("obj_type", shareItem.fgj);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eFG);
            shareItem.ae(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z2 = false;
            shareDialogConfig.setIsAlaLive((this.agB.getThreadType() == 49 || this.agB.getThreadType() == 60) ? true : true);
            a(shareDialogConfig);
            com.baidu.tieba.d.f.coW().b(shareDialogConfig);
        }
    }

    private void bsk() {
        ItemInfo cxe;
        if ((this.mContext instanceof ao) && ((ao) this.mContext).cxf() && this.agB != null && this.agB.bnH() == null && (cxe = ((ao) this.mContext).cxe()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cxe.id.longValue());
            builder.item_name = cxe.name;
            builder.icon_size = cxe.icon_size;
            builder.icon_url = cxe.icon_url;
            builder.tags = cxe.tags;
            if (cxe.score != null && cxe.score.item_point != null) {
                Iterator<ItemPoint> it = cxe.score.item_point.iterator();
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
            this.agB.a(itemData);
        }
    }

    private int getShareObjParam2(bx bxVar) {
        if (bxVar == null) {
            return 0;
        }
        if (bxVar.bkk()) {
            return 10;
        }
        if (bxVar.bkl()) {
            return 9;
        }
        if (bxVar.bnA()) {
            return 8;
        }
        if (bxVar.bnz()) {
            return 7;
        }
        if (bxVar.isShareThread) {
            return 6;
        }
        if (bxVar.threadType == 0) {
            return 1;
        }
        if (bxVar.threadType == 40) {
            return 2;
        }
        if (bxVar.threadType == 49) {
            return 3;
        }
        if (bxVar.threadType == 54) {
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
        if (this.eVI == 1) {
            return 5;
        }
        if (this.eVI != 3) {
            if (this.eVI == 4) {
                return 4;
            }
            if (this.eVI == 6) {
                return 8;
            }
            if (this.eVI != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String getShareImageUrl(bx bxVar) {
        String str;
        if (bxVar == null) {
            return null;
        }
        if (bxVar.blW() != null && !TextUtils.isEmpty(bxVar.blW().cover)) {
            return bxVar.blW().cover;
        }
        if (bxVar.blL() == null) {
            return null;
        }
        ArrayList<MediaData> blL = bxVar.blL();
        int size = blL.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = blL.get(i);
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
        if (str == null && bxVar.blU() != null && !TextUtils.isEmpty(bxVar.blU().thumbnail_url)) {
            return bxVar.blU().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(bx bxVar) {
        if (bxVar != null) {
            if (bxVar.blE()) {
                return 4;
            }
            if (bxVar.blz() == 1) {
                return 3;
            }
            if (bxVar.bkk()) {
                return 5;
            }
            if (bxVar.bkl()) {
                return 6;
            }
            if (bxVar.bnz()) {
                return 7;
            }
            if (bxVar.bnA()) {
                return 8;
            }
            if (!bxVar.isShareThread || bxVar.eEF == null) {
                return bxVar.bmW() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bu(View view) {
        if (this.eVu == null) {
            this.eVu = new ac(this.mPageContext, isShow(16));
        }
        this.eVu.setData(this.agB);
        this.eVu.PA();
        if (this.agB != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.agB.getFid()).dR("tid", this.agB.getId()));
        }
    }

    private void bv(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.eVA = z;
        if (this.aiU != null) {
            this.aiU.setClickable(this.eVA);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(bx bxVar) {
        if (bxVar == null) {
            setVisibility(8);
            return false;
        }
        this.agB = bxVar;
        ahn();
        D(bxVar);
        F(bxVar);
        C(bxVar);
        B(bxVar);
        updatePraiseNum(bxVar);
        E(bxVar);
        G(bxVar);
        setVisibility(this.eVx ? 0 : 8);
        bse();
        return this.eVx;
    }

    protected void bse() {
    }

    protected void ahn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(bx bxVar) {
        this.aiU.setVisibility(8);
    }

    protected void E(bx bxVar) {
        if (this.eVw != null && this.dax != null && this.eVv != null && bxVar != null) {
            if (!this.eVP) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.eVw.setVisibility(8);
            } else if (this.eVH && (com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.dax.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.dax.performClick();
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
                if (this.agB.bnp() || this.agB.bnq()) {
                    ap.setViewTextColor(this.eVv, R.color.CAM_X0304);
                    WebPManager.a(this.dax, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
                } else {
                    com.baidu.tbadk.core.elementsMaven.c.bj(this.eVv).oY(R.color.CAM_X0107);
                    WebPManager.a(this.dax, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                }
                this.mMaskView.setVisibility(0);
                this.eVw.setVisibility(8);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.eVw.setVisibility(8);
            }
        }
    }

    private void F(bx bxVar) {
        String blf;
        if (this.eVh != null && bxVar != null) {
            if (bxVar.blv() <= 0 || !this.eVy) {
                this.eVh.setVisibility(8);
                return;
            }
            this.eVh.setVisibility(0);
            if (this.mFrom == 3) {
                blf = bxVar.blg();
            } else {
                blf = bxVar.blf();
            }
            this.eVh.setText(blf);
            this.eVx = true;
        }
    }

    public boolean isVisible() {
        return this.eVx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(bx bxVar) {
        if (this.eVj != null && bxVar != null) {
            if (this.eVD) {
                this.eVl.setVisibility(0);
                if (bxVar.blt() > 0) {
                    this.eVj.setVisibility(0);
                    String numFormatOverWan = au.numFormatOverWan(bxVar.blt());
                    if (this.eVB) {
                        updateReplyStateUI();
                        this.eVj.setText(numFormatOverWan);
                    } else {
                        this.eVj.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.eVj.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.eVx = true;
                    return;
                } else if (this.eVB) {
                    updateReplyStateUI();
                    this.eVj.setText(this.mContext.getString(R.string.action_comment_default));
                    this.eVj.setVisibility(0);
                    this.eVx = true;
                    return;
                } else {
                    this.eVj.setVisibility(8);
                    return;
                }
            }
            this.eVl.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        if (this.eVB) {
            WebPManager.a(this.eVk, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
        com.baidu.tbadk.core.elementsMaven.c.bj(this.eVj).oY(R.color.CAM_X0107);
    }

    public void updatePraiseNum(bx bxVar) {
        setAgreeViewType(bxVar);
        if (bxVar.bnv() != null) {
            bxVar.bnv().isInThread = true;
            this.eVi.setCardType(bxVar.bnD());
            this.eVi.setThreadData(bxVar);
            this.eVi.setData(bxVar.bnv());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bx bxVar) {
        if (this.eVo != null && this.eVm != null && bxVar != null) {
            if (this.eVF) {
                this.eVo.setVisibility(0);
                long bng = bxVar.bng();
                if ((bxVar.bmV() || bxVar.bmY()) && bxVar.blW() != null && bxVar.blW().share_info != null) {
                    bng = bxVar.blW().share_info.share_count;
                }
                this.eVm.setText(bng > 0 ? au.numFormatOverWan(bng) : this.mContext.getString(R.string.share));
                this.eVx = true;
                updateShareStateUI(bxVar);
                return;
            }
            this.eVo.setVisibility(8);
        }
    }

    public void updateShareStateUI(bx bxVar) {
        WebPManager.a(this.eVn, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        if (AntiHelper.bb(bxVar)) {
            setShareClickable(true);
            this.eVm.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0107), ap.eMz));
        } else if (bxVar != null && bxVar.eEF != null && this.agB.eEF.ezh) {
            setShareClickable(false);
            this.eVm.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0107), ap.eMz));
        } else {
            setShareClickable(true);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.eVm).oY(R.color.CAM_X0107);
        }
    }

    protected void G(bx bxVar) {
        if (this.eVt != null && bxVar != null) {
            this.eVG = isShow(4);
            if (bxVar.eEQ != null) {
                this.eVG = false;
            }
            if (this.eVG && (this.eVw == null || this.eVw.getVisibility() == 8)) {
                this.eVt.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.eVr.setText(string);
                this.eVr.setContentDescription(string);
                this.eVx = true;
                return;
            }
            this.eVt.setVisibility(isShow(64) ? 4 : 8);
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.eVi != null) {
            this.eVi.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            ap.setViewTextColor(this.aiU, R.color.CAM_X0109);
            ap.setViewTextColor(this.eVh, R.color.CAM_X0107);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.eVr).oY(R.color.CAM_X0107);
            updateReplyStateUI();
            updateShareStateUI(this.agB);
            WebPManager.a(this.eVs, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (this.eVu != null) {
                this.eVu.onChangeSkinType();
            }
            if (this.eVi != null) {
                this.eVi.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eVM = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aiU;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.eVE = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.eVy = z;
    }

    public View getCommentNumView() {
        return this.eVj;
    }

    public View getCommentContainer() {
        return this.eVl;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.eVB = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.eVC = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.eVF = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVk.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.eVk.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.eVF = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVk.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.eVk.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.eVH = z;
    }

    public void setManageVisible(boolean z) {
        this.eVG = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.eVN = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.dax);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.eVP = z;
    }

    public boolean isInFrsAllThread() {
        return this.eVP;
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
        if (this.eVu != null) {
            this.eVu.destory();
        }
    }

    public void setAgreeViewType(bx bxVar) {
        if (bxVar != null && bxVar.bkm()) {
            this.eVi.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.eVi.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.eVO = aVar;
    }
}
