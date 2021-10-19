package c.a.r0.k2.k.e.a1;

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
import c.a.q0.s.q.d2;
import c.a.q0.t.c.j0;
import c.a.r0.b0.m;
import c.a.r0.k2.k.e.a1.h;
import c.a.r0.k2.k.e.p0;
import c.a.r0.k2.k.e.q0;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public int C;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f20016a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.k2.i.c f20017b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f20018c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f20019d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.f0.e f20020e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f20021f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20022g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.k2.k.e.g f20023h;

    /* renamed from: i  reason: collision with root package name */
    public ColumnLayout f20024i;

    /* renamed from: j  reason: collision with root package name */
    public ThreadSkinView f20025j;
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

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20026e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f20027f;

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
            this.f20027f = hVar;
            this.f20026e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.f20027f.t.getMeasuredWidth();
                int measuredWidth2 = this.f20027f.y.getMeasuredWidth();
                int measuredWidth3 = this.f20027f.B.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i2 = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i3 = this.f20026e;
                if (i2 < i3) {
                    this.f20027f.A.setVisibility(8);
                    this.f20027f.z.setVisibility(8);
                } else if (i2 - i3 < dimenPixelSize) {
                    this.f20027f.z.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20028e;

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
            this.f20028e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20028e.o.playAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TextView f20029a;

        /* renamed from: b  reason: collision with root package name */
        public final TBSpecificationBtn f20030b;

        /* renamed from: c  reason: collision with root package name */
        public String f20031c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f20032d;

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
            this.f20032d = hVar;
            this.f20029a = textView;
            this.f20030b = tBSpecificationBtn;
            c();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f20031c = str;
            }
        }

        @NonNull
        public final j0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                j0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                return tiebaPlusConfigData == null ? j0.f14705c : tiebaPlusConfigData;
            }
            return (j0) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.f20030b.setConfig(bVar);
                this.f20030b.setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.k2.k.e.a1.a
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
            if (!c.a.e.e.p.j.A()) {
                c.a.e.e.p.l.L(this.f20032d.f20016a.getContext(), R.string.neterror);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f20032d.f20016a.getPageContext(), new String[]{b().d(this.f20031c)});
            j0.a(4);
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                if (b().f()) {
                    this.f20030b.changeSkinType(i2);
                } else {
                    SkinManager.setViewTextColor(this.f20029a, R.color.CAM_X0109);
                }
            }
        }

        public void f(@Nullable CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
                if (b().f()) {
                    this.f20030b.setText(charSequence.toString());
                } else {
                    this.f20029a.setText(charSequence);
                }
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                if (b().f()) {
                    this.f20030b.setVisibility(i2);
                    this.f20029a.setVisibility(8);
                    return;
                }
                this.f20030b.setVisibility(8);
                this.f20029a.setVisibility(i2);
            }
        }
    }

    public h(PbFragment pbFragment, c.a.r0.k2.i.c cVar, View.OnClickListener onClickListener) {
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
        this.f20018c = null;
        this.f20019d = null;
        this.f20021f = null;
        this.f20024i = null;
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
        this.f20016a = pbFragment;
        this.f20017b = cVar;
        this.f20018c = onClickListener;
        p();
    }

    public final void A(c.a.r0.k2.h.e eVar) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || (tBLottieAnimationView = this.o) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() != 0 && eVar != null && eVar.O() != null && eVar.O().J() != null) {
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", eVar.n());
            statisticItem.param("fname", eVar.o());
            statisticItem.param("obj_param1", eVar.O().J().getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", eVar.Q());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (eVar.O().J().getAlaInfo() != null) {
                AlaInfoData alaInfo = eVar.O().J().getAlaInfo();
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
            if (this.f20016a.isSimpleForum()) {
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

    public void C(c.a.r0.k2.h.e eVar, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, eVar, postData, z) == null) || eVar == null || postData == null) {
            return;
        }
        if (3 != eVar.g()) {
            this.v.setVisibility(0);
        }
        if (z) {
            this.v.setVisibility(8);
            if (eVar != null && eVar.O() != null && eVar.O().L() != null && eVar.O().L().oriUgcType == 3) {
                this.x.g(8);
            } else {
                this.x.g(0);
            }
            this.x.a(eVar.Q());
            this.x.f(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(eVar.P())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.t().hadConcerned()) {
            this.x.g(8);
        } else {
            this.v.setVisibility(8);
            this.x.g(8);
        }
        if (eVar.f19811i || 3 == eVar.g()) {
            this.v.setVisibility(8);
        }
    }

    public void h(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f20021f);
    }

    public void i(BdTypeListView bdTypeListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, bdTypeListView, i2) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f20021f, i2);
    }

    public void j(c.a.r0.k2.h.e eVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{eVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (eVar != null && eVar.f19812j) {
                this.f20022g.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f20022g.setVisibility(0);
            } else if (z && z2) {
                this.f20022g.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.f20022g.setVisibility(0);
            } else if (z) {
                this.f20022g.setImageResource(R.drawable.pic_pb_refined_n);
                this.f20022g.setVisibility(0);
            } else if (z2) {
                this.f20022g.setImageResource(R.drawable.pic_pb_stick_n);
                this.f20022g.setVisibility(0);
            } else {
                this.f20022g.setVisibility(8);
            }
        }
    }

    public void k() {
        c.a.r0.f0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eVar = this.f20020e) == null) {
            return;
        }
        eVar.I();
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20023h.e() : (TextView) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20021f : (View) invokeV.objValue;
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
            return m.h(this.f20016a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.f20024i.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.f20024i.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f20016a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
            this.f20021f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_top_part);
            this.f20022g = imageView;
            imageView.getLayoutParams().height = q0.g();
            c.a.r0.k2.k.e.g gVar = new c.a.r0.k2.k.e.g(this.f20016a.getBaseFragmentActivity(), this.f20021f);
            this.f20023h = gVar;
            gVar.a();
            c.a.r0.k2.k.e.g gVar2 = this.f20023h;
            gVar2.d(gVar2.e(), this.f20018c);
            this.f20024i = (ColumnLayout) this.f20021f.findViewById(R.id.pb_head_owner_root);
            this.f20025j = (ThreadSkinView) this.f20021f.findViewById(R.id.pb_thread_skin);
            this.k = (TextView) this.f20024i.findViewById(R.id.pb_head_owner_info_user_name);
            this.l = (TextView) this.f20024i.findViewById(R.id.floor_owner);
            this.m = (ImageView) this.f20024i.findViewById(R.id.icon_forum_level);
            this.r = (FrameLayout) this.f20024i.findViewById(R.id.pb_head_headImage_container);
            HeadPendantView headPendantView = (HeadPendantView) this.f20024i.findViewById(R.id.pb_pendant_head_owner_photo);
            this.n = headPendantView;
            headPendantView.setHasPendantStyle();
            this.o = (TBLottieAnimationView) this.f20024i.findViewById(R.id.pb_head_living_lottie);
            this.f20024i.setOnLongClickListener(this.f20019d);
            this.f20024i.setOnTouchListener(this.f20017b);
            this.f20024i.setVisibility(8);
            if (this.n.getHeadView() != null) {
                this.n.getHeadView().setIsRound(true);
                this.n.getHeadView().setDrawBorder(true);
                this.n.getHeadView().setPlaceHolder(1);
            }
            this.p = (UserIconBox) this.f20024i.findViewById(R.id.show_icon_vip);
            this.q = (UserIconBox) this.f20024i.findViewById(R.id.show_icon_yinji);
            this.s = (LinearLayout) this.f20021f.findViewById(R.id.pb_head_owner_info_root);
            this.t = (LinearLayout) this.f20024i.findViewById(R.id.pb_first_floor_location_container);
            this.v = (PbFirstFloorUserLikeButton) this.f20024i.findViewById(R.id.pb_like_button);
            this.x = new c(this, (TextView) this.f20024i.findViewById(R.id.pb_views), (TBSpecificationBtn) this.f20024i.findViewById(R.id.pb_views_btn));
            this.y = (TextView) this.f20024i.findViewById(R.id.pb_item_first_floor_reply_time);
            this.z = (TextView) this.f20024i.findViewById(R.id.pb_item_first_floor_location_address);
            this.A = (TextView) this.f20024i.findViewById(R.id.pb_item_first_floor_distance);
            this.B = (TextView) this.f20024i.findViewById(R.id.pb_item_first_floor_general_desc);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f20021f, R.color.CAM_X0205);
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
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            }
            TextView textView2 = this.y;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0109);
            }
            c cVar = this.x;
            if (cVar != null) {
                cVar.e(i2);
            }
            TextView textView3 = this.B;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
            }
            TextView textView4 = this.A;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, R.color.CAM_X0109);
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.r0.f0.e eVar = this.f20020e;
            if (eVar != null) {
                eVar.I();
            }
            ColumnLayout columnLayout = this.f20024i;
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

    public void s(c.a.r0.k2.h.e eVar, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{eVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || eVar == null || postData == null) {
            return;
        }
        String Q = eVar != null ? eVar.Q() : "";
        int i2 = q0.i(eVar);
        if (z && postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
        }
        if (this.w == null) {
            d2 O = eVar.O();
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
            p0 p0Var = new p0(this.f20016a.getPageContext(), this.v, i3);
            this.w = p0Var;
            p0Var.l(this.f20016a.getUniqueId());
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
        bdTypeListView.removeHeaderView(this.f20021f);
    }

    public void u(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onLongClickListener) == null) {
            this.f20019d = onLongClickListener;
            this.f20024i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void v(PostData postData, c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, postData, eVar) == null) || postData == null || eVar == null) {
            return;
        }
        if (postData.L() != null) {
            this.f20025j.setData(this.f20016a.getPageContext(), eVar.F().get(0).L(), c.a.r0.k3.k0.a.a("PB", "c0132", eVar.m().getId(), eVar.m().getName(), eVar.O().f0(), this.f20016a.isFromFrs() ? "FRS" : null));
            ColumnLayout columnLayout = this.f20024i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.f20024i.getPaddingRight(), this.f20024i.getPaddingBottom());
            return;
        }
        this.f20025j.setData(null, null, null);
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f20023h.g(z);
        }
    }

    public void x(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            if (eVar != null && eVar.q0()) {
                int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds45);
                int paddingBottom = this.f20024i.getPaddingBottom();
                if (eVar.f0()) {
                    g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.f20024i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), g2, this.f20024i.getPaddingRight(), paddingBottom);
                return;
            }
            int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.f20024i.getPaddingBottom();
            if (eVar != null && !eVar.O().E2() && eVar.f0() && (!StringUtils.isNull(eVar.O().getTitle()) || eVar.O().g1() != null)) {
                g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
            }
            ColumnLayout columnLayout2 = this.f20024i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), g3, this.f20024i.getPaddingRight(), paddingBottom2);
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f20024i.setVisibility(i2);
        }
    }

    public void z(int i2, c.a.r0.k2.h.e eVar, PostData postData, View.OnClickListener onClickListener) {
        ArrayList<IconData> arrayList;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), eVar, postData, onClickListener}) == null) {
            if (postData != null && postData.t() != null) {
                MetaData t = postData.t();
                String string = t.getName_show() == null ? StringUtils.string(t.getUserName()) : StringUtils.string(t.getName_show());
                if ((!StringUtils.isNull(postData.t().getSealPrefix()) ? c.a.e.e.p.k.byteLength(t.getSealPrefix()) + 2 : 0) > 0) {
                    if (c.a.e.e.p.k.byteLength(string) > 12) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, "...");
                    }
                } else if (c.a.e.e.p.k.byteLength(string) > 14) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, "...");
                }
                ArrayList<IconData> iconInfo = t.getIconInfo();
                ArrayList<IconData> tShowInfoNew = t.getTShowInfoNew();
                UserIconBox userIconBox = this.q;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, t.getUserId());
                    if (this.f20016a.getPbActivity() != null) {
                        this.q.setOnClickListener(this.f20016a.getPbActivity().mEvent.f20138c);
                    }
                    int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    this.q.loadIcon(iconInfo, 4, g2, g2, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (this.p != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.p.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.f20016a.getPbActivity() != null) {
                        this.p.setOnClickListener(this.f20016a.getPbActivity().mEvent.f20139d);
                    }
                    int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    arrayList = tShowInfoNew;
                    this.p.loadIcon(tShowInfoNew, 3, g3, g3, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                } else {
                    arrayList = tShowInfoNew;
                }
                this.k.setText(n(t.getSealPrefix(), string));
                this.k.setTag(R.id.tag_user_id, t.getUserId());
                this.k.setTag(R.id.tag_user_name, t.getName_show());
                if (ListUtils.isEmpty(arrayList) && !t.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (eVar.f0()) {
                    this.l.setVisibility(8);
                } else if (t.getIs_bawu() == 1 && postData.Z()) {
                    c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.l);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_bazhu_tip);
                    this.l.setVisibility(0);
                    c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.l);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_xbazhu_tip);
                    this.l.setVisibility(0);
                    c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(this.l);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.S()), "yyyy"))) {
                    this.y.setText(StringHelper.getFormatTimeShort(postData.S()));
                } else {
                    this.y.setText(StringHelper.getFormatTime(postData.S()));
                }
                if (eVar.f0()) {
                    this.z.setVisibility(8);
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = 0;
                    }
                    this.f20024i.setSpacingRight(0);
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
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.f20024i.setSpacingRight(c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    c.a.q0.u.f I = postData.I();
                    if (I != null && !TextUtils.isEmpty(I.b()) && !TextUtils.isEmpty(I.b().trim())) {
                        this.z.setVisibility(0);
                        this.z.setText(I.b());
                    } else {
                        this.z.setVisibility(8);
                    }
                    if (I != null && !TextUtils.isEmpty(I.a())) {
                        this.A.setText(I.a());
                        this.A.setVisibility(0);
                        this.t.post(new a(this, (int) this.A.getPaint().measureText(I.a(), 0, I.a().length())));
                    } else {
                        this.A.setVisibility(8);
                    }
                }
                if (eVar.O().J() == null || eVar.O().J().getAlaInfo() == null || eVar.O().J().getAlaInfo().live_status != 1) {
                    z = false;
                } else {
                    A(eVar);
                    z = true;
                }
                this.n.setBigVDimenSize(R.dimen.tbds36);
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
                this.n.getHeadView().setTid(postData.E());
                this.n.getHeadView().setFid(eVar != null ? eVar.n() : "");
                this.n.getHeadView().setFName(eVar.o());
                this.n.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.n.startLoadOnlyHeadUrl(t.getAvater());
                } else {
                    this.n.startLoadWithPendantAndBigV(t);
                }
                String name_show = t.getName_show();
                String userName = t.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(c.a.r0.k2.c.b(this.f20016a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.tag_nick_name_activity, c.a.r0.k2.c.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
            }
            if (eVar != null) {
                this.f20023h.f(eVar.O());
            }
        }
    }
}
