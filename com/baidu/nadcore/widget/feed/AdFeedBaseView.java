package com.baidu.nadcore.widget.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.b.h;
import c.a.b0.d0.f;
import c.a.b0.g.f.j;
import c.a.b0.p.b;
import c.a.b0.p.l;
import c.a.b0.p.o;
import c.a.b0.s.p;
import c.a.b0.s.q;
import c.a.b0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uitemplate.DislikeBottomDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f37887g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f37888e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37889f;
    public DislikeBottomDialog mBottomDialog;
    public c.a.b0.h0.c0.b mFeedListener;
    public c.a.b0.h0.c0.a mNadDownloadListener;
    public c.a.b0.g.f.d mNativeDownloadPresenter;
    public p mNativePlayer;
    public c.a.b0.h0.c0.c mVideoMediaListener;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37890e;

        public a(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37890e = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f37890e.onDislikeBtnClicked();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DislikeBottomDialog.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdFeedBaseView a;

        public b(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adFeedBaseView;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.DislikeBottomDialog.d
        public void a(List<b.a> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                Toast.makeText(this.a.getContext(), h.nad_dislike_reduce_recommend, 0).show();
                this.a.setVisibility(8);
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.mFeedListener == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.a.mFeedListener.a((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37891e;

        public c(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37891e = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.b0.g.f.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (dVar = this.f37891e.mNativeDownloadPresenter) == null) {
                return;
            }
            dVar.o();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37892e;

        public d(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37892e = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f37892e.getTag() instanceof AdBaseModel)) {
                AdBaseModel adBaseModel = (AdBaseModel) this.f37892e.getTag();
                String str = adBaseModel.f37574d.a;
                AdOperator adOperator = adBaseModel.f37576f;
                if (adOperator != null && !TextUtils.isEmpty(adOperator.f37584d)) {
                    str = adBaseModel.f37576f.f37584d;
                }
                c.a.b0.d.c.c(str, this.f37892e.getContext());
                c.a.b0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.CLICK).f(ClogBuilder.Area.BUTTON).m(adBaseModel.f37574d.f1782b));
                c.a.b0.h0.c0.b bVar = this.f37892e.mFeedListener;
                if (bVar != null) {
                    bVar.b(adBaseModel);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdFeedBaseView a;

        public e(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adFeedBaseView;
        }

        @Override // c.a.b0.s.i
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.mVideoMediaListener == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedBaseView adFeedBaseView2 = this.a;
                adFeedBaseView2.mVideoMediaListener.f((AdBaseModel) adFeedBaseView2.getTag());
            }
        }

        @Override // c.a.b0.s.i
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.mVideoMediaListener == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedBaseView adFeedBaseView2 = this.a;
                adFeedBaseView2.mVideoMediaListener.e((AdBaseModel) adFeedBaseView2.getTag(), str);
            }
        }

        @Override // c.a.b0.s.i
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.mVideoMediaListener == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedBaseView adFeedBaseView2 = this.a;
                adFeedBaseView2.mVideoMediaListener.c((AdBaseModel) adFeedBaseView2.getTag());
            }
        }

        @Override // c.a.b0.s.i
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.mVideoMediaListener == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedBaseView adFeedBaseView2 = this.a;
                adFeedBaseView2.mVideoMediaListener.d((AdBaseModel) adFeedBaseView2.getTag());
            }
        }

        @Override // c.a.b0.s.i
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.mVideoMediaListener == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedBaseView adFeedBaseView2 = this.a;
                adFeedBaseView2.mVideoMediaListener.a((AdBaseModel) adFeedBaseView2.getTag());
            }
        }

        @Override // c.a.b0.s.i
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                AdFeedBaseView adFeedBaseView = this.a;
                if (adFeedBaseView.mVideoMediaListener == null || !(adFeedBaseView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                AdFeedBaseView adFeedBaseView2 = this.a;
                adFeedBaseView2.mVideoMediaListener.b((AdBaseModel) adFeedBaseView2.getTag());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37893b;

        public f(AdFeedBaseView adFeedBaseView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37893b = adFeedBaseView;
            this.a = adBaseModel;
        }

        @Override // c.a.b0.g.f.j
        public void a(c.a.b0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37893b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37893b.mNadDownloadListener.e(this.a);
            }
        }

        @Override // c.a.b0.g.f.j
        public void b(c.a.b0.g.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                AdFeedBaseView adFeedBaseView = this.f37893b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37893b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.b0.g.f.j
        public void c(c.a.b0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37893b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37893b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.b0.g.f.j
        public void d(c.a.b0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37893b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37893b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.b0.g.f.j
        public void e(c.a.b0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37893b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37893b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.b0.g.f.j
        public void f(c.a.b0.g.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                AdFeedBaseView adFeedBaseView = this.f37893b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37893b.mNadDownloadListener.g(this.a, f2);
            }
        }

        @Override // c.a.b0.g.f.j
        public void g(c.a.b0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37893b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37893b.mNadDownloadListener.b(this.a);
            }
        }

        @Override // c.a.b0.g.f.j
        public void h(c.a.b0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f37893b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f37893b.mNadDownloadListener.f(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f37894e;

        public g(AdFeedBaseView adFeedBaseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adFeedBaseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37894e = adFeedBaseView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f37894e.f37889f = true;
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f37894e.f37889f = false;
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f37894e.f37889f = false;
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ g(AdFeedBaseView adFeedBaseView, a aVar) {
            this(adFeedBaseView);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1776047025, "Lcom/baidu/nadcore/widget/feed/AdFeedBaseView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1776047025, "Lcom/baidu/nadcore/widget/feed/AdFeedBaseView;");
                return;
            }
        }
        f37887g = f.c.a(c.a.b0.e.a.b(), 15.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37889f = true;
    }

    public void bindDownloadView(@NonNull View view, @NonNull c.a.b0.h0.c0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) {
            view.setOnClickListener(new c(this));
            setViewDownloadListener(aVar);
        }
    }

    public void bindOperateBtnView(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            view.setOnClickListener(new d(this));
        }
    }

    public void bindVideoView(@NonNull ViewGroup viewGroup, @Nullable q qVar, @Nullable IVideoUpdateStrategy iVideoUpdateStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, qVar, iVideoUpdateStrategy) == null) {
            p pVar = this.mNativePlayer;
            if (pVar != null) {
                pVar.release();
                this.mNativePlayer = null;
            }
            p.a aVar = p.a;
            Context context = getContext();
            if (qVar == null) {
                qVar = q.f2081b;
            }
            p b2 = aVar.b(context, 0, qVar);
            this.mNativePlayer = b2;
            if (iVideoUpdateStrategy != null) {
                b2.d(iVideoUpdateStrategy);
            }
            this.mNativePlayer.attachToContainer(viewGroup);
        }
    }

    public final void c() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (findViewById = findViewById(c.a.b0.b.e.nad_base_delete_id)) == null) {
            return;
        }
        c.a.b0.h0.j.a(this, findViewById, f37887g);
        findViewById.setOnClickListener(new a(this));
    }

    public final boolean d(c.a.b0.g.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.b0.p.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.f37579i) == null || !TextUtils.equals(aVar.f1499g, cVar.f1768b) || !TextUtils.equals(aVar.d(), cVar.f1769c)) ? false : true : invokeLL.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            p pVar = this.mNativePlayer;
            if (pVar != null) {
                pVar.release();
                this.mNativePlayer = null;
            }
            c.a.b0.g.f.d dVar = this.mNativeDownloadPresenter;
            if (dVar != null) {
                dVar.m();
                this.mNativeDownloadPresenter = null;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (adBaseModel.a) {
                return;
            }
            c.a.b0.h0.c0.b bVar = this.mFeedListener;
            if (bVar != null) {
                bVar.c(adBaseModel);
            }
            c.a.b0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.SHOW).m(adBaseModel.f37574d.f1782b));
            adBaseModel.a = true;
        }
    }

    public final void f(@NonNull AdBaseModel adBaseModel) {
        c.a.b0.p.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) && (cVar = adBaseModel.f37579i) != null && cVar.f1770d) {
            this.mNativeDownloadPresenter = new c.a.b0.g.f.d(c.a.b0.g.d.a.b(adBaseModel));
            c.a.b0.h0.c0.a aVar = this.mNadDownloadListener;
            if (aVar != null) {
                aVar.d(adBaseModel);
            }
            this.mNativeDownloadPresenter.q(new f(this, adBaseModel));
        }
    }

    public final void g(@NonNull AdBaseModel adBaseModel) {
        p pVar;
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) || (pVar = this.mNativePlayer) == null || (lVar = adBaseModel.f37578h) == null) {
            return;
        }
        pVar.c(lVar);
        this.mNativePlayer.a(new e(this));
    }

    public long getVideoPosMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            p pVar = this.mNativePlayer;
            if (pVar == null) {
                return -1L;
            }
            return pVar.b();
        }
        return invokeV.longValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : (View) invokeV.objValue;
    }

    public void notifyDislikeClicked(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            c.a.b0.x.a.b(new c.a.b0.x.c.b().d(str).f(adBaseModel.f37574d.f1782b).e(c.a.b0.e.a.a().b()));
            setVisibility(8);
            c.a.b0.h0.c0.b bVar = this.mFeedListener;
            if (bVar != null) {
                bVar.a(adBaseModel);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onAttachedToWindow();
            e();
        }
    }

    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view) == null) && this.f37889f && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (TextUtils.isEmpty(adBaseModel.f37574d.a)) {
                return;
            }
            c.a.b0.d.c.c(adBaseModel.f37574d.a, getContext());
            c.a.b0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.CLICK).f(ClogBuilder.Area.HOTAREA).m(adBaseModel.f37574d.f1782b));
            c.a.b0.h0.c0.b bVar = this.mFeedListener;
            if (bVar != null) {
                bVar.b(adBaseModel);
            }
            adBaseModel.f37572b = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
            destroy();
        }
    }

    public void onDislikeBtnClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.mBottomDialog == null) {
                if (!(getTag() instanceof AdBaseModel)) {
                    return;
                }
                this.mBottomDialog = new DislikeBottomDialog(getContext(), (AdBaseModel) getTag());
            }
            this.mBottomDialog.setDislikeListener(new b(this));
            c.a.b0.d0.a.b(this.mBottomDialog);
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            this.f37888e.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            super.onViewAdded(view);
            if (view.getVisibility() == 0) {
                e();
                c();
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
            if (i2 == 0) {
                e();
            }
        }
    }

    public boolean playVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            p pVar = this.mNativePlayer;
            if (pVar == null || pVar.isPlaying()) {
                return false;
            }
            this.mNativePlayer.start();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setVideoMediaListener(c.a.b0.h0.c0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.mVideoMediaListener = cVar;
        }
    }

    public void setViewDownloadListener(c.a.b0.h0.c0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.mNadDownloadListener = aVar;
        }
    }

    public void setViewStatChangeListener(c.a.b0.h0.c0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.mFeedListener = bVar;
        }
    }

    public boolean stopVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            p pVar = this.mNativePlayer;
            if (pVar == null) {
                return false;
            }
            pVar.stop();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, adBaseModel) == null) {
            setTag(adBaseModel);
            this.mBottomDialog = new DislikeBottomDialog(getContext(), adBaseModel);
            g(adBaseModel);
            f(adBaseModel);
            if (getVisibility() != 0) {
                setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdFeedBaseView(Context context, AttributeSet attributeSet, int i2, o oVar) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), oVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f37889f = true;
        setOnClickListener(this);
        this.f37888e = new GestureDetector(getContext(), new g(this, null));
    }
}
