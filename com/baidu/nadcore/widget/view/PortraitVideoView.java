package com.baidu.nadcore.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.s.s;
import c.a.a0.v.p;
import c.a.a0.v.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p i;
    public NadVideoAdOverContainer j;
    public ImageView k;
    public ViewGroup l;
    public final t m;

    /* loaded from: classes4.dex */
    public class a extends t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PortraitVideoView a;

        public a(PortraitVideoView portraitVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = portraitVideoView;
        }

        @Override // c.a.a0.v.i
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.f27780b.f((AdBaseModel) this.a.getTag());
                }
                this.a.B();
            }
        }

        @Override // c.a.a0.v.i
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) && this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.f27780b.e((AdBaseModel) this.a.getTag(), str);
            }
        }

        @Override // c.a.a0.v.i
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.f27780b.c((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.a0.v.i
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.f27780b.d((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.a0.v.i
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.f27780b.a((AdBaseModel) this.a.getTag());
            }
        }

        @Override // c.a.a0.v.i
        public void onStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.f27780b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.f27780b.b((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PortraitVideoView a;

        public b(PortraitVideoView portraitVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = portraitVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.l0.r.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PortraitVideoView f27855b;

        public c(PortraitVideoView portraitVideoView, c.a.a0.l0.r.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27855b = portraitVideoView;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f27855b.getTag() instanceof AdBaseModel)) {
                this.a.b((AdBaseModel) this.f27855b.getTag());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortraitVideoView(Context context) {
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

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.setVisibility(0);
            p pVar = this.i;
            if (pVar != null) {
                pVar.start();
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Log.d("PortraitVideoView", "start to showTailFrame");
            this.j.v(true);
            this.l.setVisibility(4);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.j.s()) {
                v();
            }
            p pVar = this.i;
            if (pVar != null) {
                if (pVar.isPause()) {
                    this.i.resume();
                } else {
                    this.i.start();
                }
                this.k.setVisibility(4);
            }
        }
    }

    public void D(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) {
            this.j.setVisibility(0);
            this.j.setData(adBaseModel);
            this.j.setTag(R.id.obfuscated_res_0x7f0914d0, adBaseModel);
        }
    }

    public void E(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adBaseModel) == null) {
            w();
            this.j.setOnNewTailFrameReplayClickListener(new b(this));
            if (this.i == null) {
                p a2 = p.a.a(c.a.a0.h.a.b(), 0);
                this.i = a2;
                a2.a(this.m);
            }
            c.a.a0.s.p pVar = adBaseModel.j;
            if (pVar != null) {
                this.i.c(pVar);
            }
            this.i.attachToContainer(this.l);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchVisibilityChanged(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, view, i) == null) {
            super.dispatchVisibilityChanged(view, i);
            if (i == 0) {
                if (this.i != null) {
                    C();
                    return;
                }
                return;
            }
            p pVar = this.i;
            if (pVar == null || !pVar.isPlaying()) {
                return;
            }
            z();
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f0914e4 || view.getId() == R.id.obfuscated_res_0x7f092357) {
                Log.d("PortraitVideoView", "onclick area： cover");
                if (this.i.isPlaying()) {
                    this.i.pause();
                    this.k.setVisibility(0);
                    return;
                }
                this.i.resume();
                this.k.setVisibility(4);
            }
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void setViewStatChangeListener(c.a.a0.l0.r.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            super.setViewStatChangeListener(bVar);
            this.j.setOnUiClickListener(new c(this, bVar));
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adBaseModel) == null) {
            super.update(adBaseModel);
            D(adBaseModel);
            E(adBaseModel);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.j.v(false);
            this.l.setVisibility(0);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.j.s()) {
            v();
            A();
        }
    }

    public void x(LayoutInflater layoutInflater, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, layoutInflater, sVar) == null) {
            layoutInflater.inflate((sVar == null || sVar.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) == 0) ? R.layout.obfuscated_res_0x7f0d05c5 : sVar.a(AdBaseModel.STYLE.PORTRAIT_VIDEO), this);
        }
    }

    public void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            NadVideoAdOverContainer nadVideoAdOverContainer = (NadVideoAdOverContainer) findViewById(R.id.obfuscated_res_0x7f0914e4);
            this.j = nadVideoAdOverContainer;
            nadVideoAdOverContainer.setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f092357);
            this.k = imageView;
            imageView.setOnClickListener(this);
            this.l = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914d1);
        }
    }

    public void z() {
        p pVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (pVar = this.i) != null && pVar.isPlaying()) {
            this.i.pause();
            this.k.setVisibility(0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortraitVideoView(Context context, AttributeSet attributeSet) {
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
    public PortraitVideoView(Context context, AttributeSet attributeSet, int i) {
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
    public PortraitVideoView(Context context, AttributeSet attributeSet, int i, s sVar) {
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
        x(LayoutInflater.from(context), sVar);
        y(context);
        this.m = new a(this);
    }
}
