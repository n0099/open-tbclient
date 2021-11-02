package b.a.r0.x0.l2.g;

import b.a.e.e.p.k;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.x0.h1;
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
public class b extends b.a.q0.s.q.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f25962f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<g> f25963e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(846207645, "Lb/a/r0/x0/l2/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(846207645, "Lb/a/r0/x0/l2/g/b;");
                return;
            }
        }
        f25962f = BdUniqueId.gen();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25963e : (ArrayList) invokeV.objValue;
    }

    @Override // b.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (x0) invokeV.objValue;
    }

    @Override // b.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (d2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f25962f : (BdUniqueId) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !ListUtils.isEmpty(this.f25963e) : invokeV.booleanValue;
    }

    public void k(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, itemInfo) == null) {
            if (this.f25963e == null) {
                this.f25963e = new ArrayList<>();
            }
            this.f25963e.clear();
            if (itemInfo == null || (apkDetail = itemInfo.apk_detail) == null) {
                return;
            }
            if (!k.isEmpty(apkDetail.developer)) {
                this.f25963e.add(new g(TbadkCoreApplication.getInst().getResources().getString(h1.developer), itemInfo.apk_detail.developer, null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.publisher)) {
                this.f25963e.add(new g(TbadkCoreApplication.getInst().getResources().getString(h1.publisher), itemInfo.apk_detail.publisher, null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.version)) {
                this.f25963e.add(new g(TbadkCoreApplication.getInst().getResources().getString(h1.current_version), itemInfo.apk_detail.version, null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.update_time)) {
                this.f25963e.add(new g(TbadkCoreApplication.getInst().getResources().getString(h1.update_tiem), itemInfo.apk_detail.update_time, null));
            }
            if (b.a.e.e.m.b.g(itemInfo.apk_detail.size, 0L) > 0) {
                this.f25963e.add(new g(TbadkCoreApplication.getInst().getResources().getString(h1.file_size), StringHelper.getFormatSize(b.a.e.e.m.b.g(itemInfo.apk_detail.size, 0L)), null));
            }
            if (itemInfo.apk_detail.need_network.intValue() > 0) {
                this.f25963e.add(new g(TbadkCoreApplication.getInst().getResources().getString(h1.is_need_network), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_network.intValue() == 1 ? h1.editor_dialog_yes : h1.editor_dialog_no), null));
            }
            if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                this.f25963e.add(new g(TbadkCoreApplication.getInst().getResources().getString(h1.has_purchasing), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_inner_buy.intValue() == 1 ? h1.editor_dialog_yes : h1.editor_dialog_no), null));
            }
            if (!k.isEmpty(itemInfo.apk_detail.authority_url)) {
                this.f25963e.add(new g(TbadkCoreApplication.getInst().getResources().getString(h1.permission_info), TbadkCoreApplication.getInst().getResources().getString(h1.item_browse), itemInfo.apk_detail.authority_url));
            }
            if (k.isEmpty(itemInfo.apk_detail.privacy_url)) {
                return;
            }
            this.f25963e.add(new g(TbadkCoreApplication.getInst().getResources().getString(h1.privacy_info), TbadkCoreApplication.getInst().getResources().getString(h1.item_browse), itemInfo.apk_detail.privacy_url));
        }
    }
}
