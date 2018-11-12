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
    private bb aBF;
    private View.OnClickListener aBz;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aBF != null && HeadPendantClickableView.this.aBF.yC() != null && !StringUtils.isNull(HeadPendantClickableView.this.aBF.yC().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aBF.yC().getUserId())) {
                    if (HeadPendantClickableView.this.aBF.zF() != null && HeadPendantClickableView.this.aBF.zF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aBF.zF().channelId, HeadPendantClickableView.this.aBF.zF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aBF.yC().getUserId(), HeadPendantClickableView.this.aBF.yC().getName_show(), HeadPendantClickableView.this.aBF.yI(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aBz != null) {
                        HeadPendantClickableView.this.aBz.onClick(view);
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
                if (HeadPendantClickableView.this.aBF != null && HeadPendantClickableView.this.aBF.yC() != null && !StringUtils.isNull(HeadPendantClickableView.this.aBF.yC().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aBF.yC().getUserId())) {
                    if (HeadPendantClickableView.this.aBF.zF() != null && HeadPendantClickableView.this.aBF.zF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aBF.zF().channelId, HeadPendantClickableView.this.aBF.zF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aBF.yC().getUserId(), HeadPendantClickableView.this.aBF.yC().getName_show(), HeadPendantClickableView.this.aBF.yI(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aBz != null) {
                        HeadPendantClickableView.this.aBz.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bb bbVar) {
        if (bbVar != null && bbVar.yC() != null) {
            this.aBF = bbVar;
            MetaData yC = bbVar.yC();
            setContentDescription(yC.getName_show() + this.mContext.getString(e.j.somebodys_portrait));
            getHeadView().setUserId(yC.getUserId());
            getHeadView().setUserName(yC.getUserName());
            getHeadView().setUrl(yC.getPortrait());
            bh zF = bbVar.zF();
            if (zF != null && zF.channelId > 0) {
                getHeadView().startLoad(zF.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bbVar.yC().getPortrait()) && bbVar.yC().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bbVar.yC().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bbVar.yC().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = yC.getPendantData();
            if (zF != null && zF.channelId > 0) {
                fT(null);
            } else if (pendantData != null) {
                fT(bbVar.yC().getPendantData().xn());
            } else {
                fT(null);
            }
            c(yC);
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
        this.aBz = onClickListener;
    }
}
