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
    protected PraiseView aBD;
    protected DisPraiseView aBE;
    protected bb aBF;
    private View.OnClickListener aEX;
    protected ImageView aFA;
    protected View aFB;
    protected TextView aFC;
    protected ImageView aFD;
    protected View aFE;
    protected TextView aFF;
    protected FrameLayout aFG;
    private List<CharSequence> aFH;
    private List<String> aFI;
    protected TextView aFJ;
    protected ImageView aFK;
    protected View aFL;
    private ae aFM;
    protected ImageView aFN;
    protected TextView aFO;
    protected LinearLayout aFP;
    protected boolean aFQ;
    private boolean aFR;
    protected boolean aFS;
    protected boolean aFT;
    protected boolean aFU;
    protected boolean aFV;
    protected boolean aFW;
    private boolean aFX;
    protected boolean aFY;
    protected boolean aFZ;
    protected int aFv;
    protected TextView aFw;
    private TextView aFx;
    protected b aFy;
    protected TextView aFz;
    protected boolean aGa;
    private int aGb;
    private String aGc;
    protected int aGd;
    protected int aGe;
    private a aGf;
    private LinearLayout aGg;
    private boolean aGh;
    public int asl;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    private TbPageContext mPageContext;
    private String mStType;

    /* loaded from: classes6.dex */
    public interface a {
        void bI(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.aGc = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.aFy != null) {
            this.aFy.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aFy != null) {
            this.aFy.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.aGb = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aFv = 0;
        this.aFQ = false;
        this.aFR = true;
        this.aFS = true;
        this.aFT = true;
        this.aFU = false;
        this.aFV = false;
        this.aFW = true;
        this.aFX = false;
        this.aFY = true;
        this.aFZ = false;
        this.aGa = true;
        this.mFrom = 2;
        this.aGb = 1;
        this.aGf = null;
        this.aGh = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFv = 0;
        this.aFQ = false;
        this.aFR = true;
        this.aFS = true;
        this.aFT = true;
        this.aFU = false;
        this.aFV = false;
        this.aFW = true;
        this.aFX = false;
        this.aFY = true;
        this.aFZ = false;
        this.aGa = true;
        this.mFrom = 2;
        this.aGb = 1;
        this.aGf = null;
        this.aGh = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aFv = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aFw = (TextView) inflate.findViewById(e.g.thread_info_bar_name);
        this.aFx = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aGg = (LinearLayout) inflate.findViewById(e.g.thread_comment_layout_root);
        this.aFz = (TextView) inflate.findViewById(e.g.thread_info_commont_num);
        this.aFA = (ImageView) inflate.findViewById(e.g.thread_info_commont_img);
        this.aFB = inflate.findViewById(e.g.thread_info_commont_container);
        this.aFC = (TextView) inflate.findViewById(e.g.share_num);
        this.aFD = (ImageView) inflate.findViewById(e.g.share_num_img);
        this.aFE = inflate.findViewById(e.g.share_num_container);
        this.aFF = (TextView) inflate.findViewById(e.g.thread_info_more);
        this.aFG = (FrameLayout) inflate.findViewById(e.g.thread_info_more_frame);
        this.aBD = (PraiseView) inflate.findViewById(e.g.agree_view);
        this.aBE = (DisPraiseView) inflate.findViewById(e.g.disagree_view);
        this.aFy = new b(this.aBD, this.aBE);
        this.aFL = inflate.findViewById(e.g.manage_view_container);
        this.aFJ = (TextView) inflate.findViewById(e.g.thread_info_manage_text);
        this.aFK = (ImageView) inflate.findViewById(e.g.thread_info_manage_img);
        this.aFN = (ImageView) inflate.findViewById(e.g.manage_select_img);
        this.aFO = (TextView) inflate.findViewById(e.g.manage_select_text);
        this.aFP = (LinearLayout) inflate.findViewById(e.g.manage_select_container);
        this.aFP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.aFN.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.aFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aFN.performClick();
            }
        });
        this.aFP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aFN.performClick();
            }
        });
        this.aBD.setOnClickListener(this);
        this.aBE.setOnClickListener(this);
        this.aFB.setOnClickListener(this);
        this.aFE.setOnClickListener(this);
        this.aFL.setOnClickListener(this);
        this.aFN.setOnClickListener(this);
        this.aGe = e.f.icon_home_card_share;
        this.aGd = e.f.icon_home_card_comment;
        this.aFy.DB();
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            this.aFy.h(getPageUniqueId());
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                this.aFy.h(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                return;
            }
            this.aFy.h(getPageUniqueId());
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
        if (view == this.aFw) {
            S(view);
        } else if (view == this.aFB) {
            N(view);
        } else if (view == this.aFE) {
            O(view);
        } else if (view == this.aBD) {
            P(view);
        } else if (view == this.aBE) {
            Q(view);
        } else if (view == this.aFG) {
            U(view);
        } else if (view == this.aFL) {
            T(view);
        } else if (view == this.aFN) {
            R(view);
        }
    }

    protected void R(View view) {
        if (this.aFN != null && this.aBF != null && this.aFO != null && !this.aBF.Ae()) {
            if (!this.aBF.Ad()) {
                if (com.baidu.tieba.frs.a.ayk().V(this.aBF)) {
                    this.aBF.bc(true);
                }
            } else {
                com.baidu.tieba.frs.a.ayk().W(this.aBF);
                this.aBF.bc(false);
            }
            al.h(this.aFO, this.aBF.Ad() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
            this.aFN.setImageDrawable(al.getDrawable(this.aBF.Ad() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
            if (this.aGf != null) {
                this.aGf.bI(this.aBF.Ad());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aFM != null) {
            this.aFM.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.aFB != null) {
            this.aFB.setClickable(z);
            this.aFA.setEnabled(z);
            this.aFz.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.aFy != null) {
            this.aFy.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.aFE != null) {
            this.aFE.setClickable(z);
            this.aFD.setEnabled(z);
            this.aFC.setEnabled(z);
        }
    }

    private void S(View view) {
        if (this.aBF != null && !StringUtils.isNull(this.aBF.yI())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aGc)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.aBF.yI(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aBF.yI(), this.mStType, this.aGc)));
            }
            if (this.aEX != null) {
                this.aEX.onClick(view);
            }
        }
    }

    protected void N(View view) {
        if (this.aBF != null && this.mContext != null) {
            com.baidu.tieba.card.o.me(this.aBF.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aBF, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aBF.getFid()));
            addLocateParam.setForumName(this.aBF.yI());
            if (this.aBF.Ai() && this.aBF.Ah() != null) {
                addLocateParam.setForumId(this.aBF.Ah().getForumId());
                addLocateParam.setForumName(this.aBF.Ah().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.aBF.zt() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.asl);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.x("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.x("obj_locate", this.mFrom);
            amVar2.x("obj_type", getThreadType());
            amVar2.ax("tid", this.aBF.getTid());
            TiebaStatic.log(amVar2);
            if (this.aEX != null) {
                this.aEX.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.aBF == null) {
            return 0;
        }
        if (this.aBF.isShareThread) {
            return 4;
        }
        if (this.aBF.getThreadType() == 49) {
            return 5;
        }
        if (this.aBF.yU() != null) {
            return 1;
        }
        if (this.aBF.getType() == bb.apG || this.aBF.getType() == bb.apI) {
            if (v.H(this.aBF.yR()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aBF != null || i >= 0) {
            am amVar = new am("c12003");
            amVar.ax("tid", this.aBF.getTid());
            if (this.aBF.getThreadType() == 40) {
                amVar.ax("obj_param1", "2");
            } else if (this.aBF.getThreadType() == 0) {
                amVar.ax("obj_param1", "1");
            }
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            amVar.h(ImageViewerConfig.FORUM_ID, this.aBF.getFid());
            amVar.x("obj_locate", this.mFrom);
            amVar.x(VideoPlayActivityConfig.OBJ_ID, i);
            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.ax("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
        }
    }

    protected void P(View view) {
        if (this.aBD != null) {
            addPraiseStats(this.aBD.L(view));
        }
    }

    protected void Q(View view) {
        if (this.aBE != null) {
            this.aBE.L(view);
        }
    }

    protected void O(View view) {
        if ((ax.jJ() || ba.bG(this.mContext)) && this.aBF != null) {
            Ek();
            El();
            if (this.aEX != null && this.aBF.yH()) {
                this.aEX.onClick(view);
            }
        }
    }

    private void Ek() {
        int i = 4;
        if (this.aBF != null) {
            if (this.aGb != 1) {
                if (this.aGb == 2) {
                    i = 5;
                } else if (this.aGb == 3) {
                    i = 3;
                } else if (this.aGb == 4) {
                    i = 2;
                } else if (this.aGb == 6) {
                    i = 8;
                } else if (this.aGb != 7) {
                    i = 0;
                } else {
                    i = 9;
                }
            }
            am amVar = new am("c12386");
            amVar.h(ImageViewerConfig.FORUM_ID, this.aBF.getFid());
            amVar.ax("tid", this.aBF.getTid());
            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.x("obj_locate", i);
            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void El() {
        if (this.aBF != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aBF.getFid());
            String yI = this.aBF.yI();
            if (this.aBF.asc != null) {
                valueOf = this.aBF.asc.id;
                yI = this.aBF.asc.ori_fname;
            }
            String title = this.aBF.getTitle();
            String tid = this.aBF.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aBF);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aBF.getAbstract();
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aOK = str2;
            dVar.linkUrl = str;
            dVar.ask = this.aGb;
            dVar.extData = tid;
            dVar.aON = 3;
            dVar.fid = valueOf;
            dVar.aOG = yI;
            dVar.tid = tid;
            dVar.aOC = true;
            dVar.aOM = getShareObjSource();
            dVar.aOO = c(this.aBF);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aBF);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aON);
            bundle.putInt("obj_type", dVar.aOO);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ask);
            dVar.i(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aBF.getThreadType() == 49 || this.aBF.getThreadType() == 60);
            com.baidu.tieba.c.e.apC().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.aGb == 1) {
            return 5;
        }
        if (this.aGb != 3) {
            if (this.aGb == 4) {
                return 4;
            }
            if (this.aGb != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.yN() == null) {
            return null;
        }
        ArrayList<MediaData> yN = bbVar.yN();
        int size = yN.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = yN.get(i);
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
            if (bbVar.yE()) {
                return 4;
            }
            if (bbVar.yz() == 1) {
                return 3;
            }
            return bbVar.zH() ? 2 : 1;
        }
        return 0;
    }

    private void T(View view) {
        if (this.aFM == null) {
            this.aFM = new ae(this.mPageContext, this.aGh);
        }
        this.aFM.setData(this.aBF);
        com.baidu.adp.lib.g.g.a(this.aFM, this.mPageContext);
        TiebaStatic.log(new am("c12711"));
    }

    private void U(View view) {
        En();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aFT = z;
        if (this.aFw != null) {
            this.aFw.setClickable(this.aFT);
        }
    }

    public boolean isMoreViewVisible() {
        return this.aFG != null && this.aFG.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.aFy != null) {
            this.aFy.setForumId(str);
        }
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aBF = bbVar;
        Em();
        d(bbVar);
        f(bbVar);
        g(bbVar);
        h(bbVar);
        updatePraiseNum(bbVar);
        e(bbVar);
        i(bbVar);
        setVisibility(this.aFQ ? 0 : 8);
        return this.aFQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Em() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(bb bbVar) {
        this.aFw.setVisibility(8);
    }

    protected void e(bb bbVar) {
        int aO;
        if (this.aFP != null && this.aFN != null && this.aFO != null && bbVar != null) {
            if (!this.aGh) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aFP.setVisibility(8);
            } else if (this.aGa && com.baidu.tieba.frs.a.ayk().ayl()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.j(this.mMaskView, e.d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.aFN.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.aFN.performClick();
                        }
                    });
                }
                if (bbVar.Ae()) {
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
                al.h(this.aFO, this.aBF.Ad() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
                this.aFN.setImageDrawable(al.getDrawable(bbVar.Ad() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.aFP.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aFP.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String G;
        if (this.aFx != null && bbVar != null) {
            if (bbVar.yv() <= 0 || !this.aFR) {
                this.aFx.setVisibility(8);
                return;
            }
            this.aFx.setVisibility(0);
            if (this.mFrom == 3) {
                G = ao.D(bbVar.yv());
            } else {
                G = ao.G(bbVar.yv() * 1000);
            }
            this.aFx.setText(G);
            this.aFQ = true;
        }
    }

    public boolean isVisible() {
        return this.aFQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bb bbVar) {
        if (this.aFz != null && bbVar != null) {
            if (this.aFW) {
                this.aFB.setVisibility(0);
                if (this.aFB.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFB.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aFB.setLayoutParams(layoutParams);
                }
                if (bbVar.yt() > 0) {
                    this.aFz.setVisibility(0);
                    String P = ao.P(bbVar.yt());
                    if (this.aFU) {
                        this.aFA.setImageDrawable(al.getDrawable(this.aGd));
                        this.aFz.setText(P);
                    } else {
                        this.aFz.setText(String.format(this.mContext.getString(e.j.reply_num_tip), P));
                    }
                    this.aFz.setContentDescription(this.mContext.getString(e.j.reply_num) + P);
                    this.aFQ = true;
                    return;
                } else if (this.aFU) {
                    this.aFA.setImageDrawable(al.getDrawable(this.aGd));
                    this.aFz.setText(this.mContext.getString(e.j.action_comment_default));
                    this.aFz.setVisibility(0);
                    this.aFQ = true;
                    return;
                } else {
                    this.aFz.setVisibility(8);
                    return;
                }
            }
            this.aFB.setVisibility(8);
        }
    }

    public void updatePraiseNum(bb bbVar) {
        if (this.aFy != null) {
            if (bbVar.getType() == bb.apP || bbVar.getType() == bb.apQ) {
                this.aFy.setDisPraiseFrom(5);
            }
            this.aFy.a(bbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bb bbVar) {
        if (this.aFE != null && this.aFC != null && bbVar != null) {
            if (this.aFY) {
                this.aFE.setVisibility(0);
                if (this.aFE.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFE.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aFE.setLayoutParams(layoutParams);
                }
                long zS = bbVar.zS();
                if ((bbVar.zG() || bbVar.zJ()) && bbVar.yW() != null) {
                    zS = bbVar.yW().share_info.share_count;
                }
                this.aFC.setText(zS > 0 ? ao.P(zS) : this.mContext.getString(e.j.share));
                this.aFQ = true;
                if (bbVar.arT != null && bbVar.arT.isDeleted) {
                    setShareClickable(false);
                    al.i(this.aFD, e.f.icon_card_share_d);
                    al.h(this.aFC, e.d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.i(this.aFD, this.aGe);
                al.h(this.aFC, e.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.aFE.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.aFG != null) {
            if (this.aBF == null || v.I(this.aBF.zD()) || !TbadkCoreApplication.isLogin() || this.aBF.zE()) {
                this.aFG.setVisibility(8);
                return;
            }
            if (this.aFG.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFG.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.aFG.setLayoutParams(layoutParams);
            }
            if (this.aFH == null) {
                this.aFH = new ArrayList();
            } else {
                this.aFH.clear();
            }
            if (this.aFI == null) {
                this.aFI = new ArrayList();
            } else {
                this.aFI.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aBF.zD()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aFH.add(reportInfo.info);
                    this.aFI.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aFG.setOnClickListener(this);
                this.aFG.setVisibility(0);
                return;
            }
            this.aFG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(bb bbVar) {
        if (this.aFL != null && bbVar != null) {
            if (bbVar.asc != null) {
                this.aFZ = false;
            }
            if (this.aFZ && (this.aFP == null || this.aFP.getVisibility() == 8)) {
                this.aFL.setVisibility(0);
                if (this.aFL.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aFL.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aFL.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(e.j.manage);
                this.aFJ.setText(string);
                this.aFJ.setContentDescription(string);
                this.aFQ = true;
                return;
            }
            this.aFL.setVisibility(8);
        }
    }

    private void En() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cQ(e.j.operation);
            bVar.a(this.aFH, new b.InterfaceC0148b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.d(ThreadCommentAndPraiseInfoLayout.this.aFI, i);
                    if (!StringUtils.isNull(str)) {
                        ay.Db().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AE();
        }
    }

    public void onChangeSkinType() {
        al.h(this.aFw, e.d.cp_cont_d);
        al.h(this.aFx, e.d.cp_cont_j);
        al.h(this.aFz, e.f.selector_comment_and_prise_item_text_color);
        al.h(this.aFJ, e.f.selector_comment_and_prise_item_text_color);
        al.i(this.aFF, e.f.btn_frs_more_selector);
        if (this.aFz != null && this.aFU && this.aGd > 0) {
            this.aFA.setImageDrawable(al.getDrawable(this.aGd));
        }
        if (this.aBF != null && this.aBF.arT != null && this.aBF.arT.isDeleted) {
            setShareClickable(false);
            al.i(this.aFD, e.f.icon_card_share_d);
            al.h(this.aFC, e.d.cp_cont_e);
        } else {
            setShareClickable(true);
            al.i(this.aFD, this.aGe);
            al.h(this.aFC, e.f.selector_comment_and_prise_item_text_color);
        }
        if (this.aFK != null) {
            this.aFK.setImageDrawable(al.getDrawable(e.f.icon_card_frs_manage_selector));
        }
        if (this.aFM != null) {
            this.aFM.onChangeSkinType();
        }
        if (this.aFy != null) {
            this.aFy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        al.j(this.mMaskView, e.d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aEX = onClickListener;
        if (this.aBD != null) {
            this.aBD.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.aFw;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.aFX = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aFR = z;
    }

    public View getCommentNumView() {
        return this.aFz;
    }

    public View getCommentContainer() {
        return this.aFB;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aFU = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.aFV = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.aGa = z;
    }

    public void setManageVisible(boolean z) {
        this.aFZ = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.aGf = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.aFN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.aGg;
    }

    public void setInFrsAllThread(boolean z) {
        this.aGh = z;
    }

    public boolean isInFrsAllThread() {
        return this.aGh;
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
        if (this.aFy != null) {
            this.aFy.onDestroy();
        }
    }
}
