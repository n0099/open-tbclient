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
    protected bd aYc;
    protected ImageView bbA;
    protected View bbB;
    protected TextView bbC;
    protected FrameLayout bbD;
    private List<CharSequence> bbE;
    private List<String> bbF;
    protected TextView bbG;
    protected ImageView bbH;
    protected View bbI;
    private w bbJ;
    protected boolean bbK;
    protected boolean bbL;
    private boolean bbM;
    protected boolean bbN;
    protected boolean bbO;
    private boolean bbP;
    protected boolean bbQ;
    protected boolean bbR;
    private boolean bbS;
    protected boolean bbT;
    protected boolean bbU;
    private int bbV;
    private int bbW;
    public int bbX;
    private String bbY;
    private View.OnClickListener bbZ;
    protected int bbq;
    protected TextView bbr;
    private TextView bbs;
    protected TextView bbt;
    protected ImageView bbu;
    protected View bbv;
    protected TextView bbw;
    protected ImageView bbx;
    protected View bby;
    protected TextView bbz;
    protected int bca;
    protected int bcb;
    protected int bcc;
    protected ScaleAnimation bcd;
    private com.baidu.tieba.d.c bce;
    private CustomMessageListener bcf;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.bbY = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.bbV = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.bbq = 0;
        this.bbK = false;
        this.bbL = true;
        this.bbM = true;
        this.bbN = true;
        this.bbO = false;
        this.bbP = false;
        this.bbQ = false;
        this.bbR = true;
        this.bbS = false;
        this.bbT = true;
        this.bbU = false;
        this.mFrom = 2;
        this.bbV = 1;
        this.bcf = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aYc != null && ThreadCommentAndPraiseInfoLayout.this.aYc.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.yI() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aYc.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aYc.yI() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aYc.yI().setNum(bdVar.yI().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aYc);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbq = 0;
        this.bbK = false;
        this.bbL = true;
        this.bbM = true;
        this.bbN = true;
        this.bbO = false;
        this.bbP = false;
        this.bbQ = false;
        this.bbR = true;
        this.bbS = false;
        this.bbT = true;
        this.bbU = false;
        this.mFrom = 2;
        this.bbV = 1;
        this.bcf = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.aYc != null && ThreadCommentAndPraiseInfoLayout.this.aYc.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.yI() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aYc.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aYc.yI() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aYc.yI().setNum(bdVar.yI().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.aYc);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.bbq = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.bbr = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.bbs = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bbw = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bbx = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.bby = inflate.findViewById(d.g.thread_info_commont_container);
        this.bbz = (TextView) inflate.findViewById(d.g.share_num);
        this.bbA = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.bbB = inflate.findViewById(d.g.share_num_container);
        this.bbC = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bbD = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.bbt = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.bbu = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.bbv = inflate.findViewById(d.g.agree_view_container);
        this.bbI = inflate.findViewById(d.g.manage_view_container);
        this.bbG = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.bbH = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.bbv.setOnClickListener(this);
        this.bby.setOnClickListener(this);
        this.bbB.setOnClickListener(this);
        this.bbI.setOnClickListener(this);
        this.bcc = d.f.icon_home_card_share;
        this.bcb = d.f.icon_home_card_comment;
        this.bbW = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bbr) {
            aU(view);
        } else if (view == this.bby) {
            aV(view);
        } else if (view == this.bbv) {
            aW(view);
        } else if (view == this.bbB) {
            aX(view);
        } else if (view == this.bbD) {
            aZ(view);
        } else if (view == this.bbI) {
            aY(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bbJ != null) {
            this.bbJ.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.bby != null) {
            this.bby.setClickable(z);
            this.bbx.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.bbv != null) {
            this.bbv.setClickable(z);
            this.bbu.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.bbB != null) {
            this.bbB.setEnabled(z);
            this.bbA.setEnabled(z);
        }
    }

    private void aU(View view) {
        if (this.aYc != null && !StringUtils.isNull(this.aYc.yZ())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.bbY)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.aYc.yZ(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.aYc.yZ(), this.mStType, this.bbY)));
            }
            if (this.bbZ != null) {
                this.bbZ.onClick(view);
            }
        }
    }

    private void aV(View view) {
        if (this.aYc != null && this.mContext != null) {
            com.baidu.tieba.card.k.kk(this.aYc.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.aYc, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.aYc.getFid()));
            addLocateParam.setForumName(this.aYc.yZ());
            addLocateParam.setJumpToCommentArea(true);
            if (this.aYc.zI() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.bbX);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.s("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
            if (this.bbZ != null) {
                this.bbZ.onClick(view);
            }
        }
    }

    protected void aW(View view) {
        int i = 1;
        if (ax.bb(this.mContext) && this.aYc != null) {
            if (this.aYc.Af() != 0) {
                this.aYc.eY(this.aYc.Ae() - 1);
                this.aYc.eX(0);
                if (this.bbt != null) {
                    aj.r(this.bbt, d.C0108d.cp_cont_j);
                }
            } else {
                this.aYc.eX(1);
                this.aYc.eY(this.aYc.Ae() + 1);
                if (this.bbt != null) {
                    aj.r(this.bbt, d.C0108d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.aYc);
            if (this.bbu != null && i == 0) {
                this.bbu.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.aYc.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.bbW > 0) {
                httpMessage.addParam("forum_id", this.aYc.getFid());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.aa("tid", this.aYc.getTid());
            if (this.aYc.getThreadType() == 40) {
                akVar.aa("obj_param1", "2");
            } else if (this.aYc.getThreadType() == 0) {
                akVar.aa("obj_param1", "1");
            }
            akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f(ImageViewerConfig.FORUM_ID, this.aYc.getFid());
            akVar.s("obj_locate", this.mFrom);
            akVar.s("obj_id", i);
            TiebaStatic.log(akVar);
        }
    }

    protected void aX(View view) {
        if (am.nv() || ax.bb(this.mContext)) {
            DX();
            DY();
        }
    }

    private void DX() {
        int i = 4;
        if (this.aYc != null) {
            if (this.bbV != 1) {
                if (this.bbV == 2) {
                    i = 5;
                } else if (this.bbV == 3) {
                    i = 3;
                } else if (this.bbV == 4) {
                    i = 2;
                } else if (this.bbV != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f(ImageViewerConfig.FORUM_ID, this.aYc.getFid()).aa("tid", this.aYc.getTid()).aa("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_locate", i));
        }
    }

    private void DY() {
        if (this.aYc != null && this.mContext != null) {
            String valueOf = String.valueOf(this.aYc.getFid());
            String yZ = this.aYc.yZ();
            String title = this.aYc.getTitle();
            String tid = this.aYc.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aYc);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.aYc.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.bjp = str2;
            dVar.linkUrl = str;
            dVar.aPh = this.bbV;
            dVar.extData = tid;
            dVar.bjs = 3;
            dVar.fid = valueOf;
            dVar.bjk = yZ;
            dVar.tid = tid;
            dVar.bjh = true;
            dVar.bjr = getShareObjSource();
            dVar.bjt = b(this.aYc);
            if (parse != null) {
                dVar.bjm = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aYc);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.bjs);
            bundle.putInt("obj_type", dVar.bjt);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aPh);
            dVar.h(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.aYc.getThreadType() == 49 || this.aYc.getThreadType() == 60);
            if (this.bce == null) {
                this.bce = new com.baidu.tieba.d.c(this.mContext);
            }
            this.bce.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.bbV == 1) {
            return 5;
        }
        if (this.bbV != 3) {
            if (this.bbV == 4) {
                return 4;
            }
            if (this.bbV != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.ze() == null) {
            return null;
        }
        ArrayList<MediaData> ze = bdVar.ze();
        int size = ze.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = ze.get(i);
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
            if (bdVar.yW()) {
                return 4;
            }
            if (bdVar.yQ() == 1) {
                return 3;
            }
            return bdVar.zX() ? 2 : 1;
        }
        return 0;
    }

    private void aY(View view) {
        if (this.bbJ == null) {
            this.bbJ = new w(this.mPageContext);
        }
        this.bbJ.setData(this.aYc);
        com.baidu.adp.lib.g.g.a(this.bbJ, this.mPageContext);
        TiebaStatic.log(new ak("c12711"));
    }

    private void aZ(View view) {
        Ea();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.bbN = z;
        if (this.bbr != null) {
            this.bbr.setClickable(this.bbN);
        }
    }

    public boolean isMoreViewVisible() {
        return this.bbD != null && this.bbD.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.bbW = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aYc = bdVar;
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        g(bdVar);
        setVisibility(this.bbK ? 0 : 8);
        return this.bbK;
    }

    protected void c(bd bdVar) {
        this.bbr.setVisibility(8);
    }

    private void d(bd bdVar) {
        String A;
        if (this.bbs != null && bdVar != null) {
            if (bdVar.yN() <= 0 || !this.bbM) {
                this.bbs.setVisibility(8);
                return;
            }
            this.bbs.setVisibility(0);
            if (this.mFrom == 3) {
                A = com.baidu.tbadk.core.util.am.y(bdVar.yN());
            } else {
                A = com.baidu.tbadk.core.util.am.A(bdVar.yN() * 1000);
            }
            this.bbs.setText(A);
            this.bbK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(bd bdVar) {
        if (this.bbw != null && bdVar != null) {
            if (this.bbR) {
                this.bby.setVisibility(0);
                if (this.bby.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bby.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bby.setLayoutParams(layoutParams);
                }
                if (bdVar.yL() > 0) {
                    this.bbw.setVisibility(0);
                    String J = com.baidu.tbadk.core.util.am.J(bdVar.yL());
                    if (this.bbO) {
                        this.bbw.setText(J);
                    } else {
                        this.bbw.setText(String.format(this.mContext.getString(d.j.reply_num_tip), J));
                    }
                    this.bbw.setContentDescription(this.mContext.getString(d.j.reply_num) + J);
                    this.bbK = true;
                    return;
                } else if (this.bbO) {
                    this.bbw.setText(this.mContext.getString(d.j.action_comment_default));
                    this.bbw.setVisibility(0);
                    this.bbK = true;
                    return;
                } else {
                    this.bbw.setVisibility(8);
                    return;
                }
            }
            this.bby.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.bbv != null && this.bbu != null && this.bbt != null && bdVar != null) {
            if (this.bbL) {
                this.bbv.setVisibility(0);
                if (this.bbv.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbv.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bbv.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bbu.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.bbu.setLayoutParams(layoutParams2);
                int Ae = bdVar.Ae();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (Ae > 0) {
                    string = com.baidu.tbadk.core.util.am.J(Ae);
                }
                this.bbt.setText(string);
                this.bbt.setContentDescription(this.mContext.getString(d.j.zan_num) + Ae);
                this.bbK = true;
                if (bdVar.Af() != 0) {
                    this.bca = DZ() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.bbu.setImageDrawable(aj.getDrawable(this.bca));
                    if (this.bbt != null) {
                        aj.r(this.bbt, d.C0108d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.bca = DZ() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.bbu.setImageDrawable(aj.getDrawable(this.bca));
                if (this.bbt != null) {
                    aj.r(this.bbt, d.C0108d.cp_cont_j);
                    return;
                }
                return;
            }
            this.bbv.setVisibility(8);
        }
    }

    private boolean DZ() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.EW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bd bdVar) {
        if (this.bbB != null && this.bbz != null && bdVar != null) {
            if (this.bbT) {
                this.bbB.setVisibility(0);
                if (this.bbB.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbB.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bbB.setLayoutParams(layoutParams);
                }
                long Ag = bdVar.Ag();
                if ((bdVar.zW() || bdVar.zZ()) && bdVar.zm() != null) {
                    Ag = bdVar.zm().share_info.share_count;
                }
                this.bbz.setText(Ag > 0 ? com.baidu.tbadk.core.util.am.J(Ag) : this.mContext.getString(d.j.share));
                this.bbK = true;
                if (bdVar.aPc != null && bdVar.aPc.isDeleted) {
                    aj.s(this.bbA, d.f.icon_card_share_d);
                    aj.r(this.bbz, d.C0108d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                aj.s(this.bbA, this.bcc);
                aj.r(this.bbz, d.f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.bbB.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.bbD != null) {
            if (this.aYc == null || v.E(this.aYc.zT()) || !TbadkCoreApplication.isLogin() || this.aYc.zU()) {
                this.bbD.setVisibility(8);
                return;
            }
            if (this.bbD.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbD.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.bbD.setLayoutParams(layoutParams);
            }
            if (this.bbE == null) {
                this.bbE = new ArrayList();
            } else {
                this.bbE.clear();
            }
            if (this.bbF == null) {
                this.bbF = new ArrayList();
            } else {
                this.bbF.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aYc.zT()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.bbE.add(reportInfo.info);
                    this.bbF.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.bbD.setOnClickListener(this);
                this.bbD.setVisibility(0);
                return;
            }
            this.bbD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bd bdVar) {
        if (this.bbI != null && bdVar != null) {
            if (this.bbU) {
                this.bbI.setVisibility(0);
                if (this.bbI.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbI.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.bbI.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.j.manage);
                this.bbG.setText(string);
                this.bbG.setContentDescription(string);
                this.bbK = true;
                return;
            }
            this.bbI.setVisibility(8);
        }
    }

    private void Ea() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bbE, new b.InterfaceC0073b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayout.this.bbF, i);
                    if (!StringUtils.isNull(str)) {
                        av.Da().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AE();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bbr, d.C0108d.cp_cont_d);
        aj.r(this.bbs, d.C0108d.cp_cont_j);
        aj.r(this.bbt, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bbw, d.f.selector_comment_and_prise_item_text_color);
        aj.r(this.bbG, d.f.selector_comment_and_prise_item_text_color);
        aj.s(this.bbC, d.f.btn_frs_more_selector);
        if (this.aYc != null && this.aYc.Af() == 1 && this.bbt != null) {
            aj.r(this.bbt, d.C0108d.cp_cont_h);
            this.bca = d.f.icon_home_card_like_s;
        }
        if (this.bbt != null && this.bbP && this.bca > 0) {
            this.bbu.setImageDrawable(aj.getDrawable(this.bca));
        }
        if (this.bbw != null && this.bbO && this.bcb > 0) {
            this.bbx.setImageDrawable(aj.getDrawable(this.bcb));
        }
        if (this.aYc != null && this.aYc.aPc != null && this.aYc.aPc.isDeleted) {
            aj.s(this.bbA, d.f.icon_card_share_d);
            aj.r(this.bbz, d.C0108d.cp_cont_e);
            setShareClickable(false);
        } else {
            aj.s(this.bbA, this.bcc);
            aj.r(this.bbz, d.f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.bbH != null) {
            this.bbH.setImageDrawable(aj.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.bbJ != null) {
            this.bbJ.onChangeSkinType();
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bbZ = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.bbr;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bcf != null) {
            this.bcf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bcf);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.bbS = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.bbM = z;
    }

    public View getCommentNumView() {
        return this.bbw;
    }

    public View getCommentContainer() {
        return this.bby;
    }

    protected Animation getScaleAnimation() {
        if (this.bcd == null) {
            this.bcd = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.bcd.setDuration(200L);
        }
        return this.bcd;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.bbO = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.bbP = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.bbQ = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.bbU = z;
    }
}
