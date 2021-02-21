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
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ac;
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
    protected cb ahi;
    protected TextView ajt;
    private int ako;
    protected ImageView djP;
    private int feu;
    protected int fhP;
    private TextView fjV;
    protected AgreeView fjW;
    protected EMTextView fjX;
    protected ImageView fjY;
    protected View fjZ;
    private MaskView fkA;
    private b fkB;
    private a fkC;
    private boolean fkD;
    CustomMessageListener fkE;
    protected EMTextView fka;
    protected ImageView fkb;
    protected View fkc;
    protected FrameLayout fkd;
    protected ImageView fke;
    protected EMTextView fkf;
    protected ImageView fkg;
    protected View fkh;
    protected ac fki;
    protected EMTextView fkj;
    protected LinearLayout fkk;
    protected boolean fkl;
    protected boolean fkm;
    protected boolean fkn;
    protected boolean fko;
    protected boolean fkp;
    protected boolean fkq;
    protected boolean fkr;
    protected boolean fks;
    protected boolean fkt;
    protected boolean fku;
    private int fkv;
    public int fkw;
    public String fkx;
    private String fky;
    private View.OnClickListener fkz;
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
        void ke(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.fky = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.fjW != null) {
            this.fjW.setFrom(this.mFrom);
        }
    }

    public void setDisPraiseFrom(int i) {
    }

    public void setShareReportFrom(int i) {
        this.fkv = i;
    }

    public void setGameId(int i) {
        this.feu = i;
        if (this.fjW != null) {
            this.fjW.setGameId(i);
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
        if (this.fjW != null) {
            this.fjW.setTabName(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fkE);
        MessageManager.getInstance().registerListener(this.mUpdateShareNumListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fkE);
        MessageManager.getInstance().unRegisterListener(this.mUpdateShareNumListener);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.fhP = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ako = 11;
        this.isVisible = false;
        this.fkl = true;
        this.fkm = true;
        this.fkn = true;
        this.fko = false;
        this.fkp = false;
        this.fkq = true;
        this.fkr = false;
        this.fks = true;
        this.fkt = false;
        this.fku = true;
        this.mFrom = 2;
        this.fkv = 1;
        this.mSkinType = 3;
        this.fkB = null;
        this.fkD = true;
        this.fkE = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof cb)) {
                    cb cbVar = (cb) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.ahi != null && cbVar != null) {
                        String str = cbVar.getBaijiahaoData() != null ? cbVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.ahi.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.ahi.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.ahi.nk(cbVar.bnH());
                                ThreadCommentAndPraiseInfoLayout.this.C(cbVar);
                                return;
                            }
                            return;
                        }
                        String id = cbVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.ahi.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.ahi.nk(cbVar.bnH());
                            ThreadCommentAndPraiseInfoLayout.this.C(cbVar);
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
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.ahi != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.ahi.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.ahi.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.ahi.bpj() || ThreadCommentAndPraiseInfoLayout.this.ahi.bpm()) && ThreadCommentAndPraiseInfoLayout.this.ahi.boj() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.ahi.boj() != null && ThreadCommentAndPraiseInfoLayout.this.ahi.boj().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.ahi.boj().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.ahi.dP(ThreadCommentAndPraiseInfoLayout.this.ahi.bpu() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.ahi);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhP = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.ako = 11;
        this.isVisible = false;
        this.fkl = true;
        this.fkm = true;
        this.fkn = true;
        this.fko = false;
        this.fkp = false;
        this.fkq = true;
        this.fkr = false;
        this.fks = true;
        this.fkt = false;
        this.fku = true;
        this.mFrom = 2;
        this.fkv = 1;
        this.mSkinType = 3;
        this.fkB = null;
        this.fkD = true;
        this.fkE = new CustomMessageListener(2921416) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof cb)) {
                    cb cbVar = (cb) customResponsedMessage.getData();
                    if (ThreadCommentAndPraiseInfoLayout.this.ahi != null && cbVar != null) {
                        String str = cbVar.getBaijiahaoData() != null ? cbVar.getBaijiahaoData().oriUgcNid : "";
                        String str2 = ThreadCommentAndPraiseInfoLayout.this.ahi.getBaijiahaoData() != null ? ThreadCommentAndPraiseInfoLayout.this.ahi.getBaijiahaoData().oriUgcNid : "";
                        if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                            if (str.equals(str2)) {
                                ThreadCommentAndPraiseInfoLayout.this.ahi.nk(cbVar.bnH());
                                ThreadCommentAndPraiseInfoLayout.this.C(cbVar);
                                return;
                            }
                            return;
                        }
                        String id = cbVar.getId();
                        String id2 = ThreadCommentAndPraiseInfoLayout.this.ahi.getId();
                        if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                            ThreadCommentAndPraiseInfoLayout.this.ahi.nk(cbVar.bnH());
                            ThreadCommentAndPraiseInfoLayout.this.C(cbVar);
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
                    if (!TextUtils.isEmpty(str) && ThreadCommentAndPraiseInfoLayout.this.ahi != null && !"0".equals(ThreadCommentAndPraiseInfoLayout.this.ahi.getId()) && str.equals(ThreadCommentAndPraiseInfoLayout.this.ahi.getId())) {
                        if ((ThreadCommentAndPraiseInfoLayout.this.ahi.bpj() || ThreadCommentAndPraiseInfoLayout.this.ahi.bpm()) && ThreadCommentAndPraiseInfoLayout.this.ahi.boj() != null) {
                            if (ThreadCommentAndPraiseInfoLayout.this.ahi.boj() != null && ThreadCommentAndPraiseInfoLayout.this.ahi.boj().share_info != null) {
                                ThreadCommentAndPraiseInfoLayout.this.ahi.boj().share_info.share_count++;
                            }
                        } else {
                            ThreadCommentAndPraiseInfoLayout.this.ahi.dP(ThreadCommentAndPraiseInfoLayout.this.ahi.bpu() + 1);
                        }
                        ThreadCommentAndPraiseInfoLayout.this.B(ThreadCommentAndPraiseInfoLayout.this.ahi);
                    }
                }
            }
        };
        init(context);
    }

    protected View fd(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        this.fhP = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        aPF();
    }

    protected void aPF() {
        am(fd(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am(View view) {
        this.ajt = (TextView) view.findViewById(R.id.thread_info_bar_name);
        this.fjV = (TextView) view.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
        this.fjX = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fjX).oa(R.string.F_X01);
        this.fjY = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fjZ = view.findViewById(R.id.thread_info_commont_container);
        this.fka = (EMTextView) view.findViewById(R.id.share_num);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fka).oa(R.string.F_X01);
        this.fkb = (ImageView) view.findViewById(R.id.share_num_img);
        this.fkc = view.findViewById(R.id.share_num_container);
        this.fkd = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
        this.fke = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
        View findViewById = view.findViewById(R.id.new_agree_view);
        if (findViewById != null) {
            this.fjW = (AgreeView) findViewById;
            this.fjW.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadCommentAndPraiseInfoLayout.this.fkz != null) {
                        ThreadCommentAndPraiseInfoLayout.this.fkz.onClick(view2);
                    }
                    ThreadCommentAndPraiseInfoLayout.this.a(view2, ThreadCommentAndPraiseInfoLayout.this.ahi);
                }
            });
        }
        this.fkh = view.findViewById(R.id.manage_view_container);
        this.fkf = (EMTextView) view.findViewById(R.id.thread_info_manage_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fkf).oa(R.string.F_X01);
        this.fkg = (ImageView) view.findViewById(R.id.thread_info_manage_img);
        this.djP = (ImageView) view.findViewById(R.id.manage_select_img);
        this.fkj = (EMTextView) view.findViewById(R.id.manage_select_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fkj).oa(R.string.F_X01);
        this.fkk = (LinearLayout) view.findViewById(R.id.manage_select_container);
        this.fkk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.djP.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.fkj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.djP.performClick();
            }
        });
        this.fkk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayout.this.djP.performClick();
            }
        });
        this.fjZ.setOnClickListener(this);
        this.fkc.setOnClickListener(this);
        this.fkh.setOnClickListener(this);
        this.djP.setOnClickListener(this);
    }

    public void setShowFlag(int i) {
        this.ako = i;
        ty();
    }

    private void ty() {
        int i;
        this.fkc.setVisibility(isShow(1) ? 0 : 8);
        this.fjZ.setVisibility(isShow(2) ? 0 : 8);
        View view = this.fkh;
        if (isShow(4)) {
            i = 0;
        } else {
            i = isShow(64) ? 4 : 8;
        }
        view.setVisibility(i);
        this.fjW.setVisibility(isShow(8) ? 0 : 8);
        this.fjW.setAgreeAlone(isShow(32));
    }

    private boolean isShow(int i) {
        return (this.ako & i) > 0;
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahi == null || this.ahi.getType() != cb.eRd) {
            if (view == this.ajt) {
                bB(view);
            } else if (view == this.fjZ) {
                by(view);
            } else if (view == this.fkc) {
                bz(view);
            } else if (view == this.fke) {
                bD(view);
            } else if (view == this.fkh) {
                bC(view);
            } else if (view == this.djP) {
                bA(view);
            }
        }
    }

    protected void bA(View view) {
        boolean z = false;
        if (this.djP != null && this.ahi != null && this.fkj != null && !this.ahi.bpF()) {
            if (!this.ahi.bpD() && com.baidu.tieba.frs.b.cBy().cBs()) {
                if (com.baidu.tieba.frs.b.cBy().am(this.ahi)) {
                    this.ahi.jA(true);
                }
            } else if (!this.ahi.bpE() && com.baidu.tieba.frs.a.cBr().cBs()) {
                if (com.baidu.tieba.frs.a.cBr().am(this.ahi)) {
                    this.ahi.jB(true);
                }
            } else {
                com.baidu.tieba.frs.b.cBy().an(this.ahi);
                this.ahi.jA(false);
                com.baidu.tieba.frs.a.cBr().an(this.ahi);
                this.ahi.jB(false);
            }
            if (this.ahi.bpD() || this.ahi.bpE()) {
                ap.setViewTextColor(this.fkj, R.color.CAM_X0304);
                WebPManager.a(this.djP, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            } else {
                com.baidu.tbadk.core.elementsMaven.c.br(this.fkj).od(R.color.CAM_X0107);
                WebPManager.a(this.djP, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            }
            if (this.fkB != null) {
                b bVar = this.fkB;
                if (this.ahi.bpD() || this.ahi.bpE()) {
                    z = true;
                }
                bVar.ke(z);
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.fjZ != null) {
            this.fjZ.setClickable(z);
            this.fjY.setEnabled(z);
            this.fjX.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
    }

    public void setShareClickable(boolean z) {
        if (this.fkc != null) {
            this.fkc.setClickable(z);
            this.fkb.setEnabled(z);
            this.fka.setEnabled(z);
        }
    }

    private void bB(View view) {
        if (this.ahi != null && !StringUtils.isNull(this.ahi.bnU())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.fky)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ahi.bnU(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ahi.bnU(), this.mStType, this.fky)));
            }
            if (this.fkz != null) {
                this.fkz.onClick(view);
            }
        }
    }

    private boolean w(cb cbVar) {
        return (cbVar == null || !cbVar.bmv() || cbVar.boh() == null) ? false : true;
    }

    protected void by(View view) {
        if (this.ahi != null && this.mContext != null) {
            m.IN(this.ahi.getTid());
            ar arVar = new ar("c12942");
            arVar.ap("obj_locate", this.mFrom);
            arVar.ap("obj_type", getThreadType());
            arVar.dR("tid", this.ahi.getTid());
            arVar.dR(IntentConfig.NID, this.ahi.bmo());
            if (this.mFrom == 18) {
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.v("fid", this.ahi.getFid());
                arVar.ap("obj_locate", 18);
                arVar.dR("resource_id", this.mTabName);
            }
            com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(this);
            if (bR != null) {
                arVar.dR("obj_cur_page", bR.getCurrentPageKey());
            }
            if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
            }
            TiebaStatic.log(arVar);
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ahi, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ahi.getFid()));
            addLocateParam.setForumName(this.ahi.bnU());
            if (this.ahi.bpH() && this.ahi.bpG() != null) {
                addLocateParam.setForumId(this.ahi.bpG().getForumId());
                addLocateParam.setForumName(this.ahi.bpG().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.fkC != null) {
                this.fkC.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && w(this.ahi)) {
                addLocateParam.setNeedPreLoad(true);
                com.baidu.tieba.frs.l.ao(this.ahi);
            }
            if (this.ahi.eTB) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.ahi.boY() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.fkw);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ar arVar2 = new ar("c12291");
            arVar2.ap("obj_locate", this.mFrom);
            TiebaStatic.log(arVar2);
            buC();
            a(view, this.ahi);
            if (this.fkz != null) {
                this.fkz.onClick(view);
            }
        }
    }

    private void buC() {
        int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
        int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
        if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
            ar arVar = new ar("c13568");
            arVar.ap("obj_source", threadSourceForDynamicAndBjh);
            arVar.ap("obj_type", threadTypeForDynamicAndBjh);
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
        if (this.ahi == null) {
            return 0;
        }
        if (this.ahi.bmx()) {
            return 1;
        }
        if (this.ahi.bmy()) {
            return 2;
        }
        if (this.ahi.bpN()) {
            return 3;
        }
        return this.ahi.bpO() ? 4 : 0;
    }

    private int getThreadType() {
        if (this.ahi == null) {
            return 0;
        }
        if (this.ahi.isShareThread) {
            return 4;
        }
        if (this.ahi.getThreadType() == 49) {
            return 5;
        }
        if (this.ahi.boh() != null) {
            return 1;
        }
        if (this.ahi.getType() == cb.eQm || this.ahi.getType() == cb.eQJ) {
            if (y.getCount(this.ahi.bod()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.ahi != null || i >= 0) {
            ar pI = pI(i);
            pI.ap("thread_type", this.ahi.getThreadType());
            TiebaStatic.log(pI);
        }
    }

    private ar pI(int i) {
        if (this.ahi == null && i < 0) {
            return null;
        }
        ar arVar = new ar("c12003");
        arVar.dR("tid", this.ahi.getTid());
        if (this.ahi.getThreadType() == 40) {
            arVar.dR("obj_param1", "2");
        } else if (this.ahi.getThreadType() == 0) {
            arVar.dR("obj_param1", "1");
        }
        arVar.dR("obj_source", "1");
        arVar.v("fid", this.ahi.getFid());
        arVar.ap("obj_locate", this.mFrom);
        arVar.ap("obj_id", i);
        if (!au.isEmpty(this.fkx)) {
            arVar.dR("obj_floor", this.fkx);
        }
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
        }
        arVar.dR(IntentConfig.NID, this.ahi.bmo());
        arVar.ap(IntentConfig.CARD_TYPE, this.ahi.bpR());
        arVar.dR(IntentConfig.RECOM_SOURCE, this.ahi.mRecomSource);
        arVar.dR("ab_tag", this.ahi.mRecomAbTag);
        arVar.dR("weight", this.ahi.mRecomWeight);
        arVar.dR("extra", this.ahi.mRecomExtra);
        if (this.ahi.getBaijiahaoData() != null && !au.isEmpty(this.ahi.getBaijiahaoData().oriUgcVid)) {
            arVar.dR("obj_param6", this.ahi.getBaijiahaoData().oriUgcVid);
        }
        com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(this);
        if (bR != null) {
            arVar.dR("obj_cur_page", bR.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
            arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
            return arVar;
        }
        return arVar;
    }

    protected void bz(View view) {
        if ((ShareSwitch.isOn() || bh.checkUpIsLogin(this.mContext)) && this.ahi != null) {
            buD();
            a(view, this.ahi);
            if (!AntiHelper.d(getContext(), this.ahi)) {
                buF();
                if (this.fkz != null) {
                    this.fkz.onClick(view);
                }
            }
        }
    }

    private void buD() {
        if (this.ahi != null) {
            ar buE = buE();
            buE.ap("thread_type", this.ahi.getThreadType());
            TiebaStatic.log(buE);
        }
    }

    private ar buE() {
        if (this.ahi == null) {
            return null;
        }
        int i = 0;
        if (this.fkv == 1) {
            i = 4;
        } else if (this.fkv == 2) {
            i = 5;
        } else if (this.fkv == 3) {
            i = 3;
        } else if (this.fkv == 4) {
            i = 2;
        } else if (this.fkv == 6) {
            i = 8;
        } else if (this.fkv == 7) {
            i = 9;
        } else if (this.fkv == 9) {
            i = 10;
        } else if (this.fkv == 10) {
            i = 17;
        } else if (this.fkv == 18) {
            i = 20;
        }
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        arVar.v("fid", this.ahi.getFid());
        arVar.dR("tid", this.ahi.getTid());
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.ap("obj_locate", i);
        arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, this.feu);
        if (!au.isEmpty(this.fkx)) {
            arVar.dR("obj_floor", this.fkx);
        }
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.ahi.boj() != null && this.ahi.boj().user_info != null && this.ahi.boj().user_info.is_official == 2) {
            arVar.ap("obj_isofficial", this.ahi.boj().user_info.is_official);
        }
        arVar.ap(IntentConfig.CARD_TYPE, this.ahi.bpR()).dR("ab_tag", this.ahi.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, this.ahi.mRecomSource).dR("weight", this.ahi.mRecomWeight).dR("extra", this.ahi.mRecomExtra);
        if (this.ahi.bmx()) {
            arVar.ap("obj_type", 10);
        } else if (this.ahi.bmy()) {
            arVar.ap("obj_type", 9);
        } else if (this.ahi.bpO()) {
            arVar.ap("obj_type", 8);
        } else if (this.ahi.bpN()) {
            arVar.ap("obj_type", 7);
        } else if (this.ahi.isShareThread) {
            arVar.ap("obj_type", 6);
        } else if (this.ahi.threadType == 0) {
            arVar.ap("obj_type", 1);
        } else if (this.ahi.threadType == 40) {
            arVar.ap("obj_type", 2);
        } else if (this.ahi.threadType == 49) {
            arVar.ap("obj_type", 3);
        } else if (this.ahi.threadType == 54) {
            arVar.ap("obj_type", 4);
        } else {
            arVar.ap("obj_type", 5);
        }
        if (this.mFrom == 1 || this.mFrom == 2) {
            arVar.dR("obj_tab", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
        }
        if (this.mFrom == 18) {
            arVar.dR("obj_tab", "a099");
            arVar.dR("resource_id", this.mTabName);
        }
        if (this.ahi.getBaijiahaoData() != null) {
            arVar.dR("obj_param4", this.ahi.getBaijiahaoData().oriUgcNid);
            if (this.ahi.bmy() || this.ahi.bpO()) {
                arVar.dR("obj_param6", this.ahi.getBaijiahaoData().oriUgcVid);
            }
        }
        if (this.ahi.bpM()) {
            arVar.ap("obj_param5", 2);
        } else if (this.ahi.bmx() || this.ahi.bmy()) {
            arVar.ap("obj_param5", 3);
        } else if (this.ahi.threadType == 0 || this.ahi.threadType == 40) {
            arVar.ap("obj_param5", 1);
        }
        if (this.mPageContext != null) {
            com.baidu.tbadk.pageInfo.c.a(this.mPageContext.getPageActivity(), arVar);
        }
        arVar.dR(IntentConfig.NID, this.ahi.bmo());
        return arVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, cb cbVar) {
        int i;
        int i2 = 1;
        if (cbVar != null) {
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
                TiebaStatic.log(com.baidu.tieba.s.a.a("c13694", cbVar, i2, i));
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
    private void buF() {
        String tid;
        String str;
        boolean z;
        Uri parse;
        String str2;
        String format;
        String str3;
        if (this.ahi != null && this.mContext != null) {
            String valueOf = String.valueOf(this.ahi.getFid());
            String bnU = this.ahi.bnU();
            if (this.ahi.eTn != null) {
                valueOf = this.ahi.eTn.id;
                bnU = this.ahi.eTn.ori_fname;
            }
            String title = this.ahi.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.ahi.getAbstract();
            }
            if (this.ahi.bmz()) {
                tid = this.ahi.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.ahi.getBaijiahaoData().oriUgcType + "&dvid=" + this.ahi.getBaijiahaoData().oriUgcVid + "&nid=" + this.ahi.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.ahi.getTid();
                str = "?share=9105&fr=share";
            }
            String str4 = "http://tieba.baidu.com/p/" + tid + (str + "&share_from=post");
            if (this.ahi.boj() != null && this.ahi.boj().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str3 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.ahi.boj().user_info.user_name, "utf-8");
                    } else {
                        str3 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.ahi.boj().user_info.user_name, "utf-8");
                    }
                    z = false;
                    str4 = str3;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String shareImageUrl = getShareImageUrl(this.ahi);
                parse = shareImageUrl != null ? null : Uri.parse(shareImageUrl);
                str2 = this.ahi.getAbstract();
                String string = getResources().getString(R.string.share_content_tpl);
                String string2 = getResources().getString(R.string.default_share_content_tpl);
                if (this.ahi.bmz() || this.ahi.bnQ() == null) {
                    format = MessageFormat.format(string, title, str2);
                } else {
                    format = (TextUtils.isEmpty(this.ahi.getTitle()) || TextUtils.isEmpty(str2)) ? MessageFormat.format(string2, this.ahi.bnQ().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : str2;
                }
                String cutString = au.cutString(title, 100);
                String cutString2 = au.cutString(format, 100);
                ShareItem shareItem = new ShareItem();
                shareItem.title = cutString;
                shareItem.content = cutString2;
                int stateThreadType = getStateThreadType(this.ahi);
                if (!this.ahi.bmz()) {
                    shareItem.readCount = -1L;
                    shareItem.fuV = cutString2;
                } else {
                    if (stateThreadType == 2 && this.ahi.boh() != null) {
                        shareItem.readCount = this.ahi.boh().play_count.intValue();
                    } else if (stateThreadType == 1) {
                        shareItem.readCount = this.ahi.bnI();
                    }
                    shareItem.fuV = str2;
                }
                shareItem.linkUrl = str4;
                shareItem.extData = tid;
                shareItem.fid = valueOf;
                shareItem.fName = bnU;
                shareItem.tid = tid;
                shareItem.fuK = true;
                shareItem.eUk = this.fkv;
                shareItem.fuX = getShareObjSource();
                shareItem.fvc = stateThreadType;
                shareItem.fuY = 3;
                shareItem.fuZ = getShareObjParam2(this.ahi);
                if (parse != null) {
                    shareItem.imageUri = parse;
                }
                if (this.ahi.bmz()) {
                    z = false;
                }
                shareItem.canShareBySmartApp = z;
                if (z) {
                    shareItem.fvm = this.ahi.getShareImageUrl();
                }
                buG();
                shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahi);
                if (this.mFrom != 13) {
                    shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(this.ahi, 2);
                } else {
                    shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(this.ahi);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.fuY);
                bundle.putInt("obj_type", shareItem.fvc);
                bundle.putString("fid", shareItem.fid);
                bundle.putString("tid", shareItem.tid);
                bundle.putInt("obj_source", shareItem.eUk);
                shareItem.ae(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
                boolean z2 = false;
                shareDialogConfig.setIsAlaLive((this.ahi.getThreadType() != 49 || this.ahi.getThreadType() == 60) ? true : true);
                a(shareDialogConfig);
                com.baidu.tieba.c.f.ctG().b(shareDialogConfig);
            }
            z = true;
            String shareImageUrl2 = getShareImageUrl(this.ahi);
            if (shareImageUrl2 != null) {
            }
            str2 = this.ahi.getAbstract();
            String string3 = getResources().getString(R.string.share_content_tpl);
            String string22 = getResources().getString(R.string.default_share_content_tpl);
            if (this.ahi.bmz()) {
            }
            format = MessageFormat.format(string3, title, str2);
            String cutString3 = au.cutString(title, 100);
            String cutString22 = au.cutString(format, 100);
            ShareItem shareItem2 = new ShareItem();
            shareItem2.title = cutString3;
            shareItem2.content = cutString22;
            int stateThreadType2 = getStateThreadType(this.ahi);
            if (!this.ahi.bmz()) {
            }
            shareItem2.linkUrl = str4;
            shareItem2.extData = tid;
            shareItem2.fid = valueOf;
            shareItem2.fName = bnU;
            shareItem2.tid = tid;
            shareItem2.fuK = true;
            shareItem2.eUk = this.fkv;
            shareItem2.fuX = getShareObjSource();
            shareItem2.fvc = stateThreadType2;
            shareItem2.fuY = 3;
            shareItem2.fuZ = getShareObjParam2(this.ahi);
            if (parse != null) {
            }
            if (this.ahi.bmz()) {
            }
            shareItem2.canShareBySmartApp = z;
            if (z) {
            }
            buG();
            shareItem2.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahi);
            if (this.mFrom != 13) {
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem2.fuY);
            bundle2.putInt("obj_type", shareItem2.fvc);
            bundle2.putString("fid", shareItem2.fid);
            bundle2.putString("tid", shareItem2.tid);
            bundle2.putInt("obj_source", shareItem2.eUk);
            shareItem2.ae(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, shareItem2, true, true);
            boolean z22 = false;
            shareDialogConfig2.setIsAlaLive((this.ahi.getThreadType() != 49 || this.ahi.getThreadType() == 60) ? true : true);
            a(shareDialogConfig2);
            com.baidu.tieba.c.f.ctG().b(shareDialogConfig2);
        }
    }

    private void buG() {
        ItemInfo cBO;
        if ((this.mContext instanceof ak) && ((ak) this.mContext).cBP() && this.ahi != null && this.ahi.bpW() == null && (cBO = ((ak) this.mContext).cBO()) != null) {
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(cBO.id.longValue());
            builder.item_name = cBO.name;
            builder.icon_size = cBO.icon_size;
            builder.icon_url = cBO.icon_url;
            builder.tags = cBO.tags;
            if (cBO.score != null && cBO.score.item_point != null) {
                Iterator<ItemPoint> it = cBO.score.item_point.iterator();
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
            this.ahi.a(itemData);
        }
    }

    private int getShareObjParam2(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bmx()) {
            return 10;
        }
        if (cbVar.bmy()) {
            return 9;
        }
        if (cbVar.bpO()) {
            return 8;
        }
        if (cbVar.bpN()) {
            return 7;
        }
        if (cbVar.isShareThread) {
            return 6;
        }
        if (cbVar.threadType == 0) {
            return 1;
        }
        if (cbVar.threadType == 40) {
            return 2;
        }
        if (cbVar.threadType == 49) {
            return 3;
        }
        if (cbVar.threadType == 54) {
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
        if (this.fkv == 1) {
            return 5;
        }
        if (this.fkv != 3) {
            if (this.fkv == 4) {
                return 4;
            }
            if (this.fkv == 6) {
                return 8;
            }
            if (this.fkv != 10) {
                return 0;
            }
            return 16;
        }
        return 3;
    }

    private String getShareImageUrl(cb cbVar) {
        String str;
        if (cbVar == null) {
            return null;
        }
        if (cbVar.boj() != null && !TextUtils.isEmpty(cbVar.boj().cover)) {
            return cbVar.boj().cover;
        }
        if (cbVar.bnZ() == null) {
            return null;
        }
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        int size = bnZ.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = bnZ.get(i);
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
        if (str == null && cbVar.boh() != null && !TextUtils.isEmpty(cbVar.boh().thumbnail_url)) {
            return cbVar.boh().thumbnail_url;
        }
        return str;
    }

    private int getStateThreadType(cb cbVar) {
        if (cbVar != null) {
            if (cbVar.bnS()) {
                return 4;
            }
            if (cbVar.bnN() == 1) {
                return 3;
            }
            if (cbVar.bmx()) {
                return 5;
            }
            if (cbVar.bmy()) {
                return 6;
            }
            if (cbVar.bpN()) {
                return 7;
            }
            if (cbVar.bpO()) {
                return 8;
            }
            if (!cbVar.isShareThread || cbVar.eTc == null) {
                return cbVar.bpk() ? 2 : 1;
            }
            return 9;
        }
        return 0;
    }

    protected void bC(View view) {
        if (this.fki == null) {
            this.fki = new ac(this.mPageContext, isShow(16));
        }
        this.fki.setData(this.ahi);
        this.fki.QE();
        if (this.ahi != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).v("uid", TbadkCoreApplication.getCurrentAccountId()).v("fid", this.ahi.getFid()).dR("tid", this.ahi.getId()));
        }
    }

    private void bD(View view) {
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.fkn = z;
        if (this.ajt != null) {
            this.ajt.setClickable(this.fkn);
        }
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
    }

    public boolean setData(cb cbVar) {
        if (cbVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahi = cbVar;
        aik();
        D(cbVar);
        G(cbVar);
        C(cbVar);
        B(cbVar);
        updatePraiseNum(cbVar);
        F(cbVar);
        H(cbVar);
        setVisibility(this.isVisible ? 0 : 8);
        E(cbVar);
        buA();
        return this.isVisible;
    }

    protected void buA() {
    }

    protected void aik() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(cb cbVar) {
        this.ajt.setVisibility(8);
    }

    protected void E(cb cbVar) {
        if (cbVar != null && this.mFrom == 13) {
            showOperationMaskView(cbVar.isAuthorView == 1);
        }
    }

    public void showOperationMaskView(boolean z) {
        if (z && this.fkA == null) {
            this.fkA = new MaskView(getContext());
            addView(this.fkA);
        }
        if (this.fkA != null) {
            this.fkA.setVisibility(z ? 0 : 8);
        }
    }

    protected void F(cb cbVar) {
        if (this.fkk != null && this.djP != null && this.fkj != null && cbVar != null) {
            if (!this.fkD) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.fkk.setVisibility(8);
            } else if (this.fku && !isShow(128) && (com.baidu.tieba.frs.b.cBy().cBs() || com.baidu.tieba.frs.a.cBr().cBs())) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.djP.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.djP.performClick();
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
                if (this.ahi.bpD() || this.ahi.bpE()) {
                    ap.setViewTextColor(this.fkj, R.color.CAM_X0304);
                    WebPManager.a(this.djP, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
                } else {
                    com.baidu.tbadk.core.elementsMaven.c.br(this.fkj).od(R.color.CAM_X0107);
                    WebPManager.a(this.djP, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                }
                this.mMaskView.setVisibility(0);
                this.fkk.setVisibility(8);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.fkk.setVisibility(8);
            }
        }
    }

    private void G(cb cbVar) {
        String bnt;
        if (this.fjV != null && cbVar != null) {
            if (cbVar.bnJ() <= 0 || !this.fkl) {
                this.fjV.setVisibility(8);
                return;
            }
            this.fjV.setVisibility(0);
            if (this.mFrom == 3) {
                bnt = cbVar.bnu();
            } else {
                bnt = cbVar.bnt();
            }
            this.fjV.setText(bnt);
            this.isVisible = true;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(cb cbVar) {
        if (this.fjX != null && cbVar != null) {
            if (this.fkq) {
                this.fjZ.setVisibility(0);
                if (cbVar.bnH() > 0) {
                    this.fjX.setVisibility(0);
                    String numFormatOverWan = au.numFormatOverWan(cbVar.bnH());
                    if (this.fko) {
                        updateReplyStateUI();
                        this.fjX.setText(numFormatOverWan);
                    } else {
                        this.fjX.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.fjX.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.isVisible = true;
                    return;
                } else if (this.fko) {
                    updateReplyStateUI();
                    this.fjX.setText(this.mContext.getString(R.string.action_comment_default));
                    this.fjX.setVisibility(0);
                    this.isVisible = true;
                    return;
                } else {
                    this.fjX.setVisibility(8);
                    return;
                }
            }
            this.fjZ.setVisibility(8);
        }
    }

    public void updateReplyStateUI() {
        int color;
        if (this.fko) {
            WebPManager.a(this.fjY, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
        this.fjY.setEnabled(this.ahi == null || this.ahi.getType() != cb.eRd);
        EMTextView eMTextView = this.fjX;
        if (this.ahi != null && this.ahi.getType() == cb.eRd) {
            color = com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO);
        } else {
            color = ap.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
    }

    public void updateManagerUI() {
        int color;
        WebPManager.a(this.fkg, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        EMTextView eMTextView = this.fkf;
        if (this.ahi != null && this.ahi.getType() == cb.eRd) {
            color = com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO);
        } else {
            color = ap.getColor(R.color.CAM_X0107);
        }
        eMTextView.setTextColor(color);
        this.fkg.setEnabled(this.ahi == null || this.ahi.getType() != cb.eRd);
    }

    public void updatePraiseNum(cb cbVar) {
        setAgreeViewType(cbVar);
        if (cbVar.bpJ() != null) {
            cbVar.bpJ().isInThread = true;
            this.fjW.setCardType(cbVar.bpR());
            this.fjW.setThreadData(cbVar);
            this.fjW.setData(cbVar.bpJ());
        }
        this.fjW.setAlpha((this.ahi == null || this.ahi.getType() != cb.eRd) ? 1.0f : ap.faO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(cb cbVar) {
        if (this.fkc != null && this.fka != null && cbVar != null) {
            if (this.fks) {
                this.fkc.setVisibility(0);
                long bpu = cbVar.bpu();
                if ((cbVar.bpj() || cbVar.bpm()) && cbVar.boj() != null && cbVar.boj().share_info != null) {
                    bpu = cbVar.boj().share_info.share_count;
                }
                this.fka.setText(bpu > 0 ? au.numFormatOverWan(bpu) : this.mContext.getString(R.string.share));
                this.isVisible = true;
                updateShareStateUI(cbVar);
                return;
            }
            this.fkc.setVisibility(8);
        }
    }

    public void updateShareStateUI(cb cbVar) {
        WebPManager.a(this.fkb, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        if (AntiHelper.bd(cbVar)) {
            setShareClickable(true);
            this.fka.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO));
        } else if (cbVar != null && cbVar.eTc != null && this.ahi.eTc.eNx) {
            setShareClickable(false);
            this.fka.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO));
        } else {
            setShareClickable(true);
            com.baidu.tbadk.core.elementsMaven.c.br(this.fka).od(R.color.CAM_X0107);
        }
        if (this.ahi != null && this.ahi.getType() == cb.eRd) {
            this.fkb.setEnabled(false);
            this.fka.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO));
        }
    }

    protected void H(cb cbVar) {
        if (this.fkh != null && cbVar != null) {
            this.fkt = isShow(4);
            if (cbVar.eTn != null) {
                this.fkt = false;
            }
            if (this.fkt && (this.fkk == null || this.fkk.getVisibility() == 8)) {
                this.fkh.setVisibility(0);
                String string = this.mContext.getString(R.string.manage);
                this.fkf.setText(string);
                this.fkf.setContentDescription(string);
                this.isVisible = true;
            } else {
                this.fkh.setVisibility(isShow(64) ? 4 : 8);
            }
            updateManagerUI();
        }
    }

    public void setAgreeStatisticData(com.baidu.tbadk.core.data.e eVar) {
        if (this.fjW != null) {
            this.fjW.setStatisticData(eVar);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
            if (this.fkA != null) {
                this.fkA.bzn();
            }
            ap.setViewTextColor(this.ajt, R.color.CAM_X0109);
            ap.setViewTextColor(this.fjV, R.color.CAM_X0107);
            updateReplyStateUI();
            updateShareStateUI(this.ahi);
            updateManagerUI();
            if (this.fki != null) {
                this.fki.onChangeSkinType();
            }
            if (this.fjW != null) {
                this.fjW.onChangeSkinType(this.mSkinType);
                this.fjW.setAlpha((this.ahi == null || this.ahi.getType() != cb.eRd) ? 1.0f : ap.faO);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fkz = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.ajt;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.fkr = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.fkl = z;
    }

    public View getCommentNumView() {
        return this.fjX;
    }

    public View getCommentContainer() {
        return this.fjZ;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.fko = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.fkp = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void hideShareContainer() {
        this.fks = false;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjY.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.fjY.setLayoutParams(layoutParams);
    }

    public void resetShareContainer() {
        this.fks = true;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjY.getLayoutParams();
        layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
        this.fjY.setLayoutParams(layoutParams);
    }

    public void setSelectVisible(boolean z) {
        this.fku = z;
    }

    public void setManageVisible(boolean z) {
        this.fkt = z;
    }

    public void setOnSelectStatusChangeListener(b bVar) {
        this.fkB = bVar;
    }

    public void changeSelectStatus() {
        onClick(this.djP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.fkD = z;
    }

    public boolean isInFrsAllThread() {
        return this.fkD;
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
        if (this.fki != null) {
            this.fki.destory();
        }
    }

    public void setAgreeViewType(cb cbVar) {
        if (cbVar != null && cbVar.bmz()) {
            this.fjW.setAgreeAlone(true);
        }
    }

    public void hideDisagree() {
        this.fjW.setAgreeAlone(true);
    }

    public void setOnCommentClickCallback(a aVar) {
        this.fkC = aVar;
    }
}
