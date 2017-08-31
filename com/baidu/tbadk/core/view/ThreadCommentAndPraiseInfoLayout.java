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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.model.ShareReportModel;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout implements View.OnClickListener {
    private bj ajF;
    private TextView anA;
    private View anB;
    private TextView anC;
    private TextView anD;
    private ImageView anE;
    private View anF;
    private TextView anG;
    private TextView anH;
    private TextView anI;
    private TextView anJ;
    private TextView anK;
    private TextView anL;
    private FrameLayout anM;
    private List<CharSequence> anN;
    private List<String> anO;
    private boolean anP;
    private boolean anQ;
    private boolean anR;
    private boolean anS;
    private boolean anT;
    private boolean anU;
    private boolean anV;
    private boolean anW;
    private boolean anX;
    private boolean anY;
    private boolean anZ;
    private TextView anz;
    private boolean aoa;
    private boolean aob;
    private int aoc;
    private String aod;
    private View.OnClickListener aoe;
    private int aof;
    private int aog;
    private int aoh;
    private int aoi;
    private ScaleAnimation aoj;
    private ShareReportModel aok;
    private View.OnClickListener aol;
    private CustomMessageListener aom;
    private Context mContext;
    private TbPageContext mF;
    private int mFrom;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.aod = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.aoc = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.anP = false;
        this.anQ = false;
        this.anR = false;
        this.anS = true;
        this.anT = true;
        this.anU = false;
        this.anV = false;
        this.anW = false;
        this.anX = true;
        this.anY = true;
        this.anZ = false;
        this.aoa = false;
        this.aob = false;
        this.mFrom = 2;
        this.aoc = 1;
        this.aol = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (ax.aT(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.ajF != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.ajF.sP() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.ajF.bZ(ThreadCommentAndPraiseInfoLayout.this.ajF.sO() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.ajF.bY(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.anD != null) {
                            aj.i(ThreadCommentAndPraiseInfoLayout.this.anD, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.ajF.bY(1);
                        ThreadCommentAndPraiseInfoLayout.this.ajF.bZ(ThreadCommentAndPraiseInfoLayout.this.ajF.sO() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.anD != null) {
                            aj.i(ThreadCommentAndPraiseInfoLayout.this.anD, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.j(ThreadCommentAndPraiseInfoLayout.this.ajF);
                    if (ThreadCommentAndPraiseInfoLayout.this.anE != null) {
                        ThreadCommentAndPraiseInfoLayout.this.anE.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.ajF.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.ajF.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ak akVar = new ak("c12003");
                    akVar.ad("tid", ThreadCommentAndPraiseInfoLayout.this.ajF.getTid());
                    if (ThreadCommentAndPraiseInfoLayout.this.ajF.getThreadType() != 40) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajF.getThreadType() == 0) {
                            akVar.ad("obj_param1", "1");
                        }
                    } else {
                        akVar.ad("obj_param1", "2");
                    }
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    akVar.f("fid", ThreadCommentAndPraiseInfoLayout.this.ajF.getFid());
                    akVar.r("obj_locate", ThreadCommentAndPraiseInfoLayout.this.mFrom);
                    akVar.r("obj_id", i);
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.aom = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && ThreadCommentAndPraiseInfoLayout.this.ajF != null && ThreadCommentAndPraiseInfoLayout.this.ajF.getId() != null) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bjVar.getId()) && bjVar.rr() != null && bjVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajF.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajF.rr() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajF.rr().setNum(bjVar.rr().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.j(ThreadCommentAndPraiseInfoLayout.this.ajF);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anP = false;
        this.anQ = false;
        this.anR = false;
        this.anS = true;
        this.anT = true;
        this.anU = false;
        this.anV = false;
        this.anW = false;
        this.anX = true;
        this.anY = true;
        this.anZ = false;
        this.aoa = false;
        this.aob = false;
        this.mFrom = 2;
        this.aoc = 1;
        this.aol = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (ax.aT(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.ajF != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.ajF.sP() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.ajF.bZ(ThreadCommentAndPraiseInfoLayout.this.ajF.sO() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.ajF.bY(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.anD != null) {
                            aj.i(ThreadCommentAndPraiseInfoLayout.this.anD, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.ajF.bY(1);
                        ThreadCommentAndPraiseInfoLayout.this.ajF.bZ(ThreadCommentAndPraiseInfoLayout.this.ajF.sO() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.anD != null) {
                            aj.i(ThreadCommentAndPraiseInfoLayout.this.anD, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.j(ThreadCommentAndPraiseInfoLayout.this.ajF);
                    if (ThreadCommentAndPraiseInfoLayout.this.anE != null) {
                        ThreadCommentAndPraiseInfoLayout.this.anE.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.ajF.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.ajF.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ak akVar = new ak("c12003");
                    akVar.ad("tid", ThreadCommentAndPraiseInfoLayout.this.ajF.getTid());
                    if (ThreadCommentAndPraiseInfoLayout.this.ajF.getThreadType() != 40) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajF.getThreadType() == 0) {
                            akVar.ad("obj_param1", "1");
                        }
                    } else {
                        akVar.ad("obj_param1", "2");
                    }
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    akVar.f("fid", ThreadCommentAndPraiseInfoLayout.this.ajF.getFid());
                    akVar.r("obj_locate", ThreadCommentAndPraiseInfoLayout.this.mFrom);
                    akVar.r("obj_id", i);
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.aom = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && ThreadCommentAndPraiseInfoLayout.this.ajF != null && ThreadCommentAndPraiseInfoLayout.this.ajF.getId() != null) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bjVar.getId()) && bjVar.rr() != null && bjVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajF.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajF.rr() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajF.rr().setNum(bjVar.rr().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.j(ThreadCommentAndPraiseInfoLayout.this.ajF);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.anz = (TextView) inflate.findViewById(d.h.thread_info_bar_name);
        this.anA = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.anB = inflate.findViewById(d.h.frs_item_location_sep);
        this.anC = (TextView) inflate.findViewById(d.h.frs_item_location_address);
        this.anD = (TextView) inflate.findViewById(d.h.thread_info_praise_num);
        this.anG = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.anH = (TextView) inflate.findViewById(d.h.share_num);
        this.anI = (TextView) inflate.findViewById(d.h.thread_info_share_num);
        this.anJ = (TextView) inflate.findViewById(d.h.thread_info_audience_num);
        this.anK = (TextView) inflate.findViewById(d.h.thread_info_view_num);
        this.anL = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.anM = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        this.mContext = context;
        this.anE = (ImageView) inflate.findViewById(d.h.thread_info_praise_img);
        this.anF = inflate.findViewById(d.h.agree_view_container);
        this.anF.setOnClickListener(this);
        this.anG.setOnClickListener(this);
        this.anH.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.anz) {
            B(view);
        } else if (view == this.anG) {
            C(view);
        } else if (view == this.anF) {
            D(view);
        } else if (view == this.anH) {
            E(view);
        } else if (view == this.anM) {
            F(view);
        }
    }

    private void B(View view) {
        if (this.ajF != null && !StringUtils.isNull(this.ajF.rG())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aod)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ajF.rG(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ajF.rG(), this.mStType, this.aod)));
            }
            if (this.aoe != null) {
                this.aoe.onClick(view);
            }
        }
    }

    private void C(View view) {
        if (this.ajF != null && this.mContext != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ajF, null, com.baidu.tieba.card.m.rs(), 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajF.getFid()));
            addLocateParam.setForumName(this.ajF.rG());
            addLocateParam.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
        }
    }

    private void D(View view) {
        int i = 1;
        if (ax.aT(this.mContext) && this.ajF != null) {
            if (this.ajF.sP() != 0) {
                this.ajF.bZ(this.ajF.sO() - 1);
                this.ajF.bY(0);
                if (this.anD != null) {
                    aj.i(this.anD, d.e.cp_cont_j);
                }
            } else {
                this.ajF.bY(1);
                this.ajF.bZ(this.ajF.sO() + 1);
                if (this.anD != null) {
                    aj.i(this.anD, d.e.cp_cont_h);
                }
                i = 0;
            }
            j(this.ajF);
            if (this.anE != null) {
                this.anE.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.ajF.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", this.ajF.getFid());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void E(View view) {
        xg();
        if (ax.aT(this.mContext)) {
            xh();
        }
    }

    private void xg() {
        int i = 4;
        if (this.ajF != null) {
            if (this.aoc != 1) {
                if (this.aoc == 2) {
                    i = 5;
                } else if (this.aoc == 3) {
                    i = 3;
                } else {
                    i = this.aoc == 4 ? 2 : 0;
                }
            }
            TiebaStatic.log(new ak("c12386").f("fid", this.ajF.getFid()).ad("tid", this.ajF.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void xh() {
        if (this.ajF != null && this.mContext != null) {
            final String valueOf = String.valueOf(this.ajF.getFid());
            String rG = this.ajF.rG();
            String title = this.ajF.getTitle();
            final String tid = this.ajF.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajF);
            Uri parse = a == null ? null : Uri.parse(a);
            String rJ = this.ajF.rJ();
            String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, rJ);
            final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
            dVar.title = title;
            dVar.content = format;
            dVar.auF = rJ;
            dVar.linkUrl = str;
            dVar.auz = this.aoc;
            dVar.extData = tid;
            dVar.auI = 3;
            dVar.fid = valueOf;
            dVar.auA = rG;
            dVar.Xe = tid;
            dVar.auw = true;
            dVar.auH = getShareObjSource();
            dVar.auJ = b(this.ajF);
            if (parse != null) {
                dVar.auC = parse;
            }
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.auI);
            bundle.putInt("obj_type", dVar.auJ);
            bundle.putString("fid", dVar.fid);
            bundle.putString("tid", dVar.Xe);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.auz);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext, 23007)));
                    TiebaStatic.log(new ak("c10125").ad("tid", tid).ad("fid", valueOf).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                    ThreadCommentAndPraiseInfoLayout.this.xi();
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                    com.baidu.adp.lib.util.k.showToast(ThreadCommentAndPraiseInfoLayout.this.mContext, view.getResources().getString(d.l.copy_pb_url_success));
                    ThreadCommentAndPraiseInfoLayout.this.xi();
                }
            });
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private int getShareObjSource() {
        if (this.aoc == 1) {
            return 5;
        }
        if (this.aoc != 3) {
            return this.aoc == 4 ? 4 : 0;
        }
        return 3;
    }

    private String a(bj bjVar) {
        if (bjVar == null || bjVar.rL() == null) {
            return null;
        }
        ArrayList<MediaData> rL = bjVar.rL();
        int size = rL.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rL.get(i);
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

    private int b(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.rD()) {
                return 4;
            }
            if (bjVar.ry() == 1) {
                return 3;
            }
            return bjVar.sH() ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.aok == null) {
                this.aok = new ShareReportModel(this.mF);
            }
            this.aok.l(shareItem.fid, shareItem.Xe, shareItem.auz);
        }
    }

    private void F(View view) {
        xk();
    }

    public void setShowPraiseNum(boolean z) {
        this.anR = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.anT = z;
        if (this.anz != null) {
            this.anz.setClickable(this.anT);
        }
    }

    public boolean xj() {
        return this.anM != null && this.anM.getVisibility() == 0;
    }

    public boolean c(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajF = bjVar;
        d(bjVar);
        e(bjVar);
        f(bjVar);
        l(bjVar);
        j(bjVar);
        g(bjVar);
        h(bjVar);
        i(bjVar);
        k(bjVar);
        setVisibility(this.anP ? 0 : 8);
        return this.anP;
    }

    private void d(bj bjVar) {
        if (this.anz != null && bjVar != null) {
            if (!StringUtils.isNull(bjVar.rG()) && this.anX) {
                this.anz.setVisibility(0);
                String e = am.e(bjVar.rG(), 14, "...");
                String string = getContext().getString(d.l.chosen_pb_original_bar, e);
                if (am.dU(e) > 14) {
                    this.anz.setText(e);
                } else {
                    this.anz.setText(string);
                }
                this.anz.setContentDescription(string);
                this.anz.setOnClickListener(this);
                this.anz.setClickable(this.anT);
                this.anP = true;
                return;
            }
            this.anz.setVisibility(8);
        }
    }

    private void e(bj bjVar) {
        String s;
        if (this.anA != null && bjVar != null) {
            if (bjVar.rv() <= 0 || !this.anS) {
                this.anA.setVisibility(8);
                return;
            }
            this.anA.setVisibility(0);
            if (this.mFrom == 3) {
                s = am.p(bjVar.rv());
            } else {
                s = am.s(bjVar.rv() * 1000);
            }
            this.anA.setText(s);
            this.anP = true;
        }
    }

    private void f(bj bjVar) {
        if (this.anC != null && this.anB != null && bjVar != null) {
            if (this.anQ && !bjVar.sg() && !StringUtils.isNull(bjVar.getAddress())) {
                this.anC.setVisibility(0);
                if (bjVar.rv() <= 0) {
                    this.anB.setVisibility(8);
                } else {
                    this.anB.setVisibility(0);
                }
                this.anC.setText(bjVar.getAddress());
                this.anP = true;
                return;
            }
            this.anC.setVisibility(8);
            this.anB.setVisibility(8);
        }
    }

    private void g(bj bjVar) {
        if (this.anG != null && bjVar != null) {
            if (this.anY) {
                if (bjVar.rt() > 0) {
                    this.anG.setVisibility(0);
                    String v = am.v(bjVar.rt());
                    if (this.anV) {
                        this.anG.setText(v);
                    } else {
                        this.anG.setText(String.format(this.mContext.getString(d.l.reply_num_tip), v));
                    }
                    this.anG.setContentDescription(this.mContext.getString(d.l.reply_num) + v);
                    this.anP = true;
                    return;
                } else if (this.anV) {
                    this.anG.setText("0");
                    this.anG.setVisibility(0);
                    this.anP = true;
                    return;
                } else {
                    this.anG.setVisibility(8);
                    return;
                }
            }
            this.anG.setVisibility(8);
        }
    }

    private void h(bj bjVar) {
        if ((this.anI != null || bjVar != null) && bjVar.rT() != null) {
            if (!this.anZ) {
                this.anI.setVisibility(8);
                return;
            }
            this.anI.setText(am.v(bjVar.rT().Uv.share_count));
            this.anI.setVisibility(0);
            this.anP = true;
        }
    }

    private void i(bj bjVar) {
        if ((this.anJ != null || bjVar != null) && bjVar.rT() != null) {
            if (!this.aoa) {
                this.anJ.setVisibility(8);
                return;
            }
            this.anJ.setText(am.v(bjVar.rT().audience_count));
            this.anJ.setVisibility(0);
            this.anP = true;
        }
    }

    public void j(bj bjVar) {
        if (this.anD != null && bjVar != null) {
            if (this.anR) {
                this.anF.setVisibility(0);
                this.anD.setVisibility(0);
                String v = am.v(bjVar.sO());
                this.anD.setText(v);
                this.anD.setContentDescription(this.mContext.getString(d.l.zan_num) + v);
                this.anP = true;
                if (bjVar.sP() != 0) {
                    this.aof = d.g.icon_home_card_liked_n;
                    this.anE.setImageDrawable(aj.getDrawable(this.aof));
                    if (this.anD != null) {
                        aj.i(this.anD, d.e.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.aof = d.g.icon_home_card_like_n;
                this.anE.setImageDrawable(aj.getDrawable(this.aof));
                if (this.anD != null) {
                    aj.i(this.anD, d.e.cp_cont_j);
                    return;
                }
                return;
            }
            this.anF.setVisibility(8);
            this.anD.setVisibility(8);
        }
    }

    private void k(bj bjVar) {
        if (this.anH != null && bjVar != null) {
            if (this.aob) {
                this.anH.setVisibility(0);
                this.anH.setText(am.v(bjVar.sQ()));
                return;
            }
            this.anH.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.anK != null && bjVar != null) {
            if (this.anU && bjVar.ru() > 0) {
                this.anK.setVisibility(0);
                String u = am.u(bjVar.ru());
                this.anK.setText(String.format(this.mContext.getString(d.l.view_num_tip), u));
                this.anK.setContentDescription(this.mContext.getString(d.l.view_num) + u);
                this.anP = true;
                return;
            }
            this.anK.setVisibility(8);
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mF = tbPageContext;
        if (this.anM != null) {
            if (this.ajF == null || v.v(this.ajF.sD()) || !TbadkCoreApplication.isLogin() || this.ajF.sE()) {
                this.anM.setVisibility(8);
                return;
            }
            if (this.anN == null) {
                this.anN = new ArrayList();
            } else {
                this.anN.clear();
            }
            if (this.anO == null) {
                this.anO = new ArrayList();
            } else {
                this.anO.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ajF.sD()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.anN.add(reportInfo.info);
                    this.anO.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.anM.setOnClickListener(this);
                this.anM.setVisibility(0);
                return;
            }
            this.anM.setVisibility(8);
        }
    }

    private void xk() {
        if (this.mF != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mF.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.anN, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.anO, i);
                    if (!StringUtils.isNull(str)) {
                        au.wd().c(ThreadCommentAndPraiseInfoLayout.this.mF, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mF);
            bVar.tr();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.anz, d.e.cp_cont_j);
        aj.i(this.anA, d.e.cp_cont_j);
        aj.k(this.anB, d.e.cp_cont_j);
        aj.i(this.anC, d.e.cp_cont_j);
        aj.i(this.anD, d.e.cp_cont_j);
        aj.i(this.anK, d.e.cp_cont_j);
        aj.i(this.anG, d.e.cp_cont_j);
        aj.i(this.anH, d.e.cp_cont_j);
        if (this.ajF != null && this.ajF.sP() == 1 && this.anD != null) {
            aj.i(this.anD, d.e.cp_cont_h);
            this.aof = d.g.icon_home_card_liked_n;
        }
        aj.i(this.anI, d.e.cp_cont_j);
        aj.i(this.anJ, d.e.cp_cont_j);
        aj.j(this.anL, d.g.btn_frs_more_selector);
        if (this.anD != null && this.anW && this.aof > 0) {
            this.anE.setImageDrawable(aj.getDrawable(this.aof));
        }
        if (this.anG != null && this.anV && this.aog > 0) {
            this.anG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.aog), (Drawable) null);
        }
        if (this.anH != null) {
            this.anH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_home_card_share_n), (Drawable) null);
        }
        if (this.anI != null && this.anZ && this.aoh > 0) {
            this.anI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.aoh), (Drawable) null);
        }
        if (this.anJ != null && this.aoa && this.aoi > 0) {
            this.anJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.aoi), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aoe = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.anz;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aom != null) {
            this.aom.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aom);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.anQ = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.anU = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.anY = z;
    }

    public void setLiveShareEnable(boolean z) {
        this.anZ = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.aoa = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.anS = z;
    }

    public View getCommentNumView() {
        return this.anG;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.aog = i;
        }
    }

    public void setLiveShareIcon(int i) {
        if (i > 0) {
            this.aoh = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.aoi = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getScaleAnimation() {
        if (this.aoj == null) {
            this.aoj = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.aoj.setDuration(200L);
        }
        return this.aoj;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.anV = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.anW = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.anX = z;
    }

    public void setShareVisible(boolean z) {
        this.aob = z;
    }
}
