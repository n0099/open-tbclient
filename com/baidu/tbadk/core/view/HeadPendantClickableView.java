package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bh ajg;
    private View.OnClickListener ajh;
    protected com.baidu.tbadk.d.a aji;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aji = aVar;
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.aji == null || !HeadPendantClickableView.this.aji.s(view)) && HeadPendantClickableView.this.ajg != null && HeadPendantClickableView.this.ajg.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajg.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.ajg.sz() != null && HeadPendantClickableView.this.ajg.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajg.sz().channelId, HeadPendantClickableView.this.ajg.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajg.getAuthor().getUserId(), HeadPendantClickableView.this.ajg.getAuthor().getName_show(), HeadPendantClickableView.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajh != null) {
                        HeadPendantClickableView.this.ajh.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.ajZ = l.f(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.aji == null || !HeadPendantClickableView.this.aji.s(view)) && HeadPendantClickableView.this.ajg != null && HeadPendantClickableView.this.ajg.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajg.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.ajg.sz() != null && HeadPendantClickableView.this.ajg.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajg.sz().channelId, HeadPendantClickableView.this.ajg.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajg.getAuthor().getUserId(), HeadPendantClickableView.this.ajg.getAuthor().getName_show(), HeadPendantClickableView.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajh != null) {
                        HeadPendantClickableView.this.ajh.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.ajZ = l.f(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.getAuthor() != null) {
            this.ajg = bhVar;
            MetaData author = bhVar.getAuthor();
            setContentDescription(author.getName_show() + this.mContext.getString(d.l.somebodys_portrait));
            getHeadView().setUserId(author.getUserId());
            getHeadView().setUserName(author.getUserName());
            getHeadView().setUrl(author.getPortrait());
            bm sz = bhVar.sz();
            if (sz != null && sz.channelId > 0) {
                getHeadView().c(sz.channelAvatar, 10, false);
            } else {
                getHeadView().c(bhVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.i pendantData = author.getPendantData();
            if (sz != null && sz.channelId > 0) {
                ei(null);
            } else if (pendantData != null) {
                ei(bhVar.getAuthor().getPendantData().pS());
            } else {
                ei(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bh bhVar = new bh();
            bhVar.setAuthor(metaData);
            setData(bhVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajh = onClickListener;
    }
}
