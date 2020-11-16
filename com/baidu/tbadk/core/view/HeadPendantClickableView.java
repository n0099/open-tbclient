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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bx agB;
    private View.OnClickListener aju;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.agB != null && HeadPendantClickableView.this.agB.blC() != null && !StringUtils.isNull(HeadPendantClickableView.this.agB.blC().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.agB.blC().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.agB.eFg) {
                        if (!HeadPendantClickableView.this.agB.bnw()) {
                            if (HeadPendantClickableView.this.agB.bjk()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.agB.blC().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.agB.blC().getUserId(), HeadPendantClickableView.this.agB.blC().getName_show(), HeadPendantClickableView.this.agB.blG(), str, HeadPendantClickableView.this.agB.getTid(), HeadPendantClickableView.this.agB.getNid())));
                    }
                    if (HeadPendantClickableView.this.aju != null) {
                        HeadPendantClickableView.this.aju.onClick(view);
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
                if (HeadPendantClickableView.this.agB != null && HeadPendantClickableView.this.agB.blC() != null && !StringUtils.isNull(HeadPendantClickableView.this.agB.blC().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.agB.blC().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.agB.eFg) {
                        if (!HeadPendantClickableView.this.agB.bnw()) {
                            if (HeadPendantClickableView.this.agB.bjk()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.agB.blC().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.agB.blC().getUserId(), HeadPendantClickableView.this.agB.blC().getName_show(), HeadPendantClickableView.this.agB.blG(), str, HeadPendantClickableView.this.agB.getTid(), HeadPendantClickableView.this.agB.getNid())));
                    }
                    if (HeadPendantClickableView.this.aju != null) {
                        HeadPendantClickableView.this.aju.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bx bxVar) {
        setData(bxVar, false);
    }

    public void setData(bx bxVar, boolean z) {
        if (bxVar != null && bxVar.blC() != null) {
            this.agB = bxVar;
            MetaData blC = bxVar.blC();
            setContentDescription(blC.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(blC.getUserId());
            getHeadView().setUserName(blC.getUserName());
            getHeadView().setUrl(blC.getAvater());
            if (blC.isDefaultAvatar && com.baidu.tbadk.a.d.bhm()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(blC.getAvater()) && blC.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(blC.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(blC.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(blC.getAvater(), 28, false);
            }
            a(blC, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            bx bxVar = new bx();
            bxVar.a(metaData);
            setData(bxVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aju = onClickListener;
    }
}
