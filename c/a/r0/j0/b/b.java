package c.a.r0.j0.b;

import c.a.e.l.e.n;
import c.a.q0.u.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
import tbclient.ManageInfo;
/* loaded from: classes3.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f19308i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemData f19309e;

    /* renamed from: f  reason: collision with root package name */
    public int f19310f;

    /* renamed from: g  reason: collision with root package name */
    public int f19311g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19312h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-198943452, "Lc/a/r0/j0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-198943452, "Lc/a/r0/j0/b/b;");
                return;
            }
        }
        f19308i = BdUniqueId.gen();
    }

    public b() {
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
        this.f19309e = null;
        this.f19310f = 0;
        this.f19311g = 0;
        this.f19312h = true;
    }

    public static b c(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            b bVar = new b();
            bVar.f19309e = dVar.f15047b;
            bVar.f19310f = dVar.f15049d;
            bVar.f19311g = dVar.f15050e;
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static b d(ManageInfo manageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, manageInfo)) == null) {
            b bVar = new b();
            ItemData itemData = new ItemData();
            bVar.f19309e = itemData;
            itemData.parseProto(manageInfo.item);
            bVar.f19310f = manageInfo.item_source.intValue();
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public b clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = new b();
            bVar.f19309e = this.f19309e;
            bVar.f19310f = this.f19310f;
            bVar.f19311g = this.f19311g;
            bVar.f19312h = this.f19312h;
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public boolean g(b bVar) {
        InterceptResult invokeL;
        ItemData itemData;
        ApkDetail apkDetail;
        ApkDetail apkDetail2;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            boolean z = this.f19310f == bVar.f19310f && this.f19311g == bVar.f19311g;
            ItemData itemData3 = this.f19309e;
            boolean equals = (itemData3 == null || (itemData2 = bVar.f19309e) == null) ? false : itemData3.pkgName.equals(itemData2.pkgName);
            ItemData itemData4 = this.f19309e;
            return z && equals && ((itemData4 == null || (itemData = bVar.f19309e) == null || (apkDetail = itemData4.apkDetail) == null || (apkDetail2 = itemData.apkDetail) == null) ? false : apkDetail.version_code.equals(apkDetail2.version_code));
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f19308i : (BdUniqueId) invokeV.objValue;
    }
}
