package c.a.p0.v1.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.b0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes2.dex */
public class l implements c.a.o0.k0.b.g, c.a.o0.k0.b.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f19144b;

    /* renamed from: c  reason: collision with root package name */
    public String f19145c;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19144b = 1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19144b = 1;
            this.a = 1;
            this.f19145c = null;
        }
    }

    public void c(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, feedData) == null) || feedData == null) {
            return;
        }
        this.f19145c = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f19144b++;
            this.a = 4;
        }
    }

    @Override // c.a.o0.k0.b.i
    public Object f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.pn = Integer.valueOf(this.f19144b);
                builder.ids = this.f19145c;
                builder.q_type = Integer.valueOf(c.a.o0.r.l.c().e());
                builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                builder.scr_h = Integer.valueOf(c.a.d.f.p.n.i(TbadkCoreApplication.getInst().getApp()));
                builder.scr_w = Integer.valueOf(c.a.d.f.p.n.k(TbadkCoreApplication.getInst().getApp()));
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    b0.a(builder, true);
                }
                ReplyMeReqIdl.Builder builder2 = new ReplyMeReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "replyme_cache" : (String) invokeV.objValue;
    }

    @Override // c.a.o0.k0.b.d
    public boolean isNeedUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.k0.b.f
    public HashMap<String, Object> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            hashMap.put(Config.PACKAGE_NAME, String.valueOf(this.f19144b));
            hashMap.put("q_type", Integer.valueOf(c.a.o0.r.l.c().e()));
            hashMap.put("scr_dip", Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
            hashMap.put("scr_h", Integer.valueOf(c.a.d.f.p.n.i(TbadkCoreApplication.getInst().getApp())));
            hashMap.put("scr_w", Integer.valueOf(c.a.d.f.p.n.k(TbadkCoreApplication.getInst().getApp())));
            if (this.a == 4 && !TextUtils.isEmpty(this.f19145c)) {
                hashMap.put("ids", this.f19145c);
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // c.a.o0.k0.b.f
    public HashMap<String, String> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "tb_user_replyme" : (String) invokeV.objValue;
    }
}
