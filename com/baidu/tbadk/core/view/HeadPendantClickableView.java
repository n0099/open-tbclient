package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bj adG;
    private View.OnClickListener afS;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.adG != null && HeadPendantClickableView.this.adG.aKE() != null && !StringUtils.isNull(HeadPendantClickableView.this.adG.aKE().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.adG.aKE().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.adG.dtQ) {
                        if (!HeadPendantClickableView.this.adG.aMt()) {
                            if (HeadPendantClickableView.this.adG.aMu()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.adG.aKE().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.adG.aKE().getUserId(), HeadPendantClickableView.this.adG.aKE().getName_show(), HeadPendantClickableView.this.adG.aKJ(), str, HeadPendantClickableView.this.adG.getTid())));
                    }
                    if (HeadPendantClickableView.this.afS != null) {
                        HeadPendantClickableView.this.afS.onClick(view);
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
                if (HeadPendantClickableView.this.adG != null && HeadPendantClickableView.this.adG.aKE() != null && !StringUtils.isNull(HeadPendantClickableView.this.adG.aKE().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.adG.aKE().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.adG.dtQ) {
                        if (!HeadPendantClickableView.this.adG.aMt()) {
                            if (HeadPendantClickableView.this.adG.aMu()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.adG.aKE().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.adG.aKE().getUserId(), HeadPendantClickableView.this.adG.aKE().getName_show(), HeadPendantClickableView.this.adG.aKJ(), str, HeadPendantClickableView.this.adG.getTid())));
                    }
                    if (HeadPendantClickableView.this.afS != null) {
                        HeadPendantClickableView.this.afS.onClick(view);
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
        if (bjVar != null && bjVar.aKE() != null) {
            this.adG = bjVar;
            MetaData aKE = bjVar.aKE();
            setContentDescription(aKE.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aKE.getUserId());
            getHeadView().setUserName(aKE.getUserName());
            getHeadView().setUrl(aKE.getAvater());
            if (!StringUtils.isNull(aKE.getAvater()) && aKE.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(aKE.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(aKE.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(aKE.getAvater(), 28, false);
            }
            a(aKE, 0);
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
        this.afS = onClickListener;
    }
}
