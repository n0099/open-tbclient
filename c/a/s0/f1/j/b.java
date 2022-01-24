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
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.s0.f1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, constrainImageLayout, list, i2, i3)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return i3;
            }
            if (i2 == 0) {
                return e(constrainImageLayout, list, i3);
            }
            if (i2 == 1) {
                return d(constrainImageLayout, list, i3);
            }
            return i2 == 2 ? c(constrainImageLayout, list, i3) : i3;
        }
        return invokeLLII.intValue;
    }

    @Override // c.a.s0.f1.j.c
    public int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < 4) {
                return 1;
            }
            return (i2 < 4 || i2 >= 7) ? 3 : 2;
        }
        return invokeI.intValue;
    }

    public final int c(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, constrainImageLayout, list, i2)) == null) {
            if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
                return i2;
            }
            int count = ListUtils.getCount(list);
            constrainImageLayout.setImageMaxChildCount(3);
            int i3 = count - 9;
            if (i3 > 0) {
                int i4 = i2 + 3;
                List<MediaData> subList = ListUtils.subList(list, i2, i4);
                constrainImageLayout.setExtraCenterText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
                constrainImageLayout.setUrls(subList, i2, true);
                return i4;
            }
            constrainImageLayout.setUrls(ListUtils.subList(list, i2, count), i2);
            constrainImageLayout.setExtraCenterText(null);
            return count;
        }
        return invokeLLI.intValue;
    }

    public final int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, constrainImageLayout, list, i2)) == null) {
            if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
                return i2;
            }
            if (ListUtils.getCount(list) == 4) {
                int i3 = i2 + 2;
                constrainImageLayout.setUrls(ListUtils.subList(list, i2, i3), i2);
                return i3;
            }
            int i4 = i2 + 3;
            constrainImageLayout.setUrls(ListUtils.subList(list, i2, i4), i2);
            return i4;
        }
        return invokeLLI.intValue;
    }

    public final int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, constrainImageLayout, list, i2)) == null) {
            if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
                return i2;
            }
            int count = ListUtils.getCount(list);
            if (count == 1) {
                constrainImageLayout.setUrls(list, i2);
                return 0;
            } else if (count != 2 && count != 4 && count != 5) {
                int i3 = i2 + 3;
                constrainImageLayout.setUrls(ListUtils.subList(list, i2, i3), i2);
                return i3;
            } else {
                int i4 = i2 + 2;
                constrainImageLayout.setUrls(ListUtils.subList(list, i2, i4), i2);
                return i4;
            }
        }
        return invokeLLI.intValue;
    }
}
