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
    private bw agf;
    private View.OnClickListener aiW;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.agf != null && HeadPendantClickableView.this.agf.bfy() != null && !StringUtils.isNull(HeadPendantClickableView.this.agf.bfy().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.agf.bfy().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.agf.egt) {
                        if (!HeadPendantClickableView.this.agf.bhq()) {
                            if (HeadPendantClickableView.this.agf.bdg()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.agf.bfy().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.agf.bfy().getUserId(), HeadPendantClickableView.this.agf.bfy().getName_show(), HeadPendantClickableView.this.agf.bfC(), str, HeadPendantClickableView.this.agf.getTid(), HeadPendantClickableView.this.agf.getNid())));
                    }
                    if (HeadPendantClickableView.this.aiW != null) {
                        HeadPendantClickableView.this.aiW.onClick(view);
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
                if (HeadPendantClickableView.this.agf != null && HeadPendantClickableView.this.agf.bfy() != null && !StringUtils.isNull(HeadPendantClickableView.this.agf.bfy().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.agf.bfy().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.agf.egt) {
                        if (!HeadPendantClickableView.this.agf.bhq()) {
                            if (HeadPendantClickableView.this.agf.bdg()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.agf.bfy().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.agf.bfy().getUserId(), HeadPendantClickableView.this.agf.bfy().getName_show(), HeadPendantClickableView.this.agf.bfC(), str, HeadPendantClickableView.this.agf.getTid(), HeadPendantClickableView.this.agf.getNid())));
                    }
                    if (HeadPendantClickableView.this.aiW != null) {
                        HeadPendantClickableView.this.aiW.onClick(view);
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
        if (bwVar != null && bwVar.bfy() != null) {
            this.agf = bwVar;
            MetaData bfy = bwVar.bfy();
            setContentDescription(bfy.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(bfy.getUserId());
            getHeadView().setUserName(bfy.getUserName());
            getHeadView().setUrl(bfy.getAvater());
            if (bfy.isDefaultAvatar && com.baidu.tbadk.a.d.baT()) {
                getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(bfy.getAvater()) && bfy.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(bfy.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(bfy.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(bfy.getAvater(), 28, false);
            }
            a(bfy, 0);
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
        this.aiW = onClickListener;
    }
}
