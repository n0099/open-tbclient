package b.a.p0.a.c0.a.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.a2.e;
import b.a.p0.a.c0.a.b.b;
import b.a.p0.a.e0.d;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.p.d.h0;
import b.a.p0.a.v2.d0;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class a<V extends SimpleDraweeView, M extends b> extends b.a.p0.a.c0.a.d.a<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.c0.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0117a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4038a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1754878972, "Lb/a/p0/a/c0/a/b/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1754878972, "Lb/a/p0/a/c0/a/b/a$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            f4038a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4038a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4038a[PathType.NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4038a[PathType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (b.a.p0.a.c0.a.d.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Uri W(@NonNull String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            PathType s = b.a.p0.a.k2.b.s(str);
            e i2 = e.i();
            if (i2 != null) {
                str2 = i2.f3961f;
                str3 = i2.Y();
            } else {
                str2 = null;
                str3 = null;
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return null;
            }
            int i3 = C0117a.f4038a[s.ordinal()];
            if (i3 == 1) {
                String M = b.a.p0.a.k2.b.M(str, str2);
                if (TextUtils.isEmpty(M)) {
                    return null;
                }
                return Uri.fromFile(new File(M));
            } else if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return Uri.parse(str);
            } else {
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String L = b.a.p0.a.k2.b.L(str, i2, str3);
                if (TextUtils.isEmpty(L)) {
                    return null;
                }
                return Uri.fromFile(new File(L));
            }
        }
        return (Uri) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.d.a, b.a.p0.a.c0.b.a
    @NonNull
    /* renamed from: S */
    public b.a.p0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, m, m2)) == null) {
            b.a.p0.a.c0.f.b k = super.k(m, m2);
            if (!TextUtils.equals(m.x, m2.x)) {
                k.b(9);
            }
            return k;
        }
        return (b.a.p0.a.c0.f.b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.c0.a.d.a
    /* renamed from: T */
    public void O(@NonNull V v, @NonNull M m, @NonNull b.a.p0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, v, m, bVar) == null) {
            super.C(v, m, bVar);
            if (bVar.a(9)) {
                U(v, m);
            }
        }
    }

    public void U(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, v, m) == null) {
            V(v, m, null);
        }
    }

    public final void V(@NonNull V v, @NonNull M m, @Nullable BaseControllerListener<ImageInfo> baseControllerListener) {
        Uri W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, v, m, baseControllerListener) == null) || m.n == null) {
            return;
        }
        boolean z = b.a.p0.a.c0.b.a.f4044h;
        String str = m.x;
        if (TextUtils.isEmpty(str) || (W = W(str)) == null) {
            return;
        }
        d.g("Component-SimpleDrawee", "Image Uri:" + W);
        PipelineDraweeControllerBuilder oldController = Fresco.newDraweeControllerBuilder().setOldController(v.getController());
        if (baseControllerListener != null) {
            oldController.setControllerListener(baseControllerListener);
        }
        HashMap hashMap = new HashMap();
        String X = g.M().X();
        if (!TextUtils.isEmpty(X)) {
            hashMap.put("User-Agent", X);
        }
        String b2 = d0.b();
        if (!TextUtils.isEmpty(b2) && d0.c(W.toString())) {
            hashMap.put("Referer", b2);
        }
        h0 y = b.a.p0.a.c1.a.y();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(W);
        y.e(newBuilderWithSource, hashMap);
        oldController.setImageRequest(newBuilderWithSource.build());
        AbstractDraweeController build = oldController.build();
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setCornersRadius(m.r);
        GenericDraweeHierarchy build2 = new GenericDraweeHierarchyBuilder(v.getResources()).build();
        build2.setRoundingParams(roundingParams);
        build2.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        v.setHierarchy(build2);
        v.setController(build);
    }
}
