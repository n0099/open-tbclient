package b.a.r0.b1.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f16469a;

    /* renamed from: b  reason: collision with root package name */
    public int f16470b;

    /* renamed from: c  reason: collision with root package name */
    public int f16471c;

    /* renamed from: d  reason: collision with root package name */
    public long f16472d;

    /* renamed from: e  reason: collision with root package name */
    public String f16473e;

    /* renamed from: f  reason: collision with root package name */
    public int f16474f;

    /* renamed from: g  reason: collision with root package name */
    public String f16475g;

    /* renamed from: h  reason: collision with root package name */
    public String f16476h;

    /* renamed from: i  reason: collision with root package name */
    public long f16477i;
    public int j;
    public int k;
    public long l;
    public int m;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public PaymentConfirmRequestData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PaymentConfirmRequestData paymentConfirmRequestData = new PaymentConfirmRequestData();
            paymentConfirmRequestData.setTdou_num(this.f16477i);
            paymentConfirmRequestData.setOpen_id(this.l);
            paymentConfirmRequestData.setOrder_id(this.f16475g);
            paymentConfirmRequestData.setScene_id(this.f16470b);
            paymentConfirmRequestData.setGoods_name(this.f16469a);
            paymentConfirmRequestData.setGoods_pic(this.f16473e);
            paymentConfirmRequestData.setTerminal("" + this.f16474f);
            paymentConfirmRequestData.setGoods_num((long) this.j);
            paymentConfirmRequestData.setGoods_unit(this.f16476h);
            paymentConfirmRequestData.setGoods_duration(this.f16472d);
            paymentConfirmRequestData.setGoods_user_level(this.f16471c);
            paymentConfirmRequestData.setPay_type(this.k);
            paymentConfirmRequestData.setCurrency(this.m);
            return paymentConfirmRequestData;
        }
        return (PaymentConfirmRequestData) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16475g : (String) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f16469a = dataRes.goods_name;
        this.f16470b = dataRes.scene_id.intValue();
        this.f16471c = dataRes.goods_user_level.intValue();
        this.f16472d = dataRes.goods_duration.intValue();
        this.f16473e = dataRes.goods_pic;
        this.f16474f = dataRes.terminal.intValue();
        this.f16475g = dataRes.order_id;
        this.f16476h = dataRes.goods_unit;
        this.f16477i = dataRes.tdou_num.intValue();
        dataRes.goods_price.intValue();
        this.j = dataRes.goods_num.intValue();
        this.k = dataRes.pay_type.intValue();
        dataRes.user_id.longValue();
        dataRes.tb_timestamp.intValue();
        this.l = dataRes.open_id.longValue();
        dataRes.gift_count.intValue();
        this.m = dataRes.currency.intValue();
    }
}
