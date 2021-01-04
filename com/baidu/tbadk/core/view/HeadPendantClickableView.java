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
    private bz aim;
    private View.OnClickListener akV;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.aim != null && HeadPendantClickableView.this.aim.brq() != null && !StringUtils.isNull(HeadPendantClickableView.this.aim.brq().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aim.brq().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aim.eWd) {
                        if (!HeadPendantClickableView.this.aim.btl()) {
                            if (HeadPendantClickableView.this.aim.boV()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aim.brq().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aim.brq().getUserId(), HeadPendantClickableView.this.aim.brq().getName_show(), HeadPendantClickableView.this.aim.bru(), str, HeadPendantClickableView.this.aim.getTid(), HeadPendantClickableView.this.aim.bpO())));
                    }
                    if (HeadPendantClickableView.this.akV != null) {
                        HeadPendantClickableView.this.akV.onClick(view);
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
                if (HeadPendantClickableView.this.aim != null && HeadPendantClickableView.this.aim.brq() != null && !StringUtils.isNull(HeadPendantClickableView.this.aim.brq().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.aim.brq().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.aim.eWd) {
                        if (!HeadPendantClickableView.this.aim.btl()) {
                            if (HeadPendantClickableView.this.aim.boV()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.aim.brq().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.aim.brq().getUserId(), HeadPendantClickableView.this.aim.brq().getName_show(), HeadPendantClickableView.this.aim.bru(), str, HeadPendantClickableView.this.aim.getTid(), HeadPendantClickableView.this.aim.bpO())));
                    }
                    if (HeadPendantClickableView.this.akV != null) {
                        HeadPendantClickableView.this.akV.onClick(view);
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
        if (bzVar != null && bzVar.brq() != null) {
            this.aim = bzVar;
            MetaData brq = bzVar.brq();
            setContentDescription(brq.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(brq.getUserId());
            getHeadView().setUserName(brq.getUserName());
            getHeadView().setUrl(brq.getAvater());
            if (brq.isDefaultAvatar && com.baidu.tbadk.a.d.bmE()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(brq.getAvater()) && brq.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(brq.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(brq.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(brq.getAvater(), 28, false);
            }
            a(brq, 0);
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
        this.akV = onClickListener;
    }
}
