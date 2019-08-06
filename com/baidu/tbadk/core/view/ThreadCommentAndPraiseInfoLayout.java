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
import com.baidu.tbadk.core.data.bh;
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
    protected bh We;
    private LinearLayout bOg;
    private int bWN;
    protected PraiseView bWo;
    protected DisPraiseView bWp;
    private View.OnClickListener caC;
    protected boolean cbA;
    private boolean cbB;
    protected boolean cbC;
    protected boolean cbD;
    protected boolean cbE;
    protected boolean cbF;
    protected boolean cbG;
    private boolean cbH;
    protected boolean cbI;
    protected boolean cbJ;
    protected boolean cbK;
    private int cbL;
    public int cbM;
    public String cbN;
    private String cbO;
    protected int cbP;
    protected int cbQ;
    private a cbR;
    private boolean cbS;
    protected int cbe;
    protected TextView cbf;
    private TextView cbg;
    protected com.baidu.tbadk.core.view.a cbh;
    protected AgreeView cbi;
    protected TextView cbj;
    protected ImageView cbk;
    protected View cbl;
    protected TextView cbm;
    protected ImageView cbn;
    protected View cbo;
    protected TextView cbp;
    protected FrameLayout cbq;
    private List<CharSequence> cbr;
    private List<String> cbs;
    protected TextView cbt;
    protected ImageView cbu;
    protected View cbv;
    protected ac cbw;
    protected ImageView cbx;
    protected TextView cby;
    protected LinearLayout cbz;
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
        this.cbO = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.cbh != null) {
            this.cbh.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.cbh != null) {
            this.cbh.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.cbL = i;
    }

    public void setGameId(int i) {
        this.bWN = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.cbe = 0;
        this.cbA = false;
        this.cbB = true;
        this.cbC = true;
        this.cbD = true;
        this.cbE = false;
        this.cbF = false;
        this.cbG = true;
        this.cbH = false;
        this.cbI = true;
        this.cbJ = false;
        this.cbK = true;
        this.mFrom = 2;
        this.cbL = 1;
        this.mSkinType = 3;
        this.cbR = null;
        this.cbS = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbe = 0;
        this.cbA = false;
        this.cbB = true;
        this.cbC = true;
        this.cbD = true;
        this.cbE = false;
        this.cbF = false;
        this.cbG = true;
        this.cbH = false;
        this.cbI = true;
        this.cbJ = false;
        this.cbK = true;
        this.mFrom = 2;
        this.cbL = 1;
        this.mSkinType = 3;
        this.cbR = null;
        this.cbS = false;
        init(context);
    }

    protected View cG(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cbe = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds84);
        View cG = cG(context);
        this.cbf = (TextView) cG.findViewById(R.id.thread_info_bar_name);
        this.cbg = (TextView) cG.findViewById(R.id.thread_info_reply_time);
        this.bOg = (LinearLayout) cG.findViewById(R.id.thread_comment_layout_root);
        this.cbj = (TextView) cG.findViewById(R.id.thread_info_commont_num);
        this.cbk = (ImageView) cG.findViewById(R.id.thread_info_commont_img);
        this.cbl = cG.findViewById(R.id.thread_info_commont_container);
        this.cbm = (TextView) cG.findViewById(R.id.share_num);
        this.cbn = (ImageView) cG.findViewById(R.id.share_num_img);
        this.cbo = cG.findViewById(R.id.share_num_container);
        this.cbp = (TextView) cG.findViewById(R.id.thread_info_more);
        this.cbq = (FrameLayout) cG.findViewById(R.id.thread_info_more_frame);
        View findViewById = cG.findViewById(R.id.agree_view);
        if (findViewById != null) {
            this.bWo = (PraiseView) findViewById;
        }
        View findViewById2 = cG.findViewById(R.id.disagree_view);
        if (findViewById2 != null) {
            this.bWp = (DisPraiseView) findViewById2;
        }
        View findViewById3 = cG.findViewById(R.id.new_agree_view);
        if (findViewById3 != null) {
            this.cbi = (AgreeView) findViewById3;
            this.cbi.setAgreeAnimationResource(R.raw.agree);
            this.cbi.setDisagreeAnimationResource(R.raw.disagree);
        }
        if (this.bWo != null && this.bWp != null) {
            this.cbh = new com.baidu.tbadk.core.view.a(this.bWo, this.bWp);
        }
        this.cbv = cG.findViewById(R.id.manage_view_container);
        this.cbt = (TextView) cG.findViewById(R.id.thread_info_manage_text);
        this.cbu = (ImageView) cG.findViewById(R.id.thread_info_manage_img);
        this.cbx = (ImageView) cG.findViewById(R.id.manage_select_img);
        this.cby = (TextView) cG.findViewById(R.id.manage_select_text);
        this.cbz = (LinearLayout) cG.findViewById(R.id.manage_select_container);
        this.cbz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cbx.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cbx.performClick();
            }
        });
        this.cbz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cbx.performClick();
            }
        });
        if (this.bWo != null) {
            this.bWo.setOnClickListener(this);
        }
        if (this.bWp != null) {
            this.bWp.setOnClickListener(this);
        }
        this.cbl.setOnClickListener(this);
        this.cbo.setOnClickListener(this);
        this.cbv.setOnClickListener(this);
        this.cbx.setOnClickListener(this);
        this.cbQ = R.drawable.icon_home_card_share;
        this.cbP = R.drawable.icon_home_card_comment;
        if (this.cbh != null) {
            this.cbh.ake();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.cbh != null) {
                this.cbh.j(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.cbh != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.cbh.j(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.cbh.j(getPageUniqueId());
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
        if (view == this.cbf) {
            aT(view);
        } else if (view == this.cbl) {
            aQ(view);
        } else if (view == this.cbo) {
            aR(view);
        } else if (view == this.bWo) {
            aU(view);
        } else if (view == this.bWp) {
            aV(view);
        } else if (view == this.cbq) {
            aW(view);
        } else if (view == this.cbv) {
            aP(view);
        } else if (view == this.cbx) {
            aS(view);
        }
    }

    protected void aS(View view) {
        if (this.cbx != null && this.We != null && this.cby != null && !this.We.agi()) {
            if (!this.We.agh()) {
                if (com.baidu.tieba.frs.a.blf().aa(this.We)) {
                    this.We.dM(true);
                }
            } else {
                com.baidu.tieba.frs.a.blf().ab(this.We);
                this.We.dM(false);
            }
            am.j(this.cby, this.We.agh() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cbx.setImageDrawable(am.getDrawable(this.We.agh() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.cbR != null) {
                this.cbR.eu(this.We.agh());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.cbl != null) {
            this.cbl.setClickable(z);
            this.cbk.setEnabled(z);
            this.cbj.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.cbh != null) {
            this.cbh.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.cbo != null) {
            this.cbo.setClickable(z);
            this.cbn.setEnabled(z);
            this.cbm.setEnabled(z);
        }
    }

    private void aT(View view) {
        if (this.We != null && !StringUtils.isNull(this.We.aeD())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.cbO)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.We.aeD(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.We.aeD(), this.mStType, this.cbO)));
            }
            if (this.caC != null) {
                this.caC.onClick(view);
            }
        }
    }

    protected void aQ(View view) {
        if (this.We != null && this.mContext != null) {
            com.baidu.tieba.card.n.vx(this.We.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.We, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.We.getFid()));
            addLocateParam.setForumName(this.We.aeD());
            if (this.We.agm() && this.We.agl() != null) {
                addLocateParam.setForumId(this.We.agl().getForumId());
                addLocateParam.setForumName(this.We.agl().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.We.afx() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.cbM);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            an anVar = new an("c12291");
            anVar.P("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.P("obj_locate", this.mFrom);
            anVar2.P("obj_type", getThreadType());
            anVar2.bT("tid", this.We.getTid());
            TiebaStatic.log(anVar2);
            if (this.caC != null) {
                this.caC.onClick(view);
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
        if (this.We.aeP() != null) {
            return 1;
        }
        if (this.We.getType() == bh.bJo || this.We.getType() == bh.bJB) {
            if (v.Z(this.We.aeM()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.We != null || i >= 0) {
            an jb = jb(i);
            jb.P("thread_type", this.We.getThreadType());
            TiebaStatic.log(jb);
        }
    }

    private an jb(int i) {
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
        if (!aq.isEmpty(this.cbN)) {
            anVar.bT("obj_floor", this.cbN);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bT("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aU(View view) {
        if (this.bWo != null) {
            addPraiseStats(this.bWo.aN(view));
        }
    }

    protected void aV(View view) {
        if (this.bWp != null) {
            this.bWp.aN(view);
        }
    }

    protected void aR(View view) {
        if ((bf.iN() || bd.cF(this.mContext)) && this.We != null) {
            akY();
            ala();
            if (this.caC != null && this.We.aeC()) {
                this.caC.onClick(view);
            }
        }
    }

    private void akY() {
        if (this.We != null) {
            an akZ = akZ();
            akZ.P("thread_type", this.We.getThreadType());
            TiebaStatic.log(akZ);
        }
    }

    private an akZ() {
        int i = 4;
        if (this.We == null) {
            return null;
        }
        if (this.cbL != 1) {
            if (this.cbL == 2) {
                i = 5;
            } else if (this.cbL == 3) {
                i = 3;
            } else if (this.cbL == 4) {
                i = 2;
            } else if (this.cbL == 6) {
                i = 8;
            } else if (this.cbL == 7) {
                i = 9;
            } else if (this.cbL != 9) {
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
        anVar.P("obj_param2", this.bWN);
        if (!aq.isEmpty(this.cbN)) {
            anVar.bT("obj_floor", this.cbN);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.We.aeR() != null && this.We.aeR().user_info != null && this.We.aeR().user_info.is_official == 2) {
            anVar.P("obj_isofficial", this.We.aeR().user_info.is_official);
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
    private void ala() {
        String str;
        boolean z;
        Uri parse;
        String str2;
        boolean z2 = false;
        if (this.We != null && this.mContext != null) {
            String valueOf = String.valueOf(this.We.getFid());
            String aeD = this.We.aeD();
            if (this.We.bMf != null) {
                valueOf = this.We.bMf.id;
                aeD = this.We.bMf.ori_fname;
            }
            String title = this.We.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.We.getAbstract();
            }
            String tid = this.We.getTid();
            String str3 = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            if (this.We.aeR() != null && this.We.aeR().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.We.aeR().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.We.aeR().user_info.user_name, "utf-8");
                    }
                    str = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String s = s(this.We);
                parse = s != null ? null : Uri.parse(s);
                String str4 = this.We.getAbstract();
                String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str4);
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                eVar.title = title;
                eVar.content = format;
                eVar.ckP = str4;
                eVar.linkUrl = str;
                eVar.bMy = this.cbL;
                eVar.extData = tid;
                eVar.ckS = 3;
                eVar.fid = valueOf;
                eVar.ckJ = aeD;
                eVar.clh = z;
                eVar.tid = tid;
                eVar.ckC = true;
                eVar.ckR = getShareObjSource();
                eVar.ckW = t(this.We);
                if (parse != null) {
                    eVar.imageUri = parse;
                }
                eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.We);
                if (z) {
                    eVar.clg = this.We.getShareImageUrl();
                }
                TbadkCoreApplication.getInst().setShareItem(eVar);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", eVar.ckS);
                bundle.putInt("obj_type", eVar.ckW);
                bundle.putString("fid", eVar.fid);
                bundle.putString("tid", eVar.tid);
                bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMy);
                eVar.E(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
                if (this.We.getThreadType() != 49 || this.We.getThreadType() == 60) {
                    z2 = true;
                }
                shareDialogConfig.setIsAlaLive(z2);
                com.baidu.tieba.c.e.bbD().a(shareDialogConfig);
            }
            str = str3;
            z = true;
            String s2 = s(this.We);
            if (s2 != null) {
            }
            String str42 = this.We.getAbstract();
            String format2 = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str42);
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = format2;
            eVar2.ckP = str42;
            eVar2.linkUrl = str;
            eVar2.bMy = this.cbL;
            eVar2.extData = tid;
            eVar2.ckS = 3;
            eVar2.fid = valueOf;
            eVar2.ckJ = aeD;
            eVar2.clh = z;
            eVar2.tid = tid;
            eVar2.ckC = true;
            eVar2.ckR = getShareObjSource();
            eVar2.ckW = t(this.We);
            if (parse != null) {
            }
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.We);
            if (z) {
            }
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.ckS);
            bundle2.putInt("obj_type", eVar2.ckW);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar2.bMy);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, eVar2, true, true);
            if (this.We.getThreadType() != 49) {
            }
            z2 = true;
            shareDialogConfig2.setIsAlaLive(z2);
            com.baidu.tieba.c.e.bbD().a(shareDialogConfig2);
        }
    }

    private int getShareObjSource() {
        if (this.cbL == 1) {
            return 5;
        }
        if (this.cbL != 3) {
            if (this.cbL == 4) {
                return 4;
            }
            if (this.cbL != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String s(bh bhVar) {
        String str;
        if (bhVar == null) {
            return null;
        }
        if (bhVar.aeR() != null && !TextUtils.isEmpty(bhVar.aeR().cover)) {
            return bhVar.aeR().cover;
        }
        if (bhVar.aeI() == null) {
            return null;
        }
        ArrayList<MediaData> aeI = bhVar.aeI();
        int size = aeI.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aeI.get(i);
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
        if (str == null && bhVar.aeP() != null && !TextUtils.isEmpty(bhVar.aeP().thumbnail_url)) {
            return bhVar.aeP().thumbnail_url;
        }
        return str;
    }

    private int t(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.aeA()) {
                return 4;
            }
            if (bhVar.aev() == 1) {
                return 3;
            }
            return bhVar.afK() ? 2 : 1;
        }
        return 0;
    }

    protected void aP(View view) {
        if (this.cbw == null) {
            this.cbw = new ac(this.mPageContext, this.cbS);
        }
        this.cbw.setData(this.We);
        this.cbw.showDialog();
        TiebaStatic.log(new an("c12711"));
    }

    private void aW(View view) {
        alc();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.cbD = z;
        if (this.cbf != null) {
            this.cbf.setClickable(this.cbD);
        }
    }

    public boolean isMoreViewVisible() {
        return this.cbq != null && this.cbq.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.cbh != null) {
            this.cbh.setForumId(str);
        }
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.We = bhVar;
        alb();
        u(bhVar);
        w(bhVar);
        q(bhVar);
        p(bhVar);
        updatePraiseNum(bhVar);
        v(bhVar);
        r(bhVar);
        setVisibility(this.cbA ? 0 : 8);
        return this.cbA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alb() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(bh bhVar) {
        this.cbf.setVisibility(8);
    }

    protected void v(bh bhVar) {
        int af;
        if (this.cbz != null && this.cbx != null && this.cby != null && bhVar != null) {
            if (!this.cbS) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cbz.setVisibility(8);
            } else if (this.cbK && com.baidu.tieba.frs.a.blf().blg()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    am.l(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cbx.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cbx.performClick();
                        }
                    });
                }
                if (bhVar.agi()) {
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
                am.j(this.cby, this.We.agh() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cbx.setImageDrawable(am.getDrawable(bhVar.agh() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.cbz.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cbz.setVisibility(8);
            }
        }
    }

    private void w(bh bhVar) {
        String aeb;
        if (this.cbg != null && bhVar != null) {
            if (bhVar.aer() <= 0 || !this.cbB) {
                this.cbg.setVisibility(8);
                return;
            }
            this.cbg.setVisibility(0);
            if (this.mFrom == 3) {
                aeb = bhVar.aec();
            } else {
                aeb = bhVar.aeb();
            }
            this.cbg.setText(aeb);
            this.cbA = true;
        }
    }

    public boolean isVisible() {
        return this.cbA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bh bhVar) {
        if (this.cbj != null && bhVar != null) {
            if (this.cbG) {
                this.cbl.setVisibility(0);
                if (this.cbl.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbl.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cbl.setLayoutParams(layoutParams);
                }
                if (bhVar.aep() > 0) {
                    this.cbj.setVisibility(0);
                    String aO = aq.aO(bhVar.aep());
                    if (this.cbE) {
                        this.cbk.setImageDrawable(am.getDrawable(this.cbP));
                        this.cbj.setText(aO);
                    } else {
                        this.cbj.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aO));
                    }
                    this.cbj.setContentDescription(this.mContext.getString(R.string.reply_num) + aO);
                    this.cbA = true;
                    return;
                } else if (this.cbE) {
                    this.cbk.setImageDrawable(am.getDrawable(this.cbP));
                    this.cbj.setText(this.mContext.getString(R.string.action_comment_default));
                    this.cbj.setVisibility(0);
                    this.cbA = true;
                    return;
                } else {
                    this.cbj.setVisibility(8);
                    return;
                }
            }
            this.cbl.setVisibility(8);
        }
    }

    public void updatePraiseNum(bh bhVar) {
        if (this.cbh != null) {
            if (bhVar.getType() == bh.bJI || bhVar.getType() == bh.bJJ) {
                this.cbh.setDisPraiseFrom(5);
            }
            this.cbh.o(bhVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(bh bhVar) {
        if (this.cbo != null && this.cbm != null && bhVar != null) {
            if (this.cbI) {
                this.cbo.setVisibility(0);
                if (this.cbo.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbo.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cbo.setLayoutParams(layoutParams);
                }
                long afV = bhVar.afV();
                if ((bhVar.afJ() || bhVar.afM()) && bhVar.aeR() != null) {
                    afV = bhVar.aeR().share_info.share_count;
                }
                this.cbm.setText(afV > 0 ? aq.aO(afV) : this.mContext.getString(R.string.share));
                this.cbA = true;
                if (bhVar.bLV != null && bhVar.bLV.isDeleted) {
                    setShareClickable(false);
                    am.k(this.cbn, R.drawable.icon_card_share_d);
                    am.j(this.cbm, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                am.k(this.cbn, this.cbQ);
                am.j(this.cbm, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cbo.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.cbq != null) {
            if (this.We == null || v.aa(this.We.afG()) || !TbadkCoreApplication.isLogin() || this.We.afH()) {
                this.cbq.setVisibility(8);
                return;
            }
            if (this.cbq.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbq.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.cbq.setLayoutParams(layoutParams);
            }
            if (this.cbr == null) {
                this.cbr = new ArrayList();
            } else {
                this.cbr.clear();
            }
            if (this.cbs == null) {
                this.cbs = new ArrayList();
            } else {
                this.cbs.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.We.afG()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.cbr.add(reportInfo.info);
                    this.cbs.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.cbq.setOnClickListener(this);
                this.cbq.setVisibility(0);
                return;
            }
            this.cbq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(bh bhVar) {
        if (this.cbv != null && bhVar != null) {
            if (bhVar.bMf != null) {
                this.cbJ = false;
            }
            if (this.cbJ && (this.cbz == null || this.cbz.getVisibility() == 8)) {
                this.cbv.setVisibility(0);
                if (this.cbv.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbv.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cbv.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(R.string.manage);
                this.cbt.setText(string);
                this.cbt.setContentDescription(string);
                am.c(this.cbu, (int) R.drawable.icon_card_frs_manage_selector);
                this.cbA = true;
                return;
            }
            this.cbv.setVisibility(8);
        }
    }

    private void alc() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.hy(R.string.operation);
            bVar.a(this.cbr, new b.a() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.cbs, i);
                    if (!StringUtils.isNull(str)) {
                        bb.ajE().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.agN();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.j(this.cbf, R.color.cp_cont_d);
            am.j(this.cbg, R.color.cp_cont_j);
            am.j(this.cbj, R.drawable.selector_comment_and_prise_item_text_color);
            am.j(this.cbt, R.drawable.selector_comment_and_prise_item_text_color);
            am.k(this.cbp, R.drawable.btn_frs_more_selector);
            if (this.cbj != null && this.cbE && this.cbP > 0) {
                this.cbk.setImageDrawable(am.getDrawable(this.cbP));
            }
            if (this.We != null && this.We.bLV != null && this.We.bLV.isDeleted) {
                setShareClickable(false);
                am.k(this.cbn, R.drawable.icon_card_share_d);
                am.j(this.cbm, R.color.cp_cont_e);
            } else {
                setShareClickable(true);
                am.k(this.cbn, this.cbQ);
                am.j(this.cbm, R.drawable.selector_comment_and_prise_item_text_color);
            }
            if (this.cbu != null) {
                this.cbu.setImageDrawable(am.getDrawable(R.drawable.icon_card_frs_manage_selector));
            }
            if (this.cbw != null) {
                this.cbw.onChangeSkinType();
            }
            if (this.cbh != null) {
                this.cbh.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            am.l(this.mMaskView, R.color.cp_bg_line_d);
            if (this.cbi != null) {
                this.cbi.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.caC = onClickListener;
        if (this.bWo != null) {
            this.bWo.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.cbf;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.cbH = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.cbB = z;
    }

    public View getCommentNumView() {
        return this.cbj;
    }

    public View getCommentContainer() {
        return this.cbl;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.cbE = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.cbF = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.cbK = z;
    }

    public void setManageVisible(boolean z) {
        this.cbJ = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.cbR = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.cbx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.bOg;
    }

    public void setInFrsAllThread(boolean z) {
        this.cbS = z;
    }

    public boolean isInFrsAllThread() {
        return this.cbS;
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
        if (this.cbh != null) {
            this.cbh.onDestroy();
        }
        if (this.cbw != null) {
            this.cbw.destory();
        }
    }
}
