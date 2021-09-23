package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import c.a.q0.b.d;
import c.a.q0.s.q.d2;
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
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
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
    public d2 q;
    public Context r;
    public View.OnClickListener s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HeadPendantClickableView f47743e;

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
            this.f47743e = headPendantClickableView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47743e.q == null || this.f47743e.q.J() == null || StringUtils.isNull(this.f47743e.q.J().getName_show()) || StringUtils.isNull(this.f47743e.q.J().getUserId())) {
                return;
            }
            if (this.f47743e.q.a2) {
                if (this.f47743e.q.o1() == 69) {
                    str5 = YYLiveUtil.SOURCE_HOME_RECOMMEND_LIVE_HEAD;
                } else {
                    str5 = this.f47743e.q.o1() == 40 ? YYLiveUtil.SOURCE_HOME_RECOMMEND_VIDEO_HEAD : YYLiveUtil.SOURCE_HOME_RECOMMEND_TUWEN_HEAD;
                }
                str = str5;
                str2 = AddFriendActivityConfig.TYPE_HOME_HEAD;
            } else if (this.f47743e.q.X1()) {
                if (this.f47743e.q.o1() == 69) {
                    str4 = YYLiveUtil.SOURCE_HOME_CONCERN_LIVE_HEAD;
                } else {
                    str4 = this.f47743e.q.o1() == 40 ? YYLiveUtil.SOURCE_HOME_CONCERN_VIDEO_HEAD : YYLiveUtil.SOURCE_HOME_CONCERN_TUWEN_HEAD;
                }
                str = str4;
                str2 = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
            } else if (this.f47743e.q.isFromFrs()) {
                if (this.f47743e.q.o1() == 69) {
                    str3 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB;
                } else {
                    str3 = YYLiveUtil.SOURCE_FRS_LIVE_HEAD_ + TbSingleton.getInstance().getFrsCurTabType();
                }
                str = str3;
                str2 = AddFriendActivityConfig.TYPE_FRS_HEAD;
            } else {
                str = YYLiveUtil.SOURCE_NOT_DEFINE;
                str2 = "";
            }
            AlaInfoData alaInfo = this.f47743e.q.J().getAlaInfo();
            if (alaInfo != null && alaInfo.isLegalYYLiveData()) {
                TbPageContext tbPageContext = this.f47743e.getTbPageContext();
                YyExtData yyExtData = alaInfo.mYyExtData;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + alaInfo.roomId, str);
                HeadPendantClickableView headPendantClickableView = this.f47743e;
                headPendantClickableView.j(headPendantClickableView.q.s1(), String.valueOf(this.f47743e.q.T()), String.valueOf(alaInfo.roomId), String.valueOf(alaInfo.live_id), alaInfo.mYyExtData.mSid);
            } else {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f47743e.r, this.f47743e.q.J().getUserId(), this.f47743e.q.J().getName_show(), this.f47743e.q.Z(), str2, this.f47743e.q.s1(), this.f47743e.q.F0());
                personInfoActivityConfig.setIsVideoThread(this.f47743e.q.q1() != null);
                if (this.f47743e.q.V0() != 1) {
                    if (this.f47743e.q.V0() != 2) {
                        if (this.f47743e.q.V0() == 5) {
                            personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
                        }
                    } else {
                        personInfoActivityConfig.setVideoPersonFrom("frs");
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom("home");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
            if (this.f47743e.s != null) {
                this.f47743e.s.onClick(view);
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
            this.s = onClickListener;
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d2Var) == null) {
            setData(d2Var, false);
        }
    }

    public void setData(d2 d2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, d2Var, z) == null) || d2Var == null || d2Var.J() == null) {
            return;
        }
        this.q = d2Var;
        MetaData J = d2Var.J();
        setContentDescription(J.getName_show() + this.r.getString(R.string.somebodys_portrait));
        getHeadView().setUserId(J.getUserId());
        getHeadView().setUserName(J.getUserName());
        getHeadView().setUrl(J.getAvater());
        if (J.isDefaultAvatar && d.h0()) {
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
        this.r = context;
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
        d2 d2Var = new d2();
        d2Var.x3(metaData);
        setData(d2Var, z);
    }
}
