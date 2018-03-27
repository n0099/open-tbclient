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
    private bd aZC;
    public ClickableHeaderImageView bdO;
    public TextView bdP;
    public ViewStub bdQ;
    public TbImageView bdR;
    private boolean bdS;
    private View.OnClickListener bdT;
    private View.OnClickListener bdU;
    private View.OnClickListener bdV;
    private TextView bda;
    private TextView bde;
    private TextView bdk;
    private FrameLayout bdl;
    private List<CharSequence> bdm;
    private List<String> bdn;
    private boolean bdu;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.bdu = true;
        this.bdS = false;
        this.mFrom = 1;
        this.bdU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Ev();
            }
        };
        this.bdV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aZC != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bdT != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bdT.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdu = true;
        this.bdS = false;
        this.mFrom = 1;
        this.bdU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Ev();
            }
        };
        this.bdV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aZC != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bdT != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bdT.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdu = true;
        this.bdS = false;
        this.mFrom = 1;
        this.bdU = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.Ev();
            }
        };
        this.bdV = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.aZC != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zt() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao() != null && ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.aZC.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zn().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.aZC.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.bdT != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.bdT.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.bdO = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.bdQ = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.bdP = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.bda = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.bde = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.bdk = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.bdl = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.bdP.setOnClickListener(this.bdV);
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZC = bdVar;
        h(bdVar);
        i(bdVar);
        e(bdVar);
        d(bdVar);
        setVisibility(0);
        return true;
    }

    private void initHeaderImg() {
        if (this.bdO != null) {
            this.bdO.setDefaultResource(17170445);
            this.bdO.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bdO.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.bdO.setIsRound(true);
            this.bdO.setAfterClickListener(this.bdT);
        }
    }

    private void h(bd bdVar) {
        if (this.bdO != null && bdVar != null) {
            if (this.bdS) {
                this.bdO.setVisibility(8);
                return;
            }
            this.bdO.setVisibility(0);
            this.bdO.setData(bdVar);
            UserTbVipInfoData zo = bdVar.zo();
            if (zo != null && zo.getvipV_url() != null && this.bdQ != null) {
                if (this.bdR == null) {
                    this.bdQ.inflate();
                    this.bdR = (TbImageView) findViewById(d.g.user_head_mask);
                }
                this.bdR.startLoad(zo.getvipV_url(), 10, false);
                this.bdO.setIsBigV(true);
            }
        }
    }

    private void i(bd bdVar) {
        if (this.bdP != null && bdVar != null && !StringUtils.isNull(this.aZC.zn().getName_show())) {
            this.bdP.setText(am.getFixedText(this.aZC.zn().getName_show(), 8, true));
        }
    }

    private void d(bd bdVar) {
        String A;
        if (this.bda != null && bdVar != null) {
            if (bdVar.zh() <= 0 || !this.bdu) {
                this.bda.setVisibility(8);
                return;
            }
            this.bda.setVisibility(0);
            if (this.mFrom == 2) {
                A = am.y(bdVar.zh());
            } else {
                A = am.A(bdVar.zh() * 1000);
            }
            this.bda.setText(A);
        }
    }

    private void e(bd bdVar) {
        if (this.bde != null && bdVar != null) {
            if (bdVar.zf() >= 0) {
                this.bde.setVisibility(0);
                this.bde.setText(String.format(this.mContext.getString(d.j.comment_num_tip), am.C(bdVar.zf())));
                return;
            }
            this.bde.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ev() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(this.bdm, new b.InterfaceC0097b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) v.f(ThreadCommentAndPraiseInfoLayoutNew.this.bdn, i);
                    if (!StringUtils.isNull(str)) {
                        aw.Du().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AY();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bdP, d.C0141d.cp_cont_d);
        aj.r(this.bda, d.C0141d.cp_cont_d);
        aj.r(this.bde, d.C0141d.cp_cont_d);
        aj.s(this.bdk, d.f.btn_frs_more_selector);
    }

    public void setReplyTimeVisible(boolean z) {
        this.bdu = z;
    }

    public View getCommentNumView() {
        return this.bde;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.bde.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.bdS = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.bdT = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.bdO != null) {
            this.bdO.setPageId(bdUniqueId);
        }
    }

    public void Ew() {
        this.bdO.setClickable(false);
        this.bdP.setClickable(false);
    }
}
