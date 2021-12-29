package c.a.r0.a.j1.d.b;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.r0.a.e;
import c.a.r0.a.f;
import c.a.r0.a.g;
import c.a.r0.a.h;
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f7580e;

    /* renamed from: f  reason: collision with root package name */
    public String f7581f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.r0.a.j1.d.f.a> f7582g;

    /* renamed from: h  reason: collision with root package name */
    public int f7583h;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f7584b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f7585c;

        public a(b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (SimpleDraweeView) view.findViewById(f.album_name_item_img);
            this.f7584b = (TextView) view.findViewById(f.album_name_item_title);
            this.f7585c = (TextView) view.findViewById(f.album_name_item_number);
        }
    }

    public b(Activity activity, String str, ArrayList<c.a.r0.a.j1.d.f.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7580e = activity;
        this.f7581f = str;
        this.f7582g = arrayList;
        this.f7583h = (int) (n0.f(activity, 50.0f) / 2.0f);
    }

    public final String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? TextUtils.equals(this.f7581f, "Image") ? this.f7580e.getString(h.swanapp_image_pages, new Object[]{Integer.valueOf(i2)}) : this.f7580e.getString(h.swanapp_album_pages, new Object[]{Integer.valueOf(i2)}) : (String) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<c.a.r0.a.j1.d.f.a> arrayList = this.f7582g;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 < 0 || i2 > this.f7582g.size()) {
                return null;
            }
            return this.f7582g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f7580e).inflate(g.swanapp_album_name_item, (ViewGroup) null);
                aVar = new a(this, view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            view.setBackground(this.f7580e.getResources().getDrawable(e.swanapp_album_name_item_selector));
            c.a.r0.a.j1.d.f.a aVar2 = this.f7582g.get(i2);
            if (aVar2 == null) {
                return view;
            }
            aVar.f7584b.setText(aVar2.c());
            ArrayList<MediaModel> arrayList = aVar2.f7610h;
            if (arrayList == null) {
                return view;
            }
            aVar.f7585c.setText(a(arrayList.size()));
            if (aVar2.f7610h.get(0) != null && !TextUtils.isEmpty(aVar2.f7610h.get(0).getPath())) {
                ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(aVar2.f7610h.get(0).getPath())));
                int i3 = this.f7583h;
                newBuilderWithSource.setResizeOptions(new ResizeOptions(i3, i3));
                newBuilderWithSource.setLocalThumbnailPreviewsEnabled(true);
                aVar.a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setImageRequest(newBuilderWithSource.build()).setOldController(aVar.a.getController()).build());
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
