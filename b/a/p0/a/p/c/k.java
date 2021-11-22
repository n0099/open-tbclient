package b.a.p0.a.p.c;

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
public class k implements b.a.p0.a.p.d.x {
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
        public Context f7549e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<MediaModel> f7550f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f7551g;

        /* renamed from: h  reason: collision with root package name */
        public String f7552h;

        /* renamed from: i  reason: collision with root package name */
        public b.a.p0.a.j1.d.d.d f7553i;
        public HandlerC0343b j;
        public a k;

        /* loaded from: classes.dex */
        public class a extends b.a.p0.a.g1.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public HandlerC0343b f7554e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f7555f;

            public a(b bVar, HandlerC0343b handlerC0343b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, handlerC0343b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7555f = bVar;
                this.f7554e = handlerC0343b;
            }

            @Override // b.a.p0.a.g1.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                    if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                        if (this.f7554e.f7557b != null && this.f7554e.f7557b.isShowing()) {
                            this.f7554e.f7557b.cancel();
                            this.f7554e.f7557b = null;
                        }
                        HandlerC0343b handlerC0343b = this.f7554e;
                        if (handlerC0343b != null) {
                            handlerC0343b.removeMessages(1);
                            this.f7554e.removeMessages(2);
                            this.f7554e = null;
                        }
                        this.f7555f.f();
                    }
                }
            }
        }

        /* renamed from: b.a.p0.a.p.c.k$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class HandlerC0343b extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public WeakReference<Context> f7556a;

            /* renamed from: b  reason: collision with root package name */
            public Dialog f7557b;

            public /* synthetic */ HandlerC0343b(Context context, a aVar) {
                this(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Dialog dialog;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    int i2 = message.what;
                    if (i2 != 1) {
                        if (i2 == 2 && (dialog = this.f7557b) != null && dialog.isShowing()) {
                            Context context = this.f7556a.get();
                            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                this.f7557b.cancel();
                            }
                            this.f7557b = null;
                            return;
                        }
                        return;
                    }
                    Context context2 = this.f7556a.get();
                    if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                        return;
                    }
                    Dialog dialog2 = new Dialog(this.f7556a.get(), b.a.p0.a.i.SwanAppCompressDialog);
                    this.f7557b = dialog2;
                    dialog2.setContentView(b.a.p0.a.g.swanapp_progress_dialog);
                    this.f7557b.findViewById(b.a.p0.a.f.layer_night).setVisibility(b.a.p0.a.c1.a.M().a() ? 0 : 8);
                    this.f7557b.setCancelable(false);
                    this.f7557b.show();
                }
            }

            public HandlerC0343b(Context context) {
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
                this.f7556a = new WeakReference<>(context);
            }
        }

        public b(Context context, Bundle bundle, b.a.p0.a.j1.d.d.d dVar) {
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
            this.f7549e = context;
            this.f7550f = bundle.getParcelableArrayList("mediaModels");
            b.a.p0.a.z2.v.g(bundle, "swanAppId");
            this.f7551g = b.a.p0.a.z2.v.c(bundle, "compressed", false);
            this.f7552h = b.a.p0.a.z2.v.g(bundle, "swanTmpPath");
            this.f7553i = dVar;
            this.j = new HandlerC0343b(context, null);
        }

        public final void b(MediaModel mediaModel, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, mediaModel, i2) == null) || mediaModel == null) {
                return;
            }
            if (b.a.p0.a.j1.d.c.c.f6713a) {
                String str = "compressImg : " + mediaModel.getPath();
            }
            File file = new File(mediaModel.getPath());
            File l = b.a.p0.a.z2.u.l(this.f7552h, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.setTempPath(l.getAbsolutePath());
            b.a.p0.a.z2.u.n(file, l, i2);
            mediaModel.setSize(l.length());
        }

        public final void c(VideoModel videoModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoModel) == null) || videoModel == null) {
                return;
            }
            if (b.a.p0.a.j1.d.c.c.f6713a) {
                String str = "compressVideo : " + videoModel.getPath();
            }
            File l = b.a.p0.a.z2.u.l(this.f7552h, new File(videoModel.getPath()).getName());
            if (l == null) {
                return;
            }
            b.a.p0.w.d.f(new File(videoModel.getPath()), l);
            videoModel.setTempPath(l.getPath());
            videoModel.setSize(l.length());
        }

        public final void d(MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaModel) == null) || mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.getPath());
            File l = b.a.p0.a.z2.u.l(this.f7552h, file.getName());
            if (l == null || !l.exists() || b.a.p0.w.d.f(file, l) == 0) {
                return;
            }
            mediaModel.setTempPath(l.getPath());
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.k = new a(this, this.j);
                b.a.p0.a.c1.a.c().registerActivityLifecycleCallbacks(this.k);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.k == null) {
                return;
            }
            b.a.p0.a.c1.a.c().unregisterActivityLifecycleCallbacks(this.k);
            this.k = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                HandlerC0343b handlerC0343b = this.j;
                if (handlerC0343b != null) {
                    handlerC0343b.sendEmptyMessage(1);
                }
                if (this.f7551g) {
                    Iterator<MediaModel> it = this.f7550f.iterator();
                    while (it.hasNext()) {
                        MediaModel next = it.next();
                        if (next != null) {
                            if (next instanceof ImageModel) {
                                if (TextUtils.equals(b.a.p0.w.d.t(next.getPath()), "gif")) {
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
                    Iterator<MediaModel> it2 = this.f7550f.iterator();
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
                HandlerC0343b handlerC0343b2 = this.j;
                if (handlerC0343b2 != null) {
                    handlerC0343b2.sendEmptyMessage(2);
                }
                b.a.p0.a.j1.d.d.d dVar = this.f7553i;
                if (dVar != null) {
                    dVar.a(true, null, this.f7550f);
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

    @Override // b.a.p0.a.p.d.x
    public void a(Activity activity, Bundle bundle, b.a.p0.a.j1.d.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, dVar) == null) {
            b.a.p0.a.z2.q.k(new b(activity, bundle, dVar), "main process compress files");
        }
    }
}
