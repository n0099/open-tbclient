package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import c.a.o0.b.d;
import c.a.o0.s.q.c2;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class HeadPendantClickableView extends HeadPendantView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener mOnClickListener;
    public c2 r;
    public Context s;
    public View.OnClickListener t;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HeadPendantClickableView f47415e;

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
            this.f47415e = headPendantClickableView;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x019d  */
        /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            String str4;
            AlaInfoData alaInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47415e.r == null || this.f47415e.r.J() == null || StringUtils.isNull(this.f47415e.r.J().getName_show()) || StringUtils.isNull(this.f47415e.r.J().getUserId())) {
                return;
            }
            boolean z = this.f47415e.r.X1;
            String str5 = AddFriendActivityConfig.TYPE_HOME_HEAD;
            if (z) {
                if (this.f47415e.r.m1() == 69) {
                    str3 = YYLiveUtil.SOURCE_HOME_RECOMMEND_LIVE_HEAD;
                } else {
                    str3 = this.f47415e.r.m1() == 40 ? YYLiveUtil.SOURCE_HOME_RECOMMEND_VIDEO_HEAD : YYLiveUtil.SOURCE_HOME_RECOMMEND_TUWEN_HEAD;
                }
            } else {
                if (this.f47415e.r.U1()) {
                    if (this.f47415e.r.m1() == 69) {
                        str4 = YYLiveUtil.SOURCE_HOME_CONCERN_LIVE_HEAD;
                    } else {
                        str4 = this.f47415e.r.m1() == 40 ? YYLiveUtil.SOURCE_HOME_CONCERN_VIDEO_HEAD : YYLiveUtil.SOURCE_HOME_CONCERN_TUWEN_HEAD;
                    }
                    str = str4;
                    str2 = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                } else if (this.f47415e.r.isFromFrs()) {
                    str3 = YYLiveUtil.SOURCE_FRS_LIVE_HEAD_ + TbSingleton.getInstance().getFrsCurTabType();
                    str5 = AddFriendActivityConfig.TYPE_FRS_HEAD;
                } else {
                    str = YYLiveUtil.SOURCE_NOT_DEFINE;
                    str2 = "";
                }
                alaInfo = this.f47415e.r.J().getAlaInfo();
                if (alaInfo == null && alaInfo.isLegalYYLiveData()) {
                    TbPageContext tbPageContext = this.f47415e.getTbPageContext();
                    YyExtData yyExtData = alaInfo.mYyExtData;
                    YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + alaInfo.roomId, str);
                    HeadPendantClickableView headPendantClickableView = this.f47415e;
                    headPendantClickableView.j(headPendantClickableView.r.q1(), String.valueOf(this.f47415e.r.T()), String.valueOf(alaInfo.roomId), String.valueOf(alaInfo.live_id), alaInfo.mYyExtData.mSid);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f47415e.s, this.f47415e.r.J().getUserId(), this.f47415e.r.J().getName_show(), this.f47415e.r.Z(), str2, this.f47415e.r.q1(), this.f47415e.r.D0())));
                }
                if (this.f47415e.t == null) {
                    this.f47415e.t.onClick(view);
                    return;
                }
                return;
            }
            str = str3;
            str2 = str5;
            alaInfo = this.f47415e.r.J().getAlaInfo();
            if (alaInfo == null) {
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f47415e.s, this.f47415e.r.J().getUserId(), this.f47415e.r.J().getName_show(), this.f47415e.r.Z(), str2, this.f47415e.r.q1(), this.f47415e.r.D0())));
            if (this.f47415e.t == null) {
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
        this.mOnClickListener = aVar;
        this.s = context;
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

    public final void j(String str, String str2, String str3, String str4, String str5) {
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
            this.t = onClickListener;
        }
    }

    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c2Var) == null) {
            setData(c2Var, false);
        }
    }

    public void setData(c2 c2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, c2Var, z) == null) || c2Var == null || c2Var.J() == null) {
            return;
        }
        this.r = c2Var;
        MetaData J = c2Var.J();
        setContentDescription(J.getName_show() + this.s.getString(R.string.somebodys_portrait));
        getHeadView().setUserId(J.getUserId());
        getHeadView().setUserName(J.getUserName());
        getHeadView().setUrl(J.getAvater());
        if (J.isDefaultAvatar && d.r0()) {
            getHeadView().startLoad(String.valueOf(R.drawable.pic_mask_pass_head), 24, false);
        } else if (!StringUtils.isNull(J.getAvater()) && J.getAvater().startsWith("http")) {
            getHeadView().startLoad(J.getAvater(), 10, false);
        } else if (z) {
            getHeadView().startLoad(J.getAvater(), 25, false);
        } else {
            getHeadView().startLoad(J.getAvater(), 28, false);
        }
        showHeadPendantAndBigV(J, 0);
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
        this.mOnClickListener = aVar;
        this.s = context;
        setOnClickListener(aVar);
    }

    public void setData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, metaData) == null) {
            setData(metaData, false);
        }
    }

    public void setData(MetaData metaData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, metaData, z) == null) || metaData == null) {
            return;
        }
        c2 c2Var = new c2();
        c2Var.r3(metaData);
        setData(c2Var, z);
    }
}
