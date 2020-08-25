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
/* loaded from: classes2.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bw afJ;
    private View.OnClickListener aiA;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.afJ != null && HeadPendantClickableView.this.afJ.beE() != null && !StringUtils.isNull(HeadPendantClickableView.this.afJ.beE().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.afJ.beE().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.afJ.eef) {
                        if (!HeadPendantClickableView.this.afJ.bgw()) {
                            if (HeadPendantClickableView.this.afJ.bcm()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.afJ.beE().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.afJ.beE().getUserId(), HeadPendantClickableView.this.afJ.beE().getName_show(), HeadPendantClickableView.this.afJ.beI(), str, HeadPendantClickableView.this.afJ.getTid(), HeadPendantClickableView.this.afJ.getNid())));
                    }
                    if (HeadPendantClickableView.this.aiA != null) {
                        HeadPendantClickableView.this.aiA.onClick(view);
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
                if (HeadPendantClickableView.this.afJ != null && HeadPendantClickableView.this.afJ.beE() != null && !StringUtils.isNull(HeadPendantClickableView.this.afJ.beE().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.afJ.beE().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.afJ.eef) {
                        if (!HeadPendantClickableView.this.afJ.bgw()) {
                            if (HeadPendantClickableView.this.afJ.bcm()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.afJ.beE().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.afJ.beE().getUserId(), HeadPendantClickableView.this.afJ.beE().getName_show(), HeadPendantClickableView.this.afJ.beI(), str, HeadPendantClickableView.this.afJ.getTid(), HeadPendantClickableView.this.afJ.getNid())));
                    }
                    if (HeadPendantClickableView.this.aiA != null) {
                        HeadPendantClickableView.this.aiA.onClick(view);
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
        if (bwVar != null && bwVar.beE() != null) {
            this.afJ = bwVar;
            MetaData beE = bwVar.beE();
            setContentDescription(beE.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(beE.getUserId());
            getHeadView().setUserName(beE.getUserName());
            getHeadView().setUrl(beE.getAvater());
            if (beE.isDefaultAvatar && com.baidu.tbadk.a.d.bad()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(beE.getAvater()) && beE.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(beE.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(beE.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(beE.getAvater(), 28, false);
            }
            a(beE, 0);
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
        this.aiA = onClickListener;
    }
}
