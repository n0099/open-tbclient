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
    private boolean anC;
    public ClickableHeaderImageView anW;
    public TextView anX;
    public ViewStub anY;
    public TbImageView anZ;
    private TextView anm;
    private TextView anq;
    private TextView anw;
    private FrameLayout anx;
    private List<CharSequence> any;
    private List<String> anz;
    private boolean aoa;
    private View.OnClickListener aob;
    private View.OnClickListener aoc;
    private View.OnClickListener aod;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.anC = true;
        this.aoa = false;
        this.mFrom = 1;
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wK();
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rD() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aob != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aob.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anC = true;
        this.aoa = false;
        this.mFrom = 1;
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wK();
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rD() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aob != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aob.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anC = true;
        this.aoa = false;
        this.mFrom = 1;
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wK();
            }
        };
        this.aod = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rD() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.sC().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rx().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aob != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.aob.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.anW = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.anY = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.anX = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.anm = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.anq = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.anw = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.anx = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.anX.setOnClickListener(this.aod);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajM = bdVar;
        g(bdVar);
        h(bdVar);
        e(bdVar);
        d(bdVar);
        setVisibility(0);
        return true;
    }

    private void initHeaderImg() {
        if (this.anW != null) {
            this.anW.setDefaultResource(17170445);
            this.anW.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.anW.setDefaultBgResource(d.C0082d.cp_bg_line_e);
            this.anW.setIsRound(true);
            this.anW.setAfterClickListener(this.aob);
        }
    }

    private void g(bd bdVar) {
        if (this.anW != null && bdVar != null) {
            if (this.aoa) {
                this.anW.setVisibility(8);
                return;
            }
            this.anW.setVisibility(0);
            this.anW.setData(bdVar);
            UserTbVipInfoData ry = bdVar.ry();
            if (ry != null && ry.getvipV_url() != null && this.anY != null) {
                if (this.anZ == null) {
                    this.anY.inflate();
                    this.anZ = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.anZ.startLoad(ry.getvipV_url(), 10, false);
                this.anW.setIsBigV(true);
            }
        }
    }

    private void h(bd bdVar) {
        if (this.anX != null && bdVar != null && !StringUtils.isNull(this.ajM.rx().getName_show())) {
            this.anX.setText(am.getFixedText(this.ajM.rx().getName_show(), 8, true));
        }
    }

    private void d(bd bdVar) {
        String s;
        if (this.anm != null && bdVar != null) {
            if (bdVar.rr() <= 0 || !this.anC) {
                this.anm.setVisibility(8);
                return;
            }
            this.anm.setVisibility(0);
            if (this.mFrom == 2) {
                s = am.q(bdVar.rr());
            } else {
                s = am.s(bdVar.rr() * 1000);
            }
            this.anm.setText(s);
        }
    }

    private void e(bd bdVar) {
        if (this.anq != null && bdVar != null) {
            if (bdVar.rp() >= 0) {
                this.anq.setVisibility(0);
                this.anq.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.u(bdVar.rp())));
                return;
            }
            this.anq.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wK() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.j.operation);
            bVar.a(this.any, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayoutNew.this.anz, i);
                    if (!StringUtils.isNull(str)) {
                        av.vL().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.to();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.anX, d.C0082d.cp_cont_d);
        aj.i(this.anm, d.C0082d.cp_cont_d);
        aj.i(this.anq, d.C0082d.cp_cont_d);
        aj.j(this.anw, d.f.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.anC = z;
    }

    public View getCommentNumView() {
        return this.anq;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.anq.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoa = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aob = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anW != null) {
            this.anW.setPageId(bdUniqueId);
        }
    }

    public void wL() {
        this.anW.setClickable(false);
        this.anX.setClickable(false);
    }
}
