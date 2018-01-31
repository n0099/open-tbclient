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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bd aYc;
    private View.OnClickListener aYd;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aYc != null && HeadPendantClickableView.this.aYc.yT() != null && !StringUtils.isNull(HeadPendantClickableView.this.aYc.yT().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aYc.yT().getUserId())) {
                    if (HeadPendantClickableView.this.aYc.zV() != null && HeadPendantClickableView.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aYc.zV().channelId, HeadPendantClickableView.this.aYc.zV().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aYc.yT().getUserId(), HeadPendantClickableView.this.aYc.yT().getName_show(), HeadPendantClickableView.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aYd != null) {
                        HeadPendantClickableView.this.aYd.onClick(view);
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
                if (HeadPendantClickableView.this.aYc != null && HeadPendantClickableView.this.aYc.yT() != null && !StringUtils.isNull(HeadPendantClickableView.this.aYc.yT().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aYc.yT().getUserId())) {
                    if (HeadPendantClickableView.this.aYc.zV() != null && HeadPendantClickableView.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aYc.zV().channelId, HeadPendantClickableView.this.aYc.zV().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aYc.yT().getUserId(), HeadPendantClickableView.this.aYc.yT().getName_show(), HeadPendantClickableView.this.aYc.yZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aYd != null) {
                        HeadPendantClickableView.this.aYd.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bd bdVar) {
        if (bdVar != null && bdVar.yT() != null) {
            this.aYc = bdVar;
            MetaData yT = bdVar.yT();
            setContentDescription(yT.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(yT.getUserId());
            getHeadView().setUserName(yT.getUserName());
            getHeadView().setUrl(yT.getPortrait());
            bj zV = bdVar.zV();
            if (zV != null && zV.channelId > 0) {
                getHeadView().startLoad(zV.channelAvatar, 10, false);
            } else {
                getHeadView().startLoad(bdVar.yT().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.h pendantData = yT.getPendantData();
            if (zV != null && zV.channelId > 0) {
                eG(null);
            } else if (pendantData != null) {
                eG(bdVar.yT().getPendantData().xu());
            } else {
                eG(null);
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
        this.aYd = onClickListener;
    }
}
