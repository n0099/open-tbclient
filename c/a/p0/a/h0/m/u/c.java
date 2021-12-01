package c.a.p0.a.h0.m.u;

import android.graphics.Bitmap;
import android.net.Uri;
import c.a.p0.a.n2.n;
import c.a.p0.a.n2.s.d;
import c.a.p0.a.u2.e;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f5839e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f5840f;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5839e = bVar;
            this.f5840f = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
                c.b(this.f5840f, this.f5839e, "download icon fail: onCancellation");
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                c.b(this.f5840f, this.f5839e, "download icon fail: onFailureImpl");
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                if (bitmap == null || bitmap.isRecycled()) {
                    c.b(this.f5840f, this.f5839e, "download icon fail: bitmap is null or is recycled");
                    return;
                }
                try {
                    if (bitmap.getConfig() == null) {
                        copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        copy = bitmap.copy(bitmap.getConfig(), true);
                    }
                    if (this.f5839e != null) {
                        this.f5839e.a(copy);
                    }
                } catch (Exception e2) {
                    int i2 = this.f5840f;
                    b bVar = this.f5839e;
                    c.b(i2, bVar, "download icon fail: " + e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Bitmap bitmap);
    }

    public static void b(int i2, b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65537, null, i2, bVar, str) == null) {
            c.a.p0.a.u2.a aVar = new c.a.p0.a.u2.a();
            aVar.k(4L);
            aVar.i(10L);
            aVar.f(str);
            e.a().f(aVar);
            d dVar = new d();
            dVar.p(aVar);
            dVar.q(n.n(i2));
            n.R(dVar);
            if (bVar != null) {
                bVar.a(null);
            }
        }
    }

    public static void c(String str, int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, str, i2, bVar) == null) {
            Uri C = q0.C(str);
            if (C == null) {
                b(i2, bVar, "download icon fail: icon url is null");
                return;
            }
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(C).build(), AppRuntime.getAppContext()).subscribe(new a(bVar, i2), UiThreadImmediateExecutorService.getInstance());
        }
    }
}
