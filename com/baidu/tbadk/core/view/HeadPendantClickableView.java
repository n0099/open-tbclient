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
    private View.OnClickListener avZ;
    private bb awf;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.awf != null && HeadPendantClickableView.this.awf.wm() != null && !StringUtils.isNull(HeadPendantClickableView.this.awf.wm().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.awf.wm().getUserId())) {
                    if (HeadPendantClickableView.this.awf.xp() != null && HeadPendantClickableView.this.awf.xp().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.awf.xp().channelId, HeadPendantClickableView.this.awf.xp().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.awf.wm().getUserId(), HeadPendantClickableView.this.awf.wm().getName_show(), HeadPendantClickableView.this.awf.ws(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.avZ != null) {
                        HeadPendantClickableView.this.avZ.onClick(view);
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
                if (HeadPendantClickableView.this.awf != null && HeadPendantClickableView.this.awf.wm() != null && !StringUtils.isNull(HeadPendantClickableView.this.awf.wm().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.awf.wm().getUserId())) {
                    if (HeadPendantClickableView.this.awf.xp() != null && HeadPendantClickableView.this.awf.xp().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.awf.xp().channelId, HeadPendantClickableView.this.awf.xp().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.awf.wm().getUserId(), HeadPendantClickableView.this.awf.wm().getName_show(), HeadPendantClickableView.this.awf.ws(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.avZ != null) {
                        HeadPendantClickableView.this.avZ.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bb bbVar) {
        if (bbVar != null && bbVar.wm() != null) {
            this.awf = bbVar;
            MetaData wm = bbVar.wm();
            setContentDescription(wm.getName_show() + this.mContext.getString(e.j.somebodys_portrait));
            getHeadView().setUserId(wm.getUserId());
            getHeadView().setUserName(wm.getUserName());
            getHeadView().setUrl(wm.getPortrait());
            bh xp = bbVar.xp();
            if (xp != null && xp.channelId > 0) {
                getHeadView().startLoad(xp.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bbVar.wm().getPortrait()) && bbVar.wm().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bbVar.wm().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bbVar.wm().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = wm.getPendantData();
            if (xp != null && xp.channelId > 0) {
                fF(null);
            } else if (pendantData != null) {
                fF(bbVar.wm().getPendantData().uW());
            } else {
                fF(null);
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
        this.avZ = onClickListener;
    }
}
