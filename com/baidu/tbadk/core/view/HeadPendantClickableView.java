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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private be aXV;
    private View.OnClickListener aXW;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aXV != null && HeadPendantClickableView.this.aXV.yX() != null && !StringUtils.isNull(HeadPendantClickableView.this.aXV.yX().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aXV.yX().getUserId())) {
                    if (HeadPendantClickableView.this.aXV.Ac() != null && HeadPendantClickableView.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aXV.Ac().channelId, HeadPendantClickableView.this.aXV.Ac().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aXV.yX().getUserId(), HeadPendantClickableView.this.aXV.yX().getName_show(), HeadPendantClickableView.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aXW != null) {
                        HeadPendantClickableView.this.aXW.onClick(view);
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
                if (HeadPendantClickableView.this.aXV != null && HeadPendantClickableView.this.aXV.yX() != null && !StringUtils.isNull(HeadPendantClickableView.this.aXV.yX().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aXV.yX().getUserId())) {
                    if (HeadPendantClickableView.this.aXV.Ac() != null && HeadPendantClickableView.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aXV.Ac().channelId, HeadPendantClickableView.this.aXV.Ac().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aXV.yX().getUserId(), HeadPendantClickableView.this.aXV.yX().getName_show(), HeadPendantClickableView.this.aXV.zd(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aXW != null) {
                        HeadPendantClickableView.this.aXW.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(be beVar) {
        if (beVar != null && beVar.yX() != null) {
            this.aXV = beVar;
            MetaData yX = beVar.yX();
            setContentDescription(yX.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(yX.getUserId());
            getHeadView().setUserName(yX.getUserName());
            getHeadView().setUrl(yX.getPortrait());
            bk Ac = beVar.Ac();
            if (Ac != null && Ac.channelId > 0) {
                getHeadView().startLoad(Ac.channelAvatar, 10, false);
            } else {
                getHeadView().startLoad(beVar.yX().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.h pendantData = yX.getPendantData();
            if (Ac != null && Ac.channelId > 0) {
                ez(null);
            } else if (pendantData != null) {
                ez(beVar.yX().getPendantData().xu());
            } else {
                ez(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            be beVar = new be();
            beVar.a(metaData);
            setData(beVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aXW = onClickListener;
    }
}
