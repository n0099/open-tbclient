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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.feed.AdFeedBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b51;
import com.repackage.fq0;
import com.repackage.hi0;
import com.repackage.io0;
import com.repackage.jq0;
import com.repackage.lo0;
/* loaded from: classes2.dex */
public class PortraitVideoView extends AdFeedBaseView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fq0 i;
    public NadVideoAdOverContainer j;
    public ImageView k;
    public ViewGroup l;
    public final jq0 m;

    /* loaded from: classes2.dex */
    public class a extends jq0 {
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

        @Override // com.repackage.jq0, com.repackage.cq0
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                    this.a.b.f((AdBaseModel) this.a.getTag());
                }
                this.a.C();
            }
        }

        @Override // com.repackage.jq0, com.repackage.cq0
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.e((AdBaseModel) this.a.getTag(), str);
            }
        }

        @Override // com.repackage.jq0, com.repackage.cq0
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.c((AdBaseModel) this.a.getTag());
            }
        }

        @Override // com.repackage.jq0, com.repackage.cq0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.d((AdBaseModel) this.a.getTag());
            }
        }

        @Override // com.repackage.jq0, com.repackage.cq0
        public void onResume() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.a((AdBaseModel) this.a.getTag());
            }
        }

        @Override // com.repackage.jq0, com.repackage.cq0
        public void onStart() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.b != null && (this.a.getTag() instanceof AdBaseModel)) {
                this.a.b.b((AdBaseModel) this.a.getTag());
            }
        }
    }

    /* loaded from: classes2.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b51 a;
        public final /* synthetic */ PortraitVideoView b;

        public c(PortraitVideoView portraitVideoView, b51 b51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {portraitVideoView, b51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = portraitVideoView;
            this.a = b51Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.b.getTag() instanceof AdBaseModel)) {
                this.a.b((AdBaseModel) this.b.getTag());
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
        fq0 fq0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fq0Var = this.i) != null && fq0Var.isPlaying()) {
            this.i.pause();
            this.k.setVisibility(0);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.setVisibility(0);
            fq0 fq0Var = this.i;
            if (fq0Var != null) {
                fq0Var.start();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.d("PortraitVideoView", "start to showTailFrame");
            this.j.v(true);
            this.l.setVisibility(4);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.j.s()) {
                w();
            }
            fq0 fq0Var = this.i;
            if (fq0Var != null) {
                if (fq0Var.isPause()) {
                    this.i.resume();
                } else {
                    this.i.start();
                }
                this.k.setVisibility(4);
            }
        }
    }

    public void E(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adBaseModel) == null) {
            this.j.setVisibility(0);
            this.j.setData(adBaseModel);
            this.j.setTag(R.id.obfuscated_res_0x7f0914cc, adBaseModel);
        }
    }

    public void F(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adBaseModel) == null) {
            x();
            this.j.setOnNewTailFrameReplayClickListener(new b(this));
            if (this.i == null) {
                fq0 a2 = fq0.a.a(hi0.b(), 0);
                this.i = a2;
                a2.a(this.m);
            }
            io0 io0Var = adBaseModel.j;
            if (io0Var != null) {
                this.i.c(io0Var);
            }
            this.i.attachToContainer(this.l);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchVisibilityChanged(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, view2, i) == null) {
            super.dispatchVisibilityChanged(view2, i);
            if (i == 0) {
                if (this.i != null) {
                    D();
                    return;
                }
                return;
            }
            fq0 fq0Var = this.i;
            if (fq0Var == null || !fq0Var.isPlaying()) {
                return;
            }
            A();
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0914e0 || view2.getId() == R.id.obfuscated_res_0x7f092335) {
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
    public void setViewStatChangeListener(b51 b51Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b51Var) == null) {
            super.setViewStatChangeListener(b51Var);
            this.j.setOnUiClickListener(new c(this, b51Var));
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adBaseModel) == null) {
            super.update(adBaseModel);
            E(adBaseModel);
            F(adBaseModel);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.j.v(false);
            this.l.setVisibility(0);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.j.s()) {
            w();
            B();
        }
    }

    public void y(LayoutInflater layoutInflater, lo0 lo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, layoutInflater, lo0Var) == null) {
            layoutInflater.inflate((lo0Var == null || lo0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO) == 0) ? R.layout.obfuscated_res_0x7f0d05c7 : lo0Var.a(AdBaseModel.STYLE.PORTRAIT_VIDEO), this);
        }
    }

    public void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            NadVideoAdOverContainer nadVideoAdOverContainer = (NadVideoAdOverContainer) findViewById(R.id.obfuscated_res_0x7f0914e0);
            this.j = nadVideoAdOverContainer;
            nadVideoAdOverContainer.setOnClickListener(this);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f092335);
            this.k = imageView;
            imageView.setOnClickListener(this);
            this.l = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914cd);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (lo0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortraitVideoView(Context context, AttributeSet attributeSet, int i, lo0 lo0Var) {
        super(context, attributeSet, i, lo0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), lo0Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (lo0) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        y(LayoutInflater.from(context), lo0Var);
        z(context);
        this.m = new a(this);
    }
}
