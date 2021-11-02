package b.a.f;

import androidx.core.view.InputDeviceCompat;
import b.a.r0.q1.o.h.b;
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
public class d extends BaseCardInfo implements b.a.r0.q1.o.l.i, b.a.r0.q1.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f2723e;

    /* renamed from: f  reason: collision with root package name */
    public ICardInfo f2724f;

    /* renamed from: g  reason: collision with root package name */
    public h f2725g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f2726h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2727i;
    public boolean j;
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
        this.j = false;
        this.f2726h = BdUniqueId.gen();
    }

    public static d g(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hVar)) == null) {
            d dVar = new d();
            dVar.f2725g = hVar;
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    @Override // b.a.r0.q1.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ICardInfo iCardInfo = this.f2724f;
            if (iCardInfo == null || !(iCardInfo instanceof b.a.r0.q1.o.h.b)) {
                return null;
            }
            return ((b.a.r0.q1.o.h.b) iCardInfo).getParallelCharge();
        }
        return (b.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (o() != null) {
                return b.f2718b;
            }
            return b.f2717a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2723e : (e) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            h hVar = this.f2725g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2724f : (ICardInfo) invokeV.objValue;
    }

    public BdUniqueId p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2726h : (BdUniqueId) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.j) {
                b.a.r0.z2.l0.e.b().d(b.a.r0.z2.l0.g.o(this, ParseError.ERROR_SMOOTH_SCROLL));
                return;
            }
            b.a.q0.s.q.e.h(this);
        }
    }

    @Override // b.a.r0.q1.o.l.i
    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (o() instanceof b.a.r0.q1.o.l.i)) {
            ((b.a.r0.q1.o.l.i) o()).setAutoPlay(z);
        }
    }

    @Override // b.a.r0.q1.o.l.i
    public void setWaitConfirm(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (o() instanceof b.a.r0.q1.o.l.i)) {
            ((b.a.r0.q1.o.l.i) o()).setWaitConfirm(z);
        }
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.f2723e = eVar;
            ICardInfo iCardInfo = eVar != null ? eVar.f2730c : null;
            this.f2724f = iCardInfo;
            if (iCardInfo instanceof i) {
                ((i) iCardInfo).setAdFacadeData(this);
            }
            this.j = true;
        }
    }

    public AdvertAppInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.k == null) {
                this.k = new AdvertAppInfo();
                h hVar = this.f2725g;
                if (hVar != null) {
                    Map<String, String> d2 = hVar.d();
                    this.k.d4 = String.valueOf(this.f2725g.b());
                    this.k.E = d2 != null ? d2.get("thread_id") : "";
                    this.k.E3(d2 != null ? Long.valueOf(d2.get("forum_id")).longValue() : 0L);
                }
                AdvertAppInfo advertAppInfo = this.k;
                e eVar = this.f2723e;
                advertAppInfo.e4 = eVar != null ? eVar.f2729b : "";
                this.k.h4 = "VIDEO_LIST";
            }
            return this.k;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }
}
