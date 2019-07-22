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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
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
    protected bg We;
    private LinearLayout bOb;
    private int bWH;
    protected PraiseView bWi;
    protected DisPraiseView bWj;
    protected int caX;
    protected TextView caY;
    private TextView caZ;
    private View.OnClickListener caw;
    private boolean cbA;
    protected boolean cbB;
    protected boolean cbC;
    protected boolean cbD;
    private int cbE;
    public int cbF;
    public String cbG;
    private String cbH;
    protected int cbI;
    protected int cbJ;
    private a cbK;
    private boolean cbL;
    protected com.baidu.tbadk.core.view.a cba;
    protected AgreeView cbb;
    protected TextView cbc;
    protected ImageView cbd;
    protected View cbe;
    protected TextView cbf;
    protected ImageView cbg;
    protected View cbh;
    protected TextView cbi;
    protected FrameLayout cbj;
    private List<CharSequence> cbk;
    private List<String> cbl;
    protected TextView cbm;
    protected ImageView cbn;
    protected View cbo;
    protected ac cbp;
    protected ImageView cbq;
    protected TextView cbr;
    protected LinearLayout cbs;
    protected boolean cbt;
    private boolean cbu;
    protected boolean cbv;
    protected boolean cbw;
    protected boolean cbx;
    protected boolean cby;
    protected boolean cbz;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private int mSkinType;
    private String mStType;

    /* loaded from: classes3.dex */
    public interface a {
        void eu(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.cbH = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.cba != null) {
            this.cba.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.cba != null) {
            this.cba.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.cbE = i;
    }

    public void setGameId(int i) {
        this.bWH = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.caX = 0;
        this.cbt = false;
        this.cbu = true;
        this.cbv = true;
        this.cbw = true;
        this.cbx = false;
        this.cby = false;
        this.cbz = true;
        this.cbA = false;
        this.cbB = true;
        this.cbC = false;
        this.cbD = true;
        this.mFrom = 2;
        this.cbE = 1;
        this.mSkinType = 3;
        this.cbK = null;
        this.cbL = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.caX = 0;
        this.cbt = false;
        this.cbu = true;
        this.cbv = true;
        this.cbw = true;
        this.cbx = false;
        this.cby = false;
        this.cbz = true;
        this.cbA = false;
        this.cbB = true;
        this.cbC = false;
        this.cbD = true;
        this.mFrom = 2;
        this.cbE = 1;
        this.mSkinType = 3;
        this.cbK = null;
        this.cbL = false;
        init(context);
    }

    protected View cG(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.caX = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds84);
        View cG = cG(context);
        this.caY = (TextView) cG.findViewById(R.id.thread_info_bar_name);
        this.caZ = (TextView) cG.findViewById(R.id.thread_info_reply_time);
        this.bOb = (LinearLayout) cG.findViewById(R.id.thread_comment_layout_root);
        this.cbc = (TextView) cG.findViewById(R.id.thread_info_commont_num);
        this.cbd = (ImageView) cG.findViewById(R.id.thread_info_commont_img);
        this.cbe = cG.findViewById(R.id.thread_info_commont_container);
        this.cbf = (TextView) cG.findViewById(R.id.share_num);
        this.cbg = (ImageView) cG.findViewById(R.id.share_num_img);
        this.cbh = cG.findViewById(R.id.share_num_container);
        this.cbi = (TextView) cG.findViewById(R.id.thread_info_more);
        this.cbj = (FrameLayout) cG.findViewById(R.id.thread_info_more_frame);
        View findViewById = cG.findViewById(R.id.agree_view);
        if (findViewById != null) {
            this.bWi = (PraiseView) findViewById;
        }
        View findViewById2 = cG.findViewById(R.id.disagree_view);
        if (findViewById2 != null) {
            this.bWj = (DisPraiseView) findViewById2;
        }
        View findViewById3 = cG.findViewById(R.id.new_agree_view);
        if (findViewById3 != null) {
            this.cbb = (AgreeView) findViewById3;
            this.cbb.setAgreeAnimationResource(R.raw.agree);
            this.cbb.setDisagreeAnimationResource(R.raw.disagree);
        }
        if (this.bWi != null && this.bWj != null) {
            this.cba = new com.baidu.tbadk.core.view.a(this.bWi, this.bWj);
        }
        this.cbo = cG.findViewById(R.id.manage_view_container);
        this.cbm = (TextView) cG.findViewById(R.id.thread_info_manage_text);
        this.cbn = (ImageView) cG.findViewById(R.id.thread_info_manage_img);
        this.cbq = (ImageView) cG.findViewById(R.id.manage_select_img);
        this.cbr = (TextView) cG.findViewById(R.id.manage_select_text);
        this.cbs = (LinearLayout) cG.findViewById(R.id.manage_select_container);
        this.cbs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cbq.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cbr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cbq.performClick();
            }
        });
        this.cbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cbq.performClick();
            }
        });
        if (this.bWi != null) {
            this.bWi.setOnClickListener(this);
        }
        if (this.bWj != null) {
            this.bWj.setOnClickListener(this);
        }
        this.cbe.setOnClickListener(this);
        this.cbh.setOnClickListener(this);
        this.cbo.setOnClickListener(this);
        this.cbq.setOnClickListener(this);
        this.cbJ = R.drawable.icon_home_card_share;
        this.cbI = R.drawable.icon_home_card_comment;
        if (this.cba != null) {
            this.cba.akc();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.cba != null) {
                this.cba.j(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.cba != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.cba.j(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.cba.j(getPageUniqueId());
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
        if (view == this.caY) {
            aT(view);
        } else if (view == this.cbe) {
            aQ(view);
        } else if (view == this.cbh) {
            aR(view);
        } else if (view == this.bWi) {
            aU(view);
        } else if (view == this.bWj) {
            aV(view);
        } else if (view == this.cbj) {
            aW(view);
        } else if (view == this.cbo) {
            aP(view);
        } else if (view == this.cbq) {
            aS(view);
        }
    }

    protected void aS(View view) {
        if (this.cbq != null && this.We != null && this.cbr != null && !this.We.agh()) {
            if (!this.We.agg()) {
                if (com.baidu.tieba.frs.a.bkY().Z(this.We)) {
                    this.We.dM(true);
                }
            } else {
                com.baidu.tieba.frs.a.bkY().aa(this.We);
                this.We.dM(false);
            }
            am.j(this.cbr, this.We.agg() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cbq.setImageDrawable(am.getDrawable(this.We.agg() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.cbK != null) {
                this.cbK.eu(this.We.agg());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.cbe != null) {
            this.cbe.setClickable(z);
            this.cbd.setEnabled(z);
            this.cbc.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.cba != null) {
            this.cba.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.cbh != null) {
            this.cbh.setClickable(z);
            this.cbg.setEnabled(z);
            this.cbf.setEnabled(z);
        }
    }

    private void aT(View view) {
        if (this.We != null && !StringUtils.isNull(this.We.aeC())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.cbH)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.We.aeC(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.We.aeC(), this.mStType, this.cbH)));
            }
            if (this.caw != null) {
                this.caw.onClick(view);
            }
        }
    }

    protected void aQ(View view) {
        if (this.We != null && this.mContext != null) {
            com.baidu.tieba.card.n.vw(this.We.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.We, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.We.getFid()));
            addLocateParam.setForumName(this.We.aeC());
            if (this.We.agl() && this.We.agk() != null) {
                addLocateParam.setForumId(this.We.agk().getForumId());
                addLocateParam.setForumName(this.We.agk().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.We.afw() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.cbF);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            an anVar = new an("c12291");
            anVar.P("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.P("obj_locate", this.mFrom);
            anVar2.P("obj_type", getThreadType());
            anVar2.bT("tid", this.We.getTid());
            TiebaStatic.log(anVar2);
            if (this.caw != null) {
                this.caw.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.We == null) {
            return 0;
        }
        if (this.We.isShareThread) {
            return 4;
        }
        if (this.We.getThreadType() == 49) {
            return 5;
        }
        if (this.We.aeO() != null) {
            return 1;
        }
        if (this.We.getType() == bg.bJj || this.We.getType() == bg.bJw) {
            if (v.Z(this.We.aeL()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.We != null || i >= 0) {
            an ja = ja(i);
            ja.P("thread_type", this.We.getThreadType());
            TiebaStatic.log(ja);
        }
    }

    private an ja(int i) {
        if (this.We == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.bT("tid", this.We.getTid());
        if (this.We.getThreadType() == 40) {
            anVar.bT("obj_param1", "2");
        } else if (this.We.getThreadType() == 0) {
            anVar.bT("obj_param1", "1");
        }
        anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        anVar.l("fid", this.We.getFid());
        anVar.P("obj_locate", this.mFrom);
        anVar.P(VideoPlayActivityConfig.OBJ_ID, i);
        if (!aq.isEmpty(this.cbG)) {
            anVar.bT("obj_floor", this.cbG);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bT("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aU(View view) {
        if (this.bWi != null) {
            addPraiseStats(this.bWi.aN(view));
        }
    }

    protected void aV(View view) {
        if (this.bWj != null) {
            this.bWj.aN(view);
        }
    }

    protected void aR(View view) {
        if ((bf.iN() || bd.cF(this.mContext)) && this.We != null) {
            akW();
            akY();
            if (this.caw != null && this.We.aeB()) {
                this.caw.onClick(view);
            }
        }
    }

    private void akW() {
        if (this.We != null) {
            an akX = akX();
            akX.P("thread_type", this.We.getThreadType());
            TiebaStatic.log(akX);
        }
    }

    private an akX() {
        int i = 4;
        if (this.We == null) {
            return null;
        }
        if (this.cbE != 1) {
            if (this.cbE == 2) {
                i = 5;
            } else if (this.cbE == 3) {
                i = 3;
            } else if (this.cbE == 4) {
                i = 2;
            } else if (this.cbE == 6) {
                i = 8;
            } else if (this.cbE == 7) {
                i = 9;
            } else if (this.cbE != 9) {
                i = 0;
            } else {
                i = 10;
            }
        }
        an anVar = new an("c12386");
        anVar.l("fid", this.We.getFid());
        anVar.bT("tid", this.We.getTid());
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.P("obj_locate", i);
        anVar.P("obj_param2", this.bWH);
        if (!aq.isEmpty(this.cbG)) {
            anVar.bT("obj_floor", this.cbG);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.We.aeQ() != null && this.We.aeQ().user_info != null && this.We.aeQ().user_info.is_official == 2) {
            anVar.P("obj_isofficial", this.We.aeQ().user_info.is_official);
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
    private void akY() {
        String str;
        boolean z;
        Uri parse;
        String str2;
        boolean z2 = false;
        if (this.We != null && this.mContext != null) {
            String valueOf = String.valueOf(this.We.getFid());
            String aeC = this.We.aeC();
            if (this.We.bMa != null) {
                valueOf = this.We.bMa.id;
                aeC = this.We.bMa.ori_fname;
            }
            String title = this.We.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.We.getAbstract();
            }
            String tid = this.We.getTid();
            String str3 = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            if (this.We.aeQ() != null && this.We.aeQ().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.We.aeQ().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.We.aeQ().user_info.user_name, "utf-8");
                    }
                    str = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String r = r(this.We);
                parse = r != null ? null : Uri.parse(r);
                String str4 = this.We.getAbstract();
                String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str4);
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                eVar.title = title;
                eVar.content = format;
                eVar.ckI = str4;
                eVar.linkUrl = str;
                eVar.bMt = this.cbE;
                eVar.extData = tid;
                eVar.ckL = 3;
                eVar.fid = valueOf;
                eVar.ckC = aeC;
                eVar.cla = z;
                eVar.tid = tid;
                eVar.ckv = true;
                eVar.ckK = getShareObjSource();
                eVar.ckP = s(this.We);
                if (parse != null) {
                    eVar.imageUri = parse;
                }
                eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.We);
                if (z) {
                    eVar.ckZ = this.We.getShareImageUrl();
                }
                TbadkCoreApplication.getInst().setShareItem(eVar);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", eVar.ckL);
                bundle.putInt("obj_type", eVar.ckP);
                bundle.putString("fid", eVar.fid);
                bundle.putString("tid", eVar.tid);
                bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMt);
                eVar.E(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
                if (this.We.getThreadType() != 49 || this.We.getThreadType() == 60) {
                    z2 = true;
                }
                shareDialogConfig.setIsAlaLive(z2);
                com.baidu.tieba.c.e.bbB().a(shareDialogConfig);
            }
            str = str3;
            z = true;
            String r2 = r(this.We);
            if (r2 != null) {
            }
            String str42 = this.We.getAbstract();
            String format2 = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str42);
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = format2;
            eVar2.ckI = str42;
            eVar2.linkUrl = str;
            eVar2.bMt = this.cbE;
            eVar2.extData = tid;
            eVar2.ckL = 3;
            eVar2.fid = valueOf;
            eVar2.ckC = aeC;
            eVar2.cla = z;
            eVar2.tid = tid;
            eVar2.ckv = true;
            eVar2.ckK = getShareObjSource();
            eVar2.ckP = s(this.We);
            if (parse != null) {
            }
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.We);
            if (z) {
            }
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.ckL);
            bundle2.putInt("obj_type", eVar2.ckP);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar2.bMt);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, eVar2, true, true);
            if (this.We.getThreadType() != 49) {
            }
            z2 = true;
            shareDialogConfig2.setIsAlaLive(z2);
            com.baidu.tieba.c.e.bbB().a(shareDialogConfig2);
        }
    }

    private int getShareObjSource() {
        if (this.cbE == 1) {
            return 5;
        }
        if (this.cbE != 3) {
            if (this.cbE == 4) {
                return 4;
            }
            if (this.cbE != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String r(bg bgVar) {
        String str;
        if (bgVar == null) {
            return null;
        }
        if (bgVar.aeQ() != null && !TextUtils.isEmpty(bgVar.aeQ().cover)) {
            return bgVar.aeQ().cover;
        }
        if (bgVar.aeH() == null) {
            return null;
        }
        ArrayList<MediaData> aeH = bgVar.aeH();
        int size = aeH.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aeH.get(i);
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
        if (str == null && bgVar.aeO() != null && !TextUtils.isEmpty(bgVar.aeO().thumbnail_url)) {
            return bgVar.aeO().thumbnail_url;
        }
        return str;
    }

    private int s(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.aez()) {
                return 4;
            }
            if (bgVar.aeu() == 1) {
                return 3;
            }
            return bgVar.afJ() ? 2 : 1;
        }
        return 0;
    }

    protected void aP(View view) {
        if (this.cbp == null) {
            this.cbp = new ac(this.mPageContext, this.cbL);
        }
        this.cbp.setData(this.We);
        this.cbp.showDialog();
        TiebaStatic.log(new an("c12711"));
    }

    private void aW(View view) {
        ala();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.cbw = z;
        if (this.caY != null) {
            this.caY.setClickable(this.cbw);
        }
    }

    public boolean isMoreViewVisible() {
        return this.cbj != null && this.cbj.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.cba != null) {
            this.cba.setForumId(str);
        }
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.We = bgVar;
        akZ();
        t(bgVar);
        v(bgVar);
        p(bgVar);
        o(bgVar);
        updatePraiseNum(bgVar);
        u(bgVar);
        q(bgVar);
        setVisibility(this.cbt ? 0 : 8);
        return this.cbt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akZ() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(bg bgVar) {
        this.caY.setVisibility(8);
    }

    protected void u(bg bgVar) {
        int af;
        if (this.cbs != null && this.cbq != null && this.cbr != null && bgVar != null) {
            if (!this.cbL) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cbs.setVisibility(8);
            } else if (this.cbD && com.baidu.tieba.frs.a.bkY().bkZ()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    am.l(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cbq.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cbq.performClick();
                        }
                    });
                }
                if (bgVar.agh()) {
                    af = com.baidu.adp.lib.util.l.af(getContext());
                } else {
                    af = (com.baidu.adp.lib.util.l.af(getContext()) / 4) * 3;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mMaskView.getLayoutParams();
                if (layoutParams == null) {
                    this.mMaskView.setLayoutParams(new FrameLayout.LayoutParams(af, -1));
                } else {
                    layoutParams.width = af;
                    requestLayout();
                }
                am.j(this.cbr, this.We.agg() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cbq.setImageDrawable(am.getDrawable(bgVar.agg() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.cbs.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cbs.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String aea;
        if (this.caZ != null && bgVar != null) {
            if (bgVar.aeq() <= 0 || !this.cbu) {
                this.caZ.setVisibility(8);
                return;
            }
            this.caZ.setVisibility(0);
            if (this.mFrom == 3) {
                aea = bgVar.aeb();
            } else {
                aea = bgVar.aea();
            }
            this.caZ.setText(aea);
            this.cbt = true;
        }
    }

    public boolean isVisible() {
        return this.cbt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(bg bgVar) {
        if (this.cbc != null && bgVar != null) {
            if (this.cbz) {
                this.cbe.setVisibility(0);
                if (this.cbe.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbe.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cbe.setLayoutParams(layoutParams);
                }
                if (bgVar.aeo() > 0) {
                    this.cbc.setVisibility(0);
                    String aO = aq.aO(bgVar.aeo());
                    if (this.cbx) {
                        this.cbd.setImageDrawable(am.getDrawable(this.cbI));
                        this.cbc.setText(aO);
                    } else {
                        this.cbc.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aO));
                    }
                    this.cbc.setContentDescription(this.mContext.getString(R.string.reply_num) + aO);
                    this.cbt = true;
                    return;
                } else if (this.cbx) {
                    this.cbd.setImageDrawable(am.getDrawable(this.cbI));
                    this.cbc.setText(this.mContext.getString(R.string.action_comment_default));
                    this.cbc.setVisibility(0);
                    this.cbt = true;
                    return;
                } else {
                    this.cbc.setVisibility(8);
                    return;
                }
            }
            this.cbe.setVisibility(8);
        }
    }

    public void updatePraiseNum(bg bgVar) {
        if (this.cba != null) {
            if (bgVar.getType() == bg.bJD || bgVar.getType() == bg.bJE) {
                this.cba.setDisPraiseFrom(5);
            }
            this.cba.n(bgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(bg bgVar) {
        if (this.cbh != null && this.cbf != null && bgVar != null) {
            if (this.cbB) {
                this.cbh.setVisibility(0);
                if (this.cbh.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbh.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cbh.setLayoutParams(layoutParams);
                }
                long afU = bgVar.afU();
                if ((bgVar.afI() || bgVar.afL()) && bgVar.aeQ() != null) {
                    afU = bgVar.aeQ().share_info.share_count;
                }
                this.cbf.setText(afU > 0 ? aq.aO(afU) : this.mContext.getString(R.string.share));
                this.cbt = true;
                if (bgVar.bLQ != null && bgVar.bLQ.isDeleted) {
                    setShareClickable(false);
                    am.k(this.cbg, R.drawable.icon_card_share_d);
                    am.j(this.cbf, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                am.k(this.cbg, this.cbJ);
                am.j(this.cbf, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cbh.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.cbj != null) {
            if (this.We == null || v.aa(this.We.afF()) || !TbadkCoreApplication.isLogin() || this.We.afG()) {
                this.cbj.setVisibility(8);
                return;
            }
            if (this.cbj.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbj.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.cbj.setLayoutParams(layoutParams);
            }
            if (this.cbk == null) {
                this.cbk = new ArrayList();
            } else {
                this.cbk.clear();
            }
            if (this.cbl == null) {
                this.cbl = new ArrayList();
            } else {
                this.cbl.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.We.afF()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.cbk.add(reportInfo.info);
                    this.cbl.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.cbj.setOnClickListener(this);
                this.cbj.setVisibility(0);
                return;
            }
            this.cbj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bg bgVar) {
        if (this.cbo != null && bgVar != null) {
            if (bgVar.bMa != null) {
                this.cbC = false;
            }
            if (this.cbC && (this.cbs == null || this.cbs.getVisibility() == 8)) {
                this.cbo.setVisibility(0);
                if (this.cbo.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbo.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cbo.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(R.string.manage);
                this.cbm.setText(string);
                this.cbm.setContentDescription(string);
                am.c(this.cbn, (int) R.drawable.icon_card_frs_manage_selector);
                this.cbt = true;
                return;
            }
            this.cbo.setVisibility(8);
        }
    }

    private void ala() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.hy(R.string.operation);
            bVar.a(this.cbk, new b.a() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.cbl, i);
                    if (!StringUtils.isNull(str)) {
                        bb.ajC().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.agL();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.j(this.caY, R.color.cp_cont_d);
            am.j(this.caZ, R.color.cp_cont_j);
            am.j(this.cbc, R.drawable.selector_comment_and_prise_item_text_color);
            am.j(this.cbm, R.drawable.selector_comment_and_prise_item_text_color);
            am.k(this.cbi, R.drawable.btn_frs_more_selector);
            if (this.cbc != null && this.cbx && this.cbI > 0) {
                this.cbd.setImageDrawable(am.getDrawable(this.cbI));
            }
            if (this.We != null && this.We.bLQ != null && this.We.bLQ.isDeleted) {
                setShareClickable(false);
                am.k(this.cbg, R.drawable.icon_card_share_d);
                am.j(this.cbf, R.color.cp_cont_e);
            } else {
                setShareClickable(true);
                am.k(this.cbg, this.cbJ);
                am.j(this.cbf, R.drawable.selector_comment_and_prise_item_text_color);
            }
            if (this.cbn != null) {
                this.cbn.setImageDrawable(am.getDrawable(R.drawable.icon_card_frs_manage_selector));
            }
            if (this.cbp != null) {
                this.cbp.onChangeSkinType();
            }
            if (this.cba != null) {
                this.cba.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            am.l(this.mMaskView, R.color.cp_bg_line_d);
            if (this.cbb != null) {
                this.cbb.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.caw = onClickListener;
        if (this.bWi != null) {
            this.bWi.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.caY;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.cbA = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.cbu = z;
    }

    public View getCommentNumView() {
        return this.cbc;
    }

    public View getCommentContainer() {
        return this.cbe;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.cbx = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.cby = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.cbD = z;
    }

    public void setManageVisible(boolean z) {
        this.cbC = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.cbK = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.cbq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.bOb;
    }

    public void setInFrsAllThread(boolean z) {
        this.cbL = z;
    }

    public boolean isInFrsAllThread() {
        return this.cbL;
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
        if (this.cba != null) {
            this.cba.onDestroy();
        }
        if (this.cbp != null) {
            this.cbp.destory();
        }
    }
}
