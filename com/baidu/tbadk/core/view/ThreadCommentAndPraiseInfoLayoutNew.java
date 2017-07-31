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
    private bl akj;
    private TbPageContext alI;
    private View.OnClickListener aoO;
    public ClickableHeaderImageView aoR;
    public TextView aoS;
    public ViewStub aoT;
    public TbImageView aoU;
    private boolean aoV;
    private View.OnClickListener aoW;
    private View.OnClickListener aoX;
    private TextView aof;
    private TextView aol;
    private TextView aop;
    private FrameLayout aoq;
    private List<CharSequence> aor;
    private List<String> aos;
    private boolean aow;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.aow = true;
        this.aoV = false;
        this.mFrom = 1;
        this.aoO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xi();
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.akj != null && ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.akj.rK() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ() != null && ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aoW != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aoW.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aow = true;
        this.aoV = false;
        this.mFrom = 1;
        this.aoO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xi();
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.akj != null && ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.akj.rK() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ() != null && ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aoW != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aoW.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aow = true;
        this.aoV = false;
        this.mFrom = 1;
        this.aoO = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xi();
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.akj != null && ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.akj.rK() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ() != null && ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.akj.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.akj.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aoW != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aoW.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.aoR = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aoT = (ViewStub) inflate.findViewById(d.h.viewstub_headimage_mask);
        this.aoS = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.aof = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.aol = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.aop = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.aoq = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        xj();
        this.aoS.setOnClickListener(this.aoX);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.akj = blVar;
        j(blVar);
        k(blVar);
        e(blVar);
        c(blVar);
        setVisibility(0);
        return true;
    }

    private void xj() {
        if (this.aoR != null) {
            this.aoR.setDefaultResource(17170445);
            this.aoR.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aoR.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aoR.setIsRound(true);
            this.aoR.setAfterClickListener(this.aoW);
        }
    }

    private void j(bl blVar) {
        if (this.aoR != null && blVar != null) {
            if (this.aoV) {
                this.aoR.setVisibility(8);
                return;
            }
            this.aoR.setVisibility(0);
            this.aoR.setData(blVar);
            UserTbVipInfoData rF = blVar.rF();
            if (rF != null && rF.getvipV_url() != null && this.aoT != null) {
                if (this.aoU == null) {
                    this.aoT.inflate();
                    this.aoU = (TbImageView) findViewById(d.h.user_head_mask);
                }
                this.aoU.c(rF.getvipV_url(), 10, false);
                this.aoR.setIsBigV(true);
            }
        }
    }

    private void k(bl blVar) {
        if (this.aoS != null && blVar != null && !StringUtils.isNull(this.akj.getAuthor().getName_show())) {
            this.aoS.setText(al.getFixedText(this.akj.getAuthor().getName_show(), 8, true));
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
            if (this.mFrom == 2) {
                s = al.p(blVar.rz());
            } else {
                s = al.s(blVar.rz() * 1000);
            }
            this.aof.setText(s);
        }
    }

    private void e(bl blVar) {
        if (this.aol != null && blVar != null) {
            if (blVar.rx() >= 0) {
                this.aol.setVisibility(0);
                this.aol.setText(String.format(this.mContext.getString(d.l.comment_num_tip), al.u(blVar.rx())));
                return;
            }
            this.aol.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        if (this.alI != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.alI.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.aor, new b.InterfaceC0043b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) u.c(ThreadCommentAndPraiseInfoLayoutNew.this.aos, i);
                    if (!StringUtils.isNull(str)) {
                        at.wf().c(ThreadCommentAndPraiseInfoLayoutNew.this.alI, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.alI);
            bVar.tu();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.aoS, d.e.cp_cont_d);
        ai.i(this.aof, d.e.cp_cont_d);
        ai.i(this.aol, d.e.cp_cont_d);
        ai.j(this.aop, d.g.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.aow = z;
    }

    public View getCommentNumView() {
        return this.aol;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.aol.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoV = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aoW = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aoR != null) {
            this.aoR.setPageId(bdUniqueId);
        }
    }

    public void xk() {
        this.aoR.setClickable(false);
        this.aoS.setClickable(false);
    }
}
