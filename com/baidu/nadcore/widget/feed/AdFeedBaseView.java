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
import c.a.c0.b.h;
import c.a.c0.d0.f;
import c.a.c0.g.f.j;
import c.a.c0.p.b;
import c.a.c0.p.l;
import c.a.c0.p.o;
import c.a.c0.s.p;
import c.a.c0.s.q;
import c.a.c0.s.t;
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
/* loaded from: classes10.dex */
public class AdFeedBaseView extends FrameLayout implements Object<View> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final int f38532g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f38533e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38534f;
    public DislikeBottomDialog mBottomDialog;
    public c.a.c0.h0.c0.b mFeedListener;
    public c.a.c0.h0.c0.a mNadDownloadListener;
    public c.a.c0.g.f.d mNativeDownloadPresenter;
    public p mNativePlayer;
    public c.a.c0.h0.c0.c mVideoMediaListener;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f38535e;

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
            this.f38535e = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f38535e.onDislikeBtnClicked();
            }
        }
    }

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f38536e;

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
            this.f38536e = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.c0.g.f.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (dVar = this.f38536e.mNativeDownloadPresenter) == null) {
                return;
            }
            dVar.o();
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f38537e;

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
            this.f38537e = adFeedBaseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f38537e.getTag() instanceof AdBaseModel)) {
                AdBaseModel adBaseModel = (AdBaseModel) this.f38537e.getTag();
                String str = adBaseModel.f38219d.a;
                AdOperator adOperator = adBaseModel.f38221f;
                if (adOperator != null && !TextUtils.isEmpty(adOperator.f38229d)) {
                    str = adBaseModel.f38221f.f38229d;
                }
                c.a.c0.d.c.c(str, this.f38537e.getContext());
                c.a.c0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.CLICK).f(ClogBuilder.Area.BUTTON).m(adBaseModel.f38219d.f2227b));
                c.a.c0.h0.c0.b bVar = this.f38537e.mFeedListener;
                if (bVar != null) {
                    bVar.b(adBaseModel);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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

        @Override // c.a.c0.s.i
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

        @Override // c.a.c0.s.i
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

        @Override // c.a.c0.s.i
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

        @Override // c.a.c0.s.i
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

        @Override // c.a.c0.s.i
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

        @Override // c.a.c0.s.i
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

    /* loaded from: classes10.dex */
    public class f implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f38538b;

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
            this.f38538b = adFeedBaseView;
            this.a = adBaseModel;
        }

        @Override // c.a.c0.g.f.j
        public void a(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f38538b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f38538b.mNadDownloadListener.e(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void b(c.a.c0.g.d.a aVar, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, adDownloadCode) == null) {
                AdFeedBaseView adFeedBaseView = this.f38538b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f38538b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void c(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f38538b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f38538b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void d(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f38538b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f38538b.mNadDownloadListener.c(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void e(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f38538b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f38538b.mNadDownloadListener.a(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void f(c.a.c0.g.d.a aVar, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, aVar, f2) == null) {
                AdFeedBaseView adFeedBaseView = this.f38538b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f38538b.mNadDownloadListener.g(this.a, f2);
            }
        }

        @Override // c.a.c0.g.f.j
        public void g(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f38538b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f38538b.mNadDownloadListener.b(this.a);
            }
        }

        @Override // c.a.c0.g.f.j
        public void h(c.a.c0.g.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                AdFeedBaseView adFeedBaseView = this.f38538b;
                if (adFeedBaseView.mNadDownloadListener == null || !adFeedBaseView.d(aVar, this.a)) {
                    return;
                }
                this.f38538b.mNadDownloadListener.f(this.a);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdFeedBaseView f38539e;

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
            this.f38539e = adFeedBaseView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f38539e.f38534f = true;
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f38539e.f38534f = false;
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f38539e.f38534f = false;
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
        f38532g = f.c.a(c.a.c0.e.a.b(), 15.0f);
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
        this.f38534f = true;
    }

    public void bindDownloadView(@NonNull View view, @NonNull c.a.c0.h0.c0.a aVar) {
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
                qVar = q.f2526b;
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (findViewById = findViewById(c.a.c0.b.e.nad_base_delete_id)) == null) {
            return;
        }
        c.a.c0.h0.j.a(this, findViewById, f38532g);
        findViewById.setOnClickListener(new a(this));
    }

    public final boolean d(c.a.c0.g.d.a aVar, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        c.a.c0.p.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, aVar, adBaseModel)) == null) ? (aVar == null || adBaseModel == null || (cVar = adBaseModel.f38224i) == null || !TextUtils.equals(aVar.f1944g, cVar.f2213b) || !TextUtils.equals(aVar.d(), cVar.f2214c)) ? false : true : invokeLL.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            p pVar = this.mNativePlayer;
            if (pVar != null) {
                pVar.release();
                this.mNativePlayer = null;
            }
            c.a.c0.g.f.d dVar = this.mNativeDownloadPresenter;
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
            c.a.c0.h0.c0.b bVar = this.mFeedListener;
            if (bVar != null) {
                bVar.c(adBaseModel);
            }
            c.a.c0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.SHOW).m(adBaseModel.f38219d.f2227b));
            adBaseModel.a = true;
        }
    }

    public final void f(@NonNull AdBaseModel adBaseModel) {
        c.a.c0.p.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) && (cVar = adBaseModel.f38224i) != null && cVar.f2215d) {
            this.mNativeDownloadPresenter = new c.a.c0.g.f.d(c.a.c0.g.d.a.b(adBaseModel));
            c.a.c0.h0.c0.a aVar = this.mNadDownloadListener;
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
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) || (pVar = this.mNativePlayer) == null || (lVar = adBaseModel.f38223h) == null) {
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
            c.a.c0.x.a.b(new c.a.c0.x.c.b().d(str).f(adBaseModel.f38219d.f2227b).e(c.a.c0.e.a.a().b()));
            setVisibility(8);
            c.a.c0.h0.c0.b bVar = this.mFeedListener;
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
        if ((interceptable == null || interceptable.invokeL(1048589, this, view) == null) && this.f38534f && (getTag() instanceof AdBaseModel)) {
            AdBaseModel adBaseModel = (AdBaseModel) getTag();
            if (TextUtils.isEmpty(adBaseModel.f38219d.a)) {
                return;
            }
            c.a.c0.d.c.c(adBaseModel.f38219d.a, getContext());
            c.a.c0.x.a.b(new ClogBuilder().r(ClogBuilder.LogType.CLICK).f(ClogBuilder.Area.HOTAREA).m(adBaseModel.f38219d.f2227b));
            c.a.c0.h0.c0.b bVar = this.mFeedListener;
            if (bVar != null) {
                bVar.b(adBaseModel);
            }
            adBaseModel.f38217b = true;
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
            c.a.c0.d0.a.b(this.mBottomDialog);
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            this.f38533e.onTouchEvent(motionEvent);
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

    public void setVideoMediaListener(c.a.c0.h0.c0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.mVideoMediaListener = cVar;
        }
    }

    public void setViewDownloadListener(c.a.c0.h0.c0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.mNadDownloadListener = aVar;
        }
    }

    public void setViewStatChangeListener(c.a.c0.h0.c0.b bVar) {
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
        this.f38534f = true;
        setOnClickListener(this);
        this.f38533e = new GestureDetector(getContext(), new g(this, null));
    }
}
