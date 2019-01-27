package com.baidu.tbadk.core.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.p.ay;
import com.baidu.tieba.card.ae;
import com.baidu.tieba.e;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes6.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected PraiseView aFH;
    protected DisPraiseView aFI;
    protected bb aFJ;
    protected TextView aJA;
    private TextView aJB;
    protected b aJC;
    protected TextView aJD;
    protected ImageView aJE;
    protected View aJF;
    protected TextView aJG;
    protected ImageView aJH;
    protected View aJI;
    protected TextView aJJ;
    protected FrameLayout aJK;
    private List<CharSequence> aJL;
    private List<String> aJM;
    protected TextView aJN;
    protected ImageView aJO;
    protected View aJP;
    private ae aJQ;
    protected ImageView aJR;
    protected TextView aJS;
    protected LinearLayout aJT;
    protected boolean aJU;
    private boolean aJV;
    protected boolean aJW;
    protected boolean aJX;
    protected boolean aJY;
    protected boolean aJZ;
    private View.OnClickListener aJb;
    protected int aJz;
    protected boolean aKa;
    private boolean aKb;
    protected boolean aKc;
    protected boolean aKd;
    protected boolean aKe;
    private int aKf;
    public String aKg;
    private String aKh;
    protected int aKi;
    protected int aKj;
    private a aKk;
    private LinearLayout aKl;
    private boolean aKm;
    public int awp;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    private TbPageContext mPageContext;
    private String mStType;

    /* loaded from: classes6.dex */
    public interface a {
        void bK(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.aKh = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.aJC != null) {
            this.aJC.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aJC != null) {
            this.aJC.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.aKf = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aJz = 0;
        this.aJU = false;
        this.aJV = true;
        this.aJW = true;
        this.aJX = true;
        this.aJY = false;
        this.aJZ = false;
        this.aKa = true;
        this.aKb = false;
        this.aKc = true;
        this.aKd = false;
        this.aKe = true;
        this.mFrom = 2;
        this.aKf = 1;
        this.aKk = null;
        this.aKm = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJz = 0;
        this.aJU = false;
        this.aJV = true;
        this.aJW = true;
        this.aJX = true;
        this.aJY = false;
        this.aJZ = false;
        this.aKa = true;
        this.aKb = false;
        this.aKc = true;
        this.aKd = false;
        this.aKe = true;
        this.mFrom = 2;
        this.aKf = 1;
        this.aKk = null;
        this.aKm = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aJz = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aJA = (TextView) inflate.findViewById(e.g.thread_info_bar_name);
        this.aJB = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aKl = (LinearLayout) inflate.findViewById(e.g.thread_comment_layout_root);
        this.aJD = (TextView) inflate.findViewById(e.g.thread_info_commont_num);
        this.aJE = (ImageView) inflate.findViewById(e.g.thread_info_commont_img);
        this.aJF = inflate.findViewById(e.g.thread_info_commont_container);
        this.aJG = (TextView) inflate.findViewById(e.g.share_num);
        this.aJH = (ImageView) inflate.findViewById(e.g.share_num_img);
        this.aJI = inflate.findViewById(e.g.share_num_container);
        this.aJJ = (TextView) inflate.findViewById(e.g.thread_info_more);
        this.aJK = (FrameLayout) inflate.findViewById(e.g.thread_info_more_frame);
        this.aFH = (PraiseView) inflate.findViewById(e.g.agree_view);
        this.aFI = (DisPraiseView) inflate.findViewById(e.g.disagree_view);
        this.aJC = new b(this.aFH, this.aFI);
        this.aJP = inflate.findViewById(e.g.manage_view_container);
        this.aJN = (TextView) inflate.findViewById(e.g.thread_info_manage_text);
        this.aJO = (ImageView) inflate.findViewById(e.g.thread_info_manage_img);
        this.aJR = (ImageView) inflate.findViewById(e.g.manage_select_img);
        this.aJS = (TextView) inflate.findViewById(e.g.manage_select_text);
        this.aJT = (LinearLayout) inflate.findViewById(e.g.manage_select_container);
        this.aJT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.aJR.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.aJS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aJR.performClick();
            }
        });
        this.aJT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aJR.performClick();
            }
        });
        this.aFH.setOnClickListener(this);
        this.aFI.setOnClickListener(this);
        this.aJF.setOnClickListener(this);
        this.aJI.setOnClickListener(this);
        this.aJP.setOnClickListener(this);
        this.aJR.setOnClickListener(this);
        this.aKj = e.f.icon_home_card_share;
        this.aKi = e.f.icon_home_card_comment;
        this.aJC.ES();
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            this.aJC.h(getPageUniqueId());
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                this.aJC.h(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                return;
            }
            this.aJC.h(getPageUniqueId());
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
        if (view == this.aJA) {
            S(view);
        } else if (view == this.aJF) {
            N(view);
        } else if (view == this.aJI) {
            O(view);
        } else if (view == this.aFH) {
            P(view);
        } else if (view == this.aFI) {
            Q(view);
        } else if (view == this.aJK) {
            U(view);
        } else if (view == this.aJP) {
            T(view);
        } else if (view == this.aJR) {
            R(view);
        }
    }

    protected void R(View view) {
        if (this.aJR != null && this.aFJ != null && this.aJS != null && !this.aFJ.Bv()) {
            if (!this.aFJ.Bu()) {
                if (com.baidu.tieba.frs.a.aBg().V(this.aFJ)) {
                    this.aFJ.be(true);
                }
            } else {
                com.baidu.tieba.frs.a.aBg().W(this.aFJ);
                this.aFJ.be(false);
            }
            al.h(this.aJS, this.aFJ.Bu() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
            this.aJR.setImageDrawable(al.getDrawable(this.aFJ.Bu() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
            if (this.aKk != null) {
                this.aKk.bK(this.aFJ.Bu());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aJQ != null) {
            this.aJQ.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.aJF != null) {
            this.aJF.setClickable(z);
            this.aJE.setEnabled(z);
            this.aJD.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.aJC != null) {
            this.aJC.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.aJI != null) {
            this.aJI.setClickable(z);
            this.aJH.setEnabled(z);
            this.aJG.setEnabled(z);
        }
    }

    private void S(View view) {
        if (this.aFJ != null && !StringUtils.isNull(this.aFJ.zZ())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aKh)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.aFJ.zZ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aFJ.zZ(), this.mStType, this.aKh)));
            }
            if (this.aJb != null) {
                this.aJb.onClick(view);
            }
        }
    }

    protected void N(View view) {
        if (this.aFJ != null && this.mContext != null) {
            com.baidu.tieba.card.o.mW(this.aFJ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aFJ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aFJ.getFid()));
            addLocateParam.setForumName(this.aFJ.zZ());
            if (this.aFJ.Bz() && this.aFJ.By() != null) {
                addLocateParam.setForumId(this.aFJ.By().getForumId());
                addLocateParam.setForumName(this.aFJ.By().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.aFJ.AK() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.awp);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.y("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.y("obj_locate", this.mFrom);
            amVar2.y("obj_type", getThreadType());
            amVar2.aB("tid", this.aFJ.getTid());
            TiebaStatic.log(amVar2);
            if (this.aJb != null) {
                this.aJb.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.aFJ == null) {
            return 0;
        }
        if (this.aFJ.isShareThread) {
            return 4;
        }
        if (this.aFJ.getThreadType() == 49) {
            return 5;
        }
        if (this.aFJ.Al() != null) {
            return 1;
        }
        if (this.aFJ.getType() == bb.atJ || this.aFJ.getType() == bb.atL) {
            if (v.H(this.aFJ.Ai()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aFJ != null || i >= 0) {
            am eB = eB(i);
            eB.y("thread_type", this.aFJ.getThreadType());
            TiebaStatic.log(eB);
        }
    }

    private am eB(int i) {
        if (this.aFJ == null && i < 0) {
            return null;
        }
        am amVar = new am("c12003");
        amVar.aB("tid", this.aFJ.getTid());
        if (this.aFJ.getThreadType() == 40) {
            amVar.aB("obj_param1", "2");
        } else if (this.aFJ.getThreadType() == 0) {
            amVar.aB("obj_param1", "1");
        }
        amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        amVar.i(ImageViewerConfig.FORUM_ID, this.aFJ.getFid());
        amVar.y("obj_locate", this.mFrom);
        amVar.y(VideoPlayActivityConfig.OBJ_ID, i);
        if (!ao.isEmpty(this.aKg)) {
            amVar.aB("obj_floor", this.aKg);
        }
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aB("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return amVar;
        }
        return amVar;
    }

    protected void P(View view) {
        if (this.aFH != null) {
            addPraiseStats(this.aFH.L(view));
        }
    }

    protected void Q(View view) {
        if (this.aFI != null) {
            this.aFI.L(view);
        }
    }

    protected void O(View view) {
        if ((ay.jJ() || ba.bJ(this.mContext)) && this.aFJ != null) {
            FB();
            FD();
            if (this.aJb != null && this.aFJ.zY()) {
                this.aJb.onClick(view);
            }
        }
    }

    private void FB() {
        if (this.aFJ != null) {
            am FC = FC();
            FC.y("thread_type", this.aFJ.getThreadType());
            TiebaStatic.log(FC);
        }
    }

    private am FC() {
        int i = 4;
        if (this.aFJ == null) {
            return null;
        }
        if (this.aKf != 1) {
            if (this.aKf == 2) {
                i = 5;
            } else if (this.aKf == 3) {
                i = 3;
            } else if (this.aKf == 4) {
                i = 2;
            } else if (this.aKf == 6) {
                i = 8;
            } else if (this.aKf != 7) {
                i = 0;
            } else {
                i = 9;
            }
        }
        am amVar = new am("c12386");
        amVar.i(ImageViewerConfig.FORUM_ID, this.aFJ.getFid());
        amVar.aB("tid", this.aFJ.getTid());
        amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.y("obj_locate", i);
        if (!ao.isEmpty(this.aKg)) {
            amVar.aB("obj_floor", this.aKg);
        }
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    private void FD() {
        if (this.aFJ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aFJ.getFid());
            String zZ = this.aFJ.zZ();
            if (this.aFJ.awf != null) {
                valueOf = this.aFJ.awf.id;
                zZ = this.aFJ.awf.ori_fname;
            }
            String title = this.aFJ.getTitle();
            String tid = this.aFJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aFJ);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aFJ.getAbstract();
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aSR = str2;
            dVar.linkUrl = str;
            dVar.awo = this.aKf;
            dVar.extData = tid;
            dVar.aSU = 3;
            dVar.fid = valueOf;
            dVar.aSM = zZ;
            dVar.tid = tid;
            dVar.aSI = true;
            dVar.aST = getShareObjSource();
            dVar.aSV = c(this.aFJ);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aFJ);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSU);
            bundle.putInt("obj_type", dVar.aSV);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.awo);
            dVar.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aFJ.getThreadType() == 49 || this.aFJ.getThreadType() == 60);
            com.baidu.tieba.c.e.asB().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.aKf == 1) {
            return 5;
        }
        if (this.aKf != 3) {
            if (this.aKf == 4) {
                return 4;
            }
            if (this.aKf != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.Ae() == null) {
            return null;
        }
        ArrayList<MediaData> Ae = bbVar.Ae();
        int size = Ae.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = Ae.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    return mediaData.getThumbnails_url();
                }
                if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    return mediaData.getPicUrl();
                }
            }
        }
        return null;
    }

    private int c(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.zV()) {
                return 4;
            }
            if (bbVar.zQ() == 1) {
                return 3;
            }
            return bbVar.AY() ? 2 : 1;
        }
        return 0;
    }

    private void T(View view) {
        if (this.aJQ == null) {
            this.aJQ = new ae(this.mPageContext, this.aKm);
        }
        this.aJQ.setData(this.aFJ);
        com.baidu.adp.lib.g.g.a(this.aJQ, this.mPageContext);
        TiebaStatic.log(new am("c12711"));
    }

    private void U(View view) {
        FF();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aJX = z;
        if (this.aJA != null) {
            this.aJA.setClickable(this.aJX);
        }
    }

    public boolean isMoreViewVisible() {
        return this.aJK != null && this.aJK.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.aJC != null) {
            this.aJC.setForumId(str);
        }
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFJ = bbVar;
        FE();
        d(bbVar);
        f(bbVar);
        g(bbVar);
        h(bbVar);
        updatePraiseNum(bbVar);
        e(bbVar);
        i(bbVar);
        setVisibility(this.aJU ? 0 : 8);
        return this.aJU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(bb bbVar) {
        this.aJA.setVisibility(8);
    }

    protected void e(bb bbVar) {
        int aO;
        if (this.aJT != null && this.aJR != null && this.aJS != null && bbVar != null) {
            if (!this.aKm) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aJT.setVisibility(8);
            } else if (this.aKe && com.baidu.tieba.frs.a.aBg().aBh()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.j(this.mMaskView, e.d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.aJR.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.aJR.performClick();
                        }
                    });
                }
                if (bbVar.Bv()) {
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
                al.h(this.aJS, this.aFJ.Bu() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
                this.aJR.setImageDrawable(al.getDrawable(bbVar.Bu() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.aJT.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aJT.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String O;
        if (this.aJB != null && bbVar != null) {
            if (bbVar.zM() <= 0 || !this.aJV) {
                this.aJB.setVisibility(8);
                return;
            }
            this.aJB.setVisibility(0);
            if (this.mFrom == 3) {
                O = ao.L(bbVar.zM());
            } else {
                O = ao.O(bbVar.zM() * 1000);
            }
            this.aJB.setText(O);
            this.aJU = true;
        }
    }

    public boolean isVisible() {
        return this.aJU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bb bbVar) {
        if (this.aJD != null && bbVar != null) {
            if (this.aKa) {
                this.aJF.setVisibility(0);
                if (this.aJF.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJF.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJF.setLayoutParams(layoutParams);
                }
                if (bbVar.zK() > 0) {
                    this.aJD.setVisibility(0);
                    String X = ao.X(bbVar.zK());
                    if (this.aJY) {
                        this.aJE.setImageDrawable(al.getDrawable(this.aKi));
                        this.aJD.setText(X);
                    } else {
                        this.aJD.setText(String.format(this.mContext.getString(e.j.reply_num_tip), X));
                    }
                    this.aJD.setContentDescription(this.mContext.getString(e.j.reply_num) + X);
                    this.aJU = true;
                    return;
                } else if (this.aJY) {
                    this.aJE.setImageDrawable(al.getDrawable(this.aKi));
                    this.aJD.setText(this.mContext.getString(e.j.action_comment_default));
                    this.aJD.setVisibility(0);
                    this.aJU = true;
                    return;
                } else {
                    this.aJD.setVisibility(8);
                    return;
                }
            }
            this.aJF.setVisibility(8);
        }
    }

    public void updatePraiseNum(bb bbVar) {
        if (this.aJC != null) {
            if (bbVar.getType() == bb.atS || bbVar.getType() == bb.atT) {
                this.aJC.setDisPraiseFrom(5);
            }
            this.aJC.a(bbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bb bbVar) {
        if (this.aJI != null && this.aJG != null && bbVar != null) {
            if (this.aKc) {
                this.aJI.setVisibility(0);
                if (this.aJI.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJI.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJI.setLayoutParams(layoutParams);
                }
                long Bj = bbVar.Bj();
                if ((bbVar.AX() || bbVar.Ba()) && bbVar.An() != null) {
                    Bj = bbVar.An().share_info.share_count;
                }
                this.aJG.setText(Bj > 0 ? ao.X(Bj) : this.mContext.getString(e.j.share));
                this.aJU = true;
                if (bbVar.avW != null && bbVar.avW.isDeleted) {
                    setShareClickable(false);
                    al.i(this.aJH, e.f.icon_card_share_d);
                    al.h(this.aJG, e.d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.i(this.aJH, this.aKj);
                al.h(this.aJG, e.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.aJI.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.aJK != null) {
            if (this.aFJ == null || v.I(this.aFJ.AU()) || !TbadkCoreApplication.isLogin() || this.aFJ.AV()) {
                this.aJK.setVisibility(8);
                return;
            }
            if (this.aJK.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJK.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.aJK.setLayoutParams(layoutParams);
            }
            if (this.aJL == null) {
                this.aJL = new ArrayList();
            } else {
                this.aJL.clear();
            }
            if (this.aJM == null) {
                this.aJM = new ArrayList();
            } else {
                this.aJM.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aFJ.AU()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aJL.add(reportInfo.info);
                    this.aJM.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aJK.setOnClickListener(this);
                this.aJK.setVisibility(0);
                return;
            }
            this.aJK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(bb bbVar) {
        if (this.aJP != null && bbVar != null) {
            if (bbVar.awf != null) {
                this.aKd = false;
            }
            if (this.aKd && (this.aJT == null || this.aJT.getVisibility() == 8)) {
                this.aJP.setVisibility(0);
                if (this.aJP.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJP.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJP.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(e.j.manage);
                this.aJN.setText(string);
                this.aJN.setContentDescription(string);
                this.aJU = true;
                return;
            }
            this.aJP.setVisibility(8);
        }
    }

    private void FF() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.de(e.j.operation);
            bVar.a(this.aJL, new b.InterfaceC0158b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.d(ThreadCommentAndPraiseInfoLayout.this.aJM, i);
                    if (!StringUtils.isNull(str)) {
                        com.baidu.tbadk.core.util.ay.Es().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.BV();
        }
    }

    public void onChangeSkinType() {
        al.h(this.aJA, e.d.cp_cont_d);
        al.h(this.aJB, e.d.cp_cont_j);
        al.h(this.aJD, e.f.selector_comment_and_prise_item_text_color);
        al.h(this.aJN, e.f.selector_comment_and_prise_item_text_color);
        al.i(this.aJJ, e.f.btn_frs_more_selector);
        if (this.aJD != null && this.aJY && this.aKi > 0) {
            this.aJE.setImageDrawable(al.getDrawable(this.aKi));
        }
        if (this.aFJ != null && this.aFJ.avW != null && this.aFJ.avW.isDeleted) {
            setShareClickable(false);
            al.i(this.aJH, e.f.icon_card_share_d);
            al.h(this.aJG, e.d.cp_cont_e);
        } else {
            setShareClickable(true);
            al.i(this.aJH, this.aKj);
            al.h(this.aJG, e.f.selector_comment_and_prise_item_text_color);
        }
        if (this.aJO != null) {
            this.aJO.setImageDrawable(al.getDrawable(e.f.icon_card_frs_manage_selector));
        }
        if (this.aJQ != null) {
            this.aJQ.onChangeSkinType();
        }
        if (this.aJC != null) {
            this.aJC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        al.j(this.mMaskView, e.d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aJb = onClickListener;
        if (this.aFH != null) {
            this.aFH.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.aJA;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.aKb = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aJV = z;
    }

    public View getCommentNumView() {
        return this.aJD;
    }

    public View getCommentContainer() {
        return this.aJF;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aJY = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.aJZ = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.aKe = z;
    }

    public void setManageVisible(boolean z) {
        this.aKd = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.aKk = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.aJR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.aKl;
    }

    public void setInFrsAllThread(boolean z) {
        this.aKm = z;
    }

    public boolean isInFrsAllThread() {
        return this.aKm;
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
        if (this.aJC != null) {
            this.aJC.onDestroy();
        }
    }
}
