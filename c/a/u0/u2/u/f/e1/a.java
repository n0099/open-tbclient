package c.a.u0.u2.u.f.e1;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import c.a.d.f.p.m;
import c.a.u0.u2.i;
import c.a.u0.u2.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String f23564f;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.u0.u2.u.a a;

    /* renamed from: b  reason: collision with root package name */
    public final View.OnClickListener f23565b;

    /* renamed from: c  reason: collision with root package name */
    public final View.OnClickListener f23566c;

    /* renamed from: d  reason: collision with root package name */
    public final View.OnClickListener f23567d;

    /* renamed from: e  reason: collision with root package name */
    public final TbRichTextView.x f23568e;

    /* renamed from: c.a.u0.u2.u.f.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1439a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23569e;

        public View$OnClickListenerC1439a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23569e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            AlaInfoData alaInfoData;
            String str4;
            String str5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = -1;
                if (view instanceof HeadImageView) {
                    HeadImageView headImageView = (HeadImageView) view;
                    String userId = headImageView.getUserId();
                    String userName = headImageView.getUserName();
                    String fid = headImageView.getFid();
                    String tid = headImageView.getTid();
                    String fName = headImageView.getFName();
                    int floor = headImageView.getFloor();
                    alaInfoData = headImageView.getAlaInfo();
                    int liveStatus = headImageView.getLiveStatus();
                    if (alaInfoData != null && (liveStatus == 1 || alaInfoData.live_status == 1)) {
                        StatisticItem statisticItem = new StatisticItem("c13715");
                        statisticItem.param("fid", fid);
                        statisticItem.param("fname", fName);
                        AlaUserInfoData alaUserInfoData = alaInfoData.user_info;
                        str5 = userId;
                        statisticItem.param("obj_param1", alaUserInfoData != null ? alaUserInfoData.user_id : 0L);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("tid", tid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, floor);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(alaInfoData));
                        if (alaInfoData.mYyExtData != null) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                            TiebaStaticHelper.addYYParam(statisticItem, alaInfoData.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                    } else {
                        str5 = userId;
                        if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            StatisticItem statisticItem2 = new StatisticItem("c13267");
                            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem2.param("fid", fid);
                            statisticItem2.param("tid", tid);
                            statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(statisticItem2);
                        }
                    }
                    i2 = liveStatus;
                    str3 = userName;
                    str4 = tid;
                    str2 = str5;
                } else {
                    if (view.getTag(i.tag_user_id) instanceof String) {
                        str = (String) view.getTag(i.tag_user_id);
                    } else {
                        str = view.getTag() instanceof String ? (String) view.getTag() : null;
                    }
                    String str6 = view.getTag(i.tag_user_name) instanceof String ? (String) view.getTag(i.tag_user_name) : null;
                    if ((view.getTag() instanceof SparseArray) && (((SparseArray) view.getTag()).get(i.tag_user_id) instanceof String)) {
                        str = (String) ((SparseArray) view.getTag()).get(i.tag_user_id);
                    }
                    str2 = str;
                    str3 = str6;
                    alaInfoData = null;
                    str4 = null;
                }
                if (view.getTag(i.tag_statistic_item) instanceof StatisticItem) {
                    TiebaStatic.log((StatisticItem) view.getTag(i.tag_statistic_item));
                }
                if (view.getTag(i.tag_nick_name_activity) != null && (view.getTag(i.tag_nick_name_activity) instanceof String)) {
                    String str7 = (String) view.getTag(i.tag_nick_name_activity);
                    if (!TextUtils.isEmpty(str7) && ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f23569e.a.getPageContext().getPageActivity(), null, str7, true)));
                        return;
                    }
                }
                String str8 = view.getTag(i.tag_virtual_user_url) instanceof String ? (String) view.getTag(i.tag_virtual_user_url) : null;
                if (str8 != null) {
                    if (!ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f23569e.a.getPageContext(), new String[]{str8});
                } else if (str2 != null) {
                    if (alaInfoData != null && (i2 == 1 || alaInfoData.live_status == 1)) {
                        if (alaInfoData.isLegalYYLiveData()) {
                            YYLiveUtil.jumpYYLiveRoom(this.f23569e.a.getPageContext(), alaInfoData);
                            TbPageContext pageContext = this.f23569e.a.getPageContext();
                            YyExtData yyExtData = alaInfoData.mYyExtData;
                            String str9 = yyExtData.mSid;
                            String str10 = yyExtData.mSsid;
                            String str11 = yyExtData.mTemplateId;
                            YYLiveUtil.jumpToYYLiveRoom(pageContext, str9, str10, str11, "" + alaInfoData.roomId, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f23569e.a.getPageContext().getPageActivity(), str2, str3, this.f23569e.a.getFromForumName(), AddFriendActivityConfig.TYPE_PB_HEAD, str4, null)));
                    }
                }
                if (this.f23569e.a instanceof PbCommentFloatActivity) {
                    StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem3.param("fid", ((PbCommentFloatActivity) this.f23569e.a).getPbModel().getForumId());
                    statisticItem3.param("tid", ((PbCommentFloatActivity) this.f23569e.a).getPbModel().h1());
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem3.param("post_id", ((PbCommentFloatActivity) this.f23569e.a).getPbModel().q0());
                    statisticItem3.param("obj_source", 1);
                    statisticItem3.param("obj_type", 6);
                    statisticItem3.param("obj_locate", ((PbCommentFloatActivity) this.f23569e.a).getFromVideoPageType());
                    TiebaStatic.log(statisticItem3);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag(i.tag_user_id) instanceof String)) {
                c.a.t0.m.a.q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(l.user_icon_web_view_title), a.f23564f + "?user_id=" + ((String) view.getTag(i.tag_user_id)) + "&opacity=0", true, true, true);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23570e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23570e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                String str = view.getTag() != null ? (String) view.getTag() : null;
                if (str != null) {
                    UrlManager.getInstance().dealOneLink(this.f23570e.a.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(this.f23570e.a.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements TbRichTextView.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, str2, str3, str4, str5, str6, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(this.a.a.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i2, i3)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1146307542, "Lc/a/u0/u2/u/f/e1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1146307542, "Lc/a/u0/u2/u/f/e1/a;");
                return;
            }
        }
        f23564f = TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    }

    public a(c.a.u0.u2.u.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23565b = new View$OnClickListenerC1439a(this);
        this.f23566c = new b(this);
        this.f23567d = new c(this);
        this.f23568e = new d(this);
        this.a = aVar;
    }
}
