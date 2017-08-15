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
    private bl akl;
    private View.OnClickListener aoP;
    public ClickableHeaderImageView aoS;
    public TextView aoT;
    public ViewStub aoU;
    public TbImageView aoV;
    private boolean aoW;
    private View.OnClickListener aoX;
    private View.OnClickListener aoY;
    private TextView aog;
    private TextView aom;
    private TextView aoq;
    private FrameLayout aor;
    private List<CharSequence> aos;
    private List<String> aot;
    private boolean aox;
    private Context mContext;
    private int mFrom;
    private TbPageContext oV;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.aox = true;
        this.aoW = false;
        this.mFrom = 1;
        this.aoP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xi();
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.akl != null && ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.akl.rK() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ() != null && ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.akl.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aoX != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aoX.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aox = true;
        this.aoW = false;
        this.mFrom = 1;
        this.aoP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xi();
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.akl != null && ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.akl.rK() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ() != null && ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.akl.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aoX != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aoX.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aox = true;
        this.aoW = false;
        this.mFrom = 1;
        this.aoP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xi();
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.akl != null && ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.akl.rK() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ() != null && ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.akl.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.akl.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.akl.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aoX != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aoX.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.aoS = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.aoU = (ViewStub) inflate.findViewById(d.h.viewstub_headimage_mask);
        this.aoT = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.aog = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.aom = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.aoq = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.aor = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        xj();
        this.aoT.setOnClickListener(this.aoY);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.akl = blVar;
        j(blVar);
        k(blVar);
        e(blVar);
        c(blVar);
        setVisibility(0);
        return true;
    }

    private void xj() {
        if (this.aoS != null) {
            this.aoS.setDefaultResource(17170445);
            this.aoS.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aoS.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aoS.setIsRound(true);
            this.aoS.setAfterClickListener(this.aoX);
        }
    }

    private void j(bl blVar) {
        if (this.aoS != null && blVar != null) {
            if (this.aoW) {
                this.aoS.setVisibility(8);
                return;
            }
            this.aoS.setVisibility(0);
            this.aoS.setData(blVar);
            UserTbVipInfoData rF = blVar.rF();
            if (rF != null && rF.getvipV_url() != null && this.aoU != null) {
                if (this.aoV == null) {
                    this.aoU.inflate();
                    this.aoV = (TbImageView) findViewById(d.h.user_head_mask);
                }
                this.aoV.c(rF.getvipV_url(), 10, false);
                this.aoS.setIsBigV(true);
            }
        }
    }

    private void k(bl blVar) {
        if (this.aoT != null && blVar != null && !StringUtils.isNull(this.akl.getAuthor().getName_show())) {
            this.aoT.setText(al.getFixedText(this.akl.getAuthor().getName_show(), 8, true));
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
            if (this.mFrom == 2) {
                s = al.p(blVar.rz());
            } else {
                s = al.s(blVar.rz() * 1000);
            }
            this.aog.setText(s);
        }
    }

    private void e(bl blVar) {
        if (this.aom != null && blVar != null) {
            if (blVar.rx() >= 0) {
                this.aom.setVisibility(0);
                this.aom.setText(String.format(this.mContext.getString(d.l.comment_num_tip), al.u(blVar.rx())));
                return;
            }
            this.aom.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        if (this.oV != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oV.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.aos, new b.InterfaceC0043b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) u.c(ThreadCommentAndPraiseInfoLayoutNew.this.aot, i);
                    if (!StringUtils.isNull(str)) {
                        at.wf().c(ThreadCommentAndPraiseInfoLayoutNew.this.oV, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.oV);
            bVar.tu();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.aoT, d.e.cp_cont_d);
        ai.i(this.aog, d.e.cp_cont_d);
        ai.i(this.aom, d.e.cp_cont_d);
        ai.j(this.aoq, d.g.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.aox = z;
    }

    public View getCommentNumView() {
        return this.aom;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.aom.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoW = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aoX = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aoS != null) {
            this.aoS.setPageId(bdUniqueId);
        }
    }

    public void xk() {
        this.aoS.setClickable(false);
        this.aoT.setClickable(false);
    }
}
