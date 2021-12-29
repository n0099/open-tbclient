package c.a.r0.a.p.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class k implements c.a.r0.a.p.d.x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f8290e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<MediaModel> f8291f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8292g;

        /* renamed from: h  reason: collision with root package name */
        public String f8293h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.r0.a.j1.d.d.d f8294i;

        /* renamed from: j  reason: collision with root package name */
        public HandlerC0483b f8295j;

        /* renamed from: k  reason: collision with root package name */
        public a f8296k;

        /* loaded from: classes.dex */
        public class a extends c.a.r0.a.g1.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public HandlerC0483b f8297e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f8298f;

            public a(b bVar, HandlerC0483b handlerC0483b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, handlerC0483b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8298f = bVar;
                this.f8297e = handlerC0483b;
            }

            @Override // c.a.r0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                    if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                        if (this.f8297e.f8299b != null && this.f8297e.f8299b.isShowing()) {
                            this.f8297e.f8299b.cancel();
                            this.f8297e.f8299b = null;
                        }
                        HandlerC0483b handlerC0483b = this.f8297e;
                        if (handlerC0483b != null) {
                            handlerC0483b.removeMessages(1);
                            this.f8297e.removeMessages(2);
                            this.f8297e = null;
                        }
                        this.f8298f.f();
                    }
                }
            }
        }

        /* renamed from: c.a.r0.a.p.c.k$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class HandlerC0483b extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public WeakReference<Context> a;

            /* renamed from: b  reason: collision with root package name */
            public Dialog f8299b;

            public /* synthetic */ HandlerC0483b(Context context, a aVar) {
                this(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Dialog dialog;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    int i2 = message.what;
                    if (i2 != 1) {
                        if (i2 == 2 && (dialog = this.f8299b) != null && dialog.isShowing()) {
                            Context context = this.a.get();
                            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                this.f8299b.cancel();
                            }
                            this.f8299b = null;
                            return;
                        }
                        return;
                    }
                    Context context2 = this.a.get();
                    if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                        return;
                    }
                    Dialog dialog2 = new Dialog(this.a.get(), c.a.r0.a.i.SwanAppCompressDialog);
                    this.f8299b = dialog2;
                    dialog2.setContentView(c.a.r0.a.g.swanapp_progress_dialog);
                    this.f8299b.findViewById(c.a.r0.a.f.layer_night).setVisibility(c.a.r0.a.c1.a.M().a() ? 0 : 8);
                    this.f8299b.setCancelable(false);
                    this.f8299b.show();
                }
            }

            public HandlerC0483b(Context context) {
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
                this.a = new WeakReference<>(context);
            }
        }

        public b(Context context, Bundle bundle, c.a.r0.a.j1.d.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bundle, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8290e = context;
            this.f8291f = bundle.getParcelableArrayList("mediaModels");
            c.a.r0.a.z2.v.g(bundle, "swanAppId");
            this.f8292g = c.a.r0.a.z2.v.c(bundle, "compressed", false);
            this.f8293h = c.a.r0.a.z2.v.g(bundle, "swanTmpPath");
            this.f8294i = dVar;
            this.f8295j = new HandlerC0483b(context, null);
        }

        public final void b(MediaModel mediaModel, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaModel, i2) == null) || mediaModel == null) {
                return;
            }
            if (c.a.r0.a.j1.d.c.c.a) {
                String str = "compressImg : " + mediaModel.getPath();
            }
            File file = new File(mediaModel.getPath());
            File l = c.a.r0.a.z2.u.l(this.f8293h, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.setTempPath(l.getAbsolutePath());
            c.a.r0.a.z2.u.n(file, l, i2);
            mediaModel.setSize(l.length());
        }

        public final void c(VideoModel videoModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoModel) == null) || videoModel == null) {
                return;
            }
            if (c.a.r0.a.j1.d.c.c.a) {
                String str = "compressVideo : " + videoModel.getPath();
            }
            File l = c.a.r0.a.z2.u.l(this.f8293h, new File(videoModel.getPath()).getName());
            if (l == null) {
                return;
            }
            c.a.r0.w.d.f(new File(videoModel.getPath()), l);
            videoModel.setTempPath(l.getPath());
            videoModel.setSize(l.length());
        }

        public final void d(MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaModel) == null) || mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.getPath());
            File l = c.a.r0.a.z2.u.l(this.f8293h, file.getName());
            if (l == null || !l.exists() || c.a.r0.w.d.f(file, l) == 0) {
                return;
            }
            mediaModel.setTempPath(l.getPath());
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f8296k = new a(this, this.f8295j);
                c.a.r0.a.c1.a.c().registerActivityLifecycleCallbacks(this.f8296k);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f8296k == null) {
                return;
            }
            c.a.r0.a.c1.a.c().unregisterActivityLifecycleCallbacks(this.f8296k);
            this.f8296k = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                HandlerC0483b handlerC0483b = this.f8295j;
                if (handlerC0483b != null) {
                    handlerC0483b.sendEmptyMessage(1);
                }
                if (this.f8292g) {
                    Iterator<MediaModel> it = this.f8291f.iterator();
                    while (it.hasNext()) {
                        MediaModel next = it.next();
                        if (next != null) {
                            if (next instanceof ImageModel) {
                                if (TextUtils.equals(c.a.r0.w.d.t(next.getPath()), "gif")) {
                                    d(next);
                                } else {
                                    b(next, 20);
                                }
                            } else if (next instanceof VideoModel) {
                                c((VideoModel) next);
                            }
                        }
                    }
                } else {
                    Iterator<MediaModel> it2 = this.f8291f.iterator();
                    while (it2.hasNext()) {
                        MediaModel next2 = it2.next();
                        if (next2 != null) {
                            if (next2 instanceof ImageModel) {
                                b(next2, 100);
                            } else {
                                d(next2);
                            }
                        }
                    }
                }
                HandlerC0483b handlerC0483b2 = this.f8295j;
                if (handlerC0483b2 != null) {
                    handlerC0483b2.sendEmptyMessage(2);
                }
                c.a.r0.a.j1.d.d.d dVar = this.f8294i;
                if (dVar != null) {
                    dVar.a(true, null, this.f8291f);
                }
                f();
            }
        }
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r0.a.p.d.x
    public void a(Activity activity, Bundle bundle, c.a.r0.a.j1.d.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, dVar) == null) {
            c.a.r0.a.z2.q.k(new b(activity, bundle, dVar), "main process compress files");
        }
    }
}
