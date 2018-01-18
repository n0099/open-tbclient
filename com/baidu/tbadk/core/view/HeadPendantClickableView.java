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
    private bd aXU;
    private View.OnClickListener aXV;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aXU != null && HeadPendantClickableView.this.aXU.yS() != null && !StringUtils.isNull(HeadPendantClickableView.this.aXU.yS().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aXU.yS().getUserId())) {
                    if (HeadPendantClickableView.this.aXU.zU() != null && HeadPendantClickableView.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aXU.zU().channelId, HeadPendantClickableView.this.aXU.zU().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aXU.yS().getUserId(), HeadPendantClickableView.this.aXU.yS().getName_show(), HeadPendantClickableView.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aXV != null) {
                        HeadPendantClickableView.this.aXV.onClick(view);
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
                if (HeadPendantClickableView.this.aXU != null && HeadPendantClickableView.this.aXU.yS() != null && !StringUtils.isNull(HeadPendantClickableView.this.aXU.yS().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aXU.yS().getUserId())) {
                    if (HeadPendantClickableView.this.aXU.zU() != null && HeadPendantClickableView.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aXU.zU().channelId, HeadPendantClickableView.this.aXU.zU().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aXU.yS().getUserId(), HeadPendantClickableView.this.aXU.yS().getName_show(), HeadPendantClickableView.this.aXU.yY(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aXV != null) {
                        HeadPendantClickableView.this.aXV.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bd bdVar) {
        if (bdVar != null && bdVar.yS() != null) {
            this.aXU = bdVar;
            MetaData yS = bdVar.yS();
            setContentDescription(yS.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(yS.getUserId());
            getHeadView().setUserName(yS.getUserName());
            getHeadView().setUrl(yS.getPortrait());
            bj zU = bdVar.zU();
            if (zU != null && zU.channelId > 0) {
                getHeadView().startLoad(zU.channelAvatar, 10, false);
            } else {
                getHeadView().startLoad(bdVar.yS().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.h pendantData = yS.getPendantData();
            if (zU != null && zU.channelId > 0) {
                ez(null);
            } else if (pendantData != null) {
                ez(bdVar.yS().getPendantData().xt());
            } else {
                ez(null);
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
        this.aXV = onClickListener;
    }
}
