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
    private bd aYc;
    private TextView bbC;
    private FrameLayout bbD;
    private List<CharSequence> bbE;
    private List<String> bbF;
    private boolean bbM;
    private TextView bbs;
    private TextView bbw;
    public ClickableHeaderImageView bch;
    public TextView bci;
    public ViewStub bcj;
    public TbImageView bck;
    private boolean bcl;
    private View.OnClickListener bcm;
    private View.OnClickListener bcn;
    private View.OnClickListener bco;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.bbM = true;
        this.bcl = false;
        this.mFrom = 1;
        this.bcn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Ea();
            }
        };
        this.bco = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aYc != null && ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yZ() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bcm != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bcm.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbM = true;
        this.bcl = false;
        this.mFrom = 1;
        this.bcn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Ea();
            }
        };
        this.bco = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aYc != null && ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yZ() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bcm != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bcm.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbM = true;
        this.bcl = false;
        this.mFrom = 1;
        this.bcn = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Ea();
            }
        };
        this.bco = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aYc != null && ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yZ() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aYc.zV().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yT().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bcm != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bcm.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.bch = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bcj = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.bci = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.bbs = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bbw = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bbC = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bbD = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bci.setOnClickListener(this.bco);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aYc = bdVar;
        h(bdVar);
        i(bdVar);
        e(bdVar);
        d(bdVar);
        setVisibility(0);
        return true;
    }

    private void initHeaderImg() {
        if (this.bch != null) {
            this.bch.setDefaultResource(17170445);
            this.bch.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bch.setDefaultBgResource(d.C0108d.cp_bg_line_e);
            this.bch.setIsRound(true);
            this.bch.setAfterClickListener(this.bcm);
        }
    }

    private void h(bd bdVar) {
        if (this.bch != null && bdVar != null) {
            if (this.bcl) {
                this.bch.setVisibility(8);
                return;
            }
            this.bch.setVisibility(0);
            this.bch.setData(bdVar);
            UserTbVipInfoData yU = bdVar.yU();
            if (yU != null && yU.getvipV_url() != null && this.bcj != null) {
                if (this.bck == null) {
                    this.bcj.inflate();
                    this.bck = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.bck.startLoad(yU.getvipV_url(), 10, false);
                this.bch.setIsBigV(true);
            }
        }
    }

    private void i(bd bdVar) {
        if (this.bci != null && bdVar != null && !StringUtils.isNull(this.aYc.yT().getName_show())) {
            this.bci.setText(am.getFixedText(this.aYc.yT().getName_show(), 8, true));
        }
    }

    private void d(bd bdVar) {
        String A;
        if (this.bbs != null && bdVar != null) {
            if (bdVar.yN() <= 0 || !this.bbM) {
                this.bbs.setVisibility(8);
                return;
            }
            this.bbs.setVisibility(0);
            if (this.mFrom == 2) {
                A = am.y(bdVar.yN());
            } else {
                A = am.A(bdVar.yN() * 1000);
            }
            this.bbs.setText(A);
        }
    }

    private void e(bd bdVar) {
        if (this.bbw != null && bdVar != null) {
            if (bdVar.yL() >= 0) {
                this.bbw.setVisibility(0);
                this.bbw.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.yL())));
                return;
            }
            this.bbw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bbE, new b.InterfaceC0073b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayoutNew.this.bbF, i);
                    if (!StringUtils.isNull(str)) {
                        av.Da().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AE();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bci, d.C0108d.cp_cont_d);
        aj.r(this.bbs, d.C0108d.cp_cont_d);
        aj.r(this.bbw, d.C0108d.cp_cont_d);
        aj.s(this.bbC, d.f.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.bbM = z;
    }

    public View getCommentNumView() {
        return this.bbw;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.bbw.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.bcl = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bcm = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bch != null) {
            this.bch.setPageId(bdUniqueId);
        }
    }

    public void Eb() {
        this.bch.setClickable(false);
        this.bci.setClickable(false);
    }
}
