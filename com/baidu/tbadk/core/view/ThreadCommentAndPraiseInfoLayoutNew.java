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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bd atn;
    private TextView awA;
    private TextView awE;
    private TextView awK;
    private FrameLayout awL;
    private List<CharSequence> awM;
    private List<String> awN;
    private boolean awU;
    public ClickableHeaderImageView axn;
    public TextView axo;
    public ViewStub axp;
    private boolean axq;
    private View.OnClickListener axr;
    private View.OnClickListener axs;
    private View.OnClickListener axt;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.awU = true;
        this.axq = false;
        this.mFrom = 1;
        this.axs = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AG();
            }
        };
        this.axt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atn != null && ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atn.vr() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.axr != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.axr.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awU = true;
        this.axq = false;
        this.mFrom = 1;
        this.axs = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AG();
            }
        };
        this.axt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atn != null && ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atn.vr() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.axr != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.axr.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awU = true;
        this.axq = false;
        this.mFrom = 1;
        this.axs = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AG();
            }
        };
        this.axt = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atn != null && ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atn.vr() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atn.wm().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atn.vm().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.axr != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.axr.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.axn = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.axp = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.axo = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.awA = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.awE = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.awK = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.awL = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.axo.setOnClickListener(this.axt);
    }

    private void initHeaderImg() {
        if (this.axn != null) {
            this.axn.setDefaultResource(17170445);
            this.axn.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.axn.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.axn.setIsRound(true);
            this.axn.setAfterClickListener(this.axr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AG() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cf(d.k.operation);
            bVar.a(this.awM, new b.InterfaceC0103b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) w.c(ThreadCommentAndPraiseInfoLayoutNew.this.awN, i);
                    if (!StringUtils.isNull(str)) {
                        ay.zG().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xd();
        }
    }

    public void setReplyTimeVisible(boolean z) {
        this.awU = z;
    }

    public View getCommentNumView() {
        return this.awE;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.awE.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.axq = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axr = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axn != null) {
            this.axn.setPageId(bdUniqueId);
        }
    }
}
