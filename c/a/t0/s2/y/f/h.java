package c.a.t0.s2.y.f;

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
import c.a.d.f.p.n;
import c.a.s0.s.q.d2;
import c.a.t0.s2.l;
import c.a.t0.s2.u.f.q0;
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
/* loaded from: classes8.dex */
public class h extends c.a.d.n.e.a<PostData, VideoPbVideoInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment m;
    @Nullable
    public c.a.t0.s2.y.b n;
    public c.a.t0.s2.r.f o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public q0 t;
    public boolean u;
    public boolean v;
    public boolean w;
    public String x;
    public View.OnClickListener y;
    public CustomMessageListener z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f23974e;

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
            this.f23974e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == c.a.t0.s2.i.btn_wrapper_title_expand_video_info_item || view.getId() == c.a.t0.s2.i.video_title_area_video_info_item) {
                    if (this.f23974e.f3305k != null) {
                        int curVideoTitleStatus = ((VideoPbVideoInfoViewHolder) this.f23974e.f3305k).getCurVideoTitleStatus();
                        if (curVideoTitleStatus == 1) {
                            ((VideoPbVideoInfoViewHolder) this.f23974e.f3305k).changeVideoTitleStatus(2);
                        } else if (curVideoTitleStatus == 2) {
                            ((VideoPbVideoInfoViewHolder) this.f23974e.f3305k).changeVideoTitleStatus(1);
                        }
                        if (this.f23974e.o.g0() || curVideoTitleStatus == 1) {
                            ((VideoPbVideoInfoViewHolder) this.f23974e.f3305k).mPublishLocation.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) this.f23974e.f3305k).mPublishDistance.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) this.f23974e.f3305k).mPublishLocation.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) this.f23974e.f3305k).mPublishDistance.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                        return;
                    }
                    return;
                }
                if (view.getId() == c.a.t0.s2.i.vip_icon_video_info_item) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        r7 = view.getTag() != null ? (String) view.getTag() : null;
                        if (r7 != null) {
                            UrlManager.getInstance().dealOneLink(this.f23974e.m.getPageContext(), new String[]{r7});
                        }
                        TiebaStatic.eventStat(this.f23974e.m.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == c.a.t0.s2.i.user_yinji_video_info_item) {
                    if (view.getTag(c.a.t0.s2.i.tag_user_id) instanceof String) {
                        c.a.s0.m.a.q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(l.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view.getTag(c.a.t0.s2.i.tag_user_id)), true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view.getId() == c.a.t0.s2.i.head_view_video_info_item) {
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
                            YYLiveUtil.jumpYYLiveRoom(this.f23974e.m.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f23974e.f3299e, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == c.a.t0.s2.i.user_name_video_info_item) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str = view.getTag(c.a.t0.s2.i.tag_user_id) instanceof String ? (String) view.getTag(c.a.t0.s2.i.tag_user_id) : null;
                    String str2 = view.getTag(c.a.t0.s2.i.tag_user_name) instanceof String ? (String) view.getTag(c.a.t0.s2.i.tag_user_name) : null;
                    if (this.f23974e.o != null && this.f23974e.o.l() != null) {
                        r7 = this.f23974e.o.l().getName();
                    }
                    String str3 = r7;
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str);
                    if (this.f23974e.o != null) {
                        statisticItem3.param("fid", this.f23974e.o.m());
                        statisticItem3.param("tid", this.f23974e.o.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f23974e.f3299e, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f23975e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f23976f;

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
            this.f23975e = videoPbVideoInfoViewHolder;
            this.f23976f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.t0.s2.g.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(c.a.t0.s2.g.tbds29);
                int measuredWidth = this.f23975e.mVideoInfoItemLayout.getMeasuredWidth();
                int measuredWidth2 = this.f23975e.mPlayCount.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(c.a.t0.s2.g.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f23975e.mPublishTime.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i2 = this.f23976f;
                if (measuredWidth3 < i2) {
                    this.f23975e.mPublishDistance.setVisibility(8);
                    this.f23975e.mPublishLocation.setVisibility(8);
                } else if (measuredWidth3 - i2 < dimenPixelSize3) {
                    this.f23975e.mPublishLocation.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f23977e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f23978f;

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
            this.f23977e = videoPbVideoInfoViewHolder;
            this.f23978f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.t0.s2.g.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(c.a.t0.s2.g.tbds29);
                int measuredWidth = this.f23977e.mVideoInfoItemCollapsibleLayout.getMeasuredWidth();
                int measuredWidth2 = this.f23977e.mCollapsiblePlayCount.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(c.a.t0.s2.g.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.f23977e.mCollapsiblePublishTime.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i2 = this.f23978f;
                if (measuredWidth3 < i2) {
                    this.f23977e.mCollapsiblePublishDistance.setVisibility(8);
                    this.f23977e.mCollapsiblePublishLocation.setVisibility(8);
                } else if (measuredWidth3 - i2 < dimenPixelSize3) {
                    this.f23977e.mCollapsiblePublishLocation.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

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
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f3305k == null || ((VideoPbVideoInfoViewHolder) this.a.f3305k).mVideoTitle == null) {
                return;
            }
            ((VideoPbVideoInfoViewHolder) this.a.f3305k).mVideoTitle.setTextSize(TbConfig.getContentSize());
            this.a.H();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(BaseFragment baseFragment, @Nullable c.a.t0.s2.y.b bVar, BdUniqueId bdUniqueId) {
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

    public void A0(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public final void B0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoPbVideoInfoViewHolder, metaData) == null) {
            if (this.o != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoPbVideoInfoViewHolder.mFansCount;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(l.fans_default_name));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mFansCount.getLayoutParams();
                layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoPbVideoInfoViewHolder.mBjhAuthorAuth.setText(authInfo);
                videoPbVideoInfoViewHolder.mBjhAuthorAuth.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mFansCount.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.mBjhAuthorAuth.setVisibility(8);
        }
    }

    public final void C0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            c.a.t0.s2.r.f fVar = this.o;
            if (fVar != null && fVar.g0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.t() != null) {
                MetaData t = postData.t();
                String str = this.x;
                if (str != null && !str.equals("0") && this.x.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(l.host_name);
                    textView.setBackgroundColor(0);
                    c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(textView);
                    d2.v(c.a.t0.s2.f.CAM_X0302);
                    d2.n(l.J_X04);
                    d2.l(c.a.t0.s2.g.L_X01);
                    d2.k(c.a.t0.s2.f.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && postData.c0()) {
                    c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(textView);
                    d3.v(c.a.t0.s2.f.CAM_X0101);
                    d3.n(l.J_X04);
                    d3.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(l.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(textView);
                    d4.v(c.a.t0.s2.f.CAM_X0101);
                    d4.n(l.J_X04);
                    d4.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(l.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    c.a.s0.s.u.c d5 = c.a.s0.s.u.c.d(textView);
                    d5.v(c.a.t0.s2.f.CAM_X0101);
                    d5.n(l.J_X04);
                    d5.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(l.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    c.a.s0.s.u.c d6 = c.a.s0.s.u.c.d(textView);
                    d6.v(c.a.t0.s2.f.CAM_X0101);
                    d6.n(l.J_X04);
                    d6.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(l.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    c.a.s0.s.u.c d7 = c.a.s0.s.u.c.d(textView);
                    d7.v(c.a.t0.s2.f.CAM_X0101);
                    d7.n(l.J_X04);
                    d7.f(c.a.t0.s2.f.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(l.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void D0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoPbVideoInfoViewHolder) == null) || (fVar = this.o) == null) {
            return;
        }
        this.q = fVar.f23042j;
        if (fVar.O() != null) {
            this.s = this.o.O().r0() == 1;
            this.r = this.o.O().s0() == 1;
        }
        videoPbVideoInfoViewHolder.onChangeThreadStamp(this.q, this.s, this.r);
    }

    public final void E0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, videoPbVideoInfoViewHolder, postData) == null) || (fVar = this.o) == null || fVar.O() == null) {
            return;
        }
        this.p = 0;
        if (!this.o.O().o2()) {
            if (postData != null && postData.t() != null) {
                this.p = postData.t().getLevel_id();
            }
            if (!this.o.g0()) {
                videoPbVideoInfoViewHolder.mUserForumLevel.setVisibility(0);
                videoPbVideoInfoViewHolder.onChangeForumLevelSkinType(this.p);
                return;
            }
            videoPbVideoInfoViewHolder.mUserForumLevel.setVisibility(8);
            return;
        }
        videoPbVideoInfoViewHolder.mUserForumLevel.setVisibility(8);
    }

    public final void F0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.o == null || metaData == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setUserId(metaData.getUserId());
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setUserName(metaData.getUserName());
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setTid(postData.G());
        c.a.t0.s2.r.f fVar = this.o;
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setFid(fVar != null ? fVar.m() : "");
        c.a.t0.s2.r.f fVar2 = this.o;
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setFName(fVar2 != null ? fVar2.n() : "");
        videoPbVideoInfoViewHolder.mHeadView.showHeadPendantAndBigV(metaData, 4);
        videoPbVideoInfoViewHolder.mHeadView.startLoadWithPendantAndBigV(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoPbVideoInfoViewHolder.handleUserAlaLiveState(true);
            videoPbVideoInfoViewHolder.mHeadView.getHeadView().setLiveStatus(1);
            videoPbVideoInfoViewHolder.mHeadView.getHeadView().setAlaInfo(postData.t().getAlaInfo());
            z0(postData);
            return;
        }
        videoPbVideoInfoViewHolder.handleUserAlaLiveState(false);
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setLiveStatus(0);
        videoPbVideoInfoViewHolder.mHeadView.getHeadView().setAlaInfo(null);
    }

    public final void G0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, videoPbVideoInfoViewHolder, metaData, postData) == null) || this.o == null || postData == null || postData.t() == null) {
            return;
        }
        c.a.t0.s2.r.f fVar = this.o;
        String Q = fVar != null ? fVar.Q() : "";
        int t0 = t0(this.o);
        int i2 = 4;
        if (this.o.O() != null && this.o.O().I2()) {
            i2 = 8;
        }
        if (this.t == null) {
            q0 q0Var = new q0(this.m.getPageContext(), videoPbVideoInfoViewHolder.mConcernBtn, i2);
            this.t = q0Var;
            q0Var.l(this.m.getUniqueId());
        }
        postData.t().setIsLike(postData.t().hadConcerned());
        this.t.n(postData.t());
        this.t.x(Q);
        this.t.v(this.o.O());
        q0 q0Var2 = this.t;
        q0Var2.t = true;
        q0Var2.w(t0);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoPbVideoInfoViewHolder.mConcernBtn.setVisibility(8);
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoPbVideoInfoViewHolder.mConcernBtn.setVisibility(8);
        }
        if (this.o.f23041i) {
            videoPbVideoInfoViewHolder.mConcernBtn.setVisibility(8);
        }
    }

    public final void H0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.mUserName.setText(metaData.getName_show());
        videoPbVideoInfoViewHolder.mUserName.setTag(c.a.t0.s2.i.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.mUserName.setTag(c.a.t0.s2.i.tag_user_name, metaData.getName_show());
        this.v = metaData.isBigV();
        this.w = metaData.isNewGod();
    }

    public final void I0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoPbVideoInfoViewHolder, metaData) == null) || this.o == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoPbVideoInfoViewHolder.mUserYinJi.setTag(c.a.t0.s2.i.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.mUserYinJi.loadIcon(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.s2.g.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.s2.g.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.s2.g.tbds10));
    }

    public final void J0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, videoPbVideoInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.u = true;
            videoPbVideoInfoViewHolder.mVipIcon.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mUserName.getLayoutParams();
            layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.u = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mUserName.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoPbVideoInfoViewHolder.mVipIcon.loadIcon(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.s2.g.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.s2.g.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.s2.g.tbds10), true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        y0(i2, view, viewGroup, postData, videoPbVideoInfoViewHolder);
        return view;
    }

    public final void o0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, c.a.t0.s2.r.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048588, this, videoPbVideoInfoViewHolder, fVar, i2) == null) || fVar == null) {
            return;
        }
        videoPbVideoInfoViewHolder.setNoticeBarData(fVar, i2);
    }

    public final void p0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, videoPbVideoInfoViewHolder, postData) == null) || (fVar = this.o) == null || fVar.O() == null || this.o.O().J() == null || postData == null) {
            return;
        }
        F0(videoPbVideoInfoViewHolder, this.o.O().J(), postData);
        J0(videoPbVideoInfoViewHolder, this.o.O().J());
        H0(videoPbVideoInfoViewHolder, this.o.O().J());
        C0(videoPbVideoInfoViewHolder.mUserIdentity, this.o.j());
        E0(videoPbVideoInfoViewHolder, postData);
        I0(videoPbVideoInfoViewHolder, this.o.O().J());
        B0(videoPbVideoInfoViewHolder, this.o.O().J());
        G0(videoPbVideoInfoViewHolder, this.o.O().J(), postData);
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.x = str;
        }
    }

    public final void q0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        c.a.t0.s2.r.f fVar;
        String formatTime;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, videoPbVideoInfoViewHolder, postData) == null) || (fVar = this.o) == null || fVar.O() == null || postData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.setVideoTitle(this.o.O().Y0(), this.o.O().getTitle(), this.o.O(), u0(postData), this.o.s0());
        if (this.o.O().t1() != null) {
            String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.o.O().t1().play_count.intValue());
            TextView textView = videoPbVideoInfoViewHolder.mPlayCount;
            textView.setText(numberUniformFormatExtra + this.f3299e.getString(l.play));
            TextView textView2 = videoPbVideoInfoViewHolder.mCollapsiblePlayCount;
            textView2.setText(numberUniformFormatExtra + this.f3299e.getString(l.play));
        }
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.V()), "yyyy"))) {
            formatTime = StringHelper.getFormatTimeShort(postData.V());
        } else {
            formatTime = StringHelper.getFormatTime(postData.V());
        }
        TextView textView3 = videoPbVideoInfoViewHolder.mPublishTime;
        textView3.setText(formatTime + this.f3299e.getString(l.send_post));
        TextView textView4 = videoPbVideoInfoViewHolder.mCollapsiblePublishTime;
        textView4.setText(formatTime + this.f3299e.getString(l.send_post));
        c.a.s0.u.g K = postData.K();
        if (K != null && !TextUtils.isEmpty(K.b()) && !TextUtils.isEmpty(K.b().trim())) {
            videoPbVideoInfoViewHolder.mPublishLocation.setText(K.b());
            videoPbVideoInfoViewHolder.mCollapsiblePublishLocation.setText(K.b());
            videoPbVideoInfoViewHolder.mPublishLocation.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.mPublishLocation.setVisibility(8);
        }
        if (K != null && !TextUtils.isEmpty(K.a())) {
            videoPbVideoInfoViewHolder.mPublishDistance.setText(K.a());
            videoPbVideoInfoViewHolder.mCollapsiblePublishDistance.setText(K.a());
            videoPbVideoInfoViewHolder.mPublishDistance.setVisibility(0);
            int measureText = (int) videoPbVideoInfoViewHolder.mPublishDistance.getPaint().measureText(K.a(), 0, K.a().length());
            videoPbVideoInfoViewHolder.mVideoInfoItemLayout.post(new b(this, videoPbVideoInfoViewHolder, measureText));
            videoPbVideoInfoViewHolder.mVideoInfoItemCollapsibleLayout.post(new c(this, videoPbVideoInfoViewHolder, measureText));
        } else {
            videoPbVideoInfoViewHolder.mPublishDistance.setVisibility(8);
        }
        PollData J0 = this.o.O().J0();
        if (J0 != null && J0.getOptions() != null && J0.getOptions().size() > 0) {
            videoPbVideoInfoViewHolder.mPublishVoteView.setPageContext(this.m.getPageContext());
            videoPbVideoInfoViewHolder.mPublishVoteView.setDataForPb(J0, this.o.Q(), this.o.m());
            videoPbVideoInfoViewHolder.mPublishVoteView.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.mPublishVoteView.setVisibility(8);
        }
        LinearLayout linearLayout = videoPbVideoInfoViewHolder.mLinkContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        c.a.t0.s2.r.f fVar2 = this.o;
        if (fVar2 != null && fVar2.O() != null && !v0(this.o.O()) && (!ListUtils.isEmpty(this.o.O().B0()) || !ListUtils.isEmpty(this.o.O().d0()))) {
            c.a.s0.e1.q0 q0Var = new c.a.s0.e1.q0();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.f3299e);
            c.a.t0.s2.r.f fVar3 = this.o;
            pbLinkGoodsRootView.bindData(fVar3, q0Var.a(fVar3.O().B0(), this.o.O().d0()), this.o.n(), (AbsVideoPbFragment) this.m, q0Var.b());
            videoPbVideoInfoViewHolder.mLinkContainer.addView(pbLinkGoodsRootView);
            videoPbVideoInfoViewHolder.mLinkContainer.setVisibility(0);
        } else {
            videoPbVideoInfoViewHolder.mLinkContainer.setVisibility(8);
        }
        videoPbVideoInfoViewHolder.setVideoAbstract(this.f3299e, postData);
    }

    public final void r0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, videoPbVideoInfoViewHolder, postData) == null) {
            videoPbVideoInfoViewHolder.setUegInfo(8, null);
            c.a.t0.s2.r.f fVar = this.o;
            if (fVar == null || fVar.O() == null || postData == null) {
                return;
            }
            if (postData.U) {
                videoPbVideoInfoViewHolder.setUegInfo(0, postData.G());
            }
            BaseFragment baseFragment = this.m;
            if (baseFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) baseFragment).updateUegMask(postData.U);
            }
        }
    }

    public final int s0() {
        InterceptResult invokeV;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.t0.s2.y.b bVar = this.n;
            if (bVar == null || (pbModel = bVar.getPbModel()) == null) {
                return 0;
            }
            return pbModel.Q0();
        }
        return invokeV.intValue;
    }

    public final int t0(c.a.t0.s2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().o2()) {
                return (ListUtils.isEmpty(fVar.p()) && (fVar.h() == null || StringUtils.isNull(fVar.h().getForumName()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final boolean u0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.q0) >= 2 : invokeL.booleanValue;
    }

    public final boolean v0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, d2Var)) == null) ? (d2Var == null || d2Var.J0() == null || d2Var.J0().getOptions() == null || d2Var.J0().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void w0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, videoPbVideoInfoViewHolder) == null) || videoPbVideoInfoViewHolder == null) {
            return;
        }
        videoPbVideoInfoViewHolder.onChangeForumLevelSkinType(this.p);
        videoPbVideoInfoViewHolder.onChangeUserNameSkinType(this.u || this.v || this.w);
        videoPbVideoInfoViewHolder.onChangeThreadStamp(this.q, this.s, this.r);
        videoPbVideoInfoViewHolder.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: x0 */
    public VideoPbVideoInfoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f3299e).inflate(c.a.t0.s2.j.pb_list_video_info_item, viewGroup, false);
            Context context = this.f3299e;
            BaseFragment baseFragment = this.m;
            VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(context, inflate, baseFragment instanceof AbsVideoPbFragment ? (AbsVideoPbFragment) baseFragment : null);
            videoPbVideoInfoViewHolder.setOnClickListener(this.y);
            w0(videoPbVideoInfoViewHolder);
            this.f3305k = videoPbVideoInfoViewHolder;
            return videoPbVideoInfoViewHolder;
        }
        return (VideoPbVideoInfoViewHolder) invokeL.objValue;
    }

    public View y0(int i2, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, videoPbVideoInfoViewHolder})) == null) {
            c.a.t0.s2.r.f fVar = this.o;
            if (fVar != null && fVar.O() != null && postData != null) {
                c.a.t0.s2.w.a.d(this.m.getUniqueId(), this.o, postData, 1, 1);
                D0(videoPbVideoInfoViewHolder);
                p0(videoPbVideoInfoViewHolder, postData);
                q0(videoPbVideoInfoViewHolder, postData);
                r0(videoPbVideoInfoViewHolder, postData);
                o0(videoPbVideoInfoViewHolder, this.o, s0());
                w0(videoPbVideoInfoViewHolder);
                videoPbVideoInfoViewHolder.mYoungsterTip.setVisibility(c.a.s0.h1.b.c.d() ? 0 : 8);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, postData) == null) || postData == null || postData.t() == null) {
            return;
        }
        String userId = postData.t().getUserId();
        c.a.t0.s2.r.f fVar = this.o;
        String m = fVar != null ? fVar.m() : "";
        c.a.t0.s2.r.f fVar2 = this.o;
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
}
