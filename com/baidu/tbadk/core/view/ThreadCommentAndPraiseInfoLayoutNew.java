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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bb atD;
    private TextView awP;
    private TextView awT;
    private TextView awZ;
    public ClickableHeaderImageView axK;
    public TextView axL;
    public ViewStub axM;
    private boolean axN;
    private View.OnClickListener axO;
    private View.OnClickListener axP;
    private View.OnClickListener axQ;
    private FrameLayout axa;
    private List<CharSequence> axb;
    private List<String> axc;
    private boolean axm;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.axm = true;
        this.axN = false;
        this.mFrom = 1;
        this.axP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AP();
            }
        };
        this.axQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atD != null && ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atD.vq() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.axO != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.axO.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axm = true;
        this.axN = false;
        this.mFrom = 1;
        this.axP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AP();
            }
        };
        this.axQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atD != null && ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atD.vq() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.axO != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.axO.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axm = true;
        this.axN = false;
        this.mFrom = 1;
        this.axP = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AP();
            }
        };
        this.axQ = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atD != null && ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atD.vq() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atD.wl().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atD.vk().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.axO != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.axO.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.axK = (ClickableHeaderImageView) inflate.findViewById(d.g.card_home_page_normal_thread_user_header);
        this.axM = (ViewStub) inflate.findViewById(d.g.viewstub_headimage_mask);
        this.axL = (TextView) inflate.findViewById(d.g.card_home_page_normal_thread_user_name);
        this.awP = (TextView) inflate.findViewById(d.g.thread_info_reply_time);
        this.awT = (TextView) inflate.findViewById(d.g.thread_info_commont_num);
        this.awZ = (TextView) inflate.findViewById(d.g.thread_info_more);
        this.axa = (FrameLayout) inflate.findViewById(d.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.axL.setOnClickListener(this.axQ);
    }

    private void initHeaderImg() {
        if (this.axK != null) {
            this.axK.setDefaultResource(17170445);
            this.axK.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.axK.setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.axK.setIsRound(true);
            this.axK.setAfterClickListener(this.axO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AP() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.ci(d.j.operation);
            bVar.a(this.axb, new b.InterfaceC0101b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) w.d(ThreadCommentAndPraiseInfoLayoutNew.this.axc, i);
                    if (!StringUtils.isNull(str)) {
                        ay.zK().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xi();
        }
    }

    public void setReplyTimeVisible(boolean z) {
        this.axm = z;
    }

    public View getCommentNumView() {
        return this.awT;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.awT.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.axN = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axO = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axK != null) {
            this.axK.setPageId(bdUniqueId);
        }
    }
}
