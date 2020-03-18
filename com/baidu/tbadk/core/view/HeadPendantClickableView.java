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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bj KJ;
    private View.OnClickListener Ni;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.KJ != null && HeadPendantClickableView.this.KJ.aCr() != null && !StringUtils.isNull(HeadPendantClickableView.this.KJ.aCr().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.KJ.aCr().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.KJ.cUF) {
                        if (!HeadPendantClickableView.this.KJ.aEf()) {
                            if (HeadPendantClickableView.this.KJ.aEg()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.KJ.aCr().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.KJ.aCr().getUserId(), HeadPendantClickableView.this.KJ.aCr().getName_show(), HeadPendantClickableView.this.KJ.aCw(), str, HeadPendantClickableView.this.KJ.getTid())));
                    }
                    if (HeadPendantClickableView.this.Ni != null) {
                        HeadPendantClickableView.this.Ni.onClick(view);
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
                if (HeadPendantClickableView.this.KJ != null && HeadPendantClickableView.this.KJ.aCr() != null && !StringUtils.isNull(HeadPendantClickableView.this.KJ.aCr().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.KJ.aCr().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.KJ.cUF) {
                        if (!HeadPendantClickableView.this.KJ.aEf()) {
                            if (HeadPendantClickableView.this.KJ.aEg()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.KJ.aCr().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.KJ.aCr().getUserId(), HeadPendantClickableView.this.KJ.aCr().getName_show(), HeadPendantClickableView.this.KJ.aCw(), str, HeadPendantClickableView.this.KJ.getTid())));
                    }
                    if (HeadPendantClickableView.this.Ni != null) {
                        HeadPendantClickableView.this.Ni.onClick(view);
                    }
                }
            }
        };
        this.mContext = context;
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bj bjVar) {
        setData(bjVar, false);
    }

    public void setData(bj bjVar, boolean z) {
        if (bjVar != null && bjVar.aCr() != null) {
            this.KJ = bjVar;
            MetaData aCr = bjVar.aCr();
            setContentDescription(aCr.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aCr.getUserId());
            getHeadView().setUserName(aCr.getUserName());
            getHeadView().setUrl(aCr.getAvater());
            if (!StringUtils.isNull(aCr.getAvater()) && aCr.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(aCr.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(aCr.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(aCr.getAvater(), 28, false);
            }
            a(aCr, 0);
        }
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData != null) {
            bj bjVar = new bj();
            bjVar.a(metaData);
            setData(bjVar, z);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Ni = onClickListener;
    }
}
