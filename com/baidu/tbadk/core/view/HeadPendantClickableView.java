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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes3.dex */
public class HeadPendantClickableView extends HeadPendantView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData m;
    public Context n;
    public View.OnClickListener o;
    public View.OnClickListener p;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeadPendantClickableView a;

        public a(HeadPendantClickableView headPendantClickableView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headPendantClickableView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = headPendantClickableView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.m == null || this.a.m.getAuthor() == null || StringUtils.isNull(this.a.m.getAuthor().getName_show()) || StringUtils.isNull(this.a.m.getAuthor().getUserId())) {
                return;
            }
            if (this.a.m.isFromHomPage) {
                if (this.a.m.getThreadType() == 69) {
                    str5 = YYLiveUtil.SOURCE_HOME_RECOMMEND_LIVE_HEAD;
                } else {
                    str5 = this.a.m.getThreadType() == 40 ? YYLiveUtil.SOURCE_HOME_RECOMMEND_VIDEO_HEAD : YYLiveUtil.SOURCE_HOME_RECOMMEND_TUWEN_HEAD;
                }
                str = str5;
                str2 = AddFriendActivityConfig.TYPE_HOME_HEAD;
            } else if (this.a.m.isFromConcern()) {
                if (this.a.m.getThreadType() == 69) {
                    str4 = YYLiveUtil.SOURCE_HOME_CONCERN_LIVE_HEAD;
                } else {
                    str4 = this.a.m.getThreadType() == 40 ? YYLiveUtil.SOURCE_HOME_CONCERN_VIDEO_HEAD : YYLiveUtil.SOURCE_HOME_CONCERN_TUWEN_HEAD;
                }
                str = str4;
                str2 = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
            } else if (this.a.m.isFromFrs()) {
                if (this.a.m.getThreadType() == 69) {
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
            AlaInfoData alaInfo = this.a.m.getAuthor().getAlaInfo();
            if (alaInfo != null && alaInfo.isLegalYYLiveData()) {
                TbPageContext tbPageContext = this.a.getTbPageContext();
                YyExtData yyExtData = alaInfo.mYyExtData;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + alaInfo.roomId, alaInfo.mYyExtData.streamInfo, str);
                HeadPendantClickableView headPendantClickableView = this.a;
                headPendantClickableView.s(headPendantClickableView.m.getTid(), String.valueOf(this.a.m.getFid()), String.valueOf(alaInfo.roomId), String.valueOf(alaInfo.live_id), alaInfo.mYyExtData.mSid);
            } else {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.n, this.a.m.getAuthor().getUserId(), this.a.m.getAuthor().getName_show(), this.a.m.getForum_name(), str2, this.a.m.getTid(), this.a.m.getNid());
                personInfoActivityConfig.setIsVideoThread(this.a.m.getThreadVideoInfo() != null);
                if (this.a.m.getResource() != 1) {
                    if (this.a.m.getResource() != 2) {
                        if (this.a.m.getResource() == 5) {
                            personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
                        }
                    } else {
                        personInfoActivityConfig.setVideoPersonFrom("frs");
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
            if (this.a.o != null) {
                this.a.o.onClick(view2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.p = aVar;
        this.n = context;
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

    public final void s(String str, String str2, String str3, String str4, String str5) {
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) {
            setData(threadData, false);
        }
    }

    public void setData(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, threadData, z) == null) || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        this.m = threadData;
        MetaData author = threadData.getAuthor();
        setContentDescription(author.getName_show() + this.n.getString(R.string.obfuscated_res_0x7f0f11c1));
        getHeadView().setUserId(author.getUserId());
        getHeadView().setUserName(author.getUserName());
        getHeadView().setUrl(author.getAvater());
        if (author.isDefaultAvatar && UbsABTestHelper.showNewUI()) {
            getHeadView().J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080ed3), 24, false);
        } else if (!StringUtils.isNull(author.getAvater()) && author.getAvater().startsWith("http")) {
            getHeadView().J(author.getAvater(), 10, false);
        } else if (z) {
            getHeadView().J(author.getAvater(), 25, false);
        } else {
            getHeadView().J(author.getAvater(), 28, false);
        }
        j(author, 0);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.p = aVar;
        this.n = context;
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
        ThreadData threadData = new ThreadData();
        threadData.setAuthor(metaData);
        setData(threadData, z);
    }
}
