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
    private bd ajJ;
    private boolean anD;
    public ClickableHeaderImageView anY;
    public TextView anZ;
    private TextView anj;
    private TextView ann;
    private TextView ant;
    private FrameLayout anu;
    private List<CharSequence> anv;
    private List<String> anw;
    public ViewStub aoa;
    public TbImageView aob;
    private boolean aoc;
    private View.OnClickListener aod;
    private View.OnClickListener aoe;
    private View.OnClickListener aof;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.anD = true;
        this.aoc = false;
        this.mFrom = 1;
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wJ();
            }
        };
        this.aof = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajJ != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rB() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aod != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aod.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anD = true;
        this.aoc = false;
        this.mFrom = 1;
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wJ();
            }
        };
        this.aof = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajJ != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rB() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aod != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aod.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anD = true;
        this.aoc = false;
        this.mFrom = 1;
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wJ();
            }
        };
        this.aof = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajJ != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rB() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rv().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aod != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aod.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.anY = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.aoa = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.anZ = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.anj = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.ann = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.ant = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.anu = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.anZ.setOnClickListener(this.aof);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajJ = bdVar;
        h(bdVar);
        i(bdVar);
        e(bdVar);
        d(bdVar);
        setVisibility(0);
        return true;
    }

    private void initHeaderImg() {
        if (this.anY != null) {
            this.anY.setDefaultResource(17170445);
            this.anY.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.anY.setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.anY.setIsRound(true);
            this.anY.setAfterClickListener(this.aod);
        }
    }

    private void h(bd bdVar) {
        if (this.anY != null && bdVar != null) {
            if (this.aoc) {
                this.anY.setVisibility(8);
                return;
            }
            this.anY.setVisibility(0);
            this.anY.setData(bdVar);
            UserTbVipInfoData rw = bdVar.rw();
            if (rw != null && rw.getvipV_url() != null && this.aoa != null) {
                if (this.aob == null) {
                    this.aoa.inflate();
                    this.aob = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.aob.startLoad(rw.getvipV_url(), 10, false);
                this.anY.setIsBigV(true);
            }
        }
    }

    private void i(bd bdVar) {
        if (this.anZ != null && bdVar != null && !StringUtils.isNull(this.ajJ.rv().getName_show())) {
            this.anZ.setText(am.getFixedText(this.ajJ.rv().getName_show(), 8, true));
        }
    }

    private void d(bd bdVar) {
        String s;
        if (this.anj != null && bdVar != null) {
            if (bdVar.rp() <= 0 || !this.anD) {
                this.anj.setVisibility(8);
                return;
            }
            this.anj.setVisibility(0);
            if (this.mFrom == 2) {
                s = am.q(bdVar.rp());
            } else {
                s = am.s(bdVar.rp() * 1000);
            }
            this.anj.setText(s);
        }
    }

    private void e(bd bdVar) {
        if (this.ann != null && bdVar != null) {
            if (bdVar.rn() >= 0) {
                this.ann.setVisibility(0);
                this.ann.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.u(bdVar.rn())));
                return;
            }
            this.ann.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.j.operation);
            bVar.a(this.anv, new b.InterfaceC0061b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayoutNew.this.anw, i);
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
        aj.i(this.anZ, d.C0096d.cp_cont_d);
        aj.i(this.anj, d.C0096d.cp_cont_d);
        aj.i(this.ann, d.C0096d.cp_cont_d);
        aj.j(this.ant, d.f.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.anD = z;
    }

    public View getCommentNumView() {
        return this.ann;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.ann.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoc = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aod = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anY != null) {
            this.anY.setPageId(bdUniqueId);
        }
    }

    public void wK() {
        this.anY.setClickable(false);
        this.anZ.setClickable(false);
    }
}
