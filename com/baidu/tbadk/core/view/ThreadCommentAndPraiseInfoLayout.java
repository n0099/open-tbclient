package com.baidu.tbadk.core.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.o.ar;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout implements View.OnClickListener {
    public int aka;
    protected bd atn;
    private TextView awA;
    protected TextView awB;
    protected ImageView awC;
    protected View awD;
    protected TextView awE;
    protected ImageView awF;
    protected View awG;
    protected TextView awH;
    protected ImageView awI;
    protected View awJ;
    protected TextView awK;
    protected FrameLayout awL;
    private List<CharSequence> awM;
    private List<String> awN;
    protected TextView awO;
    protected ImageView awP;
    protected View awQ;
    private ac awR;
    protected boolean awS;
    protected boolean awT;
    private boolean awU;
    protected boolean awV;
    protected boolean awW;
    private boolean awX;
    protected boolean awY;
    protected boolean awZ;
    protected int awy;
    protected TextView awz;
    private boolean axa;
    protected boolean axb;
    protected boolean axc;
    private int axd;
    private int axe;
    private String axf;
    private View.OnClickListener axg;
    protected int axh;
    protected int axi;
    protected int axj;
    protected ScaleAnimation axk;
    private CustomMessageListener axl;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.axf = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.axd = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.awy = 0;
        this.awS = false;
        this.awT = true;
        this.awU = true;
        this.awV = true;
        this.awW = false;
        this.awX = false;
        this.awY = false;
        this.awZ = true;
        this.axa = false;
        this.axb = true;
        this.axc = false;
        this.mFrom = 2;
        this.axd = 1;
        this.axl = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.atn != null && ThreadCommentAndPraiseInfoLayout.this.atn.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.va() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.atn.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.atn.va() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.atn.va().setNum(bdVar.va().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.atn);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awy = 0;
        this.awS = false;
        this.awT = true;
        this.awU = true;
        this.awV = true;
        this.awW = false;
        this.awX = false;
        this.awY = false;
        this.awZ = true;
        this.axa = false;
        this.axb = true;
        this.axc = false;
        this.mFrom = 2;
        this.axd = 1;
        this.axl = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.atn != null && ThreadCommentAndPraiseInfoLayout.this.atn.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.va() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.atn.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.atn.va() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.atn.va().setNum(bdVar.va().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.atn);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.awy = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.awz = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.awA = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.awE = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.awF = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.awG = inflate.findViewById(d.g.thread_info_commont_container);
        this.awH = (TextView) inflate.findViewById(d.g.share_num);
        this.awI = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.awJ = inflate.findViewById(d.g.share_num_container);
        this.awK = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.awL = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.awB = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.awC = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.awD = inflate.findViewById(d.g.agree_view_container);
        this.awQ = inflate.findViewById(d.g.manage_view_container);
        this.awO = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.awP = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.awD.setOnClickListener(this);
        this.awG.setOnClickListener(this);
        this.awJ.setOnClickListener(this);
        this.awQ.setOnClickListener(this);
        this.axj = d.f.icon_home_card_share;
        this.axi = d.f.icon_home_card_comment;
        this.axe = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.awz) {
            C(view);
        } else if (view == this.awG) {
            D(view);
        } else if (view == this.awD) {
            E(view);
        } else if (view == this.awJ) {
            F(view);
        } else if (view == this.awL) {
            H(view);
        } else if (view == this.awQ) {
            G(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.awR != null) {
            this.awR.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.awG != null) {
            this.awG.setClickable(z);
            this.awF.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.awD != null) {
            this.awD.setClickable(z);
            this.awC.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.awJ != null) {
            this.awJ.setEnabled(z);
            this.awI.setEnabled(z);
        }
    }

    private void C(View view) {
        if (this.atn != null && !StringUtils.isNull(this.atn.vr())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.axf)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.atn.vr(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.atn.vr(), this.mStType, this.axf)));
            }
            if (this.axg != null) {
                this.axg.onClick(view);
            }
        }
    }

    private void D(View view) {
        if (this.atn != null && this.mContext != null) {
            o.lb(this.atn.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.atn, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.atn.getFid()));
            addLocateParam.setForumName(this.atn.vr());
            addLocateParam.setJumpToCommentArea(true);
            if (this.atn.wa() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.aka);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            am amVar = new am("c12291");
            amVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(amVar);
            am amVar2 = new am("c12942");
            amVar2.r("obj_locate", this.mFrom);
            amVar2.r("obj_type", getThreadType());
            amVar2.ah("tid", this.atn.getTid());
            TiebaStatic.log(amVar2);
            if (this.axg != null) {
                this.axg.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.atn == null) {
            return 0;
        }
        if (this.atn.isShareThread) {
            return 4;
        }
        if (this.atn.getThreadType() == 49) {
            return 5;
        }
        if (this.atn.vD() != null) {
            return 1;
        }
        if (this.atn.getType() == bd.ahJ || this.atn.getType() == bd.ahL) {
            if (w.y(this.atn.vA()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    protected void E(View view) {
        int i = 1;
        if (ba.aU(this.mContext) && this.atn != null) {
            if (this.atn.ww() != 0) {
                this.atn.bZ(this.atn.wv() - 1);
                this.atn.bY(0);
                if (this.awB != null) {
                    al.h(this.awB, d.C0141d.cp_cont_j);
                }
            } else {
                this.atn.bY(1);
                this.atn.bZ(this.atn.wv() + 1);
                if (this.awB != null) {
                    al.h(this.awB, d.C0141d.cp_cont_h);
                }
                com.baidu.tieba.n.a.bnR().y(this.mPageContext);
                i = 0;
            }
            updatePraiseNum(this.atn);
            if (this.awC != null && i == 0) {
                this.awC.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.atn.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.axe > 0) {
                httpMessage.addParam("forum_id", this.atn.getFid());
            }
            if (this.mPageContext != null) {
                httpMessage.setTag(this.mPageContext.getUniqueId());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            am amVar = new am("c12003");
            amVar.ah("tid", this.atn.getTid());
            if (this.atn.getThreadType() == 40) {
                amVar.ah("obj_param1", "2");
            } else if (this.atn.getThreadType() == 0) {
                amVar.ah("obj_param1", "1");
            }
            amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            amVar.f(ImageViewerConfig.FORUM_ID, this.atn.getFid());
            amVar.r("obj_locate", this.mFrom);
            amVar.r(VideoPlayActivityConfig.OBJ_ID, i);
            TiebaStatic.log(amVar);
        }
    }

    protected void F(View view) {
        if (ar.ip() || ba.aU(this.mContext)) {
            AC();
            AD();
        }
    }

    private void AC() {
        int i = 4;
        if (this.atn != null) {
            if (this.axd != 1) {
                if (this.axd == 2) {
                    i = 5;
                } else if (this.axd == 3) {
                    i = 3;
                } else if (this.axd == 4) {
                    i = 2;
                } else if (this.axd != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new am("c12386").f(ImageViewerConfig.FORUM_ID, this.atn.getFid()).ah("tid", this.atn.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void AD() {
        if (this.atn != null && this.mContext != null) {
            String valueOf = String.valueOf(this.atn.getFid());
            String vr = this.atn.vr();
            String title = this.atn.getTitle();
            String tid = this.atn.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.atn);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.atn.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.k.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aFm = str2;
            dVar.linkUrl = str;
            dVar.ajZ = this.axd;
            dVar.extData = tid;
            dVar.aFp = 3;
            dVar.fid = valueOf;
            dVar.aFh = vr;
            dVar.tid = tid;
            dVar.aFd = true;
            dVar.aFo = getShareObjSource();
            dVar.aFq = b(this.atn);
            if (parse != null) {
                dVar.aFj = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.atn);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aFp);
            bundle.putInt("obj_type", dVar.aFq);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajZ);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.atn.getThreadType() == 49 || this.atn.getThreadType() == 60);
            com.baidu.tieba.c.e.akV().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.axd == 1) {
            return 5;
        }
        if (this.axd != 3) {
            if (this.axd == 4) {
                return 4;
            }
            if (this.axd != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.vw() == null) {
            return null;
        }
        ArrayList<MediaData> vw = bdVar.vw();
        int size = vw.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = vw.get(i);
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

    private int b(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.vo()) {
                return 4;
            }
            if (bdVar.vj() == 1) {
                return 3;
            }
            return bdVar.wo() ? 2 : 1;
        }
        return 0;
    }

    private void G(View view) {
        if (this.awR == null) {
            this.awR = new ac(this.mPageContext);
        }
        this.awR.setData(this.atn);
        com.baidu.adp.lib.g.g.a(this.awR, this.mPageContext);
        TiebaStatic.log(new am("c12711"));
    }

    private void H(View view) {
        AG();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.awV = z;
        if (this.awz != null) {
            this.awz.setClickable(this.awV);
        }
    }

    public boolean isMoreViewVisible() {
        return this.awL != null && this.awL.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.axe = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.atn = bdVar;
        AE();
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        g(bdVar);
        setVisibility(this.awS ? 0 : 8);
        return this.awS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AE() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(bd bdVar) {
        this.awz.setVisibility(8);
    }

    private void d(bd bdVar) {
        String w;
        if (this.awA != null && bdVar != null) {
            if (bdVar.vg() <= 0 || !this.awU) {
                this.awA.setVisibility(8);
                return;
            }
            this.awA.setVisibility(0);
            if (this.mFrom == 3) {
                w = ao.u(bdVar.vg());
            } else {
                w = ao.w(bdVar.vg() * 1000);
            }
            this.awA.setText(w);
            this.awS = true;
        }
    }

    public boolean isVisible() {
        return this.awS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(bd bdVar) {
        if (this.awE != null && bdVar != null) {
            if (this.awZ) {
                this.awG.setVisibility(0);
                if (this.awG.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awG.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awG.setLayoutParams(layoutParams);
                }
                if (bdVar.ve() > 0) {
                    this.awE.setVisibility(0);
                    String E = ao.E(bdVar.ve());
                    if (this.awW) {
                        this.awF.setImageDrawable(al.getDrawable(this.axi));
                        this.awE.setText(E);
                    } else {
                        this.awE.setText(String.format(this.mContext.getString(d.k.reply_num_tip), E));
                    }
                    this.awE.setContentDescription(this.mContext.getString(d.k.reply_num) + E);
                    this.awS = true;
                    return;
                } else if (this.awW) {
                    this.awF.setImageDrawable(al.getDrawable(this.axi));
                    this.awE.setText(this.mContext.getString(d.k.action_comment_default));
                    this.awE.setVisibility(0);
                    this.awS = true;
                    return;
                } else {
                    this.awE.setVisibility(8);
                    return;
                }
            }
            this.awG.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.awD != null && this.awC != null && this.awB != null && bdVar != null) {
            if (this.awT) {
                this.awD.setVisibility(0);
                if (this.awD.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awD.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awD.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.awC.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.awC.setLayoutParams(layoutParams2);
                int wv = bdVar.wv();
                String string = this.mContext.getString(d.k.action_praise_default);
                if (wv > 0) {
                    string = ao.E(wv);
                }
                this.awB.setText(string);
                this.awB.setContentDescription(this.mContext.getString(d.k.zan_num) + wv);
                this.awS = true;
                if (bdVar.ww() != 0) {
                    this.axh = AF() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.awC.setImageDrawable(al.getDrawable(this.axh));
                    if (this.awB != null) {
                        al.h(this.awB, d.C0141d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.axh = AF() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.awC.setImageDrawable(al.getDrawable(this.axh));
                if (this.awB != null) {
                    al.h(this.awB, d.C0141d.cp_cont_j);
                    return;
                }
                return;
            }
            this.awD.setVisibility(8);
        }
    }

    private boolean AF() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.BD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bd bdVar) {
        if (this.awJ != null && this.awH != null && bdVar != null) {
            if (this.axb) {
                this.awJ.setVisibility(0);
                if (this.awJ.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awJ.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awJ.setLayoutParams(layoutParams);
                }
                long wx = bdVar.wx();
                if ((bdVar.wn() || bdVar.wq()) && bdVar.vE() != null) {
                    wx = bdVar.vE().share_info.share_count;
                }
                this.awH.setText(wx > 0 ? ao.E(wx) : this.mContext.getString(d.k.share));
                this.awS = true;
                if (bdVar.ajP != null && bdVar.ajP.isDeleted) {
                    al.i(this.awI, d.f.icon_card_share_d);
                    al.h(this.awH, d.C0141d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                al.i(this.awI, this.axj);
                al.h(this.awH, d.f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.awJ.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.awL != null) {
            if (this.atn == null || w.z(this.atn.wk()) || !TbadkCoreApplication.isLogin() || this.atn.wl()) {
                this.awL.setVisibility(8);
                return;
            }
            if (this.awL.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awL.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.awL.setLayoutParams(layoutParams);
            }
            if (this.awM == null) {
                this.awM = new ArrayList();
            } else {
                this.awM.clear();
            }
            if (this.awN == null) {
                this.awN = new ArrayList();
            } else {
                this.awN.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.atn.wk()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.awM.add(reportInfo.info);
                    this.awN.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.awL.setOnClickListener(this);
                this.awL.setVisibility(0);
                return;
            }
            this.awL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bd bdVar) {
        if (this.awQ != null && bdVar != null) {
            if (this.axc) {
                this.awQ.setVisibility(0);
                if (this.awQ.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.awQ.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.awQ.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.k.manage);
                this.awO.setText(string);
                this.awO.setContentDescription(string);
                this.awS = true;
                return;
            }
            this.awQ.setVisibility(8);
        }
    }

    private void AG() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cf(d.k.operation);
            bVar.a(this.awM, new b.InterfaceC0103b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) w.c(ThreadCommentAndPraiseInfoLayout.this.awN, i);
                    if (!StringUtils.isNull(str)) {
                        ay.zG().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xd();
        }
    }

    public void onChangeSkinType() {
        al.h(this.awz, d.C0141d.cp_cont_d);
        al.h(this.awA, d.C0141d.cp_cont_j);
        al.h(this.awB, d.f.selector_comment_and_prise_item_text_color);
        al.h(this.awE, d.f.selector_comment_and_prise_item_text_color);
        al.h(this.awO, d.f.selector_comment_and_prise_item_text_color);
        al.i(this.awK, d.f.btn_frs_more_selector);
        if (this.atn != null && this.atn.ww() == 1 && this.awB != null) {
            al.h(this.awB, d.C0141d.cp_cont_h);
            this.axh = d.f.icon_home_card_like_s;
        }
        if (this.awB != null && this.awX && this.axh > 0) {
            this.awC.setImageDrawable(al.getDrawable(this.axh));
        }
        if (this.awE != null && this.awW && this.axi > 0) {
            this.awF.setImageDrawable(al.getDrawable(this.axi));
        }
        if (this.atn != null && this.atn.ajP != null && this.atn.ajP.isDeleted) {
            al.i(this.awI, d.f.icon_card_share_d);
            al.h(this.awH, d.C0141d.cp_cont_e);
            setShareClickable(false);
        } else {
            al.i(this.awI, this.axj);
            al.h(this.awH, d.f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.awP != null) {
            this.awP.setImageDrawable(al.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.awR != null) {
            this.awR.onChangeSkinType();
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axg = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.awz;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.axl != null) {
            this.axl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.axl);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.axa = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.awU = z;
    }

    public View getCommentNumView() {
        return this.awE;
    }

    public View getCommentContainer() {
        return this.awG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Animation getScaleAnimation() {
        if (this.axk == null) {
            this.axk = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.axk.setDuration(200L);
        }
        return this.axk;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.awW = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.awX = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.awY = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.axc = z;
    }
}
