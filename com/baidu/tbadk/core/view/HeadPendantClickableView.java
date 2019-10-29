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
    private bh FT;
    private View.OnClickListener cmo;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.FT != null && HeadPendantClickableView.this.FT.aiG() != null && !StringUtils.isNull(HeadPendantClickableView.this.FT.aiG().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.FT.aiG().getUserId())) {
                    if (HeadPendantClickableView.this.FT.ajP() != null && HeadPendantClickableView.this.FT.ajP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.FT.ajP().channelId, HeadPendantClickableView.this.FT.ajP().ZN)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.FT.aiG().getUserId(), HeadPendantClickableView.this.FT.aiG().getName_show(), HeadPendantClickableView.this.FT.aiL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.cmo != null) {
                        HeadPendantClickableView.this.cmo.onClick(view);
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
                if (HeadPendantClickableView.this.FT != null && HeadPendantClickableView.this.FT.aiG() != null && !StringUtils.isNull(HeadPendantClickableView.this.FT.aiG().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.FT.aiG().getUserId())) {
                    if (HeadPendantClickableView.this.FT.ajP() != null && HeadPendantClickableView.this.FT.ajP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.FT.ajP().channelId, HeadPendantClickableView.this.FT.ajP().ZN)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.FT.aiG().getUserId(), HeadPendantClickableView.this.FT.aiG().getName_show(), HeadPendantClickableView.this.FT.aiL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.cmo != null) {
                        HeadPendantClickableView.this.cmo.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aiG() != null) {
            this.FT = bhVar;
            MetaData aiG = bhVar.aiG();
            setContentDescription(aiG.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aiG.getUserId());
            getHeadView().setUserName(aiG.getUserName());
            getHeadView().setUrl(aiG.getPortrait());
            bn ajP = bhVar.ajP();
            if (ajP != null && ajP.channelId > 0) {
                getHeadView().startLoad(ajP.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bhVar.aiG().getPortrait()) && bhVar.aiG().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bhVar.aiG().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bhVar.aiG().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.l pendantData = aiG.getPendantData();
            if (ajP != null && ajP.channelId > 0) {
                ou(null);
            } else if (pendantData != null) {
                ou(bhVar.aiG().getPendantData().ahf());
            } else {
                ou(null);
            }
            c(aiG);
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
        this.cmo = onClickListener;
    }
}
