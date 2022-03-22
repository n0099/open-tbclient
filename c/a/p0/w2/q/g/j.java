package c.a.p0.w2.q.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.w2.m.f.x0;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class j extends c.a.d.o.e.a<PostData, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment i;
    public c.a.p0.w2.i.f j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public x0 o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public View.OnClickListener t;
    public CustomMessageListener u;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f092390) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str = view.getTag() != null ? (String) view.getTag() : null;
                        if (str != null) {
                            UrlManager.getInstance().dealOneLink(this.a.i.getPageContext(), new String[]{str});
                        }
                        TiebaStatic.eventStat(this.a.i.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f09238b) {
                    if (view.getTag(R.id.obfuscated_res_0x7f091eb7) instanceof String) {
                        c.a.o0.l.a.q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14a5), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view.getTag(R.id.obfuscated_res_0x7f091eb7)) + "&opacity=0", true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f09237e) {
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
                            YYLiveUtil.jumpYYLiveRoom(this.a.i.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f09238a) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str2 = view.getTag(R.id.obfuscated_res_0x7f091eb7) instanceof String ? (String) view.getTag(R.id.obfuscated_res_0x7f091eb7) : null;
                    String str3 = view.getTag(R.id.obfuscated_res_0x7f091ebf) instanceof String ? (String) view.getTag(R.id.obfuscated_res_0x7f091ebf) : null;
                    String name = (this.a.j == null || this.a.j.l() == null) ? null : this.a.j.l().getName();
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str2);
                    if (this.a.j != null) {
                        statisticItem3.param("fid", this.a.j.m());
                        statisticItem3.param("tid", this.a.j.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str2 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.a, str2, str3, name, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f09237a && (this.a.i instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.a.j.m());
                    statisticItem4.param("tid", this.a.j.Q());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.a.j.j().G());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.a.i).V2());
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f2573g == null || ((VideoTabPbFloatUserInfoViewHolder) this.a.f2573g).o == null) {
                return;
            }
            ((VideoTabPbFloatUserInfoViewHolder) this.a.f2573g).o.setTextSize(TbConfig.getContentSize());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = null;
        this.t = new a(this);
        b bVar = new b(this, 2004018);
        this.u = bVar;
        this.i = baseFragment;
        baseFragment.registerListener(bVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        n0(i, view, viewGroup, postData, videoTabPbFloatUserInfoViewHolder);
        return view;
    }

    public final void g0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (fVar = this.j) == null || fVar.O() == null || this.j.O().getAuthor() == null || postData == null) {
            return;
        }
        u0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor(), postData);
        y0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor());
        w0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor());
        r0(videoTabPbFloatUserInfoViewHolder.f35237h, postData);
        t0(videoTabPbFloatUserInfoViewHolder, postData);
        x0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor());
        q0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor());
        v0(videoTabPbFloatUserInfoViewHolder, this.j.O().getAuthor(), postData);
    }

    public final void h0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (fVar = this.j) == null || fVar.O() == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.o(this.j.O().getRichTitle(), this.j.O().getTitle(), this.j.O(), k0(postData), this.j.s0());
        videoTabPbFloatUserInfoViewHolder.n(this.a, postData);
    }

    public final void i0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, videoTabPbFloatUserInfoViewHolder, postData) == null) {
            videoTabPbFloatUserInfoViewHolder.m(8, null);
            c.a.p0.w2.i.f fVar = this.j;
            if (fVar == null || fVar.O() == null || postData == null) {
                return;
            }
            if (postData.Q) {
                videoTabPbFloatUserInfoViewHolder.m(0, postData.G());
            }
            BaseFragment baseFragment = this.i;
            if (baseFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) baseFragment).d5(postData.Q);
            }
        }
    }

    public final int j0(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().isMutiForumThread()) {
                return (ListUtils.isEmpty(fVar.p()) && (fVar.h() == null || StringUtils.isNull(fVar.h().a()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final boolean k0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.m0) >= 2 : invokeL.booleanValue;
    }

    public void l0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, videoTabPbFloatUserInfoViewHolder) == null) || videoTabPbFloatUserInfoViewHolder == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.h(this.k);
        videoTabPbFloatUserInfoViewHolder.k(this.p || this.q || this.r);
        videoTabPbFloatUserInfoViewHolder.j(this.l, this.n, this.m);
        videoTabPbFloatUserInfoViewHolder.i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: m0 */
    public VideoTabPbFloatUserInfoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0693, viewGroup, false);
            Context context = this.a;
            BaseFragment baseFragment = this.i;
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, baseFragment instanceof AbsVideoPbFragment ? (AbsVideoPbFragment) baseFragment : null);
            videoTabPbFloatUserInfoViewHolder.l(this.t);
            l0(videoTabPbFloatUserInfoViewHolder);
            this.f2573g = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View n0(int i, View view, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view, viewGroup, postData, videoTabPbFloatUserInfoViewHolder})) == null) {
            c.a.p0.w2.i.f fVar = this.j;
            if (fVar != null && fVar.O() != null && postData != null) {
                c.a.p0.w2.o.a.d(this.i.getUniqueId(), this.j, postData, 1, 1);
                s0(videoTabPbFloatUserInfoViewHolder);
                g0(videoTabPbFloatUserInfoViewHolder, postData);
                h0(videoTabPbFloatUserInfoViewHolder, postData);
                i0(videoTabPbFloatUserInfoViewHolder, postData);
                l0(videoTabPbFloatUserInfoViewHolder);
                videoTabPbFloatUserInfoViewHolder.q.setVisibility(8);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void o0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        String userId = postData.s().getUserId();
        c.a.p0.w2.i.f fVar = this.j;
        String m = fVar != null ? fVar.m() : "";
        c.a.p0.w2.i.f fVar2 = this.j;
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
        if (postData.s().getAlaInfo() != null) {
            AlaInfoData alaInfo = postData.s().getAlaInfo();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
            if (alaInfo.mYyExtData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public void p0(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.j = fVar;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.s = str;
        }
    }

    public final void q0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) {
            if (this.j != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoTabPbFloatUserInfoViewHolder.l;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05e7));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.l.getLayoutParams();
                layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.k.setText(authInfo);
                videoTabPbFloatUserInfoViewHolder.k.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.l.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoTabPbFloatUserInfoViewHolder.k.setVisibility(8);
        }
    }

    public final void r0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, textView, postData) == null) || textView == null || postData == null) {
            return;
        }
        textView.setTag(postData);
        if (postData.s() != null && StringHelper.equals(this.s, postData.s().getUserId())) {
            textView.setVisibility(0);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(textView);
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0302);
            textView.setText(R.string.obfuscated_res_0x7f0f0855);
            return;
        }
        textView.setVisibility(8);
    }

    public final void s0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, videoTabPbFloatUserInfoViewHolder) == null) || (fVar = this.j) == null) {
            return;
        }
        this.l = fVar.j;
        if (fVar.O() != null) {
            this.n = this.j.O().getIs_good() == 1;
            this.m = this.j.O().getIs_top() == 1;
        }
        videoTabPbFloatUserInfoViewHolder.j(this.l, this.n, this.m);
    }

    public final void t0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (fVar = this.j) == null || fVar.O() == null) {
            return;
        }
        this.k = 0;
        if (!this.j.O().isMutiForumThread()) {
            if (postData != null && postData.s() != null) {
                this.k = postData.s().getLevel_id();
            }
            if (!this.j.g0()) {
                videoTabPbFloatUserInfoViewHolder.i.setVisibility(0);
                videoTabPbFloatUserInfoViewHolder.h(this.k);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.i.setVisibility(8);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.i.setVisibility(8);
    }

    public final void u0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048593, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.j == null || metaData == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.f35233d.getHeadView().setUserId(metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.f35233d.getHeadView().setUserName(metaData.getUserName());
        videoTabPbFloatUserInfoViewHolder.f35233d.getHeadView().setTid(postData.G());
        c.a.p0.w2.i.f fVar = this.j;
        videoTabPbFloatUserInfoViewHolder.f35233d.getHeadView().setFid(fVar != null ? fVar.m() : "");
        c.a.p0.w2.i.f fVar2 = this.j;
        videoTabPbFloatUserInfoViewHolder.f35233d.getHeadView().setFName(fVar2 != null ? fVar2.n() : "");
        videoTabPbFloatUserInfoViewHolder.f35233d.j(metaData, 4);
        videoTabPbFloatUserInfoViewHolder.f35233d.n(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoTabPbFloatUserInfoViewHolder.e(true);
            videoTabPbFloatUserInfoViewHolder.f35233d.getHeadView().setLiveStatus(1);
            videoTabPbFloatUserInfoViewHolder.f35233d.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            o0(postData);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.e(false);
        videoTabPbFloatUserInfoViewHolder.f35233d.getHeadView().setLiveStatus(0);
        videoTabPbFloatUserInfoViewHolder.f35233d.getHeadView().setAlaInfo(null);
    }

    public final void v0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.j == null || postData == null || postData.s() == null) {
            return;
        }
        c.a.p0.w2.i.f fVar = this.j;
        String Q = fVar != null ? fVar.Q() : "";
        int j0 = j0(this.j);
        int i = 4;
        if (this.j.O() != null && this.j.O().isVideoWorksInfo()) {
            i = 8;
        }
        if (this.o == null) {
            x0 x0Var = new x0(this.i.getPageContext(), videoTabPbFloatUserInfoViewHolder.m, i);
            this.o = x0Var;
            x0Var.l(this.i.getUniqueId());
        }
        postData.s().setIsLike(postData.s().hadConcerned());
        this.o.n(postData.s());
        this.o.x(Q);
        this.o.v(this.j.O());
        x0 x0Var2 = this.o;
        x0Var2.p = true;
        x0Var2.w(j0);
        this.o.k(true);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.m.setText("");
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.m.setText("");
        }
        if (this.j.i) {
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.m.setText("");
        }
        if (postData.s().getIsLike()) {
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.m.setText("");
        }
    }

    public final void w0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.f35236g.setText(metaData.getName_show());
        videoTabPbFloatUserInfoViewHolder.f35236g.setTag(R.id.obfuscated_res_0x7f091eb7, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.f35236g.setTag(R.id.obfuscated_res_0x7f091ebf, metaData.getName_show());
        this.q = metaData.isBigV();
        this.r = metaData.isNewGod();
    }

    public final void x0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || this.j == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoTabPbFloatUserInfoViewHolder.j.setTag(R.id.obfuscated_res_0x7f091eb7, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.j.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void y0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.p = true;
            videoTabPbFloatUserInfoViewHolder.f35235f.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.f35236g.getLayoutParams();
            layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.p = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.f35236g.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.f35235f.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }
}
