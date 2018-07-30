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
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bb atD;
    private View.OnClickListener atE;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.atD != null && HeadPendantClickableView.this.atD.vk() != null && !StringUtils.isNull(HeadPendantClickableView.this.atD.vk().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.atD.vk().getUserId())) {
                    if (HeadPendantClickableView.this.atD.wl() != null && HeadPendantClickableView.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atD.wl().channelId, HeadPendantClickableView.this.atD.wl().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atD.vk().getUserId(), HeadPendantClickableView.this.atD.vk().getName_show(), HeadPendantClickableView.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.atE != null) {
                        HeadPendantClickableView.this.atE.onClick(view);
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
                if (HeadPendantClickableView.this.atD != null && HeadPendantClickableView.this.atD.vk() != null && !StringUtils.isNull(HeadPendantClickableView.this.atD.vk().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.atD.vk().getUserId())) {
                    if (HeadPendantClickableView.this.atD.wl() != null && HeadPendantClickableView.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atD.wl().channelId, HeadPendantClickableView.this.atD.wl().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atD.vk().getUserId(), HeadPendantClickableView.this.atD.vk().getName_show(), HeadPendantClickableView.this.atD.vq(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.atE != null) {
                        HeadPendantClickableView.this.atE.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bb bbVar) {
        if (bbVar != null && bbVar.vk() != null) {
            this.atD = bbVar;
            MetaData vk = bbVar.vk();
            setContentDescription(vk.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(vk.getUserId());
            getHeadView().setUserName(vk.getUserName());
            getHeadView().setUrl(vk.getPortrait());
            bh wl = bbVar.wl();
            if (wl != null && wl.channelId > 0) {
                getHeadView().startLoad(wl.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bbVar.vk().getPortrait()) && bbVar.vk().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bbVar.vk().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bbVar.vk().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.i pendantData = vk.getPendantData();
            if (wl != null && wl.channelId > 0) {
                fl(null);
            } else if (pendantData != null) {
                fl(bbVar.vk().getPendantData().tU());
            } else {
                fl(null);
            }
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
        this.atE = onClickListener;
    }
}
