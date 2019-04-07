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
    private LinearLayout bFy;
    protected PraiseView bNu;
    protected DisPraiseView bNv;
    private View.OnClickListener bRB;
    protected boolean bSA;
    protected boolean bSB;
    protected boolean bSC;
    protected boolean bSD;
    private boolean bSE;
    protected boolean bSF;
    protected boolean bSG;
    protected boolean bSH;
    private int bSI;
    public int bSJ;
    public String bSK;
    private String bSL;
    protected int bSM;
    protected int bSN;
    private a bSO;
    private boolean bSP;
    protected int bSb;
    protected TextView bSc;
    private TextView bSd;
    protected com.baidu.tbadk.core.view.a bSe;
    protected AgreeView bSf;
    protected TextView bSg;
    protected ImageView bSh;
    protected View bSi;
    protected TextView bSj;
    protected ImageView bSk;
    protected View bSl;
    protected TextView bSm;
    protected FrameLayout bSn;
    private List<CharSequence> bSo;
    private List<String> bSp;
    protected TextView bSq;
    protected ImageView bSr;
    protected View bSs;
    protected ac bSt;
    protected ImageView bSu;
    protected TextView bSv;
    protected LinearLayout bSw;
    protected boolean bSx;
    private boolean bSy;
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
        this.bSL = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.bSe != null) {
            this.bSe.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bSe != null) {
            this.bSe.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.bSI = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bSb = 0;
        this.bSx = false;
        this.bSy = true;
        this.bSz = true;
        this.bSA = true;
        this.bSB = false;
        this.bSC = false;
        this.bSD = true;
        this.bSE = false;
        this.bSF = true;
        this.bSG = false;
        this.bSH = true;
        this.mFrom = 2;
        this.bSI = 1;
        this.mSkinType = 3;
        this.bSO = null;
        this.bSP = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSb = 0;
        this.bSx = false;
        this.bSy = true;
        this.bSz = true;
        this.bSA = true;
        this.bSB = false;
        this.bSC = false;
        this.bSD = true;
        this.bSE = false;
        this.bSF = true;
        this.bSG = false;
        this.bSH = true;
        this.mFrom = 2;
        this.bSI = 1;
        this.mSkinType = 3;
        this.bSO = null;
        this.bSP = false;
        init(context);
    }

    protected View da(Context context) {
        return LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bSb = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds84);
        View da = da(context);
        this.bSc = (TextView) da.findViewById(d.g.thread_info_bar_name);
        this.bSd = (TextView) da.findViewById(d.g.thread_info_reply_time);
        this.bFy = (LinearLayout) da.findViewById(d.g.thread_comment_layout_root);
        this.bSg = (TextView) da.findViewById(d.g.thread_info_commont_num);
        this.bSh = (ImageView) da.findViewById(d.g.thread_info_commont_img);
        this.bSi = da.findViewById(d.g.thread_info_commont_container);
        this.bSj = (TextView) da.findViewById(d.g.share_num);
        this.bSk = (ImageView) da.findViewById(d.g.share_num_img);
        this.bSl = da.findViewById(d.g.share_num_container);
        this.bSm = (TextView) da.findViewById(d.g.thread_info_more);
        this.bSn = (FrameLayout) da.findViewById(d.g.thread_info_more_frame);
        View findViewById = da.findViewById(d.g.agree_view);
        if (findViewById != null) {
            this.bNu = (PraiseView) findViewById;
        }
        View findViewById2 = da.findViewById(d.g.disagree_view);
        if (findViewById2 != null) {
            this.bNv = (DisPraiseView) findViewById2;
        }
        View findViewById3 = da.findViewById(d.g.new_agree_view);
        if (findViewById3 != null) {
            this.bSf = (AgreeView) findViewById3;
            this.bSf.setAgreeAnimationResource(d.i.agree);
            this.bSf.setDisagreeAnimationResource(d.i.disagree);
        }
        if (this.bNu != null && this.bNv != null) {
            this.bSe = new com.baidu.tbadk.core.view.a(this.bNu, this.bNv);
        }
        this.bSs = da.findViewById(d.g.manage_view_container);
        this.bSq = (TextView) da.findViewById(d.g.thread_info_manage_text);
        this.bSr = (ImageView) da.findViewById(d.g.thread_info_manage_img);
        this.bSu = (ImageView) da.findViewById(d.g.manage_select_img);
        this.bSv = (TextView) da.findViewById(d.g.manage_select_text);
        this.bSw = (LinearLayout) da.findViewById(d.g.manage_select_container);
        this.bSw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.bSu.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bSv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.bSu.performClick();
            }
        });
        this.bSw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.bSu.performClick();
            }
        });
        if (this.bNu != null) {
            this.bNu.setOnClickListener(this);
        }
        if (this.bNv != null) {
            this.bNv.setOnClickListener(this);
        }
        this.bSi.setOnClickListener(this);
        this.bSl.setOnClickListener(this);
        this.bSs.setOnClickListener(this);
        this.bSu.setOnClickListener(this);
        this.bSN = d.f.icon_home_card_share;
        this.bSM = d.f.icon_home_card_comment;
        if (this.bSe != null) {
            this.bSe.adZ();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.bSe != null) {
                this.bSe.i(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.bSe != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.bSe.i(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.bSe.i(getPageUniqueId());
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
        if (view == this.bSc) {
            aL(view);
        } else if (view == this.bSi) {
            aI(view);
        } else if (view == this.bSl) {
            aJ(view);
        } else if (view == this.bNu) {
            aM(view);
        } else if (view == this.bNv) {
            aN(view);
        } else if (view == this.bSn) {
            aO(view);
        } else if (view == this.bSs) {
            aH(view);
        } else if (view == this.bSu) {
            aK(view);
        }
    }

    protected void aK(View view) {
        if (this.bSu != null && this.XS != null && this.bSv != null && !this.XS.aay()) {
            if (!this.XS.aax()) {
                if (com.baidu.tieba.frs.a.bbD().Z(this.XS)) {
                    this.XS.dn(true);
                }
            } else {
                com.baidu.tieba.frs.a.bbD().aa(this.XS);
                this.XS.dn(false);
            }
            al.j(this.bSv, this.XS.aax() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
            this.bSu.setImageDrawable(al.getDrawable(this.XS.aax() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
            if (this.bSO != null) {
                this.bSO.dT(this.XS.aax());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.bSi != null) {
            this.bSi.setClickable(z);
            this.bSh.setEnabled(z);
            this.bSg.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bSe != null) {
            this.bSe.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.bSl != null) {
            this.bSl.setClickable(z);
            this.bSk.setEnabled(z);
            this.bSj.setEnabled(z);
        }
    }

    private void aL(View view) {
        if (this.XS != null && !StringUtils.isNull(this.XS.YT())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.bSL)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.XS.YT(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.XS.YT(), this.mStType, this.bSL)));
            }
            if (this.bRB != null) {
                this.bRB.onClick(view);
            }
        }
    }

    protected void aI(View view) {
        if (this.XS != null && this.mContext != null) {
            com.baidu.tieba.card.n.tz(this.XS.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.XS, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.XS.getFid()));
            addLocateParam.setForumName(this.XS.YT());
            if (this.XS.aaC() && this.XS.aaB() != null) {
                addLocateParam.setForumId(this.XS.aaB().getForumId());
                addLocateParam.setForumName(this.XS.aaB().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.XS.ZN() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.bSJ);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.T("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.T("obj_locate", this.mFrom);
            amVar2.T("obj_type", getThreadType());
            amVar2.bJ("tid", this.XS.getTid());
            TiebaStatic.log(amVar2);
            if (this.bRB != null) {
                this.bRB.onClick(view);
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
        if (this.XS.Zf() != null) {
            return 1;
        }
        if (this.XS.getType() == bg.bAT || this.XS.getType() == bg.bBf) {
            if (v.S(this.XS.Zc()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.XS != null || i >= 0) {
            am ig = ig(i);
            ig.T("thread_type", this.XS.getThreadType());
            TiebaStatic.log(ig);
        }
    }

    private am ig(int i) {
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
        if (!ap.isEmpty(this.bSK)) {
            amVar.bJ("obj_floor", this.bSK);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bJ("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return amVar;
        }
        return amVar;
    }

    protected void aM(View view) {
        if (this.bNu != null) {
            addPraiseStats(this.bNu.aF(view));
        }
    }

    protected void aN(View view) {
        if (this.bNv != null) {
            this.bNv.aF(view);
        }
    }

    protected void aJ(View view) {
        if ((az.jK() || bc.cZ(this.mContext)) && this.XS != null) {
            aeS();
            aeU();
            if (this.bRB != null && this.XS.YS()) {
                this.bRB.onClick(view);
            }
        }
    }

    private void aeS() {
        if (this.XS != null) {
            am aeT = aeT();
            aeT.T("thread_type", this.XS.getThreadType());
            TiebaStatic.log(aeT);
        }
    }

    private am aeT() {
        int i = 4;
        if (this.XS == null) {
            return null;
        }
        if (this.bSI != 1) {
            if (this.bSI == 2) {
                i = 5;
            } else if (this.bSI == 3) {
                i = 3;
            } else if (this.bSI == 4) {
                i = 2;
            } else if (this.bSI == 6) {
                i = 8;
            } else if (this.bSI != 7) {
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
        if (!ap.isEmpty(this.bSK)) {
            amVar.bJ("obj_floor", this.bSK);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.XS.Zh() != null && this.XS.Zh().user_info != null && this.XS.Zh().user_info.is_official == 2) {
            amVar.T("obj_isofficial", this.XS.Zh().user_info.is_official);
        }
        return amVar;
    }

    private void aeU() {
        if (this.XS != null && this.mContext != null) {
            String valueOf = String.valueOf(this.XS.getFid());
            String YT = this.XS.YT();
            if (this.XS.bDH != null) {
                valueOf = this.XS.bDH.id;
                YT = this.XS.bDH.ori_fname;
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
            dVar.cbA = str2;
            dVar.linkUrl = str;
            dVar.bDY = this.bSI;
            dVar.extData = tid;
            dVar.cbD = 3;
            dVar.fid = valueOf;
            dVar.cbu = YT;
            dVar.tid = tid;
            dVar.cbo = true;
            dVar.cbC = getShareObjSource();
            dVar.cbH = s(this.XS);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.XS);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.cbD);
            bundle.putInt("obj_type", dVar.cbH);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDY);
            dVar.D(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.XS.getThreadType() == 49 || this.XS.getThreadType() == 60);
            com.baidu.tieba.c.e.aSr().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.bSI == 1) {
            return 5;
        }
        if (this.bSI != 3) {
            if (this.bSI == 4) {
                return 4;
            }
            if (this.bSI != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String r(bg bgVar) {
        String str;
        if (bgVar == null || bgVar.YY() == null) {
            return null;
        }
        ArrayList<MediaData> YY = bgVar.YY();
        int size = YY.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = YY.get(i);
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
        if (str == null && bgVar.Zf() != null && !TextUtils.isEmpty(bgVar.Zf().thumbnail_url)) {
            return bgVar.Zf().thumbnail_url;
        }
        return str;
    }

    private int s(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.YQ()) {
                return 4;
            }
            if (bgVar.YL() == 1) {
                return 3;
            }
            return bgVar.aaa() ? 2 : 1;
        }
        return 0;
    }

    protected void aH(View view) {
        if (this.bSt == null) {
            this.bSt = new ac(this.mPageContext, this.bSP);
        }
        this.bSt.setData(this.XS);
        this.bSt.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    private void aO(View view) {
        aeW();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.bSA = z;
        if (this.bSc != null) {
            this.bSc.setClickable(this.bSA);
        }
    }

    public boolean isMoreViewVisible() {
        return this.bSn != null && this.bSn.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.bSe != null) {
            this.bSe.setForumId(str);
        }
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XS = bgVar;
        aeV();
        t(bgVar);
        v(bgVar);
        p(bgVar);
        o(bgVar);
        updatePraiseNum(bgVar);
        u(bgVar);
        q(bgVar);
        setVisibility(this.bSx ? 0 : 8);
        return this.bSx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(bg bgVar) {
        this.bSc.setVisibility(8);
    }

    protected void u(bg bgVar) {
        int aO;
        if (this.bSw != null && this.bSu != null && this.bSv != null && bgVar != null) {
            if (!this.bSP) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.bSw.setVisibility(8);
            } else if (this.bSH && com.baidu.tieba.frs.a.bbD().bbE()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.bSu.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.bSu.performClick();
                        }
                    });
                }
                if (bgVar.aay()) {
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
                al.j(this.bSv, this.XS.aax() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
                this.bSu.setImageDrawable(al.getDrawable(bgVar.aax() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.bSw.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.bSw.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String Yr;
        if (this.bSd != null && bgVar != null) {
            if (bgVar.YH() <= 0 || !this.bSy) {
                this.bSd.setVisibility(8);
                return;
            }
            this.bSd.setVisibility(0);
            if (this.mFrom == 3) {
                Yr = bgVar.Ys();
            } else {
                Yr = bgVar.Yr();
            }
            this.bSd.setText(Yr);
            this.bSx = true;
        }
    }

    public boolean isVisible() {
        return this.bSx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(bg bgVar) {
        if (this.bSg != null && bgVar != null) {
            if (this.bSD) {
                this.bSi.setVisibility(0);
                if (this.bSi.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSi.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSi.setLayoutParams(layoutParams);
                }
                if (bgVar.YF() > 0) {
                    this.bSg.setVisibility(0);
                    String az = ap.az(bgVar.YF());
                    if (this.bSB) {
                        this.bSh.setImageDrawable(al.getDrawable(this.bSM));
                        this.bSg.setText(az);
                    } else {
                        this.bSg.setText(String.format(this.mContext.getString(d.j.reply_num_tip), az));
                    }
                    this.bSg.setContentDescription(this.mContext.getString(d.j.reply_num) + az);
                    this.bSx = true;
                    return;
                } else if (this.bSB) {
                    this.bSh.setImageDrawable(al.getDrawable(this.bSM));
                    this.bSg.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bSg.setVisibility(0);
                    this.bSx = true;
                    return;
                } else {
                    this.bSg.setVisibility(8);
                    return;
                }
            }
            this.bSi.setVisibility(8);
        }
    }

    public void updatePraiseNum(bg bgVar) {
        if (this.bSe != null) {
            if (bgVar.getType() == bg.bBm || bgVar.getType() == bg.bBn) {
                this.bSe.setDisPraiseFrom(5);
            }
            this.bSe.n(bgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(bg bgVar) {
        if (this.bSl != null && this.bSj != null && bgVar != null) {
            if (this.bSF) {
                this.bSl.setVisibility(0);
                if (this.bSl.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSl.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSl.setLayoutParams(layoutParams);
                }
                long aal = bgVar.aal();
                if ((bgVar.ZZ() || bgVar.aac()) && bgVar.Zh() != null) {
                    aal = bgVar.Zh().share_info.share_count;
                }
                this.bSj.setText(aal > 0 ? ap.az(aal) : this.mContext.getString(d.j.share));
                this.bSx = true;
                if (bgVar.bDy != null && bgVar.bDy.isDeleted) {
                    setShareClickable(false);
                    al.k(this.bSk, d.f.icon_card_share_d);
                    al.j(this.bSj, d.C0277d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.bSk, this.bSN);
                al.j(this.bSj, d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.bSl.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.bSn != null) {
            if (this.XS == null || v.T(this.XS.ZW()) || !TbadkCoreApplication.isLogin() || this.XS.ZX()) {
                this.bSn.setVisibility(8);
                return;
            }
            if (this.bSn.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSn.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.bSn.setLayoutParams(layoutParams);
            }
            if (this.bSo == null) {
                this.bSo = new ArrayList();
            } else {
                this.bSo.clear();
            }
            if (this.bSp == null) {
                this.bSp = new ArrayList();
            } else {
                this.bSp.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.XS.ZW()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.bSo.add(reportInfo.info);
                    this.bSp.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.bSn.setOnClickListener(this);
                this.bSn.setVisibility(0);
                return;
            }
            this.bSn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bg bgVar) {
        if (this.bSs != null && bgVar != null) {
            if (bgVar.bDH != null) {
                this.bSG = false;
            }
            if (this.bSG && (this.bSw == null || this.bSw.getVisibility() == 8)) {
                this.bSs.setVisibility(0);
                if (this.bSs.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSs.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSs.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.bSq.setText(string);
                this.bSq.setContentDescription(string);
                al.c(this.bSr, d.f.icon_card_frs_manage_selector);
                this.bSx = true;
                return;
            }
            this.bSs.setVisibility(8);
        }
    }

    private void aeW() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.gF(d.j.operation);
            bVar.a(this.bSo, new b.InterfaceC0225b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.bSp, i);
                    if (!StringUtils.isNull(str)) {
                        ba.adA().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.aaZ();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.bSc, d.C0277d.cp_cont_d);
            al.j(this.bSd, d.C0277d.cp_cont_j);
            al.j(this.bSg, d.f.selector_comment_and_prise_item_text_color);
            al.j(this.bSq, d.f.selector_comment_and_prise_item_text_color);
            al.k(this.bSm, d.f.btn_frs_more_selector);
            if (this.bSg != null && this.bSB && this.bSM > 0) {
                this.bSh.setImageDrawable(al.getDrawable(this.bSM));
            }
            if (this.XS != null && this.XS.bDy != null && this.XS.bDy.isDeleted) {
                setShareClickable(false);
                al.k(this.bSk, d.f.icon_card_share_d);
                al.j(this.bSj, d.C0277d.cp_cont_e);
            } else {
                setShareClickable(true);
                al.k(this.bSk, this.bSN);
                al.j(this.bSj, d.f.selector_comment_and_prise_item_text_color);
            }
            if (this.bSr != null) {
                this.bSr.setImageDrawable(al.getDrawable(d.f.icon_card_frs_manage_selector));
            }
            if (this.bSt != null) {
                this.bSt.onChangeSkinType();
            }
            if (this.bSe != null) {
                this.bSe.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
            if (this.bSf != null) {
                this.bSf.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRB = onClickListener;
        if (this.bNu != null) {
            this.bNu.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.bSc;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.bSE = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.bSy = z;
    }

    public View getCommentNumView() {
        return this.bSg;
    }

    public View getCommentContainer() {
        return this.bSi;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.bSB = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.bSC = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.bSH = z;
    }

    public void setManageVisible(boolean z) {
        this.bSG = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.bSO = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.bSu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.bFy;
    }

    public void setInFrsAllThread(boolean z) {
        this.bSP = z;
    }

    public boolean isInFrsAllThread() {
        return this.bSP;
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
        if (this.bSe != null) {
            this.bSe.onDestroy();
        }
        if (this.bSt != null) {
            this.bSt.destory();
        }
    }
}
