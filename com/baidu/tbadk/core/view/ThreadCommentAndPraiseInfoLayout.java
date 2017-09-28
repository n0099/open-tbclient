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
    private bh ajg;
    protected TextView amH;
    private TextView amI;
    private View amJ;
    private TextView amK;
    protected TextView amL;
    protected ImageView amM;
    protected View amN;
    protected TextView amO;
    private ImageView amP;
    protected View amQ;
    protected TextView amR;
    private ImageView amS;
    protected View amT;
    private TextView amU;
    private TextView amV;
    private TextView amW;
    private TextView amX;
    private FrameLayout amY;
    private List<CharSequence> amZ;
    private List<String> ana;
    protected boolean anb;
    private boolean anc;
    protected boolean and;
    private boolean ane;
    protected boolean anf;
    private boolean ang;
    protected boolean anh;
    private boolean ani;
    protected boolean anj;
    protected boolean ank;
    private boolean anl;
    private boolean anm;
    protected boolean ann;
    private int ano;
    private int anp;
    private String anq;
    private View.OnClickListener anr;
    protected int ans;
    private int ant;
    private int anu;
    private int anv;
    private int anw;
    private ScaleAnimation anx;
    private ShareReportModel any;
    private CustomMessageListener anz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mG;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.anq = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.ano = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.anb = false;
        this.anc = false;
        this.and = false;
        this.ane = true;
        this.anf = true;
        this.ang = false;
        this.anh = false;
        this.ani = false;
        this.anj = true;
        this.ank = true;
        this.anl = false;
        this.anm = false;
        this.ann = false;
        this.mFrom = 2;
        this.ano = 1;
        this.anz = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && ThreadCommentAndPraiseInfoLayout.this.ajg != null && ThreadCommentAndPraiseInfoLayout.this.ajg.getId() != null) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bhVar.getId()) && bhVar.rl() != null && bhVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajg.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajg.rl() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajg.rl().setNum(bhVar.rl().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajg);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anb = false;
        this.anc = false;
        this.and = false;
        this.ane = true;
        this.anf = true;
        this.ang = false;
        this.anh = false;
        this.ani = false;
        this.anj = true;
        this.ank = true;
        this.anl = false;
        this.anm = false;
        this.ann = false;
        this.mFrom = 2;
        this.ano = 1;
        this.anz = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && ThreadCommentAndPraiseInfoLayout.this.ajg != null && ThreadCommentAndPraiseInfoLayout.this.ajg.getId() != null) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bhVar.getId()) && bhVar.rl() != null && bhVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajg.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajg.rl() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajg.rl().setNum(bhVar.rl().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajg);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.amH = (TextView) inflate.findViewById(d.h.thread_info_bar_name);
        this.amI = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.amJ = inflate.findViewById(d.h.frs_item_location_sep);
        this.amK = (TextView) inflate.findViewById(d.h.frs_item_location_address);
        this.amL = (TextView) inflate.findViewById(d.h.thread_info_praise_num);
        this.amO = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.amP = (ImageView) inflate.findViewById(d.h.thread_info_commont_img);
        this.amQ = inflate.findViewById(d.h.thread_info_commont_container);
        this.amR = (TextView) inflate.findViewById(d.h.share_num);
        this.amS = (ImageView) inflate.findViewById(d.h.share_num_img);
        this.amT = inflate.findViewById(d.h.share_num_container);
        this.amU = (TextView) inflate.findViewById(d.h.thread_info_share_num);
        this.amV = (TextView) inflate.findViewById(d.h.thread_info_audience_num);
        this.amW = (TextView) inflate.findViewById(d.h.thread_info_view_num);
        this.amX = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.amY = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        this.mContext = context;
        this.amM = (ImageView) inflate.findViewById(d.h.thread_info_praise_img);
        this.amN = inflate.findViewById(d.h.agree_view_container);
        this.amN.setOnClickListener(this);
        this.amQ.setOnClickListener(this);
        this.amT.setOnClickListener(this);
        this.anu = d.g.icon_home_card_share;
        this.ant = d.g.icon_home_card_comment;
        this.anp = 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.amH) {
            B(view);
        } else if (view == this.amQ) {
            C(view);
        } else if (view == this.amN) {
            D(view);
        } else if (view == this.amT) {
            E(view);
        } else if (view == this.amY) {
            F(view);
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.amQ != null) {
            this.amQ.setClickable(z);
            this.amP.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.amN != null) {
            this.amN.setClickable(z);
            this.amM.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.amT != null) {
            this.amT.setClickable(z);
            this.amS.setEnabled(z);
        }
    }

    private void B(View view) {
        if (this.ajg != null && !StringUtils.isNull(this.ajg.rA())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.anq)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ajg.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ajg.rA(), this.mStType, this.anq)));
            }
            if (this.anr != null) {
                this.anr.onClick(view);
            }
        }
    }

    private void C(View view) {
        if (this.ajg != null && this.mContext != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ajg, null, m.rm(), 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajg.getFid()));
            addLocateParam.setForumName(this.ajg.rA());
            addLocateParam.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
        }
    }

    private void D(View view) {
        int i = 1;
        if (ax.aU(this.mContext) && this.ajg != null) {
            if (this.ajg.sJ() != 0) {
                this.ajg.ca(this.ajg.sI() - 1);
                this.ajg.bZ(0);
                if (this.amL != null) {
                    aj.i(this.amL, d.e.cp_cont_f);
                }
            } else {
                this.ajg.bZ(1);
                this.ajg.ca(this.ajg.sI() + 1);
                if (this.amL != null) {
                    aj.i(this.amL, d.e.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.ajg);
            if (this.amM != null) {
                this.amM.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.ajg.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.anp > 0) {
                httpMessage.addParam("forum_id", this.ajg.getFid());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ad("tid", this.ajg.getTid());
            if (this.ajg.getThreadType() == 40) {
                akVar.ad("obj_param1", "2");
            } else if (this.ajg.getThreadType() == 0) {
                akVar.ad("obj_param1", "1");
            }
            akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f("fid", this.ajg.getFid());
            akVar.r("obj_locate", this.mFrom);
            akVar.r("obj_id", i);
            TiebaStatic.log(akVar);
        }
    }

    private void E(View view) {
        if (al.fS() || ax.aU(this.mContext)) {
            wF();
            wG();
        }
    }

    private void wF() {
        int i = 4;
        if (this.ajg != null) {
            if (this.ano != 1) {
                if (this.ano == 2) {
                    i = 5;
                } else if (this.ano == 3) {
                    i = 3;
                } else if (this.ano == 4) {
                    i = 2;
                } else if (this.ano != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f("fid", this.ajg.getFid()).ad("tid", this.ajg.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void wG() {
        if (this.ajg != null && this.mContext != null) {
            final String valueOf = String.valueOf(this.ajg.getFid());
            String rA = this.ajg.rA();
            String title = this.ajg.getTitle();
            final String tid = this.ajg.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajg);
            Uri parse = a == null ? null : Uri.parse(a);
            String rD = this.ajg.rD();
            String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, rD);
            final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
            dVar.title = title;
            dVar.content = format;
            dVar.atK = rD;
            dVar.linkUrl = str;
            dVar.atE = this.ano;
            dVar.extData = tid;
            dVar.atN = 3;
            dVar.fid = valueOf;
            dVar.atF = rA;
            dVar.Xf = tid;
            dVar.atB = true;
            dVar.atM = getShareObjSource();
            dVar.atO = b(this.ajg);
            if (parse != null) {
                dVar.atH = parse;
            }
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.atN);
            bundle.putInt("obj_type", dVar.atO);
            bundle.putString("fid", dVar.fid);
            bundle.putString("tid", dVar.Xf);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.atE);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            if (TbadkCoreApplication.isLogin()) {
                shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext, 23007)));
                        TiebaStatic.log(new ak("c10125").ad("tid", tid).ad("fid", valueOf).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ThreadCommentAndPraiseInfoLayout.this.getShareObjSource()));
                        ThreadCommentAndPraiseInfoLayout.this.wH();
                    }
                });
            }
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar.linkUrl = com.baidu.tbadk.coreExtra.d.e.ak(dVar.linkUrl, dVar.Xf);
                    com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                    l.showToast(ThreadCommentAndPraiseInfoLayout.this.mContext, view.getResources().getString(d.l.copy_pb_url_success));
                    ThreadCommentAndPraiseInfoLayout.this.wH();
                }
            });
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getShareObjSource() {
        if (this.ano == 1) {
            return 5;
        }
        if (this.ano != 3) {
            if (this.ano == 4) {
                return 4;
            }
            if (this.ano != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bh bhVar) {
        if (bhVar == null || bhVar.rF() == null) {
            return null;
        }
        ArrayList<MediaData> rF = bhVar.rF();
        int size = rF.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rF.get(i);
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
            if (bhVar.rx()) {
                return 4;
            }
            if (bhVar.rs() == 1) {
                return 3;
            }
            return bhVar.sB() ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.any == null) {
                this.any = new ShareReportModel(this.mG);
            }
            this.any.j(shareItem.fid, shareItem.Xf, shareItem.atE);
        }
    }

    private void F(View view) {
        wI();
    }

    public void setShowPraiseNum(boolean z) {
        this.and = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.anf = z;
        if (this.amH != null) {
            this.amH.setClickable(this.anf);
        }
    }

    public boolean isMoreViewVisible() {
        return this.amY != null && this.amY.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.anp = i;
        }
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajg = bhVar;
        c(bhVar);
        d(bhVar);
        e(bhVar);
        i(bhVar);
        updatePraiseNum(bhVar);
        f(bhVar);
        g(bhVar);
        h(bhVar);
        setVisibility(this.anb ? 0 : 8);
        return this.anb;
    }

    protected void c(bh bhVar) {
        if (this.amH != null && bhVar != null) {
            if (!StringUtils.isNull(bhVar.rA()) && this.anj) {
                this.amH.setVisibility(0);
                String e = am.e(bhVar.rA(), 14, "...");
                String string = getContext().getString(d.l.chosen_pb_original_bar, e);
                if (am.dN(e) > 14) {
                    this.amH.setText(e);
                } else {
                    this.amH.setText(string);
                }
                this.amH.setContentDescription(string);
                this.amH.setOnClickListener(this);
                this.amH.setClickable(this.anf);
                this.anb = true;
                return;
            }
            this.amH.setVisibility(8);
        }
    }

    private void d(bh bhVar) {
        String r;
        if (this.amI != null && bhVar != null) {
            if (bhVar.rp() <= 0 || !this.ane) {
                this.amI.setVisibility(8);
                return;
            }
            this.amI.setVisibility(0);
            if (this.mFrom == 3) {
                r = am.p(bhVar.rp());
            } else {
                r = am.r(bhVar.rp() * 1000);
            }
            this.amI.setText(r);
            this.anb = true;
        }
    }

    private void e(bh bhVar) {
        if (this.amK != null && this.amJ != null && bhVar != null) {
            if (this.anc && !bhVar.sa() && !StringUtils.isNull(bhVar.getAddress())) {
                this.amK.setVisibility(0);
                if (bhVar.rp() <= 0) {
                    this.amJ.setVisibility(8);
                } else {
                    this.amJ.setVisibility(0);
                }
                this.amK.setText(bhVar.getAddress());
                this.anb = true;
                return;
            }
            this.amK.setVisibility(8);
            this.amJ.setVisibility(8);
        }
    }

    protected void f(bh bhVar) {
        if (this.amO != null && bhVar != null) {
            if (this.ank) {
                this.amQ.setVisibility(0);
                if (bhVar.rn() > 0) {
                    this.amO.setVisibility(0);
                    String z = am.z(bhVar.rn());
                    if (this.anh) {
                        this.amO.setText(z);
                    } else {
                        this.amO.setText(String.format(this.mContext.getString(d.l.reply_num_tip), z));
                    }
                    this.amO.setContentDescription(this.mContext.getString(d.l.reply_num) + z);
                    this.anb = true;
                    return;
                } else if (this.anh) {
                    this.amO.setText(this.mContext.getString(d.l.action_comment_default));
                    this.amO.setVisibility(0);
                    this.anb = true;
                    return;
                } else {
                    this.amO.setVisibility(8);
                    return;
                }
            }
            this.amQ.setVisibility(8);
        }
    }

    private void g(bh bhVar) {
        if ((this.amV != null || bhVar != null) && bhVar.rN() != null) {
            if (!this.anm) {
                this.amV.setVisibility(8);
                return;
            }
            this.amV.setText(am.u(bhVar.rN().audience_count));
            this.amV.setVisibility(0);
            this.anb = true;
        }
    }

    public void updatePraiseNum(bh bhVar) {
        if (this.amN != null && this.amM != null && this.amL != null && bhVar != null) {
            if (this.and) {
                this.amN.setVisibility(0);
                int sI = bhVar.sI();
                String string = this.mContext.getString(d.l.action_praise_default);
                if (sI > 0) {
                    string = am.z(sI);
                }
                this.amL.setText(string);
                this.amL.setContentDescription(this.mContext.getString(d.l.zan_num) + sI);
                this.anb = true;
                if (bhVar.sJ() != 0) {
                    this.ans = d.g.icon_home_card_like_s;
                    this.amM.setImageDrawable(aj.getDrawable(this.ans));
                    if (this.amL != null) {
                        aj.i(this.amL, d.e.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.ans = d.g.icon_home_card_like_n;
                this.amM.setImageDrawable(aj.getDrawable(this.ans));
                if (this.amL != null) {
                    aj.i(this.amL, d.e.cp_cont_f);
                    return;
                }
                return;
            }
            this.amN.setVisibility(8);
        }
    }

    protected void h(bh bhVar) {
        if (this.amT != null && this.amR != null && bhVar != null) {
            if (this.ann) {
                this.amT.setVisibility(0);
                long sK = bhVar.sK();
                if (bhVar.sA() && bhVar.rN() != null) {
                    sK = bhVar.rN().UK.share_count;
                }
                this.amR.setText(sK > 0 ? am.z(sK) : this.mContext.getString(d.l.action_share_default));
                this.anb = true;
                return;
            }
            this.amT.setVisibility(8);
        }
    }

    private void i(bh bhVar) {
        if (this.amW != null && bhVar != null) {
            if (this.ang && bhVar.ro() > 0) {
                this.amW.setVisibility(0);
                String t = am.t(bhVar.ro());
                this.amW.setText(String.format(this.mContext.getString(d.l.view_num_tip), t));
                this.amW.setContentDescription(this.mContext.getString(d.l.view_num) + t);
                this.anb = true;
                return;
            }
            this.amW.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mG = tbPageContext;
        if (this.amY != null) {
            if (this.ajg == null || v.u(this.ajg.sx()) || !TbadkCoreApplication.isLogin() || this.ajg.sy()) {
                this.amY.setVisibility(8);
                return;
            }
            if (this.amZ == null) {
                this.amZ = new ArrayList();
            } else {
                this.amZ.clear();
            }
            if (this.ana == null) {
                this.ana = new ArrayList();
            } else {
                this.ana.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ajg.sx()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.amZ.add(reportInfo.info);
                    this.ana.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.amY.setOnClickListener(this);
                this.amY.setVisibility(0);
                return;
            }
            this.amY.setVisibility(8);
        }
    }

    private void wI() {
        if (this.mG != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mG.getPageActivity());
            bVar.cg(d.l.operation);
            bVar.a(this.amZ, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.ana, i);
                    if (!StringUtils.isNull(str)) {
                        av.vH().c(ThreadCommentAndPraiseInfoLayout.this.mG, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mG);
            bVar.tl();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.amH, d.e.cp_cont_d);
        aj.i(this.amI, d.e.cp_cont_j);
        aj.k(this.amJ, d.e.cp_cont_j);
        aj.i(this.amK, d.e.cp_cont_j);
        aj.i(this.amL, d.e.cp_cont_f);
        aj.i(this.amW, d.e.cp_cont_j);
        aj.i(this.amO, d.e.cp_cont_f);
        aj.i(this.amR, d.e.cp_cont_f);
        if (this.ajg != null && this.ajg.sJ() == 1 && this.amL != null) {
            aj.i(this.amL, d.e.cp_cont_h);
            this.ans = d.g.icon_home_card_like_s;
        }
        aj.i(this.amU, d.e.cp_cont_j);
        aj.i(this.amV, d.e.cp_cont_j);
        aj.j(this.amX, d.g.btn_frs_more_selector);
        if (this.amL != null && this.ani && this.ans > 0) {
            this.amM.setImageDrawable(aj.getDrawable(this.ans));
        }
        if (this.amO != null && this.anh && this.ant > 0) {
            this.amP.setImageDrawable(aj.getDrawable(this.ant));
        }
        if (this.amR != null) {
            this.amS.setImageDrawable(aj.getDrawable(this.anu));
        }
        if (this.amU != null && this.anl && this.anv > 0) {
            this.amU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.anv), (Drawable) null);
        }
        if (this.amV != null && this.anm && this.anw > 0) {
            this.amV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.anw), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.anr = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.amH;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anz != null) {
            this.anz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anz);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.anc = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.ang = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.ank = z;
    }

    public void setLiveShareEnable(boolean z) {
        this.anl = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.anm = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.ane = z;
    }

    public View getCommentNumView() {
        return this.amO;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.ant = i;
        }
    }

    public void setShareIcon(int i) {
        if (i > 0) {
            this.anu = i;
        }
    }

    public void setLiveShareIcon(int i) {
        if (i > 0) {
            this.anv = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.anw = i;
        }
    }

    private Animation getScaleAnimation() {
        if (this.anx == null) {
            this.anx = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.anx.setDuration(200L);
        }
        return this.anx;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.anh = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.ani = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.anj = z;
    }

    public void setShareVisible(boolean z) {
        this.ann = z;
    }
}
