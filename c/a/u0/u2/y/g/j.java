package c.a.u0.u2.y.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.u0.u2.l;
import c.a.u0.u2.u.f.r0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
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
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class j extends c.a.d.o.e.a<PostData, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment m;
    public c.a.u0.u2.r.f n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public r0 s;
    public boolean t;
    public boolean u;
    public boolean v;
    public String w;
    public View.OnClickListener x;
    public CustomMessageListener y;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f24089e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24089e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == c.a.u0.u2.i.video_tab_vip_icon_video_info_item) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        r4 = view.getTag() != null ? (String) view.getTag() : null;
                        if (r4 != null) {
                            UrlManager.getInstance().dealOneLink(this.f24089e.m.getPageContext(), new String[]{r4});
                        }
                        TiebaStatic.eventStat(this.f24089e.m.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == c.a.u0.u2.i.video_tab_user_yinji_video_info_item) {
                    if (view.getTag(c.a.u0.u2.i.tag_user_id) instanceof String) {
                        c.a.t0.m.a.q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(l.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view.getTag(c.a.u0.u2.i.tag_user_id)) + "&opacity=0", true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view.getId() == c.a.u0.u2.i.video_tab_head_view_video_info_item) {
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
                            YYLiveUtil.jumpYYLiveRoom(this.f24089e.m.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f24089e.f2447e, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == c.a.u0.u2.i.video_tab_user_name_video_info_item) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str = view.getTag(c.a.u0.u2.i.tag_user_id) instanceof String ? (String) view.getTag(c.a.u0.u2.i.tag_user_id) : null;
                    String str2 = view.getTag(c.a.u0.u2.i.tag_user_name) instanceof String ? (String) view.getTag(c.a.u0.u2.i.tag_user_name) : null;
                    if (this.f24089e.n != null && this.f24089e.n.l() != null) {
                        r4 = this.f24089e.n.l().getName();
                    }
                    String str3 = r4;
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str);
                    if (this.f24089e.n != null) {
                        statisticItem3.param("fid", this.f24089e.n.m());
                        statisticItem3.param("tid", this.f24089e.n.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f24089e.f2447e, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == c.a.u0.u2.i.video_tab_concern_video_info_item && (this.f24089e.m instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.f24089e.n.m());
                    statisticItem4.param("tid", this.f24089e.n.Q());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.f24089e.n.j().G());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.f24089e.m).getFromVideoPageType());
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
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
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.k == null || ((VideoTabPbFloatUserInfoViewHolder) this.a.k).mVideoTitle == null) {
                return;
            }
            ((VideoTabPbFloatUserInfoViewHolder) this.a.k).mVideoTitle.setTextSize(TbConfig.getContentSize());
            this.a.H();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdUniqueId};
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
        this.w = null;
        this.x = new a(this);
        b bVar = new b(this, 2004018);
        this.y = bVar;
        this.m = baseFragment;
        baseFragment.registerListener(bVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        n0(i2, view, viewGroup, postData, videoTabPbFloatUserInfoViewHolder);
        return view;
    }

    public final void g0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        c.a.u0.u2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (fVar = this.n) == null || fVar.O() == null || this.n.O().J() == null || postData == null) {
            return;
        }
        u0(videoTabPbFloatUserInfoViewHolder, this.n.O().J(), postData);
        y0(videoTabPbFloatUserInfoViewHolder, this.n.O().J());
        w0(videoTabPbFloatUserInfoViewHolder, this.n.O().J());
        r0(videoTabPbFloatUserInfoViewHolder.mUserIdentity, postData);
        t0(videoTabPbFloatUserInfoViewHolder, postData);
        x0(videoTabPbFloatUserInfoViewHolder, this.n.O().J());
        q0(videoTabPbFloatUserInfoViewHolder, this.n.O().J());
        v0(videoTabPbFloatUserInfoViewHolder, this.n.O().J(), postData);
    }

    public final void h0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        c.a.u0.u2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (fVar = this.n) == null || fVar.O() == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.setVideoTitle(this.n.O().Z0(), this.n.O().getTitle(), this.n.O(), k0(postData), this.n.s0());
        videoTabPbFloatUserInfoViewHolder.setVideoAbstract(this.f2447e, postData);
    }

    public final void i0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, videoTabPbFloatUserInfoViewHolder, postData) == null) {
            videoTabPbFloatUserInfoViewHolder.setUegInfo(8, null);
            c.a.u0.u2.r.f fVar = this.n;
            if (fVar == null || fVar.O() == null || postData == null) {
                return;
            }
            if (postData.U) {
                videoTabPbFloatUserInfoViewHolder.setUegInfo(0, postData.G());
            }
            BaseFragment baseFragment = this.m;
            if (baseFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) baseFragment).updateUegMask(postData.U);
            }
        }
    }

    public final int j0(c.a.u0.u2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().p2()) {
                return (ListUtils.isEmpty(fVar.p()) && (fVar.h() == null || StringUtils.isNull(fVar.h().getForumName()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final boolean k0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.q0) >= 2 : invokeL.booleanValue;
    }

    public void l0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, videoTabPbFloatUserInfoViewHolder) == null) || videoTabPbFloatUserInfoViewHolder == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.onChangeForumLevelSkinType(this.o);
        videoTabPbFloatUserInfoViewHolder.onChangeUserNameSkinType(this.t || this.u || this.v);
        videoTabPbFloatUserInfoViewHolder.onChangeThreadStamp(this.p, this.r, this.q);
        videoTabPbFloatUserInfoViewHolder.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: m0 */
    public VideoTabPbFloatUserInfoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f2447e).inflate(c.a.u0.u2.j.pb_new_video_tab_user_info_item, viewGroup, false);
            Context context = this.f2447e;
            BaseFragment baseFragment = this.m;
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, baseFragment instanceof AbsVideoPbFragment ? (AbsVideoPbFragment) baseFragment : null);
            videoTabPbFloatUserInfoViewHolder.setOnClickListener(this.x);
            l0(videoTabPbFloatUserInfoViewHolder);
            this.k = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View n0(int i2, View view, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, videoTabPbFloatUserInfoViewHolder})) == null) {
            c.a.u0.u2.r.f fVar = this.n;
            if (fVar != null && fVar.O() != null && postData != null) {
                c.a.u0.u2.w.a.d(this.m.getUniqueId(), this.n, postData, 1, 1);
                s0(videoTabPbFloatUserInfoViewHolder);
                g0(videoTabPbFloatUserInfoViewHolder, postData);
                h0(videoTabPbFloatUserInfoViewHolder, postData);
                i0(videoTabPbFloatUserInfoViewHolder, postData);
                l0(videoTabPbFloatUserInfoViewHolder);
                videoTabPbFloatUserInfoViewHolder.mYoungsterTip.setVisibility(c.a.t0.g1.b.c.d() ? 0 : 8);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void o0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postData) == null) || postData == null || postData.t() == null) {
            return;
        }
        String userId = postData.t().getUserId();
        c.a.u0.u2.r.f fVar = this.n;
        String m = fVar != null ? fVar.m() : "";
        c.a.u0.u2.r.f fVar2 = this.n;
        String n = fVar2 != null ? fVar2.n() : "";
        int A = postData.A();
        String G = postData.G();
        StatisticItem statisticItem = new StatisticItem("c13714");
        statisticItem.param("fid", m);
        statisticItem.param("fname", n);
        statisticItem.param("obj_param1", userId);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", G);
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

    public void p0(c.a.u0.u2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.w = str;
        }
    }

    public final void q0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) {
            if (this.n != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoTabPbFloatUserInfoViewHolder.mFansCount;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(l.fans_default_name));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.mFansCount.getLayoutParams();
                layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setText(authInfo);
                videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.mFansCount.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setVisibility(8);
        }
    }

    public final void r0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, textView, postData) == null) || textView == null || postData == null) {
            return;
        }
        textView.setTag(postData);
        if (postData.t() != null && StringHelper.equals(this.w, postData.t().getUserId())) {
            textView.setVisibility(0);
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(textView);
            d2.v(c.a.u0.u2.f.CAM_X0101);
            d2.n(l.J_X04);
            d2.f(c.a.u0.u2.f.CAM_X0302);
            textView.setText(l.host_name);
            return;
        }
        textView.setVisibility(8);
    }

    public final void s0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        c.a.u0.u2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, videoTabPbFloatUserInfoViewHolder) == null) || (fVar = this.n) == null) {
            return;
        }
        this.p = fVar.f23186j;
        if (fVar.O() != null) {
            this.r = this.n.O().s0() == 1;
            this.q = this.n.O().t0() == 1;
        }
        videoTabPbFloatUserInfoViewHolder.onChangeThreadStamp(this.p, this.r, this.q);
    }

    public final void t0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        c.a.u0.u2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (fVar = this.n) == null || fVar.O() == null) {
            return;
        }
        this.o = 0;
        if (!this.n.O().p2()) {
            if (postData != null && postData.t() != null) {
                this.o = postData.t().getLevel_id();
            }
            if (!this.n.g0()) {
                videoTabPbFloatUserInfoViewHolder.mUserForumLevel.setVisibility(0);
                videoTabPbFloatUserInfoViewHolder.onChangeForumLevelSkinType(this.o);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.mUserForumLevel.setVisibility(8);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.mUserForumLevel.setVisibility(8);
    }

    public final void u0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.n == null || metaData == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setUserId(metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setUserName(metaData.getUserName());
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setTid(postData.G());
        c.a.u0.u2.r.f fVar = this.n;
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setFid(fVar != null ? fVar.m() : "");
        c.a.u0.u2.r.f fVar2 = this.n;
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setFName(fVar2 != null ? fVar2.n() : "");
        videoTabPbFloatUserInfoViewHolder.mHeadView.showHeadPendantAndBigV(metaData, 4);
        videoTabPbFloatUserInfoViewHolder.mHeadView.startLoadWithPendantAndBigV(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoTabPbFloatUserInfoViewHolder.handleUserAlaLiveState(true);
            videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setLiveStatus(1);
            videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setAlaInfo(postData.t().getAlaInfo());
            o0(postData);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.handleUserAlaLiveState(false);
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setLiveStatus(0);
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setAlaInfo(null);
    }

    public final void v0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.n == null || postData == null || postData.t() == null) {
            return;
        }
        c.a.u0.u2.r.f fVar = this.n;
        String Q = fVar != null ? fVar.Q() : "";
        int j0 = j0(this.n);
        int i2 = 4;
        if (this.n.O() != null && this.n.O().J2()) {
            i2 = 8;
        }
        if (this.s == null) {
            r0 r0Var = new r0(this.m.getPageContext(), videoTabPbFloatUserInfoViewHolder.mConcernBtn, i2);
            this.s = r0Var;
            r0Var.l(this.m.getUniqueId());
        }
        postData.t().setIsLike(postData.t().hadConcerned());
        this.s.n(postData.t());
        this.s.x(Q);
        this.s.v(this.n.O());
        r0 r0Var2 = this.s;
        r0Var2.t = true;
        r0Var2.w(j0);
        this.s.k(true);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setText("");
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setText("");
        }
        if (this.n.f23185i) {
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setText("");
        }
        if (postData.t().getIsLike()) {
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setText("");
        }
    }

    public final void w0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.mUserName.setText(metaData.getName_show());
        videoTabPbFloatUserInfoViewHolder.mUserName.setTag(c.a.u0.u2.i.tag_user_id, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.mUserName.setTag(c.a.u0.u2.i.tag_user_name, metaData.getName_show());
        this.u = metaData.isBigV();
        this.v = metaData.isNewGod();
    }

    public final void x0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || this.n == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoTabPbFloatUserInfoViewHolder.mUserYinJi.setTag(c.a.u0.u2.i.tag_user_id, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.mUserYinJi.loadIcon(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.u2.g.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.u2.g.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.u2.g.tbds10));
    }

    public final void y0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.t = true;
            videoTabPbFloatUserInfoViewHolder.mVipIcon.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.mUserName.getLayoutParams();
            layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.t = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.mUserName.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.mVipIcon.loadIcon(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.u2.g.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.u2.g.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.u2.g.tbds10), true);
    }
}
