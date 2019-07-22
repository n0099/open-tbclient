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
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bg We;
    private View.OnClickListener bWk;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.We != null && HeadPendantClickableView.this.We.aex() != null && !StringUtils.isNull(HeadPendantClickableView.this.We.aex().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.We.aex().getUserId())) {
                    if (HeadPendantClickableView.this.We.afH() != null && HeadPendantClickableView.this.We.afH().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.We.afH().channelId, HeadPendantClickableView.this.We.afH().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.We.aex().getUserId(), HeadPendantClickableView.this.We.aex().getName_show(), HeadPendantClickableView.this.We.aeC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bWk != null) {
                        HeadPendantClickableView.this.bWk.onClick(view);
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
                if (HeadPendantClickableView.this.We != null && HeadPendantClickableView.this.We.aex() != null && !StringUtils.isNull(HeadPendantClickableView.this.We.aex().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.We.aex().getUserId())) {
                    if (HeadPendantClickableView.this.We.afH() != null && HeadPendantClickableView.this.We.afH().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.We.afH().channelId, HeadPendantClickableView.this.We.afH().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.We.aex().getUserId(), HeadPendantClickableView.this.We.aex().getName_show(), HeadPendantClickableView.this.We.aeC(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bWk != null) {
                        HeadPendantClickableView.this.bWk.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.aex() != null) {
            this.We = bgVar;
            MetaData aex = bgVar.aex();
            setContentDescription(aex.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aex.getUserId());
            getHeadView().setUserName(aex.getUserName());
            getHeadView().setUrl(aex.getPortrait());
            bm afH = bgVar.afH();
            if (afH != null && afH.channelId > 0) {
                getHeadView().startLoad(afH.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bgVar.aex().getPortrait()) && bgVar.aex().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bgVar.aex().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bgVar.aex().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.l pendantData = aex.getPendantData();
            if (afH != null && afH.channelId > 0) {
                oN(null);
            } else if (pendantData != null) {
                oN(bgVar.aex().getPendantData().acU());
            } else {
                oN(null);
            }
            c(aex);
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
        this.bWk = onClickListener;
    }
}
