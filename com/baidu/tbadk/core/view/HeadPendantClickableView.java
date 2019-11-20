package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bh Fs;
    private View.OnClickListener clw;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.Fs != null && HeadPendantClickableView.this.Fs.aiE() != null && !StringUtils.isNull(HeadPendantClickableView.this.Fs.aiE().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.Fs.aiE().getUserId())) {
                    if (HeadPendantClickableView.this.Fs.ajN() != null && HeadPendantClickableView.this.Fs.ajN().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Fs.ajN().channelId, HeadPendantClickableView.this.Fs.ajN().Zv)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Fs.aiE().getUserId(), HeadPendantClickableView.this.Fs.aiE().getName_show(), HeadPendantClickableView.this.Fs.aiJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.clw != null) {
                        HeadPendantClickableView.this.clw.onClick(view);
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
                if (HeadPendantClickableView.this.Fs != null && HeadPendantClickableView.this.Fs.aiE() != null && !StringUtils.isNull(HeadPendantClickableView.this.Fs.aiE().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.Fs.aiE().getUserId())) {
                    if (HeadPendantClickableView.this.Fs.ajN() != null && HeadPendantClickableView.this.Fs.ajN().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Fs.ajN().channelId, HeadPendantClickableView.this.Fs.ajN().Zv)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Fs.aiE().getUserId(), HeadPendantClickableView.this.Fs.aiE().getName_show(), HeadPendantClickableView.this.Fs.aiJ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.clw != null) {
                        HeadPendantClickableView.this.clw.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aiE() != null) {
            this.Fs = bhVar;
            MetaData aiE = bhVar.aiE();
            setContentDescription(aiE.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aiE.getUserId());
            getHeadView().setUserName(aiE.getUserName());
            getHeadView().setUrl(aiE.getPortrait());
            bn ajN = bhVar.ajN();
            if (ajN != null && ajN.channelId > 0) {
                getHeadView().startLoad(ajN.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bhVar.aiE().getPortrait()) && bhVar.aiE().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bhVar.aiE().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bhVar.aiE().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.l pendantData = aiE.getPendantData();
            if (ajN != null && ajN.channelId > 0) {
                ou(null);
            } else if (pendantData != null) {
                ou(bhVar.aiE().getPendantData().ahd());
            } else {
                ou(null);
            }
            c(aiE);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bh bhVar = new bh();
            bhVar.a(metaData);
            setData(bhVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.clw = onClickListener;
    }
}
