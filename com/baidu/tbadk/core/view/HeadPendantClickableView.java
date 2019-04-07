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
    private bg XS;
    private View.OnClickListener bNw;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.XS != null && HeadPendantClickableView.this.XS.YO() != null && !StringUtils.isNull(HeadPendantClickableView.this.XS.YO().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.XS.YO().getUserId())) {
                    if (HeadPendantClickableView.this.XS.ZY() != null && HeadPendantClickableView.this.XS.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.XS.ZY().channelId, HeadPendantClickableView.this.XS.ZY().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.XS.YO().getUserId(), HeadPendantClickableView.this.XS.YO().getName_show(), HeadPendantClickableView.this.XS.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bNw != null) {
                        HeadPendantClickableView.this.bNw.onClick(view);
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
                if (HeadPendantClickableView.this.XS != null && HeadPendantClickableView.this.XS.YO() != null && !StringUtils.isNull(HeadPendantClickableView.this.XS.YO().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.XS.YO().getUserId())) {
                    if (HeadPendantClickableView.this.XS.ZY() != null && HeadPendantClickableView.this.XS.ZY().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.XS.ZY().channelId, HeadPendantClickableView.this.XS.ZY().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.XS.YO().getUserId(), HeadPendantClickableView.this.XS.YO().getName_show(), HeadPendantClickableView.this.XS.YT(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bNw != null) {
                        HeadPendantClickableView.this.bNw.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.YO() != null) {
            this.XS = bgVar;
            MetaData YO = bgVar.YO();
            setContentDescription(YO.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(YO.getUserId());
            getHeadView().setUserName(YO.getUserName());
            getHeadView().setUrl(YO.getPortrait());
            bm ZY = bgVar.ZY();
            if (ZY != null && ZY.channelId > 0) {
                getHeadView().startLoad(ZY.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bgVar.YO().getPortrait()) && bgVar.YO().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bgVar.YO().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bgVar.YO().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.l pendantData = YO.getPendantData();
            if (ZY != null && ZY.channelId > 0) {
                nn(null);
            } else if (pendantData != null) {
                nn(bgVar.YO().getPendantData().Xk());
            } else {
                nn(null);
            }
            c(YO);
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
        this.bNw = onClickListener;
    }
}
