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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private cb aiB;
    private View.OnClickListener alm;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aiB != null && HeadPendantClickableView.this.aiB.bnS() != null && !StringUtils.isNull(HeadPendantClickableView.this.aiB.bnS().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aiB.bnS().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aiB.eVf) {
                        if (!HeadPendantClickableView.this.aiB.bpM()) {
                            if (HeadPendantClickableView.this.aiB.blw()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aiB.bnS().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aiB.bnS().getUserId(), HeadPendantClickableView.this.aiB.bnS().getName_show(), HeadPendantClickableView.this.aiB.bnW(), str, HeadPendantClickableView.this.aiB.getTid(), HeadPendantClickableView.this.aiB.bmq())));
                    }
                    if (HeadPendantClickableView.this.alm != null) {
                        HeadPendantClickableView.this.alm.onClick(view);
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
                if (HeadPendantClickableView.this.aiB != null && HeadPendantClickableView.this.aiB.bnS() != null && !StringUtils.isNull(HeadPendantClickableView.this.aiB.bnS().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aiB.bnS().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aiB.eVf) {
                        if (!HeadPendantClickableView.this.aiB.bpM()) {
                            if (HeadPendantClickableView.this.aiB.blw()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aiB.bnS().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aiB.bnS().getUserId(), HeadPendantClickableView.this.aiB.bnS().getName_show(), HeadPendantClickableView.this.aiB.bnW(), str, HeadPendantClickableView.this.aiB.getTid(), HeadPendantClickableView.this.aiB.bmq())));
                    }
                    if (HeadPendantClickableView.this.alm != null) {
                        HeadPendantClickableView.this.alm.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(cb cbVar) {
        setData(cbVar, false);
    }

    public void setData(cb cbVar, boolean z) {
        if (cbVar != null && cbVar.bnS() != null) {
            this.aiB = cbVar;
            MetaData bnS = cbVar.bnS();
            setContentDescription(bnS.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(bnS.getUserId());
            getHeadView().setUserName(bnS.getUserName());
            getHeadView().setUrl(bnS.getAvater());
            if (bnS.isDefaultAvatar && com.baidu.tbadk.a.d.biZ()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(bnS.getAvater()) && bnS.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bnS.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(bnS.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(bnS.getAvater(), 28, false);
            }
            a(bnS, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            cb cbVar = new cb();
            cbVar.a(metaData);
            setData(cbVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }
}
