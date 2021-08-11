package c.a.p0.v0.a2.g;

import c.a.e.e.p.k;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class b extends c.a.o0.s.q.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f25514f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f25515e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2006744467, "Lc/a/p0/v0/a2/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2006744467, "Lc/a/p0/v0/a2/g/b;");
                return;
            }
        }
        f25514f = BdUniqueId.gen();
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

    public ArrayList<d> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25515e : (ArrayList) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.o0.s.q.a
    public c2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (c2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f25514f : (BdUniqueId) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !ListUtils.isEmpty(this.f25515e) : invokeV.booleanValue;
    }

    public void k(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, itemInfo) == null) {
            if (this.f25515e == null) {
                this.f25515e = new ArrayList<>();
            }
            this.f25515e.clear();
            if (itemInfo == null || (apkDetail = itemInfo.apk_detail) == null) {
                return;
            }
            if (!k.isEmpty(apkDetail.developer)) {
                this.f25515e.add(new d(TbadkCoreApplication.getInst().getResources().getString(R.string.developer), itemInfo.apk_detail.developer, null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.publisher)) {
                this.f25515e.add(new d(TbadkCoreApplication.getInst().getResources().getString(R.string.publisher), itemInfo.apk_detail.publisher, null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.version)) {
                this.f25515e.add(new d(TbadkCoreApplication.getInst().getResources().getString(R.string.current_version), itemInfo.apk_detail.version, null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.update_time)) {
                this.f25515e.add(new d(TbadkCoreApplication.getInst().getResources().getString(R.string.update_tiem), itemInfo.apk_detail.update_time, null));
            }
            if (c.a.e.e.m.b.f(itemInfo.apk_detail.size, 0L) > 0) {
                this.f25515e.add(new d(TbadkCoreApplication.getInst().getResources().getString(R.string.file_size), StringHelper.getFormatSize(c.a.e.e.m.b.f(itemInfo.apk_detail.size, 0L)), null));
            }
            if (itemInfo.apk_detail.need_network.intValue() > 0) {
                this.f25515e.add(new d(TbadkCoreApplication.getInst().getResources().getString(R.string.is_need_network), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_network.intValue() == 1 ? R.string.editor_dialog_yes : R.string.editor_dialog_no), null));
            }
            if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                this.f25515e.add(new d(TbadkCoreApplication.getInst().getResources().getString(R.string.has_purchasing), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_inner_buy.intValue() == 1 ? R.string.editor_dialog_yes : R.string.editor_dialog_no), null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.authority_url)) {
                this.f25515e.add(new d(TbadkCoreApplication.getInst().getResources().getString(R.string.permission_info), TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse), itemInfo.apk_detail.authority_url));
            }
            if (k.isEmpty(itemInfo.apk_detail.privacy_url)) {
                return;
            }
            this.f25515e.add(new d(TbadkCoreApplication.getInst().getResources().getString(R.string.privacy_info), TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse), itemInfo.apk_detail.privacy_url));
        }
    }
}
