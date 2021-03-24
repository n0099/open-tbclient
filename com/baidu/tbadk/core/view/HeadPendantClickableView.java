package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import d.b.h0.b.d;
import d.b.h0.r.q.a2;
/* loaded from: classes3.dex */
public class HeadPendantClickableView extends HeadPendantView {
    public a2 q;
    public Context r;
    public View.OnClickListener s;
    public View.OnClickListener t;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (HeadPendantClickableView.this.q == null || HeadPendantClickableView.this.q.T() == null || StringUtils.isNull(HeadPendantClickableView.this.q.T().getName_show()) || StringUtils.isNull(HeadPendantClickableView.this.q.T().getUserId())) {
                return;
            }
            if (HeadPendantClickableView.this.q.T1) {
                str = AddFriendActivityConfig.TYPE_HOME_HEAD;
            } else if (HeadPendantClickableView.this.q.Y1()) {
                str = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
            } else {
                str = HeadPendantClickableView.this.q.o() ? AddFriendActivityConfig.TYPE_FRS_HEAD : "";
            }
            String str2 = str;
            AlaUserInfoData alaUserData = HeadPendantClickableView.this.q.T().getAlaUserData();
            if (alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = alaUserData.live_id;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(HeadPendantClickableView.this.r, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_ATTENTION, null, false, "")));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.r, HeadPendantClickableView.this.q.T().getUserId(), HeadPendantClickableView.this.q.T().getName_show(), HeadPendantClickableView.this.q.i0(), str2, HeadPendantClickableView.this.q.w1(), HeadPendantClickableView.this.q.L0())));
            }
            if (HeadPendantClickableView.this.s != null) {
                HeadPendantClickableView.this.s.onClick(view);
            }
        }
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        a aVar = new a();
        this.t = aVar;
        this.r = context;
        setOnClickListener(aVar);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public void setData(a2 a2Var) {
        setData(a2Var, false);
    }

    public void setData(a2 a2Var, boolean z) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        this.q = a2Var;
        MetaData T = a2Var.T();
        setContentDescription(T.getName_show() + this.r.getString(R.string.somebodys_portrait));
        getHeadView().setUserId(T.getUserId());
        getHeadView().setUserName(T.getUserName());
        getHeadView().setUrl(T.getAvater());
        if (T.isDefaultAvatar && d.R()) {
            getHeadView().W(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
        } else if (!StringUtils.isNull(T.getAvater()) && T.getAvater().startsWith("http")) {
            getHeadView().W(T.getAvater(), 10, false);
        } else if (z) {
            getHeadView().W(T.getAvater(), 25, false);
        } else {
            getHeadView().W(T.getAvater(), 28, false);
        }
        i(T, 0);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a();
        this.t = aVar;
        this.r = context;
        setOnClickListener(aVar);
    }

    public void setData(MetaData metaData) {
        setData(metaData, false);
    }

    public void setData(MetaData metaData, boolean z) {
        if (metaData == null) {
            return;
        }
        a2 a2Var = new a2();
        a2Var.p3(metaData);
        setData(a2Var, z);
    }
}
