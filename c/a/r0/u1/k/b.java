package c.a.r0.u1.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.r0.e1.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.FunImageView;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22958b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f22959c;

    /* renamed from: d  reason: collision with root package name */
    public final TbPageContext<?> f22960d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<String> f22961e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, c.a.r0.u1.k.a> f22962f;

    /* renamed from: g  reason: collision with root package name */
    public int f22963g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f22964h;

    /* renamed from: i  reason: collision with root package name */
    public final int f22965i;

    /* renamed from: j  reason: collision with root package name */
    public final int f22966j;
    public final int k;
    public int l;
    public long m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public final String r;
    public final HashSet<String> s;
    public FunImageView t;
    public View u;
    public LinearLayout v;
    public TextView w;
    public TBLottieAnimationView x;
    public int y;
    public final Runnable z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22967e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22967e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22967e.u == null || this.f22967e.x == null || this.f22967e.u.getVisibility() != 0) {
                return;
            }
            this.f22967e.x.cancelAnimation();
            this.f22967e.u.setVisibility(8);
        }
    }

    /* renamed from: c.a.r0.u1.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnAttachStateChangeListenerC1434b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22968e;

        public View$OnAttachStateChangeListenerC1434b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22968e = bVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22968e.x.resumeAnimation();
                this.f22968e.x.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f22968e.z.run();
                this.f22968e.u.removeCallbacks(this.f22968e.z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f22969b;

        public c(b bVar, a.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22969b = bVar;
            this.a = hVar;
        }

        @Override // c.a.r0.e1.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                a.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, i2);
                }
                if (c.a.r0.e1.a.i().m(str)) {
                    this.f22969b.n(0);
                } else {
                    this.f22969b.n(1);
                }
            }
        }

        @Override // c.a.r0.e1.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f22969b.n(1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22970e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22971f;

        public d(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22971f = bVar;
            this.f22970e = i2;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
                this.f22971f.y = this.f22970e;
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f22972b;

        public e(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22972b = bVar;
            this.a = i2;
        }

        @Override // c.a.r0.e1.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                this.f22972b.k(str2, str3, this.a);
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f22972b.y = -1;
                this.f22972b.l();
                this.f22972b.o(1, this.a, null, null);
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f22972b.y = this.a;
                this.f22972b.o(0, this.a, str2, str3);
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            }
        }
    }

    public b(@NonNull ArrayList<String> arrayList, String str, String str2, boolean z, int i2, TbPageContext<ImageViewerActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, str, str2, Boolean.valueOf(z), Integer.valueOf(i2), tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = -1;
        this.s = new HashSet<>();
        this.y = -2;
        this.z = new a(this);
        this.a = str;
        this.f22958b = str2;
        this.f22959c = z;
        this.f22960d = tbPageContext;
        this.f22961e = arrayList;
        this.f22962f = new HashMap();
        this.f22965i = c.a.q0.s.c.d.c() - 1;
        this.f22966j = c.a.q0.s.c.d.b() + 1;
        this.k = c.a.q0.s.c.d.d() + 1;
        this.f22964h = c.a.q0.r.j0.b.k().l("fun_ad_big_image_switch", -1) == 1;
        String str3 = (String) ListUtils.getItem(arrayList, i2);
        this.r = StringUtils.isNull(str3) ? arrayList.get(0) : str3;
    }

    public boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.q >= i2) {
                this.q = i2;
                return false;
            }
            this.q = i2;
            for (int i3 = i2 + 1; i3 <= this.f22966j + i2; i3++) {
                String str = (String) ListUtils.getItem(this.f22961e, i3);
                if (c.a.r0.e1.c.b(str)) {
                    if (i3 < this.f22963g + p()) {
                        this.f22963g--;
                    }
                    this.f22961e.remove(str);
                    o(2, i3, null, null);
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void B(a.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            FunAdRecordHttpMessage.uploadRequestRecord("a008", "2", this.f22958b, this.a, null);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.f22958b).param("fid", this.a).param("obj_locate", 2).param("obj_type", "a008").eventStat();
            c.a.r0.e1.a.i().n(this.f22960d.getPageActivity(), "6051001643-679358748", new c(this, hVar), c.a.r0.e1.a.b("pic", UbsABTestHelper.isPicPageFunAdSdkTest() ? "1" : "0"));
        }
    }

    public void C(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.m = j2;
            this.l = i2;
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.o = z;
        }
    }

    public final void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.t.removeView(this.v);
            this.t.setFunAdViewVisible(0);
            this.t.getFunAdView().setOnHierarchyChangeListener(new d(this, i2));
            c.a.r0.e1.a.i().v(this.f22960d.getPageActivity(), "6051001643-679358748", this.t.getFunAdView(), new e(this, i2), c.a.r0.e1.a.b("pic", UbsABTestHelper.isPicPageFunAdSdkTest() ? "1" : "0"));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            if (this.t == null) {
                this.t = new FunImageView(this.f22960d.getPageActivity());
            }
            this.t.resetFunAdView();
            viewGroup.addView(this.t);
            if (!this.f22959c) {
                l();
                return this.t;
            }
            this.n = i2 == this.f22961e.size() - 1;
            this.t.setCurUrlTagAndIndex((String) ListUtils.getItem(this.f22961e, i2), i2);
            if (this.t.getFunAdView() != null && c.a.r0.e1.a.i().m("6051001643-679358748")) {
                E(i2);
                return this.t;
            }
            o(3, i2, null, null);
            l();
            return this.t;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewGroup, i2) == null) {
        }
    }

    public final void k(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, str, str2, i2) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").param(TiebaStatic.Params.OBJ_TO, str).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, i2).eventStat();
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a008", "0", this.f22958b, this.a, null, null, null, null, null);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View q = q();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.t.addView(q, layoutParams);
            this.t.setFunAdViewVisible(8);
        }
    }

    public final void m(@NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            String a2 = c.a.r0.e1.c.a(list.size());
            this.s.add(a2);
            ListUtils.add(list, a2);
        }
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i2);
            if (i2 == 1) {
                param.param(TiebaStatic.Params.RESOURCE_ID, 0);
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i2), this.f22958b, this.a, "0");
            } else {
                param.param(TiebaStatic.Params.RESOURCE_ID, 1);
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i2), this.f22958b, this.a, null);
            }
            TiebaStatic.log(param);
        }
    }

    public final void o(int i2, int i3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
            statisticItem.param("obj_source", 6).param("obj_type", "a008").param("tid", this.f22958b).param("fid", this.a).param("obj_locate", i2).param(TiebaStatic.Params.OBJ_PARAM3, i3);
            if (str != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str);
            }
            if (str2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            TiebaStatic.log(statisticItem);
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a008", String.valueOf(i2), this.f22958b, this.a, null, null, null, null, null);
        }
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Math.max(this.f22961e.indexOf(this.r), 0) : invokeV.intValue;
    }

    public final View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TbPageContext<?> tbPageContext = this.f22960d;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            if (this.v == null) {
                LinearLayout linearLayout = new LinearLayout(this.f22960d.getPageActivity());
                this.v = linearLayout;
                linearLayout.setOrientation(1);
                ImageView imageView = new ImageView(this.f22960d.getPageActivity());
                imageView.setBackgroundResource(R.drawable.new_pic_emotion_01);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.v.addView(imageView, layoutParams);
                TextView textView = new TextView(this.f22960d.getPageActivity());
                this.w = textView;
                textView.setIncludeFontPadding(false);
                c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.w);
                d2.v(R.color.CAM_X0108);
                d2.z(R.dimen.T_X06);
                d2.A(R.string.F_X01);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.topMargin = n.f(this.f22960d.getPageActivity(), R.dimen.tbds120);
                layoutParams2.gravity = 17;
                this.v.addView(this.w, layoutParams2);
            }
            TextView textView2 = this.w;
            if (textView2 != null) {
                textView2.setText(this.n ? R.string.image_load_last_error : R.string.image_load_error);
            }
            ViewParent parent = this.v.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.v);
            }
            this.v.setVisibility(0);
            return this.v;
        }
        return (View) invokeV.objValue;
    }

    public final View r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            TbPageContext<?> tbPageContext = this.f22960d;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || this.s.contains(str)) {
                return null;
            }
            View view = this.u;
            if (view != null) {
                return view;
            }
            View inflate = LayoutInflater.from(this.f22960d.getPageActivity()).inflate(R.layout.image_fun_guide, (ViewGroup) null);
            this.u = inflate;
            c.a.q0.r.v.c.d(inflate.findViewById(R.id.ad_slide_guide_mask_layer)).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.u.findViewById(R.id.ad_left_slide_guide_icon);
            this.x = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.ad_left_slide_guide_lottie);
            this.x.setRepeatCount(3);
            this.u.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC1434b(this));
            return this.u;
        }
        return (View) invokeL.objValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && this.f22959c) {
            ArrayList arrayList = new ArrayList(this.f22961e);
            if (UbsABTestHelper.isPicPageFunAdSdkTest()) {
                if (this.o && this.l <= this.f22961e.size()) {
                    m(arrayList);
                }
            } else if (!UbsABTestHelper.isPicPageFunAdInsert()) {
                return;
            } else {
                if (this.p != z) {
                    this.p = z;
                    this.f22963g = 0;
                    this.s.clear();
                    this.f22962f.clear();
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (c.a.r0.e1.c.b(it.next()) && it.hasNext()) {
                            it.remove();
                        }
                    }
                }
                if (this.p) {
                    if (this.f22964h && !t(arrayList.size() - 1) && this.l <= this.f22961e.size()) {
                        m(arrayList);
                    }
                } else {
                    int p = p();
                    if (this.l <= this.f22961e.size() && this.f22965i + p >= this.f22961e.size()) {
                        m(arrayList);
                    } else {
                        int i2 = this.f22963g;
                        int i3 = p + i2;
                        int i4 = i2 > 0 ? this.f22966j : this.f22965i;
                        while (true) {
                            i3 += i4;
                            if (i3 > arrayList.size() || this.f22962f.size() >= this.k) {
                                break;
                            }
                            if (!c.a.r0.e1.c.b((String) ListUtils.getItem(this.f22961e, i3))) {
                                this.f22963g = i3 - p;
                                String a2 = c.a.r0.e1.c.a(i3);
                                c.a.r0.u1.k.a aVar = new c.a.r0.u1.k.a(a2);
                                this.f22962f.put(a2, aVar);
                                ListUtils.add(arrayList, i3, aVar.a());
                            }
                            i4 = this.f22966j;
                        }
                        if (this.f22964h && (arrayList.size() - this.f22963g) - p > this.f22966j && !t(arrayList.size() - 1) && this.l <= this.f22961e.size()) {
                            m(arrayList);
                        }
                    }
                }
            }
            this.f22961e.clear();
            this.f22961e.addAll(arrayList);
        }
    }

    public boolean t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? c.a.r0.e1.c.b((String) ListUtils.getItem(this.f22961e, i2)) : invokeI.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? ((long) i2) >= this.m : invokeI.booleanValue;
    }

    public boolean w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            int i3 = i2;
            while (true) {
                if (i3 >= this.f22961e.size()) {
                    i3 = -1;
                    break;
                } else if (c.a.r0.e1.c.b((String) ListUtils.getItem(this.f22961e, i3))) {
                    break;
                } else {
                    i3++;
                }
            }
            return this.y != i3 && i3 != -1 && i2 >= i3 + (-3) && i2 < i3;
        }
        return invokeI.booleanValue;
    }

    public boolean x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048596, this, i2)) != null) {
            return invokeI.booleanValue;
        }
        int p = p();
        int i3 = this.f22965i;
        while (true) {
            p += i3;
            if (p >= this.f22961e.size()) {
                return false;
            }
            if (i2 == p) {
                return true;
            }
            i3 = this.f22966j;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.r0.e1.a.i().d("6051001643-679358748");
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            String str = (String) ListUtils.getItem(this.f22961e, i2);
            if (!c.a.r0.e1.c.b(str)) {
                this.z.run();
                return;
            }
            LinearLayout linearLayout = this.v;
            if (linearLayout != null && linearLayout.getParent() != null) {
                E(i2);
            }
            if (!this.s.contains(str) && i2 < this.f22961e.size() - 1) {
                View r = r(str);
                if (r != null) {
                    ViewParent parent = r.getParent();
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(r);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(15);
                    this.t.addView(r, layoutParams);
                    this.u.setVisibility(0);
                    this.u.postDelayed(this.z, 10000L);
                }
                this.s.add(str);
                return;
            }
            this.z.run();
        }
    }
}
