package c.a.p0.a.a0.a.j;

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
public class k extends c.a.p0.a.a0.a.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f4432a;

    /* renamed from: b  reason: collision with root package name */
    public int f4433b;

    /* renamed from: c  reason: collision with root package name */
    public int f4434c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f4435d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f4436e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f4437f;

    /* renamed from: g  reason: collision with root package name */
    public int f4438g;

    /* renamed from: h  reason: collision with root package name */
    public Uri f4439h;

    /* renamed from: i  reason: collision with root package name */
    public String f4440i;

    /* loaded from: classes.dex */
    public class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataSource f4441a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f4442b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f4443c;

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
            this.f4443c = kVar;
            this.f4441a = dataSource;
            this.f4442b = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                this.f4443c.f4438g = 3;
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (this.f4441a.isFinished() && bitmap != null) {
                    this.f4443c.f4437f = Bitmap.createBitmap(bitmap);
                    this.f4441a.close();
                    CanvasView canvasView = this.f4442b.l;
                    if (canvasView != null) {
                        canvasView.postInvalidate();
                    }
                }
                this.f4443c.f4438g = 2;
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
        this.f4438g = 0;
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (h(bVar)) {
                int alpha = bVar.f4394h.getAlpha();
                bVar.f(bVar.f4394h);
                Rect rect = this.f4436e;
                if (rect != null) {
                    canvas.drawBitmap(this.f4437f, this.f4435d, rect, bVar.f4394h);
                } else {
                    canvas.drawBitmap(this.f4437f, this.f4433b, this.f4434c, bVar.f4394h);
                }
                bVar.f4394h.setAlpha(alpha);
                return;
            }
            try {
                j(bVar);
            } catch (Exception e2) {
                if (c.a.p0.a.k.f7077a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // c.a.p0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            try {
                int length = jSONArray.length();
                if (length > 0) {
                    this.f4440i = this.f4432a;
                    String optString = jSONArray.optString(0);
                    this.f4432a = optString;
                    this.f4432a = f(Q, optString);
                }
                if (length > 2) {
                    this.f4433b = i(jSONArray, 1);
                    this.f4434c = i(jSONArray, 2);
                }
                if (length > 4) {
                    int i2 = this.f4433b;
                    int i3 = this.f4434c;
                    int i4 = i(jSONArray, 3);
                    int i5 = i(jSONArray, 4);
                    if (i4 > 0 && i5 > 0) {
                        this.f4436e = new Rect(i2, i3, i4 + i2, i5 + i3);
                    }
                }
                if (length > 8) {
                    int optInt = jSONArray.optInt(5);
                    int optInt2 = jSONArray.optInt(6);
                    int optInt3 = jSONArray.optInt(7);
                    int optInt4 = jSONArray.optInt(8);
                    if (optInt3 > 0 && optInt4 > 0) {
                        this.f4435d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                    }
                }
                if (Q != null) {
                    String g2 = g(this.f4432a, Q);
                    if (!TextUtils.isEmpty(g2)) {
                        this.f4437f = BitmapFactory.decodeFile(g2);
                    } else if (TextUtils.isEmpty(this.f4432a)) {
                    } else {
                        if (this.f4439h == null || !TextUtils.equals(this.f4432a, this.f4440i)) {
                            this.f4439h = Uri.parse(this.f4432a);
                        }
                    }
                }
            } catch (Exception e2) {
                if (c.a.p0.a.k.f7077a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) || hashMap == null || TextUtils.isEmpty(this.f4432a) || this.f4437f == null || hashMap.containsKey(this.f4432a)) {
            return;
        }
        hashMap.put(this.f4432a, this.f4437f);
    }

    public final String f(c.a.p0.a.a2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, str)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    return ("bdfile".equalsIgnoreCase(URI.create(str).getScheme()) || str.startsWith(c.a.p0.a.v2.q0.x(eVar).getPath())) ? str : c.a.p0.a.v2.q0.w(eVar, str);
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final String g(String str, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, eVar)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        str = c.a.p0.a.k2.b.M(str, eVar.f4558f);
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
            if (this.f4437f != null) {
                return true;
            }
            if (this.f4439h == null || bVar == null || (canvasView = bVar.l) == null) {
                return false;
            }
            Bitmap bitmapByUrlKey = canvasView.getBitmapByUrlKey(this.f4432a);
            this.f4437f = bitmapByUrlKey;
            if (bitmapByUrlKey != null) {
                return true;
            }
            Bitmap c2 = c.a.p0.a.v2.t.c(this.f4439h, bVar.l.getContext());
            this.f4437f = c2;
            return c2 != null;
        }
        return invokeL.booleanValue;
    }

    public final int i(JSONArray jSONArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, jSONArray, i2)) == null) ? c.a.p0.a.v2.n0.g((float) jSONArray.optDouble(i2)) : invokeLI.intValue;
    }

    @UiThread
    public final void j(b bVar) {
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || this.f4438g != 0 || (canvasView = bVar.l) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.f4432a)) {
            return;
        }
        this.f4438g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.f4432a)).build(), bVar.l.getContext());
        fetchDecodedImage.subscribe(new a(this, fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
