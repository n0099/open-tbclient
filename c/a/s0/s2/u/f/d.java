package c.a.s0.s2.u.f;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d extends c.a.r0.f1.n.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static double K = 0.5d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i2;
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null || tbImageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                return;
            }
            Matrix imageMatrix = tbImageView.getImageMatrix();
            c.a.d.m.d.a m = c.a.r0.c0.c.k().m(c.a.d.f.l.d.h().g(tbImageView.getUrl(), this.a.r ? 17 : 18));
            int i3 = 0;
            if (m != null) {
                i3 = m.r();
                i2 = m.m();
            } else {
                i2 = 0;
            }
            if (i3 == 0 || i2 == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            if (i3 * height > width * i2) {
                f2 = height;
                f3 = i2;
            } else {
                f2 = width;
                f3 = i3;
            }
            float f4 = f2 / f3;
            imageMatrix.setScale(f4, f4);
            imageMatrix.postTranslate(0.0f, 0.0f);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1429516578, "Lc/a/s0/s2/u/f/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1429516578, "Lc/a/s0/s2/u/f/d;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.r0.f1.n.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.r0.f1.n.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        k(true);
        t();
        o(TbConfig.getPostLineSpace(), 1.0f);
        y(0);
        l(c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds30));
        m(c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds12));
        i(c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds48), c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds48));
        r(c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.M_H_X004), c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.M_H_X004));
        j(c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.M_H_X004));
        this.G = c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds749);
        this.H = c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds10);
        c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.s2.g.tbds26);
        this.I = new a(this);
    }

    @Override // c.a.r0.f1.n.a
    public int[] e(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i2, i3, i4, i5)) == null) {
            if (i3 <= 0 || i2 <= 0 || i4 <= 0 || i5 <= 0) {
                return null;
            }
            if (this.s) {
                float f2 = c.a.r0.f1.n.a.J;
                if (f2 > 1.0f) {
                    float f3 = i2;
                    if (f3 * f2 <= i4 * K) {
                        i4 = (int) (f3 * f2);
                    }
                    i3 = (i3 * i4) / i2;
                    if (i3 > 4096) {
                        this.p = ImageView.ScaleType.MATRIX;
                        i2 = i4;
                        i3 = 4096;
                    } else {
                        this.p = ImageView.ScaleType.CENTER_CROP;
                        i2 = i4;
                    }
                }
            }
            return new int[]{i2, i3};
        }
        return (int[]) invokeIIII.objValue;
    }
}
