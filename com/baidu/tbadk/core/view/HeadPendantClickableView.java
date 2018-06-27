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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bc atZ;
    private View.OnClickListener aua;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.atZ != null && HeadPendantClickableView.this.atZ.vw() != null && !StringUtils.isNull(HeadPendantClickableView.this.atZ.vw().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.atZ.vw().getUserId())) {
                    if (HeadPendantClickableView.this.atZ.ww() != null && HeadPendantClickableView.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atZ.ww().channelId, HeadPendantClickableView.this.atZ.ww().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atZ.vw().getUserId(), HeadPendantClickableView.this.atZ.vw().getName_show(), HeadPendantClickableView.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aua != null) {
                        HeadPendantClickableView.this.aua.onClick(view);
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
                if (HeadPendantClickableView.this.atZ != null && HeadPendantClickableView.this.atZ.vw() != null && !StringUtils.isNull(HeadPendantClickableView.this.atZ.vw().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.atZ.vw().getUserId())) {
                    if (HeadPendantClickableView.this.atZ.ww() != null && HeadPendantClickableView.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atZ.ww().channelId, HeadPendantClickableView.this.atZ.ww().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atZ.vw().getUserId(), HeadPendantClickableView.this.atZ.vw().getName_show(), HeadPendantClickableView.this.atZ.vB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aua != null) {
                        HeadPendantClickableView.this.aua.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bc bcVar) {
        if (bcVar != null && bcVar.vw() != null) {
            this.atZ = bcVar;
            MetaData vw = bcVar.vw();
            setContentDescription(vw.getName_show() + this.mContext.getString(d.k.somebodys_portrait));
            getHeadView().setUserId(vw.getUserId());
            getHeadView().setUserName(vw.getUserName());
            getHeadView().setUrl(vw.getPortrait());
            bi ww = bcVar.ww();
            if (ww != null && ww.channelId > 0) {
                getHeadView().startLoad(ww.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bcVar.vw().getPortrait()) && bcVar.vw().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bcVar.vw().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bcVar.vw().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.i pendantData = vw.getPendantData();
            if (ww != null && ww.channelId > 0) {
                fn(null);
            } else if (pendantData != null) {
                fn(bcVar.vw().getPendantData().uh());
            } else {
                fn(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bc bcVar = new bc();
            bcVar.a(metaData);
            setData(bcVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aua = onClickListener;
    }
}
