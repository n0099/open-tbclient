package c.a.q0.i2.o.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.b1.q0;
import c.a.q0.i2.k.e.n0;
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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class j extends c.a.e.l.e.a<PostData, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment m;
    public c.a.q0.i2.h.e n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public n0 s;
    public boolean t;
    public boolean u;
    public boolean v;
    public String w;
    public View.OnClickListener x;
    public CustomMessageListener y;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f20063e;

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
            this.f20063e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.video_tab_vip_icon_video_info_item) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        r4 = view.getTag() != null ? (String) view.getTag() : null;
                        if (r4 != null) {
                            UrlManager.getInstance().dealOneLink(this.f20063e.m.getPageContext(), new String[]{r4});
                        }
                        TiebaStatic.eventStat(this.f20063e.m.getPageContext().getPageActivity(), "consume_2", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.video_tab_user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        c.a.p0.m.a.p(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view.getId() == R.id.video_tab_head_view_video_info_item) {
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
                            YYLiveUtil.jumpYYLiveRoom(this.f20063e.m.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f20063e.f2966e, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.video_tab_user_name_video_info_item) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (this.f20063e.n != null && this.f20063e.n.m() != null) {
                        r4 = this.f20063e.n.m().getName();
                    }
                    String str3 = r4;
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str);
                    if (this.f20063e.n != null) {
                        statisticItem3.param("fid", this.f20063e.n.n());
                        statisticItem3.param("tid", this.f20063e.n.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f20063e.f2966e, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.video_tab_concern_video_info_item && (this.f20063e.m instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.f20063e.n.n());
                    statisticItem4.param("tid", this.f20063e.n.Q());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.f20063e.n.j().E());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.f20063e.m).getFromVideoPageType());
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f20064a;

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
            this.f20064a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f20064a.k == null || ((VideoTabPbFloatUserInfoViewHolder) this.f20064a.k).mVideoTitle == null) {
                return;
            }
            ((VideoTabPbFloatUserInfoViewHolder) this.f20064a.k).mVideoTitle.setTextSize(TbConfig.getContentSize());
            this.f20064a.P();
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

    public final void A0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        c.a.q0.i2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, videoTabPbFloatUserInfoViewHolder) == null) || (eVar = this.n) == null) {
            return;
        }
        this.p = eVar.f19071j;
        if (eVar.O() != null) {
            this.r = this.n.O().o0() == 1;
            this.q = this.n.O().p0() == 1;
        }
        videoTabPbFloatUserInfoViewHolder.onChangeThreadStamp(this.p, this.r, this.q);
    }

    public final void B0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        c.a.q0.i2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (eVar = this.n) == null || eVar.O() == null) {
            return;
        }
        this.o = 0;
        if (!this.n.O().h2()) {
            if (postData != null && postData.t() != null) {
                this.o = postData.t().getLevel_id();
            }
            if (!this.n.f0()) {
                videoTabPbFloatUserInfoViewHolder.mUserForumLevel.setVisibility(0);
                videoTabPbFloatUserInfoViewHolder.onChangeForumLevelSkinType(this.o);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.mUserForumLevel.setVisibility(8);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.mUserForumLevel.setVisibility(8);
    }

    public final void C0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.n == null || metaData == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setUserId(metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setUserName(metaData.getUserName());
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setTid(postData.E());
        c.a.q0.i2.h.e eVar = this.n;
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setFid(eVar != null ? eVar.n() : "");
        c.a.q0.i2.h.e eVar2 = this.n;
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setFName(eVar2 != null ? eVar2.o() : "");
        videoTabPbFloatUserInfoViewHolder.mHeadView.showHeadPendantAndBigV(metaData, 4);
        videoTabPbFloatUserInfoViewHolder.mHeadView.startLoadWithPendantAndBigV(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoTabPbFloatUserInfoViewHolder.handleUserAlaLiveState(true);
            videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setLiveStatus(1);
            videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setAlaInfo(postData.t().getAlaInfo());
            w0(postData);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.handleUserAlaLiveState(false);
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setLiveStatus(0);
        videoTabPbFloatUserInfoViewHolder.mHeadView.getHeadView().setAlaInfo(null);
    }

    public final void D0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.n == null || postData == null || postData.t() == null) {
            return;
        }
        c.a.q0.i2.h.e eVar = this.n;
        String Q = eVar != null ? eVar.Q() : "";
        int r0 = r0(this.n);
        int i2 = 4;
        if (this.n.O() != null && this.n.O().B2()) {
            i2 = 8;
        }
        if (this.s == null) {
            n0 n0Var = new n0(this.m.getPageContext(), videoTabPbFloatUserInfoViewHolder.mConcernBtn, i2);
            this.s = n0Var;
            n0Var.l(this.m.getUniqueId());
        }
        postData.t().setIsLike(postData.t().hadConcerned());
        this.s.n(postData.t());
        this.s.w(Q);
        this.s.u(this.n.O());
        n0 n0Var2 = this.s;
        n0Var2.s = true;
        n0Var2.v(r0);
        this.s.k(true);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setText("");
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setText("");
        }
        if (this.n.f19070i) {
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setText("");
        }
        if (postData.t().getIsLike()) {
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.mConcernBtn.setText("");
        }
    }

    public final void E0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.mUserName.setText(metaData.getName_show());
        videoTabPbFloatUserInfoViewHolder.mUserName.setTag(R.id.tag_user_id, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.mUserName.setTag(R.id.tag_user_name, metaData.getName_show());
        this.u = metaData.isBigV();
        this.v = metaData.isNewGod();
    }

    public final void F0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || this.n == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoTabPbFloatUserInfoViewHolder.mUserYinJi.setTag(R.id.tag_user_id, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.mUserYinJi.loadIcon(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void G0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.t = true;
            videoTabPbFloatUserInfoViewHolder.mVipIcon.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.mUserName.getLayoutParams();
            layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.t = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.mUserName.getLayoutParams();
            layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.mVipIcon.loadIcon(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        v0(i2, view, viewGroup, postData, videoTabPbFloatUserInfoViewHolder);
        return view;
    }

    public final void o0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        c.a.q0.i2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (eVar = this.n) == null || eVar.O() == null || this.n.O().J() == null || postData == null) {
            return;
        }
        C0(videoTabPbFloatUserInfoViewHolder, this.n.O().J(), postData);
        G0(videoTabPbFloatUserInfoViewHolder, this.n.O().J());
        E0(videoTabPbFloatUserInfoViewHolder, this.n.O().J());
        z0(videoTabPbFloatUserInfoViewHolder.mUserIdentity, this.n.j());
        B0(videoTabPbFloatUserInfoViewHolder, postData);
        F0(videoTabPbFloatUserInfoViewHolder, this.n.O().J());
        y0(videoTabPbFloatUserInfoViewHolder, this.n.O().J());
        D0(videoTabPbFloatUserInfoViewHolder, this.n.O().J(), postData);
    }

    public final void p0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        c.a.q0.i2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (eVar = this.n) == null || eVar.O() == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.setVideoTitle(this.f2966e, this.n.O().U0(), this.n.O().getTitle(), this.n.O(), s0(postData), this.n.q0());
        videoTabPbFloatUserInfoViewHolder.setVideoAbstract(this.f2966e, postData);
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.w = str;
        }
    }

    public final void q0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, videoTabPbFloatUserInfoViewHolder, postData) == null) {
            videoTabPbFloatUserInfoViewHolder.setUegInfo(8, null);
            c.a.q0.i2.h.e eVar = this.n;
            if (eVar == null || eVar.O() == null || postData == null) {
                return;
            }
            if (postData.S) {
                videoTabPbFloatUserInfoViewHolder.setUegInfo(0, postData.E());
            }
            BaseFragment baseFragment = this.m;
            if (baseFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) baseFragment).updateUegMask(postData.S);
            }
        }
    }

    public final int r0(c.a.q0.i2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return 0;
            }
            if (eVar.O().h2()) {
                return (ListUtils.isEmpty(eVar.q()) && (eVar.h() == null || StringUtils.isNull(eVar.h().getForumName()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final boolean s0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.n0) >= 2 : invokeL.booleanValue;
    }

    public void t0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, videoTabPbFloatUserInfoViewHolder) == null) || videoTabPbFloatUserInfoViewHolder == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.onChangeForumLevelSkinType(this.o);
        videoTabPbFloatUserInfoViewHolder.onChangeUserNameSkinType(this.t || this.u || this.v);
        videoTabPbFloatUserInfoViewHolder.onChangeThreadStamp(this.p, this.r, this.q);
        videoTabPbFloatUserInfoViewHolder.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: u0 */
    public VideoTabPbFloatUserInfoViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f2966e).inflate(R.layout.pb_new_video_tab_user_info_item, viewGroup, false);
            Context context = this.f2966e;
            BaseFragment baseFragment = this.m;
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, baseFragment instanceof AbsVideoPbFragment ? (AbsVideoPbFragment) baseFragment : null);
            videoTabPbFloatUserInfoViewHolder.setOnClickListener(this.x);
            t0(videoTabPbFloatUserInfoViewHolder);
            this.k = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View v0(int i2, View view, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, videoTabPbFloatUserInfoViewHolder})) == null) {
            c.a.q0.i2.h.e eVar = this.n;
            if (eVar != null && eVar.O() != null && postData != null) {
                c.a.q0.i2.m.a.d(this.m.getUniqueId(), this.n, postData, 1, 1);
                A0(videoTabPbFloatUserInfoViewHolder);
                o0(videoTabPbFloatUserInfoViewHolder, postData);
                p0(videoTabPbFloatUserInfoViewHolder, postData);
                q0(videoTabPbFloatUserInfoViewHolder, postData);
                t0(videoTabPbFloatUserInfoViewHolder);
                videoTabPbFloatUserInfoViewHolder.mYoungsterTip.setVisibility(c.a.p0.e1.b.e.d() ? 0 : 8);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void w0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, postData) == null) || postData == null || postData.t() == null) {
            return;
        }
        String userId = postData.t().getUserId();
        c.a.q0.i2.h.e eVar = this.n;
        String n = eVar != null ? eVar.n() : "";
        c.a.q0.i2.h.e eVar2 = this.n;
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

    public void x0(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public final void y0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) {
            if (this.n != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoTabPbFloatUserInfoViewHolder.mFansCount;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
            }
            if (metaData != null && metaData.isNewGod()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.mFansCount.getLayoutParams();
                layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setText(metaData.getNewGodData().getFieldName() + q0.d(metaData.getNewGodData().isVideoGod()));
                videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setVisibility(0);
            } else if (metaData != null && metaData.showBazhuGrade()) {
                videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setText(StringHelper.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, "..."));
                videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setVisibility(0);
            } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !k.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.mFansCount.getLayoutParams();
                layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setText(metaData.getBaijiahaoInfo().auth_desc);
                videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setVisibility(0);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.mFansCount.getLayoutParams();
                layoutParams3.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.mBjhAuthorAuth.setVisibility(8);
            }
        }
    }

    public final void z0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            c.a.q0.i2.h.e eVar = this.n;
            if (eVar != null && eVar.f0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.t() != null) {
                MetaData t = postData.t();
                String str = this.w;
                if (str != null && !"0".equals(str) && this.w.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(textView);
                    d2.u(R.color.CAM_X0302);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.k(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && postData.X()) {
                    c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(textView);
                    d3.u(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    c.a.p0.s.u.c d4 = c.a.p0.s.u.c.d(textView);
                    d4.u(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    c.a.p0.s.u.c d5 = c.a.p0.s.u.c.d(textView);
                    d5.u(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    c.a.p0.s.u.c d6 = c.a.p0.s.u.c.d(textView);
                    d6.u(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    c.a.p0.s.u.c d7 = c.a.p0.s.u.c.d(textView);
                    d7.u(R.color.CAM_X0101);
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
}
