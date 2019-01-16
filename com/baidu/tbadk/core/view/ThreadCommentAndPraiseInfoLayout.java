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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.p.ax;
import com.baidu.tieba.card.ae;
import com.baidu.tieba.e;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes6.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected PraiseView aFG;
    protected DisPraiseView aFH;
    protected bb aFI;
    private TextView aJA;
    protected b aJB;
    protected TextView aJC;
    protected ImageView aJD;
    protected View aJE;
    protected TextView aJF;
    protected ImageView aJG;
    protected View aJH;
    protected TextView aJI;
    protected FrameLayout aJJ;
    private List<CharSequence> aJK;
    private List<String> aJL;
    protected TextView aJM;
    protected ImageView aJN;
    protected View aJO;
    private ae aJP;
    protected ImageView aJQ;
    protected TextView aJR;
    protected LinearLayout aJS;
    protected boolean aJT;
    private boolean aJU;
    protected boolean aJV;
    protected boolean aJW;
    protected boolean aJX;
    protected boolean aJY;
    protected boolean aJZ;
    private View.OnClickListener aJa;
    protected int aJy;
    protected TextView aJz;
    private boolean aKa;
    protected boolean aKb;
    protected boolean aKc;
    protected boolean aKd;
    private int aKe;
    public String aKf;
    private String aKg;
    protected int aKh;
    protected int aKi;
    private a aKj;
    private LinearLayout aKk;
    private boolean aKl;
    public int awo;
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
        this.aKg = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.aJB != null) {
            this.aJB.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aJB != null) {
            this.aJB.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.aKe = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aJy = 0;
        this.aJT = false;
        this.aJU = true;
        this.aJV = true;
        this.aJW = true;
        this.aJX = false;
        this.aJY = false;
        this.aJZ = true;
        this.aKa = false;
        this.aKb = true;
        this.aKc = false;
        this.aKd = true;
        this.mFrom = 2;
        this.aKe = 1;
        this.aKj = null;
        this.aKl = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJy = 0;
        this.aJT = false;
        this.aJU = true;
        this.aJV = true;
        this.aJW = true;
        this.aJX = false;
        this.aJY = false;
        this.aJZ = true;
        this.aKa = false;
        this.aKb = true;
        this.aKc = false;
        this.aKd = true;
        this.mFrom = 2;
        this.aKe = 1;
        this.aKj = null;
        this.aKl = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aJy = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aJz = (TextView) inflate.findViewById(e.g.thread_info_bar_name);
        this.aJA = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aKk = (LinearLayout) inflate.findViewById(e.g.thread_comment_layout_root);
        this.aJC = (TextView) inflate.findViewById(e.g.thread_info_commont_num);
        this.aJD = (ImageView) inflate.findViewById(e.g.thread_info_commont_img);
        this.aJE = inflate.findViewById(e.g.thread_info_commont_container);
        this.aJF = (TextView) inflate.findViewById(e.g.share_num);
        this.aJG = (ImageView) inflate.findViewById(e.g.share_num_img);
        this.aJH = inflate.findViewById(e.g.share_num_container);
        this.aJI = (TextView) inflate.findViewById(e.g.thread_info_more);
        this.aJJ = (FrameLayout) inflate.findViewById(e.g.thread_info_more_frame);
        this.aFG = (PraiseView) inflate.findViewById(e.g.agree_view);
        this.aFH = (DisPraiseView) inflate.findViewById(e.g.disagree_view);
        this.aJB = new b(this.aFG, this.aFH);
        this.aJO = inflate.findViewById(e.g.manage_view_container);
        this.aJM = (TextView) inflate.findViewById(e.g.thread_info_manage_text);
        this.aJN = (ImageView) inflate.findViewById(e.g.thread_info_manage_img);
        this.aJQ = (ImageView) inflate.findViewById(e.g.manage_select_img);
        this.aJR = (TextView) inflate.findViewById(e.g.manage_select_text);
        this.aJS = (LinearLayout) inflate.findViewById(e.g.manage_select_container);
        this.aJS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.aJQ.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.aJR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aJQ.performClick();
            }
        });
        this.aJS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aJQ.performClick();
            }
        });
        this.aFG.setOnClickListener(this);
        this.aFH.setOnClickListener(this);
        this.aJE.setOnClickListener(this);
        this.aJH.setOnClickListener(this);
        this.aJO.setOnClickListener(this);
        this.aJQ.setOnClickListener(this);
        this.aKi = e.f.icon_home_card_share;
        this.aKh = e.f.icon_home_card_comment;
        this.aJB.ES();
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            this.aJB.h(getPageUniqueId());
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                this.aJB.h(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                return;
            }
            this.aJB.h(getPageUniqueId());
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
        if (view == this.aJz) {
            S(view);
        } else if (view == this.aJE) {
            N(view);
        } else if (view == this.aJH) {
            O(view);
        } else if (view == this.aFG) {
            P(view);
        } else if (view == this.aFH) {
            Q(view);
        } else if (view == this.aJJ) {
            U(view);
        } else if (view == this.aJO) {
            T(view);
        } else if (view == this.aJQ) {
            R(view);
        }
    }

    protected void R(View view) {
        if (this.aJQ != null && this.aFI != null && this.aJR != null && !this.aFI.Bv()) {
            if (!this.aFI.Bu()) {
                if (com.baidu.tieba.frs.a.aBg().V(this.aFI)) {
                    this.aFI.be(true);
                }
            } else {
                com.baidu.tieba.frs.a.aBg().W(this.aFI);
                this.aFI.be(false);
            }
            al.h(this.aJR, this.aFI.Bu() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
            this.aJQ.setImageDrawable(al.getDrawable(this.aFI.Bu() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
            if (this.aKj != null) {
                this.aKj.bK(this.aFI.Bu());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aJP != null) {
            this.aJP.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.aJE != null) {
            this.aJE.setClickable(z);
            this.aJD.setEnabled(z);
            this.aJC.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.aJB != null) {
            this.aJB.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.aJH != null) {
            this.aJH.setClickable(z);
            this.aJG.setEnabled(z);
            this.aJF.setEnabled(z);
        }
    }

    private void S(View view) {
        if (this.aFI != null && !StringUtils.isNull(this.aFI.zZ())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aKg)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.aFI.zZ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aFI.zZ(), this.mStType, this.aKg)));
            }
            if (this.aJa != null) {
                this.aJa.onClick(view);
            }
        }
    }

    protected void N(View view) {
        if (this.aFI != null && this.mContext != null) {
            com.baidu.tieba.card.o.mW(this.aFI.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aFI, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aFI.getFid()));
            addLocateParam.setForumName(this.aFI.zZ());
            if (this.aFI.Bz() && this.aFI.By() != null) {
                addLocateParam.setForumId(this.aFI.By().getForumId());
                addLocateParam.setForumName(this.aFI.By().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.aFI.AK() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.awo);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.y("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.y("obj_locate", this.mFrom);
            amVar2.y("obj_type", getThreadType());
            amVar2.aB("tid", this.aFI.getTid());
            TiebaStatic.log(amVar2);
            if (this.aJa != null) {
                this.aJa.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.aFI == null) {
            return 0;
        }
        if (this.aFI.isShareThread) {
            return 4;
        }
        if (this.aFI.getThreadType() == 49) {
            return 5;
        }
        if (this.aFI.Al() != null) {
            return 1;
        }
        if (this.aFI.getType() == bb.atI || this.aFI.getType() == bb.atK) {
            if (v.H(this.aFI.Ai()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aFI != null || i >= 0) {
            am eB = eB(i);
            eB.y("thread_type", this.aFI.getThreadType());
            TiebaStatic.log(eB);
        }
    }

    private am eB(int i) {
        if (this.aFI == null && i < 0) {
            return null;
        }
        am amVar = new am("c12003");
        amVar.aB("tid", this.aFI.getTid());
        if (this.aFI.getThreadType() == 40) {
            amVar.aB("obj_param1", "2");
        } else if (this.aFI.getThreadType() == 0) {
            amVar.aB("obj_param1", "1");
        }
        amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        amVar.i(ImageViewerConfig.FORUM_ID, this.aFI.getFid());
        amVar.y("obj_locate", this.mFrom);
        amVar.y(VideoPlayActivityConfig.OBJ_ID, i);
        if (!ao.isEmpty(this.aKf)) {
            amVar.aB("obj_floor", this.aKf);
        }
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aB("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return amVar;
        }
        return amVar;
    }

    protected void P(View view) {
        if (this.aFG != null) {
            addPraiseStats(this.aFG.L(view));
        }
    }

    protected void Q(View view) {
        if (this.aFH != null) {
            this.aFH.L(view);
        }
    }

    protected void O(View view) {
        if ((ax.jJ() || ba.bJ(this.mContext)) && this.aFI != null) {
            FB();
            FD();
            if (this.aJa != null && this.aFI.zY()) {
                this.aJa.onClick(view);
            }
        }
    }

    private void FB() {
        if (this.aFI != null) {
            am FC = FC();
            FC.y("thread_type", this.aFI.getThreadType());
            TiebaStatic.log(FC);
        }
    }

    private am FC() {
        int i = 4;
        if (this.aFI == null) {
            return null;
        }
        if (this.aKe != 1) {
            if (this.aKe == 2) {
                i = 5;
            } else if (this.aKe == 3) {
                i = 3;
            } else if (this.aKe == 4) {
                i = 2;
            } else if (this.aKe == 6) {
                i = 8;
            } else if (this.aKe != 7) {
                i = 0;
            } else {
                i = 9;
            }
        }
        am amVar = new am("c12386");
        amVar.i(ImageViewerConfig.FORUM_ID, this.aFI.getFid());
        amVar.aB("tid", this.aFI.getTid());
        amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.y("obj_locate", i);
        if (!ao.isEmpty(this.aKf)) {
            amVar.aB("obj_floor", this.aKf);
        }
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    private void FD() {
        if (this.aFI != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aFI.getFid());
            String zZ = this.aFI.zZ();
            if (this.aFI.awe != null) {
                valueOf = this.aFI.awe.id;
                zZ = this.aFI.awe.ori_fname;
            }
            String title = this.aFI.getTitle();
            String tid = this.aFI.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aFI);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aFI.getAbstract();
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aSQ = str2;
            dVar.linkUrl = str;
            dVar.awn = this.aKe;
            dVar.extData = tid;
            dVar.aST = 3;
            dVar.fid = valueOf;
            dVar.aSL = zZ;
            dVar.tid = tid;
            dVar.aSH = true;
            dVar.aSS = getShareObjSource();
            dVar.aSU = c(this.aFI);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aFI);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aST);
            bundle.putInt("obj_type", dVar.aSU);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.awn);
            dVar.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aFI.getThreadType() == 49 || this.aFI.getThreadType() == 60);
            com.baidu.tieba.c.e.asB().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.aKe == 1) {
            return 5;
        }
        if (this.aKe != 3) {
            if (this.aKe == 4) {
                return 4;
            }
            if (this.aKe != 6) {
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
        if (this.aJP == null) {
            this.aJP = new ae(this.mPageContext, this.aKl);
        }
        this.aJP.setData(this.aFI);
        com.baidu.adp.lib.g.g.a(this.aJP, this.mPageContext);
        TiebaStatic.log(new am("c12711"));
    }

    private void U(View view) {
        FF();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aJW = z;
        if (this.aJz != null) {
            this.aJz.setClickable(this.aJW);
        }
    }

    public boolean isMoreViewVisible() {
        return this.aJJ != null && this.aJJ.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.aJB != null) {
            this.aJB.setForumId(str);
        }
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFI = bbVar;
        FE();
        d(bbVar);
        f(bbVar);
        g(bbVar);
        h(bbVar);
        updatePraiseNum(bbVar);
        e(bbVar);
        i(bbVar);
        setVisibility(this.aJT ? 0 : 8);
        return this.aJT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(bb bbVar) {
        this.aJz.setVisibility(8);
    }

    protected void e(bb bbVar) {
        int aO;
        if (this.aJS != null && this.aJQ != null && this.aJR != null && bbVar != null) {
            if (!this.aKl) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aJS.setVisibility(8);
            } else if (this.aKd && com.baidu.tieba.frs.a.aBg().aBh()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.j(this.mMaskView, e.d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.aJQ.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.aJQ.performClick();
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
                al.h(this.aJR, this.aFI.Bu() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
                this.aJQ.setImageDrawable(al.getDrawable(bbVar.Bu() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.aJS.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aJS.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String O;
        if (this.aJA != null && bbVar != null) {
            if (bbVar.zM() <= 0 || !this.aJU) {
                this.aJA.setVisibility(8);
                return;
            }
            this.aJA.setVisibility(0);
            if (this.mFrom == 3) {
                O = ao.L(bbVar.zM());
            } else {
                O = ao.O(bbVar.zM() * 1000);
            }
            this.aJA.setText(O);
            this.aJT = true;
        }
    }

    public boolean isVisible() {
        return this.aJT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bb bbVar) {
        if (this.aJC != null && bbVar != null) {
            if (this.aJZ) {
                this.aJE.setVisibility(0);
                if (this.aJE.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJE.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJE.setLayoutParams(layoutParams);
                }
                if (bbVar.zK() > 0) {
                    this.aJC.setVisibility(0);
                    String X = ao.X(bbVar.zK());
                    if (this.aJX) {
                        this.aJD.setImageDrawable(al.getDrawable(this.aKh));
                        this.aJC.setText(X);
                    } else {
                        this.aJC.setText(String.format(this.mContext.getString(e.j.reply_num_tip), X));
                    }
                    this.aJC.setContentDescription(this.mContext.getString(e.j.reply_num) + X);
                    this.aJT = true;
                    return;
                } else if (this.aJX) {
                    this.aJD.setImageDrawable(al.getDrawable(this.aKh));
                    this.aJC.setText(this.mContext.getString(e.j.action_comment_default));
                    this.aJC.setVisibility(0);
                    this.aJT = true;
                    return;
                } else {
                    this.aJC.setVisibility(8);
                    return;
                }
            }
            this.aJE.setVisibility(8);
        }
    }

    public void updatePraiseNum(bb bbVar) {
        if (this.aJB != null) {
            if (bbVar.getType() == bb.atR || bbVar.getType() == bb.atS) {
                this.aJB.setDisPraiseFrom(5);
            }
            this.aJB.a(bbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bb bbVar) {
        if (this.aJH != null && this.aJF != null && bbVar != null) {
            if (this.aKb) {
                this.aJH.setVisibility(0);
                if (this.aJH.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJH.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJH.setLayoutParams(layoutParams);
                }
                long Bj = bbVar.Bj();
                if ((bbVar.AX() || bbVar.Ba()) && bbVar.An() != null) {
                    Bj = bbVar.An().share_info.share_count;
                }
                this.aJF.setText(Bj > 0 ? ao.X(Bj) : this.mContext.getString(e.j.share));
                this.aJT = true;
                if (bbVar.avV != null && bbVar.avV.isDeleted) {
                    setShareClickable(false);
                    al.i(this.aJG, e.f.icon_card_share_d);
                    al.h(this.aJF, e.d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.i(this.aJG, this.aKi);
                al.h(this.aJF, e.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.aJH.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.aJJ != null) {
            if (this.aFI == null || v.I(this.aFI.AU()) || !TbadkCoreApplication.isLogin() || this.aFI.AV()) {
                this.aJJ.setVisibility(8);
                return;
            }
            if (this.aJJ.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJJ.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.aJJ.setLayoutParams(layoutParams);
            }
            if (this.aJK == null) {
                this.aJK = new ArrayList();
            } else {
                this.aJK.clear();
            }
            if (this.aJL == null) {
                this.aJL = new ArrayList();
            } else {
                this.aJL.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aFI.AU()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aJK.add(reportInfo.info);
                    this.aJL.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aJJ.setOnClickListener(this);
                this.aJJ.setVisibility(0);
                return;
            }
            this.aJJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(bb bbVar) {
        if (this.aJO != null && bbVar != null) {
            if (bbVar.awe != null) {
                this.aKc = false;
            }
            if (this.aKc && (this.aJS == null || this.aJS.getVisibility() == 8)) {
                this.aJO.setVisibility(0);
                if (this.aJO.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJO.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJO.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(e.j.manage);
                this.aJM.setText(string);
                this.aJM.setContentDescription(string);
                this.aJT = true;
                return;
            }
            this.aJO.setVisibility(8);
        }
    }

    private void FF() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.de(e.j.operation);
            bVar.a(this.aJK, new b.InterfaceC0158b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.d(ThreadCommentAndPraiseInfoLayout.this.aJL, i);
                    if (!StringUtils.isNull(str)) {
                        ay.Es().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.BV();
        }
    }

    public void onChangeSkinType() {
        al.h(this.aJz, e.d.cp_cont_d);
        al.h(this.aJA, e.d.cp_cont_j);
        al.h(this.aJC, e.f.selector_comment_and_prise_item_text_color);
        al.h(this.aJM, e.f.selector_comment_and_prise_item_text_color);
        al.i(this.aJI, e.f.btn_frs_more_selector);
        if (this.aJC != null && this.aJX && this.aKh > 0) {
            this.aJD.setImageDrawable(al.getDrawable(this.aKh));
        }
        if (this.aFI != null && this.aFI.avV != null && this.aFI.avV.isDeleted) {
            setShareClickable(false);
            al.i(this.aJG, e.f.icon_card_share_d);
            al.h(this.aJF, e.d.cp_cont_e);
        } else {
            setShareClickable(true);
            al.i(this.aJG, this.aKi);
            al.h(this.aJF, e.f.selector_comment_and_prise_item_text_color);
        }
        if (this.aJN != null) {
            this.aJN.setImageDrawable(al.getDrawable(e.f.icon_card_frs_manage_selector));
        }
        if (this.aJP != null) {
            this.aJP.onChangeSkinType();
        }
        if (this.aJB != null) {
            this.aJB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        al.j(this.mMaskView, e.d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aJa = onClickListener;
        if (this.aFG != null) {
            this.aFG.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.aJz;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.aKa = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aJU = z;
    }

    public View getCommentNumView() {
        return this.aJC;
    }

    public View getCommentContainer() {
        return this.aJE;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aJX = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.aJY = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.aKd = z;
    }

    public void setManageVisible(boolean z) {
        this.aKc = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.aKj = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.aJQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.aKk;
    }

    public void setInFrsAllThread(boolean z) {
        this.aKl = z;
    }

    public boolean isInFrsAllThread() {
        return this.aKl;
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
        if (this.aJB != null) {
            this.aJB.onDestroy();
        }
    }
}
