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
    private View.OnClickListener Nh;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.HeadPendantClickableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HeadPendantClickableView.this.KJ != null && HeadPendantClickableView.this.KJ.aCo() != null && !StringUtils.isNull(HeadPendantClickableView.this.KJ.aCo().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.KJ.aCo().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.KJ.cUr) {
                        if (!HeadPendantClickableView.this.KJ.aEb()) {
                            if (HeadPendantClickableView.this.KJ.aEc()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.KJ.aCo().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.KJ.aCo().getUserId(), HeadPendantClickableView.this.KJ.aCo().getName_show(), HeadPendantClickableView.this.KJ.aCt(), str, HeadPendantClickableView.this.KJ.getTid())));
                    }
                    if (HeadPendantClickableView.this.Nh != null) {
                        HeadPendantClickableView.this.Nh.onClick(view);
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
                if (HeadPendantClickableView.this.KJ != null && HeadPendantClickableView.this.KJ.aCo() != null && !StringUtils.isNull(HeadPendantClickableView.this.KJ.aCo().getName_show()) && !StringUtils.isNull(HeadPendantClickableView.this.KJ.aCo().getUserId())) {
                    String str = "";
                    if (!HeadPendantClickableView.this.KJ.cUr) {
                        if (!HeadPendantClickableView.this.KJ.aEb()) {
                            if (HeadPendantClickableView.this.KJ.aEc()) {
                                str = AddFriendActivityConfig.TYPE_FRS_HEAD;
                            }
                        } else {
                            str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                        }
                    } else {
                        str = AddFriendActivityConfig.TYPE_HOME_HEAD;
                    }
                    AlaUserInfoData alaUserData = HeadPendantClickableView.this.KJ.aCo().getAlaUserData();
                    if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = alaUserData.live_id;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.mContext, alaLiveInfoCoreData, "person_attention", null, false, "")));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(HeadPendantClickableView.this.mContext, HeadPendantClickableView.this.KJ.aCo().getUserId(), HeadPendantClickableView.this.KJ.aCo().getName_show(), HeadPendantClickableView.this.KJ.aCt(), str, HeadPendantClickableView.this.KJ.getTid())));
                    }
                    if (HeadPendantClickableView.this.Nh != null) {
                        HeadPendantClickableView.this.Nh.onClick(view);
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
        if (bjVar != null && bjVar.aCo() != null) {
            this.KJ = bjVar;
            MetaData aCo = bjVar.aCo();
            setContentDescription(aCo.getName_show() + this.mContext.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(aCo.getUserId());
            getHeadView().setUserName(aCo.getUserName());
            getHeadView().setUrl(aCo.getAvater());
            if (!StringUtils.isNull(aCo.getAvater()) && aCo.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                getHeadView().startLoad(aCo.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(aCo.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(aCo.getAvater(), 28, false);
            }
            a(aCo, 0);
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
        this.Nh = onClickListener;
    }
}
