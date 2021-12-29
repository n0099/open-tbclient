package c.a.t0.x1;

import android.text.TextUtils;
import c.a.t0.g0.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class i implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final StatisticItem a;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b implements e {
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

        @Override // c.a.t0.x1.e
        public void a(ICardInfo iCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iCardInfo) == null) {
            }
        }

        @Override // c.a.t0.x1.e
        public e b(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) ? this : (e) invokeLI.objValue;
        }

        @Override // c.a.t0.x1.e
        public e c(String str, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2)) == null) ? this : (e) invokeLJ.objValue;
        }

        @Override // c.a.t0.x1.e
        public e d(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? this : (e) invokeLL.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(BaseLegoCardInfo baseLegoCardInfo) {
        this(baseLegoCardInfo.getStatistics(), baseLegoCardInfo.getStatTab(), baseLegoCardInfo.getCardType(), baseLegoCardInfo.getItemId());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseLegoCardInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static e e(BaseLegoCardInfo baseLegoCardInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, baseLegoCardInfo)) == null) {
            return baseLegoCardInfo != null && !TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) ? new i(baseLegoCardInfo) : new b(null);
        }
        return (e) invokeL.objValue;
    }

    public static e f(String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) ? !TextUtils.isEmpty(str) ? new i(str, i2, i3, str2) : new b(null) : (e) invokeCommon.objValue;
    }

    @Override // c.a.t0.x1.e
    public void a(ICardInfo iCardInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iCardInfo) == null) {
            g(iCardInfo);
            TiebaStatic.log(this.a);
        }
    }

    @Override // c.a.t0.x1.e
    public e b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.a.param(str, i2);
            }
            return this;
        }
        return (e) invokeLI.objValue;
    }

    @Override // c.a.t0.x1.e
    public e c(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.a.param(str, String.valueOf(j2));
            }
            return this;
        }
        return (e) invokeLJ.objValue;
    }

    @Override // c.a.t0.x1.e
    public e d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.a.param(str, str2);
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public final void g(ICardInfo iCardInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iCardInfo) == null) {
            BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) iCardInfo;
            if (TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) || TextUtils.isEmpty(baseLegoCardInfo.getsExtras())) {
                return;
            }
            List<Object> params = this.a.getParams();
            for (String str : baseLegoCardInfo.getsExtras().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    String str2 = split[0];
                    String str3 = split[1];
                    boolean z = false;
                    for (int i2 = 0; i2 < params.size() && !z; i2 += 2) {
                        if (TextUtils.equals(str2, params.get(i2).toString())) {
                            int i3 = i2 + 1;
                            if (i3 < params.size()) {
                                params.set(i3, str3);
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        this.a.param(str2, str3);
                    }
                }
            }
            d(TiebaStatic.Params.OBJ_PARAM3, m.e());
        }
    }

    public i(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        StatisticItem statisticItem = new StatisticItem(str);
        this.a = statisticItem;
        statisticItem.param("obj_source", i2);
        this.a.param("obj_type", i3);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.a.param("obj_card", str2);
    }
}
