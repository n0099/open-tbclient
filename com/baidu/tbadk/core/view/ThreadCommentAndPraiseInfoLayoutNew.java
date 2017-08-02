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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bl aiQ;
    private TbPageContext ako;
    private TextView amM;
    private TextView amS;
    private TextView amW;
    private FrameLayout amX;
    private List<CharSequence> amY;
    private List<String> amZ;
    public ViewStub anA;
    public TbImageView anB;
    private boolean anC;
    private View.OnClickListener anD;
    private View.OnClickListener anE;
    private boolean and;
    private View.OnClickListener anv;
    public ClickableHeaderImageView any;
    public TextView anz;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.and = true;
        this.anC = false;
        this.mFrom = 1;
        this.anv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xa();
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aiQ != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.rA() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anD != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anD.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.and = true;
        this.anC = false;
        this.mFrom = 1;
        this.anv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xa();
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aiQ != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.rA() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anD != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anD.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.and = true;
        this.anC = false;
        this.mFrom = 1;
        this.anv = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xa();
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aiQ != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.rA() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anD != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anD.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.any = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.anA = (ViewStub) inflate.findViewById(d.h.viewstub_headimage_mask);
        this.anz = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.amM = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.amS = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.amW = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.amX = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        xb();
        this.anz.setOnClickListener(this.anE);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiQ = blVar;
        j(blVar);
        k(blVar);
        e(blVar);
        c(blVar);
        setVisibility(0);
        return true;
    }

    private void xb() {
        if (this.any != null) {
            this.any.setDefaultResource(17170445);
            this.any.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.any.setDefaultBgResource(d.e.cp_bg_line_e);
            this.any.setIsRound(true);
            this.any.setAfterClickListener(this.anD);
        }
    }

    private void j(bl blVar) {
        if (this.any != null && blVar != null) {
            if (this.anC) {
                this.any.setVisibility(8);
                return;
            }
            this.any.setVisibility(0);
            this.any.setData(blVar);
            UserTbVipInfoData rv = blVar.rv();
            if (rv != null && rv.getvipV_url() != null && this.anA != null) {
                if (this.anB == null) {
                    this.anA.inflate();
                    this.anB = (TbImageView) findViewById(d.h.user_head_mask);
                }
                this.anB.c(rv.getvipV_url(), 10, false);
                this.any.setIsBigV(true);
            }
        }
    }

    private void k(bl blVar) {
        if (this.anz != null && blVar != null && !StringUtils.isNull(this.aiQ.getAuthor().getName_show())) {
            this.anz.setText(al.getFixedText(this.aiQ.getAuthor().getName_show(), 8, true));
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
            if (this.mFrom == 2) {
                s = al.p(blVar.rp());
            } else {
                s = al.s(blVar.rp() * 1000);
            }
            this.amM.setText(s);
        }
    }

    private void e(bl blVar) {
        if (this.amS != null && blVar != null) {
            if (blVar.rn() >= 0) {
                this.amS.setVisibility(0);
                this.amS.setText(String.format(this.mContext.getString(d.l.comment_num_tip), al.u(blVar.rn())));
                return;
            }
            this.amS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa() {
        if (this.ako != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.ako.getPageActivity());
            bVar.cd(d.l.operation);
            bVar.a(this.amY, new b.InterfaceC0043b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) u.c(ThreadCommentAndPraiseInfoLayoutNew.this.amZ, i);
                    if (!StringUtils.isNull(str)) {
                        at.vV().c(ThreadCommentAndPraiseInfoLayoutNew.this.ako, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.ako);
            bVar.tk();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.anz, d.e.cp_cont_d);
        ai.i(this.amM, d.e.cp_cont_d);
        ai.i(this.amS, d.e.cp_cont_d);
        ai.j(this.amW, d.g.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.and = z;
    }

    public View getCommentNumView() {
        return this.amS;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.amS.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.anC = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anD = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.any != null) {
            this.any.setPageId(bdUniqueId);
        }
    }

    public void xc() {
        this.any.setClickable(false);
        this.anz.setClickable(false);
    }
}
