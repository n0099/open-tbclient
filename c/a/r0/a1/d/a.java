package c.a.r0.a1.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15795a;

    /* renamed from: b  reason: collision with root package name */
    public int f15796b;

    /* renamed from: c  reason: collision with root package name */
    public int f15797c;

    /* renamed from: d  reason: collision with root package name */
    public long f15798d;

    /* renamed from: e  reason: collision with root package name */
    public String f15799e;

    /* renamed from: f  reason: collision with root package name */
    public int f15800f;

    /* renamed from: g  reason: collision with root package name */
    public String f15801g;

    /* renamed from: h  reason: collision with root package name */
    public String f15802h;

    /* renamed from: i  reason: collision with root package name */
    public long f15803i;

    /* renamed from: j  reason: collision with root package name */
    public int f15804j;
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
            paymentConfirmRequestData.setTdou_num(this.f15803i);
            paymentConfirmRequestData.setOpen_id(this.l);
            paymentConfirmRequestData.setOrder_id(this.f15801g);
            paymentConfirmRequestData.setScene_id(this.f15796b);
            paymentConfirmRequestData.setGoods_name(this.f15795a);
            paymentConfirmRequestData.setGoods_pic(this.f15799e);
            paymentConfirmRequestData.setTerminal("" + this.f15800f);
            paymentConfirmRequestData.setGoods_num((long) this.f15804j);
            paymentConfirmRequestData.setGoods_unit(this.f15802h);
            paymentConfirmRequestData.setGoods_duration(this.f15798d);
            paymentConfirmRequestData.setGoods_user_level(this.f15797c);
            paymentConfirmRequestData.setPay_type(this.k);
            paymentConfirmRequestData.setCurrency(this.m);
            return paymentConfirmRequestData;
        }
        return (PaymentConfirmRequestData) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15801g : (String) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f15795a = dataRes.goods_name;
        this.f15796b = dataRes.scene_id.intValue();
        this.f15797c = dataRes.goods_user_level.intValue();
        this.f15798d = dataRes.goods_duration.intValue();
        this.f15799e = dataRes.goods_pic;
        this.f15800f = dataRes.terminal.intValue();
        this.f15801g = dataRes.order_id;
        this.f15802h = dataRes.goods_unit;
        this.f15803i = dataRes.tdou_num.intValue();
        dataRes.goods_price.intValue();
        this.f15804j = dataRes.goods_num.intValue();
        this.k = dataRes.pay_type.intValue();
        dataRes.user_id.longValue();
        dataRes.tb_timestamp.intValue();
        this.l = dataRes.open_id.longValue();
        dataRes.gift_count.intValue();
        this.m = dataRes.currency.intValue();
    }
}
