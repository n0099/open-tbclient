package c.a.p0.s.q;

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
/* loaded from: classes3.dex */
public class f1 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId M0;
    public transient /* synthetic */ FieldHolder $fh;
    public String D0;
    public String E0;
    public String F0;
    public String G0;
    public String H0;
    public String I0;
    public List<String> J0;
    public String K0;
    public String L0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-377462675, "Lc/a/p0/s/q/f1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-377462675, "Lc/a/p0/s/q/f1;");
                return;
            }
        }
        M0 = BdUniqueId.gen();
    }

    public f1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !StringUtils.isNull(this.G0) : invokeV.booleanValue;
    }

    public void D0(RecommendBook recommendBook) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recommendBook) == null) || recommendBook == null) {
            return;
        }
        this.D0 = recommendBook.recommend_text;
        this.E0 = recommendBook.suggest_text;
        this.F0 = recommendBook.suggest_url;
        this.G0 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.H0 = recommendBook.book_cover;
        this.I0 = recommendBook.book_title;
        this.J0 = recommendBook.book_tips;
        this.K0 = recommendBook.botton_text;
        this.L0 = recommendBook.subscript_icon;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? M0 : (BdUniqueId) invokeV.objValue;
    }
}
