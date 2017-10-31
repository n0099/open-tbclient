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
    protected TextView amQ;
    private TextView amR;
    private View amS;
    private TextView amT;
    protected TextView amU;
    protected ImageView amV;
    protected View amW;
    protected TextView amX;
    private ImageView amY;
    protected View amZ;
    private View.OnClickListener anA;
    protected int anB;
    private int anC;
    private int anD;
    private int anE;
    private int anF;
    protected ScaleAnimation anG;
    private ShareReportModel anH;
    private CustomMessageListener anI;
    protected TextView ana;
    private ImageView anb;
    protected View anc;
    private TextView and;
    private TextView ane;
    private TextView anf;
    private TextView ang;
    private FrameLayout anh;
    private List<CharSequence> ani;
    private List<String> anj;
    protected boolean ank;
    private boolean anl;
    protected boolean anm;
    private boolean ann;
    protected boolean ano;
    private boolean anp;
    protected boolean anq;
    private boolean anr;
    protected boolean ans;
    protected boolean ant;
    private boolean anu;
    private boolean anv;
    protected boolean anw;
    private int anx;
    private int any;
    private String anz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.anz = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.anx = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ank = false;
        this.anl = false;
        this.anm = false;
        this.ann = true;
        this.ano = true;
        this.anp = false;
        this.anq = false;
        this.anr = false;
        this.ans = true;
        this.ant = true;
        this.anu = false;
        this.anv = false;
        this.anw = false;
        this.mFrom = 2;
        this.anx = 1;
        this.anI = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
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
        this.ank = false;
        this.anl = false;
        this.anm = false;
        this.ann = true;
        this.ano = true;
        this.anp = false;
        this.anq = false;
        this.anr = false;
        this.ans = true;
        this.ant = true;
        this.anu = false;
        this.anv = false;
        this.anw = false;
        this.mFrom = 2;
        this.anx = 1;
        this.anI = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
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
        this.amQ = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.amR = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.amS = inflate.findViewById(d.g.frs_item_location_sep);
        this.amT = (TextView) inflate.findViewById(d.g.frs_item_location_address);
        this.amU = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.amX = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.amY = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.amZ = inflate.findViewById(d.g.thread_info_commont_container);
        this.ana = (TextView) inflate.findViewById(d.g.share_num);
        this.anb = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.anc = inflate.findViewById(d.g.share_num_container);
        this.and = (TextView) inflate.findViewById(d.g.thread_info_share_num);
        this.ane = (TextView) inflate.findViewById(d.g.thread_info_audience_num);
        this.anf = (TextView) inflate.findViewById(d.g.thread_info_view_num);
        this.ang = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.anh = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.mContext = context;
        this.amV = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.amW = inflate.findViewById(d.g.agree_view_container);
        this.amW.setOnClickListener(this);
        this.amZ.setOnClickListener(this);
        this.anc.setOnClickListener(this);
        this.anD = d.f.icon_home_card_share;
        this.anC = d.f.icon_home_card_comment;
        this.any = 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.amQ) {
            B(view);
        } else if (view == this.amZ) {
            C(view);
        } else if (view == this.amW) {
            D(view);
        } else if (view == this.anc) {
            E(view);
        } else if (view == this.anh) {
            F(view);
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.amZ != null) {
            this.amZ.setClickable(z);
            this.amY.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.amW != null) {
            this.amW.setClickable(z);
            this.amV.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.anc != null) {
            this.anc.setClickable(z);
            this.anb.setEnabled(z);
        }
    }

    private void B(View view) {
        if (this.ajq != null && !StringUtils.isNull(this.ajq.rz())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.anz)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ajq.rz(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ajq.rz(), this.mStType, this.anz)));
            }
            if (this.anA != null) {
                this.anA.onClick(view);
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
            if (this.anA != null) {
                this.anA.onClick(view);
            }
        }
    }

    protected void D(View view) {
        int i = 1;
        if (ax.aT(this.mContext) && this.ajq != null) {
            if (this.ajq.sJ() != 0) {
                this.ajq.bZ(this.ajq.sI() - 1);
                this.ajq.bY(0);
                if (this.amU != null) {
                    aj.i(this.amU, d.C0080d.cp_cont_f);
                }
            } else {
                this.ajq.bY(1);
                this.ajq.bZ(this.ajq.sI() + 1);
                if (this.amU != null) {
                    aj.i(this.amU, d.C0080d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.ajq);
            if (this.amV != null) {
                this.amV.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.ajq.getTid());
            httpMessage.addParam(PbActivityConfig.KEY_MSG_OP_TYPE, i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.any > 0) {
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
            if (this.anx != 1) {
                if (this.anx == 2) {
                    i = 5;
                } else if (this.anx == 3) {
                    i = 3;
                } else if (this.anx == 4) {
                    i = 2;
                } else if (this.anx != 6) {
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
            dVar.atU = str2;
            dVar.linkUrl = str;
            dVar.atO = this.anx;
            dVar.extData = tid;
            dVar.atX = 3;
            dVar.fid = valueOf;
            dVar.atP = rz;
            dVar.Xl = tid;
            dVar.atL = true;
            dVar.atW = getShareObjSource();
            dVar.atY = b(this.ajq);
            if (parse != null) {
                dVar.atR = parse;
            }
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.atX);
            bundle.putInt("obj_type", dVar.atY);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.Xl);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.atO);
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
        if (this.anx == 1) {
            return 5;
        }
        if (this.anx != 3) {
            if (this.anx == 4) {
                return 4;
            }
            if (this.anx != 6) {
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
            if (this.anH == null) {
                this.anH = new ShareReportModel(this.mPageContext);
            }
            this.anH.j(shareItem.fid, shareItem.Xl, shareItem.atO);
        }
    }

    private void F(View view) {
        wI();
    }

    public void setShowPraiseNum(boolean z) {
        this.anm = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ano = z;
        if (this.amQ != null) {
            this.amQ.setClickable(this.ano);
        }
    }

    public boolean isMoreViewVisible() {
        return this.anh != null && this.anh.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.any = i;
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
        setVisibility(this.ank ? 0 : 8);
        return this.ank;
    }

    protected void c(bh bhVar) {
        if (this.amQ != null && bhVar != null) {
            if (bhVar.aao > 0) {
                this.amQ.setVisibility(0);
                this.amQ.setText(d.j.select_video_list);
                this.amQ.setEnabled(false);
                this.ank = true;
            } else if (!StringUtils.isNull(bhVar.rz()) && this.ans) {
                this.amQ.setVisibility(0);
                String e = am.e(bhVar.rz(), 14, "...");
                String string = getContext().getString(d.j.chosen_pb_original_bar, e);
                if (am.dS(e) > 14) {
                    this.amQ.setText(e);
                } else {
                    this.amQ.setText(string);
                }
                this.amQ.setContentDescription(string);
                this.amQ.setOnClickListener(this);
                this.amQ.setClickable(this.ano);
                this.ank = true;
            } else {
                this.amQ.setVisibility(8);
            }
        }
    }

    private void d(bh bhVar) {
        String s;
        if (this.amR != null && bhVar != null) {
            if (bhVar.rn() <= 0 || !this.ann) {
                this.amR.setVisibility(8);
                return;
            }
            this.amR.setVisibility(0);
            if (this.mFrom == 3) {
                s = am.q(bhVar.rn());
            } else {
                s = am.s(bhVar.rn() * 1000);
            }
            this.amR.setText(s);
            this.ank = true;
        }
    }

    private void e(bh bhVar) {
        if (this.amT != null && this.amS != null && bhVar != null) {
            if (this.anl && !bhVar.rZ() && !StringUtils.isNull(bhVar.getAddress())) {
                this.amT.setVisibility(0);
                if (bhVar.rn() <= 0) {
                    this.amS.setVisibility(8);
                } else {
                    this.amS.setVisibility(0);
                }
                this.amT.setText(bhVar.getAddress());
                this.ank = true;
                return;
            }
            this.amT.setVisibility(8);
            this.amS.setVisibility(8);
        }
    }

    protected void f(bh bhVar) {
        if (this.amX != null && bhVar != null) {
            if (this.ant) {
                this.amZ.setVisibility(0);
                if (bhVar.rl() > 0) {
                    this.amX.setVisibility(0);
                    String A = am.A(bhVar.rl());
                    if (this.anq) {
                        this.amX.setText(A);
                    } else {
                        this.amX.setText(String.format(this.mContext.getString(d.j.reply_num_tip), A));
                    }
                    this.amX.setContentDescription(this.mContext.getString(d.j.reply_num) + A);
                    this.ank = true;
                    return;
                } else if (this.anq) {
                    this.amX.setText(this.mContext.getString(d.j.action_comment_default));
                    this.amX.setVisibility(0);
                    this.ank = true;
                    return;
                } else {
                    this.amX.setVisibility(8);
                    return;
                }
            }
            this.amZ.setVisibility(8);
        }
    }

    private void g(bh bhVar) {
        if ((this.ane != null || bhVar != null) && bhVar.rM() != null) {
            if (!this.anv) {
                this.ane.setVisibility(8);
                return;
            }
            this.ane.setText(am.v(bhVar.rM().audience_count));
            this.ane.setVisibility(0);
            this.ank = true;
        }
    }

    public void updatePraiseNum(bh bhVar) {
        if (this.amW != null && this.amV != null && this.amU != null && bhVar != null) {
            if (this.anm) {
                this.amW.setVisibility(0);
                int sI = bhVar.sI();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (sI > 0) {
                    string = am.A(sI);
                }
                this.amU.setText(string);
                this.amU.setContentDescription(this.mContext.getString(d.j.zan_num) + sI);
                this.ank = true;
                if (bhVar.sJ() != 0) {
                    this.anB = d.f.icon_home_card_like_s;
                    this.amV.setImageDrawable(aj.getDrawable(this.anB));
                    if (this.amU != null) {
                        aj.i(this.amU, d.C0080d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.anB = d.f.icon_home_card_like_n;
                this.amV.setImageDrawable(aj.getDrawable(this.anB));
                if (this.amU != null) {
                    aj.i(this.amU, d.C0080d.cp_cont_f);
                    return;
                }
                return;
            }
            this.amW.setVisibility(8);
        }
    }

    protected void h(bh bhVar) {
        if (this.anc != null && this.ana != null && bhVar != null) {
            if (this.anw) {
                this.anc.setVisibility(0);
                long sK = bhVar.sK();
                if ((bhVar.sA() || bhVar.sD()) && bhVar.rM() != null) {
                    sK = bhVar.rM().UR.share_count;
                }
                this.ana.setText(sK > 0 ? am.A(sK) : this.mContext.getString(d.j.share));
                this.ank = true;
                return;
            }
            this.anc.setVisibility(8);
        }
    }

    private void i(bh bhVar) {
        if (this.anf != null && bhVar != null) {
            if (this.anp && bhVar.rm() > 0) {
                this.anf.setVisibility(0);
                String u = am.u(bhVar.rm());
                this.anf.setText(String.format(this.mContext.getString(d.j.view_num_tip), u));
                this.anf.setContentDescription(this.mContext.getString(d.j.view_num) + u);
                this.ank = true;
                return;
            }
            this.anf.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.anh != null) {
            if (this.ajq == null || v.v(this.ajq.sx()) || !TbadkCoreApplication.isLogin() || this.ajq.sy()) {
                this.anh.setVisibility(8);
                return;
            }
            if (this.ani == null) {
                this.ani = new ArrayList();
            } else {
                this.ani.clear();
            }
            if (this.anj == null) {
                this.anj = new ArrayList();
            } else {
                this.anj.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ajq.sx()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.ani.add(reportInfo.info);
                    this.anj.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.anh.setOnClickListener(this);
                this.anh.setVisibility(0);
                return;
            }
            this.anh.setVisibility(8);
        }
    }

    private void wI() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cf(d.j.operation);
            bVar.a(this.ani, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.anj, i);
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
        aj.i(this.amQ, d.C0080d.cp_cont_d);
        aj.i(this.amR, d.C0080d.cp_cont_j);
        aj.k(this.amS, d.C0080d.cp_cont_j);
        aj.i(this.amT, d.C0080d.cp_cont_j);
        aj.i(this.amU, d.C0080d.cp_cont_f);
        aj.i(this.anf, d.C0080d.cp_cont_j);
        aj.i(this.amX, d.C0080d.cp_cont_f);
        aj.i(this.ana, d.C0080d.cp_cont_f);
        if (this.ajq != null && this.ajq.sJ() == 1 && this.amU != null) {
            aj.i(this.amU, d.C0080d.cp_cont_h);
            this.anB = d.f.icon_home_card_like_s;
        }
        aj.i(this.and, d.C0080d.cp_cont_j);
        aj.i(this.ane, d.C0080d.cp_cont_j);
        aj.j(this.ang, d.f.btn_frs_more_selector);
        if (this.amU != null && this.anr && this.anB > 0) {
            this.amV.setImageDrawable(aj.getDrawable(this.anB));
        }
        if (this.amX != null && this.anq && this.anC > 0) {
            this.amY.setImageDrawable(aj.getDrawable(this.anC));
        }
        if (this.ana != null) {
            this.anb.setImageDrawable(aj.getDrawable(this.anD));
        }
        if (this.and != null && this.anu && this.anE > 0) {
            this.and.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.anE), (Drawable) null);
        }
        if (this.ane != null && this.anv && this.anF > 0) {
            this.ane.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.anF), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.anA = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.amQ;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anI != null) {
            this.anI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anI);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.anl = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.anp = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.ant = z;
    }

    public void setLiveShareEnable(boolean z) {
        this.anu = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.anv = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.ann = z;
    }

    public View getCommentNumView() {
        return this.amX;
    }

    public View getCommentContainer() {
        return this.amZ;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.anC = i;
        }
    }

    public void setShareIcon(int i) {
        if (i > 0) {
            this.anD = i;
        }
    }

    public void setLiveShareIcon(int i) {
        if (i > 0) {
            this.anE = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.anF = i;
        }
    }

    protected Animation getScaleAnimation() {
        if (this.anG == null) {
            this.anG = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.anG.setDuration(200L);
        }
        return this.anG;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.anq = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.anr = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.ans = z;
    }

    public void setShareVisible(boolean z) {
        this.anw = z;
    }
}
