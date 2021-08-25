package c.a.q0.h1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes3.dex */
public class n extends c.a.q0.a0.d0.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f18656g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.l.e.n> f18657e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18658f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1748777995, "Lc/a/q0/h1/c/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1748777995, "Lc/a/q0/h1/c/n;");
                return;
            }
        }
        f18656g = BdUniqueId.gen();
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18657e = null;
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<c.a.e.l.e.n> list = this.f18657e;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f18657e.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f18656g : (BdUniqueId) invokeV.objValue;
    }

    public void parserProtobuf(List<RelateForum> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        this.showTopDivider = true;
        this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
        this.f18657e = new ArrayList();
        for (RelateForum relateForum : list) {
            if (!StringUtils.isNull(relateForum.forum_name)) {
                RelateForumItemData relateForumItemData = new RelateForumItemData();
                relateForumItemData.parserProtobuf(relateForum);
                this.f18657e.add(relateForumItemData);
            }
        }
    }
}
