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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.o36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PeiwanInfo;
/* loaded from: classes4.dex */
public class HeadPendantClickableView extends HeadPendantView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData o;
    public Context p;
    public View.OnClickListener q;
    public int r;
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
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
            boolean z;
            String str5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.o != null && this.a.o.getAuthor() != null && !StringUtils.isNull(this.a.o.getAuthor().getName_show()) && !StringUtils.isNull(this.a.o.getAuthor().getUserId())) {
                if (this.a.o.isFromHomPage) {
                    if (this.a.o.getThreadType() == 69) {
                        str5 = YYLiveUtil.SOURCE_HOME_RECOMMEND_LIVE_HEAD;
                    } else if (this.a.o.getThreadType() == 40) {
                        str5 = YYLiveUtil.SOURCE_HOME_RECOMMEND_VIDEO_HEAD;
                    } else {
                        str5 = YYLiveUtil.SOURCE_HOME_RECOMMEND_TUWEN_HEAD;
                    }
                    str = str5;
                    str2 = AddFriendActivityConfig.TYPE_HOME_HEAD;
                } else if (this.a.o.isFromConcern()) {
                    if (this.a.o.getThreadType() == 69) {
                        str4 = YYLiveUtil.SOURCE_HOME_CONCERN_LIVE_HEAD;
                    } else if (this.a.o.getThreadType() == 40) {
                        str4 = YYLiveUtil.SOURCE_HOME_CONCERN_VIDEO_HEAD;
                    } else {
                        str4 = YYLiveUtil.SOURCE_HOME_CONCERN_TUWEN_HEAD;
                    }
                    str = str4;
                    str2 = AddFriendActivityConfig.TYPE_CONCERN_HEAD;
                } else if (this.a.o.isFromFrs()) {
                    if (this.a.o.getThreadType() == 69) {
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
                AlaInfoData alaInfo = this.a.o.getAuthor().getAlaInfo();
                if (!o36.a(this.a.p, this.a.o)) {
                    if (alaInfo != null && alaInfo.isLegalYYLiveData()) {
                        TbPageContext tbPageContext = this.a.getTbPageContext();
                        YyExtData yyExtData = alaInfo.mYyExtData;
                        YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + alaInfo.roomId, alaInfo.mYyExtData.streamInfo, str);
                        HeadPendantClickableView headPendantClickableView = this.a;
                        headPendantClickableView.u(headPendantClickableView.o.getTid(), String.valueOf(this.a.o.getFid()), String.valueOf(alaInfo.roomId), String.valueOf(alaInfo.live_id), alaInfo.mYyExtData.mSid);
                    } else if (this.a.o.getPeiwanInfo() != null && this.a.o.getPeiwanInfo().scheme != null) {
                        UrlManager.getInstance().dealOneLink(this.a.o.getPeiwanInfo().scheme);
                        HeadPendantClickableView headPendantClickableView2 = this.a;
                        headPendantClickableView2.t(headPendantClickableView2.o);
                    } else {
                        PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.p, this.a.o.getAuthor().getUserId(), this.a.o.getAuthor().getName_show(), this.a.o.getForum_name(), str2, this.a.o.getTid(), this.a.o.getNid());
                        if (this.a.o.getThreadVideoInfo() != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        personInfoActivityConfig.setIsVideoThread(z);
                        if (this.a.o.getResource() == 1) {
                            personInfoActivityConfig.setVideoPersonFrom("home");
                        } else if (this.a.o.getResource() == 2) {
                            personInfoActivityConfig.setVideoPersonFrom("frs");
                        } else if (this.a.o.getResource() == 5) {
                            personInfoActivityConfig.setVideoPersonFrom("topic_detail");
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    }
                }
                if (this.a.q != null) {
                    this.a.q.onClick(view2);
                }
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
        this.r = 0;
        a aVar = new a(this);
        this.s = aVar;
        this.p = context;
        setOnClickListener(aVar);
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
        this.r = 0;
        a aVar = new a(this);
        this.s = aVar;
        this.p = context;
        setOnClickListener(aVar);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void setData(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, metaData) == null) {
            setData(metaData, false);
        }
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

    public void setData(MetaData metaData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, metaData, z) != null) || metaData == null) {
            return;
        }
        ThreadData threadData = new ThreadData();
        threadData.setAuthor(metaData);
        setData(threadData, z);
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            setData(threadData, false);
        }
    }

    public void setData(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048581, this, threadData, z) == null) && threadData != null && threadData.getAuthor() != null) {
            this.o = threadData;
            MetaData author = threadData.getAuthor();
            setContentDescription(author.getName_show() + this.p.getString(R.string.somebodys_portrait));
            getHeadView().setUserId(author.getUserId());
            getHeadView().setUserName(author.getUserName());
            getHeadView().setUrl(author.getAvater());
            if (author.isDefaultAvatar) {
                getHeadView().startLoad(String.valueOf((int) R.drawable.pic_mask_pass_head), 24, false);
            } else if (!StringUtils.isNull(author.getAvater()) && author.getAvater().startsWith("http")) {
                getHeadView().startLoad(author.getAvater(), 10, false);
            } else if (z) {
                getHeadView().startLoad(author.getAvater(), 25, false);
            } else {
                getHeadView().startLoad(author.getAvater(), 28, false);
            }
            i(author);
        }
    }

    public void t(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) && threadData != null && threadData.getPeiwanInfo() != null) {
            String str2 = null;
            int i = this.r;
            if (i == 1) {
                str2 = CommonStatisticKey.KEY_HOME_PEI_WAN_CARD_CLICK;
            } else if (i == 2) {
                str2 = CommonStatisticKey.KEY_FRS_HOT_PEI_WAN_CARD_CLICK;
            }
            if (StringUtils.isNotNull(str2)) {
                PeiwanInfo peiwanInfo = threadData.getPeiwanInfo();
                StatisticItem statisticItem = new StatisticItem(str2);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("obj_locate", String.valueOf(threadData.floorPosition));
                statisticItem.addParam(TiebaStatic.Params.OBJ_TO, peiwanInfo.room_id.longValue());
                if (threadData.isFromNet) {
                    str = "1";
                } else {
                    str = "0";
                }
                statisticItem.addParam("obj_param1", str);
                if (this.r == 2) {
                    statisticItem.addParam("fid", threadData.getFid());
                    statisticItem.addParam("fname", threadData.getForum_name());
                }
                statisticItem.eventStat();
            }
        }
    }

    public final void u(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, str3, str4, str5) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tid", str);
                jSONObject.put("fid", str2);
                if (TextUtils.equals("0", str3)) {
                    str3 = null;
                }
                jSONObject.put("roomId", str3);
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
}
