package c.a.r0.b1.d;

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
    public String f15961a;

    /* renamed from: b  reason: collision with root package name */
    public int f15962b;

    /* renamed from: c  reason: collision with root package name */
    public int f15963c;

    /* renamed from: d  reason: collision with root package name */
    public long f15964d;

    /* renamed from: e  reason: collision with root package name */
    public String f15965e;

    /* renamed from: f  reason: collision with root package name */
    public int f15966f;

    /* renamed from: g  reason: collision with root package name */
    public String f15967g;

    /* renamed from: h  reason: collision with root package name */
    public String f15968h;

    /* renamed from: i  reason: collision with root package name */
    public long f15969i;

    /* renamed from: j  reason: collision with root package name */
    public int f15970j;
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
            paymentConfirmRequestData.setTdou_num(this.f15969i);
            paymentConfirmRequestData.setOpen_id(this.l);
            paymentConfirmRequestData.setOrder_id(this.f15967g);
            paymentConfirmRequestData.setScene_id(this.f15962b);
            paymentConfirmRequestData.setGoods_name(this.f15961a);
            paymentConfirmRequestData.setGoods_pic(this.f15965e);
            paymentConfirmRequestData.setTerminal("" + this.f15966f);
            paymentConfirmRequestData.setGoods_num((long) this.f15970j);
            paymentConfirmRequestData.setGoods_unit(this.f15968h);
            paymentConfirmRequestData.setGoods_duration(this.f15964d);
            paymentConfirmRequestData.setGoods_user_level(this.f15963c);
            paymentConfirmRequestData.setPay_type(this.k);
            paymentConfirmRequestData.setCurrency(this.m);
            return paymentConfirmRequestData;
        }
        return (PaymentConfirmRequestData) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15967g : (String) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f15961a = dataRes.goods_name;
        this.f15962b = dataRes.scene_id.intValue();
        this.f15963c = dataRes.goods_user_level.intValue();
        this.f15964d = dataRes.goods_duration.intValue();
        this.f15965e = dataRes.goods_pic;
        this.f15966f = dataRes.terminal.intValue();
        this.f15967g = dataRes.order_id;
        this.f15968h = dataRes.goods_unit;
        this.f15969i = dataRes.tdou_num.intValue();
        dataRes.goods_price.intValue();
        this.f15970j = dataRes.goods_num.intValue();
        this.k = dataRes.pay_type.intValue();
        dataRes.user_id.longValue();
        dataRes.tb_timestamp.intValue();
        this.l = dataRes.open_id.longValue();
        dataRes.gift_count.intValue();
        this.m = dataRes.currency.intValue();
    }
}
