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
    public int aQt;
    protected bd aZA;
    protected int bcW;
    protected TextView bcX;
    private TextView bcY;
    protected TextView bcZ;
    protected boolean bdA;
    private int bdB;
    private int bdC;
    private String bdD;
    private View.OnClickListener bdE;
    protected int bdF;
    protected int bdG;
    protected int bdH;
    protected ScaleAnimation bdI;
    private CustomMessageListener bdJ;
    protected ImageView bda;
    protected View bdb;
    protected TextView bdc;
    protected ImageView bdd;
    protected View bde;
    protected TextView bdf;
    protected ImageView bdg;
    protected View bdh;
    protected TextView bdi;
    protected FrameLayout bdj;
    private List<CharSequence> bdk;
    private List<String> bdl;
    protected TextView bdm;
    protected ImageView bdn;
    protected View bdo;
    private w bdp;
    protected boolean bdq;
    protected boolean bdr;
    private boolean bds;
    protected boolean bdt;
    protected boolean bdu;
    private boolean bdv;
    protected boolean bdw;
    protected boolean bdx;
    private boolean bdy;
    protected boolean bdz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.bdD = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.bdB = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bcW = 0;
        this.bdq = false;
        this.bdr = true;
        this.bds = true;
        this.bdt = true;
        this.bdu = false;
        this.bdv = false;
        this.bdw = false;
        this.bdx = true;
        this.bdy = false;
        this.bdz = true;
        this.bdA = false;
        this.mFrom = 2;
        this.bdB = 1;
        this.bdJ = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aZA != null && ThreadCommentAndPraiseInfoLayout.this.aZA.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.zc() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aZA.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aZA.zc() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aZA.zc().setNum(bdVar.zc().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aZA);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcW = 0;
        this.bdq = false;
        this.bdr = true;
        this.bds = true;
        this.bdt = true;
        this.bdu = false;
        this.bdv = false;
        this.bdw = false;
        this.bdx = true;
        this.bdy = false;
        this.bdz = true;
        this.bdA = false;
        this.mFrom = 2;
        this.bdB = 1;
        this.bdJ = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aZA != null && ThreadCommentAndPraiseInfoLayout.this.aZA.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.zc() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aZA.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aZA.zc() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aZA.zc().setNum(bdVar.zc().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aZA);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bcW = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.bcX = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.bcY = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bdc = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bdd = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.bde = inflate.findViewById(d.g.thread_info_commont_container);
        this.bdf = (TextView) inflate.findViewById(d.g.share_num);
        this.bdg = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.bdh = inflate.findViewById(d.g.share_num_container);
        this.bdi = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bdj = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.bcZ = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.bda = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.bdb = inflate.findViewById(d.g.agree_view_container);
        this.bdo = inflate.findViewById(d.g.manage_view_container);
        this.bdm = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.bdn = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.bdb.setOnClickListener(this);
        this.bde.setOnClickListener(this);
        this.bdh.setOnClickListener(this);
        this.bdo.setOnClickListener(this);
        this.bdH = d.f.icon_home_card_share;
        this.bdG = d.f.icon_home_card_comment;
        this.bdC = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bcX) {
            aU(view);
        } else if (view == this.bde) {
            aV(view);
        } else if (view == this.bdb) {
            aW(view);
        } else if (view == this.bdh) {
            aX(view);
        } else if (view == this.bdj) {
            aZ(view);
        } else if (view == this.bdo) {
            aY(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bdp != null) {
            this.bdp.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.bde != null) {
            this.bde.setClickable(z);
            this.bdd.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bdb != null) {
            this.bdb.setClickable(z);
            this.bda.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.bdh != null) {
            this.bdh.setEnabled(z);
            this.bdg.setEnabled(z);
        }
    }

    private void aU(View view) {
        if (this.aZA != null && !StringUtils.isNull(this.aZA.zt())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.bdD)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.aZA.zt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aZA.zt(), this.mStType, this.bdD)));
            }
            if (this.bdE != null) {
                this.bdE.onClick(view);
            }
        }
    }

    private void aV(View view) {
        if (this.aZA != null && this.mContext != null) {
            com.baidu.tieba.card.j.kr(this.aZA.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aZA, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aZA.getFid()));
            addLocateParam.setForumName(this.aZA.zt());
            addLocateParam.setJumpToCommentArea(true);
            if (this.aZA.Ac() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.aQt);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.s("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
            ak akVar2 = new ak("c12942");
            akVar2.s("obj_locate", this.mFrom);
            akVar2.s("obj_type", getThreadType());
            akVar2.ab("tid", this.aZA.getTid());
            TiebaStatic.log(akVar2);
            if (this.bdE != null) {
                this.bdE.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.aZA == null) {
            return 0;
        }
        if (this.aZA.isShareThread) {
            return 4;
        }
        if (this.aZA.getThreadType() == 49) {
            return 5;
        }
        if (this.aZA.zF() != null) {
            return 1;
        }
        if (this.aZA.getType() == bd.aOj || this.aZA.getType() == bd.aOl) {
            if (v.D(this.aZA.zC()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    protected void aW(View view) {
        int i = 1;
        if (ay.ba(this.mContext) && this.aZA != null) {
            if (this.aZA.Ay() != 0) {
                this.aZA.eY(this.aZA.Ax() - 1);
                this.aZA.eX(0);
                if (this.bcZ != null) {
                    aj.r(this.bcZ, d.C0141d.cp_cont_j);
                }
            } else {
                this.aZA.eX(1);
                this.aZA.eY(this.aZA.Ax() + 1);
                if (this.bcZ != null) {
                    aj.r(this.bcZ, d.C0141d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.aZA);
            if (this.bda != null && i == 0) {
                this.bda.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.aZA.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.bdC > 0) {
                httpMessage.addParam("forum_id", this.aZA.getFid());
            }
            if (this.mPageContext != null) {
                httpMessage.setTag(this.mPageContext.getUniqueId());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ab("tid", this.aZA.getTid());
            if (this.aZA.getThreadType() == 40) {
                akVar.ab("obj_param1", "2");
            } else if (this.aZA.getThreadType() == 0) {
                akVar.ab("obj_param1", "1");
            }
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f(ImageViewerConfig.FORUM_ID, this.aZA.getFid());
            akVar.s("obj_locate", this.mFrom);
            akVar.s("obj_id", i);
            TiebaStatic.log(akVar);
        }
    }

    protected void aX(View view) {
        if (ap.nv() || ay.ba(this.mContext)) {
            Eq();
            Er();
        }
    }

    private void Eq() {
        int i = 4;
        if (this.aZA != null) {
            if (this.bdB != 1) {
                if (this.bdB == 2) {
                    i = 5;
                } else if (this.bdB == 3) {
                    i = 3;
                } else if (this.bdB == 4) {
                    i = 2;
                } else if (this.bdB != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f(ImageViewerConfig.FORUM_ID, this.aZA.getFid()).ab("tid", this.aZA.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_locate", i));
        }
    }

    private void Er() {
        if (this.aZA != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aZA.getFid());
            String zt = this.aZA.zt();
            String title = this.aZA.getTitle();
            String tid = this.aZA.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aZA);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.aZA.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.blr = str2;
            dVar.linkUrl = str;
            dVar.aQs = this.bdB;
            dVar.extData = tid;
            dVar.blu = 3;
            dVar.fid = valueOf;
            dVar.blm = zt;
            dVar.tid = tid;
            dVar.blj = true;
            dVar.blt = getShareObjSource();
            dVar.blv = b(this.aZA);
            if (parse != null) {
                dVar.blo = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aZA);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blu);
            bundle.putInt("obj_type", dVar.blv);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQs);
            dVar.i(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aZA.getThreadType() == 49 || this.aZA.getThreadType() == 60);
            com.baidu.tieba.d.d.ani().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.bdB == 1) {
            return 5;
        }
        if (this.bdB != 3) {
            if (this.bdB == 4) {
                return 4;
            }
            if (this.bdB != 6) {
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
        if (this.bdp == null) {
            this.bdp = new w(this.mPageContext);
        }
        this.bdp.setData(this.aZA);
        com.baidu.adp.lib.g.g.a(this.bdp, this.mPageContext);
        TiebaStatic.log(new ak("c12711"));
    }

    private void aZ(View view) {
        Eu();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.bdt = z;
        if (this.bcX != null) {
            this.bcX.setClickable(this.bdt);
        }
    }

    public boolean isMoreViewVisible() {
        return this.bdj != null && this.bdj.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.bdC = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZA = bdVar;
        Es();
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        g(bdVar);
        setVisibility(this.bdq ? 0 : 8);
        return this.bdq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Es() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(bd bdVar) {
        this.bcX.setVisibility(8);
    }

    private void d(bd bdVar) {
        String A;
        if (this.bcY != null && bdVar != null) {
            if (bdVar.zh() <= 0 || !this.bds) {
                this.bcY.setVisibility(8);
                return;
            }
            this.bcY.setVisibility(0);
            if (this.mFrom == 3) {
                A = am.y(bdVar.zh());
            } else {
                A = am.A(bdVar.zh() * 1000);
            }
            this.bcY.setText(A);
            this.bdq = true;
        }
    }

    public boolean isVisible() {
        return this.bdq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(bd bdVar) {
        if (this.bdc != null && bdVar != null) {
            if (this.bdx) {
                this.bde.setVisibility(0);
                if (this.bde.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bde.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bde.setLayoutParams(layoutParams);
                }
                if (bdVar.zf() > 0) {
                    this.bdc.setVisibility(0);
                    String J = am.J(bdVar.zf());
                    if (this.bdu) {
                        this.bdd.setImageDrawable(aj.getDrawable(this.bdG));
                        this.bdc.setText(J);
                    } else {
                        this.bdc.setText(String.format(this.mContext.getString(d.j.reply_num_tip), J));
                    }
                    this.bdc.setContentDescription(this.mContext.getString(d.j.reply_num) + J);
                    this.bdq = true;
                    return;
                } else if (this.bdu) {
                    this.bdd.setImageDrawable(aj.getDrawable(this.bdG));
                    this.bdc.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bdc.setVisibility(0);
                    this.bdq = true;
                    return;
                } else {
                    this.bdc.setVisibility(8);
                    return;
                }
            }
            this.bde.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.bdb != null && this.bda != null && this.bcZ != null && bdVar != null) {
            if (this.bdr) {
                this.bdb.setVisibility(0);
                if (this.bdb.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdb.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdb.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bda.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.bda.setLayoutParams(layoutParams2);
                int Ax = bdVar.Ax();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (Ax > 0) {
                    string = am.J(Ax);
                }
                this.bcZ.setText(string);
                this.bcZ.setContentDescription(this.mContext.getString(d.j.zan_num) + Ax);
                this.bdq = true;
                if (bdVar.Ay() != 0) {
                    this.bdF = Et() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.bda.setImageDrawable(aj.getDrawable(this.bdF));
                    if (this.bcZ != null) {
                        aj.r(this.bcZ, d.C0141d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.bdF = Et() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.bda.setImageDrawable(aj.getDrawable(this.bdF));
                if (this.bcZ != null) {
                    aj.r(this.bcZ, d.C0141d.cp_cont_j);
                    return;
                }
                return;
            }
            this.bdb.setVisibility(8);
        }
    }

    private boolean Et() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bd bdVar) {
        if (this.bdh != null && this.bdf != null && bdVar != null) {
            if (this.bdz) {
                this.bdh.setVisibility(0);
                if (this.bdh.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdh.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdh.setLayoutParams(layoutParams);
                }
                long Az = bdVar.Az();
                if ((bdVar.Ap() || bdVar.As()) && bdVar.zG() != null) {
                    Az = bdVar.zG().share_info.share_count;
                }
                this.bdf.setText(Az > 0 ? am.J(Az) : this.mContext.getString(d.j.share));
                this.bdq = true;
                if (bdVar.aQl != null && bdVar.aQl.isDeleted) {
                    aj.s(this.bdg, d.f.icon_card_share_d);
                    aj.r(this.bdf, d.C0141d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                aj.s(this.bdg, this.bdH);
                aj.r(this.bdf, d.f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.bdh.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.bdj != null) {
            if (this.aZA == null || v.E(this.aZA.Am()) || !TbadkCoreApplication.isLogin() || this.aZA.An()) {
                this.bdj.setVisibility(8);
                return;
            }
            if (this.bdj.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdj.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.bdj.setLayoutParams(layoutParams);
            }
            if (this.bdk == null) {
                this.bdk = new ArrayList();
            } else {
                this.bdk.clear();
            }
            if (this.bdl == null) {
                this.bdl = new ArrayList();
            } else {
                this.bdl.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aZA.Am()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.bdk.add(reportInfo.info);
                    this.bdl.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.bdj.setOnClickListener(this);
                this.bdj.setVisibility(0);
                return;
            }
            this.bdj.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bd bdVar) {
        if (this.bdo != null && bdVar != null) {
            if (this.bdA) {
                this.bdo.setVisibility(0);
                if (this.bdo.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdo.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdo.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.bdm.setText(string);
                this.bdm.setContentDescription(string);
                this.bdq = true;
                return;
            }
            this.bdo.setVisibility(8);
        }
    }

    private void Eu() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bdk, new b.InterfaceC0097b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayout.this.bdl, i);
                    if (!StringUtils.isNull(str)) {
                        aw.Dt().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AX();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bcX, d.C0141d.cp_cont_d);
        aj.r(this.bcY, d.C0141d.cp_cont_j);
        aj.r(this.bcZ, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bdc, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bdm, d.f.selector_comment_and_prise_item_text_color);
        aj.s(this.bdi, d.f.btn_frs_more_selector);
        if (this.aZA != null && this.aZA.Ay() == 1 && this.bcZ != null) {
            aj.r(this.bcZ, d.C0141d.cp_cont_h);
            this.bdF = d.f.icon_home_card_like_s;
        }
        if (this.bcZ != null && this.bdv && this.bdF > 0) {
            this.bda.setImageDrawable(aj.getDrawable(this.bdF));
        }
        if (this.bdc != null && this.bdu && this.bdG > 0) {
            this.bdd.setImageDrawable(aj.getDrawable(this.bdG));
        }
        if (this.aZA != null && this.aZA.aQl != null && this.aZA.aQl.isDeleted) {
            aj.s(this.bdg, d.f.icon_card_share_d);
            aj.r(this.bdf, d.C0141d.cp_cont_e);
            setShareClickable(false);
        } else {
            aj.s(this.bdg, this.bdH);
            aj.r(this.bdf, d.f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.bdn != null) {
            this.bdn.setImageDrawable(aj.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.bdp != null) {
            this.bdp.onChangeSkinType();
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bdE = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.bcX;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdJ != null) {
            this.bdJ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdJ);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.bdy = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.bds = z;
    }

    public View getCommentNumView() {
        return this.bdc;
    }

    public View getCommentContainer() {
        return this.bde;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Animation getScaleAnimation() {
        if (this.bdI == null) {
            this.bdI = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdI.setDuration(200L);
        }
        return this.bdI;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.bdu = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.bdv = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.bdw = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.bdA = z;
    }
}
