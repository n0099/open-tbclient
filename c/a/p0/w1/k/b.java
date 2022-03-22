package c.a.p0.w1.k;

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
import c.a.p0.g1.b;
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
    public final String f19708b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f19709c;

    /* renamed from: d  reason: collision with root package name */
    public final TbPageContext<?> f19710d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<String> f19711e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, c.a.p0.w1.k.a> f19712f;

    /* renamed from: g  reason: collision with root package name */
    public int f19713g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f19714h;
    public final int i;
    public final int j;
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
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.u == null || this.a.x == null || this.a.u.getVisibility() != 0) {
                return;
            }
            this.a.x.cancelAnimation();
            this.a.u.setVisibility(8);
        }
    }

    /* renamed from: c.a.p0.w1.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnAttachStateChangeListenerC1489b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnAttachStateChangeListenerC1489b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.x.resumeAnimation();
                this.a.x.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.a.z.run();
                this.a.u.removeCallbacks(this.a.z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements b.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f19715b;

        public c(b bVar, b.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19715b = bVar;
            this.a = hVar;
        }

        @Override // c.a.p0.g1.b.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                b.h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, i);
                }
                if (c.a.p0.g1.b.j().o(str)) {
                    this.f19715b.n(0);
                } else {
                    this.f19715b.n(1);
                }
            }
        }

        @Override // c.a.p0.g1.b.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                b.h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f19715b.n(1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f19716b;

        public d(b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19716b = bVar;
            this.a = i;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
                this.f19716b.y = this.a;
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
    public class e implements b.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f19717b;

        public e(b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19717b = bVar;
            this.a = i;
        }

        @Override // c.a.p0.g1.b.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                this.f19717b.k(str2, str3, this.a);
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f19717b.y = -1;
                this.f19717b.l();
                this.f19717b.o(1, this.a, null, null);
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f19717b.y = this.a;
                this.f19717b.o(0, this.a, str2, str3);
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            }
        }
    }

    public b(@NonNull ArrayList<String> arrayList, String str, String str2, boolean z, int i, TbPageContext<ImageViewerActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, str, str2, Boolean.valueOf(z), Integer.valueOf(i), tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.f19708b = str2;
        this.f19709c = z;
        this.f19710d = tbPageContext;
        this.f19711e = arrayList;
        this.f19712f = new HashMap();
        this.i = c.a.o0.s.c.d.c() - 1;
        this.j = c.a.o0.s.c.d.b() + 1;
        this.k = c.a.o0.s.c.d.d() + 1;
        this.f19714h = c.a.o0.r.j0.b.k().l("fun_ad_big_image_switch", -1) == 1;
        String str3 = (String) ListUtils.getItem(arrayList, i);
        this.r = StringUtils.isNull(str3) ? arrayList.get(0) : str3;
    }

    public boolean A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.q >= i) {
                this.q = i;
                return false;
            }
            this.q = i;
            for (int i2 = i + 1; i2 <= this.j + i; i2++) {
                String str = (String) ListUtils.getItem(this.f19711e, i2);
                if (c.a.p0.g1.d.d(str)) {
                    if (i2 < this.f19713g + p()) {
                        this.f19713g--;
                    }
                    this.f19711e.remove(str);
                    o(2, i2, null, null);
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void B(b.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            FunAdRecordHttpMessage.uploadRequestRecord("a008", "2", this.f19708b, this.a, null);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.f19708b).param("fid", this.a).param("obj_locate", 2).param("obj_type", "a008").eventStat();
            c.a.p0.g1.b.j().p(this.f19710d.getPageActivity(), "6051001643-679358748", -1, new c(this, hVar), c.a.p0.g1.b.b("pic", UbsABTestHelper.isPicPageFunAdSdkTest() ? "1" : "0"));
        }
    }

    public void C(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.m = j;
            this.l = i;
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.o = z;
        }
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.t.removeView(this.v);
            this.t.setFunAdViewVisible(0);
            this.t.getFunAdView().setOnHierarchyChangeListener(new d(this, i));
            c.a.p0.g1.b.j().x(this.f19710d.getPageActivity(), "6051001643-679358748", this.t.getFunAdView(), new e(this, i), c.a.p0.g1.b.b("pic", UbsABTestHelper.isPicPageFunAdSdkTest() ? "1" : "0"));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            if (this.t == null) {
                this.t = new FunImageView(this.f19710d.getPageActivity());
            }
            this.t.b();
            viewGroup.addView(this.t);
            if (!this.f19709c) {
                l();
                return this.t;
            }
            this.n = i == this.f19711e.size() - 1;
            this.t.setCurUrlTagAndIndex((String) ListUtils.getItem(this.f19711e, i), i);
            if (this.t.getFunAdView() != null && c.a.p0.g1.b.j().o("6051001643-679358748")) {
                E(i);
                return this.t;
            }
            o(3, i, null, null);
            l();
            return this.t;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewGroup, i) == null) {
        }
    }

    public final void k(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, str, str2, i) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").param(TiebaStatic.Params.OBJ_TO, str).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, i).eventStat();
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a008", "0", this.f19708b, this.a, null, null, null, null, null);
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
            String b2 = c.a.p0.g1.d.b(list.size());
            this.s.add(b2);
            ListUtils.add(list, b2);
        }
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i);
            if (i == 1) {
                param.param(TiebaStatic.Params.RESOURCE_ID, 0);
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i), this.f19708b, this.a, "0");
            } else {
                param.param(TiebaStatic.Params.RESOURCE_ID, 1);
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i), this.f19708b, this.a, null);
            }
            TiebaStatic.log(param);
        }
    }

    public final void o(int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
            statisticItem.param("obj_source", 6).param("obj_type", "a008").param("tid", this.f19708b).param("fid", this.a).param("obj_locate", i).param(TiebaStatic.Params.OBJ_PARAM3, i2);
            if (str != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str);
            }
            if (str2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            TiebaStatic.log(statisticItem);
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a008", String.valueOf(i), this.f19708b, this.a, null, null, null, null, null);
        }
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Math.max(this.f19711e.indexOf(this.r), 0) : invokeV.intValue;
    }

    public final View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TbPageContext<?> tbPageContext = this.f19710d;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            if (this.v == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19710d.getPageActivity());
                this.v = linearLayout;
                linearLayout.setOrientation(1);
                ImageView imageView = new ImageView(this.f19710d.getPageActivity());
                imageView.setBackgroundResource(R.drawable.new_pic_emotion_01);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.v.addView(imageView, layoutParams);
                TextView textView = new TextView(this.f19710d.getPageActivity());
                this.w = textView;
                textView.setIncludeFontPadding(false);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.w);
                d2.v(R.color.CAM_X0108);
                d2.z(R.dimen.T_X06);
                d2.A(R.string.F_X01);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.topMargin = n.f(this.f19710d.getPageActivity(), R.dimen.tbds120);
                layoutParams2.gravity = 17;
                this.v.addView(this.w, layoutParams2);
            }
            TextView textView2 = this.w;
            if (textView2 != null) {
                textView2.setText(this.n ? R.string.obfuscated_res_0x7f0f08a8 : R.string.obfuscated_res_0x7f0f08a7);
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
            TbPageContext<?> tbPageContext = this.f19710d;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || this.s.contains(str)) {
                return null;
            }
            View view = this.u;
            if (view != null) {
                return view;
            }
            View inflate = LayoutInflater.from(this.f19710d.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03d4, (ViewGroup) null);
            this.u = inflate;
            c.a.o0.r.v.c.d(inflate.findViewById(R.id.obfuscated_res_0x7f0900e3)).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.u.findViewById(R.id.obfuscated_res_0x7f0900cf);
            this.x = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f110000);
            this.x.setRepeatCount(3);
            this.u.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC1489b(this));
            return this.u;
        }
        return (View) invokeL.objValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && this.f19709c) {
            ArrayList arrayList = new ArrayList(this.f19711e);
            if (UbsABTestHelper.isPicPageFunAdSdkTest()) {
                if (this.o && this.l <= this.f19711e.size()) {
                    m(arrayList);
                }
            } else if (!UbsABTestHelper.isPicPageFunAdInsert()) {
                return;
            } else {
                if (this.p != z) {
                    this.p = z;
                    this.f19713g = 0;
                    this.s.clear();
                    this.f19712f.clear();
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (c.a.p0.g1.d.d(it.next()) && it.hasNext()) {
                            it.remove();
                        }
                    }
                }
                if (this.p) {
                    if (this.f19714h && !t(arrayList.size() - 1) && this.l <= this.f19711e.size()) {
                        m(arrayList);
                    }
                } else {
                    int p = p();
                    if (this.l <= this.f19711e.size() && this.i + p >= this.f19711e.size()) {
                        m(arrayList);
                    } else {
                        int i = this.f19713g;
                        int i2 = p + i;
                        int i3 = i > 0 ? this.j : this.i;
                        while (true) {
                            i2 += i3;
                            if (i2 > arrayList.size() || this.f19712f.size() >= this.k) {
                                break;
                            }
                            if (!c.a.p0.g1.d.d((String) ListUtils.getItem(this.f19711e, i2))) {
                                this.f19713g = i2 - p;
                                String b2 = c.a.p0.g1.d.b(i2);
                                c.a.p0.w1.k.a aVar = new c.a.p0.w1.k.a(b2);
                                this.f19712f.put(b2, aVar);
                                ListUtils.add(arrayList, i2, aVar.a());
                            }
                            i3 = this.j;
                        }
                        if (this.f19714h && (arrayList.size() - this.f19713g) - p > this.j && !t(arrayList.size() - 1) && this.l <= this.f19711e.size()) {
                            m(arrayList);
                        }
                    }
                }
            }
            this.f19711e.clear();
            this.f19711e.addAll(arrayList);
        }
    }

    public boolean t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? c.a.p0.g1.d.d((String) ListUtils.getItem(this.f19711e, i)) : invokeI.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) ? ((long) i) >= this.m : invokeI.booleanValue;
    }

    public boolean w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            int i2 = i;
            while (true) {
                if (i2 >= this.f19711e.size()) {
                    i2 = -1;
                    break;
                } else if (c.a.p0.g1.d.d((String) ListUtils.getItem(this.f19711e, i2))) {
                    break;
                } else {
                    i2++;
                }
            }
            return this.y != i2 && i2 != -1 && i >= i2 + (-3) && i < i2;
        }
        return invokeI.booleanValue;
    }

    public boolean x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048596, this, i)) != null) {
            return invokeI.booleanValue;
        }
        int p = p();
        int i2 = this.i;
        while (true) {
            p += i2;
            if (p >= this.f19711e.size()) {
                return false;
            }
            if (i == p) {
                return true;
            }
            i2 = this.j;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.p0.g1.b.j().d("6051001643-679358748");
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            String str = (String) ListUtils.getItem(this.f19711e, i);
            if (!c.a.p0.g1.d.d(str)) {
                this.z.run();
                return;
            }
            LinearLayout linearLayout = this.v;
            if (linearLayout != null && linearLayout.getParent() != null) {
                E(i);
            }
            if (!this.s.contains(str) && i < this.f19711e.size() - 1) {
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
