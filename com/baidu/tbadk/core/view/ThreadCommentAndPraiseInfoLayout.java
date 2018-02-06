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
    public int aQE;
    protected bd aZM;
    protected View bdA;
    private w bdB;
    protected boolean bdC;
    protected boolean bdD;
    private boolean bdE;
    protected boolean bdF;
    protected boolean bdG;
    private boolean bdH;
    protected boolean bdI;
    protected boolean bdJ;
    private boolean bdK;
    protected boolean bdL;
    protected boolean bdM;
    private int bdN;
    private int bdO;
    private String bdP;
    private View.OnClickListener bdQ;
    protected int bdR;
    protected int bdS;
    protected int bdT;
    protected ScaleAnimation bdU;
    private CustomMessageListener bdV;
    protected int bdi;
    protected TextView bdj;
    private TextView bdk;
    protected TextView bdl;
    protected ImageView bdm;
    protected View bdn;
    protected TextView bdo;
    protected ImageView bdp;
    protected View bdq;
    protected TextView bdr;
    protected ImageView bds;
    protected View bdt;
    protected TextView bdu;
    protected FrameLayout bdv;
    private List<CharSequence> bdw;
    private List<String> bdx;
    protected TextView bdy;
    protected ImageView bdz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.bdP = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.bdN = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bdi = 0;
        this.bdC = false;
        this.bdD = true;
        this.bdE = true;
        this.bdF = true;
        this.bdG = false;
        this.bdH = false;
        this.bdI = false;
        this.bdJ = true;
        this.bdK = false;
        this.bdL = true;
        this.bdM = false;
        this.mFrom = 2;
        this.bdN = 1;
        this.bdV = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aZM != null && ThreadCommentAndPraiseInfoLayout.this.aZM.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.zc() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aZM.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aZM.zc() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aZM.zc().setNum(bdVar.zc().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aZM);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdi = 0;
        this.bdC = false;
        this.bdD = true;
        this.bdE = true;
        this.bdF = true;
        this.bdG = false;
        this.bdH = false;
        this.bdI = false;
        this.bdJ = true;
        this.bdK = false;
        this.bdL = true;
        this.bdM = false;
        this.mFrom = 2;
        this.bdN = 1;
        this.bdV = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aZM != null && ThreadCommentAndPraiseInfoLayout.this.aZM.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.zc() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aZM.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aZM.zc() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aZM.zc().setNum(bdVar.zc().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aZM);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bdi = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.bdj = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.bdk = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bdo = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bdp = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.bdq = inflate.findViewById(d.g.thread_info_commont_container);
        this.bdr = (TextView) inflate.findViewById(d.g.share_num);
        this.bds = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.bdt = inflate.findViewById(d.g.share_num_container);
        this.bdu = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bdv = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.bdl = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.bdm = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.bdn = inflate.findViewById(d.g.agree_view_container);
        this.bdA = inflate.findViewById(d.g.manage_view_container);
        this.bdy = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.bdz = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.bdn.setOnClickListener(this);
        this.bdq.setOnClickListener(this);
        this.bdt.setOnClickListener(this);
        this.bdA.setOnClickListener(this);
        this.bdT = d.f.icon_home_card_share;
        this.bdS = d.f.icon_home_card_comment;
        this.bdO = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bdj) {
            aU(view);
        } else if (view == this.bdq) {
            aV(view);
        } else if (view == this.bdn) {
            aW(view);
        } else if (view == this.bdt) {
            aX(view);
        } else if (view == this.bdv) {
            aZ(view);
        } else if (view == this.bdA) {
            aY(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bdB != null) {
            this.bdB.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.bdq != null) {
            this.bdq.setClickable(z);
            this.bdp.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bdn != null) {
            this.bdn.setClickable(z);
            this.bdm.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.bdt != null) {
            this.bdt.setEnabled(z);
            this.bds.setEnabled(z);
        }
    }

    private void aU(View view) {
        if (this.aZM != null && !StringUtils.isNull(this.aZM.zt())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.bdP)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.aZM.zt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aZM.zt(), this.mStType, this.bdP)));
            }
            if (this.bdQ != null) {
                this.bdQ.onClick(view);
            }
        }
    }

    private void aV(View view) {
        if (this.aZM != null && this.mContext != null) {
            com.baidu.tieba.card.j.kr(this.aZM.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aZM, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aZM.getFid()));
            addLocateParam.setForumName(this.aZM.zt());
            addLocateParam.setJumpToCommentArea(true);
            if (this.aZM.Ac() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.aQE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.s("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
            ak akVar2 = new ak("c12942");
            akVar2.s("obj_locate", this.mFrom);
            akVar2.s("obj_type", getThreadType());
            akVar2.ab("tid", this.aZM.getTid());
            TiebaStatic.log(akVar2);
            if (this.bdQ != null) {
                this.bdQ.onClick(view);
            }
        }
    }

    private int getThreadType() {
        if (this.aZM == null) {
            return 0;
        }
        if (this.aZM.isShareThread) {
            return 4;
        }
        if (this.aZM.getThreadType() == 49) {
            return 5;
        }
        if (this.aZM.zF() != null) {
            return 1;
        }
        if (this.aZM.getType() == bd.aOu || this.aZM.getType() == bd.aOw) {
            if (v.D(this.aZM.zC()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    protected void aW(View view) {
        int i = 1;
        if (ay.ba(this.mContext) && this.aZM != null) {
            if (this.aZM.Ay() != 0) {
                this.aZM.eY(this.aZM.Ax() - 1);
                this.aZM.eX(0);
                if (this.bdl != null) {
                    aj.r(this.bdl, d.C0140d.cp_cont_j);
                }
            } else {
                this.aZM.eX(1);
                this.aZM.eY(this.aZM.Ax() + 1);
                if (this.bdl != null) {
                    aj.r(this.bdl, d.C0140d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.aZM);
            if (this.bdm != null && i == 0) {
                this.bdm.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.aZM.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.bdO > 0) {
                httpMessage.addParam("forum_id", this.aZM.getFid());
            }
            if (this.mPageContext != null) {
                httpMessage.setTag(this.mPageContext.getUniqueId());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ab("tid", this.aZM.getTid());
            if (this.aZM.getThreadType() == 40) {
                akVar.ab("obj_param1", "2");
            } else if (this.aZM.getThreadType() == 0) {
                akVar.ab("obj_param1", "1");
            }
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f(ImageViewerConfig.FORUM_ID, this.aZM.getFid());
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
        if (this.aZM != null) {
            if (this.bdN != 1) {
                if (this.bdN == 2) {
                    i = 5;
                } else if (this.bdN == 3) {
                    i = 3;
                } else if (this.bdN == 4) {
                    i = 2;
                } else if (this.bdN != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f(ImageViewerConfig.FORUM_ID, this.aZM.getFid()).ab("tid", this.aZM.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_locate", i));
        }
    }

    private void Es() {
        if (this.aZM != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aZM.getFid());
            String zt = this.aZM.zt();
            String title = this.aZM.getTitle();
            String tid = this.aZM.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aZM);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.aZM.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.blE = str2;
            dVar.linkUrl = str;
            dVar.aQD = this.bdN;
            dVar.extData = tid;
            dVar.blH = 3;
            dVar.fid = valueOf;
            dVar.blz = zt;
            dVar.tid = tid;
            dVar.blw = true;
            dVar.blG = getShareObjSource();
            dVar.blI = b(this.aZM);
            if (parse != null) {
                dVar.blB = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aZM);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blH);
            bundle.putInt("obj_type", dVar.blI);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQD);
            dVar.i(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aZM.getThreadType() == 49 || this.aZM.getThreadType() == 60);
            com.baidu.tieba.d.d.anj().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.bdN == 1) {
            return 5;
        }
        if (this.bdN != 3) {
            if (this.bdN == 4) {
                return 4;
            }
            if (this.bdN != 6) {
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
        if (this.bdB == null) {
            this.bdB = new w(this.mPageContext);
        }
        this.bdB.setData(this.aZM);
        com.baidu.adp.lib.g.g.a(this.bdB, this.mPageContext);
        TiebaStatic.log(new ak("c12711"));
    }

    private void aZ(View view) {
        Ev();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.bdF = z;
        if (this.bdj != null) {
            this.bdj.setClickable(this.bdF);
        }
    }

    public boolean isMoreViewVisible() {
        return this.bdv != null && this.bdv.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.bdO = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZM = bdVar;
        Et();
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        g(bdVar);
        setVisibility(this.bdC ? 0 : 8);
        return this.bdC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Et() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(bd bdVar) {
        this.bdj.setVisibility(8);
    }

    private void d(bd bdVar) {
        String A;
        if (this.bdk != null && bdVar != null) {
            if (bdVar.zh() <= 0 || !this.bdE) {
                this.bdk.setVisibility(8);
                return;
            }
            this.bdk.setVisibility(0);
            if (this.mFrom == 3) {
                A = am.y(bdVar.zh());
            } else {
                A = am.A(bdVar.zh() * 1000);
            }
            this.bdk.setText(A);
            this.bdC = true;
        }
    }

    public boolean isVisible() {
        return this.bdC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(bd bdVar) {
        if (this.bdo != null && bdVar != null) {
            if (this.bdJ) {
                this.bdq.setVisibility(0);
                if (this.bdq.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdq.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdq.setLayoutParams(layoutParams);
                }
                if (bdVar.zf() > 0) {
                    this.bdo.setVisibility(0);
                    String J = am.J(bdVar.zf());
                    if (this.bdG) {
                        this.bdp.setImageDrawable(aj.getDrawable(this.bdS));
                        this.bdo.setText(J);
                    } else {
                        this.bdo.setText(String.format(this.mContext.getString(d.j.reply_num_tip), J));
                    }
                    this.bdo.setContentDescription(this.mContext.getString(d.j.reply_num) + J);
                    this.bdC = true;
                    return;
                } else if (this.bdG) {
                    this.bdp.setImageDrawable(aj.getDrawable(this.bdS));
                    this.bdo.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bdo.setVisibility(0);
                    this.bdC = true;
                    return;
                } else {
                    this.bdo.setVisibility(8);
                    return;
                }
            }
            this.bdq.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.bdn != null && this.bdm != null && this.bdl != null && bdVar != null) {
            if (this.bdD) {
                this.bdn.setVisibility(0);
                if (this.bdn.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdn.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdn.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bdm.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.bdm.setLayoutParams(layoutParams2);
                int Ax = bdVar.Ax();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (Ax > 0) {
                    string = am.J(Ax);
                }
                this.bdl.setText(string);
                this.bdl.setContentDescription(this.mContext.getString(d.j.zan_num) + Ax);
                this.bdC = true;
                if (bdVar.Ay() != 0) {
                    this.bdR = Eu() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.bdm.setImageDrawable(aj.getDrawable(this.bdR));
                    if (this.bdl != null) {
                        aj.r(this.bdl, d.C0140d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.bdR = Eu() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.bdm.setImageDrawable(aj.getDrawable(this.bdR));
                if (this.bdl != null) {
                    aj.r(this.bdl, d.C0140d.cp_cont_j);
                    return;
                }
                return;
            }
            this.bdn.setVisibility(8);
        }
    }

    private boolean Eu() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.Fr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bd bdVar) {
        if (this.bdt != null && this.bdr != null && bdVar != null) {
            if (this.bdL) {
                this.bdt.setVisibility(0);
                if (this.bdt.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdt.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdt.setLayoutParams(layoutParams);
                }
                long Az = bdVar.Az();
                if ((bdVar.Ap() || bdVar.As()) && bdVar.zG() != null) {
                    Az = bdVar.zG().share_info.share_count;
                }
                this.bdr.setText(Az > 0 ? am.J(Az) : this.mContext.getString(d.j.share));
                this.bdC = true;
                if (bdVar.aQw != null && bdVar.aQw.isDeleted) {
                    aj.s(this.bds, d.f.icon_card_share_d);
                    aj.r(this.bdr, d.C0140d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                aj.s(this.bds, this.bdT);
                aj.r(this.bdr, d.f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.bdt.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.bdv != null) {
            if (this.aZM == null || v.E(this.aZM.Am()) || !TbadkCoreApplication.isLogin() || this.aZM.An()) {
                this.bdv.setVisibility(8);
                return;
            }
            if (this.bdv.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdv.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.bdv.setLayoutParams(layoutParams);
            }
            if (this.bdw == null) {
                this.bdw = new ArrayList();
            } else {
                this.bdw.clear();
            }
            if (this.bdx == null) {
                this.bdx = new ArrayList();
            } else {
                this.bdx.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aZM.Am()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.bdw.add(reportInfo.info);
                    this.bdx.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.bdv.setOnClickListener(this);
                this.bdv.setVisibility(0);
                return;
            }
            this.bdv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bd bdVar) {
        if (this.bdA != null && bdVar != null) {
            if (this.bdM) {
                this.bdA.setVisibility(0);
                if (this.bdA.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bdA.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bdA.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.bdy.setText(string);
                this.bdy.setContentDescription(string);
                this.bdC = true;
                return;
            }
            this.bdA.setVisibility(8);
        }
    }

    private void Ev() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bdw, new b.InterfaceC0096b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayout.this.bdx, i);
                    if (!StringUtils.isNull(str)) {
                        aw.Du().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AX();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bdj, d.C0140d.cp_cont_d);
        aj.r(this.bdk, d.C0140d.cp_cont_j);
        aj.r(this.bdl, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bdo, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bdy, d.f.selector_comment_and_prise_item_text_color);
        aj.s(this.bdu, d.f.btn_frs_more_selector);
        if (this.aZM != null && this.aZM.Ay() == 1 && this.bdl != null) {
            aj.r(this.bdl, d.C0140d.cp_cont_h);
            this.bdR = d.f.icon_home_card_like_s;
        }
        if (this.bdl != null && this.bdH && this.bdR > 0) {
            this.bdm.setImageDrawable(aj.getDrawable(this.bdR));
        }
        if (this.bdo != null && this.bdG && this.bdS > 0) {
            this.bdp.setImageDrawable(aj.getDrawable(this.bdS));
        }
        if (this.aZM != null && this.aZM.aQw != null && this.aZM.aQw.isDeleted) {
            aj.s(this.bds, d.f.icon_card_share_d);
            aj.r(this.bdr, d.C0140d.cp_cont_e);
            setShareClickable(false);
        } else {
            aj.s(this.bds, this.bdT);
            aj.r(this.bdr, d.f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.bdz != null) {
            this.bdz.setImageDrawable(aj.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.bdB != null) {
            this.bdB.onChangeSkinType();
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bdQ = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.bdj;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bdV != null) {
            this.bdV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdV);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.bdK = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.bdE = z;
    }

    public View getCommentNumView() {
        return this.bdo;
    }

    public View getCommentContainer() {
        return this.bdq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Animation getScaleAnimation() {
        if (this.bdU == null) {
            this.bdU = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bdU.setDuration(200L);
        }
        return this.bdU;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.bdG = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.bdH = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.bdI = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.bdM = z;
    }
}
