package c.a.p0.j1.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PlaceOrder.DataRes;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f15631b;

    /* renamed from: c  reason: collision with root package name */
    public int f15632c;

    /* renamed from: d  reason: collision with root package name */
    public long f15633d;

    /* renamed from: e  reason: collision with root package name */
    public String f15634e;

    /* renamed from: f  reason: collision with root package name */
    public int f15635f;

    /* renamed from: g  reason: collision with root package name */
    public String f15636g;

    /* renamed from: h  reason: collision with root package name */
    public String f15637h;
    public long i;
    public int j;
    public int k;
    public long l;
    public int m;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            paymentConfirmRequestData.setTdou_num(this.i);
            paymentConfirmRequestData.setOpen_id(this.l);
            paymentConfirmRequestData.setOrder_id(this.f15636g);
            paymentConfirmRequestData.setScene_id(this.f15631b);
            paymentConfirmRequestData.setGoods_name(this.a);
            paymentConfirmRequestData.setGoods_pic(this.f15634e);
            paymentConfirmRequestData.setTerminal("" + this.f15635f);
            paymentConfirmRequestData.setGoods_num((long) this.j);
            paymentConfirmRequestData.setGoods_unit(this.f15637h);
            paymentConfirmRequestData.setGoods_duration(this.f15633d);
            paymentConfirmRequestData.setGoods_user_level(this.f15632c);
            paymentConfirmRequestData.setPay_type(this.k);
            paymentConfirmRequestData.setCurrency(this.m);
            return paymentConfirmRequestData;
        }
        return (PaymentConfirmRequestData) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15636g : (String) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.a = dataRes.goods_name;
        this.f15631b = dataRes.scene_id.intValue();
        this.f15632c = dataRes.goods_user_level.intValue();
        this.f15633d = dataRes.goods_duration.intValue();
        this.f15634e = dataRes.goods_pic;
        this.f15635f = dataRes.terminal.intValue();
        this.f15636g = dataRes.order_id;
        this.f15637h = dataRes.goods_unit;
        this.i = dataRes.tdou_num.intValue();
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
