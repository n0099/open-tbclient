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
    private bh ajq;
    private TextView amQ;
    private TextView amW;
    public ClickableHeaderImageView anM;
    public TextView anN;
    public ViewStub anO;
    public TbImageView anP;
    private boolean anQ;
    private View.OnClickListener anR;
    private View.OnClickListener anS;
    private View.OnClickListener anT;
    private TextView anf;
    private FrameLayout ang;
    private List<CharSequence> anh;
    private List<String> ani;
    private boolean anm;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.anm = true;
        this.anQ = false;
        this.mFrom = 1;
        this.anS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wI();
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajq != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rz() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anR != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anR.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anm = true;
        this.anQ = false;
        this.mFrom = 1;
        this.anS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wI();
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajq != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rz() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anR != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anR.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anm = true;
        this.anQ = false;
        this.mFrom = 1;
        this.anS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wI();
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajq != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rz() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajq.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rt().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anR != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anR.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.anM = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.anO = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.anN = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.amQ = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.amW = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.anf = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.ang = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        wJ();
        this.anN.setOnClickListener(this.anT);
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajq = bhVar;
        j(bhVar);
        k(bhVar);
        f(bhVar);
        d(bhVar);
        setVisibility(0);
        return true;
    }

    private void wJ() {
        if (this.anM != null) {
            this.anM.setDefaultResource(17170445);
            this.anM.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.anM.setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.anM.setIsRound(true);
            this.anM.setAfterClickListener(this.anR);
        }
    }

    private void j(bh bhVar) {
        if (this.anM != null && bhVar != null) {
            if (this.anQ) {
                this.anM.setVisibility(8);
                return;
            }
            this.anM.setVisibility(0);
            this.anM.setData(bhVar);
            UserTbVipInfoData ru = bhVar.ru();
            if (ru != null && ru.getvipV_url() != null && this.anO != null) {
                if (this.anP == null) {
                    this.anO.inflate();
                    this.anP = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.anP.startLoad(ru.getvipV_url(), 10, false);
                this.anM.setIsBigV(true);
            }
        }
    }

    private void k(bh bhVar) {
        if (this.anN != null && bhVar != null && !StringUtils.isNull(this.ajq.rt().getName_show())) {
            this.anN.setText(am.getFixedText(this.ajq.rt().getName_show(), 8, true));
        }
    }

    private void d(bh bhVar) {
        String s;
        if (this.amQ != null && bhVar != null) {
            if (bhVar.rn() <= 0 || !this.anm) {
                this.amQ.setVisibility(8);
                return;
            }
            this.amQ.setVisibility(0);
            if (this.mFrom == 2) {
                s = am.q(bhVar.rn());
            } else {
                s = am.s(bhVar.rn() * 1000);
            }
            this.amQ.setText(s);
        }
    }

    private void f(bh bhVar) {
        if (this.amW != null && bhVar != null) {
            if (bhVar.rl() >= 0) {
                this.amW.setVisibility(0);
                this.amW.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.u(bhVar.rl())));
                return;
            }
            this.amW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cf(d.j.operation);
            bVar.a(this.anh, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayoutNew.this.ani, i);
                    if (!StringUtils.isNull(str)) {
                        av.vI().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tl();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.anN, d.C0080d.cp_cont_d);
        aj.i(this.amQ, d.C0080d.cp_cont_d);
        aj.i(this.amW, d.C0080d.cp_cont_d);
        aj.j(this.anf, d.f.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.anm = z;
    }

    public View getCommentNumView() {
        return this.amW;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.amW.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.anQ = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anR = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anM != null) {
            this.anM.setPageId(bdUniqueId);
        }
    }

    public void wK() {
        this.anM.setClickable(false);
        this.anN.setClickable(false);
    }
}
