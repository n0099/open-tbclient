package c.a.n0.a.z0.d.b;

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
import c.a.n0.a.p2.k0;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<MediaModel> f7848b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.z0.d.d.e f7849c;

    /* renamed from: d  reason: collision with root package name */
    public int f7850d;

    /* renamed from: e  reason: collision with root package name */
    public int f7851e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout.LayoutParams f7852f;

    /* renamed from: c.a.n0.a.z0.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0606a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC0606a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.m();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.u();
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.z0.d.d.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.z0.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                c.a.n0.a.z0.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", c.a.n0.a.z0.d.c.d.f7881e);
                bundle.putString("swanAppId", c.a.n0.a.z0.d.c.d.f7882f);
                bundle.putParcelableArrayList("mediaModels", c.a.n0.a.z0.d.c.e.e());
                bundle.putString("swanTmpPath", c.a.n0.a.z0.d.c.d.j);
                c.a.n0.a.z0.d.c.d.g(this.a.a, bundle);
            }
        }

        @Override // c.a.n0.a.z0.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.t();
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.a.z0.d.d.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.z0.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.n0.a.z0.d.c.e.i(c.a.n0.a.z0.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", c.a.n0.a.z0.d.c.d.f7881e);
                bundle.putString("swanAppId", c.a.n0.a.z0.d.c.d.f7882f);
                bundle.putParcelableArrayList("mediaModels", c.a.n0.a.z0.d.c.e.e());
                bundle.putString("swanTmpPath", c.a.n0.a.z0.d.c.d.j);
                c.a.n0.a.z0.d.c.d.g(this.a.a, bundle);
            }
        }

        @Override // c.a.n0.a.z0.d.d.b
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
        public final /* synthetic */ MediaModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f7853b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7854c;

        public g(a aVar, MediaModel mediaModel, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mediaModel, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7854c = aVar;
            this.a = mediaModel;
            this.f7853b = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7854c.l(this.a, this.f7853b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f7855b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7856c;

        public h(a aVar, MediaModel mediaModel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, mediaModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7856c = aVar;
            this.a = mediaModel;
            this.f7855b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f7856c.j(this.a, this.f7855b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MediaModel f7857b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f7858c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f7859d;

        public i(a aVar, VideoModel videoModel, MediaModel mediaModel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, videoModel, mediaModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7859d = aVar;
            this.a = videoModel;
            this.f7857b = mediaModel;
            this.f7858c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f7859d.s(this.a.getPath()) && !this.f7859d.n(this.a.getDuration())) {
                this.f7859d.j(this.f7857b, this.f7858c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f7860b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f7861c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f7862d;

        /* renamed from: e  reason: collision with root package name */
        public View f7863e;

        /* renamed from: f  reason: collision with root package name */
        public View f7864f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f7865g;

        /* renamed from: h  reason: collision with root package name */
        public View f7866h;

        public j(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (SimpleDraweeView) view.findViewById(R.id.obfuscated_res_0x7f090233);
            this.f7862d = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090235);
            this.f7861c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090237);
            this.f7864f = view.findViewById(R.id.obfuscated_res_0x7f090238);
            this.f7863e = view.findViewById(R.id.obfuscated_res_0x7f090236);
            this.f7860b = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09023a);
            this.f7866h = view.findViewById(R.id.obfuscated_res_0x7f090239);
            this.f7865g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090234);
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
        this.a = activity;
        this.f7848b = new ArrayList<>();
        int o = n0.o(this.a);
        int n = n0.n(this.a);
        this.f7850d = o / 4;
        this.f7851e = n / 4;
        this.f7852f = new FrameLayout.LayoutParams((o - n0.f(this.a, 10.0f)) / 4, (o - n0.f(this.a, 10.0f)) / 4);
    }

    public final void A(j jVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jVar, view) == null) {
            Resources resources = this.a.getResources();
            view.setBackgroundColor(-1);
            jVar.a.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060a5e));
            jVar.f7861c.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a69));
            jVar.f7866h.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f081145));
            jVar.f7865g.setTextColor(-1);
            jVar.f7860b.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060a6c));
            jVar.a.setLayoutParams(this.f7852f);
            jVar.f7860b.setLayoutParams(this.f7852f);
            jVar.f7860b.setVisibility(8);
            jVar.f7861c.setVisibility(8);
            jVar.f7864f.setVisibility(8);
            jVar.f7866h.setVisibility(8);
            jVar.f7864f.setVisibility(0);
            jVar.f7862d.setImageResource(R.drawable.obfuscated_res_0x7f081153);
            jVar.f7866h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f7866h.getLayoutParams();
            layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07065c);
            layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070657);
            jVar.f7866h.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.n0.a.z0.d.c.d.f7884h ? this.f7848b.size() + 1 : this.f7848b.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (c.a.n0.a.z0.d.c.d.f7884h) {
                if (i2 == 0) {
                    return null;
                }
                return this.f7848b.get(i2 - 1);
            }
            return this.f7848b.get(i2);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (c.a.n0.a.z0.d.c.d.f7884h && i2 == 0) ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07d2, (ViewGroup) null, false);
                r(inflate);
                return inflate;
            }
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07d8, (ViewGroup) null);
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
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, mediaModel, i2) == null) || c.a.n0.a.z0.d.c.d.f(c.a.n0.a.z0.d.c.d.f7880d, mediaModel)) {
            return;
        }
        if (c.a.n0.a.z0.d.c.d.f7884h) {
            i2--;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("compressed", c.a.n0.a.z0.d.c.d.f7881e);
        bundle.putString("swanAppId", c.a.n0.a.z0.d.c.d.f7882f);
        bundle.putString("mode", c.a.n0.a.z0.d.c.d.f7880d);
        bundle.putString("previewFrom", "clickItem");
        bundle.putInt("previewPosition", i2);
        c.a.n0.a.z0.d.c.d.k(this.a, bundle);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (c.a.n0.a.z0.d.c.e.d() >= c.a.n0.a.z0.d.c.d.f7879c) {
                c.a.n0.a.z0.d.c.d.j(c.a.n0.a.z0.d.c.d.f7880d);
            } else if (k0.c() < 52428800) {
                c.a.n0.a.s1.b.f.e.g(AppRuntime.getAppContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f125c)).G();
            } else {
                p(this.a);
            }
        }
    }

    public final void l(MediaModel mediaModel, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, mediaModel, jVar) == null) {
            int d2 = c.a.n0.a.z0.d.c.e.d();
            if (!c.a.n0.a.z0.d.c.e.f(mediaModel)) {
                if (d2 >= c.a.n0.a.z0.d.c.d.f7879c) {
                    c.a.n0.a.z0.d.c.d.j(c.a.n0.a.z0.d.c.d.f7880d);
                    return;
                } else if (d2 > 0 && TextUtils.equals(c.a.n0.a.z0.d.c.d.f7880d, "single") && !TextUtils.equals(c.a.n0.a.z0.d.c.e.b(), mediaModel.getType())) {
                    c.a.n0.a.s1.b.f.e.f(this.a, R.string.obfuscated_res_0x7f0f1264).G();
                    return;
                } else if (mediaModel.getSize() <= 52428800 || !TextUtils.equals(mediaModel.getType(), "image")) {
                    jVar.f7862d.setImageResource(R.drawable.obfuscated_res_0x7f081151);
                    jVar.f7861c.setVisibility(0);
                    jVar.f7861c.setText(String.valueOf(c.a.n0.a.z0.d.c.e.c(mediaModel) + 1));
                    c.a.n0.a.z0.d.c.e.i(mediaModel);
                    jVar.f7863e.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010126));
                    c.a.n0.a.z0.d.d.e eVar = this.f7849c;
                    if (eVar != null) {
                        eVar.a(d2);
                    }
                    notifyDataSetChanged();
                    return;
                } else {
                    c.a.n0.a.s1.b.f.e.f(this.a, R.string.obfuscated_res_0x7f0f1263).G();
                    return;
                }
            }
            c.a.n0.a.z0.d.c.e.h(mediaModel);
            jVar.f7862d.setImageResource(R.drawable.obfuscated_res_0x7f081153);
            jVar.f7861c.setVisibility(8);
            c.a.n0.a.z0.d.d.e eVar2 = this.f7849c;
            if (eVar2 != null) {
                eVar2.a(d2);
            }
            notifyDataSetChanged();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (c.a.n0.a.z0.d.c.e.d() >= c.a.n0.a.z0.d.c.d.f7879c) {
                c.a.n0.a.z0.d.c.d.j(c.a.n0.a.z0.d.c.d.f7880d);
            } else {
                q(this.a);
            }
        }
    }

    public final boolean n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            if (j2 < 3000) {
                c.a.n0.a.s1.b.f.e.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f126a)).G();
                return true;
            } else if (j2 > 300000) {
                c.a.n0.a.s1.b.f.e.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f1269)).G();
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
            return j4 == 0 ? this.a.getString(R.string.obfuscated_res_0x7f0f12ea, new Object[]{format, format2}) : this.a.getString(R.string.obfuscated_res_0x7f0f12eb, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j4)), format, format2});
        }
        return (String) invokeJ.objValue;
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            c.a.n0.a.l1.e.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new e(this));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            c.a.n0.a.l1.e.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new c(this));
        }
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            view.findViewById(R.id.obfuscated_res_0x7f09022c).setLayoutParams(this.f7852f);
            view.setTag(null);
            view.setClickable(true);
            ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09022d);
            if (TextUtils.equals(c.a.n0.a.z0.d.c.d.f7878b, "Image")) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08113b);
                view.setOnClickListener(new View$OnClickListenerC0606a(this));
                return;
            }
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08113f);
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
                if (c.a.n0.a.z0.d.c.c.a) {
                    e.printStackTrace();
                }
                str2 = "";
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                if (TextUtils.isEmpty(str2)) {
                }
                c.a.n0.a.s1.b.f.e.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f126b)).G();
                return false;
            }
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e4) {
                    if (c.a.n0.a.z0.d.c.c.a) {
                        e4.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str2) && str2.startsWith(FileUtils.VIDEO_FILE_START)) {
                return TextUtils.equals(MimeTypes.VIDEO_MP4, str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals(MimeTypes.VIDEO_WEBM, str2) || TextUtils.equals("video/mkv", str2);
            }
            c.a.n0.a.s1.b.f.e.g(AppRuntime.getAppContext(), this.a.getString(R.string.obfuscated_res_0x7f0f126b)).G();
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.n0.a.z0.d.c.b.e(this.a, c.a.n0.a.z0.d.c.d.f7882f, c.a.n0.a.z0.d.c.d.f7883g, c.a.n0.a.z0.d.c.d.i, new f(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.n0.a.z0.d.c.b.f(this.a, c.a.n0.a.z0.d.c.d.f7882f, new d(this));
        }
    }

    public final void v(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, mediaModel, jVar, i2) == null) {
            if (c.a.n0.a.z0.d.c.e.f(mediaModel)) {
                jVar.f7862d.setImageResource(R.drawable.obfuscated_res_0x7f081151);
                jVar.f7861c.setVisibility(0);
                jVar.f7861c.setText(String.valueOf(c.a.n0.a.z0.d.c.e.c(mediaModel) + 1));
            }
            if (c.a.n0.a.z0.d.c.d.f(c.a.n0.a.z0.d.c.d.f7880d, mediaModel)) {
                jVar.f7860b.setVisibility(0);
            } else {
                jVar.f7860b.setVisibility(8);
            }
            if (!c.a.n0.a.z0.d.c.c.f7877d) {
                jVar.f7866h.setVisibility(8);
            } else if (c.a.n0.a.z0.d.c.d.d(mediaModel.getPath())) {
                jVar.f7865g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1260));
            } else if (c.a.n0.a.z0.d.c.d.e(mediaModel.getPath())) {
                jVar.f7865g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1261));
            } else {
                jVar.f7866h.setVisibility(8);
            }
            jVar.f7864f.setOnClickListener(new g(this, mediaModel, jVar));
            jVar.a.setOnClickListener(new h(this, mediaModel, i2));
        }
    }

    public final void w(MediaModel mediaModel, j jVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048596, this, mediaModel, jVar, i2) == null) && (mediaModel instanceof VideoModel)) {
            VideoModel videoModel = (VideoModel) mediaModel;
            jVar.f7866h.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) jVar.f7866h.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070656);
            } else {
                layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07065a);
            }
            layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070657);
            jVar.f7866h.setLayoutParams(layoutParams);
            jVar.f7865g.setText(o(videoModel.getDuration()));
            jVar.a.setOnClickListener(new i(this, videoModel, mediaModel, i2));
        }
    }

    public void x(ArrayList<MediaModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.f7848b.size() > 0) {
                this.f7848b.clear();
            }
            this.f7848b.addAll(arrayList);
            c.a.n0.a.z0.d.c.d.i(this.f7848b);
            notifyDataSetChanged();
        }
    }

    public final void y(String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, jVar) == null) {
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(str)));
            newBuilderWithSource.setResizeOptions(new ResizeOptions((int) (this.f7850d / 2.0f), (int) (this.f7851e / 2.0f)));
            newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
            newBuilderWithSource.setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build());
            AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setImageRequest(newBuilderWithSource.build()).setAutoPlayAnimations(false).setOldController(jVar.a.getController()).build();
            jVar.a.setController(build);
            DraweeHierarchy hierarchy = build.getHierarchy();
            if (hierarchy instanceof GenericDraweeHierarchy) {
                c.a.n0.a.s0.a.C().c((GenericDraweeHierarchy) hierarchy, false);
            }
        }
    }

    public void z(c.a.n0.a.z0.d.d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            this.f7849c = eVar;
        }
    }
}
