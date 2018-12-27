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
    protected PraiseView aFe;
    protected DisPraiseView aFf;
    protected bb aFg;
    protected int aIW;
    protected TextView aIX;
    private TextView aIY;
    protected b aIZ;
    private View.OnClickListener aIy;
    protected boolean aJA;
    protected boolean aJB;
    private int aJC;
    public String aJD;
    private String aJE;
    protected int aJF;
    protected int aJG;
    private a aJH;
    private LinearLayout aJI;
    private boolean aJJ;
    protected TextView aJa;
    protected ImageView aJb;
    protected View aJc;
    protected TextView aJd;
    protected ImageView aJe;
    protected View aJf;
    protected TextView aJg;
    protected FrameLayout aJh;
    private List<CharSequence> aJi;
    private List<String> aJj;
    protected TextView aJk;
    protected ImageView aJl;
    protected View aJm;
    private ae aJn;
    protected ImageView aJo;
    protected TextView aJp;
    protected LinearLayout aJq;
    protected boolean aJr;
    private boolean aJs;
    protected boolean aJt;
    protected boolean aJu;
    protected boolean aJv;
    protected boolean aJw;
    protected boolean aJx;
    private boolean aJy;
    protected boolean aJz;
    public int avM;
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
        this.aJE = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.aIZ != null) {
            this.aIZ.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aIZ != null) {
            this.aIZ.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.aJC = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aIW = 0;
        this.aJr = false;
        this.aJs = true;
        this.aJt = true;
        this.aJu = true;
        this.aJv = false;
        this.aJw = false;
        this.aJx = true;
        this.aJy = false;
        this.aJz = true;
        this.aJA = false;
        this.aJB = true;
        this.mFrom = 2;
        this.aJC = 1;
        this.aJH = null;
        this.aJJ = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIW = 0;
        this.aJr = false;
        this.aJs = true;
        this.aJt = true;
        this.aJu = true;
        this.aJv = false;
        this.aJw = false;
        this.aJx = true;
        this.aJy = false;
        this.aJz = true;
        this.aJA = false;
        this.aJB = true;
        this.mFrom = 2;
        this.aJC = 1;
        this.aJH = null;
        this.aJJ = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aIW = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aIX = (TextView) inflate.findViewById(e.g.thread_info_bar_name);
        this.aIY = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aJI = (LinearLayout) inflate.findViewById(e.g.thread_comment_layout_root);
        this.aJa = (TextView) inflate.findViewById(e.g.thread_info_commont_num);
        this.aJb = (ImageView) inflate.findViewById(e.g.thread_info_commont_img);
        this.aJc = inflate.findViewById(e.g.thread_info_commont_container);
        this.aJd = (TextView) inflate.findViewById(e.g.share_num);
        this.aJe = (ImageView) inflate.findViewById(e.g.share_num_img);
        this.aJf = inflate.findViewById(e.g.share_num_container);
        this.aJg = (TextView) inflate.findViewById(e.g.thread_info_more);
        this.aJh = (FrameLayout) inflate.findViewById(e.g.thread_info_more_frame);
        this.aFe = (PraiseView) inflate.findViewById(e.g.agree_view);
        this.aFf = (DisPraiseView) inflate.findViewById(e.g.disagree_view);
        this.aIZ = new b(this.aFe, this.aFf);
        this.aJm = inflate.findViewById(e.g.manage_view_container);
        this.aJk = (TextView) inflate.findViewById(e.g.thread_info_manage_text);
        this.aJl = (ImageView) inflate.findViewById(e.g.thread_info_manage_img);
        this.aJo = (ImageView) inflate.findViewById(e.g.manage_select_img);
        this.aJp = (TextView) inflate.findViewById(e.g.manage_select_text);
        this.aJq = (LinearLayout) inflate.findViewById(e.g.manage_select_container);
        this.aJq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.aJo.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.aJp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aJo.performClick();
            }
        });
        this.aJq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aJo.performClick();
            }
        });
        this.aFe.setOnClickListener(this);
        this.aFf.setOnClickListener(this);
        this.aJc.setOnClickListener(this);
        this.aJf.setOnClickListener(this);
        this.aJm.setOnClickListener(this);
        this.aJo.setOnClickListener(this);
        this.aJG = e.f.icon_home_card_share;
        this.aJF = e.f.icon_home_card_comment;
        this.aIZ.EF();
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            this.aIZ.h(getPageUniqueId());
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                this.aIZ.h(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                return;
            }
            this.aIZ.h(getPageUniqueId());
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
        if (view == this.aIX) {
            S(view);
        } else if (view == this.aJc) {
            N(view);
        } else if (view == this.aJf) {
            O(view);
        } else if (view == this.aFe) {
            P(view);
        } else if (view == this.aFf) {
            Q(view);
        } else if (view == this.aJh) {
            U(view);
        } else if (view == this.aJm) {
            T(view);
        } else if (view == this.aJo) {
            R(view);
        }
    }

    protected void R(View view) {
        if (this.aJo != null && this.aFg != null && this.aJp != null && !this.aFg.Bi()) {
            if (!this.aFg.Bh()) {
                if (com.baidu.tieba.frs.a.aAJ().V(this.aFg)) {
                    this.aFg.bd(true);
                }
            } else {
                com.baidu.tieba.frs.a.aAJ().W(this.aFg);
                this.aFg.bd(false);
            }
            al.h(this.aJp, this.aFg.Bh() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
            this.aJo.setImageDrawable(al.getDrawable(this.aFg.Bh() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
            if (this.aJH != null) {
                this.aJH.bJ(this.aFg.Bh());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aJn != null) {
            this.aJn.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.aJc != null) {
            this.aJc.setClickable(z);
            this.aJb.setEnabled(z);
            this.aJa.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.aIZ != null) {
            this.aIZ.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.aJf != null) {
            this.aJf.setClickable(z);
            this.aJe.setEnabled(z);
            this.aJd.setEnabled(z);
        }
    }

    private void S(View view) {
        if (this.aFg != null && !StringUtils.isNull(this.aFg.zM())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aJE)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.aFg.zM(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aFg.zM(), this.mStType, this.aJE)));
            }
            if (this.aIy != null) {
                this.aIy.onClick(view);
            }
        }
    }

    protected void N(View view) {
        if (this.aFg != null && this.mContext != null) {
            com.baidu.tieba.card.o.mG(this.aFg.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aFg, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aFg.getFid()));
            addLocateParam.setForumName(this.aFg.zM());
            if (this.aFg.Bm() && this.aFg.Bl() != null) {
                addLocateParam.setForumId(this.aFg.Bl().getForumId());
                addLocateParam.setForumName(this.aFg.Bl().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.aFg.Ax() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.avM);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.x("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.x("obj_locate", this.mFrom);
            amVar2.x("obj_type", getThreadType());
            amVar2.aA("tid", this.aFg.getTid());
            TiebaStatic.log(amVar2);
            if (this.aIy != null) {
                this.aIy.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.aFg == null) {
            return 0;
        }
        if (this.aFg.isShareThread) {
            return 4;
        }
        if (this.aFg.getThreadType() == 49) {
            return 5;
        }
        if (this.aFg.zY() != null) {
            return 1;
        }
        if (this.aFg.getType() == bb.atg || this.aFg.getType() == bb.ati) {
            if (v.H(this.aFg.zV()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aFg != null || i >= 0) {
            am eB = eB(i);
            eB.x("thread_type", this.aFg.getThreadType());
            TiebaStatic.log(eB);
        }
    }

    public void addPraiseStats(boolean z, int i, String str) {
        if (this.aFg != null || i >= 0) {
            am eB = eB(i);
            eB.x("thread_type", -1);
            if (!StringUtils.isNull(str)) {
                eB.aA("obj_param3", str);
            }
            TiebaStatic.log(eB);
        }
    }

    private am eB(int i) {
        if (this.aFg == null && i < 0) {
            return null;
        }
        am amVar = new am("c12003");
        amVar.aA("tid", this.aFg.getTid());
        if (this.aFg.getThreadType() == 40) {
            amVar.aA("obj_param1", "2");
        } else if (this.aFg.getThreadType() == 0) {
            amVar.aA("obj_param1", "1");
        }
        amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
        amVar.i(ImageViewerConfig.FORUM_ID, this.aFg.getFid());
        amVar.x("obj_locate", this.mFrom);
        amVar.x(VideoPlayActivityConfig.OBJ_ID, i);
        if (!ao.isEmpty(this.aJD)) {
            amVar.aA("obj_floor", this.aJD);
        }
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aA("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            return amVar;
        }
        return amVar;
    }

    protected void P(View view) {
        if (this.aFe != null) {
            addPraiseStats(this.aFe.L(view));
        }
    }

    protected void Q(View view) {
        if (this.aFf != null) {
            this.aFf.L(view);
        }
    }

    protected void O(View view) {
        if ((ax.jJ() || ba.bJ(this.mContext)) && this.aFg != null) {
            Fo();
            Fq();
            if (this.aIy != null && this.aFg.zL()) {
                this.aIy.onClick(view);
            }
        }
    }

    private void Fo() {
        if (this.aFg != null) {
            am Fp = Fp();
            Fp.x("thread_type", this.aFg.getThreadType());
            TiebaStatic.log(Fp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(boolean z, String str) {
        am Fp = Fp();
        Fp.x("thread_type", -1);
        if (!StringUtils.isNull(str)) {
            Fp.aA(VideoPlayActivityConfig.OBJ_ID, str);
        }
        TiebaStatic.log(Fp);
    }

    private am Fp() {
        int i = 4;
        if (this.aFg == null) {
            return null;
        }
        if (this.aJC != 1) {
            if (this.aJC == 2) {
                i = 5;
            } else if (this.aJC == 3) {
                i = 3;
            } else if (this.aJC == 4) {
                i = 2;
            } else if (this.aJC == 6) {
                i = 8;
            } else if (this.aJC != 7) {
                i = 0;
            } else {
                i = 9;
            }
        }
        am amVar = new am("c12386");
        amVar.i(ImageViewerConfig.FORUM_ID, this.aFg.getFid());
        amVar.aA("tid", this.aFg.getTid());
        amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.x("obj_locate", i);
        if (!ao.isEmpty(this.aJD)) {
            amVar.aA("obj_floor", this.aJD);
        }
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        return amVar;
    }

    private void Fq() {
        if (this.aFg != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aFg.getFid());
            String zM = this.aFg.zM();
            if (this.aFg.avC != null) {
                valueOf = this.aFg.avC.id;
                zM = this.aFg.avC.ori_fname;
            }
            String title = this.aFg.getTitle();
            String tid = this.aFg.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aFg);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aFg.getAbstract();
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aSl = str2;
            dVar.linkUrl = str;
            dVar.avL = this.aJC;
            dVar.extData = tid;
            dVar.aSo = 3;
            dVar.fid = valueOf;
            dVar.aSh = zM;
            dVar.tid = tid;
            dVar.aSd = true;
            dVar.aSn = getShareObjSource();
            dVar.aSp = c(this.aFg);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aFg);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSo);
            bundle.putInt("obj_type", dVar.aSp);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.avL);
            dVar.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aFg.getThreadType() == 49 || this.aFg.getThreadType() == 60);
            com.baidu.tieba.c.e.asd().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.aJC == 1) {
            return 5;
        }
        if (this.aJC != 3) {
            if (this.aJC == 4) {
                return 4;
            }
            if (this.aJC != 6) {
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
        if (this.aJn == null) {
            this.aJn = new ae(this.mPageContext, this.aJJ);
        }
        this.aJn.setData(this.aFg);
        com.baidu.adp.lib.g.g.a(this.aJn, this.mPageContext);
        TiebaStatic.log(new am("c12711"));
    }

    private void U(View view) {
        Fs();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aJu = z;
        if (this.aIX != null) {
            this.aIX.setClickable(this.aJu);
        }
    }

    public boolean isMoreViewVisible() {
        return this.aJh != null && this.aJh.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.aIZ != null) {
            this.aIZ.setForumId(str);
        }
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFg = bbVar;
        Fr();
        d(bbVar);
        f(bbVar);
        g(bbVar);
        h(bbVar);
        updatePraiseNum(bbVar);
        e(bbVar);
        i(bbVar);
        setVisibility(this.aJr ? 0 : 8);
        return this.aJr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fr() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(bb bbVar) {
        this.aIX.setVisibility(8);
    }

    protected void e(bb bbVar) {
        int aO;
        if (this.aJq != null && this.aJo != null && this.aJp != null && bbVar != null) {
            if (!this.aJJ) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aJq.setVisibility(8);
            } else if (this.aJB && com.baidu.tieba.frs.a.aAJ().aAK()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.j(this.mMaskView, e.d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.aJo.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.aJo.performClick();
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
                al.h(this.aJp, this.aFg.Bh() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
                this.aJo.setImageDrawable(al.getDrawable(bbVar.Bh() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.aJq.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aJq.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String O;
        if (this.aIY != null && bbVar != null) {
            if (bbVar.zz() <= 0 || !this.aJs) {
                this.aIY.setVisibility(8);
                return;
            }
            this.aIY.setVisibility(0);
            if (this.mFrom == 3) {
                O = ao.L(bbVar.zz());
            } else {
                O = ao.O(bbVar.zz() * 1000);
            }
            this.aIY.setText(O);
            this.aJr = true;
        }
    }

    public boolean isVisible() {
        return this.aJr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bb bbVar) {
        if (this.aJa != null && bbVar != null) {
            if (this.aJx) {
                this.aJc.setVisibility(0);
                if (this.aJc.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJc.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJc.setLayoutParams(layoutParams);
                }
                if (bbVar.zx() > 0) {
                    this.aJa.setVisibility(0);
                    String X = ao.X(bbVar.zx());
                    if (this.aJv) {
                        this.aJb.setImageDrawable(al.getDrawable(this.aJF));
                        this.aJa.setText(X);
                    } else {
                        this.aJa.setText(String.format(this.mContext.getString(e.j.reply_num_tip), X));
                    }
                    this.aJa.setContentDescription(this.mContext.getString(e.j.reply_num) + X);
                    this.aJr = true;
                    return;
                } else if (this.aJv) {
                    this.aJb.setImageDrawable(al.getDrawable(this.aJF));
                    this.aJa.setText(this.mContext.getString(e.j.action_comment_default));
                    this.aJa.setVisibility(0);
                    this.aJr = true;
                    return;
                } else {
                    this.aJa.setVisibility(8);
                    return;
                }
            }
            this.aJc.setVisibility(8);
        }
    }

    public void updatePraiseNum(bb bbVar) {
        if (this.aIZ != null) {
            if (bbVar.getType() == bb.atp || bbVar.getType() == bb.atq) {
                this.aIZ.setDisPraiseFrom(5);
            }
            this.aIZ.a(bbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bb bbVar) {
        if (this.aJf != null && this.aJd != null && bbVar != null) {
            if (this.aJz) {
                this.aJf.setVisibility(0);
                if (this.aJf.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJf.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJf.setLayoutParams(layoutParams);
                }
                long AW = bbVar.AW();
                if ((bbVar.AK() || bbVar.AN()) && bbVar.Aa() != null) {
                    AW = bbVar.Aa().share_info.share_count;
                }
                this.aJd.setText(AW > 0 ? ao.X(AW) : this.mContext.getString(e.j.share));
                this.aJr = true;
                if (bbVar.avt != null && bbVar.avt.isDeleted) {
                    setShareClickable(false);
                    al.i(this.aJe, e.f.icon_card_share_d);
                    al.h(this.aJd, e.d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.i(this.aJe, this.aJG);
                al.h(this.aJd, e.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.aJf.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.aJh != null) {
            if (this.aFg == null || v.I(this.aFg.AH()) || !TbadkCoreApplication.isLogin() || this.aFg.AI()) {
                this.aJh.setVisibility(8);
                return;
            }
            if (this.aJh.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJh.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.aJh.setLayoutParams(layoutParams);
            }
            if (this.aJi == null) {
                this.aJi = new ArrayList();
            } else {
                this.aJi.clear();
            }
            if (this.aJj == null) {
                this.aJj = new ArrayList();
            } else {
                this.aJj.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aFg.AH()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aJi.add(reportInfo.info);
                    this.aJj.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aJh.setOnClickListener(this);
                this.aJh.setVisibility(0);
                return;
            }
            this.aJh.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(bb bbVar) {
        if (this.aJm != null && bbVar != null) {
            if (bbVar.avC != null) {
                this.aJA = false;
            }
            if (this.aJA && (this.aJq == null || this.aJq.getVisibility() == 8)) {
                this.aJm.setVisibility(0);
                if (this.aJm.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJm.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aJm.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(e.j.manage);
                this.aJk.setText(string);
                this.aJk.setContentDescription(string);
                this.aJr = true;
                return;
            }
            this.aJm.setVisibility(8);
        }
    }

    private void Fs() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.de(e.j.operation);
            bVar.a(this.aJi, new b.InterfaceC0158b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.d(ThreadCommentAndPraiseInfoLayout.this.aJj, i);
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
        al.h(this.aIX, e.d.cp_cont_d);
        al.h(this.aIY, e.d.cp_cont_j);
        al.h(this.aJa, e.f.selector_comment_and_prise_item_text_color);
        al.h(this.aJk, e.f.selector_comment_and_prise_item_text_color);
        al.i(this.aJg, e.f.btn_frs_more_selector);
        if (this.aJa != null && this.aJv && this.aJF > 0) {
            this.aJb.setImageDrawable(al.getDrawable(this.aJF));
        }
        if (this.aFg != null && this.aFg.avt != null && this.aFg.avt.isDeleted) {
            setShareClickable(false);
            al.i(this.aJe, e.f.icon_card_share_d);
            al.h(this.aJd, e.d.cp_cont_e);
        } else {
            setShareClickable(true);
            al.i(this.aJe, this.aJG);
            al.h(this.aJd, e.f.selector_comment_and_prise_item_text_color);
        }
        if (this.aJl != null) {
            this.aJl.setImageDrawable(al.getDrawable(e.f.icon_card_frs_manage_selector));
        }
        if (this.aJn != null) {
            this.aJn.onChangeSkinType();
        }
        if (this.aIZ != null) {
            this.aIZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        al.j(this.mMaskView, e.d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aIy = onClickListener;
        if (this.aFe != null) {
            this.aFe.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.aIX;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.aJy = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aJs = z;
    }

    public View getCommentNumView() {
        return this.aJa;
    }

    public View getCommentContainer() {
        return this.aJc;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aJv = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.aJw = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.aJB = z;
    }

    public void setManageVisible(boolean z) {
        this.aJA = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.aJH = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.aJo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.aJI;
    }

    public void setInFrsAllThread(boolean z) {
        this.aJJ = z;
    }

    public boolean isInFrsAllThread() {
        return this.aJJ;
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
        if (this.aIZ != null) {
            this.aIZ.onDestroy();
        }
    }
}
