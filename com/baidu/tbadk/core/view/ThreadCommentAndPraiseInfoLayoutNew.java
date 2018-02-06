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
    private bd aZM;
    private boolean bdE;
    public ClickableHeaderImageView bdX;
    public TextView bdY;
    public ViewStub bdZ;
    private TextView bdk;
    private TextView bdo;
    private TextView bdu;
    private FrameLayout bdv;
    private List<CharSequence> bdw;
    private List<String> bdx;
    public TbImageView bea;
    private boolean beb;
    private View.OnClickListener bec;
    private View.OnClickListener bed;
    private View.OnClickListener bee;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.bdE = true;
        this.beb = false;
        this.mFrom = 1;
        this.bed = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Ev();
            }
        };
        this.bee = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aZM != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bec != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bec.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdE = true;
        this.beb = false;
        this.mFrom = 1;
        this.bed = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Ev();
            }
        };
        this.bee = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aZM != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bec != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bec.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdE = true;
        this.beb = false;
        this.mFrom = 1;
        this.bed = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Ev();
            }
        };
        this.bee = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aZM != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aZM.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zn().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bec != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bec.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.bdX = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bdZ = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.bdY = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.bdk = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bdo = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bdu = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bdv = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bdY.setOnClickListener(this.bee);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZM = bdVar;
        h(bdVar);
        i(bdVar);
        e(bdVar);
        d(bdVar);
        setVisibility(0);
        return true;
    }

    private void initHeaderImg() {
        if (this.bdX != null) {
            this.bdX.setDefaultResource(17170445);
            this.bdX.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bdX.setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.bdX.setIsRound(true);
            this.bdX.setAfterClickListener(this.bec);
        }
    }

    private void h(bd bdVar) {
        if (this.bdX != null && bdVar != null) {
            if (this.beb) {
                this.bdX.setVisibility(8);
                return;
            }
            this.bdX.setVisibility(0);
            this.bdX.setData(bdVar);
            UserTbVipInfoData zo = bdVar.zo();
            if (zo != null && zo.getvipV_url() != null && this.bdZ != null) {
                if (this.bea == null) {
                    this.bdZ.inflate();
                    this.bea = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.bea.startLoad(zo.getvipV_url(), 10, false);
                this.bdX.setIsBigV(true);
            }
        }
    }

    private void i(bd bdVar) {
        if (this.bdY != null && bdVar != null && !StringUtils.isNull(this.aZM.zn().getName_show())) {
            this.bdY.setText(am.getFixedText(this.aZM.zn().getName_show(), 8, true));
        }
    }

    private void d(bd bdVar) {
        String A;
        if (this.bdk != null && bdVar != null) {
            if (bdVar.zh() <= 0 || !this.bdE) {
                this.bdk.setVisibility(8);
                return;
            }
            this.bdk.setVisibility(0);
            if (this.mFrom == 2) {
                A = am.y(bdVar.zh());
            } else {
                A = am.A(bdVar.zh() * 1000);
            }
            this.bdk.setText(A);
        }
    }

    private void e(bd bdVar) {
        if (this.bdo != null && bdVar != null) {
            if (bdVar.zf() >= 0) {
                this.bdo.setVisibility(0);
                this.bdo.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.zf())));
                return;
            }
            this.bdo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ev() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bdw, new b.InterfaceC0096b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayoutNew.this.bdx, i);
                    if (!StringUtils.isNull(str)) {
                        aw.Du().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AX();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bdY, d.C0140d.cp_cont_d);
        aj.r(this.bdk, d.C0140d.cp_cont_d);
        aj.r(this.bdo, d.C0140d.cp_cont_d);
        aj.s(this.bdu, d.f.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.bdE = z;
    }

    public View getCommentNumView() {
        return this.bdo;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.bdo.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.beb = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bec = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bdX != null) {
            this.bdX.setPageId(bdUniqueId);
        }
    }

    public void Ew() {
        this.bdX.setClickable(false);
        this.bdY.setClickable(false);
    }
}
