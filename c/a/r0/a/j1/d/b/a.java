package c.a.r0.a.j1.d.b;

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
import c.a.r0.a.z2.k0;
import c.a.r0.a.z2.n0;
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
    public Activity f7553e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f7554f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.a.j1.d.d.e f7555g;

    /* renamed from: h  reason: collision with root package name */
    public int f7556h;

    /* renamed from: i  reason: collision with root package name */
    public int f7557i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout.LayoutParams f7558j;

    /* renamed from: c.a.r0.a.j1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0431a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7559e;

        public View$OnClickListenerC0431a(a aVar) {
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
            this.f7559e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7559e.m();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7560e;

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
            this.f7560e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7560e.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.r0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7561e;

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
            this.f7561e = aVar;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7561e.u();
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.r0.a.j1.d.d.b {
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

        @Override // c.a.r0.a.j1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                c.a.r0.a.j1.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", c.a.r0.a.j1.d.c.d.f7595e);
                bundle.putString("swanAppId", c.a.r0.a.j1.d.c.d.f7596f);
                bundle.putParcelableArrayList("mediaModels", c.a.r0.a.j1.d.c.e.e());
                bundle.putString("swanTmpPath", c.a.r0.a.j1.d.c.d.f7600j);
                c.a.r0.a.j1.d.c.d.g(this.a.f7553e, bundle);
            }
        }

        @Override // c.a.r0.a.j1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.r0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7562e;

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
            this.f7562e = aVar;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7562e.t();
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.r0.a.j1.d.d.b {
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

        @Override // c.a.r0.a.j1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.r0.a.j1.d.c.e.i(c.a.r0.a.j1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", c.a.r0.a.j1.d.c.d.f7595e);
                bundle.putString("swanAppId", c.a.r0.a.j1.d.c.d.f7596f);
                bundle.putParcelableArrayList("mediaModels", c.a.r0.a.j1.d.c.e.e());
                bundle.putString("swanTmpPath", c.a.r0.a.j1.d.c.d.f7600j);
                c.a.r0.a.j1.d.c.d.g(this.a.f7553e, bundle);
            }
        }

        @Override // c.a.r0.a.j1.d.d.b
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
        public final /* synthetic */ MediaModel f7563e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f7564f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7565g;

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
            this.f7565g = aVar;
            this.f7563e = mediaModel;
            this.f7564f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7565g.l(this.f7563e, this.f7564f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f7566e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7567f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7568g;

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
            this.f7568g = aVar;
            this.f7566e = mediaModel;
            this.f7567f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7568g.j(this.f7566e, this.f7567f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoModel f7569e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f7570f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7571g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7572h;

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
            this.f7572h = aVar;
            this.f7569e = videoModel;
            this.f7570f = mediaModel;
            this.f7571g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f7572h.s(this.f7569e.getPath()) && !this.f7572h.n(this.f7569e.getDuration())) {
                this.f7572h.j(this.f7570f, this.f7571g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f7573b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f7574c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f7575d;

        /* renamed from: e  reason: collision with root package name */
        public View f7576e;

        /* renamed from: f  reason: collision with root package name */
        public View f7577f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f7578g;

        /* renamed from: h  reason: collision with root package name */
        public View f7579h;

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
            this.a = (SimpleDraweeView) view.findViewById(c.a.r0.a.f.album_item_img);
            this.f7575d = (ImageView) view.findViewById(c.a.r0.a.f.album_item_select_checkbox);
            this.f7574c = (TextView) view.findViewById(c.a.r0.a.f.album_item_select_number);
            this.f7577f = view.findViewById(c.a.r0.a.f.album_item_selected_check);
            this.f7576e = view.findViewById(c.a.r0.a.f.album_item_select_circle_view);
            this.f7573b = (ImageView) view.findViewById(c.a.r0.a.f.album_item_unable_shadow);
            this.f7579h = view.findViewById(c.a.r0.a.f.album_item_tip_bg);
            this.f7578g = (TextView) view.findViewById(c.a.r0.a.f.album_item_right_bottom_tip);
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
        this.f7553e = activity;
        this.f7554f = new ArrayList<>();
        int o = n0.o(this.f7553e);
        int n = n0.n(this.f7553e);
        this.f7556h = o / 4;
        this.f7557i = n / 4;
        this.f7558j = new FrameLayout.LayoutParams((o - n0.f(this.f7553e, 10.0f)) / 4, (o - n0.f(this.f7553e, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jVar, view) == null) {
            Resources resources = this.f7553e.getResources();
            view.setBackgroundColor(-1);
            jVar.a.setBackgroundColor(resources.getColor(c.a.r0.a.c.swanapp_album_item_select_bg));
            jVar.f7574c.setTextColor(resources.getColor(c.a.r0.a.c.swanapp_album_select_number_color));
            jVar.f7579h.setBackground(resources.getDrawable(c.a.r0.a.e.swanapp_album_item_duration_bg));
            jVar.f7578g.setTextColor(-1);
            jVar.f7573b.setBackgroundColor(resources.getColor(c.a.r0.a.c.swanapp_album_unenable_shadow_color));
            jVar.a.setLayoutParams(this.f7558j);
            jVar.f7573b.setLayoutParams(this.f7558j);
            jVar.f7573b.setVisibility(8);
            jVar.f7574c.setVisibility(8);
            jVar.f7577f.setVisibility(8);
            jVar.f7579h.setVisibility(8);
            jVar.f7577f.setVisibility(0);
            jVar.f7575d.setImageResource(c.a.r0.a.e.swanapp_album_unselect_thumb_icon);
            jVar.f7579h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f7579h.getLayoutParams();
            layoutParams.width = this.f7553e.getResources().getDimensionPixelSize(c.a.r0.a.d.swanapp_album_item_tip_width);
            layoutParams.height = this.f7553e.getResources().getDimensionPixelSize(c.a.r0.a.d.swanapp_album_item_time_height);
            jVar.f7579h.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.r0.a.j1.d.c.d.f7598h ? this.f7554f.size() + 1 : this.f7554f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (c.a.r0.a.j1.d.c.d.f7598h) {
                if (i2 == 0) {
                    return null;
                }
                return this.f7554f.get(i2 - 1);
            }
            return this.f7554f.get(i2);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (c.a.r0.a.j1.d.c.d.f7598h && i2 == 0) ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                View inflate = LayoutInflater.from(this.f7553e).inflate(c.a.r0.a.g.swanapp_album_camera_item, (ViewGroup) null, false);
                r(inflate);
                return inflate;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f7553e).inflate(c.a.r0.a.g.swanapp_album_select_item, (ViewGroup) null);
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
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, mediaModel, i2) == null) || c.a.r0.a.j1.d.c.d.f(c.a.r0.a.j1.d.c.d.f7594d, mediaModel)) {
            return;
        }
        if (c.a.r0.a.j1.d.c.d.f7598h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", c.a.r0.a.j1.d.c.d.f7595e);
        bundle.putString("swanAppId", c.a.r0.a.j1.d.c.d.f7596f);
        bundle.putString("mode", c.a.r0.a.j1.d.c.d.f7594d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        c.a.r0.a.j1.d.c.d.k(this.f7553e, bundle);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (c.a.r0.a.j1.d.c.e.d() >= c.a.r0.a.j1.d.c.d.f7593c) {
                c.a.r0.a.j1.d.c.d.j(c.a.r0.a.j1.d.c.d.f7594d);
            } else if (k0.c() < 52428800) {
                c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7553e.getResources().getString(c.a.r0.a.h.swanapp_album_camera_no_storage)).G();
            } else {
                p(this.f7553e);
            }
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, mediaModel, jVar) == null) {
            int d2 = c.a.r0.a.j1.d.c.e.d();
            if (!c.a.r0.a.j1.d.c.e.f(mediaModel)) {
                if (d2 >= c.a.r0.a.j1.d.c.d.f7593c) {
                    c.a.r0.a.j1.d.c.d.j(c.a.r0.a.j1.d.c.d.f7594d);
                    return;
                } else if (d2 > 0 && TextUtils.equals(c.a.r0.a.j1.d.c.d.f7594d, "single") && !TextUtils.equals(c.a.r0.a.j1.d.c.e.b(), mediaModel.getType())) {
                    c.a.r0.a.c2.b.f.e.f(this.f7553e, c.a.r0.a.h.swanapp_album_select_single).G();
                    return;
                } else if (mediaModel.getSize() <= 52428800 || !TextUtils.equals(mediaModel.getType(), "image")) {
                    jVar.f7575d.setImageResource(c.a.r0.a.e.swanapp_album_select_icon_bg);
                    jVar.f7574c.setVisibility(0);
                    jVar.f7574c.setText(String.valueOf(c.a.r0.a.j1.d.c.e.c(mediaModel) + 1));
                    c.a.r0.a.j1.d.c.e.i(mediaModel);
                    jVar.f7576e.startAnimation(AnimationUtils.loadAnimation(this.f7553e, c.a.r0.a.a.swanapp_album_checkshake));
                    c.a.r0.a.j1.d.d.e eVar = this.f7555g;
                    if (eVar != null) {
                        eVar.a(d2);
                    }
                    notifyDataSetChanged();
                    return;
                } else {
                    c.a.r0.a.c2.b.f.e.f(this.f7553e, c.a.r0.a.h.swanapp_album_photo_too_big).G();
                    return;
                }
            }
            c.a.r0.a.j1.d.c.e.h(mediaModel);
            jVar.f7575d.setImageResource(c.a.r0.a.e.swanapp_album_unselect_thumb_icon);
            jVar.f7574c.setVisibility(8);
            c.a.r0.a.j1.d.d.e eVar2 = this.f7555g;
            if (eVar2 != null) {
                eVar2.a(d2);
            }
            notifyDataSetChanged();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (c.a.r0.a.j1.d.c.e.d() >= c.a.r0.a.j1.d.c.d.f7593c) {
                c.a.r0.a.j1.d.c.d.j(c.a.r0.a.j1.d.c.d.f7594d);
            } else {
                q(this.f7553e);
            }
        }
    }

    public final boolean n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            if (j2 < 3000) {
                c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7553e.getString(c.a.r0.a.h.swanapp_album_video_duration_min)).G();
                return true;
            } else if (j2 > 300000) {
                c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7553e.getString(c.a.r0.a.h.swanapp_album_video_duration_max)).G();
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
            return j4 == 0 ? this.f7553e.getString(c.a.r0.a.h.swanapp_video_duration, new Object[]{format, format2}) : this.f7553e.getString(c.a.r0.a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
        }
        return (String) invokeJ.objValue;
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            c.a.r0.a.v1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e(this));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            c.a.r0.a.v1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c(this));
        }
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            view.findViewById(c.a.r0.a.f.album_camera_enter).setLayoutParams(this.f7558j);
            view.setTag(null);
            view.setClickable(true);
            ImageView imageView = (ImageView) view.findViewById(c.a.r0.a.f.album_camera_icon);
            if (TextUtils.equals(c.a.r0.a.j1.d.c.d.f7592b, "Image")) {
                imageView.setImageResource(c.a.r0.a.e.swanapp_album_camera_item_selector);
                view.setOnClickListener(new View$OnClickListenerC0431a(this));
                return;
            }
            imageView.setImageResource(c.a.r0.a.e.swanapp_album_camera_video_selector);
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
                if (c.a.r0.a.j1.d.c.c.a) {
                    e.printStackTrace();
                }
                str2 = "";
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7553e.getString(c.a.r0.a.h.swanapp_album_video_format)).G();
                return false;
            }
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e4) {
                    if (c.a.r0.a.j1.d.c.c.a) {
                        e4.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
                return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
            }
            c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7553e.getString(c.a.r0.a.h.swanapp_album_video_format)).G();
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.r0.a.j1.d.c.b.e(this.f7553e, c.a.r0.a.j1.d.c.d.f7596f, c.a.r0.a.j1.d.c.d.f7597g, c.a.r0.a.j1.d.c.d.f7599i, new f(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.r0.a.j1.d.c.b.f(this.f7553e, c.a.r0.a.j1.d.c.d.f7596f, new d(this));
        }
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, mediaModel, jVar, i2) == null) {
            if (c.a.r0.a.j1.d.c.e.f(mediaModel)) {
                jVar.f7575d.setImageResource(c.a.r0.a.e.swanapp_album_select_icon_bg);
                jVar.f7574c.setVisibility(0);
                jVar.f7574c.setText(String.valueOf(c.a.r0.a.j1.d.c.e.c(mediaModel) + 1));
            }
            if (c.a.r0.a.j1.d.c.d.f(c.a.r0.a.j1.d.c.d.f7594d, mediaModel)) {
                jVar.f7573b.setVisibility(0);
            } else {
                jVar.f7573b.setVisibility(8);
            }
            if (!c.a.r0.a.j1.d.c.c.f7591d) {
                jVar.f7579h.setVisibility(8);
            } else if (c.a.r0.a.j1.d.c.d.d(mediaModel.getPath())) {
                jVar.f7578g.setText(this.f7553e.getString(c.a.r0.a.h.swanapp_album_gif_photo));
            } else if (c.a.r0.a.j1.d.c.d.e(mediaModel.getPath())) {
                jVar.f7578g.setText(this.f7553e.getString(c.a.r0.a.h.swanapp_album_large_photo));
            } else {
                jVar.f7579h.setVisibility(8);
            }
            jVar.f7577f.setOnClickListener(new g(this, mediaModel, jVar));
            jVar.a.setOnClickListener(new h(this, mediaModel, i2));
        }
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048596, this, mediaModel, jVar, i2) == null) && (mediaModel instanceof VideoModel)) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f7579h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f7579h.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.f7553e.getResources().getDimensionPixelSize(c.a.r0.a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.f7553e.getResources().getDimensionPixelSize(c.a.r0.a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.f7553e.getResources().getDimensionPixelSize(c.a.r0.a.d.swanapp_album_item_time_height);
            jVar.f7579h.setLayoutParams(layoutParams);
            jVar.f7578g.setText(o(videoModel.getDuration()));
            jVar.a.setOnClickListener(new i(this, videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.f7554f.size() > 0) {
                this.f7554f.clear();
            }
            this.f7554f.addAll(arrayList);
            c.a.r0.a.j1.d.c.d.i(this.f7554f);
            notifyDataSetChanged();
        }
    }

    public final void y(String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, jVar) == null) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
            newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f7556h / 2.0f), (int) (this.f7557i / 2.0f)));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
            AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.a.getController()).build();
            jVar.a.setController(build);
            DraweeHierarchy hierarchy = build.getHierarchy();
            if (hierarchy instanceof GenericDraweeHierarchy) {
                c.a.r0.a.c1.a.C().c((GenericDraweeHierarchy) hierarchy, false);
            }
        }
    }

    public void z(c.a.r0.a.j1.d.d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.f7555g = eVar;
        }
    }
}
