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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bz ahu;
    protected TextView ajE;
    private int akz;
    protected ImageView dhB;
    private int fce;
    protected int ffz;
    private TextView fhC;
    protected AgreeView fhD;
    protected EMTextView fhE;
    protected ImageView fhF;
    protected View fhG;
    protected EMTextView fhH;
    protected ImageView fhI;
    protected View fhJ;
    protected FrameLayout fhK;
    protected ImageView fhL;
    protected EMTextView fhM;
    protected ImageView fhN;
    protected View fhO;
    protected ab fhP;
    protected EMTextView fhQ;
    protected LinearLayout fhR;
    protected boolean fhS;
    protected boolean fhT;
    protected boolean fhU;
    protected boolean fhV;
    protected boolean fhW;
    protected boolean fhX;
    protected boolean fhY;
    protected boolean fhZ;
    protected boolean fia;
    protected boolean fib;
    private int fic;
    public int fie;
    public String fif;
    private String fig;
    private View.OnClickListener fih;
    private b fii;
    private a fij;
    private boolean fik;
    CustomMessageListener fil;
    protected boolean isVisible;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;
    private String mTabName;
    CustomMessageListener mUpdateShareNumListener;

    /* loaded from: classes.dex */
    public interface a {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes.dex */
    public interface b {
        void kb(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.fig = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.fhD != null) {
            this.fhD.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.fic = i;
    }

    public void setGameId(int i) {
        this.fce = i;
        if (this.fhD != null) {
            this.fhD.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.fhD != null) {
            this.fhD.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fil);
        MessageManager.getInstance().registerListener(this.mUpdateShareNumListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fil);
        MessageManager.getInstance().unRegisterListener(this.mUpdateShareNumListener);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ffz = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.akz = 11;
        this.isVisible = false;
        this.fhS = true;
        this.fhT = true;
        this.fhU = true;
        this.fhV = false;
        this.fhW = false;
        this.fhX = true;
        this.fhY = false;
        this.fhZ = true;
        this.fia = false;
        this.fib = true;
        this.mFrom = 2;
        this.fic = 1;
        this.mSkinType = 3;
        this.fii = null;
        this.fik = true;
        this.fil = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bz)) {
                    bz bzVar = (bz) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.ahu != null && bzVar != null) {
                        String str = bzVar.getBaijiahaoData() != null ? bzVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.ahu.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.ahu.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.ahu.nh(bzVar.bno());
                                ThreadCommentAndPraiseInfoLayout.this.C(bzVar);
                                return;
                            }
                            return;
                        }
                        String id = bzVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.ahu.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.ahu.nh(bzVar.bno());
                            ThreadCommentAndPraiseInfoLayout.this.C(bzVar);
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
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.ahu != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.ahu.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.ahu.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.ahu.boR() || ThreadCommentAndPraiseInfoLayout.this.ahu.boU()) && ThreadCommentAndPraiseInfoLayout.this.ahu.bnQ() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.ahu.bnQ() != null && ThreadCommentAndPraiseInfoLayout.this.ahu.bnQ().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.ahu.bnQ().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.ahu.dJ(ThreadCommentAndPraiseInfoLayout.this.ahu.bpc() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.ahu);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffz = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.akz = 11;
        this.isVisible = false;
        this.fhS = true;
        this.fhT = true;
        this.fhU = true;
        this.fhV = false;
        this.fhW = false;
        this.fhX = true;
        this.fhY = false;
        this.fhZ = true;
        this.fia = false;
        this.fib = true;
        this.mFrom = 2;
        this.fic = 1;
        this.mSkinType = 3;
        this.fii = null;
        this.fik = true;
        this.fil = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bz)) {
                    bz bzVar = (bz) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.ahu != null && bzVar != null) {
                        String str = bzVar.getBaijiahaoData() != null ? bzVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.ahu.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.ahu.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.ahu.nh(bzVar.bno());
                                ThreadCommentAndPraiseInfoLayout.this.C(bzVar);
                                return;
                            }
                            return;
                        }
                        String id = bzVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.ahu.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.ahu.nh(bzVar.bno());
                            ThreadCommentAndPraiseInfoLayout.this.C(bzVar);
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
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.ahu != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.ahu.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.ahu.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.ahu.boR() || ThreadCommentAndPraiseInfoLayout.this.ahu.boU()) && ThreadCommentAndPraiseInfoLayout.this.ahu.bnQ() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.ahu.bnQ() != null && ThreadCommentAndPraiseInfoLayout.this.ahu.bnQ().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.ahu.bnQ().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.ahu.dJ(ThreadCommentAndPraiseInfoLayout.this.ahu.bpc() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.ahu);
                    }
                }
            }
        };
        init(context);
    }

    protected View fe(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.ffz = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aPm();
    }

    protected void aPm() {
        ap(fe(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ap(View view) {
        this.ajE = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fhC = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.fhE = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fhE).nX(R.string.F_X01);
        this.fhF = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fhG = view.findViewById(R.id.thread_info_commont_container);
        this.fhH = (EMTextView) view.findViewById(R.id.share_num);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fhH).nX(R.string.F_X01);
        this.fhI = (ImageView) view.findViewById(R.id.share_num_img);
        this.fhJ = view.findViewById(R.id.share_num_container);
        this.fhK = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.fhL = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.fhD = (AgreeView) findViewById;
            this.fhD.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.fih != null) {
                        ThreadCommentAndPraiseInfoLayout.this.fih.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.ahu);
                }
            });
        }
        this.fhO = view.findViewById(R.id.manage_view_container);
        this.fhM = (EMTextView) view.findViewById(R.id.thread_info_manage_text);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fhM).nX(R.string.F_X01);
        this.fhN = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.dhB = (ImageView) view.findViewById(R.id.manage_select_img);
        this.fhQ = (EMTextView) view.findViewById(R.id.manage_select_text);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fhQ).nX(R.string.F_X01);
        this.fhR = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.fhR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.dhB.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.fhQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dhB.performClick();
            }
        });
        this.fhR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.dhB.performClick();
            }
        });
        this.fhG.setOnClickListener(this);
        this.fhJ.setOnClickListener(this);
        this.fhO.setOnClickListener(this);
        this.dhB.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.akz = i;
        tB();
    }

    private void tB() {
        int i;
        this.fhJ.setVisibility(isShow(1) ? 0 : 8);
        this.fhG.setVisibility(isShow(2) ? 0 : 8);
        View view = this.fhO;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.fhD.setVisibility(isShow(8) ? 0 : 8);
        this.fhD.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.akz & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahu == null || this.ahu.getType() != bz.eOR) {
            if (view == this.ajE) {
                bF(view);
            } else if (view == this.fhG) {
                bC(view);
            } else if (view == this.fhJ) {
                bD(view);
            } else if (view == this.fhL) {
                bH(view);
            } else if (view == this.fhO) {
                bG(view);
            } else if (view == this.dhB) {
                bE(view);
            }
        }
    }

    protected void bE(View view) {
        boolean z = false;
        if (this.dhB != null && this.ahu != null && this.fhQ != null && !this.ahu.bpn()) {
            if (!this.ahu.bpl() && com.baidu.tieba.frs.b.cAg().cAa()) {
                if (com.baidu.tieba.frs.b.cAg().al(this.ahu)) {
                    this.ahu.jy(true);
                }
            } else if (!this.ahu.bpm() && com.baidu.tieba.frs.a.czZ().cAa()) {
                if (com.baidu.tieba.frs.a.czZ().al(this.ahu)) {
                    this.ahu.jz(true);
                }
            } else {
                com.baidu.tieba.frs.b.cAg().am(this.ahu);
                this.ahu.jy(false);
                com.baidu.tieba.frs.a.czZ().am(this.ahu);
                this.ahu.jz(false);
            }
            if (this.ahu.bpl() || this.ahu.bpm()) {
                ao.setViewTextColor(this.fhQ, R.color.CAM_X0304);
                WebPManager.a(this.dhB, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            } else {
                com.baidu.tbadk.core.elementsMaven.c.bv(this.fhQ).oa(R.color.CAM_X0107);
                WebPManager.a(this.dhB, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            }
            if (this.fii != null) {
                b bVar = this.fii;
                if (this.ahu.bpl() || this.ahu.bpm()) {
                    z = true;
                }
                bVar.kb(z);
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.fhG != null) {
            this.fhG.setClickable(z);
            this.fhF.setEnabled(z);
            this.fhE.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.fhJ != null) {
            this.fhJ.setClickable(z);
            this.fhI.setEnabled(z);
            this.fhH.setEnabled(z);
        }
    }

    private void bF(View view) {
        if (this.ahu != null && !StringUtils.isNull(this.ahu.bnB())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.fig)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ahu.bnB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ahu.bnB(), this.mStType, this.fig)));
            }
            if (this.fih != null) {
                this.fih.onClick(view);
            }
        }
    }

    private boolean w(bz bzVar) {
        return (bzVar == null || !bzVar.bmc() || bzVar.bnO() == null) ? false : true;
    }

    protected void bC(View view) {
        if (this.ahu != null && this.mContext != null) {
            m.Ic(this.ahu.getTid());
            aq aqVar = new aq("c12942");
            aqVar.an("obj_locate", this.mFrom);
            aqVar.an("obj_type", getThreadType());
            aqVar.dW("tid", this.ahu.getTid());
            aqVar.dW(IntentConfig.NID, this.ahu.blV());
            if (this.mFrom == 18) {
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", this.ahu.getFid());
                aqVar.an("obj_locate", 18);
                aqVar.dW("resource_id", this.mTabName);
            }
            com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
            if (bV != null) {
                aqVar.dW("obj_cur_page", bV.getCurrentPageKey());
            }
            if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                aqVar.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
            }
            TiebaStatic.log(aqVar);
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ahu, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ahu.getFid()));
            addLocateParam.setForumName(this.ahu.bnB());
            if (this.ahu.bpp() && this.ahu.bpo() != null) {
                addLocateParam.setForumId(this.ahu.bpo().getForumId());
                addLocateParam.setForumName(this.ahu.bpo().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.fij != null) {
                this.fij.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.ahu)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.an(this.ahu);
            }
            if (this.ahu.eRp) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.ahu.boG() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.fie);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            aq aqVar2 = new aq("c12291");
            aqVar2.an("obj_locate", this.mFrom);
            TiebaStatic.log(aqVar2);
            bui();
            a(view, this.ahu);
            if (this.fih != null) {
                this.fih.onClick(view);
            }
        }
    }

    private void bui() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            aq aqVar = new aq("c13568");
            aqVar.an("obj_source", threadSourceForDynamicAndBjh);
            aqVar.an("obj_type", threadTypeForDynamicAndBjh);
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
        if (this.ahu == null) {
            return 0;
        }
        if (this.ahu.bme()) {
            return 1;
        }
        if (this.ahu.bmf()) {
            return 2;
        }
        if (this.ahu.bpv()) {
            return 3;
        }
        return this.ahu.bpw() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.ahu == null) {
            return 0;
        }
        if (this.ahu.isShareThread) {
            return 4;
        }
        if (this.ahu.getThreadType() == 49) {
            return 5;
        }
        if (this.ahu.bnO() != null) {
            return 1;
        }
        if (this.ahu.getType() == bz.eOa || this.ahu.getType() == bz.eOx) {
            if (x.getCount(this.ahu.bnK()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.ahu != null || i >= 0) {
            aq pD = pD(i);
            pD.an("thread_type", this.ahu.getThreadType());
            TiebaStatic.log(pD);
        }
    }

    private aq pD(int i) {
        if (this.ahu == null && i < 0) {
            return null;
        }
        aq aqVar = new aq("c12003");
        aqVar.dW("tid", this.ahu.getTid());
        if (this.ahu.getThreadType() == 40) {
            aqVar.dW("obj_param1", "2");
        } else if (this.ahu.getThreadType() == 0) {
            aqVar.dW("obj_param1", "1");
        }
        aqVar.dW("obj_source", "1");
        aqVar.w("fid", this.ahu.getFid());
        aqVar.an("obj_locate", this.mFrom);
        aqVar.an("obj_id", i);
        if (!at.isEmpty(this.fif)) {
            aqVar.dW("obj_floor", this.fif);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dW(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        aqVar.dW(IntentConfig.NID, this.ahu.blV());
        aqVar.an(IntentConfig.CARD_TYPE, this.ahu.bpz());
        aqVar.dW(IntentConfig.RECOM_SOURCE, this.ahu.mRecomSource);
        aqVar.dW("ab_tag", this.ahu.mRecomAbTag);
        aqVar.dW("weight", this.ahu.mRecomWeight);
        aqVar.dW("extra", this.ahu.mRecomExtra);
        if (this.ahu.getBaijiahaoData() != null && !at.isEmpty(this.ahu.getBaijiahaoData().oriUgcVid)) {
            aqVar.dW("obj_param6", this.ahu.getBaijiahaoData().oriUgcVid);
        }
        com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(this);
        if (bV != null) {
            aqVar.dW("obj_cur_page", bV.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
            aqVar.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
            return aqVar;
        }
        return aqVar;
    }

    protected void bD(View view) {
        if ((ShareSwitch.isOn() || bg.checkUpIsLogin(this.mContext)) && this.ahu != null) {
            buj();
            a(view, this.ahu);
            if (!AntiHelper.d(getContext(), this.ahu)) {
                bul();
                if (this.fih != null) {
                    this.fih.onClick(view);
                }
            }
        }
    }

    private void buj() {
        if (this.ahu != null) {
            aq buk = buk();
            buk.an("thread_type", this.ahu.getThreadType());
            TiebaStatic.log(buk);
        }
    }

    private aq buk() {
        if (this.ahu == null) {
            return null;
        }
        int i = 0;
        if (this.fic == 1) {
            i = 4;
        } else if (this.fic == 2) {
            i = 5;
        } else if (this.fic == 3) {
            i = 3;
        } else if (this.fic == 4) {
            i = 2;
        } else if (this.fic == 6) {
            i = 8;
        } else if (this.fic == 7) {
            i = 9;
        } else if (this.fic == 9) {
            i = 10;
        } else if (this.fic == 10) {
            i = 17;
        } else if (this.fic == 18) {
            i = 20;
        }
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.w("fid", this.ahu.getFid());
        aqVar.dW("tid", this.ahu.getTid());
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.an("obj_locate", i);
        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, this.fce);
        if (!at.isEmpty(this.fif)) {
            aqVar.dW("obj_floor", this.fif);
        }
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.ahu.bnQ() != null && this.ahu.bnQ().user_info != null && this.ahu.bnQ().user_info.is_official == 2) {
            aqVar.an("obj_isofficial", this.ahu.bnQ().user_info.is_official);
        }
        aqVar.an(IntentConfig.CARD_TYPE, this.ahu.bpz()).dW("ab_tag", this.ahu.mRecomAbTag).dW(IntentConfig.RECOM_SOURCE, this.ahu.mRecomSource).dW("weight", this.ahu.mRecomWeight).dW("extra", this.ahu.mRecomExtra);
        if (this.ahu.bme()) {
            aqVar.an("obj_type", 10);
        } else if (this.ahu.bmf()) {
            aqVar.an("obj_type", 9);
        } else if (this.ahu.bpw()) {
            aqVar.an("obj_type", 8);
        } else if (this.ahu.bpv()) {
            aqVar.an("obj_type", 7);
        } else if (this.ahu.isShareThread) {
            aqVar.an("obj_type", 6);
        } else if (this.ahu.threadType == 0) {
            aqVar.an("obj_type", 1);
        } else if (this.ahu.threadType == 40) {
            aqVar.an("obj_type", 2);
        } else if (this.ahu.threadType == 49) {
            aqVar.an("obj_type", 3);
        } else if (this.ahu.threadType == 54) {
            aqVar.an("obj_type", 4);
        } else {
            aqVar.an("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            aqVar.dW("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            aqVar.dW("obj_tab", "a099");
            aqVar.dW("resource_id", this.mTabName);
        }
        if (this.ahu.getBaijiahaoData() != null) {
            aqVar.dW("obj_param4", this.ahu.getBaijiahaoData().oriUgcNid);
            if (this.ahu.bmf() || this.ahu.bpw()) {
                aqVar.dW("obj_param6", this.ahu.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.ahu.bpu()) {
            aqVar.an("obj_param5", 2);
        } else if (this.ahu.bme() || this.ahu.bmf()) {
            aqVar.an("obj_param5", 3);
        } else if (this.ahu.threadType == 0 || this.ahu.threadType == 40) {
            aqVar.an("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), aqVar);
        }
        aqVar.dW(IntentConfig.NID, this.ahu.blV());
        return aqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, bz bzVar) {
        int i;
        int i2 = 1;
        if (bzVar != null) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a("c13694", bzVar, i2, i));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bul() {
        String tid;
        String str;
        boolean z;
        Uri parse;
        String str2;
        String format;
        String str3;
        if (this.ahu != null && this.mContext != null) {
            String valueOf = String.valueOf(this.ahu.getFid());
            String bnB = this.ahu.bnB();
            if (this.ahu.eRb != null) {
                valueOf = this.ahu.eRb.id;
                bnB = this.ahu.eRb.ori_fname;
            }
            String title = this.ahu.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.ahu.getAbstract();
            }
            if (this.ahu.bmg()) {
                tid = this.ahu.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.ahu.getBaijiahaoData().oriUgcType + "&dvid=" + this.ahu.getBaijiahaoData().oriUgcVid + "&nid=" + this.ahu.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.ahu.getTid();
                str = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            if (this.ahu.bnQ() != null && this.ahu.bnQ().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str3 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.ahu.bnQ().user_info.user_name, "utf-8");
                    } else {
                        str3 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.ahu.bnQ().user_info.user_name, "utf-8");
                    }
                    z = false;
                    str4 = str3;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String shareImageUrl = getShareImageUrl(this.ahu);
                parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
                str2 = this.ahu.getAbstract();
                String string = getResources().getString(R.string.share_content_tpl);
                String string2 = getResources().getString(R.string.default_share_content_tpl);
                if (this.ahu.bmg() || this.ahu.bnx() == null) {
                    format = MessageFormat.format(string, title, str2);
                } else {
                    format = (TextUtils.isEmpty(this.ahu.getTitle()) || TextUtils.isEmpty(str2)) ? MessageFormat.format(string2, this.ahu.bnx().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str2;
                }
                String cutString = at.cutString(title, 100);
                String cutString2 = at.cutString(format, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                int stateThreadType = getStateThreadType(this.ahu);
                if (!this.ahu.bmg()) {
                    shareItem.readCount = -1L;
                    shareItem.fsD = cutString2;
                } else {
                    if (stateThreadType == 2 && this.ahu.bnO() != null) {
                        shareItem.readCount = this.ahu.bnO().play_count.intValue();
                    } else if (stateThreadType == 1) {
                        shareItem.readCount = this.ahu.bnp();
                    }
                    shareItem.fsD = str2;
                }
                shareItem.linkUrl = str4;
                shareItem.extData = tid;
                shareItem.fid = valueOf;
                shareItem.fName = bnB;
                shareItem.tid = tid;
                shareItem.fss = true;
                shareItem.eRW = this.fic;
                shareItem.fsF = getShareObjSource();
                shareItem.fsK = stateThreadType;
                shareItem.fsG = 3;
                shareItem.fsH = getShareObjParam2(this.ahu);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (this.ahu.bmg()) {
                    z = false;
                }
                shareItem.canShareBySmartApp = z;
                if (z) {
                    shareItem.fsU = this.ahu.getShareImageUrl();
                }
                bum();
                shareItem.fsN = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahu);
                if (this.mFrom != 13) {
                    shareItem.fsO = ShareItem.ForwardInfo.generateForwardInfo(this.ahu, 2);
                } else {
                    shareItem.fsO = ShareItem.ForwardInfo.generateForwardInfo(this.ahu);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fsG);
                bundle.putInt("obj_type", shareItem.fsK);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putInt("obj_source", shareItem.eRW);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                boolean z2 = false;
                shareDialogConfig.setIsAlaLive((this.ahu.getThreadType() != 49 || this.ahu.getThreadType() == 60) ? true : true);
                a(shareDialogConfig);
                com.baidu.tieba.c.f.csn().b(shareDialogConfig);
            }
            z = true;
            String shareImageUrl2 = getShareImageUrl(this.ahu);
            if (shareImageUrl2 != null) {
            }
            str2 = this.ahu.getAbstract();
            String string3 = getResources().getString(R.string.share_content_tpl);
            String string22 = getResources().getString(R.string.default_share_content_tpl);
            if (this.ahu.bmg()) {
            }
            format = MessageFormat.format(string3, title, str2);
            String cutString3 = at.cutString(title, 100);
            String cutString22 = at.cutString(format, 100);
            ShareItem shareItem2 = new ShareItem();
            shareItem2.title = cutString3;
            shareItem2.content = cutString22;
            int stateThreadType2 = getStateThreadType(this.ahu);
            if (!this.ahu.bmg()) {
            }
            shareItem2.linkUrl = str4;
            shareItem2.extData = tid;
            shareItem2.fid = valueOf;
            shareItem2.fName = bnB;
            shareItem2.tid = tid;
            shareItem2.fss = true;
            shareItem2.eRW = this.fic;
            shareItem2.fsF = getShareObjSource();
            shareItem2.fsK = stateThreadType2;
            shareItem2.fsG = 3;
            shareItem2.fsH = getShareObjParam2(this.ahu);
            if (parse != null) {
            }
            if (this.ahu.bmg()) {
            }
            shareItem2.canShareBySmartApp = z;
            if (z) {
            }
            bum();
            shareItem2.fsN = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahu);
            if (this.mFrom != 13) {
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem2.fsG);
            bundle2.putInt("obj_type", shareItem2.fsK);
            bundle2.putString("fid", shareItem2.fid);
            bundle2.putString("tid", shareItem2.tid);
            bundle2.putInt("obj_source", shareItem2.eRW);
            shareItem2.ae(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, shareItem2, true, true);
            boolean z22 = false;
            shareDialogConfig2.setIsAlaLive((this.ahu.getThreadType() != 49 || this.ahu.getThreadType() == 60) ? true : true);
            a(shareDialogConfig2);
            com.baidu.tieba.c.f.csn().b(shareDialogConfig2);
        }
    }

    private void bum() {
        ItemInfo cAw;
        if ((this.mContext instanceof ak) && ((ak) this.mContext).cAx() && this.ahu != null && this.ahu.bpE() == null && (cAw = ((ak) this.mContext).cAw()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cAw.id.longValue());
            builder.item_name = cAw.name;
            builder.icon_size = cAw.icon_size;
            builder.icon_url = cAw.icon_url;
            builder.tags = cAw.tags;
            if (cAw.score != null && cAw.score.item_point != null) {
                Iterator<ItemPoint> it = cAw.score.item_point.iterator();
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
            this.ahu.a(itemData);
        }
    }

    private int getShareObjParam2(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bme()) {
            return 10;
        }
        if (bzVar.bmf()) {
            return 9;
        }
        if (bzVar.bpw()) {
            return 8;
        }
        if (bzVar.bpv()) {
            return 7;
        }
        if (bzVar.isShareThread) {
            return 6;
        }
        if (bzVar.threadType == 0) {
            return 1;
        }
        if (bzVar.threadType == 40) {
            return 2;
        }
        if (bzVar.threadType == 49) {
            return 3;
        }
        if (bzVar.threadType == 54) {
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
        if (this.fic == 1) {
            return 5;
        }
        if (this.fic != 3) {
            if (this.fic == 4) {
                return 4;
            }
            if (this.fic == 6) {
                return 8;
            }
            if (this.fic != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String getShareImageUrl(bz bzVar) {
        String str;
        if (bzVar == null) {
            return null;
        }
        if (bzVar.bnQ() != null && !TextUtils.isEmpty(bzVar.bnQ().cover)) {
            return bzVar.bnQ().cover;
        }
        if (bzVar.bnG() == null) {
            return null;
        }
        ArrayList<MediaData> bnG = bzVar.bnG();
        int size = bnG.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bnG.get(i);
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
        if (str == null && bzVar.bnO() != null && !TextUtils.isEmpty(bzVar.bnO().thumbnail_url)) {
            return bzVar.bnO().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.bnz()) {
                return 4;
            }
            if (bzVar.bnu() == 1) {
                return 3;
            }
            if (bzVar.bme()) {
                return 5;
            }
            if (bzVar.bmf()) {
                return 6;
            }
            if (bzVar.bpv()) {
                return 7;
            }
            if (bzVar.bpw()) {
                return 8;
            }
            if (!bzVar.isShareThread || bzVar.eQQ == null) {
                return bzVar.boS() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bG(View view) {
        if (this.fhP == null) {
            this.fhP = new ab(this.mPageContext, isShow(16));
        }
        this.fhP.setData(this.ahu);
        this.fhP.Pd();
        if (this.ahu != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).w("uid", TbadkCoreApplication.getCurrentAccountId()).w("fid", this.ahu.getFid()).dW("tid", this.ahu.getId()));
        }
    }

    private void bH(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.fhU = z;
        if (this.ajE != null) {
            this.ajE.setClickable(this.fhU);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(bz bzVar) {
        if (bzVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahu = bzVar;
        ahM();
        D(bzVar);
        F(bzVar);
        C(bzVar);
        B(bzVar);
        updatePraiseNum(bzVar);
        E(bzVar);
        G(bzVar);
        setVisibility(this.isVisible ? 0 : 8);
        bug();
        return this.isVisible;
    }

    protected void bug() {
    }

    protected void ahM() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(bz bzVar) {
        this.ajE.setVisibility(8);
    }

    protected void E(bz bzVar) {
        if (this.fhR != null && this.dhB != null && this.fhQ != null && bzVar != null) {
            if (!this.fik) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.fhR.setVisibility(8);
            } else if (this.fib && !isShow(128) && (com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.dhB.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.dhB.performClick();
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
                if (this.ahu.bpl() || this.ahu.bpm()) {
                    ao.setViewTextColor(this.fhQ, R.color.CAM_X0304);
                    WebPManager.a(this.dhB, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
                } else {
                    com.baidu.tbadk.core.elementsMaven.c.bv(this.fhQ).oa(R.color.CAM_X0107);
                    WebPManager.a(this.dhB, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                }
                this.mMaskView.setVisibility(0);
                this.fhR.setVisibility(8);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.fhR.setVisibility(8);
            }
        }
    }

    private void F(bz bzVar) {
        String bna;
        if (this.fhC != null && bzVar != null) {
            if (bzVar.bnq() <= 0 || !this.fhS) {
                this.fhC.setVisibility(8);
                return;
            }
            this.fhC.setVisibility(0);
            if (this.mFrom == 3) {
                bna = bzVar.bnb();
            } else {
                bna = bzVar.bna();
            }
            this.fhC.setText(bna);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(bz bzVar) {
        if (this.fhE != null && bzVar != null) {
            if (this.fhX) {
                this.fhG.setVisibility(0);
                if (bzVar.bno() > 0) {
                    this.fhE.setVisibility(0);
                    String numFormatOverWan = at.numFormatOverWan(bzVar.bno());
                    if (this.fhV) {
                        updateReplyStateUI();
                        this.fhE.setText(numFormatOverWan);
                    } else {
                        this.fhE.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.fhE.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.fhV) {
                    updateReplyStateUI();
                    this.fhE.setText(this.mContext.getString(R.string.action_comment_default));
                    this.fhE.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.fhE.setVisibility(8);
                    return;
                }
            }
            this.fhG.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        int color;
        if (this.fhV) {
            WebPManager.a(this.fhF, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
        this.fhF.setEnabled(this.ahu == null || this.ahu.getType() != bz.eOR);
        EMTextView eMTextView = this.fhE;
        if (this.ahu != null && this.ahu.getType() == bz.eOR) {
            color = com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.eYz);
        } else {
            color = ao.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
    }

    public void updateManagerUI() {
        int color;
        WebPManager.a(this.fhN, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        EMTextView eMTextView = this.fhM;
        if (this.ahu != null && this.ahu.getType() == bz.eOR) {
            color = com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.eYz);
        } else {
            color = ao.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
        this.fhN.setEnabled(this.ahu == null || this.ahu.getType() != bz.eOR);
    }

    public void updatePraiseNum(bz bzVar) {
        setAgreeViewType(bzVar);
        if (bzVar.bpr() != null) {
            bzVar.bpr().isInThread = true;
            this.fhD.setCardType(bzVar.bpz());
            this.fhD.setThreadData(bzVar);
            this.fhD.setData(bzVar.bpr());
        }
        this.fhD.setAlpha((this.ahu == null || this.ahu.getType() != bz.eOR) ? 1.0f : ao.eYz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(bz bzVar) {
        if (this.fhJ != null && this.fhH != null && bzVar != null) {
            if (this.fhZ) {
                this.fhJ.setVisibility(0);
                long bpc = bzVar.bpc();
                if ((bzVar.boR() || bzVar.boU()) && bzVar.bnQ() != null && bzVar.bnQ().share_info != null) {
                    bpc = bzVar.bnQ().share_info.share_count;
                }
                this.fhH.setText(bpc > 0 ? at.numFormatOverWan(bpc) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                updateShareStateUI(bzVar);
                return;
            }
            this.fhJ.setVisibility(8);
        }
    }

    public void updateShareStateUI(bz bzVar) {
        WebPManager.a(this.fhI, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        if (AntiHelper.bc(bzVar)) {
            setShareClickable(true);
            this.fhH.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.eYz));
        } else if (bzVar != null && bzVar.eQQ != null && this.ahu.eQQ.eLl) {
            setShareClickable(false);
            this.fhH.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.eYz));
        } else {
            setShareClickable(true);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.fhH).oa(R.color.CAM_X0107);
        }
        if (this.ahu != null && this.ahu.getType() == bz.eOR) {
            this.fhI.setEnabled(false);
            this.fhH.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.eYz));
        }
    }

    protected void G(bz bzVar) {
        if (this.fhO != null && bzVar != null) {
            this.fia = isShow(4);
            if (bzVar.eRb != null) {
                this.fia = false;
            }
            if (this.fia && (this.fhR == null || this.fhR.getVisibility() == 8)) {
                this.fhO.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.fhM.setText(string);
                this.fhM.setContentDescription(string);
                this.isVisible = true;
            } else {
                this.fhO.setVisibility(isShow(64) ? 4 : 8);
            }
            updateManagerUI();
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.d dVar) {
        if (this.fhD != null) {
            this.fhD.setStatisticData(dVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            ao.setViewTextColor(this.ajE, R.color.CAM_X0109);
            ao.setViewTextColor(this.fhC, R.color.CAM_X0107);
            updateReplyStateUI();
            updateShareStateUI(this.ahu);
            updateManagerUI();
            if (this.fhP != null) {
                this.fhP.onChangeSkinType();
            }
            if (this.fhD != null) {
                this.fhD.onChangeSkinType(this.mSkinType);
                this.fhD.setAlpha((this.ahu == null || this.ahu.getType() != bz.eOR) ? 1.0f : ao.eYz);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fih = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.ajE;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.fhY = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.fhS = z;
    }

    public View getCommentNumView() {
        return this.fhE;
    }

    public View getCommentContainer() {
        return this.fhG;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.fhV = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.fhW = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.fhZ = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhF.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.fhF.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.fhZ = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhF.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.fhF.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.fib = z;
    }

    public void setManageVisible(boolean z) {
        this.fia = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.fii = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.dhB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.fik = z;
    }

    public boolean isInFrsAllThread() {
        return this.fik;
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
        if (this.fhP != null) {
            this.fhP.destory();
        }
    }

    public void setAgreeViewType(bz bzVar) {
        if (bzVar != null && bzVar.bmg()) {
            this.fhD.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.fhD.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.fij = aVar;
    }
}
