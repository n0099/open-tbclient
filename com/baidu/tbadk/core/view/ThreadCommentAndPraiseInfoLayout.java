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
    private bl aiQ;
    private TbPageContext ako;
    private TextView amL;
    private TextView amM;
    private View amN;
    private TextView amO;
    private TextView amP;
    private ImageView amQ;
    private View amR;
    private TextView amS;
    private TextView amT;
    private TextView amU;
    private TextView amV;
    private TextView amW;
    private FrameLayout amX;
    private List<CharSequence> amY;
    private List<String> amZ;
    private boolean ana;
    private boolean anb;
    private boolean anc;
    private boolean and;
    private boolean ane;
    private boolean anf;
    private boolean ang;
    private boolean anh;
    private boolean ani;
    private boolean anj;
    private boolean ank;
    private boolean anl;
    private String anm;
    private View.OnClickListener ann;
    private int ano;
    private int anp;
    private int anq;
    private int anr;
    private ScaleAnimation ans;
    private View.OnClickListener ant;
    private View.OnClickListener anu;
    private View.OnClickListener anv;
    private CustomMessageListener anw;
    private Context mContext;
    private int mFrom;
    private String mStType;

    public void setYuelaouLocate(String str) {
        this.anm = str;
    }

    public void setStType(String str) {
        this.mStType = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ana = false;
        this.anb = false;
        this.anc = false;
        this.and = true;
        this.ane = true;
        this.anf = false;
        this.ang = false;
        this.anh = false;
        this.ani = true;
        this.anj = true;
        this.ank = false;
        this.anl = false;
        this.mFrom = 2;
        this.ant = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayout.this.aiQ != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.aiQ.rA())) {
                    if (StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.mStType) || StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.anm)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createNormalCfg(ThreadCommentAndPraiseInfoLayout.this.aiQ.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createCfgForpersonalized(ThreadCommentAndPraiseInfoLayout.this.aiQ.rA(), ThreadCommentAndPraiseInfoLayout.this.mStType, ThreadCommentAndPraiseInfoLayout.this.anm)));
                    }
                    if (ThreadCommentAndPraiseInfoLayout.this.ann != null) {
                        ThreadCommentAndPraiseInfoLayout.this.ann.onClick(view);
                    }
                }
            }
        };
        this.anu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (aw.aN(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.aiQ != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.aiQ.sJ() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.aiQ.bX(ThreadCommentAndPraiseInfoLayout.this.aiQ.sI() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.aiQ.bW(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.amP != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.amP, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.aiQ.bW(1);
                        ThreadCommentAndPraiseInfoLayout.this.aiQ.bX(ThreadCommentAndPraiseInfoLayout.this.aiQ.sI() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.amP != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.amP, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.aiQ);
                    if (ThreadCommentAndPraiseInfoLayout.this.amQ != null) {
                        ThreadCommentAndPraiseInfoLayout.this.amQ.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.aiQ.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.aiQ.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        };
        this.anv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.xa();
            }
        };
        this.anw = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl) && ThreadCommentAndPraiseInfoLayout.this.aiQ != null && ThreadCommentAndPraiseInfoLayout.this.aiQ.getId() != null) {
                    bl blVar = (bl) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(blVar.getId()) && blVar.rl() != null && blVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aiQ.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aiQ.rl() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aiQ.rl().setNum(blVar.rl().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.aiQ);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ana = false;
        this.anb = false;
        this.anc = false;
        this.and = true;
        this.ane = true;
        this.anf = false;
        this.ang = false;
        this.anh = false;
        this.ani = true;
        this.anj = true;
        this.ank = false;
        this.anl = false;
        this.mFrom = 2;
        this.ant = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayout.this.aiQ != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.aiQ.rA())) {
                    if (StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.mStType) || StringUtils.isNull(ThreadCommentAndPraiseInfoLayout.this.anm)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createNormalCfg(ThreadCommentAndPraiseInfoLayout.this.aiQ.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createCfgForpersonalized(ThreadCommentAndPraiseInfoLayout.this.aiQ.rA(), ThreadCommentAndPraiseInfoLayout.this.mStType, ThreadCommentAndPraiseInfoLayout.this.anm)));
                    }
                    if (ThreadCommentAndPraiseInfoLayout.this.ann != null) {
                        ThreadCommentAndPraiseInfoLayout.this.ann.onClick(view);
                    }
                }
            }
        };
        this.anu = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = 1;
                if (aw.aN(ThreadCommentAndPraiseInfoLayout.this.mContext) && ThreadCommentAndPraiseInfoLayout.this.aiQ != null) {
                    if (ThreadCommentAndPraiseInfoLayout.this.aiQ.sJ() != 0) {
                        ThreadCommentAndPraiseInfoLayout.this.aiQ.bX(ThreadCommentAndPraiseInfoLayout.this.aiQ.sI() - 1);
                        ThreadCommentAndPraiseInfoLayout.this.aiQ.bW(0);
                        if (ThreadCommentAndPraiseInfoLayout.this.amP != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.amP, d.e.cp_cont_d);
                        }
                    } else {
                        ThreadCommentAndPraiseInfoLayout.this.aiQ.bW(1);
                        ThreadCommentAndPraiseInfoLayout.this.aiQ.bX(ThreadCommentAndPraiseInfoLayout.this.aiQ.sI() + 1);
                        if (ThreadCommentAndPraiseInfoLayout.this.amP != null) {
                            ai.i(ThreadCommentAndPraiseInfoLayout.this.amP, d.e.cp_cont_h);
                        }
                        i = 0;
                    }
                    ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.aiQ);
                    if (ThreadCommentAndPraiseInfoLayout.this.amQ != null) {
                        ThreadCommentAndPraiseInfoLayout.this.amQ.startAnimation(ThreadCommentAndPraiseInfoLayout.this.getScaleAnimation());
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", ThreadCommentAndPraiseInfoLayout.this.aiQ.getTid());
                    httpMessage.addParam("op_type", i);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addParam("forum_id", ThreadCommentAndPraiseInfoLayout.this.aiQ.getFid());
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
            }
        };
        this.anv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayout.this.xa();
            }
        };
        this.anw = new CustomMessageListener(CmdConfigCustom.PB_ACTION_PRAISE) { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl) && ThreadCommentAndPraiseInfoLayout.this.aiQ != null && ThreadCommentAndPraiseInfoLayout.this.aiQ.getId() != null) {
                    bl blVar = (bl) customResponsedMessage.getData();
                    if (!TextUtils.isEmpty(blVar.getId()) && blVar.rl() != null && blVar.getId().equals(ThreadCommentAndPraiseInfoLayout.this.aiQ.getId())) {
                        if (ThreadCommentAndPraiseInfoLayout.this.aiQ.rl() != null) {
                            ThreadCommentAndPraiseInfoLayout.this.aiQ.rl().setNum(blVar.rl().getNum());
                        }
                        ThreadCommentAndPraiseInfoLayout.this.h(ThreadCommentAndPraiseInfoLayout.this.aiQ);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.amL = (TextView) inflate.findViewById(d.h.thread_info_bar_name);
        this.amM = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.amN = inflate.findViewById(d.h.frs_item_location_sep);
        this.amO = (TextView) inflate.findViewById(d.h.frs_item_location_address);
        this.amP = (TextView) inflate.findViewById(d.h.thread_info_praise_num);
        this.amS = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.amT = (TextView) inflate.findViewById(d.h.thread_info_share_num);
        this.amU = (TextView) inflate.findViewById(d.h.thread_info_audience_num);
        this.amV = (TextView) inflate.findViewById(d.h.thread_info_view_num);
        this.amW = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.amX = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        this.mContext = context;
        this.amQ = (ImageView) inflate.findViewById(d.h.thread_info_praise_img);
        this.amR = inflate.findViewById(d.h.agree_view_container);
        this.amR.setOnClickListener(this.anu);
        this.amS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayout.this.aiQ != null && ThreadCommentAndPraiseInfoLayout.this.mContext != null) {
                    PbActivityConfig addLocateParam = new PbActivityConfig(ThreadCommentAndPraiseInfoLayout.this.mContext).createFromThreadCfg(ThreadCommentAndPraiseInfoLayout.this.aiQ, null, com.baidu.tieba.card.m.rm(), 0, true, false, false).addLocateParam("");
                    addLocateParam.setForumId(String.valueOf(ThreadCommentAndPraiseInfoLayout.this.aiQ.getFid()));
                    addLocateParam.setForumName(ThreadCommentAndPraiseInfoLayout.this.aiQ.rA());
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
        this.anc = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ane = z;
        if (this.amL != null) {
            this.amL.setClickable(this.ane);
        }
    }

    public boolean wZ() {
        return this.amX != null && this.amX.getVisibility() == 0;
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiQ = blVar;
        b(blVar);
        c(blVar);
        d(blVar);
        i(blVar);
        h(blVar);
        e(blVar);
        f(blVar);
        g(blVar);
        setVisibility(this.ana ? 0 : 8);
        return this.ana;
    }

    private void b(bl blVar) {
        if (this.amL != null && blVar != null) {
            if (!StringUtils.isNull(blVar.rA()) && this.ani) {
                this.amL.setVisibility(0);
                String d = al.d(blVar.rA(), 14, "...");
                String string = getContext().getString(d.l.chosen_pb_original_bar, d);
                if (al.dS(d) > 14) {
                    this.amL.setText(d);
                } else {
                    this.amL.setText(string);
                }
                this.amL.setContentDescription(string);
                this.amL.setOnClickListener(this.ant);
                this.amL.setClickable(this.ane);
                this.ana = true;
                return;
            }
            this.amL.setVisibility(8);
        }
    }

    private void c(bl blVar) {
        String s;
        if (this.amM != null && blVar != null) {
            if (blVar.rp() <= 0 || !this.and) {
                this.amM.setVisibility(8);
                return;
            }
            this.amM.setVisibility(0);
            if (this.mFrom == 3) {
                s = al.p(blVar.rp());
            } else {
                s = al.s(blVar.rp() * 1000);
            }
            this.amM.setText(s);
            this.ana = true;
        }
    }

    private void d(bl blVar) {
        if (this.amO != null && this.amN != null && blVar != null) {
            if (this.anb && !blVar.sa() && !StringUtils.isNull(blVar.getAddress())) {
                this.amO.setVisibility(0);
                if (blVar.rp() <= 0) {
                    this.amN.setVisibility(8);
                } else {
                    this.amN.setVisibility(0);
                }
                this.amO.setText(blVar.getAddress());
                this.ana = true;
                return;
            }
            this.amO.setVisibility(8);
            this.amN.setVisibility(8);
        }
    }

    private void e(bl blVar) {
        if (this.amS != null && blVar != null) {
            if (this.anj) {
                if (blVar.rn() > 0) {
                    this.amS.setVisibility(0);
                    String v = al.v(blVar.rn());
                    if (this.ang) {
                        this.amS.setText(v);
                    } else {
                        this.amS.setText(String.format(this.mContext.getString(d.l.reply_num_tip), v));
                    }
                    this.amS.setContentDescription(this.mContext.getString(d.l.reply_num) + v);
                    this.ana = true;
                    return;
                } else if (this.ang) {
                    this.amS.setText("0");
                    this.amS.setVisibility(0);
                    this.ana = true;
                    return;
                } else {
                    this.amS.setVisibility(8);
                    return;
                }
            }
            this.amS.setVisibility(8);
        }
    }

    private void f(bl blVar) {
        if ((this.amT != null || blVar != null) && blVar.rN() != null) {
            if (!this.ank) {
                this.amT.setVisibility(8);
                return;
            }
            this.amT.setText(al.v(blVar.rN().TS.share_count));
            this.amT.setVisibility(0);
            this.ana = true;
        }
    }

    private void g(bl blVar) {
        if ((this.amU != null || blVar != null) && blVar.rN() != null) {
            if (!this.anl) {
                this.amU.setVisibility(8);
                return;
            }
            this.amU.setText(al.v(blVar.rN().audience_count));
            this.amU.setVisibility(0);
            this.ana = true;
        }
    }

    public void h(bl blVar) {
        if (this.amP != null && blVar != null) {
            if (this.anc) {
                this.amR.setVisibility(0);
                this.amP.setVisibility(0);
                String v = al.v(blVar.sI());
                this.amP.setText(v);
                this.amP.setContentDescription(this.mContext.getString(d.l.zan_num) + v);
                this.ana = true;
                if (blVar.sJ() != 0) {
                    this.ano = d.g.icon_home_card_like_d;
                    this.amQ.setImageDrawable(ai.getDrawable(this.ano));
                    if (this.amP != null) {
                        ai.i(this.amP, d.e.cp_cont_h);
                        return;
                    }
                    return;
                }
                this.ano = d.g.icon_home_card_like_n;
                this.amQ.setImageDrawable(ai.getDrawable(this.ano));
                if (this.amP != null) {
                    ai.i(this.amP, d.e.cp_cont_d);
                    return;
                }
                return;
            }
            this.amR.setVisibility(8);
            this.amP.setVisibility(8);
        }
    }

    private void i(bl blVar) {
        if (this.amV != null && blVar != null) {
            if (this.anf && blVar.ro() > 0) {
                this.amV.setVisibility(0);
                String u = al.u(blVar.ro());
                this.amV.setText(String.format(this.mContext.getString(d.l.view_num_tip), u));
                this.amV.setContentDescription(this.mContext.getString(d.l.view_num) + u);
                this.ana = true;
                return;
            }
            this.amV.setVisibility(8);
        }
    }

    public void f(TbPageContext tbPageContext) {
        this.ako = tbPageContext;
        if (this.amX != null) {
            if (this.aiQ == null || u.v(this.aiQ.sx()) || !TbadkCoreApplication.isLogin() || this.aiQ.sy()) {
                this.amX.setVisibility(8);
                return;
            }
            if (this.amY == null) {
                this.amY = new ArrayList();
            } else {
                this.amY.clear();
            }
            if (this.amZ == null) {
                this.amZ = new ArrayList();
            } else {
                this.amZ.clear();
            }
            boolean z = false;
            for (ReportInfo reportInfo : this.aiQ.sx()) {
                if (reportInfo != null && !StringUtils.isNull(reportInfo.info) && !StringUtils.isNull(reportInfo.url)) {
                    z = true;
                    this.amY.add(reportInfo.info);
                    this.amZ.add(reportInfo.url);
                }
                z = z;
            }
            if (z) {
                this.amX.setOnClickListener(this.anv);
                this.amX.setVisibility(0);
                return;
            }
            this.amX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa() {
        if (this.ako != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.ako.getPageActivity());
            bVar.cd(d.l.operation);
            bVar.a(this.amY, new b.InterfaceC0043b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) u.c(ThreadCommentAndPraiseInfoLayout.this.amZ, i);
                    if (!StringUtils.isNull(str)) {
                        at.vV().c(ThreadCommentAndPraiseInfoLayout.this.ako, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.ako);
            bVar.tk();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.amL, d.e.cp_cont_d);
        ai.i(this.amM, d.e.cp_cont_d);
        ai.k(this.amN, d.e.cp_cont_d);
        ai.i(this.amO, d.e.cp_cont_d);
        ai.i(this.amP, d.e.cp_cont_d);
        ai.i(this.amV, d.e.cp_cont_d);
        ai.i(this.amS, d.e.cp_cont_d);
        if (this.aiQ != null && this.aiQ.sJ() == 1 && this.amP != null) {
            ai.i(this.amP, d.e.cp_cont_h);
            this.ano = d.g.icon_home_card_like_d;
        }
        ai.i(this.amT, d.e.cp_cont_d);
        ai.i(this.amU, d.e.cp_cont_d);
        ai.j(this.amW, d.g.btn_frs_more_selector);
        if (this.amP != null && this.anh && this.ano > 0) {
            this.amQ.setImageDrawable(ai.getDrawable(this.ano));
        }
        if (this.amS != null && this.ang && this.anp > 0) {
            this.amS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(this.anp), (Drawable) null);
        }
        if (this.amT != null && this.ank && this.anq > 0) {
            this.amT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(this.anq), (Drawable) null);
        }
        if (this.amU != null && this.anl && this.anr > 0) {
            this.amU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(this.anr), (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ann = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.amL;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.anw != null) {
            this.anw.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anw);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.anb = z;
    }

    public void setViewNumEnabled(boolean z) {
        this.anf = z;
    }

    public void setCommentNumEnable(boolean z) {
        this.anj = z;
    }

    public void setLiveShareEnable(boolean z) {
        this.ank = z;
    }

    public void setLiveAudienceEnable(boolean z) {
        this.anl = z;
    }

    public void setReplyTimeVisible(boolean z) {
        this.and = z;
    }

    public View getCommentNumView() {
        return this.amS;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
    }

    public void setReplyIcon(int i) {
        if (i > 0) {
            this.anp = i;
        }
    }

    public void setLiveShareIcon(int i) {
        if (i > 0) {
            this.anq = i;
        }
    }

    public void setLiveAudienceIcon(int i) {
        if (i > 0) {
            this.anr = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation getScaleAnimation() {
        if (this.ans == null) {
            this.ans = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.ans.setDuration(200L);
        }
        return this.ans;
    }

    public void setNeedAddReplyIcon(boolean z) {
        this.ang = z;
    }

    public void setNeedAddPraiseIcon(boolean z) {
        this.anh = z;
    }

    public void setIsBarViewVisible(boolean z) {
        this.ani = z;
    }
}
