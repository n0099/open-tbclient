package c.a.n0.a.q.a.j;

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
public class k extends c.a.n0.a.q.a.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f5924b;

    /* renamed from: c  reason: collision with root package name */
    public int f5925c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f5926d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f5927e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f5928f;

    /* renamed from: g  reason: collision with root package name */
    public int f5929g;

    /* renamed from: h  reason: collision with root package name */
    public Uri f5930h;
    public String i;

    /* loaded from: classes.dex */
    public class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataSource a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f5931b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f5932c;

        public a(k kVar, DataSource dataSource, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, dataSource, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5932c = kVar;
            this.a = dataSource;
            this.f5931b = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                if (dataSource != null) {
                    dataSource.close();
                }
                this.f5932c.f5929g = 3;
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(@Nullable Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (this.a.isFinished() && bitmap != null) {
                    this.f5932c.f5928f = Bitmap.createBitmap(bitmap);
                    this.a.close();
                    CanvasView canvasView = this.f5931b.f5902h;
                    if (canvasView != null) {
                        canvasView.postInvalidate();
                    }
                }
                this.f5932c.f5929g = 2;
            }
        }
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5929g = 0;
    }

    @Override // c.a.n0.a.q.a.j.a
    public void a(b bVar, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) {
            if (h(bVar)) {
                int alpha = bVar.f5898d.getAlpha();
                bVar.c(bVar.f5898d);
                Rect rect = this.f5927e;
                if (rect != null) {
                    canvas.drawBitmap(this.f5928f, this.f5926d, rect, bVar.f5898d);
                } else {
                    canvas.drawBitmap(this.f5928f, this.f5924b, this.f5925c, bVar.f5898d);
                }
                bVar.f5898d.setAlpha(alpha);
                return;
            }
            try {
                j(bVar);
            } catch (Exception e2) {
                if (c.a.n0.a.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // c.a.n0.a.q.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            try {
                int length = jSONArray.length();
                if (length > 0) {
                    this.i = this.a;
                    String optString = jSONArray.optString(0);
                    this.a = optString;
                    this.a = f(a0, optString);
                }
                if (length > 2) {
                    this.f5924b = i(jSONArray, 1);
                    this.f5925c = i(jSONArray, 2);
                }
                if (length > 4) {
                    int i = this.f5924b;
                    int i2 = this.f5925c;
                    int i3 = i(jSONArray, 3);
                    int i4 = i(jSONArray, 4);
                    if (i3 > 0 && i4 > 0) {
                        this.f5927e = new Rect(i, i2, i3 + i, i4 + i2);
                    }
                }
                if (length > 8) {
                    int optInt = jSONArray.optInt(5);
                    int optInt2 = jSONArray.optInt(6);
                    int optInt3 = jSONArray.optInt(7);
                    int optInt4 = jSONArray.optInt(8);
                    if (optInt3 > 0 && optInt4 > 0) {
                        this.f5926d = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                    }
                }
                if (a0 != null) {
                    String g2 = g(this.a, a0);
                    if (!TextUtils.isEmpty(g2)) {
                        this.f5928f = BitmapFactory.decodeFile(g2);
                    } else if (TextUtils.isEmpty(this.a)) {
                    } else {
                        if (this.f5930h == null || !TextUtils.equals(this.a, this.i)) {
                            this.f5930h = Uri.parse(this.a);
                        }
                    }
                }
            } catch (Exception e2) {
                if (c.a.n0.a.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void e(HashMap<String, Bitmap> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) || hashMap == null || TextUtils.isEmpty(this.a) || this.f5928f == null || hashMap.containsKey(this.a)) {
            return;
        }
        hashMap.put(this.a, this.f5928f);
    }

    public final String f(c.a.n0.a.t1.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, str)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    return ("bdfile".equalsIgnoreCase(URI.create(str).getScheme()) || str.startsWith(c.a.n0.a.p2.q0.x(eVar).getPath())) ? str : c.a.n0.a.p2.q0.w(eVar, str);
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final String g(String str, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, eVar)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        str = c.a.n0.a.e2.b.M(str, eVar.f6344b);
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
            if (this.f5928f != null) {
                return true;
            }
            if (this.f5930h == null || bVar == null || (canvasView = bVar.f5902h) == null) {
                return false;
            }
            Bitmap e2 = canvasView.e(this.a);
            this.f5928f = e2;
            if (e2 != null) {
                return true;
            }
            Bitmap c2 = c.a.n0.a.p2.t.c(this.f5930h, bVar.f5902h.getContext());
            this.f5928f = c2;
            return c2 != null;
        }
        return invokeL.booleanValue;
    }

    public final int i(JSONArray jSONArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, jSONArray, i)) == null) ? c.a.n0.a.p2.n0.g((float) jSONArray.optDouble(i)) : invokeLI.intValue;
    }

    @UiThread
    public final void j(b bVar) {
        CanvasView canvasView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || this.f5929g != 0 || (canvasView = bVar.f5902h) == null || canvasView.getContext() == null || TextUtils.isEmpty(this.a)) {
            return;
        }
        this.f5929g = 1;
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.a)).build(), bVar.f5902h.getContext());
        fetchDecodedImage.subscribe(new a(this, fetchDecodedImage, bVar), UiThreadImmediateExecutorService.getInstance());
    }
}
