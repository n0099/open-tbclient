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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.o.ap;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout implements View.OnClickListener {
    public int abW;
    protected bd alf;
    protected ImageView aoA;
    protected View aoB;
    protected TextView aoC;
    protected FrameLayout aoD;
    private List<CharSequence> aoE;
    private List<String> aoF;
    protected TextView aoG;
    protected ImageView aoH;
    protected View aoI;
    private ac aoJ;
    protected boolean aoK;
    protected boolean aoL;
    private boolean aoM;
    protected boolean aoN;
    protected boolean aoO;
    private boolean aoP;
    protected boolean aoQ;
    protected boolean aoR;
    private boolean aoS;
    protected boolean aoT;
    protected boolean aoU;
    private int aoV;
    private int aoW;
    private String aoX;
    private View.OnClickListener aoY;
    protected int aoZ;
    protected int aoq;
    protected TextView aor;
    private TextView aos;
    protected TextView aot;
    protected ImageView aou;
    protected View aov;
    protected TextView aow;
    protected ImageView aox;
    protected View aoy;
    protected TextView aoz;
    protected int apa;
    protected int apb;
    protected ScaleAnimation apc;
    private CustomMessageListener apd;
    protected Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.aoX = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setShareReportFrom(int i) {
        this.aoV = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aoq = 0;
        this.aoK = false;
        this.aoL = true;
        this.aoM = true;
        this.aoN = true;
        this.aoO = false;
        this.aoP = false;
        this.aoQ = false;
        this.aoR = true;
        this.aoS = false;
        this.aoT = true;
        this.aoU = false;
        this.mFrom = 2;
        this.aoV = 1;
        this.apd = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.alf != null && ThreadCommentAndPraiseInfoLayout.this.alf.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.rE() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.alf.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.alf.rE() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.alf.rE().setNum(bdVar.rE().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.alf);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoq = 0;
        this.aoK = false;
        this.aoL = true;
        this.aoM = true;
        this.aoN = true;
        this.aoO = false;
        this.aoP = false;
        this.aoQ = false;
        this.aoR = true;
        this.aoS = false;
        this.aoT = true;
        this.aoU = false;
        this.mFrom = 2;
        this.aoV = 1;
        this.apd = new CustomMessageListener(2004004) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd) && ThreadCommentAndPraiseInfoLayout.this.alf != null && ThreadCommentAndPraiseInfoLayout.this.alf.getId() != null) {
                    bd bdVar = (bd) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(bdVar.getId()) && bdVar.rE() != null && bdVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.alf.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.alf.rE() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.alf.rE().setNum(bdVar.rE().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.updatePraiseNum(ThreadCommentAndPraiseInfoLayout.this.alf);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.aoq = l.e(this.mContext, d.e.tbds84);
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aor = (TextView) inflate.findViewById(d.g.thread_info_bar_name);
        this.aos = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.aow = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.aox = (ImageView) inflate.findViewById(d.g.thread_info_commont_img);
        this.aoy = inflate.findViewById(d.g.thread_info_commont_container);
        this.aoz = (TextView) inflate.findViewById(d.g.share_num);
        this.aoA = (ImageView) inflate.findViewById(d.g.share_num_img);
        this.aoB = inflate.findViewById(d.g.share_num_container);
        this.aoC = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.aoD = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        this.aot = (TextView) inflate.findViewById(d.g.thread_info_praise_num);
        this.aou = (ImageView) inflate.findViewById(d.g.thread_info_praise_img);
        this.aov = inflate.findViewById(d.g.agree_view_container);
        this.aoI = inflate.findViewById(d.g.manage_view_container);
        this.aoG = (TextView) inflate.findViewById(d.g.thread_info_manage_text);
        this.aoH = (ImageView) inflate.findViewById(d.g.thread_info_manage_img);
        this.aov.setOnClickListener(this);
        this.aoy.setOnClickListener(this);
        this.aoB.setOnClickListener(this);
        this.aoI.setOnClickListener(this);
        this.apb = d.f.icon_home_card_share;
        this.apa = d.f.icon_home_card_comment;
        this.aoW = 1;
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.aor) {
            C(view2);
        } else if (view2 == this.aoy) {
            D(view2);
        } else if (view2 == this.aov) {
            E(view2);
        } else if (view2 == this.aoB) {
            F(view2);
        } else if (view2 == this.aoD) {
            H(view2);
        } else if (view2 == this.aoI) {
            G(view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aoJ != null) {
            this.aoJ.destory();
        }
    }

    public void setCommentClickable(boolean z) {
        if (this.aoy != null) {
            this.aoy.setClickable(z);
            this.aox.setEnabled(z);
        }
    }

    public void setAgreeClickable(boolean z) {
        if (this.aov != null) {
            this.aov.setClickable(z);
            this.aou.setEnabled(z);
        }
    }

    public void setShareClickable(boolean z) {
        if (this.aoB != null) {
            this.aoB.setEnabled(z);
            this.aoA.setEnabled(z);
        }
    }

    private void C(View view2) {
        if (this.alf != null && !StringUtils.isNull(this.alf.rU())) {
            if (StringUtils.isNull(this.mStType) || StringUtils.isNull(this.aoX)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.alf.rU(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.alf.rU(), this.mStType, this.aoX)));
            }
            if (this.aoY != null) {
                this.aoY.onClick(view2);
            }
        }
    }

    private void D(View view2) {
        if (this.alf != null && this.mContext != null) {
            o.ky(this.alf.getTid());
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.alf, null, this.mStType, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.alf.getFid()));
            addLocateParam.setForumName(this.alf.rU());
            addLocateParam.setJumpToCommentArea(true);
            if (this.alf.sD() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.abW);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            al alVar = new al("c12291");
            alVar.r("obj_locate", this.mFrom);
            TiebaStatic.log(alVar);
            al alVar2 = new al("c12942");
            alVar2.r("obj_locate", this.mFrom);
            alVar2.r("obj_type", getThreadType());
            alVar2.ac("tid", this.alf.getTid());
            TiebaStatic.log(alVar2);
            if (this.aoY != null) {
                this.aoY.onClick(view2);
            }
        }
    }

    private int getThreadType() {
        if (this.alf == null) {
            return 0;
        }
        if (this.alf.isShareThread) {
            return 4;
        }
        if (this.alf.getThreadType() == 49) {
            return 5;
        }
        if (this.alf.sg() != null) {
            return 1;
        }
        if (this.alf.getType() == bd.ZH || this.alf.getType() == bd.ZJ) {
            if (v.v(this.alf.sd()) > 0) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    protected void E(View view2) {
        int i = 1;
        if (az.aK(this.mContext) && this.alf != null) {
            if (this.alf.sZ() != 0) {
                this.alf.bX(this.alf.sY() - 1);
                this.alf.bW(0);
                if (this.aot != null) {
                    ak.h(this.aot, d.C0126d.cp_cont_j);
                }
            } else {
                this.alf.bW(1);
                this.alf.bX(this.alf.sY() + 1);
                if (this.aot != null) {
                    ak.h(this.aot, d.C0126d.cp_cont_h);
                }
                i = 0;
            }
            updatePraiseNum(this.alf);
            if (this.aou != null && i == 0) {
                this.aou.startAnimation(getScaleAnimation());
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.alf.getTid());
            httpMessage.addParam("op_type", i);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            if (this.aoW > 0) {
                httpMessage.addParam("forum_id", this.alf.getFid());
            }
            if (this.mPageContext != null) {
                httpMessage.setTag(this.mPageContext.getUniqueId());
            }
            MessageManager.getInstance().sendMessage(httpMessage);
            al alVar = new al("c12003");
            alVar.ac("tid", this.alf.getTid());
            if (this.alf.getThreadType() == 40) {
                alVar.ac("obj_param1", "2");
            } else if (this.alf.getThreadType() == 0) {
                alVar.ac("obj_param1", "1");
            }
            alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
            alVar.f(ImageViewerConfig.FORUM_ID, this.alf.getFid());
            alVar.r("obj_locate", this.mFrom);
            alVar.r(VideoPlayActivityConfig.OBJ_ID, i);
            TiebaStatic.log(alVar);
        }
    }

    protected void F(View view2) {
        if (ap.fz() || az.aK(this.mContext)) {
            xb();
            xc();
        }
    }

    private void xb() {
        int i = 4;
        if (this.alf != null) {
            if (this.aoV != 1) {
                if (this.aoV == 2) {
                    i = 5;
                } else if (this.aoV == 3) {
                    i = 3;
                } else if (this.aoV == 4) {
                    i = 2;
                } else if (this.aoV != 6) {
                    i = 0;
                } else {
                    i = 8;
                }
            }
            TiebaStatic.log(new al("c12386").f(ImageViewerConfig.FORUM_ID, this.alf.getFid()).ac("tid", this.alf.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", i));
        }
    }

    private void xc() {
        if (this.alf != null && this.mContext != null) {
            String valueOf = String.valueOf(this.alf.getFid());
            String rU = this.alf.rU();
            String title = this.alf.getTitle();
            String tid = this.alf.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.alf);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.alf.getAbstract();
            String format = MessageFormat.format(getResources().getString(d.k.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.awZ = str2;
            dVar.linkUrl = str;
            dVar.abV = this.aoV;
            dVar.extData = tid;
            dVar.axc = 3;
            dVar.fid = valueOf;
            dVar.awU = rU;
            dVar.tid = tid;
            dVar.awR = true;
            dVar.axb = getShareObjSource();
            dVar.axd = b(this.alf);
            if (parse != null) {
                dVar.awW = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.alf);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.axc);
            bundle.putInt("obj_type", dVar.axd);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.abV);
            dVar.f(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true, true);
            shareDialogConfig.setIsAlaLive(this.alf.getThreadType() == 49 || this.alf.getThreadType() == 60);
            com.baidu.tieba.d.d.ahh().a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        if (this.aoV == 1) {
            return 5;
        }
        if (this.aoV != 3) {
            if (this.aoV == 4) {
                return 4;
            }
            if (this.aoV != 6) {
                return 0;
            }
            return 8;
        }
        return 3;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.rZ() == null) {
            return null;
        }
        ArrayList<MediaData> rZ = bdVar.rZ();
        int size = rZ.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rZ.get(i);
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
            if (bdVar.rR()) {
                return 4;
            }
            if (bdVar.rM() == 1) {
                return 3;
            }
            return bdVar.sR() ? 2 : 1;
        }
        return 0;
    }

    private void G(View view2) {
        if (this.aoJ == null) {
            this.aoJ = new ac(this.mPageContext);
        }
        this.aoJ.setData(this.alf);
        com.baidu.adp.lib.g.g.a(this.aoJ, this.mPageContext);
        TiebaStatic.log(new al("c12711"));
    }

    private void H(View view2) {
        xf();
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aoN = z;
        if (this.aor != null) {
            this.aor.setClickable(this.aoN);
        }
    }

    public boolean isMoreViewVisible() {
        return this.aoD != null && this.aoD.getVisibility() == 0;
    }

    public void setMultiForumCount(int i) {
        if (i >= 0) {
            this.aoW = i;
        }
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.alf = bdVar;
        xd();
        c(bdVar);
        d(bdVar);
        updatePraiseNum(bdVar);
        e(bdVar);
        f(bdVar);
        g(bdVar);
        setVisibility(this.aoK ? 0 : 8);
        return this.aoK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xd() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(bd bdVar) {
        this.aor.setVisibility(8);
    }

    private void d(bd bdVar) {
        String t;
        if (this.aos != null && bdVar != null) {
            if (bdVar.rJ() <= 0 || !this.aoM) {
                this.aos.setVisibility(8);
                return;
            }
            this.aos.setVisibility(0);
            if (this.mFrom == 3) {
                t = an.r(bdVar.rJ());
            } else {
                t = an.t(bdVar.rJ() * 1000);
            }
            this.aos.setText(t);
            this.aoK = true;
        }
    }

    public boolean isVisible() {
        return this.aoK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(bd bdVar) {
        if (this.aow != null && bdVar != null) {
            if (this.aoR) {
                this.aoy.setVisibility(0);
                if (this.aoy.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoy.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aoy.setLayoutParams(layoutParams);
                }
                if (bdVar.rH() > 0) {
                    this.aow.setVisibility(0);
                    String B = an.B(bdVar.rH());
                    if (this.aoO) {
                        this.aox.setImageDrawable(ak.getDrawable(this.apa));
                        this.aow.setText(B);
                    } else {
                        this.aow.setText(String.format(this.mContext.getString(d.k.reply_num_tip), B));
                    }
                    this.aow.setContentDescription(this.mContext.getString(d.k.reply_num) + B);
                    this.aoK = true;
                    return;
                } else if (this.aoO) {
                    this.aox.setImageDrawable(ak.getDrawable(this.apa));
                    this.aow.setText(this.mContext.getString(d.k.action_comment_default));
                    this.aow.setVisibility(0);
                    this.aoK = true;
                    return;
                } else {
                    this.aow.setVisibility(8);
                    return;
                }
            }
            this.aoy.setVisibility(8);
        }
    }

    public void updatePraiseNum(bd bdVar) {
        if (this.aov != null && this.aou != null && this.aot != null && bdVar != null) {
            if (this.aoL) {
                this.aov.setVisibility(0);
                if (this.aov.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aov.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aov.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aou.getLayoutParams();
                layoutParams2.leftMargin = 0;
                this.aou.setLayoutParams(layoutParams2);
                int sY = bdVar.sY();
                String string = this.mContext.getString(d.k.action_praise_default);
                if (sY > 0) {
                    string = an.B(sY);
                }
                this.aot.setText(string);
                this.aot.setContentDescription(this.mContext.getString(d.k.zan_num) + sY);
                this.aoK = true;
                if (bdVar.sZ() != 0) {
                    this.aoZ = xe() ? d.f.icon_home_card_like_s_xmas : d.f.icon_home_card_like_s;
                    this.aou.setImageDrawable(ak.getDrawable(this.aoZ));
                    if (this.aot != null) {
                        ak.h(this.aot, d.C0126d.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.aoZ = xe() ? d.f.icon_home_card_like_n_xmas : d.f.icon_home_card_like_n;
                this.aou.setImageDrawable(ak.getDrawable(this.aoZ));
                if (this.aot != null) {
                    ak.h(this.aot, d.C0126d.cp_cont_j);
                    return;
                }
                return;
            }
            this.aov.setVisibility(8);
        }
    }

    private boolean xe() {
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        return activitySwitch != null && activitySwitch.yd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(bd bdVar) {
        if (this.aoB != null && this.aoz != null && bdVar != null) {
            if (this.aoT) {
                this.aoB.setVisibility(0);
                if (this.aoB.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoB.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aoB.setLayoutParams(layoutParams);
                }
                long ta = bdVar.ta();
                if ((bdVar.sQ() || bdVar.sT()) && bdVar.sh() != null) {
                    ta = bdVar.sh().share_info.share_count;
                }
                this.aoz.setText(ta > 0 ? an.B(ta) : this.mContext.getString(d.k.share));
                this.aoK = true;
                if (bdVar.abM != null && bdVar.abM.isDeleted) {
                    ak.i(this.aoA, d.f.icon_card_share_d);
                    ak.h(this.aoz, d.C0126d.cp_cont_e);
                    setShareClickable(false);
                    return;
                }
                ak.i(this.aoA, this.apb);
                ak.h(this.aoz, d.f.selector_comment_and_prise_item_text_color);
                setShareClickable(true);
                return;
            }
            this.aoB.setVisibility(8);
        }
    }

    public void updataMoreView(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        if (this.aoD != null) {
            if (this.alf == null || v.w(this.alf.sN()) || !TbadkCoreApplication.isLogin() || this.alf.sO()) {
                this.aoD.setVisibility(8);
                return;
            }
            if (this.aoD.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoD.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                this.aoD.setLayoutParams(layoutParams);
            }
            if (this.aoE == null) {
                this.aoE = new ArrayList();
            } else {
                this.aoE.clear();
            }
            if (this.aoF == null) {
                this.aoF = new ArrayList();
            } else {
                this.aoF.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.alf.sN()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aoE.add(reportInfo.info);
                    this.aoF.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aoD.setOnClickListener(this);
                this.aoD.setVisibility(0);
                return;
            }
            this.aoD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(bd bdVar) {
        if (this.aoI != null && bdVar != null) {
            if (this.aoU) {
                this.aoI.setVisibility(0);
                if (this.aoI.getLayoutParams() != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoI.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                    this.aoI.setLayoutParams(layoutParams);
                }
                String string = this.mContext.getString(d.k.manage);
                this.aoG.setText(string);
                this.aoG.setContentDescription(string);
                this.aoK = true;
                return;
            }
            this.aoI.setVisibility(8);
        }
    }

    private void xf() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cd(d.k.operation);
            bVar.a(this.aoE, new b.InterfaceC0086b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayout.this.aoF, i);
                    if (!StringUtils.isNull(str)) {
                        ax.wf().c(ThreadCommentAndPraiseInfoLayout.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tF();
        }
    }

    public void onChangeSkinType() {
        ak.h(this.aor, d.C0126d.cp_cont_d);
        ak.h(this.aos, d.C0126d.cp_cont_j);
        ak.h(this.aot, d.f.selector_comment_and_prise_item_text_color);
        ak.h(this.aow, d.f.selector_comment_and_prise_item_text_color);
        ak.h(this.aoG, d.f.selector_comment_and_prise_item_text_color);
        ak.i(this.aoC, d.f.btn_frs_more_selector);
        if (this.alf != null && this.alf.sZ() == 1 && this.aot != null) {
            ak.h(this.aot, d.C0126d.cp_cont_h);
            this.aoZ = d.f.icon_home_card_like_s;
        }
        if (this.aot != null && this.aoP && this.aoZ > 0) {
            this.aou.setImageDrawable(ak.getDrawable(this.aoZ));
        }
        if (this.aow != null && this.aoO && this.apa > 0) {
            this.aox.setImageDrawable(ak.getDrawable(this.apa));
        }
        if (this.alf != null && this.alf.abM != null && this.alf.abM.isDeleted) {
            ak.i(this.aoA, d.f.icon_card_share_d);
            ak.h(this.aoz, d.C0126d.cp_cont_e);
            setShareClickable(false);
        } else {
            ak.i(this.aoA, this.apb);
            ak.h(this.aoz, d.f.selector_comment_and_prise_item_text_color);
            setShareClickable(true);
        }
        if (this.aoH != null) {
            this.aoH.setImageDrawable(ak.getDrawable(d.f.icon_card_frs_manage_selector));
        }
        if (this.aoJ != null) {
            this.aoJ.onChangeSkinType();
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aoY = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aor;
    }

    public void registPraiseNumSynchronizeListener(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.apd != null) {
            this.apd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.apd);
        }
    }

    public void setCommentNumEnable(boolean z) {
    }

    public void setLiveShareEnable(boolean z) {
        this.aoS = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aoM = z;
    }

    public View getCommentNumView() {
        return this.aow;
    }

    public View getCommentContainer() {
        return this.aoy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Animation getScaleAnimation() {
        if (this.apc == null) {
            this.apc = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.apc.setDuration(200L);
        }
        return this.apc;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aoO = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.aoP = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.aoQ = z;
    }

    public void setShareVisible(boolean z) {
    }

    public void setManageVisible(boolean z) {
        this.aoU = z;
    }
}
