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
    private View.OnClickListener aAK;
    private bb aAQ;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aAQ != null && HeadPendantClickableView.this.aAQ.yv() != null && !StringUtils.isNull(HeadPendantClickableView.this.aAQ.yv().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aAQ.yv().getUserId())) {
                    if (HeadPendantClickableView.this.aAQ.zy() != null && HeadPendantClickableView.this.aAQ.zy().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aAQ.zy().channelId, HeadPendantClickableView.this.aAQ.zy().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aAQ.yv().getUserId(), HeadPendantClickableView.this.aAQ.yv().getName_show(), HeadPendantClickableView.this.aAQ.yB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aAK != null) {
                        HeadPendantClickableView.this.aAK.onClick(view);
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
                if (HeadPendantClickableView.this.aAQ != null && HeadPendantClickableView.this.aAQ.yv() != null && !StringUtils.isNull(HeadPendantClickableView.this.aAQ.yv().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aAQ.yv().getUserId())) {
                    if (HeadPendantClickableView.this.aAQ.zy() != null && HeadPendantClickableView.this.aAQ.zy().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aAQ.zy().channelId, HeadPendantClickableView.this.aAQ.zy().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aAQ.yv().getUserId(), HeadPendantClickableView.this.aAQ.yv().getName_show(), HeadPendantClickableView.this.aAQ.yB(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aAK != null) {
                        HeadPendantClickableView.this.aAK.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bb bbVar) {
        if (bbVar != null && bbVar.yv() != null) {
            this.aAQ = bbVar;
            MetaData yv = bbVar.yv();
            setContentDescription(yv.getName_show() + this.mContext.getString(e.j.somebodys_portrait));
            getHeadView().setUserId(yv.getUserId());
            getHeadView().setUserName(yv.getUserName());
            getHeadView().setUrl(yv.getPortrait());
            bh zy = bbVar.zy();
            if (zy != null && zy.channelId > 0) {
                getHeadView().startLoad(zy.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bbVar.yv().getPortrait()) && bbVar.yv().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bbVar.yv().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bbVar.yv().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = yv.getPendantData();
            if (zy != null && zy.channelId > 0) {
                fT(null);
            } else if (pendantData != null) {
                fT(bbVar.yv().getPendantData().xf());
            } else {
                fT(null);
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
        this.aAK = onClickListener;
    }
}
