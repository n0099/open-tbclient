package c.n.a.f;

import android.graphics.Canvas;
import android.widget.ImageView;
import c.n.a.g.f;
import c.n.a.g.g;
import c.n.a.h.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f34374a;

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f34375b;

    /* renamed from: c.n.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public final class C1514a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f34376a;

        /* renamed from: b  reason: collision with root package name */
        public final g f34377b;

        public C1514a(a aVar, String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34376a = str;
            this.f34377b = gVar;
        }

        public final g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34377b : (g) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34376a : (String) invokeV.objValue;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVGAVideoEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34375b = sVGAVideoEntity;
        this.f34374a = new e();
    }

    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, canvas, i2, scaleType) == null) {
            this.f34374a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f34375b.h().b(), (float) this.f34375b.h().a(), scaleType);
        }
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34374a : (e) invokeV.objValue;
    }

    public final SVGAVideoEntity c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34375b : (SVGAVideoEntity) invokeV.objValue;
    }

    public final List<C1514a> d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            List<f> g2 = this.f34375b.g();
            ArrayList arrayList = new ArrayList();
            for (f fVar : g2) {
                C1514a c1514a = null;
                if (i2 >= 0 && i2 < fVar.a().size() && fVar.a().get(i2).a() > 0.0d) {
                    c1514a = new C1514a(this, fVar.b(), fVar.a().get(i2));
                }
                if (c1514a != null) {
                    arrayList.add(c1514a);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
