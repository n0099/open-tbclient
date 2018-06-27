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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.o.as;
import com.baidu.tieba.card.ae;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    public int akz;
    protected bc atZ;
    private ae axA;
    protected ImageView axB;
    protected TextView axC;
    protected LinearLayout axD;
    protected boolean axE;
    protected boolean axF;
    private boolean axG;
    protected boolean axH;
    protected boolean axI;
    private boolean axJ;
    protected boolean axK;
    protected boolean axL;
    private boolean axM;
    protected boolean axN;
    protected boolean axO;
    protected boolean axP;
    private int axQ;
    private int axR;
    private String axS;
    private View.OnClickListener axT;
    protected int axU;
    protected int axV;
    protected int axW;
    protected ScaleAnimation axX;
    private View axY;
    private a axZ;
    protected int axh;
    protected TextView axi;
    private TextView axj;
    protected TextView axk;
    protected ImageView axl;
    protected View axm;
    protected TextView axn;
    protected ImageView axo;
    protected View axp;
    protected TextView axq;
    protected ImageView axr;
    protected View axs;
    protected TextView axt;
    protected FrameLayout axu;
    private List<CharSequence> axv;
    private List<String> axw;
    protected TextView axx;
    protected ImageView axy;
    protected View axz;
    private LinearLayout aya;
    private boolean ayb;
    private CustomMessageListener ayc;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    /* loaded from: classes2.dex */
    public interface a {
        void aW(boolean z);
    }

    public void setYuelaouLocate(String str) {
        this.axS = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.axQ = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.axh = 0;
        this.axE = false;
        this.axF = true;
        this.axG = true;
        this.axH = true;
        this.axI = false;
        this.axJ = false;
        this.axK = false;
        this.axL = true;
        this.axM = false;
        this.axN = true;
        this.axO = false;
        this.axP = true;
        this.mFrom = 2;
        this.axQ = 1;
        this.axZ = null;
        this.ayb = false;
        this.ayc = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bc) && ThreadCommentAndPraiseInfoLayout.this.atZ != null && ThreadCommentAndPraiseInfoLayout.this.atZ.getId() != null) {
                    bc bcVar = (bc) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bcVar.getId()) && bcVar.vj() != null && bcVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.atZ.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.atZ.vj() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.atZ.vj().setNum(bcVar.vj().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.atZ);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axh = 0;
        this.axE = false;
        this.axF = true;
        this.axG = true;
        this.axH = true;
        this.axI = false;
        this.axJ = false;
        this.axK = false;
        this.axL = true;
        this.axM = false;
        this.axN = true;
        this.axO = false;
        this.axP = true;
        this.mFrom = 2;
        this.axQ = 1;
        this.axZ = null;
        this.ayb = false;
        this.ayc = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bc) && ThreadCommentAndPraiseInfoLayout.this.atZ != null && ThreadCommentAndPraiseInfoLayout.this.atZ.getId() != null) {
                    bc bcVar = (bc) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bcVar.getId()) && bcVar.vj() != null && bcVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.atZ.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.atZ.vj() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.atZ.vj().setNum(bcVar.vj().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.atZ);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.axh = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.axi = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.axj = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.aya = (LinearLayout) inflate.findViewById(d.g.thread_comment_layout_root);
        this.axn = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.axo = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.axp = inflate.findViewById(d.g.thread_info_commont_container);
        this.axq = (TextView) inflate.findViewById(d.g.share_num);
        this.axr = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.axs = inflate.findViewById(d.g.share_num_container);
        this.axt = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.axu = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.axk = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.axl = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.axm = inflate.findViewById(d.g.agree_view_container);
        this.axz = inflate.findViewById(d.g.manage_view_container);
        this.axx = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.axy = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.axB = (ImageView) inflate.findViewById(d.g.manage_select_img);
        this.axC = (TextView) inflate.findViewById(d.g.manage_select_text);
        this.axD = (LinearLayout) inflate.findViewById(d.g.manage_select_container);
        this.axD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ThreadCommentAndPraiseInfoLayout.this.axB.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.axC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.axB.performClick();
            }
        });
        this.axD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.axB.performClick();
            }
        });
        this.axm.setOnClickListener(this);
        this.axp.setOnClickListener(this);
        this.axs.setOnClickListener(this);
        this.axz.setOnClickListener(this);
        this.axB.setOnClickListener(this);
        this.axW = d.f.icon_home_card_share;
        this.axV = d.f.icon_home_card_comment;
        this.axR = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.axi) {
            D(view);
        } else if (view == this.axp) {
            E(view);
        } else if (view == this.axm) {
            F(view);
        } else if (view == this.axs) {
            G(view);
        } else if (view == this.axu) {
            I(view);
        } else if (view == this.axz) {
            H(view);
        } else if (view == this.axB) {
            C(view);
        }
    }

    protected void C(View view) {
        if (this.axB != null && this.atZ != null && this.axC != null && !this.atZ.wT()) {
            if (!this.atZ.wS()) {
                if (com.baidu.tieba.frs.a.asZ().S(this.atZ)) {
                    this.atZ.av(true);
                }
            } else {
                com.baidu.tieba.frs.a.asZ().T(this.atZ);
                this.atZ.av(false);
            }
            am.h(this.axC, this.atZ.wS() ? d.C0142d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
            this.axB.setImageDrawable(am.getDrawable(this.atZ.wS() ? d.f.icon_card_frs_select_ok_n : d.f.btn_forum_select));
            if (this.axZ != null) {
                this.axZ.aW(this.atZ.wS());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.axA != null) {
            this.axA.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.axp != null) {
            this.axp.setClickable(z);
            this.axo.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.axm != null) {
            this.axm.setClickable(z);
            this.axl.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.axs != null) {
            this.axs.setEnabled(z);
            this.axr.setEnabled(z);
        }
    }

    private void D(View view) {
        if (this.atZ != null && !StringUtils.isNull(this.atZ.vB())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.axS)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.atZ.vB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.atZ.vB(), this.mStType, this.axS)));
            }
            if (this.axT != null) {
                this.axT.onClick(view);
            }
        }
    }

    private void E(View view) {
        if (this.atZ != null && this.mContext != null) {
            o.kY(this.atZ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.atZ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.atZ.getFid()));
            addLocateParam.setForumName(this.atZ.vB());
            addLocateParam.setJumpToCommentArea(true);
            if (this.atZ.wk() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.akz);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            an anVar = new an("c12291");
            anVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(anVar);
            an anVar2 = new an("c12942");
            anVar2.r("obj_locate", this.mFrom);
            anVar2.r("obj_type", getThreadType());
            anVar2.ah("tid", this.atZ.getTid());
            TiebaStatic.log(anVar2);
            if (this.axT != null) {
                this.axT.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.atZ == null) {
            return 0;
        }
        if (this.atZ.isShareThread) {
            return 4;
        }
        if (this.atZ.getThreadType() == 49) {
            return 5;
        }
        if (this.atZ.vN() != null) {
            return 1;
        }
        if (this.atZ.getType() == bc.aib || this.atZ.getType() == bc.aid) {
            if (w.z(this.atZ.vK()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    protected void F(View view) {
        int i = 1;
        if (bb.aU(this.mContext) && this.atZ != null) {
            if (this.atZ.wG() != 0) {
                this.atZ.ca(this.atZ.wF() - 1);
                this.atZ.bZ(0);
                if (this.axk != null) {
                    am.h(this.axk, d.C0142d.cp_cont_j);
                }
            } else {
                this.atZ.bZ(1);
                this.atZ.ca(this.atZ.wF() + 1);
                if (this.axk != null) {
                    am.h(this.axk, d.C0142d.cp_cont_h);
                }
                com.baidu.tieba.n.a.bor().y(this.mPageContext);
                i = 0;
            }
            updatePraiseNum(this.atZ);
            if (this.axl != null && i == 0) {
                this.axl.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.atZ.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            if (this.axR > 0) {
                httpMessage.addParam("forum_id", this.atZ.getFid());
            }
            if (this.mPageContext != null) {
                httpMessage.setTag(this.mPageContext.getUniqueId());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            an anVar = new an("c12003");
            anVar.ah("tid", this.atZ.getTid());
            if (this.atZ.getThreadType() == 40) {
                anVar.ah("obj_param1", "2");
            } else if (this.atZ.getThreadType() == 0) {
                anVar.ah("obj_param1", "1");
            }
            anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            anVar.f(ImageViewerConfig.FORUM_ID, this.atZ.getFid());
            anVar.r("obj_locate", this.mFrom);
            anVar.r(VideoPlayActivityConfig.OBJ_ID, i);
            TiebaStatic.log(anVar);
        }
    }

    protected void G(View view) {
        if (as.ip() || bb.aU(this.mContext)) {
            AU();
            AV();
        }
    }

    private void AU() {
        int i = 4;
        if (this.atZ != null) {
            if (this.axQ != 1) {
                if (this.axQ == 2) {
                    i = 5;
                } else if (this.axQ == 3) {
                    i = 3;
                } else if (this.axQ == 4) {
                    i = 2;
                } else if (this.axQ != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new an("c12386").f(ImageViewerConfig.FORUM_ID, this.atZ.getFid()).ah("tid", this.atZ.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void AV() {
        if (this.atZ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.atZ.getFid());
            String vB = this.atZ.vB();
            if (this.atZ.akt != null) {
                valueOf = this.atZ.akt.id;
                vB = this.atZ.akt.ori_fname;
            }
            String title = this.atZ.getTitle();
            String tid = this.atZ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a2 = a(this.atZ);
            Uri parse = a2 == null ? null : Uri.parse(a2);
            String str2 = this.atZ.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.k.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aGf = str2;
            dVar.linkUrl = str;
            dVar.aky = this.axQ;
            dVar.extData = tid;
            dVar.aGi = 3;
            dVar.fid = valueOf;
            dVar.aGb = vB;
            dVar.tid = tid;
            dVar.aFX = true;
            dVar.aGh = getShareObjSource();
            dVar.aGj = b(this.atZ);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.atZ);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGi);
            bundle.putInt("obj_type", dVar.aGj);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aky);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.atZ.getThreadType() == 49 || this.atZ.getThreadType() == 60);
            com.baidu.tieba.c.e.akp().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.axQ == 1) {
            return 5;
        }
        if (this.axQ != 3) {
            if (this.axQ == 4) {
                return 4;
            }
            if (this.axQ != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bc bcVar) {
        if (bcVar == null || bcVar.vG() == null) {
            return null;
        }
        ArrayList<MediaData> vG = bcVar.vG();
        int size = vG.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = vG.get(i);
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

    private int b(bc bcVar) {
        if (bcVar != null) {
            if (bcVar.vy()) {
                return 4;
            }
            if (bcVar.vt() == 1) {
                return 3;
            }
            return bcVar.wy() ? 2 : 1;
        }
        return 0;
    }

    private void H(View view) {
        if (this.axA == null) {
            this.axA = new ae(this.mPageContext, this.ayb);
        }
        this.axA.setData(this.atZ);
        com.baidu.adp.lib.g.g.a(this.axA, this.mPageContext);
        TiebaStatic.log(new an("c12711"));
    }

    private void I(View view) {
        AY();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.axH = z;
        if (this.axi != null) {
            this.axi.setClickable(this.axH);
        }
    }

    public boolean isMoreViewVisible() {
        return this.axu != null && this.axu.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.axR = i;
        }
    }

    public boolean setData(bc bcVar) {
        if (bcVar == null) {
            setVisibility(8);
            return false;
        }
        this.atZ = bcVar;
        AW();
        c(bcVar);
        e(bcVar);
        updatePraiseNum(bcVar);
        f(bcVar);
        g(bcVar);
        d(bcVar);
        h(bcVar);
        setVisibility(this.axE ? 0 : 8);
        return this.axE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AW() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(bc bcVar) {
        this.axi.setVisibility(8);
    }

    protected void d(bc bcVar) {
        int ah;
        if (this.axD != null && this.axB != null && this.axC != null && bcVar != null) {
            if (!this.ayb) {
                if (this.axY != null) {
                    this.axY.setVisibility(8);
                }
                this.axD.setVisibility(8);
            } else if (this.axP && com.baidu.tieba.frs.a.asZ().ata()) {
                if (this.axY == null) {
                    this.axY = new View(getContext());
                    am.j(this.axY, d.C0142d.cp_bg_line_d);
                    addView(this.axY);
                    this.axY.setAlpha(0.5f);
                    this.axY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ThreadCommentAndPraiseInfoLayout.this.axB.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                    this.axY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ThreadCommentAndPraiseInfoLayout.this.axB.performClick();
                        }
                    });
                }
                if (bcVar.wT()) {
                    ah = com.baidu.adp.lib.util.l.ah(getContext());
                } else {
                    ah = (com.baidu.adp.lib.util.l.ah(getContext()) / 4) * 3;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.axY.getLayoutParams();
                if (layoutParams == null) {
                    this.axY.setLayoutParams(new FrameLayout.LayoutParams(ah, -1));
                } else {
                    layoutParams.width = ah;
                    requestLayout();
                }
                am.h(this.axC, this.atZ.wS() ? d.C0142d.cp_link_tip_a : d.f.selector_comment_and_prise_item_text_color);
                this.axB.setImageDrawable(am.getDrawable(bcVar.wS() ? d.f.icon_card_frs_select_ok_n : d.f.btn_forum_select));
                this.axY.setVisibility(0);
                this.axD.setVisibility(0);
            } else {
                if (this.axY != null) {
                    this.axY.setVisibility(8);
                }
                this.axD.setVisibility(8);
            }
        }
    }

    private void e(bc bcVar) {
        String x;
        if (this.axj != null && bcVar != null) {
            if (bcVar.vp() <= 0 || !this.axG) {
                this.axj.setVisibility(8);
                return;
            }
            this.axj.setVisibility(0);
            if (this.mFrom == 3) {
                x = ap.v(bcVar.vp());
            } else {
                x = ap.x(bcVar.vp() * 1000);
            }
            this.axj.setText(x);
            this.axE = true;
        }
    }

    public boolean isVisible() {
        return this.axE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bc bcVar) {
        if (this.axn != null && bcVar != null) {
            if (this.axL) {
                this.axp.setVisibility(0);
                if (this.axp.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axp.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.axp.setLayoutParams(layoutParams);
                }
                if (bcVar.vn() > 0) {
                    this.axn.setVisibility(0);
                    String F = ap.F(bcVar.vn());
                    if (this.axI) {
                        this.axo.setImageDrawable(am.getDrawable(this.axV));
                        this.axn.setText(F);
                    } else {
                        this.axn.setText(String.format(this.mContext.getString(d.k.reply_num_tip), F));
                    }
                    this.axn.setContentDescription(this.mContext.getString(d.k.reply_num) + F);
                    this.axE = true;
                    return;
                } else if (this.axI) {
                    this.axo.setImageDrawable(am.getDrawable(this.axV));
                    this.axn.setText(this.mContext.getString(d.k.action_comment_default));
                    this.axn.setVisibility(0);
                    this.axE = true;
                    return;
                } else {
                    this.axn.setVisibility(8);
                    return;
                }
            }
            this.axp.setVisibility(8);
        }
    }

    public void updatePraiseNum(bc bcVar) {
        if (this.axm != null && this.axl != null && this.axk != null && bcVar != null) {
            if (this.axF) {
                this.axm.setVisibility(0);
                if (this.axm.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axm.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.axm.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.axl.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.axl.setLayoutParams(layoutParams2);
                int wF = bcVar.wF();
                String string = this.mContext.getString(d.k.action_praise_default);
                if (wF > 0) {
                    string = ap.F(wF);
                }
                this.axk.setText(string);
                this.axk.setContentDescription(this.mContext.getString(d.k.zan_num) + wF);
                this.axE = true;
                if (bcVar.wG() != 0) {
                    this.axU = AX() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.axl.setImageDrawable(am.getDrawable(this.axU));
                    if (this.axk != null) {
                        am.h(this.axk, d.C0142d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.axU = AX() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.axl.setImageDrawable(am.getDrawable(this.axU));
                if (this.axk != null) {
                    am.h(this.axk, d.C0142d.cp_cont_j);
                    return;
                }
                return;
            }
            this.axm.setVisibility(8);
        }
    }

    private boolean AX() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bc bcVar) {
        if (this.axs != null && this.axq != null && bcVar != null) {
            if (this.axN) {
                this.axs.setVisibility(0);
                if (this.axs.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axs.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.axs.setLayoutParams(layoutParams);
                }
                long wH = bcVar.wH();
                if ((bcVar.wx() || bcVar.wA()) && bcVar.vO() != null) {
                    wH = bcVar.vO().share_info.share_count;
                }
                this.axq.setText(wH > 0 ? ap.F(wH) : this.mContext.getString(d.k.share));
                this.axE = true;
                if (bcVar.akk != null && bcVar.akk.isDeleted) {
                    am.i(this.axr, d.f.icon_card_share_d);
                    am.h(this.axq, d.C0142d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                am.i(this.axr, this.axW);
                am.h(this.axq, d.f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.axs.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.axu != null) {
            if (this.atZ == null || w.A(this.atZ.wu()) || !TbadkCoreApplication.isLogin() || this.atZ.wv()) {
                this.axu.setVisibility(8);
                return;
            }
            if (this.axu.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axu.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.axu.setLayoutParams(layoutParams);
            }
            if (this.axv == null) {
                this.axv = new ArrayList();
            } else {
                this.axv.clear();
            }
            if (this.axw == null) {
                this.axw = new ArrayList();
            } else {
                this.axw.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.atZ.wu()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.axv.add(reportInfo.info);
                    this.axw.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.axu.setOnClickListener(this);
                this.axu.setVisibility(0);
                return;
            }
            this.axu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(bc bcVar) {
        if (this.axz != null && bcVar != null) {
            if (bcVar.akt != null) {
                this.axO = false;
            }
            if (this.axO && (this.axD == null || this.axD.getVisibility() == 8)) {
                this.axz.setVisibility(0);
                if (this.axz.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axz.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.axz.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.k.manage);
                this.axx.setText(string);
                this.axx.setContentDescription(string);
                this.axE = true;
                return;
            }
            this.axz.setVisibility(8);
        }
    }

    private void AY() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.k.operation);
            bVar.a(this.axv, new b.InterfaceC0104b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) w.d(ThreadCommentAndPraiseInfoLayout.this.axw, i);
                    if (!StringUtils.isNull(str)) {
                        az.zV().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xq();
        }
    }

    public void onChangeSkinType() {
        am.h(this.axi, d.C0142d.cp_cont_d);
        am.h(this.axj, d.C0142d.cp_cont_j);
        am.h(this.axk, d.f.selector_comment_and_prise_item_text_color);
        am.h(this.axn, d.f.selector_comment_and_prise_item_text_color);
        am.h(this.axx, d.f.selector_comment_and_prise_item_text_color);
        am.i(this.axt, d.f.btn_frs_more_selector);
        if (this.atZ != null && this.atZ.wG() == 1 && this.axk != null) {
            am.h(this.axk, d.C0142d.cp_cont_h);
            this.axU = d.f.icon_home_card_like_s;
        }
        if (this.axk != null && this.axJ && this.axU > 0) {
            this.axl.setImageDrawable(am.getDrawable(this.axU));
        }
        if (this.axn != null && this.axI && this.axV > 0) {
            this.axo.setImageDrawable(am.getDrawable(this.axV));
        }
        if (this.atZ != null && this.atZ.akk != null && this.atZ.akk.isDeleted) {
            am.i(this.axr, d.f.icon_card_share_d);
            am.h(this.axq, d.C0142d.cp_cont_e);
            setShareClickable(false);
        } else {
            am.i(this.axr, this.axW);
            am.h(this.axq, d.f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.axy != null) {
            this.axy.setImageDrawable(am.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.axA != null) {
            this.axA.onChangeSkinType();
        }
        am.j(this.axY, d.C0142d.cp_bg_line_d);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axT = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.axi;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ayc != null) {
            this.ayc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ayc);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.axM = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.axG = z;
    }

    public View getCommentNumView() {
        return this.axn;
    }

    public View getCommentContainer() {
        return this.axp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Animation getScaleAnimation() {
        if (this.axX == null) {
            this.axX = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axX.setDuration(200L);
        }
        return this.axX;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.axI = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.axJ = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.axK = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setSelectVisible(boolean z) {
        this.axP = z;
    }

    public void setManageVisible(boolean z) {
        this.axO = z;
    }

    public void setOnSelectStatusChangeListener(a aVar) {
        this.axZ = aVar;
    }

    public void changeSelectStatus() {
        onClick(this.axB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.aya;
    }

    public void setInFrsAllThread(boolean z) {
        this.ayb = z;
    }

    public boolean isInFrsAllThread() {
        return this.ayb;
    }
}
