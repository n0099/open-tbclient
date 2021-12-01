package c.a.r0.d1.m2.g;

import c.a.d.f.p.k;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.d1.i1;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ApkDetail;
import tbclient.ItemInfo;
/* loaded from: classes5.dex */
public class b extends c.a.q0.s.q.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f15712f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<g> f15713e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(914869364, "Lc/a/r0/d1/m2/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(914869364, "Lc/a/r0/d1/m2/g/b;");
                return;
            }
        }
        f15712f = BdUniqueId.gen();
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
        setSupportType(BaseCardInfo.SupportType.FULL);
    }

    public ArrayList<g> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15713e : (ArrayList) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f15712f : (BdUniqueId) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !ListUtils.isEmpty(this.f15713e) : invokeV.booleanValue;
    }

    public void k(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, itemInfo) == null) {
            if (this.f15713e == null) {
                this.f15713e = new ArrayList<>();
            }
            this.f15713e.clear();
            if (itemInfo == null || (apkDetail = itemInfo.apk_detail) == null) {
                return;
            }
            if (!k.isEmpty(apkDetail.developer)) {
                this.f15713e.add(new g(TbadkCoreApplication.getInst().getResources().getString(i1.developer), itemInfo.apk_detail.developer, null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.publisher)) {
                this.f15713e.add(new g(TbadkCoreApplication.getInst().getResources().getString(i1.publisher), itemInfo.apk_detail.publisher, null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.version)) {
                this.f15713e.add(new g(TbadkCoreApplication.getInst().getResources().getString(i1.current_version), itemInfo.apk_detail.version, null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.update_time)) {
                this.f15713e.add(new g(TbadkCoreApplication.getInst().getResources().getString(i1.update_tiem), itemInfo.apk_detail.update_time, null));
            }
            if (c.a.d.f.m.b.g(itemInfo.apk_detail.size, 0L) > 0) {
                this.f15713e.add(new g(TbadkCoreApplication.getInst().getResources().getString(i1.file_size), StringHelper.getFormatSize(c.a.d.f.m.b.g(itemInfo.apk_detail.size, 0L)), null));
            }
            if (itemInfo.apk_detail.need_network.intValue() > 0) {
                this.f15713e.add(new g(TbadkCoreApplication.getInst().getResources().getString(i1.is_need_network), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_network.intValue() == 1 ? i1.editor_dialog_yes : i1.editor_dialog_no), null));
            }
            if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                this.f15713e.add(new g(TbadkCoreApplication.getInst().getResources().getString(i1.has_purchasing), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_inner_buy.intValue() == 1 ? i1.editor_dialog_yes : i1.editor_dialog_no), null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.authority_url)) {
                this.f15713e.add(new g(TbadkCoreApplication.getInst().getResources().getString(i1.permission_info), TbadkCoreApplication.getInst().getResources().getString(i1.item_browse), itemInfo.apk_detail.authority_url));
            }
            if (k.isEmpty(itemInfo.apk_detail.privacy_url)) {
                return;
            }
            this.f15713e.add(new g(TbadkCoreApplication.getInst().getResources().getString(i1.privacy_info), TbadkCoreApplication.getInst().getResources().getString(i1.item_browse), itemInfo.apk_detail.privacy_url));
        }
    }
}
