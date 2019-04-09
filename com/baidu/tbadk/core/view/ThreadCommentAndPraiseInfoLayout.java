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
    protected bg XT;
    private LinearLayout bFz;
    protected PraiseView bNv;
    protected DisPraiseView bNw;
    private View.OnClickListener bRC;
    protected boolean bSA;
    protected boolean bSB;
    protected boolean bSC;
    protected boolean bSD;
    protected boolean bSE;
    private boolean bSF;
    protected boolean bSG;
    protected boolean bSH;
    protected boolean bSI;
    private int bSJ;
    public int bSK;
    public String bSL;
    private String bSM;
    protected int bSN;
    protected int bSO;
    private a bSP;
    private boolean bSQ;
    protected int bSc;
    protected TextView bSd;
    private TextView bSe;
    protected com.baidu.tbadk.core.view.a bSf;
    protected AgreeView bSg;
    protected TextView bSh;
    protected ImageView bSi;
    protected View bSj;
    protected TextView bSk;
    protected ImageView bSl;
    protected View bSm;
    protected TextView bSn;
    protected FrameLayout bSo;
    private List<CharSequence> bSp;
    private List<String> bSq;
    protected TextView bSr;
    protected ImageView bSs;
    protected View bSt;
    protected ac bSu;
    protected ImageView bSv;
    protected TextView bSw;
    protected LinearLayout bSx;
    protected boolean bSy;
    private boolean bSz;
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
        this.bSM = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.bSf != null) {
            this.bSf.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bSf != null) {
            this.bSf.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.bSJ = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bSc = 0;
        this.bSy = false;
        this.bSz = true;
        this.bSA = true;
        this.bSB = true;
        this.bSC = false;
        this.bSD = false;
        this.bSE = true;
        this.bSF = false;
        this.bSG = true;
        this.bSH = false;
        this.bSI = true;
        this.mFrom = 2;
        this.bSJ = 1;
        this.mSkinType = 3;
        this.bSP = null;
        this.bSQ = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSc = 0;
        this.bSy = false;
        this.bSz = true;
        this.bSA = true;
        this.bSB = true;
        this.bSC = false;
        this.bSD = false;
        this.bSE = true;
        this.bSF = false;
        this.bSG = true;
        this.bSH = false;
        this.bSI = true;
        this.mFrom = 2;
        this.bSJ = 1;
        this.mSkinType = 3;
        this.bSP = null;
        this.bSQ = false;
        init(context);
    }

    protected View da(Context context) {
        return LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bSc = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds84);
        View da = da(context);
        this.bSd = (TextView) da.findViewById(d.g.thread_info_bar_name);
        this.bSe = (TextView) da.findViewById(d.g.thread_info_reply_time);
        this.bFz = (LinearLayout) da.findViewById(d.g.thread_comment_layout_root);
        this.bSh = (TextView) da.findViewById(d.g.thread_info_commont_num);
        this.bSi = (ImageView) da.findViewById(d.g.thread_info_commont_img);
        this.bSj = da.findViewById(d.g.thread_info_commont_container);
        this.bSk = (TextView) da.findViewById(d.g.share_num);
        this.bSl = (ImageView) da.findViewById(d.g.share_num_img);
        this.bSm = da.findViewById(d.g.share_num_container);
        this.bSn = (TextView) da.findViewById(d.g.thread_info_more);
        this.bSo = (FrameLayout) da.findViewById(d.g.thread_info_more_frame);
        View findViewById = da.findViewById(d.g.agree_view);
        if (findViewById != null) {
            this.bNv = (PraiseView) findViewById;
        }
        View findViewById2 = da.findViewById(d.g.disagree_view);
        if (findViewById2 != null) {
            this.bNw = (DisPraiseView) findViewById2;
        }
        View findViewById3 = da.findViewById(d.g.new_agree_view);
        if (findViewById3 != null) {
            this.bSg = (AgreeView) findViewById3;
            this.bSg.setAgreeAnimationResource(d.i.agree);
            this.bSg.setDisagreeAnimationResource(d.i.disagree);
        }
        if (this.bNv != null && this.bNw != null) {
            this.bSf = new com.baidu.tbadk.core.view.a(this.bNv, this.bNw);
        }
        this.bSt = da.findViewById(d.g.manage_view_container);
        this.bSr = (TextView) da.findViewById(d.g.thread_info_manage_text);
        this.bSs = (ImageView) da.findViewById(d.g.thread_info_manage_img);
        this.bSv = (ImageView) da.findViewById(d.g.manage_select_img);
        this.bSw = (TextView) da.findViewById(d.g.manage_select_text);
        this.bSx = (LinearLayout) da.findViewById(d.g.manage_select_container);
        this.bSx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.bSv.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bSw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.bSv.performClick();
            }
        });
        this.bSx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.bSv.performClick();
            }
        });
        if (this.bNv != null) {
            this.bNv.setOnClickListener(this);
        }
        if (this.bNw != null) {
            this.bNw.setOnClickListener(this);
        }
        this.bSj.setOnClickListener(this);
        this.bSm.setOnClickListener(this);
        this.bSt.setOnClickListener(this);
        this.bSv.setOnClickListener(this);
        this.bSO = d.f.icon_home_card_share;
        this.bSN = d.f.icon_home_card_comment;
        if (this.bSf != null) {
            this.bSf.adZ();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.bSf != null) {
                this.bSf.i(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.bSf != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.bSf.i(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.bSf.i(getPageUniqueId());
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
        if (view == this.bSd) {
            aL(view);
        } else if (view == this.bSj) {
            aI(view);
        } else if (view == this.bSm) {
            aJ(view);
        } else if (view == this.bNv) {
            aM(view);
        } else if (view == this.bNw) {
            aN(view);
        } else if (view == this.bSo) {
            aO(view);
        } else if (view == this.bSt) {
            aH(view);
        } else if (view == this.bSv) {
            aK(view);
        }
    }

    protected void aK(View view) {
        if (this.bSv != null && this.XT != null && this.bSw != null && !this.XT.aay()) {
            if (!this.XT.aax()) {
                if (com.baidu.tieba.frs.a.bbD().Z(this.XT)) {
                    this.XT.dn(true);
                }
            } else {
                com.baidu.tieba.frs.a.bbD().aa(this.XT);
                this.XT.dn(false);
            }
            al.j(this.bSw, this.XT.aax() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
            this.bSv.setImageDrawable(al.getDrawable(this.XT.aax() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
            if (this.bSP != null) {
                this.bSP.dT(this.XT.aax());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.bSj != null) {
            this.bSj.setClickable(z);
            this.bSi.setEnabled(z);
            this.bSh.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bSf != null) {
            this.bSf.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.bSm != null) {
            this.bSm.setClickable(z);
            this.bSl.setEnabled(z);
            this.bSk.setEnabled(z);
        }
    }

    private void aL(View view) {
        if (this.XT != null && !StringUtils.isNull(this.XT.YT())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.bSM)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.XT.YT(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.XT.YT(), this.mStType, this.bSM)));
            }
            if (this.bRC != null) {
                this.bRC.onClick(view);
            }
        }
    }

    protected void aI(View view) {
        if (this.XT != null && this.mContext != null) {
            com.baidu.tieba.card.n.tz(this.XT.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.XT, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.XT.getFid()));
            addLocateParam.setForumName(this.XT.YT());
            if (this.XT.aaC() && this.XT.aaB() != null) {
                addLocateParam.setForumId(this.XT.aaB().getForumId());
                addLocateParam.setForumName(this.XT.aaB().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.XT.ZN() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.bSK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.T("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.T("obj_locate", this.mFrom);
            amVar2.T("obj_type", getThreadType());
            amVar2.bJ("tid", this.XT.getTid());
            TiebaStatic.log(amVar2);
            if (this.bRC != null) {
                this.bRC.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.XT == null) {
            return 0;
        }
        if (this.XT.isShareThread) {
            return 4;
        }
        if (this.XT.getThreadType() == 49) {
            return 5;
        }
        if (this.XT.Zf() != null) {
            return 1;
        }
        if (this.XT.getType() == bg.bAU || this.XT.getType() == bg.bBg) {
            if (v.S(this.XT.Zc()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.XT != null || i >= 0) {
            am ig = ig(i);
            ig.T("thread_type", this.XT.getThreadType());
            TiebaStatic.log(ig);
        }
    }

    private am ig(int i) {
        if (this.XT == null && i < 0) {
            return null;
        }
        am amVar = new am("c12003");
        amVar.bJ("tid", this.XT.getTid());
        if (this.XT.getThreadType() == 40) {
            amVar.bJ("obj_param1", "2");
        } else if (this.XT.getThreadType() == 0) {
            amVar.bJ("obj_param1", "1");
        }
        amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        amVar.k(ImageViewerConfig.FORUM_ID, this.XT.getFid());
        amVar.T("obj_locate", this.mFrom);
        amVar.T(VideoPlayActivityConfig.OBJ_ID, i);
        if (!ap.isEmpty(this.bSL)) {
            amVar.bJ("obj_floor", this.bSL);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bJ("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return amVar;
        }
        return amVar;
    }

    protected void aM(View view) {
        if (this.bNv != null) {
            addPraiseStats(this.bNv.aF(view));
        }
    }

    protected void aN(View view) {
        if (this.bNw != null) {
            this.bNw.aF(view);
        }
    }

    protected void aJ(View view) {
        if ((az.jK() || bc.cZ(this.mContext)) && this.XT != null) {
            aeS();
            aeU();
            if (this.bRC != null && this.XT.YS()) {
                this.bRC.onClick(view);
            }
        }
    }

    private void aeS() {
        if (this.XT != null) {
            am aeT = aeT();
            aeT.T("thread_type", this.XT.getThreadType());
            TiebaStatic.log(aeT);
        }
    }

    private am aeT() {
        int i = 4;
        if (this.XT == null) {
            return null;
        }
        if (this.bSJ != 1) {
            if (this.bSJ == 2) {
                i = 5;
            } else if (this.bSJ == 3) {
                i = 3;
            } else if (this.bSJ == 4) {
                i = 2;
            } else if (this.bSJ == 6) {
                i = 8;
            } else if (this.bSJ != 7) {
                i = 0;
            } else {
                i = 9;
            }
        }
        am amVar = new am("c12386");
        amVar.k(ImageViewerConfig.FORUM_ID, this.XT.getFid());
        amVar.bJ("tid", this.XT.getTid());
        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.T("obj_locate", i);
        if (!ap.isEmpty(this.bSL)) {
            amVar.bJ("obj_floor", this.bSL);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.XT.Zh() != null && this.XT.Zh().user_info != null && this.XT.Zh().user_info.is_official == 2) {
            amVar.T("obj_isofficial", this.XT.Zh().user_info.is_official);
        }
        return amVar;
    }

    private void aeU() {
        if (this.XT != null && this.mContext != null) {
            String valueOf = String.valueOf(this.XT.getFid());
            String YT = this.XT.YT();
            if (this.XT.bDI != null) {
                valueOf = this.XT.bDI.id;
                YT = this.XT.bDI.ori_fname;
            }
            String title = this.XT.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.XT.getAbstract();
            }
            String tid = this.XT.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.XT);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.XT.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.cbB = str2;
            dVar.linkUrl = str;
            dVar.bDZ = this.bSJ;
            dVar.extData = tid;
            dVar.cbE = 3;
            dVar.fid = valueOf;
            dVar.cbv = YT;
            dVar.tid = tid;
            dVar.cbp = true;
            dVar.cbD = getShareObjSource();
            dVar.cbI = s(this.XT);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.XT);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.cbE);
            bundle.putInt("obj_type", dVar.cbI);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDZ);
            dVar.D(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.XT.getThreadType() == 49 || this.XT.getThreadType() == 60);
            com.baidu.tieba.c.e.aSr().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.bSJ == 1) {
            return 5;
        }
        if (this.bSJ != 3) {
            if (this.bSJ == 4) {
                return 4;
            }
            if (this.bSJ != 6) {
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
        if (this.bSu == null) {
            this.bSu = new ac(this.mPageContext, this.bSQ);
        }
        this.bSu.setData(this.XT);
        this.bSu.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    private void aO(View view) {
        aeW();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.bSB = z;
        if (this.bSd != null) {
            this.bSd.setClickable(this.bSB);
        }
    }

    public boolean isMoreViewVisible() {
        return this.bSo != null && this.bSo.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.bSf != null) {
            this.bSf.setForumId(str);
        }
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XT = bgVar;
        aeV();
        t(bgVar);
        v(bgVar);
        p(bgVar);
        o(bgVar);
        updatePraiseNum(bgVar);
        u(bgVar);
        q(bgVar);
        setVisibility(this.bSy ? 0 : 8);
        return this.bSy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(bg bgVar) {
        this.bSd.setVisibility(8);
    }

    protected void u(bg bgVar) {
        int aO;
        if (this.bSx != null && this.bSv != null && this.bSw != null && bgVar != null) {
            if (!this.bSQ) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.bSx.setVisibility(8);
            } else if (this.bSI && com.baidu.tieba.frs.a.bbD().bbE()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.bSv.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.bSv.performClick();
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
                al.j(this.bSw, this.XT.aax() ? d.C0277d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
                this.bSv.setImageDrawable(al.getDrawable(bgVar.aax() ? d.f.icon_frs_select_h : d.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.bSx.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.bSx.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String Yr;
        if (this.bSe != null && bgVar != null) {
            if (bgVar.YH() <= 0 || !this.bSz) {
                this.bSe.setVisibility(8);
                return;
            }
            this.bSe.setVisibility(0);
            if (this.mFrom == 3) {
                Yr = bgVar.Ys();
            } else {
                Yr = bgVar.Yr();
            }
            this.bSe.setText(Yr);
            this.bSy = true;
        }
    }

    public boolean isVisible() {
        return this.bSy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(bg bgVar) {
        if (this.bSh != null && bgVar != null) {
            if (this.bSE) {
                this.bSj.setVisibility(0);
                if (this.bSj.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSj.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSj.setLayoutParams(layoutParams);
                }
                if (bgVar.YF() > 0) {
                    this.bSh.setVisibility(0);
                    String az = ap.az(bgVar.YF());
                    if (this.bSC) {
                        this.bSi.setImageDrawable(al.getDrawable(this.bSN));
                        this.bSh.setText(az);
                    } else {
                        this.bSh.setText(String.format(this.mContext.getString(d.j.reply_num_tip), az));
                    }
                    this.bSh.setContentDescription(this.mContext.getString(d.j.reply_num) + az);
                    this.bSy = true;
                    return;
                } else if (this.bSC) {
                    this.bSi.setImageDrawable(al.getDrawable(this.bSN));
                    this.bSh.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bSh.setVisibility(0);
                    this.bSy = true;
                    return;
                } else {
                    this.bSh.setVisibility(8);
                    return;
                }
            }
            this.bSj.setVisibility(8);
        }
    }

    public void updatePraiseNum(bg bgVar) {
        if (this.bSf != null) {
            if (bgVar.getType() == bg.bBn || bgVar.getType() == bg.bBo) {
                this.bSf.setDisPraiseFrom(5);
            }
            this.bSf.n(bgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(bg bgVar) {
        if (this.bSm != null && this.bSk != null && bgVar != null) {
            if (this.bSG) {
                this.bSm.setVisibility(0);
                if (this.bSm.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSm.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSm.setLayoutParams(layoutParams);
                }
                long aal = bgVar.aal();
                if ((bgVar.ZZ() || bgVar.aac()) && bgVar.Zh() != null) {
                    aal = bgVar.Zh().share_info.share_count;
                }
                this.bSk.setText(aal > 0 ? ap.az(aal) : this.mContext.getString(d.j.share));
                this.bSy = true;
                if (bgVar.bDz != null && bgVar.bDz.isDeleted) {
                    setShareClickable(false);
                    al.k(this.bSl, d.f.icon_card_share_d);
                    al.j(this.bSk, d.C0277d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.bSl, this.bSO);
                al.j(this.bSk, d.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.bSm.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.bSo != null) {
            if (this.XT == null || v.T(this.XT.ZW()) || !TbadkCoreApplication.isLogin() || this.XT.ZX()) {
                this.bSo.setVisibility(8);
                return;
            }
            if (this.bSo.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSo.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.bSo.setLayoutParams(layoutParams);
            }
            if (this.bSp == null) {
                this.bSp = new ArrayList();
            } else {
                this.bSp.clear();
            }
            if (this.bSq == null) {
                this.bSq = new ArrayList();
            } else {
                this.bSq.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.XT.ZW()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.bSp.add(reportInfo.info);
                    this.bSq.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.bSo.setOnClickListener(this);
                this.bSo.setVisibility(0);
                return;
            }
            this.bSo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bg bgVar) {
        if (this.bSt != null && bgVar != null) {
            if (bgVar.bDI != null) {
                this.bSH = false;
            }
            if (this.bSH && (this.bSx == null || this.bSx.getVisibility() == 8)) {
                this.bSt.setVisibility(0);
                if (this.bSt.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bSt.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bSt.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.bSr.setText(string);
                this.bSr.setContentDescription(string);
                al.c(this.bSs, d.f.icon_card_frs_manage_selector);
                this.bSy = true;
                return;
            }
            this.bSt.setVisibility(8);
        }
    }

    private void aeW() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.gF(d.j.operation);
            bVar.a(this.bSp, new b.InterfaceC0225b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.bSq, i);
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
            al.j(this.bSd, d.C0277d.cp_cont_d);
            al.j(this.bSe, d.C0277d.cp_cont_j);
            al.j(this.bSh, d.f.selector_comment_and_prise_item_text_color);
            al.j(this.bSr, d.f.selector_comment_and_prise_item_text_color);
            al.k(this.bSn, d.f.btn_frs_more_selector);
            if (this.bSh != null && this.bSC && this.bSN > 0) {
                this.bSi.setImageDrawable(al.getDrawable(this.bSN));
            }
            if (this.XT != null && this.XT.bDz != null && this.XT.bDz.isDeleted) {
                setShareClickable(false);
                al.k(this.bSl, d.f.icon_card_share_d);
                al.j(this.bSk, d.C0277d.cp_cont_e);
            } else {
                setShareClickable(true);
                al.k(this.bSl, this.bSO);
                al.j(this.bSk, d.f.selector_comment_and_prise_item_text_color);
            }
            if (this.bSs != null) {
                this.bSs.setImageDrawable(al.getDrawable(d.f.icon_card_frs_manage_selector));
            }
            if (this.bSu != null) {
                this.bSu.onChangeSkinType();
            }
            if (this.bSf != null) {
                this.bSf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            al.l(this.mMaskView, d.C0277d.cp_bg_line_d);
            if (this.bSg != null) {
                this.bSg.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRC = onClickListener;
        if (this.bNv != null) {
            this.bNv.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.bSd;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.bSF = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.bSz = z;
    }

    public View getCommentNumView() {
        return this.bSh;
    }

    public View getCommentContainer() {
        return this.bSj;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.bSC = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.bSD = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.bSI = z;
    }

    public void setManageVisible(boolean z) {
        this.bSH = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.bSP = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.bSv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.bFz;
    }

    public void setInFrsAllThread(boolean z) {
        this.bSQ = z;
    }

    public boolean isInFrsAllThread() {
        return this.bSQ;
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
        if (this.bSf != null) {
            this.bSf.onDestroy();
        }
        if (this.bSu != null) {
            this.bSu.destory();
        }
    }
}
