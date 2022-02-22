package c.a.s0.a.z1.h.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.e;
import c.a.s0.a.f;
import c.a.s0.a.g;
import c.a.s0.a.h;
import c.a.s0.a.z2.h0;
import c.a.s0.a.z2.n0;
import c.a.s0.a.z2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.publisher.view.PhotoChooseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f10138e;

    /* renamed from: f  reason: collision with root package name */
    public int f10139f;

    /* renamed from: g  reason: collision with root package name */
    public int f10140g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f10141h;

    /* renamed from: i  reason: collision with root package name */
    public Context f10142i;

    /* renamed from: j  reason: collision with root package name */
    public PhotoChooseView.b f10143j;

    /* renamed from: c.a.s0.a.z1.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0670a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f10144e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10145f;

        public View$OnClickListenerC0670a(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10145f = aVar;
            this.f10144e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f10145f.f10141h.remove(this.f10144e);
                this.f10145f.notifyDataSetChanged();
                if (this.f10145f.f10143j != null) {
                    this.f10145f.f10143j.a(this.f10145f.f10141h.size());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f10146b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f10147c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f10148d;

        public b() {
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
    }

    public a(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10140g = 9;
        this.f10141h = new ArrayList(0);
        this.f10142i = context;
        this.f10138e = i2;
        this.f10139f = i3;
    }

    public List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10141h : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public String getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 < this.f10141h.size() ? this.f10141h.get(i2) : "more_option" : (String) invokeI.objValue;
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 == getCount() - 1 && this.f10141h.size() < this.f10140g : invokeI.booleanValue;
    }

    public void f(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        for (String str : list) {
            if (!this.f10141h.contains(str)) {
                this.f10141h.add(str);
            }
        }
    }

    public void g(PhotoChooseView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f10143j = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.f10141h.size();
            int i2 = this.f10140g;
            return size < i2 ? size + 1 : i2;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                bVar = new b();
                view2 = LayoutInflater.from(this.f10142i).inflate(g.swanapp_publisher_photo_choose_layout, viewGroup, false);
                bVar.a = (SimpleDraweeView) view2.findViewById(f.publish_img);
                bVar.f10146b = (ImageView) view2.findViewById(f.publish_delete);
                bVar.f10147c = (RelativeLayout) view2.findViewById(f.publish_right_bottom_bg);
                bVar.f10148d = (TextView) view2.findViewById(f.publish_right_bottom_tip);
                bVar.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int o = n0.o(this.f10142i) - n0.g(30.0f);
                int i3 = this.f10138e;
                int i4 = this.f10139f;
                int i5 = (o - (i3 * (i4 - 1))) / i4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.a.getLayoutParams();
                layoutParams.width = i5;
                layoutParams.height = i5;
                bVar.a.setLayoutParams(layoutParams);
                bVar.a.setBackground(ContextCompat.getDrawable(this.f10142i, e.swanapp_ugc_img_stroke_bg));
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            int o2 = n0.o(this.f10142i) / 3;
            int o3 = n0.o(this.f10142i) / 3;
            bVar.f10146b.setImageResource(e.swanapp_ugc_delete_selected_img);
            bVar.f10146b.setVisibility(8);
            if (e(i2)) {
                bVar.f10147c.setVisibility(8);
                bVar.a.setBackground(ContextCompat.getDrawable(this.f10142i, e.swanapp_ugc_add_photo_stroke_bg));
                bVar.a.setImageResource(e.swanapp_ugc_add_localalbum_selector);
            } else {
                bVar.f10146b.setVisibility(0);
                String item = getItem(i2);
                if (!TextUtils.isEmpty(item)) {
                    if (h0.c(item)) {
                        bVar.f10147c.setVisibility(0);
                        bVar.f10148d.setText(this.f10142i.getString(h.swanapp_album_gif_photo));
                    } else if (h0.f(item)) {
                        bVar.f10147c.setVisibility(0);
                        bVar.f10148d.setText(this.f10142i.getString(h.swanapp_album_large_photo));
                    } else {
                        bVar.f10147c.setVisibility(8);
                    }
                    Fresco.getImagePipeline().evictFromCache(o0.p(item));
                    bVar.a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setOldController(bVar.a.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(o0.p(item)).setResizeOptions(new ResizeOptions((int) (o2 / 2.0f), (int) (o3 / 2.0f))).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build()).build()).build());
                }
            }
            bVar.f10146b.setOnClickListener(new View$OnClickListenerC0670a(this, i2));
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f10140g = i2;
        }
    }
}
