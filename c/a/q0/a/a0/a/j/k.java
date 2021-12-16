package c.a.q0.a.a0.a.j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class k extends c.a.q0.a.a0.a.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f4471b;

    /* renamed from: c  reason: collision with root package name */
    public int f4472c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f4473d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f4474e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f4475f;

    /* renamed from: g  reason: collision with root package name */
    public int f4476g;

    /* renamed from: h  reason: collision with root package name */
    public Uri f4477h;

    /* renamed from: i  reason: collision with root package name */
    public String f4478i;

    /* loaded from: classes.dex */
    public class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DataSource f4479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f4480f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f4481g;

        public a(k kVar, DataSource dataSource, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, dataSource, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4481g = kVar;
            this.f4479e = dataSource;
            this.f4480f = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                this.f4481g.f4476g = 3;
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (this.f4479e.isFinished() && bitmap != null) {
                    this.f4481g.f4475f = Bitmap.createBitmap(bitmap);
                    this.f4479e.close();
                    CanvasView canvasView = this.f4480f.l;
                    if (canvasView != null) {
                        canvasView.postInvalidate();
                    }
                }
                this.f4481g.f4476g = 2;
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
                return;
            }
        }
        this.f4476g = 0;
    }

    @Override // c.a.q0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (h(bVar)) {
                int alpha = bVar.f4446h.getAlpha();
                bVar.c(bVar.f4446h);
                Rect rect = this.f4474e;
                if (rect != null) {
                    canvas.drawBitmap(this.f4475f, this.f4473d, rect, bVar.f4446h);
                } else {
                    canvas.drawBitmap(this.f4475f, this.f4471b, this.f4472c, bVar.f4446h);
                }
                bVar.f4446h.setAlpha(alpha);
                return;
            }
            try {
                j(bVar);
            } catch (Exception e2) {
                if (c.a.q0.a.k.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // c.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            try {
                int length = jSONArray.length();
                if (length > 0) {
                    this.f4478i = this.a;
                    String optString = jSONArray.optString(0);
                    this.a = optString;
                    this.a = f(a0, optString);
                }
                if (length > 2) {
                    this.f4471b = i(jSONArray, 1);
                    this.f4472c = i(jSONArray, 2);
                }
                if (length > 4) {
                    int i2 = this.f4471b;
                    int i3 = this.f4472c;
                    int i4 = i(jSONArray, 3);
                    int i5 = i(jSONArray, 4);
                    if (i4 > 0 && i5 > 0) {
                        this.f4474e = new Rect(i2, i3, i4 + i2, i5 + i3);
                    }
                }
                if (length > 8) {
                    int optInt = jSONArray.optInt(5);
                    int optInt2 = jSONArray.optInt(6);
                    int optInt3 = jSONArray.optInt(7);
                    int optInt4 = jSONArray.optInt(8);
                    if (optInt3 > 0 && optInt4 > 0) {
                        this.f4473d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                    }
                }
                if (a0 != null) {
                    String g2 = g(this.a, a0);
                    if (!TextUtils.isEmpty(g2)) {
                        this.f4475f = BitmapFactory.decodeFile(g2);
                    } else if (TextUtils.isEmpty(this.a)) {
                    } else {
                        if (this.f4477h == null || !TextUtils.equals(this.a, this.f4478i)) {
                            this.f4477h = Uri.parse(this.a);
                        }
                    }
                }
            } catch (Exception e2) {
                if (c.a.q0.a.k.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) || hashMap == null || TextUtils.isEmpty(this.a) || this.f4475f == null || hashMap.containsKey(this.a)) {
            return;
        }
        hashMap.put(this.a, this.f4475f);
    }

    public final String f(c.a.q0.a.d2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, str)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    return ("bdfile".equalsIgnoreCase(URI.create(str).getScheme()) || str.startsWith(c.a.q0.a.z2.q0.x(eVar).getPath())) ? str : c.a.q0.a.z2.q0.w(eVar, str);
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final String g(String str, c.a.q0.a.d2.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, eVar)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        str = c.a.q0.a.o2.b.M(str, eVar.f4925f);
                    }
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        return file.getAbsolutePath();
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean h(b bVar) {
        InterceptResult invokeL;
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            if (this.f4475f != null) {
                return true;
            }
            if (this.f4477h == null || bVar == null || (canvasView = bVar.l) == null) {
                return false;
            }
            Bitmap bitmapByUrlKey = canvasView.getBitmapByUrlKey(this.a);
            this.f4475f = bitmapByUrlKey;
            if (bitmapByUrlKey != null) {
                return true;
            }
            Bitmap c2 = c.a.q0.a.z2.t.c(this.f4477h, bVar.l.getContext());
            this.f4475f = c2;
            return c2 != null;
        }
        return invokeL.booleanValue;
    }

    public final int i(JSONArray jSONArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, jSONArray, i2)) == null) ? c.a.q0.a.z2.n0.g((float) jSONArray.optDouble(i2)) : invokeLI.intValue;
    }

    @UiThread
    public final void j(b bVar) {
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || this.f4476g != 0 || (canvasView = bVar.l) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.a)) {
            return;
        }
        this.f4476g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.a)).build(), bVar.l.getContext());
        fetchDecodedImage.subscribe(new a(this, fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
