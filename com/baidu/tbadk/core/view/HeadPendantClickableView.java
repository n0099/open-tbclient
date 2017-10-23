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
    private bh aiU;
    private View.OnClickListener aiV;
    protected com.baidu.tbadk.d.a aiW;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aiW = aVar;
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.aiW == null || !HeadPendantClickableView.this.aiW.s(view)) && HeadPendantClickableView.this.aiU != null && HeadPendantClickableView.this.aiU.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aiU.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.aiU.ss() != null && HeadPendantClickableView.this.aiU.ss().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aiU.ss().channelId, HeadPendantClickableView.this.aiU.ss().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aiU.getAuthor().getUserId(), HeadPendantClickableView.this.aiU.getAuthor().getName_show(), HeadPendantClickableView.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aiV != null) {
                        HeadPendantClickableView.this.aiV.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.ajN = l.f(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.aiW == null || !HeadPendantClickableView.this.aiW.s(view)) && HeadPendantClickableView.this.aiU != null && HeadPendantClickableView.this.aiU.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aiU.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.aiU.ss() != null && HeadPendantClickableView.this.aiU.ss().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aiU.ss().channelId, HeadPendantClickableView.this.aiU.ss().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aiU.getAuthor().getUserId(), HeadPendantClickableView.this.aiU.getAuthor().getName_show(), HeadPendantClickableView.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aiV != null) {
                        HeadPendantClickableView.this.aiV.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.ajN = l.f(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.getAuthor() != null) {
            this.aiU = bhVar;
            MetaData author = bhVar.getAuthor();
            setContentDescription(author.getName_show() + this.mContext.getString(d.l.somebodys_portrait));
            getHeadView().setUserId(author.getUserId());
            getHeadView().setUserName(author.getUserName());
            getHeadView().setUrl(author.getPortrait());
            bm ss = bhVar.ss();
            if (ss != null && ss.channelId > 0) {
                getHeadView().c(ss.channelAvatar, 10, false);
            } else {
                getHeadView().c(bhVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.i pendantData = author.getPendantData();
            if (ss != null && ss.channelId > 0) {
                eh(null);
            } else if (pendantData != null) {
                eh(bhVar.getAuthor().getPendantData().pL());
            } else {
                eh(null);
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
        this.aiV = onClickListener;
    }
}
