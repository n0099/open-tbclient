package c.a.q0.a.p.c;

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
public class k implements c.a.q0.a.p.d.x {
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
        public Context f7555e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<MediaModel> f7556f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f7557g;

        /* renamed from: h  reason: collision with root package name */
        public String f7558h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.q0.a.j1.d.d.d f7559i;

        /* renamed from: j  reason: collision with root package name */
        public HandlerC0433b f7560j;

        /* renamed from: k  reason: collision with root package name */
        public a f7561k;

        /* loaded from: classes.dex */
        public class a extends c.a.q0.a.g1.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public HandlerC0433b f7562e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f7563f;

            public a(b bVar, HandlerC0433b handlerC0433b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, handlerC0433b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7563f = bVar;
                this.f7562e = handlerC0433b;
            }

            @Override // c.a.q0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                    if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                        if (this.f7562e.f7564b != null && this.f7562e.f7564b.isShowing()) {
                            this.f7562e.f7564b.cancel();
                            this.f7562e.f7564b = null;
                        }
                        HandlerC0433b handlerC0433b = this.f7562e;
                        if (handlerC0433b != null) {
                            handlerC0433b.removeMessages(1);
                            this.f7562e.removeMessages(2);
                            this.f7562e = null;
                        }
                        this.f7563f.f();
                    }
                }
            }
        }

        /* renamed from: c.a.q0.a.p.c.k$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class HandlerC0433b extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public WeakReference<Context> a;

            /* renamed from: b  reason: collision with root package name */
            public Dialog f7564b;

            public /* synthetic */ HandlerC0433b(Context context, a aVar) {
                this(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Dialog dialog;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    int i2 = message.what;
                    if (i2 != 1) {
                        if (i2 == 2 && (dialog = this.f7564b) != null && dialog.isShowing()) {
                            Context context = this.a.get();
                            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                this.f7564b.cancel();
                            }
                            this.f7564b = null;
                            return;
                        }
                        return;
                    }
                    Context context2 = this.a.get();
                    if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                        return;
                    }
                    Dialog dialog2 = new Dialog(this.a.get(), c.a.q0.a.i.SwanAppCompressDialog);
                    this.f7564b = dialog2;
                    dialog2.setContentView(c.a.q0.a.g.swanapp_progress_dialog);
                    this.f7564b.findViewById(c.a.q0.a.f.layer_night).setVisibility(c.a.q0.a.c1.a.M().a() ? 0 : 8);
                    this.f7564b.setCancelable(false);
                    this.f7564b.show();
                }
            }

            public HandlerC0433b(Context context) {
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

        public b(Context context, Bundle bundle, c.a.q0.a.j1.d.d.d dVar) {
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
            this.f7555e = context;
            this.f7556f = bundle.getParcelableArrayList("mediaModels");
            c.a.q0.a.z2.v.g(bundle, "swanAppId");
            this.f7557g = c.a.q0.a.z2.v.c(bundle, "compressed", false);
            this.f7558h = c.a.q0.a.z2.v.g(bundle, "swanTmpPath");
            this.f7559i = dVar;
            this.f7560j = new HandlerC0433b(context, null);
        }

        public final void b(MediaModel mediaModel, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaModel, i2) == null) || mediaModel == null) {
                return;
            }
            if (c.a.q0.a.j1.d.c.c.a) {
                String str = "compressImg : " + mediaModel.getPath();
            }
            File file = new File(mediaModel.getPath());
            File l = c.a.q0.a.z2.u.l(this.f7558h, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.setTempPath(l.getAbsolutePath());
            c.a.q0.a.z2.u.n(file, l, i2);
            mediaModel.setSize(l.length());
        }

        public final void c(VideoModel videoModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoModel) == null) || videoModel == null) {
                return;
            }
            if (c.a.q0.a.j1.d.c.c.a) {
                String str = "compressVideo : " + videoModel.getPath();
            }
            File l = c.a.q0.a.z2.u.l(this.f7558h, new File(videoModel.getPath()).getName());
            if (l == null) {
                return;
            }
            c.a.q0.w.d.f(new File(videoModel.getPath()), l);
            videoModel.setTempPath(l.getPath());
            videoModel.setSize(l.length());
        }

        public final void d(MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaModel) == null) || mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.getPath());
            File l = c.a.q0.a.z2.u.l(this.f7558h, file.getName());
            if (l == null || !l.exists() || c.a.q0.w.d.f(file, l) == 0) {
                return;
            }
            mediaModel.setTempPath(l.getPath());
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f7561k = new a(this, this.f7560j);
                c.a.q0.a.c1.a.c().registerActivityLifecycleCallbacks(this.f7561k);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f7561k == null) {
                return;
            }
            c.a.q0.a.c1.a.c().unregisterActivityLifecycleCallbacks(this.f7561k);
            this.f7561k = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                HandlerC0433b handlerC0433b = this.f7560j;
                if (handlerC0433b != null) {
                    handlerC0433b.sendEmptyMessage(1);
                }
                if (this.f7557g) {
                    Iterator<MediaModel> it = this.f7556f.iterator();
                    while (it.hasNext()) {
                        MediaModel next = it.next();
                        if (next != null) {
                            if (next instanceof ImageModel) {
                                if (TextUtils.equals(c.a.q0.w.d.t(next.getPath()), "gif")) {
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
                    Iterator<MediaModel> it2 = this.f7556f.iterator();
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
                HandlerC0433b handlerC0433b2 = this.f7560j;
                if (handlerC0433b2 != null) {
                    handlerC0433b2.sendEmptyMessage(2);
                }
                c.a.q0.a.j1.d.d.d dVar = this.f7559i;
                if (dVar != null) {
                    dVar.a(true, null, this.f7556f);
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

    @Override // c.a.q0.a.p.d.x
    public void a(Activity activity, Bundle bundle, c.a.q0.a.j1.d.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, dVar) == null) {
            c.a.q0.a.z2.q.k(new b(activity, bundle, dVar), "main process compress files");
        }
    }
}
