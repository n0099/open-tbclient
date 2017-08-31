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
    private bj ajF;
    private View.OnClickListener ajG;
    protected com.baidu.tbadk.e.a ajH;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.ajH = aVar;
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.ajH == null || !HeadPendantClickableView.this.ajH.s(view)) && HeadPendantClickableView.this.ajF != null && HeadPendantClickableView.this.ajF.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajF.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.ajF.sF() != null && HeadPendantClickableView.this.ajF.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajF.sF().channelId, HeadPendantClickableView.this.ajF.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajF.getAuthor().getUserId(), HeadPendantClickableView.this.ajF.getAuthor().getName_show(), HeadPendantClickableView.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajG != null) {
                        HeadPendantClickableView.this.ajG.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.ajZ = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.ajH == null || !HeadPendantClickableView.this.ajH.s(view)) && HeadPendantClickableView.this.ajF != null && HeadPendantClickableView.this.ajF.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajF.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.ajF.sF() != null && HeadPendantClickableView.this.ajF.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajF.sF().channelId, HeadPendantClickableView.this.ajF.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajF.getAuthor().getUserId(), HeadPendantClickableView.this.ajF.getAuthor().getName_show(), HeadPendantClickableView.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajG != null) {
                        HeadPendantClickableView.this.ajG.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.ajZ = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.getAuthor() != null) {
            this.ajF = bjVar;
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
        this.ajG = onClickListener;
    }
}
