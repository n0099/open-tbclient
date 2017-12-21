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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.o.am;
import com.baidu.tieba.card.w;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout implements View.OnClickListener {
    protected bd ajM;
    protected TextView anA;
    protected ImageView anB;
    protected View anC;
    private w anD;
    protected boolean anE;
    protected boolean anF;
    private boolean anG;
    protected boolean anH;
    protected boolean anI;
    private boolean anJ;
    protected boolean anK;
    protected boolean anL;
    private boolean anM;
    protected boolean anN;
    protected boolean anO;
    private int anP;
    private int anQ;
    public int anR;
    private String anS;
    private View.OnClickListener anT;
    protected int anU;
    protected int anV;
    protected int anW;
    protected ScaleAnimation anX;
    private com.baidu.tieba.d.c anY;
    private CustomMessageListener anZ;
    protected TextView anl;
    private TextView anm;
    protected TextView ann;
    protected ImageView ano;
    protected View anp;
    protected TextView anq;
    protected ImageView anr;
    protected View ans;
    protected TextView ant;
    protected ImageView anu;
    protected View anv;
    private TextView anw;
    private FrameLayout anx;
    private List<CharSequence> any;
    private List<String> anz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.anS = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.anP = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.anE = false;
        this.anF = true;
        this.anG = true;
        this.anH = true;
        this.anI = false;
        this.anJ = false;
        this.anK = true;
        this.anL = true;
        this.anM = false;
        this.anN = true;
        this.anO = false;
        this.mFrom = 2;
        this.anP = 1;
        this.anZ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.ajM != null && ThreadCommentAndPraiseInfoLayout.this.ajM.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.rk() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajM.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajM.rk() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajM.rk().setNum(bdVar.rk().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajM);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anE = false;
        this.anF = true;
        this.anG = true;
        this.anH = true;
        this.anI = false;
        this.anJ = false;
        this.anK = true;
        this.anL = true;
        this.anM = false;
        this.anN = true;
        this.anO = false;
        this.mFrom = 2;
        this.anP = 1;
        this.anZ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.ajM != null && ThreadCommentAndPraiseInfoLayout.this.ajM.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.rk() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajM.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajM.rk() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajM.rk().setNum(bdVar.rk().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajM);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.anl = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.anm = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.anq = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.anr = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.ans = inflate.findViewById(d.g.thread_info_commont_container);
        this.ant = (TextView) inflate.findViewById(d.g.share_num);
        this.anu = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.anv = inflate.findViewById(d.g.share_num_container);
        this.anw = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.anx = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.ann = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.ano = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.anp = inflate.findViewById(d.g.agree_view_container);
        this.anC = inflate.findViewById(d.g.manage_view_container);
        this.anA = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.anB = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.anp.setOnClickListener(this);
        this.ans.setOnClickListener(this);
        this.anv.setOnClickListener(this);
        this.anC.setOnClickListener(this);
        this.anW = d.f.icon_home_card_share;
        this.anV = d.f.icon_home_card_comment;
        this.anQ = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.anl) {
            B(view);
        } else if (view == this.ans) {
            C(view);
        } else if (view == this.anp) {
            D(view);
        } else if (view == this.anv) {
            E(view);
        } else if (view == this.anx) {
            G(view);
        } else if (view == this.anC) {
            F(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.anD != null) {
            this.anD.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.ans != null) {
            this.ans.setClickable(z);
            this.anr.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.anp != null) {
            this.anp.setClickable(z);
            this.ano.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.anv != null) {
            this.anv.setClickable(z);
            this.anu.setEnabled(z);
        }
    }

    private void B(View view) {
        if (this.ajM != null && !StringUtils.isNull(this.ajM.rB())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.anS)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ajM.rB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ajM.rB(), this.mStType, this.anS)));
            }
            if (this.anT != null) {
                this.anT.onClick(view);
            }
        }
    }

    private void C(View view) {
        if (this.ajM != null && this.mContext != null) {
            com.baidu.tieba.card.k.jO(this.ajM.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ajM, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajM.getFid()));
            addLocateParam.setForumName(this.ajM.rB());
            addLocateParam.setJumpToCommentArea(true);
            if (this.ajM.sm() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.anR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
            if (this.anT != null) {
                this.anT.onClick(view);
            }
        }
    }

    protected void D(View view) {
        int i = 1;
        if (ax.aS(this.mContext) && this.ajM != null) {
            if (this.ajM.sK() != 0) {
                this.ajM.ca(this.ajM.sJ() - 1);
                this.ajM.bZ(0);
                if (this.ann != null) {
                    aj.i(this.ann, d.C0095d.cp_cont_j);
                }
            } else {
                this.ajM.bZ(1);
                this.ajM.ca(this.ajM.sJ() + 1);
                if (this.ann != null) {
                    aj.i(this.ann, d.C0095d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.ajM);
            if (this.ano != null && i == 0) {
                this.ano.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.ajM.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.anQ > 0) {
                httpMessage.addParam("forum_id", this.ajM.getFid());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ac("tid", this.ajM.getTid());
            if (this.ajM.getThreadType() == 40) {
                akVar.ac("obj_param1", "2");
            } else if (this.ajM.getThreadType() == 0) {
                akVar.ac("obj_param1", "1");
            }
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f(ImageViewerConfig.FORUM_ID, this.ajM.getFid());
            akVar.r("obj_locate", this.mFrom);
            akVar.r("obj_id", i);
            TiebaStatic.log(akVar);
        }
    }

    protected void E(View view) {
        if (am.fS() || ax.aS(this.mContext)) {
            wG();
            wH();
        }
    }

    private void wG() {
        int i = 4;
        if (this.ajM != null) {
            if (this.anP != 1) {
                if (this.anP == 2) {
                    i = 5;
                } else if (this.anP == 3) {
                    i = 3;
                } else if (this.anP == 4) {
                    i = 2;
                } else if (this.anP != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f(ImageViewerConfig.FORUM_ID, this.ajM.getFid()).ac("tid", this.ajM.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void wH() {
        if (this.ajM != null && this.mContext != null) {
            String valueOf = String.valueOf(this.ajM.getFid());
            String rB = this.ajM.rB();
            String title = this.ajM.getTitle();
            String tid = this.ajM.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajM);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.ajM.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.auK = str2;
            dVar.linkUrl = str;
            dVar.aaJ = this.anP;
            dVar.extData = tid;
            dVar.auN = 3;
            dVar.fid = valueOf;
            dVar.auF = rB;
            dVar.tid = tid;
            dVar.auC = true;
            dVar.auM = getShareObjSource();
            dVar.auO = b(this.ajM);
            if (parse != null) {
                dVar.auH = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.ajM);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.auN);
            bundle.putInt("obj_type", dVar.auO);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aaJ);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.ajM.getThreadType() == 49 || this.ajM.getThreadType() == 60);
            if (this.anY == null) {
                this.anY = new com.baidu.tieba.d.c(this.mContext);
            }
            this.anY.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.anP == 1) {
            return 5;
        }
        if (this.anP != 3) {
            if (this.anP == 4) {
                return 4;
            }
            if (this.anP != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.rG() == null) {
            return null;
        }
        ArrayList<MediaData> rG = bdVar.rG();
        int size = rG.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rG.get(i);
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
            if (bdVar.ry()) {
                return 4;
            }
            if (bdVar.rs() == 1) {
                return 3;
            }
            return bdVar.sC() ? 2 : 1;
        }
        return 0;
    }

    private void F(View view) {
        if (this.anD == null) {
            this.anD = new w(this.mPageContext);
        }
        this.anD.setData(this.ajM);
        com.baidu.adp.lib.g.g.a(this.anD, this.mPageContext);
        TiebaStatic.log(new ak("c12711"));
    }

    private void G(View view) {
        wJ();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.anH = z;
        if (this.anl != null) {
            this.anl.setClickable(this.anH);
        }
    }

    public boolean isMoreViewVisible() {
        return this.anx != null && this.anx.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.anQ = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajM = bdVar;
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        g(bdVar);
        setVisibility(this.anE ? 0 : 8);
        return this.anE;
    }

    protected void c(bd bdVar) {
        this.anl.setVisibility(8);
    }

    private void d(bd bdVar) {
        String s;
        if (this.anm != null && bdVar != null) {
            if (bdVar.rp() <= 0 || !this.anG) {
                this.anm.setVisibility(8);
                return;
            }
            this.anm.setVisibility(0);
            if (this.mFrom == 3) {
                s = com.baidu.tbadk.core.util.am.q(bdVar.rp());
            } else {
                s = com.baidu.tbadk.core.util.am.s(bdVar.rp() * 1000);
            }
            this.anm.setText(s);
            this.anE = true;
        }
    }

    protected void e(bd bdVar) {
        if (this.anq != null && bdVar != null) {
            if (this.anL) {
                this.ans.setVisibility(0);
                if (this.ans.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ans.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.ans.setLayoutParams(layoutParams);
                }
                if (bdVar.rn() > 0) {
                    this.anq.setVisibility(0);
                    String A = com.baidu.tbadk.core.util.am.A(bdVar.rn());
                    if (this.anI) {
                        this.anq.setText(A);
                    } else {
                        this.anq.setText(String.format(this.mContext.getString(d.j.reply_num_tip), A));
                    }
                    this.anq.setContentDescription(this.mContext.getString(d.j.reply_num) + A);
                    this.anE = true;
                    return;
                } else if (this.anI) {
                    this.anq.setText(this.mContext.getString(d.j.action_comment_default));
                    this.anq.setVisibility(0);
                    this.anE = true;
                    return;
                } else {
                    this.anq.setVisibility(8);
                    return;
                }
            }
            this.ans.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.anp != null && this.ano != null && this.ann != null && bdVar != null) {
            if (this.anF) {
                this.anp.setVisibility(0);
                if (this.anp.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anp.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.anp.setLayoutParams(layoutParams);
                }
                int sJ = bdVar.sJ();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (sJ > 0) {
                    string = com.baidu.tbadk.core.util.am.A(sJ);
                }
                this.ann.setText(string);
                this.ann.setContentDescription(this.mContext.getString(d.j.zan_num) + sJ);
                this.anE = true;
                if (bdVar.sK() != 0) {
                    this.anU = wI() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.ano.setImageDrawable(aj.getDrawable(this.anU));
                    if (this.ann != null) {
                        aj.i(this.ann, d.C0095d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.anU = wI() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.ano.setImageDrawable(aj.getDrawable(this.anU));
                if (this.ann != null) {
                    aj.i(this.ann, d.C0095d.cp_cont_j);
                    return;
                }
                return;
            }
            this.anp.setVisibility(8);
        }
    }

    private boolean wI() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.xE();
    }

    protected void f(bd bdVar) {
        if (this.anv != null && this.ant != null && bdVar != null) {
            if (this.anN) {
                this.anv.setVisibility(0);
                if (this.anv.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anv.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.anv.setLayoutParams(layoutParams);
                }
                long sL = bdVar.sL();
                if ((bdVar.sB() || bdVar.sE()) && bdVar.rO() != null) {
                    sL = bdVar.rO().share_info.share_count;
                }
                this.ant.setText(sL > 0 ? com.baidu.tbadk.core.util.am.A(sL) : this.mContext.getString(d.j.share));
                this.anE = true;
                return;
            }
            this.anv.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.anx != null) {
            if (this.ajM == null || v.w(this.ajM.sy()) || !TbadkCoreApplication.isLogin() || this.ajM.sz()) {
                this.anx.setVisibility(8);
                return;
            }
            if (this.anx.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anx.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.width = 0;
                this.anx.setLayoutParams(layoutParams);
            }
            if (this.any == null) {
                this.any = new ArrayList();
            } else {
                this.any.clear();
            }
            if (this.anz == null) {
                this.anz = new ArrayList();
            } else {
                this.anz.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ajM.sy()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.any.add(reportInfo.info);
                    this.anz.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.anx.setOnClickListener(this);
                this.anx.setVisibility(0);
                return;
            }
            this.anx.setVisibility(8);
        }
    }

    protected void g(bd bdVar) {
        if (this.anC != null && bdVar != null) {
            if (this.anO) {
                this.anC.setVisibility(0);
                if (this.anC.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anC.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.anC.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.anA.setText(string);
                this.anA.setContentDescription(string);
                this.anE = true;
                return;
            }
            this.anC.setVisibility(8);
        }
    }

    private void wJ() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.j.operation);
            bVar.a(this.any, new b.InterfaceC0060b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.anz, i);
                    if (!StringUtils.isNull(str)) {
                        av.vI().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tl();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.anl, d.C0095d.cp_cont_d);
        aj.i(this.anm, d.C0095d.cp_cont_j);
        aj.i(this.ann, d.f.selector_comment_and_prise_item_text_color);
        aj.i(this.anq, d.f.selector_comment_and_prise_item_text_color);
        aj.i(this.ant, d.f.selector_comment_and_prise_item_text_color);
        aj.i(this.anA, d.f.selector_comment_and_prise_item_text_color);
        aj.j(this.anw, d.f.btn_frs_more_selector);
        if (this.ajM != null && this.ajM.sK() == 1 && this.ann != null) {
            aj.i(this.ann, d.C0095d.cp_cont_h);
            this.anU = d.f.icon_home_card_like_s;
        }
        if (this.ann != null && this.anJ && this.anU > 0) {
            this.ano.setImageDrawable(aj.getDrawable(this.anU));
        }
        if (this.anq != null && this.anI && this.anV > 0) {
            this.anr.setImageDrawable(aj.getDrawable(this.anV));
        }
        if (this.anu != null) {
            this.anu.setImageDrawable(aj.getDrawable(this.anW));
        }
        if (this.anB != null) {
            this.anB.setImageDrawable(aj.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.anD != null) {
            this.anD.onChangeSkinType();
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.anT = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.anl;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anZ != null) {
            this.anZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anZ);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.anM = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.anG = z;
    }

    public View getCommentNumView() {
        return this.anq;
    }

    public View getCommentContainer() {
        return this.ans;
    }

    protected Animation getScaleAnimation() {
        if (this.anX == null) {
            this.anX = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.anX.setDuration(200L);
        }
        return this.anX;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.anI = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.anJ = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.anK = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.anO = z;
    }
}
