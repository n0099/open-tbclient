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
import com.baidu.tbadk.data.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bd ajM;
    private View.OnClickListener ajN;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.ajM != null && HeadPendantClickableView.this.ajM.rx() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajM.rx().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajM.rx().getUserId())) {
                    if (HeadPendantClickableView.this.ajM.sC() != null && HeadPendantClickableView.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajM.sC().channelId, HeadPendantClickableView.this.ajM.sC().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajM.rx().getUserId(), HeadPendantClickableView.this.ajM.rx().getName_show(), HeadPendantClickableView.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajN != null) {
                        HeadPendantClickableView.this.ajN.onClick(view);
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
                if (HeadPendantClickableView.this.ajM != null && HeadPendantClickableView.this.ajM.rx() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajM.rx().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajM.rx().getUserId())) {
                    if (HeadPendantClickableView.this.ajM.sC() != null && HeadPendantClickableView.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajM.sC().channelId, HeadPendantClickableView.this.ajM.sC().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajM.rx().getUserId(), HeadPendantClickableView.this.ajM.rx().getName_show(), HeadPendantClickableView.this.ajM.rD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajN != null) {
                        HeadPendantClickableView.this.ajN.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bd bdVar) {
        if (bdVar != null && bdVar.rx() != null) {
            this.ajM = bdVar;
            MetaData rx = bdVar.rx();
            setContentDescription(rx.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(rx.getUserId());
            getHeadView().setUserName(rx.getUserName());
            getHeadView().setUrl(rx.getPortrait());
            bj sC = bdVar.sC();
            if (sC != null && sC.channelId > 0) {
                getHeadView().startLoad(sC.channelAvatar, 10, false);
            } else {
                getHeadView().startLoad(bdVar.rx().getPortrait(), 28, false);
            }
            k pendantData = rx.getPendantData();
            if (sC != null && sC.channelId > 0) {
                es(null);
            } else if (pendantData != null) {
                es(bdVar.rx().getPendantData().pT());
            } else {
                es(null);
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
        this.ajN = onClickListener;
    }
}
