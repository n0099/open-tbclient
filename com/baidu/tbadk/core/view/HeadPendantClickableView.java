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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bw agx;
    private View.OnClickListener ajp;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.agx != null && HeadPendantClickableView.this.agx.bmA() != null && !StringUtils.isNull(HeadPendantClickableView.this.agx.bmA().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.agx.bmA().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.agx.eGO) {
                        if (!HeadPendantClickableView.this.agx.bos()) {
                            if (HeadPendantClickableView.this.agx.bki()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.agx.bmA().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.agx.bmA().getUserId(), HeadPendantClickableView.this.agx.bmA().getName_show(), HeadPendantClickableView.this.agx.bmE(), str, HeadPendantClickableView.this.agx.getTid(), HeadPendantClickableView.this.agx.getNid())));
                    }
                    if (HeadPendantClickableView.this.ajp != null) {
                        HeadPendantClickableView.this.ajp.onClick(view);
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
                if (HeadPendantClickableView.this.agx != null && HeadPendantClickableView.this.agx.bmA() != null && !StringUtils.isNull(HeadPendantClickableView.this.agx.bmA().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.agx.bmA().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.agx.eGO) {
                        if (!HeadPendantClickableView.this.agx.bos()) {
                            if (HeadPendantClickableView.this.agx.bki()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.agx.bmA().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.agx.bmA().getUserId(), HeadPendantClickableView.this.agx.bmA().getName_show(), HeadPendantClickableView.this.agx.bmE(), str, HeadPendantClickableView.this.agx.getTid(), HeadPendantClickableView.this.agx.getNid())));
                    }
                    if (HeadPendantClickableView.this.ajp != null) {
                        HeadPendantClickableView.this.ajp.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bw bwVar) {
        setData(bwVar, false);
    }

    public void setData(bw bwVar, boolean z) {
        if (bwVar != null && bwVar.bmA() != null) {
            this.agx = bwVar;
            MetaData bmA = bwVar.bmA();
            setContentDescription(bmA.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(bmA.getUserId());
            getHeadView().setUserName(bmA.getUserName());
            getHeadView().setUrl(bmA.getAvater());
            if (bmA.isDefaultAvatar && com.baidu.tbadk.a.d.bhU()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(bmA.getAvater()) && bmA.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bmA.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(bmA.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(bmA.getAvater(), 28, false);
            }
            a(bmA, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            bw bwVar = new bw();
            bwVar.a(metaData);
            setData(bwVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajp = onClickListener;
    }
}
