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
import com.baidu.tbadk.p.aw;
import com.baidu.tieba.card.ae;
import com.baidu.tieba.e;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected boolean aAA;
    protected boolean aAB;
    protected boolean aAC;
    private int aAD;
    private String aAE;
    protected int aAF;
    protected int aAG;
    private View aAH;
    private a aAI;
    private LinearLayout aAJ;
    private boolean aAK;
    protected b aAa;
    protected TextView aAb;
    protected ImageView aAc;
    protected View aAd;
    protected TextView aAe;
    protected ImageView aAf;
    protected View aAg;
    protected TextView aAh;
    protected FrameLayout aAi;
    private List<CharSequence> aAj;
    private List<String> aAk;
    protected TextView aAl;
    protected ImageView aAm;
    protected View aAn;
    private ae aAo;
    protected ImageView aAp;
    protected TextView aAq;
    protected LinearLayout aAr;
    protected boolean aAs;
    private boolean aAt;
    protected boolean aAu;
    protected boolean aAv;
    protected boolean aAw;
    protected boolean aAx;
    protected boolean aAy;
    private boolean aAz;
    public int amD;
    protected PraiseView awd;
    protected DisPraiseView awe;
    protected bb awf;
    protected int azX;
    protected TextView azY;
    private TextView azZ;
    private View.OnClickListener azz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    /* loaded from: classes2.dex */
    public interface a {
        void bh(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.aAE = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.aAa != null) {
            this.aAa.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aAa != null) {
            this.aAa.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.aAD = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.azX = 0;
        this.aAs = false;
        this.aAt = true;
        this.aAu = true;
        this.aAv = true;
        this.aAw = false;
        this.aAx = false;
        this.aAy = true;
        this.aAz = false;
        this.aAA = true;
        this.aAB = false;
        this.aAC = true;
        this.mFrom = 2;
        this.aAD = 1;
        this.aAI = null;
        this.aAK = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azX = 0;
        this.aAs = false;
        this.aAt = true;
        this.aAu = true;
        this.aAv = true;
        this.aAw = false;
        this.aAx = false;
        this.aAy = true;
        this.aAz = false;
        this.aAA = true;
        this.aAB = false;
        this.aAC = true;
        this.mFrom = 2;
        this.aAD = 1;
        this.aAI = null;
        this.aAK = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.azX = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.azY = (TextView) inflate.findViewById(e.g.thread_info_bar_name);
        this.azZ = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aAJ = (LinearLayout) inflate.findViewById(e.g.thread_comment_layout_root);
        this.aAb = (TextView) inflate.findViewById(e.g.thread_info_commont_num);
        this.aAc = (ImageView) inflate.findViewById(e.g.thread_info_commont_img);
        this.aAd = inflate.findViewById(e.g.thread_info_commont_container);
        this.aAe = (TextView) inflate.findViewById(e.g.share_num);
        this.aAf = (ImageView) inflate.findViewById(e.g.share_num_img);
        this.aAg = inflate.findViewById(e.g.share_num_container);
        this.aAh = (TextView) inflate.findViewById(e.g.thread_info_more);
        this.aAi = (FrameLayout) inflate.findViewById(e.g.thread_info_more_frame);
        this.awd = (PraiseView) inflate.findViewById(e.g.agree_view);
        this.awe = (DisPraiseView) inflate.findViewById(e.g.disagree_view);
        this.aAa = new b(this.awd, this.awe);
        this.aAn = inflate.findViewById(e.g.manage_view_container);
        this.aAl = (TextView) inflate.findViewById(e.g.thread_info_manage_text);
        this.aAm = (ImageView) inflate.findViewById(e.g.thread_info_manage_img);
        this.aAp = (ImageView) inflate.findViewById(e.g.manage_select_img);
        this.aAq = (TextView) inflate.findViewById(e.g.manage_select_text);
        this.aAr = (LinearLayout) inflate.findViewById(e.g.manage_select_container);
        this.aAr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.aAp.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.aAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aAp.performClick();
            }
        });
        this.aAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aAp.performClick();
            }
        });
        this.awd.setOnClickListener(this);
        this.awe.setOnClickListener(this);
        this.aAd.setOnClickListener(this);
        this.aAg.setOnClickListener(this);
        this.aAn.setOnClickListener(this);
        this.aAp.setOnClickListener(this);
        this.aAG = e.f.icon_home_card_share;
        this.aAF = e.f.icon_home_card_comment;
        this.aAa.Bn();
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            this.aAa.h(getPageUniqueId());
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                this.aAa.h(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                return;
            }
            this.aAa.h(getPageUniqueId());
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
        if (view == this.azY) {
            S(view);
        } else if (view == this.aAd) {
            N(view);
        } else if (view == this.aAg) {
            O(view);
        } else if (view == this.awd) {
            P(view);
        } else if (view == this.awe) {
            Q(view);
        } else if (view == this.aAi) {
            U(view);
        } else if (view == this.aAn) {
            T(view);
        } else if (view == this.aAp) {
            R(view);
        }
    }

    protected void R(View view) {
        if (this.aAp != null && this.awf != null && this.aAq != null && !this.awf.xO()) {
            if (!this.awf.xN()) {
                if (com.baidu.tieba.frs.a.avq().V(this.awf)) {
                    this.awf.aC(true);
                }
            } else {
                com.baidu.tieba.frs.a.avq().W(this.awf);
                this.awf.aC(false);
            }
            al.h(this.aAq, this.awf.xN() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
            this.aAp.setImageDrawable(al.getDrawable(this.awf.xN() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
            if (this.aAI != null) {
                this.aAI.bh(this.awf.xN());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aAo != null) {
            this.aAo.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.aAd != null) {
            this.aAd.setClickable(z);
            this.aAc.setEnabled(z);
            this.aAb.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.aAa != null) {
            this.aAa.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.aAg != null) {
            this.aAg.setClickable(z);
            this.aAf.setEnabled(z);
            this.aAe.setEnabled(z);
        }
    }

    private void S(View view) {
        if (this.awf != null && !StringUtils.isNull(this.awf.ws())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aAE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.awf.ws(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.awf.ws(), this.mStType, this.aAE)));
            }
            if (this.azz != null) {
                this.azz.onClick(view);
            }
        }
    }

    protected void N(View view) {
        if (this.awf != null && this.mContext != null) {
            com.baidu.tieba.card.o.lA(this.awf.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.awf, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.awf.getFid()));
            addLocateParam.setForumName(this.awf.ws());
            if (this.awf.xS() && this.awf.xR() != null) {
                addLocateParam.setForumId(this.awf.xR().getForumId());
                addLocateParam.setForumName(this.awf.xR().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.awf.xd() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.amD);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.w("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.w("obj_locate", this.mFrom);
            amVar2.w("obj_type", getThreadType());
            amVar2.al("tid", this.awf.getTid());
            TiebaStatic.log(amVar2);
            if (this.azz != null) {
                this.azz.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.awf == null) {
            return 0;
        }
        if (this.awf.isShareThread) {
            return 4;
        }
        if (this.awf.getThreadType() == 49) {
            return 5;
        }
        if (this.awf.wE() != null) {
            return 1;
        }
        if (this.awf.getType() == bb.ajX || this.awf.getType() == bb.ajZ) {
            if (v.y(this.awf.wB()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.awf != null || i >= 0) {
            am amVar = new am("c12003");
            amVar.al("tid", this.awf.getTid());
            if (this.awf.getThreadType() == 40) {
                amVar.al("obj_param1", "2");
            } else if (this.awf.getThreadType() == 0) {
                amVar.al("obj_param1", "1");
            }
            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            amVar.g(ImageViewerConfig.FORUM_ID, this.awf.getFid());
            amVar.w("obj_locate", this.mFrom);
            amVar.w(VideoPlayActivityConfig.OBJ_ID, i);
            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.al("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
        }
    }

    protected void P(View view) {
        if (this.awd != null) {
            addPraiseStats(this.awd.L(view));
        }
    }

    protected void Q(View view) {
        if (this.awe != null) {
            this.awe.L(view);
        }
    }

    protected void O(View view) {
        if ((aw.jw() || ba.bA(this.mContext)) && this.awf != null) {
            BV();
            BW();
            if (this.azz != null && this.awf.wr()) {
                this.azz.onClick(view);
            }
        }
    }

    private void BV() {
        int i = 4;
        if (this.awf != null) {
            if (this.aAD != 1) {
                if (this.aAD == 2) {
                    i = 5;
                } else if (this.aAD == 3) {
                    i = 3;
                } else if (this.aAD == 4) {
                    i = 2;
                } else if (this.aAD == 6) {
                    i = 8;
                } else if (this.aAD != 7) {
                    i = 0;
                } else {
                    i = 9;
                }
            }
            am amVar = new am("c12386");
            amVar.g(ImageViewerConfig.FORUM_ID, this.awf.getFid());
            amVar.al("tid", this.awf.getTid());
            amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.w("obj_locate", i);
            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void BW() {
        if (this.awf != null && this.mContext != null) {
            String valueOf = String.valueOf(this.awf.getFid());
            String ws = this.awf.ws();
            if (this.awf.amu != null) {
                valueOf = this.awf.amu.id;
                ws = this.awf.amu.ori_fname;
            }
            String title = this.awf.getTitle();
            String tid = this.awf.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.awf);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.awf.getAbstract();
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aJs = str2;
            dVar.linkUrl = str;
            dVar.amC = this.aAD;
            dVar.extData = tid;
            dVar.aJv = 3;
            dVar.fid = valueOf;
            dVar.aJo = ws;
            dVar.tid = tid;
            dVar.aJk = true;
            dVar.aJu = getShareObjSource();
            dVar.aJw = c(this.awf);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.awf);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aJv);
            bundle.putInt("obj_type", dVar.aJw);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.amC);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.awf.getThreadType() == 49 || this.awf.getThreadType() == 60);
            com.baidu.tieba.c.e.amB().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.aAD == 1) {
            return 5;
        }
        if (this.aAD != 3) {
            if (this.aAD == 4) {
                return 4;
            }
            if (this.aAD != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.wx() == null) {
            return null;
        }
        ArrayList<MediaData> wx = bbVar.wx();
        int size = wx.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = wx.get(i);
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
            if (bbVar.wo()) {
                return 4;
            }
            if (bbVar.wj() == 1) {
                return 3;
            }
            return bbVar.xr() ? 2 : 1;
        }
        return 0;
    }

    private void T(View view) {
        if (this.aAo == null) {
            this.aAo = new ae(this.mPageContext, this.aAK);
        }
        this.aAo.setData(this.awf);
        com.baidu.adp.lib.g.g.a(this.aAo, this.mPageContext);
        TiebaStatic.log(new am("c12711"));
    }

    private void U(View view) {
        BY();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aAv = z;
        if (this.azY != null) {
            this.azY.setClickable(this.aAv);
        }
    }

    public boolean isMoreViewVisible() {
        return this.aAi != null && this.aAi.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.aAa != null) {
            this.aAa.setForumId(str);
        }
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.awf = bbVar;
        BX();
        d(bbVar);
        f(bbVar);
        g(bbVar);
        h(bbVar);
        updatePraiseNum(bbVar);
        e(bbVar);
        i(bbVar);
        setVisibility(this.aAs ? 0 : 8);
        return this.aAs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BX() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(bb bbVar) {
        this.azY.setVisibility(8);
    }

    protected void e(bb bbVar) {
        int aO;
        if (this.aAr != null && this.aAp != null && this.aAq != null && bbVar != null) {
            if (!this.aAK) {
                if (this.aAH != null) {
                    this.aAH.setVisibility(8);
                }
                this.aAr.setVisibility(8);
            } else if (this.aAC && com.baidu.tieba.frs.a.avq().avr()) {
                if (this.aAH == null) {
                    this.aAH = new View(getContext());
                    al.j(this.aAH, e.d.cp_bg_line_d);
                    addView(this.aAH);
                    this.aAH.setAlpha(0.5f);
                    this.aAH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.aAp.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.aAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.aAp.performClick();
                        }
                    });
                }
                if (bbVar.xO()) {
                    aO = com.baidu.adp.lib.util.l.aO(getContext());
                } else {
                    aO = (com.baidu.adp.lib.util.l.aO(getContext()) / 4) * 3;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aAH.getLayoutParams();
                if (layoutParams == null) {
                    this.aAH.setLayoutParams(new FrameLayout.LayoutParams(aO, -1));
                } else {
                    layoutParams.width = aO;
                    requestLayout();
                }
                al.h(this.aAq, this.awf.xN() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
                this.aAp.setImageDrawable(al.getDrawable(bbVar.xN() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
                this.aAH.setVisibility(0);
                this.aAr.setVisibility(0);
            } else {
                if (this.aAH != null) {
                    this.aAH.setVisibility(8);
                }
                this.aAr.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String C;
        if (this.azZ != null && bbVar != null) {
            if (bbVar.wf() <= 0 || !this.aAt) {
                this.azZ.setVisibility(8);
                return;
            }
            this.azZ.setVisibility(0);
            if (this.mFrom == 3) {
                C = ao.z(bbVar.wf());
            } else {
                C = ao.C(bbVar.wf() * 1000);
            }
            this.azZ.setText(C);
            this.aAs = true;
        }
    }

    public boolean isVisible() {
        return this.aAs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bb bbVar) {
        if (this.aAb != null && bbVar != null) {
            if (this.aAy) {
                this.aAd.setVisibility(0);
                if (this.aAd.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAd.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aAd.setLayoutParams(layoutParams);
                }
                if (bbVar.wd() > 0) {
                    this.aAb.setVisibility(0);
                    String L = ao.L(bbVar.wd());
                    if (this.aAw) {
                        this.aAc.setImageDrawable(al.getDrawable(this.aAF));
                        this.aAb.setText(L);
                    } else {
                        this.aAb.setText(String.format(this.mContext.getString(e.j.reply_num_tip), L));
                    }
                    this.aAb.setContentDescription(this.mContext.getString(e.j.reply_num) + L);
                    this.aAs = true;
                    return;
                } else if (this.aAw) {
                    this.aAc.setImageDrawable(al.getDrawable(this.aAF));
                    this.aAb.setText(this.mContext.getString(e.j.action_comment_default));
                    this.aAb.setVisibility(0);
                    this.aAs = true;
                    return;
                } else {
                    this.aAb.setVisibility(8);
                    return;
                }
            }
            this.aAd.setVisibility(8);
        }
    }

    public void updatePraiseNum(bb bbVar) {
        if (this.aAa != null) {
            if (bbVar.getType() == bb.akg || bbVar.getType() == bb.akh) {
                this.aAa.setDisPraiseFrom(5);
            }
            this.aAa.a(bbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bb bbVar) {
        if (this.aAg != null && this.aAe != null && bbVar != null) {
            if (this.aAA) {
                this.aAg.setVisibility(0);
                if (this.aAg.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAg.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aAg.setLayoutParams(layoutParams);
                }
                long xC = bbVar.xC();
                if ((bbVar.xq() || bbVar.xt()) && bbVar.wG() != null) {
                    xC = bbVar.wG().share_info.share_count;
                }
                this.aAe.setText(xC > 0 ? ao.L(xC) : this.mContext.getString(e.j.share));
                this.aAs = true;
                if (bbVar.aml != null && bbVar.aml.isDeleted) {
                    setShareClickable(false);
                    al.i(this.aAf, e.f.icon_card_share_d);
                    al.h(this.aAe, e.d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.i(this.aAf, this.aAG);
                al.h(this.aAe, e.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.aAg.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.aAi != null) {
            if (this.awf == null || v.z(this.awf.xn()) || !TbadkCoreApplication.isLogin() || this.awf.xo()) {
                this.aAi.setVisibility(8);
                return;
            }
            if (this.aAi.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAi.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.aAi.setLayoutParams(layoutParams);
            }
            if (this.aAj == null) {
                this.aAj = new ArrayList();
            } else {
                this.aAj.clear();
            }
            if (this.aAk == null) {
                this.aAk = new ArrayList();
            } else {
                this.aAk.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.awf.xn()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aAj.add(reportInfo.info);
                    this.aAk.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aAi.setOnClickListener(this);
                this.aAi.setVisibility(0);
                return;
            }
            this.aAi.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(bb bbVar) {
        if (this.aAn != null && bbVar != null) {
            if (bbVar.amu != null) {
                this.aAB = false;
            }
            if (this.aAB && (this.aAr == null || this.aAr.getVisibility() == 8)) {
                this.aAn.setVisibility(0);
                if (this.aAn.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAn.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aAn.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(e.j.manage);
                this.aAl.setText(string);
                this.aAl.setContentDescription(string);
                this.aAs = true;
                return;
            }
            this.aAn.setVisibility(8);
        }
    }

    private void BY() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cs(e.j.operation);
            bVar.a(this.aAj, new b.InterfaceC0100b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.d(ThreadCommentAndPraiseInfoLayout.this.aAk, i);
                    if (!StringUtils.isNull(str)) {
                        ay.AN().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.yo();
        }
    }

    public void onChangeSkinType() {
        al.h(this.azY, e.d.cp_cont_d);
        al.h(this.azZ, e.d.cp_cont_j);
        al.h(this.aAb, e.f.selector_comment_and_prise_item_text_color);
        al.h(this.aAl, e.f.selector_comment_and_prise_item_text_color);
        al.i(this.aAh, e.f.btn_frs_more_selector);
        if (this.aAb != null && this.aAw && this.aAF > 0) {
            this.aAc.setImageDrawable(al.getDrawable(this.aAF));
        }
        if (this.awf != null && this.awf.aml != null && this.awf.aml.isDeleted) {
            setShareClickable(false);
            al.i(this.aAf, e.f.icon_card_share_d);
            al.h(this.aAe, e.d.cp_cont_e);
        } else {
            setShareClickable(true);
            al.i(this.aAf, this.aAG);
            al.h(this.aAe, e.f.selector_comment_and_prise_item_text_color);
        }
        if (this.aAm != null) {
            this.aAm.setImageDrawable(al.getDrawable(e.f.icon_card_frs_manage_selector));
        }
        if (this.aAo != null) {
            this.aAo.onChangeSkinType();
        }
        if (this.aAa != null) {
            this.aAa.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        al.j(this.aAH, e.d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.azz = onClickListener;
        if (this.awd != null) {
            this.awd.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.azY;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.aAz = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aAt = z;
    }

    public View getCommentNumView() {
        return this.aAb;
    }

    public View getCommentContainer() {
        return this.aAd;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aAw = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.aAx = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.aAC = z;
    }

    public void setManageVisible(boolean z) {
        this.aAB = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.aAI = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.aAp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.aAJ;
    }

    public void setInFrsAllThread(boolean z) {
        this.aAK = z;
    }

    public boolean isInFrsAllThread() {
        return this.aAK;
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
        if (this.aAa != null) {
            this.aAa.onDestroy();
        }
    }
}
