package c.a.r0.d1.d3.g;

import c.a.d.f.p.l;
import c.a.q0.l0.b.g;
import c.a.q0.s.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.CommonReq;
import tbclient.VoiceRoomListPage.DataReq;
import tbclient.VoiceRoomListPage.VoiceRoomListPageReqIdl;
/* loaded from: classes5.dex */
public class b implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final long f15463e;

    /* renamed from: f  reason: collision with root package name */
    public final long f15464f;

    public b(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15463e = j2;
        this.f15464f = j3;
    }

    public final double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density : invokeV.doubleValue;
    }

    @Override // c.a.q0.l0.b.i
    public Object e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.call_from = Long.valueOf(this.f15463e);
                builder.fid = Long.valueOf(this.f15464f);
                CommonReq.Builder builder2 = new CommonReq.Builder();
                builder2.q_type = Integer.valueOf(k.c().e());
                builder2.scr_dip = Double.valueOf(a());
                builder2.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp()));
                builder2.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp()));
                VoiceRoomListPageReqIdl.Builder builder3 = new VoiceRoomListPageReqIdl.Builder();
                builder3.data = builder.build(false);
                return builder3.build(false);
            } catch (Exception unused) {
                BdLog.d("data convert error");
                return null;
            }
        }
        return invokeZ.objValue;
    }

    @Override // c.a.q0.l0.b.f
    public HashMap<String, Object> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(IntentConfig.CALL_FROM, Long.valueOf(this.f15463e));
            hashMap.put("fid", Long.valueOf(this.f15464f));
            hashMap.put("q_type", Integer.valueOf(k.c().e()));
            hashMap.put("scr_dip", Double.valueOf(a()));
            hashMap.put("scr_h", Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
            hashMap.put("scr_w", Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // c.a.q0.l0.b.f
    public HashMap<String, String> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }
}
