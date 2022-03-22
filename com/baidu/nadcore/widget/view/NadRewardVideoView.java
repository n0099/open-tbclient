package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.s.q;
import c.a.a0.s.s;
import c.a.a0.v.p;
import c.a.a0.v.t;
import c.a.a0.v.v0.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView;
import com.baidu.nadcore.widget.uitemplate.NadRewardVolumeView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class NadRewardVideoView extends NadRewardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t q;
    public p r;
    public ViewGroup s;
    public NadRewardVolumeView t;

    /* loaded from: classes4.dex */
    public class a implements NadRewardVolumeView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoView a;

        public a(NadRewardVideoView nadRewardVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoView;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardVolumeView.b
        public void a(boolean z) {
            p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pVar = this.a.r) == null) {
                return;
            }
            pVar.mute(z);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoView a;

        public b(NadRewardVideoView nadRewardVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoView;
        }

        @Override // c.a.a0.v.t, c.a.a0.v.i
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.t == null) {
                return;
            }
            this.a.t.setVolumeState(k.c(this.a.getContext()) <= 0);
        }

        @Override // c.a.a0.v.i
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.f27780b.f((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.o.f((AdBaseModel) nadRewardVideoView2.getTag());
                }
                if (this.a.t != null) {
                    this.a.t.setVisibility(8);
                }
                this.a.H();
                NadRewardCountDownView nadRewardCountDownView = this.a.n;
                if (nadRewardCountDownView != null) {
                    nadRewardCountDownView.u();
                    this.a.n.bringToFront();
                }
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f0914a2);
                if (findViewById != null) {
                    findViewById.bringToFront();
                }
            }
        }

        @Override // c.a.a0.v.i
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) {
                if (this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.f27780b.e((AdBaseModel) this.a.getTag(), str);
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.o.e((AdBaseModel) nadRewardVideoView2.getTag(), str);
                }
                if (this.a.t != null) {
                    this.a.t.setVisibility(8);
                }
            }
        }

        @Override // c.a.a0.v.i
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.f27780b.c((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o == null || !(nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                NadRewardVideoView nadRewardVideoView2 = this.a;
                nadRewardVideoView2.o.c((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // c.a.a0.v.i
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.f27780b.d((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o == null || !(nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                NadRewardVideoView nadRewardVideoView2 = this.a;
                nadRewardVideoView2.o.d((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // c.a.a0.v.i
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.f27780b.a((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o == null || !(nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                NadRewardVideoView nadRewardVideoView2 = this.a;
                nadRewardVideoView2.o.a((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // c.a.a0.v.i
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.f27780b.b((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.o.b((AdBaseModel) nadRewardVideoView2.getTag());
                }
                if (this.a.t != null && (this.a.getTag() instanceof AdBaseModel)) {
                    AdBaseModel adBaseModel = (AdBaseModel) this.a.getTag();
                    if (adBaseModel.p != null) {
                        this.a.t.setVolumeState(adBaseModel.p.f1576h);
                    }
                    if (k.c(this.a.getContext()) <= 0) {
                        this.a.t.setVolumeState(true);
                    }
                    this.a.t.setVisibility(0);
                }
                this.a.G();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NadRewardCountDownView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardVideoView f27854b;

        public c(NadRewardVideoView nadRewardVideoView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27854b = nadRewardVideoView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void a() {
            p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pVar = this.f27854b.r) == null) {
                return;
            }
            pVar.resume();
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void b() {
            p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pVar = this.f27854b.r) == null) {
                return;
            }
            pVar.pause();
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.a0.l0.t.b bVar = this.f27854b.o;
                if (bVar != null) {
                    bVar.h(this.a);
                }
                this.f27854b.j();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                c.a.a0.l0.t.b bVar = this.f27854b.o;
                if (bVar != null) {
                    bVar.g(true, this.a);
                }
                this.f27854b.j();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f27854b.r.isPlaying()) {
                this.f27854b.r.stop();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void g() {
            p pVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (pVar = this.f27854b.r) != null && pVar.isPause()) {
                this.f27854b.r.resume();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public abstract void G();

    public abstract void H();

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.dispatchWindowVisibilityChanged(i);
            if (this.r == null) {
                return;
            }
            boolean z = i == 0;
            if (z && this.r.isPause()) {
                this.r.resume();
            }
            if (z || !this.r.isPlaying()) {
                return;
            }
            this.r.pause();
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.j();
            p pVar = this.r;
            if (pVar != null) {
                pVar.release();
                this.r = null;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void m(LayoutInflater layoutInflater, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, layoutInflater, sVar) == null) {
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.s = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091a81);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void q(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            super.q(adBaseModel);
            this.n.setRewardDownInnerListener(new c(this, adBaseModel));
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void r(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            if ((adBaseModel instanceof q) && adBaseModel.j != null) {
                if (this.s != null) {
                    c.a.a0.v.q qVar = new c.a.a0.v.q();
                    qVar.a = 2;
                    if (this.r == null) {
                        this.r = p.a.b(getContext(), 0, qVar);
                    }
                    c.a.a0.v.s0.a aVar = new c.a.a0.v.s0.a();
                    aVar.i(2);
                    aVar.j(false);
                    aVar.k(true);
                    this.r.d(aVar);
                    this.r.attachToContainer(this.s);
                    this.r.c(adBaseModel.j);
                    this.r.a(this.q);
                    s sVar = adBaseModel.p;
                    if (sVar != null) {
                        this.r.mute(sVar.f1576h);
                    }
                    this.r.start();
                }
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void s(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i, s sVar) {
        super(context, attributeSet, i, sVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), sVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (s) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        NadRewardVolumeView nadRewardVolumeView = (NadRewardVolumeView) findViewById(R.id.obfuscated_res_0x7f0914de);
        this.t = nadRewardVolumeView;
        nadRewardVolumeView.setVolumeListener(new a(this));
        this.q = new b(this);
    }
}
