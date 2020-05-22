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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bk aee;
    private View.OnClickListener ags;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aee != null && HeadPendantClickableView.this.aee.aQx() != null && !StringUtils.isNull(HeadPendantClickableView.this.aee.aQx().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aee.aQx().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aee.dHM) {
                        if (!HeadPendantClickableView.this.aee.aSq()) {
                            if (HeadPendantClickableView.this.aee.aSr()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aee.aQx().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aee.aQx().getUserId(), HeadPendantClickableView.this.aee.aQx().getName_show(), HeadPendantClickableView.this.aee.aQC(), str, HeadPendantClickableView.this.aee.getTid(), HeadPendantClickableView.this.aee.getNid())));
                    }
                    if (HeadPendantClickableView.this.ags != null) {
                        HeadPendantClickableView.this.ags.onClick(view);
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
                if (HeadPendantClickableView.this.aee != null && HeadPendantClickableView.this.aee.aQx() != null && !StringUtils.isNull(HeadPendantClickableView.this.aee.aQx().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aee.aQx().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aee.dHM) {
                        if (!HeadPendantClickableView.this.aee.aSq()) {
                            if (HeadPendantClickableView.this.aee.aSr()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aee.aQx().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aee.aQx().getUserId(), HeadPendantClickableView.this.aee.aQx().getName_show(), HeadPendantClickableView.this.aee.aQC(), str, HeadPendantClickableView.this.aee.getTid(), HeadPendantClickableView.this.aee.getNid())));
                    }
                    if (HeadPendantClickableView.this.ags != null) {
                        HeadPendantClickableView.this.ags.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bk bkVar) {
        setData(bkVar, false);
    }

    public void setData(bk bkVar, boolean z) {
        if (bkVar != null && bkVar.aQx() != null) {
            this.aee = bkVar;
            MetaData aQx = bkVar.aQx();
            setContentDescription(aQx.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aQx.getUserId());
            getHeadView().setUserName(aQx.getUserName());
            getHeadView().setUrl(aQx.getAvater());
            if (!StringUtils.isNull(aQx.getAvater()) && aQx.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(aQx.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(aQx.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(aQx.getAvater(), 28, false);
            }
            a(aQx, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            bk bkVar = new bk();
            bkVar.a(metaData);
            setData(bkVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }
}
