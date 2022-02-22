package c.a.s0.a.j1.d.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.z2.k0;
import c.a.s0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f7630e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f7631f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.a.j1.d.d.e f7632g;

    /* renamed from: h  reason: collision with root package name */
    public int f7633h;

    /* renamed from: i  reason: collision with root package name */
    public int f7634i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout.LayoutParams f7635j;

    /* renamed from: c.a.s0.a.j1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0460a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7636e;

        public View$OnClickListenerC0460a(a aVar) {
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
            this.f7636e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7636e.m();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7637e;

        public b(a aVar) {
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
            this.f7637e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7637e.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.s0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7638e;

        public c(a aVar) {
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
            this.f7638e = aVar;
        }

        @Override // c.a.s0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7638e.u();
            }
        }

        @Override // c.a.s0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.s0.a.j1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.s0.a.j1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                c.a.s0.a.j1.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", c.a.s0.a.j1.d.c.d.f7672e);
                bundle.putString("swanAppId", c.a.s0.a.j1.d.c.d.f7673f);
                bundle.putParcelableArrayList("mediaModels", c.a.s0.a.j1.d.c.e.e());
                bundle.putString("swanTmpPath", c.a.s0.a.j1.d.c.d.f7677j);
                c.a.s0.a.j1.d.c.d.g(this.a.f7630e, bundle);
            }
        }

        @Override // c.a.s0.a.j1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.s0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7639e;

        public e(a aVar) {
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
            this.f7639e = aVar;
        }

        @Override // c.a.s0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7639e.t();
            }
        }

        @Override // c.a.s0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.s0.a.j1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public f(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.s0.a.j1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.s0.a.j1.d.c.e.i(c.a.s0.a.j1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", c.a.s0.a.j1.d.c.d.f7672e);
                bundle.putString("swanAppId", c.a.s0.a.j1.d.c.d.f7673f);
                bundle.putParcelableArrayList("mediaModels", c.a.s0.a.j1.d.c.e.e());
                bundle.putString("swanTmpPath", c.a.s0.a.j1.d.c.d.f7677j);
                c.a.s0.a.j1.d.c.d.g(this.a.f7630e, bundle);
            }
        }

        @Override // c.a.s0.a.j1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f7640e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f7641f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7642g;

        public g(a aVar, MediaModel mediaModel, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mediaModel, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7642g = aVar;
            this.f7640e = mediaModel;
            this.f7641f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7642g.l(this.f7640e, this.f7641f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f7643e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7644f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7645g;

        public h(a aVar, MediaModel mediaModel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mediaModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7645g = aVar;
            this.f7643e = mediaModel;
            this.f7644f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7645g.j(this.f7643e, this.f7644f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoModel f7646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f7647f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7648g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7649h;

        public i(a aVar, VideoModel videoModel, MediaModel mediaModel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, videoModel, mediaModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7649h = aVar;
            this.f7646e = videoModel;
            this.f7647f = mediaModel;
            this.f7648g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f7649h.s(this.f7646e.getPath()) && !this.f7649h.n(this.f7646e.getDuration())) {
                this.f7649h.j(this.f7647f, this.f7648g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f7650b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f7651c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f7652d;

        /* renamed from: e  reason: collision with root package name */
        public View f7653e;

        /* renamed from: f  reason: collision with root package name */
        public View f7654f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f7655g;

        /* renamed from: h  reason: collision with root package name */
        public View f7656h;

        public j(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (SimpleDraweeView) view.findViewById(c.a.s0.a.f.album_item_img);
            this.f7652d = (ImageView) view.findViewById(c.a.s0.a.f.album_item_select_checkbox);
            this.f7651c = (TextView) view.findViewById(c.a.s0.a.f.album_item_select_number);
            this.f7654f = view.findViewById(c.a.s0.a.f.album_item_selected_check);
            this.f7653e = view.findViewById(c.a.s0.a.f.album_item_select_circle_view);
            this.f7650b = (ImageView) view.findViewById(c.a.s0.a.f.album_item_unable_shadow);
            this.f7656h = view.findViewById(c.a.s0.a.f.album_item_tip_bg);
            this.f7655g = (TextView) view.findViewById(c.a.s0.a.f.album_item_right_bottom_tip);
        }
    }

    public a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7630e = activity;
        this.f7631f = new ArrayList<>();
        int o = n0.o(this.f7630e);
        int n = n0.n(this.f7630e);
        this.f7633h = o / 4;
        this.f7634i = n / 4;
        this.f7635j = new FrameLayout.LayoutParams((o - n0.f(this.f7630e, 10.0f)) / 4, (o - n0.f(this.f7630e, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jVar, view) == null) {
            Resources resources = this.f7630e.getResources();
            view.setBackgroundColor(-1);
            jVar.a.setBackgroundColor(resources.getColor(c.a.s0.a.c.swanapp_album_item_select_bg));
            jVar.f7651c.setTextColor(resources.getColor(c.a.s0.a.c.swanapp_album_select_number_color));
            jVar.f7656h.setBackground(resources.getDrawable(c.a.s0.a.e.swanapp_album_item_duration_bg));
            jVar.f7655g.setTextColor(-1);
            jVar.f7650b.setBackgroundColor(resources.getColor(c.a.s0.a.c.swanapp_album_unenable_shadow_color));
            jVar.a.setLayoutParams(this.f7635j);
            jVar.f7650b.setLayoutParams(this.f7635j);
            jVar.f7650b.setVisibility(8);
            jVar.f7651c.setVisibility(8);
            jVar.f7654f.setVisibility(8);
            jVar.f7656h.setVisibility(8);
            jVar.f7654f.setVisibility(0);
            jVar.f7652d.setImageResource(c.a.s0.a.e.swanapp_album_unselect_thumb_icon);
            jVar.f7656h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f7656h.getLayoutParams();
            layoutParams.width = this.f7630e.getResources().getDimensionPixelSize(c.a.s0.a.d.swanapp_album_item_tip_width);
            layoutParams.height = this.f7630e.getResources().getDimensionPixelSize(c.a.s0.a.d.swanapp_album_item_time_height);
            jVar.f7656h.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.s0.a.j1.d.c.d.f7675h ? this.f7631f.size() + 1 : this.f7631f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (c.a.s0.a.j1.d.c.d.f7675h) {
                if (i2 == 0) {
                    return null;
                }
                return this.f7631f.get(i2 - 1);
            }
            return this.f7631f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (c.a.s0.a.j1.d.c.d.f7675h && i2 == 0) ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                View inflate = LayoutInflater.from(this.f7630e).inflate(c.a.s0.a.g.swanapp_album_camera_item, (ViewGroup) null, false);
                r(inflate);
                return inflate;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f7630e).inflate(c.a.s0.a.g.swanapp_album_select_item, (ViewGroup) null);
                jVar = new j(this, view);
                view.setTag(jVar);
            } else {
                jVar = (j) view.getTag();
            }
            A(jVar, view);
            MediaModel mediaModel = (MediaModel) getItem(i2);
            if (mediaModel == null) {
                return view;
            }
            y(mediaModel.getPath(), jVar);
            v(mediaModel, jVar, i2);
            w(mediaModel, jVar, i2);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public final void j(MediaModel mediaModel, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, mediaModel, i2) == null) || c.a.s0.a.j1.d.c.d.f(c.a.s0.a.j1.d.c.d.f7671d, mediaModel)) {
            return;
        }
        if (c.a.s0.a.j1.d.c.d.f7675h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", c.a.s0.a.j1.d.c.d.f7672e);
        bundle.putString("swanAppId", c.a.s0.a.j1.d.c.d.f7673f);
        bundle.putString("mode", c.a.s0.a.j1.d.c.d.f7671d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        c.a.s0.a.j1.d.c.d.k(this.f7630e, bundle);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (c.a.s0.a.j1.d.c.e.d() >= c.a.s0.a.j1.d.c.d.f7670c) {
                c.a.s0.a.j1.d.c.d.j(c.a.s0.a.j1.d.c.d.f7671d);
            } else if (k0.c() < 52428800) {
                c.a.s0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7630e.getResources().getString(c.a.s0.a.h.swanapp_album_camera_no_storage)).G();
            } else {
                p(this.f7630e);
            }
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, mediaModel, jVar) == null) {
            int d2 = c.a.s0.a.j1.d.c.e.d();
            if (!c.a.s0.a.j1.d.c.e.f(mediaModel)) {
                if (d2 >= c.a.s0.a.j1.d.c.d.f7670c) {
                    c.a.s0.a.j1.d.c.d.j(c.a.s0.a.j1.d.c.d.f7671d);
                    return;
                } else if (d2 > 0 && TextUtils.equals(c.a.s0.a.j1.d.c.d.f7671d, "single") && !TextUtils.equals(c.a.s0.a.j1.d.c.e.b(), mediaModel.getType())) {
                    c.a.s0.a.c2.b.f.e.f(this.f7630e, c.a.s0.a.h.swanapp_album_select_single).G();
                    return;
                } else if (mediaModel.getSize() <= 52428800 || !TextUtils.equals(mediaModel.getType(), "image")) {
                    jVar.f7652d.setImageResource(c.a.s0.a.e.swanapp_album_select_icon_bg);
                    jVar.f7651c.setVisibility(0);
                    jVar.f7651c.setText(String.valueOf(c.a.s0.a.j1.d.c.e.c(mediaModel) + 1));
                    c.a.s0.a.j1.d.c.e.i(mediaModel);
                    jVar.f7653e.startAnimation(AnimationUtils.loadAnimation(this.f7630e, c.a.s0.a.a.swanapp_album_checkshake));
                    c.a.s0.a.j1.d.d.e eVar = this.f7632g;
                    if (eVar != null) {
                        eVar.a(d2);
                    }
                    notifyDataSetChanged();
                    return;
                } else {
                    c.a.s0.a.c2.b.f.e.f(this.f7630e, c.a.s0.a.h.swanapp_album_photo_too_big).G();
                    return;
                }
            }
            c.a.s0.a.j1.d.c.e.h(mediaModel);
            jVar.f7652d.setImageResource(c.a.s0.a.e.swanapp_album_unselect_thumb_icon);
            jVar.f7651c.setVisibility(8);
            c.a.s0.a.j1.d.d.e eVar2 = this.f7632g;
            if (eVar2 != null) {
                eVar2.a(d2);
            }
            notifyDataSetChanged();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (c.a.s0.a.j1.d.c.e.d() >= c.a.s0.a.j1.d.c.d.f7670c) {
                c.a.s0.a.j1.d.c.d.j(c.a.s0.a.j1.d.c.d.f7671d);
            } else {
                q(this.f7630e);
            }
        }
    }

    public final boolean n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            if (j2 < 3000) {
                c.a.s0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7630e.getString(c.a.s0.a.h.swanapp_album_video_duration_min)).G();
                return true;
            } else if (j2 > 300000) {
                c.a.s0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7630e.getString(c.a.s0.a.h.swanapp_album_video_duration_max)).G();
                return true;
            } else {
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public final String o(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j2)) == null) {
            long j3 = j2 / 1000;
            long j4 = j3 / 3600;
            long j5 = j3 % 3600;
            String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j5 / 60));
            String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j5 % 60));
            return j4 == 0 ? this.f7630e.getString(c.a.s0.a.h.swanapp_video_duration, new Object[]{format, format2}) : this.f7630e.getString(c.a.s0.a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
        }
        return (String) invokeJ.objValue;
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            c.a.s0.a.v1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e(this));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            c.a.s0.a.v1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c(this));
        }
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            view.findViewById(c.a.s0.a.f.album_camera_enter).setLayoutParams(this.f7635j);
            view.setTag(null);
            view.setClickable(true);
            ImageView imageView = (ImageView) view.findViewById(c.a.s0.a.f.album_camera_icon);
            if (TextUtils.equals(c.a.s0.a.j1.d.c.d.f7669b, "Image")) {
                imageView.setImageResource(c.a.s0.a.e.swanapp_album_camera_item_selector);
                view.setOnClickListener(new View$OnClickListenerC0460a(this));
                return;
            }
            imageView.setImageResource(c.a.s0.a.e.swanapp_album_camera_video_selector);
            view.setOnClickListener(new b(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean s(String str) {
        InterceptResult invokeL;
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception e2) {
                e = e2;
            }
            try {
                mediaMetadataRetriever.setDataSource(str);
                str2 = mediaMetadataRetriever.extractMetadata(12);
            } catch (Exception e3) {
                e = e3;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (c.a.s0.a.j1.d.c.c.a) {
                    e.printStackTrace();
                }
                str2 = "";
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                c.a.s0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7630e.getString(c.a.s0.a.h.swanapp_album_video_format)).G();
                return false;
            }
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e4) {
                    if (c.a.s0.a.j1.d.c.c.a) {
                        e4.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
                return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
            }
            c.a.s0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7630e.getString(c.a.s0.a.h.swanapp_album_video_format)).G();
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.s0.a.j1.d.c.b.e(this.f7630e, c.a.s0.a.j1.d.c.d.f7673f, c.a.s0.a.j1.d.c.d.f7674g, c.a.s0.a.j1.d.c.d.f7676i, new f(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.s0.a.j1.d.c.b.f(this.f7630e, c.a.s0.a.j1.d.c.d.f7673f, new d(this));
        }
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, mediaModel, jVar, i2) == null) {
            if (c.a.s0.a.j1.d.c.e.f(mediaModel)) {
                jVar.f7652d.setImageResource(c.a.s0.a.e.swanapp_album_select_icon_bg);
                jVar.f7651c.setVisibility(0);
                jVar.f7651c.setText(String.valueOf(c.a.s0.a.j1.d.c.e.c(mediaModel) + 1));
            }
            if (c.a.s0.a.j1.d.c.d.f(c.a.s0.a.j1.d.c.d.f7671d, mediaModel)) {
                jVar.f7650b.setVisibility(0);
            } else {
                jVar.f7650b.setVisibility(8);
            }
            if (!c.a.s0.a.j1.d.c.c.f7668d) {
                jVar.f7656h.setVisibility(8);
            } else if (c.a.s0.a.j1.d.c.d.d(mediaModel.getPath())) {
                jVar.f7655g.setText(this.f7630e.getString(c.a.s0.a.h.swanapp_album_gif_photo));
            } else if (c.a.s0.a.j1.d.c.d.e(mediaModel.getPath())) {
                jVar.f7655g.setText(this.f7630e.getString(c.a.s0.a.h.swanapp_album_large_photo));
            } else {
                jVar.f7656h.setVisibility(8);
            }
            jVar.f7654f.setOnClickListener(new g(this, mediaModel, jVar));
            jVar.a.setOnClickListener(new h(this, mediaModel, i2));
        }
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048596, this, mediaModel, jVar, i2) == null) && (mediaModel instanceof VideoModel)) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f7656h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f7656h.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.f7630e.getResources().getDimensionPixelSize(c.a.s0.a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.f7630e.getResources().getDimensionPixelSize(c.a.s0.a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.f7630e.getResources().getDimensionPixelSize(c.a.s0.a.d.swanapp_album_item_time_height);
            jVar.f7656h.setLayoutParams(layoutParams);
            jVar.f7655g.setText(o(videoModel.getDuration()));
            jVar.a.setOnClickListener(new i(this, videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.f7631f.size() > 0) {
                this.f7631f.clear();
            }
            this.f7631f.addAll(arrayList);
            c.a.s0.a.j1.d.c.d.i(this.f7631f);
            notifyDataSetChanged();
        }
    }

    public final void y(String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, jVar) == null) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
            newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f7633h / 2.0f), (int) (this.f7634i / 2.0f)));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
            AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.a.getController()).build();
            jVar.a.setController(build);
            DraweeHierarchy hierarchy = build.getHierarchy();
            if (hierarchy instanceof GenericDraweeHierarchy) {
                c.a.s0.a.c1.a.C().c((GenericDraweeHierarchy) hierarchy, false);
            }
        }
    }

    public void z(c.a.s0.a.j1.d.d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.f7632g = eVar;
        }
    }
}
