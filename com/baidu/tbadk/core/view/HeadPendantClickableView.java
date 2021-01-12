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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bz ahu;
    private View.OnClickListener ake;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.ahu != null && HeadPendantClickableView.this.ahu.bnx() != null && !StringUtils.isNull(HeadPendantClickableView.this.ahu.bnx().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ahu.bnx().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.ahu.eRs) {
                        if (!HeadPendantClickableView.this.ahu.bps()) {
                            if (HeadPendantClickableView.this.ahu.blc()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.ahu.bnx().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ahu.bnx().getUserId(), HeadPendantClickableView.this.ahu.bnx().getName_show(), HeadPendantClickableView.this.ahu.bnB(), str, HeadPendantClickableView.this.ahu.getTid(), HeadPendantClickableView.this.ahu.blV())));
                    }
                    if (HeadPendantClickableView.this.ake != null) {
                        HeadPendantClickableView.this.ake.onClick(view);
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
                if (HeadPendantClickableView.this.ahu != null && HeadPendantClickableView.this.ahu.bnx() != null && !StringUtils.isNull(HeadPendantClickableView.this.ahu.bnx().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ahu.bnx().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.ahu.eRs) {
                        if (!HeadPendantClickableView.this.ahu.bps()) {
                            if (HeadPendantClickableView.this.ahu.blc()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.ahu.bnx().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ahu.bnx().getUserId(), HeadPendantClickableView.this.ahu.bnx().getName_show(), HeadPendantClickableView.this.ahu.bnB(), str, HeadPendantClickableView.this.ahu.getTid(), HeadPendantClickableView.this.ahu.blV())));
                    }
                    if (HeadPendantClickableView.this.ake != null) {
                        HeadPendantClickableView.this.ake.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bz bzVar) {
        setData(bzVar, false);
    }

    public void setData(bz bzVar, boolean z) {
        if (bzVar != null && bzVar.bnx() != null) {
            this.ahu = bzVar;
            MetaData bnx = bzVar.bnx();
            setContentDescription(bnx.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(bnx.getUserId());
            getHeadView().setUserName(bnx.getUserName());
            getHeadView().setUrl(bnx.getAvater());
            if (bnx.isDefaultAvatar && com.baidu.tbadk.a.d.biL()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(bnx.getAvater()) && bnx.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bnx.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(bnx.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(bnx.getAvater(), 28, false);
            }
            a(bnx, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            bz bzVar = new bz();
            bzVar.a(metaData);
            setData(bzVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ake = onClickListener;
    }
}
