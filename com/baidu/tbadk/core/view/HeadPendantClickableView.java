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
import com.baidu.tieba.f;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bb atE;
    private View.OnClickListener atF;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.atE != null && HeadPendantClickableView.this.atE.vj() != null && !StringUtils.isNull(HeadPendantClickableView.this.atE.vj().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.atE.vj().getUserId())) {
                    if (HeadPendantClickableView.this.atE.wk() != null && HeadPendantClickableView.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atE.wk().channelId, HeadPendantClickableView.this.atE.wk().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atE.vj().getUserId(), HeadPendantClickableView.this.atE.vj().getName_show(), HeadPendantClickableView.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.atF != null) {
                        HeadPendantClickableView.this.atF.onClick(view);
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
                if (HeadPendantClickableView.this.atE != null && HeadPendantClickableView.this.atE.vj() != null && !StringUtils.isNull(HeadPendantClickableView.this.atE.vj().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.atE.vj().getUserId())) {
                    if (HeadPendantClickableView.this.atE.wk() != null && HeadPendantClickableView.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atE.wk().channelId, HeadPendantClickableView.this.atE.wk().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atE.vj().getUserId(), HeadPendantClickableView.this.atE.vj().getName_show(), HeadPendantClickableView.this.atE.vp(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.atF != null) {
                        HeadPendantClickableView.this.atF.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bb bbVar) {
        if (bbVar != null && bbVar.vj() != null) {
            this.atE = bbVar;
            MetaData vj = bbVar.vj();
            setContentDescription(vj.getName_show() + this.mContext.getString(f.j.somebodys_portrait));
            getHeadView().setUserId(vj.getUserId());
            getHeadView().setUserName(vj.getUserName());
            getHeadView().setUrl(vj.getPortrait());
            bh wk = bbVar.wk();
            if (wk != null && wk.channelId > 0) {
                getHeadView().startLoad(wk.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bbVar.vj().getPortrait()) && bbVar.vj().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bbVar.vj().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bbVar.vj().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.i pendantData = vj.getPendantData();
            if (wk != null && wk.channelId > 0) {
                fl(null);
            } else if (pendantData != null) {
                fl(bbVar.vj().getPendantData().tT());
            } else {
                fl(null);
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
        this.atF = onClickListener;
    }
}
