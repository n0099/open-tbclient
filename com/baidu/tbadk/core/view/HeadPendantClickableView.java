package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bj Ki;
    private View.OnClickListener Mz;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.Ki != null && HeadPendantClickableView.this.Ki.azE() != null && !StringUtils.isNull(HeadPendantClickableView.this.Ki.azE().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.Ki.azE().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.Ki.cQe) {
                        if (!HeadPendantClickableView.this.Ki.aBu()) {
                            if (HeadPendantClickableView.this.Ki.aBv()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Ki.azE().getUserId(), HeadPendantClickableView.this.Ki.azE().getName_show(), HeadPendantClickableView.this.Ki.azJ(), str, HeadPendantClickableView.this.Ki.getTid())));
                    if (HeadPendantClickableView.this.Mz != null) {
                        HeadPendantClickableView.this.Mz.onClick(view);
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
                if (HeadPendantClickableView.this.Ki != null && HeadPendantClickableView.this.Ki.azE() != null && !StringUtils.isNull(HeadPendantClickableView.this.Ki.azE().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.Ki.azE().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.Ki.cQe) {
                        if (!HeadPendantClickableView.this.Ki.aBu()) {
                            if (HeadPendantClickableView.this.Ki.aBv()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.Ki.azE().getUserId(), HeadPendantClickableView.this.Ki.azE().getName_show(), HeadPendantClickableView.this.Ki.azJ(), str, HeadPendantClickableView.this.Ki.getTid())));
                    if (HeadPendantClickableView.this.Mz != null) {
                        HeadPendantClickableView.this.Mz.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bj bjVar) {
        setData(bjVar, false);
    }

    public void setData(bj bjVar, boolean z) {
        if (bjVar != null && bjVar.azE() != null) {
            this.Ki = bjVar;
            MetaData azE = bjVar.azE();
            setContentDescription(azE.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(azE.getUserId());
            getHeadView().setUserName(azE.getUserName());
            getHeadView().setUrl(azE.getAvater());
            if (!StringUtils.isNull(azE.getAvater()) && azE.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(azE.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(azE.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(azE.getAvater(), 28, false);
            }
            a(azE, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            bj bjVar = new bj();
            bjVar.a(metaData);
            setData(bjVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Mz = onClickListener;
    }
}
