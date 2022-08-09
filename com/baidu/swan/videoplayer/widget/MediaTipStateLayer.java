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
/* loaded from: classes3.dex */
public class MediaTipStateLayer implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public SwanVideoView b;
    public View c;
    public View d;
    public View e;
    public TextView f;
    public TextView g;
    public TipState h;
    public ImageView i;
    public TextView j;
    public ImageView k;
    public boolean l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            this.b = swanVideoView;
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public TipState c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : (TipState) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.k.setOnClickListener(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d081a, (ViewGroup) null, false);
            this.c = inflate;
            this.e = inflate.findViewById(R.id.obfuscated_res_0x7f091f8e);
            this.k = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091f87);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091f76);
            this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091f77);
            this.d = this.c.findViewById(R.id.obfuscated_res_0x7f091f96);
            this.i = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091f95);
            this.j = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091f97);
            h(TipState.NORMAL);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Resources resources = this.a.getResources();
            TipState tipState = this.h;
            if (tipState == TipState.ERROR) {
                this.i.setImageResource(R.drawable.obfuscated_res_0x7f0811b6);
                this.j.setText(this.a.getText(R.string.obfuscated_res_0x7f0f1322));
                this.c.setVisibility(0);
                this.d.setVisibility(0);
                this.e.setVisibility(8);
            } else if (tipState == TipState.NO_WIFI) {
                this.c.setVisibility(0);
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                this.g.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060aa7));
                this.g.setText(R.string.obfuscated_res_0x7f0f1317);
                this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f0811ad);
            } else if (tipState == TipState.NO_NETWORK) {
                this.c.setVisibility(0);
                this.d.setVisibility(8);
                this.e.setVisibility(0);
                this.g.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060aa6));
                this.g.setText(R.string.obfuscated_res_0x7f0f1319);
                this.f.setText(R.string.obfuscated_res_0x7f0f1314);
                this.f.setBackgroundResource(R.drawable.obfuscated_res_0x7f0811ac);
            } else if (tipState == TipState.END) {
                this.i.setImageResource(R.drawable.obfuscated_res_0x7f0811b7);
                this.j.setText(this.a.getText(R.string.obfuscated_res_0x7f0f1323));
                this.c.setVisibility(0);
                this.d.setVisibility(0);
                this.e.setVisibility(8);
            } else if (tipState == TipState.NORMAL) {
                this.c.setVisibility(8);
                this.e.setVisibility(8);
                this.d.setVisibility(8);
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
            this.h = tipState;
            f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091f76 || id == R.id.obfuscated_res_0x7f091f96) {
                SwanVideoView swanVideoView2 = this.b;
                if (swanVideoView2 != null) {
                    swanVideoView2.Y();
                }
                h(TipState.NORMAL);
            } else if (id != R.id.obfuscated_res_0x7f091f87 || (swanVideoView = this.b) == null || swanVideoView.getVideoPlayerCallback() == null) {
            } else {
                this.b.getVideoPlayerCallback().d(!this.l);
            }
        }
    }
}
