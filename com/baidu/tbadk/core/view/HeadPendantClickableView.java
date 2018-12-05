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
    private View.OnClickListener aEZ;
    private bb aFf;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aFf != null && HeadPendantClickableView.this.aFf.zG() != null && !StringUtils.isNull(HeadPendantClickableView.this.aFf.zG().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aFf.zG().getUserId())) {
                    if (HeadPendantClickableView.this.aFf.AJ() != null && HeadPendantClickableView.this.aFf.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aFf.AJ().channelId, HeadPendantClickableView.this.aFf.AJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aFf.zG().getUserId(), HeadPendantClickableView.this.aFf.zG().getName_show(), HeadPendantClickableView.this.aFf.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aEZ != null) {
                        HeadPendantClickableView.this.aEZ.onClick(view);
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
                if (HeadPendantClickableView.this.aFf != null && HeadPendantClickableView.this.aFf.zG() != null && !StringUtils.isNull(HeadPendantClickableView.this.aFf.zG().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aFf.zG().getUserId())) {
                    if (HeadPendantClickableView.this.aFf.AJ() != null && HeadPendantClickableView.this.aFf.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aFf.AJ().channelId, HeadPendantClickableView.this.aFf.AJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aFf.zG().getUserId(), HeadPendantClickableView.this.aFf.zG().getName_show(), HeadPendantClickableView.this.aFf.zM(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.aEZ != null) {
                        HeadPendantClickableView.this.aEZ.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bb bbVar) {
        if (bbVar != null && bbVar.zG() != null) {
            this.aFf = bbVar;
            MetaData zG = bbVar.zG();
            setContentDescription(zG.getName_show() + this.mContext.getString(e.j.somebodys_portrait));
            getHeadView().setUserId(zG.getUserId());
            getHeadView().setUserName(zG.getUserName());
            getHeadView().setUrl(zG.getPortrait());
            bh AJ = bbVar.AJ();
            if (AJ != null && AJ.channelId > 0) {
                getHeadView().startLoad(AJ.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bbVar.zG().getPortrait()) && bbVar.zG().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bbVar.zG().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bbVar.zG().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = zG.getPendantData();
            if (AJ != null && AJ.channelId > 0) {
                gl(null);
            } else if (pendantData != null) {
                gl(bbVar.zG().getPendantData().ys());
            } else {
                gl(null);
            }
            c(zG);
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
        this.aEZ = onClickListener;
    }
}
