package c.a.q0.z0.d;

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
    public String f29306a;

    /* renamed from: b  reason: collision with root package name */
    public int f29307b;

    /* renamed from: c  reason: collision with root package name */
    public int f29308c;

    /* renamed from: d  reason: collision with root package name */
    public long f29309d;

    /* renamed from: e  reason: collision with root package name */
    public String f29310e;

    /* renamed from: f  reason: collision with root package name */
    public int f29311f;

    /* renamed from: g  reason: collision with root package name */
    public String f29312g;

    /* renamed from: h  reason: collision with root package name */
    public String f29313h;

    /* renamed from: i  reason: collision with root package name */
    public long f29314i;

    /* renamed from: j  reason: collision with root package name */
    public int f29315j;
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
            paymentConfirmRequestData.setTdou_num(this.f29314i);
            paymentConfirmRequestData.setOpen_id(this.l);
            paymentConfirmRequestData.setOrder_id(this.f29312g);
            paymentConfirmRequestData.setScene_id(this.f29307b);
            paymentConfirmRequestData.setGoods_name(this.f29306a);
            paymentConfirmRequestData.setGoods_pic(this.f29310e);
            paymentConfirmRequestData.setTerminal("" + this.f29311f);
            paymentConfirmRequestData.setGoods_num((long) this.f29315j);
            paymentConfirmRequestData.setGoods_unit(this.f29313h);
            paymentConfirmRequestData.setGoods_duration(this.f29309d);
            paymentConfirmRequestData.setGoods_user_level(this.f29308c);
            paymentConfirmRequestData.setPay_type(this.k);
            paymentConfirmRequestData.setCurrency(this.m);
            return paymentConfirmRequestData;
        }
        return (PaymentConfirmRequestData) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29312g : (String) invokeV.objValue;
    }

    public void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) || dataRes == null) {
            return;
        }
        dataRes.timestamp.intValue();
        this.f29306a = dataRes.goods_name;
        this.f29307b = dataRes.scene_id.intValue();
        this.f29308c = dataRes.goods_user_level.intValue();
        this.f29309d = dataRes.goods_duration.intValue();
        this.f29310e = dataRes.goods_pic;
        this.f29311f = dataRes.terminal.intValue();
        this.f29312g = dataRes.order_id;
        this.f29313h = dataRes.goods_unit;
        this.f29314i = dataRes.tdou_num.intValue();
        dataRes.goods_price.intValue();
        this.f29315j = dataRes.goods_num.intValue();
        this.k = dataRes.pay_type.intValue();
        dataRes.user_id.longValue();
        dataRes.tb_timestamp.intValue();
        this.l = dataRes.open_id.longValue();
        dataRes.gift_count.intValue();
        this.m = dataRes.currency.intValue();
    }
}
