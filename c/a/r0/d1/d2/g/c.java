package c.a.r0.d1.d2.g;

import android.content.res.Resources;
import c.a.d.f.p.m;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.x0;
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
/* loaded from: classes2.dex */
public class c extends c.a.q0.r.r.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f15448f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<h> f15449e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1517270858, "Lc/a/r0/d1/d2/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1517270858, "Lc/a/r0/d1/d2/g/c;");
                return;
            }
        }
        f15448f = BdUniqueId.gen();
    }

    public c() {
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

    public ArrayList<h> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15449e : (ArrayList) invokeV.objValue;
    }

    @Override // c.a.q0.r.r.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (x0) invokeV.objValue;
    }

    @Override // c.a.q0.r.r.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (e2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f15448f : (BdUniqueId) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !ListUtils.isEmpty(this.f15449e) : invokeV.booleanValue;
    }

    public void k(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, itemInfo) == null) {
            if (this.f15449e == null) {
                this.f15449e = new ArrayList<>();
            }
            this.f15449e.clear();
            if (itemInfo == null || (apkDetail = itemInfo.apk_detail) == null) {
                return;
            }
            if (!m.isEmpty(apkDetail.developer)) {
                this.f15449e.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.developer), itemInfo.apk_detail.developer, null));
            }
            if (!m.isEmpty(itemInfo.apk_detail.publisher)) {
                this.f15449e.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.publisher), itemInfo.apk_detail.publisher, null));
            }
            if (!m.isEmpty(itemInfo.apk_detail.version)) {
                this.f15449e.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.current_version), itemInfo.apk_detail.version, null));
            }
            if (!m.isEmpty(itemInfo.apk_detail.update_time)) {
                this.f15449e.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.update_tiem), itemInfo.apk_detail.update_time, null));
            }
            if (c.a.d.f.m.b.g(itemInfo.apk_detail.size, 0L) > 0) {
                this.f15449e.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.file_size), StringHelper.getFormatSize(c.a.d.f.m.b.g(itemInfo.apk_detail.size, 0L)), null));
            }
            int intValue = itemInfo.apk_detail.need_network.intValue();
            int i2 = R.string.editor_dialog_yes;
            if (intValue > 0) {
                this.f15449e.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.is_need_network), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_network.intValue() == 1 ? R.string.editor_dialog_yes : R.string.editor_dialog_no), null));
            }
            if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                ArrayList<h> arrayList = this.f15449e;
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.has_purchasing);
                Resources resources = TbadkCoreApplication.getInst().getResources();
                if (itemInfo.apk_detail.need_inner_buy.intValue() != 1) {
                    i2 = R.string.editor_dialog_no;
                }
                arrayList.add(new h(string, resources.getString(i2), null));
            }
            if (!m.isEmpty(itemInfo.apk_detail.authority_url)) {
                this.f15449e.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.permission_info), TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse), itemInfo.apk_detail.authority_url));
            }
            if (m.isEmpty(itemInfo.apk_detail.privacy_url)) {
                return;
            }
            this.f15449e.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.privacy_info), TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse), itemInfo.apk_detail.privacy_url));
        }
    }
}
