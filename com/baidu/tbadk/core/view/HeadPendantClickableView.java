package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bj ajE;
    private View.OnClickListener ajF;
    protected com.baidu.tbadk.e.a ajG;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.ajG = aVar;
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.ajG == null || !HeadPendantClickableView.this.ajG.s(view)) && HeadPendantClickableView.this.ajE != null && HeadPendantClickableView.this.ajE.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajE.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.ajE.sF() != null && HeadPendantClickableView.this.ajE.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajE.sF().channelId, HeadPendantClickableView.this.ajE.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajE.getAuthor().getUserId(), HeadPendantClickableView.this.ajE.getAuthor().getName_show(), HeadPendantClickableView.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajF != null) {
                        HeadPendantClickableView.this.ajF.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.ajY = com.baidu.adp.lib.util.k.f(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.ajG == null || !HeadPendantClickableView.this.ajG.s(view)) && HeadPendantClickableView.this.ajE != null && HeadPendantClickableView.this.ajE.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajE.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.ajE.sF() != null && HeadPendantClickableView.this.ajE.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajE.sF().channelId, HeadPendantClickableView.this.ajE.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajE.getAuthor().getUserId(), HeadPendantClickableView.this.ajE.getAuthor().getName_show(), HeadPendantClickableView.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajF != null) {
                        HeadPendantClickableView.this.ajF.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.ajY = com.baidu.adp.lib.util.k.f(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.getAuthor() != null) {
            this.ajE = bjVar;
            MetaData author = bjVar.getAuthor();
            setContentDescription(author.getName_show() + this.mContext.getString(d.l.somebodys_portrait));
            getHeadView().setUserId(author.getUserId());
            getHeadView().setUserName(author.getUserName());
            getHeadView().setUrl(author.getPortrait());
            bo sF = bjVar.sF();
            if (sF != null && sF.channelId > 0) {
                getHeadView().c(sF.channelAvatar, 10, false);
            } else {
                getHeadView().c(bjVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = author.getPendantData();
            if (sF != null && sF.channelId > 0) {
                eq(null);
            } else if (pendantData != null) {
                eq(bjVar.getAuthor().getPendantData().pR());
            } else {
                eq(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bj bjVar = new bj();
            bjVar.setAuthor(metaData);
            setData(bjVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajF = onClickListener;
    }
}
