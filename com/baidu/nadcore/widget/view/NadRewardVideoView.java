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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cw0;
import com.repackage.g41;
import com.repackage.qw0;
import com.repackage.so0;
import com.repackage.to0;
import com.repackage.wm0;
import com.repackage.wo0;
import com.repackage.ym0;
/* loaded from: classes2.dex */
public abstract class NadRewardVideoView extends NadRewardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wo0 q;
    public so0 r;
    public ViewGroup s;
    public NadRewardVolumeView t;

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
            so0 so0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (so0Var = this.a.r) == null) {
                return;
            }
            so0Var.mute(z);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends wo0 {
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

        @Override // com.repackage.wo0, com.repackage.po0
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.t == null) {
                return;
            }
            this.a.t.setVolumeState(qw0.c(this.a.getContext()) <= 0);
        }

        @Override // com.repackage.wo0, com.repackage.po0
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
                this.a.I();
                NadRewardCountDownView nadRewardCountDownView = this.a.n;
                if (nadRewardCountDownView != null) {
                    nadRewardCountDownView.u();
                    this.a.n.bringToFront();
                }
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091479);
                if (findViewById != null) {
                    findViewById.bringToFront();
                }
            }
        }

        @Override // com.repackage.wo0, com.repackage.po0
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

        @Override // com.repackage.wo0, com.repackage.po0
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.c((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o == null || !(nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                NadRewardVideoView nadRewardVideoView2 = this.a;
                nadRewardVideoView2.o.c((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // com.repackage.wo0, com.repackage.po0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.d((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o == null || !(nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                NadRewardVideoView nadRewardVideoView2 = this.a;
                nadRewardVideoView2.o.d((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // com.repackage.wo0, com.repackage.po0
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.a((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.o == null || !(nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                NadRewardVideoView nadRewardVideoView2 = this.a;
                nadRewardVideoView2.o.a((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // com.repackage.wo0, com.repackage.po0
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
                    if (qw0.c(this.a.getContext()) <= 0) {
                        this.a.t.setVolumeState(true);
                    }
                    this.a.t.setVisibility(0);
                }
                this.a.H();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements NadRewardCountDownView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ NadRewardVideoView b;

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
            so0 so0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (so0Var = this.b.r) == null) {
                return;
            }
            so0Var.resume();
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void b() {
            so0 so0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (so0Var = this.b.r) == null) {
                return;
            }
            so0Var.pause();
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g41 g41Var = this.b.o;
                if (g41Var != null) {
                    g41Var.h(this.a);
                }
                this.b.j();
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
                g41 g41Var = this.b.o;
                if (g41Var != null) {
                    g41Var.g(true, this.a);
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
            so0 so0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (so0Var = this.b.r) != null && so0Var.isPause()) {
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

    public abstract void H();

    public abstract void I();

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
            so0 so0Var = this.r;
            if (so0Var != null) {
                so0Var.release();
                this.r = null;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void m(LayoutInflater layoutInflater, ym0 ym0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, layoutInflater, ym0Var) == null) {
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.s = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091a6f);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void r(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            super.r(adBaseModel);
            this.n.setRewardDownInnerListener(new c(this, adBaseModel));
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void s(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            if ((adBaseModel instanceof wm0) && adBaseModel.j != null) {
                if (this.s != null) {
                    to0 to0Var = new to0();
                    to0Var.a = 2;
                    if (this.r == null) {
                        this.r = so0.a.b(getContext(), 0, to0Var);
                    }
                    cw0 cw0Var = new cw0();
                    cw0Var.j(2);
                    cw0Var.l(false);
                    cw0Var.n(true);
                    this.r.d(cw0Var);
                    this.r.attachToContainer(this.s);
                    this.r.c(adBaseModel.j);
                    this.r.a(this.q);
                    ym0 ym0Var = adBaseModel.p;
                    if (ym0Var != null) {
                        this.r.mute(ym0Var.h);
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
    public void t(AdBaseModel adBaseModel) {
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (ym0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i, ym0 ym0Var) {
        super(context, attributeSet, i, ym0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), ym0Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (ym0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        NadRewardVolumeView nadRewardVolumeView = (NadRewardVolumeView) findViewById(R.id.obfuscated_res_0x7f0914b8);
        this.t = nadRewardVolumeView;
        nadRewardVolumeView.setVolumeListener(new a(this));
        this.q = new b(this);
    }
}
