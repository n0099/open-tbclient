package b.a.r0.k2.u.f.a1;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import b.a.q0.t.c.k0;
import b.a.r0.b0.m;
import b.a.r0.k2.u.f.a1.h;
import b.a.r0.k2.u.f.p0;
import b.a.r0.k2.u.f.q0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public int C;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f19026a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.k2.s.c f19027b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f19028c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f19029d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.f0.g f19030e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f19031f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19032g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.k2.u.f.g f19033h;

    /* renamed from: i  reason: collision with root package name */
    public ColumnLayout f19034i;
    public ThreadSkinView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public HeadPendantView n;
    public TBLottieAnimationView o;
    public UserIconBox p;
    public UserIconBox q;
    public FrameLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public ClickableHeaderImageView u;
    public PbFirstFloorUserLikeButton v;
    public p0 w;
    public c x;
    public TextView y;
    public TextView z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19035e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f19036f;

        public a(h hVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19036f = hVar;
            this.f19035e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.f19036f.t.getMeasuredWidth();
                int measuredWidth2 = this.f19036f.y.getMeasuredWidth();
                int measuredWidth3 = this.f19036f.B.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(b.a.r0.k2.g.tbds120);
                int i2 = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i3 = this.f19035e;
                if (i2 < i3) {
                    this.f19036f.A.setVisibility(8);
                    this.f19036f.z.setVisibility(8);
                } else if (i2 - i3 < dimenPixelSize) {
                    this.f19036f.z.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f19037e;

        public b(h hVar) {
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
            this.f19037e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19037e.o.playAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TextView f19038a;

        /* renamed from: b  reason: collision with root package name */
        public final TBSpecificationBtn f19039b;

        /* renamed from: c  reason: collision with root package name */
        public String f19040c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f19041d;

        public c(@NonNull h hVar, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19041d = hVar;
            this.f19038a = textView;
            this.f19039b = tBSpecificationBtn;
            c();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f19040c = str;
            }
        }

        @NonNull
        public final k0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                return tiebaPlusConfigData == null ? k0.f13806c : tiebaPlusConfigData;
            }
            return (k0) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
                bVar.r(b.a.r0.k2.f.CAM_X0302);
                this.f19039b.setConfig(bVar);
                this.f19039b.setOnClickListener(new View.OnClickListener() { // from class: b.a.r0.k2.u.f.a1.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            h.c.this.d(view);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view) {
            if (!b.a.e.e.p.j.A()) {
                b.a.e.e.p.l.L(this.f19041d.f19026a.getContext(), b.a.r0.k2.l.neterror);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f19041d.f19026a.getPageContext(), new String[]{b().d(this.f19040c)});
            k0.a(4);
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                if (b().f()) {
                    this.f19039b.changeSkinType(i2);
                } else {
                    SkinManager.setViewTextColor(this.f19038a, b.a.r0.k2.f.CAM_X0109);
                }
            }
        }

        public void f(@Nullable CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
                if (b().f()) {
                    this.f19039b.setText(charSequence.toString());
                } else {
                    this.f19038a.setText(charSequence);
                }
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                if (b().f()) {
                    this.f19039b.setVisibility(i2);
                    this.f19038a.setVisibility(8);
                    return;
                }
                this.f19039b.setVisibility(8);
                this.f19038a.setVisibility(i2);
            }
        }
    }

    public h(PbFragment pbFragment, b.a.r0.k2.s.c cVar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19028c = null;
        this.f19029d = null;
        this.f19031f = null;
        this.f19034i = null;
        this.k = null;
        this.l = null;
        this.r = null;
        this.u = null;
        this.v = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.f19026a = pbFragment;
        this.f19027b = cVar;
        this.f19028c = onClickListener;
        p();
    }

    public final void A(b.a.r0.k2.r.f fVar) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || (tBLottieAnimationView = this.o) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() != 0 && fVar != null && fVar.O() != null && fVar.O().J() != null) {
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", fVar.m());
            statisticItem.param("fname", fVar.n());
            statisticItem.param("obj_param1", fVar.O().J().getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", fVar.Q());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (fVar.O().J().getAlaInfo() != null) {
                AlaInfoData alaInfo = fVar.O().J().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
        this.o.setVisibility(0);
        this.o.setSpeed(0.8f);
        this.o.loop(true);
        this.o.post(new b(this));
    }

    public void B(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData, z) == null) {
            if (this.f19026a.isSimpleForum()) {
                this.C = 0;
                if (postData != null && postData.t() != null) {
                    this.C = postData.t().getLevel_id();
                }
                if (this.C > 0 && !z) {
                    this.m.setVisibility(0);
                    SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(this.C));
                    return;
                }
                this.m.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void C(b.a.r0.k2.r.f fVar, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, fVar, postData, z) == null) || fVar == null || postData == null) {
            return;
        }
        if (3 != fVar.g()) {
            this.v.setVisibility(0);
        }
        if (z) {
            this.v.setVisibility(8);
            if (fVar != null && fVar.O() != null && fVar.O().L() != null && fVar.O().L().oriUgcType == 3) {
                this.x.g(8);
            } else {
                this.x.g(0);
            }
            this.x.a(fVar.Q());
            this.x.f(String.format(TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.person_view_num), StringHelper.numberUniformFormatExtra(fVar.P())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.t().hadConcerned()) {
            this.x.g(8);
        } else {
            this.v.setVisibility(8);
            this.x.g(8);
        }
        if (fVar.f18765i || 3 == fVar.g()) {
            this.v.setVisibility(8);
        }
    }

    public void h(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f19031f);
    }

    public void i(BdTypeListView bdTypeListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, bdTypeListView, i2) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f19031f, i2);
    }

    public void j(b.a.r0.k2.r.f fVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (fVar != null && fVar.j) {
                this.f19032g.setImageResource(b.a.r0.k2.h.pic_frs_headlines_n);
                this.f19032g.setVisibility(0);
            } else if (z && z2) {
                this.f19032g.setImageResource(b.a.r0.k2.h.pic_pb_stick_refined_n);
                this.f19032g.setVisibility(0);
            } else if (z) {
                this.f19032g.setImageResource(b.a.r0.k2.h.pic_pb_refined_n);
                this.f19032g.setVisibility(0);
            } else if (z2) {
                this.f19032g.setImageResource(b.a.r0.k2.h.pic_pb_stick_n);
                this.f19032g.setVisibility(0);
            } else {
                this.f19032g.setVisibility(8);
            }
        }
    }

    public void k() {
        b.a.r0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f19030e) == null) {
            return;
        }
        gVar.I();
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19033h.e() : (TextView) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19031f : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str));
            return m.h(this.f19026a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.f19034i.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.f19034i.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f19026a.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.new_pb_header_user_item, (ViewGroup) null);
            this.f19031f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(b.a.r0.k2.i.pb_thread_type_stamp_top_part);
            this.f19032g = imageView;
            imageView.getLayoutParams().height = q0.g();
            b.a.r0.k2.u.f.g gVar = new b.a.r0.k2.u.f.g(this.f19026a.getBaseFragmentActivity(), this.f19031f);
            this.f19033h = gVar;
            gVar.a();
            b.a.r0.k2.u.f.g gVar2 = this.f19033h;
            gVar2.d(gVar2.e(), this.f19028c);
            this.f19034i = (ColumnLayout) this.f19031f.findViewById(b.a.r0.k2.i.pb_head_owner_root);
            this.j = (ThreadSkinView) this.f19031f.findViewById(b.a.r0.k2.i.pb_thread_skin);
            this.k = (TextView) this.f19034i.findViewById(b.a.r0.k2.i.pb_head_owner_info_user_name);
            this.l = (TextView) this.f19034i.findViewById(b.a.r0.k2.i.floor_owner);
            this.m = (ImageView) this.f19034i.findViewById(b.a.r0.k2.i.icon_forum_level);
            this.r = (FrameLayout) this.f19034i.findViewById(b.a.r0.k2.i.pb_head_headImage_container);
            HeadPendantView headPendantView = (HeadPendantView) this.f19034i.findViewById(b.a.r0.k2.i.pb_pendant_head_owner_photo);
            this.n = headPendantView;
            headPendantView.setHasPendantStyle();
            this.o = (TBLottieAnimationView) this.f19034i.findViewById(b.a.r0.k2.i.pb_head_living_lottie);
            this.f19034i.setOnLongClickListener(this.f19029d);
            this.f19034i.setOnTouchListener(this.f19027b);
            this.f19034i.setVisibility(8);
            if (this.n.getHeadView() != null) {
                this.n.getHeadView().setIsRound(true);
                this.n.getHeadView().setDrawBorder(true);
                this.n.getHeadView().setPlaceHolder(1);
            }
            this.p = (UserIconBox) this.f19034i.findViewById(b.a.r0.k2.i.show_icon_vip);
            this.q = (UserIconBox) this.f19034i.findViewById(b.a.r0.k2.i.show_icon_yinji);
            this.s = (LinearLayout) this.f19031f.findViewById(b.a.r0.k2.i.pb_head_owner_info_root);
            this.t = (LinearLayout) this.f19034i.findViewById(b.a.r0.k2.i.pb_first_floor_location_container);
            this.v = (PbFirstFloorUserLikeButton) this.f19034i.findViewById(b.a.r0.k2.i.pb_like_button);
            this.x = new c(this, (TextView) this.f19034i.findViewById(b.a.r0.k2.i.pb_views), (TBSpecificationBtn) this.f19034i.findViewById(b.a.r0.k2.i.pb_views_btn));
            this.y = (TextView) this.f19034i.findViewById(b.a.r0.k2.i.pb_item_first_floor_reply_time);
            this.z = (TextView) this.f19034i.findViewById(b.a.r0.k2.i.pb_item_first_floor_location_address);
            this.A = (TextView) this.f19034i.findViewById(b.a.r0.k2.i.pb_item_first_floor_distance);
            this.B = (TextView) this.f19034i.findViewById(b.a.r0.k2.i.pb_item_first_floor_general_desc);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f19031f, b.a.r0.k2.f.CAM_X0205);
            ImageView imageView = this.m;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.C));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.v;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.onChangeSkinType(i2);
            }
            TextView textView = this.z;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, b.a.r0.k2.f.CAM_X0109);
            }
            TextView textView2 = this.y;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, b.a.r0.k2.f.CAM_X0109);
            }
            c cVar = this.x;
            if (cVar != null) {
                cVar.e(i2);
            }
            TextView textView3 = this.B;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, b.a.r0.k2.f.CAM_X0109);
            }
            TextView textView4 = this.A;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, b.a.r0.k2.f.CAM_X0109);
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, b.a.r0.k2.k.card_live_header_bg);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b.a.r0.f0.g gVar = this.f19030e;
            if (gVar != null) {
                gVar.I();
            }
            ColumnLayout columnLayout = this.f19034i;
            if (columnLayout != null && this.u != null) {
                columnLayout.removeView(this.r);
                this.u = null;
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }

    public void s(b.a.r0.k2.r.f fVar, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{fVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || fVar == null || postData == null) {
            return;
        }
        String Q = fVar != null ? fVar.Q() : "";
        int i2 = q0.i(fVar);
        if (z && postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
        }
        if (this.w == null) {
            d2 O = fVar.O();
            int i3 = 1;
            if (O != null) {
                if (O.M1()) {
                    i3 = 4;
                } else if (O.P1()) {
                    i3 = 6;
                } else if (O.O1()) {
                    i3 = 7;
                } else if (O.N1()) {
                    i3 = 5;
                } else if (O.F2()) {
                    i3 = 8;
                }
            }
            p0 p0Var = new p0(this.f19026a.getPageContext(), this.v, i3);
            this.w = p0Var;
            p0Var.l(this.f19026a.getUniqueId());
            this.w.u(O);
        }
        if (postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
            this.w.n(postData.t());
            this.w.w(Q);
        }
        p0 p0Var2 = this.w;
        p0Var2.s = z2;
        p0Var2.v(i2);
    }

    public void t(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f19031f);
    }

    public void u(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onLongClickListener) == null) {
            this.f19029d = onLongClickListener;
            this.f19034i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void v(PostData postData, b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, postData, fVar) == null) || postData == null || fVar == null) {
            return;
        }
        if (postData.N() != null) {
            this.j.setData(this.f19026a.getPageContext(), fVar.F().get(0).N(), b.a.r0.l3.l0.a.a("PB", "c0132", fVar.l().getId(), fVar.l().getName(), fVar.O().f0(), this.f19026a.isFromFrs() ? "FRS" : null));
            ColumnLayout columnLayout = this.f19034i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(b.a.r0.k2.g.ds20), this.f19034i.getPaddingRight(), this.f19034i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f19033h.g(z);
        }
    }

    public void x(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            if (fVar != null && fVar.r0()) {
                int g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds45);
                int paddingBottom = this.f19034i.getPaddingBottom();
                if (fVar.g0()) {
                    g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds38);
                    paddingBottom = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds8);
                }
                ColumnLayout columnLayout = this.f19034i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), g2, this.f19034i.getPaddingRight(), paddingBottom);
                return;
            }
            int g3 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds60);
            int paddingBottom2 = this.f19034i.getPaddingBottom();
            if (fVar != null && !fVar.O().E2() && fVar.g0() && (!StringUtils.isNull(fVar.O().getTitle()) || fVar.O().g1() != null)) {
                g3 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds20);
            }
            ColumnLayout columnLayout2 = this.f19034i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), g3, this.f19034i.getPaddingRight(), paddingBottom2);
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f19034i.setVisibility(i2);
        }
    }

    public void z(int i2, b.a.r0.k2.r.f fVar, PostData postData, View.OnClickListener onClickListener) {
        ArrayList<IconData> arrayList;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), fVar, postData, onClickListener}) == null) {
            if (postData != null && postData.t() != null) {
                MetaData t = postData.t();
                String string = t.getName_show() == null ? StringUtils.string(t.getUserName()) : StringUtils.string(t.getName_show());
                if ((!StringUtils.isNull(postData.t().getSealPrefix()) ? b.a.e.e.p.k.byteLength(t.getSealPrefix()) + 2 : 0) > 0) {
                    if (b.a.e.e.p.k.byteLength(string) > 12) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, "...");
                    }
                } else if (b.a.e.e.p.k.byteLength(string) > 14) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, "...");
                }
                ArrayList<IconData> iconInfo = t.getIconInfo();
                ArrayList<IconData> tShowInfoNew = t.getTShowInfoNew();
                UserIconBox userIconBox = this.q;
                if (userIconBox != null) {
                    userIconBox.setTag(b.a.r0.k2.i.tag_user_id, t.getUserId());
                    if (this.f19026a.getPbActivity() != null) {
                        this.q.setOnClickListener(this.f19026a.getPbActivity().mEvent.f19143c);
                    }
                    int g2 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds40);
                    this.q.loadIcon(iconInfo, 4, g2, g2, b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds10));
                }
                if (this.p != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.p.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.f19026a.getPbActivity() != null) {
                        this.p.setOnClickListener(this.f19026a.getPbActivity().mEvent.f19144d);
                    }
                    int g3 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds48);
                    arrayList = tShowInfoNew;
                    this.p.loadIcon(tShowInfoNew, 3, g3, g3, b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds8), true);
                } else {
                    arrayList = tShowInfoNew;
                }
                this.k.setText(n(t.getSealPrefix(), string));
                this.k.setTag(b.a.r0.k2.i.tag_user_id, t.getUserId());
                this.k.setTag(b.a.r0.k2.i.tag_user_name, t.getName_show());
                if (ListUtils.isEmpty(arrayList) && !t.isBigV()) {
                    SkinManager.setViewTextColor(this.k, b.a.r0.k2.f.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, b.a.r0.k2.f.CAM_X0301, 1);
                }
                if (fVar.g0()) {
                    this.l.setVisibility(8);
                } else if (t.getIs_bawu() == 1 && postData.b0()) {
                    b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.l);
                    d2.v(b.a.r0.k2.f.CAM_X0101);
                    d2.n(b.a.r0.k2.l.J_X04);
                    d2.f(b.a.r0.k2.f.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(b.a.r0.k2.l.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    this.l.setText(b.a.r0.k2.l.bawu_member_bazhu_tip);
                    this.l.setVisibility(0);
                    b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.l);
                    d3.v(b.a.r0.k2.f.CAM_X0101);
                    d3.n(b.a.r0.k2.l.J_X04);
                    d3.f(b.a.r0.k2.f.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    this.l.setText(b.a.r0.k2.l.bawu_member_xbazhu_tip);
                    this.l.setVisibility(0);
                    b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.l);
                    d4.v(b.a.r0.k2.f.CAM_X0101);
                    d4.n(b.a.r0.k2.l.J_X04);
                    d4.f(b.a.r0.k2.f.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.U()), "yyyy"))) {
                    this.y.setText(StringHelper.getFormatTimeShort(postData.U()));
                } else {
                    this.y.setText(StringHelper.getFormatTime(postData.U()));
                }
                if (fVar.g0()) {
                    this.z.setVisibility(8);
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = 0;
                    }
                    this.f19034i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(t);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.B.setVisibility(0);
                        this.B.setText(authInfo);
                    } else {
                        this.B.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(t);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.B.setVisibility(0);
                        this.B.setText(authInfo2);
                    } else {
                        this.B.setVisibility(8);
                    }
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds40);
                    }
                    this.f19034i.setSpacingRight(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds20));
                    b.a.q0.u.g K = postData.K();
                    if (K != null && !TextUtils.isEmpty(K.b()) && !TextUtils.isEmpty(K.b().trim())) {
                        this.z.setVisibility(0);
                        this.z.setText(K.b());
                    } else {
                        this.z.setVisibility(8);
                    }
                    if (K != null && !TextUtils.isEmpty(K.a())) {
                        this.A.setText(K.a());
                        this.A.setVisibility(0);
                        this.t.post(new a(this, (int) this.A.getPaint().measureText(K.a(), 0, K.a().length())));
                    } else {
                        this.A.setVisibility(8);
                    }
                }
                if (fVar.O().J() == null || fVar.O().J().getAlaInfo() == null || fVar.O().J().getAlaInfo().live_status != 1) {
                    z = false;
                } else {
                    A(fVar);
                    z = true;
                }
                this.n.setBigVDimenSize(b.a.r0.k2.g.tbds36);
                if (!z) {
                    this.n.showHeadPendantAndBigV(t, 4);
                    this.n.setIsclearmode(false);
                } else {
                    this.n.setIsclearmode(true);
                }
                this.n.setVisibility(0);
                ClickableHeaderImageView clickableHeaderImageView = this.u;
                if (clickableHeaderImageView != null) {
                    clickableHeaderImageView.setVisibility(8);
                }
                this.k.setOnClickListener(onClickListener);
                this.n.getHeadView().setUserId(t.getUserId());
                this.n.getHeadView().setUserName(t.getUserName());
                this.n.getHeadView().setTid(postData.G());
                this.n.getHeadView().setFid(fVar != null ? fVar.m() : "");
                this.n.getHeadView().setFName(fVar.n());
                this.n.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.n.startLoadOnlyHeadUrl(t.getAvater());
                } else {
                    this.n.startLoadWithPendantAndBigV(t);
                }
                String name_show = t.getName_show();
                String userName = t.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(b.a.r0.k2.c.b(this.f19026a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(b.a.r0.k2.i.tag_nick_name_activity, b.a.r0.k2.c.a());
                    SkinManager.setViewTextColor(this.k, b.a.r0.k2.f.CAM_X0312, 1);
                }
            }
            if (fVar != null) {
                this.f19033h.f(fVar.O());
            }
        }
    }
}
