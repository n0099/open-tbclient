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
    protected bg XS;
    private LinearLayout bFw;
    protected PraiseView bNs;
    protected DisPraiseView bNt;
    protected int bRZ;
    private View.OnClickListener bRz;
    protected boolean bSA;
    protected boolean bSB;
    private boolean bSC;
    protected boolean bSD;
    protected boolean bSE;
    protected boolean bSF;
    private int bSG;
    public int bSH;
    public String bSI;
    private String bSJ;
    protected int bSK;
    protected int bSL;
    private a bSM;
    private boolean bSN;
    protected TextView bSa;
    private TextView bSb;
    protected com.baidu.tbadk.core.view.a bSc;
    protected AgreeView bSd;
    protected TextView bSe;
    protected ImageView bSf;
    protected View bSg;
    protected TextView bSh;
    protected ImageView bSi;
    protected View bSj;
    protected TextView bSk;
    protected FrameLayout bSl;
    private List<CharSequence> bSm;
    private List<String> bSn;
    protected TextView bSo;
    protected ImageView bSp;
    protected View bSq;
    protected ac bSr;
    protected ImageView bSs;
    protected TextView bSt;
    protected LinearLayout bSu;
    protected boolean bSv;
    private boolean bSw;
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
        this.bSJ = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.bSc != null) {
            this.bSc.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bSc != null) {
            this.bSc.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.bSG = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bRZ = 0;
        this.bSv = false;
        this.bSw = true;
        this.bSx = true;
        this.bSy = true;
        this.bSz = false;
        this.bSA = false;
        this.bSB = true;
        this.bSC = false;
        this.bSD = true;
        this.bSE = false;
        this.bSF = true;
        this.mFrom = 2;
        this.bSG = 1;
        this.mSkinType = 3;
        this.bSM = null;
        this.bSN = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRZ = 0;
        this.bSv = false;
        this.bSw = true;
        this.bSx = true;
        this.bSy = true;
        this.bSz = false;
        this.bSA = false;
        this.bSB = true;
        this.bSC = false;
        this.bSD = true;
        this.bSE = false;
        this.bSF = true;
        this.mFrom = 2;
        this.bSG = 1;
        this.mSkinType = 3;
        this.bSM = null;
        this.bSN = false;
        init(context);
    }

    protected View da(Context context) {
        return LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bRZ = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds84);
        View da = da(context);
        this.bSa = (TextView) da.findViewById(d.g.thread_info_bar_name);
        this.bSb = (TextView) da.findViewById(d.g.thread_info_reply_time);
        this.bFw = (LinearLayout) da.findViewById(d.g.thread_comment_layout_root);
        this.bSe = (TextView) da.findViewById(d.g.thread_info_commont_num);
        this.bSf = (ImageView) da.findViewById(d.g.thread_info_commont_img);
        this.bSg = da.findViewById(d.g.thread_info_commont_container);
        this.bSh = (TextView) da.findViewById(d.g.share_num);
        this.bSi = (ImageView) da.findViewById(d.g.share_num_img);
        this.bSj = da.findViewById(d.g.share_num_container);
        this.bSk = (TextView) da.findViewById(d.g.thread_info_more);
        this.bSl = (FrameLayout) da.findViewById(d.g.thread_info_more_frame);
        View findViewById = da.findViewById(d.g.agree_view);
        if (findViewById != null) {
            this.bNs = (PraiseView) findViewById;
        }
        View findViewById2 = da.findViewById(d.g.disagree_view);
        if (findViewById2 != null) {
            this.bNt = (DisPraiseView) findViewById2;
        }
        View findViewById3 = da.findViewById(d.g.new_agree_view);
        if (findViewById3 != null) {
            this.bSd = (AgreeView) findViewById3;
            this.bSd.setAgreeAnimationResource(d.i.agree);
            this.bSd.setDisagreeAnimationResource(d.i.disagree);
        }
        if (this.bNs != null && this.bNt != null) {
            this.bSc = new com.baidu.tbadk.core.view.a(this.bNs, this.bNt);
        }
        this.bSq = da.findViewById(d.g.manage_view_container);
        this.bSo = (TextView) da.findViewById(d.g.thread_info_manage_text);
        this.bSp = (ImageView) da.findViewById(d.g.thread_info_manage_img);
        this.bSs = (ImageView) da.findViewById(d.g.manage_select_img);
        this.bSt = (TextView) da.findViewById(d.g.manage_select_text);
        this.bSu = (LinearLayout) da.findViewById(d.g.manage_select_container);
        this.bSu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.bSs.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bSt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.bSs.performClick();
            }
        });
        this.bSu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.bSs.performClick();
            }
        });
        if (this.bNs != null) {
            this.bNs.setOnClickListener(this);
        }
        if (this.bNt != null) {
            this.bNt.setOnClickListener(this);
        }
        this.bSg.setOnClickListener(this);
        this.bSj.setOnClickListener(this);
        this.bSq.setOnClickListener(this);
        this.bSs.setOnClickListener(this);
        this.bSL = d.f.icon_home_card_share;
        this.bSK = d.f.icon_home_card_comment;
        if (this.bSc != null) {
            this.bSc.aec();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.bSc != null) {
                this.bSc.i(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.bSc != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.bSc.i(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.bSc.i(getPageUniqueId());
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
        if (view == this.bSa) {
            aL(view);
        } else if (view == this.bSg) {
            aI(view);
        } else if (view == this.bSj) {
            aJ(view);
        } else if (view == this.bNs) {
            aM(view);
        } else if (view == this.bNt) {
            aN(view);
        } else if (view == this.bSl) {
            aO(view);
        } else if (view == this.bSq) {
            aH(view);
        } else if (view == this.bSs) {
            aK(view);
        }
    }

    protected void aK(View view) {
        if (this.bSs != null && this.XS != null && this.bSt != null && !this.XS.aaB()) {
            if (!this.XS.aaA()) {
                if (com.baidu.tieba.frs.a.bbF().aa(this.XS)) {
                    this.XS.dn(true);
                }
            } else {
                com.baidu.tieba.frs.a.bbF().ab(this.XS);
                this.XS.dn(false);
            }
            al.j(this.bSt, this.XS.aaA() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
            this.bSs.setImageDrawable(al.getDrawable(this.XS.aaA() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
            if (this.bSM != null) {
                this.bSM.dT(this.XS.aaA());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.bSg != null) {
            this.bSg.setClickable(z);
            this.bSf.setEnabled(z);
            this.bSe.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bSc != null) {
            this.bSc.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.bSj != null) {
            this.bSj.setClickable(z);
            this.bSi.setEnabled(z);
            this.bSh.setEnabled(z);
        }
    }

    private void aL(View view) {
        if (this.XS != null && !StringUtils.isNull(this.XS.YW())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.bSJ)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.XS.YW(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.XS.YW(), this.mStType, this.bSJ)));
            }
            if (this.bRz != null) {
                this.bRz.onClick(view);
            }
        }
    }

    protected void aI(View view) {
        if (this.XS != null && this.mContext != null) {
            com.baidu.tieba.card.n.tA(this.XS.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.XS, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.XS.getFid()));
            addLocateParam.setForumName(this.XS.YW());
            if (this.XS.aaF() && this.XS.aaE() != null) {
                addLocateParam.setForumId(this.XS.aaE().getForumId());
                addLocateParam.setForumName(this.XS.aaE().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.XS.ZQ() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.bSH);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.T("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.T("obj_locate", this.mFrom);
            amVar2.T("obj_type", getThreadType());
            amVar2.bJ("tid", this.XS.getTid());
            TiebaStatic.log(amVar2);
            if (this.bRz != null) {
                this.bRz.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.XS == null) {
            return 0;
        }
        if (this.XS.isShareThread) {
            return 4;
        }
        if (this.XS.getThreadType() == 49) {
            return 5;
        }
        if (this.XS.Zi() != null) {
            return 1;
        }
        if (this.XS.getType() == bg.bAQ || this.XS.getType() == bg.bBc) {
            if (v.S(this.XS.Zf()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.XS != null || i >= 0) {
            am ih = ih(i);
            ih.T("thread_type", this.XS.getThreadType());
            TiebaStatic.log(ih);
        }
    }

    private am ih(int i) {
        if (this.XS == null && i < 0) {
            return null;
        }
        am amVar = new am("c12003");
        amVar.bJ("tid", this.XS.getTid());
        if (this.XS.getThreadType() == 40) {
            amVar.bJ("obj_param1", "2");
        } else if (this.XS.getThreadType() == 0) {
            amVar.bJ("obj_param1", "1");
        }
        amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        amVar.k(ImageViewerConfig.FORUM_ID, this.XS.getFid());
        amVar.T("obj_locate", this.mFrom);
        amVar.T(VideoPlayActivityConfig.OBJ_ID, i);
        if (!ap.isEmpty(this.bSI)) {
            amVar.bJ("obj_floor", this.bSI);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bJ("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return amVar;
        }
        return amVar;
    }

    protected void aM(View view) {
        if (this.bNs != null) {
            addPraiseStats(this.bNs.aF(view));
        }
    }

    protected void aN(View view) {
        if (this.bNt != null) {
            this.bNt.aF(view);
        }
    }

    protected void aJ(View view) {
        if ((az.jK() || bc.cZ(this.mContext)) && this.XS != null) {
            aeV();
            aeX();
            if (this.bRz != null && this.XS.YV()) {
                this.bRz.onClick(view);
            }
        }
    }

    private void aeV() {
        if (this.XS != null) {
            am aeW = aeW();
            aeW.T("thread_type", this.XS.getThreadType());
            TiebaStatic.log(aeW);
        }
    }

    private am aeW() {
        int i = 4;
        if (this.XS == null) {
            return null;
        }
        if (this.bSG != 1) {
            if (this.bSG == 2) {
                i = 5;
            } else if (this.bSG == 3) {
                i = 3;
            } else if (this.bSG == 4) {
                i = 2;
            } else if (this.bSG == 6) {
                i = 8;
            } else if (this.bSG != 7) {
                i = 0;
            } else {
                i = 9;
            }
        }
        am amVar = new am("c12386");
        amVar.k(ImageViewerConfig.FORUM_ID, this.XS.getFid());
        amVar.bJ("tid", this.XS.getTid());
        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.T("obj_locate", i);
        if (!ap.isEmpty(this.bSI)) {
            amVar.bJ("obj_floor", this.bSI);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    private void aeX() {
        if (this.XS != null && this.mContext != null) {
            String valueOf = String.valueOf(this.XS.getFid());
            String YW = this.XS.YW();
            if (this.XS.bDE != null) {
                valueOf = this.XS.bDE.id;
                YW = this.XS.bDE.ori_fname;
            }
            String title = this.XS.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.XS.getAbstract();
            }
            String tid = this.XS.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.XS);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.XS.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.cby = str2;
            dVar.linkUrl = str;
            dVar.bDV = this.bSG;
            dVar.extData = tid;
            dVar.cbB = 3;
            dVar.fid = valueOf;
            dVar.cbs = YW;
            dVar.tid = tid;
            dVar.cbm = true;
            dVar.cbA = getShareObjSource();
            dVar.cbF = s(this.XS);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.XS);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.cbB);
            bundle.putInt("obj_type", dVar.cbF);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDV);
            dVar.D(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.XS.getThreadType() == 49 || this.XS.getThreadType() == 60);
            com.baidu.tieba.c.e.aSt().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.bSG == 1) {
            return 5;
        }
        if (this.bSG != 3) {
            if (this.bSG == 4) {
                return 4;
            }
            if (this.bSG != 6) {
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
        if (this.bSr == null) {
            this.bSr = new ac(this.mPageContext, this.bSN);
        }
        this.bSr.setData(this.XS);
        this.bSr.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    private void aO(View view) {
        aeZ();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.bSy = z;
        if (this.bSa != null) {
            this.bSa.setClickable(this.bSy);
        }
    }

    public boolean isMoreViewVisible() {
        return this.bSl != null && this.bSl.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.bSc != null) {
            this.bSc.setForumId(str);
        }
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XS = bgVar;
        aeY();
        t(bgVar);
        v(bgVar);
        p(bgVar);
        o(bgVar);
        updatePraiseNum(bgVar);
        u(bgVar);
        q(bgVar);
        setVisibility(this.bSv ? 0 : 8);
        return this.bSv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(bg bgVar) {
        this.bSa.setVisibility(8);
    }

    protected void u(bg bgVar) {
        int aO;
        if (this.bSu != null && this.bSs != null && this.bSt != null && bgVar != null) {
            if (!this.bSN) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.bSu.setVisibility(8);
            } else if (this.bSF && com.baidu.tieba.frs.a.bbF().bbG()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.bSs.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.bSs.performClick();
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
                al.j(this.bSt, this.XS.aaA() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
                this.bSs.setImageDrawable(al.getDrawable(bgVar.aaA() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.bSu.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.bSu.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String Yu;
        if (this.bSb != null && bgVar != null) {
            if (bgVar.YK() <= 0 || !this.bSw) {
                this.bSb.setVisibility(8);
                return;
            }
            this.bSb.setVisibility(0);
            if (this.mFrom == 3) {
                Yu = bgVar.Yv();
            } else {
                Yu = bgVar.Yu();
            }
            this.bSb.setText(Yu);
            this.bSv = true;
        }
    }

    public boolean isVisible() {
        return this.bSv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(bg bgVar) {
        if (this.bSe != null && bgVar != null) {
            if (this.bSB) {
                this.bSg.setVisibility(0);
                if (this.bSg.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSg.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSg.setLayoutParams(layoutParams);
                }
                if (bgVar.YI() > 0) {
                    this.bSe.setVisibility(0);
                    String az = ap.az(bgVar.YI());
                    if (this.bSz) {
                        this.bSf.setImageDrawable(al.getDrawable(this.bSK));
                        this.bSe.setText(az);
                    } else {
                        this.bSe.setText(String.format(this.mContext.getString(d.j.reply_num_tip), az));
                    }
                    this.bSe.setContentDescription(this.mContext.getString(d.j.reply_num) + az);
                    this.bSv = true;
                    return;
                } else if (this.bSz) {
                    this.bSf.setImageDrawable(al.getDrawable(this.bSK));
                    this.bSe.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bSe.setVisibility(0);
                    this.bSv = true;
                    return;
                } else {
                    this.bSe.setVisibility(8);
                    return;
                }
            }
            this.bSg.setVisibility(8);
        }
    }

    public void updatePraiseNum(bg bgVar) {
        if (this.bSc != null) {
            if (bgVar.getType() == bg.bBj || bgVar.getType() == bg.bBk) {
                this.bSc.setDisPraiseFrom(5);
            }
            this.bSc.n(bgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(bg bgVar) {
        if (this.bSj != null && this.bSh != null && bgVar != null) {
            if (this.bSD) {
                this.bSj.setVisibility(0);
                if (this.bSj.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSj.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSj.setLayoutParams(layoutParams);
                }
                long aao = bgVar.aao();
                if ((bgVar.aac() || bgVar.aaf()) && bgVar.Zk() != null) {
                    aao = bgVar.Zk().share_info.share_count;
                }
                this.bSh.setText(aao > 0 ? ap.az(aao) : this.mContext.getString(d.j.share));
                this.bSv = true;
                if (bgVar.bDv != null && bgVar.bDv.isDeleted) {
                    setShareClickable(false);
                    al.k(this.bSi, d.f.icon_card_share_d);
                    al.j(this.bSh, d.C0277d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.bSi, this.bSL);
                al.j(this.bSh, d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.bSj.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.bSl != null) {
            if (this.XS == null || v.T(this.XS.ZZ()) || !TbadkCoreApplication.isLogin() || this.XS.aaa()) {
                this.bSl.setVisibility(8);
                return;
            }
            if (this.bSl.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSl.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.bSl.setLayoutParams(layoutParams);
            }
            if (this.bSm == null) {
                this.bSm = new ArrayList();
            } else {
                this.bSm.clear();
            }
            if (this.bSn == null) {
                this.bSn = new ArrayList();
            } else {
                this.bSn.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.XS.ZZ()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.bSm.add(reportInfo.info);
                    this.bSn.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.bSl.setOnClickListener(this);
                this.bSl.setVisibility(0);
                return;
            }
            this.bSl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bg bgVar) {
        if (this.bSq != null && bgVar != null) {
            if (bgVar.bDE != null) {
                this.bSE = false;
            }
            if (this.bSE && (this.bSu == null || this.bSu.getVisibility() == 8)) {
                this.bSq.setVisibility(0);
                if (this.bSq.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSq.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSq.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.bSo.setText(string);
                this.bSo.setContentDescription(string);
                al.c(this.bSp, d.f.icon_card_frs_manage_selector);
                this.bSv = true;
                return;
            }
            this.bSq.setVisibility(8);
        }
    }

    private void aeZ() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.gG(d.j.operation);
            bVar.a(this.bSm, new b.InterfaceC0225b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.bSn, i);
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
            al.j(this.bSa, d.C0277d.cp_cont_d);
            al.j(this.bSb, d.C0277d.cp_cont_j);
            al.j(this.bSe, d.f.selector_comment_and_prise_item_text_color);
            al.j(this.bSo, d.f.selector_comment_and_prise_item_text_color);
            al.k(this.bSk, d.f.btn_frs_more_selector);
            if (this.bSe != null && this.bSz && this.bSK > 0) {
                this.bSf.setImageDrawable(al.getDrawable(this.bSK));
            }
            if (this.XS != null && this.XS.bDv != null && this.XS.bDv.isDeleted) {
                setShareClickable(false);
                al.k(this.bSi, d.f.icon_card_share_d);
                al.j(this.bSh, d.C0277d.cp_cont_e);
            } else {
                setShareClickable(true);
                al.k(this.bSi, this.bSL);
                al.j(this.bSh, d.f.selector_comment_and_prise_item_text_color);
            }
            if (this.bSp != null) {
                this.bSp.setImageDrawable(al.getDrawable(d.f.icon_card_frs_manage_selector));
            }
            if (this.bSr != null) {
                this.bSr.onChangeSkinType();
            }
            if (this.bSc != null) {
                this.bSc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
            if (this.bSd != null) {
                this.bSd.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRz = onClickListener;
        if (this.bNs != null) {
            this.bNs.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.bSa;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.bSC = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.bSw = z;
    }

    public View getCommentNumView() {
        return this.bSe;
    }

    public View getCommentContainer() {
        return this.bSg;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.bSz = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.bSA = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.bSF = z;
    }

    public void setManageVisible(boolean z) {
        this.bSE = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.bSM = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.bSs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.bFw;
    }

    public void setInFrsAllThread(boolean z) {
        this.bSN = z;
    }

    public boolean isInFrsAllThread() {
        return this.bSN;
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
        if (this.bSc != null) {
            this.bSc.onDestroy();
        }
        if (this.bSr != null) {
            this.bSr.destory();
        }
    }
}
