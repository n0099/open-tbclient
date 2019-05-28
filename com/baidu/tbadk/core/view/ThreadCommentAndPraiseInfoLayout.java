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
    protected bg VK;
    private LinearLayout bMZ;
    protected PraiseView bVg;
    protected DisPraiseView bVh;
    protected int bZU;
    protected TextView bZV;
    private TextView bZW;
    protected com.baidu.tbadk.core.view.a bZX;
    protected AgreeView bZY;
    protected TextView bZZ;
    private View.OnClickListener bZt;
    protected boolean caA;
    private int caB;
    public int caC;
    public String caD;
    private String caE;
    protected int caF;
    protected int caG;
    private a caH;
    private boolean caI;
    protected ImageView caa;
    protected View cab;
    protected TextView cac;
    protected ImageView cad;
    protected View cae;
    protected TextView caf;
    protected FrameLayout cag;
    private List<CharSequence> cah;
    private List<String> cai;
    protected TextView caj;
    protected ImageView cak;
    protected View cal;
    protected ac cam;
    protected ImageView can;
    protected TextView cao;
    protected LinearLayout cap;
    protected boolean caq;
    private boolean car;
    protected boolean cas;
    protected boolean cat;
    protected boolean cau;
    protected boolean cav;
    protected boolean caw;
    private boolean cax;
    protected boolean cay;
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
        this.caE = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.bZX != null) {
            this.bZX.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.bZX != null) {
            this.bZX.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.caB = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bZU = 0;
        this.caq = false;
        this.car = true;
        this.cas = true;
        this.cat = true;
        this.cau = false;
        this.cav = false;
        this.caw = true;
        this.cax = false;
        this.cay = true;
        this.caz = false;
        this.caA = true;
        this.mFrom = 2;
        this.caB = 1;
        this.mSkinType = 3;
        this.caH = null;
        this.caI = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZU = 0;
        this.caq = false;
        this.car = true;
        this.cas = true;
        this.cat = true;
        this.cau = false;
        this.cav = false;
        this.caw = true;
        this.cax = false;
        this.cay = true;
        this.caz = false;
        this.caA = true;
        this.mFrom = 2;
        this.caB = 1;
        this.mSkinType = 3;
        this.caH = null;
        this.caI = false;
        init(context);
    }

    protected View cF(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bZU = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds84);
        View cF = cF(context);
        this.bZV = (TextView) cF.findViewById(R.id.thread_info_bar_name);
        this.bZW = (TextView) cF.findViewById(R.id.thread_info_reply_time);
        this.bMZ = (LinearLayout) cF.findViewById(R.id.thread_comment_layout_root);
        this.bZZ = (TextView) cF.findViewById(R.id.thread_info_commont_num);
        this.caa = (ImageView) cF.findViewById(R.id.thread_info_commont_img);
        this.cab = cF.findViewById(R.id.thread_info_commont_container);
        this.cac = (TextView) cF.findViewById(R.id.share_num);
        this.cad = (ImageView) cF.findViewById(R.id.share_num_img);
        this.cae = cF.findViewById(R.id.share_num_container);
        this.caf = (TextView) cF.findViewById(R.id.thread_info_more);
        this.cag = (FrameLayout) cF.findViewById(R.id.thread_info_more_frame);
        View findViewById = cF.findViewById(R.id.agree_view);
        if (findViewById != null) {
            this.bVg = (PraiseView) findViewById;
        }
        View findViewById2 = cF.findViewById(R.id.disagree_view);
        if (findViewById2 != null) {
            this.bVh = (DisPraiseView) findViewById2;
        }
        View findViewById3 = cF.findViewById(R.id.new_agree_view);
        if (findViewById3 != null) {
            this.bZY = (AgreeView) findViewById3;
            this.bZY.setAgreeAnimationResource(R.raw.agree);
            this.bZY.setDisagreeAnimationResource(R.raw.disagree);
        }
        if (this.bVg != null && this.bVh != null) {
            this.bZX = new com.baidu.tbadk.core.view.a(this.bVg, this.bVh);
        }
        this.cal = cF.findViewById(R.id.manage_view_container);
        this.caj = (TextView) cF.findViewById(R.id.thread_info_manage_text);
        this.cak = (ImageView) cF.findViewById(R.id.thread_info_manage_img);
        this.can = (ImageView) cF.findViewById(R.id.manage_select_img);
        this.cao = (TextView) cF.findViewById(R.id.manage_select_text);
        this.cap = (LinearLayout) cF.findViewById(R.id.manage_select_container);
        this.cap.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.can.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cao.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.can.performClick();
            }
        });
        this.cap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.can.performClick();
            }
        });
        if (this.bVg != null) {
            this.bVg.setOnClickListener(this);
        }
        if (this.bVh != null) {
            this.bVh.setOnClickListener(this);
        }
        this.cab.setOnClickListener(this);
        this.cae.setOnClickListener(this);
        this.cal.setOnClickListener(this);
        this.can.setOnClickListener(this);
        this.caG = R.drawable.icon_home_card_share;
        this.caF = R.drawable.icon_home_card_comment;
        if (this.bZX != null) {
            this.bZX.aiY();
        }
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            if (this.bZX != null) {
                this.bZX.i(getPageUniqueId());
            }
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (this.bZX != null) {
                if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                    this.bZX.i(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                    return;
                }
                this.bZX.i(getPageUniqueId());
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
        if (view == this.bZV) {
            aR(view);
        } else if (view == this.cab) {
            aO(view);
        } else if (view == this.cae) {
            aP(view);
        } else if (view == this.bVg) {
            aS(view);
        } else if (view == this.bVh) {
            aT(view);
        } else if (view == this.cag) {
            aU(view);
        } else if (view == this.cal) {
            aN(view);
        } else if (view == this.can) {
            aQ(view);
        }
    }

    protected void aQ(View view) {
        if (this.can != null && this.VK != null && this.cao != null && !this.VK.aff()) {
            if (!this.VK.afe()) {
                if (com.baidu.tieba.frs.a.biW().Z(this.VK)) {
                    this.VK.dI(true);
                }
            } else {
                com.baidu.tieba.frs.a.biW().aa(this.VK);
                this.VK.dI(false);
            }
            al.j(this.cao, this.VK.afe() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
            this.can.setImageDrawable(al.getDrawable(this.VK.afe() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
            if (this.caH != null) {
                this.caH.eq(this.VK.afe());
            }
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.cab != null) {
            this.cab.setClickable(z);
            this.caa.setEnabled(z);
            this.bZZ.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bZX != null) {
            this.bZX.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.cae != null) {
            this.cae.setClickable(z);
            this.cad.setEnabled(z);
            this.cac.setEnabled(z);
        }
    }

    private void aR(View view) {
        if (this.VK != null && !StringUtils.isNull(this.VK.adA())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.caE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.VK.adA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.VK.adA(), this.mStType, this.caE)));
            }
            if (this.bZt != null) {
                this.bZt.onClick(view);
            }
        }
    }

    protected void aO(View view) {
        if (this.VK != null && this.mContext != null) {
            com.baidu.tieba.card.n.uS(this.VK.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.VK, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.VK.getFid()));
            addLocateParam.setForumName(this.VK.adA());
            if (this.VK.afj() && this.VK.afi() != null) {
                addLocateParam.setForumId(this.VK.afi().getForumId());
                addLocateParam.setForumName(this.VK.afi().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.VK.aeu() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.caC);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.P("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.P("obj_locate", this.mFrom);
            amVar2.P("obj_type", getThreadType());
            amVar2.bT("tid", this.VK.getTid());
            TiebaStatic.log(amVar2);
            if (this.bZt != null) {
                this.bZt.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.VK == null) {
            return 0;
        }
        if (this.VK.isShareThread) {
            return 4;
        }
        if (this.VK.getThreadType() == 49) {
            return 5;
        }
        if (this.VK.adM() != null) {
            return 1;
        }
        if (this.VK.getType() == bg.bIi || this.VK.getType() == bg.bIv) {
            if (v.Z(this.VK.adJ()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.VK != null || i >= 0) {
            am iU = iU(i);
            iU.P("thread_type", this.VK.getThreadType());
            TiebaStatic.log(iU);
        }
    }

    private am iU(int i) {
        if (this.VK == null && i < 0) {
            return null;
        }
        am amVar = new am("c12003");
        amVar.bT("tid", this.VK.getTid());
        if (this.VK.getThreadType() == 40) {
            amVar.bT("obj_param1", "2");
        } else if (this.VK.getThreadType() == 0) {
            amVar.bT("obj_param1", "1");
        }
        amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        amVar.l("fid", this.VK.getFid());
        amVar.P("obj_locate", this.mFrom);
        amVar.P(VideoPlayActivityConfig.OBJ_ID, i);
        if (!ap.isEmpty(this.caD)) {
            amVar.bT("obj_floor", this.caD);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bT("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return amVar;
        }
        return amVar;
    }

    protected void aS(View view) {
        if (this.bVg != null) {
            addPraiseStats(this.bVg.aL(view));
        }
    }

    protected void aT(View view) {
        if (this.bVh != null) {
            this.bVh.aL(view);
        }
    }

    protected void aP(View view) {
        if ((bf.iE() || bc.cE(this.mContext)) && this.VK != null) {
            ajR();
            ajT();
            if (this.bZt != null && this.VK.adz()) {
                this.bZt.onClick(view);
            }
        }
    }

    private void ajR() {
        if (this.VK != null) {
            am ajS = ajS();
            ajS.P("thread_type", this.VK.getThreadType());
            TiebaStatic.log(ajS);
        }
    }

    private am ajS() {
        int i = 4;
        if (this.VK == null) {
            return null;
        }
        if (this.caB != 1) {
            if (this.caB == 2) {
                i = 5;
            } else if (this.caB == 3) {
                i = 3;
            } else if (this.caB == 4) {
                i = 2;
            } else if (this.caB == 6) {
                i = 8;
            } else if (this.caB != 7) {
                i = 0;
            } else {
                i = 9;
            }
        }
        am amVar = new am("c12386");
        amVar.l("fid", this.VK.getFid());
        amVar.bT("tid", this.VK.getTid());
        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.P("obj_locate", i);
        if (!ap.isEmpty(this.caD)) {
            amVar.bT("obj_floor", this.caD);
        }
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        if (this.VK.adO() != null && this.VK.adO().user_info != null && this.VK.adO().user_info.is_official == 2) {
            amVar.P("obj_isofficial", this.VK.adO().user_info.is_official);
        }
        return amVar;
    }

    private void ajT() {
        if (this.VK != null && this.mContext != null) {
            String valueOf = String.valueOf(this.VK.getFid());
            String adA = this.VK.adA();
            if (this.VK.bKZ != null) {
                valueOf = this.VK.bKZ.id;
                adA = this.VK.bKZ.ori_fname;
            }
            String title = this.VK.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.VK.getAbstract();
            }
            String tid = this.VK.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.VK);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.VK.getAbstract();
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = title;
            eVar.content = format;
            eVar.cjC = str2;
            eVar.linkUrl = str;
            eVar.bLs = this.caB;
            eVar.extData = tid;
            eVar.cjF = 3;
            eVar.fid = valueOf;
            eVar.cjw = adA;
            eVar.tid = tid;
            eVar.cjp = true;
            eVar.cjE = getShareObjSource();
            eVar.cjJ = s(this.VK);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.VK);
            eVar.cjT = this.VK.getShareImageUrl();
            TbadkCoreApplication.getInst().setShareItem(eVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cjF);
            bundle.putInt("obj_type", eVar.cjJ);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bLs);
            eVar.E(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, true);
            shareDialogConfig.setIsAlaLive(this.VK.getThreadType() == 49 || this.VK.getThreadType() == 60);
            com.baidu.tieba.c.e.aZC().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.caB == 1) {
            return 5;
        }
        if (this.caB != 3) {
            if (this.caB == 4) {
                return 4;
            }
            if (this.caB != 6) {
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
        if (this.cam == null) {
            this.cam = new ac(this.mPageContext, this.caI);
        }
        this.cam.setData(this.VK);
        this.cam.showDialog();
        TiebaStatic.log(new am("c12711"));
    }

    private void aU(View view) {
        ajV();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.cat = z;
        if (this.bZV != null) {
            this.bZV.setClickable(this.cat);
        }
    }

    public boolean isMoreViewVisible() {
        return this.cag != null && this.cag.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.bZX != null) {
            this.bZX.setForumId(str);
        }
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.VK = bgVar;
        ajU();
        t(bgVar);
        v(bgVar);
        p(bgVar);
        o(bgVar);
        updatePraiseNum(bgVar);
        u(bgVar);
        q(bgVar);
        setVisibility(this.caq ? 0 : 8);
        return this.caq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajU() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(bg bgVar) {
        this.bZV.setVisibility(8);
    }

    protected void u(bg bgVar) {
        int af;
        if (this.cap != null && this.can != null && this.cao != null && bgVar != null) {
            if (!this.caI) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cap.setVisibility(8);
            } else if (this.caA && com.baidu.tieba.frs.a.biW().biX()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.l(this.mMaskView, R.color.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.can.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.can.performClick();
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
                al.j(this.cao, this.VK.afe() ? R.color.cp_link_tip_a : R.drawable.selector_comment_and_prise_item_text_color);
                this.can.setImageDrawable(al.getDrawable(bgVar.afe() ? R.drawable.icon_frs_select_h : R.drawable.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.cap.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.cap.setVisibility(8);
            }
        }
    }

    private void v(bg bgVar) {
        String acY;
        if (this.bZW != null && bgVar != null) {
            if (bgVar.ado() <= 0 || !this.car) {
                this.bZW.setVisibility(8);
                return;
            }
            this.bZW.setVisibility(0);
            if (this.mFrom == 3) {
                acY = bgVar.acZ();
            } else {
                acY = bgVar.acY();
            }
            this.bZW.setText(acY);
            this.caq = true;
        }
    }

    public boolean isVisible() {
        return this.caq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(bg bgVar) {
        if (this.bZZ != null && bgVar != null) {
            if (this.caw) {
                this.cab.setVisibility(0);
                if (this.cab.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cab.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cab.setLayoutParams(layoutParams);
                }
                if (bgVar.adm() > 0) {
                    this.bZZ.setVisibility(0);
                    String aN = ap.aN(bgVar.adm());
                    if (this.cau) {
                        this.caa.setImageDrawable(al.getDrawable(this.caF));
                        this.bZZ.setText(aN);
                    } else {
                        this.bZZ.setText(String.format(this.mContext.getString(R.string.reply_num_tip), aN));
                    }
                    this.bZZ.setContentDescription(this.mContext.getString(R.string.reply_num) + aN);
                    this.caq = true;
                    return;
                } else if (this.cau) {
                    this.caa.setImageDrawable(al.getDrawable(this.caF));
                    this.bZZ.setText(this.mContext.getString(R.string.action_comment_default));
                    this.bZZ.setVisibility(0);
                    this.caq = true;
                    return;
                } else {
                    this.bZZ.setVisibility(8);
                    return;
                }
            }
            this.cab.setVisibility(8);
        }
    }

    public void updatePraiseNum(bg bgVar) {
        if (this.bZX != null) {
            if (bgVar.getType() == bg.bIC || bgVar.getType() == bg.bID) {
                this.bZX.setDisPraiseFrom(5);
            }
            this.bZX.n(bgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(bg bgVar) {
        if (this.cae != null && this.cac != null && bgVar != null) {
            if (this.cay) {
                this.cae.setVisibility(0);
                if (this.cae.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cae.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cae.setLayoutParams(layoutParams);
                }
                long aeS = bgVar.aeS();
                if ((bgVar.aeG() || bgVar.aeJ()) && bgVar.adO() != null) {
                    aeS = bgVar.adO().share_info.share_count;
                }
                this.cac.setText(aeS > 0 ? ap.aN(aeS) : this.mContext.getString(R.string.share));
                this.caq = true;
                if (bgVar.bKP != null && bgVar.bKP.isDeleted) {
                    setShareClickable(false);
                    al.k(this.cad, R.drawable.icon_card_share_d);
                    al.j(this.cac, R.color.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.k(this.cad, this.caG);
                al.j(this.cac, R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.cae.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.cag != null) {
            if (this.VK == null || v.aa(this.VK.aeD()) || !TbadkCoreApplication.isLogin() || this.VK.aeE()) {
                this.cag.setVisibility(8);
                return;
            }
            if (this.cag.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cag.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.cag.setLayoutParams(layoutParams);
            }
            if (this.cah == null) {
                this.cah = new ArrayList();
            } else {
                this.cah.clear();
            }
            if (this.cai == null) {
                this.cai = new ArrayList();
            } else {
                this.cai.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.VK.aeD()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.cah.add(reportInfo.info);
                    this.cai.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.cag.setOnClickListener(this);
                this.cag.setVisibility(0);
                return;
            }
            this.cag.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(bg bgVar) {
        if (this.cal != null && bgVar != null) {
            if (bgVar.bKZ != null) {
                this.caz = false;
            }
            if (this.caz && (this.cap == null || this.cap.getVisibility() == 8)) {
                this.cal.setVisibility(0);
                if (this.cal.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cal.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.cal.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(R.string.manage);
                this.caj.setText(string);
                this.caj.setContentDescription(string);
                al.c(this.cak, (int) R.drawable.icon_card_frs_manage_selector);
                this.caq = true;
                return;
            }
            this.cal.setVisibility(8);
        }
    }

    private void ajV() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.hs(R.string.operation);
            bVar.a(this.cah, new b.a() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.cai, i);
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
            al.j(this.bZV, R.color.cp_cont_d);
            al.j(this.bZW, R.color.cp_cont_j);
            al.j(this.bZZ, R.drawable.selector_comment_and_prise_item_text_color);
            al.j(this.caj, R.drawable.selector_comment_and_prise_item_text_color);
            al.k(this.caf, R.drawable.btn_frs_more_selector);
            if (this.bZZ != null && this.cau && this.caF > 0) {
                this.caa.setImageDrawable(al.getDrawable(this.caF));
            }
            if (this.VK != null && this.VK.bKP != null && this.VK.bKP.isDeleted) {
                setShareClickable(false);
                al.k(this.cad, R.drawable.icon_card_share_d);
                al.j(this.cac, R.color.cp_cont_e);
            } else {
                setShareClickable(true);
                al.k(this.cad, this.caG);
                al.j(this.cac, R.drawable.selector_comment_and_prise_item_text_color);
            }
            if (this.cak != null) {
                this.cak.setImageDrawable(al.getDrawable(R.drawable.icon_card_frs_manage_selector));
            }
            if (this.cam != null) {
                this.cam.onChangeSkinType();
            }
            if (this.bZX != null) {
                this.bZX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            al.l(this.mMaskView, R.color.cp_bg_line_d);
            if (this.bZY != null) {
                this.bZY.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bZt = onClickListener;
        if (this.bVg != null) {
            this.bVg.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.bZV;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.cax = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.car = z;
    }

    public View getCommentNumView() {
        return this.bZZ;
    }

    public View getCommentContainer() {
        return this.cab;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.cau = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.cav = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.caA = z;
    }

    public void setManageVisible(boolean z) {
        this.caz = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.caH = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.can);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.bMZ;
    }

    public void setInFrsAllThread(boolean z) {
        this.caI = z;
    }

    public boolean isInFrsAllThread() {
        return this.caI;
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
        if (this.bZX != null) {
            this.bZX.onDestroy();
        }
        if (this.cam != null) {
            this.cam.destory();
        }
    }
}
