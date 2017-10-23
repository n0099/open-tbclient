package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.o.al;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import com.baidu.tieba.model.ShareReportModel;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout implements View.OnClickListener {
    private bh aiU;
    protected ImageView amA;
    protected View amB;
    protected TextView amC;
    private ImageView amD;
    protected View amE;
    protected TextView amF;
    private ImageView amG;
    protected View amH;
    private TextView amI;
    private TextView amJ;
    private TextView amK;
    private TextView amL;
    private FrameLayout amM;
    private List<CharSequence> amN;
    private List<String> amO;
    protected boolean amP;
    private boolean amQ;
    protected boolean amR;
    private boolean amS;
    protected boolean amT;
    private boolean amU;
    protected boolean amV;
    private boolean amW;
    protected boolean amX;
    protected boolean amY;
    private boolean amZ;
    protected TextView amv;
    private TextView amw;
    private View amx;
    private TextView amy;
    protected TextView amz;
    private boolean ana;
    protected boolean anb;
    private int anc;
    private int and;
    private String ane;
    private View.OnClickListener anf;
    protected int ang;
    private int anh;
    private int ani;
    private int anj;
    private int ank;
    private ScaleAnimation anl;
    private ShareReportModel anm;
    private CustomMessageListener ann;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mH;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.ane = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.anc = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.amP = false;
        this.amQ = false;
        this.amR = false;
        this.amS = true;
        this.amT = true;
        this.amU = false;
        this.amV = false;
        this.amW = false;
        this.amX = true;
        this.amY = true;
        this.amZ = false;
        this.ana = false;
        this.anb = false;
        this.mFrom = 2;
        this.anc = 1;
        this.ann = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && ThreadCommentAndPraiseInfoLayout.this.aiU != null && ThreadCommentAndPraiseInfoLayout.this.aiU.getId() != null) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bhVar.getId()) && bhVar.re() != null && bhVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aiU.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aiU.re() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aiU.re().setNum(bhVar.re().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aiU);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amP = false;
        this.amQ = false;
        this.amR = false;
        this.amS = true;
        this.amT = true;
        this.amU = false;
        this.amV = false;
        this.amW = false;
        this.amX = true;
        this.amY = true;
        this.amZ = false;
        this.ana = false;
        this.anb = false;
        this.mFrom = 2;
        this.anc = 1;
        this.ann = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && ThreadCommentAndPraiseInfoLayout.this.aiU != null && ThreadCommentAndPraiseInfoLayout.this.aiU.getId() != null) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bhVar.getId()) && bhVar.re() != null && bhVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aiU.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aiU.re() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aiU.re().setNum(bhVar.re().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aiU);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.amv = (TextView) inflate.findViewById(d.h.thread_info_bar_name);
        this.amw = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.amx = inflate.findViewById(d.h.frs_item_location_sep);
        this.amy = (TextView) inflate.findViewById(d.h.frs_item_location_address);
        this.amz = (TextView) inflate.findViewById(d.h.thread_info_praise_num);
        this.amC = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.amD = (ImageView) inflate.findViewById(d.h.thread_info_commont_img);
        this.amE = inflate.findViewById(d.h.thread_info_commont_container);
        this.amF = (TextView) inflate.findViewById(d.h.share_num);
        this.amG = (ImageView) inflate.findViewById(d.h.share_num_img);
        this.amH = inflate.findViewById(d.h.share_num_container);
        this.amI = (TextView) inflate.findViewById(d.h.thread_info_share_num);
        this.amJ = (TextView) inflate.findViewById(d.h.thread_info_audience_num);
        this.amK = (TextView) inflate.findViewById(d.h.thread_info_view_num);
        this.amL = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.amM = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        this.mContext = context;
        this.amA = (ImageView) inflate.findViewById(d.h.thread_info_praise_img);
        this.amB = inflate.findViewById(d.h.agree_view_container);
        this.amB.setOnClickListener(this);
        this.amE.setOnClickListener(this);
        this.amH.setOnClickListener(this);
        this.ani = d.g.icon_home_card_share;
        this.anh = d.g.icon_home_card_comment;
        this.and = 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.amv) {
            B(view);
        } else if (view == this.amE) {
            C(view);
        } else if (view == this.amB) {
            D(view);
        } else if (view == this.amH) {
            E(view);
        } else if (view == this.amM) {
            F(view);
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.amE != null) {
            this.amE.setClickable(z);
            this.amD.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.amB != null) {
            this.amB.setClickable(z);
            this.amA.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.amH != null) {
            this.amH.setClickable(z);
            this.amG.setEnabled(z);
        }
    }

    private void B(View view) {
        if (this.aiU != null && !StringUtils.isNull(this.aiU.rt())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.ane)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.aiU.rt(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aiU.rt(), this.mStType, this.ane)));
            }
            if (this.anf != null) {
                this.anf.onClick(view);
            }
        }
    }

    private void C(View view) {
        if (this.aiU != null && this.mContext != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aiU, null, m.rf(), 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aiU.getFid()));
            addLocateParam.setForumName(this.aiU.rt());
            addLocateParam.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
        }
    }

    private void D(View view) {
        int i = 1;
        if (ax.aT(this.mContext) && this.aiU != null) {
            if (this.aiU.sC() != 0) {
                this.aiU.bZ(this.aiU.sB() - 1);
                this.aiU.bY(0);
                if (this.amz != null) {
                    aj.i(this.amz, d.e.cp_cont_f);
                }
            } else {
                this.aiU.bY(1);
                this.aiU.bZ(this.aiU.sB() + 1);
                if (this.amz != null) {
                    aj.i(this.amz, d.e.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.aiU);
            if (this.amA != null) {
                this.amA.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.aiU.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.and > 0) {
                httpMessage.addParam("forum_id", this.aiU.getFid());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ac("tid", this.aiU.getTid());
            if (this.aiU.getThreadType() == 40) {
                akVar.ac("obj_param1", "2");
            } else if (this.aiU.getThreadType() == 0) {
                akVar.ac("obj_param1", "1");
            }
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f("fid", this.aiU.getFid());
            akVar.r("obj_locate", this.mFrom);
            akVar.r("obj_id", i);
            TiebaStatic.log(akVar);
        }
    }

    private void E(View view) {
        if (al.fS() || ax.aT(this.mContext)) {
            wy();
            wz();
        }
    }

    private void wy() {
        int i = 4;
        if (this.aiU != null) {
            if (this.anc != 1) {
                if (this.anc == 2) {
                    i = 5;
                } else if (this.anc == 3) {
                    i = 3;
                } else if (this.anc == 4) {
                    i = 2;
                } else if (this.anc != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f("fid", this.aiU.getFid()).ac("tid", this.aiU.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void wz() {
        if (this.aiU != null && this.mContext != null) {
            final String valueOf = String.valueOf(this.aiU.getFid());
            String rt = this.aiU.rt();
            String title = this.aiU.getTitle();
            final String tid = this.aiU.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aiU);
            Uri parse = a == null ? null : Uri.parse(a);
            String rw = this.aiU.rw();
            String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, rw);
            final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aty = rw;
            dVar.linkUrl = str;
            dVar.ats = this.anc;
            dVar.extData = tid;
            dVar.atB = 3;
            dVar.fid = valueOf;
            dVar.att = rt;
            dVar.WT = tid;
            dVar.atp = true;
            dVar.atA = getShareObjSource();
            dVar.atC = b(this.aiU);
            if (parse != null) {
                dVar.atv = parse;
            }
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.atB);
            bundle.putInt("obj_type", dVar.atC);
            bundle.putString("fid", dVar.fid);
            bundle.putString("tid", dVar.WT);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ats);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            if (TbadkCoreApplication.isLogin()) {
                shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext, 23007)));
                        TiebaStatic.log(new ak("c10125").ac("tid", tid).ac("fid", valueOf).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ThreadCommentAndPraiseInfoLayout.this.getShareObjSource()));
                        ThreadCommentAndPraiseInfoLayout.this.wA();
                    }
                });
            }
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar.linkUrl = com.baidu.tbadk.coreExtra.d.e.aj(dVar.linkUrl, dVar.WT);
                    com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                    l.showToast(ThreadCommentAndPraiseInfoLayout.this.mContext, view.getResources().getString(d.l.copy_pb_url_success));
                    ThreadCommentAndPraiseInfoLayout.this.wA();
                }
            });
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getShareObjSource() {
        if (this.anc == 1) {
            return 5;
        }
        if (this.anc != 3) {
            if (this.anc == 4) {
                return 4;
            }
            if (this.anc != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bh bhVar) {
        if (bhVar == null || bhVar.ry() == null) {
            return null;
        }
        ArrayList<MediaData> ry = bhVar.ry();
        int size = ry.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = ry.get(i);
            if (mediaData != null && mediaData.getType() == 3) {
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

    private int b(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.rq()) {
                return 4;
            }
            if (bhVar.rl() == 1) {
                return 3;
            }
            return bhVar.su() ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.anm == null) {
                this.anm = new ShareReportModel(this.mH);
            }
            this.anm.j(shareItem.fid, shareItem.WT, shareItem.ats);
        }
    }

    private void F(View view) {
        wB();
    }

    public void setShowPraiseNum(boolean z) {
        this.amR = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.amT = z;
        if (this.amv != null) {
            this.amv.setClickable(this.amT);
        }
    }

    public boolean isMoreViewVisible() {
        return this.amM != null && this.amM.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.and = i;
        }
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiU = bhVar;
        c(bhVar);
        d(bhVar);
        e(bhVar);
        i(bhVar);
        updatePraiseNum(bhVar);
        f(bhVar);
        g(bhVar);
        h(bhVar);
        setVisibility(this.amP ? 0 : 8);
        return this.amP;
    }

    protected void c(bh bhVar) {
        if (this.amv != null && bhVar != null) {
            if (!StringUtils.isNull(bhVar.rt()) && this.amX) {
                this.amv.setVisibility(0);
                String e = am.e(bhVar.rt(), 14, "...");
                String string = getContext().getString(d.l.chosen_pb_original_bar, e);
                if (am.dM(e) > 14) {
                    this.amv.setText(e);
                } else {
                    this.amv.setText(string);
                }
                this.amv.setContentDescription(string);
                this.amv.setOnClickListener(this);
                this.amv.setClickable(this.amT);
                this.amP = true;
                return;
            }
            this.amv.setVisibility(8);
        }
    }

    private void d(bh bhVar) {
        String s;
        if (this.amw != null && bhVar != null) {
            if (bhVar.ri() <= 0 || !this.amS) {
                this.amw.setVisibility(8);
                return;
            }
            this.amw.setVisibility(0);
            if (this.mFrom == 3) {
                s = am.q(bhVar.ri());
            } else {
                s = am.s(bhVar.ri() * 1000);
            }
            this.amw.setText(s);
            this.amP = true;
        }
    }

    private void e(bh bhVar) {
        if (this.amy != null && this.amx != null && bhVar != null) {
            if (this.amQ && !bhVar.rT() && !StringUtils.isNull(bhVar.getAddress())) {
                this.amy.setVisibility(0);
                if (bhVar.ri() <= 0) {
                    this.amx.setVisibility(8);
                } else {
                    this.amx.setVisibility(0);
                }
                this.amy.setText(bhVar.getAddress());
                this.amP = true;
                return;
            }
            this.amy.setVisibility(8);
            this.amx.setVisibility(8);
        }
    }

    protected void f(bh bhVar) {
        if (this.amC != null && bhVar != null) {
            if (this.amY) {
                this.amE.setVisibility(0);
                if (bhVar.rg() > 0) {
                    this.amC.setVisibility(0);
                    String A = am.A(bhVar.rg());
                    if (this.amV) {
                        this.amC.setText(A);
                    } else {
                        this.amC.setText(String.format(this.mContext.getString(d.l.reply_num_tip), A));
                    }
                    this.amC.setContentDescription(this.mContext.getString(d.l.reply_num) + A);
                    this.amP = true;
                    return;
                } else if (this.amV) {
                    this.amC.setText(this.mContext.getString(d.l.action_comment_default));
                    this.amC.setVisibility(0);
                    this.amP = true;
                    return;
                } else {
                    this.amC.setVisibility(8);
                    return;
                }
            }
            this.amE.setVisibility(8);
        }
    }

    private void g(bh bhVar) {
        if ((this.amJ != null || bhVar != null) && bhVar.rG() != null) {
            if (!this.ana) {
                this.amJ.setVisibility(8);
                return;
            }
            this.amJ.setText(am.v(bhVar.rG().audience_count));
            this.amJ.setVisibility(0);
            this.amP = true;
        }
    }

    public void updatePraiseNum(bh bhVar) {
        if (this.amB != null && this.amA != null && this.amz != null && bhVar != null) {
            if (this.amR) {
                this.amB.setVisibility(0);
                int sB = bhVar.sB();
                String string = this.mContext.getString(d.l.action_praise_default);
                if (sB > 0) {
                    string = am.A(sB);
                }
                this.amz.setText(string);
                this.amz.setContentDescription(this.mContext.getString(d.l.zan_num) + sB);
                this.amP = true;
                if (bhVar.sC() != 0) {
                    this.ang = d.g.icon_home_card_like_s;
                    this.amA.setImageDrawable(aj.getDrawable(this.ang));
                    if (this.amz != null) {
                        aj.i(this.amz, d.e.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.ang = d.g.icon_home_card_like_n;
                this.amA.setImageDrawable(aj.getDrawable(this.ang));
                if (this.amz != null) {
                    aj.i(this.amz, d.e.cp_cont_f);
                    return;
                }
                return;
            }
            this.amB.setVisibility(8);
        }
    }

    protected void h(bh bhVar) {
        if (this.amH != null && this.amF != null && bhVar != null) {
            if (this.anb) {
                this.amH.setVisibility(0);
                long sD = bhVar.sD();
                if (bhVar.st() && bhVar.rG() != null) {
                    sD = bhVar.rG().Ux.share_count;
                }
                this.amF.setText(sD > 0 ? am.A(sD) : this.mContext.getString(d.l.action_share_default));
                this.amP = true;
                return;
            }
            this.amH.setVisibility(8);
        }
    }

    private void i(bh bhVar) {
        if (this.amK != null && bhVar != null) {
            if (this.amU && bhVar.rh() > 0) {
                this.amK.setVisibility(0);
                String u = am.u(bhVar.rh());
                this.amK.setText(String.format(this.mContext.getString(d.l.view_num_tip), u));
                this.amK.setContentDescription(this.mContext.getString(d.l.view_num) + u);
                this.amP = true;
                return;
            }
            this.amK.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mH = tbPageContext;
        if (this.amM != null) {
            if (this.aiU == null || v.u(this.aiU.sq()) || !TbadkCoreApplication.isLogin() || this.aiU.sr()) {
                this.amM.setVisibility(8);
                return;
            }
            if (this.amN == null) {
                this.amN = new ArrayList();
            } else {
                this.amN.clear();
            }
            if (this.amO == null) {
                this.amO = new ArrayList();
            } else {
                this.amO.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aiU.sq()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.amN.add(reportInfo.info);
                    this.amO.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.amM.setOnClickListener(this);
                this.amM.setVisibility(0);
                return;
            }
            this.amM.setVisibility(8);
        }
    }

    private void wB() {
        if (this.mH != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mH.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.amN, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.amO, i);
                    if (!StringUtils.isNull(str)) {
                        av.vA().c(ThreadCommentAndPraiseInfoLayout.this.mH, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mH);
            bVar.te();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.amv, d.e.cp_cont_d);
        aj.i(this.amw, d.e.cp_cont_j);
        aj.k(this.amx, d.e.cp_cont_j);
        aj.i(this.amy, d.e.cp_cont_j);
        aj.i(this.amz, d.e.cp_cont_f);
        aj.i(this.amK, d.e.cp_cont_j);
        aj.i(this.amC, d.e.cp_cont_f);
        aj.i(this.amF, d.e.cp_cont_f);
        if (this.aiU != null && this.aiU.sC() == 1 && this.amz != null) {
            aj.i(this.amz, d.e.cp_cont_h);
            this.ang = d.g.icon_home_card_like_s;
        }
        aj.i(this.amI, d.e.cp_cont_j);
        aj.i(this.amJ, d.e.cp_cont_j);
        aj.j(this.amL, d.g.btn_frs_more_selector);
        if (this.amz != null && this.amW && this.ang > 0) {
            this.amA.setImageDrawable(aj.getDrawable(this.ang));
        }
        if (this.amC != null && this.amV && this.anh > 0) {
            this.amD.setImageDrawable(aj.getDrawable(this.anh));
        }
        if (this.amF != null) {
            this.amG.setImageDrawable(aj.getDrawable(this.ani));
        }
        if (this.amI != null && this.amZ && this.anj > 0) {
            this.amI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.anj), (Drawable) null);
        }
        if (this.amJ != null && this.ana && this.ank > 0) {
            this.amJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.ank), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.anf = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.amv;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ann != null) {
            this.ann.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ann);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.amQ = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.amU = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.amY = z;
    }

    public void setLiveShareEnable(boolean z) {
        this.amZ = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.ana = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.amS = z;
    }

    public View getCommentNumView() {
        return this.amC;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.anh = i;
        }
    }

    public void setShareIcon(int i) {
        if (i > 0) {
            this.ani = i;
        }
    }

    public void setLiveShareIcon(int i) {
        if (i > 0) {
            this.anj = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.ank = i;
        }
    }

    private Animation getScaleAnimation() {
        if (this.anl == null) {
            this.anl = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.anl.setDuration(200L);
        }
        return this.anl;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.amV = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.amW = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.amX = z;
    }

    public void setShareVisible(boolean z) {
        this.anb = z;
    }
}
