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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bv aeA;
    private View.OnClickListener ahn;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aeA != null && HeadPendantClickableView.this.aeA.aWl() != null && !StringUtils.isNull(HeadPendantClickableView.this.aeA.aWl().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aeA.aWl().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aeA.dUJ) {
                        if (!HeadPendantClickableView.this.aeA.aYd()) {
                            if (HeadPendantClickableView.this.aeA.aTV()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aeA.aWl().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aeA.aWl().getUserId(), HeadPendantClickableView.this.aeA.aWl().getName_show(), HeadPendantClickableView.this.aeA.aWp(), str, HeadPendantClickableView.this.aeA.getTid(), HeadPendantClickableView.this.aeA.getNid())));
                    }
                    if (HeadPendantClickableView.this.ahn != null) {
                        HeadPendantClickableView.this.ahn.onClick(view);
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
                if (HeadPendantClickableView.this.aeA != null && HeadPendantClickableView.this.aeA.aWl() != null && !StringUtils.isNull(HeadPendantClickableView.this.aeA.aWl().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aeA.aWl().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aeA.dUJ) {
                        if (!HeadPendantClickableView.this.aeA.aYd()) {
                            if (HeadPendantClickableView.this.aeA.aTV()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aeA.aWl().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aeA.aWl().getUserId(), HeadPendantClickableView.this.aeA.aWl().getName_show(), HeadPendantClickableView.this.aeA.aWp(), str, HeadPendantClickableView.this.aeA.getTid(), HeadPendantClickableView.this.aeA.getNid())));
                    }
                    if (HeadPendantClickableView.this.ahn != null) {
                        HeadPendantClickableView.this.ahn.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bv bvVar) {
        setData(bvVar, false);
    }

    public void setData(bv bvVar, boolean z) {
        if (bvVar != null && bvVar.aWl() != null) {
            this.aeA = bvVar;
            MetaData aWl = bvVar.aWl();
            setContentDescription(aWl.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aWl.getUserId());
            getHeadView().setUserName(aWl.getUserName());
            getHeadView().setUrl(aWl.getAvater());
            if (aWl.isDefaultAvatar && com.baidu.tbadk.a.d.aRL()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(aWl.getAvater()) && aWl.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(aWl.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(aWl.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(aWl.getAvater(), 28, false);
            }
            a(aWl, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            bv bvVar = new bv();
            bvVar.a(metaData);
            setData(bvVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahn = onClickListener;
    }
}
