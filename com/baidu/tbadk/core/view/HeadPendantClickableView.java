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
                if (HeadPendantClickableView.this.alf != null && HeadPendantClickableView.this.alf.rP() != null && !StringUtils.isNull(HeadPendantClickableView.this.alf.rP().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.alf.rP().getUserId())) {
                    if (HeadPendantClickableView.this.alf.sP() != null && HeadPendantClickableView.this.alf.sP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.alf.sP().channelId, HeadPendantClickableView.this.alf.sP().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.alf.rP().getUserId(), HeadPendantClickableView.this.alf.rP().getName_show(), HeadPendantClickableView.this.alf.rU(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
                if (HeadPendantClickableView.this.alf != null && HeadPendantClickableView.this.alf.rP() != null && !StringUtils.isNull(HeadPendantClickableView.this.alf.rP().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.alf.rP().getUserId())) {
                    if (HeadPendantClickableView.this.alf.sP() != null && HeadPendantClickableView.this.alf.sP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.alf.sP().channelId, HeadPendantClickableView.this.alf.sP().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.alf.rP().getUserId(), HeadPendantClickableView.this.alf.rP().getName_show(), HeadPendantClickableView.this.alf.rU(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
        if (bdVar != null && bdVar.rP() != null) {
            this.alf = bdVar;
            MetaData rP = bdVar.rP();
            setContentDescription(rP.getName_show() + this.mContext.getString(d.k.somebodys_portrait));
            getHeadView().setUserId(rP.getUserId());
            getHeadView().setUserName(rP.getUserName());
            getHeadView().setUrl(rP.getPortrait());
            bj sP = bdVar.sP();
            if (sP != null && sP.channelId > 0) {
                getHeadView().startLoad(sP.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bdVar.rP().getPortrait()) && bdVar.rP().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bdVar.rP().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bdVar.rP().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.h pendantData = rP.getPendantData();
            if (sP != null && sP.channelId > 0) {
                eK(null);
            } else if (pendantData != null) {
                eK(bdVar.rP().getPendantData().qF());
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
