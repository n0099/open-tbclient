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
    protected bd aXU;
    protected View bbA;
    private w bbB;
    protected boolean bbC;
    protected boolean bbD;
    private boolean bbE;
    protected boolean bbF;
    protected boolean bbG;
    private boolean bbH;
    protected boolean bbI;
    protected boolean bbJ;
    private boolean bbK;
    protected boolean bbL;
    protected boolean bbM;
    private int bbN;
    private int bbO;
    public int bbP;
    private String bbQ;
    private View.OnClickListener bbR;
    protected int bbS;
    protected int bbT;
    protected int bbU;
    protected ScaleAnimation bbV;
    private com.baidu.tieba.d.c bbW;
    private CustomMessageListener bbX;
    protected int bbi;
    protected TextView bbj;
    private TextView bbk;
    protected TextView bbl;
    protected ImageView bbm;
    protected View bbn;
    protected TextView bbo;
    protected ImageView bbp;
    protected View bbq;
    protected TextView bbr;
    protected ImageView bbs;
    protected View bbt;
    protected TextView bbu;
    protected FrameLayout bbv;
    private List<CharSequence> bbw;
    private List<String> bbx;
    protected TextView bby;
    protected ImageView bbz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.bbQ = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.bbN = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bbi = 0;
        this.bbC = false;
        this.bbD = true;
        this.bbE = true;
        this.bbF = true;
        this.bbG = false;
        this.bbH = false;
        this.bbI = false;
        this.bbJ = true;
        this.bbK = false;
        this.bbL = true;
        this.bbM = false;
        this.mFrom = 2;
        this.bbN = 1;
        this.bbX = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aXU != null && ThreadCommentAndPraiseInfoLayout.this.aXU.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.yH() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aXU.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aXU.yH() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aXU.yH().setNum(bdVar.yH().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aXU);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbi = 0;
        this.bbC = false;
        this.bbD = true;
        this.bbE = true;
        this.bbF = true;
        this.bbG = false;
        this.bbH = false;
        this.bbI = false;
        this.bbJ = true;
        this.bbK = false;
        this.bbL = true;
        this.bbM = false;
        this.mFrom = 2;
        this.bbN = 1;
        this.bbX = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aXU != null && ThreadCommentAndPraiseInfoLayout.this.aXU.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.yH() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aXU.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aXU.yH() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aXU.yH().setNum(bdVar.yH().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aXU);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bbi = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.bbj = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.bbk = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bbo = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bbp = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.bbq = inflate.findViewById(d.g.thread_info_commont_container);
        this.bbr = (TextView) inflate.findViewById(d.g.share_num);
        this.bbs = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.bbt = inflate.findViewById(d.g.share_num_container);
        this.bbu = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bbv = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.bbl = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.bbm = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.bbn = inflate.findViewById(d.g.agree_view_container);
        this.bbA = inflate.findViewById(d.g.manage_view_container);
        this.bby = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.bbz = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.bbn.setOnClickListener(this);
        this.bbq.setOnClickListener(this);
        this.bbt.setOnClickListener(this);
        this.bbA.setOnClickListener(this);
        this.bbU = d.f.icon_home_card_share;
        this.bbT = d.f.icon_home_card_comment;
        this.bbO = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bbj) {
            aU(view);
        } else if (view == this.bbq) {
            aV(view);
        } else if (view == this.bbn) {
            aW(view);
        } else if (view == this.bbt) {
            aX(view);
        } else if (view == this.bbv) {
            aZ(view);
        } else if (view == this.bbA) {
            aY(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bbB != null) {
            this.bbB.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.bbq != null) {
            this.bbq.setClickable(z);
            this.bbp.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bbn != null) {
            this.bbn.setClickable(z);
            this.bbm.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.bbt != null) {
            this.bbt.setEnabled(z);
            this.bbs.setEnabled(z);
        }
    }

    private void aU(View view) {
        if (this.aXU != null && !StringUtils.isNull(this.aXU.yY())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.bbQ)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.aXU.yY(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aXU.yY(), this.mStType, this.bbQ)));
            }
            if (this.bbR != null) {
                this.bbR.onClick(view);
            }
        }
    }

    private void aV(View view) {
        if (this.aXU != null && this.mContext != null) {
            com.baidu.tieba.card.k.kc(this.aXU.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aXU, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aXU.getFid()));
            addLocateParam.setForumName(this.aXU.yY());
            addLocateParam.setJumpToCommentArea(true);
            if (this.aXU.zH() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.bbP);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.s("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
            if (this.bbR != null) {
                this.bbR.onClick(view);
            }
        }
    }

    protected void aW(View view) {
        int i = 1;
        if (ax.be(this.mContext) && this.aXU != null) {
            if (this.aXU.Ae() != 0) {
                this.aXU.eY(this.aXU.Ad() - 1);
                this.aXU.eX(0);
                if (this.bbl != null) {
                    aj.r(this.bbl, d.C0107d.cp_cont_j);
                }
            } else {
                this.aXU.eX(1);
                this.aXU.eY(this.aXU.Ad() + 1);
                if (this.bbl != null) {
                    aj.r(this.bbl, d.C0107d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.aXU);
            if (this.bbm != null && i == 0) {
                this.bbm.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.aXU.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.bbO > 0) {
                httpMessage.addParam("forum_id", this.aXU.getFid());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ab("tid", this.aXU.getTid());
            if (this.aXU.getThreadType() == 40) {
                akVar.ab("obj_param1", "2");
            } else if (this.aXU.getThreadType() == 0) {
                akVar.ab("obj_param1", "1");
            }
            akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f(ImageViewerConfig.FORUM_ID, this.aXU.getFid());
            akVar.s("obj_locate", this.mFrom);
            akVar.s("obj_id", i);
            TiebaStatic.log(akVar);
        }
    }

    protected void aX(View view) {
        if (am.nu() || ax.be(this.mContext)) {
            DV();
            DW();
        }
    }

    private void DV() {
        int i = 4;
        if (this.aXU != null) {
            if (this.bbN != 1) {
                if (this.bbN == 2) {
                    i = 5;
                } else if (this.bbN == 3) {
                    i = 3;
                } else if (this.bbN == 4) {
                    i = 2;
                } else if (this.bbN != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f(ImageViewerConfig.FORUM_ID, this.aXU.getFid()).ab("tid", this.aXU.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_locate", i));
        }
    }

    private void DW() {
        if (this.aXU != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aXU.getFid());
            String yY = this.aXU.yY();
            String title = this.aXU.getTitle();
            String tid = this.aXU.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aXU);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.aXU.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.bjh = str2;
            dVar.linkUrl = str;
            dVar.aPe = this.bbN;
            dVar.extData = tid;
            dVar.bjk = 3;
            dVar.fid = valueOf;
            dVar.bjc = yY;
            dVar.tid = tid;
            dVar.biZ = true;
            dVar.bjj = getShareObjSource();
            dVar.bjl = b(this.aXU);
            if (parse != null) {
                dVar.bje = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aXU);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.bjk);
            bundle.putInt("obj_type", dVar.bjl);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aPe);
            dVar.h(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aXU.getThreadType() == 49 || this.aXU.getThreadType() == 60);
            if (this.bbW == null) {
                this.bbW = new com.baidu.tieba.d.c(this.mContext);
            }
            this.bbW.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.bbN == 1) {
            return 5;
        }
        if (this.bbN != 3) {
            if (this.bbN == 4) {
                return 4;
            }
            if (this.bbN != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.zd() == null) {
            return null;
        }
        ArrayList<MediaData> zd = bdVar.zd();
        int size = zd.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = zd.get(i);
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
            if (bdVar.yV()) {
                return 4;
            }
            if (bdVar.yP() == 1) {
                return 3;
            }
            return bdVar.zW() ? 2 : 1;
        }
        return 0;
    }

    private void aY(View view) {
        if (this.bbB == null) {
            this.bbB = new w(this.mPageContext);
        }
        this.bbB.setData(this.aXU);
        com.baidu.adp.lib.g.g.a(this.bbB, this.mPageContext);
        TiebaStatic.log(new ak("c12711"));
    }

    private void aZ(View view) {
        DY();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.bbF = z;
        if (this.bbj != null) {
            this.bbj.setClickable(this.bbF);
        }
    }

    public boolean isMoreViewVisible() {
        return this.bbv != null && this.bbv.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.bbO = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aXU = bdVar;
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        g(bdVar);
        setVisibility(this.bbC ? 0 : 8);
        return this.bbC;
    }

    protected void c(bd bdVar) {
        this.bbj.setVisibility(8);
    }

    private void d(bd bdVar) {
        String A;
        if (this.bbk != null && bdVar != null) {
            if (bdVar.yM() <= 0 || !this.bbE) {
                this.bbk.setVisibility(8);
                return;
            }
            this.bbk.setVisibility(0);
            if (this.mFrom == 3) {
                A = com.baidu.tbadk.core.util.am.y(bdVar.yM());
            } else {
                A = com.baidu.tbadk.core.util.am.A(bdVar.yM() * 1000);
            }
            this.bbk.setText(A);
            this.bbC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(bd bdVar) {
        if (this.bbo != null && bdVar != null) {
            if (this.bbJ) {
                this.bbq.setVisibility(0);
                if (this.bbq.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbq.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bbq.setLayoutParams(layoutParams);
                }
                if (bdVar.yK() > 0) {
                    this.bbo.setVisibility(0);
                    String J = com.baidu.tbadk.core.util.am.J(bdVar.yK());
                    if (this.bbG) {
                        this.bbo.setText(J);
                    } else {
                        this.bbo.setText(String.format(this.mContext.getString(d.j.reply_num_tip), J));
                    }
                    this.bbo.setContentDescription(this.mContext.getString(d.j.reply_num) + J);
                    this.bbC = true;
                    return;
                } else if (this.bbG) {
                    this.bbo.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bbo.setVisibility(0);
                    this.bbC = true;
                    return;
                } else {
                    this.bbo.setVisibility(8);
                    return;
                }
            }
            this.bbq.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.bbn != null && this.bbm != null && this.bbl != null && bdVar != null) {
            if (this.bbD) {
                this.bbn.setVisibility(0);
                if (this.bbn.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbn.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bbn.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bbm.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.bbm.setLayoutParams(layoutParams2);
                int Ad = bdVar.Ad();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (Ad > 0) {
                    string = com.baidu.tbadk.core.util.am.J(Ad);
                }
                this.bbl.setText(string);
                this.bbl.setContentDescription(this.mContext.getString(d.j.zan_num) + Ad);
                this.bbC = true;
                if (bdVar.Ae() != 0) {
                    this.bbS = DX() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.bbm.setImageDrawable(aj.getDrawable(this.bbS));
                    if (this.bbl != null) {
                        aj.r(this.bbl, d.C0107d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.bbS = DX() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.bbm.setImageDrawable(aj.getDrawable(this.bbS));
                if (this.bbl != null) {
                    aj.r(this.bbl, d.C0107d.cp_cont_j);
                    return;
                }
                return;
            }
            this.bbn.setVisibility(8);
        }
    }

    private boolean DX() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.EU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bd bdVar) {
        if (this.bbt != null && this.bbr != null && bdVar != null) {
            if (this.bbL) {
                this.bbt.setVisibility(0);
                if (this.bbt.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbt.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bbt.setLayoutParams(layoutParams);
                }
                long Af = bdVar.Af();
                if ((bdVar.zV() || bdVar.zY()) && bdVar.zl() != null) {
                    Af = bdVar.zl().share_info.share_count;
                }
                this.bbr.setText(Af > 0 ? com.baidu.tbadk.core.util.am.J(Af) : this.mContext.getString(d.j.share));
                this.bbC = true;
                if (bdVar.aOZ != null && bdVar.aOZ.isDeleted) {
                    aj.s(this.bbs, d.f.icon_card_share_d);
                    aj.r(this.bbr, d.C0107d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                aj.s(this.bbs, this.bbU);
                aj.r(this.bbr, d.f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.bbt.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.bbv != null) {
            if (this.aXU == null || v.E(this.aXU.zS()) || !TbadkCoreApplication.isLogin() || this.aXU.zT()) {
                this.bbv.setVisibility(8);
                return;
            }
            if (this.bbv.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbv.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.bbv.setLayoutParams(layoutParams);
            }
            if (this.bbw == null) {
                this.bbw = new ArrayList();
            } else {
                this.bbw.clear();
            }
            if (this.bbx == null) {
                this.bbx = new ArrayList();
            } else {
                this.bbx.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aXU.zS()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.bbw.add(reportInfo.info);
                    this.bbx.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.bbv.setOnClickListener(this);
                this.bbv.setVisibility(0);
                return;
            }
            this.bbv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bd bdVar) {
        if (this.bbA != null && bdVar != null) {
            if (this.bbM) {
                this.bbA.setVisibility(0);
                if (this.bbA.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbA.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bbA.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.bby.setText(string);
                this.bby.setContentDescription(string);
                this.bbC = true;
                return;
            }
            this.bbA.setVisibility(8);
        }
    }

    private void DY() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bbw, new b.InterfaceC0073b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayout.this.bbx, i);
                    if (!StringUtils.isNull(str)) {
                        av.CZ().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AD();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bbj, d.C0107d.cp_cont_d);
        aj.r(this.bbk, d.C0107d.cp_cont_j);
        aj.r(this.bbl, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bbo, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bby, d.f.selector_comment_and_prise_item_text_color);
        aj.s(this.bbu, d.f.btn_frs_more_selector);
        if (this.aXU != null && this.aXU.Ae() == 1 && this.bbl != null) {
            aj.r(this.bbl, d.C0107d.cp_cont_h);
            this.bbS = d.f.icon_home_card_like_s;
        }
        if (this.bbl != null && this.bbH && this.bbS > 0) {
            this.bbm.setImageDrawable(aj.getDrawable(this.bbS));
        }
        if (this.bbo != null && this.bbG && this.bbT > 0) {
            this.bbp.setImageDrawable(aj.getDrawable(this.bbT));
        }
        if (this.aXU != null && this.aXU.aOZ != null && this.aXU.aOZ.isDeleted) {
            aj.s(this.bbs, d.f.icon_card_share_d);
            aj.r(this.bbr, d.C0107d.cp_cont_e);
            setShareClickable(false);
        } else {
            aj.s(this.bbs, this.bbU);
            aj.r(this.bbr, d.f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.bbz != null) {
            this.bbz.setImageDrawable(aj.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.bbB != null) {
            this.bbB.onChangeSkinType();
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bbR = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.bbj;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bbX != null) {
            this.bbX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bbX);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.bbK = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.bbE = z;
    }

    public View getCommentNumView() {
        return this.bbo;
    }

    public View getCommentContainer() {
        return this.bbq;
    }

    protected Animation getScaleAnimation() {
        if (this.bbV == null) {
            this.bbV = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bbV.setDuration(200L);
        }
        return this.bbV;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.bbG = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.bbH = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.bbI = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.bbM = z;
    }
}
