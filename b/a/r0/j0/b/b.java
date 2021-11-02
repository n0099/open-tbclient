package b.a.r0.j0.b;

import b.a.e.l.e.n;
import b.a.q0.u.e;
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
/* loaded from: classes4.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f18295i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemData f18296e;

    /* renamed from: f  reason: collision with root package name */
    public int f18297f;

    /* renamed from: g  reason: collision with root package name */
    public int f18298g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18299h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(306615173, "Lb/a/r0/j0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(306615173, "Lb/a/r0/j0/b/b;");
                return;
            }
        }
        f18295i = BdUniqueId.gen();
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
        this.f18296e = null;
        this.f18297f = 0;
        this.f18298g = 0;
        this.f18299h = true;
    }

    public static b d(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) {
            b bVar = new b();
            bVar.f18296e = eVar.f14129b;
            bVar.f18297f = eVar.f14131d;
            bVar.f18298g = eVar.f14132e;
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
            bVar.f18296e = itemData;
            itemData.parseProto(manageInfo.item);
            bVar.f18297f = manageInfo.item_source.intValue();
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
            bVar.f18296e = this.f18296e;
            bVar.f18297f = this.f18297f;
            bVar.f18298g = this.f18298g;
            bVar.f18299h = this.f18299h;
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
            boolean z = this.f18297f == bVar.f18297f && this.f18298g == bVar.f18298g;
            ItemData itemData3 = this.f18296e;
            boolean equals = (itemData3 == null || (itemData2 = bVar.f18296e) == null) ? false : itemData3.pkgName.equals(itemData2.pkgName);
            ItemData itemData4 = this.f18296e;
            return z && equals && ((itemData4 == null || (itemData = bVar.f18296e) == null || (apkDetail = itemData4.apkDetail) == null || (apkDetail2 = itemData.apkDetail) == null) ? false : apkDetail.version_code.equals(apkDetail2.version_code));
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f18295i : (BdUniqueId) invokeV.objValue;
    }
}
