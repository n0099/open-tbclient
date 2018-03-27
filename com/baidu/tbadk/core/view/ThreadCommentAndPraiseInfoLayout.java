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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.o.ap;
import com.baidu.tieba.card.w;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout implements View.OnClickListener {
    public int aQv;
    protected bd aZC;
    protected int bcY;
    protected TextView bcZ;
    private boolean bdA;
    protected boolean bdB;
    protected boolean bdC;
    private int bdD;
    private int bdE;
    private String bdF;
    private View.OnClickListener bdG;
    protected int bdH;
    protected int bdI;
    protected int bdJ;
    protected ScaleAnimation bdK;
    private boolean bdL;
    private CustomMessageListener bdM;
    private TextView bda;
    protected TextView bdb;
    protected ImageView bdc;
    protected View bdd;
    protected TextView bde;
    protected ImageView bdf;
    protected View bdg;
    protected TextView bdh;
    protected ImageView bdi;
    protected View bdj;
    protected TextView bdk;
    protected FrameLayout bdl;
    private List<CharSequence> bdm;
    private List<String> bdn;
    protected TextView bdo;
    protected ImageView bdp;
    protected View bdq;
    private w bdr;
    protected boolean bds;
    protected boolean bdt;
    private boolean bdu;
    protected boolean bdv;
    protected boolean bdw;
    private boolean bdx;
    protected boolean bdy;
    protected boolean bdz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.bdF = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.bdD = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bcY = 0;
        this.bds = false;
        this.bdt = true;
        this.bdu = true;
        this.bdv = true;
        this.bdw = false;
        this.bdx = false;
        this.bdy = false;
        this.bdz = true;
        this.bdA = false;
        this.bdB = true;
        this.bdC = false;
        this.mFrom = 2;
        this.bdD = 1;
        this.bdL = false;
        this.bdM = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aZC != null && ThreadCommentAndPraiseInfoLayout.this.aZC.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.zc() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aZC.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aZC.zc() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aZC.zc().setNum(bdVar.zc().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aZC);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcY = 0;
        this.bds = false;
        this.bdt = true;
        this.bdu = true;
        this.bdv = true;
        this.bdw = false;
        this.bdx = false;
        this.bdy = false;
        this.bdz = true;
        this.bdA = false;
        this.bdB = true;
        this.bdC = false;
        this.mFrom = 2;
        this.bdD = 1;
        this.bdL = false;
        this.bdM = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aZC != null && ThreadCommentAndPraiseInfoLayout.this.aZC.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.zc() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aZC.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aZC.zc() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aZC.zc().setNum(bdVar.zc().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aZC);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bcY = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.bcZ = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.bda = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bde = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bdf = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.bdg = inflate.findViewById(d.g.thread_info_commont_container);
        this.bdh = (TextView) inflate.findViewById(d.g.share_num);
        this.bdi = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.bdj = inflate.findViewById(d.g.share_num_container);
        this.bdk = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bdl = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.bdb = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.bdc = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.bdd = inflate.findViewById(d.g.agree_view_container);
        this.bdq = inflate.findViewById(d.g.manage_view_container);
        this.bdo = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.bdp = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.bdd.setOnClickListener(this);
        this.bdg.setOnClickListener(this);
        this.bdj.setOnClickListener(this);
        this.bdq.setOnClickListener(this);
        this.bdJ = d.f.icon_home_card_share;
        this.bdI = d.f.icon_home_card_comment;
        this.bdE = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bcZ) {
            aU(view);
        } else if (view == this.bdg) {
            aV(view);
        } else if (view == this.bdd) {
            aW(view);
        } else if (view == this.bdj) {
            aX(view);
        } else if (view == this.bdl) {
            aZ(view);
        } else if (view == this.bdq) {
            aY(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bdr != null) {
            this.bdr.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.bdg != null) {
            this.bdg.setClickable(z);
            this.bdf.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bdd != null) {
            this.bdd.setClickable(z);
            this.bdc.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.bdj != null) {
            this.bdj.setEnabled(z);
            this.bdi.setEnabled(z);
        }
    }

    private void aU(View view) {
        if (this.aZC != null && !StringUtils.isNull(this.aZC.zt())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.bdF)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.aZC.zt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aZC.zt(), this.mStType, this.bdF)));
            }
            if (this.bdG != null) {
                this.bdG.onClick(view);
            }
        }
    }

    private void aV(View view) {
        if (this.aZC != null && this.mContext != null) {
            com.baidu.tieba.card.j.kr(this.aZC.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aZC, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aZC.getFid()));
            addLocateParam.setForumName(this.aZC.zt());
            addLocateParam.setJumpToCommentArea(true);
            if (this.aZC.Ac() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.aQv);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.s("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
            ak akVar2 = new ak("c12942");
            akVar2.s("obj_locate", this.mFrom);
            akVar2.s("obj_type", getThreadType());
            akVar2.ab("tid", this.aZC.getTid());
            TiebaStatic.log(akVar2);
            if (this.bdG != null) {
                this.bdG.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.aZC == null) {
            return 0;
        }
        if (this.aZC.isShareThread) {
            return 4;
        }
        if (this.aZC.getThreadType() == 49) {
            return 5;
        }
        if (this.aZC.zF() != null) {
            return 1;
        }
        if (this.aZC.getType() == bd.aOk || this.aZC.getType() == bd.aOm) {
            if (v.D(this.aZC.zC()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    protected void aW(View view) {
        int i = 1;
        if (ay.ba(this.mContext) && this.aZC != null) {
            if (this.aZC.Ay() != 0) {
                this.aZC.eY(this.aZC.Ax() - 1);
                this.aZC.eX(0);
                if (this.bdb != null) {
                    aj.r(this.bdb, d.C0141d.cp_cont_j);
                }
            } else {
                this.aZC.eX(1);
                this.aZC.eY(this.aZC.Ax() + 1);
                if (this.bdb != null) {
                    aj.r(this.bdb, d.C0141d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.aZC);
            if (this.bdc != null && i == 0) {
                this.bdc.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.aZC.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.bdE > 0) {
                httpMessage.addParam("forum_id", this.aZC.getFid());
            }
            if (this.mPageContext != null) {
                httpMessage.setTag(this.mPageContext.getUniqueId());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ab("tid", this.aZC.getTid());
            if (this.aZC.getThreadType() == 40) {
                akVar.ab("obj_param1", "2");
            } else if (this.aZC.getThreadType() == 0) {
                akVar.ab("obj_param1", "1");
            }
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f(ImageViewerConfig.FORUM_ID, this.aZC.getFid());
            akVar.s("obj_locate", this.mFrom);
            akVar.s("obj_id", i);
            TiebaStatic.log(akVar);
        }
    }

    protected void aX(View view) {
        if (ap.nv() || ay.ba(this.mContext)) {
            Er();
            Es();
        }
    }

    private void Er() {
        int i = 4;
        if (this.aZC != null) {
            if (this.bdD != 1) {
                if (this.bdD == 2) {
                    i = 5;
                } else if (this.bdD == 3) {
                    i = 3;
                } else if (this.bdD == 4) {
                    i = 2;
                } else if (this.bdD != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f(ImageViewerConfig.FORUM_ID, this.aZC.getFid()).ab("tid", this.aZC.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_locate", i));
        }
    }

    private void Es() {
        if (this.aZC != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aZC.getFid());
            String zt = this.aZC.zt();
            String title = this.aZC.getTitle();
            String tid = this.aZC.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aZC);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.aZC.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.blu = str2;
            dVar.linkUrl = str;
            dVar.aQu = this.bdD;
            dVar.extData = tid;
            dVar.blx = 3;
            dVar.fid = valueOf;
            dVar.blp = zt;
            dVar.tid = tid;
            dVar.blm = true;
            dVar.blw = getShareObjSource();
            dVar.bly = b(this.aZC);
            if (parse != null) {
                dVar.blr = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aZC);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blx);
            bundle.putInt("obj_type", dVar.bly);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQu);
            dVar.i(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aZC.getThreadType() == 49 || this.aZC.getThreadType() == 60);
            com.baidu.tieba.d.d.anj().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.bdD == 1) {
            return 5;
        }
        if (this.bdD != 3) {
            if (this.bdD == 4) {
                return 4;
            }
            if (this.bdD != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.zy() == null) {
            return null;
        }
        ArrayList<MediaData> zy = bdVar.zy();
        int size = zy.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = zy.get(i);
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
            if (bdVar.zq()) {
                return 4;
            }
            if (bdVar.zk() == 1) {
                return 3;
            }
            return bdVar.Aq() ? 2 : 1;
        }
        return 0;
    }

    private void aY(View view) {
        if (this.bdr == null) {
            this.bdr = new w(this.mPageContext);
        }
        this.bdr.setData(this.aZC);
        com.baidu.adp.lib.g.g.a(this.bdr, this.mPageContext);
        TiebaStatic.log(new ak("c12711"));
    }

    private void aZ(View view) {
        Ev();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.bdv = z;
        if (this.bcZ != null) {
            this.bcZ.setClickable(this.bdv);
        }
    }

    public boolean isMoreViewVisible() {
        return this.bdl != null && this.bdl.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.bdE = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZC = bdVar;
        Et();
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        g(bdVar);
        setVisibility(this.bds ? 0 : 8);
        return this.bds;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Et() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(bd bdVar) {
        this.bcZ.setVisibility(8);
    }

    private void d(bd bdVar) {
        String A;
        if (this.bda != null && bdVar != null) {
            if (bdVar.zh() <= 0 || !this.bdu) {
                this.bda.setVisibility(8);
                return;
            }
            this.bda.setVisibility(0);
            if (this.mFrom == 3) {
                A = am.y(bdVar.zh());
            } else {
                A = am.A(bdVar.zh() * 1000);
            }
            this.bda.setText(A);
            this.bds = true;
        }
    }

    public boolean isVisible() {
        return this.bds;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(bd bdVar) {
        if (this.bde != null && bdVar != null) {
            if (this.bdz) {
                this.bdg.setVisibility(0);
                if (this.bdg.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdg.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdg.setLayoutParams(layoutParams);
                }
                if (bdVar.zf() > 0) {
                    this.bde.setVisibility(0);
                    String J = am.J(bdVar.zf());
                    if (this.bdw) {
                        this.bdf.setImageDrawable(aj.getDrawable(this.bdI));
                        this.bde.setText(J);
                    } else {
                        this.bde.setText(String.format(this.mContext.getString(d.j.reply_num_tip), J));
                    }
                    this.bde.setContentDescription(this.mContext.getString(d.j.reply_num) + J);
                    this.bds = true;
                    return;
                } else if (this.bdw) {
                    this.bdf.setImageDrawable(aj.getDrawable(this.bdI));
                    this.bde.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bde.setVisibility(0);
                    this.bds = true;
                    return;
                } else {
                    this.bde.setVisibility(8);
                    return;
                }
            }
            this.bdg.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.bdd != null && this.bdc != null && this.bdb != null && bdVar != null) {
            if (this.bdt) {
                this.bdd.setVisibility(0);
                if (this.bdd.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdd.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdd.setLayoutParams(layoutParams);
                }
                this.bdL = bdVar.AC();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bdc.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.bdc.setLayoutParams(layoutParams2);
                int Ax = bdVar.Ax();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (Ax > 0) {
                    string = am.J(Ax);
                }
                this.bdb.setText(string);
                this.bdb.setContentDescription(this.mContext.getString(d.j.zan_num) + Ax);
                this.bds = true;
                if (bdVar.Ay() != 0) {
                    if (Eu()) {
                        this.bdH = d.f.icon_home_card_like_s_xmas;
                    } else if (usePrayPraiseIcon()) {
                        this.bdH = d.f.icon_card_pray_s;
                    } else {
                        this.bdH = d.f.icon_home_card_like_s;
                    }
                    this.bdc.setImageDrawable(aj.getDrawable(this.bdH));
                    if (this.bdb != null) {
                        aj.r(this.bdb, d.C0141d.cp_cont_h);
                        return;
                    }
                    return;
                }
                if (Eu()) {
                    this.bdH = d.f.icon_home_card_like_n_xmas;
                } else if (usePrayPraiseIcon()) {
                    this.bdH = d.f.icon_card_pray_n;
                } else {
                    this.bdH = d.f.icon_home_card_like_n;
                }
                this.bdc.setImageDrawable(aj.getDrawable(this.bdH));
                if (this.bdb != null) {
                    aj.r(this.bdb, d.C0141d.cp_cont_j);
                    return;
                }
                return;
            }
            this.bdd.setVisibility(8);
        }
    }

    private boolean Eu() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bd bdVar) {
        if (this.bdj != null && this.bdh != null && bdVar != null) {
            if (this.bdB) {
                this.bdj.setVisibility(0);
                if (this.bdj.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdj.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdj.setLayoutParams(layoutParams);
                }
                long Az = bdVar.Az();
                if ((bdVar.Ap() || bdVar.As()) && bdVar.zG() != null) {
                    Az = bdVar.zG().share_info.share_count;
                }
                this.bdh.setText(Az > 0 ? am.J(Az) : this.mContext.getString(d.j.share));
                this.bds = true;
                if (bdVar.aQm != null && bdVar.aQm.isDeleted) {
                    aj.s(this.bdi, d.f.icon_card_share_d);
                    aj.r(this.bdh, d.C0141d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                aj.s(this.bdi, this.bdJ);
                aj.r(this.bdh, d.f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.bdj.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.bdl != null) {
            if (this.aZC == null || v.E(this.aZC.Am()) || !TbadkCoreApplication.isLogin() || this.aZC.An()) {
                this.bdl.setVisibility(8);
                return;
            }
            if (this.bdl.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdl.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.bdl.setLayoutParams(layoutParams);
            }
            if (this.bdm == null) {
                this.bdm = new ArrayList();
            } else {
                this.bdm.clear();
            }
            if (this.bdn == null) {
                this.bdn = new ArrayList();
            } else {
                this.bdn.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aZC.Am()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.bdm.add(reportInfo.info);
                    this.bdn.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.bdl.setOnClickListener(this);
                this.bdl.setVisibility(0);
                return;
            }
            this.bdl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bd bdVar) {
        if (this.bdq != null && bdVar != null) {
            if (this.bdC) {
                this.bdq.setVisibility(0);
                if (this.bdq.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdq.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdq.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.bdo.setText(string);
                this.bdo.setContentDescription(string);
                this.bds = true;
                return;
            }
            this.bdq.setVisibility(8);
        }
    }

    private void Ev() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bdm, new b.InterfaceC0097b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayout.this.bdn, i);
                    if (!StringUtils.isNull(str)) {
                        aw.Du().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AY();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bcZ, d.C0141d.cp_cont_d);
        aj.r(this.bda, d.C0141d.cp_cont_j);
        aj.r(this.bdb, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bde, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bdo, d.f.selector_comment_and_prise_item_text_color);
        aj.s(this.bdk, d.f.btn_frs_more_selector);
        if (this.aZC != null && this.aZC.Ay() == 1 && this.bdb != null) {
            aj.r(this.bdb, d.C0141d.cp_cont_h);
            if (Eu()) {
                this.bdH = d.f.icon_home_card_like_s_xmas;
            } else if (usePrayPraiseIcon()) {
                this.bdH = d.f.icon_card_pray_s;
            } else {
                this.bdH = d.f.icon_home_card_like_s;
            }
        }
        if (this.bdb != null && this.bdx && this.bdH > 0) {
            this.bdc.setImageDrawable(aj.getDrawable(this.bdH));
        }
        if (this.bde != null && this.bdw && this.bdI > 0) {
            this.bdf.setImageDrawable(aj.getDrawable(this.bdI));
        }
        if (this.aZC != null && this.aZC.aQm != null && this.aZC.aQm.isDeleted) {
            aj.s(this.bdi, d.f.icon_card_share_d);
            aj.r(this.bdh, d.C0141d.cp_cont_e);
            setShareClickable(false);
        } else {
            aj.s(this.bdi, this.bdJ);
            aj.r(this.bdh, d.f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.bdp != null) {
            this.bdp.setImageDrawable(aj.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.bdr != null) {
            this.bdr.onChangeSkinType();
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bdG = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.bcZ;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdM != null) {
            this.bdM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdM);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.bdA = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.bdu = z;
    }

    public View getCommentNumView() {
        return this.bde;
    }

    public View getCommentContainer() {
        return this.bdg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Animation getScaleAnimation() {
        if (this.bdK == null) {
            this.bdK = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdK.setDuration(200L);
        }
        return this.bdK;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.bdw = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.bdx = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.bdy = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.bdC = z;
    }

    public boolean usePrayPraiseIcon() {
        return this.bdL;
    }

    public void setUsePrayPraiseIcon(boolean z) {
        this.bdL = z;
    }
}
