package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bh ajq;
    private View.OnClickListener ajr;
    protected com.baidu.tbadk.e.a ajs;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.ajs = aVar;
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.ajs == null || !HeadPendantClickableView.this.ajs.s(view)) && HeadPendantClickableView.this.ajq != null && HeadPendantClickableView.this.ajq.rt() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajq.rt().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajq.rt().getUserId())) {
                    if (HeadPendantClickableView.this.ajq.sz() != null && HeadPendantClickableView.this.ajq.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajq.sz().channelId, HeadPendantClickableView.this.ajq.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajq.rt().getUserId(), HeadPendantClickableView.this.ajq.rt().getName_show(), HeadPendantClickableView.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajr != null) {
                        HeadPendantClickableView.this.ajr.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.akl = l.f(context, d.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.ajs == null || !HeadPendantClickableView.this.ajs.s(view)) && HeadPendantClickableView.this.ajq != null && HeadPendantClickableView.this.ajq.rt() != null && !StringUtils.isNull(HeadPendantClickableView.this.ajq.rt().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ajq.rt().getUserId())) {
                    if (HeadPendantClickableView.this.ajq.sz() != null && HeadPendantClickableView.this.ajq.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajq.sz().channelId, HeadPendantClickableView.this.ajq.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ajq.rt().getUserId(), HeadPendantClickableView.this.ajq.rt().getName_show(), HeadPendantClickableView.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ajr != null) {
                        HeadPendantClickableView.this.ajr.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.akl = l.f(context, d.e.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.rt() != null) {
            this.ajq = bhVar;
            MetaData rt = bhVar.rt();
            setContentDescription(rt.getName_show() + this.mContext.getString(d.j.somebodys_portrait));
            getHeadView().setUserId(rt.getUserId());
            getHeadView().setUserName(rt.getUserName());
            getHeadView().setUrl(rt.getPortrait());
            bm sz = bhVar.sz();
            if (sz != null && sz.channelId > 0) {
                getHeadView().startLoad(sz.channelAvatar, 10, false);
            } else {
                getHeadView().startLoad(bhVar.rt().getPortrait(), 28, false);
            }
            k pendantData = rt.getPendantData();
            if (sz != null && sz.channelId > 0) {
                en(null);
            } else if (pendantData != null) {
                en(bhVar.rt().getPendantData().pQ());
            } else {
                en(null);
            }
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
        this.ajr = onClickListener;
    }
}
