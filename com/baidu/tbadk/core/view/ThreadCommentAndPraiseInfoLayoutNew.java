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
import com.baidu.tbadk.core.data.bd;
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
    private bd aXU;
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
                ThreadCommentAndPraiseInfoLayoutNew.this.DY();
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aXU != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yY() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
                ThreadCommentAndPraiseInfoLayoutNew.this.DY();
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aXU != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yY() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
                ThreadCommentAndPraiseInfoLayoutNew.this.DY();
            }
        };
        this.bcg = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aXU != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yY() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aXU.zU().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yS().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
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

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aXU = bdVar;
        h(bdVar);
        i(bdVar);
        e(bdVar);
        d(bdVar);
        setVisibility(0);
        return true;
    }

    private void initHeaderImg() {
        if (this.bbZ != null) {
            this.bbZ.setDefaultResource(17170445);
            this.bbZ.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bbZ.setDefaultBgResource(d.C0107d.cp_bg_line_e);
            this.bbZ.setIsRound(true);
            this.bbZ.setAfterClickListener(this.bce);
        }
    }

    private void h(bd bdVar) {
        if (this.bbZ != null && bdVar != null) {
            if (this.bcd) {
                this.bbZ.setVisibility(8);
                return;
            }
            this.bbZ.setVisibility(0);
            this.bbZ.setData(bdVar);
            UserTbVipInfoData yT = bdVar.yT();
            if (yT != null && yT.getvipV_url() != null && this.bcb != null) {
                if (this.bcc == null) {
                    this.bcb.inflate();
                    this.bcc = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.bcc.startLoad(yT.getvipV_url(), 10, false);
                this.bbZ.setIsBigV(true);
            }
        }
    }

    private void i(bd bdVar) {
        if (this.bca != null && bdVar != null && !StringUtils.isNull(this.aXU.yS().getName_show())) {
            this.bca.setText(am.getFixedText(this.aXU.yS().getName_show(), 8, true));
        }
    }

    private void d(bd bdVar) {
        String A;
        if (this.bbk != null && bdVar != null) {
            if (bdVar.yM() <= 0 || !this.bbE) {
                this.bbk.setVisibility(8);
                return;
            }
            this.bbk.setVisibility(0);
            if (this.mFrom == 2) {
                A = am.y(bdVar.yM());
            } else {
                A = am.A(bdVar.yM() * 1000);
            }
            this.bbk.setText(A);
        }
    }

    private void e(bd bdVar) {
        if (this.bbo != null && bdVar != null) {
            if (bdVar.yK() >= 0) {
                this.bbo.setVisibility(0);
                this.bbo.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.yK())));
                return;
            }
            this.bbo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DY() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bbw, new b.InterfaceC0073b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayoutNew.this.bbx, i);
                    if (!StringUtils.isNull(str)) {
                        av.CZ().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AD();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bca, d.C0107d.cp_cont_d);
        aj.r(this.bbk, d.C0107d.cp_cont_d);
        aj.r(this.bbo, d.C0107d.cp_cont_d);
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

    public void DZ() {
        this.bbZ.setClickable(false);
        this.bca.setClickable(false);
    }
}
