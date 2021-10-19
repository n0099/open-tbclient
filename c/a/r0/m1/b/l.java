package c.a.r0.m1.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes3.dex */
public class l implements c.a.q0.k0.b.g, c.a.q0.k0.b.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f22159e;

    /* renamed from: f  reason: collision with root package name */
    public int f22160f;

    /* renamed from: g  reason: collision with root package name */
    public String f22161g;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22160f = 1;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22159e : invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22160f = 1;
            this.f22159e = 1;
            this.f22161g = null;
        }
    }

    @Override // c.a.q0.k0.b.i
    public Object c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.pn = Integer.valueOf(this.f22160f);
                builder.ids = this.f22161g;
                builder.q_type = Integer.valueOf(c.a.q0.s.k.c().e());
                builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                builder.scr_h = Integer.valueOf(c.a.e.e.p.l.i(TbadkCoreApplication.getInst().getApp()));
                builder.scr_w = Integer.valueOf(c.a.e.e.p.l.k(TbadkCoreApplication.getInst().getApp()));
                if (z) {
                    z.a(builder, true);
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

    public void d(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, feedData) == null) || feedData == null) {
            return;
        }
        this.f22161g = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f22160f++;
            this.f22159e = 4;
        }
    }

    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "replyme_cache" : (String) invokeV.objValue;
    }

    @Override // c.a.q0.k0.b.d
    public boolean isNeedUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.k0.b.f
    public HashMap<String, Object> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            hashMap.put("pn", String.valueOf(this.f22160f));
            hashMap.put("q_type", Integer.valueOf(c.a.q0.s.k.c().e()));
            hashMap.put("scr_dip", Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
            hashMap.put("scr_h", Integer.valueOf(c.a.e.e.p.l.i(TbadkCoreApplication.getInst().getApp())));
            hashMap.put("scr_w", Integer.valueOf(c.a.e.e.p.l.k(TbadkCoreApplication.getInst().getApp())));
            if (this.f22159e == 4 && !TextUtils.isEmpty(this.f22161g)) {
                hashMap.put("ids", this.f22161g);
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // c.a.q0.k0.b.f
    public HashMap<String, String> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "tb_user_replyme" : (String) invokeV.objValue;
    }
}
