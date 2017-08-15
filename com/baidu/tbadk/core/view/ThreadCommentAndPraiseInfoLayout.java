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
    private bl akl;
    private boolean aoA;
    private boolean aoB;
    private boolean aoC;
    private boolean aoD;
    private boolean aoE;
    private boolean aoF;
    private String aoG;
    private View.OnClickListener aoH;
    private int aoI;
    private int aoJ;
    private int aoK;
    private int aoL;
    private ScaleAnimation aoM;
    private View.OnClickListener aoN;
    private View.OnClickListener aoO;
    private View.OnClickListener aoP;
    private CustomMessageListener aoQ;
    private TextView aof;
    private TextView aog;
    private View aoh;
    private TextView aoi;
    private TextView aoj;
    private ImageView aok;
    private View aol;
    private TextView aom;
    private TextView aon;
    private TextView aoo;
    private TextView aop;
    private TextView aoq;
    private FrameLayout aor;
    private List<CharSequence> aos;
    private List<String> aot;
    private boolean aou;
    private boolean aov;
    private boolean aow;
    private boolean aox;
    private boolean aoy;
    private boolean aoz;
    private Context mContext;
    private int mFrom;
    private String mStType;
    private TbPageContext oV;

    public void setYuelaouLocate(String str) {
        this.aoG = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aou = false;
        this.aov = false;
        this.aow = false;
        this.aox = true;
        this.aoy = true;
        this.aoz = false;
        this.aoA = false;
        this.aoB = false;
        this.aoC = true;
        this.aoD = true;
        this.aoE = false;
        this.aoF = false;
        this.mFrom = 2;
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayout.this.akl != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.akl.rK())) {
                    if (StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.mStType) || StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.aoG)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createNormalCfg(ThreadCommentAndPraiseInfoLayout.this.akl.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createCfgForpersonalized(ThreadCommentAndPraiseInfoLayout.this.akl.rK(), ThreadCommentAndPraiseInfoLayout.this.mStType, ThreadCommentAndPraiseInfoLayout.this.aoG)));
                    }
                    if (ThreadCommentAndPraiseInfoLayout.this.aoH != null) {
                        ThreadCommentAndPraiseInfoLayout.this.aoH.onClick(view);
                    }
                }
            }
        };
        this.aoO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (aw.aO(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.akl != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.akl.sT() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.akl.bZ(ThreadCommentAndPraiseInfoLayout.this.akl.sS() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.akl.bY(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.aoj != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.aoj, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.akl.bY(1);
                        ThreadCommentAndPraiseInfoLayout.this.akl.bZ(ThreadCommentAndPraiseInfoLayout.this.akl.sS() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.aoj != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.aoj, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.akl);
                    if (ThreadCommentAndPraiseInfoLayout.this.aok != null) {
                        ThreadCommentAndPraiseInfoLayout.this.aok.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.akl.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.akl.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        };
        this.aoP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.xi();
            }
        };
        this.aoQ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl) && ThreadCommentAndPraiseInfoLayout.this.akl != null && ThreadCommentAndPraiseInfoLayout.this.akl.getId() != null) {
                    bl blVar = (bl) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(blVar.getId()) && blVar.rv() != null && blVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.akl.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.akl.rv() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.akl.rv().setNum(blVar.rv().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.akl);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aou = false;
        this.aov = false;
        this.aow = false;
        this.aox = true;
        this.aoy = true;
        this.aoz = false;
        this.aoA = false;
        this.aoB = false;
        this.aoC = true;
        this.aoD = true;
        this.aoE = false;
        this.aoF = false;
        this.mFrom = 2;
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayout.this.akl != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.akl.rK())) {
                    if (StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.mStType) || StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.aoG)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createNormalCfg(ThreadCommentAndPraiseInfoLayout.this.akl.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createCfgForpersonalized(ThreadCommentAndPraiseInfoLayout.this.akl.rK(), ThreadCommentAndPraiseInfoLayout.this.mStType, ThreadCommentAndPraiseInfoLayout.this.aoG)));
                    }
                    if (ThreadCommentAndPraiseInfoLayout.this.aoH != null) {
                        ThreadCommentAndPraiseInfoLayout.this.aoH.onClick(view);
                    }
                }
            }
        };
        this.aoO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (aw.aO(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.akl != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.akl.sT() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.akl.bZ(ThreadCommentAndPraiseInfoLayout.this.akl.sS() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.akl.bY(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.aoj != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.aoj, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.akl.bY(1);
                        ThreadCommentAndPraiseInfoLayout.this.akl.bZ(ThreadCommentAndPraiseInfoLayout.this.akl.sS() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.aoj != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.aoj, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.akl);
                    if (ThreadCommentAndPraiseInfoLayout.this.aok != null) {
                        ThreadCommentAndPraiseInfoLayout.this.aok.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.akl.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.akl.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        };
        this.aoP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.xi();
            }
        };
        this.aoQ = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl) && ThreadCommentAndPraiseInfoLayout.this.akl != null && ThreadCommentAndPraiseInfoLayout.this.akl.getId() != null) {
                    bl blVar = (bl) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(blVar.getId()) && blVar.rv() != null && blVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.akl.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.akl.rv() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.akl.rv().setNum(blVar.rv().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.akl);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aof = (TextView) inflate.findViewById(d.h.thread_info_bar_name);
        this.aog = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.aoh = inflate.findViewById(d.h.frs_item_location_sep);
        this.aoi = (TextView) inflate.findViewById(d.h.frs_item_location_address);
        this.aoj = (TextView) inflate.findViewById(d.h.thread_info_praise_num);
        this.aom = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.aon = (TextView) inflate.findViewById(d.h.thread_info_share_num);
        this.aoo = (TextView) inflate.findViewById(d.h.thread_info_audience_num);
        this.aop = (TextView) inflate.findViewById(d.h.thread_info_view_num);
        this.aoq = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.aor = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        this.mContext = context;
        this.aok = (ImageView) inflate.findViewById(d.h.thread_info_praise_img);
        this.aol = inflate.findViewById(d.h.agree_view_container);
        this.aol.setOnClickListener(this.aoO);
        this.aom.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayout.this.akl != null && ThreadCommentAndPraiseInfoLayout.this.mContext != null) {
                    PbActivityConfig addLocateParam = new PbActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createFromThreadCfg(ThreadCommentAndPraiseInfoLayout.this.akl, null, com.baidu.tieba.card.m.rw(), 0, true, false, false).addLocateParam("");
                    addLocateParam.setForumId(String.valueOf(ThreadCommentAndPraiseInfoLayout.this.akl.getFid()));
                    addLocateParam.setForumName(ThreadCommentAndPraiseInfoLayout.this.akl.rK());
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
        this.aow = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aoy = z;
        if (this.aof != null) {
            this.aof.setClickable(this.aoy);
        }
    }

    public boolean xh() {
        return this.aor != null && this.aor.getVisibility() == 0;
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.akl = blVar;
        b(blVar);
        c(blVar);
        d(blVar);
        i(blVar);
        h(blVar);
        e(blVar);
        f(blVar);
        g(blVar);
        setVisibility(this.aou ? 0 : 8);
        return this.aou;
    }

    private void b(bl blVar) {
        if (this.aof != null && blVar != null) {
            if (!StringUtils.isNull(blVar.rK()) && this.aoC) {
                this.aof.setVisibility(0);
                String d = al.d(blVar.rK(), 14, "...");
                String string = getContext().getString(d.l.chosen_pb_original_bar, d);
                if (al.dY(d) > 14) {
                    this.aof.setText(d);
                } else {
                    this.aof.setText(string);
                }
                this.aof.setContentDescription(string);
                this.aof.setOnClickListener(this.aoN);
                this.aof.setClickable(this.aoy);
                this.aou = true;
                return;
            }
            this.aof.setVisibility(8);
        }
    }

    private void c(bl blVar) {
        String s;
        if (this.aog != null && blVar != null) {
            if (blVar.rz() <= 0 || !this.aox) {
                this.aog.setVisibility(8);
                return;
            }
            this.aog.setVisibility(0);
            if (this.mFrom == 3) {
                s = al.p(blVar.rz());
            } else {
                s = al.s(blVar.rz() * 1000);
            }
            this.aog.setText(s);
            this.aou = true;
        }
    }

    private void d(bl blVar) {
        if (this.aoi != null && this.aoh != null && blVar != null) {
            if (this.aov && !blVar.sk() && !StringUtils.isNull(blVar.getAddress())) {
                this.aoi.setVisibility(0);
                if (blVar.rz() <= 0) {
                    this.aoh.setVisibility(8);
                } else {
                    this.aoh.setVisibility(0);
                }
                this.aoi.setText(blVar.getAddress());
                this.aou = true;
                return;
            }
            this.aoi.setVisibility(8);
            this.aoh.setVisibility(8);
        }
    }

    private void e(bl blVar) {
        if (this.aom != null && blVar != null) {
            if (this.aoD) {
                if (blVar.rx() > 0) {
                    this.aom.setVisibility(0);
                    String v = al.v(blVar.rx());
                    if (this.aoA) {
                        this.aom.setText(v);
                    } else {
                        this.aom.setText(String.format(this.mContext.getString(d.l.reply_num_tip), v));
                    }
                    this.aom.setContentDescription(this.mContext.getString(d.l.reply_num) + v);
                    this.aou = true;
                    return;
                } else if (this.aoA) {
                    this.aom.setText("0");
                    this.aom.setVisibility(0);
                    this.aou = true;
                    return;
                } else {
                    this.aom.setVisibility(8);
                    return;
                }
            }
            this.aom.setVisibility(8);
        }
    }

    private void f(bl blVar) {
        if ((this.aon != null || blVar != null) && blVar.rX() != null) {
            if (!this.aoE) {
                this.aon.setVisibility(8);
                return;
            }
            this.aon.setText(al.v(blVar.rX().Vt.share_count));
            this.aon.setVisibility(0);
            this.aou = true;
        }
    }

    private void g(bl blVar) {
        if ((this.aoo != null || blVar != null) && blVar.rX() != null) {
            if (!this.aoF) {
                this.aoo.setVisibility(8);
                return;
            }
            this.aoo.setText(al.v(blVar.rX().audience_count));
            this.aoo.setVisibility(0);
            this.aou = true;
        }
    }

    public void h(bl blVar) {
        if (this.aoj != null && blVar != null) {
            if (this.aow) {
                this.aol.setVisibility(0);
                this.aoj.setVisibility(0);
                String v = al.v(blVar.sS());
                this.aoj.setText(v);
                this.aoj.setContentDescription(this.mContext.getString(d.l.zan_num) + v);
                this.aou = true;
                if (blVar.sT() != 0) {
                    this.aoI = d.g.icon_home_card_like_d;
                    this.aok.setImageDrawable(ai.getDrawable(this.aoI));
                    if (this.aoj != null) {
                        ai.i(this.aoj, d.e.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.aoI = d.g.icon_home_card_like_n;
                this.aok.setImageDrawable(ai.getDrawable(this.aoI));
                if (this.aoj != null) {
                    ai.i(this.aoj, d.e.cp_cont_d);
                    return;
                }
                return;
            }
            this.aol.setVisibility(8);
            this.aoj.setVisibility(8);
        }
    }

    private void i(bl blVar) {
        if (this.aop != null && blVar != null) {
            if (this.aoz && blVar.ry() > 0) {
                this.aop.setVisibility(0);
                String u = al.u(blVar.ry());
                this.aop.setText(String.format(this.mContext.getString(d.l.view_num_tip), u));
                this.aop.setContentDescription(this.mContext.getString(d.l.view_num) + u);
                this.aou = true;
                return;
            }
            this.aop.setVisibility(8);
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.oV = tbPageContext;
        if (this.aor != null) {
            if (this.akl == null || u.v(this.akl.sH()) || !TbadkCoreApplication.isLogin() || this.akl.sI()) {
                this.aor.setVisibility(8);
                return;
            }
            if (this.aos == null) {
                this.aos = new ArrayList();
            } else {
                this.aos.clear();
            }
            if (this.aot == null) {
                this.aot = new ArrayList();
            } else {
                this.aot.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.akl.sH()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.aos.add(reportInfo.info);
                    this.aot.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.aor.setOnClickListener(this.aoP);
                this.aor.setVisibility(0);
                return;
            }
            this.aor.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        if (this.oV != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oV.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.aos, new b.InterfaceC0043b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) u.c(ThreadCommentAndPraiseInfoLayout.this.aot, i);
                    if (!StringUtils.isNull(str)) {
                        at.wf().c(ThreadCommentAndPraiseInfoLayout.this.oV, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.oV);
            bVar.tu();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.aof, d.e.cp_cont_d);
        ai.i(this.aog, d.e.cp_cont_d);
        ai.k(this.aoh, d.e.cp_cont_d);
        ai.i(this.aoi, d.e.cp_cont_d);
        ai.i(this.aoj, d.e.cp_cont_d);
        ai.i(this.aop, d.e.cp_cont_d);
        ai.i(this.aom, d.e.cp_cont_d);
        if (this.akl != null && this.akl.sT() == 1 && this.aoj != null) {
            ai.i(this.aoj, d.e.cp_cont_h);
            this.aoI = d.g.icon_home_card_like_d;
        }
        ai.i(this.aon, d.e.cp_cont_d);
        ai.i(this.aoo, d.e.cp_cont_d);
        ai.j(this.aoq, d.g.btn_frs_more_selector);
        if (this.aoj != null && this.aoB && this.aoI > 0) {
            this.aok.setImageDrawable(ai.getDrawable(this.aoI));
        }
        if (this.aom != null && this.aoA && this.aoJ > 0) {
            this.aom.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(this.aoJ), (Drawable) null);
        }
        if (this.aon != null && this.aoE && this.aoK > 0) {
            this.aon.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(this.aoK), (Drawable) null);
        }
        if (this.aoo != null && this.aoF && this.aoL > 0) {
            this.aoo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(this.aoL), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aoH = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aof;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aoQ != null) {
            this.aoQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aoQ);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.aov = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.aoz = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.aoD = z;
    }

    public void setLiveShareEnable(boolean z) {
        this.aoE = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.aoF = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.aox = z;
    }

    public View getCommentNumView() {
        return this.aom;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.aoJ = i;
        }
    }

    public void setLiveShareIcon(int i) {
        if (i > 0) {
            this.aoK = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.aoL = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getScaleAnimation() {
        if (this.aoM == null) {
            this.aoM = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.aoM.setDuration(200L);
        }
        return this.aoM;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.aoA = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.aoB = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.aoC = z;
    }
}
