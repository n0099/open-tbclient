package c.a.p0.j2.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes2.dex */
public class e implements c.a.d.o.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f15659c;

    /* renamed from: d  reason: collision with root package name */
    public static int f15660d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f15661e;

    /* renamed from: f  reason: collision with root package name */
    public static String f15662f;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public List<f> f15663b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1049979693, "Lc/a/p0/j2/c/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1049979693, "Lc/a/p0/j2/c/b/e;");
                return;
            }
        }
        f15659c = BdUniqueId.gen();
        f15660d = 3;
        f15661e = false;
    }

    public e(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipSpecialList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.a = dVar;
        dVar.e(4);
        this.a.d(vipSpecialList.class_name);
        this.a.f(vipSpecialList.class_url_name);
        this.a.g(vipSpecialList.class_url);
        String currentAccount = TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP;
        if (StringUtils.isNull(f15662f) || !f15662f.equals(currentAccount)) {
            f15661e = false;
            f15662f = currentAccount;
        }
        this.f15663b = new ArrayList();
        for (int i3 = 0; i3 < vipSpecialList.item.size(); i3++) {
            this.f15663b.add(new f(vipSpecialList.item.get(i3)));
            if (f15661e) {
                if (i3 == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > f15660d) {
                    this.f15663b.add(new f(true, true));
                }
            } else if (i3 == f15660d - 1 && vipSpecialList.item.size() > f15660d) {
                this.f15663b.add(new f(true, false));
                return;
            }
        }
    }

    @Override // c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f15659c : (BdUniqueId) invokeV.objValue;
    }
}
