package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.ReportInfo;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private bl akj;
    private TbPageContext alI;
    private boolean aoA;
    private boolean aoB;
    private boolean aoC;
    private boolean aoD;
    private boolean aoE;
    private String aoF;
    private View.OnClickListener aoG;
    private int aoH;
    private int aoI;
    private int aoJ;
    private int aoK;
    private ScaleAnimation aoL;
    private View.OnClickListener aoM;
    private View.OnClickListener aoN;
    private View.OnClickListener aoO;
    private CustomMessageListener aoP;
    private TextView aoe;
    private TextView aof;
    private View aog;
    private TextView aoh;
    private TextView aoi;
    private ImageView aoj;
    private View aok;
    private TextView aol;
    private TextView aom;
    private TextView aon;
    private TextView aoo;
    private TextView aop;
    private FrameLayout aoq;
    private List<CharSequence> aor;
    private List<String> aos;
    private boolean aot;
    private boolean aou;
    private boolean aov;
    private boolean aow;
    private boolean aox;
    private boolean aoy;
    private boolean aoz;
    private Context mContext;
    private int mFrom;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.aoF = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aot = false;
        this.aou = false;
        this.aov = false;
        this.aow = true;
        this.aox = true;
        this.aoy = false;
        this.aoz = false;
        this.aoA = false;
        this.aoB = true;
        this.aoC = true;
        this.aoD = false;
        this.aoE = false;
        this.mFrom = 2;
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayout.this.akj != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.akj.rK())) {
                    if (StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.mStType) || StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.aoF)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createNormalCfg(ThreadCommentAndPraiseInfoLayout.this.akj.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createCfgForpersonalized(ThreadCommentAndPraiseInfoLayout.this.akj.rK(), ThreadCommentAndPraiseInfoLayout.this.mStType, ThreadCommentAndPraiseInfoLayout.this.aoF)));
                    }
                    if (ThreadCommentAndPraiseInfoLayout.this.aoG != null) {
                        ThreadCommentAndPraiseInfoLayout.this.aoG.onClick(view);
                    }
                }
            }
        };
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (aw.aO(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.akj != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.akj.sT() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.akj.bZ(ThreadCommentAndPraiseInfoLayout.this.akj.sS() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.akj.bY(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.aoi != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.aoi, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.akj.bY(1);
                        ThreadCommentAndPraiseInfoLayout.this.akj.bZ(ThreadCommentAndPraiseInfoLayout.this.akj.sS() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.aoi != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.aoi, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.akj);
                    if (ThreadCommentAndPraiseInfoLayout.this.aoj != null) {
                        ThreadCommentAndPraiseInfoLayout.this.aoj.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.akj.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.akj.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        };
        this.aoO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.xi();
            }
        };
        this.aoP = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl) && ThreadCommentAndPraiseInfoLayout.this.akj != null && ThreadCommentAndPraiseInfoLayout.this.akj.getId() != null) {
                    bl blVar = (bl) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(blVar.getId()) && blVar.rv() != null && blVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.akj.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.akj.rv() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.akj.rv().setNum(blVar.rv().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.akj);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aot = false;
        this.aou = false;
        this.aov = false;
        this.aow = true;
        this.aox = true;
        this.aoy = false;
        this.aoz = false;
        this.aoA = false;
        this.aoB = true;
        this.aoC = true;
        this.aoD = false;
        this.aoE = false;
        this.mFrom = 2;
        this.aoM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayout.this.akj != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.akj.rK())) {
                    if (StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.mStType) || StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.aoF)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createNormalCfg(ThreadCommentAndPraiseInfoLayout.this.akj.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createCfgForpersonalized(ThreadCommentAndPraiseInfoLayout.this.akj.rK(), ThreadCommentAndPraiseInfoLayout.this.mStType, ThreadCommentAndPraiseInfoLayout.this.aoF)));
                    }
                    if (ThreadCommentAndPraiseInfoLayout.this.aoG != null) {
                        ThreadCommentAndPraiseInfoLayout.this.aoG.onClick(view);
                    }
                }
            }
        };
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (aw.aO(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.akj != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.akj.sT() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.akj.bZ(ThreadCommentAndPraiseInfoLayout.this.akj.sS() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.akj.bY(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.aoi != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.aoi, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.akj.bY(1);
                        ThreadCommentAndPraiseInfoLayout.this.akj.bZ(ThreadCommentAndPraiseInfoLayout.this.akj.sS() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.aoi != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.aoi, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.akj);
                    if (ThreadCommentAndPraiseInfoLayout.this.aoj != null) {
                        ThreadCommentAndPraiseInfoLayout.this.aoj.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.akj.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.akj.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        };
        this.aoO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.xi();
            }
        };
        this.aoP = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl) && ThreadCommentAndPraiseInfoLayout.this.akj != null && ThreadCommentAndPraiseInfoLayout.this.akj.getId() != null) {
                    bl blVar = (bl) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(blVar.getId()) && blVar.rv() != null && blVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.akj.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.akj.rv() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.akj.rv().setNum(blVar.rv().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.akj);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aoe = (TextView) inflate.findViewById(d.h.thread_info_bar_name);
        this.aof = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.aog = inflate.findViewById(d.h.frs_item_location_sep);
        this.aoh = (TextView) inflate.findViewById(d.h.frs_item_location_address);
        this.aoi = (TextView) inflate.findViewById(d.h.thread_info_praise_num);
        this.aol = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.aom = (TextView) inflate.findViewById(d.h.thread_info_share_num);
        this.aon = (TextView) inflate.findViewById(d.h.thread_info_audience_num);
        this.aoo = (TextView) inflate.findViewById(d.h.thread_info_view_num);
        this.aop = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.aoq = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        this.mContext = context;
        this.aoj = (ImageView) inflate.findViewById(d.h.thread_info_praise_img);
        this.aok = inflate.findViewById(d.h.agree_view_container);
        this.aok.setOnClickListener(this.aoN);
        this.aol.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayout.this.akj != null && ThreadCommentAndPraiseInfoLayout.this.mContext != null) {
                    PbActivityConfig addLocateParam = new PbActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createFromThreadCfg(ThreadCommentAndPraiseInfoLayout.this.akj, null, com.baidu.tieba.card.m.rw(), 0, true, false, false).addLocateParam("");
                    addLocateParam.setForumId(String.valueOf(ThreadCommentAndPraiseInfoLayout.this.akj.getFid()));
                    addLocateParam.setForumName(ThreadCommentAndPraiseInfoLayout.this.akj.rK());
                    addLocateParam.setJumpToCommentArea(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
                    aj ajVar = new aj("c12291");
                    ajVar.r("obj_locate", ThreadCommentAndPraiseInfoLayout.this.mFrom);
                    TiebaStatic.log(ajVar);
                }
            }
        });
    }

    public void setShowPraiseNum(boolean z) {
        this.aov = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aox = z;
        if (this.aoe != null) {
            this.aoe.setClickable(this.aox);
        }
    }

    public boolean xh() {
        return this.aoq != null && this.aoq.getVisibility() == 0;
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.akj = blVar;
        b(blVar);
        c(blVar);
        d(blVar);
        i(blVar);
        h(blVar);
        e(blVar);
        f(blVar);
        g(blVar);
        setVisibility(this.aot ? 0 : 8);
        return this.aot;
    }

    private void b(bl blVar) {
        if (this.aoe != null && blVar != null) {
            if (!StringUtils.isNull(blVar.rK()) && this.aoB) {
                this.aoe.setVisibility(0);
                String d = al.d(blVar.rK(), 14, "...");
                String string = getContext().getString(d.l.chosen_pb_original_bar, d);
                if (al.dY(d) > 14) {
                    this.aoe.setText(d);
                } else {
                    this.aoe.setText(string);
                }
                this.aoe.setContentDescription(string);
                this.aoe.setOnClickListener(this.aoM);
                this.aoe.setClickable(this.aox);
                this.aot = true;
                return;
            }
            this.aoe.setVisibility(8);
        }
    }

    private void c(bl blVar) {
        String s;
        if (this.aof != null && blVar != null) {
            if (blVar.rz() <= 0 || !this.aow) {
                this.aof.setVisibility(8);
                return;
            }
            this.aof.setVisibility(0);
            if (this.mFrom == 3) {
                s = al.p(blVar.rz());
            } else {
                s = al.s(blVar.rz() * 1000);
            }
            this.aof.setText(s);
            this.aot = true;
        }
    }

    private void d(bl blVar) {
        if (this.aoh != null && this.aog != null && blVar != null) {
            if (this.aou && !blVar.sk() && !StringUtils.isNull(blVar.getAddress())) {
                this.aoh.setVisibility(0);
                if (blVar.rz() <= 0) {
                    this.aog.setVisibility(8);
                } else {
                    this.aog.setVisibility(0);
                }
                this.aoh.setText(blVar.getAddress());
                this.aot = true;
                return;
            }
            this.aoh.setVisibility(8);
            this.aog.setVisibility(8);
        }
    }

    private void e(bl blVar) {
        if (this.aol != null && blVar != null) {
            if (this.aoC) {
                if (blVar.rx() > 0) {
                    this.aol.setVisibility(0);
                    String v = al.v(blVar.rx());
                    if (this.aoz) {
                        this.aol.setText(v);
                    } else {
                        this.aol.setText(String.format(this.mContext.getString(d.l.reply_num_tip), v));
                    }
                    this.aol.setContentDescription(this.mContext.getString(d.l.reply_num) + v);
                    this.aot = true;
                    return;
                } else if (this.aoz) {
                    this.aol.setText("0");
                    this.aol.setVisibility(0);
                    this.aot = true;
                    return;
                } else {
                    this.aol.setVisibility(8);
                    return;
                }
            }
            this.aol.setVisibility(8);
        }
    }

    private void f(bl blVar) {
        if ((this.aom != null || blVar != null) && blVar.rX() != null) {
            if (!this.aoD) {
                this.aom.setVisibility(8);
                return;
            }
            this.aom.setText(al.v(blVar.rX().Vr.share_count));
            this.aom.setVisibility(0);
            this.aot = true;
        }
    }

    private void g(bl blVar) {
        if ((this.aon != null || blVar != null) && blVar.rX() != null) {
            if (!this.aoE) {
                this.aon.setVisibility(8);
                return;
            }
            this.aon.setText(al.v(blVar.rX().audience_count));
            this.aon.setVisibility(0);
            this.aot = true;
        }
    }

    public void h(bl blVar) {
        if (this.aoi != null && blVar != null) {
            if (this.aov) {
                this.aok.setVisibility(0);
                this.aoi.setVisibility(0);
                String v = al.v(blVar.sS());
                this.aoi.setText(v);
                this.aoi.setContentDescription(this.mContext.getString(d.l.zan_num) + v);
                this.aot = true;
                if (blVar.sT() != 0) {
                    this.aoH = d.g.icon_home_card_like_d;
                    this.aoj.setImageDrawable(ai.getDrawable(this.aoH));
                    if (this.aoi != null) {
                        ai.i(this.aoi, d.e.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.aoH = d.g.icon_home_card_like_n;
                this.aoj.setImageDrawable(ai.getDrawable(this.aoH));
                if (this.aoi != null) {
                    ai.i(this.aoi, d.e.cp_cont_d);
                    return;
                }
                return;
            }
            this.aok.setVisibility(8);
            this.aoi.setVisibility(8);
        }
    }

    private void i(bl blVar) {
        if (this.aoo != null && blVar != null) {
            if (this.aoy && blVar.ry() > 0) {
                this.aoo.setVisibility(0);
                String u = al.u(blVar.ry());
                this.aoo.setText(String.format(this.mContext.getString(d.l.view_num_tip), u));
                this.aoo.setContentDescription(this.mContext.getString(d.l.view_num) + u);
                this.aot = true;
                return;
            }
            this.aoo.setVisibility(8);
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.alI = tbPageContext;
        if (this.aoq != null) {
            if (this.akj == null || u.v(this.akj.sH()) || !TbadkCoreApplication.isLogin() || this.akj.sI()) {
                this.aoq.setVisibility(8);
                return;
            }
            if (this.aor == null) {
                this.aor = new ArrayList();
            } else {
                this.aor.clear();
            }
            if (this.aos == null) {
                this.aos = new ArrayList();
            } else {
                this.aos.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.akj.sH()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aor.add(reportInfo.info);
                    this.aos.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aoq.setOnClickListener(this.aoO);
                this.aoq.setVisibility(0);
                return;
            }
            this.aoq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        if (this.alI != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.alI.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.aor, new b.InterfaceC0043b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) u.c(ThreadCommentAndPraiseInfoLayout.this.aos, i);
                    if (!StringUtils.isNull(str)) {
                        at.wf().c(ThreadCommentAndPraiseInfoLayout.this.alI, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.alI);
            bVar.tu();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.aoe, d.e.cp_cont_d);
        ai.i(this.aof, d.e.cp_cont_d);
        ai.k(this.aog, d.e.cp_cont_d);
        ai.i(this.aoh, d.e.cp_cont_d);
        ai.i(this.aoi, d.e.cp_cont_d);
        ai.i(this.aoo, d.e.cp_cont_d);
        ai.i(this.aol, d.e.cp_cont_d);
        if (this.akj != null && this.akj.sT() == 1 && this.aoi != null) {
            ai.i(this.aoi, d.e.cp_cont_h);
            this.aoH = d.g.icon_home_card_like_d;
        }
        ai.i(this.aom, d.e.cp_cont_d);
        ai.i(this.aon, d.e.cp_cont_d);
        ai.j(this.aop, d.g.btn_frs_more_selector);
        if (this.aoi != null && this.aoA && this.aoH > 0) {
            this.aoj.setImageDrawable(ai.getDrawable(this.aoH));
        }
        if (this.aol != null && this.aoz && this.aoI > 0) {
            this.aol.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(this.aoI), (Drawable) null);
        }
        if (this.aom != null && this.aoD && this.aoJ > 0) {
            this.aom.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(this.aoJ), (Drawable) null);
        }
        if (this.aon != null && this.aoE && this.aoK > 0) {
            this.aon.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(this.aoK), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aoG = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aoe;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aoP != null) {
            this.aoP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoP);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.aou = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.aoy = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.aoC = z;
    }

    public void setLiveShareEnable(boolean z) {
        this.aoD = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.aoE = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aow = z;
    }

    public View getCommentNumView() {
        return this.aol;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.aoI = i;
        }
    }

    public void setLiveShareIcon(int i) {
        if (i > 0) {
            this.aoJ = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.aoK = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getScaleAnimation() {
        if (this.aoL == null) {
            this.aoL = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.aoL.setDuration(200L);
        }
        return this.aoL;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aoz = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.aoA = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.aoB = z;
    }
}
