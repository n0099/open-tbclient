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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bl akl;
    private View.OnClickListener akm;
    protected com.baidu.tbadk.e.a akn;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.akn = aVar;
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.akn == null || !HeadPendantClickableView.this.akn.s(view)) && HeadPendantClickableView.this.akl != null && HeadPendantClickableView.this.akl.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.akl.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.akl.sK() != null && HeadPendantClickableView.this.akl.sK().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.akl.sK().channelId, HeadPendantClickableView.this.akl.sK().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.akl.getAuthor().getUserId(), HeadPendantClickableView.this.akl.getAuthor().getName_show(), HeadPendantClickableView.this.akl.rL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.akm != null) {
                        HeadPendantClickableView.this.akm.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.akF = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.akn == null || !HeadPendantClickableView.this.akn.s(view)) && HeadPendantClickableView.this.akl != null && HeadPendantClickableView.this.akl.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.akl.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.akl.sK() != null && HeadPendantClickableView.this.akl.sK().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.akl.sK().channelId, HeadPendantClickableView.this.akl.sK().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.akl.getAuthor().getUserId(), HeadPendantClickableView.this.akl.getAuthor().getName_show(), HeadPendantClickableView.this.akl.rL(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.akm != null) {
                        HeadPendantClickableView.this.akm.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.akF = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bl blVar) {
        if (blVar != null && blVar.getAuthor() != null) {
            this.akl = blVar;
            MetaData author = blVar.getAuthor();
            setContentDescription(author.getName_show() + this.mContext.getString(d.l.somebodys_portrait));
            getHeadView().setUserId(author.getUserId());
            getHeadView().setUserName(author.getUserName());
            getHeadView().setUrl(author.getPortrait());
            bq sK = blVar.sK();
            if (sK != null && sK.channelId > 0) {
                getHeadView().c(sK.channelAvatar, 10, false);
            } else {
                getHeadView().c(blVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = author.getPendantData();
            if (sK != null && sK.channelId > 0) {
                ex(null);
            } else if (pendantData != null) {
                ex(blVar.getAuthor().getPendantData().pW());
            } else {
                ex(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bl blVar = new bl();
            blVar.setAuthor(metaData);
            setData(blVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akm = onClickListener;
    }
}
