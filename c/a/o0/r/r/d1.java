package c.a.o0.r.r;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes2.dex */
public class d1 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId N0;
    public transient /* synthetic */ FieldHolder $fh;
    public String E0;
    public String F0;
    public String G0;
    public String H0;
    public String I0;
    public String J0;
    public List<String> K0;
    public String L0;
    public String M0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1067531252, "Lc/a/o0/r/r/d1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1067531252, "Lc/a/o0/r/r/d1;");
                return;
            }
        }
        N0 = BdUniqueId.gen();
    }

    public d1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !StringUtils.isNull(this.H0) : invokeV.booleanValue;
    }

    public void K0(RecommendBook recommendBook) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recommendBook) == null) || recommendBook == null) {
            return;
        }
        this.E0 = recommendBook.recommend_text;
        this.F0 = recommendBook.suggest_text;
        this.G0 = recommendBook.suggest_url;
        this.H0 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.I0 = recommendBook.book_cover;
        this.J0 = recommendBook.book_title;
        this.K0 = recommendBook.book_tips;
        this.L0 = recommendBook.botton_text;
        this.M0 = recommendBook.subscript_icon;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? N0 : (BdUniqueId) invokeV.objValue;
    }
}
