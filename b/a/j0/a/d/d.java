package b.a.j0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.j0.a.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.player.AdVideoView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends b.a.j0.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public static AtomicBoolean n0;
    public static boolean o0;
    public transient /* synthetic */ FieldHolder $fh;
    public AdVideoView c0;
    public AtomicInteger i0;
    public volatile boolean j0;
    public b.a.j0.a.i.a k0;
    public a.InterfaceC0084a l0;
    public a.b m0;

    /* loaded from: classes.dex */
    public class a implements b.a.j0.a.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f3157a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3157a = dVar;
        }

        @Override // b.a.j0.a.i.a
        public void playCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3157a.a0("time_end");
            }
        }

        @Override // b.a.j0.a.i.a
        public void playFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f3157a.a0("video_onError");
            }
        }

        @Override // b.a.j0.a.i.a
        public void playPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f3157a.d0();
            }
        }

        @Override // b.a.j0.a.i.a
        public void playResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f3157a.e0();
            }
        }

        @Override // b.a.j0.a.i.a
        public void renderingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    AdVideoView adVideoView = this.f3157a.c0;
                    adVideoView.getLayoutParams().width = -1;
                    adVideoView.getLayoutParams().height = -1;
                    d.super.C();
                    this.f3157a.K();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.InterfaceC0084a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f3158a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3158a = dVar;
        }

        @Override // b.a.j0.a.i.a.InterfaceC0084a
        public void onDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3158a.c0 != null) {
                        AdVideoView adVideoView = this.f3158a.c0;
                        adVideoView.getLayoutParams().width = 1;
                        adVideoView.getLayoutParams().height = 1;
                    }
                    if (this.f3158a.r != null) {
                        this.f3158a.r.setVisibility(8);
                    }
                    if (this.f3158a.f3127g != null) {
                        this.f3158a.f3127g.setVisibility(8);
                    }
                    if (this.f3158a.f3128h != null) {
                        this.f3158a.f3128h.setVisibility(8);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f3159a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3159a = dVar;
        }

        @Override // b.a.j0.a.i.a.b
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3159a.Z();
            }
        }
    }

    /* renamed from: b.a.j0.a.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0082d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f3160e;

        public View$OnClickListenerC0082d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3160e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3160e.G();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f3161e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3161e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3161e.I();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1189022930, "Lb/a/j0/a/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1189022930, "Lb/a/j0/a/d/d;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i0 = new AtomicInteger(0);
        this.j0 = false;
        this.k0 = new a(this);
        this.l0 = new b(this);
        this.m0 = new c(this);
        this.w = "video";
        try {
            AdVideoView adVideoView = new AdVideoView(this.f3125e);
            this.c0 = adVideoView;
            if (this.K == 17) {
                adVideoView.setDisplayMode(7);
            } else {
                adVideoView.setDisplayMode(2);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
            layoutParams.addRule(13);
            k(this.c0, layoutParams);
            this.c0.setAdVideoViewListener(this.k0);
            this.c0.setDestroyedListener(this.l0);
            this.c0.setPreparedListener(this.m0);
            this.c0.stopAndRelease();
            this.c0.initAdVideoView();
            this.c0.setVideoMute(true);
            this.c0.setVideoUrl(c0());
        } catch (Exception e2) {
            a0("video_container_excepiton_constructor_" + e2.toString());
        }
    }

    @Override // b.a.j0.a.d.a
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.c0.startPlay(c0());
                Z();
            } catch (Exception e2) {
                a0("video_container_excepiton_doStartOnUIThread_" + e2.toString());
            }
        }
    }

    @Override // b.a.j0.a.d.a
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.Q();
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.i0.incrementAndGet() == 2) {
                    b.a.j0.a.k.a.a(new e(this));
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.a();
            this.c0.setOnClickListener(new View$OnClickListenerC0082d(this));
            Q();
        }
    }

    public final void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            o0 = false;
            super.y(str);
        }
    }

    public Bitmap b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AdVideoView adVideoView = this.c0;
            long currentPosition = adVideoView != null ? adVideoView.getCurrentPosition() : 1L;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(this.f3125e, Uri.parse(c0()));
                            long j = currentPosition * 1000;
                            r3 = j > 0 ? mediaMetadataRetriever.getFrameAtTime(j, 3) : null;
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e2) {
                            e2.fillInStackTrace();
                        }
                    } catch (RuntimeException e3) {
                        this.j.d(e3);
                        mediaMetadataRetriever.release();
                    }
                } catch (IllegalArgumentException e4) {
                    this.j.d(e4);
                    mediaMetadataRetriever.release();
                }
                return r3;
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e5) {
                    e5.fillInStackTrace();
                }
                throw th;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
        }
    }

    public final String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String b2 = this.m.b(this.y, MaterialLoader.MaterialCacheType.VIDEO);
            return TextUtils.isEmpty(b2) ? this.y : b2;
        }
        return (String) invokeV.objValue;
    }

    public final void d0() {
        AtomicBoolean atomicBoolean;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (atomicBoolean = n0) == null) {
            return;
        }
        atomicBoolean.compareAndSet(true, false);
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (n0 == null) {
                n0 = new AtomicBoolean(true);
            }
            n0.compareAndSet(false, true);
        }
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? super.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            String str = "onWindowFocusChanged: " + z;
            AdVideoView adVideoView = this.c0;
            if (adVideoView == null) {
                return;
            }
            if (!z) {
                adVideoView.onPause();
            } else {
                adVideoView.onResume();
            }
            if (this.c0 != null && this.j0 && z && !o0) {
                a0("onWindowFocusChanged");
            }
            this.j0 = !z;
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
        }
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.c0 == null) {
            return;
        }
        o0 = true;
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // b.a.j0.a.d.a
    public void z() {
        AdVideoView adVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (adVideoView = this.c0) == null) {
            return;
        }
        adVideoView.setOnClickListener(null);
    }
}
