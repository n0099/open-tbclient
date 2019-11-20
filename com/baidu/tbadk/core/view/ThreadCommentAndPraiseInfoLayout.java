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
    protected bh Fs;
    private int clT;
    protected PraiseView clu;
    protected DisPraiseView clv;
    private View.OnClickListener coV;
    protected ImageView cpA;
    protected View cpB;
    protected TextView cpC;
    protected ImageView cpD;
    protected View cpE;
    protected TextView cpF;
    protected FrameLayout cpG;
    private List<CharSequence> cpH;
    private List<String> cpI;
    protected TextView cpJ;
    protected ImageView cpK;
    protected View cpL;
    protected ac cpM;
    protected ImageView cpN;
    protected TextView cpO;
    protected LinearLayout cpP;
    protected boolean cpQ;
    private boolean cpR;
    protected boolean cpS;
    protected boolean cpT;
    protected boolean cpU;
    protected boolean cpV;
    protected boolean cpW;
    private boolean cpX;
    protected boolean cpY;
    protected boolean cpZ;
    protected int cpt;
    protected TextView cpv;
    private TextView cpw;
    protected com.baidu.tbadk.core.view.a cpx;
    protected AgreeView cpy;
    protected TextView cpz;
    protected boolean cqa;
    private int cqb;
    public int cqc;
    public String cqd;
    private String cqe;
    protected int cqf;
    protected int cqg;
    private a cqh;
    private boolean cqi;
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
        this.cqe = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.cpx != null) {
            this.cpx.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.cpx != null) {
            this.cpx.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.cqb = i;
    }

    public void setGameId(int i) {
        this.clT = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.cpt = 0;
        this.cpQ = false;
        this.cpR = true;
        this.cpS = true;
        this.cpT = true;
        this.cpU = false;
        this.cpV = false;
        this.cpW = true;
        this.cpX = false;
        this.cpY = true;
        this.cpZ = false;
        this.cqa = true;
        this.mFrom = 2;
        this.cqb = 1;
        this.mSkinType = 3;
        this.cqh = null;
        this.cqi = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cpt = 0;
        this.cpQ = false;
        this.cpR = true;
        this.cpS = true;
        this.cpT = true;
        this.cpU = false;
        this.cpV = false;
        this.cpW = true;
        this.cpX = false;
        this.cpY = true;
        this.cpZ = false;
        this.cqa = true;
        this.mFrom = 2;
        this.cqb = 1;
        this.mSkinType = 3;
        this.cqh = null;
        this.cqi = false;
        init(context);
    }

    protected View cs(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cpt = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds84);
        View cs = cs(context);
        this.cpv = (TextView) cs.findViewById(R.id.thread_info_bar_name);
        this.cpw = (TextView) cs.findViewById(R.id.thread_info_reply_time);
        this.mRootView = (LinearLayout) cs.findViewById(R.id.thread_comment_layout_root);
        this.cpz = (TextView) cs.findViewById(R.id.thread_info_commont_num);
        this.cpA = (ImageView) cs.findViewById(R.id.thread_info_commont_img);
        this.cpB = cs.findViewById(R.id.thread_info_commont_container);
        this.cpC = (TextView) cs.findViewById(R.id.share_num);
        this.cpD = (ImageView) cs.findViewById(R.id.share_num_img);
        this.cpE = cs.findViewById(R.id.share_num_container);
        this.cpF = (TextView) cs.findViewById(R.id.thread_info_more);
        this.cpG = (FrameLayout) cs.findViewById(R.id.thread_info_more_frame);
        View findViewById = cs.findViewById(R.id.agree_view);
        if (findViewById != null) {
            this.clu = (PraiseView) findViewById;
        }
        View findViewById2 = cs.findViewById(R.id.disagree_view);
        if (findViewById2 != null) {
            this.clv = (DisPraiseView) findViewById2;
        }
        View findViewById3 = cs.findViewById(R.id.new_agree_view);
        if (findViewById3 != null) {
            this.cpy = (AgreeView) findViewById3;
            this.cpy.setAgreeAnimationResource(R.raw.agree);
            this.cpy.setDisagreeAnimationResource(R.raw.disagree);
        }
        if (this.clu != null && this.clv != null) {
            this.cpx = new com.baidu.tbadk.core.view.a(this.clu, this.clv);
        }
        this.cpL = cs.findViewById(R.id.manage_view_container);
        this.cpJ = (TextView) cs.findViewById(R.id.thread_info_manage_text);
        this.cpK = (ImageView) cs.findViewById(R.id.thread_info_manage_img);
        this.cpN = (ImageView) cs.findViewById(R.id.manage_select_img);
        this.cpO = (TextView) cs.findViewById(R.id.manage_select_text);
        this.cpP = (LinearLayout) cs.findViewById(R.id.manage_select_container);
        this.cpP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cpN.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cpO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cpN.performClick();
            }
        });
        this.cpP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cpN.performClick();
            }
        });
        if (this.clu != null) {
            this.clu.setOnClickListener(this);
        }
        if (this.clv != null) {
            this.clv.setOnClickListener(this);
        }
        this.cpB.setOnClickListener(this);
        this.cpE.setOnClickListener(this);
        this.cpL.setOnClickListener(this);
        this.cpN.setOnClickListener(this);
        this.cqg = R.drawable.icon_home_card_share;
        this.cqf = R.drawable.icon_home_card_comment;
        if (this.cpx != null) {
            this.cpx.anq();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.cpx != null) {
                this.cpx.j(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.cpx != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.cpx.j(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.cpx.j(getPageUniqueId());
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
        if (view == this.cpv) {
            aT(view);
        } else if (view == this.cpB) {
            aQ(view);
        } else if (view == this.cpE) {
            aR(view);
        } else if (view == this.clu) {
            aU(view);
        } else if (view == this.clv) {
            aV(view);
        } else if (view == this.cpG) {
            aW(view);
        } else if (view == this.cpL) {
            aP(view);
        } else if (view == this.cpN) {
            aS(view);
        }
    }

    protected void aS(View view) {
        if (this.cpN != null && this.Fs != null && this.cpO != null && !this.Fs.akn()) {
            if (!this.Fs.akm()) {
                if (com.baidu.tieba.frs.a.biU().Z(this.Fs)) {
                    this.Fs.ec(true);
                }
            } else {
                com.baidu.tieba.frs.a.biU().aa(this.Fs);
                this.Fs.ec(false);
            }
            am.setViewTextColor(this.cpO, this.Fs.akm() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cpN.setImageDrawable(am.getDrawable(this.Fs.akm() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.cqh != null) {
                this.cqh.ev(this.Fs.akm());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.cpB != null) {
            this.cpB.setClickable(z);
            this.cpA.setEnabled(z);
            this.cpz.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.cpx != null) {
            this.cpx.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.cpE != null) {
            this.cpE.setClickable(z);
            this.cpD.setEnabled(z);
            this.cpC.setEnabled(z);
        }
    }

    private void aT(View view) {
        if (this.Fs != null && !StringUtils.isNull(this.Fs.aiJ())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.cqe)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.Fs.aiJ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.Fs.aiJ(), this.mStType, this.cqe)));
            }
            if (this.coV != null) {
                this.coV.onClick(view);
            }
        }
    }

    protected void aQ(View view) {
        if (this.Fs != null && this.mContext != null) {
            com.baidu.tieba.card.n.uz(this.Fs.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.Fs, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.Fs.getFid()));
            addLocateParam.setForumName(this.Fs.aiJ());
            if (this.Fs.akr() && this.Fs.akq() != null) {
                addLocateParam.setForumId(this.Fs.akq().getForumId());
                addLocateParam.setForumName(this.Fs.akq().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.Fs.ajD() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.cqc);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            an anVar = new an("c12291");
            anVar.O("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.O("obj_locate", this.mFrom);
            anVar2.O("obj_type", getThreadType());
            anVar2.bS("tid", this.Fs.getTid());
            TiebaStatic.log(anVar2);
            if (this.coV != null) {
                this.coV.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.Fs == null) {
            return 0;
        }
        if (this.Fs.isShareThread) {
            return 4;
        }
        if (this.Fs.getThreadType() == 49) {
            return 5;
        }
        if (this.Fs.aiV() != null) {
            return 1;
        }
        if (this.Fs.getType() == bh.caD || this.Fs.getType() == bh.caQ) {
            if (v.getCount(this.Fs.aiS()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.Fs != null || i >= 0) {
            an iQ = iQ(i);
            iQ.O("thread_type", this.Fs.getThreadType());
            TiebaStatic.log(iQ);
        }
    }

    private an iQ(int i) {
        if (this.Fs == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.bS("tid", this.Fs.getTid());
        if (this.Fs.getThreadType() == 40) {
            anVar.bS("obj_param1", "2");
        } else if (this.Fs.getThreadType() == 0) {
            anVar.bS("obj_param1", "1");
        }
        anVar.bS("obj_source", "1");
        anVar.p("fid", this.Fs.getFid());
        anVar.O("obj_locate", this.mFrom);
        anVar.O("obj_id", i);
        if (!aq.isEmpty(this.cqd)) {
            anVar.bS("obj_floor", this.cqd);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aU(View view) {
        if (this.clu != null) {
            addPraiseStats(this.clu.aO(view));
        }
    }

    protected void aV(View view) {
        if (this.clv != null) {
            this.clv.aO(view);
        }
    }

    protected void aR(View view) {
        if ((bf.isOn() || bc.checkUpIsLogin(this.mContext)) && this.Fs != null) {
            anW();
            anY();
            if (this.coV != null && this.Fs.aiI()) {
                this.coV.onClick(view);
            }
        }
    }

    private void anW() {
        if (this.Fs != null) {
            an anX = anX();
            anX.O("thread_type", this.Fs.getThreadType());
            TiebaStatic.log(anX);
        }
    }

    private an anX() {
        int i = 4;
        if (this.Fs == null) {
            return null;
        }
        if (this.cqb != 1) {
            if (this.cqb == 2) {
                i = 5;
            } else if (this.cqb == 3) {
                i = 3;
            } else if (this.cqb == 4) {
                i = 2;
            } else if (this.cqb == 6) {
                i = 8;
            } else if (this.cqb == 7) {
                i = 9;
            } else if (this.cqb != 9) {
                i = 0;
            } else {
                i = 10;
            }
        }
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.p("fid", this.Fs.getFid());
        anVar.bS("tid", this.Fs.getTid());
        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.O("obj_locate", i);
        anVar.O(TiebaInitialize.Params.OBJ_PARAM2, this.clT);
        if (!aq.isEmpty(this.cqd)) {
            anVar.bS("obj_floor", this.cqd);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.Fs.aiX() != null && this.Fs.aiX().user_info != null && this.Fs.aiX().user_info.is_official == 2) {
            anVar.O("obj_isofficial", this.Fs.aiX().user_info.is_official);
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
    private void anY() {
        String str;
        boolean z;
        Uri parse;
        String str2;
        boolean z2 = false;
        if (this.Fs != null && this.mContext != null) {
            String valueOf = String.valueOf(this.Fs.getFid());
            String aiJ = this.Fs.aiJ();
            if (this.Fs.cdv != null) {
                valueOf = this.Fs.cdv.id;
                aiJ = this.Fs.cdv.ori_fname;
            }
            String title = this.Fs.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.Fs.getAbstract();
            }
            String tid = this.Fs.getTid();
            String str3 = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            if (this.Fs.aiX() != null && this.Fs.aiX().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.Fs.aiX().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.Fs.aiX().user_info.user_name, "utf-8");
                    }
                    str = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String t = t(this.Fs);
                parse = t != null ? null : Uri.parse(t);
                String str4 = this.Fs.getAbstract();
                String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str4);
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                eVar.title = title;
                eVar.content = format;
                eVar.cxT = str4;
                eVar.linkUrl = str;
                eVar.cdP = this.cqb;
                eVar.extData = tid;
                eVar.cxW = 3;
                eVar.fid = valueOf;
                eVar.cxN = aiJ;
                eVar.cyl = z;
                eVar.tid = tid;
                eVar.cxG = true;
                eVar.cxV = getShareObjSource();
                eVar.cya = u(this.Fs);
                if (parse != null) {
                    eVar.imageUri = parse;
                }
                eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.Fs);
                if (z) {
                    eVar.cyk = this.Fs.getShareImageUrl();
                }
                TbadkCoreApplication.getInst().setShareItem(eVar);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", eVar.cxW);
                bundle.putInt("obj_type", eVar.cya);
                bundle.putString("fid", eVar.fid);
                bundle.putString("tid", eVar.tid);
                bundle.putInt("obj_source", eVar.cdP);
                eVar.E(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
                if (this.Fs.getThreadType() != 49 || this.Fs.getThreadType() == 60) {
                    z2 = true;
                }
                shareDialogConfig.setIsAlaLive(z2);
                com.baidu.tieba.c.e.bch().a(shareDialogConfig);
            }
            str = str3;
            z = true;
            String t2 = t(this.Fs);
            if (t2 != null) {
            }
            String str42 = this.Fs.getAbstract();
            String format2 = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str42);
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = format2;
            eVar2.cxT = str42;
            eVar2.linkUrl = str;
            eVar2.cdP = this.cqb;
            eVar2.extData = tid;
            eVar2.cxW = 3;
            eVar2.fid = valueOf;
            eVar2.cxN = aiJ;
            eVar2.cyl = z;
            eVar2.tid = tid;
            eVar2.cxG = true;
            eVar2.cxV = getShareObjSource();
            eVar2.cya = u(this.Fs);
            if (parse != null) {
            }
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.Fs);
            if (z) {
            }
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.cxW);
            bundle2.putInt("obj_type", eVar2.cya);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putInt("obj_source", eVar2.cdP);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, eVar2, true, true);
            if (this.Fs.getThreadType() != 49) {
            }
            z2 = true;
            shareDialogConfig2.setIsAlaLive(z2);
            com.baidu.tieba.c.e.bch().a(shareDialogConfig2);
        }
    }

    private int getShareObjSource() {
        if (this.cqb == 1) {
            return 5;
        }
        if (this.cqb != 3) {
            if (this.cqb == 4) {
                return 4;
            }
            if (this.cqb != 6) {
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
        if (bhVar.aiX() != null && !TextUtils.isEmpty(bhVar.aiX().cover)) {
            return bhVar.aiX().cover;
        }
        if (bhVar.aiO() == null) {
            return null;
        }
        ArrayList<MediaData> aiO = bhVar.aiO();
        int size = aiO.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aiO.get(i);
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
        if (str == null && bhVar.aiV() != null && !TextUtils.isEmpty(bhVar.aiV().thumbnail_url)) {
            return bhVar.aiV().thumbnail_url;
        }
        return str;
    }

    private int u(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.aiG()) {
                return 4;
            }
            if (bhVar.aiB() == 1) {
                return 3;
            }
            return bhVar.ajP() ? 2 : 1;
        }
        return 0;
    }

    protected void aP(View view) {
        if (this.cpM == null) {
            this.cpM = new ac(this.mPageContext, this.cqi);
        }
        this.cpM.setData(this.Fs);
        this.cpM.showDialog();
        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK));
    }

    private void aW(View view) {
        aoa();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.cpT = z;
        if (this.cpv != null) {
            this.cpv.setClickable(this.cpT);
        }
    }

    public boolean isMoreViewVisible() {
        return this.cpG != null && this.cpG.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.cpx != null) {
            this.cpx.setForumId(str);
        }
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.Fs = bhVar;
        anZ();
        v(bhVar);
        x(bhVar);
        r(bhVar);
        q(bhVar);
        updatePraiseNum(bhVar);
        w(bhVar);
        s(bhVar);
        setVisibility(this.cpQ ? 0 : 8);
        return this.cpQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anZ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(bh bhVar) {
        this.cpv.setVisibility(8);
    }

    protected void w(bh bhVar) {
        int equipmentWidth;
        if (this.cpP != null && this.cpN != null && this.cpO != null && bhVar != null) {
            if (!this.cqi) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cpP.setVisibility(8);
            } else if (this.cqa && com.baidu.tieba.frs.a.biU().biV()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cpN.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cpN.performClick();
                        }
                    });
                }
                if (bhVar.akn()) {
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
                am.setViewTextColor(this.cpO, this.Fs.akm() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cpN.setImageDrawable(am.getDrawable(bhVar.akm() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.cpP.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cpP.setVisibility(8);
            }
        }
    }

    private void x(bh bhVar) {
        String aih;
        if (this.cpw != null && bhVar != null) {
            if (bhVar.aix() <= 0 || !this.cpR) {
                this.cpw.setVisibility(8);
                return;
            }
            this.cpw.setVisibility(0);
            if (this.mFrom == 3) {
                aih = bhVar.aii();
            } else {
                aih = bhVar.aih();
            }
            this.cpw.setText(aih);
            this.cpQ = true;
        }
    }

    public boolean isVisible() {
        return this.cpQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(bh bhVar) {
        if (this.cpz != null && bhVar != null) {
            if (this.cpW) {
                this.cpB.setVisibility(0);
                if (this.cpB.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpB.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cpB.setLayoutParams(layoutParams);
                }
                if (bhVar.aiv() > 0) {
                    this.cpz.setVisibility(0);
                    String numFormatOverWan = aq.numFormatOverWan(bhVar.aiv());
                    if (this.cpU) {
                        SvgManager.amL().a(this.cpA, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        this.cpz.setText(numFormatOverWan);
                    } else {
                        this.cpz.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    this.cpz.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                    this.cpQ = true;
                    return;
                } else if (this.cpU) {
                    SvgManager.amL().a(this.cpA, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.cpz.setText(this.mContext.getString(R.string.action_comment_default));
                    this.cpz.setVisibility(0);
                    this.cpQ = true;
                    return;
                } else {
                    this.cpz.setVisibility(8);
                    return;
                }
            }
            this.cpB.setVisibility(8);
        }
    }

    public void updatePraiseNum(bh bhVar) {
        if (this.cpx != null) {
            if (bhVar.getType() == bh.caX || bhVar.getType() == bh.caY) {
                this.cpx.setDisPraiseFrom(5);
            }
            this.cpx.p(bhVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bh bhVar) {
        if (this.cpE != null && this.cpC != null && bhVar != null) {
            if (this.cpY) {
                this.cpE.setVisibility(0);
                if (this.cpE.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpE.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cpE.setLayoutParams(layoutParams);
                }
                long aka = bhVar.aka();
                if ((bhVar.ajO() || bhVar.ajR()) && bhVar.aiX() != null) {
                    aka = bhVar.aiX().share_info.share_count;
                }
                this.cpC.setText(aka > 0 ? aq.numFormatOverWan(aka) : this.mContext.getString(R.string.share));
                this.cpQ = true;
                if (bhVar.cdl != null && bhVar.cdl.isDeleted) {
                    setShareClickable(false);
                    SvgManager.amL().a(this.cpD, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.setViewTextColor(this.cpC, (int) R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                SvgManager.amL().a(this.cpD, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.cpC, (int) R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cpE.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.cpG != null) {
            if (this.Fs == null || v.isEmpty(this.Fs.ajL()) || !TbadkCoreApplication.isLogin() || this.Fs.ajM()) {
                this.cpG.setVisibility(8);
                return;
            }
            if (this.cpG.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpG.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.cpG.setLayoutParams(layoutParams);
            }
            if (this.cpH == null) {
                this.cpH = new ArrayList();
            } else {
                this.cpH.clear();
            }
            if (this.cpI == null) {
                this.cpI = new ArrayList();
            } else {
                this.cpI.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.Fs.ajL()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.cpH.add(reportInfo.info);
                    this.cpI.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.cpG.setOnClickListener(this);
                this.cpG.setVisibility(0);
                return;
            }
            this.cpG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(bh bhVar) {
        if (this.cpL != null && bhVar != null) {
            if (bhVar.cdv != null) {
                this.cpZ = false;
            }
            if (this.cpZ && (this.cpP == null || this.cpP.getVisibility() == 8)) {
                this.cpL.setVisibility(0);
                if (this.cpL.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cpL.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cpL.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(R.string.manage);
                this.cpJ.setText(string);
                this.cpJ.setContentDescription(string);
                SvgManager.amL().a(this.cpK, R.drawable.icon_pure_card_administration_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.cpQ = true;
                return;
            }
            this.cpL.setVisibility(8);
        }
    }

    private void aoa() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.hX(R.string.operation);
            bVar.a(this.cpH, new b.a() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.getItem(ThreadCommentAndPraiseInfoLayout.this.cpI, i);
                    if (!StringUtils.isNull(str)) {
                        ba.amO().b(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.akN();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.cpv, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.cpw, (int) R.color.cp_cont_j);
            am.setViewTextColor(this.cpz, (int) R.drawable.selector_comment_and_prise_item_text_color);
            am.setViewTextColor(this.cpJ, (int) R.drawable.selector_comment_and_prise_item_text_color);
            am.setBackgroundResource(this.cpF, R.drawable.btn_frs_more_selector);
            if (this.cpz != null && this.cpU && this.cqf > 0) {
                SvgManager.amL().a(this.cpA, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.Fs != null && this.Fs.cdl != null && this.Fs.cdl.isDeleted) {
                setShareClickable(false);
                SvgManager.amL().a(this.cpD, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.cpC, (int) R.color.cp_cont_e);
            } else {
                setShareClickable(true);
                SvgManager.amL().a(this.cpD, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.setViewTextColor(this.cpC, (int) R.drawable.selector_comment_and_prise_item_text_color);
            }
            if (this.cpK != null) {
                SvgManager.amL().a(this.cpK, R.drawable.icon_pure_card_administration_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.cpM != null) {
                this.cpM.onChangeSkinType();
            }
            if (this.cpx != null) {
                this.cpx.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
            if (this.cpy != null) {
                this.cpy.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.coV = onClickListener;
        if (this.clu != null) {
            this.clu.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.cpv;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.cpX = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.cpR = z;
    }

    public View getCommentNumView() {
        return this.cpz;
    }

    public View getCommentContainer() {
        return this.cpB;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.cpU = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.cpV = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.cqa = z;
    }

    public void setManageVisible(boolean z) {
        this.cpZ = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.cqh = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.cpN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public void setInFrsAllThread(boolean z) {
        this.cqi = z;
    }

    public boolean isInFrsAllThread() {
        return this.cqi;
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
        if (this.cpx != null) {
            this.cpx.onDestroy();
        }
        if (this.cpM != null) {
            this.cpM.destory();
        }
    }
}
