package c.a.p0.a.i1.d.b;

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
import c.a.p0.a.v2.k0;
import c.a.p0.a.v2.n0;
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
    public Activity f6687e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f6688f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.a.i1.d.d.e f6689g;

    /* renamed from: h  reason: collision with root package name */
    public int f6690h;

    /* renamed from: i  reason: collision with root package name */
    public int f6691i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout.LayoutParams f6692j;

    /* renamed from: c.a.p0.a.i1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0262a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6693e;

        public View$OnClickListenerC0262a(a aVar) {
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
            this.f6693e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6693e.m();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6694e;

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
            this.f6694e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6694e.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6695a;

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
            this.f6695a = aVar;
        }

        @Override // c.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f6695a.u();
            }
        }

        @Override // c.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6696a;

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
            this.f6696a = aVar;
        }

        @Override // c.a.p0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                c.a.p0.a.i1.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", c.a.p0.a.i1.d.c.d.f6738e);
                bundle.putString("swanAppId", c.a.p0.a.i1.d.c.d.f6739f);
                bundle.putParcelableArrayList("mediaModels", c.a.p0.a.i1.d.c.e.e());
                bundle.putString("swanTmpPath", c.a.p0.a.i1.d.c.d.f6743j);
                c.a.p0.a.i1.d.c.d.g(this.f6696a.f6687e, bundle);
            }
        }

        @Override // c.a.p0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6697a;

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
            this.f6697a = aVar;
        }

        @Override // c.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f6697a.t();
            }
        }

        @Override // c.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6698a;

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
            this.f6698a = aVar;
        }

        @Override // c.a.p0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.p0.a.i1.d.c.e.i(c.a.p0.a.i1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", c.a.p0.a.i1.d.c.d.f6738e);
                bundle.putString("swanAppId", c.a.p0.a.i1.d.c.d.f6739f);
                bundle.putParcelableArrayList("mediaModels", c.a.p0.a.i1.d.c.e.e());
                bundle.putString("swanTmpPath", c.a.p0.a.i1.d.c.d.f6743j);
                c.a.p0.a.i1.d.c.d.g(this.f6698a.f6687e, bundle);
            }
        }

        @Override // c.a.p0.a.i1.d.d.b
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
        public final /* synthetic */ MediaModel f6699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f6700f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6701g;

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
            this.f6701g = aVar;
            this.f6699e = mediaModel;
            this.f6700f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6701g.l(this.f6699e, this.f6700f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaModel f6702e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6703f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6704g;

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
            this.f6704g = aVar;
            this.f6702e = mediaModel;
            this.f6703f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6704g.j(this.f6702e, this.f6703f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoModel f6705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MediaModel f6706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f6707g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f6708h;

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
            this.f6708h = aVar;
            this.f6705e = videoModel;
            this.f6706f = mediaModel;
            this.f6707g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f6708h.s(this.f6705e.getPath()) && !this.f6708h.n(this.f6705e.getDuration())) {
                this.f6708h.j(this.f6706f, this.f6707g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f6709a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f6710b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f6711c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f6712d;

        /* renamed from: e  reason: collision with root package name */
        public View f6713e;

        /* renamed from: f  reason: collision with root package name */
        public View f6714f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f6715g;

        /* renamed from: h  reason: collision with root package name */
        public View f6716h;

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
            this.f6709a = (SimpleDraweeView) view.findViewById(c.a.p0.a.f.album_item_img);
            this.f6712d = (ImageView) view.findViewById(c.a.p0.a.f.album_item_select_checkbox);
            this.f6711c = (TextView) view.findViewById(c.a.p0.a.f.album_item_select_number);
            this.f6714f = view.findViewById(c.a.p0.a.f.album_item_selected_check);
            this.f6713e = view.findViewById(c.a.p0.a.f.album_item_select_circle_view);
            this.f6710b = (ImageView) view.findViewById(c.a.p0.a.f.album_item_unable_shadow);
            this.f6716h = view.findViewById(c.a.p0.a.f.album_item_tip_bg);
            this.f6715g = (TextView) view.findViewById(c.a.p0.a.f.album_item_right_bottom_tip);
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
        this.f6687e = activity;
        this.f6688f = new ArrayList<>();
        int o = n0.o(this.f6687e);
        int n = n0.n(this.f6687e);
        this.f6690h = o / 4;
        this.f6691i = n / 4;
        this.f6692j = new FrameLayout.LayoutParams((o - n0.f(this.f6687e, 10.0f)) / 4, (o - n0.f(this.f6687e, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jVar, view) == null) {
            Resources resources = this.f6687e.getResources();
            view.setBackgroundColor(-1);
            jVar.f6709a.setBackgroundColor(resources.getColor(c.a.p0.a.c.swanapp_album_item_select_bg));
            jVar.f6711c.setTextColor(resources.getColor(c.a.p0.a.c.swanapp_album_select_number_color));
            jVar.f6716h.setBackground(resources.getDrawable(c.a.p0.a.e.swanapp_album_item_duration_bg));
            jVar.f6715g.setTextColor(-1);
            jVar.f6710b.setBackgroundColor(resources.getColor(c.a.p0.a.c.swanapp_album_unenable_shadow_color));
            jVar.f6709a.setLayoutParams(this.f6692j);
            jVar.f6710b.setLayoutParams(this.f6692j);
            jVar.f6710b.setVisibility(8);
            jVar.f6711c.setVisibility(8);
            jVar.f6714f.setVisibility(8);
            jVar.f6716h.setVisibility(8);
            jVar.f6714f.setVisibility(0);
            jVar.f6712d.setImageResource(c.a.p0.a.e.swanapp_album_unselect_thumb_icon);
            jVar.f6716h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f6716h.getLayoutParams();
            layoutParams.width = this.f6687e.getResources().getDimensionPixelSize(c.a.p0.a.d.swanapp_album_item_tip_width);
            layoutParams.height = this.f6687e.getResources().getDimensionPixelSize(c.a.p0.a.d.swanapp_album_item_time_height);
            jVar.f6716h.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.p0.a.i1.d.c.d.f6741h ? this.f6688f.size() + 1 : this.f6688f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (c.a.p0.a.i1.d.c.d.f6741h) {
                if (i2 == 0) {
                    return null;
                }
                return this.f6688f.get(i2 - 1);
            }
            return this.f6688f.get(i2);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (c.a.p0.a.i1.d.c.d.f6741h && i2 == 0) ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                View inflate = LayoutInflater.from(this.f6687e).inflate(c.a.p0.a.g.swanapp_album_camera_item, (ViewGroup) null, false);
                r(inflate);
                return inflate;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f6687e).inflate(c.a.p0.a.g.swanapp_album_select_item, (ViewGroup) null);
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
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, mediaModel, i2) == null) || c.a.p0.a.i1.d.c.d.f(c.a.p0.a.i1.d.c.d.f6737d, mediaModel)) {
            return;
        }
        if (c.a.p0.a.i1.d.c.d.f6741h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", c.a.p0.a.i1.d.c.d.f6738e);
        bundle.putString("swanAppId", c.a.p0.a.i1.d.c.d.f6739f);
        bundle.putString("mode", c.a.p0.a.i1.d.c.d.f6737d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        c.a.p0.a.i1.d.c.d.k(this.f6687e, bundle);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (c.a.p0.a.i1.d.c.e.d() >= c.a.p0.a.i1.d.c.d.f6736c) {
                c.a.p0.a.i1.d.c.d.j(c.a.p0.a.i1.d.c.d.f6737d);
            } else if (k0.c() < 52428800) {
                c.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f6687e.getResources().getString(c.a.p0.a.h.swanapp_album_camera_no_storage)).F();
            } else {
                p(this.f6687e);
            }
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, mediaModel, jVar) == null) {
            int d2 = c.a.p0.a.i1.d.c.e.d();
            if (!c.a.p0.a.i1.d.c.e.f(mediaModel)) {
                if (d2 >= c.a.p0.a.i1.d.c.d.f6736c) {
                    c.a.p0.a.i1.d.c.d.j(c.a.p0.a.i1.d.c.d.f6737d);
                    return;
                } else if (d2 > 0 && TextUtils.equals(c.a.p0.a.i1.d.c.d.f6737d, "single") && !TextUtils.equals(c.a.p0.a.i1.d.c.e.b(), mediaModel.getType())) {
                    c.a.p0.a.z1.b.f.e.f(this.f6687e, c.a.p0.a.h.swanapp_album_select_single).F();
                    return;
                } else if (mediaModel.getSize() <= 52428800 || !TextUtils.equals(mediaModel.getType(), "image")) {
                    jVar.f6712d.setImageResource(c.a.p0.a.e.swanapp_album_select_icon_bg);
                    jVar.f6711c.setVisibility(0);
                    jVar.f6711c.setText(String.valueOf(c.a.p0.a.i1.d.c.e.c(mediaModel) + 1));
                    c.a.p0.a.i1.d.c.e.i(mediaModel);
                    jVar.f6713e.startAnimation(AnimationUtils.loadAnimation(this.f6687e, c.a.p0.a.a.swanapp_album_checkshake));
                    c.a.p0.a.i1.d.d.e eVar = this.f6689g;
                    if (eVar != null) {
                        eVar.a(d2);
                    }
                    notifyDataSetChanged();
                    return;
                } else {
                    c.a.p0.a.z1.b.f.e.f(this.f6687e, c.a.p0.a.h.swanapp_album_photo_too_big).F();
                    return;
                }
            }
            c.a.p0.a.i1.d.c.e.h(mediaModel);
            jVar.f6712d.setImageResource(c.a.p0.a.e.swanapp_album_unselect_thumb_icon);
            jVar.f6711c.setVisibility(8);
            c.a.p0.a.i1.d.d.e eVar2 = this.f6689g;
            if (eVar2 != null) {
                eVar2.a(d2);
            }
            notifyDataSetChanged();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (c.a.p0.a.i1.d.c.e.d() >= c.a.p0.a.i1.d.c.d.f6736c) {
                c.a.p0.a.i1.d.c.d.j(c.a.p0.a.i1.d.c.d.f6737d);
            } else {
                q(this.f6687e);
            }
        }
    }

    public final boolean n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            if (j2 < 3000) {
                c.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f6687e.getString(c.a.p0.a.h.swanapp_album_video_duration_min)).F();
                return true;
            } else if (j2 > 300000) {
                c.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f6687e.getString(c.a.p0.a.h.swanapp_album_video_duration_max)).F();
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
            return j4 == 0 ? this.f6687e.getString(c.a.p0.a.h.swanapp_video_duration, new Object[]{format, format2}) : this.f6687e.getString(c.a.p0.a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
        }
        return (String) invokeJ.objValue;
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            c.a.p0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new e(this));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            c.a.p0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new c(this));
        }
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            view.findViewById(c.a.p0.a.f.album_camera_enter).setLayoutParams(this.f6692j);
            view.setTag(null);
            view.setClickable(true);
            ImageView imageView = (ImageView) view.findViewById(c.a.p0.a.f.album_camera_icon);
            if (TextUtils.equals(c.a.p0.a.i1.d.c.d.f6735b, "Image")) {
                imageView.setImageResource(c.a.p0.a.e.swanapp_album_camera_item_selector);
                view.setOnClickListener(new View$OnClickListenerC0262a(this));
                return;
            }
            imageView.setImageResource(c.a.p0.a.e.swanapp_album_camera_video_selector);
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
                if (c.a.p0.a.i1.d.c.c.f6730a) {
                    e.printStackTrace();
                }
                str2 = "";
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                c.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f6687e.getString(c.a.p0.a.h.swanapp_album_video_format)).F();
                return false;
            }
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.close();
                } catch (Exception e4) {
                    if (c.a.p0.a.i1.d.c.c.f6730a) {
                        e4.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
                return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
            }
            c.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f6687e.getString(c.a.p0.a.h.swanapp_album_video_format)).F();
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.p0.a.i1.d.c.b.e(this.f6687e, c.a.p0.a.i1.d.c.d.f6739f, c.a.p0.a.i1.d.c.d.f6740g, c.a.p0.a.i1.d.c.d.f6742i, new f(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.p0.a.i1.d.c.b.f(this.f6687e, c.a.p0.a.i1.d.c.d.f6739f, new d(this));
        }
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, mediaModel, jVar, i2) == null) {
            if (c.a.p0.a.i1.d.c.e.f(mediaModel)) {
                jVar.f6712d.setImageResource(c.a.p0.a.e.swanapp_album_select_icon_bg);
                jVar.f6711c.setVisibility(0);
                jVar.f6711c.setText(String.valueOf(c.a.p0.a.i1.d.c.e.c(mediaModel) + 1));
            }
            if (c.a.p0.a.i1.d.c.d.f(c.a.p0.a.i1.d.c.d.f6737d, mediaModel)) {
                jVar.f6710b.setVisibility(0);
            } else {
                jVar.f6710b.setVisibility(8);
            }
            if (!c.a.p0.a.i1.d.c.c.f6733d) {
                jVar.f6716h.setVisibility(8);
            } else if (c.a.p0.a.i1.d.c.d.d(mediaModel.getPath())) {
                jVar.f6715g.setText(this.f6687e.getString(c.a.p0.a.h.swanapp_album_gif_photo));
            } else if (c.a.p0.a.i1.d.c.d.e(mediaModel.getPath())) {
                jVar.f6715g.setText(this.f6687e.getString(c.a.p0.a.h.swanapp_album_large_photo));
            } else {
                jVar.f6716h.setVisibility(8);
            }
            jVar.f6714f.setOnClickListener(new g(this, mediaModel, jVar));
            jVar.f6709a.setOnClickListener(new h(this, mediaModel, i2));
        }
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048596, this, mediaModel, jVar, i2) == null) && (mediaModel instanceof VideoModel)) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f6716h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f6716h.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.f6687e.getResources().getDimensionPixelSize(c.a.p0.a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.f6687e.getResources().getDimensionPixelSize(c.a.p0.a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.f6687e.getResources().getDimensionPixelSize(c.a.p0.a.d.swanapp_album_item_time_height);
            jVar.f6716h.setLayoutParams(layoutParams);
            jVar.f6715g.setText(o(videoModel.getDuration()));
            jVar.f6709a.setOnClickListener(new i(this, videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.f6688f.size() > 0) {
                this.f6688f.clear();
            }
            this.f6688f.addAll(arrayList);
            c.a.p0.a.i1.d.c.d.i(this.f6688f);
            notifyDataSetChanged();
        }
    }

    public final void y(String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, jVar) == null) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
            newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f6690h / 2.0f), (int) (this.f6691i / 2.0f)));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
            AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.f6709a.getController()).build();
            jVar.f6709a.setController(build);
            DraweeHierarchy hierarchy = build.getHierarchy();
            if (hierarchy instanceof GenericDraweeHierarchy) {
                c.a.p0.a.c1.a.y().c((GenericDraweeHierarchy) hierarchy, false);
            }
        }
    }

    public void z(c.a.p0.a.i1.d.d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.f6689g = eVar;
        }
    }
}
