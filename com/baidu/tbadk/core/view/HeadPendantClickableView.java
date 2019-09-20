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
    private bh Wd;
    private View.OnClickListener bXj;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.Wd != null && HeadPendantClickableView.this.Wd.aeC() != null && !StringUtils.isNull(HeadPendantClickableView.this.Wd.aeC().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.Wd.aeC().getUserId())) {
                    if (HeadPendantClickableView.this.Wd.afM() != null && HeadPendantClickableView.this.Wd.afM().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Wd.afM().channelId, HeadPendantClickableView.this.Wd.afM().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Wd.aeC().getUserId(), HeadPendantClickableView.this.Wd.aeC().getName_show(), HeadPendantClickableView.this.Wd.aeH(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bXj != null) {
                        HeadPendantClickableView.this.bXj.onClick(view);
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
                if (HeadPendantClickableView.this.Wd != null && HeadPendantClickableView.this.Wd.aeC() != null && !StringUtils.isNull(HeadPendantClickableView.this.Wd.aeC().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.Wd.aeC().getUserId())) {
                    if (HeadPendantClickableView.this.Wd.afM() != null && HeadPendantClickableView.this.Wd.afM().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Wd.afM().channelId, HeadPendantClickableView.this.Wd.afM().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Wd.aeC().getUserId(), HeadPendantClickableView.this.Wd.aeC().getName_show(), HeadPendantClickableView.this.Wd.aeH(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.bXj != null) {
                        HeadPendantClickableView.this.bXj.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.aeC() != null) {
            this.Wd = bhVar;
            MetaData aeC = bhVar.aeC();
            setContentDescription(aeC.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aeC.getUserId());
            getHeadView().setUserName(aeC.getUserName());
            getHeadView().setUrl(aeC.getPortrait());
            bn afM = bhVar.afM();
            if (afM != null && afM.channelId > 0) {
                getHeadView().startLoad(afM.channelAvatar, 10, false);
            } else if (!StringUtils.isNull(bhVar.aeC().getPortrait()) && bhVar.aeC().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bhVar.aeC().getPortrait(), 10, false);
            } else {
                getHeadView().startLoad(bhVar.aeC().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.l pendantData = aeC.getPendantData();
            if (afM != null && afM.channelId > 0) {
                oV(null);
            } else if (pendantData != null) {
                oV(bhVar.aeC().getPendantData().acZ());
            } else {
                oV(null);
            }
            c(aeC);
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
        this.bXj = onClickListener;
    }
}
