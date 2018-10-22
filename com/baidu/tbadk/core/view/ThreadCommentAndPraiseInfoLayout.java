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
/* loaded from: classes6.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    protected PraiseView aAO;
    protected DisPraiseView aAP;
    protected bb aAQ;
    protected int aEF;
    protected TextView aEG;
    private TextView aEH;
    protected b aEI;
    protected TextView aEJ;
    protected ImageView aEK;
    protected View aEL;
    protected TextView aEM;
    protected ImageView aEN;
    protected View aEO;
    protected TextView aEP;
    protected FrameLayout aEQ;
    private List<CharSequence> aER;
    private List<String> aES;
    protected TextView aET;
    protected ImageView aEU;
    protected View aEV;
    private ae aEW;
    protected ImageView aEX;
    protected TextView aEY;
    protected LinearLayout aEZ;
    private View.OnClickListener aEh;
    protected boolean aFa;
    private boolean aFb;
    protected boolean aFc;
    protected boolean aFd;
    protected boolean aFe;
    protected boolean aFf;
    protected boolean aFg;
    private boolean aFh;
    protected boolean aFi;
    protected boolean aFj;
    protected boolean aFk;
    private int aFl;
    private String aFm;
    protected int aFn;
    protected int aFo;
    private a aFp;
    private LinearLayout aFq;
    private boolean aFr;
    public int ary;
    protected Context mContext;
    private int mFrom;
    private View mMaskView;
    private TbPageContext mPageContext;
    private String mStType;

    /* loaded from: classes6.dex */
    public interface a {
        void br(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.aFm = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
        if (this.aEI != null) {
            this.aEI.setFrom(i);
        }
    }

    public void setDisPraiseFrom(int i) {
        if (this.aEI != null) {
            this.aEI.setDisPraiseFrom(i);
        }
    }

    public void setShareReportFrom(int i) {
        this.aFl = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aEF = 0;
        this.aFa = false;
        this.aFb = true;
        this.aFc = true;
        this.aFd = true;
        this.aFe = false;
        this.aFf = false;
        this.aFg = true;
        this.aFh = false;
        this.aFi = true;
        this.aFj = false;
        this.aFk = true;
        this.mFrom = 2;
        this.aFl = 1;
        this.aFp = null;
        this.aFr = false;
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEF = 0;
        this.aFa = false;
        this.aFb = true;
        this.aFc = true;
        this.aFd = true;
        this.aFe = false;
        this.aFf = false;
        this.aFg = true;
        this.aFh = false;
        this.aFi = true;
        this.aFj = false;
        this.aFk = true;
        this.mFrom = 2;
        this.aFl = 1;
        this.aFp = null;
        this.aFr = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aEF = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aEG = (TextView) inflate.findViewById(e.g.thread_info_bar_name);
        this.aEH = (TextView) inflate.findViewById(e.g.thread_info_reply_time);
        this.aFq = (LinearLayout) inflate.findViewById(e.g.thread_comment_layout_root);
        this.aEJ = (TextView) inflate.findViewById(e.g.thread_info_commont_num);
        this.aEK = (ImageView) inflate.findViewById(e.g.thread_info_commont_img);
        this.aEL = inflate.findViewById(e.g.thread_info_commont_container);
        this.aEM = (TextView) inflate.findViewById(e.g.share_num);
        this.aEN = (ImageView) inflate.findViewById(e.g.share_num_img);
        this.aEO = inflate.findViewById(e.g.share_num_container);
        this.aEP = (TextView) inflate.findViewById(e.g.thread_info_more);
        this.aEQ = (FrameLayout) inflate.findViewById(e.g.thread_info_more_frame);
        this.aAO = (PraiseView) inflate.findViewById(e.g.agree_view);
        this.aAP = (DisPraiseView) inflate.findViewById(e.g.disagree_view);
        this.aEI = new b(this.aAO, this.aAP);
        this.aEV = inflate.findViewById(e.g.manage_view_container);
        this.aET = (TextView) inflate.findViewById(e.g.thread_info_manage_text);
        this.aEU = (ImageView) inflate.findViewById(e.g.thread_info_manage_img);
        this.aEX = (ImageView) inflate.findViewById(e.g.manage_select_img);
        this.aEY = (TextView) inflate.findViewById(e.g.manage_select_text);
        this.aEZ = (LinearLayout) inflate.findViewById(e.g.manage_select_container);
        this.aEZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.aEX.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.aEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aEX.performClick();
            }
        });
        this.aEZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.aEX.performClick();
            }
        });
        this.aAO.setOnClickListener(this);
        this.aAP.setOnClickListener(this);
        this.aEL.setOnClickListener(this);
        this.aEO.setOnClickListener(this);
        this.aEV.setOnClickListener(this);
        this.aEX.setOnClickListener(this);
        this.aFo = e.f.icon_home_card_share;
        this.aFn = e.f.icon_home_card_comment;
        this.aEI.Du();
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
            this.aEI.h(getPageUniqueId());
        } else if (context instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) context;
            this.mPageContext = baseFragmentActivity.getPageContext();
            if (baseFragmentActivity.getVisibleFragment() instanceof BaseFragment) {
                this.aEI.h(((BaseFragment) baseFragmentActivity.getVisibleFragment()).getUniqueId());
                return;
            }
            this.aEI.h(getPageUniqueId());
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
        if (view == this.aEG) {
            S(view);
        } else if (view == this.aEL) {
            N(view);
        } else if (view == this.aEO) {
            O(view);
        } else if (view == this.aAO) {
            P(view);
        } else if (view == this.aAP) {
            Q(view);
        } else if (view == this.aEQ) {
            U(view);
        } else if (view == this.aEV) {
            T(view);
        } else if (view == this.aEX) {
            R(view);
        }
    }

    protected void R(View view) {
        if (this.aEX != null && this.aAQ != null && this.aEY != null && !this.aAQ.zX()) {
            if (!this.aAQ.zW()) {
                if (com.baidu.tieba.frs.a.ayN().V(this.aAQ)) {
                    this.aAQ.aM(true);
                }
            } else {
                com.baidu.tieba.frs.a.ayN().W(this.aAQ);
                this.aAQ.aM(false);
            }
            al.h(this.aEY, this.aAQ.zW() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
            this.aEX.setImageDrawable(al.getDrawable(this.aAQ.zW() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
            if (this.aFp != null) {
                this.aFp.br(this.aAQ.zW());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aEW != null) {
            this.aEW.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.aEL != null) {
            this.aEL.setClickable(z);
            this.aEK.setEnabled(z);
            this.aEJ.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.aEI != null) {
            this.aEI.setClickable(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.aEO != null) {
            this.aEO.setClickable(z);
            this.aEN.setEnabled(z);
            this.aEM.setEnabled(z);
        }
    }

    private void S(View view) {
        if (this.aAQ != null && !StringUtils.isNull(this.aAQ.yB())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aFm)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.aAQ.yB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aAQ.yB(), this.mStType, this.aFm)));
            }
            if (this.aEh != null) {
                this.aEh.onClick(view);
            }
        }
    }

    protected void N(View view) {
        if (this.aAQ != null && this.mContext != null) {
            com.baidu.tieba.card.o.md(this.aAQ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aAQ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aAQ.getFid()));
            addLocateParam.setForumName(this.aAQ.yB());
            if (this.aAQ.Ab() && this.aAQ.Aa() != null) {
                addLocateParam.setForumId(this.aAQ.Aa().getForumId());
                addLocateParam.setForumName(this.aAQ.Aa().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.aAQ.zm() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.ary);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.x("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.x("obj_locate", this.mFrom);
            amVar2.x("obj_type", getThreadType());
            amVar2.ax("tid", this.aAQ.getTid());
            TiebaStatic.log(amVar2);
            if (this.aEh != null) {
                this.aEh.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.aAQ == null) {
            return 0;
        }
        if (this.aAQ.isShareThread) {
            return 4;
        }
        if (this.aAQ.getThreadType() == 49) {
            return 5;
        }
        if (this.aAQ.yN() != null) {
            return 1;
        }
        if (this.aAQ.getType() == bb.aoS || this.aAQ.getType() == bb.aoU) {
            if (v.I(this.aAQ.yK()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public void addPraiseStats(int i) {
        if (this.aAQ != null || i >= 0) {
            am amVar = new am("c12003");
            amVar.ax("tid", this.aAQ.getTid());
            if (this.aAQ.getThreadType() == 40) {
                amVar.ax("obj_param1", "2");
            } else if (this.aAQ.getThreadType() == 0) {
                amVar.ax("obj_param1", "1");
            }
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            amVar.h(ImageViewerConfig.FORUM_ID, this.aAQ.getFid());
            amVar.x("obj_locate", this.mFrom);
            amVar.x(VideoPlayActivityConfig.OBJ_ID, i);
            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.ax("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
        }
    }

    protected void P(View view) {
        if (this.aAO != null) {
            addPraiseStats(this.aAO.L(view));
        }
    }

    protected void Q(View view) {
        if (this.aAP != null) {
            this.aAP.L(view);
        }
    }

    protected void O(View view) {
        if ((aw.jL() || ba.bI(this.mContext)) && this.aAQ != null) {
            Ea();
            Eb();
            if (this.aEh != null && this.aAQ.yA()) {
                this.aEh.onClick(view);
            }
        }
    }

    private void Ea() {
        int i = 4;
        if (this.aAQ != null) {
            if (this.aFl != 1) {
                if (this.aFl == 2) {
                    i = 5;
                } else if (this.aFl == 3) {
                    i = 3;
                } else if (this.aFl == 4) {
                    i = 2;
                } else if (this.aFl == 6) {
                    i = 8;
                } else if (this.aFl != 7) {
                    i = 0;
                } else {
                    i = 9;
                }
            }
            am amVar = new am("c12386");
            amVar.h(ImageViewerConfig.FORUM_ID, this.aAQ.getFid());
            amVar.ax("tid", this.aAQ.getTid());
            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.x("obj_locate", i);
            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(amVar);
        }
    }

    private void Eb() {
        if (this.aAQ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aAQ.getFid());
            String yB = this.aAQ.yB();
            if (this.aAQ.arp != null) {
                valueOf = this.aAQ.arp.id;
                yB = this.aAQ.arp.ori_fname;
            }
            String title = this.aAQ.getTitle();
            String tid = this.aAQ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aAQ);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aAQ.getAbstract();
            String format = MessageFormat.format(getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aNU = str2;
            dVar.linkUrl = str;
            dVar.arx = this.aFl;
            dVar.extData = tid;
            dVar.aNX = 3;
            dVar.fid = valueOf;
            dVar.aNQ = yB;
            dVar.tid = tid;
            dVar.aNM = true;
            dVar.aNW = getShareObjSource();
            dVar.aNY = c(this.aAQ);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aAQ);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aNX);
            bundle.putInt("obj_type", dVar.aNY);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.arx);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aAQ.getThreadType() == 49 || this.aAQ.getThreadType() == 60);
            com.baidu.tieba.c.e.aqb().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.aFl == 1) {
            return 5;
        }
        if (this.aFl != 3) {
            if (this.aFl == 4) {
                return 4;
            }
            if (this.aFl != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.yG() == null) {
            return null;
        }
        ArrayList<MediaData> yG = bbVar.yG();
        int size = yG.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = yG.get(i);
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
            if (bbVar.yx()) {
                return 4;
            }
            if (bbVar.ys() == 1) {
                return 3;
            }
            return bbVar.zA() ? 2 : 1;
        }
        return 0;
    }

    private void T(View view) {
        if (this.aEW == null) {
            this.aEW = new ae(this.mPageContext, this.aFr);
        }
        this.aEW.setData(this.aAQ);
        com.baidu.adp.lib.g.g.a(this.aEW, this.mPageContext);
        TiebaStatic.log(new am("c12711"));
    }

    private void U(View view) {
        Ed();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aFd = z;
        if (this.aEG != null) {
            this.aEG.setClickable(this.aFd);
        }
    }

    public boolean isMoreViewVisible() {
        return this.aEQ != null && this.aEQ.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
    }

    public void setForumId(String str) {
        if (this.aEI != null) {
            this.aEI.setForumId(str);
        }
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aAQ = bbVar;
        Ec();
        d(bbVar);
        f(bbVar);
        g(bbVar);
        h(bbVar);
        updatePraiseNum(bbVar);
        e(bbVar);
        i(bbVar);
        setVisibility(this.aFa ? 0 : 8);
        return this.aFa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ec() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(bb bbVar) {
        this.aEG.setVisibility(8);
    }

    protected void e(bb bbVar) {
        int aO;
        if (this.aEZ != null && this.aEX != null && this.aEY != null && bbVar != null) {
            if (!this.aFr) {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aEZ.setVisibility(8);
            } else if (this.aFk && com.baidu.tieba.frs.a.ayN().ayO()) {
                if (this.mMaskView == null) {
                    this.mMaskView = new View(getContext());
                    al.j(this.mMaskView, e.d.cp_bg_line_d);
                    addView(this.mMaskView);
                    this.mMaskView.setAlpha(0.5f);
                    this.mMaskView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.aEX.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.mMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.aEX.performClick();
                        }
                    });
                }
                if (bbVar.zX()) {
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
                al.h(this.aEY, this.aAQ.zW() ? e.d.cp_link_tip_a : e.f.selector_comment_and_prise_item_text_color);
                this.aEX.setImageDrawable(al.getDrawable(bbVar.zW() ? e.f.icon_card_frs_select_ok_n : e.f.btn_forum_select));
                this.mMaskView.setVisibility(0);
                this.aEZ.setVisibility(0);
            } else {
                if (this.mMaskView != null) {
                    this.mMaskView.setVisibility(8);
                }
                this.aEZ.setVisibility(8);
            }
        }
    }

    private void f(bb bbVar) {
        String E;
        if (this.aEH != null && bbVar != null) {
            if (bbVar.yo() <= 0 || !this.aFb) {
                this.aEH.setVisibility(8);
                return;
            }
            this.aEH.setVisibility(0);
            if (this.mFrom == 3) {
                E = ao.B(bbVar.yo());
            } else {
                E = ao.E(bbVar.yo() * 1000);
            }
            this.aEH.setText(E);
            this.aFa = true;
        }
    }

    public boolean isVisible() {
        return this.aFa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bb bbVar) {
        if (this.aEJ != null && bbVar != null) {
            if (this.aFg) {
                this.aEL.setVisibility(0);
                if (this.aEL.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEL.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aEL.setLayoutParams(layoutParams);
                }
                if (bbVar.ym() > 0) {
                    this.aEJ.setVisibility(0);
                    String N = ao.N(bbVar.ym());
                    if (this.aFe) {
                        this.aEK.setImageDrawable(al.getDrawable(this.aFn));
                        this.aEJ.setText(N);
                    } else {
                        this.aEJ.setText(String.format(this.mContext.getString(e.j.reply_num_tip), N));
                    }
                    this.aEJ.setContentDescription(this.mContext.getString(e.j.reply_num) + N);
                    this.aFa = true;
                    return;
                } else if (this.aFe) {
                    this.aEK.setImageDrawable(al.getDrawable(this.aFn));
                    this.aEJ.setText(this.mContext.getString(e.j.action_comment_default));
                    this.aEJ.setVisibility(0);
                    this.aFa = true;
                    return;
                } else {
                    this.aEJ.setVisibility(8);
                    return;
                }
            }
            this.aEL.setVisibility(8);
        }
    }

    public void updatePraiseNum(bb bbVar) {
        if (this.aEI != null) {
            if (bbVar.getType() == bb.apb || bbVar.getType() == bb.apc) {
                this.aEI.setDisPraiseFrom(5);
            }
            this.aEI.a(bbVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bb bbVar) {
        if (this.aEO != null && this.aEM != null && bbVar != null) {
            if (this.aFi) {
                this.aEO.setVisibility(0);
                if (this.aEO.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEO.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aEO.setLayoutParams(layoutParams);
                }
                long zL = bbVar.zL();
                if ((bbVar.zz() || bbVar.zC()) && bbVar.yP() != null) {
                    zL = bbVar.yP().share_info.share_count;
                }
                this.aEM.setText(zL > 0 ? ao.N(zL) : this.mContext.getString(e.j.share));
                this.aFa = true;
                if (bbVar.arg != null && bbVar.arg.isDeleted) {
                    setShareClickable(false);
                    al.i(this.aEN, e.f.icon_card_share_d);
                    al.h(this.aEM, e.d.cp_cont_e);
                    return;
                }
                setShareClickable(true);
                al.i(this.aEN, this.aFo);
                al.h(this.aEM, e.f.selector_comment_and_prise_item_text_color);
                return;
            }
            this.aEO.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.aEQ != null) {
            if (this.aAQ == null || v.J(this.aAQ.zw()) || !TbadkCoreApplication.isLogin() || this.aAQ.zx()) {
                this.aEQ.setVisibility(8);
                return;
            }
            if (this.aEQ.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEQ.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.aEQ.setLayoutParams(layoutParams);
            }
            if (this.aER == null) {
                this.aER = new ArrayList();
            } else {
                this.aER.clear();
            }
            if (this.aES == null) {
                this.aES = new ArrayList();
            } else {
                this.aES.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aAQ.zw()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aER.add(reportInfo.info);
                    this.aES.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aEQ.setOnClickListener(this);
                this.aEQ.setVisibility(0);
                return;
            }
            this.aEQ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(bb bbVar) {
        if (this.aEV != null && bbVar != null) {
            if (bbVar.arp != null) {
                this.aFj = false;
            }
            if (this.aFj && (this.aEZ == null || this.aEZ.getVisibility() == 8)) {
                this.aEV.setVisibility(0);
                if (this.aEV.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEV.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aEV.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(e.j.manage);
                this.aET.setText(string);
                this.aET.setContentDescription(string);
                this.aFa = true;
                return;
            }
            this.aEV.setVisibility(8);
        }
    }

    private void Ed() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cC(e.j.operation);
            bVar.a(this.aER, new b.InterfaceC0124b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.d(ThreadCommentAndPraiseInfoLayout.this.aES, i);
                    if (!StringUtils.isNull(str)) {
                        ay.CU().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.Ax();
        }
    }

    public void onChangeSkinType() {
        al.h(this.aEG, e.d.cp_cont_d);
        al.h(this.aEH, e.d.cp_cont_j);
        al.h(this.aEJ, e.f.selector_comment_and_prise_item_text_color);
        al.h(this.aET, e.f.selector_comment_and_prise_item_text_color);
        al.i(this.aEP, e.f.btn_frs_more_selector);
        if (this.aEJ != null && this.aFe && this.aFn > 0) {
            this.aEK.setImageDrawable(al.getDrawable(this.aFn));
        }
        if (this.aAQ != null && this.aAQ.arg != null && this.aAQ.arg.isDeleted) {
            setShareClickable(false);
            al.i(this.aEN, e.f.icon_card_share_d);
            al.h(this.aEM, e.d.cp_cont_e);
        } else {
            setShareClickable(true);
            al.i(this.aEN, this.aFo);
            al.h(this.aEM, e.f.selector_comment_and_prise_item_text_color);
        }
        if (this.aEU != null) {
            this.aEU.setImageDrawable(al.getDrawable(e.f.icon_card_frs_manage_selector));
        }
        if (this.aEW != null) {
            this.aEW.onChangeSkinType();
        }
        if (this.aEI != null) {
            this.aEI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        al.j(this.mMaskView, e.d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aEh = onClickListener;
        if (this.aAO != null) {
            this.aAO.setForumAfterClickListener(onClickListener);
        }
    }

    public TextView getBarNameTv() {
        return this.aEG;
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.aFh = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aFb = z;
    }

    public View getCommentNumView() {
        return this.aEJ;
    }

    public View getCommentContainer() {
        return this.aEL;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aFe = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setIsBarViewVisible(boolean z) {
        this.aFf = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.aFk = z;
    }

    public void setManageVisible(boolean z) {
        this.aFj = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.aFp = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.aEX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.aFq;
    }

    public void setInFrsAllThread(boolean z) {
        this.aFr = z;
    }

    public boolean isInFrsAllThread() {
        return this.aFr;
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
        if (this.aEI != null) {
            this.aEI.onDestroy();
        }
    }
}
