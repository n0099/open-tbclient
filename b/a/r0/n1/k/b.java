package b.a.r0.n1.k;

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
import b.a.e.f.p.l;
import b.a.q0.t.c.e;
import b.a.r0.y0.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b implements ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f22867a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22868b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f22869c;

    /* renamed from: d  reason: collision with root package name */
    public final TbPageContext<?> f22870d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<String> f22871e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, b.a.r0.n1.k.a> f22872f;

    /* renamed from: g  reason: collision with root package name */
    public int f22873g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f22874h;

    /* renamed from: i  reason: collision with root package name */
    public final int f22875i;
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
    public final Runnable y;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22876e;

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
            this.f22876e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22876e.u == null || this.f22876e.x == null || this.f22876e.u.getVisibility() != 0) {
                return;
            }
            this.f22876e.x.cancelAnimation();
            this.f22876e.u.setVisibility(8);
        }
    }

    /* renamed from: b.a.r0.n1.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnAttachStateChangeListenerC1115b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22877e;

        public View$OnAttachStateChangeListenerC1115b(b bVar) {
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
            this.f22877e = bVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22877e.x.resumeAnimation();
                this.f22877e.x.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f22877e.y.run();
                this.f22877e.u.removeCallbacks(this.f22877e.y);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.h f22878a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f22879b;

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
            this.f22879b = bVar;
            this.f22878a = hVar;
        }

        @Override // b.a.r0.y0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                a.h hVar = this.f22878a;
                if (hVar != null) {
                    hVar.a(str, i2);
                }
                if (b.a.r0.y0.a.i().m(str)) {
                    this.f22879b.m(0);
                } else {
                    this.f22879b.m(1);
                }
            }
        }

        @Override // b.a.r0.y0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                a.h hVar = this.f22878a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.f22879b.m(1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f22880a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f22881b;

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
            this.f22881b = bVar;
            this.f22880a = i2;
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                this.f22881b.j(str2, str3, this.f22880a);
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f22881b.k();
                this.f22881b.n(1, this.f22880a, null, null);
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                this.f22881b.n(0, this.f22880a, str2, str3);
            }
        }

        @Override // b.a.r0.y0.a.i
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
        this.s = new HashSet<>();
        this.y = new a(this);
        this.f22867a = str;
        this.f22868b = str2;
        this.f22869c = z;
        this.f22870d = tbPageContext;
        this.f22871e = arrayList;
        this.f22872f = new HashMap();
        this.f22875i = e.c() - 1;
        this.j = e.b() + 1;
        this.k = e.d() + 1;
        this.f22874h = b.a.q0.s.e0.b.j().k("fun_ad_big_image_switch", -1) == 1;
        String str3 = (String) ListUtils.getItem(arrayList, i2);
        this.r = StringUtils.isNull(str3) ? arrayList.get(0) : str3;
        PrintStream printStream = System.out;
        printStream.println("Test=>getCurBaseIndex: " + o());
        PrintStream printStream2 = System.out;
        printStream2.println("Test=>isPicPageFunAdSdkTest: " + b.a.q0.b.d.O() + " isPicPageFunAdInsert: " + b.a.q0.b.d.N());
        PrintStream printStream3 = System.out;
        printStream3.println("Test=>adInsertStart=> " + this.f22875i + " adInsertOffset: " + this.j + " adInsertSize: " + this.k + " insertSwitchOn: " + this.f22874h);
    }

    public void A(a.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            FunAdRecordHttpMessage.uploadRequestRecord("a008", "2", this.f22868b, this.f22867a, null);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", this.f22868b).param("fid", this.f22867a).param("obj_locate", 2).param("obj_type", "a008").eventStat();
            b.a.r0.y0.a.i().n(this.f22870d.getPageActivity(), "6051001643-679358748", new c(this, hVar), b.a.r0.y0.a.b("pic", b.a.q0.b.d.O() ? "1" : "0"));
        }
    }

    public void B(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.m = j;
            this.l = i2;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.o = z;
        }
    }

    public final void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.t.removeView(this.v);
            this.t.setFunAdViewVisible(0);
            b.a.r0.y0.a.i().v(this.f22870d.getPageActivity(), "6051001643-679358748", this.t.getFunAdView(), new d(this, i2), b.a.r0.y0.a.b("pic", b.a.q0.b.d.O() ? "1" : "0"));
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            if (this.t == null) {
                this.t = new FunImageView(this.f22870d.getPageActivity());
            }
            this.t.resetFunAdView();
            viewGroup.addView(this.t);
            if (!this.f22869c) {
                k();
                return this.t;
            }
            this.n = i2 == this.f22871e.size() - 1;
            this.t.setCurUrlTagAndIndex((String) ListUtils.getItem(this.f22871e, i2), i2);
            if (this.t.getFunAdView() != null && b.a.r0.y0.a.i().m("6051001643-679358748")) {
                D(i2);
                return this.t;
            }
            System.out.println("Test=>fun Ad is not ready");
            n(3, i2, null, null);
            k();
            return this.t;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewGroup, i2) == null) {
        }
    }

    public final void j(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, str, str2, i2) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").param(TiebaStatic.Params.OBJ_TO, str).param(TiebaStatic.Params.OBJ_PARAM2, str2).param(TiebaStatic.Params.OBJ_PARAM3, i2).eventStat();
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a008", "0", this.f22868b, this.f22867a, null, null, null, null, null);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View p = p();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.t.addView(p, layoutParams);
            this.t.setFunAdViewVisible(8);
        }
    }

    public final void l(@NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            String a2 = b.a.r0.y0.c.a(list.size());
            this.s.add(a2);
            ListUtils.add(list, a2);
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i2);
            if (i2 == 1) {
                param.param(TiebaStatic.Params.RESOURCE_ID, 0);
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i2), this.f22868b, this.f22867a, "0");
            } else {
                param.param(TiebaStatic.Params.RESOURCE_ID, 1);
                FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i2), this.f22868b, this.f22867a, null);
            }
            TiebaStatic.log(param);
        }
    }

    public final void n(int i2, int i3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
            statisticItem.param("obj_source", 6).param("obj_type", "a008").param("tid", this.f22868b).param("fid", this.f22867a).param("obj_locate", i2).param(TiebaStatic.Params.OBJ_PARAM3, i3);
            if (str != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str);
            }
            if (str2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            TiebaStatic.log(statisticItem);
            FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a008", String.valueOf(i2), this.f22868b, this.f22867a, null, null, null, null, null);
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Math.max(this.f22871e.indexOf(this.r), 0) : invokeV.intValue;
    }

    public final View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            TbPageContext<?> tbPageContext = this.f22870d;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                return null;
            }
            if (this.v == null) {
                LinearLayout linearLayout = new LinearLayout(this.f22870d.getPageActivity());
                this.v = linearLayout;
                linearLayout.setOrientation(1);
                ImageView imageView = new ImageView(this.f22870d.getPageActivity());
                imageView.setBackgroundResource(R.drawable.new_pic_emotion_01);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.v.addView(imageView, layoutParams);
                TextView textView = new TextView(this.f22870d.getPageActivity());
                this.w = textView;
                textView.setIncludeFontPadding(false);
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.w);
                d2.v(R.color.CAM_X0108);
                d2.z(R.dimen.T_X06);
                d2.A(R.string.F_X01);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.topMargin = l.g(this.f22870d.getPageActivity(), R.dimen.tbds120);
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

    public final View q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            TbPageContext<?> tbPageContext = this.f22870d;
            if (tbPageContext == null || tbPageContext.getPageActivity() == null || this.s.contains(str)) {
                return null;
            }
            View view = this.u;
            if (view != null) {
                return view;
            }
            View inflate = LayoutInflater.from(this.f22870d.getPageActivity()).inflate(R.layout.image_fun_guide, (ViewGroup) null);
            this.u = inflate;
            b.a.q0.s.u.c.d(inflate.findViewById(R.id.ad_slide_guide_mask_layer)).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.u.findViewById(R.id.ad_left_slide_guide_icon);
            this.x = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.ad_left_slide_guide_lottie);
            this.x.setRepeatCount(3);
            this.u.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC1115b(this));
            return this.u;
        }
        return (View) invokeL.objValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && this.f22869c) {
            ArrayList arrayList = new ArrayList(this.f22871e);
            if (b.a.q0.b.d.O()) {
                if (this.o && this.l <= this.f22871e.size()) {
                    l(arrayList);
                }
            } else if (!b.a.q0.b.d.N()) {
                return;
            } else {
                if (this.p != z) {
                    this.p = z;
                    this.f22873g = 0;
                    this.s.clear();
                    this.f22872f.clear();
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (b.a.r0.y0.c.b(it.next()) && it.hasNext()) {
                            it.remove();
                        }
                    }
                }
                if (this.p) {
                    if (this.f22874h && !s(arrayList.size() - 1) && this.l <= this.f22871e.size()) {
                        l(arrayList);
                    }
                } else {
                    int o = o();
                    if (this.l <= this.f22871e.size() && this.f22875i + o >= this.f22871e.size()) {
                        l(arrayList);
                    } else {
                        int i2 = this.f22873g;
                        int i3 = o + i2;
                        int i4 = i2 > 0 ? this.j : this.f22875i;
                        while (true) {
                            i3 += i4;
                            if (i3 > arrayList.size() || this.f22872f.size() >= this.k) {
                                break;
                            }
                            if (!b.a.r0.y0.c.b((String) ListUtils.getItem(this.f22871e, i3))) {
                                this.f22873g = i3 - o;
                                String a2 = b.a.r0.y0.c.a(i3);
                                b.a.r0.n1.k.a aVar = new b.a.r0.n1.k.a(a2);
                                this.f22872f.put(a2, aVar);
                                ListUtils.add(arrayList, i3, aVar.a());
                            }
                            i4 = this.j;
                        }
                        if (this.f22874h && (arrayList.size() - this.f22873g) - o > this.j && !s(arrayList.size() - 1) && this.l <= this.f22871e.size()) {
                            l(arrayList);
                        }
                    }
                }
            }
            System.out.println("Test=>########### origin urls: ");
            for (int i5 = 0; i5 < this.f22871e.size(); i5++) {
                PrintStream printStream = System.out;
                printStream.println("Test=>index: " + i5 + " url: " + this.f22871e.get(i5));
            }
            System.out.println("Test=>########### new urls: ");
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                PrintStream printStream2 = System.out;
                printStream2.println("Test=>index: " + i6 + " url: " + arrayList.get(i6));
            }
            this.f22871e.clear();
            this.f22871e.addAll(arrayList);
        }
    }

    public boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? b.a.r0.y0.c.b((String) ListUtils.getItem(this.f22871e, i2)) : invokeI.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? ((long) i2) >= this.m : invokeI.booleanValue;
    }

    public boolean v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            int i3 = i2;
            while (true) {
                if (i3 >= this.f22871e.size()) {
                    i3 = -1;
                    break;
                } else if (b.a.r0.y0.c.b((String) ListUtils.getItem(this.f22871e, i3))) {
                    break;
                } else {
                    i3++;
                }
            }
            return i3 != -1 && i2 >= i3 + (-3) && i2 < i3;
        }
        return invokeI.booleanValue;
    }

    public boolean w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048595, this, i2)) != null) {
            return invokeI.booleanValue;
        }
        int o = o();
        int i3 = this.f22875i;
        while (true) {
            o += i3;
            if (o >= this.f22871e.size()) {
                return false;
            }
            if (i2 == o) {
                return true;
            }
            i3 = this.j;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.a.r0.y0.a.i().d("6051001643-679358748");
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            String str = (String) ListUtils.getItem(this.f22871e, i2);
            if (!b.a.r0.y0.c.b(str)) {
                this.y.run();
                return;
            }
            LinearLayout linearLayout = this.v;
            if (linearLayout != null && linearLayout.getParent() != null) {
                D(i2);
            }
            if (!this.s.contains(str) && i2 < this.f22871e.size() - 1) {
                View q = q(str);
                if (q != null) {
                    ViewParent parent = q.getParent();
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(q);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(15);
                    this.t.addView(q, layoutParams);
                    this.u.setVisibility(0);
                    this.u.postDelayed(this.y, 10000L);
                }
                this.s.add(str);
                return;
            }
            this.y.run();
        }
    }

    public boolean z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (this.q >= i2) {
                this.q = i2;
                return false;
            }
            this.q = i2;
            for (int i3 = i2 + 1; i3 <= this.j + i2; i3++) {
                String str = (String) ListUtils.getItem(this.f22871e, i3);
                if (b.a.r0.y0.c.b(str)) {
                    if (i3 < this.f22873g + o()) {
                        this.f22873g--;
                    }
                    System.out.println("Test=>removeNextFunData=> curIndex: " + i2 + " url: " + str);
                    this.f22871e.remove(str);
                    n(2, i3, null, null);
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }
}
