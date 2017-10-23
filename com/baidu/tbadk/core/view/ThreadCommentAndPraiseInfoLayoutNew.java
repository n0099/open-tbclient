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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bh aiU;
    private TextView amC;
    private TextView amL;
    private FrameLayout amM;
    private List<CharSequence> amN;
    private List<String> amO;
    private boolean amS;
    private TextView amw;
    public ClickableHeaderImageView ans;
    public TextView ant;
    public ViewStub anu;
    public TbImageView anv;
    private boolean anw;
    private View.OnClickListener anx;
    private View.OnClickListener any;
    private View.OnClickListener anz;
    private Context mContext;
    private int mFrom;
    private TbPageContext mH;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.amS = true;
        this.anw = false;
        this.mFrom = 1;
        this.any = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wB();
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aiU != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aiU.rt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anx != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anx.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amS = true;
        this.anw = false;
        this.mFrom = 1;
        this.any = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wB();
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aiU != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aiU.rt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anx != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anx.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amS = true;
        this.anw = false;
        this.mFrom = 1;
        this.any = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wB();
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aiU != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aiU.rt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aiU.ss().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aiU.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anx != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anx.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.ans = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.anu = (ViewStub) inflate.findViewById(d.h.viewstub_headimage_mask);
        this.ant = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.amw = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.amC = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.amL = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.amM = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        wC();
        this.ant.setOnClickListener(this.anz);
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiU = bhVar;
        j(bhVar);
        k(bhVar);
        f(bhVar);
        d(bhVar);
        setVisibility(0);
        return true;
    }

    private void wC() {
        if (this.ans != null) {
            this.ans.setDefaultResource(17170445);
            this.ans.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.ans.setDefaultBgResource(d.e.cp_bg_line_e);
            this.ans.setIsRound(true);
            this.ans.setAfterClickListener(this.anx);
        }
    }

    private void j(bh bhVar) {
        if (this.ans != null && bhVar != null) {
            if (this.anw) {
                this.ans.setVisibility(8);
                return;
            }
            this.ans.setVisibility(0);
            this.ans.setData(bhVar);
            UserTbVipInfoData ro = bhVar.ro();
            if (ro != null && ro.getvipV_url() != null && this.anu != null) {
                if (this.anv == null) {
                    this.anu.inflate();
                    this.anv = (TbImageView) findViewById(d.h.user_head_mask);
                }
                this.anv.c(ro.getvipV_url(), 10, false);
                this.ans.setIsBigV(true);
            }
        }
    }

    private void k(bh bhVar) {
        if (this.ant != null && bhVar != null && !StringUtils.isNull(this.aiU.getAuthor().getName_show())) {
            this.ant.setText(am.getFixedText(this.aiU.getAuthor().getName_show(), 8, true));
        }
    }

    private void d(bh bhVar) {
        String s;
        if (this.amw != null && bhVar != null) {
            if (bhVar.ri() <= 0 || !this.amS) {
                this.amw.setVisibility(8);
                return;
            }
            this.amw.setVisibility(0);
            if (this.mFrom == 2) {
                s = am.q(bhVar.ri());
            } else {
                s = am.s(bhVar.ri() * 1000);
            }
            this.amw.setText(s);
        }
    }

    private void f(bh bhVar) {
        if (this.amC != null && bhVar != null) {
            if (bhVar.rg() >= 0) {
                this.amC.setVisibility(0);
                this.amC.setText(String.format(this.mContext.getString(d.l.comment_num_tip), am.u(bhVar.rg())));
                return;
            }
            this.amC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wB() {
        if (this.mH != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mH.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(this.amN, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayoutNew.this.amO, i);
                    if (!StringUtils.isNull(str)) {
                        av.vA().c(ThreadCommentAndPraiseInfoLayoutNew.this.mH, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mH);
            bVar.te();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.ant, d.e.cp_cont_d);
        aj.i(this.amw, d.e.cp_cont_d);
        aj.i(this.amC, d.e.cp_cont_d);
        aj.j(this.amL, d.g.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.amS = z;
    }

    public View getCommentNumView() {
        return this.amC;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.amC.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.anw = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anx = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ans != null) {
            this.ans.setPageId(bdUniqueId);
        }
    }

    public void wD() {
        this.ans.setClickable(false);
        this.ant.setClickable(false);
    }
}
