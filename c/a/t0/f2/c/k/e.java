package c.a.t0.f2.c.k;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes7.dex */
public class e implements c.a.d.n.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f17885i;

    /* renamed from: j  reason: collision with root package name */
    public static int f17886j;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f17887k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VipSpecialList f17888e;

    /* renamed from: f  reason: collision with root package name */
    public d f17889f;

    /* renamed from: g  reason: collision with root package name */
    public List<f> f17890g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17891h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(206461948, "Lc/a/t0/f2/c/k/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(206461948, "Lc/a/t0/f2/c/k/e;");
                return;
            }
        }
        f17885i = BdUniqueId.gen();
        f17886j = 3;
        f17887k = false;
    }

    public e(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipSpecialList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17891h = true;
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        this.f17888e = vipSpecialList;
        d dVar = new d();
        this.f17889f = dVar;
        dVar.f(4);
        this.f17889f.e(vipSpecialList.class_name);
        this.f17889f.g(vipSpecialList.class_url_name);
        this.f17889f.h(vipSpecialList.class_url);
        String currentAccount = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP;
        if (StringUtils.isNull(l) || !l.equals(currentAccount)) {
            f17887k = false;
            l = currentAccount;
        }
        this.f17890g = new ArrayList();
        for (int i4 = 0; i4 < vipSpecialList.item.size(); i4++) {
            this.f17890g.add(new f(vipSpecialList.item.get(i4)));
            if (f17887k) {
                if (i4 == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > f17886j) {
                    this.f17890g.add(new f(true, true));
                }
            } else if (i4 == f17886j - 1 && vipSpecialList.item.size() > f17886j) {
                this.f17890g.add(new f(true, false));
                return;
            }
        }
    }

    public d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17889f : (d) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f17887k : invokeV.booleanValue;
    }

    public List<f> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17890g : (List) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            f17887k = z;
        }
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f17885i : (BdUniqueId) invokeV.objValue;
    }
}
