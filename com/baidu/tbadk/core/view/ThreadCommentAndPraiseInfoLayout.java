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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.p.at;
import com.baidu.tieba.card.ae;
import com.baidu.tieba.card.o;
import com.baidu.tieba.f;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    public int ajY;
    protected bb atE;
    protected int awK;
    protected TextView awL;
    private TextView awM;
    protected TextView awN;
    protected ImageView awO;
    protected View awP;
    protected TextView awQ;
    protected ImageView awR;
    protected View awS;
    protected TextView awT;
    protected ImageView awU;
    protected View awV;
    protected TextView awW;
    protected FrameLayout awX;
    private List<CharSequence> awY;
    private List<String> awZ;
    protected ScaleAnimation axA;
    private View axB;
    private a axC;
    private LinearLayout axD;
    private boolean axE;
    private CustomMessageListener axF;
    protected TextView axa;
    protected ImageView axb;
    protected View axc;
    private ae axd;
    protected ImageView axe;
    protected TextView axf;
    protected LinearLayout axg;
    protected boolean axh;
    protected boolean axi;
    private boolean axj;
    protected boolean axk;
    protected boolean axl;
    private boolean axm;
    protected boolean axn;
    protected boolean axo;
    private boolean axp;
    protected boolean axq;
    protected boolean axr;
    protected boolean axs;
    private int axt;
    private int axu;
    private String axv;
    private View.OnClickListener axw;
    protected int axx;
    protected int axy;
    protected int axz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    /* loaded from: classes2.dex */
    public interface a {
        void aV(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.axv = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.axt = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.awK = 0;
        this.axh = false;
        this.axi = true;
        this.axj = true;
        this.axk = true;
        this.axl = false;
        this.axm = false;
        this.axn = false;
        this.axo = true;
        this.axp = false;
        this.axq = true;
        this.axr = false;
        this.axs = true;
        this.mFrom = 2;
        this.axt = 1;
        this.axC = null;
        this.axE = false;
        this.axF = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && ThreadCommentAndPraiseInfoLayout.this.atE != null && ThreadCommentAndPraiseInfoLayout.this.atE.getId() != null) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bbVar.getId()) && bbVar.uW() != null && bbVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.atE.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.atE.uW() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.atE.uW().setNum(bbVar.uW().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.atE);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awK = 0;
        this.axh = false;
        this.axi = true;
        this.axj = true;
        this.axk = true;
        this.axl = false;
        this.axm = false;
        this.axn = false;
        this.axo = true;
        this.axp = false;
        this.axq = true;
        this.axr = false;
        this.axs = true;
        this.mFrom = 2;
        this.axt = 1;
        this.axC = null;
        this.axE = false;
        this.axF = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb) && ThreadCommentAndPraiseInfoLayout.this.atE != null && ThreadCommentAndPraiseInfoLayout.this.atE.getId() != null) {
                    bb bbVar = (bb) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bbVar.getId()) && bbVar.uW() != null && bbVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.atE.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.atE.uW() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.atE.uW().setNum(bbVar.uW().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.atE);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.awK = com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(f.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.awL = (TextView) inflate.findViewById(f.g.thread_info_bar_name);
        this.awM = (TextView) inflate.findViewById(f.g.thread_info_reply_time);
        this.axD = (LinearLayout) inflate.findViewById(f.g.thread_comment_layout_root);
        this.awQ = (TextView) inflate.findViewById(f.g.thread_info_commont_num);
        this.awR = (ImageView) inflate.findViewById(f.g.thread_info_commont_img);
        this.awS = inflate.findViewById(f.g.thread_info_commont_container);
        this.awT = (TextView) inflate.findViewById(f.g.share_num);
        this.awU = (ImageView) inflate.findViewById(f.g.share_num_img);
        this.awV = inflate.findViewById(f.g.share_num_container);
        this.awW = (TextView) inflate.findViewById(f.g.thread_info_more);
        this.awX = (FrameLayout) inflate.findViewById(f.g.thread_info_more_frame);
        this.awN = (TextView) inflate.findViewById(f.g.thread_info_praise_num);
        this.awO = (ImageView) inflate.findViewById(f.g.thread_info_praise_img);
        this.awP = inflate.findViewById(f.g.agree_view_container);
        this.axc = inflate.findViewById(f.g.manage_view_container);
        this.axa = (TextView) inflate.findViewById(f.g.thread_info_manage_text);
        this.axb = (ImageView) inflate.findViewById(f.g.thread_info_manage_img);
        this.axe = (ImageView) inflate.findViewById(f.g.manage_select_img);
        this.axf = (TextView) inflate.findViewById(f.g.manage_select_text);
        this.axg = (LinearLayout) inflate.findViewById(f.g.manage_select_container);
        this.axg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.axe.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.axf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.axe.performClick();
            }
        });
        this.axg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.axe.performClick();
            }
        });
        this.awP.setOnClickListener(this);
        this.awS.setOnClickListener(this);
        this.awV.setOnClickListener(this);
        this.axc.setOnClickListener(this);
        this.axe.setOnClickListener(this);
        this.axz = f.C0146f.icon_home_card_share;
        this.axy = f.C0146f.icon_home_card_comment;
        this.axu = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.awL) {
            D(view);
        } else if (view == this.awS) {
            E(view);
        } else if (view == this.awP) {
            F(view);
        } else if (view == this.awV) {
            G(view);
        } else if (view == this.awX) {
            I(view);
        } else if (view == this.axc) {
            H(view);
        } else if (view == this.axe) {
            C(view);
        }
    }

    protected void C(View view) {
        if (this.axe != null && this.atE != null && this.axf != null && !this.atE.wH()) {
            if (!this.atE.wG()) {
                if (com.baidu.tieba.frs.a.atC().U(this.atE)) {
                    this.atE.at(true);
                }
            } else {
                com.baidu.tieba.frs.a.atC().V(this.atE);
                this.atE.at(false);
            }
            am.h(this.axf, this.atE.wG() ? f.d.cp_link_tip_a : f.C0146f.selector_comment_and_prise_item_text_color);
            this.axe.setImageDrawable(am.getDrawable(this.atE.wG() ? f.C0146f.icon_card_frs_select_ok_n : f.C0146f.btn_forum_select));
            if (this.axC != null) {
                this.axC.aV(this.atE.wG());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.axd != null) {
            this.axd.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.awS != null) {
            this.awS.setClickable(z);
            this.awR.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.awP != null) {
            this.awP.setClickable(z);
            this.awO.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.awV != null) {
            this.awV.setEnabled(z);
            this.awU.setEnabled(z);
        }
    }

    private void D(View view) {
        if (this.atE != null && !StringUtils.isNull(this.atE.vp())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.axv)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.atE.vp(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.atE.vp(), this.mStType, this.axv)));
            }
            if (this.axw != null) {
                this.axw.onClick(view);
            }
        }
    }

    private void E(View view) {
        if (this.atE != null && this.mContext != null) {
            o.kY(this.atE.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.atE, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.atE.getFid()));
            addLocateParam.setForumName(this.atE.vp());
            if (this.atE.wL() && this.atE.wK() != null) {
                addLocateParam.setForumId(this.atE.wK().getForumId());
                addLocateParam.setForumName(this.atE.wK().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            if (this.atE.vY() && addLocateParam.getIntent() != null) {
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
            anVar2.ae("tid", this.atE.getTid());
            TiebaStatic.log(anVar2);
            if (this.axw != null) {
                this.axw.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.atE == null) {
            return 0;
        }
        if (this.atE.isShareThread) {
            return 4;
        }
        if (this.atE.getThreadType() == 49) {
            return 5;
        }
        if (this.atE.vB() != null) {
            return 1;
        }
        if (this.atE.getType() == bb.ahx || this.atE.getType() == bb.ahz) {
            if (w.y(this.atE.vy()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    protected void F(View view) {
        int i = 1;
        if (com.baidu.tbadk.core.util.bb.aU(this.mContext) && this.atE != null) {
            if (this.atE.wu() != 0) {
                this.atE.cc(this.atE.wt() - 1);
                this.atE.cb(0);
                if (this.awN != null) {
                    am.h(this.awN, f.d.cp_cont_j);
                }
            } else {
                this.atE.cb(1);
                this.atE.cc(this.atE.wt() + 1);
                if (this.awN != null) {
                    am.h(this.awN, f.d.cp_cont_h);
                }
                com.baidu.tieba.n.a.bmW().y(this.mPageContext);
                i = 0;
            }
            updatePraiseNum(this.atE);
            if (this.awO != null && i == 0) {
                this.awO.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.atE.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            if (this.axu > 0) {
                httpMessage.addParam("forum_id", this.atE.getFid());
            }
            if (this.mPageContext != null) {
                httpMessage.setTag(this.mPageContext.getUniqueId());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            an anVar = new an("c12003");
            anVar.ae("tid", this.atE.getTid());
            if (this.atE.getThreadType() == 40) {
                anVar.ae("obj_param1", "2");
            } else if (this.atE.getThreadType() == 0) {
                anVar.ae("obj_param1", "1");
            }
            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            anVar.f(ImageViewerConfig.FORUM_ID, this.atE.getFid());
            anVar.r("obj_locate", this.mFrom);
            anVar.r(VideoPlayActivityConfig.OBJ_ID, i);
            if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.ae("obj_param2", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            if (this.axw != null) {
                this.axw.onClick(view);
            }
        }
    }

    protected void G(View view) {
        if (at.iq() || com.baidu.tbadk.core.util.bb.aU(this.mContext)) {
            AI();
            AJ();
            if (this.axw != null) {
                this.axw.onClick(view);
            }
        }
    }

    private void AI() {
        int i = 4;
        if (this.atE != null) {
            if (this.axt != 1) {
                if (this.axt == 2) {
                    i = 5;
                } else if (this.axt == 3) {
                    i = 3;
                } else if (this.axt == 4) {
                    i = 2;
                } else if (this.axt == 6) {
                    i = 8;
                } else if (this.axt != 7) {
                    i = 0;
                } else {
                    i = 9;
                }
            }
            an anVar = new an("c12386");
            anVar.f(ImageViewerConfig.FORUM_ID, this.atE.getFid());
            anVar.ae("tid", this.atE.getTid());
            anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.r("obj_locate", i);
            if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
        }
    }

    private void AJ() {
        if (this.atE != null && this.mContext != null) {
            String valueOf = String.valueOf(this.atE.getFid());
            String vp = this.atE.vp();
            if (this.atE.ajQ != null) {
                valueOf = this.atE.ajQ.id;
                vp = this.atE.ajQ.ori_fname;
            }
            String title = this.atE.getTitle();
            String tid = this.atE.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a2 = a(this.atE);
            Uri parse = a2 == null ? null : Uri.parse(a2);
            String str2 = this.atE.getAbstract();
            String format = MessageFormat.format(getResources().getString(f.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aGe = str2;
            dVar.linkUrl = str;
            dVar.ajX = this.axt;
            dVar.extData = tid;
            dVar.aGh = 3;
            dVar.fid = valueOf;
            dVar.aGa = vp;
            dVar.tid = tid;
            dVar.aFW = true;
            dVar.aGg = getShareObjSource();
            dVar.aGi = b(this.atE);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.atE);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGh);
            bundle.putInt("obj_type", dVar.aGi);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajX);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.atE.getThreadType() == 49 || this.atE.getThreadType() == 60);
            com.baidu.tieba.c.e.akQ().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.axt == 1) {
            return 5;
        }
        if (this.axt != 3) {
            if (this.axt == 4) {
                return 4;
            }
            if (this.axt != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bb bbVar) {
        if (bbVar == null || bbVar.vu() == null) {
            return null;
        }
        ArrayList<MediaData> vu = bbVar.vu();
        int size = vu.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = vu.get(i);
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
            if (bbVar.vl()) {
                return 4;
            }
            if (bbVar.vg() == 1) {
                return 3;
            }
            return bbVar.wm() ? 2 : 1;
        }
        return 0;
    }

    private void H(View view) {
        if (this.axd == null) {
            this.axd = new ae(this.mPageContext, this.axE);
        }
        this.axd.setData(this.atE);
        com.baidu.adp.lib.g.g.a(this.axd, this.mPageContext);
        TiebaStatic.log(new an("c12711"));
    }

    private void I(View view) {
        AM();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.axk = z;
        if (this.awL != null) {
            this.awL.setClickable(this.axk);
        }
    }

    public boolean isMoreViewVisible() {
        return this.awX != null && this.awX.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.axu = i;
        }
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.atE = bbVar;
        AK();
        c(bbVar);
        e(bbVar);
        updatePraiseNum(bbVar);
        f(bbVar);
        g(bbVar);
        d(bbVar);
        h(bbVar);
        setVisibility(this.axh ? 0 : 8);
        return this.axh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AK() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(bb bbVar) {
        this.awL.setVisibility(8);
    }

    protected void d(bb bbVar) {
        int ah;
        if (this.axg != null && this.axe != null && this.axf != null && bbVar != null) {
            if (!this.axE) {
                if (this.axB != null) {
                    this.axB.setVisibility(8);
                }
                this.axg.setVisibility(8);
            } else if (this.axs && com.baidu.tieba.frs.a.atC().atD()) {
                if (this.axB == null) {
                    this.axB = new View(getContext());
                    am.j(this.axB, f.d.cp_bg_line_d);
                    addView(this.axB);
                    this.axB.setAlpha(0.5f);
                    this.axB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.axe.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.axB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.axe.performClick();
                        }
                    });
                }
                if (bbVar.wH()) {
                    ah = com.baidu.adp.lib.util.l.ah(getContext());
                } else {
                    ah = (com.baidu.adp.lib.util.l.ah(getContext()) / 4) * 3;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.axB.getLayoutParams();
                if (layoutParams == null) {
                    this.axB.setLayoutParams(new FrameLayout.LayoutParams(ah, -1));
                } else {
                    layoutParams.width = ah;
                    requestLayout();
                }
                am.h(this.axf, this.atE.wG() ? f.d.cp_link_tip_a : f.C0146f.selector_comment_and_prise_item_text_color);
                this.axe.setImageDrawable(am.getDrawable(bbVar.wG() ? f.C0146f.icon_card_frs_select_ok_n : f.C0146f.btn_forum_select));
                this.axB.setVisibility(0);
                this.axg.setVisibility(0);
            } else {
                if (this.axB != null) {
                    this.axB.setVisibility(8);
                }
                this.axg.setVisibility(8);
            }
        }
    }

    private void e(bb bbVar) {
        String y;
        if (this.awM != null && bbVar != null) {
            if (bbVar.vc() <= 0 || !this.axj) {
                this.awM.setVisibility(8);
                return;
            }
            this.awM.setVisibility(0);
            if (this.mFrom == 3) {
                y = ap.v(bbVar.vc());
            } else {
                y = ap.y(bbVar.vc() * 1000);
            }
            this.awM.setText(y);
            this.axh = true;
        }
    }

    public boolean isVisible() {
        return this.axh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bb bbVar) {
        if (this.awQ != null && bbVar != null) {
            if (this.axo) {
                this.awS.setVisibility(0);
                if (this.awS.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awS.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awS.setLayoutParams(layoutParams);
                }
                if (bbVar.va() > 0) {
                    this.awQ.setVisibility(0);
                    String H = ap.H(bbVar.va());
                    if (this.axl) {
                        this.awR.setImageDrawable(am.getDrawable(this.axy));
                        this.awQ.setText(H);
                    } else {
                        this.awQ.setText(String.format(this.mContext.getString(f.j.reply_num_tip), H));
                    }
                    this.awQ.setContentDescription(this.mContext.getString(f.j.reply_num) + H);
                    this.axh = true;
                    return;
                } else if (this.axl) {
                    this.awR.setImageDrawable(am.getDrawable(this.axy));
                    this.awQ.setText(this.mContext.getString(f.j.action_comment_default));
                    this.awQ.setVisibility(0);
                    this.axh = true;
                    return;
                } else {
                    this.awQ.setVisibility(8);
                    return;
                }
            }
            this.awS.setVisibility(8);
        }
    }

    public void updatePraiseNum(bb bbVar) {
        if (this.awP != null && this.awO != null && this.awN != null && bbVar != null) {
            if (this.axi) {
                this.awP.setVisibility(0);
                if (this.awP.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awP.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awP.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.awO.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.awO.setLayoutParams(layoutParams2);
                int wt = bbVar.wt();
                String string = this.mContext.getString(f.j.action_praise_default);
                if (wt > 0) {
                    string = ap.H(wt);
                }
                this.awN.setText(string);
                this.awN.setContentDescription(this.mContext.getString(f.j.zan_num) + wt);
                this.axh = true;
                if (bbVar.wu() != 0) {
                    this.axx = AL() ? f.C0146f.icon_home_card_like_s_xmas : f.C0146f.icon_home_card_like_s;
                    this.awO.setImageDrawable(am.getDrawable(this.axx));
                    if (this.awN != null) {
                        am.h(this.awN, f.d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.axx = AL() ? f.C0146f.icon_home_card_like_n_xmas : f.C0146f.icon_home_card_like_n;
                this.awO.setImageDrawable(am.getDrawable(this.axx));
                if (this.awN != null) {
                    am.h(this.awN, f.d.cp_cont_j);
                    return;
                }
                return;
            }
            this.awP.setVisibility(8);
        }
    }

    private boolean AL() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bb bbVar) {
        if (this.awV != null && this.awT != null && bbVar != null) {
            if (this.axq) {
                this.awV.setVisibility(0);
                if (this.awV.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awV.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awV.setLayoutParams(layoutParams);
                }
                long wv = bbVar.wv();
                if ((bbVar.wl() || bbVar.wo()) && bbVar.vC() != null) {
                    wv = bbVar.vC().share_info.share_count;
                }
                this.awT.setText(wv > 0 ? ap.H(wv) : this.mContext.getString(f.j.share));
                this.axh = true;
                if (bbVar.ajH != null && bbVar.ajH.isDeleted) {
                    am.i(this.awU, f.C0146f.icon_card_share_d);
                    am.h(this.awT, f.d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                am.i(this.awU, this.axz);
                am.h(this.awT, f.C0146f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.awV.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.awX != null) {
            if (this.atE == null || w.z(this.atE.wi()) || !TbadkCoreApplication.isLogin() || this.atE.wj()) {
                this.awX.setVisibility(8);
                return;
            }
            if (this.awX.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awX.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.awX.setLayoutParams(layoutParams);
            }
            if (this.awY == null) {
                this.awY = new ArrayList();
            } else {
                this.awY.clear();
            }
            if (this.awZ == null) {
                this.awZ = new ArrayList();
            } else {
                this.awZ.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.atE.wi()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.awY.add(reportInfo.info);
                    this.awZ.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.awX.setOnClickListener(this);
                this.awX.setVisibility(0);
                return;
            }
            this.awX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bb bbVar) {
        if (this.axc != null && bbVar != null) {
            if (bbVar.ajQ != null) {
                this.axr = false;
            }
            if (this.axr && (this.axg == null || this.axg.getVisibility() == 8)) {
                this.axc.setVisibility(0);
                if (this.axc.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axc.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.axc.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(f.j.manage);
                this.axa.setText(string);
                this.axa.setContentDescription(string);
                this.axh = true;
                return;
            }
            this.axc.setVisibility(8);
        }
    }

    private void AM() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.ci(f.j.operation);
            bVar.a(this.awY, new b.InterfaceC0101b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) w.d(ThreadCommentAndPraiseInfoLayout.this.awZ, i);
                    if (!StringUtils.isNull(str)) {
                        az.zI().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xh();
        }
    }

    public void onChangeSkinType() {
        am.h(this.awL, f.d.cp_cont_d);
        am.h(this.awM, f.d.cp_cont_j);
        am.h(this.awN, f.C0146f.selector_comment_and_prise_item_text_color);
        am.h(this.awQ, f.C0146f.selector_comment_and_prise_item_text_color);
        am.h(this.axa, f.C0146f.selector_comment_and_prise_item_text_color);
        am.i(this.awW, f.C0146f.btn_frs_more_selector);
        if (this.atE != null && this.atE.wu() == 1 && this.awN != null) {
            am.h(this.awN, f.d.cp_cont_h);
            this.axx = f.C0146f.icon_home_card_like_s;
        }
        if (this.awN != null && this.axm && this.axx > 0) {
            this.awO.setImageDrawable(am.getDrawable(this.axx));
        }
        if (this.awQ != null && this.axl && this.axy > 0) {
            this.awR.setImageDrawable(am.getDrawable(this.axy));
        }
        if (this.atE != null && this.atE.ajH != null && this.atE.ajH.isDeleted) {
            am.i(this.awU, f.C0146f.icon_card_share_d);
            am.h(this.awT, f.d.cp_cont_e);
            setShareClickable(false);
        } else {
            am.i(this.awU, this.axz);
            am.h(this.awT, f.C0146f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.axb != null) {
            this.axb.setImageDrawable(am.getDrawable(f.C0146f.icon_card_frs_manage_selector));
        }
        if (this.axd != null) {
            this.axd.onChangeSkinType();
        }
        am.j(this.axB, f.d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axw = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.awL;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.axF != null) {
            this.axF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.axF);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.axp = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.axj = z;
    }

    public View getCommentNumView() {
        return this.awQ;
    }

    public View getCommentContainer() {
        return this.awS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Animation getScaleAnimation() {
        if (this.axA == null) {
            this.axA = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axA.setDuration(200L);
        }
        return this.axA;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.axl = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.axm = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.axn = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.axs = z;
    }

    public void setManageVisible(boolean z) {
        this.axr = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.axC = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.axe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.axD;
    }

    public void setInFrsAllThread(boolean z) {
        this.axE = z;
    }

    public boolean isInFrsAllThread() {
        return this.axE;
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
