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
import com.baidu.tbadk.core.data.be;
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
    private be aXV;
    private boolean bbE;
    public ClickableHeaderImageView bbZ;
    private TextView bbk;
    private TextView bbo;
    private TextView bbu;
    private FrameLayout bbv;
    private List<CharSequence> bbw;
    private List<String> bbx;
    public TextView bca;
    public ViewStub bcb;
    public TbImageView bcc;
    private boolean bcd;
    private View.OnClickListener bce;
    private View.OnClickListener bcf;
    private View.OnClickListener bcg;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.bbE = true;
        this.bcd = false;
        this.mFrom = 1;
        this.bcf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Eh();
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aXV != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aXV.zd() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bce != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bce.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbE = true;
        this.bcd = false;
        this.mFrom = 1;
        this.bcf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Eh();
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aXV != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aXV.zd() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bce != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bce.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbE = true;
        this.bcd = false;
        this.mFrom = 1;
        this.bcf = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Eh();
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aXV != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aXV.zd() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aXV.Ac().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aXV.yX().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bce != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bce.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.bbZ = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bcb = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.bca = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.bbk = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bbo = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bbu = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bbv = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bca.setOnClickListener(this.bcg);
    }

    public boolean setData(be beVar) {
        if (beVar == null) {
            setVisibility(8);
            return false;
        }
        this.aXV = beVar;
        h(beVar);
        i(beVar);
        e(beVar);
        d(beVar);
        setVisibility(0);
        return true;
    }

    private void initHeaderImg() {
        if (this.bbZ != null) {
            this.bbZ.setDefaultResource(17170445);
            this.bbZ.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bbZ.setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.bbZ.setIsRound(true);
            this.bbZ.setAfterClickListener(this.bce);
        }
    }

    private void h(be beVar) {
        if (this.bbZ != null && beVar != null) {
            if (this.bcd) {
                this.bbZ.setVisibility(8);
                return;
            }
            this.bbZ.setVisibility(0);
            this.bbZ.setData(beVar);
            UserTbVipInfoData yY = beVar.yY();
            if (yY != null && yY.getvipV_url() != null && this.bcb != null) {
                if (this.bcc == null) {
                    this.bcb.inflate();
                    this.bcc = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.bcc.startLoad(yY.getvipV_url(), 10, false);
                this.bbZ.setIsBigV(true);
            }
        }
    }

    private void i(be beVar) {
        if (this.bca != null && beVar != null && !StringUtils.isNull(this.aXV.yX().getName_show())) {
            this.bca.setText(am.getFixedText(this.aXV.yX().getName_show(), 8, true));
        }
    }

    private void d(be beVar) {
        String A;
        if (this.bbk != null && beVar != null) {
            if (beVar.yR() <= 0 || !this.bbE) {
                this.bbk.setVisibility(8);
                return;
            }
            this.bbk.setVisibility(0);
            if (this.mFrom == 2) {
                A = am.y(beVar.yR());
            } else {
                A = am.A(beVar.yR() * 1000);
            }
            this.bbk.setText(A);
        }
    }

    private void e(be beVar) {
        if (this.bbo != null && beVar != null) {
            if (beVar.yP() >= 0) {
                this.bbo.setVisibility(0);
                this.bbo.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(beVar.yP())));
                return;
            }
            this.bbo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fg(d.j.operation);
            bVar.a(this.bbw, new b.InterfaceC0074b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayoutNew.this.bbx, i);
                    if (!StringUtils.isNull(str)) {
                        av.Di().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AL();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bca, d.C0108d.cp_cont_d);
        aj.r(this.bbk, d.C0108d.cp_cont_d);
        aj.r(this.bbo, d.C0108d.cp_cont_d);
        aj.s(this.bbu, d.f.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.bbE = z;
    }

    public View getCommentNumView() {
        return this.bbo;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.bbo.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.bcd = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bce = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bbZ != null) {
            this.bbZ.setPageId(bdUniqueId);
        }
    }

    public void Ei() {
        this.bbZ.setClickable(false);
        this.bca.setClickable(false);
    }
}
