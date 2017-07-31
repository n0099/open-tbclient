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
    private bl akj;
    private View.OnClickListener akk;
    protected com.baidu.tbadk.e.a akl;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.akl = aVar;
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.akl == null || !HeadPendantClickableView.this.akl.s(view)) && HeadPendantClickableView.this.akj != null && HeadPendantClickableView.this.akj.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.akj.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.akj.sJ() != null && HeadPendantClickableView.this.akj.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.akj.sJ().channelId, HeadPendantClickableView.this.akj.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.akj.getAuthor().getUserId(), HeadPendantClickableView.this.akj.getAuthor().getName_show(), HeadPendantClickableView.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.akk != null) {
                        HeadPendantClickableView.this.akk.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.akD = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((HeadPendantClickableView.this.akl == null || !HeadPendantClickableView.this.akl.s(view)) && HeadPendantClickableView.this.akj != null && HeadPendantClickableView.this.akj.getAuthor() != null && !StringUtils.isNull(HeadPendantClickableView.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.akj.getAuthor().getUserId())) {
                    if (HeadPendantClickableView.this.akj.sJ() != null && HeadPendantClickableView.this.akj.sJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.akj.sJ().channelId, HeadPendantClickableView.this.akj.sJ().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.akj.getAuthor().getUserId(), HeadPendantClickableView.this.akj.getAuthor().getName_show(), HeadPendantClickableView.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    }
                    if (HeadPendantClickableView.this.akk != null) {
                        HeadPendantClickableView.this.akk.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        this.akD = com.baidu.adp.lib.util.k.g(context, d.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bl blVar) {
        if (blVar != null && blVar.getAuthor() != null) {
            this.akj = blVar;
            MetaData author = blVar.getAuthor();
            setContentDescription(author.getName_show() + this.mContext.getString(d.l.somebodys_portrait));
            getHeadView().setUserId(author.getUserId());
            getHeadView().setUserName(author.getUserName());
            getHeadView().setUrl(author.getPortrait());
            bq sJ = blVar.sJ();
            if (sJ != null && sJ.channelId > 0) {
                getHeadView().c(sJ.channelAvatar, 10, false);
            } else {
                getHeadView().c(blVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = author.getPendantData();
            if (sJ != null && sJ.channelId > 0) {
                et(null);
            } else if (pendantData != null) {
                et(blVar.getAuthor().getPendantData().pV());
            } else {
                et(null);
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
        this.akk = onClickListener;
    }
}
