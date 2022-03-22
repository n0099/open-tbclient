package c.a.e;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.b2.o.h.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.ParseError;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements c.a.p0.b2.o.l.i, c.a.p0.b2.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public ICardInfo f2668b;

    /* renamed from: c  reason: collision with root package name */
    public h f2669c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f2670d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2671e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2672f;

    /* renamed from: g  reason: collision with root package name */
    public AdvertAppInfo f2673g;

    public d() {
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
        this.f2672f = false;
        this.f2670d = BdUniqueId.gen();
    }

    public static d e(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hVar)) == null) {
            d dVar = new d();
            dVar.f2669c = hVar;
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public e g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (e) invokeV.objValue;
    }

    @Override // c.a.p0.b2.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ICardInfo iCardInfo = this.f2668b;
            if (iCardInfo == null || !(iCardInfo instanceof c.a.p0.b2.o.h.b)) {
                return null;
            }
            return ((c.a.p0.b2.o.h.b) iCardInfo).getParallelCharge();
        }
        return (b.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (k() != null) {
                return b.f2664b;
            }
            return b.a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            h hVar = this.f2669c;
            if (hVar != null) {
                return hVar.e();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public ICardInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2668b : (ICardInfo) invokeV.objValue;
    }

    public BdUniqueId m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2670d : (BdUniqueId) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.f2672f) {
                c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.o(this, ParseError.ERROR_SMOOTH_SCROLL));
                return;
            }
            c.a.o0.r.r.e.h(this);
        }
    }

    public void r(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.a = eVar;
            ICardInfo iCardInfo = eVar != null ? eVar.f2675c : null;
            this.f2668b = iCardInfo;
            if (iCardInfo instanceof i) {
                ((i) iCardInfo).setAdFacadeData(this);
            }
            this.f2672f = true;
        }
    }

    public AdvertAppInfo s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f2673g == null) {
                this.f2673g = new AdvertAppInfo();
                h hVar = this.f2669c;
                if (hVar != null) {
                    Map<String, String> d2 = hVar.d();
                    this.f2673g.f29820g = String.valueOf(this.f2669c.b());
                    this.f2673g.tid = d2 != null ? d2.get("thread_id") : "";
                    this.f2673g.setFid(d2 != null ? Long.valueOf(d2.get("forum_id")).longValue() : 0L);
                }
                AdvertAppInfo advertAppInfo = this.f2673g;
                e eVar = this.a;
                advertAppInfo.f29821h = eVar != null ? eVar.f2674b : "";
                this.f2673g.k = "VIDEO_LIST";
            }
            return this.f2673g;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    @Override // c.a.p0.b2.o.l.i
    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (k() instanceof c.a.p0.b2.o.l.i)) {
            ((c.a.p0.b2.o.l.i) k()).setAutoPlay(z);
        }
    }

    @Override // c.a.p0.b2.o.l.i
    public void setWaitConfirm(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (k() instanceof c.a.p0.b2.o.l.i)) {
            ((c.a.p0.b2.o.l.i) k()).setWaitConfirm(z);
        }
    }
}
