package c.a.n0.a.f.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class k implements c.a.n0.a.f.d.x {
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
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<MediaModel> f4298b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4299c;

        /* renamed from: d  reason: collision with root package name */
        public String f4300d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.n0.a.z0.d.d.d f4301e;

        /* renamed from: f  reason: collision with root package name */
        public HandlerC0257b f4302f;

        /* renamed from: g  reason: collision with root package name */
        public a f4303g;

        /* loaded from: classes.dex */
        public class a extends c.a.n0.a.w0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public HandlerC0257b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f4304b;

            public a(b bVar, HandlerC0257b handlerC0257b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, handlerC0257b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4304b = bVar;
                this.a = handlerC0257b;
            }

            @Override // c.a.n0.a.w0.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                    if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                        if (this.a.f4305b != null && this.a.f4305b.isShowing()) {
                            this.a.f4305b.cancel();
                            this.a.f4305b = null;
                        }
                        HandlerC0257b handlerC0257b = this.a;
                        if (handlerC0257b != null) {
                            handlerC0257b.removeMessages(1);
                            this.a.removeMessages(2);
                            this.a = null;
                        }
                        this.f4304b.f();
                    }
                }
            }
        }

        /* renamed from: c.a.n0.a.f.c.k$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class HandlerC0257b extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public WeakReference<Context> a;

            /* renamed from: b  reason: collision with root package name */
            public Dialog f4305b;

            public /* synthetic */ HandlerC0257b(Context context, a aVar) {
                this(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Dialog dialog;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    int i = message.what;
                    if (i != 1) {
                        if (i == 2 && (dialog = this.f4305b) != null && dialog.isShowing()) {
                            Context context = this.a.get();
                            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                this.f4305b.cancel();
                            }
                            this.f4305b = null;
                            return;
                        }
                        return;
                    }
                    Context context2 = this.a.get();
                    if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                        return;
                    }
                    Dialog dialog2 = new Dialog(this.a.get(), R.style.obfuscated_res_0x7f100199);
                    this.f4305b = dialog2;
                    dialog2.setContentView(R.layout.obfuscated_res_0x7f0d07de);
                    this.f4305b.findViewById(R.id.obfuscated_res_0x7f0911bd).setVisibility(c.a.n0.a.s0.a.M().a() ? 0 : 8);
                    this.f4305b.setCancelable(false);
                    this.f4305b.show();
                }
            }

            public HandlerC0257b(Context context) {
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
                this.a = new WeakReference<>(context);
            }
        }

        public b(Context context, Bundle bundle, c.a.n0.a.z0.d.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bundle, dVar};
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
            this.f4298b = bundle.getParcelableArrayList("mediaModels");
            c.a.n0.a.p2.v.g(bundle, "swanAppId");
            this.f4299c = c.a.n0.a.p2.v.c(bundle, "compressed", false);
            this.f4300d = c.a.n0.a.p2.v.g(bundle, "swanTmpPath");
            this.f4301e = dVar;
            this.f4302f = new HandlerC0257b(context, null);
        }

        public final void b(MediaModel mediaModel, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaModel, i) == null) || mediaModel == null) {
                return;
            }
            if (c.a.n0.a.z0.d.c.c.a) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File l = c.a.n0.a.p2.u.l(this.f4300d, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.setTempPath(l.getAbsolutePath());
            c.a.n0.a.p2.u.n(file, l, i);
            mediaModel.setSize(l.length());
        }

        public final void c(VideoModel videoModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoModel) == null) || videoModel == null) {
                return;
            }
            if (c.a.n0.a.z0.d.c.c.a) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File l = c.a.n0.a.p2.u.l(this.f4300d, new File(videoModel.getPath()).getName());
            if (l == null) {
                return;
            }
            c.a.n0.w.d.f(new File(videoModel.getPath()), l);
            videoModel.setTempPath(l.getPath());
            videoModel.setSize(l.length());
        }

        public final void d(MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaModel) == null) || mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.getPath());
            File l = c.a.n0.a.p2.u.l(this.f4300d, file.getName());
            if (l == null || !l.exists() || c.a.n0.w.d.f(file, l) == 0) {
                return;
            }
            mediaModel.setTempPath(l.getPath());
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f4303g = new a(this, this.f4302f);
                c.a.n0.a.s0.a.c().registerActivityLifecycleCallbacks(this.f4303g);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f4303g == null) {
                return;
            }
            c.a.n0.a.s0.a.c().unregisterActivityLifecycleCallbacks(this.f4303g);
            this.f4303g = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                HandlerC0257b handlerC0257b = this.f4302f;
                if (handlerC0257b != null) {
                    handlerC0257b.sendEmptyMessage(1);
                }
                if (this.f4299c) {
                    Iterator<MediaModel> it = this.f4298b.iterator();
                    while (it.hasNext()) {
                        MediaModel next = it.next();
                        if (next != null) {
                            if (next instanceof ImageModel) {
                                if (TextUtils.equals(c.a.n0.w.d.t(next.getPath()), "gif")) {
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
                    Iterator<MediaModel> it2 = this.f4298b.iterator();
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
                HandlerC0257b handlerC0257b2 = this.f4302f;
                if (handlerC0257b2 != null) {
                    handlerC0257b2.sendEmptyMessage(2);
                }
                c.a.n0.a.z0.d.d.d dVar = this.f4301e;
                if (dVar != null) {
                    dVar.a(true, null, this.f4298b);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.n0.a.f.d.x
    public void a(Activity activity, Bundle bundle, c.a.n0.a.z0.d.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, dVar) == null) {
            c.a.n0.a.p2.q.k(new b(activity, bundle, dVar), "main process compress files");
        }
    }
}
