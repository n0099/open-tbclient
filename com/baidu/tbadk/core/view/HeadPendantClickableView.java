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
    private cb ahi;
    private View.OnClickListener ajT;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.ahi != null && HeadPendantClickableView.this.ahi.bnQ() != null && !StringUtils.isNull(HeadPendantClickableView.this.ahi.bnQ().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ahi.bnQ().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.ahi.eTE) {
                        if (!HeadPendantClickableView.this.ahi.bpK()) {
                            if (HeadPendantClickableView.this.ahi.blu()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.ahi.bnQ().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ahi.bnQ().getUserId(), HeadPendantClickableView.this.ahi.bnQ().getName_show(), HeadPendantClickableView.this.ahi.bnU(), str, HeadPendantClickableView.this.ahi.getTid(), HeadPendantClickableView.this.ahi.bmo())));
                    }
                    if (HeadPendantClickableView.this.ajT != null) {
                        HeadPendantClickableView.this.ajT.onClick(view);
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
                if (HeadPendantClickableView.this.ahi != null && HeadPendantClickableView.this.ahi.bnQ() != null && !StringUtils.isNull(HeadPendantClickableView.this.ahi.bnQ().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.ahi.bnQ().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.ahi.eTE) {
                        if (!HeadPendantClickableView.this.ahi.bpK()) {
                            if (HeadPendantClickableView.this.ahi.blu()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.ahi.bnQ().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.ahi.bnQ().getUserId(), HeadPendantClickableView.this.ahi.bnQ().getName_show(), HeadPendantClickableView.this.ahi.bnU(), str, HeadPendantClickableView.this.ahi.getTid(), HeadPendantClickableView.this.ahi.bmo())));
                    }
                    if (HeadPendantClickableView.this.ajT != null) {
                        HeadPendantClickableView.this.ajT.onClick(view);
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
        if (cbVar != null && cbVar.bnQ() != null) {
            this.ahi = cbVar;
            MetaData bnQ = cbVar.bnQ();
            setContentDescription(bnQ.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(bnQ.getUserId());
            getHeadView().setUserName(bnQ.getUserName());
            getHeadView().setUrl(bnQ.getAvater());
            if (bnQ.isDefaultAvatar && com.baidu.tbadk.a.d.biX()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(bnQ.getAvater()) && bnQ.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bnQ.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(bnQ.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(bnQ.getAvater(), 28, false);
            }
            a(bnQ, 0);
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
        this.ajT = onClickListener;
    }
}
