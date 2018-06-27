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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bc atZ;
    private boolean axG;
    private TextView axj;
    private TextView axn;
    private TextView axt;
    private FrameLayout axu;
    private List<CharSequence> axv;
    private List<String> axw;
    public ClickableHeaderImageView aye;
    public TextView ayf;
    public ViewStub ayg;
    private boolean ayh;
    private View.OnClickListener ayi;
    private View.OnClickListener ayj;
    private View.OnClickListener ayk;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.axG = true;
        this.ayh = false;
        this.mFrom = 1;
        this.ayj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AY();
            }
        };
        this.ayk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atZ != null && ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vB() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ayi != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.ayi.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axG = true;
        this.ayh = false;
        this.mFrom = 1;
        this.ayj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AY();
            }
        };
        this.ayk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atZ != null && ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vB() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ayi != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.ayi.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axG = true;
        this.ayh = false;
        this.mFrom = 1;
        this.ayj = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AY();
            }
        };
        this.ayk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atZ != null && ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vB() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atZ.ww().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vw().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.ayi != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.ayi.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.aye = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.ayg = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.ayf = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.axj = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.axn = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.axt = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.axu = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.ayf.setOnClickListener(this.ayk);
    }

    private void initHeaderImg() {
        if (this.aye != null) {
            this.aye.setDefaultResource(17170445);
            this.aye.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.aye.setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.aye.setIsRound(true);
            this.aye.setAfterClickListener(this.ayi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.k.operation);
            bVar.a(this.axv, new b.InterfaceC0104b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) w.d(ThreadCommentAndPraiseInfoLayoutNew.this.axw, i);
                    if (!StringUtils.isNull(str)) {
                        az.zV().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xq();
        }
    }

    public void setReplyTimeVisible(boolean z) {
        this.axG = z;
    }

    public View getCommentNumView() {
        return this.axn;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.axn.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.ayh = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ayi = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aye != null) {
            this.aye.setPageId(bdUniqueId);
        }
    }
}
