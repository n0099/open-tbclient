package b.a.q0.c1;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12831a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.r0.b0.f0.c> f12832b;

    /* loaded from: classes4.dex */
    public class a implements Comparator<b.a.r0.b0.f0.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b.a.r0.b0.f0.c cVar, b.a.r0.b0.f0.c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, cVar2)) == null) ? cVar.sort() - cVar2.sort() : invokeLL.intValue;
        }
    }

    public o0() {
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
        this.f12832b = new LinkedList();
    }

    public List<b.a.r0.b0.f0.c> a(List<PbLinkData> list, List<PbGoodsData> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, list2)) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    PbLinkData pbLinkData = list.get(i2);
                    if (pbLinkData.urlType == 2 && !this.f12831a) {
                        this.f12831a = true;
                    }
                    this.f12832b.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(list2)) {
                this.f12831a = true;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    this.f12832b.add(list2.get(i3));
                }
            }
            Collections.sort(this.f12832b, new a(this));
            return this.f12832b;
        }
        return (List) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12831a : invokeV.booleanValue;
    }
}
