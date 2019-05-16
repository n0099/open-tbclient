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
    private bg VK;
    private View.OnClickListener bVi;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.VK != null && HeadPendantClickableView.this.VK.adv() != null && !StringUtils.isNull(HeadPendantClickableView.this.VK.adv().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.VK.adv().getUserId())) {
                    if (HeadPendantClickableView.this.VK.aeF() != null && HeadPendantClickableView.this.VK.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.VK.aeF().channelId, HeadPendantClickableView.this.VK.aeF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.VK.adv().getUserId(), HeadPendantClickableView.this.VK.adv().getName_show(), HeadPendantClickableView.this.VK.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bVi != null) {
                        HeadPendantClickableView.this.bVi.onClick(view);
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
                if (HeadPendantClickableView.this.VK != null && HeadPendantClickableView.this.VK.adv() != null && !StringUtils.isNull(HeadPendantClickableView.this.VK.adv().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.VK.adv().getUserId())) {
                    if (HeadPendantClickableView.this.VK.aeF() != null && HeadPendantClickableView.this.VK.aeF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.VK.aeF().channelId, HeadPendantClickableView.this.VK.aeF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.VK.adv().getUserId(), HeadPendantClickableView.this.VK.adv().getName_show(), HeadPendantClickableView.this.VK.adA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bVi != null) {
                        HeadPendantClickableView.this.bVi.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.adv() != null) {
            this.VK = bgVar;
            MetaData adv = bgVar.adv();
            setContentDescription(adv.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(adv.getUserId());
            getHeadView().setUserName(adv.getUserName());
            getHeadView().setUrl(adv.getPortrait());
            bm aeF = bgVar.aeF();
            if (aeF != null && aeF.channelId > 0) {
                getHeadView().startLoad(aeF.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bgVar.adv().getPortrait()) && bgVar.adv().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bgVar.adv().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bgVar.adv().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.l pendantData = adv.getPendantData();
            if (aeF != null && aeF.channelId > 0) {
                ox(null);
            } else if (pendantData != null) {
                ox(bgVar.adv().getPendantData().abS());
            } else {
                ox(null);
            }
            c(adv);
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
        this.bVi = onClickListener;
    }
}
