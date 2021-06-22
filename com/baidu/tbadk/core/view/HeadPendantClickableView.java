package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import d.a.n0.b.d;
import d.a.n0.r.q.a2;
import org.json.JSONException;
import org.json.JSONObject;
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

        /* JADX WARN: Removed duplicated region for block: B:31:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            AlaInfoData alaInfo;
            if (HeadPendantClickableView.this.q == null || HeadPendantClickableView.this.q.T() == null || StringUtils.isNull(HeadPendantClickableView.this.q.T().getName_show()) || StringUtils.isNull(HeadPendantClickableView.this.q.T().getUserId())) {
                return;
            }
            if (HeadPendantClickableView.this.q.V1) {
                str3 = AddFriendActivityConfig.TYPE_HOME_HEAD;
                str = YYLiveUtil.SOURCE_HOME_RECOMMEND_HEAD;
            } else if (HeadPendantClickableView.this.q.b2()) {
                str3 = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                str = YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_HEAD;
            } else if (!HeadPendantClickableView.this.q.k()) {
                str = YYLiveUtil.SOURCE_NOT_DEFINE;
                str2 = "";
                String str4 = str;
                alaInfo = HeadPendantClickableView.this.q.T().getAlaInfo();
                if (alaInfo == null && alaInfo.isLegalYYLiveData()) {
                    TbPageContext tbPageContext = HeadPendantClickableView.this.getTbPageContext();
                    YyExtData yyExtData = alaInfo.mYyExtData;
                    YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + alaInfo.roomId, str4);
                    HeadPendantClickableView headPendantClickableView = HeadPendantClickableView.this;
                    headPendantClickableView.r(headPendantClickableView.q.z1(), String.valueOf(HeadPendantClickableView.this.q.c0()), String.valueOf(alaInfo.roomId), String.valueOf(alaInfo.live_id), alaInfo.mYyExtData.mSid);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.r, HeadPendantClickableView.this.q.T().getUserId(), HeadPendantClickableView.this.q.T().getName_show(), HeadPendantClickableView.this.q.i0(), str2, HeadPendantClickableView.this.q.z1(), HeadPendantClickableView.this.q.M0())));
                }
                if (HeadPendantClickableView.this.s == null) {
                    HeadPendantClickableView.this.s.onClick(view);
                    return;
                }
                return;
            } else {
                str = YYLiveUtil.SOURCE_FRS_LIVE_HEAD_ + TbSingleton.getInstance().getFrsCurTabType();
                str3 = AddFriendActivityConfig.TYPE_FRS_HEAD;
            }
            str2 = str3;
            String str42 = str;
            alaInfo = HeadPendantClickableView.this.q.T().getAlaInfo();
            if (alaInfo == null) {
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(HeadPendantClickableView.this.r, HeadPendantClickableView.this.q.T().getUserId(), HeadPendantClickableView.this.q.T().getName_show(), HeadPendantClickableView.this.q.i0(), str2, HeadPendantClickableView.this.q.z1(), HeadPendantClickableView.this.q.M0())));
            if (HeadPendantClickableView.this.s == null) {
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

    public TbPageContext getTbPageContext() {
        Context context = getContext();
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public final void r(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tid", str);
            jSONObject.put("fid", str2);
            if (TextUtils.equals("0", str3)) {
                str3 = null;
            }
            jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, str3);
            if (TextUtils.equals("0", str4)) {
                str4 = null;
            }
            jSONObject.put("liveId", str4);
            jSONObject.put("sid", str5);
            jSONObject.put("roomInfo", "roomInfo");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
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
        if (T.isDefaultAvatar && d.V()) {
            getHeadView().U(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
        } else if (!StringUtils.isNull(T.getAvater()) && T.getAvater().startsWith("http")) {
            getHeadView().U(T.getAvater(), 10, false);
        } else if (z) {
            getHeadView().U(T.getAvater(), 25, false);
        } else {
            getHeadView().U(T.getAvater(), 28, false);
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
        a2Var.u3(metaData);
        setData(a2Var, z);
    }
}
