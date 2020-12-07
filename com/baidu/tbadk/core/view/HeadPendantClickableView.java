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
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private by ahA;
    private View.OnClickListener akt;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.ahA != null && HeadPendantClickableView.this.ahA.boP() != null && !StringUtils.isNull(HeadPendantClickableView.this.ahA.boP().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ahA.boP().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.ahA.eMi) {
                        if (!HeadPendantClickableView.this.ahA.bqJ()) {
                            if (HeadPendantClickableView.this.ahA.bmu()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.ahA.boP().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ahA.boP().getUserId(), HeadPendantClickableView.this.ahA.boP().getName_show(), HeadPendantClickableView.this.ahA.boT(), str, HeadPendantClickableView.this.ahA.getTid(), HeadPendantClickableView.this.ahA.getNid())));
                    }
                    if (HeadPendantClickableView.this.akt != null) {
                        HeadPendantClickableView.this.akt.onClick(view);
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
                if (HeadPendantClickableView.this.ahA != null && HeadPendantClickableView.this.ahA.boP() != null && !StringUtils.isNull(HeadPendantClickableView.this.ahA.boP().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ahA.boP().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.ahA.eMi) {
                        if (!HeadPendantClickableView.this.ahA.bqJ()) {
                            if (HeadPendantClickableView.this.ahA.bmu()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.ahA.boP().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ahA.boP().getUserId(), HeadPendantClickableView.this.ahA.boP().getName_show(), HeadPendantClickableView.this.ahA.boT(), str, HeadPendantClickableView.this.ahA.getTid(), HeadPendantClickableView.this.ahA.getNid())));
                    }
                    if (HeadPendantClickableView.this.akt != null) {
                        HeadPendantClickableView.this.akt.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(by byVar) {
        setData(byVar, false);
    }

    public void setData(by byVar, boolean z) {
        if (byVar != null && byVar.boP() != null) {
            this.ahA = byVar;
            MetaData boP = byVar.boP();
            setContentDescription(boP.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(boP.getUserId());
            getHeadView().setUserName(boP.getUserName());
            getHeadView().setUrl(boP.getAvater());
            if (boP.isDefaultAvatar && com.baidu.tbadk.a.d.bkq()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(boP.getAvater()) && boP.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(boP.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(boP.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(boP.getAvater(), 28, false);
            }
            a(boP, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            by byVar = new by();
            byVar.a(metaData);
            setData(byVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }
}
