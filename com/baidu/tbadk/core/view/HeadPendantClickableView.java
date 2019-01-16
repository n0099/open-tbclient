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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.e;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private View.OnClickListener aFC;
    private bb aFI;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aFI != null && HeadPendantClickableView.this.aFI.zT() != null && !StringUtils.isNull(HeadPendantClickableView.this.aFI.zT().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aFI.zT().getUserId())) {
                    if (HeadPendantClickableView.this.aFI.AW() != null && HeadPendantClickableView.this.aFI.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aFI.AW().channelId, HeadPendantClickableView.this.aFI.AW().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aFI.zT().getUserId(), HeadPendantClickableView.this.aFI.zT().getName_show(), HeadPendantClickableView.this.aFI.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aFC != null) {
                        HeadPendantClickableView.this.aFC.onClick(view);
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
                if (HeadPendantClickableView.this.aFI != null && HeadPendantClickableView.this.aFI.zT() != null && !StringUtils.isNull(HeadPendantClickableView.this.aFI.zT().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aFI.zT().getUserId())) {
                    if (HeadPendantClickableView.this.aFI.AW() != null && HeadPendantClickableView.this.aFI.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aFI.AW().channelId, HeadPendantClickableView.this.aFI.AW().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aFI.zT().getUserId(), HeadPendantClickableView.this.aFI.zT().getName_show(), HeadPendantClickableView.this.aFI.zZ(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aFC != null) {
                        HeadPendantClickableView.this.aFC.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bb bbVar) {
        if (bbVar != null && bbVar.zT() != null) {
            this.aFI = bbVar;
            MetaData zT = bbVar.zT();
            setContentDescription(zT.getName_show() + this.mContext.getString(e.j.somebodys_portrait));
            getHeadView().setUserId(zT.getUserId());
            getHeadView().setUserName(zT.getUserName());
            getHeadView().setUrl(zT.getPortrait());
            bh AW = bbVar.AW();
            if (AW != null && AW.channelId > 0) {
                getHeadView().startLoad(AW.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bbVar.zT().getPortrait()) && bbVar.zT().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bbVar.zT().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bbVar.zT().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.l pendantData = zT.getPendantData();
            if (AW != null && AW.channelId > 0) {
                gA(null);
            } else if (pendantData != null) {
                gA(bbVar.zT().getPendantData().yF());
            } else {
                gA(null);
            }
            c(zT);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bb bbVar = new bb();
            bbVar.a(metaData);
            setData(bbVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aFC = onClickListener;
    }
}
