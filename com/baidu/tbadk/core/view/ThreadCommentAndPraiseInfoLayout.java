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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.s.az;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes3.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bg XR;
    private LinearLayout bFu;
    protected PraiseView bNr;
    protected DisPraiseView bNs;
    protected int bRY;
    protected TextView bRZ;
    private View.OnClickListener bRy;
    protected boolean bSA;
    private boolean bSB;
    protected boolean bSC;
    protected boolean bSD;
    protected boolean bSE;
    private int bSF;
    public int bSG;
    public String bSH;
    private String bSI;
    protected int bSJ;
    protected int bSK;
    private a bSL;
    private boolean bSM;
    private TextView bSa;
    protected com.baidu.tbadk.core.view.a bSb;
    protected AgreeView bSc;
    protected TextView bSd;
    protected ImageView bSe;
    protected View bSf;
    protected TextView bSg;
    protected ImageView bSh;
    protected View bSi;
    protected TextView bSj;
    protected FrameLayout bSk;
    private List<CharSequence> bSl;
    private List<String> bSm;
    protected TextView bSn;
    protected ImageView bSo;
    protected View bSp;
    protected ac bSq;
    protected ImageView bSr;
    protected TextView bSs;
    protected LinearLayout bSt;
    protected boolean bSu;
    private boolean bSv;
    protected boolean bSw;
    protected boolean bSx;
    protected boolean bSy;
    protected boolean bSz;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private int mSkinType;
    private String mStType;

    /* loaded from: classes3.dex */
    public interface a {
        void dT(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.bSI = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.bSb != null) {
            this.bSb.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bSb != null) {
            this.bSb.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.bSF = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bRY = 0;
        this.bSu = false;
        this.bSv = true;
        this.bSw = true;
        this.bSx = true;
        this.bSy = false;
        this.bSz = false;
        this.bSA = true;
        this.bSB = false;
        this.bSC = true;
        this.bSD = false;
        this.bSE = true;
        this.mFrom = 2;
        this.bSF = 1;
        this.mSkinType = 3;
        this.bSL = null;
        this.bSM = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRY = 0;
        this.bSu = false;
        this.bSv = true;
        this.bSw = true;
        this.bSx = true;
        this.bSy = false;
        this.bSz = false;
        this.bSA = true;
        this.bSB = false;
        this.bSC = true;
        this.bSD = false;
        this.bSE = true;
        this.mFrom = 2;
        this.bSF = 1;
        this.mSkinType = 3;
        this.bSL = null;
        this.bSM = false;
        init(context);
    }

    protected View da(Context context) {
        return LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bRY = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds84);
        View da = da(context);
        this.bRZ = (TextView) da.findViewById(d.g.thread_info_bar_name);
        this.bSa = (TextView) da.findViewById(d.g.thread_info_reply_time);
        this.bFu = (LinearLayout) da.findViewById(d.g.thread_comment_layout_root);
        this.bSd = (TextView) da.findViewById(d.g.thread_info_commont_num);
        this.bSe = (ImageView) da.findViewById(d.g.thread_info_commont_img);
        this.bSf = da.findViewById(d.g.thread_info_commont_container);
        this.bSg = (TextView) da.findViewById(d.g.share_num);
        this.bSh = (ImageView) da.findViewById(d.g.share_num_img);
        this.bSi = da.findViewById(d.g.share_num_container);
        this.bSj = (TextView) da.findViewById(d.g.thread_info_more);
        this.bSk = (FrameLayout) da.findViewById(d.g.thread_info_more_frame);
        View findViewById = da.findViewById(d.g.agree_view);
        if (findViewById != null) {
            this.bNr = (PraiseView) findViewById;
        }
        View findViewById2 = da.findViewById(d.g.disagree_view);
        if (findViewById2 != null) {
            this.bNs = (DisPraiseView) findViewById2;
        }
        View findViewById3 = da.findViewById(d.g.new_agree_view);
        if (findViewById3 != null) {
            this.bSc = (AgreeView) findViewById3;
            this.bSc.setAgreeAnimationResource(d.i.agree);
            this.bSc.setDisagreeAnimationResource(d.i.disagree);
        }
        if (this.bNr != null && this.bNs != null) {
            this.bSb = new com.baidu.tbadk.core.view.a(this.bNr, this.bNs);
        }
        this.bSp = da.findViewById(d.g.manage_view_container);
        this.bSn = (TextView) da.findViewById(d.g.thread_info_manage_text);
        this.bSo = (ImageView) da.findViewById(d.g.thread_info_manage_img);
        this.bSr = (ImageView) da.findViewById(d.g.manage_select_img);
        this.bSs = (TextView) da.findViewById(d.g.manage_select_text);
        this.bSt = (LinearLayout) da.findViewById(d.g.manage_select_container);
        this.bSt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.bSr.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bSs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.bSr.performClick();
            }
        });
        this.bSt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.bSr.performClick();
            }
        });
        if (this.bNr != null) {
            this.bNr.setOnClickListener(this);
        }
        if (this.bNs != null) {
            this.bNs.setOnClickListener(this);
        }
        this.bSf.setOnClickListener(this);
        this.bSi.setOnClickListener(this);
        this.bSp.setOnClickListener(this);
        this.bSr.setOnClickListener(this);
        this.bSK = d.f.icon_home_card_share;
        this.bSJ = d.f.icon_home_card_comment;
        if (this.bSb != null) {
            this.bSb.aec();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.bSb != null) {
                this.bSb.i(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.bSb != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.bSb.i(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.bSb.i(getPageUniqueId());
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
        if (view == this.bRZ) {
            aL(view);
        } else if (view == this.bSf) {
            aI(view);
        } else if (view == this.bSi) {
            aJ(view);
        } else if (view == this.bNr) {
            aM(view);
        } else if (view == this.bNs) {
            aN(view);
        } else if (view == this.bSk) {
            aO(view);
        } else if (view == this.bSp) {
            aH(view);
        } else if (view == this.bSr) {
            aK(view);
        }
    }

    protected void aK(View view) {
        if (this.bSr != null && this.XR != null && this.bSs != null && !this.XR.aaB()) {
            if (!this.XR.aaA()) {
                if (com.baidu.tieba.frs.a.bbF().aa(this.XR)) {
                    this.XR.dn(true);
                }
            } else {
                com.baidu.tieba.frs.a.bbF().ab(this.XR);
                this.XR.dn(false);
            }
            al.j(this.bSs, this.XR.aaA() ? d.C0236d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
            this.bSr.setImageDrawable(al.getDrawable(this.XR.aaA() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
            if (this.bSL != null) {
                this.bSL.dT(this.XR.aaA());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.bSf != null) {
            this.bSf.setClickable(z);
            this.bSe.setEnabled(z);
            this.bSd.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bSb != null) {
            this.bSb.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.bSi != null) {
            this.bSi.setClickable(z);
            this.bSh.setEnabled(z);
            this.bSg.setEnabled(z);
        }
    }

    private void aL(View view) {
        if (this.XR != null && !StringUtils.isNull(this.XR.YW())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.bSI)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.XR.YW(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.XR.YW(), this.mStType, this.bSI)));
            }
            if (this.bRy != null) {
                this.bRy.onClick(view);
            }
        }
    }

    protected void aI(View view) {
        if (this.XR != null && this.mContext != null) {
            com.baidu.tieba.card.n.tB(this.XR.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.XR, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.XR.getFid()));
            addLocateParam.setForumName(this.XR.YW());
            if (this.XR.aaF() && this.XR.aaE() != null) {
                addLocateParam.setForumId(this.XR.aaE().getForumId());
                addLocateParam.setForumName(this.XR.aaE().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.XR.ZQ() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.bSG);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.T("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.T("obj_locate", this.mFrom);
            amVar2.T("obj_type", getThreadType());
            amVar2.bJ("tid", this.XR.getTid());
            TiebaStatic.log(amVar2);
            if (this.bRy != null) {
                this.bRy.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.XR == null) {
            return 0;
        }
        if (this.XR.isShareThread) {
            return 4;
        }
        if (this.XR.getThreadType() == 49) {
            return 5;
        }
        if (this.XR.Zi() != null) {
            return 1;
        }
        if (this.XR.getType() == bg.bAO || this.XR.getType() == bg.bBa) {
            if (v.S(this.XR.Zf()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.XR != null || i >= 0) {
            am ih = ih(i);
            ih.T("thread_type", this.XR.getThreadType());
            TiebaStatic.log(ih);
        }
    }

    private am ih(int i) {
        if (this.XR == null && i < 0) {
            return null;
        }
        am amVar = new am("c12003");
        amVar.bJ("tid", this.XR.getTid());
        if (this.XR.getThreadType() == 40) {
            amVar.bJ("obj_param1", "2");
        } else if (this.XR.getThreadType() == 0) {
            amVar.bJ("obj_param1", "1");
        }
        amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        amVar.k(ImageViewerConfig.FORUM_ID, this.XR.getFid());
        amVar.T("obj_locate", this.mFrom);
        amVar.T(VideoPlayActivityConfig.OBJ_ID, i);
        if (!ap.isEmpty(this.bSH)) {
            amVar.bJ("obj_floor", this.bSH);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bJ("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return amVar;
        }
        return amVar;
    }

    protected void aM(View view) {
        if (this.bNr != null) {
            addPraiseStats(this.bNr.aF(view));
        }
    }

    protected void aN(View view) {
        if (this.bNs != null) {
            this.bNs.aF(view);
        }
    }

    protected void aJ(View view) {
        if ((az.jK() || bc.cZ(this.mContext)) && this.XR != null) {
            aeV();
            aeX();
            if (this.bRy != null && this.XR.YV()) {
                this.bRy.onClick(view);
            }
        }
    }

    private void aeV() {
        if (this.XR != null) {
            am aeW = aeW();
            aeW.T("thread_type", this.XR.getThreadType());
            TiebaStatic.log(aeW);
        }
    }

    private am aeW() {
        int i = 4;
        if (this.XR == null) {
            return null;
        }
        if (this.bSF != 1) {
            if (this.bSF == 2) {
                i = 5;
            } else if (this.bSF == 3) {
                i = 3;
            } else if (this.bSF == 4) {
                i = 2;
            } else if (this.bSF == 6) {
                i = 8;
            } else if (this.bSF != 7) {
                i = 0;
            } else {
                i = 9;
            }
        }
        am amVar = new am("c12386");
        amVar.k(ImageViewerConfig.FORUM_ID, this.XR.getFid());
        amVar.bJ("tid", this.XR.getTid());
        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.T("obj_locate", i);
        if (!ap.isEmpty(this.bSH)) {
            amVar.bJ("obj_floor", this.bSH);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    private void aeX() {
        if (this.XR != null && this.mContext != null) {
            String valueOf = String.valueOf(this.XR.getFid());
            String YW = this.XR.YW();
            if (this.XR.bDC != null) {
                valueOf = this.XR.bDC.id;
                YW = this.XR.bDC.ori_fname;
            }
            String title = this.XR.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.XR.getAbstract();
            }
            String tid = this.XR.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.XR);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.XR.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.cby = str2;
            dVar.linkUrl = str;
            dVar.bDT = this.bSF;
            dVar.extData = tid;
            dVar.cbB = 3;
            dVar.fid = valueOf;
            dVar.cbs = YW;
            dVar.tid = tid;
            dVar.cbm = true;
            dVar.cbA = getShareObjSource();
            dVar.cbF = s(this.XR);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.XR);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.cbB);
            bundle.putInt("obj_type", dVar.cbF);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDT);
            dVar.D(bundle);
            if (com.baidu.tbadk.plugins.c.b(this.mPageContext, "com.baidu.tieba.pluginCore")) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
                shareDialogConfig.setIsAlaLive(this.XR.getThreadType() == 49 || this.XR.getThreadType() == 60);
                com.baidu.tieba.c.e.aSt().a(shareDialogConfig);
            }
        }
    }

    private int getShareObjSource() {
        if (this.bSF == 1) {
            return 5;
        }
        if (this.bSF != 3) {
            if (this.bSF == 4) {
                return 4;
            }
            if (this.bSF != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String r(bg bgVar) {
        String str;
        if (bgVar == null || bgVar.Zb() == null) {
            return null;
        }
        ArrayList<MediaData> Zb = bgVar.Zb();
        int size = Zb.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = Zb.get(i);
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
        if (str == null && bgVar.Zi() != null && !TextUtils.isEmpty(bgVar.Zi().thumbnail_url)) {
            return bgVar.Zi().thumbnail_url;
        }
        return str;
    }

    private int s(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.YT()) {
                return 4;
            }
            if (bgVar.YO() == 1) {
                return 3;
            }
            return bgVar.aad() ? 2 : 1;
        }
        return 0;
    }

    protected void aH(View view) {
        if (this.bSq == null) {
            this.bSq = new ac(this.mPageContext, this.bSM);
        }
        this.bSq.setData(this.XR);
        this.bSq.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    private void aO(View view) {
        aeZ();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.bSx = z;
        if (this.bRZ != null) {
            this.bRZ.setClickable(this.bSx);
        }
    }

    public boolean isMoreViewVisible() {
        return this.bSk != null && this.bSk.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.bSb != null) {
            this.bSb.setForumId(str);
        }
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XR = bgVar;
        aeY();
        t(bgVar);
        v(bgVar);
        p(bgVar);
        o(bgVar);
        updatePraiseNum(bgVar);
        u(bgVar);
        q(bgVar);
        setVisibility(this.bSu ? 0 : 8);
        return this.bSu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(bg bgVar) {
        this.bRZ.setVisibility(8);
    }

    protected void u(bg bgVar) {
        int aO;
        if (this.bSt != null && this.bSr != null && this.bSs != null && bgVar != null) {
            if (!this.bSM) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.bSt.setVisibility(8);
            } else if (this.bSE && com.baidu.tieba.frs.a.bbF().bbG()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.l(this.mMaskView, d.C0236d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.bSr.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.bSr.performClick();
                        }
                    });
                }
                if (bgVar.aaB()) {
                    aO = com.baidu.adp.lib.util.l.aO(getContext());
                } else {
                    aO = (com.baidu.adp.lib.util.l.aO(getContext()) / 4) * 3;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mMaskView.getLayoutParams();
                if (layoutParams == null) {
                    this.mMaskView.setLayoutParams(new FrameLayout.LayoutParams(aO, -1));
                } else {
                    layoutParams.width = aO;
                    requestLayout();
                }
                al.j(this.bSs, this.XR.aaA() ? d.C0236d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
                this.bSr.setImageDrawable(al.getDrawable(bgVar.aaA() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.bSt.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.bSt.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String Yu;
        if (this.bSa != null && bgVar != null) {
            if (bgVar.YK() <= 0 || !this.bSv) {
                this.bSa.setVisibility(8);
                return;
            }
            this.bSa.setVisibility(0);
            if (this.mFrom == 3) {
                Yu = bgVar.Yv();
            } else {
                Yu = bgVar.Yu();
            }
            this.bSa.setText(Yu);
            this.bSu = true;
        }
    }

    public boolean isVisible() {
        return this.bSu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(bg bgVar) {
        if (this.bSd != null && bgVar != null) {
            if (this.bSA) {
                this.bSf.setVisibility(0);
                if (this.bSf.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSf.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSf.setLayoutParams(layoutParams);
                }
                if (bgVar.YI() > 0) {
                    this.bSd.setVisibility(0);
                    String az = ap.az(bgVar.YI());
                    if (this.bSy) {
                        this.bSe.setImageDrawable(al.getDrawable(this.bSJ));
                        this.bSd.setText(az);
                    } else {
                        this.bSd.setText(String.format(this.mContext.getString(d.j.reply_num_tip), az));
                    }
                    this.bSd.setContentDescription(this.mContext.getString(d.j.reply_num) + az);
                    this.bSu = true;
                    return;
                } else if (this.bSy) {
                    this.bSe.setImageDrawable(al.getDrawable(this.bSJ));
                    this.bSd.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bSd.setVisibility(0);
                    this.bSu = true;
                    return;
                } else {
                    this.bSd.setVisibility(8);
                    return;
                }
            }
            this.bSf.setVisibility(8);
        }
    }

    public void updatePraiseNum(bg bgVar) {
        if (this.bSb != null) {
            if (bgVar.getType() == bg.bBh || bgVar.getType() == bg.bBi) {
                this.bSb.setDisPraiseFrom(5);
            }
            this.bSb.n(bgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(bg bgVar) {
        if (this.bSi != null && this.bSg != null && bgVar != null) {
            if (this.bSC) {
                this.bSi.setVisibility(0);
                if (this.bSi.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSi.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSi.setLayoutParams(layoutParams);
                }
                long aao = bgVar.aao();
                if ((bgVar.aac() || bgVar.aaf()) && bgVar.Zk() != null) {
                    aao = bgVar.Zk().share_info.share_count;
                }
                this.bSg.setText(aao > 0 ? ap.az(aao) : this.mContext.getString(d.j.share));
                this.bSu = true;
                if (bgVar.bDt != null && bgVar.bDt.isDeleted) {
                    setShareClickable(false);
                    al.k(this.bSh, d.f.icon_card_share_d);
                    al.j(this.bSg, d.C0236d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.bSh, this.bSK);
                al.j(this.bSg, d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.bSi.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.bSk != null) {
            if (this.XR == null || v.T(this.XR.ZZ()) || !TbadkCoreApplication.isLogin() || this.XR.aaa()) {
                this.bSk.setVisibility(8);
                return;
            }
            if (this.bSk.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSk.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.bSk.setLayoutParams(layoutParams);
            }
            if (this.bSl == null) {
                this.bSl = new ArrayList();
            } else {
                this.bSl.clear();
            }
            if (this.bSm == null) {
                this.bSm = new ArrayList();
            } else {
                this.bSm.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.XR.ZZ()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.bSl.add(reportInfo.info);
                    this.bSm.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.bSk.setOnClickListener(this);
                this.bSk.setVisibility(0);
                return;
            }
            this.bSk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bg bgVar) {
        if (this.bSp != null && bgVar != null) {
            if (bgVar.bDC != null) {
                this.bSD = false;
            }
            if (this.bSD && (this.bSt == null || this.bSt.getVisibility() == 8)) {
                this.bSp.setVisibility(0);
                if (this.bSp.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSp.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSp.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.bSn.setText(string);
                this.bSn.setContentDescription(string);
                al.c(this.bSo, d.f.icon_card_frs_manage_selector);
                this.bSu = true;
                return;
            }
            this.bSp.setVisibility(8);
        }
    }

    private void aeZ() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.gG(d.j.operation);
            bVar.a(this.bSl, new b.InterfaceC0191b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.bSm, i);
                    if (!StringUtils.isNull(str)) {
                        ba.adD().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.abc();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.bRZ, d.C0236d.cp_cont_d);
            al.j(this.bSa, d.C0236d.cp_cont_j);
            al.j(this.bSd, d.f.selector_comment_and_prise_item_text_color);
            al.j(this.bSn, d.f.selector_comment_and_prise_item_text_color);
            al.k(this.bSj, d.f.btn_frs_more_selector);
            if (this.bSd != null && this.bSy && this.bSJ > 0) {
                this.bSe.setImageDrawable(al.getDrawable(this.bSJ));
            }
            if (this.XR != null && this.XR.bDt != null && this.XR.bDt.isDeleted) {
                setShareClickable(false);
                al.k(this.bSh, d.f.icon_card_share_d);
                al.j(this.bSg, d.C0236d.cp_cont_e);
            } else {
                setShareClickable(true);
                al.k(this.bSh, this.bSK);
                al.j(this.bSg, d.f.selector_comment_and_prise_item_text_color);
            }
            if (this.bSo != null) {
                this.bSo.setImageDrawable(al.getDrawable(d.f.icon_card_frs_manage_selector));
            }
            if (this.bSq != null) {
                this.bSq.onChangeSkinType();
            }
            if (this.bSb != null) {
                this.bSb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            al.l(this.mMaskView, d.C0236d.cp_bg_line_d);
            if (this.bSc != null) {
                this.bSc.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRy = onClickListener;
        if (this.bNr != null) {
            this.bNr.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.bRZ;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.bSB = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.bSv = z;
    }

    public View getCommentNumView() {
        return this.bSd;
    }

    public View getCommentContainer() {
        return this.bSf;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.bSy = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.bSz = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.bSE = z;
    }

    public void setManageVisible(boolean z) {
        this.bSD = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.bSL = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.bSr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.bFu;
    }

    public void setInFrsAllThread(boolean z) {
        this.bSM = z;
    }

    public boolean isInFrsAllThread() {
        return this.bSM;
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
        if (this.bSb != null) {
            this.bSb.onDestroy();
        }
        if (this.bSq != null) {
            this.bSq.destory();
        }
    }
}
