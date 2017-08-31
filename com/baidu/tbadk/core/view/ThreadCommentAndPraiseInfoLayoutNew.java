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
    private bj ajF;
    private TextView anA;
    private TextView anG;
    private TextView anL;
    private FrameLayout anM;
    private List<CharSequence> anN;
    private List<String> anO;
    private boolean anS;
    public ClickableHeaderImageView aor;
    public TextView aos;
    public ViewStub aot;
    public TbImageView aou;
    private boolean aov;
    private View.OnClickListener aow;
    private View.OnClickListener aox;
    private View.OnClickListener aoy;
    private Context mContext;
    private TbPageContext mF;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.anS = true;
        this.aov = false;
        this.mFrom = 1;
        this.aox = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xk();
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajF != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajF.rG() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aow != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aow.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anS = true;
        this.aov = false;
        this.mFrom = 1;
        this.aox = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xk();
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajF != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajF.rG() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aow != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aow.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anS = true;
        this.aov = false;
        this.mFrom = 1;
        this.aox = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xk();
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajF != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajF.rG() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajF.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajF.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aow != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aow.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.aor = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aot = (ViewStub) inflate.findViewById(d.h.viewstub_headimage_mask);
        this.aos = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.anA = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.anG = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.anL = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.anM = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        xl();
        this.aos.setOnClickListener(this.aoy);
    }

    public boolean c(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajF = bjVar;
        m(bjVar);
        n(bjVar);
        g(bjVar);
        e(bjVar);
        setVisibility(0);
        return true;
    }

    private void xl() {
        if (this.aor != null) {
            this.aor.setDefaultResource(17170445);
            this.aor.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aor.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aor.setIsRound(true);
            this.aor.setAfterClickListener(this.aow);
        }
    }

    private void m(bj bjVar) {
        if (this.aor != null && bjVar != null) {
            if (this.aov) {
                this.aor.setVisibility(8);
                return;
            }
            this.aor.setVisibility(0);
            this.aor.setData(bjVar);
            UserTbVipInfoData rB = bjVar.rB();
            if (rB != null && rB.getvipV_url() != null && this.aot != null) {
                if (this.aou == null) {
                    this.aot.inflate();
                    this.aou = (TbImageView) findViewById(d.h.user_head_mask);
                }
                this.aou.c(rB.getvipV_url(), 10, false);
                this.aor.setIsBigV(true);
            }
        }
    }

    private void n(bj bjVar) {
        if (this.aos != null && bjVar != null && !StringUtils.isNull(this.ajF.getAuthor().getName_show())) {
            this.aos.setText(am.getFixedText(this.ajF.getAuthor().getName_show(), 8, true));
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
            if (this.mFrom == 2) {
                s = am.p(bjVar.rv());
            } else {
                s = am.s(bjVar.rv() * 1000);
            }
            this.anA.setText(s);
        }
    }

    private void g(bj bjVar) {
        if (this.anG != null && bjVar != null) {
            if (bjVar.rt() >= 0) {
                this.anG.setVisibility(0);
                this.anG.setText(String.format(this.mContext.getString(d.l.comment_num_tip), am.u(bjVar.rt())));
                return;
            }
            this.anG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xk() {
        if (this.mF != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mF.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.anN, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayoutNew.this.anO, i);
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
        aj.i(this.aos, d.e.cp_cont_d);
        aj.i(this.anA, d.e.cp_cont_d);
        aj.i(this.anG, d.e.cp_cont_d);
        aj.j(this.anL, d.g.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.anS = z;
    }

    public View getCommentNumView() {
        return this.anG;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.anG.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.aov = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aow = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aor != null) {
            this.aor.setPageId(bdUniqueId);
        }
    }

    public void xm() {
        this.aor.setClickable(false);
        this.aos.setClickable(false);
    }
}
