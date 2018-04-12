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
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bd alf;
    private View.OnClickListener alg;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (HeadPendantClickableView.this.alf != null && HeadPendantClickableView.this.alf.rQ() != null && !StringUtils.isNull(HeadPendantClickableView.this.alf.rQ().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.alf.rQ().getUserId())) {
                    if (HeadPendantClickableView.this.alf.sQ() != null && HeadPendantClickableView.this.alf.sQ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.alf.sQ().channelId, HeadPendantClickableView.this.alf.sQ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.alf.rQ().getUserId(), HeadPendantClickableView.this.alf.rQ().getName_show(), HeadPendantClickableView.this.alf.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.alg != null) {
                        HeadPendantClickableView.this.alg.onClick(view2);
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
            public void onClick(View view2) {
                if (HeadPendantClickableView.this.alf != null && HeadPendantClickableView.this.alf.rQ() != null && !StringUtils.isNull(HeadPendantClickableView.this.alf.rQ().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.alf.rQ().getUserId())) {
                    if (HeadPendantClickableView.this.alf.sQ() != null && HeadPendantClickableView.this.alf.sQ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.alf.sQ().channelId, HeadPendantClickableView.this.alf.sQ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.alf.rQ().getUserId(), HeadPendantClickableView.this.alf.rQ().getName_show(), HeadPendantClickableView.this.alf.rV(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.alg != null) {
                        HeadPendantClickableView.this.alg.onClick(view2);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bd bdVar) {
        if (bdVar != null && bdVar.rQ() != null) {
            this.alf = bdVar;
            MetaData rQ = bdVar.rQ();
            setContentDescription(rQ.getName_show() + this.mContext.getString(d.k.somebodys_portrait));
            getHeadView().setUserId(rQ.getUserId());
            getHeadView().setUserName(rQ.getUserName());
            getHeadView().setUrl(rQ.getPortrait());
            bj sQ = bdVar.sQ();
            if (sQ != null && sQ.channelId > 0) {
                getHeadView().startLoad(sQ.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bdVar.rQ().getPortrait()) && bdVar.rQ().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bdVar.rQ().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bdVar.rQ().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.h pendantData = rQ.getPendantData();
            if (sQ != null && sQ.channelId > 0) {
                eK(null);
            } else if (pendantData != null) {
                eK(bdVar.rQ().getPendantData().qG());
            } else {
                eK(null);
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
        this.alg = onClickListener;
    }
}
