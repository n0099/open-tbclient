package com.baidu.swan.apps.media.chooser.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.swan.apps.media.image.HugePhotoDraweeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SwanAppAlbumPreviewAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<MediaModel> a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<View> f38910b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f38911c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a.j1.d.d.a f38912d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f38913e;

    /* renamed from: f  reason: collision with root package name */
    public h f38914f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a.j1.d.e.a f38915g;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f38916e;

        public a(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38916e = swanAppAlbumPreviewAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38916e.f38912d == null) {
                return;
            }
            this.f38916e.f38912d.clickContainer();
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f38917e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f38918f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f38919g;

        public b(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar, MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar, mediaModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38919g = swanAppAlbumPreviewAdapter;
            this.f38917e = hVar;
            this.f38918f = mediaModel;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f38919g.n(this.f38917e, (ImageModel) this.f38918f);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f38920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f38921f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f38922g;

        /* loaded from: classes11.dex */
        public class a implements MediaPlayer.OnPreparedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f38923e;

            /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes11.dex */
            public class RunnableC1886a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f38924e;

                public RunnableC1886a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38924e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c cVar = this.f38924e.f38923e;
                        cVar.f38922g.q(cVar.f38920e);
                    }
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38923e = cVar;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                    this.f38923e.f38920e.f38932d.postDelayed(new RunnableC1886a(this), 300L);
                }
            }
        }

        /* loaded from: classes11.dex */
        public class b implements MediaPlayer.OnErrorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f38925e;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38925e = cVar;
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    c cVar = this.f38925e;
                    cVar.f38922g.o(cVar.f38920e);
                    return false;
                }
                return invokeLII.booleanValue;
            }
        }

        /* renamed from: com.baidu.swan.apps.media.chooser.adapter.SwanAppAlbumPreviewAdapter$c$c  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C1887c implements MediaPlayer.OnCompletionListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f38926e;

            public C1887c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38926e = cVar;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                    c cVar = this.f38926e;
                    cVar.f38922g.o(cVar.f38920e);
                }
            }
        }

        public c(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar, MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar, mediaModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38922g = swanAppAlbumPreviewAdapter;
            this.f38920e = hVar;
            this.f38921f = mediaModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38920e.f38932d.isPlaying()) {
                return;
            }
            this.f38920e.f38931c.setVisibility(0);
            this.f38920e.f38932d.setVisibility(0);
            this.f38920e.f38933e.setVisibility(8);
            if (this.f38922g.f38912d != null) {
                this.f38922g.f38912d.hideBar();
            }
            MediaController mediaController = new MediaController(this.f38922g.f38911c);
            mediaController.setVisibility(8);
            mediaController.setAnchorView(null);
            this.f38920e.f38932d.setMediaController(mediaController);
            this.f38920e.f38932d.setVideoPath(this.f38921f.getPath());
            this.f38920e.f38932d.setOnPreparedListener(new a(this));
            this.f38920e.f38932d.setOnErrorListener(new b(this));
            this.f38920e.f38932d.setOnCompletionListener(new C1887c(this));
            this.f38920e.f38932d.start();
            this.f38922g.f38914f = this.f38920e;
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f38927e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f38928f;

        public d(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38928f = swanAppAlbumPreviewAdapter;
            this.f38927e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f38927e.f38932d.isPlaying()) {
                this.f38927e.f38932d.stopPlayback();
                this.f38928f.o(this.f38927e);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public e(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.f38930b.setVisibility(8);
                this.a.f38930b.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public f(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.f38930b.setVisibility(0);
                this.a.f38930b.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g extends BaseControllerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HugePhotoDraweeView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAlbumPreviewAdapter f38929b;

        public g(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, HugePhotoDraweeView hugePhotoDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, hugePhotoDraweeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38929b = swanAppAlbumPreviewAdapter;
            this.a = hugePhotoDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, th) == null) {
                super.onFailure(str, th);
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj, animatable) == null) {
                super.onFinalImageSet(str, obj, animatable);
                if (obj instanceof CloseableStaticBitmap) {
                    this.a.setIsDynamicBitmap(false);
                    this.a.setZoomEnabled(true);
                    Bitmap underlyingBitmap = ((CloseableStaticBitmap) obj).getUnderlyingBitmap();
                    this.f38929b.f38913e = u.j();
                    c.a.r0.a.j1.e.b b2 = c.a.r0.a.j1.e.b.b(underlyingBitmap);
                    if (b2 == null) {
                        return;
                    }
                    if (underlyingBitmap.getWidth() < this.f38929b.f38913e[0] && underlyingBitmap.getHeight() < this.f38929b.f38913e[0]) {
                        b2.m();
                    } else {
                        b2.n();
                    }
                    this.a.setImage(b2);
                    this.f38929b.m(this.a, underlyingBitmap);
                } else if (obj instanceof CloseableAnimatedImage) {
                    this.a.setIsDynamicBitmap(true);
                    this.a.setZoomEnabled(false);
                    this.a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
                }
            }
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onSubmit(String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) {
                super.onSubmit(str, obj);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public HugePhotoDraweeView f38930b;

        /* renamed from: c  reason: collision with root package name */
        public View f38931c;

        /* renamed from: d  reason: collision with root package name */
        public VideoView f38932d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f38933e;

        public h(SwanAppAlbumPreviewAdapter swanAppAlbumPreviewAdapter, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAlbumPreviewAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
            this.f38930b = (HugePhotoDraweeView) view.findViewById(c.a.r0.a.f.album_preview_image);
            this.f38931c = view.findViewById(c.a.r0.a.f.preview_video_layout);
            this.f38932d = (VideoView) view.findViewById(c.a.r0.a.f.preview_video_view);
            this.f38933e = (ImageView) view.findViewById(c.a.r0.a.f.video_preview);
        }
    }

    public SwanAppAlbumPreviewAdapter(Activity activity, ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38913e = new int[1];
        this.f38911c = activity;
        this.a = arrayList;
        this.f38910b = new SparseArray<>();
    }

    public void destroy() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hVar = this.f38914f) == null) {
            return;
        }
        VideoView videoView = hVar.f38932d;
        if (videoView != null && videoView.isPlaying()) {
            videoView.stopPlayback();
        }
        this.f38914f.f38932d = null;
        this.f38914f = null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            MediaModel mediaModel = this.a.get(i2);
            View view = this.f38910b.get(i2);
            if (view == null) {
                view = LayoutInflater.from(this.f38911c).inflate(c.a.r0.a.g.swanapp_album_preview_item, viewGroup, false);
                hVar = new h(this, view);
                view.setTag(hVar);
                this.f38910b.put(i2, view);
            } else {
                hVar = (h) view.getTag();
            }
            k(hVar, mediaModel);
            l(hVar, mediaModel);
            viewGroup.addView(view);
            return view;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public final ControllerListener j(HugePhotoDraweeView hugePhotoDraweeView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hugePhotoDraweeView)) == null) ? new g(this, hugePhotoDraweeView) : (ControllerListener) invokeL.objValue;
    }

    public final void k(h hVar, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, hVar, mediaModel) == null) || hVar == null || mediaModel == null || TextUtils.isEmpty(mediaModel.getPath())) {
            return;
        }
        ControllerListener j2 = j(hVar.f38930b);
        String path = mediaModel.getPath();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(path.startsWith("http") ? Uri.parse(path) : Uri.fromFile(new File(mediaModel.getPath())));
        newBuilderWithSource.setResizeOptions(new ResizeOptions(n0.o(this.f38911c), n0.n(this.f38911c), 10240.0f));
        newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(c.a.r0.a.j1.d.c.c.f7568d).setImageRequest(newBuilderWithSource.build()).setControllerListener(j2).setOldController(hVar.f38930b.getController()).build();
        hVar.f38930b.setVisibility(0);
        hVar.f38930b.setController(build);
        if (mediaModel instanceof ImageModel) {
            hVar.f38931c.setVisibility(8);
            hVar.f38930b.setOnClickListener(new a(this));
            hVar.f38930b.setOnLongClickListener(new b(this, hVar, mediaModel));
        }
    }

    public final void l(h hVar, MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar, mediaModel) == null) {
            if (!(mediaModel instanceof VideoModel)) {
                hVar.f38933e.setVisibility(8);
            } else if (hVar == null || TextUtils.isEmpty(mediaModel.getPath())) {
            } else {
                hVar.f38931c.setVisibility(8);
                hVar.f38932d.setVisibility(8);
                hVar.f38933e.setVisibility(0);
                hVar.f38930b.setOnClickListener(new c(this, hVar, mediaModel));
                hVar.f38931c.setOnClickListener(new d(this, hVar));
            }
        }
    }

    public final void m(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, hugePhotoDraweeView, bitmap) == null) {
            int o = n0.o(this.f38911c);
            int n = n0.n(this.f38911c);
            if (bitmap == null || bitmap.getHeight() <= n * 1.6f) {
                return;
            }
            float width = bitmap.getWidth() == 0 ? 1.0f : o / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(o / 2, 0.0f));
        }
    }

    public final void n(h hVar, ImageModel imageModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, hVar, imageModel) == null) {
            if (this.f38915g == null) {
                this.f38915g = new c.a.r0.a.j1.d.e.a(this.f38911c);
            }
            this.f38915g.i(hVar.a, imageModel.getPath());
        }
    }

    public final void o(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            p(hVar, true);
        }
    }

    public final void p(h hVar, boolean z) {
        c.a.r0.a.j1.d.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048588, this, hVar, z) == null) || hVar == null) {
            return;
        }
        hVar.f38933e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f38911c, c.a.r0.a.a.swanapp_album_preview_img_enter);
        loadAnimation.setAnimationListener(new f(this, hVar));
        hVar.f38930b.startAnimation(loadAnimation);
        if (!z || (aVar = this.f38912d) == null) {
            return;
        }
        aVar.showBar();
    }

    public void pageScrollStateChanged() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (hVar = this.f38914f) == null || hVar.f38932d == null || !this.f38914f.f38932d.isPlaying()) {
            return;
        }
        this.f38914f.f38932d.stopPlayback();
        p(this.f38914f, false);
    }

    public final void q(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hVar) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f38911c, c.a.r0.a.a.swanapp_album_preview_img_exit);
            loadAnimation.setAnimationListener(new e(this, hVar));
            hVar.f38930b.startAnimation(loadAnimation);
        }
    }

    public void setCurrentViewBackground(int i2, @ColorInt int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || i2 >= this.f38910b.size() || this.f38910b.get(i2) == null) {
            return;
        }
        this.f38910b.get(i2).findViewById(c.a.r0.a.f.album_preview_item_root).setBackgroundColor(i3);
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            this.a = arrayList;
            this.f38910b.clear();
            notifyDataSetChanged();
        }
    }

    public void setListener(c.a.r0.a.j1.d.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            this.f38912d = aVar;
        }
    }
}
