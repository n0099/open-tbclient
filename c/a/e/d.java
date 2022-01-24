package c.a.e;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.y1.o.h.b;
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
public class d extends BaseCardInfo implements c.a.t0.y1.o.l.i, c.a.t0.y1.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f3569e;

    /* renamed from: f  reason: collision with root package name */
    public ICardInfo f3570f;

    /* renamed from: g  reason: collision with root package name */
    public h f3571g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f3572h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3573i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3574j;
    public AdvertAppInfo k;

    public d() {
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
        this.f3574j = false;
        this.f3572h = BdUniqueId.gen();
    }

    public static d g(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hVar)) == null) {
            d dVar = new d();
            dVar.f3571g = hVar;
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    @Override // c.a.t0.y1.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ICardInfo iCardInfo = this.f3570f;
            if (iCardInfo == null || !(iCardInfo instanceof c.a.t0.y1.o.h.b)) {
                return null;
            }
            return ((c.a.t0.y1.o.h.b) iCardInfo).getParallelCharge();
        }
        return (b.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (o() != null) {
                return b.f3565b;
            }
            return b.a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3569e : (e) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            h hVar = this.f3571g;
            if (hVar != null) {
                return hVar.e();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public ICardInfo o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3570f : (ICardInfo) invokeV.objValue;
    }

    public BdUniqueId p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3572h : (BdUniqueId) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.f3574j) {
                c.a.t0.k3.l0.e.b().d(c.a.t0.k3.l0.g.o(this, ParseError.ERROR_SMOOTH_SCROLL));
                return;
            }
            c.a.s0.s.q.e.h(this);
        }
    }

    @Override // c.a.t0.y1.o.l.i
    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (o() instanceof c.a.t0.y1.o.l.i)) {
            ((c.a.t0.y1.o.l.i) o()).setAutoPlay(z);
        }
    }

    @Override // c.a.t0.y1.o.l.i
    public void setWaitConfirm(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (o() instanceof c.a.t0.y1.o.l.i)) {
            ((c.a.t0.y1.o.l.i) o()).setWaitConfirm(z);
        }
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.f3569e = eVar;
            ICardInfo iCardInfo = eVar != null ? eVar.f3576c : null;
            this.f3570f = iCardInfo;
            if (iCardInfo instanceof i) {
                ((i) iCardInfo).setAdFacadeData(this);
            }
            this.f3574j = true;
        }
    }

    public AdvertAppInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.k == null) {
                this.k = new AdvertAppInfo();
                h hVar = this.f3571g;
                if (hVar != null) {
                    Map<String, String> d2 = hVar.d();
                    this.k.m4 = String.valueOf(this.f3571g.b());
                    this.k.E = d2 != null ? d2.get("thread_id") : "";
                    this.k.J3(d2 != null ? Long.valueOf(d2.get("forum_id")).longValue() : 0L);
                }
                AdvertAppInfo advertAppInfo = this.k;
                e eVar = this.f3569e;
                advertAppInfo.n4 = eVar != null ? eVar.f3575b : "";
                this.k.q4 = "VIDEO_LIST";
            }
            return this.k;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }
}
