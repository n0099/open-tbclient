package c.a.t0.q0.a;

import c.a.d.n.e.n;
import c.a.s0.u.e;
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
/* loaded from: classes8.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f21667i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemData f21668e;

    /* renamed from: f  reason: collision with root package name */
    public int f21669f;

    /* renamed from: g  reason: collision with root package name */
    public int f21670g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21671h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1325558218, "Lc/a/t0/q0/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1325558218, "Lc/a/t0/q0/a/b;");
                return;
            }
        }
        f21667i = BdUniqueId.gen();
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
        this.f21668e = null;
        this.f21669f = 0;
        this.f21670g = 0;
        this.f21671h = true;
    }

    public static b d(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) {
            b bVar = new b();
            bVar.f21668e = eVar.f14264b;
            bVar.f21669f = eVar.f14266d;
            bVar.f21670g = eVar.f14267e;
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static b e(ManageInfo manageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, manageInfo)) == null) {
            b bVar = new b();
            ItemData itemData = new ItemData();
            bVar.f21668e = itemData;
            itemData.parseProto(manageInfo.item);
            bVar.f21669f = manageInfo.item_source.intValue();
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public b clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = new b();
            bVar.f21668e = this.f21668e;
            bVar.f21669f = this.f21669f;
            bVar.f21670g = this.f21670g;
            bVar.f21671h = this.f21671h;
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
            boolean z = this.f21669f == bVar.f21669f && this.f21670g == bVar.f21670g;
            ItemData itemData3 = this.f21668e;
            boolean equals = (itemData3 == null || (itemData2 = bVar.f21668e) == null) ? false : itemData3.pkgName.equals(itemData2.pkgName);
            ItemData itemData4 = this.f21668e;
            return z && equals && ((itemData4 == null || (itemData = bVar.f21668e) == null || (apkDetail = itemData4.apkDetail) == null || (apkDetail2 = itemData.apkDetail) == null) ? false : apkDetail.version_code.equals(apkDetail2.version_code));
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f21667i : (BdUniqueId) invokeV.objValue;
    }
}
