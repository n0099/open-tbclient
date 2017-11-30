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
import com.baidu.sapi2.SapiAccountManager;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.o.al;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout implements View.OnClickListener {
    protected bd ajM;
    protected boolean anA;
    protected boolean anB;
    private boolean anC;
    protected boolean anD;
    protected boolean anE;
    private boolean anF;
    protected boolean anG;
    protected boolean anH;
    private boolean anI;
    protected boolean anJ;
    private int anK;
    private int anL;
    public int anM;
    private String anN;
    private View.OnClickListener anO;
    protected int anP;
    protected int anQ;
    protected int anR;
    protected ScaleAnimation anS;
    private com.baidu.tieba.d.c anT;
    private CustomMessageListener anU;
    protected TextView anl;
    private TextView anm;
    protected TextView ann;
    protected ImageView ano;
    protected View anp;
    protected TextView anq;
    private ImageView anr;
    protected View ans;
    protected TextView ant;
    private ImageView anu;
    protected View anv;
    private TextView anw;
    private FrameLayout anx;
    private List<CharSequence> any;
    private List<String> anz;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.anN = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.anK = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.anA = false;
        this.anB = true;
        this.anC = true;
        this.anD = true;
        this.anE = false;
        this.anF = false;
        this.anG = true;
        this.anH = true;
        this.anI = false;
        this.anJ = true;
        this.mFrom = 2;
        this.anK = 1;
        this.anU = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.ajM != null && ThreadCommentAndPraiseInfoLayout.this.ajM.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.rm() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajM.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajM.rm() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajM.rm().setNum(bdVar.rm().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajM);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anA = false;
        this.anB = true;
        this.anC = true;
        this.anD = true;
        this.anE = false;
        this.anF = false;
        this.anG = true;
        this.anH = true;
        this.anI = false;
        this.anJ = true;
        this.mFrom = 2;
        this.anK = 1;
        this.anU = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.ajM != null && ThreadCommentAndPraiseInfoLayout.this.ajM.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.rm() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.ajM.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.ajM.rm() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.ajM.rm().setNum(bdVar.rm().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.ajM);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.anl = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.anm = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.ann = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.anq = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.anr = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.ans = inflate.findViewById(d.g.thread_info_commont_container);
        this.ant = (TextView) inflate.findViewById(d.g.share_num);
        this.anu = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.anv = inflate.findViewById(d.g.share_num_container);
        this.anw = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.anx = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.mContext = context;
        this.ano = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.anp = inflate.findViewById(d.g.agree_view_container);
        this.anp.setOnClickListener(this);
        this.ans.setOnClickListener(this);
        this.anv.setOnClickListener(this);
        this.anR = d.f.icon_home_card_share;
        this.anQ = d.f.icon_home_card_comment;
        this.anL = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.anl) {
            B(view);
        } else if (view == this.ans) {
            C(view);
        } else if (view == this.anp) {
            D(view);
        } else if (view == this.anv) {
            E(view);
        } else if (view == this.anx) {
            F(view);
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.ans != null) {
            this.ans.setClickable(z);
            this.anr.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.anp != null) {
            this.anp.setClickable(z);
            this.ano.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.anv != null) {
            this.anv.setClickable(z);
            this.anu.setEnabled(z);
        }
    }

    private void B(View view) {
        if (this.ajM != null && !StringUtils.isNull(this.ajM.rD())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.anN)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.ajM.rD(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.ajM.rD(), this.mStType, this.anN)));
            }
            if (this.anO != null) {
                this.anO.onClick(view);
            }
        }
    }

    private void C(View view) {
        if (this.ajM != null && this.mContext != null) {
            k.jQ(this.ajM.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.ajM, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.ajM.getFid()));
            addLocateParam.setForumName(this.ajM.rD());
            addLocateParam.setJumpToCommentArea(true);
            if (this.ajM.so() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.anM);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
            ak akVar = new ak("c12291");
            akVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(akVar);
            if (this.anO != null) {
                this.anO.onClick(view);
            }
        }
    }

    protected void D(View view) {
        int i = 1;
        if (ax.aV(this.mContext) && this.ajM != null) {
            if (this.ajM.sM() != 0) {
                this.ajM.ca(this.ajM.sL() - 1);
                this.ajM.bZ(0);
                if (this.ann != null) {
                    aj.i(this.ann, d.C0082d.cp_cont_j);
                }
            } else {
                this.ajM.bZ(1);
                this.ajM.ca(this.ajM.sL() + 1);
                if (this.ann != null) {
                    aj.i(this.ann, d.C0082d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.ajM);
            if (this.ano != null && i == 0) {
                this.ano.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.ajM.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.anL > 0) {
                httpMessage.addParam("forum_id", this.ajM.getFid());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            ak akVar = new ak("c12003");
            akVar.ac("tid", this.ajM.getTid());
            if (this.ajM.getThreadType() == 40) {
                akVar.ac("obj_param1", "2");
            } else if (this.ajM.getThreadType() == 0) {
                akVar.ac("obj_param1", "1");
            }
            akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            akVar.f(ImageViewerConfig.FORUM_ID, this.ajM.getFid());
            akVar.r("obj_locate", this.mFrom);
            akVar.r("obj_id", i);
            TiebaStatic.log(akVar);
        }
    }

    protected void E(View view) {
        if (al.fS() || ax.aV(this.mContext)) {
            wI();
            wJ();
        }
    }

    private void wI() {
        int i = 4;
        if (this.ajM != null) {
            if (this.anK != 1) {
                if (this.anK == 2) {
                    i = 5;
                } else if (this.anK == 3) {
                    i = 3;
                } else if (this.anK == 4) {
                    i = 2;
                } else if (this.anK != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new ak("c12386").f(ImageViewerConfig.FORUM_ID, this.ajM.getFid()).ac("tid", this.ajM.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void wJ() {
        if (this.ajM != null && this.mContext != null) {
            String valueOf = String.valueOf(this.ajM.getFid());
            String rD = this.ajM.rD();
            String title = this.ajM.getTitle();
            String tid = this.ajM.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajM);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.ajM.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.auC = str2;
            dVar.linkUrl = str;
            dVar.aaM = this.anK;
            dVar.extData = tid;
            dVar.auF = 3;
            dVar.fid = valueOf;
            dVar.aux = rD;
            dVar.tid = tid;
            dVar.auu = true;
            dVar.auE = getShareObjSource();
            dVar.auG = b(this.ajM);
            if (parse != null) {
                dVar.auz = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.ajM);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.auF);
            bundle.putInt("obj_type", dVar.auG);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aaM);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.ajM.getThreadType() == 49 || this.ajM.getThreadType() == 60);
            if (this.anT == null) {
                this.anT = new com.baidu.tieba.d.c(this.mContext);
            }
            this.anT.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.anK == 1) {
            return 5;
        }
        if (this.anK != 3) {
            if (this.anK == 4) {
                return 4;
            }
            if (this.anK != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.rI() == null) {
            return null;
        }
        ArrayList<MediaData> rI = bdVar.rI();
        int size = rI.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rI.get(i);
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
            if (bdVar.rA()) {
                return 4;
            }
            if (bdVar.ru() == 1) {
                return 3;
            }
            return bdVar.sE() ? 2 : 1;
        }
        return 0;
    }

    private void F(View view) {
        wK();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.anD = z;
        if (this.anl != null) {
            this.anl.setClickable(this.anD);
        }
    }

    public boolean isMoreViewVisible() {
        return this.anx != null && this.anx.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.anL = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajM = bdVar;
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        setVisibility(this.anA ? 0 : 8);
        return this.anA;
    }

    protected void c(bd bdVar) {
        this.anl.setVisibility(8);
    }

    private void d(bd bdVar) {
        String s;
        if (this.anm != null && bdVar != null) {
            if (bdVar.rr() <= 0 || !this.anC) {
                this.anm.setVisibility(8);
                return;
            }
            this.anm.setVisibility(0);
            if (this.mFrom == 3) {
                s = am.q(bdVar.rr());
            } else {
                s = am.s(bdVar.rr() * 1000);
            }
            this.anm.setText(s);
            this.anA = true;
        }
    }

    protected void e(bd bdVar) {
        if (this.anq != null && bdVar != null) {
            if (this.anH) {
                this.ans.setVisibility(0);
                if (this.ans.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ans.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.ans.setLayoutParams(layoutParams);
                }
                if (bdVar.rp() > 0) {
                    this.anq.setVisibility(0);
                    String A = am.A(bdVar.rp());
                    if (this.anE) {
                        this.anq.setText(A);
                    } else {
                        this.anq.setText(String.format(this.mContext.getString(d.j.reply_num_tip), A));
                    }
                    this.anq.setContentDescription(this.mContext.getString(d.j.reply_num) + A);
                    this.anA = true;
                    return;
                } else if (this.anE) {
                    this.anq.setText(this.mContext.getString(d.j.action_comment_default));
                    this.anq.setVisibility(0);
                    this.anA = true;
                    return;
                } else {
                    this.anq.setVisibility(8);
                    return;
                }
            }
            this.ans.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.anp != null && this.ano != null && this.ann != null && bdVar != null) {
            if (this.anB) {
                this.anp.setVisibility(0);
                if (this.anp.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anp.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.anp.setLayoutParams(layoutParams);
                }
                int sL = bdVar.sL();
                String string = this.mContext.getString(d.j.action_praise_default);
                if (sL > 0) {
                    string = am.A(sL);
                }
                this.ann.setText(string);
                this.ann.setContentDescription(this.mContext.getString(d.j.zan_num) + sL);
                this.anA = true;
                if (bdVar.sM() != 0) {
                    this.anP = d.f.icon_home_card_like_s;
                    this.ano.setImageDrawable(aj.getDrawable(this.anP));
                    if (this.ann != null) {
                        aj.i(this.ann, d.C0082d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.anP = d.f.icon_home_card_like_n;
                this.ano.setImageDrawable(aj.getDrawable(this.anP));
                if (this.ann != null) {
                    aj.i(this.ann, d.C0082d.cp_cont_j);
                    return;
                }
                return;
            }
            this.anp.setVisibility(8);
        }
    }

    protected void f(bd bdVar) {
        if (this.anv != null && this.ant != null && bdVar != null) {
            if (this.anJ) {
                this.anv.setVisibility(0);
                if (this.anv.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anv.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.anv.setLayoutParams(layoutParams);
                }
                long sN = bdVar.sN();
                if ((bdVar.sD() || bdVar.sG()) && bdVar.rQ() != null) {
                    sN = bdVar.rQ().share_info.share_count;
                }
                this.ant.setText(sN > 0 ? am.A(sN) : this.mContext.getString(d.j.share));
                this.anA = true;
                return;
            }
            this.anv.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.anx != null) {
            if (this.ajM == null || v.w(this.ajM.sA()) || !TbadkCoreApplication.isLogin() || this.ajM.sB()) {
                this.anx.setVisibility(8);
                return;
            }
            if (this.anx.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anx.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.width = 0;
                this.anx.setLayoutParams(layoutParams);
            }
            if (this.any == null) {
                this.any = new ArrayList();
            } else {
                this.any.clear();
            }
            if (this.anz == null) {
                this.anz = new ArrayList();
            } else {
                this.anz.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.ajM.sA()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.any.add(reportInfo.info);
                    this.anz.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.anx.setOnClickListener(this);
                this.anx.setVisibility(0);
                return;
            }
            this.anx.setVisibility(8);
        }
    }

    private void wK() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.j.operation);
            bVar.a(this.any, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.anz, i);
                    if (!StringUtils.isNull(str)) {
                        av.vL().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.to();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.anl, d.C0082d.cp_cont_d);
        aj.i(this.anm, d.C0082d.cp_cont_j);
        aj.i(this.ann, d.f.selector_comment_and_prise_item_text_color);
        aj.i(this.anq, d.f.selector_comment_and_prise_item_text_color);
        aj.i(this.ant, d.f.selector_comment_and_prise_item_text_color);
        if (this.ajM != null && this.ajM.sM() == 1 && this.ann != null) {
            aj.i(this.ann, d.C0082d.cp_cont_h);
            this.anP = d.f.icon_home_card_like_s;
        }
        aj.j(this.anw, d.f.btn_frs_more_selector);
        if (this.ann != null && this.anF && this.anP > 0) {
            this.ano.setImageDrawable(aj.getDrawable(this.anP));
        }
        if (this.anq != null && this.anE && this.anQ > 0) {
            this.anr.setImageDrawable(aj.getDrawable(this.anQ));
        }
        if (this.ant != null) {
            this.anu.setImageDrawable(aj.getDrawable(this.anR));
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.anO = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.anl;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anU != null) {
            this.anU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anU);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.anI = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.anC = z;
    }

    public View getCommentNumView() {
        return this.anq;
    }

    public View getCommentContainer() {
        return this.ans;
    }

    protected Animation getScaleAnimation() {
        if (this.anS == null) {
            this.anS = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.anS.setDuration(200L);
        }
        return this.anS;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.anE = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.anF = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.anG = z;
    }

    public void setShareVisible(boolean z) {
    }
}
