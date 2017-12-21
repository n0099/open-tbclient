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
    private bd ajM;
    private boolean anG;
    private TextView anm;
    private TextView anq;
    private TextView anw;
    private FrameLayout anx;
    private List<CharSequence> any;
    private List<String> anz;
    public ClickableHeaderImageView aob;
    public TextView aoc;
    public ViewStub aod;
    public TbImageView aoe;
    private boolean aof;
    private View.OnClickListener aog;
    private View.OnClickListener aoh;
    private View.OnClickListener aoi;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.anG = true;
        this.aof = false;
        this.mFrom = 1;
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wJ();
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rB() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aog != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aog.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anG = true;
        this.aof = false;
        this.mFrom = 1;
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wJ();
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rB() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aog != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aog.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anG = true;
        this.aof = false;
        this.mFrom = 1;
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wJ();
            }
        };
        this.aoi = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rB() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rv().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aog != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aog.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.aob = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.aod = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.aoc = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.anm = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.anq = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.anw = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.anx = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.aoc.setOnClickListener(this.aoi);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajM = bdVar;
        h(bdVar);
        i(bdVar);
        e(bdVar);
        d(bdVar);
        setVisibility(0);
        return true;
    }

    private void initHeaderImg() {
        if (this.aob != null) {
            this.aob.setDefaultResource(17170445);
            this.aob.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.aob.setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.aob.setIsRound(true);
            this.aob.setAfterClickListener(this.aog);
        }
    }

    private void h(bd bdVar) {
        if (this.aob != null && bdVar != null) {
            if (this.aof) {
                this.aob.setVisibility(8);
                return;
            }
            this.aob.setVisibility(0);
            this.aob.setData(bdVar);
            UserTbVipInfoData rw = bdVar.rw();
            if (rw != null && rw.getvipV_url() != null && this.aod != null) {
                if (this.aoe == null) {
                    this.aod.inflate();
                    this.aoe = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.aoe.startLoad(rw.getvipV_url(), 10, false);
                this.aob.setIsBigV(true);
            }
        }
    }

    private void i(bd bdVar) {
        if (this.aoc != null && bdVar != null && !StringUtils.isNull(this.ajM.rv().getName_show())) {
            this.aoc.setText(am.getFixedText(this.ajM.rv().getName_show(), 8, true));
        }
    }

    private void d(bd bdVar) {
        String s;
        if (this.anm != null && bdVar != null) {
            if (bdVar.rp() <= 0 || !this.anG) {
                this.anm.setVisibility(8);
                return;
            }
            this.anm.setVisibility(0);
            if (this.mFrom == 2) {
                s = am.q(bdVar.rp());
            } else {
                s = am.s(bdVar.rp() * 1000);
            }
            this.anm.setText(s);
        }
    }

    private void e(bd bdVar) {
        if (this.anq != null && bdVar != null) {
            if (bdVar.rn() >= 0) {
                this.anq.setVisibility(0);
                this.anq.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.u(bdVar.rn())));
                return;
            }
            this.anq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.j.operation);
            bVar.a(this.any, new b.InterfaceC0060b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayoutNew.this.anz, i);
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
        aj.i(this.aoc, d.C0095d.cp_cont_d);
        aj.i(this.anm, d.C0095d.cp_cont_d);
        aj.i(this.anq, d.C0095d.cp_cont_d);
        aj.j(this.anw, d.f.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.anG = z;
    }

    public View getCommentNumView() {
        return this.anq;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.anq.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.aof = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aog = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aob != null) {
            this.aob.setPageId(bdUniqueId);
        }
    }

    public void wK() {
        this.aob.setClickable(false);
        this.aoc.setClickable(false);
    }
}
