package c.a.p0.w3.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.s.a;
import c.a.p0.w3.l.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.tieba.video.record.StickerItem;
import com.baidu.tieba.video.record.VideoPreviewView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecordVideoActivity f28100a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f28101b;

    /* renamed from: c  reason: collision with root package name */
    public j f28102c;

    /* renamed from: d  reason: collision with root package name */
    public Camera f28103d;

    /* renamed from: e  reason: collision with root package name */
    public int f28104e;

    /* renamed from: f  reason: collision with root package name */
    public int f28105f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f28106g;

    /* renamed from: h  reason: collision with root package name */
    public int f28107h;

    /* renamed from: i  reason: collision with root package name */
    public int f28108i;

    /* renamed from: j  reason: collision with root package name */
    public List<String> f28109j;
    public boolean k;
    public int l;
    public int m;
    public Camera.Parameters n;
    public c.a.p0.w3.l.g o;
    public SurfaceView p;
    public List<String> q;
    public String r;
    public k s;
    public c.a.p0.w3.l.b t;
    public c.a.p0.y1.g u;
    public Handler v;
    public GLVideoPreviewView.b w;
    public GLVideoPreviewView.b x;
    public l y;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f28110a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28110a = hVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    this.f28110a.K();
                } else if (i2 != 2) {
                    if (i2 == 3 && this.f28110a.f28100a != null) {
                        c.a.e.e.p.l.L(this.f28110a.f28100a, R.string.disallow_audio_record_permission);
                        if (this.f28110a.u != null) {
                            this.f28110a.u.b(2, this.f28110a.f28100a.getResources().getString(R.string.disallow_audio_record_permission));
                        }
                        this.f28110a.f28100a.finish();
                    }
                } else if (this.f28110a.f28100a != null) {
                    if (!"OD103".equals(Build.MODEL)) {
                        c.a.e.e.p.l.L(this.f28110a.f28100a, R.string.disallow_camera_permission);
                        if (this.f28110a.u != null) {
                            Object obj = message.obj;
                            if (!(obj instanceof String)) {
                                string = this.f28110a.f28100a.getResources().getString(R.string.disallow_camera_permission);
                            } else {
                                string = (String) obj;
                            }
                            this.f28110a.u.b(1, string);
                        }
                        this.f28110a.f28100a.finish();
                        return;
                    }
                    h hVar = this.f28110a;
                    hVar.x(hVar.f28100a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f28111e;

        public b(h hVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28111e = activity;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f28111e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f28112e;

        public c(h hVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28112e = activity;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, this.f28112e.getPackageName(), null));
                this.f28112e.startActivity(intent);
                this.f28112e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements GLVideoPreviewView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f28113e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f28114e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f28115f;

            public a(d dVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28115f = dVar;
                this.f28114e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f28115f.f28113e.w.onFaceIdentifyState(this.f28114e);
                }
            }
        }

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28113e = hVar;
        }

        @Override // com.baidu.tieba.video.record.GLVideoPreviewView.b
        public void onFaceIdentifyState(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f28113e.w == null) {
                return;
            }
            c.a.e.e.m.e.a().post(new a(this, z));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f28116e;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28116e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28116e.A();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f28117e;

        public f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28117e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28117e.A();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f28118e;

        public g(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28118e = hVar;
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f28118e.f28100a != null) {
                    this.f28118e.f28100a.finish();
                }
            }
        }
    }

    /* renamed from: c.a.p0.w3.l.h$h  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1315h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1315h(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.s.s.a.e
        public void onClick(c.a.o0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f28119e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f28120f;

        public i(h hVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28120f = hVar;
            this.f28119e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28120f.o == null) {
                return;
            }
            this.f28120f.o.takePicture(this.f28119e);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f28121e;

        /* renamed from: f  reason: collision with root package name */
        public int f28122f;

        /* renamed from: g  reason: collision with root package name */
        public Bitmap f28123g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(h hVar, Context context, int i2, int i3, Bitmap bitmap) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, context, Integer.valueOf(i2), Integer.valueOf(i3), bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28121e = i2;
            this.f28122f = i3;
            this.f28123g = bitmap;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                canvas.drawBitmap(this.f28123g, this.f28121e, this.f28122f, (Paint) null);
                super.onDraw(canvas);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface k {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface l {
        void onSurfaceViewLayoutChange(int i2, int i3);
    }

    public h(RecordVideoActivity recordVideoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recordVideoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = 0;
        this.n = null;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, c.a.p0.y1.k.class);
        c.a.p0.y1.k kVar = runTask != null ? (c.a.p0.y1.k) runTask.getData() : null;
        if (kVar != null) {
            this.u = kVar.get();
        }
        this.v = new a(this);
        this.x = new d(this);
        this.f28100a = recordVideoActivity;
        s();
        this.f28101b = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.box_recorder_focus);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f28104e = displayMetrics.widthPixels;
        this.f28105f = displayMetrics.heightPixels;
        this.f28106g = this.f28100a.getSurfaceContainer();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.p = gLVideoPreviewView;
            this.o = gLVideoPreviewView;
            gLVideoPreviewView.setFaceIdentifyStateListener(this.x);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.p = videoPreviewView;
            this.o = videoPreviewView;
        }
        if (recordVideoActivity == null || recordVideoActivity.getSurfaceContainer() == null) {
            return;
        }
        recordVideoActivity.getSurfaceContainer().addView(this.p, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void A() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28106g == null || (jVar = this.f28102c) == null || jVar.getParent() == null) {
            return;
        }
        this.f28106g.removeView(this.f28102c);
    }

    public void B(c.a.p0.w3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setBeautyLevel(aVar);
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            try {
                if (!c.a.p0.w3.l.a.f(z)) {
                    z = !z;
                    if (!c.a.p0.w3.l.a.f(z)) {
                        J();
                        return;
                    }
                }
                int c2 = c.a.p0.w3.l.a.c(z);
                this.l = c2;
                if (-1 != c2) {
                    t();
                    this.t = new c.a.p0.w3.l.b(this.f28103d);
                    this.k = z;
                    return;
                }
                J();
            } catch (Exception e2) {
                e2.printStackTrace();
                J();
                c.a.p0.y1.g gVar = this.u;
                if (gVar != null) {
                    gVar.b(8, c.a.p0.y1.a.a(e2));
                }
            }
        }
    }

    public void D(GLVideoPreviewView.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
            return;
        }
        this.w = bVar;
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setFilter(str);
            }
        }
    }

    public void F(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            this.s = kVar;
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = Integer.MAX_VALUE;
            int[] iArr = null;
            int i3 = Integer.MAX_VALUE;
            for (int[] iArr2 : this.n.getSupportedPreviewFpsRange()) {
                if (Math.abs(20000 - iArr2[1]) <= i2 && Math.abs(15000 - iArr2[0]) <= i3) {
                    i2 = Math.abs(20000 - iArr2[1]);
                    i3 = Math.abs(15000 - iArr2[0]);
                    iArr = iArr2;
                }
            }
            this.n.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    public void H(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, stickerItem) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setSticker(stickerItem);
            }
        }
    }

    public void I(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lVar) == null) || lVar == null) {
            return;
        }
        this.y = lVar;
    }

    public final void J() {
        RecordVideoActivity recordVideoActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (recordVideoActivity = this.f28100a) == null) {
            return;
        }
        c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(recordVideoActivity.getPageContext().getPageActivity());
        aVar.setMessageId(R.string.video_quit_confirm);
        aVar.setPositiveButton(R.string.dialog_ok, new g(this));
        aVar.setNegativeButton(R.string.dialog_cancel, new C1315h(this));
        aVar.setCancelable(true);
        aVar.create(this.f28100a.getPageContext());
        aVar.show();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.startPreview(this.f28103d);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.startRecord(this.f28103d);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.o.stopRecord(this.f28103d);
        }
    }

    public void N(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            c.a.p0.w3.l.g gVar = this.o;
            if (gVar instanceof GLSurfaceView) {
                this.v.postDelayed(new i(this, aVar), 500L);
            } else {
                gVar.takePicture(aVar);
            }
        }
    }

    public final void O(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            try {
                this.f28103d.cancelAutoFocus();
                if (this.f28109j.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                    Camera.Parameters parameters = this.f28103d.getParameters();
                    this.n = parameters;
                    parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                }
                this.f28103d.setParameters(this.n);
                this.f28103d.autoFocus(null);
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a.p0.y1.g gVar = this.u;
                if (gVar != null) {
                    gVar.b(9, c.a.p0.y1.a.a(e2));
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView != null && (surfaceView instanceof GLVideoPreviewView)) {
                GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) surfaceView;
                gLVideoPreviewView.setIsChangingCamera(true);
                z();
                gLVideoPreviewView.clearNV21Data();
                int i2 = this.m == 0 ? 1 : 0;
                this.m = i2;
                C(i2 == 1);
                gLVideoPreviewView.switchCameraSurfaceTexture();
                gLVideoPreviewView.setIsChangingCamera(false);
                return;
            }
            SurfaceView surfaceView2 = this.p;
            if (surfaceView2 == null || !(surfaceView2 instanceof VideoPreviewView)) {
                return;
            }
            ((VideoPreviewView) surfaceView2).stopPreview(this.f28103d);
            z();
            int i3 = this.m == 0 ? 1 : 0;
            this.m = i3;
            C(i3 == 1);
            K();
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            File file = new File(c.a.p0.w3.c.f27859f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = c.a.p0.w3.c.f27859f + "f_" + System.currentTimeMillis() + ".mp4";
            this.r = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        List<String> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (list = this.q) == null || list.size() == 0) {
            return;
        }
        List<String> list2 = this.q;
        String remove = list2.remove(list2.size() - 1);
        if (TextUtils.isEmpty(remove)) {
            return;
        }
        File file = new File(remove);
        if (file.exists()) {
            file.delete();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                if (this.f28103d == null) {
                    return;
                }
                if (this.n == null) {
                    this.n = this.f28103d.getParameters();
                }
                if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(this.n.getFlashMode())) {
                    this.n.setFlashMode("torch");
                } else {
                    this.n.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                }
                this.f28103d.setParameters(this.n);
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a.p0.y1.g gVar = this.u;
                if (gVar != null) {
                    gVar.b(7, c.a.p0.y1.a.a(e2));
                }
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l == 0 : invokeV.booleanValue;
    }

    public c.a.p0.w3.l.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.t : (c.a.p0.w3.l.b) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            try {
                if (this.f28103d == null) {
                    return false;
                }
                if (this.n == null) {
                    this.n = this.f28103d.getParameters();
                }
                return !DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(this.n.getFlashMode());
            } catch (Exception e2) {
                e2.printStackTrace();
                c.a.p0.y1.g gVar = this.u;
                if (gVar != null) {
                    gVar.b(7, c.a.p0.y1.a.a(e2));
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.m == 1 : invokeV.booleanValue;
    }

    public Handler n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.v : (Handler) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.q == null) {
                this.q = new ArrayList();
            }
            File file = new File(c.a.p0.w3.c.f27859f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = c.a.p0.w3.c.f27859f + "rec_tmp_" + System.currentTimeMillis() + ".mp4";
            this.q.add(str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public int p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, context)) == null) {
            int i2 = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                i2 = displayMetrics.heightPixels;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i2 == 0 ? c.a.e.e.p.l.i(context) : i2;
        }
        return invokeL.intValue;
    }

    public c.a.p0.w3.l.g q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.o : (c.a.p0.w3.l.g) invokeV.objValue;
    }

    public boolean r(MotionEvent motionEvent, ViewParent viewParent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, motionEvent, viewParent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y > this.f28105f || x < c.a.e.e.p.l.g(this.f28100a, R.dimen.ds60)) {
                    return true;
                }
                int width = this.f28101b.getWidth();
                int height = this.f28101b.getHeight();
                int i2 = width / 2;
                int a2 = c.a.p0.w3.l.a.a(x, i2, this.f28104e - i2);
                int i3 = height / 2;
                int a3 = c.a.p0.w3.l.a.a(y, i3, this.f28105f - i3);
                if (viewParent != null && (viewParent instanceof FrameLayout)) {
                    if (this.f28106g == null) {
                        this.f28106g = (FrameLayout) viewParent;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.f28106g.getChildCount()) {
                            break;
                        } else if (this.f28102c == this.f28106g.getChildAt(i4)) {
                            this.f28106g.removeViewAt(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    j jVar = new j(this, this.f28100a, a2 - i2, a3 - i3, this.f28101b);
                    this.f28102c = jVar;
                    this.f28106g.addView(jVar, new ViewGroup.LayoutParams(-2, -2));
                    O(a2, a3);
                }
            } else if (action == 1) {
                this.v.postDelayed(new f(this), 800L);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.f28107h = 720;
            this.f28108i = 960;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            try {
                Camera open = Camera.open(this.l);
                this.f28103d = open;
                this.n = open.getParameters();
                y();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                Message obtainMessage = this.v.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.obj = c.a.p0.y1.a.a(e2);
                this.v.sendMessageDelayed(obtainMessage, 1000L);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            z();
            this.o.stopPreview(this.f28103d);
            SurfaceView surfaceView = this.p;
            if (surfaceView == null || !(surfaceView instanceof GLVideoPreviewView)) {
                return;
            }
            ((GLVideoPreviewView) surfaceView).onPause();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            C(this.m == 1);
            SurfaceView surfaceView = this.p;
            if (surfaceView != null && (surfaceView instanceof GLVideoPreviewView)) {
                ((GLVideoPreviewView) surfaceView).onResume();
            }
            SurfaceView surfaceView2 = this.p;
            if (surfaceView2 != null && (surfaceView2 instanceof VideoPreviewView)) {
                ((VideoPreviewView) surfaceView2).onResume();
            }
            if (c.a.p0.w3.l.c.b()) {
                return;
            }
            this.v.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    public boolean w(MotionEvent motionEvent, ViewParent viewParent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, motionEvent, viewParent)) == null) {
            if (this.s != null && motionEvent.getAction() == 0) {
                this.s.a();
            }
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount == 1) {
                return r(motionEvent, viewParent);
            }
            if (pointerCount >= 2) {
                this.v.postDelayed(new e(this), 100L);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void x(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, activity) == null) {
            c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(activity);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setTitle(R.string.request_permission_default_title);
            aVar.setMessageId(R.string.request_permission_camera);
            aVar.setPositiveButton(R.string.isopen, new c(this, activity)).setNegativeButton(R.string.cancel, new b(this, activity)).create(c.a.e.a.j.a(activity));
            aVar.show();
        }
    }

    public void y() {
        RecordVideoActivity recordVideoActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.f28103d == null && (recordVideoActivity = this.f28100a) != null) {
                recordVideoActivity.finish();
                return;
            }
            int k2 = c.a.e.e.p.l.k(this.f28100a.getPageContext().getPageActivity());
            int p = p(this.f28100a.getPageContext().getPageActivity());
            if (DeviceInfoUtil.isHuaWeiP40()) {
                p = this.f28105f;
            }
            float f2 = p;
            float f3 = k2;
            Camera.Size d2 = c.a.p0.w3.l.a.d(this.f28103d, 720, (int) (720 * ((f2 * 1.0f) / f3)));
            if (d2 != null) {
                int i2 = d2.width;
                this.f28107h = i2;
                int i3 = d2.height;
                this.f28108i = i3;
                this.n.setPreviewSize(i2, i3);
                c.a.p0.w3.l.g gVar = this.o;
                if (gVar != null) {
                    gVar.setPreviewSize(this.f28107h, this.f28108i);
                }
            }
            this.n.setPreviewFormat(17);
            G();
            this.f28103d.setDisplayOrientation(c.a.p0.w3.l.a.b(this.f28100a, this.l));
            List<String> supportedFocusModes = this.n.getSupportedFocusModes();
            this.f28109j = supportedFocusModes;
            if (supportedFocusModes != null) {
                if ((Build.MODEL.startsWith("GT-I950") || Build.MODEL.endsWith("SCH-I959") || Build.MODEL.endsWith("MEIZU MX3")) && this.f28109j.contains("continuous-picture")) {
                    this.n.setFocusMode("continuous-picture");
                } else if (this.f28109j.contains("continuous-video")) {
                    this.n.setFocusMode("continuous-video");
                }
            }
            this.f28103d.setParameters(this.n);
            RecordVideoActivity recordVideoActivity2 = this.f28100a;
            if (recordVideoActivity2 == null || recordVideoActivity2.getSurfaceContainer() == null) {
                return;
            }
            float f4 = (this.f28108i * 1.0f) / this.f28107h;
            if ((f3 * 1.0f) / f2 > f4) {
                p = (int) (f3 / f4);
            } else {
                k2 = (int) (f2 * f4);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = p;
            this.p.setLayoutParams(layoutParams);
            this.p.invalidate();
            l lVar = this.y;
            if (lVar != null) {
                lVar.onSurfaceViewLayoutChange(layoutParams.width, layoutParams.height);
            }
        }
    }

    public final void z() {
        Camera camera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (camera = this.f28103d) == null) {
            return;
        }
        try {
            camera.stopPreview();
            this.f28103d.setPreviewCallback(null);
            this.f28103d.setPreviewTexture(null);
            this.f28103d.release();
        } catch (Exception e2) {
            e2.printStackTrace();
            c.a.p0.y1.g gVar = this.u;
            if (gVar != null) {
                gVar.b(6, c.a.p0.y1.a.a(e2));
            }
        }
        this.f28103d = null;
    }
}
