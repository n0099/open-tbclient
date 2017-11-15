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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tbadk.p.al;
import com.baidu.tieba.d;
import com.baidu.tieba.model.ShareReportModel;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout implements View.OnClickListener {
    protected bh ajq;
    protected TextView amP;
    private TextView amQ;
    private View amR;
    private TextView amS;
    protected TextView amT;
    protected ImageView amU;
    protected View amV;
    protected TextView amW;
    private ImageView amX;
    protected View amY;
    protected TextView amZ;
    protected int anA;
    private int anB;
    private int anC;
    private int anD;
    private int anE;
    protected ScaleAnimation anF;
    private ShareReportModel anG;
    private CustomMessageListener anH;
    private ImageView ana;
    protected View anb;
    private TextView anc;
    private TextView and;
    private TextView ane;
    private TextView anf;
    private FrameLayout ang;
    private List<CharSequence> anh;
    private List<String> ani;
    protected boolean anj;
    private boolean ank;
    protected boolean anl;
    private boolean anm;
    protected boolean ann;
    private boolean ano;
    protected boolean anp;
    private boolean anq;
    protected boolean anr;
    protected boolean ans;
    private boolean ant;
    private boolean anu;
    protected boolean anv;
    private int anw;
    private int anx;
    private String any;
    private View.OnClickListener anz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.any = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.anw = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.anj = false;
        this.ank = false;
        this.anl = false;
        this.anm = true;
        this.ann = true;
        this.ano = false;
        this.anp = false;
        this.anq = false;
        this.anr = true;
        this.ans = true;
        this.ant = false;
        this.anu = false;
        this.anv = false;
        this.mFrom = 2;
        this.anw = 1;
        this.anH = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && ThreadCommentAndPraiseInfoLayout.this.ajq != null && ThreadCommentAndPraiseInfoLayout.this.ajq.getId() != null) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bhVar.getId()) && bhVar.ri() != null && bhVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajq.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajq.ri() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajq.ri().setNum(bhVar.ri().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajq);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anj = false;
        this.ank = false;
        this.anl = false;
        this.anm = true;
        this.ann = true;
        this.ano = false;
        this.anp = false;
        this.anq = false;
        this.anr = true;
        this.ans = true;
        this.ant = false;
        this.anu = false;
        this.anv = false;
        this.mFrom = 2;
        this.anw = 1;
        this.anH = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh) && ThreadCommentAndPraiseInfoLayout.this.ajq != null && ThreadCommentAndPraiseInfoLayout.this.ajq.getId() != null) {
                    bh bhVar = (bh) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bhVar.getId()) && bhVar.ri() != null && bhVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajq.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajq.ri() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajq.ri().setNum(bhVar.ri().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajq);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.amP = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.amQ = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.amR = inflate.findViewById(d.g.frs_item_location_sep);
        this.amS = (TextView) inflate.findViewById(d.g.frs_item_location_address);
        this.amT = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.amW = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.amX = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.amY = inflate.findViewById(d.g.thread_info_commont_container);
        this.amZ = (TextView) inflate.findViewById(d.g.share_num);
        this.ana = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.anb = inflate.findViewById(d.g.share_num_container);
        this.anc = (TextView) inflate.findViewById(d.g.thread_info_share_num);
        this.and = (TextView) inflate.findViewById(d.g.thread_info_audience_num);
        this.ane = (TextView) inflate.findViewById(d.g.thread_info_view_num);
        this.anf = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.ang = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.mContext = context;
        this.amU = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.amV = inflate.findViewById(d.g.agree_view_container);
        this.amV.setOnClickListener(this);
        this.amY.setOnClickListener(this);
        this.anb.setOnClickListener(this);
        this.anC = d.f.icon_home_card_share;
        this.anB = d.f.icon_home_card_comment;
        this.anx = 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.amP) {
            B(view);
        } else if (view == this.amY) {
            C(view);
        } else if (view == this.amV) {
            D(view);
        } else if (view == this.anb) {
            E(view);
        } else if (view == this.ang) {
            F(view);
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.amY != null) {
            this.amY.setClickable(z);
            this.amX.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.amV != null) {
            this.amV.setClickable(z);
            this.amU.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.anb != null) {
            this.anb.setClickable(z);
            this.ana.setEnabled(z);
        }
    }

    private void B(View view) {
        if (this.ajq != null && !StringUtils.isNull(this.ajq.rz())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.any)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ajq.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ajq.rz(), this.mStType, this.any)));
            }
            if (this.anz != null) {
                this.anz.onClick(view);
            }
        }
    }

    private void C(View view) {
        if (this.ajq != null && this.mContext != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ajq, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajq.getFid()));
            addLocateParam.setForumName(this.ajq.rz());
            addLocateParam.setJumpToCommentArea(true);
            if (this.ajq.sl() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra(PbActivityConfig.KEY_IS_INTERVIEW_LIVE, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
            if (this.anz != null) {
                this.anz.onClick(view);
            }
        }
    }

    protected void D(View view) {
        int i = 1;
        if (ax.aT(this.mContext) && this.ajq != null) {
            if (this.ajq.sJ() != 0) {
                this.ajq.bZ(this.ajq.sI() - 1);
                this.ajq.bY(0);
                if (this.amT != null) {
                    aj.i(this.amT, d.C0080d.cp_cont_f);
                }
            } else {
                this.ajq.bY(1);
                this.ajq.bZ(this.ajq.sI() + 1);
                if (this.amT != null) {
                    aj.i(this.amT, d.C0080d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.ajq);
            if (this.amU != null) {
                this.amU.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.ajq.getTid());
            httpMessage.addParam(PbActivityConfig.KEY_MSG_OP_TYPE, i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.anx > 0) {
                httpMessage.addParam("forum_id", this.ajq.getFid());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ac("tid", this.ajq.getTid());
            if (this.ajq.getThreadType() == 40) {
                akVar.ac("obj_param1", "2");
            } else if (this.ajq.getThreadType() == 0) {
                akVar.ac("obj_param1", "1");
            }
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f(ImageViewerConfig.FORUM_ID, this.ajq.getFid());
            akVar.r("obj_locate", this.mFrom);
            akVar.r("obj_id", i);
            TiebaStatic.log(akVar);
        }
    }

    protected void E(View view) {
        if (al.fS() || ax.aT(this.mContext)) {
            wF();
            wG();
        }
    }

    private void wF() {
        int i = 4;
        if (this.ajq != null) {
            if (this.anw != 1) {
                if (this.anw == 2) {
                    i = 5;
                } else if (this.anw == 3) {
                    i = 3;
                } else if (this.anw == 4) {
                    i = 2;
                } else if (this.anw != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f(ImageViewerConfig.FORUM_ID, this.ajq.getFid()).ac("tid", this.ajq.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void wG() {
        if (this.ajq != null && this.mContext != null) {
            final String valueOf = String.valueOf(this.ajq.getFid());
            String rz = this.ajq.rz();
            String title = this.ajq.getTitle();
            final String tid = this.ajq.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajq);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.ajq.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
            dVar.title = title;
            dVar.content = format;
            dVar.auc = str2;
            dVar.linkUrl = str;
            dVar.atW = this.anw;
            dVar.extData = tid;
            dVar.auf = 3;
            dVar.fid = valueOf;
            dVar.atX = rz;
            dVar.Xl = tid;
            dVar.atT = true;
            dVar.aue = getShareObjSource();
            dVar.aug = b(this.ajq);
            if (parse != null) {
                dVar.atZ = parse;
            }
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.auf);
            bundle.putInt("obj_type", dVar.aug);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.Xl);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.atW);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            if (TbadkCoreApplication.isLogin()) {
                shareDialogConfig.addOutsideTextView(d.j.forum_friend, d.f.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext, 23007)));
                        TiebaStatic.log(new ak("c10125").ac("tid", tid).ac(ImageViewerConfig.FORUM_ID, valueOf).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ThreadCommentAndPraiseInfoLayout.this.getShareObjSource()));
                        ThreadCommentAndPraiseInfoLayout.this.wH();
                    }
                });
            }
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar.linkUrl = com.baidu.tbadk.coreExtra.d.e.ai(dVar.linkUrl, dVar.Xl);
                    com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                    l.showToast(ThreadCommentAndPraiseInfoLayout.this.mContext, view.getResources().getString(d.j.copy_pb_url_success));
                    ThreadCommentAndPraiseInfoLayout.this.wH();
                }
            });
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getShareObjSource() {
        if (this.anw == 1) {
            return 5;
        }
        if (this.anw != 3) {
            if (this.anw == 4) {
                return 4;
            }
            if (this.anw != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bh bhVar) {
        if (bhVar == null || bhVar.rE() == null) {
            return null;
        }
        ArrayList<MediaData> rE = bhVar.rE();
        int size = rE.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rE.get(i);
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
            if (bhVar.rw()) {
                return 4;
            }
            if (bhVar.rq() == 1) {
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
            if (this.anG == null) {
                this.anG = new ShareReportModel(this.mPageContext);
            }
            this.anG.j(shareItem.fid, shareItem.Xl, shareItem.atW);
        }
    }

    private void F(View view) {
        wI();
    }

    public void setShowPraiseNum(boolean z) {
        this.anl = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ann = z;
        if (this.amP != null) {
            this.amP.setClickable(this.ann);
        }
    }

    public boolean isMoreViewVisible() {
        return this.ang != null && this.ang.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.anx = i;
        }
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajq = bhVar;
        c(bhVar);
        d(bhVar);
        e(bhVar);
        i(bhVar);
        updatePraiseNum(bhVar);
        f(bhVar);
        g(bhVar);
        h(bhVar);
        setVisibility(this.anj ? 0 : 8);
        return this.anj;
    }

    protected void c(bh bhVar) {
        if (this.amP != null && bhVar != null) {
            if (bhVar.aao > 0) {
                this.amP.setVisibility(0);
                this.amP.setText(d.j.select_video_list);
                this.amP.setEnabled(false);
                this.anj = true;
            } else if (!StringUtils.isNull(bhVar.rz()) && this.anr) {
                this.amP.setVisibility(0);
                String e = am.e(bhVar.rz(), 14, "...");
                String string = getContext().getString(d.j.chosen_pb_original_bar, e);
                if (am.dS(e) > 14) {
                    this.amP.setText(e);
                } else {
                    this.amP.setText(string);
                }
                this.amP.setContentDescription(string);
                this.amP.setOnClickListener(this);
                this.amP.setClickable(this.ann);
                this.anj = true;
            } else {
                this.amP.setVisibility(8);
            }
        }
    }

    private void d(bh bhVar) {
        String s;
        if (this.amQ != null && bhVar != null) {
            if (bhVar.rn() <= 0 || !this.anm) {
                this.amQ.setVisibility(8);
                return;
            }
            this.amQ.setVisibility(0);
            if (this.mFrom == 3) {
                s = am.q(bhVar.rn());
            } else {
                s = am.s(bhVar.rn() * 1000);
            }
            this.amQ.setText(s);
            this.anj = true;
        }
    }

    private void e(bh bhVar) {
        if (this.amS != null && this.amR != null && bhVar != null) {
            if (this.ank && !bhVar.rZ() && !StringUtils.isNull(bhVar.getAddress())) {
                this.amS.setVisibility(0);
                if (bhVar.rn() <= 0) {
                    this.amR.setVisibility(8);
                } else {
                    this.amR.setVisibility(0);
                }
                this.amS.setText(bhVar.getAddress());
                this.anj = true;
                return;
            }
            this.amS.setVisibility(8);
            this.amR.setVisibility(8);
        }
    }

    protected void f(bh bhVar) {
        if (this.amW != null && bhVar != null) {
            if (this.ans) {
                this.amY.setVisibility(0);
                if (bhVar.rl() > 0) {
                    this.amW.setVisibility(0);
                    String A = am.A(bhVar.rl());
                    if (this.anp) {
                        this.amW.setText(A);
                    } else {
                        this.amW.setText(String.format(this.mContext.getString(d.j.reply_num_tip), A));
                    }
                    this.amW.setContentDescription(this.mContext.getString(d.j.reply_num) + A);
                    this.anj = true;
                    return;
                } else if (this.anp) {
                    this.amW.setText(this.mContext.getString(d.j.action_comment_default));
                    this.amW.setVisibility(0);
                    this.anj = true;
                    return;
                } else {
                    this.amW.setVisibility(8);
                    return;
                }
            }
            this.amY.setVisibility(8);
        }
    }

    private void g(bh bhVar) {
        if ((this.and != null || bhVar != null) && bhVar.rM() != null) {
            if (!this.anu) {
                this.and.setVisibility(8);
                return;
            }
            this.and.setText(am.v(bhVar.rM().audience_count));
            this.and.setVisibility(0);
            this.anj = true;
        }
    }

    public void updatePraiseNum(bh bhVar) {
        if (this.amV != null && this.amU != null && this.amT != null && bhVar != null) {
            if (this.anl) {
                this.amV.setVisibility(0);
                int sI = bhVar.sI();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (sI > 0) {
                    string = am.A(sI);
                }
                this.amT.setText(string);
                this.amT.setContentDescription(this.mContext.getString(d.j.zan_num) + sI);
                this.anj = true;
                if (bhVar.sJ() != 0) {
                    this.anA = d.f.icon_home_card_like_s;
                    this.amU.setImageDrawable(aj.getDrawable(this.anA));
                    if (this.amT != null) {
                        aj.i(this.amT, d.C0080d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.anA = d.f.icon_home_card_like_n;
                this.amU.setImageDrawable(aj.getDrawable(this.anA));
                if (this.amT != null) {
                    aj.i(this.amT, d.C0080d.cp_cont_f);
                    return;
                }
                return;
            }
            this.amV.setVisibility(8);
        }
    }

    protected void h(bh bhVar) {
        if (this.anb != null && this.amZ != null && bhVar != null) {
            if (this.anv) {
                this.anb.setVisibility(0);
                long sK = bhVar.sK();
                if ((bhVar.sA() || bhVar.sD()) && bhVar.rM() != null) {
                    sK = bhVar.rM().UR.share_count;
                }
                this.amZ.setText(sK > 0 ? am.A(sK) : this.mContext.getString(d.j.share));
                this.anj = true;
                return;
            }
            this.anb.setVisibility(8);
        }
    }

    private void i(bh bhVar) {
        if (this.ane != null && bhVar != null) {
            if (this.ano && bhVar.rm() > 0) {
                this.ane.setVisibility(0);
                String u = am.u(bhVar.rm());
                this.ane.setText(String.format(this.mContext.getString(d.j.view_num_tip), u));
                this.ane.setContentDescription(this.mContext.getString(d.j.view_num) + u);
                this.anj = true;
                return;
            }
            this.ane.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.ang != null) {
            if (this.ajq == null || v.v(this.ajq.sx()) || !TbadkCoreApplication.isLogin() || this.ajq.sy()) {
                this.ang.setVisibility(8);
                return;
            }
            if (this.anh == null) {
                this.anh = new ArrayList();
            } else {
                this.anh.clear();
            }
            if (this.ani == null) {
                this.ani = new ArrayList();
            } else {
                this.ani.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ajq.sx()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.anh.add(reportInfo.info);
                    this.ani.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.ang.setOnClickListener(this);
                this.ang.setVisibility(0);
                return;
            }
            this.ang.setVisibility(8);
        }
    }

    private void wI() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cf(d.j.operation);
            bVar.a(this.anh, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.ani, i);
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
        aj.i(this.amP, d.C0080d.cp_cont_d);
        aj.i(this.amQ, d.C0080d.cp_cont_j);
        aj.k(this.amR, d.C0080d.cp_cont_j);
        aj.i(this.amS, d.C0080d.cp_cont_j);
        aj.i(this.amT, d.C0080d.cp_cont_f);
        aj.i(this.ane, d.C0080d.cp_cont_j);
        aj.i(this.amW, d.C0080d.cp_cont_f);
        aj.i(this.amZ, d.C0080d.cp_cont_f);
        if (this.ajq != null && this.ajq.sJ() == 1 && this.amT != null) {
            aj.i(this.amT, d.C0080d.cp_cont_h);
            this.anA = d.f.icon_home_card_like_s;
        }
        aj.i(this.anc, d.C0080d.cp_cont_j);
        aj.i(this.and, d.C0080d.cp_cont_j);
        aj.j(this.anf, d.f.btn_frs_more_selector);
        if (this.amT != null && this.anq && this.anA > 0) {
            this.amU.setImageDrawable(aj.getDrawable(this.anA));
        }
        if (this.amW != null && this.anp && this.anB > 0) {
            this.amX.setImageDrawable(aj.getDrawable(this.anB));
        }
        if (this.amZ != null) {
            this.ana.setImageDrawable(aj.getDrawable(this.anC));
        }
        if (this.anc != null && this.ant && this.anD > 0) {
            this.anc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.anD), (Drawable) null);
        }
        if (this.and != null && this.anu && this.anE > 0) {
            this.and.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.anE), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.anz = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.amP;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anH != null) {
            this.anH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anH);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.ank = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.ano = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.ans = z;
    }

    public void setLiveShareEnable(boolean z) {
        this.ant = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.anu = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.anm = z;
    }

    public View getCommentNumView() {
        return this.amW;
    }

    public View getCommentContainer() {
        return this.amY;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.anB = i;
        }
    }

    public void setShareIcon(int i) {
        if (i > 0) {
            this.anC = i;
        }
    }

    public void setLiveShareIcon(int i) {
        if (i > 0) {
            this.anD = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.anE = i;
        }
    }

    protected Animation getScaleAnimation() {
        if (this.anF == null) {
            this.anF = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.anF.setDuration(200L);
        }
        return this.anF;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.anp = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.anq = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.anr = z;
    }

    public void setShareVisible(boolean z) {
        this.anv = z;
    }
}
