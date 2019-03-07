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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bg XR;
    private View.OnClickListener bNt;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.XR != null && HeadPendantClickableView.this.XR.YR() != null && !StringUtils.isNull(HeadPendantClickableView.this.XR.YR().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.XR.YR().getUserId())) {
                    if (HeadPendantClickableView.this.XR.aab() == null || HeadPendantClickableView.this.XR.aab().channelId <= 0) {
                        if (com.baidu.tbadk.plugins.c.ay(HeadPendantClickableView.this.mContext, "com.baidu.tieba.pluginMember")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.XR.YR().getUserId(), HeadPendantClickableView.this.XR.YR().getName_show(), HeadPendantClickableView.this.XR.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.XR.aab().channelId, HeadPendantClickableView.this.XR.aab().mCurrentPage)));
                    }
                    if (HeadPendantClickableView.this.bNt != null) {
                        HeadPendantClickableView.this.bNt.onClick(view);
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
                if (HeadPendantClickableView.this.XR != null && HeadPendantClickableView.this.XR.YR() != null && !StringUtils.isNull(HeadPendantClickableView.this.XR.YR().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.XR.YR().getUserId())) {
                    if (HeadPendantClickableView.this.XR.aab() == null || HeadPendantClickableView.this.XR.aab().channelId <= 0) {
                        if (com.baidu.tbadk.plugins.c.ay(HeadPendantClickableView.this.mContext, "com.baidu.tieba.pluginMember")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.XR.YR().getUserId(), HeadPendantClickableView.this.XR.YR().getName_show(), HeadPendantClickableView.this.XR.YW(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.XR.aab().channelId, HeadPendantClickableView.this.XR.aab().mCurrentPage)));
                    }
                    if (HeadPendantClickableView.this.bNt != null) {
                        HeadPendantClickableView.this.bNt.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.YR() != null) {
            this.XR = bgVar;
            MetaData YR = bgVar.YR();
            setContentDescription(YR.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(YR.getUserId());
            getHeadView().setUserName(YR.getUserName());
            getHeadView().setUrl(YR.getPortrait());
            bm aab = bgVar.aab();
            if (aab != null && aab.channelId > 0) {
                getHeadView().startLoad(aab.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bgVar.YR().getPortrait()) && bgVar.YR().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bgVar.YR().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bgVar.YR().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.l pendantData = YR.getPendantData();
            if (aab != null && aab.channelId > 0) {
                nm(null);
            } else if (pendantData != null) {
                nm(bgVar.YR().getPendantData().Xn());
            } else {
                nm(null);
            }
            c(YR);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bg bgVar = new bg();
            bgVar.a(metaData);
            setData(bgVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNt = onClickListener;
    }
}
