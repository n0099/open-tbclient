package b.a.p0.a.h0.m.r;

import android.graphics.Bitmap;
import android.net.Uri;
import b.a.p0.a.j2.k;
import b.a.p0.a.j2.p.d;
import b.a.p0.a.q2.e;
import b.a.p0.a.v2.q0;
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f5616a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5617b;

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
            this.f5616a = bVar;
            this.f5617b = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
                c.b(this.f5617b, this.f5616a, "download icon fail: onCancellation");
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                c.b(this.f5617b, this.f5616a, "download icon fail: onFailureImpl");
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                if (bitmap == null || bitmap.isRecycled()) {
                    c.b(this.f5617b, this.f5616a, "download icon fail: bitmap is null or is recycled");
                    return;
                }
                try {
                    if (bitmap.getConfig() == null) {
                        copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        copy = bitmap.copy(bitmap.getConfig(), true);
                    }
                    if (this.f5616a != null) {
                        this.f5616a.a(copy);
                    }
                } catch (Exception e2) {
                    int i2 = this.f5617b;
                    b bVar = this.f5616a;
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
            b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
            aVar.j(4L);
            aVar.h(10L);
            aVar.e(str);
            e.a().f(aVar);
            d dVar = new d();
            dVar.p(aVar);
            dVar.q(k.m(i2));
            k.L(dVar);
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
