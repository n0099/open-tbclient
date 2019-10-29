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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.t.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ac;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes3.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bh FT;
    private int cmL;
    protected PraiseView cmm;
    protected DisPraiseView cmn;
    private View.OnClickListener cpN;
    protected TextView cqA;
    protected ImageView cqB;
    protected View cqC;
    protected ac cqD;
    protected ImageView cqE;
    protected TextView cqF;
    protected LinearLayout cqG;
    protected boolean cqH;
    private boolean cqI;
    protected boolean cqJ;
    protected boolean cqK;
    protected boolean cqL;
    protected boolean cqM;
    protected boolean cqN;
    private boolean cqO;
    protected boolean cqP;
    protected boolean cqQ;
    protected boolean cqR;
    private int cqS;
    public int cqT;
    public String cqU;
    private String cqV;
    protected int cqW;
    protected int cqX;
    private a cqY;
    private boolean cqZ;
    protected int cql;
    protected TextView cqm;
    private TextView cqn;
    protected com.baidu.tbadk.core.view.a cqo;
    protected AgreeView cqp;
    protected TextView cqq;
    protected ImageView cqr;
    protected View cqs;
    protected TextView cqt;
    protected ImageView cqu;
    protected View cqv;
    protected TextView cqw;
    protected FrameLayout cqx;
    private List<CharSequence> cqy;
    private List<String> cqz;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private LinearLayout mRootView;
    private int mSkinType;
    private String mStType;

    /* loaded from: classes3.dex */
    public interface a {
        void ev(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.cqV = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.cqo != null) {
            this.cqo.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.cqo != null) {
            this.cqo.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.cqS = i;
    }

    public void setGameId(int i) {
        this.cmL = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.cql = 0;
        this.cqH = false;
        this.cqI = true;
        this.cqJ = true;
        this.cqK = true;
        this.cqL = false;
        this.cqM = false;
        this.cqN = true;
        this.cqO = false;
        this.cqP = true;
        this.cqQ = false;
        this.cqR = true;
        this.mFrom = 2;
        this.cqS = 1;
        this.mSkinType = 3;
        this.cqY = null;
        this.cqZ = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cql = 0;
        this.cqH = false;
        this.cqI = true;
        this.cqJ = true;
        this.cqK = true;
        this.cqL = false;
        this.cqM = false;
        this.cqN = true;
        this.cqO = false;
        this.cqP = true;
        this.cqQ = false;
        this.cqR = true;
        this.mFrom = 2;
        this.cqS = 1;
        this.mSkinType = 3;
        this.cqY = null;
        this.cqZ = false;
        init(context);
    }

    protected View cs(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cql = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View cs = cs(context);
        this.cqm = (TextView) cs.findViewById(R.id.thread_info_bar_name);
        this.cqn = (TextView) cs.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) cs.findViewById(R.id.thread_comment_layout_root);
        this.cqq = (TextView) cs.findViewById(R.id.thread_info_commont_num);
        this.cqr = (ImageView) cs.findViewById(R.id.thread_info_commont_img);
        this.cqs = cs.findViewById(R.id.thread_info_commont_container);
        this.cqt = (TextView) cs.findViewById(R.id.share_num);
        this.cqu = (ImageView) cs.findViewById(R.id.share_num_img);
        this.cqv = cs.findViewById(R.id.share_num_container);
        this.cqw = (TextView) cs.findViewById(R.id.thread_info_more);
        this.cqx = (FrameLayout) cs.findViewById(R.id.thread_info_more_frame);
        View findViewById = cs.findViewById(R.id.agree_view);
        if (findViewById != null) {
            this.cmm = (PraiseView) findViewById;
        }
        View findViewById2 = cs.findViewById(R.id.disagree_view);
        if (findViewById2 != null) {
            this.cmn = (DisPraiseView) findViewById2;
        }
        View findViewById3 = cs.findViewById(R.id.new_agree_view);
        if (findViewById3 != null) {
            this.cqp = (AgreeView) findViewById3;
            this.cqp.setAgreeAnimationResource(R.raw.agree);
            this.cqp.setDisagreeAnimationResource(R.raw.disagree);
        }
        if (this.cmm != null && this.cmn != null) {
            this.cqo = new com.baidu.tbadk.core.view.a(this.cmm, this.cmn);
        }
        this.cqC = cs.findViewById(R.id.manage_view_container);
        this.cqA = (TextView) cs.findViewById(R.id.thread_info_manage_text);
        this.cqB = (ImageView) cs.findViewById(R.id.thread_info_manage_img);
        this.cqE = (ImageView) cs.findViewById(R.id.manage_select_img);
        this.cqF = (TextView) cs.findViewById(R.id.manage_select_text);
        this.cqG = (LinearLayout) cs.findViewById(R.id.manage_select_container);
        this.cqG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cqE.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cqF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cqE.performClick();
            }
        });
        this.cqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cqE.performClick();
            }
        });
        if (this.cmm != null) {
            this.cmm.setOnClickListener(this);
        }
        if (this.cmn != null) {
            this.cmn.setOnClickListener(this);
        }
        this.cqs.setOnClickListener(this);
        this.cqv.setOnClickListener(this);
        this.cqC.setOnClickListener(this);
        this.cqE.setOnClickListener(this);
        this.cqX = R.drawable.icon_home_card_share;
        this.cqW = R.drawable.icon_home_card_comment;
        if (this.cqo != null) {
            this.cqo.ans();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.cqo != null) {
                this.cqo.j(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.cqo != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.cqo.j(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.cqo.j(getPageUniqueId());
            }
        }
    }

    private BdUniqueId getPageUniqueId() {
        if (this.mPageContext != null) {
            return this.mPageContext.getUniqueId();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cqm) {
            aT(view);
        } else if (view == this.cqs) {
            aQ(view);
        } else if (view == this.cqv) {
            aR(view);
        } else if (view == this.cmm) {
            aU(view);
        } else if (view == this.cmn) {
            aV(view);
        } else if (view == this.cqx) {
            aW(view);
        } else if (view == this.cqC) {
            aP(view);
        } else if (view == this.cqE) {
            aS(view);
        }
    }

    protected void aS(View view) {
        if (this.cqE != null && this.FT != null && this.cqF != null && !this.FT.akp()) {
            if (!this.FT.ako()) {
                if (com.baidu.tieba.frs.a.biW().Z(this.FT)) {
                    this.FT.ec(true);
                }
            } else {
                com.baidu.tieba.frs.a.biW().aa(this.FT);
                this.FT.ec(false);
            }
            am.setViewTextColor(this.cqF, this.FT.ako() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cqE.setImageDrawable(am.getDrawable(this.FT.ako() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.cqY != null) {
                this.cqY.ev(this.FT.ako());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.cqs != null) {
            this.cqs.setClickable(z);
            this.cqr.setEnabled(z);
            this.cqq.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.cqo != null) {
            this.cqo.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.cqv != null) {
            this.cqv.setClickable(z);
            this.cqu.setEnabled(z);
            this.cqt.setEnabled(z);
        }
    }

    private void aT(View view) {
        if (this.FT != null && !StringUtils.isNull(this.FT.aiL())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.cqV)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.FT.aiL(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.FT.aiL(), this.mStType, this.cqV)));
            }
            if (this.cpN != null) {
                this.cpN.onClick(view);
            }
        }
    }

    protected void aQ(View view) {
        if (this.FT != null && this.mContext != null) {
            com.baidu.tieba.card.n.uz(this.FT.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.FT, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.FT.getFid()));
            addLocateParam.setForumName(this.FT.aiL());
            if (this.FT.akt() && this.FT.aks() != null) {
                addLocateParam.setForumId(this.FT.aks().getForumId());
                addLocateParam.setForumName(this.FT.aks().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.FT.ajF() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.cqT);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.O("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.O("obj_locate", this.mFrom);
            anVar2.O("obj_type", getThreadType());
            anVar2.bS("tid", this.FT.getTid());
            TiebaStatic.log(anVar2);
            if (this.cpN != null) {
                this.cpN.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.FT == null) {
            return 0;
        }
        if (this.FT.isShareThread) {
            return 4;
        }
        if (this.FT.getThreadType() == 49) {
            return 5;
        }
        if (this.FT.aiX() != null) {
            return 1;
        }
        if (this.FT.getType() == bh.cbu || this.FT.getType() == bh.cbH) {
            if (v.getCount(this.FT.aiU()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.FT != null || i >= 0) {
            an iR = iR(i);
            iR.O("thread_type", this.FT.getThreadType());
            TiebaStatic.log(iR);
        }
    }

    private an iR(int i) {
        if (this.FT == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.bS("tid", this.FT.getTid());
        if (this.FT.getThreadType() == 40) {
            anVar.bS("obj_param1", "2");
        } else if (this.FT.getThreadType() == 0) {
            anVar.bS("obj_param1", "1");
        }
        anVar.bS("obj_source", "1");
        anVar.p("fid", this.FT.getFid());
        anVar.O("obj_locate", this.mFrom);
        anVar.O("obj_id", i);
        if (!aq.isEmpty(this.cqU)) {
            anVar.bS("obj_floor", this.cqU);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aU(View view) {
        if (this.cmm != null) {
            addPraiseStats(this.cmm.aO(view));
        }
    }

    protected void aV(View view) {
        if (this.cmn != null) {
            this.cmn.aO(view);
        }
    }

    protected void aR(View view) {
        if ((bf.isOn() || bc.checkUpIsLogin(this.mContext)) && this.FT != null) {
            anY();
            aoa();
            if (this.cpN != null && this.FT.aiK()) {
                this.cpN.onClick(view);
            }
        }
    }

    private void anY() {
        if (this.FT != null) {
            an anZ = anZ();
            anZ.O("thread_type", this.FT.getThreadType());
            TiebaStatic.log(anZ);
        }
    }

    private an anZ() {
        int i = 4;
        if (this.FT == null) {
            return null;
        }
        if (this.cqS != 1) {
            if (this.cqS == 2) {
                i = 5;
            } else if (this.cqS == 3) {
                i = 3;
            } else if (this.cqS == 4) {
                i = 2;
            } else if (this.cqS == 6) {
                i = 8;
            } else if (this.cqS == 7) {
                i = 9;
            } else if (this.cqS != 9) {
                i = 0;
            } else {
                i = 10;
            }
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.p("fid", this.FT.getFid());
        anVar.bS("tid", this.FT.getTid());
        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.O("obj_locate", i);
        anVar.O(TiebaInitialize.Params.OBJ_PARAM2, this.cmL);
        if (!aq.isEmpty(this.cqU)) {
            anVar.bS("obj_floor", this.cqU);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.FT.aiZ() != null && this.FT.aiZ().user_info != null && this.FT.aiZ().user_info.is_official == 2) {
            anVar.O("obj_isofficial", this.FT.aiZ().user_info.is_official);
        }
        return anVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aoa() {
        String str;
        boolean z;
        Uri parse;
        String str2;
        boolean z2 = false;
        if (this.FT != null && this.mContext != null) {
            String valueOf = String.valueOf(this.FT.getFid());
            String aiL = this.FT.aiL();
            if (this.FT.cem != null) {
                valueOf = this.FT.cem.id;
                aiL = this.FT.cem.ori_fname;
            }
            String title = this.FT.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.FT.getAbstract();
            }
            String tid = this.FT.getTid();
            String str3 = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            if (this.FT.aiZ() != null && this.FT.aiZ().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.FT.aiZ().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.FT.aiZ().user_info.user_name, "utf-8");
                    }
                    str = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String t = t(this.FT);
                parse = t != null ? null : Uri.parse(t);
                String str4 = this.FT.getAbstract();
                String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str4);
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                eVar.title = title;
                eVar.content = format;
                eVar.cyK = str4;
                eVar.linkUrl = str;
                eVar.ceG = this.cqS;
                eVar.extData = tid;
                eVar.cyN = 3;
                eVar.fid = valueOf;
                eVar.cyE = aiL;
                eVar.czc = z;
                eVar.tid = tid;
                eVar.cyx = true;
                eVar.cyM = getShareObjSource();
                eVar.cyR = u(this.FT);
                if (parse != null) {
                    eVar.imageUri = parse;
                }
                eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.FT);
                if (z) {
                    eVar.czb = this.FT.getShareImageUrl();
                }
                TbadkCoreApplication.getInst().setShareItem(eVar);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", eVar.cyN);
                bundle.putInt("obj_type", eVar.cyR);
                bundle.putString("fid", eVar.fid);
                bundle.putString("tid", eVar.tid);
                bundle.putInt("obj_source", eVar.ceG);
                eVar.E(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
                if (this.FT.getThreadType() != 49 || this.FT.getThreadType() == 60) {
                    z2 = true;
                }
                shareDialogConfig.setIsAlaLive(z2);
                com.baidu.tieba.c.e.bcj().a(shareDialogConfig);
            }
            str = str3;
            z = true;
            String t2 = t(this.FT);
            if (t2 != null) {
            }
            String str42 = this.FT.getAbstract();
            String format2 = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str42);
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = format2;
            eVar2.cyK = str42;
            eVar2.linkUrl = str;
            eVar2.ceG = this.cqS;
            eVar2.extData = tid;
            eVar2.cyN = 3;
            eVar2.fid = valueOf;
            eVar2.cyE = aiL;
            eVar2.czc = z;
            eVar2.tid = tid;
            eVar2.cyx = true;
            eVar2.cyM = getShareObjSource();
            eVar2.cyR = u(this.FT);
            if (parse != null) {
            }
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.FT);
            if (z) {
            }
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.cyN);
            bundle2.putInt("obj_type", eVar2.cyR);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putInt("obj_source", eVar2.ceG);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, eVar2, true, true);
            if (this.FT.getThreadType() != 49) {
            }
            z2 = true;
            shareDialogConfig2.setIsAlaLive(z2);
            com.baidu.tieba.c.e.bcj().a(shareDialogConfig2);
        }
    }

    private int getShareObjSource() {
        if (this.cqS == 1) {
            return 5;
        }
        if (this.cqS != 3) {
            if (this.cqS == 4) {
                return 4;
            }
            if (this.cqS != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String t(bh bhVar) {
        String str;
        if (bhVar == null) {
            return null;
        }
        if (bhVar.aiZ() != null && !TextUtils.isEmpty(bhVar.aiZ().cover)) {
            return bhVar.aiZ().cover;
        }
        if (bhVar.aiQ() == null) {
            return null;
        }
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        int size = aiQ.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aiQ.get(i);
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
        if (str == null && bhVar.aiX() != null && !TextUtils.isEmpty(bhVar.aiX().thumbnail_url)) {
            return bhVar.aiX().thumbnail_url;
        }
        return str;
    }

    private int u(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.aiI()) {
                return 4;
            }
            if (bhVar.aiD() == 1) {
                return 3;
            }
            return bhVar.ajR() ? 2 : 1;
        }
        return 0;
    }

    protected void aP(View view) {
        if (this.cqD == null) {
            this.cqD = new ac(this.mPageContext, this.cqZ);
        }
        this.cqD.setData(this.FT);
        this.cqD.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aW(View view) {
        aoc();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.cqK = z;
        if (this.cqm != null) {
            this.cqm.setClickable(this.cqK);
        }
    }

    public boolean isMoreViewVisible() {
        return this.cqx != null && this.cqx.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.cqo != null) {
            this.cqo.setForumId(str);
        }
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.FT = bhVar;
        aob();
        v(bhVar);
        x(bhVar);
        r(bhVar);
        q(bhVar);
        updatePraiseNum(bhVar);
        w(bhVar);
        s(bhVar);
        setVisibility(this.cqH ? 0 : 8);
        return this.cqH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aob() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(bh bhVar) {
        this.cqm.setVisibility(8);
    }

    protected void w(bh bhVar) {
        int equipmentWidth;
        if (this.cqG != null && this.cqE != null && this.cqF != null && bhVar != null) {
            if (!this.cqZ) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cqG.setVisibility(8);
            } else if (this.cqR && com.baidu.tieba.frs.a.biW().biX()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cqE.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cqE.performClick();
                        }
                    });
                }
                if (bhVar.akp()) {
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
                am.setViewTextColor(this.cqF, this.FT.ako() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cqE.setImageDrawable(am.getDrawable(bhVar.ako() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.cqG.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cqG.setVisibility(8);
            }
        }
    }

    private void x(bh bhVar) {
        String aij;
        if (this.cqn != null && bhVar != null) {
            if (bhVar.aiz() <= 0 || !this.cqI) {
                this.cqn.setVisibility(8);
                return;
            }
            this.cqn.setVisibility(0);
            if (this.mFrom == 3) {
                aij = bhVar.aik();
            } else {
                aij = bhVar.aij();
            }
            this.cqn.setText(aij);
            this.cqH = true;
        }
    }

    public boolean isVisible() {
        return this.cqH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(bh bhVar) {
        if (this.cqq != null && bhVar != null) {
            if (this.cqN) {
                this.cqs.setVisibility(0);
                if (this.cqs.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqs.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cqs.setLayoutParams(layoutParams);
                }
                if (bhVar.aix() > 0) {
                    this.cqq.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bhVar.aix());
                    if (this.cqL) {
                        SvgManager.amN().a(this.cqr, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        this.cqq.setText(numFormatOverWan);
                    } else {
                        this.cqq.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.cqq.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.cqH = true;
                    return;
                } else if (this.cqL) {
                    SvgManager.amN().a(this.cqr, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.cqq.setText(this.mContext.getString(R.string.action_comment_default));
                    this.cqq.setVisibility(0);
                    this.cqH = true;
                    return;
                } else {
                    this.cqq.setVisibility(8);
                    return;
                }
            }
            this.cqs.setVisibility(8);
        }
    }

    public void updatePraiseNum(bh bhVar) {
        if (this.cqo != null) {
            if (bhVar.getType() == bh.cbO || bhVar.getType() == bh.cbP) {
                this.cqo.setDisPraiseFrom(5);
            }
            this.cqo.p(bhVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bh bhVar) {
        if (this.cqv != null && this.cqt != null && bhVar != null) {
            if (this.cqP) {
                this.cqv.setVisibility(0);
                if (this.cqv.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqv.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cqv.setLayoutParams(layoutParams);
                }
                long akc = bhVar.akc();
                if ((bhVar.ajQ() || bhVar.ajT()) && bhVar.aiZ() != null) {
                    akc = bhVar.aiZ().share_info.share_count;
                }
                this.cqt.setText(akc > 0 ? aq.numFormatOverWan(akc) : this.mContext.getString(R.string.share));
                this.cqH = true;
                if (bhVar.cec != null && bhVar.cec.isDeleted) {
                    setShareClickable(false);
                    SvgManager.amN().a(this.cqu, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setViewTextColor(this.cqt, (int) R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                SvgManager.amN().a(this.cqu, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.cqt, (int) R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cqv.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.cqx != null) {
            if (this.FT == null || v.isEmpty(this.FT.ajN()) || !TbadkCoreApplication.isLogin() || this.FT.ajO()) {
                this.cqx.setVisibility(8);
                return;
            }
            if (this.cqx.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqx.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.cqx.setLayoutParams(layoutParams);
            }
            if (this.cqy == null) {
                this.cqy = new ArrayList();
            } else {
                this.cqy.clear();
            }
            if (this.cqz == null) {
                this.cqz = new ArrayList();
            } else {
                this.cqz.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.FT.ajN()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.cqy.add(reportInfo.info);
                    this.cqz.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.cqx.setOnClickListener(this);
                this.cqx.setVisibility(0);
                return;
            }
            this.cqx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(bh bhVar) {
        if (this.cqC != null && bhVar != null) {
            if (bhVar.cem != null) {
                this.cqQ = false;
            }
            if (this.cqQ && (this.cqG == null || this.cqG.getVisibility() == 8)) {
                this.cqC.setVisibility(0);
                if (this.cqC.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqC.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cqC.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(R.string.manage);
                this.cqA.setText(string);
                this.cqA.setContentDescription(string);
                SvgManager.amN().a(this.cqB, R.drawable.icon_pure_card_administration_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.cqH = true;
                return;
            }
            this.cqC.setVisibility(8);
        }
    }

    private void aoc() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.hY(R.string.operation);
            bVar.a(this.cqy, new b.a() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.getItem(ThreadCommentAndPraiseInfoLayout.this.cqz, i);
                    if (!StringUtils.isNull(str)) {
                        ba.amQ().b(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.akP();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.cqm, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.cqn, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.cqq, (int) R.drawable.selector_comment_and_prise_item_text_color);
            am.setViewTextColor(this.cqA, (int) R.drawable.selector_comment_and_prise_item_text_color);
            am.setBackgroundResource(this.cqw, R.drawable.btn_frs_more_selector);
            if (this.cqq != null && this.cqL && this.cqW > 0) {
                SvgManager.amN().a(this.cqr, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.FT != null && this.FT.cec != null && this.FT.cec.isDeleted) {
                setShareClickable(false);
                SvgManager.amN().a(this.cqu, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.cqt, (int) R.color.cp_cont_e);
            } else {
                setShareClickable(true);
                SvgManager.amN().a(this.cqu, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.cqt, (int) R.drawable.selector_comment_and_prise_item_text_color);
            }
            if (this.cqB != null) {
                SvgManager.amN().a(this.cqB, R.drawable.icon_pure_card_administration_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.cqD != null) {
                this.cqD.onChangeSkinType();
            }
            if (this.cqo != null) {
                this.cqo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            if (this.cqp != null) {
                this.cqp.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cpN = onClickListener;
        if (this.cmm != null) {
            this.cmm.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.cqm;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.cqO = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.cqI = z;
    }

    public View getCommentNumView() {
        return this.cqq;
    }

    public View getCommentContainer() {
        return this.cqs;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.cqL = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.cqM = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.cqR = z;
    }

    public void setManageVisible(boolean z) {
        this.cqQ = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.cqY = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.cqE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.cqZ = z;
    }

    public boolean isInFrsAllThread() {
        return this.cqZ;
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
        if (this.cqo != null) {
            this.cqo.onDestroy();
        }
        if (this.cqD != null) {
            this.cqD.destory();
        }
    }
}
