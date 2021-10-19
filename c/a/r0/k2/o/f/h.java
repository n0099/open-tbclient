package c.a.r0.k2.o.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.d1.o0;
import c.a.q0.s.q.d2;
import c.a.r0.k2.k.e.p0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbVideoInfoViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes3.dex */
public class h extends c.a.e.l.e.a<PostData, VideoPbVideoInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment m;
    @Nullable
    public c.a.r0.k2.o.b n;
    public c.a.r0.k2.h.e o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public p0 t;
    public boolean u;
    public boolean v;
    public boolean w;
    public String x;
    public View.OnClickListener y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20813e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20813e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (this.f20813e.k != null) {
                        int curVideoTitleStatus = ((VideoPbVideoInfoViewHolder) this.f20813e.k).getCurVideoTitleStatus();
                        if (curVideoTitleStatus == 1) {
                            ((VideoPbVideoInfoViewHolder) this.f20813e.k).changeVideoTitleStatus(2);
                        } else if (curVideoTitleStatus == 2) {
                            ((VideoPbVideoInfoViewHolder) this.f20813e.k).changeVideoTitleStatus(1);
                        }
                        if (this.f20813e.o.f0() || curVideoTitleStatus == 1) {
                            ((VideoPbVideoInfoViewHolder) this.f20813e.k).mPublishLocation.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) this.f20813e.k).mPublishDistance.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) this.f20813e.k).mPublishLocation.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) this.f20813e.k).mPublishDistance.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                        return;
                    }
                    return;
                }
                if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        r7 = view.getTag() != null ? (String) view.getTag() : null;
                        if (r7 != null) {
                            UrlManager.getInstance().dealOneLink(this.f20813e.m.getPageContext(), new String[]{r7});
                        }
                        TiebaStatic.eventStat(this.f20813e.m.getPageContext().getPageActivity(), "consume_2", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        c.a.q0.m.a.p(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view.getId() == R.id.head_view_video_info_item) {
                    HeadImageView headView = ((HeadPendantClickableView) view).getHeadView();
                    String userId = headView.getUserId();
                    String userName = headView.getUserName();
                    String fid = headView.getFid();
                    String tid = headView.getTid();
                    String fName = headView.getFName();
                    int floor = headView.getFloor();
                    AlaInfoData alaInfo = headView.getAlaInfo();
                    int liveStatus = headView.getLiveStatus();
                    if (alaInfo != null && (liveStatus == 1 || alaInfo.live_status == 1)) {
                        if (alaInfo.isLegalYYLiveData()) {
                            YYLiveUtil.jumpYYLiveRoom(this.f20813e.m.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        }
                        StatisticItem statisticItem = new StatisticItem("c13715");
                        statisticItem.param("fid", fid);
                        statisticItem.param("fname", fName);
                        AlaUserInfoData alaUserInfoData = alaInfo.user_info;
                        statisticItem.param("obj_param1", alaUserInfoData != null ? alaUserInfoData.user_id : 0L);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("tid", tid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, floor);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(alaInfo));
                        if (alaInfo.mYyExtData != null) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                            TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    StatisticItem statisticItem2 = new StatisticItem("c13267");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", fid);
                    statisticItem2.param("tid", tid);
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f20813e.f2958e, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (this.f20813e.o != null && this.f20813e.o.m() != null) {
                        r7 = this.f20813e.o.m().getName();
                    }
                    String str3 = r7;
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str);
                    if (this.f20813e.o != null) {
                        statisticItem3.param("fid", this.f20813e.o.n());
                        statisticItem3.param("tid", this.f20813e.o.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f20813e.f2958e, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f20814e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20815f;

        public b(h hVar, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, videoPbVideoInfoViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20814e = videoPbVideoInfoViewHolder;
            this.f20815f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                int measuredWidth = this.f20814e.mVideoInfoItemLayout.getMeasuredWidth();
                int measuredWidth2 = this.f20814e.mPlayCount.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f20814e.mPublishTime.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i2 = this.f20815f;
                if (measuredWidth3 < i2) {
                    this.f20814e.mPublishDistance.setVisibility(8);
                    this.f20814e.mPublishLocation.setVisibility(8);
                } else if (measuredWidth3 - i2 < dimenPixelSize3) {
                    this.f20814e.mPublishLocation.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f20816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20817f;

        public c(h hVar, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, videoPbVideoInfoViewHolder, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20816e = videoPbVideoInfoViewHolder;
            this.f20817f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                int measuredWidth = this.f20816e.mVideoInfoItemCollapsibleLayout.getMeasuredWidth();
                int measuredWidth2 = this.f20816e.mCollapsiblePlayCount.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f20816e.mCollapsiblePublishTime.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i2 = this.f20817f;
                if (measuredWidth3 < i2) {
                    this.f20816e.mCollapsiblePublishDistance.setVisibility(8);
                    this.f20816e.mCollapsiblePublishLocation.setVisibility(8);
                } else if (measuredWidth3 - i2 < dimenPixelSize3) {
                    this.f20816e.mCollapsiblePublishLocation.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f20818a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20818a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f20818a.k == null || ((VideoPbVideoInfoViewHolder) this.f20818a.k).mVideoTitle == null) {
                return;
            }
            ((VideoPbVideoInfoViewHolder) this.f20818a.k).mVideoTitle.setTextSize(TbConfig.getContentSize());
            this.f20818a.P();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(BaseFragment baseFragment, @Nullable c.a.r0.k2.o.b bVar, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = null;
        this.y = new a(this);
        d dVar = new d(this, 2004018);
        this.z = dVar;
        this.m = baseFragment;
        this.n = bVar;
        baseFragment.registerListener(dVar);
    }

    public final int A0() {
        InterceptResult invokeV;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.r0.k2.o.b bVar = this.n;
            if (bVar == null || (pbModel = bVar.getPbModel()) == null) {
                return 0;
            }
            return pbModel.O0();
        }
        return invokeV.intValue;
    }

    public final int B0(c.a.r0.k2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return 0;
            }
            if (eVar.O().l2()) {
                return (ListUtils.isEmpty(eVar.q()) && (eVar.h() == null || StringUtils.isNull(eVar.h().getForumName()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.n0) >= 2 : invokeL.booleanValue;
    }

    public final boolean D0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d2Var)) == null) ? (d2Var == null || d2Var.I0() == null || d2Var.I0().getOptions() == null || d2Var.I0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void E0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, videoPbVideoInfoViewHolder) == null) || videoPbVideoInfoViewHolder == null) {
            return;
        }
        videoPbVideoInfoViewHolder.onChangeForumLevelSkinType(this.p);
        videoPbVideoInfoViewHolder.onChangeUserNameSkinType(this.u || this.v || this.w);
        videoPbVideoInfoViewHolder.onChangeThreadStamp(this.q, this.s, this.r);
        videoPbVideoInfoViewHolder.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: F0 */
    public VideoPbVideoInfoViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f2958e).inflate(R.layout.pb_list_video_info_item, viewGroup, false);
            Context context = this.f2958e;
            BaseFragment baseFragment = this.m;
            VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(context, inflate, baseFragment instanceof AbsVideoPbFragment ? (AbsVideoPbFragment) baseFragment : null);
            videoPbVideoInfoViewHolder.setOnClickListener(this.y);
            E0(videoPbVideoInfoViewHolder);
            this.k = videoPbVideoInfoViewHolder;
            return videoPbVideoInfoViewHolder;
        }
        return (VideoPbVideoInfoViewHolder) invokeL.objValue;
    }

    public View G0(int i2, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, videoPbVideoInfoViewHolder})) == null) {
            c.a.r0.k2.h.e eVar = this.o;
            if (eVar != null && eVar.O() != null && postData != null) {
                c.a.r0.k2.m.a.d(this.m.getUniqueId(), this.o, postData, 1, 1);
                L0(videoPbVideoInfoViewHolder);
                x0(videoPbVideoInfoViewHolder, postData);
                y0(videoPbVideoInfoViewHolder, postData);
                z0(videoPbVideoInfoViewHolder, postData);
                w0(videoPbVideoInfoViewHolder, this.o, A0());
                E0(videoPbVideoInfoViewHolder);
                videoPbVideoInfoViewHolder.mYoungsterTip.setVisibility(c.a.q0.g1.b.c.d() ? 0 : 8);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void H0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postData) == null) || postData == null || postData.t() == null) {
            return;
        }
        String userId = postData.t().getUserId();
        c.a.r0.k2.h.e eVar = this.o;
        String n = eVar != null ? eVar.n() : "";
        c.a.r0.k2.h.e eVar2 = this.o;
        String o = eVar2 != null ? eVar2.o() : "";
        int A = postData.A();
        String E = postData.E();
        StatisticItem statisticItem = new StatisticItem("c13714");
        statisticItem.param("fid", n);
        statisticItem.param("fname", o);
        statisticItem.param("obj_param1", userId);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", E);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, A);
        if (postData.t().getAlaInfo() != null) {
            AlaInfoData alaInfo = postData.t().getAlaInfo();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
            if (alaInfo.mYyExtData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public void I0(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public final void J0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, videoPbVideoInfoViewHolder, metaData) == null) {
            if (this.o != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoPbVideoInfoViewHolder.mFansCount;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mFansCount.getLayoutParams();
                layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoPbVideoInfoViewHolder.mBjhAuthorAuth.setText(authInfo);
                videoPbVideoInfoViewHolder.mBjhAuthorAuth.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mFansCount.getLayoutParams();
            layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.mBjhAuthorAuth.setVisibility(8);
        }
    }

    public final void K0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            c.a.r0.k2.h.e eVar = this.o;
            if (eVar != null && eVar.f0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.t() != null) {
                MetaData t = postData.t();
                String str = this.x;
                if (str != null && !str.equals("0") && this.x.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
                    d2.v(R.color.CAM_X0302);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.k(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && postData.Z()) {
                    c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    c.a.q0.s.u.c d5 = c.a.q0.s.u.c.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    c.a.q0.s.u.c d6 = c.a.q0.s.u.c.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    c.a.q0.s.u.c d7 = c.a.q0.s.u.c.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void L0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        c.a.r0.k2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, videoPbVideoInfoViewHolder) == null) || (eVar = this.o) == null) {
            return;
        }
        this.q = eVar.f19812j;
        if (eVar.O() != null) {
            this.s = this.o.O().q0() == 1;
            this.r = this.o.O().r0() == 1;
        }
        videoPbVideoInfoViewHolder.onChangeThreadStamp(this.q, this.s, this.r);
    }

    public final void M0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        c.a.r0.k2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, videoPbVideoInfoViewHolder, postData) == null) || (eVar = this.o) == null || eVar.O() == null) {
            return;
        }
        this.p = 0;
        if (!this.o.O().l2()) {
            if (postData != null && postData.t() != null) {
                this.p = postData.t().getLevel_id();
            }
            if (!this.o.f0()) {
                videoPbVideoInfoViewHolder.mUserForumLevel.setVisibility(0);
                videoPbVideoInfoViewHolder.onChangeForumLevelSkinType(this.p);
                return;
            }
            videoPbVideoInfoViewHolder.mUserForumLevel.setVisibility(8);
            return;
        }
        videoPbVideoInfoViewHolder.mUserForumLevel.setVisibility(8);
    }

    public final void N0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.o == null || metaData == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setUserId(metaData.getUserId());
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setUserName(metaData.getUserName());
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setTid(postData.E());
        c.a.r0.k2.h.e eVar = this.o;
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setFid(eVar != null ? eVar.n() : "");
        c.a.r0.k2.h.e eVar2 = this.o;
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setFName(eVar2 != null ? eVar2.o() : "");
        videoPbVideoInfoViewHolder.mHeadView.showHeadPendantAndBigV(metaData, 4);
        videoPbVideoInfoViewHolder.mHeadView.startLoadWithPendantAndBigV(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoPbVideoInfoViewHolder.handleUserAlaLiveState(true);
            videoPbVideoInfoViewHolder.mHeadView.getHeadView().setLiveStatus(1);
            videoPbVideoInfoViewHolder.mHeadView.getHeadView().setAlaInfo(postData.t().getAlaInfo());
            H0(postData);
            return;
        }
        videoPbVideoInfoViewHolder.handleUserAlaLiveState(false);
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setLiveStatus(0);
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setAlaInfo(null);
    }

    public final void O0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.o == null || postData == null || postData.t() == null) {
            return;
        }
        c.a.r0.k2.h.e eVar = this.o;
        String Q = eVar != null ? eVar.Q() : "";
        int B0 = B0(this.o);
        int i2 = 4;
        if (this.o.O() != null && this.o.O().F2()) {
            i2 = 8;
        }
        if (this.t == null) {
            p0 p0Var = new p0(this.m.getPageContext(), videoPbVideoInfoViewHolder.mConcernBtn, i2);
            this.t = p0Var;
            p0Var.l(this.m.getUniqueId());
        }
        postData.t().setIsLike(postData.t().hadConcerned());
        this.t.n(postData.t());
        this.t.w(Q);
        this.t.u(this.o.O());
        p0 p0Var2 = this.t;
        p0Var2.s = true;
        p0Var2.v(B0);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoPbVideoInfoViewHolder.mConcernBtn.setVisibility(8);
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoPbVideoInfoViewHolder.mConcernBtn.setVisibility(8);
        }
        if (this.o.f19811i) {
            videoPbVideoInfoViewHolder.mConcernBtn.setVisibility(8);
        }
    }

    public final void P0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.mUserName.setText(metaData.getName_show());
        videoPbVideoInfoViewHolder.mUserName.setTag(R.id.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.mUserName.setTag(R.id.tag_user_name, metaData.getName_show());
        this.v = metaData.isBigV();
        this.w = metaData.isNewGod();
    }

    public final void Q0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, videoPbVideoInfoViewHolder, metaData) == null) || this.o == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoPbVideoInfoViewHolder.mUserYinJi.setTag(R.id.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.mUserYinJi.loadIcon(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void R0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.u = true;
            videoPbVideoInfoViewHolder.mVipIcon.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mUserName.getLayoutParams();
            layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.u = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mUserName.getLayoutParams();
            layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoPbVideoInfoViewHolder.mVipIcon.loadIcon(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        G0(i2, view, viewGroup, postData, videoPbVideoInfoViewHolder);
        return view;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.x = str;
        }
    }

    public final void w0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, c.a.r0.k2.h.e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048597, this, videoPbVideoInfoViewHolder, eVar, i2) == null) || eVar == null) {
            return;
        }
        videoPbVideoInfoViewHolder.setNoticeBarData(eVar, i2);
    }

    public final void x0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        c.a.r0.k2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, videoPbVideoInfoViewHolder, postData) == null) || (eVar = this.o) == null || eVar.O() == null || this.o.O().J() == null || postData == null) {
            return;
        }
        N0(videoPbVideoInfoViewHolder, this.o.O().J(), postData);
        R0(videoPbVideoInfoViewHolder, this.o.O().J());
        P0(videoPbVideoInfoViewHolder, this.o.O().J());
        K0(videoPbVideoInfoViewHolder.mUserIdentity, this.o.j());
        M0(videoPbVideoInfoViewHolder, postData);
        Q0(videoPbVideoInfoViewHolder, this.o.O().J());
        J0(videoPbVideoInfoViewHolder, this.o.O().J());
        O0(videoPbVideoInfoViewHolder, this.o.O().J(), postData);
    }

    public final void y0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        c.a.r0.k2.h.e eVar;
        String formatTime;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, videoPbVideoInfoViewHolder, postData) == null) || (eVar = this.o) == null || eVar.O() == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.setVideoTitle(this.f2958e, this.o.O().W0(), this.o.O().getTitle(), this.o.O(), C0(postData), this.o.r0());
        if (this.o.O().q1() != null) {
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.o.O().q1().play_count.intValue());
            TextView textView = videoPbVideoInfoViewHolder.mPlayCount;
            textView.setText(numberUniformFormatExtra + this.f2958e.getString(R.string.play));
            TextView textView2 = videoPbVideoInfoViewHolder.mCollapsiblePlayCount;
            textView2.setText(numberUniformFormatExtra + this.f2958e.getString(R.string.play));
        }
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.S()), "yyyy"))) {
            formatTime = StringHelper.getFormatTimeShort(postData.S());
        } else {
            formatTime = StringHelper.getFormatTime(postData.S());
        }
        TextView textView3 = videoPbVideoInfoViewHolder.mPublishTime;
        textView3.setText(formatTime + this.f2958e.getString(R.string.send_post));
        TextView textView4 = videoPbVideoInfoViewHolder.mCollapsiblePublishTime;
        textView4.setText(formatTime + this.f2958e.getString(R.string.send_post));
        c.a.q0.u.f I = postData.I();
        if (I != null && !TextUtils.isEmpty(I.b()) && !TextUtils.isEmpty(I.b().trim())) {
            videoPbVideoInfoViewHolder.mPublishLocation.setText(I.b());
            videoPbVideoInfoViewHolder.mCollapsiblePublishLocation.setText(I.b());
            videoPbVideoInfoViewHolder.mPublishLocation.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.mPublishLocation.setVisibility(8);
        }
        if (I != null && !TextUtils.isEmpty(I.a())) {
            videoPbVideoInfoViewHolder.mPublishDistance.setText(I.a());
            videoPbVideoInfoViewHolder.mCollapsiblePublishDistance.setText(I.a());
            videoPbVideoInfoViewHolder.mPublishDistance.setVisibility(0);
            int measureText = (int) videoPbVideoInfoViewHolder.mPublishDistance.getPaint().measureText(I.a(), 0, I.a().length());
            videoPbVideoInfoViewHolder.mVideoInfoItemLayout.post(new b(this, videoPbVideoInfoViewHolder, measureText));
            videoPbVideoInfoViewHolder.mVideoInfoItemCollapsibleLayout.post(new c(this, videoPbVideoInfoViewHolder, measureText));
        } else {
            videoPbVideoInfoViewHolder.mPublishDistance.setVisibility(8);
        }
        PollData I0 = this.o.O().I0();
        if (I0 != null && I0.getOptions() != null && I0.getOptions().size() > 0) {
            videoPbVideoInfoViewHolder.mPublishVoteView.setPageContext(this.m.getPageContext());
            videoPbVideoInfoViewHolder.mPublishVoteView.setDataForPb(I0, this.o.Q(), this.o.n());
            videoPbVideoInfoViewHolder.mPublishVoteView.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.mPublishVoteView.setVisibility(8);
        }
        LinearLayout linearLayout = videoPbVideoInfoViewHolder.mLinkContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        c.a.r0.k2.h.e eVar2 = this.o;
        if (eVar2 != null && eVar2.O() != null && !D0(this.o.O()) && (!ListUtils.isEmpty(this.o.O().A0()) || !ListUtils.isEmpty(this.o.O().c0()))) {
            o0 o0Var = new o0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.f2958e);
            c.a.r0.k2.h.e eVar3 = this.o;
            pbLinkGoodsRootView.bindData(eVar3, o0Var.a(eVar3.O().A0(), this.o.O().c0()), this.o.o(), (AbsVideoPbFragment) this.m, o0Var.b());
            videoPbVideoInfoViewHolder.mLinkContainer.addView(pbLinkGoodsRootView);
            videoPbVideoInfoViewHolder.mLinkContainer.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.mLinkContainer.setVisibility(8);
        }
        videoPbVideoInfoViewHolder.setVideoAbstract(this.f2958e, postData);
    }

    public final void z0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, videoPbVideoInfoViewHolder, postData) == null) {
            videoPbVideoInfoViewHolder.setUegInfo(8, null);
            c.a.r0.k2.h.e eVar = this.o;
            if (eVar == null || eVar.O() == null || postData == null) {
                return;
            }
            if (postData.S) {
                videoPbVideoInfoViewHolder.setUegInfo(0, postData.E());
            }
            BaseFragment baseFragment = this.m;
            if (baseFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) baseFragment).updateUegMask(postData.S);
            }
        }
    }
}
