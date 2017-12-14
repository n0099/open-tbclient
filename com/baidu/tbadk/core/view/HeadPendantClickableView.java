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
    private bd ajJ;
    private View.OnClickListener ajK;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.ajJ != null && HeadPendantClickableView.this.ajJ.rv() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajJ.rv().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajJ.rv().getUserId())) {
                    if (HeadPendantClickableView.this.ajJ.sA() != null && HeadPendantClickableView.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajJ.sA().channelId, HeadPendantClickableView.this.ajJ.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajJ.rv().getUserId(), HeadPendantClickableView.this.ajJ.rv().getName_show(), HeadPendantClickableView.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajK != null) {
                        HeadPendantClickableView.this.ajK.onClick(view);
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
                if (HeadPendantClickableView.this.ajJ != null && HeadPendantClickableView.this.ajJ.rv() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajJ.rv().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajJ.rv().getUserId())) {
                    if (HeadPendantClickableView.this.ajJ.sA() != null && HeadPendantClickableView.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajJ.sA().channelId, HeadPendantClickableView.this.ajJ.sA().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajJ.rv().getUserId(), HeadPendantClickableView.this.ajJ.rv().getName_show(), HeadPendantClickableView.this.ajJ.rB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajK != null) {
                        HeadPendantClickableView.this.ajK.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bd bdVar) {
        if (bdVar != null && bdVar.rv() != null) {
            this.ajJ = bdVar;
            MetaData rv = bdVar.rv();
            setContentDescription(rv.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(rv.getUserId());
            getHeadView().setUserName(rv.getUserName());
            getHeadView().setUrl(rv.getPortrait());
            bj sA = bdVar.sA();
            if (sA != null && sA.channelId > 0) {
                getHeadView().startLoad(sA.channelAvatar, 10, false);
            } else {
                getHeadView().startLoad(bdVar.rv().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.k pendantData = rv.getPendantData();
            if (sA != null && sA.channelId > 0) {
                es(null);
            } else if (pendantData != null) {
                es(bdVar.rv().getPendantData().pR());
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
        this.ajK = onClickListener;
    }
}
