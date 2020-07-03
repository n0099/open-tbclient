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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bu aeK;
    private View.OnClickListener ahw;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aeK != null && HeadPendantClickableView.this.aeK.aSp() != null && !StringUtils.isNull(HeadPendantClickableView.this.aeK.aSp().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aeK.aSp().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aeK.dOy) {
                        if (!HeadPendantClickableView.this.aeK.aUh()) {
                            if (HeadPendantClickableView.this.aeK.aUi()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aeK.aSp().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aeK.aSp().getUserId(), HeadPendantClickableView.this.aeK.aSp().getName_show(), HeadPendantClickableView.this.aeK.aSt(), str, HeadPendantClickableView.this.aeK.getTid(), HeadPendantClickableView.this.aeK.getNid())));
                    }
                    if (HeadPendantClickableView.this.ahw != null) {
                        HeadPendantClickableView.this.ahw.onClick(view);
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
                if (HeadPendantClickableView.this.aeK != null && HeadPendantClickableView.this.aeK.aSp() != null && !StringUtils.isNull(HeadPendantClickableView.this.aeK.aSp().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aeK.aSp().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aeK.dOy) {
                        if (!HeadPendantClickableView.this.aeK.aUh()) {
                            if (HeadPendantClickableView.this.aeK.aUi()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aeK.aSp().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aeK.aSp().getUserId(), HeadPendantClickableView.this.aeK.aSp().getName_show(), HeadPendantClickableView.this.aeK.aSt(), str, HeadPendantClickableView.this.aeK.getTid(), HeadPendantClickableView.this.aeK.getNid())));
                    }
                    if (HeadPendantClickableView.this.ahw != null) {
                        HeadPendantClickableView.this.ahw.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bu buVar) {
        setData(buVar, false);
    }

    public void setData(bu buVar, boolean z) {
        if (buVar != null && buVar.aSp() != null) {
            this.aeK = buVar;
            MetaData aSp = buVar.aSp();
            setContentDescription(aSp.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aSp.getUserId());
            getHeadView().setUserName(aSp.getUserName());
            getHeadView().setUrl(aSp.getAvater());
            if (!StringUtils.isNull(aSp.getAvater()) && aSp.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(aSp.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(aSp.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(aSp.getAvater(), 28, false);
            }
            a(aSp, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            bu buVar = new bu();
            buVar.a(metaData);
            setData(buVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
    }
}
