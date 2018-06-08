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
    private bd atn;
    private View.OnClickListener ato;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.atn != null && HeadPendantClickableView.this.atn.vm() != null && !StringUtils.isNull(HeadPendantClickableView.this.atn.vm().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.atn.vm().getUserId())) {
                    if (HeadPendantClickableView.this.atn.wm() != null && HeadPendantClickableView.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atn.wm().channelId, HeadPendantClickableView.this.atn.wm().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atn.vm().getUserId(), HeadPendantClickableView.this.atn.vm().getName_show(), HeadPendantClickableView.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ato != null) {
                        HeadPendantClickableView.this.ato.onClick(view);
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
                if (HeadPendantClickableView.this.atn != null && HeadPendantClickableView.this.atn.vm() != null && !StringUtils.isNull(HeadPendantClickableView.this.atn.vm().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.atn.vm().getUserId())) {
                    if (HeadPendantClickableView.this.atn.wm() != null && HeadPendantClickableView.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atn.wm().channelId, HeadPendantClickableView.this.atn.wm().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.atn.vm().getUserId(), HeadPendantClickableView.this.atn.vm().getName_show(), HeadPendantClickableView.this.atn.vr(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.ato != null) {
                        HeadPendantClickableView.this.ato.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bd bdVar) {
        if (bdVar != null && bdVar.vm() != null) {
            this.atn = bdVar;
            MetaData vm = bdVar.vm();
            setContentDescription(vm.getName_show() + this.mContext.getString(d.k.somebodys_portrait));
            getHeadView().setUserId(vm.getUserId());
            getHeadView().setUserName(vm.getUserName());
            getHeadView().setUrl(vm.getPortrait());
            bj wm = bdVar.wm();
            if (wm != null && wm.channelId > 0) {
                getHeadView().startLoad(wm.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bdVar.vm().getPortrait()) && bdVar.vm().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bdVar.vm().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bdVar.vm().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.i pendantData = vm.getPendantData();
            if (wm != null && wm.channelId > 0) {
                fj(null);
            } else if (pendantData != null) {
                fj(bdVar.vm().getPendantData().ub());
            } else {
                fj(null);
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
        this.ato = onClickListener;
    }
}
