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
    protected PraiseView aFd;
    protected DisPraiseView aFe;
    protected bb aFf;
    protected int aIV;
    protected TextView aIW;
    private TextView aIX;
    protected b aIY;
    protected TextView aIZ;
    private View.OnClickListener aIx;
    protected boolean aJA;
    private int aJB;
    private String aJC;
    protected int aJD;
    protected int aJE;
    private a aJF;
    private LinearLayout aJG;
    private boolean aJH;
    protected ImageView aJa;
    protected View aJb;
    protected TextView aJc;
    protected ImageView aJd;
    protected View aJe;
    protected TextView aJf;
    protected FrameLayout aJg;
    private List<CharSequence> aJh;
    private List<String> aJi;
    protected TextView aJj;
    protected ImageView aJk;
    protected View aJl;
    private ae aJm;
    protected ImageView aJn;
    protected TextView aJo;
    protected LinearLayout aJp;
    protected boolean aJq;
    private boolean aJr;
    protected boolean aJs;
    protected boolean aJt;
    protected boolean aJu;
    protected boolean aJv;
    protected boolean aJw;
    private boolean aJx;
    protected boolean aJy;
    protected boolean aJz;
    public int avL;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    private TbPageContext mPageContext;
    private String mStType;

    /* loaded from: classes6.dex */
    public interface a {
        void bJ(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.aJC = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.aIY != null) {
            this.aIY.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aIY != null) {
            this.aIY.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.aJB = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aIV = 0;
        this.aJq = false;
        this.aJr = true;
        this.aJs = true;
        this.aJt = true;
        this.aJu = false;
        this.aJv = false;
        this.aJw = true;
        this.aJx = false;
        this.aJy = true;
        this.aJz = false;
        this.aJA = true;
        this.mFrom = 2;
        this.aJB = 1;
        this.aJF = null;
        this.aJH = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIV = 0;
        this.aJq = false;
        this.aJr = true;
        this.aJs = true;
        this.aJt = true;
        this.aJu = false;
        this.aJv = false;
        this.aJw = true;
        this.aJx = false;
        this.aJy = true;
        this.aJz = false;
        this.aJA = true;
        this.mFrom = 2;
        this.aJB = 1;
        this.aJF = null;
        this.aJH = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aIV = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aIW = (TextView) inflate.findViewById(e.g.thread_info_bar_name);
        this.aIX = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aJG = (LinearLayout) inflate.findViewById(e.g.thread_comment_layout_root);
        this.aIZ = (TextView) inflate.findViewById(e.g.thread_info_commont_num);
        this.aJa = (ImageView) inflate.findViewById(e.g.thread_info_commont_img);
        this.aJb = inflate.findViewById(e.g.thread_info_commont_container);
        this.aJc = (TextView) inflate.findViewById(e.g.share_num);
        this.aJd = (ImageView) inflate.findViewById(e.g.share_num_img);
        this.aJe = inflate.findViewById(e.g.share_num_container);
        this.aJf = (TextView) inflate.findViewById(e.g.thread_info_more);
        this.aJg = (FrameLayout) inflate.findViewById(e.g.thread_info_more_frame);
        this.aFd = (PraiseView) inflate.findViewById(e.g.agree_view);
        this.aFe = (DisPraiseView) inflate.findViewById(e.g.disagree_view);
        this.aIY = new b(this.aFd, this.aFe);
        this.aJl = inflate.findViewById(e.g.manage_view_container);
        this.aJj = (TextView) inflate.findViewById(e.g.thread_info_manage_text);
        this.aJk = (ImageView) inflate.findViewById(e.g.thread_info_manage_img);
        this.aJn = (ImageView) inflate.findViewById(e.g.manage_select_img);
        this.aJo = (TextView) inflate.findViewById(e.g.manage_select_text);
        this.aJp = (LinearLayout) inflate.findViewById(e.g.manage_select_container);
        this.aJp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.aJn.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.aJo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aJn.performClick();
            }
        });
        this.aJp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aJn.performClick();
            }
        });
        this.aFd.setOnClickListener(this);
        this.aFe.setOnClickListener(this);
        this.aJb.setOnClickListener(this);
        this.aJe.setOnClickListener(this);
        this.aJl.setOnClickListener(this);
        this.aJn.setOnClickListener(this);
        this.aJE = e.f.icon_home_card_share;
        this.aJD = e.f.icon_home_card_comment;
        this.aIY.EF();
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            this.aIY.h(getPageUniqueId());
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                this.aIY.h(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                return;
            }
            this.aIY.h(getPageUniqueId());
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
        if (view == this.aIW) {
            S(view);
        } else if (view == this.aJb) {
            N(view);
        } else if (view == this.aJe) {
            O(view);
        } else if (view == this.aFd) {
            P(view);
        } else if (view == this.aFe) {
            Q(view);
        } else if (view == this.aJg) {
            U(view);
        } else if (view == this.aJl) {
            T(view);
        } else if (view == this.aJn) {
            R(view);
        }
    }

    protected void R(View view) {
        if (this.aJn != null && this.aFf != null && this.aJo != null && !this.aFf.Bi()) {
            if (!this.aFf.Bh()) {
                if (com.baidu.tieba.frs.a.azU().V(this.aFf)) {
                    this.aFf.bd(true);
                }
            } else {
                com.baidu.tieba.frs.a.azU().W(this.aFf);
                this.aFf.bd(false);
            }
            al.h(this.aJo, this.aFf.Bh() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
            this.aJn.setImageDrawable(al.getDrawable(this.aFf.Bh() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
            if (this.aJF != null) {
                this.aJF.bJ(this.aFf.Bh());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aJm != null) {
            this.aJm.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.aJb != null) {
            this.aJb.setClickable(z);
            this.aJa.setEnabled(z);
            this.aIZ.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.aIY != null) {
            this.aIY.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.aJe != null) {
            this.aJe.setClickable(z);
            this.aJd.setEnabled(z);
            this.aJc.setEnabled(z);
        }
    }

    private void S(View view) {
        if (this.aFf != null && !StringUtils.isNull(this.aFf.zM())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aJC)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.aFf.zM(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aFf.zM(), this.mStType, this.aJC)));
            }
            if (this.aIx != null) {
                this.aIx.onClick(view);
            }
        }
    }

    protected void N(View view) {
        if (this.aFf != null && this.mContext != null) {
            com.baidu.tieba.card.o.mD(this.aFf.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aFf, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aFf.getFid()));
            addLocateParam.setForumName(this.aFf.zM());
            if (this.aFf.Bm() && this.aFf.Bl() != null) {
                addLocateParam.setForumId(this.aFf.Bl().getForumId());
                addLocateParam.setForumName(this.aFf.Bl().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.aFf.Ax() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.avL);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.x("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.x("obj_locate", this.mFrom);
            amVar2.x("obj_type", getThreadType());
            amVar2.aA("tid", this.aFf.getTid());
            TiebaStatic.log(amVar2);
            if (this.aIx != null) {
                this.aIx.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.aFf == null) {
            return 0;
        }
        if (this.aFf.isShareThread) {
            return 4;
        }
        if (this.aFf.getThreadType() == 49) {
            return 5;
        }
        if (this.aFf.zY() != null) {
            return 1;
        }
        if (this.aFf.getType() == bb.atg || this.aFf.getType() == bb.ati) {
            if (v.H(this.aFf.zV()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aFf != null || i >= 0) {
            am amVar = new am("c12003");
            amVar.aA("tid", this.aFf.getTid());
            if (this.aFf.getThreadType() == 40) {
                amVar.aA("obj_param1", "2");
            } else if (this.aFf.getThreadType() == 0) {
                amVar.aA("obj_param1", "1");
            }
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            amVar.i(ImageViewerConfig.FORUM_ID, this.aFf.getFid());
            amVar.x("obj_locate", this.mFrom);
            amVar.x(VideoPlayActivityConfig.OBJ_ID, i);
            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.aA("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
        }
    }

    protected void P(View view) {
        if (this.aFd != null) {
            addPraiseStats(this.aFd.L(view));
        }
    }

    protected void Q(View view) {
        if (this.aFe != null) {
            this.aFe.L(view);
        }
    }

    protected void O(View view) {
        if ((ax.jJ() || ba.bJ(this.mContext)) && this.aFf != null) {
            Fo();
            Fp();
            if (this.aIx != null && this.aFf.zL()) {
                this.aIx.onClick(view);
            }
        }
    }

    private void Fo() {
        int i = 4;
        if (this.aFf != null) {
            if (this.aJB != 1) {
                if (this.aJB == 2) {
                    i = 5;
                } else if (this.aJB == 3) {
                    i = 3;
                } else if (this.aJB == 4) {
                    i = 2;
                } else if (this.aJB == 6) {
                    i = 8;
                } else if (this.aJB != 7) {
                    i = 0;
                } else {
                    i = 9;
                }
            }
            am amVar = new am("c12386");
            amVar.i(ImageViewerConfig.FORUM_ID, this.aFf.getFid());
            amVar.aA("tid", this.aFf.getTid());
            amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.x("obj_locate", i);
            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void Fp() {
        if (this.aFf != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aFf.getFid());
            String zM = this.aFf.zM();
            if (this.aFf.avC != null) {
                valueOf = this.aFf.avC.id;
                zM = this.aFf.avC.ori_fname;
            }
            String title = this.aFf.getTitle();
            String tid = this.aFf.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aFf);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aFf.getAbstract();
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aSj = str2;
            dVar.linkUrl = str;
            dVar.avK = this.aJB;
            dVar.extData = tid;
            dVar.aSm = 3;
            dVar.fid = valueOf;
            dVar.aSf = zM;
            dVar.tid = tid;
            dVar.aSb = true;
            dVar.aSl = getShareObjSource();
            dVar.aSn = c(this.aFf);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aFf);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSm);
            bundle.putInt("obj_type", dVar.aSn);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.avK);
            dVar.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aFf.getThreadType() == 49 || this.aFf.getThreadType() == 60);
            com.baidu.tieba.c.e.aro().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.aJB == 1) {
            return 5;
        }
        if (this.aJB != 3) {
            if (this.aJB == 4) {
                return 4;
            }
            if (this.aJB != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.zR() == null) {
            return null;
        }
        ArrayList<MediaData> zR = bbVar.zR();
        int size = zR.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = zR.get(i);
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
            if (bbVar.zI()) {
                return 4;
            }
            if (bbVar.zD() == 1) {
                return 3;
            }
            return bbVar.AL() ? 2 : 1;
        }
        return 0;
    }

    private void T(View view) {
        if (this.aJm == null) {
            this.aJm = new ae(this.mPageContext, this.aJH);
        }
        this.aJm.setData(this.aFf);
        com.baidu.adp.lib.g.g.a(this.aJm, this.mPageContext);
        TiebaStatic.log(new am("c12711"));
    }

    private void U(View view) {
        Fr();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aJt = z;
        if (this.aIW != null) {
            this.aIW.setClickable(this.aJt);
        }
    }

    public boolean isMoreViewVisible() {
        return this.aJg != null && this.aJg.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.aIY != null) {
            this.aIY.setForumId(str);
        }
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFf = bbVar;
        Fq();
        d(bbVar);
        f(bbVar);
        g(bbVar);
        h(bbVar);
        updatePraiseNum(bbVar);
        e(bbVar);
        i(bbVar);
        setVisibility(this.aJq ? 0 : 8);
        return this.aJq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fq() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(bb bbVar) {
        this.aIW.setVisibility(8);
    }

    protected void e(bb bbVar) {
        int aO;
        if (this.aJp != null && this.aJn != null && this.aJo != null && bbVar != null) {
            if (!this.aJH) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aJp.setVisibility(8);
            } else if (this.aJA && com.baidu.tieba.frs.a.azU().azV()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.j(this.mMaskView, e.d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.aJn.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.aJn.performClick();
                        }
                    });
                }
                if (bbVar.Bi()) {
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
                al.h(this.aJo, this.aFf.Bh() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
                this.aJn.setImageDrawable(al.getDrawable(bbVar.Bh() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.aJp.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aJp.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String N;
        if (this.aIX != null && bbVar != null) {
            if (bbVar.zz() <= 0 || !this.aJr) {
                this.aIX.setVisibility(8);
                return;
            }
            this.aIX.setVisibility(0);
            if (this.mFrom == 3) {
                N = ao.K(bbVar.zz());
            } else {
                N = ao.N(bbVar.zz() * 1000);
            }
            this.aIX.setText(N);
            this.aJq = true;
        }
    }

    public boolean isVisible() {
        return this.aJq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bb bbVar) {
        if (this.aIZ != null && bbVar != null) {
            if (this.aJw) {
                this.aJb.setVisibility(0);
                if (this.aJb.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJb.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJb.setLayoutParams(layoutParams);
                }
                if (bbVar.zx() > 0) {
                    this.aIZ.setVisibility(0);
                    String W = ao.W(bbVar.zx());
                    if (this.aJu) {
                        this.aJa.setImageDrawable(al.getDrawable(this.aJD));
                        this.aIZ.setText(W);
                    } else {
                        this.aIZ.setText(String.format(this.mContext.getString(e.j.reply_num_tip), W));
                    }
                    this.aIZ.setContentDescription(this.mContext.getString(e.j.reply_num) + W);
                    this.aJq = true;
                    return;
                } else if (this.aJu) {
                    this.aJa.setImageDrawable(al.getDrawable(this.aJD));
                    this.aIZ.setText(this.mContext.getString(e.j.action_comment_default));
                    this.aIZ.setVisibility(0);
                    this.aJq = true;
                    return;
                } else {
                    this.aIZ.setVisibility(8);
                    return;
                }
            }
            this.aJb.setVisibility(8);
        }
    }

    public void updatePraiseNum(bb bbVar) {
        if (this.aIY != null) {
            if (bbVar.getType() == bb.atp || bbVar.getType() == bb.atq) {
                this.aIY.setDisPraiseFrom(5);
            }
            this.aIY.a(bbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bb bbVar) {
        if (this.aJe != null && this.aJc != null && bbVar != null) {
            if (this.aJy) {
                this.aJe.setVisibility(0);
                if (this.aJe.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJe.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJe.setLayoutParams(layoutParams);
                }
                long AW = bbVar.AW();
                if ((bbVar.AK() || bbVar.AN()) && bbVar.Aa() != null) {
                    AW = bbVar.Aa().share_info.share_count;
                }
                this.aJc.setText(AW > 0 ? ao.W(AW) : this.mContext.getString(e.j.share));
                this.aJq = true;
                if (bbVar.avt != null && bbVar.avt.isDeleted) {
                    setShareClickable(false);
                    al.i(this.aJd, e.f.icon_card_share_d);
                    al.h(this.aJc, e.d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.i(this.aJd, this.aJE);
                al.h(this.aJc, e.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.aJe.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.aJg != null) {
            if (this.aFf == null || v.I(this.aFf.AH()) || !TbadkCoreApplication.isLogin() || this.aFf.AI()) {
                this.aJg.setVisibility(8);
                return;
            }
            if (this.aJg.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJg.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.aJg.setLayoutParams(layoutParams);
            }
            if (this.aJh == null) {
                this.aJh = new ArrayList();
            } else {
                this.aJh.clear();
            }
            if (this.aJi == null) {
                this.aJi = new ArrayList();
            } else {
                this.aJi.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aFf.AH()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aJh.add(reportInfo.info);
                    this.aJi.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aJg.setOnClickListener(this);
                this.aJg.setVisibility(0);
                return;
            }
            this.aJg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(bb bbVar) {
        if (this.aJl != null && bbVar != null) {
            if (bbVar.avC != null) {
                this.aJz = false;
            }
            if (this.aJz && (this.aJp == null || this.aJp.getVisibility() == 8)) {
                this.aJl.setVisibility(0);
                if (this.aJl.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJl.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJl.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(e.j.manage);
                this.aJj.setText(string);
                this.aJj.setContentDescription(string);
                this.aJq = true;
                return;
            }
            this.aJl.setVisibility(8);
        }
    }

    private void Fr() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.de(e.j.operation);
            bVar.a(this.aJh, new b.InterfaceC0158b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.d(ThreadCommentAndPraiseInfoLayout.this.aJi, i);
                    if (!StringUtils.isNull(str)) {
                        ay.Ef().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.BI();
        }
    }

    public void onChangeSkinType() {
        al.h(this.aIW, e.d.cp_cont_d);
        al.h(this.aIX, e.d.cp_cont_j);
        al.h(this.aIZ, e.f.selector_comment_and_prise_item_text_color);
        al.h(this.aJj, e.f.selector_comment_and_prise_item_text_color);
        al.i(this.aJf, e.f.btn_frs_more_selector);
        if (this.aIZ != null && this.aJu && this.aJD > 0) {
            this.aJa.setImageDrawable(al.getDrawable(this.aJD));
        }
        if (this.aFf != null && this.aFf.avt != null && this.aFf.avt.isDeleted) {
            setShareClickable(false);
            al.i(this.aJd, e.f.icon_card_share_d);
            al.h(this.aJc, e.d.cp_cont_e);
        } else {
            setShareClickable(true);
            al.i(this.aJd, this.aJE);
            al.h(this.aJc, e.f.selector_comment_and_prise_item_text_color);
        }
        if (this.aJk != null) {
            this.aJk.setImageDrawable(al.getDrawable(e.f.icon_card_frs_manage_selector));
        }
        if (this.aJm != null) {
            this.aJm.onChangeSkinType();
        }
        if (this.aIY != null) {
            this.aIY.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        al.j(this.mMaskView, e.d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aIx = onClickListener;
        if (this.aFd != null) {
            this.aFd.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.aIW;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.aJx = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aJr = z;
    }

    public View getCommentNumView() {
        return this.aIZ;
    }

    public View getCommentContainer() {
        return this.aJb;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aJu = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.aJv = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.aJA = z;
    }

    public void setManageVisible(boolean z) {
        this.aJz = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.aJF = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.aJn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.aJG;
    }

    public void setInFrsAllThread(boolean z) {
        this.aJH = z;
    }

    public boolean isInFrsAllThread() {
        return this.aJH;
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
        if (this.aIY != null) {
            this.aIY.onDestroy();
        }
    }
}
