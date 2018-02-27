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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bd aZA;
    private TextView bcY;
    public ClickableHeaderImageView bdL;
    public TextView bdM;
    public ViewStub bdN;
    public TbImageView bdO;
    private boolean bdP;
    private View.OnClickListener bdQ;
    private View.OnClickListener bdR;
    private View.OnClickListener bdS;
    private TextView bdc;
    private TextView bdi;
    private FrameLayout bdj;
    private List<CharSequence> bdk;
    private List<String> bdl;
    private boolean bds;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.bds = true;
        this.bdP = false;
        this.mFrom = 1;
        this.bdR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Eu();
            }
        };
        this.bdS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aZA != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bdQ != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bdQ.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bds = true;
        this.bdP = false;
        this.mFrom = 1;
        this.bdR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Eu();
            }
        };
        this.bdS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aZA != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bdQ != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bdQ.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bds = true;
        this.bdP = false;
        this.mFrom = 1;
        this.bdR = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Eu();
            }
        };
        this.bdS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aZA != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aZA.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zn().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aZA.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bdQ != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bdQ.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.bdL = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bdN = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.bdM = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.bcY = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bdc = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bdi = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bdj = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bdM.setOnClickListener(this.bdS);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZA = bdVar;
        h(bdVar);
        i(bdVar);
        e(bdVar);
        d(bdVar);
        setVisibility(0);
        return true;
    }

    private void initHeaderImg() {
        if (this.bdL != null) {
            this.bdL.setDefaultResource(17170445);
            this.bdL.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bdL.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bdL.setIsRound(true);
            this.bdL.setAfterClickListener(this.bdQ);
        }
    }

    private void h(bd bdVar) {
        if (this.bdL != null && bdVar != null) {
            if (this.bdP) {
                this.bdL.setVisibility(8);
                return;
            }
            this.bdL.setVisibility(0);
            this.bdL.setData(bdVar);
            UserTbVipInfoData zo = bdVar.zo();
            if (zo != null && zo.getvipV_url() != null && this.bdN != null) {
                if (this.bdO == null) {
                    this.bdN.inflate();
                    this.bdO = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.bdO.startLoad(zo.getvipV_url(), 10, false);
                this.bdL.setIsBigV(true);
            }
        }
    }

    private void i(bd bdVar) {
        if (this.bdM != null && bdVar != null && !StringUtils.isNull(this.aZA.zn().getName_show())) {
            this.bdM.setText(am.getFixedText(this.aZA.zn().getName_show(), 8, true));
        }
    }

    private void d(bd bdVar) {
        String A;
        if (this.bcY != null && bdVar != null) {
            if (bdVar.zh() <= 0 || !this.bds) {
                this.bcY.setVisibility(8);
                return;
            }
            this.bcY.setVisibility(0);
            if (this.mFrom == 2) {
                A = am.y(bdVar.zh());
            } else {
                A = am.A(bdVar.zh() * 1000);
            }
            this.bcY.setText(A);
        }
    }

    private void e(bd bdVar) {
        if (this.bdc != null && bdVar != null) {
            if (bdVar.zf() >= 0) {
                this.bdc.setVisibility(0);
                this.bdc.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.zf())));
                return;
            }
            this.bdc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eu() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bdk, new b.InterfaceC0097b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayoutNew.this.bdl, i);
                    if (!StringUtils.isNull(str)) {
                        aw.Dt().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AX();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bdM, d.C0141d.cp_cont_d);
        aj.r(this.bcY, d.C0141d.cp_cont_d);
        aj.r(this.bdc, d.C0141d.cp_cont_d);
        aj.s(this.bdi, d.f.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.bds = z;
    }

    public View getCommentNumView() {
        return this.bdc;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.bdc.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.bdP = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bdQ = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bdL != null) {
            this.bdL.setPageId(bdUniqueId);
        }
    }

    public void Ev() {
        this.bdL.setClickable(false);
        this.bdM.setClickable(false);
    }
}
