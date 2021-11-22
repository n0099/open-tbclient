package b.a.r0.j0.b;

import b.a.e.m.e.n;
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
    public static final BdUniqueId f19629i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemData f19630e;

    /* renamed from: f  reason: collision with root package name */
    public int f19631f;

    /* renamed from: g  reason: collision with root package name */
    public int f19632g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19633h;

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
        f19629i = BdUniqueId.gen();
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
        this.f19630e = null;
        this.f19631f = 0;
        this.f19632g = 0;
        this.f19633h = true;
    }

    public static b d(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) {
            b bVar = new b();
            bVar.f19630e = eVar.f14896b;
            bVar.f19631f = eVar.f14898d;
            bVar.f19632g = eVar.f14899e;
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
            bVar.f19630e = itemData;
            itemData.parseProto(manageInfo.item);
            bVar.f19631f = manageInfo.item_source.intValue();
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
            bVar.f19630e = this.f19630e;
            bVar.f19631f = this.f19631f;
            bVar.f19632g = this.f19632g;
            bVar.f19633h = this.f19633h;
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
            boolean z = this.f19631f == bVar.f19631f && this.f19632g == bVar.f19632g;
            ItemData itemData3 = this.f19630e;
            boolean equals = (itemData3 == null || (itemData2 = bVar.f19630e) == null) ? false : itemData3.pkgName.equals(itemData2.pkgName);
            ItemData itemData4 = this.f19630e;
            return z && equals && ((itemData4 == null || (itemData = bVar.f19630e) == null || (apkDetail = itemData4.apkDetail) == null || (apkDetail2 = itemData.apkDetail) == null) ? false : apkDetail.version_code.equals(apkDetail2.version_code));
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.e.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f19629i : (BdUniqueId) invokeV.objValue;
    }
}
