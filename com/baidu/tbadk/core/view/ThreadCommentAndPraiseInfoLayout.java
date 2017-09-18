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
    private bj ajE;
    private TextView anA;
    private TextView anB;
    private ImageView anC;
    private View anD;
    private TextView anE;
    private TextView anF;
    private TextView anG;
    private TextView anH;
    private TextView anI;
    private TextView anJ;
    private FrameLayout anK;
    private List<CharSequence> anL;
    private List<String> anM;
    private boolean anN;
    private boolean anO;
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
    private TextView anx;
    private TextView any;
    private View anz;
    private int aoa;
    private String aob;
    private View.OnClickListener aoc;
    private int aod;
    private int aoe;
    private int aof;
    private int aog;
    private ScaleAnimation aoh;
    private ShareReportModel aoi;
    private View.OnClickListener aoj;
    private CustomMessageListener aok;
    private Context mContext;
    private TbPageContext mF;
    private int mFrom;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.aob = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.aoa = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.anN = false;
        this.anO = false;
        this.anP = false;
        this.anQ = true;
        this.anR = true;
        this.anS = false;
        this.anT = false;
        this.anU = false;
        this.anV = true;
        this.anW = true;
        this.anX = false;
        this.anY = false;
        this.anZ = false;
        this.mFrom = 2;
        this.aoa = 1;
        this.aoj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (ax.aU(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.ajE != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.ajE.sP() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.ajE.bZ(ThreadCommentAndPraiseInfoLayout.this.ajE.sO() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.ajE.bY(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.anB != null) {
                            aj.i(ThreadCommentAndPraiseInfoLayout.this.anB, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.ajE.bY(1);
                        ThreadCommentAndPraiseInfoLayout.this.ajE.bZ(ThreadCommentAndPraiseInfoLayout.this.ajE.sO() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.anB != null) {
                            aj.i(ThreadCommentAndPraiseInfoLayout.this.anB, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.j(ThreadCommentAndPraiseInfoLayout.this.ajE);
                    if (ThreadCommentAndPraiseInfoLayout.this.anC != null) {
                        ThreadCommentAndPraiseInfoLayout.this.anC.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.ajE.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.ajE.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ak akVar = new ak("c12003");
                    akVar.ad("tid", ThreadCommentAndPraiseInfoLayout.this.ajE.getTid());
                    if (ThreadCommentAndPraiseInfoLayout.this.ajE.getThreadType() != 40) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajE.getThreadType() == 0) {
                            akVar.ad("obj_param1", "1");
                        }
                    } else {
                        akVar.ad("obj_param1", "2");
                    }
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    akVar.f("fid", ThreadCommentAndPraiseInfoLayout.this.ajE.getFid());
                    akVar.r("obj_locate", ThreadCommentAndPraiseInfoLayout.this.mFrom);
                    akVar.r("obj_id", i);
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.aok = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && ThreadCommentAndPraiseInfoLayout.this.ajE != null && ThreadCommentAndPraiseInfoLayout.this.ajE.getId() != null) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bjVar.getId()) && bjVar.rr() != null && bjVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajE.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajE.rr() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajE.rr().setNum(bjVar.rr().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.j(ThreadCommentAndPraiseInfoLayout.this.ajE);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anN = false;
        this.anO = false;
        this.anP = false;
        this.anQ = true;
        this.anR = true;
        this.anS = false;
        this.anT = false;
        this.anU = false;
        this.anV = true;
        this.anW = true;
        this.anX = false;
        this.anY = false;
        this.anZ = false;
        this.mFrom = 2;
        this.aoa = 1;
        this.aoj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (ax.aU(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.ajE != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.ajE.sP() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.ajE.bZ(ThreadCommentAndPraiseInfoLayout.this.ajE.sO() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.ajE.bY(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.anB != null) {
                            aj.i(ThreadCommentAndPraiseInfoLayout.this.anB, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.ajE.bY(1);
                        ThreadCommentAndPraiseInfoLayout.this.ajE.bZ(ThreadCommentAndPraiseInfoLayout.this.ajE.sO() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.anB != null) {
                            aj.i(ThreadCommentAndPraiseInfoLayout.this.anB, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.j(ThreadCommentAndPraiseInfoLayout.this.ajE);
                    if (ThreadCommentAndPraiseInfoLayout.this.anC != null) {
                        ThreadCommentAndPraiseInfoLayout.this.anC.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.ajE.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.ajE.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ak akVar = new ak("c12003");
                    akVar.ad("tid", ThreadCommentAndPraiseInfoLayout.this.ajE.getTid());
                    if (ThreadCommentAndPraiseInfoLayout.this.ajE.getThreadType() != 40) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajE.getThreadType() == 0) {
                            akVar.ad("obj_param1", "1");
                        }
                    } else {
                        akVar.ad("obj_param1", "2");
                    }
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    akVar.f("fid", ThreadCommentAndPraiseInfoLayout.this.ajE.getFid());
                    akVar.r("obj_locate", ThreadCommentAndPraiseInfoLayout.this.mFrom);
                    akVar.r("obj_id", i);
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.aok = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj) && ThreadCommentAndPraiseInfoLayout.this.ajE != null && ThreadCommentAndPraiseInfoLayout.this.ajE.getId() != null) {
                    bj bjVar = (bj) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bjVar.getId()) && bjVar.rr() != null && bjVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajE.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajE.rr() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajE.rr().setNum(bjVar.rr().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.j(ThreadCommentAndPraiseInfoLayout.this.ajE);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.anx = (TextView) inflate.findViewById(d.h.thread_info_bar_name);
        this.any = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.anz = inflate.findViewById(d.h.frs_item_location_sep);
        this.anA = (TextView) inflate.findViewById(d.h.frs_item_location_address);
        this.anB = (TextView) inflate.findViewById(d.h.thread_info_praise_num);
        this.anE = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.anF = (TextView) inflate.findViewById(d.h.share_num);
        this.anG = (TextView) inflate.findViewById(d.h.thread_info_share_num);
        this.anH = (TextView) inflate.findViewById(d.h.thread_info_audience_num);
        this.anI = (TextView) inflate.findViewById(d.h.thread_info_view_num);
        this.anJ = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.anK = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        this.mContext = context;
        this.anC = (ImageView) inflate.findViewById(d.h.thread_info_praise_img);
        this.anD = inflate.findViewById(d.h.agree_view_container);
        this.anD.setOnClickListener(this);
        this.anE.setOnClickListener(this);
        this.anF.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.anx) {
            B(view);
        } else if (view == this.anE) {
            C(view);
        } else if (view == this.anD) {
            D(view);
        } else if (view == this.anF) {
            E(view);
        } else if (view == this.anK) {
            F(view);
        }
    }

    private void B(View view) {
        if (this.ajE != null && !StringUtils.isNull(this.ajE.rG())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aob)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ajE.rG(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ajE.rG(), this.mStType, this.aob)));
            }
            if (this.aoc != null) {
                this.aoc.onClick(view);
            }
        }
    }

    private void C(View view) {
        if (this.ajE != null && this.mContext != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ajE, null, com.baidu.tieba.card.m.rs(), 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajE.getFid()));
            addLocateParam.setForumName(this.ajE.rG());
            addLocateParam.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
        }
    }

    private void D(View view) {
        int i = 1;
        if (ax.aU(this.mContext) && this.ajE != null) {
            if (this.ajE.sP() != 0) {
                this.ajE.bZ(this.ajE.sO() - 1);
                this.ajE.bY(0);
                if (this.anB != null) {
                    aj.i(this.anB, d.e.cp_cont_j);
                }
            } else {
                this.ajE.bY(1);
                this.ajE.bZ(this.ajE.sO() + 1);
                if (this.anB != null) {
                    aj.i(this.anB, d.e.cp_cont_h);
                }
                i = 0;
            }
            j(this.ajE);
            if (this.anC != null) {
                this.anC.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.ajE.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addParam("forum_id", this.ajE.getFid());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void E(View view) {
        xg();
        if (ax.aU(this.mContext)) {
            xh();
        }
    }

    private void xg() {
        int i = 4;
        if (this.ajE != null) {
            if (this.aoa != 1) {
                if (this.aoa == 2) {
                    i = 5;
                } else if (this.aoa == 3) {
                    i = 3;
                } else {
                    i = this.aoa == 4 ? 2 : 0;
                }
            }
            TiebaStatic.log(new ak("c12386").f("fid", this.ajE.getFid()).ad("tid", this.ajE.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void xh() {
        if (this.ajE != null && this.mContext != null) {
            final String valueOf = String.valueOf(this.ajE.getFid());
            String rG = this.ajE.rG();
            String title = this.ajE.getTitle();
            final String tid = this.ajE.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajE);
            Uri parse = a == null ? null : Uri.parse(a);
            String rJ = this.ajE.rJ();
            String format = MessageFormat.format(getResources().getString(d.l.share_content_tpl), title, rJ);
            final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
            dVar.title = title;
            dVar.content = format;
            dVar.auC = rJ;
            dVar.linkUrl = str;
            dVar.auw = this.aoa;
            dVar.extData = tid;
            dVar.auF = 3;
            dVar.fid = valueOf;
            dVar.aux = rG;
            dVar.Xe = tid;
            dVar.aut = true;
            dVar.auE = getShareObjSource();
            dVar.auG = b(this.ajE);
            if (parse != null) {
                dVar.auz = parse;
            }
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.auF);
            bundle.putInt("obj_type", dVar.auG);
            bundle.putString("fid", dVar.fid);
            bundle.putString("tid", dVar.Xe);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.auw);
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
        if (this.aoa == 1) {
            return 5;
        }
        if (this.aoa != 3) {
            return this.aoa == 4 ? 4 : 0;
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
            if (this.aoi == null) {
                this.aoi = new ShareReportModel(this.mF);
            }
            this.aoi.l(shareItem.fid, shareItem.Xe, shareItem.auw);
        }
    }

    private void F(View view) {
        xk();
    }

    public void setShowPraiseNum(boolean z) {
        this.anP = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.anR = z;
        if (this.anx != null) {
            this.anx.setClickable(this.anR);
        }
    }

    public boolean xj() {
        return this.anK != null && this.anK.getVisibility() == 0;
    }

    public boolean c(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajE = bjVar;
        d(bjVar);
        e(bjVar);
        f(bjVar);
        l(bjVar);
        j(bjVar);
        g(bjVar);
        h(bjVar);
        i(bjVar);
        k(bjVar);
        setVisibility(this.anN ? 0 : 8);
        return this.anN;
    }

    private void d(bj bjVar) {
        if (this.anx != null && bjVar != null) {
            if (!StringUtils.isNull(bjVar.rG()) && this.anV) {
                this.anx.setVisibility(0);
                String e = am.e(bjVar.rG(), 14, "...");
                String string = getContext().getString(d.l.chosen_pb_original_bar, e);
                if (am.dU(e) > 14) {
                    this.anx.setText(e);
                } else {
                    this.anx.setText(string);
                }
                this.anx.setContentDescription(string);
                this.anx.setOnClickListener(this);
                this.anx.setClickable(this.anR);
                this.anN = true;
                return;
            }
            this.anx.setVisibility(8);
        }
    }

    private void e(bj bjVar) {
        String s;
        if (this.any != null && bjVar != null) {
            if (bjVar.rv() <= 0 || !this.anQ) {
                this.any.setVisibility(8);
                return;
            }
            this.any.setVisibility(0);
            if (this.mFrom == 3) {
                s = am.p(bjVar.rv());
            } else {
                s = am.s(bjVar.rv() * 1000);
            }
            this.any.setText(s);
            this.anN = true;
        }
    }

    private void f(bj bjVar) {
        if (this.anA != null && this.anz != null && bjVar != null) {
            if (this.anO && !bjVar.sg() && !StringUtils.isNull(bjVar.getAddress())) {
                this.anA.setVisibility(0);
                if (bjVar.rv() <= 0) {
                    this.anz.setVisibility(8);
                } else {
                    this.anz.setVisibility(0);
                }
                this.anA.setText(bjVar.getAddress());
                this.anN = true;
                return;
            }
            this.anA.setVisibility(8);
            this.anz.setVisibility(8);
        }
    }

    private void g(bj bjVar) {
        if (this.anE != null && bjVar != null) {
            if (this.anW) {
                if (bjVar.rt() > 0) {
                    this.anE.setVisibility(0);
                    String v = am.v(bjVar.rt());
                    if (this.anT) {
                        this.anE.setText(v);
                    } else {
                        this.anE.setText(String.format(this.mContext.getString(d.l.reply_num_tip), v));
                    }
                    this.anE.setContentDescription(this.mContext.getString(d.l.reply_num) + v);
                    this.anN = true;
                    return;
                } else if (this.anT) {
                    this.anE.setText("0");
                    this.anE.setVisibility(0);
                    this.anN = true;
                    return;
                } else {
                    this.anE.setVisibility(8);
                    return;
                }
            }
            this.anE.setVisibility(8);
        }
    }

    private void h(bj bjVar) {
        if ((this.anG != null || bjVar != null) && bjVar.rT() != null) {
            if (!this.anX) {
                this.anG.setVisibility(8);
                return;
            }
            this.anG.setText(am.v(bjVar.rT().Uv.share_count));
            this.anG.setVisibility(0);
            this.anN = true;
        }
    }

    private void i(bj bjVar) {
        if ((this.anH != null || bjVar != null) && bjVar.rT() != null) {
            if (!this.anY) {
                this.anH.setVisibility(8);
                return;
            }
            this.anH.setText(am.v(bjVar.rT().audience_count));
            this.anH.setVisibility(0);
            this.anN = true;
        }
    }

    public void j(bj bjVar) {
        if (this.anB != null && bjVar != null) {
            if (this.anP) {
                this.anD.setVisibility(0);
                this.anB.setVisibility(0);
                String v = am.v(bjVar.sO());
                this.anB.setText(v);
                this.anB.setContentDescription(this.mContext.getString(d.l.zan_num) + v);
                this.anN = true;
                if (bjVar.sP() != 0) {
                    this.aod = d.g.icon_home_card_liked_n;
                    this.anC.setImageDrawable(aj.getDrawable(this.aod));
                    if (this.anB != null) {
                        aj.i(this.anB, d.e.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.aod = d.g.icon_home_card_like_n;
                this.anC.setImageDrawable(aj.getDrawable(this.aod));
                if (this.anB != null) {
                    aj.i(this.anB, d.e.cp_cont_j);
                    return;
                }
                return;
            }
            this.anD.setVisibility(8);
            this.anB.setVisibility(8);
        }
    }

    private void k(bj bjVar) {
        if (this.anF != null && bjVar != null) {
            if (this.anZ) {
                this.anF.setVisibility(0);
                this.anF.setText(am.v(bjVar.sQ()));
                return;
            }
            this.anF.setVisibility(8);
        }
    }

    private void l(bj bjVar) {
        if (this.anI != null && bjVar != null) {
            if (this.anS && bjVar.ru() > 0) {
                this.anI.setVisibility(0);
                String u = am.u(bjVar.ru());
                this.anI.setText(String.format(this.mContext.getString(d.l.view_num_tip), u));
                this.anI.setContentDescription(this.mContext.getString(d.l.view_num) + u);
                this.anN = true;
                return;
            }
            this.anI.setVisibility(8);
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.mF = tbPageContext;
        if (this.anK != null) {
            if (this.ajE == null || v.v(this.ajE.sD()) || !TbadkCoreApplication.isLogin() || this.ajE.sE()) {
                this.anK.setVisibility(8);
                return;
            }
            if (this.anL == null) {
                this.anL = new ArrayList();
            } else {
                this.anL.clear();
            }
            if (this.anM == null) {
                this.anM = new ArrayList();
            } else {
                this.anM.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ajE.sD()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.anL.add(reportInfo.info);
                    this.anM.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.anK.setOnClickListener(this);
                this.anK.setVisibility(0);
                return;
            }
            this.anK.setVisibility(8);
        }
    }

    private void xk() {
        if (this.mF != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mF.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.anL, new b.InterfaceC0046b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.anM, i);
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
        aj.i(this.anx, d.e.cp_cont_j);
        aj.i(this.any, d.e.cp_cont_j);
        aj.k(this.anz, d.e.cp_cont_j);
        aj.i(this.anA, d.e.cp_cont_j);
        aj.i(this.anB, d.e.cp_cont_j);
        aj.i(this.anI, d.e.cp_cont_j);
        aj.i(this.anE, d.e.cp_cont_j);
        aj.i(this.anF, d.e.cp_cont_j);
        if (this.ajE != null && this.ajE.sP() == 1 && this.anB != null) {
            aj.i(this.anB, d.e.cp_cont_h);
            this.aod = d.g.icon_home_card_liked_n;
        }
        aj.i(this.anG, d.e.cp_cont_j);
        aj.i(this.anH, d.e.cp_cont_j);
        aj.j(this.anJ, d.g.btn_frs_more_selector);
        if (this.anB != null && this.anU && this.aod > 0) {
            this.anC.setImageDrawable(aj.getDrawable(this.aod));
        }
        if (this.anE != null && this.anT && this.aoe > 0) {
            this.anE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.aoe), (Drawable) null);
        }
        if (this.anF != null) {
            this.anF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_home_card_share_n), (Drawable) null);
        }
        if (this.anG != null && this.anX && this.aof > 0) {
            this.anG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.aof), (Drawable) null);
        }
        if (this.anH != null && this.anY && this.aog > 0) {
            this.anH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(this.aog), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aoc = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.anx;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aok != null) {
            this.aok.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aok);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.anO = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.anS = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.anW = z;
    }

    public void setLiveShareEnable(boolean z) {
        this.anX = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.anY = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.anQ = z;
    }

    public View getCommentNumView() {
        return this.anE;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.aoe = i;
        }
    }

    public void setLiveShareIcon(int i) {
        if (i > 0) {
            this.aof = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.aog = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getScaleAnimation() {
        if (this.aoh == null) {
            this.aoh = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.aoh.setDuration(200L);
        }
        return this.aoh;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.anT = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.anU = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.anV = z;
    }

    public void setShareVisible(boolean z) {
        this.anZ = z;
    }
}
