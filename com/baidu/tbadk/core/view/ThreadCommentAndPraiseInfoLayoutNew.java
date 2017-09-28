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
    private bh ajg;
    private TextView amI;
    private TextView amO;
    private TextView amX;
    private FrameLayout amY;
    private List<CharSequence> amZ;
    public ClickableHeaderImageView anE;
    public TextView anF;
    public ViewStub anG;
    public TbImageView anH;
    private boolean anI;
    private View.OnClickListener anJ;
    private View.OnClickListener anK;
    private View.OnClickListener anL;
    private List<String> ana;
    private boolean ane;
    private Context mContext;
    private int mFrom;
    private TbPageContext mG;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.ane = true;
        this.anI = false;
        this.mFrom = 1;
        this.anK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wI();
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajg != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajg.rA() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anJ != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anJ.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ane = true;
        this.anI = false;
        this.mFrom = 1;
        this.anK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wI();
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajg != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajg.rA() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anJ != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anJ.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ane = true;
        this.anI = false;
        this.mFrom = 1;
        this.anK = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.wI();
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.ajg != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.ajg.rA() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz() != null && ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.ajg.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.ajg.getAuthor().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.anJ != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.anJ.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.anE = (ClickableHeaderImageView) inflate.findViewById(d.h.card_home_page_normal_thread_user_header);
        this.anG = (ViewStub) inflate.findViewById(d.h.viewstub_headimage_mask);
        this.anF = (TextView) inflate.findViewById(d.h.card_home_page_normal_thread_user_name);
        this.amI = (TextView) inflate.findViewById(d.h.thread_info_reply_time);
        this.amO = (TextView) inflate.findViewById(d.h.thread_info_commont_num);
        this.amX = (TextView) inflate.findViewById(d.h.thread_info_more);
        this.amY = (FrameLayout) inflate.findViewById(d.h.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        wJ();
        this.anF.setOnClickListener(this.anL);
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajg = bhVar;
        j(bhVar);
        k(bhVar);
        f(bhVar);
        d(bhVar);
        setVisibility(0);
        return true;
    }

    private void wJ() {
        if (this.anE != null) {
            this.anE.setDefaultResource(17170445);
            this.anE.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.anE.setDefaultBgResource(d.e.cp_bg_line_e);
            this.anE.setIsRound(true);
            this.anE.setAfterClickListener(this.anJ);
        }
    }

    private void j(bh bhVar) {
        if (this.anE != null && bhVar != null) {
            if (this.anI) {
                this.anE.setVisibility(8);
                return;
            }
            this.anE.setVisibility(0);
            this.anE.setData(bhVar);
            UserTbVipInfoData rv = bhVar.rv();
            if (rv != null && rv.getvipV_url() != null && this.anG != null) {
                if (this.anH == null) {
                    this.anG.inflate();
                    this.anH = (TbImageView) findViewById(d.h.user_head_mask);
                }
                this.anH.c(rv.getvipV_url(), 10, false);
                this.anE.setIsBigV(true);
            }
        }
    }

    private void k(bh bhVar) {
        if (this.anF != null && bhVar != null && !StringUtils.isNull(this.ajg.getAuthor().getName_show())) {
            this.anF.setText(am.getFixedText(this.ajg.getAuthor().getName_show(), 8, true));
        }
    }

    private void d(bh bhVar) {
        String r;
        if (this.amI != null && bhVar != null) {
            if (bhVar.rp() <= 0 || !this.ane) {
                this.amI.setVisibility(8);
                return;
            }
            this.amI.setVisibility(0);
            if (this.mFrom == 2) {
                r = am.p(bhVar.rp());
            } else {
                r = am.r(bhVar.rp() * 1000);
            }
            this.amI.setText(r);
        }
    }

    private void f(bh bhVar) {
        if (this.amO != null && bhVar != null) {
            if (bhVar.rn() >= 0) {
                this.amO.setVisibility(0);
                this.amO.setText(String.format(this.mContext.getString(d.l.comment_num_tip), am.t(bhVar.rn())));
                return;
            }
            this.amO.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI() {
        if (this.mG != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mG.getPageActivity());
            bVar.cg(d.l.operation);
            bVar.a(this.amZ, new b.InterfaceC0047b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayoutNew.this.ana, i);
                    if (!StringUtils.isNull(str)) {
                        av.vH().c(ThreadCommentAndPraiseInfoLayoutNew.this.mG, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mG);
            bVar.tl();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.anF, d.e.cp_cont_d);
        aj.i(this.amI, d.e.cp_cont_d);
        aj.i(this.amO, d.e.cp_cont_d);
        aj.j(this.amX, d.g.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.ane = z;
    }

    public View getCommentNumView() {
        return this.amO;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.amO.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.anI = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anJ = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anE != null) {
            this.anE.setPageId(bdUniqueId);
        }
    }

    public void wK() {
        this.anE.setClickable(false);
        this.anF.setClickable(false);
    }
}
