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
    protected bh Wd;
    private LinearLayout bOF;
    private int bXG;
    protected PraiseView bXh;
    protected DisPraiseView bXi;
    protected int cbX;
    protected TextView cbY;
    private TextView cbZ;
    private View.OnClickListener cbv;
    protected boolean ccA;
    private boolean ccB;
    protected boolean ccC;
    protected boolean ccD;
    protected boolean ccE;
    private int ccF;
    public int ccG;
    public String ccH;
    private String ccI;
    protected int ccJ;
    protected int ccK;
    private a ccL;
    private boolean ccM;
    protected com.baidu.tbadk.core.view.a cca;
    protected AgreeView ccb;
    protected TextView ccc;
    protected ImageView ccd;
    protected View cce;
    protected TextView ccf;
    protected ImageView ccg;
    protected View cch;
    protected TextView cci;
    protected FrameLayout ccj;
    private List<CharSequence> cck;
    private List<String> ccl;
    protected TextView ccm;
    protected ImageView ccn;
    protected View cco;
    protected ac ccp;
    protected ImageView ccq;
    protected TextView ccr;
    protected LinearLayout cct;
    protected boolean ccu;
    private boolean ccv;
    protected boolean ccw;
    protected boolean ccx;
    protected boolean ccy;
    protected boolean ccz;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private int mSkinType;
    private String mStType;

    /* loaded from: classes3.dex */
    public interface a {
        void ex(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.ccI = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.cca != null) {
            this.cca.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.cca != null) {
            this.cca.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.ccF = i;
    }

    public void setGameId(int i) {
        this.bXG = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.cbX = 0;
        this.ccu = false;
        this.ccv = true;
        this.ccw = true;
        this.ccx = true;
        this.ccy = false;
        this.ccz = false;
        this.ccA = true;
        this.ccB = false;
        this.ccC = true;
        this.ccD = false;
        this.ccE = true;
        this.mFrom = 2;
        this.ccF = 1;
        this.mSkinType = 3;
        this.ccL = null;
        this.ccM = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbX = 0;
        this.ccu = false;
        this.ccv = true;
        this.ccw = true;
        this.ccx = true;
        this.ccy = false;
        this.ccz = false;
        this.ccA = true;
        this.ccB = false;
        this.ccC = true;
        this.ccD = false;
        this.ccE = true;
        this.mFrom = 2;
        this.ccF = 1;
        this.mSkinType = 3;
        this.ccL = null;
        this.ccM = false;
        init(context);
    }

    protected View cG(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cbX = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds84);
        View cG = cG(context);
        this.cbY = (TextView) cG.findViewById(R.id.thread_info_bar_name);
        this.cbZ = (TextView) cG.findViewById(R.id.thread_info_reply_time);
        this.bOF = (LinearLayout) cG.findViewById(R.id.thread_comment_layout_root);
        this.ccc = (TextView) cG.findViewById(R.id.thread_info_commont_num);
        this.ccd = (ImageView) cG.findViewById(R.id.thread_info_commont_img);
        this.cce = cG.findViewById(R.id.thread_info_commont_container);
        this.ccf = (TextView) cG.findViewById(R.id.share_num);
        this.ccg = (ImageView) cG.findViewById(R.id.share_num_img);
        this.cch = cG.findViewById(R.id.share_num_container);
        this.cci = (TextView) cG.findViewById(R.id.thread_info_more);
        this.ccj = (FrameLayout) cG.findViewById(R.id.thread_info_more_frame);
        View findViewById = cG.findViewById(R.id.agree_view);
        if (findViewById != null) {
            this.bXh = (PraiseView) findViewById;
        }
        View findViewById2 = cG.findViewById(R.id.disagree_view);
        if (findViewById2 != null) {
            this.bXi = (DisPraiseView) findViewById2;
        }
        View findViewById3 = cG.findViewById(R.id.new_agree_view);
        if (findViewById3 != null) {
            this.ccb = (AgreeView) findViewById3;
            this.ccb.setAgreeAnimationResource(R.raw.agree);
            this.ccb.setDisagreeAnimationResource(R.raw.disagree);
        }
        if (this.bXh != null && this.bXi != null) {
            this.cca = new com.baidu.tbadk.core.view.a(this.bXh, this.bXi);
        }
        this.cco = cG.findViewById(R.id.manage_view_container);
        this.ccm = (TextView) cG.findViewById(R.id.thread_info_manage_text);
        this.ccn = (ImageView) cG.findViewById(R.id.thread_info_manage_img);
        this.ccq = (ImageView) cG.findViewById(R.id.manage_select_img);
        this.ccr = (TextView) cG.findViewById(R.id.manage_select_text);
        this.cct = (LinearLayout) cG.findViewById(R.id.manage_select_container);
        this.cct.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.ccq.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ccr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.ccq.performClick();
            }
        });
        this.cct.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.ccq.performClick();
            }
        });
        if (this.bXh != null) {
            this.bXh.setOnClickListener(this);
        }
        if (this.bXi != null) {
            this.bXi.setOnClickListener(this);
        }
        this.cce.setOnClickListener(this);
        this.cch.setOnClickListener(this);
        this.cco.setOnClickListener(this);
        this.ccq.setOnClickListener(this);
        this.ccK = R.drawable.icon_home_card_share;
        this.ccJ = R.drawable.icon_home_card_comment;
        if (this.cca != null) {
            this.cca.akq();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.cca != null) {
                this.cca.j(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.cca != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.cca.j(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.cca.j(getPageUniqueId());
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
        if (view == this.cbY) {
            aT(view);
        } else if (view == this.cce) {
            aQ(view);
        } else if (view == this.cch) {
            aR(view);
        } else if (view == this.bXh) {
            aU(view);
        } else if (view == this.bXi) {
            aV(view);
        } else if (view == this.ccj) {
            aW(view);
        } else if (view == this.cco) {
            aP(view);
        } else if (view == this.ccq) {
            aS(view);
        }
    }

    protected void aS(View view) {
        if (this.ccq != null && this.Wd != null && this.ccr != null && !this.Wd.agm()) {
            if (!this.Wd.agl()) {
                if (com.baidu.tieba.frs.a.blQ().ab(this.Wd)) {
                    this.Wd.dM(true);
                }
            } else {
                com.baidu.tieba.frs.a.blQ().ac(this.Wd);
                this.Wd.dM(false);
            }
            am.j(this.ccr, this.Wd.agl() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.ccq.setImageDrawable(am.getDrawable(this.Wd.agl() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.ccL != null) {
                this.ccL.ex(this.Wd.agl());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.cce != null) {
            this.cce.setClickable(z);
            this.ccd.setEnabled(z);
            this.ccc.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.cca != null) {
            this.cca.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.cch != null) {
            this.cch.setClickable(z);
            this.ccg.setEnabled(z);
            this.ccf.setEnabled(z);
        }
    }

    private void aT(View view) {
        if (this.Wd != null && !StringUtils.isNull(this.Wd.aeH())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.ccI)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.Wd.aeH(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.Wd.aeH(), this.mStType, this.ccI)));
            }
            if (this.cbv != null) {
                this.cbv.onClick(view);
            }
        }
    }

    protected void aQ(View view) {
        if (this.Wd != null && this.mContext != null) {
            com.baidu.tieba.card.n.vW(this.Wd.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.Wd, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.Wd.getFid()));
            addLocateParam.setForumName(this.Wd.aeH());
            if (this.Wd.agq() && this.Wd.agp() != null) {
                addLocateParam.setForumId(this.Wd.agp().getForumId());
                addLocateParam.setForumName(this.Wd.agp().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.Wd.afB() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.ccG);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            an anVar = new an("c12291");
            anVar.P("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.P("obj_locate", this.mFrom);
            anVar2.P("obj_type", getThreadType());
            anVar2.bT("tid", this.Wd.getTid());
            TiebaStatic.log(anVar2);
            if (this.cbv != null) {
                this.cbv.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.Wd == null) {
            return 0;
        }
        if (this.Wd.isShareThread) {
            return 4;
        }
        if (this.Wd.getThreadType() == 49) {
            return 5;
        }
        if (this.Wd.aeT() != null) {
            return 1;
        }
        if (this.Wd.getType() == bh.bJM || this.Wd.getType() == bh.bJZ) {
            if (v.Z(this.Wd.aeQ()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.Wd != null || i >= 0) {
            an je = je(i);
            je.P("thread_type", this.Wd.getThreadType());
            TiebaStatic.log(je);
        }
    }

    private an je(int i) {
        if (this.Wd == null && i < 0) {
            return null;
        }
        an anVar = new an("c12003");
        anVar.bT("tid", this.Wd.getTid());
        if (this.Wd.getThreadType() == 40) {
            anVar.bT("obj_param1", "2");
        } else if (this.Wd.getThreadType() == 0) {
            anVar.bT("obj_param1", "1");
        }
        anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        anVar.n("fid", this.Wd.getFid());
        anVar.P("obj_locate", this.mFrom);
        anVar.P(VideoPlayActivityConfig.OBJ_ID, i);
        if (!aq.isEmpty(this.ccH)) {
            anVar.bT("obj_floor", this.ccH);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bT("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return anVar;
        }
        return anVar;
    }

    protected void aU(View view) {
        if (this.bXh != null) {
            addPraiseStats(this.bXh.aN(view));
        }
    }

    protected void aV(View view) {
        if (this.bXi != null) {
            this.bXi.aN(view);
        }
    }

    protected void aR(View view) {
        if ((bf.iN() || bc.cF(this.mContext)) && this.Wd != null) {
            alk();
            alm();
            if (this.cbv != null && this.Wd.aeG()) {
                this.cbv.onClick(view);
            }
        }
    }

    private void alk() {
        if (this.Wd != null) {
            an all = all();
            all.P("thread_type", this.Wd.getThreadType());
            TiebaStatic.log(all);
        }
    }

    private an all() {
        int i = 4;
        if (this.Wd == null) {
            return null;
        }
        if (this.ccF != 1) {
            if (this.ccF == 2) {
                i = 5;
            } else if (this.ccF == 3) {
                i = 3;
            } else if (this.ccF == 4) {
                i = 2;
            } else if (this.ccF == 6) {
                i = 8;
            } else if (this.ccF == 7) {
                i = 9;
            } else if (this.ccF != 9) {
                i = 0;
            } else {
                i = 10;
            }
        }
        an anVar = new an("c12386");
        anVar.n("fid", this.Wd.getFid());
        anVar.bT("tid", this.Wd.getTid());
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.P("obj_locate", i);
        anVar.P("obj_param2", this.bXG);
        if (!aq.isEmpty(this.ccH)) {
            anVar.bT("obj_floor", this.ccH);
        }
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.Wd.aeV() != null && this.Wd.aeV().user_info != null && this.Wd.aeV().user_info.is_official == 2) {
            anVar.P("obj_isofficial", this.Wd.aeV().user_info.is_official);
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
    private void alm() {
        String str;
        boolean z;
        Uri parse;
        String str2;
        boolean z2 = false;
        if (this.Wd != null && this.mContext != null) {
            String valueOf = String.valueOf(this.Wd.getFid());
            String aeH = this.Wd.aeH();
            if (this.Wd.bMD != null) {
                valueOf = this.Wd.bMD.id;
                aeH = this.Wd.bMD.ori_fname;
            }
            String title = this.Wd.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.Wd.getAbstract();
            }
            String tid = this.Wd.getTid();
            String str3 = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            if (this.Wd.aeV() != null && this.Wd.aeV().user_info != null) {
                try {
                    if (TbConfig.HTTPS_LIVE_SHARE_PREFIX.contains("?")) {
                        str2 = "https://tieba.baidu.com/ala/share&uname=" + URLEncoder.encode(this.Wd.aeV().user_info.user_name, "utf-8");
                    } else {
                        str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.Wd.aeV().user_info.user_name, "utf-8");
                    }
                    str = str2;
                    z = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                String t = t(this.Wd);
                parse = t != null ? null : Uri.parse(t);
                String str4 = this.Wd.getAbstract();
                String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str4);
                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                eVar.title = title;
                eVar.content = format;
                eVar.clK = str4;
                eVar.linkUrl = str;
                eVar.bMX = this.ccF;
                eVar.extData = tid;
                eVar.clN = 3;
                eVar.fid = valueOf;
                eVar.clE = aeH;
                eVar.cmc = z;
                eVar.tid = tid;
                eVar.clx = true;
                eVar.clM = getShareObjSource();
                eVar.clR = u(this.Wd);
                if (parse != null) {
                    eVar.imageUri = parse;
                }
                eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.Wd);
                if (z) {
                    eVar.cmb = this.Wd.getShareImageUrl();
                }
                TbadkCoreApplication.getInst().setShareItem(eVar);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", eVar.clN);
                bundle.putInt("obj_type", eVar.clR);
                bundle.putString("fid", eVar.fid);
                bundle.putString("tid", eVar.tid);
                bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMX);
                eVar.E(bundle);
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
                if (this.Wd.getThreadType() != 49 || this.Wd.getThreadType() == 60) {
                    z2 = true;
                }
                shareDialogConfig.setIsAlaLive(z2);
                com.baidu.tieba.c.e.bch().a(shareDialogConfig);
            }
            str = str3;
            z = true;
            String t2 = t(this.Wd);
            if (t2 != null) {
            }
            String str42 = this.Wd.getAbstract();
            String format2 = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str42);
            com.baidu.tbadk.coreExtra.c.e eVar2 = new com.baidu.tbadk.coreExtra.c.e();
            eVar2.title = title;
            eVar2.content = format2;
            eVar2.clK = str42;
            eVar2.linkUrl = str;
            eVar2.bMX = this.ccF;
            eVar2.extData = tid;
            eVar2.clN = 3;
            eVar2.fid = valueOf;
            eVar2.clE = aeH;
            eVar2.cmc = z;
            eVar2.tid = tid;
            eVar2.clx = true;
            eVar2.clM = getShareObjSource();
            eVar2.clR = u(this.Wd);
            if (parse != null) {
            }
            eVar2.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.Wd);
            if (z) {
            }
            TbadkCoreApplication.getInst().setShareItem(eVar2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", eVar2.clN);
            bundle2.putInt("obj_type", eVar2.clR);
            bundle2.putString("fid", eVar2.fid);
            bundle2.putString("tid", eVar2.tid);
            bundle2.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar2.bMX);
            eVar2.E(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, eVar2, true, true);
            if (this.Wd.getThreadType() != 49) {
            }
            z2 = true;
            shareDialogConfig2.setIsAlaLive(z2);
            com.baidu.tieba.c.e.bch().a(shareDialogConfig2);
        }
    }

    private int getShareObjSource() {
        if (this.ccF == 1) {
            return 5;
        }
        if (this.ccF != 3) {
            if (this.ccF == 4) {
                return 4;
            }
            if (this.ccF != 6) {
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
        if (bhVar.aeV() != null && !TextUtils.isEmpty(bhVar.aeV().cover)) {
            return bhVar.aeV().cover;
        }
        if (bhVar.aeM() == null) {
            return null;
        }
        ArrayList<MediaData> aeM = bhVar.aeM();
        int size = aeM.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = aeM.get(i);
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
        if (str == null && bhVar.aeT() != null && !TextUtils.isEmpty(bhVar.aeT().thumbnail_url)) {
            return bhVar.aeT().thumbnail_url;
        }
        return str;
    }

    private int u(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.aeE()) {
                return 4;
            }
            if (bhVar.aez() == 1) {
                return 3;
            }
            return bhVar.afO() ? 2 : 1;
        }
        return 0;
    }

    protected void aP(View view) {
        if (this.ccp == null) {
            this.ccp = new ac(this.mPageContext, this.ccM);
        }
        this.ccp.setData(this.Wd);
        this.ccp.showDialog();
        TiebaStatic.log(new an("c12711"));
    }

    private void aW(View view) {
        alo();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ccx = z;
        if (this.cbY != null) {
            this.cbY.setClickable(this.ccx);
        }
    }

    public boolean isMoreViewVisible() {
        return this.ccj != null && this.ccj.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.cca != null) {
            this.cca.setForumId(str);
        }
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.Wd = bhVar;
        aln();
        v(bhVar);
        x(bhVar);
        r(bhVar);
        q(bhVar);
        updatePraiseNum(bhVar);
        w(bhVar);
        s(bhVar);
        setVisibility(this.ccu ? 0 : 8);
        return this.ccu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aln() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(bh bhVar) {
        this.cbY.setVisibility(8);
    }

    protected void w(bh bhVar) {
        int af;
        if (this.cct != null && this.ccq != null && this.ccr != null && bhVar != null) {
            if (!this.ccM) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cct.setVisibility(8);
            } else if (this.ccE && com.baidu.tieba.frs.a.blQ().blR()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    am.l(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.ccq.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.ccq.performClick();
                        }
                    });
                }
                if (bhVar.agm()) {
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
                am.j(this.ccr, this.Wd.agl() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.ccq.setImageDrawable(am.getDrawable(bhVar.agl() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.cct.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cct.setVisibility(8);
            }
        }
    }

    private void x(bh bhVar) {
        String aef;
        if (this.cbZ != null && bhVar != null) {
            if (bhVar.aev() <= 0 || !this.ccv) {
                this.cbZ.setVisibility(8);
                return;
            }
            this.cbZ.setVisibility(0);
            if (this.mFrom == 3) {
                aef = bhVar.aeg();
            } else {
                aef = bhVar.aef();
            }
            this.cbZ.setText(aef);
            this.ccu = true;
        }
    }

    public boolean isVisible() {
        return this.ccu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(bh bhVar) {
        if (this.ccc != null && bhVar != null) {
            if (this.ccA) {
                this.cce.setVisibility(0);
                if (this.cce.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cce.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cce.setLayoutParams(layoutParams);
                }
                if (bhVar.aet() > 0) {
                    this.ccc.setVisibility(0);
                    String aO = aq.aO(bhVar.aet());
                    if (this.ccy) {
                        SvgManager.ajv().a(this.ccd, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        this.ccc.setText(aO);
                    } else {
                        this.ccc.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aO));
                    }
                    this.ccc.setContentDescription(this.mContext.getString(R.string.reply_num) + aO);
                    this.ccu = true;
                    return;
                } else if (this.ccy) {
                    SvgManager.ajv().a(this.ccd, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.ccc.setText(this.mContext.getString(R.string.action_comment_default));
                    this.ccc.setVisibility(0);
                    this.ccu = true;
                    return;
                } else {
                    this.ccc.setVisibility(8);
                    return;
                }
            }
            this.cce.setVisibility(8);
        }
    }

    public void updatePraiseNum(bh bhVar) {
        if (this.cca != null) {
            if (bhVar.getType() == bh.bKg || bhVar.getType() == bh.bKh) {
                this.cca.setDisPraiseFrom(5);
            }
            this.cca.p(bhVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bh bhVar) {
        if (this.cch != null && this.ccf != null && bhVar != null) {
            if (this.ccC) {
                this.cch.setVisibility(0);
                if (this.cch.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cch.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cch.setLayoutParams(layoutParams);
                }
                long afZ = bhVar.afZ();
                if ((bhVar.afN() || bhVar.afQ()) && bhVar.aeV() != null) {
                    afZ = bhVar.aeV().share_info.share_count;
                }
                this.ccf.setText(afZ > 0 ? aq.aO(afZ) : this.mContext.getString(R.string.share));
                this.ccu = true;
                if (bhVar.bMt != null && bhVar.bMt.isDeleted) {
                    setShareClickable(false);
                    SvgManager.ajv().a(this.ccg, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    am.j(this.ccf, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                SvgManager.ajv().a(this.ccg, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.j(this.ccf, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cch.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.ccj != null) {
            if (this.Wd == null || v.aa(this.Wd.afK()) || !TbadkCoreApplication.isLogin() || this.Wd.afL()) {
                this.ccj.setVisibility(8);
                return;
            }
            if (this.ccj.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ccj.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.ccj.setLayoutParams(layoutParams);
            }
            if (this.cck == null) {
                this.cck = new ArrayList();
            } else {
                this.cck.clear();
            }
            if (this.ccl == null) {
                this.ccl = new ArrayList();
            } else {
                this.ccl.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.Wd.afK()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.cck.add(reportInfo.info);
                    this.ccl.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.ccj.setOnClickListener(this);
                this.ccj.setVisibility(0);
                return;
            }
            this.ccj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(bh bhVar) {
        if (this.cco != null && bhVar != null) {
            if (bhVar.bMD != null) {
                this.ccD = false;
            }
            if (this.ccD && (this.cct == null || this.cct.getVisibility() == 8)) {
                this.cco.setVisibility(0);
                if (this.cco.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cco.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cco.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(R.string.manage);
                this.ccm.setText(string);
                this.ccm.setContentDescription(string);
                SvgManager.ajv().a(this.ccn, R.drawable.icon_pure_card_administration_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.ccu = true;
                return;
            }
            this.cco.setVisibility(8);
        }
    }

    private void alo() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.hz(R.string.operation);
            bVar.a(this.cck, new b.a() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.ccl, i);
                    if (!StringUtils.isNull(str)) {
                        ba.ajK().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.agR();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.j(this.cbY, R.color.cp_cont_d);
            am.j(this.cbZ, R.color.cp_cont_j);
            am.j(this.ccc, R.drawable.selector_comment_and_prise_item_text_color);
            am.j(this.ccm, R.drawable.selector_comment_and_prise_item_text_color);
            am.k(this.cci, R.drawable.btn_frs_more_selector);
            if (this.ccc != null && this.ccy && this.ccJ > 0) {
                SvgManager.ajv().a(this.ccd, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.Wd != null && this.Wd.bMt != null && this.Wd.bMt.isDeleted) {
                setShareClickable(false);
                SvgManager.ajv().a(this.ccg, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.j(this.ccf, R.color.cp_cont_e);
            } else {
                setShareClickable(true);
                SvgManager.ajv().a(this.ccg, R.drawable.icon_pure_pb_bottom_share_h_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                am.j(this.ccf, R.drawable.selector_comment_and_prise_item_text_color);
            }
            if (this.ccn != null) {
                SvgManager.ajv().a(this.ccn, R.drawable.icon_pure_card_administration_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.ccp != null) {
                this.ccp.onChangeSkinType();
            }
            if (this.cca != null) {
                this.cca.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            am.l(this.mMaskView, R.color.cp_bg_line_d);
            if (this.ccb != null) {
                this.ccb.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cbv = onClickListener;
        if (this.bXh != null) {
            this.bXh.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.cbY;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.ccB = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.ccv = z;
    }

    public View getCommentNumView() {
        return this.ccc;
    }

    public View getCommentContainer() {
        return this.cce;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.ccy = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.ccz = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.ccE = z;
    }

    public void setManageVisible(boolean z) {
        this.ccD = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.ccL = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.ccq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.bOF;
    }

    public void setInFrsAllThread(boolean z) {
        this.ccM = z;
    }

    public boolean isInFrsAllThread() {
        return this.ccM;
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
        if (this.cca != null) {
            this.cca.onDestroy();
        }
        if (this.ccp != null) {
            this.ccp.destory();
        }
    }
}
