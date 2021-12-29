package c.a.t0.p0.b;

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
    public static final BdUniqueId f21940i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemData f21941e;

    /* renamed from: f  reason: collision with root package name */
    public int f21942f;

    /* renamed from: g  reason: collision with root package name */
    public int f21943g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21944h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(438084328, "Lc/a/t0/p0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(438084328, "Lc/a/t0/p0/b/b;");
                return;
            }
        }
        f21940i = BdUniqueId.gen();
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
        this.f21941e = null;
        this.f21942f = 0;
        this.f21943g = 0;
        this.f21944h = true;
    }

    public static b d(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) {
            b bVar = new b();
            bVar.f21941e = eVar.f14461b;
            bVar.f21942f = eVar.f14463d;
            bVar.f21943g = eVar.f14464e;
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
            bVar.f21941e = itemData;
            itemData.parseProto(manageInfo.item);
            bVar.f21942f = manageInfo.item_source.intValue();
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
            bVar.f21941e = this.f21941e;
            bVar.f21942f = this.f21942f;
            bVar.f21943g = this.f21943g;
            bVar.f21944h = this.f21944h;
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
            boolean z = this.f21942f == bVar.f21942f && this.f21943g == bVar.f21943g;
            ItemData itemData3 = this.f21941e;
            boolean equals = (itemData3 == null || (itemData2 = bVar.f21941e) == null) ? false : itemData3.pkgName.equals(itemData2.pkgName);
            ItemData itemData4 = this.f21941e;
            return z && equals && ((itemData4 == null || (itemData = bVar.f21941e) == null || (apkDetail = itemData4.apkDetail) == null || (apkDetail2 = itemData.apkDetail) == null) ? false : apkDetail.version_code.equals(apkDetail2.version_code));
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f21940i : (BdUniqueId) invokeV.objValue;
    }
}
