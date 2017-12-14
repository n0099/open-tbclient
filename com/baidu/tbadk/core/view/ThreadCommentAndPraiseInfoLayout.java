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
    protected bd ajJ;
    private w anA;
    protected boolean anB;
    protected boolean anC;
    private boolean anD;
    protected boolean anE;
    protected boolean anF;
    private boolean anG;
    protected boolean anH;
    protected boolean anI;
    private boolean anJ;
    protected boolean anK;
    protected boolean anL;
    private int anM;
    private int anN;
    public int anO;
    private String anP;
    private View.OnClickListener anQ;
    protected int anR;
    protected int anS;
    protected int anT;
    protected ScaleAnimation anU;
    private com.baidu.tieba.d.c anV;
    private CustomMessageListener anW;
    protected TextView ani;
    private TextView anj;
    protected TextView ank;
    protected ImageView anl;
    protected View anm;
    protected TextView ann;
    protected ImageView ano;
    protected View anp;
    protected TextView anq;
    protected ImageView anr;
    protected View ans;
    private TextView ant;
    private FrameLayout anu;
    private List<CharSequence> anv;
    private List<String> anw;
    protected TextView anx;
    protected ImageView any;
    protected View anz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.anP = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.anM = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.anB = false;
        this.anC = true;
        this.anD = true;
        this.anE = true;
        this.anF = false;
        this.anG = false;
        this.anH = true;
        this.anI = true;
        this.anJ = false;
        this.anK = true;
        this.anL = false;
        this.mFrom = 2;
        this.anM = 1;
        this.anW = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.ajJ != null && ThreadCommentAndPraiseInfoLayout.this.ajJ.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.rk() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajJ.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajJ.rk() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajJ.rk().setNum(bdVar.rk().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajJ);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anB = false;
        this.anC = true;
        this.anD = true;
        this.anE = true;
        this.anF = false;
        this.anG = false;
        this.anH = true;
        this.anI = true;
        this.anJ = false;
        this.anK = true;
        this.anL = false;
        this.mFrom = 2;
        this.anM = 1;
        this.anW = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.ajJ != null && ThreadCommentAndPraiseInfoLayout.this.ajJ.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.rk() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajJ.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajJ.rk() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajJ.rk().setNum(bdVar.rk().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajJ);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.ani = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.anj = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.ann = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.ano = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.anp = inflate.findViewById(d.g.thread_info_commont_container);
        this.anq = (TextView) inflate.findViewById(d.g.share_num);
        this.anr = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.ans = inflate.findViewById(d.g.share_num_container);
        this.ant = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.anu = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.ank = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.anl = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.anm = inflate.findViewById(d.g.agree_view_container);
        this.anz = inflate.findViewById(d.g.manage_view_container);
        this.anx = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.any = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.anm.setOnClickListener(this);
        this.anp.setOnClickListener(this);
        this.ans.setOnClickListener(this);
        this.anz.setOnClickListener(this);
        this.anT = d.f.icon_home_card_share;
        this.anS = d.f.icon_home_card_comment;
        this.anN = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ani) {
            B(view);
        } else if (view == this.anp) {
            C(view);
        } else if (view == this.anm) {
            D(view);
        } else if (view == this.ans) {
            E(view);
        } else if (view == this.anu) {
            G(view);
        } else if (view == this.anz) {
            F(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.anA != null) {
            this.anA.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.anp != null) {
            this.anp.setClickable(z);
            this.ano.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.anm != null) {
            this.anm.setClickable(z);
            this.anl.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.ans != null) {
            this.ans.setClickable(z);
            this.anr.setEnabled(z);
        }
    }

    private void B(View view) {
        if (this.ajJ != null && !StringUtils.isNull(this.ajJ.rB())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.anP)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ajJ.rB(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ajJ.rB(), this.mStType, this.anP)));
            }
            if (this.anQ != null) {
                this.anQ.onClick(view);
            }
        }
    }

    private void C(View view) {
        if (this.ajJ != null && this.mContext != null) {
            com.baidu.tieba.card.k.jO(this.ajJ.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ajJ, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajJ.getFid()));
            addLocateParam.setForumName(this.ajJ.rB());
            addLocateParam.setJumpToCommentArea(true);
            if (this.ajJ.sm() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.anO);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
            if (this.anQ != null) {
                this.anQ.onClick(view);
            }
        }
    }

    protected void D(View view) {
        int i = 1;
        if (ax.aS(this.mContext) && this.ajJ != null) {
            if (this.ajJ.sK() != 0) {
                this.ajJ.ca(this.ajJ.sJ() - 1);
                this.ajJ.bZ(0);
                if (this.ank != null) {
                    aj.i(this.ank, d.C0096d.cp_cont_j);
                }
            } else {
                this.ajJ.bZ(1);
                this.ajJ.ca(this.ajJ.sJ() + 1);
                if (this.ank != null) {
                    aj.i(this.ank, d.C0096d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.ajJ);
            if (this.anl != null && i == 0) {
                this.anl.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.ajJ.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.anN > 0) {
                httpMessage.addParam("forum_id", this.ajJ.getFid());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ac("tid", this.ajJ.getTid());
            if (this.ajJ.getThreadType() == 40) {
                akVar.ac("obj_param1", "2");
            } else if (this.ajJ.getThreadType() == 0) {
                akVar.ac("obj_param1", "1");
            }
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f(ImageViewerConfig.FORUM_ID, this.ajJ.getFid());
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
        if (this.ajJ != null) {
            if (this.anM != 1) {
                if (this.anM == 2) {
                    i = 5;
                } else if (this.anM == 3) {
                    i = 3;
                } else if (this.anM == 4) {
                    i = 2;
                } else if (this.anM != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f(ImageViewerConfig.FORUM_ID, this.ajJ.getFid()).ac("tid", this.ajJ.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void wH() {
        if (this.ajJ != null && this.mContext != null) {
            String valueOf = String.valueOf(this.ajJ.getFid());
            String rB = this.ajJ.rB();
            String title = this.ajJ.getTitle();
            String tid = this.ajJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajJ);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.ajJ.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.auH = str2;
            dVar.linkUrl = str;
            dVar.aaG = this.anM;
            dVar.extData = tid;
            dVar.auK = 3;
            dVar.fid = valueOf;
            dVar.auC = rB;
            dVar.tid = tid;
            dVar.auz = true;
            dVar.auJ = getShareObjSource();
            dVar.auL = b(this.ajJ);
            if (parse != null) {
                dVar.auE = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.ajJ);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.auK);
            bundle.putInt("obj_type", dVar.auL);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aaG);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.ajJ.getThreadType() == 49 || this.ajJ.getThreadType() == 60);
            if (this.anV == null) {
                this.anV = new com.baidu.tieba.d.c(this.mContext);
            }
            this.anV.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.anM == 1) {
            return 5;
        }
        if (this.anM != 3) {
            if (this.anM == 4) {
                return 4;
            }
            if (this.anM != 6) {
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
        if (this.anA == null) {
            this.anA = new w(this.mPageContext);
        }
        this.anA.setData(this.ajJ);
        com.baidu.adp.lib.g.g.a(this.anA, this.mPageContext);
        TiebaStatic.log(new ak("c12711"));
    }

    private void G(View view) {
        wJ();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.anE = z;
        if (this.ani != null) {
            this.ani.setClickable(this.anE);
        }
    }

    public boolean isMoreViewVisible() {
        return this.anu != null && this.anu.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.anN = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajJ = bdVar;
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        g(bdVar);
        setVisibility(this.anB ? 0 : 8);
        return this.anB;
    }

    protected void c(bd bdVar) {
        this.ani.setVisibility(8);
    }

    private void d(bd bdVar) {
        String s;
        if (this.anj != null && bdVar != null) {
            if (bdVar.rp() <= 0 || !this.anD) {
                this.anj.setVisibility(8);
                return;
            }
            this.anj.setVisibility(0);
            if (this.mFrom == 3) {
                s = com.baidu.tbadk.core.util.am.q(bdVar.rp());
            } else {
                s = com.baidu.tbadk.core.util.am.s(bdVar.rp() * 1000);
            }
            this.anj.setText(s);
            this.anB = true;
        }
    }

    protected void e(bd bdVar) {
        if (this.ann != null && bdVar != null) {
            if (this.anI) {
                this.anp.setVisibility(0);
                if (this.anp.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anp.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.anp.setLayoutParams(layoutParams);
                }
                if (bdVar.rn() > 0) {
                    this.ann.setVisibility(0);
                    String A = com.baidu.tbadk.core.util.am.A(bdVar.rn());
                    if (this.anF) {
                        this.ann.setText(A);
                    } else {
                        this.ann.setText(String.format(this.mContext.getString(d.j.reply_num_tip), A));
                    }
                    this.ann.setContentDescription(this.mContext.getString(d.j.reply_num) + A);
                    this.anB = true;
                    return;
                } else if (this.anF) {
                    this.ann.setText(this.mContext.getString(d.j.action_comment_default));
                    this.ann.setVisibility(0);
                    this.anB = true;
                    return;
                } else {
                    this.ann.setVisibility(8);
                    return;
                }
            }
            this.anp.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.anm != null && this.anl != null && this.ank != null && bdVar != null) {
            if (this.anC) {
                this.anm.setVisibility(0);
                if (this.anm.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anm.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.anm.setLayoutParams(layoutParams);
                }
                int sJ = bdVar.sJ();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (sJ > 0) {
                    string = com.baidu.tbadk.core.util.am.A(sJ);
                }
                this.ank.setText(string);
                this.ank.setContentDescription(this.mContext.getString(d.j.zan_num) + sJ);
                this.anB = true;
                if (bdVar.sK() != 0) {
                    this.anR = wI() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.anl.setImageDrawable(aj.getDrawable(this.anR));
                    if (this.ank != null) {
                        aj.i(this.ank, d.C0096d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.anR = wI() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.anl.setImageDrawable(aj.getDrawable(this.anR));
                if (this.ank != null) {
                    aj.i(this.ank, d.C0096d.cp_cont_j);
                    return;
                }
                return;
            }
            this.anm.setVisibility(8);
        }
    }

    private boolean wI() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.xE();
    }

    protected void f(bd bdVar) {
        if (this.ans != null && this.anq != null && bdVar != null) {
            if (this.anK) {
                this.ans.setVisibility(0);
                if (this.ans.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ans.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.ans.setLayoutParams(layoutParams);
                }
                long sL = bdVar.sL();
                if ((bdVar.sB() || bdVar.sE()) && bdVar.rO() != null) {
                    sL = bdVar.rO().share_info.share_count;
                }
                this.anq.setText(sL > 0 ? com.baidu.tbadk.core.util.am.A(sL) : this.mContext.getString(d.j.share));
                this.anB = true;
                return;
            }
            this.ans.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.anu != null) {
            if (this.ajJ == null || v.w(this.ajJ.sy()) || !TbadkCoreApplication.isLogin() || this.ajJ.sz()) {
                this.anu.setVisibility(8);
                return;
            }
            if (this.anu.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anu.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.width = 0;
                this.anu.setLayoutParams(layoutParams);
            }
            if (this.anv == null) {
                this.anv = new ArrayList();
            } else {
                this.anv.clear();
            }
            if (this.anw == null) {
                this.anw = new ArrayList();
            } else {
                this.anw.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ajJ.sy()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.anv.add(reportInfo.info);
                    this.anw.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.anu.setOnClickListener(this);
                this.anu.setVisibility(0);
                return;
            }
            this.anu.setVisibility(8);
        }
    }

    protected void g(bd bdVar) {
        if (this.anz != null && bdVar != null) {
            if (this.anL) {
                this.anz.setVisibility(0);
                if (this.anz.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anz.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.anz.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.anx.setText(string);
                this.anx.setContentDescription(string);
                this.anB = true;
                return;
            }
            this.anz.setVisibility(8);
        }
    }

    private void wJ() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.j.operation);
            bVar.a(this.anv, new b.InterfaceC0061b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.anw, i);
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
        aj.i(this.ani, d.C0096d.cp_cont_d);
        aj.i(this.anj, d.C0096d.cp_cont_j);
        aj.i(this.ank, d.f.selector_comment_and_prise_item_text_color);
        aj.i(this.ann, d.f.selector_comment_and_prise_item_text_color);
        aj.i(this.anq, d.f.selector_comment_and_prise_item_text_color);
        aj.i(this.anx, d.f.selector_comment_and_prise_item_text_color);
        aj.j(this.ant, d.f.btn_frs_more_selector);
        if (this.ajJ != null && this.ajJ.sK() == 1 && this.ank != null) {
            aj.i(this.ank, d.C0096d.cp_cont_h);
            this.anR = d.f.icon_home_card_like_s;
        }
        if (this.ank != null && this.anG && this.anR > 0) {
            this.anl.setImageDrawable(aj.getDrawable(this.anR));
        }
        if (this.ann != null && this.anF && this.anS > 0) {
            this.ano.setImageDrawable(aj.getDrawable(this.anS));
        }
        if (this.anr != null) {
            this.anr.setImageDrawable(aj.getDrawable(this.anT));
        }
        if (this.any != null) {
            this.any.setImageDrawable(aj.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.anA != null) {
            this.anA.onChangeSkinType();
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.anQ = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.ani;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anW != null) {
            this.anW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anW);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.anJ = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.anD = z;
    }

    public View getCommentNumView() {
        return this.ann;
    }

    public View getCommentContainer() {
        return this.anp;
    }

    protected Animation getScaleAnimation() {
        if (this.anU == null) {
            this.anU = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.anU.setDuration(200L);
        }
        return this.anU;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.anF = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.anG = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.anH = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.anL = z;
    }
}
