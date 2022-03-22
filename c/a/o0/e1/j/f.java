package c.a.o0.e1.j;

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
/* loaded from: classes2.dex */
public class f implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f10135b;

    /* renamed from: c  reason: collision with root package name */
    public double f10136c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10137d;

    public f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f10135b = 3;
        this.f10137d = true;
        if (i > 0) {
            this.f10135b = i;
        }
    }

    @Override // c.a.o0.e1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, constrainImageLayout, list, i, i2)) == null) ? ListUtils.getCount(list) <= 0 ? i2 : e(constrainImageLayout, list, i2) : invokeLLII.intValue;
    }

    @Override // c.a.o0.e1.j.c
    public int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return 1;
        }
        return invokeI.intValue;
    }

    public final double c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            TbadkCoreApplication.getInst();
            if (i == 1) {
                return 0.5625d;
            }
            double d2 = this.f10136c;
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
            this.f10136c = d2;
        }
    }

    public int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, constrainImageLayout, list, i)) == null) {
            if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
                return i;
            }
            int count = ListUtils.getCount(list);
            if (count >= 2) {
                constrainImageLayout.setImageMaxChildCount(this.a);
                constrainImageLayout.setCanCenterStart(false);
            } else {
                constrainImageLayout.setImageMaxChildCount(-1);
                constrainImageLayout.setCanCenterStart(true);
            }
            int i3 = this.f10135b;
            int i4 = count - i3;
            if (i4 > 0) {
                i2 = i3 + i;
                List<MediaData> subList = ListUtils.subList(list, i, i2);
                constrainImageLayout.setExtraCenterText(this.f10137d ? TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0427, new Object[]{Integer.valueOf(i4)}) : null);
                constrainImageLayout.setUrls(subList, i, true, this.f10137d);
            } else {
                constrainImageLayout.setUrls(ListUtils.subList(list, i, count), i);
                constrainImageLayout.setExtraCenterText(null);
                i2 = count;
            }
            constrainImageLayout.setSingleImageRatio(c(count));
            return i2;
        }
        return invokeLLI.intValue;
    }
}
