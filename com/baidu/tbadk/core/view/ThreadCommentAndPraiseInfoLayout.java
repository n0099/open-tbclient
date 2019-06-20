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
import com.baidu.tbadk.t.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ac;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes3.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected bg VJ;
    private LinearLayout bNa;
    protected PraiseView bVh;
    protected DisPraiseView bVi;
    protected int bZV;
    protected TextView bZW;
    private TextView bZX;
    protected com.baidu.tbadk.core.view.a bZY;
    protected AgreeView bZZ;
    private View.OnClickListener bZu;
    protected boolean caA;
    protected boolean caB;
    private int caC;
    public int caD;
    public String caE;
    private String caF;
    protected int caG;
    protected int caH;
    private a caI;
    private boolean caJ;
    protected TextView caa;
    protected ImageView cab;
    protected View cac;
    protected TextView cad;
    protected ImageView cae;
    protected View caf;
    protected TextView cag;
    protected FrameLayout cah;
    private List<CharSequence> cai;
    private List<String> caj;
    protected TextView cak;
    protected ImageView cal;
    protected View cam;
    protected ac can;
    protected ImageView cao;
    protected TextView cap;
    protected LinearLayout caq;
    protected boolean car;
    private boolean cas;
    protected boolean cat;
    protected boolean cau;
    protected boolean cav;
    protected boolean caw;
    protected boolean cax;
    private boolean cay;
    protected boolean caz;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    protected TbPageContext mPageContext;
    private int mSkinType;
    private String mStType;

    /* loaded from: classes3.dex */
    public interface a {
        void eq(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.caF = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.bZY != null) {
            this.bZY.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bZY != null) {
            this.bZY.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.caC = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bZV = 0;
        this.car = false;
        this.cas = true;
        this.cat = true;
        this.cau = true;
        this.cav = false;
        this.caw = false;
        this.cax = true;
        this.cay = false;
        this.caz = true;
        this.caA = false;
        this.caB = true;
        this.mFrom = 2;
        this.caC = 1;
        this.mSkinType = 3;
        this.caI = null;
        this.caJ = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZV = 0;
        this.car = false;
        this.cas = true;
        this.cat = true;
        this.cau = true;
        this.cav = false;
        this.caw = false;
        this.cax = true;
        this.cay = false;
        this.caz = true;
        this.caA = false;
        this.caB = true;
        this.mFrom = 2;
        this.caC = 1;
        this.mSkinType = 3;
        this.caI = null;
        this.caJ = false;
        init(context);
    }

    protected View cF(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bZV = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds84);
        View cF = cF(context);
        this.bZW = (TextView) cF.findViewById(R.id.thread_info_bar_name);
        this.bZX = (TextView) cF.findViewById(R.id.thread_info_reply_time);
        this.bNa = (LinearLayout) cF.findViewById(R.id.thread_comment_layout_root);
        this.caa = (TextView) cF.findViewById(R.id.thread_info_commont_num);
        this.cab = (ImageView) cF.findViewById(R.id.thread_info_commont_img);
        this.cac = cF.findViewById(R.id.thread_info_commont_container);
        this.cad = (TextView) cF.findViewById(R.id.share_num);
        this.cae = (ImageView) cF.findViewById(R.id.share_num_img);
        this.caf = cF.findViewById(R.id.share_num_container);
        this.cag = (TextView) cF.findViewById(R.id.thread_info_more);
        this.cah = (FrameLayout) cF.findViewById(R.id.thread_info_more_frame);
        View findViewById = cF.findViewById(R.id.agree_view);
        if (findViewById != null) {
            this.bVh = (PraiseView) findViewById;
        }
        View findViewById2 = cF.findViewById(R.id.disagree_view);
        if (findViewById2 != null) {
            this.bVi = (DisPraiseView) findViewById2;
        }
        View findViewById3 = cF.findViewById(R.id.new_agree_view);
        if (findViewById3 != null) {
            this.bZZ = (AgreeView) findViewById3;
            this.bZZ.setAgreeAnimationResource(R.raw.agree);
            this.bZZ.setDisagreeAnimationResource(R.raw.disagree);
        }
        if (this.bVh != null && this.bVi != null) {
            this.bZY = new com.baidu.tbadk.core.view.a(this.bVh, this.bVi);
        }
        this.cam = cF.findViewById(R.id.manage_view_container);
        this.cak = (TextView) cF.findViewById(R.id.thread_info_manage_text);
        this.cal = (ImageView) cF.findViewById(R.id.thread_info_manage_img);
        this.cao = (ImageView) cF.findViewById(R.id.manage_select_img);
        this.cap = (TextView) cF.findViewById(R.id.manage_select_text);
        this.caq = (LinearLayout) cF.findViewById(R.id.manage_select_container);
        this.caq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.cao.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cao.performClick();
            }
        });
        this.caq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.cao.performClick();
            }
        });
        if (this.bVh != null) {
            this.bVh.setOnClickListener(this);
        }
        if (this.bVi != null) {
            this.bVi.setOnClickListener(this);
        }
        this.cac.setOnClickListener(this);
        this.caf.setOnClickListener(this);
        this.cam.setOnClickListener(this);
        this.cao.setOnClickListener(this);
        this.caH = R.drawable.icon_home_card_share;
        this.caG = R.drawable.icon_home_card_comment;
        if (this.bZY != null) {
            this.bZY.aiY();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.bZY != null) {
                this.bZY.i(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.bZY != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.bZY.i(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.bZY.i(getPageUniqueId());
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
        if (view == this.bZW) {
            aR(view);
        } else if (view == this.cac) {
            aO(view);
        } else if (view == this.caf) {
            aP(view);
        } else if (view == this.bVh) {
            aS(view);
        } else if (view == this.bVi) {
            aT(view);
        } else if (view == this.cah) {
            aU(view);
        } else if (view == this.cam) {
            aN(view);
        } else if (view == this.cao) {
            aQ(view);
        }
    }

    protected void aQ(View view) {
        if (this.cao != null && this.VJ != null && this.cap != null && !this.VJ.aff()) {
            if (!this.VJ.afe()) {
                if (com.baidu.tieba.frs.a.biW().Z(this.VJ)) {
                    this.VJ.dI(true);
                }
            } else {
                com.baidu.tieba.frs.a.biW().aa(this.VJ);
                this.VJ.dI(false);
            }
            al.j(this.cap, this.VJ.afe() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.cao.setImageDrawable(al.getDrawable(this.VJ.afe() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.caI != null) {
                this.caI.eq(this.VJ.afe());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.cac != null) {
            this.cac.setClickable(z);
            this.cab.setEnabled(z);
            this.caa.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bZY != null) {
            this.bZY.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.caf != null) {
            this.caf.setClickable(z);
            this.cae.setEnabled(z);
            this.cad.setEnabled(z);
        }
    }

    private void aR(View view) {
        if (this.VJ != null && !StringUtils.isNull(this.VJ.adA())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.caF)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.VJ.adA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.VJ.adA(), this.mStType, this.caF)));
            }
            if (this.bZu != null) {
                this.bZu.onClick(view);
            }
        }
    }

    protected void aO(View view) {
        if (this.VJ != null && this.mContext != null) {
            com.baidu.tieba.card.n.uR(this.VJ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.VJ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.VJ.getFid()));
            addLocateParam.setForumName(this.VJ.adA());
            if (this.VJ.afj() && this.VJ.afi() != null) {
                addLocateParam.setForumId(this.VJ.afi().getForumId());
                addLocateParam.setForumName(this.VJ.afi().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.VJ.aeu() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.caD);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.P("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.P("obj_locate", this.mFrom);
            amVar2.P("obj_type", getThreadType());
            amVar2.bT("tid", this.VJ.getTid());
            TiebaStatic.log(amVar2);
            if (this.bZu != null) {
                this.bZu.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.VJ == null) {
            return 0;
        }
        if (this.VJ.isShareThread) {
            return 4;
        }
        if (this.VJ.getThreadType() == 49) {
            return 5;
        }
        if (this.VJ.adM() != null) {
            return 1;
        }
        if (this.VJ.getType() == bg.bIj || this.VJ.getType() == bg.bIw) {
            if (v.Z(this.VJ.adJ()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.VJ != null || i >= 0) {
            am iU = iU(i);
            iU.P("thread_type", this.VJ.getThreadType());
            TiebaStatic.log(iU);
        }
    }

    private am iU(int i) {
        if (this.VJ == null && i < 0) {
            return null;
        }
        am amVar = new am("c12003");
        amVar.bT("tid", this.VJ.getTid());
        if (this.VJ.getThreadType() == 40) {
            amVar.bT("obj_param1", "2");
        } else if (this.VJ.getThreadType() == 0) {
            amVar.bT("obj_param1", "1");
        }
        amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        amVar.l("fid", this.VJ.getFid());
        amVar.P("obj_locate", this.mFrom);
        amVar.P(VideoPlayActivityConfig.OBJ_ID, i);
        if (!ap.isEmpty(this.caE)) {
            amVar.bT("obj_floor", this.caE);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bT("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return amVar;
        }
        return amVar;
    }

    protected void aS(View view) {
        if (this.bVh != null) {
            addPraiseStats(this.bVh.aL(view));
        }
    }

    protected void aT(View view) {
        if (this.bVi != null) {
            this.bVi.aL(view);
        }
    }

    protected void aP(View view) {
        if ((bf.iE() || bc.cE(this.mContext)) && this.VJ != null) {
            ajR();
            ajT();
            if (this.bZu != null && this.VJ.adz()) {
                this.bZu.onClick(view);
            }
        }
    }

    private void ajR() {
        if (this.VJ != null) {
            am ajS = ajS();
            ajS.P("thread_type", this.VJ.getThreadType());
            TiebaStatic.log(ajS);
        }
    }

    private am ajS() {
        int i = 4;
        if (this.VJ == null) {
            return null;
        }
        if (this.caC != 1) {
            if (this.caC == 2) {
                i = 5;
            } else if (this.caC == 3) {
                i = 3;
            } else if (this.caC == 4) {
                i = 2;
            } else if (this.caC == 6) {
                i = 8;
            } else if (this.caC != 7) {
                i = 0;
            } else {
                i = 9;
            }
        }
        am amVar = new am("c12386");
        amVar.l("fid", this.VJ.getFid());
        amVar.bT("tid", this.VJ.getTid());
        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.P("obj_locate", i);
        if (!ap.isEmpty(this.caE)) {
            amVar.bT("obj_floor", this.caE);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.VJ.adO() != null && this.VJ.adO().user_info != null && this.VJ.adO().user_info.is_official == 2) {
            amVar.P("obj_isofficial", this.VJ.adO().user_info.is_official);
        }
        return amVar;
    }

    private void ajT() {
        if (this.VJ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.VJ.getFid());
            String adA = this.VJ.adA();
            if (this.VJ.bLa != null) {
                valueOf = this.VJ.bLa.id;
                adA = this.VJ.bLa.ori_fname;
            }
            String title = this.VJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.VJ.getAbstract();
            }
            String tid = this.VJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.VJ);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.VJ.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = title;
            eVar.content = format;
            eVar.cjD = str2;
            eVar.linkUrl = str;
            eVar.bLt = this.caC;
            eVar.extData = tid;
            eVar.cjG = 3;
            eVar.fid = valueOf;
            eVar.cjx = adA;
            eVar.tid = tid;
            eVar.cjq = true;
            eVar.cjF = getShareObjSource();
            eVar.cjK = s(this.VJ);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.VJ);
            eVar.cjU = this.VJ.getShareImageUrl();
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cjG);
            bundle.putInt("obj_type", eVar.cjK);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bLt);
            eVar.E(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
            shareDialogConfig.setIsAlaLive(this.VJ.getThreadType() == 49 || this.VJ.getThreadType() == 60);
            com.baidu.tieba.c.e.aZC().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.caC == 1) {
            return 5;
        }
        if (this.caC != 3) {
            if (this.caC == 4) {
                return 4;
            }
            if (this.caC != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String r(bg bgVar) {
        String str;
        if (bgVar == null || bgVar.adF() == null) {
            return null;
        }
        ArrayList<MediaData> adF = bgVar.adF();
        int size = adF.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            MediaData mediaData = adF.get(i);
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
        if (str == null && bgVar.adM() != null && !TextUtils.isEmpty(bgVar.adM().thumbnail_url)) {
            return bgVar.adM().thumbnail_url;
        }
        return str;
    }

    private int s(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.adx()) {
                return 4;
            }
            if (bgVar.ads() == 1) {
                return 3;
            }
            return bgVar.aeH() ? 2 : 1;
        }
        return 0;
    }

    protected void aN(View view) {
        if (this.can == null) {
            this.can = new ac(this.mPageContext, this.caJ);
        }
        this.can.setData(this.VJ);
        this.can.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    private void aU(View view) {
        ajV();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.cau = z;
        if (this.bZW != null) {
            this.bZW.setClickable(this.cau);
        }
    }

    public boolean isMoreViewVisible() {
        return this.cah != null && this.cah.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.bZY != null) {
            this.bZY.setForumId(str);
        }
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.VJ = bgVar;
        ajU();
        t(bgVar);
        v(bgVar);
        p(bgVar);
        o(bgVar);
        updatePraiseNum(bgVar);
        u(bgVar);
        q(bgVar);
        setVisibility(this.car ? 0 : 8);
        return this.car;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajU() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(bg bgVar) {
        this.bZW.setVisibility(8);
    }

    protected void u(bg bgVar) {
        int af;
        if (this.caq != null && this.cao != null && this.cap != null && bgVar != null) {
            if (!this.caJ) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.caq.setVisibility(8);
            } else if (this.caB && com.baidu.tieba.frs.a.biW().biX()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.l(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.cao.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.cao.performClick();
                        }
                    });
                }
                if (bgVar.aff()) {
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
                al.j(this.cap, this.VJ.afe() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.cao.setImageDrawable(al.getDrawable(bgVar.afe() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.caq.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.caq.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String acY;
        if (this.bZX != null && bgVar != null) {
            if (bgVar.ado() <= 0 || !this.cas) {
                this.bZX.setVisibility(8);
                return;
            }
            this.bZX.setVisibility(0);
            if (this.mFrom == 3) {
                acY = bgVar.acZ();
            } else {
                acY = bgVar.acY();
            }
            this.bZX.setText(acY);
            this.car = true;
        }
    }

    public boolean isVisible() {
        return this.car;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(bg bgVar) {
        if (this.caa != null && bgVar != null) {
            if (this.cax) {
                this.cac.setVisibility(0);
                if (this.cac.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cac.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cac.setLayoutParams(layoutParams);
                }
                if (bgVar.adm() > 0) {
                    this.caa.setVisibility(0);
                    String aN = ap.aN(bgVar.adm());
                    if (this.cav) {
                        this.cab.setImageDrawable(al.getDrawable(this.caG));
                        this.caa.setText(aN);
                    } else {
                        this.caa.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aN));
                    }
                    this.caa.setContentDescription(this.mContext.getString(R.string.reply_num) + aN);
                    this.car = true;
                    return;
                } else if (this.cav) {
                    this.cab.setImageDrawable(al.getDrawable(this.caG));
                    this.caa.setText(this.mContext.getString(R.string.action_comment_default));
                    this.caa.setVisibility(0);
                    this.car = true;
                    return;
                } else {
                    this.caa.setVisibility(8);
                    return;
                }
            }
            this.cac.setVisibility(8);
        }
    }

    public void updatePraiseNum(bg bgVar) {
        if (this.bZY != null) {
            if (bgVar.getType() == bg.bID || bgVar.getType() == bg.bIE) {
                this.bZY.setDisPraiseFrom(5);
            }
            this.bZY.n(bgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(bg bgVar) {
        if (this.caf != null && this.cad != null && bgVar != null) {
            if (this.caz) {
                this.caf.setVisibility(0);
                if (this.caf.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caf.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.caf.setLayoutParams(layoutParams);
                }
                long aeS = bgVar.aeS();
                if ((bgVar.aeG() || bgVar.aeJ()) && bgVar.adO() != null) {
                    aeS = bgVar.adO().share_info.share_count;
                }
                this.cad.setText(aeS > 0 ? ap.aN(aeS) : this.mContext.getString(R.string.share));
                this.car = true;
                if (bgVar.bKQ != null && bgVar.bKQ.isDeleted) {
                    setShareClickable(false);
                    al.k(this.cae, R.drawable.icon_card_share_d);
                    al.j(this.cad, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.cae, this.caH);
                al.j(this.cad, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.caf.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.cah != null) {
            if (this.VJ == null || v.aa(this.VJ.aeD()) || !TbadkCoreApplication.isLogin() || this.VJ.aeE()) {
                this.cah.setVisibility(8);
                return;
            }
            if (this.cah.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cah.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.cah.setLayoutParams(layoutParams);
            }
            if (this.cai == null) {
                this.cai = new ArrayList();
            } else {
                this.cai.clear();
            }
            if (this.caj == null) {
                this.caj = new ArrayList();
            } else {
                this.caj.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.VJ.aeD()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.cai.add(reportInfo.info);
                    this.caj.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.cah.setOnClickListener(this);
                this.cah.setVisibility(0);
                return;
            }
            this.cah.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bg bgVar) {
        if (this.cam != null && bgVar != null) {
            if (bgVar.bLa != null) {
                this.caA = false;
            }
            if (this.caA && (this.caq == null || this.caq.getVisibility() == 8)) {
                this.cam.setVisibility(0);
                if (this.cam.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cam.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cam.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(R.string.manage);
                this.cak.setText(string);
                this.cak.setContentDescription(string);
                al.c(this.cal, (int) R.drawable.icon_card_frs_manage_selector);
                this.car = true;
                return;
            }
            this.cam.setVisibility(8);
        }
    }

    private void ajV() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.hs(R.string.operation);
            bVar.a(this.cai, new b.a() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.caj, i);
                    if (!StringUtils.isNull(str)) {
                        ba.aiz().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.afJ();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.bZW, R.color.cp_cont_d);
            al.j(this.bZX, R.color.cp_cont_j);
            al.j(this.caa, R.drawable.selector_comment_and_prise_item_text_color);
            al.j(this.cak, R.drawable.selector_comment_and_prise_item_text_color);
            al.k(this.cag, R.drawable.btn_frs_more_selector);
            if (this.caa != null && this.cav && this.caG > 0) {
                this.cab.setImageDrawable(al.getDrawable(this.caG));
            }
            if (this.VJ != null && this.VJ.bKQ != null && this.VJ.bKQ.isDeleted) {
                setShareClickable(false);
                al.k(this.cae, R.drawable.icon_card_share_d);
                al.j(this.cad, R.color.cp_cont_e);
            } else {
                setShareClickable(true);
                al.k(this.cae, this.caH);
                al.j(this.cad, R.drawable.selector_comment_and_prise_item_text_color);
            }
            if (this.cal != null) {
                this.cal.setImageDrawable(al.getDrawable(R.drawable.icon_card_frs_manage_selector));
            }
            if (this.can != null) {
                this.can.onChangeSkinType();
            }
            if (this.bZY != null) {
                this.bZY.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            al.l(this.mMaskView, R.color.cp_bg_line_d);
            if (this.bZZ != null) {
                this.bZZ.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bZu = onClickListener;
        if (this.bVh != null) {
            this.bVh.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.bZW;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.cay = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.cas = z;
    }

    public View getCommentNumView() {
        return this.caa;
    }

    public View getCommentContainer() {
        return this.cac;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.cav = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.caw = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.caB = z;
    }

    public void setManageVisible(boolean z) {
        this.caA = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.caI = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.cao);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.bNa;
    }

    public void setInFrsAllThread(boolean z) {
        this.caJ = z;
    }

    public boolean isInFrsAllThread() {
        return this.caJ;
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
        if (this.bZY != null) {
            this.bZY.onDestroy();
        }
        if (this.can != null) {
            this.can.destory();
        }
    }
}
