package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bj ajE;
    private TextView anE;
    private TextView anJ;
    private FrameLayout anK;
    private List<CharSequence> anL;
    private List<String> anM;
    private boolean anQ;
    private TextView any;
    public ClickableHeaderImageView aop;
    public TextView aoq;
    public ViewStub aor;
    public TbImageView aos;
    private boolean aot;
    private View.OnClickListener aou;
    private View.OnClickListener aov;
    private View.OnClickListener aow;
    private Context mContext;
    private TbPageContext mF;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.anQ = true;
        this.aot = false;
        this.mFrom = 1;
        this.aov = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xk();
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajE != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajE.rG() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aou != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aou.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anQ = true;
        this.aot = false;
        this.mFrom = 1;
        this.aov = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xk();
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajE != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajE.rG() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aou != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aou.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anQ = true;
        this.aot = false;
        this.mFrom = 1;
        this.aov = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xk();
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajE != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajE.rG() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajE.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajE.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aou != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aou.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.aop = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aor = (ViewStub) inflate.findViewById(d.h.viewstub_headimage_mask);
        this.aoq = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.any = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.anE = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.anJ = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.anK = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        xl();
        this.aoq.setOnClickListener(this.aow);
    }

    public boolean c(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajE = bjVar;
        m(bjVar);
        n(bjVar);
        g(bjVar);
        e(bjVar);
        setVisibility(0);
        return true;
    }

    private void xl() {
        if (this.aop != null) {
            this.aop.setDefaultResource(17170445);
            this.aop.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aop.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aop.setIsRound(true);
            this.aop.setAfterClickListener(this.aou);
        }
    }

    private void m(bj bjVar) {
        if (this.aop != null && bjVar != null) {
            if (this.aot) {
                this.aop.setVisibility(8);
                return;
            }
            this.aop.setVisibility(0);
            this.aop.setData(bjVar);
            UserTbVipInfoData rB = bjVar.rB();
            if (rB != null && rB.getvipV_url() != null && this.aor != null) {
                if (this.aos == null) {
                    this.aor.inflate();
                    this.aos = (TbImageView) findViewById(d.h.user_head_mask);
                }
                this.aos.c(rB.getvipV_url(), 10, false);
                this.aop.setIsBigV(true);
            }
        }
    }

    private void n(bj bjVar) {
        if (this.aoq != null && bjVar != null && !StringUtils.isNull(this.ajE.getAuthor().getName_show())) {
            this.aoq.setText(am.getFixedText(this.ajE.getAuthor().getName_show(), 8, true));
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
            if (this.mFrom == 2) {
                s = am.p(bjVar.rv());
            } else {
                s = am.s(bjVar.rv() * 1000);
            }
            this.any.setText(s);
        }
    }

    private void g(bj bjVar) {
        if (this.anE != null && bjVar != null) {
            if (bjVar.rt() >= 0) {
                this.anE.setVisibility(0);
                this.anE.setText(String.format(this.mContext.getString(d.l.comment_num_tip), am.u(bjVar.rt())));
                return;
            }
            this.anE.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xk() {
        if (this.mF != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mF.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.anL, new b.InterfaceC0046b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayoutNew.this.anM, i);
                    if (!StringUtils.isNull(str)) {
                        au.wd().c(ThreadCommentAndPraiseInfoLayoutNew.this.mF, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mF);
            bVar.tr();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.aoq, d.e.cp_cont_d);
        aj.i(this.any, d.e.cp_cont_d);
        aj.i(this.anE, d.e.cp_cont_d);
        aj.j(this.anJ, d.g.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.anQ = z;
    }

    public View getCommentNumView() {
        return this.anE;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.anE.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.aot = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aou = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aop != null) {
            this.aop.setPageId(bdUniqueId);
        }
    }

    public void xm() {
        this.aop.setClickable(false);
        this.aoq.setClickable(false);
    }
}
