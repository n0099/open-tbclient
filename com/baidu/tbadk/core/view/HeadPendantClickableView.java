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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bd aZM;
    private View.OnClickListener aZN;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aZM != null && HeadPendantClickableView.this.aZM.zn() != null && !StringUtils.isNull(HeadPendantClickableView.this.aZM.zn().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aZM.zn().getUserId())) {
                    if (HeadPendantClickableView.this.aZM.Ao() != null && HeadPendantClickableView.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aZM.Ao().channelId, HeadPendantClickableView.this.aZM.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aZM.zn().getUserId(), HeadPendantClickableView.this.aZM.zn().getName_show(), HeadPendantClickableView.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aZN != null) {
                        HeadPendantClickableView.this.aZN.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aZM != null && HeadPendantClickableView.this.aZM.zn() != null && !StringUtils.isNull(HeadPendantClickableView.this.aZM.zn().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aZM.zn().getUserId())) {
                    if (HeadPendantClickableView.this.aZM.Ao() != null && HeadPendantClickableView.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aZM.Ao().channelId, HeadPendantClickableView.this.aZM.Ao().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aZM.zn().getUserId(), HeadPendantClickableView.this.aZM.zn().getName_show(), HeadPendantClickableView.this.aZM.zt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aZN != null) {
                        HeadPendantClickableView.this.aZN.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bd bdVar) {
        if (bdVar != null && bdVar.zn() != null) {
            this.aZM = bdVar;
            MetaData zn = bdVar.zn();
            setContentDescription(zn.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(zn.getUserId());
            getHeadView().setUserName(zn.getUserName());
            getHeadView().setUrl(zn.getPortrait());
            bj Ao = bdVar.Ao();
            if (Ao != null && Ao.channelId > 0) {
                getHeadView().startLoad(Ao.channelAvatar, 10, false);
            } else {
                getHeadView().startLoad(bdVar.zn().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.h pendantData = zn.getPendantData();
            if (Ao != null && Ao.channelId > 0) {
                eS(null);
            } else if (pendantData != null) {
                eS(bdVar.zn().getPendantData().ya());
            } else {
                eS(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bd bdVar = new bd();
            bdVar.a(metaData);
            setData(bdVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aZN = onClickListener;
    }
}
