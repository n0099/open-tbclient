package c.a.p0.f1.d2.g;

import android.content.res.Resources;
import c.a.d.f.p.m;
import c.a.o0.r.r.v0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
public class c extends c.a.o0.r.r.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final BdUniqueId f13928b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<h> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1711049862, "Lc/a/p0/f1/d2/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1711049862, "Lc/a/p0/f1/d2/g/c;");
                return;
            }
        }
        f13928b = BdUniqueId.gen();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setSupportType(BaseCardInfo.SupportType.FULL);
    }

    public ArrayList<h> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !ListUtils.isEmpty(this.a) : invokeV.booleanValue;
    }

    @Override // c.a.o0.r.r.a
    public v0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (v0) invokeV.objValue;
    }

    @Override // c.a.o0.r.r.a
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f13928b : (BdUniqueId) invokeV.objValue;
    }

    public void i(ItemInfo itemInfo) {
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, itemInfo) == null) {
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
            this.a.clear();
            if (itemInfo == null || (apkDetail = itemInfo.apk_detail) == null) {
                return;
            }
            if (!m.isEmpty(apkDetail.developer)) {
                this.a.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04ce), itemInfo.apk_detail.developer, null));
            }
            if (!m.isEmpty(itemInfo.apk_detail.publisher)) {
                this.a.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0efa), itemInfo.apk_detail.publisher, null));
            }
            if (!m.isEmpty(itemInfo.apk_detail.version)) {
                this.a.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0464), itemInfo.apk_detail.version, null));
            }
            if (!m.isEmpty(itemInfo.apk_detail.update_time)) {
                this.a.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f148b), itemInfo.apk_detail.update_time, null));
            }
            if (c.a.d.f.m.b.g(itemInfo.apk_detail.size, 0L) > 0) {
                this.a.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f05f8), StringHelper.getFormatSize(c.a.d.f.m.b.g(itemInfo.apk_detail.size, 0L)), null));
            }
            int intValue = itemInfo.apk_detail.need_network.intValue();
            int i = R.string.obfuscated_res_0x7f0f0516;
            if (intValue > 0) {
                this.a.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0962), TbadkCoreApplication.getInst().getResources().getString(itemInfo.apk_detail.need_network.intValue() == 1 ? R.string.obfuscated_res_0x7f0f0516 : R.string.obfuscated_res_0x7f0f0515), null));
            }
            if (itemInfo.apk_detail.need_inner_buy.intValue() > 0) {
                ArrayList<h> arrayList = this.a;
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f080b);
                Resources resources = TbadkCoreApplication.getInst().getResources();
                if (itemInfo.apk_detail.need_inner_buy.intValue() != 1) {
                    i = R.string.obfuscated_res_0x7f0f0515;
                }
                arrayList.add(new h(string, resources.getString(i), null));
            }
            if (!m.isEmpty(itemInfo.apk_detail.authority_url)) {
                this.a.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dd7), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0965), itemInfo.apk_detail.authority_url));
            }
            if (m.isEmpty(itemInfo.apk_detail.privacy_url)) {
                return;
            }
            this.a.add(new h(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eb6), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0965), itemInfo.apk_detail.privacy_url));
        }
    }
}
