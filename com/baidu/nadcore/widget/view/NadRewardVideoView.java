package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView;
import com.baidu.nadcore.widget.uitemplate.NadRewardVolumeView;
import com.baidu.tieba.R;
import com.baidu.tieba.bq0;
import com.baidu.tieba.bs0;
import com.baidu.tieba.cs0;
import com.baidu.tieba.dq0;
import com.baidu.tieba.fs0;
import com.baidu.tieba.lz0;
import com.baidu.tieba.o81;
import com.baidu.tieba.zz0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class NadRewardVideoView extends NadRewardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fs0 q;
    public bs0 r;
    public ViewGroup s;
    public NadRewardVolumeView t;

    public abstract void G();

    public abstract void H();

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void m(LayoutInflater layoutInflater, dq0 dq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, layoutInflater, dq0Var) == null) {
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void s(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) {
        }
    }

    /* loaded from: classes2.dex */
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
            bs0 bs0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (bs0Var = this.a.r) != null) {
                bs0Var.mute(z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends fs0 {
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

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void a(int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.t == null) {
                return;
            }
            NadRewardVolumeView nadRewardVolumeView = this.a.t;
            if (zz0.c(this.a.getContext()) <= 0) {
                z = true;
            } else {
                z = false;
            }
            nadRewardVolumeView.setVolumeState(z);
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.f((AdBaseModel) this.a.getTag());
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
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f09160b);
                if (findViewById != null) {
                    findViewById.bringToFront();
                }
            }
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.e((AdBaseModel) this.a.getTag(), str);
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

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.c((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.o.c((AdBaseModel) nadRewardVideoView2.getTag());
                }
            }
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.d((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.o.d((AdBaseModel) nadRewardVideoView2.getTag());
                }
            }
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.a((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.o.a((AdBaseModel) nadRewardVideoView2.getTag());
                }
            }
        }

        @Override // com.baidu.tieba.fs0, com.baidu.tieba.yr0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.b((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.o.b((AdBaseModel) nadRewardVideoView2.getTag());
                }
                if (this.a.t != null && (this.a.getTag() instanceof AdBaseModel)) {
                    AdBaseModel adBaseModel = (AdBaseModel) this.a.getTag();
                    if (adBaseModel.p != null) {
                        this.a.t.setVolumeState(adBaseModel.p.h);
                    }
                    if (zz0.c(this.a.getContext()) <= 0) {
                        this.a.t.setVolumeState(true);
                    }
                    this.a.t.setVisibility(0);
                }
                this.a.G();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements NadRewardCountDownView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ NadRewardVideoView b;

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

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
            this.b = nadRewardVideoView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void a() {
            bs0 bs0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bs0Var = this.b.r) != null) {
                bs0Var.resume();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void b() {
            bs0 bs0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bs0Var = this.b.r) != null) {
                bs0Var.pause();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                o81 o81Var = this.b.o;
                if (o81Var != null) {
                    o81Var.h(this.a);
                }
                this.b.j();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                o81 o81Var = this.b.o;
                if (o81Var != null) {
                    o81Var.g(true, this.a);
                }
                this.b.j();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b.r.isPlaying()) {
                this.b.r.stop();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void g() {
            bs0 bs0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (bs0Var = this.b.r) != null && bs0Var.isPause()) {
                this.b.r.resume();
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.dispatchWindowVisibilityChanged(i);
            if (this.r == null) {
                return;
            }
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && this.r.isPause()) {
                this.r.resume();
            }
            if (!z && this.r.isPlaying()) {
                this.r.pause();
            }
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (dq0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i, dq0 dq0Var) {
        super(context, attributeSet, i, dq0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), dq0Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (dq0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        NadRewardVolumeView nadRewardVolumeView = (NadRewardVolumeView) findViewById(R.id.obfuscated_res_0x7f09164c);
        this.t = nadRewardVolumeView;
        nadRewardVolumeView.setVolumeListener(new a(this));
        this.q = new b(this);
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.s = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091c62);
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
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.j();
            bs0 bs0Var = this.r;
            if (bs0Var != null) {
                bs0Var.release();
                this.r = null;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void r(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            if ((adBaseModel instanceof bq0) && adBaseModel.j != null) {
                if (this.s != null) {
                    cs0 cs0Var = new cs0();
                    cs0Var.a = 2;
                    if (this.r == null) {
                        this.r = bs0.a.b(getContext(), 0, cs0Var);
                    }
                    lz0 lz0Var = new lz0();
                    lz0Var.j(2);
                    lz0Var.l(false);
                    lz0Var.n(true);
                    this.r.d(lz0Var);
                    this.r.attachToContainer(this.s);
                    this.r.c(adBaseModel.j);
                    this.r.a(this.q);
                    dq0 dq0Var = adBaseModel.p;
                    if (dq0Var != null) {
                        this.r.mute(dq0Var.h);
                    }
                    this.r.start();
                }
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }
}
