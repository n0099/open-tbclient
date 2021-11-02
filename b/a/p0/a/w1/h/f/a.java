package b.a.p0.a.w1.h.f;

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
import b.a.p0.a.e;
import b.a.p0.a.f;
import b.a.p0.a.g;
import b.a.p0.a.h;
import b.a.p0.a.v2.h0;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.o0;
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
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f8780e;

    /* renamed from: f  reason: collision with root package name */
    public int f8781f;

    /* renamed from: g  reason: collision with root package name */
    public int f8782g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f8783h;

    /* renamed from: i  reason: collision with root package name */
    public Context f8784i;
    public PhotoChooseView.b j;

    /* renamed from: b.a.p0.a.w1.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0440a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8786f;

        public View$OnClickListenerC0440a(a aVar, int i2) {
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
            this.f8786f = aVar;
            this.f8785e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f8786f.f8783h.remove(this.f8785e);
                this.f8786f.notifyDataSetChanged();
                if (this.f8786f.j != null) {
                    this.f8786f.j.a(this.f8786f.f8783h.size());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SimpleDraweeView f8787a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f8788b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f8789c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f8790d;

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
        this.f8782g = 9;
        this.f8783h = new ArrayList(0);
        this.f8784i = context;
        this.f8780e = i2;
        this.f8781f = i3;
    }

    public List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8783h : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public String getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 < this.f8783h.size() ? this.f8783h.get(i2) : "more_option" : (String) invokeI.objValue;
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 == getCount() - 1 && this.f8783h.size() < this.f8782g : invokeI.booleanValue;
    }

    public void f(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        for (String str : list) {
            if (!this.f8783h.contains(str)) {
                this.f8783h.add(str);
            }
        }
    }

    public void g(PhotoChooseView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.j = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.f8783h.size();
            int i2 = this.f8782g;
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
                view2 = LayoutInflater.from(this.f8784i).inflate(g.swanapp_publisher_photo_choose_layout, viewGroup, false);
                bVar.f8787a = (SimpleDraweeView) view2.findViewById(f.publish_img);
                bVar.f8788b = (ImageView) view2.findViewById(f.publish_delete);
                bVar.f8789c = (RelativeLayout) view2.findViewById(f.publish_right_bottom_bg);
                bVar.f8790d = (TextView) view2.findViewById(f.publish_right_bottom_tip);
                bVar.f8787a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int o = n0.o(this.f8784i) - n0.g(30.0f);
                int i3 = this.f8780e;
                int i4 = this.f8781f;
                int i5 = (o - (i3 * (i4 - 1))) / i4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.f8787a.getLayoutParams();
                layoutParams.width = i5;
                layoutParams.height = i5;
                bVar.f8787a.setLayoutParams(layoutParams);
                bVar.f8787a.setBackground(ContextCompat.getDrawable(this.f8784i, e.swanapp_ugc_img_stroke_bg));
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            int o2 = n0.o(this.f8784i) / 3;
            int o3 = n0.o(this.f8784i) / 3;
            bVar.f8788b.setImageResource(e.swanapp_ugc_delete_selected_img);
            bVar.f8788b.setVisibility(8);
            if (e(i2)) {
                bVar.f8789c.setVisibility(8);
                bVar.f8787a.setBackground(ContextCompat.getDrawable(this.f8784i, e.swanapp_ugc_add_photo_stroke_bg));
                bVar.f8787a.setImageResource(e.swanapp_ugc_add_localalbum_selector);
            } else {
                bVar.f8788b.setVisibility(0);
                String item = getItem(i2);
                if (!TextUtils.isEmpty(item)) {
                    if (h0.c(item)) {
                        bVar.f8789c.setVisibility(0);
                        bVar.f8790d.setText(this.f8784i.getString(h.swanapp_album_gif_photo));
                    } else if (h0.f(item)) {
                        bVar.f8789c.setVisibility(0);
                        bVar.f8790d.setText(this.f8784i.getString(h.swanapp_album_large_photo));
                    } else {
                        bVar.f8789c.setVisibility(8);
                    }
                    Fresco.getImagePipeline().evictFromCache(o0.p(item));
                    bVar.f8787a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setOldController(bVar.f8787a.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(o0.p(item)).setResizeOptions(new ResizeOptions((int) (o2 / 2.0f), (int) (o3 / 2.0f))).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build()).build()).build());
                }
            }
            bVar.f8788b.setOnClickListener(new View$OnClickListenerC0440a(this, i2));
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f8782g = i2;
        }
    }
}
