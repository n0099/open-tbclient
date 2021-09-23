package c.a.p0.a.p.c;

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
public class l implements c.a.p0.a.p.d.x {
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
        public Context f7862e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<MediaModel> f7863f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f7864g;

        /* renamed from: h  reason: collision with root package name */
        public String f7865h;

        /* renamed from: i  reason: collision with root package name */
        public c.a.p0.a.i1.d.d.d f7866i;

        /* renamed from: j  reason: collision with root package name */
        public HandlerC0338b f7867j;
        public a k;

        /* loaded from: classes.dex */
        public class a extends c.a.p0.a.g1.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public HandlerC0338b f7868e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f7869f;

            public a(b bVar, HandlerC0338b handlerC0338b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, handlerC0338b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7869f = bVar;
                this.f7868e = handlerC0338b;
            }

            @Override // c.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                    if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                        if (this.f7868e.f7871b != null && this.f7868e.f7871b.isShowing()) {
                            this.f7868e.f7871b.cancel();
                            this.f7868e.f7871b = null;
                        }
                        HandlerC0338b handlerC0338b = this.f7868e;
                        if (handlerC0338b != null) {
                            handlerC0338b.removeMessages(1);
                            this.f7868e.removeMessages(2);
                            this.f7868e = null;
                        }
                        this.f7869f.f();
                    }
                }
            }
        }

        /* renamed from: c.a.p0.a.p.c.l$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class HandlerC0338b extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f7870a;

            /* renamed from: b  reason: collision with root package name */
            public Dialog f7871b;

            public /* synthetic */ HandlerC0338b(Context context, a aVar) {
                this(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Dialog dialog;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    int i2 = message.what;
                    if (i2 != 1) {
                        if (i2 == 2 && (dialog = this.f7871b) != null && dialog.isShowing()) {
                            Context context = this.f7870a.get();
                            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                this.f7871b.cancel();
                            }
                            this.f7871b = null;
                            return;
                        }
                        return;
                    }
                    Context context2 = this.f7870a.get();
                    if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                        return;
                    }
                    Dialog dialog2 = new Dialog(this.f7870a.get(), c.a.p0.a.i.SwanAppCompressDialog);
                    this.f7871b = dialog2;
                    dialog2.setContentView(c.a.p0.a.g.swanapp_progress_dialog);
                    this.f7871b.findViewById(c.a.p0.a.f.layer_night).setVisibility(c.a.p0.a.c1.a.H().a() ? 0 : 8);
                    this.f7871b.setCancelable(false);
                    this.f7871b.show();
                }
            }

            public HandlerC0338b(Context context) {
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
                this.f7870a = new WeakReference<>(context);
            }
        }

        public b(Context context, Bundle bundle, c.a.p0.a.i1.d.d.d dVar) {
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
            this.f7862e = context;
            this.f7863f = bundle.getParcelableArrayList("mediaModels");
            c.a.p0.a.v2.v.g(bundle, "swanAppId");
            this.f7864g = c.a.p0.a.v2.v.c(bundle, "compressed", false);
            this.f7865h = c.a.p0.a.v2.v.g(bundle, "swanTmpPath");
            this.f7866i = dVar;
            this.f7867j = new HandlerC0338b(context, null);
        }

        public final void b(MediaModel mediaModel, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaModel, i2) == null) || mediaModel == null) {
                return;
            }
            if (c.a.p0.a.i1.d.c.c.f6738a) {
                String str = "compressImg : " + mediaModel.getPath();
            }
            File file = new File(mediaModel.getPath());
            File l = c.a.p0.a.v2.u.l(this.f7865h, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.setTempPath(l.getAbsolutePath());
            c.a.p0.a.v2.u.n(file, l, i2);
            mediaModel.setSize(l.length());
        }

        public final void c(VideoModel videoModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoModel) == null) || videoModel == null) {
                return;
            }
            if (c.a.p0.a.i1.d.c.c.f6738a) {
                String str = "compressVideo : " + videoModel.getPath();
            }
            File l = c.a.p0.a.v2.u.l(this.f7865h, new File(videoModel.getPath()).getName());
            if (l == null) {
                return;
            }
            c.a.p0.t.d.f(new File(videoModel.getPath()), l);
            videoModel.setTempPath(l.getPath());
            videoModel.setSize(l.length());
        }

        public final void d(MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaModel) == null) || mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.getPath());
            File l = c.a.p0.a.v2.u.l(this.f7865h, file.getName());
            if (l == null || !l.exists() || c.a.p0.t.d.f(file, l) == 0) {
                return;
            }
            mediaModel.setTempPath(l.getPath());
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.k = new a(this, this.f7867j);
                c.a.p0.a.c1.a.b().registerActivityLifecycleCallbacks(this.k);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.k == null) {
                return;
            }
            c.a.p0.a.c1.a.b().unregisterActivityLifecycleCallbacks(this.k);
            this.k = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                HandlerC0338b handlerC0338b = this.f7867j;
                if (handlerC0338b != null) {
                    handlerC0338b.sendEmptyMessage(1);
                }
                if (this.f7864g) {
                    Iterator<MediaModel> it = this.f7863f.iterator();
                    while (it.hasNext()) {
                        MediaModel next = it.next();
                        if (next != null) {
                            if (next instanceof ImageModel) {
                                if (TextUtils.equals(c.a.p0.t.d.s(next.getPath()), "gif")) {
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
                    Iterator<MediaModel> it2 = this.f7863f.iterator();
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
                HandlerC0338b handlerC0338b2 = this.f7867j;
                if (handlerC0338b2 != null) {
                    handlerC0338b2.sendEmptyMessage(2);
                }
                c.a.p0.a.i1.d.d.d dVar = this.f7866i;
                if (dVar != null) {
                    dVar.a(true, null, this.f7863f);
                }
                f();
            }
        }
    }

    public l() {
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

    @Override // c.a.p0.a.p.d.x
    public void a(Activity activity, Bundle bundle, c.a.p0.a.i1.d.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, dVar) == null) {
            c.a.p0.a.v2.q.j(new b(activity, bundle, dVar), "main process compress files");
        }
    }
}
