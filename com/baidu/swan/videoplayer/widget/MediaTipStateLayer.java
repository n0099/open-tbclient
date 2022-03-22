package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MediaTipStateLayer implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public SwanVideoView f29757b;

    /* renamed from: c  reason: collision with root package name */
    public View f29758c;

    /* renamed from: d  reason: collision with root package name */
    public View f29759d;

    /* renamed from: e  reason: collision with root package name */
    public View f29760e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f29761f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f29762g;

    /* renamed from: h  reason: collision with root package name */
    public TipState f29763h;
    public ImageView i;
    public TextView j;
    public ImageView k;
    public boolean l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class TipState {
        public static final /* synthetic */ TipState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TipState END;
        public static final TipState ERROR;
        public static final TipState NORMAL;
        public static final TipState NO_NETWORK;
        public static final TipState NO_WIFI;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(974514336, "Lcom/baidu/swan/videoplayer/widget/MediaTipStateLayer$TipState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(974514336, "Lcom/baidu/swan/videoplayer/widget/MediaTipStateLayer$TipState;");
                    return;
                }
            }
            NORMAL = new TipState("NORMAL", 0);
            ERROR = new TipState("ERROR", 1);
            NO_WIFI = new TipState("NO_WIFI", 2);
            NO_NETWORK = new TipState("NO_NETWORK", 3);
            TipState tipState = new TipState("END", 4);
            END = tipState;
            $VALUES = new TipState[]{NORMAL, ERROR, NO_WIFI, NO_NETWORK, tipState};
        }

        public TipState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TipState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TipState) Enum.valueOf(TipState.class, str) : (TipState) invokeL.objValue;
        }

        public static TipState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TipState[]) $VALUES.clone() : (TipState[]) invokeV.objValue;
        }
    }

    public MediaTipStateLayer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        e();
        d();
    }

    public void a(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.f29757b = swanVideoView;
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29758c : (View) invokeV.objValue;
    }

    public TipState c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29763h : (TipState) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f29761f.setOnClickListener(this);
            this.f29759d.setOnClickListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07e6, (ViewGroup) null, false);
            this.f29758c = inflate;
            this.f29760e = inflate.findViewById(R.id.obfuscated_res_0x7f091e0e);
            this.k = (ImageView) this.f29758c.findViewById(R.id.obfuscated_res_0x7f091e07);
            this.f29761f = (TextView) this.f29758c.findViewById(R.id.obfuscated_res_0x7f091df6);
            this.f29762g = (TextView) this.f29758c.findViewById(R.id.obfuscated_res_0x7f091df7);
            this.f29759d = this.f29758c.findViewById(R.id.obfuscated_res_0x7f091e16);
            this.i = (ImageView) this.f29758c.findViewById(R.id.obfuscated_res_0x7f091e15);
            this.j = (TextView) this.f29758c.findViewById(R.id.obfuscated_res_0x7f091e17);
            h(TipState.NORMAL);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Resources resources = this.a.getResources();
            TipState tipState = this.f29763h;
            if (tipState == TipState.ERROR) {
                this.i.setImageResource(R.drawable.obfuscated_res_0x7f0811a8);
                this.j.setText(this.a.getText(R.string.obfuscated_res_0x7f0f12f7));
                this.f29758c.setVisibility(0);
                this.f29759d.setVisibility(0);
                this.f29760e.setVisibility(8);
            } else if (tipState == TipState.NO_WIFI) {
                this.f29758c.setVisibility(0);
                this.f29759d.setVisibility(8);
                this.f29760e.setVisibility(0);
                this.f29762g.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a8e));
                this.f29762g.setText(R.string.obfuscated_res_0x7f0f12ec);
                this.f29761f.setBackgroundResource(R.drawable.obfuscated_res_0x7f08119f);
            } else if (tipState == TipState.NO_NETWORK) {
                this.f29758c.setVisibility(0);
                this.f29759d.setVisibility(8);
                this.f29760e.setVisibility(0);
                this.f29762g.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a8d));
                this.f29762g.setText(R.string.obfuscated_res_0x7f0f12ee);
                this.f29761f.setText(R.string.obfuscated_res_0x7f0f12e9);
                this.f29761f.setBackgroundResource(R.drawable.obfuscated_res_0x7f08119e);
            } else if (tipState == TipState.END) {
                this.i.setImageResource(R.drawable.obfuscated_res_0x7f0811a9);
                this.j.setText(this.a.getText(R.string.obfuscated_res_0x7f0f12f8));
                this.f29758c.setVisibility(0);
                this.f29759d.setVisibility(0);
                this.f29760e.setVisibility(8);
            } else if (tipState == TipState.NORMAL) {
                this.f29758c.setVisibility(8);
                this.f29760e.setVisibility(8);
                this.f29759d.setVisibility(8);
            }
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
            this.k.setVisibility(z ? 0 : 8);
        }
    }

    public void h(TipState tipState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tipState) == null) {
            this.f29763h = tipState;
            f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f091df6 || id == R.id.obfuscated_res_0x7f091e16) {
                SwanVideoView swanVideoView2 = this.f29757b;
                if (swanVideoView2 != null) {
                    swanVideoView2.Y();
                }
                h(TipState.NORMAL);
            } else if (id != R.id.obfuscated_res_0x7f091e07 || (swanVideoView = this.f29757b) == null || swanVideoView.getVideoPlayerCallback() == null) {
            } else {
                this.f29757b.getVideoPlayerCallback().d(!this.l);
            }
        }
    }
}
