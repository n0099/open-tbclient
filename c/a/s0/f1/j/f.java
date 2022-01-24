package c.a.s0.f1.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class f implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f12737b;

    /* renamed from: c  reason: collision with root package name */
    public double f12738c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12739d;

    public f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f12737b = 3;
        this.f12739d = true;
        if (i2 > 0) {
            this.f12737b = i2;
        }
    }

    @Override // c.a.s0.f1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, constrainImageLayout, list, i2, i3)) == null) ? ListUtils.getCount(list) <= 0 ? i3 : e(constrainImageLayout, list, i3) : invokeLLII.intValue;
    }

    @Override // c.a.s0.f1.j.c
    public int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            return 1;
        }
        return invokeI.intValue;
    }

    public final double c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            TbadkCoreApplication.getInst();
            if (i2 == 1) {
                return 0.5625d;
            }
            double d2 = this.f12738c;
            if (d2 > 0.0d) {
                return d2;
            }
            return 0.6666666666666666d;
        }
        return invokeI.doubleValue;
    }

    public void d(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f12738c = d2;
        }
    }

    public int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, constrainImageLayout, list, i2)) == null) {
            if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
                return i2;
            }
            int count = ListUtils.getCount(list);
            if (count >= 2) {
                constrainImageLayout.setImageMaxChildCount(this.a);
                constrainImageLayout.setCanCenterStart(false);
            } else {
                constrainImageLayout.setImageMaxChildCount(-1);
                constrainImageLayout.setCanCenterStart(true);
            }
            int i4 = this.f12737b;
            int i5 = count - i4;
            if (i5 > 0) {
                i3 = i4 + i2;
                List<MediaData> subList = ListUtils.subList(list, i2, i3);
                constrainImageLayout.setExtraCenterText(this.f12739d ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i5)}) : null);
                constrainImageLayout.setUrls(subList, i2, true, this.f12739d);
            } else {
                constrainImageLayout.setUrls(ListUtils.subList(list, i2, count), i2);
                constrainImageLayout.setExtraCenterText(null);
                i3 = count;
            }
            constrainImageLayout.setSingleImageRatio(c(count));
            return i3;
        }
        return invokeLLI.intValue;
    }
}
