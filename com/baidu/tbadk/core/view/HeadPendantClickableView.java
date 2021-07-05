package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.b.d;
import d.a.r0.r.q.b2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HeadPendantClickableView extends HeadPendantView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b2 q;
    public Context r;
    public View.OnClickListener s;
    public View.OnClickListener t;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HeadPendantClickableView f12406e;

        public a(HeadPendantClickableView headPendantClickableView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headPendantClickableView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12406e = headPendantClickableView;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            AlaInfoData alaInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12406e.q == null || this.f12406e.q.H() == null || StringUtils.isNull(this.f12406e.q.H().getName_show()) || StringUtils.isNull(this.f12406e.q.H().getUserId())) {
                return;
            }
            if (this.f12406e.q.W1) {
                str3 = AddFriendActivityConfig.TYPE_HOME_HEAD;
                str = YYLiveUtil.SOURCE_HOME_RECOMMEND_HEAD;
            } else if (this.f12406e.q.O1()) {
                str3 = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                str = YYLiveUtil.SOURCE_HOME_FOLLOW_TAB_HEAD;
            } else if (!this.f12406e.q.isFromFrs()) {
                str = YYLiveUtil.SOURCE_NOT_DEFINE;
                str2 = "";
                String str4 = str;
                alaInfo = this.f12406e.q.H().getAlaInfo();
                if (alaInfo == null && alaInfo.isLegalYYLiveData()) {
                    TbPageContext tbPageContext = this.f12406e.getTbPageContext();
                    YyExtData yyExtData = alaInfo.mYyExtData;
                    YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + alaInfo.roomId, str4);
                    HeadPendantClickableView headPendantClickableView = this.f12406e;
                    headPendantClickableView.r(headPendantClickableView.q.n1(), String.valueOf(this.f12406e.q.Q()), String.valueOf(alaInfo.roomId), String.valueOf(alaInfo.live_id), alaInfo.mYyExtData.mSid);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f12406e.r, this.f12406e.q.H().getUserId(), this.f12406e.q.H().getName_show(), this.f12406e.q.W(), str2, this.f12406e.q.n1(), this.f12406e.q.A0())));
                }
                if (this.f12406e.s == null) {
                    this.f12406e.s.onClick(view);
                    return;
                }
                return;
            } else {
                str = YYLiveUtil.SOURCE_FRS_LIVE_HEAD_ + TbSingleton.getInstance().getFrsCurTabType();
                str3 = AddFriendActivityConfig.TYPE_FRS_HEAD;
            }
            str2 = str3;
            String str42 = str;
            alaInfo = this.f12406e.q.H().getAlaInfo();
            if (alaInfo == null) {
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f12406e.r, this.f12406e.q.H().getUserId(), this.f12406e.q.H().getName_show(), this.f12406e.q.W(), str2, this.f12406e.q.n1(), this.f12406e.q.A0())));
            if (this.f12406e.s == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadPendantClickableView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.t = aVar;
        this.r = context;
        setOnClickListener(aVar);
    }

    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final void r(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, str5) == null) {
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
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b2Var) == null) {
            setData(b2Var, false);
        }
    }

    public void setData(b2 b2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, b2Var, z) == null) || b2Var == null || b2Var.H() == null) {
            return;
        }
        this.q = b2Var;
        MetaData H = b2Var.H();
        setContentDescription(H.getName_show() + this.r.getString(R.string.somebodys_portrait));
        getHeadView().setUserId(H.getUserId());
        getHeadView().setUserName(H.getUserName());
        getHeadView().setUrl(H.getAvater());
        if (H.isDefaultAvatar && d.V()) {
            getHeadView().M(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
        } else if (!StringUtils.isNull(H.getAvater()) && H.getAvater().startsWith("http")) {
            getHeadView().M(H.getAvater(), 10, false);
        } else if (z) {
            getHeadView().M(H.getAvater(), 25, false);
        } else {
            getHeadView().M(H.getAvater(), 28, false);
        }
        i(H, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.t = aVar;
        this.r = context;
        setOnClickListener(aVar);
    }

    public void setData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, metaData) == null) {
            setData(metaData, false);
        }
    }

    public void setData(MetaData metaData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, metaData, z) == null) || metaData == null) {
            return;
        }
        b2 b2Var = new b2();
        b2Var.h3(metaData);
        setData(b2Var, z);
    }
}
