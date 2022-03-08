package c.a.p0.a.p1.h.f;

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
import c.a.p0.a.p2.h0;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.publisher.view.PhotoChooseView;
import com.baidu.tieba.R;
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
    public int f6866e;

    /* renamed from: f  reason: collision with root package name */
    public int f6867f;

    /* renamed from: g  reason: collision with root package name */
    public int f6868g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f6869h;

    /* renamed from: i  reason: collision with root package name */
    public Context f6870i;

    /* renamed from: j  reason: collision with root package name */
    public PhotoChooseView.b f6871j;

    /* renamed from: c.a.p0.a.p1.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0427a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f6872e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6873f;

        public View$OnClickListenerC0427a(a aVar, int i2) {
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
            this.f6873f = aVar;
            this.f6872e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6873f.f6869h.remove(this.f6872e);
                this.f6873f.notifyDataSetChanged();
                if (this.f6873f.f6871j != null) {
                    this.f6873f.f6871j.a(this.f6873f.f6869h.size());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f6874b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f6875c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f6876d;

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
        this.f6868g = 9;
        this.f6869h = new ArrayList(0);
        this.f6870i = context;
        this.f6866e = i2;
        this.f6867f = i3;
    }

    public List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6869h : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public String getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 < this.f6869h.size() ? this.f6869h.get(i2) : "more_option" : (String) invokeI.objValue;
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 == getCount() - 1 && this.f6869h.size() < this.f6868g : invokeI.booleanValue;
    }

    public void f(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        for (String str : list) {
            if (!this.f6869h.contains(str)) {
                this.f6869h.add(str);
            }
        }
    }

    public void g(PhotoChooseView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f6871j = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.f6869h.size();
            int i2 = this.f6868g;
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
                view2 = LayoutInflater.from(this.f6870i).inflate(R.layout.swanapp_publisher_photo_choose_layout, viewGroup, false);
                bVar.a = (SimpleDraweeView) view2.findViewById(R.id.publish_img);
                bVar.f6874b = (ImageView) view2.findViewById(R.id.publish_delete);
                bVar.f6875c = (RelativeLayout) view2.findViewById(R.id.publish_right_bottom_bg);
                bVar.f6876d = (TextView) view2.findViewById(R.id.publish_right_bottom_tip);
                bVar.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int o = n0.o(this.f6870i) - n0.g(30.0f);
                int i3 = this.f6866e;
                int i4 = this.f6867f;
                int i5 = (o - (i3 * (i4 - 1))) / i4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.a.getLayoutParams();
                layoutParams.width = i5;
                layoutParams.height = i5;
                bVar.a.setLayoutParams(layoutParams);
                bVar.a.setBackground(ContextCompat.getDrawable(this.f6870i, R.drawable.swanapp_ugc_img_stroke_bg));
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            int o2 = n0.o(this.f6870i) / 3;
            int o3 = n0.o(this.f6870i) / 3;
            bVar.f6874b.setImageResource(R.drawable.swanapp_ugc_delete_selected_img);
            bVar.f6874b.setVisibility(8);
            if (e(i2)) {
                bVar.f6875c.setVisibility(8);
                bVar.a.setBackground(ContextCompat.getDrawable(this.f6870i, R.drawable.swanapp_ugc_add_photo_stroke_bg));
                bVar.a.setImageResource(R.drawable.swanapp_ugc_add_localalbum_selector);
            } else {
                bVar.f6874b.setVisibility(0);
                String item = getItem(i2);
                if (!TextUtils.isEmpty(item)) {
                    if (h0.c(item)) {
                        bVar.f6875c.setVisibility(0);
                        bVar.f6876d.setText(this.f6870i.getString(R.string.swanapp_album_gif_photo));
                    } else if (h0.f(item)) {
                        bVar.f6875c.setVisibility(0);
                        bVar.f6876d.setText(this.f6870i.getString(R.string.swanapp_album_large_photo));
                    } else {
                        bVar.f6875c.setVisibility(8);
                    }
                    Fresco.getImagePipeline().evictFromCache(o0.p(item));
                    bVar.a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setOldController(bVar.a.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(o0.p(item)).setResizeOptions(new ResizeOptions((int) (o2 / 2.0f), (int) (o3 / 2.0f))).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build()).build()).build());
                }
            }
            bVar.f6874b.setOnClickListener(new View$OnClickListenerC0427a(this, i2));
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f6868g = i2;
        }
    }
}
