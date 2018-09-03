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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes2.dex */
public class ThreadCommentAndPraiseInfoLayoutNew extends LinearLayout {
    private bb atE;
    private TextView awM;
    private TextView awQ;
    private TextView awW;
    private FrameLayout awX;
    private List<CharSequence> awY;
    private List<String> awZ;
    public ClickableHeaderImageView axH;
    public TextView axI;
    public ViewStub axJ;
    private boolean axK;
    private View.OnClickListener axL;
    private View.OnClickListener axM;
    private View.OnClickListener axN;
    private boolean axj;
    private Context mContext;
    private int mFrom;
    private TbPageContext mPageContext;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context) {
        super(context);
        this.axj = true;
        this.axK = false;
        this.mFrom = 1;
        this.axM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AM();
            }
        };
        this.axN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atE != null && ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atE.vp() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.axL != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.axL.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axj = true;
        this.axK = false;
        this.mFrom = 1;
        this.axM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AM();
            }
        };
        this.axN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atE != null && ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atE.vp() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.axL != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.axL.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayoutNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axj = true;
        this.axK = false;
        this.mFrom = 1;
        this.axM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadCommentAndPraiseInfoLayoutNew.this.AM();
            }
        };
        this.axN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadCommentAndPraiseInfoLayoutNew.this.atE != null && ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj() != null && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getName_show()) && !StringUtils.isNull(ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getUserId()) && ThreadCommentAndPraiseInfoLayoutNew.this.atE.vp() != null) {
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk() != null && ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk().channelId, ThreadCommentAndPraiseInfoLayoutNew.this.atE.wk().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(ThreadCommentAndPraiseInfoLayoutNew.this.mContext, ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getUserId(), ThreadCommentAndPraiseInfoLayoutNew.this.atE.vj().getName_show(), ThreadCommentAndPraiseInfoLayoutNew.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (ThreadCommentAndPraiseInfoLayoutNew.this.axL != null) {
                        ThreadCommentAndPraiseInfoLayoutNew.this.axL.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(f.h.thread_comment_and_praise_info_layout_new, (ViewGroup) this, true);
        this.axH = (ClickableHeaderImageView) inflate.findViewById(f.g.card_home_page_normal_thread_user_header);
        this.axJ = (ViewStub) inflate.findViewById(f.g.viewstub_headimage_mask);
        this.axI = (TextView) inflate.findViewById(f.g.card_home_page_normal_thread_user_name);
        this.awM = (TextView) inflate.findViewById(f.g.thread_info_reply_time);
        this.awQ = (TextView) inflate.findViewById(f.g.thread_info_commont_num);
        this.awW = (TextView) inflate.findViewById(f.g.thread_info_more);
        this.awX = (FrameLayout) inflate.findViewById(f.g.thread_info_more_frame);
        setVerticalGravity(16);
        this.mContext = context;
        initHeaderImg();
        this.axI.setOnClickListener(this.axN);
    }

    private void initHeaderImg() {
        if (this.axH != null) {
            this.axH.setDefaultResource(17170445);
            this.axH.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.axH.setDefaultBgResource(f.d.cp_bg_line_e);
            this.axH.setIsRound(true);
            this.axH.setAfterClickListener(this.axL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM() {
        if (this.mPageContext != null) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.ci(f.j.operation);
            bVar.a(this.awY, new b.InterfaceC0101b() { // from class: com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayoutNew.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    String str = (String) w.d(ThreadCommentAndPraiseInfoLayoutNew.this.awZ, i);
                    if (!StringUtils.isNull(str)) {
                        az.zI().c(ThreadCommentAndPraiseInfoLayoutNew.this.mPageContext, new String[]{str});
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xh();
        }
    }

    public void setReplyTimeVisible(boolean z) {
        this.axj = z;
    }

    public View getCommentNumView() {
        return this.awQ;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.awQ.setOnClickListener(onClickListener);
    }

    public void setIsSimpleThread(boolean z) {
        this.axK = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.axL = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.axH != null) {
            this.axH.setPageId(bdUniqueId);
        }
    }
}
