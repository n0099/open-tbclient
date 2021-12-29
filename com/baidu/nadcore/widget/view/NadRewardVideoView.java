package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.b.e;
import c.a.c0.p.m;
import c.a.c0.p.o;
import c.a.c0.s.p;
import c.a.c0.s.q;
import c.a.c0.s.t;
import c.a.c0.s.v0.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView;
import com.baidu.nadcore.widget.uitemplate.NadRewardVolumeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public abstract class NadRewardVideoView extends NadRewardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final t f38662h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f38663i;

    /* renamed from: j  reason: collision with root package name */
    public NadRewardVolumeView f38664j;
    public p mPlayer;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (pVar = this.a.mPlayer) == null) {
                return;
            }
            pVar.mute(z);
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoView;
        }

        @Override // c.a.c0.s.t, c.a.c0.s.i
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f38664j == null) {
                return;
            }
            this.a.f38664j.setVolumeState(k.c(this.a.getContext()) <= 0);
        }

        @Override // c.a.c0.s.i
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                if (this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.mVideoMediaListener.f((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.mRewardMediaListener != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.mRewardMediaListener.f((AdBaseModel) nadRewardVideoView2.getTag());
                }
                if (this.a.f38664j != null) {
                    this.a.f38664j.setVisibility(8);
                }
                this.a.showTailFrame();
                NadRewardCountDownView nadRewardCountDownView = this.a.mSkipButton;
                if (nadRewardCountDownView != null) {
                    nadRewardCountDownView.startTailFrameCountDown();
                    this.a.mSkipButton.bringToFront();
                }
                View findViewById = this.a.findViewById(e.nad_base_delete_id);
                if (findViewById != null) {
                    findViewById.bringToFront();
                }
            }
        }

        @Override // c.a.c0.s.i
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
                if (this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.mVideoMediaListener.e((AdBaseModel) this.a.getTag(), str);
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.mRewardMediaListener != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.mRewardMediaListener.e((AdBaseModel) nadRewardVideoView2.getTag(), str);
                }
                if (this.a.f38664j != null) {
                    this.a.f38664j.setVisibility(8);
                }
            }
        }

        @Override // c.a.c0.s.i
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.mVideoMediaListener.c((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.mRewardMediaListener == null || !(nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                NadRewardVideoView nadRewardVideoView2 = this.a;
                nadRewardVideoView2.mRewardMediaListener.c((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // c.a.c0.s.i
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.mVideoMediaListener.d((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.mRewardMediaListener == null || !(nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                NadRewardVideoView nadRewardVideoView2 = this.a;
                nadRewardVideoView2.mRewardMediaListener.d((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // c.a.c0.s.i
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.mVideoMediaListener.a((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.mRewardMediaListener == null || !(nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    return;
                }
                NadRewardVideoView nadRewardVideoView2 = this.a;
                nadRewardVideoView2.mRewardMediaListener.a((AdBaseModel) nadRewardVideoView2.getTag());
            }
        }

        @Override // c.a.c0.s.i
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.a.mVideoMediaListener != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.mVideoMediaListener.b((AdBaseModel) this.a.getTag());
                }
                NadRewardVideoView nadRewardVideoView = this.a;
                if (nadRewardVideoView.mRewardMediaListener != null && (nadRewardVideoView.getTag() instanceof AdBaseModel)) {
                    NadRewardVideoView nadRewardVideoView2 = this.a;
                    nadRewardVideoView2.mRewardMediaListener.b((AdBaseModel) nadRewardVideoView2.getTag());
                }
                if (this.a.f38664j != null && (this.a.getTag() instanceof AdBaseModel)) {
                    AdBaseModel adBaseModel = (AdBaseModel) this.a.getTag();
                    if (adBaseModel.l != null) {
                        this.a.f38664j.setVolumeState(adBaseModel.l.f2251f);
                    }
                    if (k.c(this.a.getContext()) <= 0) {
                        this.a.f38664j.setVolumeState(true);
                    }
                    this.a.f38664j.setVisibility(0);
                }
                this.a.hideTailFrame();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements NadRewardCountDownView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NadRewardVideoView f38665b;

        public c(NadRewardVideoView nadRewardVideoView, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoView, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38665b = nadRewardVideoView;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.c0.h0.e0.a aVar = this.f38665b.mRewardMediaListener;
                if (aVar != null) {
                    aVar.h(this.a);
                }
                this.f38665b.detach();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void b() {
            p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pVar = this.f38665b.mPlayer) == null) {
                return;
            }
            pVar.resume();
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                c.a.c0.h0.e0.a aVar = this.f38665b.mRewardMediaListener;
                if (aVar != null) {
                    aVar.g(true, this.a);
                }
                this.f38665b.detach();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f38665b.mPlayer.isPlaying()) {
                this.f38665b.mPlayer.stop();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void f() {
            p pVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (pVar = this.f38665b.mPlayer) != null && pVar.isPause()) {
                this.f38665b.mPlayer.resume();
            }
        }

        @Override // com.baidu.nadcore.widget.uitemplate.NadRewardCountDownView.g
        public void g() {
            p pVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pVar = this.f38665b.mPlayer) == null) {
                return;
            }
            pVar.pause();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.detach();
            p pVar = this.mPlayer;
            if (pVar != null) {
                pVar.release();
                this.mPlayer = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.dispatchWindowVisibilityChanged(i2);
            if (this.mPlayer == null) {
                return;
            }
            boolean z = i2 == 0;
            if (z && this.mPlayer.isPause()) {
                this.mPlayer.resume();
            }
            if (z || !this.mPlayer.isPlaying()) {
                return;
            }
            this.mPlayer.pause();
        }
    }

    public abstract void hideTailFrame();

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void initInflate(LayoutInflater layoutInflater, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, layoutInflater, oVar) == null) {
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void initLayout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f38663i = (ViewGroup) findViewById(e.reward_ad_video_container);
        }
    }

    public abstract void showTailFrame();

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void updateSkipButton(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adBaseModel) == null) {
            super.updateSkipButton(adBaseModel);
            this.mSkipButton.setRewardDownInnerListener(new c(this, adBaseModel));
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void updateSubViewData(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adBaseModel) == null) {
            if ((adBaseModel instanceof m) && adBaseModel.f38223h != null) {
                if (this.f38663i != null) {
                    q qVar = new q();
                    qVar.a = 2;
                    if (this.mPlayer == null) {
                        this.mPlayer = p.a.b(getContext(), 0, qVar);
                    }
                    c.a.c0.s.s0.a aVar = new c.a.c0.s.s0.a();
                    aVar.h(2);
                    aVar.i(false);
                    aVar.j(true);
                    this.mPlayer.d(aVar);
                    this.mPlayer.attachToContainer(this.f38663i);
                    this.mPlayer.c(adBaseModel.f38223h);
                    this.mPlayer.a(this.f38662h);
                    o oVar = adBaseModel.l;
                    if (oVar != null) {
                        this.mPlayer.mute(oVar.f2251f);
                    }
                    this.mPlayer.start();
                }
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    @Override // com.baidu.nadcore.widget.view.NadRewardBaseView
    public void updateSubViewUi(AdBaseModel adBaseModel) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadRewardVideoView(Context context, AttributeSet attributeSet, int i2, o oVar) {
        super(context, attributeSet, i2, oVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), oVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (o) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        NadRewardVolumeView nadRewardVolumeView = (NadRewardVolumeView) findViewById(e.nad_reward_volumn_icon);
        this.f38664j = nadRewardVolumeView;
        nadRewardVolumeView.setVolumeListener(new a(this));
        this.f38662h = new b(this);
    }
}
