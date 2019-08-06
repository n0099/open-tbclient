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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bh We;
    private View.OnClickListener bWq;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.We != null && HeadPendantClickableView.this.We.aey() != null && !StringUtils.isNull(HeadPendantClickableView.this.We.aey().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.We.aey().getUserId())) {
                    if (HeadPendantClickableView.this.We.afI() != null && HeadPendantClickableView.this.We.afI().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.We.afI().channelId, HeadPendantClickableView.this.We.afI().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.We.aey().getUserId(), HeadPendantClickableView.this.We.aey().getName_show(), HeadPendantClickableView.this.We.aeD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bWq != null) {
                        HeadPendantClickableView.this.bWq.onClick(view);
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
                if (HeadPendantClickableView.this.We != null && HeadPendantClickableView.this.We.aey() != null && !StringUtils.isNull(HeadPendantClickableView.this.We.aey().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.We.aey().getUserId())) {
                    if (HeadPendantClickableView.this.We.afI() != null && HeadPendantClickableView.this.We.afI().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.We.afI().channelId, HeadPendantClickableView.this.We.afI().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.We.aey().getUserId(), HeadPendantClickableView.this.We.aey().getName_show(), HeadPendantClickableView.this.We.aeD(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bWq != null) {
                        HeadPendantClickableView.this.bWq.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aey() != null) {
            this.We = bhVar;
            MetaData aey = bhVar.aey();
            setContentDescription(aey.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aey.getUserId());
            getHeadView().setUserName(aey.getUserName());
            getHeadView().setUrl(aey.getPortrait());
            bn afI = bhVar.afI();
            if (afI != null && afI.channelId > 0) {
                getHeadView().startLoad(afI.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bhVar.aey().getPortrait()) && bhVar.aey().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bhVar.aey().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bhVar.aey().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.l pendantData = aey.getPendantData();
            if (afI != null && afI.channelId > 0) {
                oN(null);
            } else if (pendantData != null) {
                oN(bhVar.aey().getPendantData().acV());
            } else {
                oN(null);
            }
            c(aey);
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
        this.bWq = onClickListener;
    }
}
