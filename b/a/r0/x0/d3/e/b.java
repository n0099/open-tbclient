package b.a.r0.x0.d3.e;

import b.a.e.f.p.l;
import b.a.q0.k0.b.g;
import b.a.q0.s.k;
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
import tbclient.VoiceRoom.DataReq;
import tbclient.VoiceRoom.VoiceRoomReqIdl;
/* loaded from: classes5.dex */
public class b implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final long f27271e;

    /* renamed from: f  reason: collision with root package name */
    public final long f27272f;

    public b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27271e = j;
        this.f27272f = j2;
    }

    public final double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density : invokeV.doubleValue;
    }

    @Override // b.a.q0.k0.b.i
    public Object e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.call_from = Long.valueOf(this.f27271e);
                builder.fid = Long.valueOf(this.f27272f);
                CommonReq.Builder builder2 = new CommonReq.Builder();
                builder2.q_type = Integer.valueOf(k.c().e());
                builder2.scr_dip = Double.valueOf(a());
                builder2.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp()));
                builder2.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp()));
                VoiceRoomReqIdl.Builder builder3 = new VoiceRoomReqIdl.Builder();
                builder3.data = builder.build(false);
                return builder3.build(false);
            } catch (Exception unused) {
                BdLog.d("data convert error");
                return null;
            }
        }
        return invokeZ.objValue;
    }

    @Override // b.a.q0.k0.b.f
    public HashMap<String, Object> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(IntentConfig.CALL_FROM, Long.valueOf(this.f27271e));
            hashMap.put("fid", Long.valueOf(this.f27272f));
            hashMap.put("q_type", Integer.valueOf(k.c().e()));
            hashMap.put("scr_dip", Double.valueOf(a()));
            hashMap.put("scr_h", Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
            hashMap.put("scr_w", Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // b.a.q0.k0.b.f
    public HashMap<String, String> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }
}
