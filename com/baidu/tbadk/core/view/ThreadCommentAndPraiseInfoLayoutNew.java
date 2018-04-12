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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bd alf;
    private TextView aoC;
    private FrameLayout aoD;
    private List<CharSequence> aoE;
    private List<String> aoF;
    private boolean aoM;
    private TextView aos;
    private TextView aow;
    public ClickableHeaderImageView apf;
    public TextView apg;
    public ViewStub aph;
    private boolean api;
    private View.OnClickListener apj;
    private View.OnClickListener apk;
    private View.OnClickListener apl;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.aoM = true;
        this.api = false;
        this.mFrom = 1;
        this.apk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xg();
            }
        };
        this.apl = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.alf != null && ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.alf.rV() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ() != null && ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.alf.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.apj != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.apj.onClick(view2);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoM = true;
        this.api = false;
        this.mFrom = 1;
        this.apk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xg();
            }
        };
        this.apl = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.alf != null && ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.alf.rV() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ() != null && ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.alf.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.apj != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.apj.onClick(view2);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoM = true;
        this.api = false;
        this.mFrom = 1;
        this.apk = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ThreadCommentAndPraiseInfoLayoutNew.this.xg();
            }
        };
        this.apl = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.alf != null && ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.alf.rV() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ() != null && ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.alf.sQ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.alf.rQ().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.alf.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.apj != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.apj.onClick(view2);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.apf = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.aph = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.apg = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.aos = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.aow = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.aoC = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.aoD = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.apg.setOnClickListener(this.apl);
    }

    private void initHeaderImg() {
        if (this.apf != null) {
            this.apf.setDefaultResource(17170445);
            this.apf.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.apf.setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.apf.setIsRound(true);
            this.apf.setAfterClickListener(this.apj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cd(d.k.operation);
            bVar.a(this.aoE, new b.InterfaceC0086b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                    String str = (String) v.c(ThreadCommentAndPraiseInfoLayoutNew.this.aoF, i);
                    if (!StringUtils.isNull(str)) {
                        ax.wg().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tG();
        }
    }

    public void setReplyTimeVisible(boolean z) {
        this.aoM = z;
    }

    public View getCommentNumView() {
        return this.aow;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.aow.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.api = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.apj = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.apf != null) {
            this.apf.setPageId(bdUniqueId);
        }
    }
}
