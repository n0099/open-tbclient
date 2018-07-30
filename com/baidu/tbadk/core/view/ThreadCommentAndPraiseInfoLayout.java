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
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.p.at;
import com.baidu.tieba.card.ae;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    public int ajY;
    protected bb atD;
    protected int awN;
    protected TextView awO;
    private TextView awP;
    protected TextView awQ;
    protected ImageView awR;
    protected View awS;
    protected TextView awT;
    protected ImageView awU;
    protected View awV;
    protected TextView awW;
    protected ImageView awX;
    protected View awY;
    protected TextView awZ;
    protected int axA;
    protected int axB;
    protected int axC;
    protected ScaleAnimation axD;
    private View axE;
    private a axF;
    private LinearLayout axG;
    private boolean axH;
    private CustomMessageListener axI;
    protected FrameLayout axa;
    private List<CharSequence> axb;
    private List<String> axc;
    protected TextView axd;
    protected ImageView axe;
    protected View axf;
    private ae axg;
    protected ImageView axh;
    protected TextView axi;
    protected LinearLayout axj;
    protected boolean axk;
    protected boolean axl;
    private boolean axm;
    protected boolean axn;
    protected boolean axo;
    private boolean axp;
    protected boolean axq;
    protected boolean axr;
    private boolean axs;
    protected boolean axt;
    protected boolean axu;
    protected boolean axv;
    private int axw;
    private int axx;
    private String axy;
    private View.OnClickListener axz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    /* loaded from: classes2.dex */
    public interface a {
        void aU(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.axy = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.axw = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.awN = 0;
        this.axk = false;
        this.axl = true;
        this.axm = true;
        this.axn = true;
        this.axo = false;
        this.axp = false;
        this.axq = false;
        this.axr = true;
        this.axs = false;
        this.axt = true;
        this.axu = false;
        this.axv = true;
        this.mFrom = 2;
        this.axw = 1;
        this.axF = null;
        this.axH = false;
        this.axI = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && ThreadCommentAndPraiseInfoLayout.this.atD != null && ThreadCommentAndPraiseInfoLayout.this.atD.getId() != null) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bbVar.getId()) && bbVar.uX() != null && bbVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.atD.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.atD.uX() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.atD.uX().setNum(bbVar.uX().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.atD);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awN = 0;
        this.axk = false;
        this.axl = true;
        this.axm = true;
        this.axn = true;
        this.axo = false;
        this.axp = false;
        this.axq = false;
        this.axr = true;
        this.axs = false;
        this.axt = true;
        this.axu = false;
        this.axv = true;
        this.mFrom = 2;
        this.axw = 1;
        this.axF = null;
        this.axH = false;
        this.axI = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && ThreadCommentAndPraiseInfoLayout.this.atD != null && ThreadCommentAndPraiseInfoLayout.this.atD.getId() != null) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bbVar.getId()) && bbVar.uX() != null && bbVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.atD.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.atD.uX() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.atD.uX().setNum(bbVar.uX().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.atD);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.awN = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.awO = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.awP = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.axG = (LinearLayout) inflate.findViewById(d.g.thread_comment_layout_root);
        this.awT = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.awU = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.awV = inflate.findViewById(d.g.thread_info_commont_container);
        this.awW = (TextView) inflate.findViewById(d.g.share_num);
        this.awX = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.awY = inflate.findViewById(d.g.share_num_container);
        this.awZ = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.axa = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.awQ = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.awR = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.awS = inflate.findViewById(d.g.agree_view_container);
        this.axf = inflate.findViewById(d.g.manage_view_container);
        this.axd = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.axe = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.axh = (ImageView) inflate.findViewById(d.g.manage_select_img);
        this.axi = (TextView) inflate.findViewById(d.g.manage_select_text);
        this.axj = (LinearLayout) inflate.findViewById(d.g.manage_select_container);
        this.axj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.axh.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.axi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.axh.performClick();
            }
        });
        this.axj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.axh.performClick();
            }
        });
        this.awS.setOnClickListener(this);
        this.awV.setOnClickListener(this);
        this.awY.setOnClickListener(this);
        this.axf.setOnClickListener(this);
        this.axh.setOnClickListener(this);
        this.axC = d.f.icon_home_card_share;
        this.axB = d.f.icon_home_card_comment;
        this.axx = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.awO) {
            D(view);
        } else if (view == this.awV) {
            E(view);
        } else if (view == this.awS) {
            F(view);
        } else if (view == this.awY) {
            G(view);
        } else if (view == this.axa) {
            I(view);
        } else if (view == this.axf) {
            H(view);
        } else if (view == this.axh) {
            C(view);
        }
    }

    protected void C(View view) {
        if (this.axh != null && this.atD != null && this.axi != null && !this.atD.wI()) {
            if (!this.atD.wH()) {
                if (com.baidu.tieba.frs.a.atD().U(this.atD)) {
                    this.atD.as(true);
                }
            } else {
                com.baidu.tieba.frs.a.atD().V(this.atD);
                this.atD.as(false);
            }
            am.h(this.axi, this.atD.wH() ? d.C0140d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
            this.axh.setImageDrawable(am.getDrawable(this.atD.wH() ? d.f.icon_card_frs_select_ok_n : d.f.btn_forum_select));
            if (this.axF != null) {
                this.axF.aU(this.atD.wH());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.axg != null) {
            this.axg.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.awV != null) {
            this.awV.setClickable(z);
            this.awU.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.awS != null) {
            this.awS.setClickable(z);
            this.awR.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.awY != null) {
            this.awY.setEnabled(z);
            this.awX.setEnabled(z);
        }
    }

    private void D(View view) {
        if (this.atD != null && !StringUtils.isNull(this.atD.vq())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.axy)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.atD.vq(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.atD.vq(), this.mStType, this.axy)));
            }
            if (this.axz != null) {
                this.axz.onClick(view);
            }
        }
    }

    private void E(View view) {
        if (this.atD != null && this.mContext != null) {
            o.kW(this.atD.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.atD, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.atD.getFid()));
            addLocateParam.setForumName(this.atD.vq());
            if (this.atD.wM() && this.atD.wL() != null) {
                addLocateParam.setForumId(this.atD.wL().getForumId());
                addLocateParam.setForumName(this.atD.wL().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.atD.vZ() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.ajY);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            an anVar = new an("c12291");
            anVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.r("obj_locate", this.mFrom);
            anVar2.r("obj_type", getThreadType());
            anVar2.af("tid", this.atD.getTid());
            TiebaStatic.log(anVar2);
            if (this.axz != null) {
                this.axz.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.atD == null) {
            return 0;
        }
        if (this.atD.isShareThread) {
            return 4;
        }
        if (this.atD.getThreadType() == 49) {
            return 5;
        }
        if (this.atD.vC() != null) {
            return 1;
        }
        if (this.atD.getType() == bb.ahx || this.atD.getType() == bb.ahz) {
            if (w.y(this.atD.vz()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    protected void F(View view) {
        int i = 1;
        if (ba.aV(this.mContext) && this.atD != null) {
            if (this.atD.wv() != 0) {
                this.atD.cc(this.atD.wu() - 1);
                this.atD.cb(0);
                if (this.awQ != null) {
                    am.h(this.awQ, d.C0140d.cp_cont_j);
                }
            } else {
                this.atD.cb(1);
                this.atD.cc(this.atD.wu() + 1);
                if (this.awQ != null) {
                    am.h(this.awQ, d.C0140d.cp_cont_h);
                }
                com.baidu.tieba.n.a.bmV().y(this.mPageContext);
                i = 0;
            }
            updatePraiseNum(this.atD);
            if (this.awR != null && i == 0) {
                this.awR.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.atD.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            if (this.axx > 0) {
                httpMessage.addParam("forum_id", this.atD.getFid());
            }
            if (this.mPageContext != null) {
                httpMessage.setTag(this.mPageContext.getUniqueId());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            an anVar = new an("c12003");
            anVar.af("tid", this.atD.getTid());
            if (this.atD.getThreadType() == 40) {
                anVar.af("obj_param1", "2");
            } else if (this.atD.getThreadType() == 0) {
                anVar.af("obj_param1", "1");
            }
            anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            anVar.f(ImageViewerConfig.FORUM_ID, this.atD.getFid());
            anVar.r("obj_locate", this.mFrom);
            anVar.r(VideoPlayActivityConfig.OBJ_ID, i);
            TiebaStatic.log(anVar);
            if (this.axz != null) {
                this.axz.onClick(view);
            }
        }
    }

    protected void G(View view) {
        if (at.iq() || ba.aV(this.mContext)) {
            AL();
            AM();
            if (this.axz != null) {
                this.axz.onClick(view);
            }
        }
    }

    private void AL() {
        int i = 4;
        if (this.atD != null) {
            if (this.axw != 1) {
                if (this.axw == 2) {
                    i = 5;
                } else if (this.axw == 3) {
                    i = 3;
                } else if (this.axw == 4) {
                    i = 2;
                } else if (this.axw == 6) {
                    i = 8;
                } else {
                    i = this.axw == 7 ? 8 : 0;
                }
            }
            TiebaStatic.log(new an("c12386").f(ImageViewerConfig.FORUM_ID, this.atD.getFid()).af("tid", this.atD.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void AM() {
        if (this.atD != null && this.mContext != null) {
            String valueOf = String.valueOf(this.atD.getFid());
            String vq = this.atD.vq();
            if (this.atD.ajQ != null) {
                valueOf = this.atD.ajQ.id;
                vq = this.atD.ajQ.ori_fname;
            }
            String title = this.atD.getTitle();
            String tid = this.atD.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a2 = a(this.atD);
            Uri parse = a2 == null ? null : Uri.parse(a2);
            String str2 = this.atD.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aGf = str2;
            dVar.linkUrl = str;
            dVar.ajX = this.axw;
            dVar.extData = tid;
            dVar.aGi = 3;
            dVar.fid = valueOf;
            dVar.aGb = vq;
            dVar.tid = tid;
            dVar.aFX = true;
            dVar.aGh = getShareObjSource();
            dVar.aGj = b(this.atD);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.atD);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGi);
            bundle.putInt("obj_type", dVar.aGj);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajX);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.atD.getThreadType() == 49 || this.atD.getThreadType() == 60);
            com.baidu.tieba.c.e.akO().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.axw == 1) {
            return 5;
        }
        if (this.axw != 3) {
            if (this.axw == 4) {
                return 4;
            }
            if (this.axw != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bb bbVar) {
        if (bbVar == null || bbVar.vv() == null) {
            return null;
        }
        ArrayList<MediaData> vv = bbVar.vv();
        int size = vv.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = vv.get(i);
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

    private int b(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.vm()) {
                return 4;
            }
            if (bbVar.vh() == 1) {
                return 3;
            }
            return bbVar.wn() ? 2 : 1;
        }
        return 0;
    }

    private void H(View view) {
        if (this.axg == null) {
            this.axg = new ae(this.mPageContext, this.axH);
        }
        this.axg.setData(this.atD);
        com.baidu.adp.lib.g.g.a(this.axg, this.mPageContext);
        TiebaStatic.log(new an("c12711"));
    }

    private void I(View view) {
        AP();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.axn = z;
        if (this.awO != null) {
            this.awO.setClickable(this.axn);
        }
    }

    public boolean isMoreViewVisible() {
        return this.axa != null && this.axa.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.axx = i;
        }
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.atD = bbVar;
        AN();
        c(bbVar);
        e(bbVar);
        updatePraiseNum(bbVar);
        f(bbVar);
        g(bbVar);
        d(bbVar);
        h(bbVar);
        setVisibility(this.axk ? 0 : 8);
        return this.axk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AN() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(bb bbVar) {
        this.awO.setVisibility(8);
    }

    protected void d(bb bbVar) {
        int ah;
        if (this.axj != null && this.axh != null && this.axi != null && bbVar != null) {
            if (!this.axH) {
                if (this.axE != null) {
                    this.axE.setVisibility(8);
                }
                this.axj.setVisibility(8);
            } else if (this.axv && com.baidu.tieba.frs.a.atD().atE()) {
                if (this.axE == null) {
                    this.axE = new View(getContext());
                    am.j(this.axE, d.C0140d.cp_bg_line_d);
                    addView(this.axE);
                    this.axE.setAlpha(0.5f);
                    this.axE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.axh.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.axE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.axh.performClick();
                        }
                    });
                }
                if (bbVar.wI()) {
                    ah = com.baidu.adp.lib.util.l.ah(getContext());
                } else {
                    ah = (com.baidu.adp.lib.util.l.ah(getContext()) / 4) * 3;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.axE.getLayoutParams();
                if (layoutParams == null) {
                    this.axE.setLayoutParams(new FrameLayout.LayoutParams(ah, -1));
                } else {
                    layoutParams.width = ah;
                    requestLayout();
                }
                am.h(this.axi, this.atD.wH() ? d.C0140d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
                this.axh.setImageDrawable(am.getDrawable(bbVar.wH() ? d.f.icon_card_frs_select_ok_n : d.f.btn_forum_select));
                this.axE.setVisibility(0);
                this.axj.setVisibility(0);
            } else {
                if (this.axE != null) {
                    this.axE.setVisibility(8);
                }
                this.axj.setVisibility(8);
            }
        }
    }

    private void e(bb bbVar) {
        String y;
        if (this.awP != null && bbVar != null) {
            if (bbVar.vd() <= 0 || !this.axm) {
                this.awP.setVisibility(8);
                return;
            }
            this.awP.setVisibility(0);
            if (this.mFrom == 3) {
                y = ap.v(bbVar.vd());
            } else {
                y = ap.y(bbVar.vd() * 1000);
            }
            this.awP.setText(y);
            this.axk = true;
        }
    }

    public boolean isVisible() {
        return this.axk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bb bbVar) {
        if (this.awT != null && bbVar != null) {
            if (this.axr) {
                this.awV.setVisibility(0);
                if (this.awV.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awV.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awV.setLayoutParams(layoutParams);
                }
                if (bbVar.vb() > 0) {
                    this.awT.setVisibility(0);
                    String H = ap.H(bbVar.vb());
                    if (this.axo) {
                        this.awU.setImageDrawable(am.getDrawable(this.axB));
                        this.awT.setText(H);
                    } else {
                        this.awT.setText(String.format(this.mContext.getString(d.j.reply_num_tip), H));
                    }
                    this.awT.setContentDescription(this.mContext.getString(d.j.reply_num) + H);
                    this.axk = true;
                    return;
                } else if (this.axo) {
                    this.awU.setImageDrawable(am.getDrawable(this.axB));
                    this.awT.setText(this.mContext.getString(d.j.action_comment_default));
                    this.awT.setVisibility(0);
                    this.axk = true;
                    return;
                } else {
                    this.awT.setVisibility(8);
                    return;
                }
            }
            this.awV.setVisibility(8);
        }
    }

    public void updatePraiseNum(bb bbVar) {
        if (this.awS != null && this.awR != null && this.awQ != null && bbVar != null) {
            if (this.axl) {
                this.awS.setVisibility(0);
                if (this.awS.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awS.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awS.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.awR.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.awR.setLayoutParams(layoutParams2);
                int wu = bbVar.wu();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (wu > 0) {
                    string = ap.H(wu);
                }
                this.awQ.setText(string);
                this.awQ.setContentDescription(this.mContext.getString(d.j.zan_num) + wu);
                this.axk = true;
                if (bbVar.wv() != 0) {
                    this.axA = AO() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.awR.setImageDrawable(am.getDrawable(this.axA));
                    if (this.awQ != null) {
                        am.h(this.awQ, d.C0140d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.axA = AO() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.awR.setImageDrawable(am.getDrawable(this.axA));
                if (this.awQ != null) {
                    am.h(this.awQ, d.C0140d.cp_cont_j);
                    return;
                }
                return;
            }
            this.awS.setVisibility(8);
        }
    }

    private boolean AO() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bb bbVar) {
        if (this.awY != null && this.awW != null && bbVar != null) {
            if (this.axt) {
                this.awY.setVisibility(0);
                if (this.awY.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awY.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awY.setLayoutParams(layoutParams);
                }
                long ww = bbVar.ww();
                if ((bbVar.wm() || bbVar.wp()) && bbVar.vD() != null) {
                    ww = bbVar.vD().share_info.share_count;
                }
                this.awW.setText(ww > 0 ? ap.H(ww) : this.mContext.getString(d.j.share));
                this.axk = true;
                if (bbVar.ajH != null && bbVar.ajH.isDeleted) {
                    am.i(this.awX, d.f.icon_card_share_d);
                    am.h(this.awW, d.C0140d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                am.i(this.awX, this.axC);
                am.h(this.awW, d.f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.awY.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.axa != null) {
            if (this.atD == null || w.z(this.atD.wj()) || !TbadkCoreApplication.isLogin() || this.atD.wk()) {
                this.axa.setVisibility(8);
                return;
            }
            if (this.axa.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axa.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.axa.setLayoutParams(layoutParams);
            }
            if (this.axb == null) {
                this.axb = new ArrayList();
            } else {
                this.axb.clear();
            }
            if (this.axc == null) {
                this.axc = new ArrayList();
            } else {
                this.axc.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.atD.wj()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.axb.add(reportInfo.info);
                    this.axc.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.axa.setOnClickListener(this);
                this.axa.setVisibility(0);
                return;
            }
            this.axa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bb bbVar) {
        if (this.axf != null && bbVar != null) {
            if (bbVar.ajQ != null) {
                this.axu = false;
            }
            if (this.axu && (this.axj == null || this.axj.getVisibility() == 8)) {
                this.axf.setVisibility(0);
                if (this.axf.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axf.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.axf.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.axd.setText(string);
                this.axd.setContentDescription(string);
                this.axk = true;
                return;
            }
            this.axf.setVisibility(8);
        }
    }

    private void AP() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.ci(d.j.operation);
            bVar.a(this.axb, new b.InterfaceC0101b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) w.d(ThreadCommentAndPraiseInfoLayout.this.axc, i);
                    if (!StringUtils.isNull(str)) {
                        ay.zK().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xi();
        }
    }

    public void onChangeSkinType() {
        am.h(this.awO, d.C0140d.cp_cont_d);
        am.h(this.awP, d.C0140d.cp_cont_j);
        am.h(this.awQ, d.f.selector_comment_and_prise_item_text_color);
        am.h(this.awT, d.f.selector_comment_and_prise_item_text_color);
        am.h(this.axd, d.f.selector_comment_and_prise_item_text_color);
        am.i(this.awZ, d.f.btn_frs_more_selector);
        if (this.atD != null && this.atD.wv() == 1 && this.awQ != null) {
            am.h(this.awQ, d.C0140d.cp_cont_h);
            this.axA = d.f.icon_home_card_like_s;
        }
        if (this.awQ != null && this.axp && this.axA > 0) {
            this.awR.setImageDrawable(am.getDrawable(this.axA));
        }
        if (this.awT != null && this.axo && this.axB > 0) {
            this.awU.setImageDrawable(am.getDrawable(this.axB));
        }
        if (this.atD != null && this.atD.ajH != null && this.atD.ajH.isDeleted) {
            am.i(this.awX, d.f.icon_card_share_d);
            am.h(this.awW, d.C0140d.cp_cont_e);
            setShareClickable(false);
        } else {
            am.i(this.awX, this.axC);
            am.h(this.awW, d.f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.axe != null) {
            this.axe.setImageDrawable(am.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.axg != null) {
            this.axg.onChangeSkinType();
        }
        am.j(this.axE, d.C0140d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axz = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.awO;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.axI != null) {
            this.axI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.axI);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.axs = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.axm = z;
    }

    public View getCommentNumView() {
        return this.awT;
    }

    public View getCommentContainer() {
        return this.awV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Animation getScaleAnimation() {
        if (this.axD == null) {
            this.axD = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axD.setDuration(200L);
        }
        return this.axD;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.axo = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.axp = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.axq = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.axv = z;
    }

    public void setManageVisible(boolean z) {
        this.axu = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.axF = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.axh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.axG;
    }

    public void setInFrsAllThread(boolean z) {
        this.axH = z;
    }

    public boolean isInFrsAllThread() {
        return this.axH;
    }

    public void setShowCommonView() {
        setReplyTimeVisible(false);
        setIsBarViewVisible(false);
        setShowPraiseNum(true);
        setNeedAddPraiseIcon(true);
        setNeedAddReplyIcon(true);
        setShareVisible(true);
    }
}
