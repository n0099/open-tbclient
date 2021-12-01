package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.y.c;
import c.a.p0.y.e;
import c.a.p0.y.f;
import c.a.p0.y.g;
import c.a.p0.y.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class MediaTipStateLayer implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f40795e;

    /* renamed from: f  reason: collision with root package name */
    public SwanVideoView f40796f;

    /* renamed from: g  reason: collision with root package name */
    public View f40797g;

    /* renamed from: h  reason: collision with root package name */
    public View f40798h;

    /* renamed from: i  reason: collision with root package name */
    public View f40799i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f40800j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f40801k;
    public TipState l;
    public ImageView m;
    public TextView n;
    public ImageView o;
    public boolean p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

        public TipState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40795e = context;
        e();
        d();
    }

    public void a(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanVideoView) == null) {
            this.f40796f = swanVideoView;
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40797g : (View) invokeV.objValue;
    }

    public TipState c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (TipState) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f40800j.setOnClickListener(this);
            this.f40798h.setOnClickListener(this);
            this.o.setOnClickListener(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.f40795e).inflate(g.swanapp_video_occur_error, (ViewGroup) null, false);
            this.f40797g = inflate;
            this.f40799i = inflate.findViewById(f.swanapp_video_no_wifi);
            this.o = (ImageView) this.f40797g.findViewById(f.swanapp_video_full_screen_back);
            this.f40800j = (TextView) this.f40797g.findViewById(f.swanapp_video_continue_play);
            this.f40801k = (TextView) this.f40797g.findViewById(f.swanapp_video_continue_play_text);
            this.f40798h = this.f40797g.findViewById(f.swanapp_video_replay);
            this.m = (ImageView) this.f40797g.findViewById(f.swanapp_video_relay_img);
            this.n = (TextView) this.f40797g.findViewById(f.swanapp_video_replay_text);
            h(TipState.NORMAL);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Resources resources = this.f40795e.getResources();
            TipState tipState = this.l;
            if (tipState == TipState.ERROR) {
                this.m.setImageResource(e.swanapp_video_refresh);
                this.n.setText(this.f40795e.getText(h.swanapp_video_refresh));
                this.f40797g.setVisibility(0);
                this.f40798h.setVisibility(0);
                this.f40799i.setVisibility(8);
            } else if (tipState == TipState.NO_WIFI) {
                this.f40797g.setVisibility(0);
                this.f40798h.setVisibility(8);
                this.f40799i.setVisibility(0);
                this.f40801k.setTextColor(resources.getColor(c.swanapp_video_no_wifi_text_color));
                this.f40801k.setText(h.swanapp_video_error_no_wifi);
                this.f40800j.setBackgroundResource(e.swanapp_video_continue_play);
            } else if (tipState == TipState.NO_NETWORK) {
                this.f40797g.setVisibility(0);
                this.f40798h.setVisibility(8);
                this.f40799i.setVisibility(0);
                this.f40801k.setTextColor(resources.getColor(c.swanapp_video_no_network_text_color));
                this.f40801k.setText(h.swanapp_video_network_error);
                this.f40800j.setText(h.swanapp_video_click_retry);
                this.f40800j.setBackgroundResource(e.swanapp_video_click_retry);
            } else if (tipState == TipState.END) {
                this.m.setImageResource(e.swanapp_video_replay);
                this.n.setText(this.f40795e.getText(h.swanapp_video_replay));
                this.f40797g.setVisibility(0);
                this.f40798h.setVisibility(0);
                this.f40799i.setVisibility(8);
            } else if (tipState == TipState.NORMAL) {
                this.f40797g.setVisibility(8);
                this.f40799i.setVisibility(8);
                this.f40798h.setVisibility(8);
            }
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
            this.o.setVisibility(z ? 0 : 8);
        }
    }

    public void h(TipState tipState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tipState) == null) {
            this.l = tipState;
            f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SwanVideoView swanVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            int id = view.getId();
            if (id != f.swanapp_video_continue_play && id != f.swanapp_video_replay) {
                if (id != f.swanapp_video_full_screen_back || (swanVideoView = this.f40796f) == null || swanVideoView.getVideoPlayerCallback() == null) {
                    return;
                }
                this.f40796f.getVideoPlayerCallback().d(!this.p);
                return;
            }
            SwanVideoView swanVideoView2 = this.f40796f;
            if (swanVideoView2 != null) {
                swanVideoView2.startWithFocus();
            }
            h(TipState.NORMAL);
        }
    }
}
